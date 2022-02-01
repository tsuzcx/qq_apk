package com.tencent.mobileqq.wink.utils;

import android.text.TextUtils;
import android.util.LruCache;
import java.io.File;
import org.libpag.PAGFile;

public class TAVPAGFileManager
{
  private static final String a = "TAVPAGFileManager";
  private static volatile TAVPAGFileManager b;
  private LruCache<String, PAGFile> c = null;
  
  public static TAVPAGFileManager a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new TAVPAGFileManager();
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
  
  public PAGFile a(String paramString)
  {
    b();
    Object localObject;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = (PAGFile)this.c.get(paramString);
      if (localObject != null) {
        return ((PAGFile)localObject).copyOriginal();
      }
      if (new File(paramString).exists())
      {
        PAGFile localPAGFile = PAGFile.Load(paramString);
        localObject = localPAGFile;
        if (localPAGFile != null)
        {
          this.c.put(paramString, localPAGFile);
          return localPAGFile;
        }
      }
    }
    else
    {
      localObject = null;
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.utils.TAVPAGFileManager
 * JD-Core Version:    0.7.0.1
 */