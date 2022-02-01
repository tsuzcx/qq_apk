package com.tencent.mobileqq.pluginsdk;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;

public abstract class PluginStatic
{
  static final String CONTAINER_PACKAGE_NAME = "com.tencent.mobileqq";
  public static final String PARAM_CLASS_STATISTICS_UPLOADER = "clsUploader";
  @Deprecated
  public static final String PARAM_CLEAR_TOP = "cleartop";
  public static final String PARAM_EXTRA_INFO = "pluginsdk_extraInfo";
  static final String PARAM_IS_IN_PLUGIN = "pluginsdk_IsPluginActivity";
  public static final String PARAM_LAUNCH_ACTIVITY = "pluginsdk_launchActivity";
  public static final String PARAM_LAUNCH_SERVICE = "pluginsdk_launchService";
  public static final String PARAM_PATH = "pluginsdk_pluginpath";
  public static final String PARAM_PLUGIN_GESTURELOCK = "param_plugin_gesturelock";
  public static final String PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY = "PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY";
  public static final String PARAM_PLUGIN_LOCATION = "pluginsdk_pluginLocation";
  public static final String PARAM_PLUGIN_NAME = "pluginsdk_pluginName";
  public static final String PARAM_PLUGIN_RECEIVER_CLASS_NAME = "pluginsdk_launchReceiver";
  public static final String PARAM_UIN = "pluginsdk_selfuin";
  public static final String PARAM_USE_QQ_RESOURCES = "userQqResources";
  public static final String PARAM_USE_SKIN_ENGINE = "useSkinEngine";
  public static final int USER_QQ_RESOURCES_BOTH = 2;
  public static final int USER_QQ_RESOURCES_NO = -1;
  public static final int USER_QQ_RESOURCES_YES = 1;
  static final ConcurrentHashMap<String, DexClassLoader> sClassLoaderMap;
  static final ConcurrentHashMap<String, Long> sClassLoaderStartTimeMap = new ConcurrentHashMap();
  private static ArrayList<WeakReference<IPluginActivity>> sInstances = new ArrayList();
  private static final HashMap<String, PluginStatic.IPluginLife> sLife = new HashMap();
  public static final ConcurrentHashMap<String, PackageInfo> sPackageInfoMap;
  
  static
  {
    sClassLoaderMap = new ConcurrentHashMap();
    sPackageInfoMap = new ConcurrentHashMap();
  }
  
  static void add(IPluginActivity paramIPluginActivity)
  {
    
    synchronized (sInstances)
    {
      sInstances.add(new WeakReference(paramIPluginActivity));
      return;
    }
  }
  
