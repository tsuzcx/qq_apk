package com.tencent.mobileqq.pluginsdk;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.commonsdk.soload.SoDexClassLoader;
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
    char[] arrayOfChar1 = new char[16];
    char[] tmp8_6 = arrayOfChar1;
    tmp8_6[0] = 48;
    char[] tmp13_8 = tmp8_6;
    tmp13_8[1] = 49;
    char[] tmp18_13 = tmp13_8;
    tmp18_13[2] = 50;
    char[] tmp23_18 = tmp18_13;
    tmp23_18[3] = 51;
    char[] tmp28_23 = tmp23_18;
    tmp28_23[4] = 52;
    char[] tmp33_28 = tmp28_23;
    tmp33_28[5] = 53;
    char[] tmp38_33 = tmp33_28;
    tmp38_33[6] = 54;
    char[] tmp44_38 = tmp38_33;
    tmp44_38[7] = 55;
    char[] tmp50_44 = tmp44_38;
    tmp50_44[8] = 56;
    char[] tmp56_50 = tmp50_44;
    tmp56_50[9] = 57;
    char[] tmp62_56 = tmp56_50;
    tmp62_56[10] = 65;
    char[] tmp68_62 = tmp62_56;
    tmp68_62[11] = 66;
    char[] tmp74_68 = tmp68_62;
    tmp74_68[12] = 67;
    char[] tmp80_74 = tmp74_68;
    tmp80_74[13] = 68;
    char[] tmp86_80 = tmp80_74;
    tmp86_80[14] = 69;
    char[] tmp92_86 = tmp86_80;
    tmp92_86[15] = 70;
    tmp92_86;
    char[] arrayOfChar2 = new char[paramArrayOfByte.length * 2];
    int k = paramArrayOfByte.length;
    int i = 0;
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
    //   13: istore_2
    //   14: ldc 153
    //   16: astore 5
    //   18: iload_2
    //   19: ifeq +193 -> 212
    //   22: aload_0
    //   23: invokevirtual 156	java/io/File:isFile	()Z
    //   26: ifne +6 -> 32
    //   29: goto +183 -> 212
    //   32: ldc 158
    //   34: invokestatic 164	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   37: astore 6
    //   39: new 166	java/io/FileInputStream
    //   42: dup
    //   43: aload_0
    //   44: invokespecial 169	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   47: astore_0
    //   48: aload_0
    //   49: astore_3
    //   50: sipush 16384
    //   53: newarray byte
    //   55: astore 4
    //   57: goto +17 -> 74
    //   60: astore 4
    //   62: goto +71 -> 133
    //   65: aload_0
    //   66: astore_3
    //   67: sipush 4096
    //   70: newarray byte
    //   72: astore 4
    //   74: aload_0
    //   75: astore_3
    //   76: aload_0
    //   77: aload 4
    //   79: invokevirtual 173	java/io/FileInputStream:read	([B)I
    //   82: istore_1
    //   83: iload_1
    //   84: iconst_m1
    //   85: if_icmpeq +17 -> 102
    //   88: aload_0
    //   89: astore_3
    //   90: aload 6
    //   92: aload 4
    //   94: iconst_0
    //   95: iload_1
    //   96: invokevirtual 177	java/security/MessageDigest:update	([BII)V
    //   99: goto -25 -> 74
    //   102: aload_0
    //   103: astore_3
    //   104: aload 6
    //   106: invokevirtual 181	java/security/MessageDigest:digest	()[B
    //   109: invokestatic 183	com/tencent/mobileqq/pluginsdk/PluginStatic:byteArrayToHex	([B)Ljava/lang/String;
    //   112: astore 4
    //   114: aload 4
    //   116: astore_3
    //   117: aload_0
    //   118: invokevirtual 186	java/io/FileInputStream:close	()V
    //   121: aload_3
    //   122: areturn
    //   123: astore_0
    //   124: aconst_null
    //   125: astore_3
    //   126: goto +76 -> 202
    //   129: astore 4
    //   131: aconst_null
    //   132: astore_0
    //   133: aload_0
    //   134: astore_3
    //   135: invokestatic 191	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   138: ifeq +50 -> 188
    //   141: aload_0
    //   142: astore_3
    //   143: new 193	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 194	java/lang/StringBuilder:<init>	()V
    //   150: astore 6
    //   152: aload_0
    //   153: astore_3
    //   154: aload 6
    //   156: ldc 196
    //   158: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: aload_0
    //   163: astore_3
    //   164: aload 6
    //   166: aload 4
    //   168: invokestatic 204	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   171: invokevirtual 200	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload_0
    //   176: astore_3
    //   177: ldc 206
    //   179: iconst_2
    //   180: aload 6
    //   182: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokestatic 214	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   188: aload_0
    //   189: ifnull +9 -> 198
    //   192: aload 5
    //   194: astore_3
    //   195: goto -78 -> 117
    //   198: ldc 153
    //   200: areturn
    //   201: astore_0
    //   202: aload_3
    //   203: ifnull +7 -> 210
    //   206: aload_3
    //   207: invokevirtual 186	java/io/FileInputStream:close	()V
    //   210: aload_0
    //   211: athrow
    //   212: invokestatic 191	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   215: ifeq +11 -> 226
    //   218: ldc 206
    //   220: iconst_2
    //   221: ldc 216
    //   223: invokestatic 214	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   226: ldc 153
    //   228: areturn
    //   229: astore_3
    //   230: goto -165 -> 65
    //   233: astore_0
    //   234: aload_3
    //   235: areturn
    //   236: astore_3
    //   237: goto -27 -> 210
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	240	0	paramString	String
    //   82	14	1	i	int
    //   13	6	2	bool	boolean
    //   49	158	3	localObject1	Object
    //   229	6	3	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   236	1	3	localIOException	java.io.IOException
    //   55	1	4	arrayOfByte	byte[]
    //   60	1	4	localException1	Exception
    //   72	43	4	localObject2	Object
    //   129	38	4	localException2	Exception
    //   16	177	5	str	String
    //   37	144	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   50	57	60	java/lang/Exception
    //   67	74	60	java/lang/Exception
    //   76	83	60	java/lang/Exception
    //   90	99	60	java/lang/Exception
    //   104	114	60	java/lang/Exception
    //   32	48	123	finally
    //   32	48	129	java/lang/Exception
    //   50	57	201	finally
    //   67	74	201	finally
    //   76	83	201	finally
    //   90	99	201	finally
    //   104	114	201	finally
    //   135	141	201	finally
    //   143	152	201	finally
    //   154	162	201	finally
    //   164	175	201	finally
    //   177	188	201	finally
    //   50	57	229	java/lang/OutOfMemoryError
    //   117	121	233	java/io/IOException
    //   206	210	236	java/io/IOException
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
  
  static ClassLoader getOrCreateClassLoaderByPath(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        Object localObject2 = (DexClassLoader)sClassLoaderMap.get(paramString1);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = PluginBaseInfoHelper.createFromFile(PluginUtils.getPluginCfgFile(PluginUtils.getPluginInstallDir(paramContext), paramString1), PluginBaseInfo.class);
          IPluginAdapterProxy.getProxy().isBuiltinPluginAndUpToDay(paramString1, (PluginBaseInfo)localObject1);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("getOrCreateClassLoader:");
          ((StringBuilder)localObject1).append(paramString1);
          QLog.d("plugin_tag", 1, ((StringBuilder)localObject1).toString());
          long l1 = System.currentTimeMillis();
          localObject2 = PluginUtils.getOptimizedDexPath(paramContext).getCanonicalPath();
          Object localObject3 = PluginUtils.getPluginLibPath(paramContext, paramString1).getCanonicalPath();
          if (paramString2.endsWith(".so"))
          {
            localObject1 = new SoDexClassLoader(paramString2, (String)localObject2, (String)localObject3, paramContext.getClassLoader());
          }
          else
          {
            long l2;
            StringBuilder localStringBuilder;
            if (paramString1.startsWith("qzone_live_video_plugin"))
            {
              l2 = System.currentTimeMillis();
              localObject1 = getOrCreateClassLoader(paramContext, "qzone_plugin.apk");
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("get qzone classloader cost=");
              localStringBuilder.append(System.currentTimeMillis() - l2);
              QLog.d("plugin_tag", 1, localStringBuilder.toString());
              localObject1 = new QZoneLiveClassLoader(paramString2, (String)localObject2, (String)localObject3, (ClassLoader)localObject1);
            }
            else if (paramString1.startsWith("qzone_vertical_video_plugin"))
            {
              l2 = System.currentTimeMillis();
              localObject1 = getOrCreateClassLoader(paramContext, "qzone_plugin.apk");
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("get qzone classloader cost=");
              localStringBuilder.append(System.currentTimeMillis() - l2);
              QLog.d("plugin_tag", 1, localStringBuilder.toString());
              localObject1 = new QZoneVerticalVideoClassLoader(paramString2, (String)localObject2, (String)localObject3, (ClassLoader)localObject1);
            }
            else if (paramString1.startsWith("qzone_weishi_feeds_plugin"))
            {
              l2 = System.currentTimeMillis();
              localObject1 = getOrCreateClassLoader(paramContext, "qzone_plugin.apk");
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("get qzone classloader cost=");
              localStringBuilder.append(System.currentTimeMillis() - l2);
              QLog.d("plugin_tag", 1, localStringBuilder.toString());
              localObject1 = new QZoneWeishiFeedsClassLoader(paramString2, (String)localObject2, (String)localObject3, (ClassLoader)localObject1);
            }
            else
            {
              if ((paramString2 != null) && (!new File(paramString2).exists()))
              {
                paramString1 = new StringBuilder();
                paramString1.append("getOrCreateClassLoader notExist  ");
                paramString1.append(paramString2);
                QLog.d("plugin_tag", 1, paramString1.toString());
                paramContext = new DexClassLoader("", (String)localObject2, (String)localObject3, paramContext.getClassLoader());
                return paramContext;
              }
              if ((!PluginUtils.isOsNeedReleaseDex()) || (!IPluginAdapterProxy.getProxy().isSupportMultiDex(paramString1))) {
                break label882;
              }
              localObject1 = PluginUtils.getMultiDexSecondDex(paramContext, paramString1);
              if (!((File)localObject1).exists()) {
                break label882;
              }
              localStringBuilder = new StringBuilder();
              localStringBuilder.append(paramString2);
              localStringBuilder.append(File.pathSeparator);
              localStringBuilder.append(((File)localObject1).getAbsolutePath());
              localObject1 = localStringBuilder.toString();
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("multiDex dexsPath");
              localStringBuilder.append((String)localObject1);
              QLog.d("plugin_tag", 1, localStringBuilder.toString());
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("dexsPath");
              localStringBuilder.append((String)localObject1);
              QLog.d("plugin_tag", 1, localStringBuilder.toString());
              localObject1 = new DexClassLoader((String)localObject1, (String)localObject2, (String)localObject3, paramContext.getClassLoader());
            }
          }
          localObject3 = (PackageInfo)sPackageInfoMap.get(paramString2);
          localObject2 = localObject3;
          if (localObject3 == null)
          {
            try
            {
              paramContext = ApkFileParser.getPackageInfoWithException(paramContext, paramString2, 129);
            }
            catch (Throwable paramContext)
            {
              DebugHelper.log("plugin_tag", "PluginStatic.getOrCreateClassLoaderByPath Get Package Info Failed!", paramContext);
              paramContext = (Context)localObject3;
            }
            if (paramContext == null)
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("PluginStatic.getOrCreateClassLoaderByPath Get Package Info Failed! ");
              ((StringBuilder)localObject2).append(new File(paramString2).exists());
              DebugHelper.log(((StringBuilder)localObject2).toString());
            }
            sPackageInfoMap.put(paramString2, paramContext);
            localObject2 = paramContext;
          }
          localObject3 = (Long)sClassLoaderStartTimeMap.get(paramString1);
          paramContext = (Context)localObject3;
          if (localObject3 == null)
          {
            paramContext = Long.valueOf(System.currentTimeMillis() - l1);
            sClassLoaderStartTimeMap.put(paramString1, paramContext);
          }
          sPackageInfoMap.put(paramString2, localObject2);
          if (localObject2 != null) {
            invokePluginLife((PackageInfo)localObject2, paramString1, (ClassLoader)localObject1);
          }
          paramString2 = new StringBuilder();
          paramString2.append("getOrCreateClassLoaderCost:");
          paramString2.append(paramString1);
          paramString2.append(" c:");
          paramString2.append(paramContext);
          QLog.w("plugin_tag", 1, paramString2.toString());
          if (paramBoolean) {
            MobileQQ.sMobileQQ.loadModule(paramString1);
          }
          sClassLoaderMap.put(paramString1, localObject1);
        }
        else
        {
          return localObject1;
        }
      }
      finally {}
      label882:
      Object localObject1 = paramString2;
    }
  }
  
  static void invokePluginLife(PackageInfo paramPackageInfo, String paramString, ClassLoader paramClassLoader)
  {
    try
    {
      if ((PluginStatic.IPluginLife)sLife.get(paramString) != null) {
        return;
      }
      if (paramPackageInfo != null)
      {
        if (paramPackageInfo.applicationInfo == null) {
          return;
        }
        if (paramPackageInfo.applicationInfo.metaData == null) {
          return;
        }
        paramPackageInfo = paramPackageInfo.applicationInfo.metaData.getString("PLUGIN_LIFE_CLASS");
        if (paramPackageInfo == null) {
          return;
        }
        paramPackageInfo = (PluginStatic.IPluginLife)paramClassLoader.loadClass(paramPackageInfo).newInstance();
        sLife.put(paramString, paramPackageInfo);
        paramPackageInfo.onLoad();
      }
      return;
    }
    catch (Throwable paramPackageInfo) {}
  }
  
  public static List<Boolean> isProcessesExist(Context paramContext, List<String> paramList)
  {
    if (paramList != null)
    {
      ArrayList localArrayList = new ArrayList();
      List localList = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
      int i = 0;
      if (localList == null) {
        for (;;)
        {
          paramContext = localArrayList;
          if (i >= paramList.size()) {
            break;
          }
          localArrayList.add(Boolean.FALSE);
          i += 1;
        }
      }
      paramList = paramList.iterator();
      for (;;)
      {
        paramContext = localArrayList;
        if (!paramList.hasNext()) {
          break;
        }
        paramContext = (String)paramList.next();
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext()) {
          if (paramContext.equalsIgnoreCase(((ActivityManager.RunningAppProcessInfo)localIterator.next()).processName))
          {
            bool = true;
            break label141;
          }
        }
        boolean bool = false;
        label141:
        localArrayList.add(Boolean.valueOf(bool));
      }
    }
    paramContext = null;
    return paramContext;
  }
  
  private static boolean isSubFile(String paramString, File paramFile)
  {
    paramFile = paramFile.getCanonicalPath();
    String str = new File(paramString).getParentFile().getCanonicalPath();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("path:");
      localStringBuilder.append(paramString);
      localStringBuilder.append("-> [");
      localStringBuilder.append(str);
      localStringBuilder.append(", ");
      localStringBuilder.append(paramFile);
      localStringBuilder.append("]");
      QLog.d("plugin_tag", 2, localStringBuilder.toString());
    }
    return str.equals(paramFile);
  }
  
  static boolean isValidPluginIntent(Bundle paramBundle)
  {
    boolean bool = false;
    if (paramBundle == null) {
      return false;
    }
    try
    {
      String str = paramBundle.getString("pluginsdk_pluginLocation");
      if (!TextUtils.isEmpty(str))
      {
        if (str.substring(0, str.lastIndexOf(".")).contains(".")) {
          return false;
        }
        if (TextUtils.isEmpty(paramBundle.getString("pluginsdk_pluginName"))) {
          return false;
        }
        paramBundle = paramBundle.getString("pluginsdk_pluginpath");
        if (TextUtils.isEmpty(paramBundle)) {
          return false;
        }
        if (TextUtils.isEmpty(paramBundle)) {
          return true;
        }
        bool = isValidPluginPath(paramBundle);
      }
      return bool;
    }
    catch (Throwable paramBundle) {}
    return false;
  }
  
  static boolean isValidPluginPath(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (!paramString.contains(".."))
      {
        if (paramString.endsWith(".so"))
        {
          String str = MobileQQ.getContext().getFilesDir().getParent();
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append("/txlib/");
          localObject = new File(((StringBuilder)localObject).toString());
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append("/lib/");
          if (isSubFile(paramString, new File(localStringBuilder.toString()))) {
            break label155;
          }
          isSubFile(paramString, (File)localObject);
          break label155;
        }
        bool1 = bool2;
        if (paramString.endsWith(".apk")) {
          bool1 = isSubFile(paramString, PluginUtils.getPluginInstallDir(MobileQQ.getContext()));
        }
      }
      return bool1;
    }
    catch (Exception paramString)
    {
      return false;
    }
    label155:
    return true;
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
      finally
      {
        continue;
        throw paramIPluginActivity;
        continue;
        i += 1;
      }
    }
  }
  
  public static ClassLoader removeClassLoader(String paramString)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("removeClassLoader:");
      localStringBuilder.append(paramString);
      QLog.d("plugin_tag", 1, localStringBuilder.toString());
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
          j = i;
          if (((WeakReference)sInstances.get(i)).get() == null)
          {
            sInstances.remove(i);
            j = i - 1;
          }
        }
        else
        {
          return;
        }
      }
      finally
      {
        int j;
        continue;
        throw localObject;
        continue;
        i = j + 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginStatic
 * JD-Core Version:    0.7.0.1
 */