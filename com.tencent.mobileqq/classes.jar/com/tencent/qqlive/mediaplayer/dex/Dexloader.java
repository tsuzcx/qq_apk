package com.tencent.qqlive.mediaplayer.dex;

import android.content.Context;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.sdkupdate.d;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.Constructor;

public class Dexloader
{
  private static Dexloader a = null;
  private static Context b;
  
  public static Dexloader a(Context paramContext)
  {
    try
    {
      if (a == null) {
        a = new Dexloader();
      }
      if (paramContext != null) {
        b = paramContext;
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  public ClassLoader a(String paramString1, String paramString2)
  {
    if (paramString1 == null)
    {
      d.a(5, "Dexloader.java", "MediaPlayerMgr", "getClassLoader filePath error, jarPath: " + paramString1 + ", soPath: " + paramString2);
      return null;
    }
    d.a(3, "Dexloader.java", "MediaPlayerMgr", "getClassLoader jarPath: " + paramString1 + ", soPath: " + paramString2);
    try
    {
      d.a(3, "Dexloader.java", "MediaPlayerMgr", "getClassLoader, print so dir content...");
      d.a(new File(paramString2), 2);
      if (b != null)
      {
        Context localContext = b.getApplicationContext();
        if (localContext != null) {
          break label196;
        }
        d.a(5, "Dexloader.java", "MediaPlayerMgr", "getClassLoader context == null, should not happen !!" + paramString1 + ", soPath: " + paramString2);
        return null;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        d.a(5, "Dexloader.java", "MediaPlayerMgr", "getClassLoader, print so dir content error, " + localThrowable.toString());
        continue;
        localObject = TVK_SDKMgr.getAppContext();
      }
      label196:
      Object localObject = ((Context)localObject).getDir("assets", 0).getAbsolutePath();
      if (new File(paramString1).exists()) {
        try
        {
          paramString2 = new DexClassLoader(paramString1, (String)localObject, paramString2, b.getApplicationContext().getClassLoader());
        }
        catch (Exception paramString2)
        {
          for (;;)
          {
            try
            {
              Constructor localConstructor = Class.forName("dalvik.system.LexClassLoader").getConstructor(new Class[] { String.class, String.class, String.class, ClassLoader.class });
              String str = new File(paramString1).getName().replaceAll("\\.[a-zA-Z0-9]+", ".lex");
              paramString1 = (ClassLoader)localConstructor.newInstance(new Object[] { (String)localObject + File.separator + str, localObject, paramString1, b.getApplicationContext().getClassLoader() });
              return paramString1;
            }
            catch (Exception paramString1)
            {
              return paramString2;
            }
            paramString2 = paramString2;
            d.a(5, "Dexloader.java", "MediaPlayerMgr", "DexClassLoader failed! error:" + paramString2.getMessage());
            paramString2 = null;
          }
        }
      }
      d.a(3, "Dexloader.java", "MediaPlayerMgr", "files do not exist, creat dexclassloader failed");
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqlive.mediaplayer.dex.Dexloader
 * JD-Core Version:    0.7.0.1
 */