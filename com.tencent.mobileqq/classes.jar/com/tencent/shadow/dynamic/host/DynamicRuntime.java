package com.tencent.shadow.dynamic.host;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Process;
import com.tencent.shadow.core.common.InstalledApk;
import com.tencent.shadow.core.common.Logger;
import com.tencent.shadow.core.common.LoggerFactory;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;

public class DynamicRuntime
{
  private static final String KEY_RUNTIME_APK = "KEY_RUNTIME_APK";
  private static final String KEY_RUNTIME_LIB = "KEY_RUNTIME_LIB";
  private static final String KEY_RUNTIME_ODEX = "KEY_RUNTIME_ODEX";
  private static final String SP_NAME = "ShadowRuntimeLoader";
  private static final Logger mLogger = LoggerFactory.getLogger(ShadowTag.class);
  
  private static InstalledApk getLastRuntimeInfo(Context paramContext)
  {
    Object localObject = paramContext.getSharedPreferences(getSpName(paramContext), 0);
    paramContext = ((SharedPreferences)localObject).getString("KEY_RUNTIME_APK", null);
    String str = ((SharedPreferences)localObject).getString("KEY_RUNTIME_ODEX", null);
    localObject = ((SharedPreferences)localObject).getString("KEY_RUNTIME_LIB", null);
    if (paramContext == null) {
      return null;
    }
    return new InstalledApk(paramContext, str, (String)localObject);
  }
  
  private static Field getParentField()
  {
    ClassLoader localClassLoader1 = DynamicRuntime.class.getClassLoader();
    ClassLoader localClassLoader2 = localClassLoader1.getParent();
    Field[] arrayOfField = ClassLoader.class.getDeclaredFields();
    int j = arrayOfField.length;
    int i = 0;
    while (i < j)
    {
      Field localField = arrayOfField[i];
      try
      {
        boolean bool = localField.isAccessible();
        localField.setAccessible(true);
        Object localObject = localField.get(localClassLoader1);
        localField.setAccessible(bool);
        if (localObject == localClassLoader2) {
          return localField;
        }
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        i += 1;
      }
    }
    return null;
  }
  
  /* Error */
  private static String getProcessName(int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: new 96	java/io/FileReader
    //   5: dup
    //   6: new 98	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   13: ldc 101
    //   15: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: iload_0
    //   19: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   22: ldc 110
    //   24: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokespecial 117	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   33: astore_3
    //   34: aload_3
    //   35: astore_2
    //   36: sipush 512
    //   39: newarray char
    //   41: astore 4
    //   43: aload_3
    //   44: astore_2
    //   45: aload_3
    //   46: aload 4
    //   48: invokevirtual 121	java/io/FileReader:read	([C)I
    //   51: pop
    //   52: iload_1
    //   53: istore_0
    //   54: aload_3
    //   55: astore_2
    //   56: iload_0
    //   57: aload 4
    //   59: arraylength
    //   60: if_icmpge +17 -> 77
    //   63: aload 4
    //   65: iload_0
    //   66: caload
    //   67: ifeq +10 -> 77
    //   70: iload_0
    //   71: iconst_1
    //   72: iadd
    //   73: istore_0
    //   74: goto -20 -> 54
    //   77: aload_3
    //   78: astore_2
    //   79: new 123	java/lang/String
    //   82: dup
    //   83: aload 4
    //   85: invokespecial 126	java/lang/String:<init>	([C)V
    //   88: iconst_0
    //   89: iload_0
    //   90: invokevirtual 130	java/lang/String:substring	(II)Ljava/lang/String;
    //   93: astore 4
    //   95: aload 4
    //   97: astore_2
    //   98: aload_2
    //   99: astore 4
    //   101: aload_3
    //   102: ifnull +10 -> 112
    //   105: aload_3
    //   106: invokevirtual 133	java/io/FileReader:close	()V
    //   109: aload_2
    //   110: astore 4
    //   112: aload 4
    //   114: areturn
    //   115: astore_3
    //   116: aload_3
    //   117: invokevirtual 136	java/io/IOException:printStackTrace	()V
    //   120: aload_2
    //   121: areturn
    //   122: astore 4
    //   124: aconst_null
    //   125: astore_3
    //   126: aload_3
    //   127: astore_2
    //   128: getstatic 28	com/tencent/shadow/dynamic/host/DynamicRuntime:mLogger	Lcom/tencent/shadow/core/common/Logger;
    //   131: ldc 138
    //   133: aload 4
    //   135: invokeinterface 144 3 0
    //   140: ldc 146
    //   142: astore 4
    //   144: aload_3
    //   145: ifnull -33 -> 112
    //   148: aload_3
    //   149: invokevirtual 133	java/io/FileReader:close	()V
    //   152: ldc 146
    //   154: areturn
    //   155: astore_2
    //   156: aload_2
    //   157: invokevirtual 136	java/io/IOException:printStackTrace	()V
    //   160: ldc 146
    //   162: areturn
    //   163: astore_3
    //   164: aconst_null
    //   165: astore_2
    //   166: aload_2
    //   167: ifnull +7 -> 174
    //   170: aload_2
    //   171: invokevirtual 133	java/io/FileReader:close	()V
    //   174: aload_3
    //   175: athrow
    //   176: astore_2
    //   177: aload_2
    //   178: invokevirtual 136	java/io/IOException:printStackTrace	()V
    //   181: goto -7 -> 174
    //   184: astore_3
    //   185: goto -19 -> 166
    //   188: astore 4
    //   190: goto -64 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	paramInt	int
    //   1	52	1	i	int
    //   35	93	2	localObject1	Object
    //   155	2	2	localIOException1	java.io.IOException
    //   165	6	2	localObject2	Object
    //   176	2	2	localIOException2	java.io.IOException
    //   33	73	3	localFileReader	java.io.FileReader
    //   115	2	3	localIOException3	java.io.IOException
    //   125	24	3	localObject3	Object
    //   163	12	3	localObject4	Object
    //   184	1	3	localObject5	Object
    //   41	72	4	localObject6	Object
    //   122	12	4	localException1	Exception
    //   142	1	4	str	String
    //   188	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   105	109	115	java/io/IOException
    //   2	34	122	java/lang/Exception
    //   148	152	155	java/io/IOException
    //   2	34	163	finally
    //   170	174	176	java/io/IOException
    //   36	43	184	finally
    //   45	52	184	finally
    //   56	63	184	finally
    //   79	95	184	finally
    //   128	140	184	finally
    //   36	43	188	java/lang/Exception
    //   45	52	188	java/lang/Exception
    //   56	63	188	java/lang/Exception
    //   79	95	188	java/lang/Exception
  }
  
