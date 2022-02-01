package com.tencent.shadow.dynamic.host;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import com.tencent.shadow.core.common.InstalledApk;
import com.tencent.shadow.core.common.Logger;
import com.tencent.shadow.core.common.LoggerFactory;
import com.tencent.shadow.proguard.g;
import java.io.File;
import java.lang.reflect.Field;

public class DynamicRuntime
{
  private static final Logger a = LoggerFactory.getLogger(DynamicRuntime.class);
  
  private static void a()
  {
    Object localObject2 = DynamicRuntime.class.getClassLoader();
    ClassLoader localClassLoader;
    for (Object localObject1 = ((ClassLoader)localObject2).getParent();; localObject1 = localClassLoader)
    {
      if (localObject1 != null)
      {
        if ((localObject1 instanceof g)) {
          a((ClassLoader)localObject2, ((ClassLoader)localObject1).getParent());
        }
      }
      else {
        return;
      }
      localClassLoader = ((ClassLoader)localObject1).getParent();
      localObject2 = localObject1;
    }
  }
  
  private static void a(InstalledApk paramInstalledApk, ClassLoader paramClassLoader)
  {
    long l2 = System.currentTimeMillis();
    paramInstalledApk = new g(paramInstalledApk.apkFilePath, paramInstalledApk.oDexPath, paramInstalledApk.libraryPath, paramClassLoader.getParent());
    long l1 = System.currentTimeMillis();
    Log.i("DynamicRuntime", "createRuntime cost = " + (l1 - l2));
    a(paramClassLoader, paramInstalledApk);
    l2 = System.currentTimeMillis();
    Log.i("DynamicRuntime", "hackruntime cost = " + (l2 - l1));
  }
  
  static void a(ClassLoader paramClassLoader1, ClassLoader paramClassLoader2)
  {
    Field localField = b();
    if (localField == null) {
      throw new RuntimeException("在ClassLoader.class中没找到类型为ClassLoader的parent域");
    }
    localField.setAccessible(true);
    localField.set(paramClassLoader1, paramClassLoader2);
  }
  
  private static Field b()
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
  public static boolean loadRuntime(InstalledApk paramInstalledApk)
  {
    // Byte code:
    //   0: ldc 2
    //   2: invokevirtual 26	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   5: astore_2
    //   6: ldc 2
    //   8: invokevirtual 26	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   11: invokevirtual 31	java/lang/ClassLoader:getParent	()Ljava/lang/ClassLoader;
    //   14: astore_1
    //   15: aload_1
    //   16: ifnull +113 -> 129
    //   19: aload_1
    //   20: instanceof 33
    //   23: ifeq +98 -> 121
    //   26: aload_1
    //   27: checkcast 33	com/tencent/shadow/proguard/g
    //   30: astore_1
    //   31: aload_1
    //   32: ifnull +126 -> 158
    //   35: aload_1
    //   36: invokestatic 123	com/tencent/shadow/proguard/g:a	(Lcom/tencent/shadow/proguard/g;)Ljava/lang/String;
    //   39: astore_1
    //   40: getstatic 16	com/tencent/shadow/dynamic/host/DynamicRuntime:a	Lcom/tencent/shadow/core/common/Logger;
    //   43: invokeinterface 128 1 0
    //   48: ifeq +39 -> 87
    //   51: getstatic 16	com/tencent/shadow/dynamic/host/DynamicRuntime:a	Lcom/tencent/shadow/core/common/Logger;
    //   54: new 62	java/lang/StringBuilder
    //   57: dup
    //   58: ldc 130
    //   60: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   63: aload_1
    //   64: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: ldc 135
    //   69: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: aload_0
    //   73: getfield 49	com/tencent/shadow/core/common/InstalledApk:apkFilePath	Ljava/lang/String;
    //   76: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokeinterface 138 2 0
    //   87: aload_1
    //   88: aload_0
    //   89: getfield 49	com/tencent/shadow/core/common/InstalledApk:apkFilePath	Ljava/lang/String;
    //   92: invokestatic 144	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   95: ifeq +39 -> 134
    //   98: getstatic 16	com/tencent/shadow/dynamic/host/DynamicRuntime:a	Lcom/tencent/shadow/core/common/Logger;
    //   101: invokeinterface 128 1 0
    //   106: ifeq +13 -> 119
    //   109: getstatic 16	com/tencent/shadow/dynamic/host/DynamicRuntime:a	Lcom/tencent/shadow/core/common/Logger;
    //   112: ldc 146
    //   114: invokeinterface 138 2 0
    //   119: iconst_0
    //   120: ireturn
    //   121: aload_1
    //   122: invokevirtual 31	java/lang/ClassLoader:getParent	()Ljava/lang/ClassLoader;
    //   125: astore_1
    //   126: goto -111 -> 15
    //   129: aconst_null
    //   130: astore_1
    //   131: goto -100 -> 31
    //   134: getstatic 16	com/tencent/shadow/dynamic/host/DynamicRuntime:a	Lcom/tencent/shadow/core/common/Logger;
    //   137: invokeinterface 128 1 0
    //   142: ifeq +13 -> 155
    //   145: getstatic 16	com/tencent/shadow/dynamic/host/DynamicRuntime:a	Lcom/tencent/shadow/core/common/Logger;
    //   148: ldc 148
    //   150: invokeinterface 138 2 0
    //   155: invokestatic 150	com/tencent/shadow/dynamic/host/DynamicRuntime:a	()V
    //   158: aload_0
    //   159: aload_2
    //   160: invokestatic 152	com/tencent/shadow/dynamic/host/DynamicRuntime:a	(Lcom/tencent/shadow/core/common/InstalledApk;Ljava/lang/ClassLoader;)V
    //   163: iconst_1
    //   164: ireturn
    //   165: astore_0
    //   166: new 89	java/lang/RuntimeException
    //   169: dup
    //   170: aload_0
    //   171: invokespecial 155	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   174: athrow
    //   175: astore_0
    //   176: new 89	java/lang/RuntimeException
    //   179: dup
    //   180: aload_0
    //   181: invokespecial 155	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   184: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	paramInstalledApk	InstalledApk
    //   14	117	1	localObject	Object
    //   5	155	2	localClassLoader	ClassLoader
    // Exception table:
    //   from	to	target	type
    //   155	158	165	java/lang/Exception
    //   158	163	175	java/lang/Exception
  }
  
