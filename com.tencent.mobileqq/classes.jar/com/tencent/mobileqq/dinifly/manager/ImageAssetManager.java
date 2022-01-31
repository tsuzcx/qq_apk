package com.tencent.mobileqq.dinifly.manager;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable.Callback;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.tencent.mobileqq.dinifly.ImageAssetDelegate;
import com.tencent.mobileqq.dinifly.LottieImageAsset;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ImageAssetManager
{
  private final Map<String, Bitmap> bitmaps = new HashMap();
  private final Context context;
  @Nullable
  private ImageAssetDelegate delegate;
  private final Map<String, LottieImageAsset> imageAssets;
  private String imagesFolder;
  
  public ImageAssetManager(Drawable.Callback paramCallback, String paramString, ImageAssetDelegate paramImageAssetDelegate, Map<String, LottieImageAsset> paramMap)
  {
    this.imagesFolder = paramString;
    if ((!TextUtils.isEmpty(paramString)) && (this.imagesFolder.charAt(this.imagesFolder.length() - 1) != '/')) {
      this.imagesFolder += '/';
    }
    if (!(paramCallback instanceof View))
    {
      Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
      this.imageAssets = new HashMap();
      this.context = null;
      return;
    }
    this.context = ((View)paramCallback).getContext();
    this.imageAssets = paramMap;
    setDelegate(paramImageAssetDelegate);
  }
  
  @Nullable
  public Bitmap bitmapForId(String paramString)
  {
    Object localObject2 = (Bitmap)this.bitmaps.get(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = (LottieImageAsset)this.imageAssets.get(paramString);
      if (localObject1 == null) {
        return null;
      }
      if (this.delegate != null)
      {
        if (((LottieImageAsset)localObject1).hasCache()) {
          return this.delegate.fetchBitmap((LottieImageAsset)localObject1);
        }
        localObject1 = this.delegate.fetchBitmap((LottieImageAsset)localObject1);
        if (localObject1 != null) {
          this.bitmaps.put(paramString, localObject1);
        }
        return localObject1;
      }
      try
      {
        if (TextUtils.isEmpty(this.imagesFolder)) {
          throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
        }
      }
      catch (IOException paramString)
      {
        Log.w("LOTTIE", "Unable to open asset.", paramString);
        return null;
      }
      localObject2 = this.context.getAssets().open(this.imagesFolder + ((LottieImageAsset)localObject1).getFileName());
      localObject1 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject1).inScaled = true;
      ((BitmapFactory.Options)localObject1).inDensity = 320;
      localObject1 = BitmapFactory.decodeStream((InputStream)localObject2, null, (BitmapFactory.Options)localObject1);
      if (localObject2 == null) {}
    }
    try
    {
      ((InputStream)localObject2).close();
      this.bitmaps.put(paramString, localObject1);
      return localObject1;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
  }
  
  public boolean hasSameContext(Context paramContext)
  {
    return ((paramContext == null) && (this.context == null)) || ((paramContext != null) && (this.context.equals(paramContext)));
  }
  
  public void recycleBitmaps()
  {
    Iterator localIterator = this.bitmaps.entrySet().iterator();
    while (localIterator.hasNext())
    {
      ((Bitmap)((Map.Entry)localIterator.next()).getValue()).recycle();
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
    return (Bitmap)this.bitmaps.put(paramString, paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.manager.ImageAssetManager
 * JD-Core Version:    0.7.0.1
 */