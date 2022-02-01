package com.tencent.tavsticker.core;

import android.content.Context;
import android.text.TextUtils;
import android.util.LruCache;
import java.io.File;
import org.libpag.PAGFont;

public class TAVFontManager
{
  private static final int CACHE_SIZE = 10;
  private static final String TAG = "TAVFontManager";
  private static volatile TAVFontManager sInstance;
  private LruCache<String, PAGFont> mapPagFont = null;
  
  private void checkPAGFontMap()
  {
    if (this.mapPagFont == null) {
      this.mapPagFont = new LruCache(10);
    }
  }
  
  public static TAVFontManager getInstance()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new TAVFontManager();
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  private boolean registerFontWithPath(String paramString)
  {
    checkPAGFontMap();
    if ((PAGFont)this.mapPagFont.get(paramString) != null) {
      return true;
    }
    if (!new File(paramString).exists()) {
      return false;
    }
    PAGFont localPAGFont = PAGFont.RegisterFont(paramString);
    if (localPAGFont != null)
    {
      this.mapPagFont.put(paramString, localPAGFont);
      return true;
    }
    return false;
  }
  
  public PAGFont fontWithAssetPath(Context paramContext, String paramString)
  {
    checkPAGFontMap();
    Object localObject1 = this.mapPagFont;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("android_asset://");
    ((StringBuilder)localObject2).append(paramString);
    localObject2 = (PAGFont)((LruCache)localObject1).get(((StringBuilder)localObject2).toString());
    if (localObject2 != null) {
      return localObject2;
    }
    localObject1 = localObject2;
    if (paramContext != null)
    {
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramString))
      {
        paramContext = PAGFont.RegisterFont(paramContext.getAssets(), paramString);
        localObject1 = paramContext;
        if (paramContext != null)
        {
          localObject1 = this.mapPagFont;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("android_asset://");
          ((StringBuilder)localObject2).append(paramString);
          ((LruCache)localObject1).put(((StringBuilder)localObject2).toString(), paramContext);
          localObject1 = paramContext;
        }
      }
    }
    return localObject1;
  }
  
  public PAGFont fontWithPath(String paramString)
  {
    if (registerFontWithPath(paramString)) {
      return (PAGFont)this.mapPagFont.get(paramString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavsticker.core.TAVFontManager
 * JD-Core Version:    0.7.0.1
 */