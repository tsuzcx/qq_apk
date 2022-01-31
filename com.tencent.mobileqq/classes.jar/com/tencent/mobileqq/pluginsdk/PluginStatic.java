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
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;

public abstract class PluginStatic
{
  public static final String PARAM_CLASS_STATISTICS_UPLOADER = "clsUploader";
  public static final String PARAM_CLEAR_TOP = "cleartop";
  public static final String PARAM_EXTRA_INFO = "pluginsdk_extraInfo";
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
  static final String a = "com.tencent.mobileqq";
  static final String b = "pluginsdk_IsPluginActivity";
  static final ConcurrentHashMap c = new ConcurrentHashMap();
  static final ConcurrentHashMap d = new ConcurrentHashMap();
  private static final HashMap e = new HashMap();
  private static ArrayList f = new ArrayList();
  
  /* Error */
  static ClassLoader a(Context paramContext, String paramString1, String paramString2)
    throws Exception
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 83	com/tencent/mobileqq/pluginsdk/PluginStatic:c	Ljava/util/concurrent/ConcurrentHashMap;
    //   6: aload_1
    //   7: invokevirtual 101	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast 103	dalvik/system/DexClassLoader
    //   13: astore 8
    //   15: aload 8
    //   17: astore 7
    //   19: aload 8
    //   21: ifnonnull +221 -> 242
    //   24: ldc 105
    //   26: iconst_1
    //   27: new 107	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   34: ldc 110
    //   36: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload_1
    //   40: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokestatic 123	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   49: invokestatic 129	java/lang/System:currentTimeMillis	()J
    //   52: lstore_3
    //   53: aload_0
    //   54: invokestatic 135	com/tencent/mobileqq/pluginsdk/PluginUtils:getOptimizedDexPath	(Landroid/content/Context;)Ljava/io/File;
    //   57: invokevirtual 140	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   60: astore 8
    //   62: aload_0
    //   63: aload_1
    //   64: invokestatic 144	com/tencent/mobileqq/pluginsdk/PluginUtils:getPluginLibPath	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   67: invokevirtual 140	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   70: astore 9
    //   72: aload_2
    //   73: ldc 146
    //   75: invokevirtual 152	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   78: ifeq +170 -> 248
    //   81: new 154	com/tencent/commonsdk/soload/SoDexClassLoader
    //   84: dup
    //   85: aload_2
    //   86: aload 8
    //   88: aload 9
    //   90: aload_0
    //   91: invokevirtual 160	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   94: invokespecial 163	com/tencent/commonsdk/soload/SoDexClassLoader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   97: astore 7
    //   99: getstatic 85	com/tencent/mobileqq/pluginsdk/PluginStatic:d	Ljava/util/concurrent/ConcurrentHashMap;
    //   102: aload_2
    //   103: invokevirtual 101	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   106: checkcast 165	android/content/pm/PackageInfo
    //   109: astore 8
    //   111: aload 8
    //   113: astore 9
    //   115: aload 8
    //   117: ifnonnull +60 -> 177
    //   120: aload_0
    //   121: aload_2
    //   122: sipush 129
    //   125: invokestatic 171	com/tencent/mobileqq/pluginsdk/ApkFileParser:getPackageInfoWithException	(Landroid/content/Context;Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   128: astore_0
    //   129: aload_0
    //   130: ifnonnull +35 -> 165
    //   133: new 107	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   140: ldc 173
    //   142: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: new 137	java/io/File
    //   148: dup
    //   149: aload_2
    //   150: invokespecial 176	java/io/File:<init>	(Ljava/lang/String;)V
    //   153: invokevirtual 180	java/io/File:exists	()Z
    //   156: invokevirtual 183	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   159: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokestatic 188	com/tencent/mobileqq/pluginsdk/DebugHelper:log	(Ljava/lang/String;)V
    //   165: getstatic 85	com/tencent/mobileqq/pluginsdk/PluginStatic:d	Ljava/util/concurrent/ConcurrentHashMap;
    //   168: aload_2
    //   169: aload_0
    //   170: invokevirtual 192	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   173: pop
    //   174: aload_0
    //   175: astore 9
    //   177: aload 9
    //   179: ifnull +11 -> 190
    //   182: aload 9
    //   184: aload_1
    //   185: aload 7
    //   187: invokestatic 195	com/tencent/mobileqq/pluginsdk/PluginStatic:a	(Landroid/content/pm/PackageInfo;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   190: invokestatic 129	java/lang/System:currentTimeMillis	()J
    //   193: lstore 5
    //   195: ldc 105
    //   197: iconst_1
    //   198: new 107	java/lang/StringBuilder
    //   201: dup
    //   202: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   205: ldc 197
    //   207: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: aload_1
    //   211: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: ldc 199
    //   216: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: lload 5
    //   221: lload_3
    //   222: lsub
    //   223: invokevirtual 202	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   226: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: invokestatic 205	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   232: getstatic 83	com/tencent/mobileqq/pluginsdk/PluginStatic:c	Ljava/util/concurrent/ConcurrentHashMap;
    //   235: aload_1
    //   236: aload 7
    //   238: invokevirtual 192	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   241: pop
    //   242: ldc 2
    //   244: monitorexit
    //   245: aload 7
    //   247: areturn
    //   248: aload_1
    //   249: ldc 207
    //   251: invokevirtual 210	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   254: ifeq +71 -> 325
    //   257: invokestatic 129	java/lang/System:currentTimeMillis	()J
    //   260: lstore 5
    //   262: aload_0
    //   263: ldc 212
    //   265: invokestatic 216	com/tencent/mobileqq/pluginsdk/PluginStatic:getOrCreateClassLoader	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/ClassLoader;
    //   268: astore 7
    //   270: ldc 105
    //   272: iconst_1
    //   273: new 107	java/lang/StringBuilder
    //   276: dup
    //   277: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   280: ldc 218
    //   282: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: invokestatic 129	java/lang/System:currentTimeMillis	()J
    //   288: lload 5
    //   290: lsub
    //   291: invokevirtual 202	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   294: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   297: invokestatic 123	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   300: new 220	com/tencent/mobileqq/pluginsdk/QZoneLiveClassLoader
    //   303: dup
    //   304: aload_2
    //   305: aload 8
    //   307: aload 9
    //   309: aload 7
    //   311: invokespecial 221	com/tencent/mobileqq/pluginsdk/QZoneLiveClassLoader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   314: astore 7
    //   316: goto -217 -> 99
    //   319: astore_0
    //   320: ldc 2
    //   322: monitorexit
    //   323: aload_0
    //   324: athrow
    //   325: aload_1
    //   326: ldc 223
    //   328: invokevirtual 210	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   331: ifeq +65 -> 396
    //   334: invokestatic 129	java/lang/System:currentTimeMillis	()J
    //   337: lstore 5
    //   339: aload_0
    //   340: ldc 212
    //   342: invokestatic 216	com/tencent/mobileqq/pluginsdk/PluginStatic:getOrCreateClassLoader	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/ClassLoader;
    //   345: astore 7
    //   347: ldc 105
    //   349: iconst_1
    //   350: new 107	java/lang/StringBuilder
    //   353: dup
    //   354: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   357: ldc 218
    //   359: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: invokestatic 129	java/lang/System:currentTimeMillis	()J
    //   365: lload 5
    //   367: lsub
    //   368: invokevirtual 202	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   371: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   374: invokestatic 123	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   377: new 225	com/tencent/mobileqq/pluginsdk/QZoneVerticalVideoClassLoader
    //   380: dup
    //   381: aload_2
    //   382: aload 8
    //   384: aload 9
    //   386: aload 7
    //   388: invokespecial 226	com/tencent/mobileqq/pluginsdk/QZoneVerticalVideoClassLoader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   391: astore 7
    //   393: goto -294 -> 99
    //   396: aload_1
    //   397: ldc 228
    //   399: invokevirtual 210	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   402: ifeq +65 -> 467
    //   405: invokestatic 129	java/lang/System:currentTimeMillis	()J
    //   408: lstore 5
    //   410: aload_0
    //   411: ldc 212
    //   413: invokestatic 216	com/tencent/mobileqq/pluginsdk/PluginStatic:getOrCreateClassLoader	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/ClassLoader;
    //   416: astore 7
    //   418: ldc 105
    //   420: iconst_1
    //   421: new 107	java/lang/StringBuilder
    //   424: dup
    //   425: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   428: ldc 218
    //   430: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: invokestatic 129	java/lang/System:currentTimeMillis	()J
    //   436: lload 5
    //   438: lsub
    //   439: invokevirtual 202	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   442: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   445: invokestatic 123	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   448: new 230	com/tencent/mobileqq/pluginsdk/QZoneWeishiFeedsClassLoader
    //   451: dup
    //   452: aload_2
    //   453: aload 8
    //   455: aload 9
    //   457: aload 7
    //   459: invokespecial 231	com/tencent/mobileqq/pluginsdk/QZoneWeishiFeedsClassLoader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   462: astore 7
    //   464: goto -365 -> 99
    //   467: aload_2
    //   468: ifnull +64 -> 532
    //   471: new 137	java/io/File
    //   474: dup
    //   475: aload_2
    //   476: invokespecial 176	java/io/File:<init>	(Ljava/lang/String;)V
    //   479: invokevirtual 180	java/io/File:exists	()Z
    //   482: ifne +50 -> 532
    //   485: ldc 105
    //   487: iconst_1
    //   488: new 107	java/lang/StringBuilder
    //   491: dup
    //   492: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   495: ldc 233
    //   497: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: aload_2
    //   501: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   507: invokestatic 123	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   510: new 103	dalvik/system/DexClassLoader
    //   513: dup
    //   514: ldc 235
    //   516: aload 8
    //   518: aload 9
    //   520: aload_0
    //   521: invokevirtual 160	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   524: invokespecial 236	dalvik/system/DexClassLoader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   527: astore 7
    //   529: goto -287 -> 242
    //   532: invokestatic 239	com/tencent/mobileqq/pluginsdk/PluginUtils:isOsNeedReleaseDex	()Z
    //   535: ifeq +150 -> 685
    //   538: invokestatic 245	com/tencent/mobileqq/pluginsdk/IPluginAdapterProxy:getProxy	()Lcom/tencent/mobileqq/pluginsdk/IPluginAdapterProxy;
    //   541: aload_1
    //   542: invokevirtual 248	com/tencent/mobileqq/pluginsdk/IPluginAdapterProxy:isSupportMultiDex	(Ljava/lang/String;)Z
    //   545: ifeq +140 -> 685
    //   548: aload_0
    //   549: aload_1
    //   550: invokestatic 251	com/tencent/mobileqq/pluginsdk/PluginUtils:getMultiDexSecondDex	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   553: astore 7
    //   555: aload 7
    //   557: invokevirtual 180	java/io/File:exists	()Z
    //   560: ifeq +125 -> 685
    //   563: new 107	java/lang/StringBuilder
    //   566: dup
    //   567: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   570: aload_2
    //   571: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   574: getstatic 254	java/io/File:pathSeparator	Ljava/lang/String;
    //   577: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   580: aload 7
    //   582: invokevirtual 257	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   585: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   591: astore 7
    //   593: ldc 105
    //   595: iconst_1
    //   596: new 107	java/lang/StringBuilder
    //   599: dup
    //   600: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   603: ldc_w 259
    //   606: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   609: aload 7
    //   611: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   614: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   617: invokestatic 123	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   620: ldc 105
    //   622: iconst_1
    //   623: new 107	java/lang/StringBuilder
    //   626: dup
    //   627: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   630: ldc_w 261
    //   633: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   636: aload 7
    //   638: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   641: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   644: invokestatic 123	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   647: new 103	dalvik/system/DexClassLoader
    //   650: dup
    //   651: aload 7
    //   653: aload 8
    //   655: aload 9
    //   657: aload_0
    //   658: invokevirtual 160	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   661: invokespecial 236	dalvik/system/DexClassLoader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   664: astore 7
    //   666: goto -567 -> 99
    //   669: astore_0
    //   670: ldc 105
    //   672: ldc_w 263
    //   675: aload_0
    //   676: invokestatic 266	com/tencent/mobileqq/pluginsdk/DebugHelper:log	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   679: aload 8
    //   681: astore_0
    //   682: goto -553 -> 129
    //   685: aload_2
    //   686: astore 7
    //   688: goto -68 -> 620
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	691	0	paramContext	Context
    //   0	691	1	paramString1	String
    //   0	691	2	paramString2	String
    //   52	170	3	l1	long
    //   193	244	5	l2	long
    //   17	670	7	localObject1	Object
    //   13	667	8	localObject2	Object
    //   70	586	9	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   3	15	319	finally
    //   24	99	319	finally
    //   99	111	319	finally
    //   120	129	319	finally
    //   133	165	319	finally
    //   165	174	319	finally
    //   182	190	319	finally
    //   190	242	319	finally
    //   248	316	319	finally
    //   325	393	319	finally
    //   396	464	319	finally
    //   471	529	319	finally
    //   532	620	319	finally
    //   620	666	319	finally
    //   670	679	319	finally
    //   120	129	669	java/lang/Throwable
  }
  
  static List a()
  {
    return f;
  }
  
  static void a(PackageInfo paramPackageInfo, String paramString, ClassLoader paramClassLoader)
  {
    try
    {
      if ((IPluginLife)e.get(paramString) != null) {
        return;
      }
      if ((paramPackageInfo != null) && (paramPackageInfo.applicationInfo != null) && (paramPackageInfo.applicationInfo.metaData != null))
      {
        paramPackageInfo = paramPackageInfo.applicationInfo.metaData.getString("PLUGIN_LIFE_CLASS");
        if (paramPackageInfo != null)
        {
          paramPackageInfo = (IPluginLife)paramClassLoader.loadClass(paramPackageInfo).newInstance();
          e.put(paramString, paramPackageInfo);
          paramPackageInfo.onLoad();
          return;
        }
      }
    }
    catch (Throwable paramPackageInfo) {}
  }
  
  static void a(IPluginActivity paramIPluginActivity)
  {
    
    synchronized (f)
    {
      f.add(new WeakReference(paramIPluginActivity));
      return;
    }
  }
  
  static boolean a(Bundle paramBundle)
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
            boolean bool = a(paramBundle);
            return bool;
          }
        }
      }
      catch (Throwable paramBundle) {}
    }
    return false;
  }
  
  static boolean a(String paramString)
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
        if ((a(paramString, new File(str + "/lib/"))) || (!a(paramString, localFile))) {}
      }
      else
      {
        bool1 = bool2;
        if (!paramString.endsWith(".apk")) {
          return bool1;
        }
        bool1 = a(paramString, PluginUtils.getPluginInstallDir(MobileQQ.getContext()));
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
  
  private static boolean a(String paramString, File paramFile)
    throws IOException
  {
    paramFile = paramFile.getCanonicalPath();
    String str = new File(paramString).getParentFile().getCanonicalPath();
    if (QLog.isColorLevel()) {
      QLog.d("plugin_tag", 2, "path:" + paramString + "-> [" + str + ", " + paramFile + "]");
    }
    return str.equals(paramFile);
  }
  
  static void b()
  {
    ArrayList localArrayList = f;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < f.size())
        {
          if (((WeakReference)f.get(i)).get() == null)
          {
            f.remove(i);
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
  
  static void b(IPluginActivity paramIPluginActivity)
  {
    b();
    c(paramIPluginActivity);
  }
  
  public static String byteArrayToHex(byte[] paramArrayOfByte)
  {
    int i = 0;
    char[] arrayOfChar1 = new char[16];
    char[] tmp10_8 = arrayOfChar1;
    tmp10_8[0] = 48;
    char[] tmp16_10 = tmp10_8;
    tmp16_10[1] = 49;
    char[] tmp22_16 = tmp16_10;
    tmp22_16[2] = 50;
    char[] tmp28_22 = tmp22_16;
    tmp28_22[3] = 51;
    char[] tmp34_28 = tmp28_22;
    tmp34_28[4] = 52;
    char[] tmp40_34 = tmp34_28;
    tmp40_34[5] = 53;
    char[] tmp46_40 = tmp40_34;
    tmp46_40[6] = 54;
    char[] tmp53_46 = tmp46_40;
    tmp53_46[7] = 55;
    char[] tmp60_53 = tmp53_46;
    tmp60_53[8] = 56;
    char[] tmp67_60 = tmp60_53;
    tmp67_60[9] = 57;
    char[] tmp74_67 = tmp67_60;
    tmp74_67[10] = 65;
    char[] tmp81_74 = tmp74_67;
    tmp81_74[11] = 66;
    char[] tmp88_81 = tmp81_74;
    tmp88_81[12] = 67;
    char[] tmp95_88 = tmp88_81;
    tmp95_88[13] = 68;
    char[] tmp102_95 = tmp95_88;
    tmp102_95[14] = 69;
    char[] tmp109_102 = tmp102_95;
    tmp109_102[15] = 70;
    tmp109_102;
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
  
  private static boolean c(IPluginActivity paramIPluginActivity)
  {
    ArrayList localArrayList = f;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < f.size())
        {
          if (((WeakReference)f.get(i)).get() == paramIPluginActivity)
          {
            f.remove(i);
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
  
  /* Error */
  public static String encodeFile(String paramString)
  {
    // Byte code:
    //   0: new 137	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 176	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: invokevirtual 180	java/io/File:exists	()Z
    //   13: ifeq +10 -> 23
    //   16: aload_0
    //   17: invokevirtual 427	java/io/File:isFile	()Z
    //   20: ifne +23 -> 43
    //   23: invokestatic 374	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   26: ifeq +12 -> 38
    //   29: ldc 105
    //   31: iconst_2
    //   32: ldc_w 429
    //   35: invokestatic 431	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   38: ldc 235
    //   40: astore_3
    //   41: aload_3
    //   42: areturn
    //   43: ldc_w 433
    //   46: invokestatic 439	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   49: astore 4
    //   51: new 441	java/io/FileInputStream
    //   54: dup
    //   55: aload_0
    //   56: invokespecial 444	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   59: astore_2
    //   60: aload_2
    //   61: astore_0
    //   62: sipush 16384
    //   65: newarray byte
    //   67: astore_3
    //   68: aload_2
    //   69: astore_0
    //   70: aload_2
    //   71: aload_3
    //   72: invokevirtual 448	java/io/FileInputStream:read	([B)I
    //   75: istore_1
    //   76: iload_1
    //   77: iconst_m1
    //   78: if_icmpeq +79 -> 157
    //   81: aload_2
    //   82: astore_0
    //   83: aload 4
    //   85: aload_3
    //   86: iconst_0
    //   87: iload_1
    //   88: invokevirtual 452	java/security/MessageDigest:update	([BII)V
    //   91: goto -23 -> 68
    //   94: astore_3
    //   95: aload_2
    //   96: astore_0
    //   97: invokestatic 374	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   100: ifeq +34 -> 134
    //   103: aload_2
    //   104: astore_0
    //   105: ldc 105
    //   107: iconst_2
    //   108: new 107	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   115: ldc_w 454
    //   118: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: aload_3
    //   122: invokestatic 458	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   125: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokestatic 431	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   134: aload_2
    //   135: ifnull +7 -> 142
    //   138: aload_2
    //   139: invokevirtual 461	java/io/FileInputStream:close	()V
    //   142: ldc 235
    //   144: areturn
    //   145: astore_0
    //   146: aload_2
    //   147: astore_0
    //   148: sipush 4096
    //   151: newarray byte
    //   153: astore_3
    //   154: goto -86 -> 68
    //   157: aload_2
    //   158: astore_0
    //   159: aload 4
    //   161: invokevirtual 465	java/security/MessageDigest:digest	()[B
    //   164: invokestatic 467	com/tencent/mobileqq/pluginsdk/PluginStatic:byteArrayToHex	([B)Ljava/lang/String;
    //   167: astore_3
    //   168: aload_3
    //   169: astore_0
    //   170: aload_0
    //   171: astore_3
    //   172: aload_2
    //   173: ifnull -132 -> 41
    //   176: aload_2
    //   177: invokevirtual 461	java/io/FileInputStream:close	()V
    //   180: aload_0
    //   181: areturn
    //   182: astore_2
    //   183: aload_0
    //   184: areturn
    //   185: astore_2
    //   186: aconst_null
    //   187: astore_0
    //   188: aload_0
    //   189: ifnull +7 -> 196
    //   192: aload_0
    //   193: invokevirtual 461	java/io/FileInputStream:close	()V
    //   196: aload_2
    //   197: athrow
    //   198: astore_0
    //   199: goto -3 -> 196
    //   202: astore_0
    //   203: goto -61 -> 142
    //   206: astore_2
    //   207: goto -19 -> 188
    //   210: astore_3
    //   211: aconst_null
    //   212: astore_2
    //   213: goto -118 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	216	0	paramString	String
    //   75	13	1	i	int
    //   59	118	2	localFileInputStream	java.io.FileInputStream
    //   182	1	2	localIOException	IOException
    //   185	12	2	localObject1	Object
    //   206	1	2	localObject2	Object
    //   212	1	2	localObject3	Object
    //   40	46	3	localObject4	Object
    //   94	28	3	localException1	Exception
    //   153	19	3	localObject5	Object
    //   210	1	3	localException2	Exception
    //   49	111	4	localMessageDigest	java.security.MessageDigest
    // Exception table:
    //   from	to	target	type
    //   62	68	94	java/lang/Exception
    //   70	76	94	java/lang/Exception
    //   83	91	94	java/lang/Exception
    //   148	154	94	java/lang/Exception
    //   159	168	94	java/lang/Exception
    //   62	68	145	java/lang/OutOfMemoryError
    //   176	180	182	java/io/IOException
    //   43	60	185	finally
    //   192	196	198	java/io/IOException
    //   138	142	202	java/io/IOException
    //   62	68	206	finally
    //   70	76	206	finally
    //   83	91	206	finally
    //   97	103	206	finally
    //   105	134	206	finally
    //   148	154	206	finally
    //   159	168	206	finally
    //   43	60	210	java/lang/Exception
  }
  
  public static ClassLoader getClassLoader(String paramString)
  {
    try
    {
      paramString = (DexClassLoader)c.get(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static ClassLoader getOrCreateClassLoader(Context paramContext, String paramString)
    throws Exception
  {
    try
    {
      ClassLoader localClassLoader2 = (ClassLoader)c.get(paramString);
      ClassLoader localClassLoader1 = localClassLoader2;
      if (localClassLoader2 == null) {
        localClassLoader1 = a(paramContext, paramString, PluginUtils.getInstalledPluginPath(paramContext, paramString).getCanonicalPath());
      }
      return localClassLoader1;
    }
    finally {}
  }
  
  public static List isProcessesExist(Context paramContext, List paramList)
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
  
  public static ClassLoader removeClassLoader(String paramString)
  {
    try
    {
      QLog.d("plugin_tag", 1, "removeClassLoader:" + paramString);
      paramString = (ClassLoader)c.remove(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static abstract interface IPluginLife
  {
    public abstract void onLoad();
    
    public abstract void onUnload();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginStatic
 * JD-Core Version:    0.7.0.1
 */