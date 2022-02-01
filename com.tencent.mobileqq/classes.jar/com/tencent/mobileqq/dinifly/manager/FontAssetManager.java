package com.tencent.mobileqq.dinifly.manager;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable.Callback;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import com.tencent.mobileqq.dinifly.FontAssetDelegate;
import com.tencent.mobileqq.dinifly.model.MutablePair;
import java.util.HashMap;
import java.util.Map;

public class FontAssetManager
{
  private final AssetManager assetManager;
  private String defaultFontFileExtension = ".ttf";
  @Nullable
  private FontAssetDelegate delegate;
  private final Map<String, Typeface> fontFamilies = new HashMap();
  private final Map<MutablePair<String>, Typeface> fontMap = new HashMap();
  private final MutablePair<String> tempPair = new MutablePair();
  
  public FontAssetManager(Drawable.Callback paramCallback, @Nullable FontAssetDelegate paramFontAssetDelegate)
  {
    this.delegate = paramFontAssetDelegate;
    if (!(paramCallback instanceof View))
    {
      Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
      this.assetManager = null;
      return;
    }
    this.assetManager = ((View)paramCallback).getContext().getAssets();
  }
  
  private Typeface getFontFamily(String paramString)
  {
    Object localObject1 = (Typeface)this.fontFamilies.get(paramString);
    if (localObject1 != null) {
      return localObject1;
    }
    Object localObject3 = null;
    localObject1 = this.delegate;
    if (localObject1 != null) {
      localObject3 = ((FontAssetDelegate)localObject1).fetchFont(paramString);
    }
    Object localObject4 = this.delegate;
    localObject1 = localObject3;
    Object localObject2;
    if (localObject4 != null)
    {
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        localObject4 = ((FontAssetDelegate)localObject4).getFontPath(paramString);
        localObject1 = localObject3;
        if (localObject4 != null) {
          try
          {
            localObject1 = Typeface.createFromAsset(this.assetManager, (String)localObject4);
          }
          catch (RuntimeException localRuntimeException1)
          {
            localRuntimeException1.printStackTrace();
            localObject2 = Typeface.DEFAULT;
          }
        }
      }
    }
    localObject3 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("fonts/");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(this.defaultFontFileExtension);
      localObject2 = ((StringBuilder)localObject2).toString();
      try
      {
        localObject3 = Typeface.createFromAsset(this.assetManager, (String)localObject2);
      }
      catch (RuntimeException localRuntimeException2)
      {
        localRuntimeException2.printStackTrace();
        localObject3 = Typeface.DEFAULT;
      }
    }
    this.fontFamilies.put(paramString, localObject3);
    return localObject3;
  }
  
  private Typeface typefaceForStyle(Typeface paramTypeface, String paramString)
  {
    boolean bool1 = paramString.contains("Italic");
    boolean bool2 = paramString.contains("Bold");
    int i;
    if ((bool1) && (bool2)) {
      i = 3;
    } else if (bool1) {
      i = 2;
    } else if (bool2) {
      i = 1;
    } else {
      i = 0;
    }
    if (paramTypeface.getStyle() == i) {
      return paramTypeface;
    }
    return Typeface.create(paramTypeface, i);
  }
  
  public Typeface getTypeface(String paramString1, String paramString2)
  {
    this.tempPair.set(paramString1, paramString2);
    Typeface localTypeface = (Typeface)this.fontMap.get(this.tempPair);
    if (localTypeface != null) {
      return localTypeface;
    }
    paramString1 = typefaceForStyle(getFontFamily(paramString1), paramString2);
    this.fontMap.put(this.tempPair, paramString1);
    return paramString1;
  }
  
  public void setDefaultFontFileExtension(String paramString)
  {
    this.defaultFontFileExtension = paramString;
  }
  
  public void setDelegate(@Nullable FontAssetDelegate paramFontAssetDelegate)
  {
    this.delegate = paramFontAssetDelegate;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.manager.FontAssetManager
 * JD-Core Version:    0.7.0.1
 */