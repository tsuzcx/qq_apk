package com.tencent.mobileqq.mini.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.apkg.BaseLibManager;
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
    String str2 = StorageUtil.getPreference().getString("version", "1.10.0.00173");
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
    //   45: ifnull +57 -> 102
    //   48: aload_1
    //   49: aload_0
    //   50: getfield 84	com/tencent/mobileqq/mini/util/MiniAppDexLoader:mNewClassLoader	Ljava/lang/ClassLoader;
    //   53: invokestatic 103	com/tencent/mobileqq/triton/sdk/reflection/Reflect:on	(Ljava/lang/String;Ljava/lang/ClassLoader;)Lcom/tencent/mobileqq/triton/sdk/reflection/Reflect;
    //   56: invokevirtual 107	com/tencent/mobileqq/triton/sdk/reflection/Reflect:create	()Lcom/tencent/mobileqq/triton/sdk/reflection/Reflect;
    //   59: invokevirtual 111	com/tencent/mobileqq/triton/sdk/reflection/Reflect:get	()Ljava/lang/Object;
    //   62: checkcast 113	com/tencent/mobileqq/mini/app/BaseAppLoaderManager
    //   65: astore_2
    //   66: ldc 8
    //   68: iconst_1
    //   69: new 63	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   76: ldc 89
    //   78: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: aload_1
    //   82: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: ldc 115
    //   87: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: aload_2
    //   91: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokestatic 97	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   100: aload_2
    //   101: areturn
    //   102: aload_1
    //   103: aload_0
    //   104: invokevirtual 122	java/lang/Object:getClass	()Ljava/lang/Class;
    //   107: invokevirtual 128	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   110: invokestatic 103	com/tencent/mobileqq/triton/sdk/reflection/Reflect:on	(Ljava/lang/String;Ljava/lang/ClassLoader;)Lcom/tencent/mobileqq/triton/sdk/reflection/Reflect;
    //   113: invokevirtual 107	com/tencent/mobileqq/triton/sdk/reflection/Reflect:create	()Lcom/tencent/mobileqq/triton/sdk/reflection/Reflect;
    //   116: invokevirtual 111	com/tencent/mobileqq/triton/sdk/reflection/Reflect:get	()Ljava/lang/Object;
    //   119: checkcast 113	com/tencent/mobileqq/mini/app/BaseAppLoaderManager
    //   122: astore_2
    //   123: aload_2
    //   124: areturn
    //   125: astore_3
    //   126: aconst_null
    //   127: astore_2
    //   128: ldc 8
    //   130: iconst_1
    //   131: new 63	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   138: ldc 89
    //   140: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: aload_1
    //   144: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: ldc 130
    //   149: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: aload_3
    //   153: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   156: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokestatic 97	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   162: aload_2
    //   163: areturn
    //   164: astore_3
    //   165: goto -37 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	this	MiniAppDexLoader
    //   0	168	1	paramString	String
    //   65	98	2	localBaseAppLoaderManager	com.tencent.mobileqq.mini.app.BaseAppLoaderManager
    //   125	28	3	localException1	java.lang.Exception
    //   164	1	3	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   0	11	125	java/lang/Exception
    //   11	66	125	java/lang/Exception
    //   102	123	125	java/lang/Exception
    //   66	100	164	java/lang/Exception
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
    //   45: ifnull +57 -> 102
    //   48: aload_1
    //   49: aload_0
    //   50: getfield 84	com/tencent/mobileqq/mini/util/MiniAppDexLoader:mNewClassLoader	Ljava/lang/ClassLoader;
    //   53: invokestatic 103	com/tencent/mobileqq/triton/sdk/reflection/Reflect:on	(Ljava/lang/String;Ljava/lang/ClassLoader;)Lcom/tencent/mobileqq/triton/sdk/reflection/Reflect;
    //   56: invokevirtual 107	com/tencent/mobileqq/triton/sdk/reflection/Reflect:create	()Lcom/tencent/mobileqq/triton/sdk/reflection/Reflect;
    //   59: invokevirtual 111	com/tencent/mobileqq/triton/sdk/reflection/Reflect:get	()Ljava/lang/Object;
    //   62: checkcast 134	com/tencent/mobileqq/mini/app/IAppUIProxy
    //   65: astore_2
    //   66: ldc 8
    //   68: iconst_1
    //   69: new 63	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   76: ldc 89
    //   78: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: aload_1
    //   82: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: ldc 115
    //   87: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: aload_2
    //   91: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokestatic 97	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   100: aload_2
    //   101: areturn
    //   102: aload_1
    //   103: aload_0
    //   104: invokevirtual 122	java/lang/Object:getClass	()Ljava/lang/Class;
    //   107: invokevirtual 128	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   110: invokestatic 103	com/tencent/mobileqq/triton/sdk/reflection/Reflect:on	(Ljava/lang/String;Ljava/lang/ClassLoader;)Lcom/tencent/mobileqq/triton/sdk/reflection/Reflect;
    //   113: invokevirtual 107	com/tencent/mobileqq/triton/sdk/reflection/Reflect:create	()Lcom/tencent/mobileqq/triton/sdk/reflection/Reflect;
    //   116: invokevirtual 111	com/tencent/mobileqq/triton/sdk/reflection/Reflect:get	()Ljava/lang/Object;
    //   119: checkcast 134	com/tencent/mobileqq/mini/app/IAppUIProxy
    //   122: astore_2
    //   123: aload_2
    //   124: areturn
    //   125: astore_3
    //   126: aconst_null
    //   127: astore_2
    //   128: ldc 8
    //   130: iconst_1
    //   131: new 63	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   138: ldc 89
    //   140: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: aload_1
    //   144: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: ldc 130
    //   149: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: aload_3
    //   153: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   156: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokestatic 97	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   162: aload_2
    //   163: areturn
    //   164: astore_3
    //   165: goto -37 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	this	MiniAppDexLoader
    //   0	168	1	paramString	String
    //   65	98	2	localIAppUIProxy	com.tencent.mobileqq.mini.app.IAppUIProxy
    //   125	28	3	localException1	java.lang.Exception
    //   164	1	3	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   0	11	125	java/lang/Exception
    //   11	66	125	java/lang/Exception
    //   102	123	125	java/lang/Exception
    //   66	100	164	java/lang/Exception
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
    //   45: ifnull +57 -> 102
    //   48: aload_1
    //   49: aload_0
    //   50: getfield 84	com/tencent/mobileqq/mini/util/MiniAppDexLoader:mNewClassLoader	Ljava/lang/ClassLoader;
    //   53: invokestatic 103	com/tencent/mobileqq/triton/sdk/reflection/Reflect:on	(Ljava/lang/String;Ljava/lang/ClassLoader;)Lcom/tencent/mobileqq/triton/sdk/reflection/Reflect;
    //   56: invokevirtual 107	com/tencent/mobileqq/triton/sdk/reflection/Reflect:create	()Lcom/tencent/mobileqq/triton/sdk/reflection/Reflect;
    //   59: invokevirtual 111	com/tencent/mobileqq/triton/sdk/reflection/Reflect:get	()Ljava/lang/Object;
    //   62: checkcast 138	com/tencent/mobileqq/mini/appbrand/jsapi/IJsPlugin
    //   65: astore_2
    //   66: ldc 8
    //   68: iconst_2
    //   69: new 63	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   76: ldc 89
    //   78: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: aload_1
    //   82: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: ldc 115
    //   87: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: aload_2
    //   91: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokestatic 97	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   100: aload_2
    //   101: areturn
    //   102: aload_1
    //   103: aload_0
    //   104: invokevirtual 122	java/lang/Object:getClass	()Ljava/lang/Class;
    //   107: invokevirtual 128	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   110: invokestatic 103	com/tencent/mobileqq/triton/sdk/reflection/Reflect:on	(Ljava/lang/String;Ljava/lang/ClassLoader;)Lcom/tencent/mobileqq/triton/sdk/reflection/Reflect;
    //   113: invokevirtual 107	com/tencent/mobileqq/triton/sdk/reflection/Reflect:create	()Lcom/tencent/mobileqq/triton/sdk/reflection/Reflect;
    //   116: invokevirtual 111	com/tencent/mobileqq/triton/sdk/reflection/Reflect:get	()Ljava/lang/Object;
    //   119: checkcast 138	com/tencent/mobileqq/mini/appbrand/jsapi/IJsPlugin
    //   122: astore_2
    //   123: aload_2
    //   124: areturn
    //   125: astore_3
    //   126: aconst_null
    //   127: astore_2
    //   128: ldc 8
    //   130: iconst_1
    //   131: new 63	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   138: ldc 89
    //   140: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: aload_1
    //   144: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: ldc 130
    //   149: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: aload_3
    //   153: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   156: invokevirtual 73	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: aload_3
    //   160: invokestatic 141	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   163: aload_2
    //   164: areturn
    //   165: astore_3
    //   166: goto -38 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	169	0	this	MiniAppDexLoader
    //   0	169	1	paramString	String
    //   65	99	2	localIJsPlugin	com.tencent.mobileqq.mini.appbrand.jsapi.IJsPlugin
    //   125	35	3	localException1	java.lang.Exception
    //   165	1	3	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   0	11	125	java/lang/Exception
    //   11	66	125	java/lang/Exception
    //   102	123	125	java/lang/Exception
    //   66	100	165	java/lang/Exception
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.util.MiniAppDexLoader
 * JD-Core Version:    0.7.0.1
 */