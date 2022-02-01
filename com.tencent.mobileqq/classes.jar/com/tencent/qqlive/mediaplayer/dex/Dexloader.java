package com.tencent.qqlive.mediaplayer.dex;

import android.content.Context;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.mediaplayer.sdkupdate.d;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.Constructor;

public class Dexloader
{
  private static Dexloader a;
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
    Constructor localConstructor = null;
    if (paramString1 == null)
    {
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("getClassLoader filePath error, jarPath: ");
      localStringBuilder1.append(paramString1);
      localStringBuilder1.append(", soPath: ");
      localStringBuilder1.append(paramString2);
      d.a(5, "Dexloader.java", "MediaPlayerMgr", localStringBuilder1.toString());
      return null;
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("getClassLoader jarPath: ");
    localStringBuilder1.append(paramString1);
    localStringBuilder1.append(", soPath: ");
    localStringBuilder1.append(paramString2);
    d.a(3, "Dexloader.java", "MediaPlayerMgr", localStringBuilder1.toString());
    Object localObject2;
    try
    {
      d.a(3, "Dexloader.java", "MediaPlayerMgr", "getClassLoader, print so dir content...");
      d.a(new File(paramString2), 2);
    }
    catch (Throwable localThrowable)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getClassLoader, print so dir content error, ");
      ((StringBuilder)localObject2).append(localThrowable.toString());
      d.a(5, "Dexloader.java", "MediaPlayerMgr", ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = b;
    if (localObject1 != null) {
      localObject1 = ((Context)localObject1).getApplicationContext();
    } else {
      localObject1 = TVK_SDKMgr.getAppContext();
    }
    if (localObject1 == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getClassLoader context == null, should not happen !!");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(", soPath: ");
      ((StringBuilder)localObject1).append(paramString2);
      d.a(5, "Dexloader.java", "MediaPlayerMgr", ((StringBuilder)localObject1).toString());
      return null;
    }
    localObject1 = ((Context)localObject1).getDir("assets", 0).getAbsolutePath();
    if (new File(paramString1).exists()) {
      try
      {
        paramString2 = new DexClassLoader(paramString1, (String)localObject1, paramString2, b.getApplicationContext().getClassLoader());
      }
      catch (Exception paramString2)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("DexClassLoader failed! error:");
        ((StringBuilder)localObject2).append(paramString2.getMessage());
        d.a(5, "Dexloader.java", "MediaPlayerMgr", ((StringBuilder)localObject2).toString());
        paramString2 = localConstructor;
      }
    }
    try
    {
      localConstructor = Class.forName("dalvik.system.LexClassLoader").getConstructor(new Class[] { String.class, String.class, String.class, ClassLoader.class });
      localObject2 = new File(paramString1).getName().replaceAll("\\.[a-zA-Z0-9]+", ".lex");
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append((String)localObject1);
      localStringBuilder2.append(File.separator);
      localStringBuilder2.append((String)localObject2);
      paramString1 = (ClassLoader)localConstructor.newInstance(new Object[] { localStringBuilder2.toString(), localObject1, paramString1, b.getApplicationContext().getClassLoader() });
      return paramString1;
    }
    catch (Exception paramString1)
    {
      label461:
      break label461;
    }
    return paramString2;
    d.a(3, "Dexloader.java", "MediaPlayerMgr", "files do not exist, creat dexclassloader failed");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.mediaplayer.dex.Dexloader
 * JD-Core Version:    0.7.0.1
 */