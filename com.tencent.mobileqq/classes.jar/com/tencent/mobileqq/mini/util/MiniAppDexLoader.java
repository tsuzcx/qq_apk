package com.tencent.mobileqq.mini.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.apkg.BaseLibManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class MiniAppDexLoader
{
  public static final String TAG = "MiniAppDexLoader";
  private static MiniAppDexLoader instance;
  private static byte[] lock = new byte[0];
  protected Context mContext;
  private ClassLoader mNewClassLoader;
  
  private String getDexPath()
  {
    String str1 = StorageUtil.getPreference().getString("downloadUrl", "");
    String str2 = StorageUtil.getPreference().getString("version", "1.19.0.00043");
    str1 = BaseLibManager.g().getBaseLibDir(str1, str2);
    if (!TextUtils.isEmpty(str1)) {
      return str1 + "api.jar";
    }
    return null;
  }
  
  public static MiniAppDexLoader getInstance()
  {
    if (instance == null) {}
    synchronized (lock)
    {
      if (instance == null) {
        instance = new MiniAppDexLoader();
      }
      return instance;
    }
  }
  
  /* Error */
  public com.tencent.mobileqq.mini.app.BaseAppLoaderManager createAppLoaderManager(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 84	com/tencent/mobileqq/mini/util/MiniAppDexLoader:mNewClassLoader	Ljava/lang/ClassLoader;
    //   4: ifnonnull +7 -> 11
    //   7: aload_0
    //   8: invokevirtual 87	com/tencent/mobileqq/mini/util/MiniAppDexLoader:loadDex	()V
    //   11: ldc 8
    //   13: iconst_1
    //   14: new 63	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   21: ldc 89
    //   23: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_1
    //   27: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: ldc 91
    //   32: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 97	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   41: aload_0
    //   42: getfield 84	com/tencent/mobileqq/mini/util/MiniAppDexLoader:mNewClassLoader	Ljava/lang/ClassLoader;
    //   45: ifnull +52 -> 97
    //   48: aload_0
    //   49: aload_1
    //   50: aload_0
    //   51: getfield 84	com/tencent/mobileqq/mini/util/MiniAppDexLoader:mNewClassLoader	Ljava/lang/ClassLoader;
    //   54: invokevirtual 101	com/tencent/mobileqq/mini/util/MiniAppDexLoader:createInstance	(Ljava/lang/String;Ljava/lang/ClassLoader;)Ljava/lang/Object;
    //   57: checkcast 103	com/tencent/mobileqq/mini/app/BaseAppLoaderManager
    //   60: astore_2
    //   61: ldc 8
    //   63: iconst_1
    //   64: new 63	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   71: ldc 89
    //   73: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: aload_1
    //   77: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: ldc 105
    //   82: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: aload_2
    //   86: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokestatic 97	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   95: aload_2
    //   96: areturn
    //   97: aload_0
    //   98: aload_1
    //   99: aload_0
    //   100: invokevirtual 112	java/lang/Object:getClass	()Ljava/lang/Class;
    //   103: invokevirtual 118	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   106: invokevirtual 101	com/tencent/mobileqq/mini/util/MiniAppDexLoader:createInstance	(Ljava/lang/String;Ljava/lang/ClassLoader;)Ljava/lang/Object;
    //   109: checkcast 103	com/tencent/mobileqq/mini/app/BaseAppLoaderManager
    //   112: astore_2
    //   113: aload_2
    //   114: areturn
    //   115: astore_3
    //   116: aconst_null
    //   117: astore_2
    //   118: ldc 8
    //   120: iconst_1
    //   121: new 63	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   128: ldc 89
    //   130: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: aload_1
    //   134: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: ldc 120
    //   139: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: aload_3
    //   143: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   146: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokestatic 97	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   152: aload_2
    //   153: areturn
    //   154: astore_3
    //   155: goto -37 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	this	MiniAppDexLoader
    //   0	158	1	paramString	String
    //   60	93	2	localBaseAppLoaderManager	com.tencent.mobileqq.mini.app.BaseAppLoaderManager
    //   115	28	3	localException1	java.lang.Exception
    //   154	1	3	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   0	11	115	java/lang/Exception
    //   11	61	115	java/lang/Exception
    //   97	113	115	java/lang/Exception
    //   61	95	154	java/lang/Exception
  }
  
  /* Error */
  public com.tencent.mobileqq.mini.app.IAppUIProxy createAppUIProxy(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 84	com/tencent/mobileqq/mini/util/MiniAppDexLoader:mNewClassLoader	Ljava/lang/ClassLoader;
    //   4: ifnonnull +7 -> 11
    //   7: aload_0
    //   8: invokevirtual 87	com/tencent/mobileqq/mini/util/MiniAppDexLoader:loadDex	()V
    //   11: ldc 8
    //   13: iconst_1
    //   14: new 63	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   21: ldc 89
    //   23: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_1
    //   27: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: ldc 91
    //   32: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 97	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   41: aload_0
    //   42: getfield 84	com/tencent/mobileqq/mini/util/MiniAppDexLoader:mNewClassLoader	Ljava/lang/ClassLoader;
    //   45: ifnull +52 -> 97
    //   48: aload_0
    //   49: aload_1
    //   50: aload_0
    //   51: getfield 84	com/tencent/mobileqq/mini/util/MiniAppDexLoader:mNewClassLoader	Ljava/lang/ClassLoader;
    //   54: invokevirtual 101	com/tencent/mobileqq/mini/util/MiniAppDexLoader:createInstance	(Ljava/lang/String;Ljava/lang/ClassLoader;)Ljava/lang/Object;
    //   57: checkcast 124	com/tencent/mobileqq/mini/app/IAppUIProxy
    //   60: astore_2
    //   61: ldc 8
    //   63: iconst_1
    //   64: new 63	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   71: ldc 89
    //   73: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: aload_1
    //   77: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: ldc 105
    //   82: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: aload_2
    //   86: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokestatic 97	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   95: aload_2
    //   96: areturn
    //   97: aload_0
    //   98: aload_1
    //   99: aload_0
    //   100: invokevirtual 112	java/lang/Object:getClass	()Ljava/lang/Class;
    //   103: invokevirtual 118	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   106: invokevirtual 101	com/tencent/mobileqq/mini/util/MiniAppDexLoader:createInstance	(Ljava/lang/String;Ljava/lang/ClassLoader;)Ljava/lang/Object;
    //   109: checkcast 124	com/tencent/mobileqq/mini/app/IAppUIProxy
    //   112: astore_2
    //   113: aload_2
    //   114: areturn
    //   115: astore_3
    //   116: aconst_null
    //   117: astore_2
    //   118: ldc 8
    //   120: iconst_1
    //   121: new 63	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   128: ldc 89
    //   130: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: aload_1
    //   134: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: ldc 120
    //   139: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: aload_3
    //   143: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   146: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokestatic 97	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   152: aload_2
    //   153: areturn
    //   154: astore_3
    //   155: goto -37 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	this	MiniAppDexLoader
    //   0	158	1	paramString	String
    //   60	93	2	localIAppUIProxy	com.tencent.mobileqq.mini.app.IAppUIProxy
    //   115	28	3	localException1	java.lang.Exception
    //   154	1	3	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   0	11	115	java/lang/Exception
    //   11	61	115	java/lang/Exception
    //   97	113	115	java/lang/Exception
    //   61	95	154	java/lang/Exception
  }
  
  Object createInstance(String paramString, ClassLoader paramClassLoader)
  {
    try
    {
      paramClassLoader = paramClassLoader.loadClass(paramString).newInstance();
      return paramClassLoader;
    }
    catch (IllegalAccessException paramClassLoader)
    {
      QLog.e("MiniAppDexLoader", 1, " MiniAppDexLoader : " + paramString + " failed." + paramClassLoader);
      return null;
    }
    catch (InstantiationException paramClassLoader)
    {
      for (;;)
      {
        QLog.e("MiniAppDexLoader", 1, " MiniAppDexLoader : " + paramString + " failed." + paramClassLoader);
      }
    }
    catch (ClassNotFoundException paramClassLoader)
    {
      for (;;)
      {
        QLog.e("MiniAppDexLoader", 1, " MiniAppDexLoader : " + paramString + " failed." + paramClassLoader);
      }
    }
  }
  
  /* Error */
  public com.tencent.mobileqq.mini.appbrand.jsapi.IJsPlugin createJsPlugin(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 84	com/tencent/mobileqq/mini/util/MiniAppDexLoader:mNewClassLoader	Ljava/lang/ClassLoader;
    //   4: ifnonnull +7 -> 11
    //   7: aload_0
    //   8: invokevirtual 87	com/tencent/mobileqq/mini/util/MiniAppDexLoader:loadDex	()V
    //   11: ldc 8
    //   13: iconst_2
    //   14: new 63	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   21: ldc 89
    //   23: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_1
    //   27: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: ldc 91
    //   32: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 97	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   41: aload_0
    //   42: getfield 84	com/tencent/mobileqq/mini/util/MiniAppDexLoader:mNewClassLoader	Ljava/lang/ClassLoader;
    //   45: ifnull +52 -> 97
    //   48: aload_0
    //   49: aload_1
    //   50: aload_0
    //   51: getfield 84	com/tencent/mobileqq/mini/util/MiniAppDexLoader:mNewClassLoader	Ljava/lang/ClassLoader;
    //   54: invokevirtual 101	com/tencent/mobileqq/mini/util/MiniAppDexLoader:createInstance	(Ljava/lang/String;Ljava/lang/ClassLoader;)Ljava/lang/Object;
    //   57: checkcast 144	com/tencent/mobileqq/mini/appbrand/jsapi/IJsPlugin
    //   60: astore_2
    //   61: ldc 8
    //   63: iconst_2
    //   64: new 63	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   71: ldc 89
    //   73: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: aload_1
    //   77: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: ldc 105
    //   82: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: aload_2
    //   86: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokestatic 97	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   95: aload_2
    //   96: areturn
    //   97: aload_0
    //   98: aload_1
    //   99: aload_0
    //   100: invokevirtual 112	java/lang/Object:getClass	()Ljava/lang/Class;
    //   103: invokevirtual 118	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   106: invokevirtual 101	com/tencent/mobileqq/mini/util/MiniAppDexLoader:createInstance	(Ljava/lang/String;Ljava/lang/ClassLoader;)Ljava/lang/Object;
    //   109: checkcast 144	com/tencent/mobileqq/mini/appbrand/jsapi/IJsPlugin
    //   112: astore_2
    //   113: aload_2
    //   114: areturn
    //   115: astore_3
    //   116: aconst_null
    //   117: astore_2
    //   118: ldc 8
    //   120: iconst_1
    //   121: new 63	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   128: ldc 89
    //   130: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: aload_1
    //   134: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: ldc 120
    //   139: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: aload_3
    //   143: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   146: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: aload_3
    //   150: invokestatic 147	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   153: aload_2
    //   154: areturn
    //   155: astore_3
    //   156: goto -38 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	this	MiniAppDexLoader
    //   0	159	1	paramString	String
    //   60	94	2	localIJsPlugin	com.tencent.mobileqq.mini.appbrand.jsapi.IJsPlugin
    //   115	35	3	localException1	java.lang.Exception
    //   155	1	3	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   0	11	115	java/lang/Exception
    //   11	61	115	java/lang/Exception
    //   97	113	115	java/lang/Exception
    //   61	95	155	java/lang/Exception
  }
  
  public boolean hasNewDex()
  {
    String str = getDexPath();
    if (TextUtils.isEmpty(str)) {}
    while (!new File(str).exists()) {
      return false;
    }
    return true;
  }
  
  public void loadDex()
  {
    try
    {
      getClass().getClassLoader();
      if ((hasNewDex()) && (this.mNewClassLoader == null)) {
        this.mNewClassLoader = new MiniAppClassloader(getDexPath(), BaseApplicationImpl.getApplication().getApplicationInfo().nativeLibraryDir, getClass().getClassLoader());
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.util.MiniAppDexLoader
 * JD-Core Version:    0.7.0.1
 */