  public static boolean recoveryRuntime(Context paramContext)
  {
    InstalledApk localInstalledApk = null;
    long l1 = System.currentTimeMillis();
    Object localObject = paramContext.getSharedPreferences("ShadowRuntimeLoader", 0);
    String str1 = ((SharedPreferences)localObject).getString("KEY_RUNTIME_APK", null);
    String str2 = ((SharedPreferences)localObject).getString("KEY_RUNTIME_ODEX", null);
    localObject = ((SharedPreferences)localObject).getString("KEY_RUNTIME_LIB", null);
    if (str1 == null) {}
    for (;;)
    {
      long l2 = System.currentTimeMillis();
      Log.i("DynamicRuntime", "getLastRuntime cost = " + (l2 - l1));
      if ((localInstalledApk == null) || (!new File(localInstalledApk.apkFilePath).exists())) {
        break label230;
      }
      if ((localInstalledApk.oDexPath == null) || (new File(localInstalledApk.oDexPath).exists())) {
        break;
      }
      return false;
      localInstalledApk = new InstalledApk(str1, str2, (String)localObject);
    }
    try
    {
      a(localInstalledApk, DynamicRuntime.class.getClassLoader());
      return true;
    }
    catch (Exception localException)
    {
      if (a.isErrorEnabled()) {
        a.error("recoveryRuntime 错误", localException);
      }
      paramContext.getSharedPreferences("ShadowRuntimeLoader", 0).edit().remove("KEY_RUNTIME_APK").remove("KEY_RUNTIME_ODEX").remove("KEY_RUNTIME_LIB").commit();
    }
    label230:
    return false;
  }
  
  public static void saveLastRuntimeInfo(Context paramContext, InstalledApk paramInstalledApk)
  {
    paramContext.getSharedPreferences("ShadowRuntimeLoader", 0).edit().putString("KEY_RUNTIME_APK", paramInstalledApk.apkFilePath).putString("KEY_RUNTIME_ODEX", paramInstalledApk.oDexPath).putString("KEY_RUNTIME_LIB", paramInstalledApk.libraryPath).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.shadow.dynamic.host.DynamicRuntime
 * JD-Core Version:    0.7.0.1
 */