  private static String getProcessName(Context paramContext)
  {
    if (paramContext == null) {
      return "unknown";
    }
    try
    {
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
      if (paramContext != null)
      {
        paramContext = paramContext.iterator();
        while (paramContext.hasNext())
        {
          ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
          if ((localRunningAppProcessInfo != null) && (localRunningAppProcessInfo.pid == Process.myPid()))
          {
            paramContext = localRunningAppProcessInfo.processName;
            return paramContext;
          }
        }
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return getProcessName(Process.myPid());
  }
  
  private static DynamicRuntime.RuntimeClassLoader getRuntimeClassLoader()
  {
    for (ClassLoader localClassLoader = DynamicRuntime.class.getClassLoader().getParent(); localClassLoader != null; localClassLoader = localClassLoader.getParent()) {
      if ((localClassLoader instanceof DynamicRuntime.RuntimeClassLoader)) {
        return (DynamicRuntime.RuntimeClassLoader)localClassLoader;
      }
    }
    return null;
  }
  
  private static String getSpName(Context paramContext)
  {
    return "ShadowRuntimeLoader_" + getProcessName(paramContext);
  }
  
  static void hackParentClassLoader(ClassLoader paramClassLoader1, ClassLoader paramClassLoader2)
  {
    Field localField = getParentField();
    if (localField == null) {
      throw new RuntimeException("在ClassLoader.class中没找到类型为ClassLoader的parent域");
    }
    localField.setAccessible(true);
    localField.set(paramClassLoader1, paramClassLoader2);
  }
  
  private static void hackParentToRuntime(InstalledApk paramInstalledApk, ClassLoader paramClassLoader)
  {
    hackParentClassLoader(paramClassLoader, new DynamicRuntime.RuntimeClassLoader(paramInstalledApk.apkFilePath, paramInstalledApk.oDexPath, paramInstalledApk.libraryPath, paramClassLoader.getParent()));
  }
  
  /* Error */
  public static boolean loadRuntime(InstalledApk paramInstalledApk)
  {
    // Byte code:
    //   0: ldc 2
    //   2: invokevirtual 65	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   5: astore_1
    //   6: invokestatic 232	com/tencent/shadow/dynamic/host/DynamicRuntime:getRuntimeClassLoader	()Lcom/tencent/shadow/dynamic/host/DynamicRuntime$RuntimeClassLoader;
    //   9: astore_2
    //   10: aload_2
    //   11: ifnull +117 -> 128
    //   14: aload_2
    //   15: invokestatic 236	com/tencent/shadow/dynamic/host/DynamicRuntime$RuntimeClassLoader:access$000	(Lcom/tencent/shadow/dynamic/host/DynamicRuntime$RuntimeClassLoader;)Ljava/lang/String;
    //   18: astore_2
    //   19: getstatic 28	com/tencent/shadow/dynamic/host/DynamicRuntime:mLogger	Lcom/tencent/shadow/core/common/Logger;
    //   22: invokeinterface 239 1 0
    //   27: ifeq +42 -> 69
    //   30: getstatic 28	com/tencent/shadow/dynamic/host/DynamicRuntime:mLogger	Lcom/tencent/shadow/core/common/Logger;
    //   33: new 98	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   40: ldc 241
    //   42: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload_2
    //   46: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: ldc 243
    //   51: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: aload_0
    //   55: getfield 217	com/tencent/shadow/core/common/InstalledApk:apkFilePath	Ljava/lang/String;
    //   58: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokeinterface 246 2 0
    //   69: aload_2
    //   70: aload_0
    //   71: getfield 217	com/tencent/shadow/core/common/InstalledApk:apkFilePath	Ljava/lang/String;
    //   74: invokestatic 252	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   77: ifeq +26 -> 103
    //   80: getstatic 28	com/tencent/shadow/dynamic/host/DynamicRuntime:mLogger	Lcom/tencent/shadow/core/common/Logger;
    //   83: invokeinterface 239 1 0
    //   88: ifeq +13 -> 101
    //   91: getstatic 28	com/tencent/shadow/dynamic/host/DynamicRuntime:mLogger	Lcom/tencent/shadow/core/common/Logger;
    //   94: ldc 254
    //   96: invokeinterface 246 2 0
    //   101: iconst_0
    //   102: ireturn
    //   103: getstatic 28	com/tencent/shadow/dynamic/host/DynamicRuntime:mLogger	Lcom/tencent/shadow/core/common/Logger;
    //   106: invokeinterface 239 1 0
    //   111: ifeq +14 -> 125
    //   114: getstatic 28	com/tencent/shadow/dynamic/host/DynamicRuntime:mLogger	Lcom/tencent/shadow/core/common/Logger;
    //   117: ldc_w 256
    //   120: invokeinterface 246 2 0
    //   125: invokestatic 259	com/tencent/shadow/dynamic/host/DynamicRuntime:recoveryClassLoader	()V
    //   128: aload_0
    //   129: aload_1
    //   130: invokestatic 261	com/tencent/shadow/dynamic/host/DynamicRuntime:hackParentToRuntime	(Lcom/tencent/shadow/core/common/InstalledApk;Ljava/lang/ClassLoader;)V
    //   133: iconst_1
    //   134: ireturn
    //   135: astore_0
    //   136: new 205	java/lang/RuntimeException
    //   139: dup
    //   140: aload_0
    //   141: invokespecial 264	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   144: athrow
    //   145: astore_0
    //   146: new 205	java/lang/RuntimeException
    //   149: dup
    //   150: aload_0
    //   151: invokespecial 264	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   154: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	155	0	paramInstalledApk	InstalledApk
    //   5	125	1	localClassLoader	ClassLoader
    //   9	61	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   125	128	135	java/lang/Exception
    //   128	133	145	java/lang/Exception
  }
  
  private static void recoveryClassLoader()
  {
    Object localObject2 = DynamicRuntime.class.getClassLoader();
    ClassLoader localClassLoader;
    for (Object localObject1 = ((ClassLoader)localObject2).getParent();; localObject1 = localClassLoader)
    {
      if (localObject1 != null)
      {
        if ((localObject1 instanceof DynamicRuntime.RuntimeClassLoader)) {
          hackParentClassLoader((ClassLoader)localObject2, ((ClassLoader)localObject1).getParent());
        }
      }
      else {
        return;
      }
      localClassLoader = ((ClassLoader)localObject1).getParent();
      localObject2 = localObject1;
    }
  }
  
  public static boolean recoveryRuntime(Context paramContext)
  {
    InstalledApk localInstalledApk = getLastRuntimeInfo(paramContext);
    if ((localInstalledApk == null) || (!new File(localInstalledApk.apkFilePath).exists()) || ((localInstalledApk.oDexPath != null) && (!new File(localInstalledApk.oDexPath).exists()))) {
      return false;
    }
    try
    {
      hackParentToRuntime(localInstalledApk, DynamicRuntime.class.getClassLoader());
      return true;
    }
    catch (Exception localException)
    {
      if (mLogger.isErrorEnabled()) {
        mLogger.error("recoveryRuntime 错误", localException);
      }
      removeLastRuntimeInfo(paramContext);
    }
    return false;
  }
  
  @SuppressLint({"ApplySharedPref"})
  private static void removeLastRuntimeInfo(Context paramContext)
  {
    paramContext.getSharedPreferences(getSpName(paramContext), 0).edit().remove("KEY_RUNTIME_APK").remove("KEY_RUNTIME_ODEX").remove("KEY_RUNTIME_LIB").commit();
  }
  
  @SuppressLint({"ApplySharedPref"})
  public static void saveLastRuntimeInfo(Context paramContext, InstalledApk paramInstalledApk)
  {
    paramContext.getSharedPreferences(getSpName(paramContext), 0).edit().putString("KEY_RUNTIME_APK", paramInstalledApk.apkFilePath).putString("KEY_RUNTIME_ODEX", paramInstalledApk.oDexPath).putString("KEY_RUNTIME_LIB", paramInstalledApk.libraryPath).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.shadow.dynamic.host.DynamicRuntime
 * JD-Core Version:    0.7.0.1
 */