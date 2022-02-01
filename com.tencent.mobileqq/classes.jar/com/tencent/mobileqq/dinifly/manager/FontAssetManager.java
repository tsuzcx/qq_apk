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
    Object localObject2 = null;
    if (this.delegate != null) {
      localObject2 = this.delegate.fetchFont(paramString);
    }
    localObject1 = localObject2;
    String str;
    if (this.delegate != null)
    {
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        str = this.delegate.getFontPath(paramString);
        localObject1 = localObject2;
        if (str == null) {}
      }
    }
    try
    {
      localObject1 = Typeface.createFromAsset(this.assetManager, str);
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject1 = "fonts/" + paramString + this.defaultFontFileExtension;
      }
    }
    catch (RuntimeException localRuntimeException1)
    {
      try
      {
        localObject2 = Typeface.createFromAsset(this.assetManager, (String)localObject1);
        this.fontFamilies.put(paramString, localObject2);
        return localObject2;
        localRuntimeException1 = localRuntimeException1;
        localRuntimeException1.printStackTrace();
        Typeface localTypeface = Typeface.DEFAULT;
      }
      catch (RuntimeException localRuntimeException2)
      {
        for (;;)
        {
          localRuntimeException2.printStackTrace();
          localObject2 = Typeface.DEFAULT;
        }
      }
    }
  }
  
  private Typeface typefaceForStyle(Typeface paramTypeface, String paramString)
  {
    int i = 0;
    boolean bool1 = paramString.contains("Italic");
    boolean bool2 = paramString.contains("Bold");
    if ((bool1) && (bool2)) {
      i = 3;
    }
    while (paramTypeface.getStyle() == i)
    {
      return paramTypeface;
      if (bool1) {
        i = 2;
      } else if (bool2) {
        i = 1;
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.manager.FontAssetManager
 * JD-Core Version:    0.7.0.1
 */