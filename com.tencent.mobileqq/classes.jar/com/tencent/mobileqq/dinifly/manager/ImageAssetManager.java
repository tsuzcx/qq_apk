package com.tencent.mobileqq.dinifly.manager;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable.Callback;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.dinifly.ImageAssetDelegate;
import com.tencent.mobileqq.dinifly.LottieImageAsset;
import com.tencent.mobileqq.dinifly.utils.Logger;
import com.tencent.mobileqq.dinifly.utils.Utils;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ImageAssetManager
{
  private static final Object bitmapHashLock = new Object();
  private final Context context;
  @Nullable
  private ImageAssetDelegate delegate;
  private final Map<String, LottieImageAsset> imageAssets;
  private final String imagesFolder;
  
  public ImageAssetManager(Context paramContext, String paramString, ImageAssetDelegate paramImageAssetDelegate, Map<String, LottieImageAsset> paramMap)
  {
    this.context = paramContext;
    if ((!TextUtils.isEmpty(paramString)) && (paramString.charAt(paramString.length() - 1) != '/'))
    {
      paramContext = new StringBuilder();
      paramContext.append(paramString);
      paramContext.append('/');
      this.imagesFolder = paramContext.toString();
    }
    else
    {
      this.imagesFolder = paramString;
    }
    this.imageAssets = paramMap;
    setDelegate(paramImageAssetDelegate);
  }
  
  public ImageAssetManager(Drawable.Callback paramCallback, String paramString, ImageAssetDelegate paramImageAssetDelegate, Map<String, LottieImageAsset> paramMap)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.charAt(paramString.length() - 1) != '/'))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append('/');
      this.imagesFolder = localStringBuilder.toString();
    }
    else
    {
      this.imagesFolder = paramString;
    }
    if (!(paramCallback instanceof View))
    {
      Logger.warning("LottieDrawable must be inside of a view for images to work.");
      this.imageAssets = new HashMap();
      this.context = null;
      return;
    }
    this.context = ((View)paramCallback).getContext();
    this.imageAssets = paramMap;
    setDelegate(paramImageAssetDelegate);
  }
  
  private Bitmap putBitmap(String paramString, @Nullable Bitmap paramBitmap)
  {
    synchronized (bitmapHashLock)
    {
      ((LottieImageAsset)this.imageAssets.get(paramString)).setBitmap(paramBitmap);
      return paramBitmap;
    }
  }
  
  @Nullable
  public Bitmap bitmapForId(String paramString)
  {
    Object localObject1 = (LottieImageAsset)this.imageAssets.get(paramString);
    if (localObject1 == null) {
      return null;
    }
    Object localObject2 = ((LottieImageAsset)localObject1).getBitmap();
    if (localObject2 != null) {
      return localObject2;
    }
    if (this.delegate != null)
    {
      if (((LottieImageAsset)localObject1).hasCache()) {
        return this.delegate.fetchBitmap((LottieImageAsset)localObject1);
      }
      localObject1 = this.delegate.fetchBitmap((LottieImageAsset)localObject1);
      if (localObject1 != null) {
        putBitmap(paramString, (Bitmap)localObject1);
      }
      return localObject1;
    }
    Object localObject3 = ((LottieImageAsset)localObject1).getFileName();
    localObject2 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject2).inScaled = true;
    ((BitmapFactory.Options)localObject2).inDensity = 320;
    if ((((String)localObject3).startsWith("data:")) && (((String)localObject3).indexOf("base64,") > 0)) {
      try
      {
        localObject1 = Base64.decode(((String)localObject3).substring(((String)localObject3).indexOf(',') + 1), 0);
        return putBitmap(paramString, BitmapFactory.decodeByteArray((byte[])localObject1, 0, localObject1.length, (BitmapFactory.Options)localObject2));
      }
      catch (IllegalArgumentException paramString)
      {
        Logger.warning("data URL did not have correct base64 format.", paramString);
        return null;
      }
    }
    try
    {
      if (!TextUtils.isEmpty(this.imagesFolder))
      {
        AssetManager localAssetManager = this.context.getAssets();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.imagesFolder);
        localStringBuilder.append((String)localObject3);
        localObject3 = localAssetManager.open(localStringBuilder.toString());
        try
        {
          localObject2 = BitmapFactory.decodeStream((InputStream)localObject3, null, (BitmapFactory.Options)localObject2);
          localObject1 = Utils.resizeBitmapIfNeeded((Bitmap)localObject2, ((LottieImageAsset)localObject1).getWidth(), ((LottieImageAsset)localObject1).getHeight());
          if (localObject3 != null) {
            try
            {
              ((InputStream)localObject3).close();
            }
            catch (IOException localIOException)
            {
              localIOException.printStackTrace();
            }
          }
          return putBitmap(paramString, (Bitmap)localObject1);
        }
        catch (IllegalArgumentException paramString)
        {
          Logger.warning("Unable to decode image.", paramString);
          return null;
        }
      }
      throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
    }
    catch (IOException paramString)
    {
      Logger.warning("Unable to open asset.", paramString);
    }
    return null;
  }
  
  public boolean hasSameContext(Context paramContext)
  {
    return ((paramContext == null) && (this.context == null)) || (this.context.equals(paramContext));
  }
  
  public void recycleBitmaps()
  {
    Iterator localIterator = this.imageAssets.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((LottieImageAsset)localEntry.getValue()).getBitmap() != null) {
        ((LottieImageAsset)localEntry.getValue()).getBitmap().recycle();
      }
      localIterator.remove();
    }
  }
  
  public void setDelegate(@Nullable ImageAssetDelegate paramImageAssetDelegate)
  {
    this.delegate = paramImageAssetDelegate;
  }
  
  @Nullable
  public Bitmap updateBitmap(String paramString, @Nullable Bitmap paramBitmap)
  {
    if (paramBitmap == null)
    {
      paramString = (LottieImageAsset)this.imageAssets.get(paramString);
      paramBitmap = paramString.getBitmap();
      paramString.setBitmap(null);
      return paramBitmap;
    }
    Bitmap localBitmap = ((LottieImageAsset)this.imageAssets.get(paramString)).getBitmap();
    putBitmap(paramString, paramBitmap);
    return localBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.manager.ImageAssetManager
 * JD-Core Version:    0.7.0.1
 */