  public static String byteArrayToHex(byte[] paramArrayOfByte)
  {
    int i = 0;
    char[] arrayOfChar1 = new char[16];
    char[] tmp10_8 = arrayOfChar1;
    tmp10_8[0] = 48;
    char[] tmp15_10 = tmp10_8;
    tmp15_10[1] = 49;
    char[] tmp20_15 = tmp15_10;
    tmp20_15[2] = 50;
    char[] tmp25_20 = tmp20_15;
    tmp25_20[3] = 51;
    char[] tmp30_25 = tmp25_20;
    tmp30_25[4] = 52;
    char[] tmp35_30 = tmp30_25;
    tmp35_30[5] = 53;
    char[] tmp40_35 = tmp35_30;
    tmp40_35[6] = 54;
    char[] tmp46_40 = tmp40_35;
    tmp46_40[7] = 55;
    char[] tmp52_46 = tmp46_40;
    tmp52_46[8] = 56;
    char[] tmp58_52 = tmp52_46;
    tmp58_52[9] = 57;
    char[] tmp64_58 = tmp58_52;
    tmp64_58[10] = 65;
    char[] tmp70_64 = tmp64_58;
    tmp70_64[11] = 66;
    char[] tmp76_70 = tmp70_64;
    tmp76_70[12] = 67;
    char[] tmp82_76 = tmp76_70;
    tmp82_76[13] = 68;
    char[] tmp88_82 = tmp82_76;
    tmp88_82[14] = 69;
    char[] tmp94_88 = tmp88_82;
    tmp94_88[15] = 70;
    tmp94_88;
    char[] arrayOfChar2 = new char[paramArrayOfByte.length * 2];
    int k = paramArrayOfByte.length;
    int j = 0;
    while (i < k)
    {
      int m = paramArrayOfByte[i];
      int n = j + 1;
      arrayOfChar2[j] = arrayOfChar1[(m >>> 4 & 0xF)];
      j = n + 1;
      arrayOfChar2[n] = arrayOfChar1[(m & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar2);
  }
  
  /* Error */
  public static String encodeFile(String paramString)
  {
    // Byte code:
    //   0: new 144	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 147	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: invokevirtual 151	java/io/File:exists	()Z
    //   13: ifeq +10 -> 23
    //   16: aload_0
    //   17: invokevirtual 154	java/io/File:isFile	()Z
    //   20: ifne +22 -> 42
    //   23: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   26: ifeq +11 -> 37
    //   29: ldc 161
    //   31: iconst_2
    //   32: ldc 163
    //   34: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   37: ldc 169
    //   39: astore_3
    //   40: aload_3
    //   41: areturn
    //   42: ldc 171
    //   44: invokestatic 177	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   47: astore 4
    //   49: new 179	java/io/FileInputStream
    //   52: dup
    //   53: aload_0
    //   54: invokespecial 182	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   57: astore_2
    //   58: aload_2
    //   59: astore_0
    //   60: sipush 16384
    //   63: newarray byte
    //   65: astore_3
    //   66: aload_2
    //   67: astore_0
    //   68: aload_2
    //   69: aload_3
    //   70: invokevirtual 186	java/io/FileInputStream:read	([B)I
    //   73: istore_1
    //   74: iload_1
    //   75: iconst_m1
    //   76: if_icmpeq +78 -> 154
    //   79: aload_2
    //   80: astore_0
    //   81: aload 4
    //   83: aload_3
    //   84: iconst_0
    //   85: iload_1
    //   86: invokevirtual 190	java/security/MessageDigest:update	([BII)V
    //   89: goto -23 -> 66
    //   92: astore_3
    //   93: aload_2
    //   94: astore_0
    //   95: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   98: ifeq +33 -> 131
    //   101: aload_2
    //   102: astore_0
    //   103: ldc 161
    //   105: iconst_2
    //   106: new 192	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   113: ldc 195
    //   115: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload_3
    //   119: invokestatic 203	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   122: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   131: aload_2
    //   132: ifnull +81 -> 213
    //   135: aload_2
    //   136: invokevirtual 210	java/io/FileInputStream:close	()V
    //   139: ldc 169
    //   141: areturn
    //   142: astore_0
    //   143: aload_2
    //   144: astore_0
    //   145: sipush 4096
    //   148: newarray byte
    //   150: astore_3
    //   151: goto -85 -> 66
    //   154: aload_2
    //   155: astore_0
    //   156: aload 4
    //   158: invokevirtual 214	java/security/MessageDigest:digest	()[B
    //   161: invokestatic 216	com/tencent/mobileqq/pluginsdk/PluginStatic:byteArrayToHex	([B)Ljava/lang/String;
    //   164: astore_3
    //   165: aload_3
    //   166: astore_0
    //   167: aload_0
    //   168: astore_3
    //   169: aload_2
    //   170: ifnull -130 -> 40
    //   173: aload_2
    //   174: invokevirtual 210	java/io/FileInputStream:close	()V
    //   177: aload_0
    //   178: areturn
    //   179: astore_2
    //   180: aload_0
    //   181: areturn
    //   182: astore_0
    //   183: ldc 169
    //   185: areturn
    //   186: astore_2
    //   187: aconst_null
    //   188: astore_0
    //   189: aload_0
    //   190: ifnull +7 -> 197
    //   193: aload_0
    //   194: invokevirtual 210	java/io/FileInputStream:close	()V
    //   197: aload_2
    //   198: athrow
    //   199: astore_0
    //   200: goto -3 -> 197
    //   203: astore_2
    //   204: goto -15 -> 189
    //   207: astore_3
    //   208: aconst_null
    //   209: astore_2
    //   210: goto -117 -> 93
    //   213: ldc 169
    //   215: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	216	0	paramString	String
    //   73	13	1	i	int
    //   57	117	2	localFileInputStream	java.io.FileInputStream
    //   179	1	2	localIOException	java.io.IOException
    //   186	12	2	localObject1	Object
    //   203	1	2	localObject2	Object
    //   209	1	2	localObject3	Object
    //   39	45	3	localObject4	Object
    //   92	27	3	localException1	Exception
    //   150	19	3	localObject5	Object
    //   207	1	3	localException2	Exception
    //   47	110	4	localMessageDigest	java.security.MessageDigest
    // Exception table:
    //   from	to	target	type
    //   60	66	92	java/lang/Exception
    //   68	74	92	java/lang/Exception
    //   81	89	92	java/lang/Exception
    //   145	151	92	java/lang/Exception
    //   156	165	92	java/lang/Exception
    //   60	66	142	java/lang/OutOfMemoryError
    //   173	177	179	java/io/IOException
    //   135	139	182	java/io/IOException
    //   42	58	186	finally
    //   193	197	199	java/io/IOException
    //   60	66	203	finally
    //   68	74	203	finally
    //   81	89	203	finally
    //   95	101	203	finally
    //   103	131	203	finally
    //   145	151	203	finally
    //   156	165	203	finally
    //   42	58	207	java/lang/Exception
  }
  
  static List<WeakReference<IPluginActivity>> getActivitys()
  {
    return sInstances;
  }
  
  public static ClassLoader getClassLoader(String paramString)
  {
    try
    {
      paramString = (DexClassLoader)sClassLoaderMap.get(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static ClassLoader getOrCreateClassLoader(Context paramContext, String paramString)
  {
    try
    {
      paramContext = getOrCreateClassLoaderAsModule(paramContext, paramString, true);
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static ClassLoader getOrCreateClassLoaderAsModule(Context paramContext, String paramString, boolean paramBoolean)
  {
    try
    {
      ClassLoader localClassLoader2 = (ClassLoader)sClassLoaderMap.get(paramString);
      ClassLoader localClassLoader1 = localClassLoader2;
      if (localClassLoader2 == null) {
        localClassLoader1 = getOrCreateClassLoaderByPath(paramContext, paramString, PluginUtils.getInstalledPluginPath(paramContext, paramString).getCanonicalPath(), paramBoolean);
      }
      return localClassLoader1;
    }
    finally {}
  }
  
  /* Error */
  static ClassLoader getOrCreateClassLoaderByPath(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 87	com/tencent/mobileqq/pluginsdk/PluginStatic:sClassLoaderMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   6: aload_1
    //   7: invokevirtual 226	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast 228	dalvik/system/DexClassLoader
    //   13: astore 9
    //   15: aload 9
    //   17: astore 8
    //   19: aload 9
    //   21: ifnonnull +305 -> 326
    //   24: aload_0
    //   25: invokestatic 255	com/tencent/mobileqq/pluginsdk/PluginUtils:getPluginInstallDir	(Landroid/content/Context;)Ljava/io/File;
    //   28: aload_1
    //   29: invokestatic 259	com/tencent/mobileqq/pluginsdk/PluginUtils:getPluginCfgFile	(Ljava/io/File;Ljava/lang/String;)Ljava/io/File;
    //   32: ldc_w 261
    //   35: invokestatic 267	com/tencent/mobileqq/pluginsdk/PluginBaseInfoHelper:createFromFile	(Ljava/io/File;Ljava/lang/Class;)Lcom/tencent/mobileqq/pluginsdk/PluginBaseInfo;
    //   38: astore 8
    //   40: invokestatic 273	com/tencent/mobileqq/pluginsdk/IPluginAdapterProxy:getProxy	()Lcom/tencent/mobileqq/pluginsdk/IPluginAdapterProxy;
    //   43: aload_1
    //   44: aload 8
    //   46: invokevirtual 277	com/tencent/mobileqq/pluginsdk/IPluginAdapterProxy:isBuiltinPluginAndUpToDay	(Ljava/lang/String;Lcom/tencent/mobileqq/pluginsdk/PluginBaseInfo;)Z
    //   49: pop
    //   50: ldc 161
    //   52: iconst_1
    //   53: new 192	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   60: ldc_w 279
    //   63: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload_1
    //   67: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 282	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: invokestatic 288	java/lang/System:currentTimeMillis	()J
    //   79: lstore 4
    //   81: aload_0
    //   82: invokestatic 291	com/tencent/mobileqq/pluginsdk/PluginUtils:getOptimizedDexPath	(Landroid/content/Context;)Ljava/io/File;
    //   85: invokevirtual 245	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   88: astore 9
    //   90: aload_0
    //   91: aload_1
    //   92: invokestatic 294	com/tencent/mobileqq/pluginsdk/PluginUtils:getPluginLibPath	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   95: invokevirtual 245	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   98: astore 10
    //   100: aload_2
    //   101: ldc_w 296
    //   104: invokevirtual 300	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   107: ifeq +225 -> 332
    //   110: new 302	com/tencent/commonsdk/soload/SoDexClassLoader
    //   113: dup
    //   114: aload_2
    //   115: aload 9
    //   117: aload 10
    //   119: aload_0
    //   120: invokevirtual 307	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   123: invokespecial 310	com/tencent/commonsdk/soload/SoDexClassLoader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   126: astore 8
    //   128: getstatic 89	com/tencent/mobileqq/pluginsdk/PluginStatic:sPackageInfoMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   131: aload_2
    //   132: invokevirtual 226	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   135: checkcast 312	android/content/pm/PackageInfo
    //   138: astore 10
    //   140: aload 10
    //   142: astore 9
    //   144: aload 10
    //   146: ifnonnull +61 -> 207
    //   149: aload_0
    //   150: aload_2
    //   151: sipush 129
    //   154: invokestatic 318	com/tencent/mobileqq/pluginsdk/ApkFileParser:getPackageInfoWithException	(Landroid/content/Context;Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   157: astore_0
    //   158: aload_0
    //   159: ifnonnull +36 -> 195
    //   162: new 192	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   169: ldc_w 320
    //   172: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: new 144	java/io/File
    //   178: dup
    //   179: aload_2
    //   180: invokespecial 147	java/io/File:<init>	(Ljava/lang/String;)V
    //   183: invokevirtual 151	java/io/File:exists	()Z
    //   186: invokevirtual 323	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   189: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: invokestatic 328	com/tencent/mobileqq/pluginsdk/DebugHelper:log	(Ljava/lang/String;)V
    //   195: getstatic 89	com/tencent/mobileqq/pluginsdk/PluginStatic:sPackageInfoMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   198: aload_2
    //   199: aload_0
    //   200: invokevirtual 332	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   203: pop
    //   204: aload_0
    //   205: astore 9
    //   207: getstatic 91	com/tencent/mobileqq/pluginsdk/PluginStatic:sClassLoaderStartTimeMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   210: aload_1
    //   211: invokevirtual 226	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   214: checkcast 334	java/lang/Long
    //   217: astore 10
    //   219: aload 10
    //   221: astore_0
    //   222: aload 10
    //   224: ifnonnull +22 -> 246
    //   227: invokestatic 288	java/lang/System:currentTimeMillis	()J
    //   230: lload 4
    //   232: lsub
    //   233: invokestatic 338	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   236: astore_0
    //   237: getstatic 91	com/tencent/mobileqq/pluginsdk/PluginStatic:sClassLoaderStartTimeMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   240: aload_1
    //   241: aload_0
    //   242: invokevirtual 332	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   245: pop
    //   246: getstatic 89	com/tencent/mobileqq/pluginsdk/PluginStatic:sPackageInfoMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   249: aload_2
    //   250: aload 9
    //   252: invokevirtual 332	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   255: pop
    //   256: aload 9
    //   258: ifnull +11 -> 269
    //   261: aload 9
    //   263: aload_1
    //   264: aload 8
    //   266: invokestatic 342	com/tencent/mobileqq/pluginsdk/PluginStatic:invokePluginLife	(Landroid/content/pm/PackageInfo;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   269: ldc 161
    //   271: iconst_1
    //   272: new 192	java/lang/StringBuilder
    //   275: dup
    //   276: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   279: ldc_w 344
    //   282: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: aload_1
    //   286: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: ldc_w 346
    //   292: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: aload_0
    //   296: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   299: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   302: invokestatic 352	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   305: iload_3
    //   306: ifeq +10 -> 316
    //   309: getstatic 358	mqq/app/MobileQQ:sMobileQQ	Lmqq/app/MobileQQ;
    //   312: aload_1
    //   313: invokevirtual 361	mqq/app/MobileQQ:loadModule	(Ljava/lang/String;)V
    //   316: getstatic 87	com/tencent/mobileqq/pluginsdk/PluginStatic:sClassLoaderMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   319: aload_1
    //   320: aload 8
    //   322: invokevirtual 332	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   325: pop
    //   326: ldc 2
    //   328: monitorexit
    //   329: aload 8
    //   331: areturn
    //   332: aload_1
    //   333: ldc_w 363
    //   336: invokevirtual 366	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   339: ifeq +73 -> 412
    //   342: invokestatic 288	java/lang/System:currentTimeMillis	()J
    //   345: lstore 6
    //   347: aload_0
    //   348: ldc_w 368
    //   351: invokestatic 370	com/tencent/mobileqq/pluginsdk/PluginStatic:getOrCreateClassLoader	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/ClassLoader;
    //   354: astore 8
    //   356: ldc 161
    //   358: iconst_1
    //   359: new 192	java/lang/StringBuilder
    //   362: dup
    //   363: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   366: ldc_w 372
    //   369: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: invokestatic 288	java/lang/System:currentTimeMillis	()J
    //   375: lload 6
    //   377: lsub
    //   378: invokevirtual 375	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   381: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   384: invokestatic 282	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   387: new 377	com/tencent/mobileqq/pluginsdk/QZoneLiveClassLoader
    //   390: dup
    //   391: aload_2
    //   392: aload 9
    //   394: aload 10
    //   396: aload 8
    //   398: invokespecial 378	com/tencent/mobileqq/pluginsdk/QZoneLiveClassLoader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   401: astore 8
    //   403: goto -275 -> 128
    //   406: astore_0
    //   407: ldc 2
    //   409: monitorexit
    //   410: aload_0
    //   411: athrow
    //   412: aload_1
    //   413: ldc_w 380
    //   416: invokevirtual 366	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   419: ifeq +67 -> 486
    //   422: invokestatic 288	java/lang/System:currentTimeMillis	()J
    //   425: lstore 6
    //   427: aload_0
    //   428: ldc_w 368
    //   431: invokestatic 370	com/tencent/mobileqq/pluginsdk/PluginStatic:getOrCreateClassLoader	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/ClassLoader;
    //   434: astore 8
    //   436: ldc 161
    //   438: iconst_1
    //   439: new 192	java/lang/StringBuilder
    //   442: dup
    //   443: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   446: ldc_w 372
    //   449: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: invokestatic 288	java/lang/System:currentTimeMillis	()J
    //   455: lload 6
    //   457: lsub
    //   458: invokevirtual 375	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   461: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   464: invokestatic 282	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   467: new 382	com/tencent/mobileqq/pluginsdk/QZoneVerticalVideoClassLoader
    //   470: dup
    //   471: aload_2
    //   472: aload 9
    //   474: aload 10
    //   476: aload 8
    //   478: invokespecial 383	com/tencent/mobileqq/pluginsdk/QZoneVerticalVideoClassLoader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   481: astore 8
    //   483: goto -355 -> 128
    //   486: aload_1
    //   487: ldc_w 385
    //   490: invokevirtual 366	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   493: ifeq +67 -> 560
    //   496: invokestatic 288	java/lang/System:currentTimeMillis	()J
    //   499: lstore 6
    //   501: aload_0
    //   502: ldc_w 368
    //   505: invokestatic 370	com/tencent/mobileqq/pluginsdk/PluginStatic:getOrCreateClassLoader	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/ClassLoader;
    //   508: astore 8
    //   510: ldc 161
    //   512: iconst_1
    //   513: new 192	java/lang/StringBuilder
    //   516: dup
    //   517: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   520: ldc_w 372
    //   523: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   526: invokestatic 288	java/lang/System:currentTimeMillis	()J
    //   529: lload 6
    //   531: lsub
    //   532: invokevirtual 375	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   535: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   538: invokestatic 282	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   541: new 387	com/tencent/mobileqq/pluginsdk/QZoneWeishiFeedsClassLoader
    //   544: dup
    //   545: aload_2
    //   546: aload 9
    //   548: aload 10
    //   550: aload 8
    //   552: invokespecial 388	com/tencent/mobileqq/pluginsdk/QZoneWeishiFeedsClassLoader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   555: astore 8
    //   557: goto -429 -> 128
    //   560: aload_2
    //   561: ifnull +65 -> 626
    //   564: new 144	java/io/File
    //   567: dup
    //   568: aload_2
    //   569: invokespecial 147	java/io/File:<init>	(Ljava/lang/String;)V
    //   572: invokevirtual 151	java/io/File:exists	()Z
    //   575: ifne +51 -> 626
    //   578: ldc 161
    //   580: iconst_1
    //   581: new 192	java/lang/StringBuilder
    //   584: dup
    //   585: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   588: ldc_w 390
    //   591: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   594: aload_2
    //   595: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   601: invokestatic 282	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   604: new 228	dalvik/system/DexClassLoader
    //   607: dup
    //   608: ldc 169
    //   610: aload 9
    //   612: aload 10
    //   614: aload_0
    //   615: invokevirtual 307	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   618: invokespecial 391	dalvik/system/DexClassLoader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   621: astore 8
    //   623: goto -297 -> 326
    //   626: invokestatic 394	com/tencent/mobileqq/pluginsdk/PluginUtils:isOsNeedReleaseDex	()Z
    //   629: ifeq +150 -> 779
    //   632: invokestatic 273	com/tencent/mobileqq/pluginsdk/IPluginAdapterProxy:getProxy	()Lcom/tencent/mobileqq/pluginsdk/IPluginAdapterProxy;
    //   635: aload_1
    //   636: invokevirtual 397	com/tencent/mobileqq/pluginsdk/IPluginAdapterProxy:isSupportMultiDex	(Ljava/lang/String;)Z
    //   639: ifeq +140 -> 779
    //   642: aload_0
    //   643: aload_1
    //   644: invokestatic 400	com/tencent/mobileqq/pluginsdk/PluginUtils:getMultiDexSecondDex	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   647: astore 8
    //   649: aload 8
    //   651: invokevirtual 151	java/io/File:exists	()Z
    //   654: ifeq +125 -> 779
    //   657: new 192	java/lang/StringBuilder
    //   660: dup
    //   661: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   664: aload_2
    //   665: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: getstatic 403	java/io/File:pathSeparator	Ljava/lang/String;
    //   671: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   674: aload 8
    //   676: invokevirtual 406	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   679: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   682: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   685: astore 8
    //   687: ldc 161
    //   689: iconst_1
    //   690: new 192	java/lang/StringBuilder
    //   693: dup
    //   694: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   697: ldc_w 408
    //   700: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   703: aload 8
    //   705: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   708: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   711: invokestatic 282	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   714: ldc 161
    //   716: iconst_1
    //   717: new 192	java/lang/StringBuilder
    //   720: dup
    //   721: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   724: ldc_w 410
    //   727: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   730: aload 8
    //   732: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   735: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   738: invokestatic 282	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   741: new 228	dalvik/system/DexClassLoader
    //   744: dup
    //   745: aload 8
    //   747: aload 9
    //   749: aload 10
    //   751: aload_0
    //   752: invokevirtual 307	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   755: invokespecial 391	dalvik/system/DexClassLoader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   758: astore 8
    //   760: goto -632 -> 128
    //   763: astore_0
    //   764: ldc 161
    //   766: ldc_w 412
    //   769: aload_0
    //   770: invokestatic 415	com/tencent/mobileqq/pluginsdk/DebugHelper:log	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   773: aload 10
    //   775: astore_0
    //   776: goto -618 -> 158
    //   779: aload_2
    //   780: astore 8
    //   782: goto -68 -> 714
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	785	0	paramContext	Context
    //   0	785	1	paramString1	String
    //   0	785	2	paramString2	String
    //   0	785	3	paramBoolean	boolean
    //   79	152	4	l1	long
    //   345	185	6	l2	long
    //   17	764	8	localObject1	Object
    //   13	735	9	localObject2	Object
    //   98	676	10	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   3	15	406	finally
    //   24	128	406	finally
    //   128	140	406	finally
    //   149	158	406	finally
    //   162	195	406	finally
    //   195	204	406	finally
    //   207	219	406	finally
    //   227	246	406	finally
    //   246	256	406	finally
    //   261	269	406	finally
    //   269	305	406	finally
    //   309	316	406	finally
    //   316	326	406	finally
    //   332	403	406	finally
    //   412	483	406	finally
    //   486	557	406	finally
    //   564	623	406	finally
    //   626	714	406	finally
    //   714	760	406	finally
    //   764	773	406	finally
    //   149	158	763	java/lang/Throwable
  }
  
  static void invokePluginLife(PackageInfo paramPackageInfo, String paramString, ClassLoader paramClassLoader)
  {
    try
    {
      if ((PluginStatic.IPluginLife)sLife.get(paramString) != null) {
        return;
      }
      if ((paramPackageInfo != null) && (paramPackageInfo.applicationInfo != null) && (paramPackageInfo.applicationInfo.metaData != null))
      {
        paramPackageInfo = paramPackageInfo.applicationInfo.metaData.getString("PLUGIN_LIFE_CLASS");
        if (paramPackageInfo != null)
        {
          paramPackageInfo = (PluginStatic.IPluginLife)paramClassLoader.loadClass(paramPackageInfo).newInstance();
          sLife.put(paramString, paramPackageInfo);
          paramPackageInfo.onLoad();
          return;
        }
      }
    }
    catch (Throwable paramPackageInfo) {}
  }
  
  public static List<Boolean> isProcessesExist(Context paramContext, List<String> paramList)
  {
    ArrayList localArrayList = null;
    if (paramList != null)
    {
      localArrayList = new ArrayList();
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
      if (paramContext == null)
      {
        int i = 0;
        while (i < paramList.size())
        {
          localArrayList.add(Boolean.FALSE);
          i += 1;
        }
      }
    }
    else
    {
      return localArrayList;
    }
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      String str = (String)paramList.next();
      Iterator localIterator = paramContext.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (!str.equalsIgnoreCase(((ActivityManager.RunningAppProcessInfo)localIterator.next()).processName));
      for (boolean bool = true;; bool = false)
      {
        localArrayList.add(Boolean.valueOf(bool));
        break;
      }
    }
    return localArrayList;
  }
  
  private static boolean isSubFile(String paramString, File paramFile)
  {
    paramFile = paramFile.getCanonicalPath();
    String str = new File(paramString).getParentFile().getCanonicalPath();
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "path:" + paramString + "-> [" + str + ", " + paramFile + "]");
    }
    return str.equals(paramFile);
  }
  
  static boolean isValidPluginIntent(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    for (;;)
    {
      return false;
      try
      {
        String str = paramBundle.getString("pluginsdk_pluginLocation");
        if ((!TextUtils.isEmpty(str)) && (!str.substring(0, str.lastIndexOf(".")).contains(".")) && (!TextUtils.isEmpty(paramBundle.getString("pluginsdk_pluginName"))))
        {
          paramBundle = paramBundle.getString("pluginsdk_pluginpath");
          if (!TextUtils.isEmpty(paramBundle))
          {
            if (TextUtils.isEmpty(paramBundle)) {
              return true;
            }
            boolean bool = isValidPluginPath(paramBundle);
            return bool;
          }
        }
      }
      catch (Throwable paramBundle) {}
    }
    return false;
  }
  
  static boolean isValidPluginPath(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (paramString.contains("..")) {
        return bool1;
      }
      if (paramString.endsWith(".so"))
      {
        String str = MobileQQ.getContext().getFilesDir().getParent();
        File localFile = new File(str + "/txlib/");
        if ((isSubFile(paramString, new File(str + "/lib/"))) || (!isSubFile(paramString, localFile))) {}
      }
      else
      {
        bool1 = bool2;
        if (!paramString.endsWith(".apk")) {
          return bool1;
        }
        bool1 = isSubFile(paramString, PluginUtils.getPluginInstallDir(MobileQQ.getContext()));
        return bool1;
      }
    }
    catch (Exception paramString)
    {
      return false;
    }
    bool1 = true;
    return bool1;
  }
  
  static void remove(IPluginActivity paramIPluginActivity)
  {
    updateReference();
    removeActivity(paramIPluginActivity);
  }
  
  private static boolean removeActivity(IPluginActivity paramIPluginActivity)
  {
    ArrayList localArrayList = sInstances;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < sInstances.size())
        {
          if (((WeakReference)sInstances.get(i)).get() == paramIPluginActivity)
          {
            sInstances.remove(i);
            return true;
          }
        }
        else {
          return false;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  public static ClassLoader removeClassLoader(String paramString)
  {
    try
    {
      QLog.d("plugin_tag", 1, "removeClassLoader:" + paramString);
      paramString = (ClassLoader)sClassLoaderMap.remove(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  static void updateReference()
  {
    ArrayList localArrayList = sInstances;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < sInstances.size())
        {
          if (((WeakReference)sInstances.get(i)).get() == null)
          {
            sInstances.remove(i);
            i -= 1;
          }
        }
        else {
          return;
        }
      }
      finally {}
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginStatic
 * JD-Core Version:    0.7.0.1
 */