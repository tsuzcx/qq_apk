package com.tencent.shadow.dynamic.host;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Process;
import android.text.TextUtils;
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
        label72:
        break label72;
      }
      i += 1;
    }
    return null;
  }
  
  /* Error */
  private static String getProcessName(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_2
    //   5: aload_2
    //   6: astore_1
    //   7: new 96	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   14: astore_3
    //   15: aload_2
    //   16: astore_1
    //   17: aload_3
    //   18: ldc 99
    //   20: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload_2
    //   25: astore_1
    //   26: aload_3
    //   27: iload_0
    //   28: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: aload_2
    //   33: astore_1
    //   34: aload_3
    //   35: ldc 108
    //   37: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload_2
    //   42: astore_1
    //   43: new 110	java/io/FileReader
    //   46: dup
    //   47: aload_3
    //   48: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokespecial 117	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   54: astore_2
    //   55: sipush 512
    //   58: newarray char
    //   60: astore_1
    //   61: aload_2
    //   62: aload_1
    //   63: invokevirtual 121	java/io/FileReader:read	([C)I
    //   66: pop
    //   67: iconst_0
    //   68: istore_0
    //   69: iload_0
    //   70: aload_1
    //   71: arraylength
    //   72: if_icmpge +16 -> 88
    //   75: aload_1
    //   76: iload_0
    //   77: caload
    //   78: ifeq +10 -> 88
    //   81: iload_0
    //   82: iconst_1
    //   83: iadd
    //   84: istore_0
    //   85: goto -16 -> 69
    //   88: new 123	java/lang/String
    //   91: dup
    //   92: aload_1
    //   93: invokespecial 126	java/lang/String:<init>	([C)V
    //   96: iconst_0
    //   97: iload_0
    //   98: invokevirtual 130	java/lang/String:substring	(II)Ljava/lang/String;
    //   101: astore_1
    //   102: aload_2
    //   103: invokevirtual 133	java/io/FileReader:close	()V
    //   106: aload_1
    //   107: areturn
    //   108: astore_2
    //   109: aload_2
    //   110: invokevirtual 136	java/io/IOException:printStackTrace	()V
    //   113: aload_1
    //   114: areturn
    //   115: astore_3
    //   116: aload_2
    //   117: astore_1
    //   118: aload_3
    //   119: astore_2
    //   120: goto +47 -> 167
    //   123: astore_3
    //   124: goto +11 -> 135
    //   127: astore_2
    //   128: goto +39 -> 167
    //   131: astore_3
    //   132: aload 4
    //   134: astore_2
    //   135: aload_2
    //   136: astore_1
    //   137: getstatic 28	com/tencent/shadow/dynamic/host/DynamicRuntime:mLogger	Lcom/tencent/shadow/core/common/Logger;
    //   140: ldc 138
    //   142: aload_3
    //   143: invokeinterface 144 3 0
    //   148: aload_2
    //   149: ifnull +15 -> 164
    //   152: aload_2
    //   153: invokevirtual 133	java/io/FileReader:close	()V
    //   156: ldc 146
    //   158: areturn
    //   159: astore_1
    //   160: aload_1
    //   161: invokevirtual 136	java/io/IOException:printStackTrace	()V
    //   164: ldc 146
    //   166: areturn
    //   167: aload_1
    //   168: ifnull +15 -> 183
    //   171: aload_1
    //   172: invokevirtual 133	java/io/FileReader:close	()V
    //   175: goto +8 -> 183
    //   178: astore_1
    //   179: aload_1
    //   180: invokevirtual 136	java/io/IOException:printStackTrace	()V
    //   183: goto +5 -> 188
    //   186: aload_2
    //   187: athrow
    //   188: goto -2 -> 186
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	paramInt	int
    //   6	131	1	localObject1	Object
    //   159	13	1	localIOException1	java.io.IOException
    //   178	2	1	localIOException2	java.io.IOException
    //   4	99	2	localFileReader	java.io.FileReader
    //   108	9	2	localIOException3	java.io.IOException
    //   119	1	2	localObject2	Object
    //   127	1	2	localObject3	Object
    //   134	53	2	localObject4	Object
    //   14	34	3	localStringBuilder	StringBuilder
    //   115	4	3	localObject5	Object
    //   123	1	3	localException1	Exception
    //   131	12	3	localException2	Exception
    //   1	132	4	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   102	106	108	java/io/IOException
    //   55	67	115	finally
    //   69	75	115	finally
    //   88	102	115	finally
    //   55	67	123	java/lang/Exception
    //   69	75	123	java/lang/Exception
    //   88	102	123	java/lang/Exception
    //   7	15	127	finally
    //   17	24	127	finally
    //   26	32	127	finally
    //   34	41	127	finally
    //   43	55	127	finally
    //   137	148	127	finally
    //   7	15	131	java/lang/Exception
    //   17	24	131	java/lang/Exception
    //   26	32	131	java/lang/Exception
    //   34	41	131	java/lang/Exception
    //   43	55	131	java/lang/Exception
    //   152	156	159	java/io/IOException
    //   171	175	178	java/io/IOException
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ShadowRuntimeLoader_");
    localStringBuilder.append(getProcessName(paramContext));
    return localStringBuilder.toString();
  }
  
  static void hackParentClassLoader(ClassLoader paramClassLoader1, ClassLoader paramClassLoader2)
  {
    Field localField = getParentField();
    if (localField != null)
    {
      localField.setAccessible(true);
      localField.set(paramClassLoader1, paramClassLoader2);
      return;
    }
    throw new RuntimeException("在ClassLoader.class中没找到类型为ClassLoader的parent域");
  }
  
  private static void hackParentToRuntime(InstalledApk paramInstalledApk, ClassLoader paramClassLoader)
  {
    hackParentClassLoader(paramClassLoader, new DynamicRuntime.RuntimeClassLoader(paramInstalledApk.apkFilePath, paramInstalledApk.oDexPath, paramInstalledApk.libraryPath, paramClassLoader.getParent()));
  }
  
  public static boolean loadRuntime(InstalledApk paramInstalledApk)
  {
    ClassLoader localClassLoader = DynamicRuntime.class.getClassLoader();
    Object localObject = getRuntimeClassLoader();
    if (localObject != null)
    {
      localObject = DynamicRuntime.RuntimeClassLoader.access$000((DynamicRuntime.RuntimeClassLoader)localObject);
      if (mLogger.isInfoEnabled())
      {
        Logger localLogger = mLogger;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("last apkPath:");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(" new apkPath:");
        localStringBuilder.append(paramInstalledApk.apkFilePath);
        localLogger.info(localStringBuilder.toString());
      }
      if (TextUtils.equals((CharSequence)localObject, paramInstalledApk.apkFilePath))
      {
        if (mLogger.isInfoEnabled()) {
          mLogger.info("已经加载相同apkPath的runtime了,不需要加载");
        }
        return false;
      }
      if (mLogger.isInfoEnabled()) {
        mLogger.info("加载不相同apkPath的runtime了,先恢复classLoader树结构");
      }
      try
      {
        recoveryClassLoader();
      }
      catch (Exception paramInstalledApk)
      {
        throw new RuntimeException(paramInstalledApk);
      }
    }
    try
    {
      hackParentToRuntime(paramInstalledApk, localClassLoader);
      return true;
    }
    catch (Exception paramInstalledApk)
    {
      throw new RuntimeException(paramInstalledApk);
    }
  }
  
  private static void recoveryClassLoader()
  {
    Object localObject2 = DynamicRuntime.class.getClassLoader();
    ClassLoader localClassLoader;
    for (Object localObject1 = ((ClassLoader)localObject2).getParent(); localObject1 != null; localObject1 = localClassLoader)
    {
      if ((localObject1 instanceof DynamicRuntime.RuntimeClassLoader))
      {
        hackParentClassLoader((ClassLoader)localObject2, ((ClassLoader)localObject1).getParent());
        return;
      }
      localClassLoader = ((ClassLoader)localObject1).getParent();
      localObject2 = localObject1;
    }
  }
  
  public static boolean recoveryRuntime(Context paramContext)
  {
    InstalledApk localInstalledApk = getLastRuntimeInfo(paramContext);
    if ((localInstalledApk != null) && (new File(localInstalledApk.apkFilePath).exists()))
    {
      if ((localInstalledApk.oDexPath != null) && (!new File(localInstalledApk.oDexPath).exists())) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.shadow.dynamic.host.DynamicRuntime
 * JD-Core Version:    0.7.0.1
 */