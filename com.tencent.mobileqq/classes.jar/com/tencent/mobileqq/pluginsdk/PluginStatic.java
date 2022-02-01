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
  static final ConcurrentHashMap<String, PackageInfo> sPackageInfoMap;
  
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
      ClassLoader localClassLoader2 = (ClassLoader)sClassLoaderMap.get(paramString);
      ClassLoader localClassLoader1 = localClassLoader2;
      if (localClassLoader2 == null) {
        localClassLoader1 = getOrCreateClassLoaderByPath(paramContext, paramString, PluginUtils.getInstalledPluginPath(paramContext, paramString).getCanonicalPath());
      }
      return localClassLoader1;
    }
    finally {}
  }
  
  /* Error */
  static ClassLoader getOrCreateClassLoaderByPath(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 87	com/tencent/mobileqq/pluginsdk/PluginStatic:sClassLoaderMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   6: aload_1
    //   7: invokevirtual 226	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast 228	dalvik/system/DexClassLoader
    //   13: astore 8
    //   15: aload 8
    //   17: astore 7
    //   19: aload 8
    //   21: ifnonnull +299 -> 320
    //   24: aload_0
    //   25: invokestatic 251	com/tencent/mobileqq/pluginsdk/PluginUtils:getPluginInstallDir	(Landroid/content/Context;)Ljava/io/File;
    //   28: aload_1
    //   29: invokestatic 255	com/tencent/mobileqq/pluginsdk/PluginUtils:getPluginCfgFile	(Ljava/io/File;Ljava/lang/String;)Ljava/io/File;
    //   32: ldc_w 257
    //   35: invokestatic 263	com/tencent/mobileqq/pluginsdk/PluginBaseInfoHelper:createFromFile	(Ljava/io/File;Ljava/lang/Class;)Lcom/tencent/mobileqq/pluginsdk/PluginBaseInfo;
    //   38: astore 7
    //   40: invokestatic 269	com/tencent/mobileqq/pluginsdk/IPluginAdapterProxy:getProxy	()Lcom/tencent/mobileqq/pluginsdk/IPluginAdapterProxy;
    //   43: aload_1
    //   44: aload 7
    //   46: invokevirtual 273	com/tencent/mobileqq/pluginsdk/IPluginAdapterProxy:isBuiltinPluginAndUpToDay	(Ljava/lang/String;Lcom/tencent/mobileqq/pluginsdk/PluginBaseInfo;)Z
    //   49: pop
    //   50: ldc 161
    //   52: iconst_1
    //   53: new 192	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   60: ldc_w 275
    //   63: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload_1
    //   67: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 278	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: invokestatic 284	java/lang/System:currentTimeMillis	()J
    //   79: lstore_3
    //   80: aload_0
    //   81: invokestatic 287	com/tencent/mobileqq/pluginsdk/PluginUtils:getOptimizedDexPath	(Landroid/content/Context;)Ljava/io/File;
    //   84: invokevirtual 241	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   87: astore 8
    //   89: aload_0
    //   90: aload_1
    //   91: invokestatic 290	com/tencent/mobileqq/pluginsdk/PluginUtils:getPluginLibPath	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   94: invokevirtual 241	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   97: astore 9
    //   99: aload_2
    //   100: ldc_w 292
    //   103: invokevirtual 296	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   106: ifeq +220 -> 326
    //   109: new 298	com/tencent/commonsdk/soload/SoDexClassLoader
    //   112: dup
    //   113: aload_2
    //   114: aload 8
    //   116: aload 9
    //   118: aload_0
    //   119: invokevirtual 303	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   122: invokespecial 306	com/tencent/commonsdk/soload/SoDexClassLoader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   125: astore 7
    //   127: getstatic 89	com/tencent/mobileqq/pluginsdk/PluginStatic:sPackageInfoMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   130: aload_2
    //   131: invokevirtual 226	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   134: checkcast 308	android/content/pm/PackageInfo
    //   137: astore 9
    //   139: aload 9
    //   141: astore 8
    //   143: aload 9
    //   145: ifnonnull +61 -> 206
    //   148: aload_0
    //   149: aload_2
    //   150: sipush 129
    //   153: invokestatic 314	com/tencent/mobileqq/pluginsdk/ApkFileParser:getPackageInfoWithException	(Landroid/content/Context;Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   156: astore_0
    //   157: aload_0
    //   158: ifnonnull +36 -> 194
    //   161: new 192	java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   168: ldc_w 316
    //   171: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: new 144	java/io/File
    //   177: dup
    //   178: aload_2
    //   179: invokespecial 147	java/io/File:<init>	(Ljava/lang/String;)V
    //   182: invokevirtual 151	java/io/File:exists	()Z
    //   185: invokevirtual 319	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   188: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: invokestatic 324	com/tencent/mobileqq/pluginsdk/DebugHelper:log	(Ljava/lang/String;)V
    //   194: getstatic 89	com/tencent/mobileqq/pluginsdk/PluginStatic:sPackageInfoMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   197: aload_2
    //   198: aload_0
    //   199: invokevirtual 328	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   202: pop
    //   203: aload_0
    //   204: astore 8
    //   206: getstatic 91	com/tencent/mobileqq/pluginsdk/PluginStatic:sClassLoaderStartTimeMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   209: aload_1
    //   210: invokevirtual 226	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   213: checkcast 330	java/lang/Long
    //   216: astore 9
    //   218: aload 9
    //   220: astore_0
    //   221: aload 9
    //   223: ifnonnull +21 -> 244
    //   226: invokestatic 284	java/lang/System:currentTimeMillis	()J
    //   229: lload_3
    //   230: lsub
    //   231: invokestatic 334	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   234: astore_0
    //   235: getstatic 91	com/tencent/mobileqq/pluginsdk/PluginStatic:sClassLoaderStartTimeMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   238: aload_1
    //   239: aload_0
    //   240: invokevirtual 328	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   243: pop
    //   244: getstatic 89	com/tencent/mobileqq/pluginsdk/PluginStatic:sPackageInfoMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   247: aload_2
    //   248: aload 8
    //   250: invokevirtual 328	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   253: pop
    //   254: aload 8
    //   256: ifnull +11 -> 267
    //   259: aload 8
    //   261: aload_1
    //   262: aload 7
    //   264: invokestatic 338	com/tencent/mobileqq/pluginsdk/PluginStatic:invokePluginLife	(Landroid/content/pm/PackageInfo;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   267: ldc 161
    //   269: iconst_1
    //   270: new 192	java/lang/StringBuilder
    //   273: dup
    //   274: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   277: ldc_w 340
    //   280: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: aload_1
    //   284: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: ldc_w 342
    //   290: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: aload_0
    //   294: invokevirtual 345	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   297: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   300: invokestatic 348	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   303: getstatic 354	mqq/app/MobileQQ:sMobileQQ	Lmqq/app/MobileQQ;
    //   306: aload_1
    //   307: invokevirtual 357	mqq/app/MobileQQ:loadModule	(Ljava/lang/String;)V
    //   310: getstatic 87	com/tencent/mobileqq/pluginsdk/PluginStatic:sClassLoaderMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   313: aload_1
    //   314: aload 7
    //   316: invokevirtual 328	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   319: pop
    //   320: ldc 2
    //   322: monitorexit
    //   323: aload 7
    //   325: areturn
    //   326: aload_1
    //   327: ldc_w 359
    //   330: invokevirtual 362	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   333: ifeq +73 -> 406
    //   336: invokestatic 284	java/lang/System:currentTimeMillis	()J
    //   339: lstore 5
    //   341: aload_0
    //   342: ldc_w 364
    //   345: invokestatic 366	com/tencent/mobileqq/pluginsdk/PluginStatic:getOrCreateClassLoader	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/ClassLoader;
    //   348: astore 7
    //   350: ldc 161
    //   352: iconst_1
    //   353: new 192	java/lang/StringBuilder
    //   356: dup
    //   357: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   360: ldc_w 368
    //   363: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: invokestatic 284	java/lang/System:currentTimeMillis	()J
    //   369: lload 5
    //   371: lsub
    //   372: invokevirtual 371	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   375: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   378: invokestatic 278	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   381: new 373	com/tencent/mobileqq/pluginsdk/QZoneLiveClassLoader
    //   384: dup
    //   385: aload_2
    //   386: aload 8
    //   388: aload 9
    //   390: aload 7
    //   392: invokespecial 374	com/tencent/mobileqq/pluginsdk/QZoneLiveClassLoader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   395: astore 7
    //   397: goto -270 -> 127
    //   400: astore_0
    //   401: ldc 2
    //   403: monitorexit
    //   404: aload_0
    //   405: athrow
    //   406: aload_1
    //   407: ldc_w 376
    //   410: invokevirtual 362	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   413: ifeq +67 -> 480
    //   416: invokestatic 284	java/lang/System:currentTimeMillis	()J
    //   419: lstore 5
    //   421: aload_0
    //   422: ldc_w 364
    //   425: invokestatic 366	com/tencent/mobileqq/pluginsdk/PluginStatic:getOrCreateClassLoader	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/ClassLoader;
    //   428: astore 7
    //   430: ldc 161
    //   432: iconst_1
    //   433: new 192	java/lang/StringBuilder
    //   436: dup
    //   437: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   440: ldc_w 368
    //   443: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: invokestatic 284	java/lang/System:currentTimeMillis	()J
    //   449: lload 5
    //   451: lsub
    //   452: invokevirtual 371	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   455: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   458: invokestatic 278	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   461: new 378	com/tencent/mobileqq/pluginsdk/QZoneVerticalVideoClassLoader
    //   464: dup
    //   465: aload_2
    //   466: aload 8
    //   468: aload 9
    //   470: aload 7
    //   472: invokespecial 379	com/tencent/mobileqq/pluginsdk/QZoneVerticalVideoClassLoader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   475: astore 7
    //   477: goto -350 -> 127
    //   480: aload_1
    //   481: ldc_w 381
    //   484: invokevirtual 362	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   487: ifeq +67 -> 554
    //   490: invokestatic 284	java/lang/System:currentTimeMillis	()J
    //   493: lstore 5
    //   495: aload_0
    //   496: ldc_w 364
    //   499: invokestatic 366	com/tencent/mobileqq/pluginsdk/PluginStatic:getOrCreateClassLoader	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/ClassLoader;
    //   502: astore 7
    //   504: ldc 161
    //   506: iconst_1
    //   507: new 192	java/lang/StringBuilder
    //   510: dup
    //   511: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   514: ldc_w 368
    //   517: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: invokestatic 284	java/lang/System:currentTimeMillis	()J
    //   523: lload 5
    //   525: lsub
    //   526: invokevirtual 371	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   529: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   532: invokestatic 278	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   535: new 383	com/tencent/mobileqq/pluginsdk/QZoneWeishiFeedsClassLoader
    //   538: dup
    //   539: aload_2
    //   540: aload 8
    //   542: aload 9
    //   544: aload 7
    //   546: invokespecial 384	com/tencent/mobileqq/pluginsdk/QZoneWeishiFeedsClassLoader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   549: astore 7
    //   551: goto -424 -> 127
    //   554: aload_2
    //   555: ifnull +65 -> 620
    //   558: new 144	java/io/File
    //   561: dup
    //   562: aload_2
    //   563: invokespecial 147	java/io/File:<init>	(Ljava/lang/String;)V
    //   566: invokevirtual 151	java/io/File:exists	()Z
    //   569: ifne +51 -> 620
    //   572: ldc 161
    //   574: iconst_1
    //   575: new 192	java/lang/StringBuilder
    //   578: dup
    //   579: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   582: ldc_w 386
    //   585: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: aload_2
    //   589: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   595: invokestatic 278	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   598: new 228	dalvik/system/DexClassLoader
    //   601: dup
    //   602: ldc 169
    //   604: aload 8
    //   606: aload 9
    //   608: aload_0
    //   609: invokevirtual 303	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   612: invokespecial 387	dalvik/system/DexClassLoader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   615: astore 7
    //   617: goto -297 -> 320
    //   620: invokestatic 390	com/tencent/mobileqq/pluginsdk/PluginUtils:isOsNeedReleaseDex	()Z
    //   623: ifeq +150 -> 773
    //   626: invokestatic 269	com/tencent/mobileqq/pluginsdk/IPluginAdapterProxy:getProxy	()Lcom/tencent/mobileqq/pluginsdk/IPluginAdapterProxy;
    //   629: aload_1
    //   630: invokevirtual 393	com/tencent/mobileqq/pluginsdk/IPluginAdapterProxy:isSupportMultiDex	(Ljava/lang/String;)Z
    //   633: ifeq +140 -> 773
    //   636: aload_0
    //   637: aload_1
    //   638: invokestatic 396	com/tencent/mobileqq/pluginsdk/PluginUtils:getMultiDexSecondDex	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   641: astore 7
    //   643: aload 7
    //   645: invokevirtual 151	java/io/File:exists	()Z
    //   648: ifeq +125 -> 773
    //   651: new 192	java/lang/StringBuilder
    //   654: dup
    //   655: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   658: aload_2
    //   659: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   662: getstatic 399	java/io/File:pathSeparator	Ljava/lang/String;
    //   665: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: aload 7
    //   670: invokevirtual 402	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   673: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   676: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   679: astore 7
    //   681: ldc 161
    //   683: iconst_1
    //   684: new 192	java/lang/StringBuilder
    //   687: dup
    //   688: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   691: ldc_w 404
    //   694: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   697: aload 7
    //   699: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   702: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   705: invokestatic 278	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   708: ldc 161
    //   710: iconst_1
    //   711: new 192	java/lang/StringBuilder
    //   714: dup
    //   715: invokespecial 193	java/lang/StringBuilder:<init>	()V
    //   718: ldc_w 406
    //   721: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   724: aload 7
    //   726: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   729: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   732: invokestatic 278	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   735: new 228	dalvik/system/DexClassLoader
    //   738: dup
    //   739: aload 7
    //   741: aload 8
    //   743: aload 9
    //   745: aload_0
    //   746: invokevirtual 303	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   749: invokespecial 387	dalvik/system/DexClassLoader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   752: astore 7
    //   754: goto -627 -> 127
    //   757: astore_0
    //   758: ldc 161
    //   760: ldc_w 408
    //   763: aload_0
    //   764: invokestatic 411	com/tencent/mobileqq/pluginsdk/DebugHelper:log	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   767: aload 9
    //   769: astore_0
    //   770: goto -613 -> 157
    //   773: aload_2
    //   774: astore 7
    //   776: goto -68 -> 708
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	779	0	paramContext	Context
    //   0	779	1	paramString1	String
    //   0	779	2	paramString2	String
    //   79	151	3	l1	long
    //   339	185	5	l2	long
    //   17	758	7	localObject1	Object
    //   13	729	8	localObject2	Object
    //   97	671	9	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   3	15	400	finally
    //   24	127	400	finally
    //   127	139	400	finally
    //   148	157	400	finally
    //   161	194	400	finally
    //   194	203	400	finally
    //   206	218	400	finally
    //   226	244	400	finally
    //   244	254	400	finally
    //   259	267	400	finally
    //   267	320	400	finally
    //   326	397	400	finally
    //   406	477	400	finally
    //   480	551	400	finally
    //   558	617	400	finally
    //   620	708	400	finally
    //   708	754	400	finally
    //   758	767	400	finally
    //   148	157	757	java/lang/Throwable
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