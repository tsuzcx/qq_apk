package com.tencent.tavsticker.core;

import android.content.Context;
import android.text.TextUtils;
import android.util.LruCache;
import java.io.File;
import org.libpag.PAGFont;

public class TAVFontManager
{
  public static final int CACHE_SIZE = 10;
  private static final String TAG = TAVFontManager.class.getSimpleName();
  private static volatile TAVFontManager sInstance = null;
  private LruCache<String, PAGFont> mapPagFont = null;
  
  private void checkPAGFontMap()
  {
    if (this.mapPagFont == null) {
      this.mapPagFont = new LruCache(10);
    }
  }
  
  public static TAVFontManager getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new TAVFontManager();
      }
      return sInstance;
    }
    finally {}
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
    PAGFont localPAGFont = (PAGFont)this.mapPagFont.get("android_asset://" + paramString);
    Object localObject;
    if (localPAGFont != null) {
      localObject = localPAGFont;
    }
    do
    {
      do
      {
        do
        {
          return localObject;
          localObject = localPAGFont;
        } while (paramContext == null);
        localObject = localPAGFont;
      } while (TextUtils.isEmpty(paramString));
      paramContext = PAGFont.RegisterFont(paramContext.getAssets(), paramString);
      localObject = paramContext;
    } while (paramContext == null);
    this.mapPagFont.put("android_asset://" + paramString, paramContext);
    return paramContext;
  }
  
  public PAGFont fontWithPath(String paramString)
  {
    if (registerFontWithPath(paramString)) {
      return (PAGFont)this.mapPagFont.get(paramString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavsticker.core.TAVFontManager
 * JD-Core Version:    0.7.0.1
 */