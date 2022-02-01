package com.tencent.mobileqq.wink.utils;

import android.util.LruCache;
import java.io.File;
import org.libpag.PAGFont;

public class TAVFontManager
{
  private static final String a = "TAVFontManager";
  private static volatile TAVFontManager b;
  private LruCache<String, PAGFont> c = null;
  
  public static TAVFontManager a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new TAVFontManager();
        }
      }
      finally {}
    }
    return b;
  }
  
  private void b()
  {
    if (this.c == null) {
      this.c = new LruCache(10);
    }
  }
  
  private boolean b(String paramString)
  {
    b();
    if ((PAGFont)this.c.get(paramString) != null) {
      return true;
    }
    if (!new File(paramString).exists()) {
      return false;
    }
    PAGFont localPAGFont = PAGFont.RegisterFont(paramString);
    if (localPAGFont != null)
    {
      this.c.put(paramString, localPAGFont);
      return true;
    }
    return false;
  }
  
  public PAGFont a(String paramString)
  {
    if (b(paramString)) {
      return (PAGFont)this.c.get(paramString);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.utils.TAVFontManager
 * JD-Core Version:    0.7.0.1
 */