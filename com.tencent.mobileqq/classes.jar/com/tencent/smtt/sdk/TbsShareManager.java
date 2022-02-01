package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.a;
import com.tencent.smtt.utils.b;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

public class TbsShareManager
{
  private static Context a;
  private static boolean b = false;
  private static String c;
  private static String d;
  private static int e = 0;
  private static String f;
  private static boolean g = false;
  private static boolean h = false;
  private static boolean i = false;
  private static String j;
  private static boolean k = false;
  private static boolean l = false;
  public static boolean mHasQueryed = false;
  
  static int a(Context paramContext, boolean paramBoolean)
  {
    b(paramContext, paramBoolean);
    return e;
  }
  
  static String a()
  {
    return d;
  }
  
  static void a(Context paramContext)
  {
    TbsLog.i("TbsShareManager", "shareTbsCore #1");
    try
    {
      localObject = new TbsLinuxToolsJni(paramContext);
      a(paramContext, (TbsLinuxToolsJni)localObject, p.a().q(paramContext));
      paramContext = p.a().r(paramContext);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("shareTbsCore tbsShareDir is ");
      localStringBuilder.append(paramContext.getAbsolutePath());
      TbsLog.i("TbsShareManager", localStringBuilder.toString());
      ((TbsLinuxToolsJni)localObject).a(paramContext.getAbsolutePath(), "755");
      return;
    }
    catch (Throwable paramContext)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("shareTbsCore tbsShareDir error is ");
      ((StringBuilder)localObject).append(paramContext.getMessage());
      ((StringBuilder)localObject).append(" ## ");
      ((StringBuilder)localObject).append(paramContext.getCause());
      TbsLog.i("TbsShareManager", ((StringBuilder)localObject).toString());
      paramContext.printStackTrace();
    }
  }
  
  private static void a(Context paramContext, int paramInt)
  {
    if ((!TbsPVConfig.getInstance(a).isDisableHostBackupCore()) && (p.a().t(paramContext)))
    {
      Object localObject1 = new String[5];
      localObject1[0] = "com.tencent.tbs";
      localObject1[1] = "com.tencent.mm";
      localObject1[2] = "com.tencent.mobileqq";
      localObject1[3] = "com.qzone";
      localObject1[4] = paramContext.getPackageName();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("find host backup core to unzip #1");
      ((StringBuilder)localObject2).append(Log.getStackTraceString(new Throwable()));
      TbsLog.i("TbsShareManager", ((StringBuilder)localObject2).toString());
      int n = localObject1.length;
      int m = 0;
      while (m < n)
      {
        String str = localObject1[m];
        File localFile;
        if (paramInt == getBackupCoreVersion(paramContext, str))
        {
          localObject2 = getPackageContext(paramContext, str, false);
          if (p.a().f((Context)localObject2))
          {
            localFile = getBackupCoreFile(paramContext, str);
            if (a.a(paramContext, localFile, 0L, paramInt)) {
              localObject1 = new StringBuilder();
            }
          }
        }
        else
        {
          for (localObject2 = "find host backup core to unzip normal coreVersion is ";; localObject2 = "find host backup core to unzip decouple coreVersion is ")
          {
            ((StringBuilder)localObject1).append((String)localObject2);
            ((StringBuilder)localObject1).append(paramInt);
            ((StringBuilder)localObject1).append(" packageName is ");
            ((StringBuilder)localObject1).append(str);
            TbsLog.i("TbsShareManager", ((StringBuilder)localObject1).toString());
            p.a().a(paramContext, localFile, paramInt);
            break label320;
            if (paramInt != getBackupDecoupleCoreVersion(paramContext, str)) {
              break;
            }
            localObject2 = getPackageContext(paramContext, str, false);
            if (!p.a().f((Context)localObject2)) {
              break;
            }
            localFile = getBackupDecoupleCoreFile(paramContext, str);
            if (!a.a(paramContext, localFile, 0L, paramInt)) {
              break;
            }
            localObject1 = new StringBuilder();
          }
        }
        m += 1;
      }
      label320:
      p.a().b();
    }
  }
  
  private static void a(Context paramContext, TbsLinuxToolsJni paramTbsLinuxToolsJni, File paramFile)
  {
    TbsLog.i("TbsShareManager", "shareAllDirsAndFiles #1");
    if ((paramFile != null) && (paramFile.exists()))
    {
      if (!paramFile.isDirectory()) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("shareAllDirsAndFiles dir is ");
      localStringBuilder.append(paramFile.getAbsolutePath());
      TbsLog.i("TbsShareManager", localStringBuilder.toString());
      paramTbsLinuxToolsJni.a(paramFile.getAbsolutePath(), "755");
      paramFile = paramFile.listFiles();
      int n = paramFile.length;
      int m = 0;
      while (m < n)
      {
        localStringBuilder = paramFile[m];
        if (localStringBuilder.isFile())
        {
          if (localStringBuilder.getAbsolutePath().indexOf(".so") > 0) {
            paramTbsLinuxToolsJni.a(localStringBuilder.getAbsolutePath(), "755");
          } else {
            paramTbsLinuxToolsJni.a(localStringBuilder.getAbsolutePath(), "644");
          }
        }
        else if (localStringBuilder.isDirectory()) {
          a(paramContext, paramTbsLinuxToolsJni, localStringBuilder);
        } else {
          TbsLog.e("TbsShareManager", "unknown file type.", true);
        }
        m += 1;
      }
    }
  }
  
  static void b(Context paramContext)
  {
    try
    {
      a(paramContext, new TbsLinuxToolsJni(paramContext), p.a().p(paramContext));
      return;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  static boolean b(Context paramContext, boolean paramBoolean)
  {
    if (i(paramContext)) {
      return true;
    }
    if (paramBoolean) {
      QbSdk.a(paramContext, "TbsShareManager::isShareTbsCoreAvailable forceSysWebViewInner!");
    }
    return false;
  }
  
  static String c(Context paramContext)
  {
    j(paramContext);
    return d;
  }
  
  /* Error */
  private static void c(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aload_0
    //   7: ldc 237
    //   9: invokestatic 240	com/tencent/smtt/sdk/TbsShareManager:getTbsShareFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   12: astore 6
    //   14: aload 6
    //   16: ifnonnull +4 -> 20
    //   19: return
    //   20: new 242	java/io/BufferedInputStream
    //   23: dup
    //   24: new 244	java/io/FileInputStream
    //   27: dup
    //   28: aload 6
    //   30: invokespecial 247	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   33: invokespecial 250	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   36: astore_3
    //   37: new 252	java/util/Properties
    //   40: dup
    //   41: invokespecial 253	java/util/Properties:<init>	()V
    //   44: astore 5
    //   46: aload 5
    //   48: aload_3
    //   49: invokevirtual 256	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   52: aload 5
    //   54: ldc_w 258
    //   57: iconst_0
    //   58: invokestatic 262	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   61: invokevirtual 266	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   64: pop
    //   65: iload_1
    //   66: ifeq +64 -> 130
    //   69: invokestatic 58	com/tencent/smtt/sdk/p:a	()Lcom/tencent/smtt/sdk/p;
    //   72: aload_0
    //   73: invokevirtual 62	com/tencent/smtt/sdk/p:q	(Landroid/content/Context;)Ljava/io/File;
    //   76: invokevirtual 82	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   79: astore 7
    //   81: aload_0
    //   82: invokevirtual 270	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   85: invokevirtual 139	android/content/Context:getPackageName	()Ljava/lang/String;
    //   88: astore 8
    //   90: aload_0
    //   91: invokestatic 275	com/tencent/smtt/utils/b:d	(Landroid/content/Context;)I
    //   94: istore_2
    //   95: aload 5
    //   97: ldc_w 277
    //   100: aload 8
    //   102: invokevirtual 266	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   105: pop
    //   106: aload 5
    //   108: ldc_w 279
    //   111: aload 7
    //   113: invokevirtual 266	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   116: pop
    //   117: aload 5
    //   119: ldc_w 281
    //   122: iload_2
    //   123: invokestatic 284	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   126: invokevirtual 266	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   129: pop
    //   130: new 286	java/io/BufferedOutputStream
    //   133: dup
    //   134: new 288	java/io/FileOutputStream
    //   137: dup
    //   138: aload 6
    //   140: invokespecial 289	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   143: invokespecial 292	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   146: astore_0
    //   147: aload 5
    //   149: aload_0
    //   150: aconst_null
    //   151: invokevirtual 296	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   154: aload_3
    //   155: invokevirtual 299	java/io/BufferedInputStream:close	()V
    //   158: aload_0
    //   159: invokevirtual 300	java/io/BufferedOutputStream:close	()V
    //   162: return
    //   163: astore 4
    //   165: goto +55 -> 220
    //   168: astore 4
    //   170: goto +11 -> 181
    //   173: astore_0
    //   174: goto +56 -> 230
    //   177: astore 4
    //   179: aconst_null
    //   180: astore_0
    //   181: goto +16 -> 197
    //   184: astore_0
    //   185: aconst_null
    //   186: astore_3
    //   187: goto +43 -> 230
    //   190: astore 4
    //   192: aconst_null
    //   193: astore_0
    //   194: aload 5
    //   196: astore_3
    //   197: aload 4
    //   199: invokevirtual 107	java/lang/Throwable:printStackTrace	()V
    //   202: aload_3
    //   203: ifnull +7 -> 210
    //   206: aload_3
    //   207: invokevirtual 299	java/io/BufferedInputStream:close	()V
    //   210: aload_0
    //   211: ifnull +6 -> 217
    //   214: goto -56 -> 158
    //   217: return
    //   218: astore 4
    //   220: aload_0
    //   221: astore 5
    //   223: aload 4
    //   225: astore_0
    //   226: aload 5
    //   228: astore 4
    //   230: aload_3
    //   231: ifnull +7 -> 238
    //   234: aload_3
    //   235: invokevirtual 299	java/io/BufferedInputStream:close	()V
    //   238: aload 4
    //   240: ifnull +8 -> 248
    //   243: aload 4
    //   245: invokevirtual 300	java/io/BufferedOutputStream:close	()V
    //   248: goto +5 -> 253
    //   251: aload_0
    //   252: athrow
    //   253: goto -2 -> 251
    //   256: astore_3
    //   257: goto -99 -> 158
    //   260: astore_0
    //   261: return
    //   262: astore_3
    //   263: goto -53 -> 210
    //   266: astore_3
    //   267: goto -29 -> 238
    //   270: astore_3
    //   271: goto -23 -> 248
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	274	0	paramContext	Context
    //   0	274	1	paramBoolean	boolean
    //   94	29	2	m	int
    //   36	199	3	localObject1	Object
    //   256	1	3	localException1	Exception
    //   262	1	3	localException2	Exception
    //   266	1	3	localException3	Exception
    //   270	1	3	localException4	Exception
    //   1	1	4	localObject2	Object
    //   163	1	4	localObject3	Object
    //   168	1	4	localThrowable1	Throwable
    //   177	1	4	localThrowable2	Throwable
    //   190	8	4	localThrowable3	Throwable
    //   218	6	4	localObject4	Object
    //   228	16	4	localObject5	Object
    //   4	223	5	localObject6	Object
    //   12	127	6	localFile	File
    //   79	33	7	str1	String
    //   88	13	8	str2	String
    // Exception table:
    //   from	to	target	type
    //   147	154	163	finally
    //   147	154	168	java/lang/Throwable
    //   37	65	173	finally
    //   69	130	173	finally
    //   130	147	173	finally
    //   37	65	177	java/lang/Throwable
    //   69	130	177	java/lang/Throwable
    //   130	147	177	java/lang/Throwable
    //   6	14	184	finally
    //   20	37	184	finally
    //   6	14	190	java/lang/Throwable
    //   20	37	190	java/lang/Throwable
    //   197	202	218	finally
    //   154	158	256	java/lang/Exception
    //   158	162	260	java/lang/Exception
    //   206	210	262	java/lang/Exception
    //   234	238	266	java/lang/Exception
    //   243	248	270	java/lang/Exception
  }
  
  static int d(Context paramContext)
  {
    return a(paramContext, true);
  }
  
  private static String[] d(Context paramContext, boolean paramBoolean)
  {
    if (QbSdk.getOnlyDownload()) {
      return new String[] { paramContext.getApplicationContext().getPackageName() };
    }
    String[] arrayOfString = getCoreProviderAppList();
    if (paramBoolean) {
      return new String[] { paramContext.getApplicationContext().getPackageName() };
    }
    return arrayOfString;
  }
  
  static Context e(Context paramContext)
  {
    j(paramContext);
    String str = f;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (str != null)
    {
      localObject1 = getPackageContext(paramContext, str, true);
      if (!p.a().f((Context)localObject1)) {
        localObject1 = localObject2;
      }
    }
    if (c != null) {
      return a;
    }
    return localObject1;
  }
  
  /* Error */
  static String f(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ldc 237
    //   6: invokestatic 240	com/tencent/smtt/sdk/TbsShareManager:getTbsShareFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   9: astore_0
    //   10: aload_0
    //   11: ifnonnull +8 -> 19
    //   14: ldc 2
    //   16: monitorexit
    //   17: aconst_null
    //   18: areturn
    //   19: new 242	java/io/BufferedInputStream
    //   22: dup
    //   23: new 244	java/io/FileInputStream
    //   26: dup
    //   27: aload_0
    //   28: invokespecial 247	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   31: invokespecial 250	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   34: astore_2
    //   35: aload_2
    //   36: astore_0
    //   37: new 252	java/util/Properties
    //   40: dup
    //   41: invokespecial 253	java/util/Properties:<init>	()V
    //   44: astore_3
    //   45: aload_2
    //   46: astore_0
    //   47: aload_3
    //   48: aload_2
    //   49: invokevirtual 256	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   52: aload_2
    //   53: astore_0
    //   54: aload_3
    //   55: ldc_w 277
    //   58: ldc_w 317
    //   61: invokevirtual 321	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   64: astore_3
    //   65: aload_2
    //   66: astore_0
    //   67: ldc_w 317
    //   70: aload_3
    //   71: invokevirtual 325	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   74: istore_1
    //   75: iload_1
    //   76: ifne +12 -> 88
    //   79: aload_2
    //   80: invokevirtual 299	java/io/BufferedInputStream:close	()V
    //   83: ldc 2
    //   85: monitorexit
    //   86: aload_3
    //   87: areturn
    //   88: aload_2
    //   89: invokevirtual 299	java/io/BufferedInputStream:close	()V
    //   92: ldc 2
    //   94: monitorexit
    //   95: aconst_null
    //   96: areturn
    //   97: astore_3
    //   98: goto +12 -> 110
    //   101: astore_0
    //   102: aconst_null
    //   103: astore_2
    //   104: goto +37 -> 141
    //   107: astore_3
    //   108: aconst_null
    //   109: astore_2
    //   110: aload_2
    //   111: astore_0
    //   112: aload_3
    //   113: invokevirtual 107	java/lang/Throwable:printStackTrace	()V
    //   116: aload_2
    //   117: ifnull +14 -> 131
    //   120: aload_2
    //   121: invokevirtual 299	java/io/BufferedInputStream:close	()V
    //   124: goto +7 -> 131
    //   127: astore_0
    //   128: goto +23 -> 151
    //   131: ldc 2
    //   133: monitorexit
    //   134: aconst_null
    //   135: areturn
    //   136: astore_3
    //   137: aload_0
    //   138: astore_2
    //   139: aload_3
    //   140: astore_0
    //   141: aload_2
    //   142: ifnull +7 -> 149
    //   145: aload_2
    //   146: invokevirtual 299	java/io/BufferedInputStream:close	()V
    //   149: aload_0
    //   150: athrow
    //   151: ldc 2
    //   153: monitorexit
    //   154: aload_0
    //   155: athrow
    //   156: astore_0
    //   157: goto -74 -> 83
    //   160: astore_0
    //   161: goto -69 -> 92
    //   164: astore_0
    //   165: goto -34 -> 131
    //   168: astore_2
    //   169: goto -20 -> 149
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	paramContext	Context
    //   74	2	1	bool	boolean
    //   34	112	2	localObject1	Object
    //   168	1	2	localException	Exception
    //   44	43	3	localObject2	Object
    //   97	1	3	localThrowable1	Throwable
    //   107	6	3	localThrowable2	Throwable
    //   136	4	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   37	45	97	java/lang/Throwable
    //   47	52	97	java/lang/Throwable
    //   54	65	97	java/lang/Throwable
    //   67	75	97	java/lang/Throwable
    //   3	10	101	finally
    //   19	35	101	finally
    //   3	10	107	java/lang/Throwable
    //   19	35	107	java/lang/Throwable
    //   79	83	127	finally
    //   88	92	127	finally
    //   120	124	127	finally
    //   145	149	127	finally
    //   149	151	127	finally
    //   37	45	136	finally
    //   47	52	136	finally
    //   54	65	136	finally
    //   67	75	136	finally
    //   112	116	136	finally
    //   79	83	156	java/lang/Exception
    //   88	92	160	java/lang/Exception
    //   120	124	164	java/lang/Exception
    //   145	149	168	java/lang/Exception
  }
  
  public static int findCoreForThirdPartyApp(Context paramContext)
  {
    n(paramContext);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("core_info mAvailableCoreVersion is ");
    ((StringBuilder)localObject).append(e);
    ((StringBuilder)localObject).append(" mAvailableCorePath is ");
    ((StringBuilder)localObject).append(d);
    ((StringBuilder)localObject).append(" mSrcPackageName is ");
    ((StringBuilder)localObject).append(f);
    TbsLog.i("TbsShareManager", ((StringBuilder)localObject).toString());
    if (f == null) {
      TbsLog.e("TbsShareManager", "mSrcPackageName is null !!!");
    }
    localObject = f;
    if ((localObject != null) && (((String)localObject).equals("AppDefined")))
    {
      if (e == p.a().a(c)) {
        break label218;
      }
      e = 0;
      d = null;
      f = null;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("check AppDefined core is error src is ");
      ((StringBuilder)localObject).append(e);
      ((StringBuilder)localObject).append(" dest is ");
      ((StringBuilder)localObject).append(p.a().a(c));
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      if ((k(paramContext)) || (l(paramContext))) {
        break label218;
      }
      e = 0;
      d = null;
      f = null;
      localObject = "core_info error checkCoreInfo is false and checkCoreInOthers is false ";
    }
    TbsLog.i("TbsShareManager", (String)localObject);
    label218:
    if (e > 0)
    {
      localObject = paramContext.getApplicationInfo();
      int m;
      if ((!"com.tencent.android.qqdownloader".equals(((ApplicationInfo)localObject).packageName)) && (!"com.jd.jrapp".equals(((ApplicationInfo)localObject).packageName))) {
        m = 0;
      } else {
        m = 1;
      }
      boolean bool;
      if (m == 0) {
        bool = QbSdk.a(paramContext, e);
      } else {
        bool = false;
      }
      if ((bool) || (g))
      {
        e = 0;
        d = null;
        f = null;
        TbsLog.i("TbsShareManager", "core_info error QbSdk.isX5Disabled ");
      }
    }
    return e;
  }
  
  public static boolean forceLoadX5FromTBSDemo(Context paramContext)
  {
    return false;
  }
  
  public static void forceToLoadX5ForThirdApp(Context paramContext, boolean paramBoolean) {}
  
  static String g(Context paramContext)
  {
    try
    {
      n(paramContext);
      if (d != null)
      {
        if (TextUtils.isEmpty(d)) {
          return null;
        }
        paramContext = new StringBuilder(d);
        paramContext.append(File.separator);
        paramContext.append("res.apk");
        return paramContext.toString();
      }
      return null;
    }
    catch (Throwable paramContext)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getTbsResourcesPath exception: ");
      localStringBuilder.append(Log.getStackTraceString(paramContext));
      Log.e("", localStringBuilder.toString());
    }
    return null;
  }
  
  public static File getBackupCoreFile(Context paramContext, String paramString)
  {
    try
    {
      paramContext = new File(new File(FileUtil.a(getPackageContext(paramContext, paramString, false), 4)), TbsDownloader.getBackupFileName(false));
      boolean bool = paramContext.exists();
      if (bool) {
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      label40:
      break label40;
    }
    return null;
  }
  
  public static int getBackupCoreVersion(Context paramContext, String paramString)
  {
    try
    {
      paramContext = new File(new File(FileUtil.a(getPackageContext(paramContext, paramString, false), 4)), TbsDownloader.getBackupFileName(false));
      if (paramContext.exists())
      {
        int m = a.b(paramContext);
        return m;
      }
      return 0;
    }
    catch (Throwable paramContext) {}
    return 0;
  }
  
  public static File getBackupDecoupleCoreFile(Context paramContext, String paramString)
  {
    try
    {
      paramContext = new File(new File(FileUtil.a(getPackageContext(paramContext, paramString, true), 4)), TbsDownloader.getBackupFileName(true));
      boolean bool = paramContext.exists();
      if (bool) {
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      label40:
      break label40;
    }
    return null;
  }
  
  public static int getBackupDecoupleCoreVersion(Context paramContext, String paramString)
  {
    try
    {
      paramContext = new File(new File(FileUtil.a(getPackageContext(paramContext, paramString, false), 4)), TbsDownloader.getBackupFileName(true));
      if (paramContext.exists())
      {
        int m = a.b(paramContext);
        return m;
      }
      return 0;
    }
    catch (Throwable paramContext) {}
    return 0;
  }
  
  public static boolean getCoreDisabled()
  {
    return g;
  }
  
  public static boolean getCoreFormOwn()
  {
    return k;
  }
  
  public static String[] getCoreProviderAppList()
  {
    return new String[] { "com.tencent.tbs", "com.tencent.mm", "com.tencent.mobileqq", "com.qzone", "com.tencent.qqlite" };
  }
  
  public static int getCoreShareDecoupleCoreVersion(Context paramContext, String paramString)
  {
    return 0;
  }
  
  public static String getHostCorePathAppDefined()
  {
    return c;
  }
  
  public static long getHostCoreVersions(Context paramContext)
  {
    String[] arrayOfString = getCoreProviderAppList();
    int n = arrayOfString.length;
    long l1 = 0L;
    int m = 0;
    while (m < n)
    {
      String str = arrayOfString[m];
      long l2;
      long l3;
      if (str.equalsIgnoreCase("com.tencent.mm"))
      {
        l2 = getSharedTbsCoreVersion(paramContext, str);
        l3 = 10000000000L;
      }
      for (l2 *= l3;; l2 = getSharedTbsCoreVersion(paramContext, str))
      {
        l2 = l1 + l2;
        break label116;
        if (str.equalsIgnoreCase("com.tencent.mobileqq"))
        {
          l2 = getSharedTbsCoreVersion(paramContext, str);
          l3 = 100000L;
          break;
        }
        l2 = l1;
        if (!str.equalsIgnoreCase("com.qzone")) {
          break label116;
        }
      }
      label116:
      m += 1;
      l1 = l2;
    }
    return l1;
  }
  
  public static Context getPackageContext(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      if (!paramContext.getPackageName().equals(paramString))
      {
        TbsLog.i("TbsShareManager", "gray no core app,skip get context");
        if (TbsPVConfig.getInstance(paramContext).isEnableNoCoreGray()) {
          break label62;
        }
        if (Build.VERSION.SDK_INT >= 29) {
          return null;
        }
      }
      paramContext = paramContext.createPackageContext(paramString, 2);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      return null;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      return null;
    }
    label62:
    return null;
  }
  
  public static int getSharedTbsCoreVersion(Context paramContext, String paramString)
  {
    paramContext = getPackageContext(paramContext, paramString, true);
    if (paramContext != null) {
      return p.a().i(paramContext);
    }
    return 0;
  }
  
  public static File getTbsShareFile(Context paramContext, String paramString)
  {
    paramContext = p.a().r(paramContext);
    if (paramContext == null) {
      return null;
    }
    paramContext = new File(paramContext, paramString);
    if (paramContext.exists()) {
      return paramContext;
    }
    try
    {
      paramContext.createNewFile();
      return paramContext;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  /* Error */
  static int h(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 42
    //   5: ldc_w 458
    //   8: invokestatic 49	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   11: aload_0
    //   12: ldc 237
    //   14: invokestatic 240	com/tencent/smtt/sdk/TbsShareManager:getTbsShareFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   17: astore_0
    //   18: aload_0
    //   19: ifnonnull +16 -> 35
    //   22: ldc 42
    //   24: ldc_w 460
    //   27: invokestatic 49	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: ldc 2
    //   32: monitorexit
    //   33: iconst_0
    //   34: ireturn
    //   35: new 242	java/io/BufferedInputStream
    //   38: dup
    //   39: new 244	java/io/FileInputStream
    //   42: dup
    //   43: aload_0
    //   44: invokespecial 247	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   47: invokespecial 250	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   50: astore_2
    //   51: aload_2
    //   52: astore_0
    //   53: new 252	java/util/Properties
    //   56: dup
    //   57: invokespecial 253	java/util/Properties:<init>	()V
    //   60: astore_3
    //   61: aload_2
    //   62: astore_0
    //   63: aload_3
    //   64: aload_2
    //   65: invokevirtual 256	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   68: aload_2
    //   69: astore_0
    //   70: aload_3
    //   71: ldc_w 462
    //   74: ldc_w 317
    //   77: invokevirtual 321	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   80: astore_3
    //   81: aload_2
    //   82: astore_0
    //   83: ldc_w 317
    //   86: aload_3
    //   87: invokevirtual 325	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   90: ifne +41 -> 131
    //   93: aload_2
    //   94: astore_0
    //   95: ldc 42
    //   97: ldc_w 464
    //   100: invokestatic 49	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   103: aload_2
    //   104: astore_0
    //   105: aload_3
    //   106: invokestatic 469	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   109: iconst_0
    //   110: invokestatic 475	java/lang/Math:max	(II)I
    //   113: istore_1
    //   114: aload_2
    //   115: invokevirtual 299	java/io/BufferedInputStream:close	()V
    //   118: goto +8 -> 126
    //   121: astore_0
    //   122: aload_0
    //   123: invokevirtual 448	java/lang/Exception:printStackTrace	()V
    //   126: ldc 2
    //   128: monitorexit
    //   129: iload_1
    //   130: ireturn
    //   131: aload_2
    //   132: astore_0
    //   133: ldc 42
    //   135: ldc_w 477
    //   138: invokestatic 49	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   141: aload_2
    //   142: invokevirtual 299	java/io/BufferedInputStream:close	()V
    //   145: goto +8 -> 153
    //   148: astore_0
    //   149: aload_0
    //   150: invokevirtual 448	java/lang/Exception:printStackTrace	()V
    //   153: ldc 2
    //   155: monitorexit
    //   156: iconst_0
    //   157: ireturn
    //   158: astore_3
    //   159: goto +12 -> 171
    //   162: astore_0
    //   163: aconst_null
    //   164: astore_2
    //   165: goto +47 -> 212
    //   168: astore_3
    //   169: aconst_null
    //   170: astore_2
    //   171: aload_2
    //   172: astore_0
    //   173: aload_3
    //   174: invokevirtual 107	java/lang/Throwable:printStackTrace	()V
    //   177: aload_2
    //   178: ifnull +15 -> 193
    //   181: aload_2
    //   182: invokevirtual 299	java/io/BufferedInputStream:close	()V
    //   185: goto +8 -> 193
    //   188: astore_0
    //   189: aload_0
    //   190: invokevirtual 448	java/lang/Exception:printStackTrace	()V
    //   193: ldc 42
    //   195: ldc_w 479
    //   198: invokestatic 49	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   201: ldc 2
    //   203: monitorexit
    //   204: bipush 254
    //   206: ireturn
    //   207: astore_3
    //   208: aload_0
    //   209: astore_2
    //   210: aload_3
    //   211: astore_0
    //   212: aload_2
    //   213: ifnull +15 -> 228
    //   216: aload_2
    //   217: invokevirtual 299	java/io/BufferedInputStream:close	()V
    //   220: goto +8 -> 228
    //   223: astore_2
    //   224: aload_2
    //   225: invokevirtual 448	java/lang/Exception:printStackTrace	()V
    //   228: aload_0
    //   229: athrow
    //   230: astore_0
    //   231: ldc 2
    //   233: monitorexit
    //   234: aload_0
    //   235: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	236	0	paramContext	Context
    //   113	17	1	m	int
    //   50	167	2	localObject1	Object
    //   223	2	2	localException	Exception
    //   60	46	3	localObject2	Object
    //   158	1	3	localThrowable1	Throwable
    //   168	6	3	localThrowable2	Throwable
    //   207	4	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   114	118	121	java/lang/Exception
    //   141	145	148	java/lang/Exception
    //   53	61	158	java/lang/Throwable
    //   63	68	158	java/lang/Throwable
    //   70	81	158	java/lang/Throwable
    //   83	93	158	java/lang/Throwable
    //   95	103	158	java/lang/Throwable
    //   105	114	158	java/lang/Throwable
    //   133	141	158	java/lang/Throwable
    //   11	18	162	finally
    //   22	30	162	finally
    //   35	51	162	finally
    //   11	18	168	java/lang/Throwable
    //   22	30	168	java/lang/Throwable
    //   35	51	168	java/lang/Throwable
    //   181	185	188	java/lang/Exception
    //   53	61	207	finally
    //   63	68	207	finally
    //   70	81	207	finally
    //   83	93	207	finally
    //   95	103	207	finally
    //   105	114	207	finally
    //   133	141	207	finally
    //   173	177	207	finally
    //   216	220	223	java/lang/Exception
    //   3	11	230	finally
    //   114	118	230	finally
    //   122	126	230	finally
    //   141	145	230	finally
    //   149	153	230	finally
    //   181	185	230	finally
    //   189	193	230	finally
    //   193	201	230	finally
    //   216	220	230	finally
    //   224	228	230	finally
    //   228	230	230	finally
  }
  
  static boolean i(Context paramContext)
  {
    try
    {
      if (e == 0) {
        findCoreForThirdPartyApp(paramContext);
      }
      if (e == 0)
      {
        TbsLog.addLog(994, null, new Object[0]);
        return false;
      }
      if (c == null)
      {
        if ((e != 0) && (getSharedTbsCoreVersion(paramContext, f) == e)) {
          return true;
        }
      }
      else if ((e != 0) && (p.a().a(c) == e)) {
        return true;
      }
      if (l(paramContext)) {
        return true;
      }
      TbsCoreLoadStat localTbsCoreLoadStat = TbsCoreLoadStat.getInstance();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mAvailableCoreVersion=");
      localStringBuilder.append(e);
      localStringBuilder.append("; mSrcPackageName=");
      localStringBuilder.append(f);
      localStringBuilder.append("; getSharedTbsCoreVersion(ctx, mSrcPackageName) is ");
      localStringBuilder.append(getSharedTbsCoreVersion(paramContext, f));
      localStringBuilder.append("; getHostCoreVersions is ");
      localStringBuilder.append(getHostCoreVersions(paramContext));
      localTbsCoreLoadStat.a(paramContext, 418, new Throwable(localStringBuilder.toString()));
      d = null;
      e = 0;
      TbsLog.addLog(993, null, new Object[0]);
      QbSdk.a(paramContext, "TbsShareManager::isShareTbsCoreAvailableInner forceSysWebViewInner!");
      return false;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
      TbsLog.addLog(992, null, new Object[0]);
    }
    return false;
  }
  
  public static boolean isThirdPartyApp(Context paramContext)
  {
    try
    {
      if ((a != null) && (a.equals(paramContext.getApplicationContext()))) {
        return b;
      }
      a = paramContext.getApplicationContext();
      paramContext = a.getPackageName();
      String[] arrayOfString = getCoreProviderAppList();
      int n = arrayOfString.length;
      int m = 0;
      while (m < n)
      {
        if (paramContext.equals(arrayOfString[m]))
        {
          b = false;
          return false;
        }
        m += 1;
      }
      return true;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
      b = true;
    }
  }
  
  static boolean j(Context paramContext)
  {
    return b(paramContext, true);
  }
  
  private static boolean k(Context paramContext)
  {
    String str = f;
    if (str == null) {
      return false;
    }
    return e == getSharedTbsCoreVersion(paramContext, str);
  }
  
  private static boolean l(Context paramContext)
  {
    if (QbSdk.getOnlyDownload()) {
      return false;
    }
    String[] arrayOfString = getCoreProviderAppList();
    int n = arrayOfString.length;
    int m = 0;
    while (m < n)
    {
      String str = arrayOfString[m];
      int i1 = e;
      if ((i1 > 0) && (i1 == getSharedTbsCoreVersion(paramContext, str)))
      {
        Context localContext = getPackageContext(paramContext, str, true);
        if (p.a().f(paramContext))
        {
          d = p.a().b(paramContext, localContext).getAbsolutePath();
          f = str;
          return true;
        }
      }
      m += 1;
    }
    return false;
  }
  
  private static boolean m(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    writeProperties(paramContext, Integer.toString(0), "", "", Integer.toString(0));
    return true;
  }
  
  /* Error */
  private static void n(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 525	com/tencent/smtt/sdk/TbsShareManager:l	Z
    //   3: ifeq +4 -> 7
    //   6: return
    //   7: ldc 2
    //   9: monitorenter
    //   10: getstatic 525	com/tencent/smtt/sdk/TbsShareManager:l	Z
    //   13: ifeq +7 -> 20
    //   16: ldc 2
    //   18: monitorexit
    //   19: return
    //   20: aload_0
    //   21: ldc 237
    //   23: invokestatic 240	com/tencent/smtt/sdk/TbsShareManager:getTbsShareFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   26: astore_0
    //   27: aload_0
    //   28: ifnonnull +7 -> 35
    //   31: ldc 2
    //   33: monitorexit
    //   34: return
    //   35: new 242	java/io/BufferedInputStream
    //   38: dup
    //   39: new 244	java/io/FileInputStream
    //   42: dup
    //   43: aload_0
    //   44: invokespecial 247	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   47: invokespecial 250	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   50: astore_1
    //   51: aload_1
    //   52: astore_0
    //   53: new 252	java/util/Properties
    //   56: dup
    //   57: invokespecial 253	java/util/Properties:<init>	()V
    //   60: astore_2
    //   61: aload_1
    //   62: astore_0
    //   63: aload_2
    //   64: aload_1
    //   65: invokevirtual 256	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   68: aload_1
    //   69: astore_0
    //   70: aload_2
    //   71: ldc_w 462
    //   74: ldc_w 317
    //   77: invokevirtual 321	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   80: astore_3
    //   81: aload_1
    //   82: astore_0
    //   83: ldc_w 317
    //   86: aload_3
    //   87: invokevirtual 325	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   90: ifne +87 -> 177
    //   93: aload_1
    //   94: astore_0
    //   95: aload_3
    //   96: invokestatic 469	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   99: iconst_0
    //   100: invokestatic 475	java/lang/Math:max	(II)I
    //   103: putstatic 34	com/tencent/smtt/sdk/TbsShareManager:e	I
    //   106: aload_1
    //   107: astore_0
    //   108: new 70	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   115: astore_3
    //   116: aload_1
    //   117: astore_0
    //   118: aload_3
    //   119: ldc_w 527
    //   122: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: pop
    //   126: aload_1
    //   127: astore_0
    //   128: aload_3
    //   129: getstatic 34	com/tencent/smtt/sdk/TbsShareManager:e	I
    //   132: invokevirtual 172	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   135: pop
    //   136: aload_1
    //   137: astore_0
    //   138: aload_3
    //   139: ldc_w 529
    //   142: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: aload_1
    //   147: astore_0
    //   148: aload_3
    //   149: new 40	java/lang/Throwable
    //   152: dup
    //   153: ldc_w 531
    //   156: invokespecial 504	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   159: invokestatic 148	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   162: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: pop
    //   166: aload_1
    //   167: astore_0
    //   168: ldc 42
    //   170: aload_3
    //   171: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokestatic 49	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   177: aload_1
    //   178: astore_0
    //   179: aload_2
    //   180: ldc_w 277
    //   183: ldc_w 317
    //   186: invokevirtual 321	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   189: astore_3
    //   190: aload_1
    //   191: astore_0
    //   192: ldc_w 317
    //   195: aload_3
    //   196: invokevirtual 325	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   199: ifne +9 -> 208
    //   202: aload_1
    //   203: astore_0
    //   204: aload_3
    //   205: putstatic 313	com/tencent/smtt/sdk/TbsShareManager:f	Ljava/lang/String;
    //   208: aload_1
    //   209: astore_0
    //   210: getstatic 313	com/tencent/smtt/sdk/TbsShareManager:f	Ljava/lang/String;
    //   213: ifnull +43 -> 256
    //   216: aload_1
    //   217: astore_0
    //   218: getstatic 110	com/tencent/smtt/sdk/TbsShareManager:a	Landroid/content/Context;
    //   221: ifnull +35 -> 256
    //   224: aload_1
    //   225: astore_0
    //   226: getstatic 313	com/tencent/smtt/sdk/TbsShareManager:f	Ljava/lang/String;
    //   229: getstatic 110	com/tencent/smtt/sdk/TbsShareManager:a	Landroid/content/Context;
    //   232: invokevirtual 139	android/content/Context:getPackageName	()Ljava/lang/String;
    //   235: invokevirtual 325	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   238: ifeq +12 -> 250
    //   241: aload_1
    //   242: astore_0
    //   243: iconst_1
    //   244: putstatic 414	com/tencent/smtt/sdk/TbsShareManager:k	Z
    //   247: goto +9 -> 256
    //   250: aload_1
    //   251: astore_0
    //   252: iconst_0
    //   253: putstatic 414	com/tencent/smtt/sdk/TbsShareManager:k	Z
    //   256: aload_1
    //   257: astore_0
    //   258: aload_2
    //   259: ldc_w 279
    //   262: ldc_w 317
    //   265: invokevirtual 321	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   268: astore_3
    //   269: aload_1
    //   270: astore_0
    //   271: ldc_w 317
    //   274: aload_3
    //   275: invokevirtual 325	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   278: ifne +9 -> 287
    //   281: aload_1
    //   282: astore_0
    //   283: aload_3
    //   284: putstatic 37	com/tencent/smtt/sdk/TbsShareManager:d	Ljava/lang/String;
    //   287: aload_1
    //   288: astore_0
    //   289: aload_2
    //   290: ldc_w 281
    //   293: ldc_w 317
    //   296: invokevirtual 321	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   299: astore_3
    //   300: aload_1
    //   301: astore_0
    //   302: ldc_w 317
    //   305: aload_3
    //   306: invokevirtual 325	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   309: ifne +9 -> 318
    //   312: aload_1
    //   313: astore_0
    //   314: aload_3
    //   315: putstatic 533	com/tencent/smtt/sdk/TbsShareManager:j	Ljava/lang/String;
    //   318: aload_1
    //   319: astore_0
    //   320: aload_2
    //   321: ldc_w 258
    //   324: ldc_w 535
    //   327: invokevirtual 321	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   330: invokestatic 540	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   333: putstatic 371	com/tencent/smtt/sdk/TbsShareManager:g	Z
    //   336: aload_1
    //   337: astore_0
    //   338: iconst_1
    //   339: putstatic 525	com/tencent/smtt/sdk/TbsShareManager:l	Z
    //   342: aload_1
    //   343: invokevirtual 299	java/io/BufferedInputStream:close	()V
    //   346: goto +45 -> 391
    //   349: astore_0
    //   350: aload_0
    //   351: invokevirtual 448	java/lang/Exception:printStackTrace	()V
    //   354: goto +37 -> 391
    //   357: astore_2
    //   358: goto +12 -> 370
    //   361: astore_0
    //   362: aconst_null
    //   363: astore_1
    //   364: goto +36 -> 400
    //   367: astore_2
    //   368: aconst_null
    //   369: astore_1
    //   370: aload_1
    //   371: astore_0
    //   372: aload_2
    //   373: invokevirtual 107	java/lang/Throwable:printStackTrace	()V
    //   376: aload_1
    //   377: ifnull +14 -> 391
    //   380: aload_1
    //   381: invokevirtual 299	java/io/BufferedInputStream:close	()V
    //   384: goto +7 -> 391
    //   387: astore_0
    //   388: goto -38 -> 350
    //   391: ldc 2
    //   393: monitorexit
    //   394: return
    //   395: astore_2
    //   396: aload_0
    //   397: astore_1
    //   398: aload_2
    //   399: astore_0
    //   400: aload_1
    //   401: ifnull +15 -> 416
    //   404: aload_1
    //   405: invokevirtual 299	java/io/BufferedInputStream:close	()V
    //   408: goto +8 -> 416
    //   411: astore_1
    //   412: aload_1
    //   413: invokevirtual 448	java/lang/Exception:printStackTrace	()V
    //   416: aload_0
    //   417: athrow
    //   418: astore_0
    //   419: ldc 2
    //   421: monitorexit
    //   422: goto +5 -> 427
    //   425: aload_0
    //   426: athrow
    //   427: goto -2 -> 425
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	430	0	paramContext	Context
    //   50	355	1	localObject1	Object
    //   411	2	1	localException	Exception
    //   60	261	2	localProperties	java.util.Properties
    //   357	1	2	localThrowable1	Throwable
    //   367	6	2	localThrowable2	Throwable
    //   395	4	2	localObject2	Object
    //   80	235	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   342	346	349	java/lang/Exception
    //   53	61	357	java/lang/Throwable
    //   63	68	357	java/lang/Throwable
    //   70	81	357	java/lang/Throwable
    //   83	93	357	java/lang/Throwable
    //   95	106	357	java/lang/Throwable
    //   108	116	357	java/lang/Throwable
    //   118	126	357	java/lang/Throwable
    //   128	136	357	java/lang/Throwable
    //   138	146	357	java/lang/Throwable
    //   148	166	357	java/lang/Throwable
    //   168	177	357	java/lang/Throwable
    //   179	190	357	java/lang/Throwable
    //   192	202	357	java/lang/Throwable
    //   204	208	357	java/lang/Throwable
    //   210	216	357	java/lang/Throwable
    //   218	224	357	java/lang/Throwable
    //   226	241	357	java/lang/Throwable
    //   243	247	357	java/lang/Throwable
    //   252	256	357	java/lang/Throwable
    //   258	269	357	java/lang/Throwable
    //   271	281	357	java/lang/Throwable
    //   283	287	357	java/lang/Throwable
    //   289	300	357	java/lang/Throwable
    //   302	312	357	java/lang/Throwable
    //   314	318	357	java/lang/Throwable
    //   320	336	357	java/lang/Throwable
    //   338	342	357	java/lang/Throwable
    //   20	27	361	finally
    //   35	51	361	finally
    //   20	27	367	java/lang/Throwable
    //   35	51	367	java/lang/Throwable
    //   380	384	387	java/lang/Exception
    //   53	61	395	finally
    //   63	68	395	finally
    //   70	81	395	finally
    //   83	93	395	finally
    //   95	106	395	finally
    //   108	116	395	finally
    //   118	126	395	finally
    //   128	136	395	finally
    //   138	146	395	finally
    //   148	166	395	finally
    //   168	177	395	finally
    //   179	190	395	finally
    //   192	202	395	finally
    //   204	208	395	finally
    //   210	216	395	finally
    //   218	224	395	finally
    //   226	241	395	finally
    //   243	247	395	finally
    //   252	256	395	finally
    //   258	269	395	finally
    //   271	281	395	finally
    //   283	287	395	finally
    //   289	300	395	finally
    //   302	312	395	finally
    //   314	318	395	finally
    //   320	336	395	finally
    //   338	342	395	finally
    //   372	376	395	finally
    //   404	408	411	java/lang/Exception
    //   10	19	418	finally
    //   31	34	418	finally
    //   342	346	418	finally
    //   350	354	418	finally
    //   380	384	418	finally
    //   391	394	418	finally
    //   404	408	418	finally
    //   412	416	418	finally
    //   416	418	418	finally
    //   419	422	418	finally
  }
  
  public static void setHostCorePathAppDefined(String paramString)
  {
    c = paramString;
  }
  
  public static void writeCoreInfoForThirdPartyApp(Context paramContext, int paramInt, boolean paramBoolean)
  {
    try
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("writeCoreInfoForThirdPartyApp coreVersion is ");
      ((StringBuilder)localObject1).append(paramInt);
      TbsLog.i("TbsShareManager", ((StringBuilder)localObject1).toString());
      if (paramInt == 0)
      {
        m(paramContext);
        TbsDownloadConfig.getInstance(a).setDownloadInterruptCode(-401);
        return;
      }
      m = h(paramContext);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("writeCoreInfoForThirdPartyApp coreVersionFromConfig is ");
      ((StringBuilder)localObject1).append(m);
      TbsLog.i("TbsShareManager", ((StringBuilder)localObject1).toString());
      if (m < 0)
      {
        TbsDownloadConfig.getInstance(a).setDownloadInterruptCode(-402);
        return;
      }
      if (paramInt == m)
      {
        if ((d(paramContext) == 0) && (!paramBoolean)) {
          a(paramContext, paramInt);
        }
        c(paramContext, paramBoolean);
        TbsDownloadConfig.getInstance(a).setDownloadInterruptCode(-403);
        return;
      }
      if (paramInt < m)
      {
        m(paramContext);
        TbsDownloadConfig.getInstance(a).setDownloadInterruptCode(-404);
        return;
      }
      m = p.a().i(paramContext);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("writeCoreInfoForThirdPartyApp coreVersionFromCoreShare is ");
      ((StringBuilder)localObject1).append(m);
      TbsLog.i("TbsShareManager", ((StringBuilder)localObject1).toString());
      if (paramInt < m)
      {
        m(paramContext);
        TbsDownloadConfig.getInstance(a).setDownloadInterruptCode(-404);
        return;
      }
      localObject1 = d(paramContext, paramBoolean);
      localObject2 = c;
      i1 = 0;
      if (localObject2 != null)
      {
        if (paramInt == p.a().a(c))
        {
          writeProperties(paramContext, Integer.toString(paramInt), "AppDefined", c, Integer.toString(1));
          try
          {
            localObject1 = getTbsShareFile(paramContext, "core_info");
            if ((!i) && (localObject1 != null))
            {
              localObject2 = new TbsLinuxToolsJni(a);
              ((TbsLinuxToolsJni)localObject2).a(((File)localObject1).getAbsolutePath(), "644");
              ((TbsLinuxToolsJni)localObject2).a(p.a().r(paramContext).getAbsolutePath(), "755");
              i = true;
            }
          }
          catch (Throwable paramContext)
          {
            paramContext.printStackTrace();
          }
          return;
        }
        if (paramInt > p.a().a(c))
        {
          n = localObject1.length;
          m = 0;
          while (m < n)
          {
            localObject2 = localObject1[m];
            if (paramInt == getSharedTbsCoreVersion(paramContext, (String)localObject2))
            {
              localObject3 = getPackageContext(paramContext, (String)localObject2, true);
              localObject2 = p.a().q((Context)localObject3).getAbsolutePath();
              b.d(paramContext);
              if (p.a().f((Context)localObject3))
              {
                localObject1 = new File(c);
                localObject2 = new File((String)localObject2);
                localObject3 = new TbsShareManager.1();
                try
                {
                  FileUtil.a((File)localObject2, (File)localObject1, (FileFilter)localObject3);
                  writeProperties(paramContext, Integer.toString(paramInt), "AppDefined", c, Integer.toString(1));
                  localObject1 = getTbsShareFile(paramContext, "core_info");
                  if ((!i) && (localObject1 != null))
                  {
                    localObject2 = new TbsLinuxToolsJni(a);
                    ((TbsLinuxToolsJni)localObject2).a(((File)localObject1).getAbsolutePath(), "644");
                    ((TbsLinuxToolsJni)localObject2).a(p.a().r(paramContext).getAbsolutePath(), "755");
                    i = true;
                  }
                }
                catch (Throwable paramContext)
                {
                  paramContext.printStackTrace();
                }
                return;
              }
            }
            m += 1;
          }
        }
      }
      i2 = localObject1.length;
      m = 0;
    }
    finally
    {
      for (;;)
      {
        Object localObject1;
        int m;
        Object localObject2;
        int i1;
        int n;
        Object localObject3;
        int i2;
        for (;;)
        {
          throw paramContext;
        }
        label902:
        m += 1;
      }
    }
    n = i1;
    if (m < i2)
    {
      localObject2 = localObject1[m];
      try
      {
        if (paramInt != getSharedTbsCoreVersion(paramContext, (String)localObject2)) {
          break label902;
        }
        Object localObject4 = getPackageContext(paramContext, (String)localObject2, true);
        if (localObject4 == null) {
          break label902;
        }
        localObject3 = p.a().q((Context)localObject4).getAbsolutePath();
        n = b.d(paramContext);
        if (!p.a().f((Context)localObject4)) {
          break label902;
        }
        if (!((String)localObject2).equals(paramContext.getApplicationContext().getPackageName()))
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("thirdAPP pre--> delete old core_share Directory:");
          ((StringBuilder)localObject4).append(paramInt);
          TbsLog.i("TbsShareManager", ((StringBuilder)localObject4).toString());
          m.a(a).a("remove_old_core", 1);
        }
        writeProperties(paramContext, Integer.toString(paramInt), (String)localObject2, (String)localObject3, Integer.toString(n));
        try
        {
          localObject2 = getTbsShareFile(paramContext, "core_info");
          if ((!i) && (localObject2 != null))
          {
            localObject3 = new TbsLinuxToolsJni(a);
            ((TbsLinuxToolsJni)localObject3).a(((File)localObject2).getAbsolutePath(), "644");
            ((TbsLinuxToolsJni)localObject3).a(p.a().r(paramContext).getAbsolutePath(), "755");
            i = true;
          }
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
        }
        n = 1;
      }
      catch (Exception localException)
      {
        TbsLog.i(localException);
        break label902;
      }
    }
    if ((n == 0) && (!paramBoolean)) {
      a(paramContext, paramInt);
    }
  }
  
  /* Error */
  public static void writeProperties(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    // Byte code:
    //   0: new 70	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   7: astore 6
    //   9: aload 6
    //   11: ldc_w 594
    //   14: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: pop
    //   18: aload 6
    //   20: aload_1
    //   21: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: pop
    //   25: aload 6
    //   27: ldc_w 596
    //   30: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload 6
    //   36: aload_2
    //   37: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload 6
    //   43: ldc_w 598
    //   46: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload 6
    //   52: aload_3
    //   53: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: ldc 42
    //   59: aload 6
    //   61: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokestatic 49	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   67: new 70	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   74: astore 6
    //   76: aload 6
    //   78: ldc_w 600
    //   81: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload 6
    //   87: new 40	java/lang/Throwable
    //   90: dup
    //   91: ldc_w 531
    //   94: invokespecial 504	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   97: invokestatic 148	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   100: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: ldc 42
    //   106: aload 6
    //   108: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokestatic 49	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   114: aconst_null
    //   115: astore 6
    //   117: aconst_null
    //   118: astore 7
    //   120: aload_0
    //   121: ldc 237
    //   123: invokestatic 240	com/tencent/smtt/sdk/TbsShareManager:getTbsShareFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   126: astore 8
    //   128: aload 8
    //   130: ifnonnull +16 -> 146
    //   133: getstatic 110	com/tencent/smtt/sdk/TbsShareManager:a	Landroid/content/Context;
    //   136: invokestatic 552	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   139: sipush -405
    //   142: invokevirtual 556	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   145: return
    //   146: new 242	java/io/BufferedInputStream
    //   149: dup
    //   150: new 244	java/io/FileInputStream
    //   153: dup
    //   154: aload 8
    //   156: invokespecial 247	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   159: invokespecial 250	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   162: astore_0
    //   163: new 252	java/util/Properties
    //   166: dup
    //   167: invokespecial 253	java/util/Properties:<init>	()V
    //   170: astore 7
    //   172: aload 7
    //   174: aload_0
    //   175: invokevirtual 256	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   178: aload_1
    //   179: invokestatic 469	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   182: istore 5
    //   184: goto +6 -> 190
    //   187: iconst_0
    //   188: istore 5
    //   190: iload 5
    //   192: ifeq +60 -> 252
    //   195: aload 7
    //   197: ldc_w 462
    //   200: aload_1
    //   201: invokevirtual 266	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   204: pop
    //   205: aload 7
    //   207: ldc_w 258
    //   210: iconst_0
    //   211: invokestatic 262	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   214: invokevirtual 266	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   217: pop
    //   218: aload 7
    //   220: ldc_w 277
    //   223: aload_2
    //   224: invokevirtual 266	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   227: pop
    //   228: aload 7
    //   230: ldc_w 279
    //   233: aload_3
    //   234: invokevirtual 266	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   237: pop
    //   238: aload 7
    //   240: ldc_w 281
    //   243: aload 4
    //   245: invokevirtual 266	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   248: pop
    //   249: goto +16 -> 265
    //   252: aload 7
    //   254: ldc_w 258
    //   257: iconst_1
    //   258: invokestatic 262	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   261: invokevirtual 266	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   264: pop
    //   265: new 286	java/io/BufferedOutputStream
    //   268: dup
    //   269: new 288	java/io/FileOutputStream
    //   272: dup
    //   273: aload 8
    //   275: invokespecial 289	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   278: invokespecial 292	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   281: astore_1
    //   282: aload 7
    //   284: aload_1
    //   285: aconst_null
    //   286: invokevirtual 296	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   289: iconst_0
    //   290: putstatic 525	com/tencent/smtt/sdk/TbsShareManager:l	Z
    //   293: getstatic 110	com/tencent/smtt/sdk/TbsShareManager:a	Landroid/content/Context;
    //   296: invokestatic 552	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   299: sipush -406
    //   302: invokevirtual 556	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   305: aload_0
    //   306: invokevirtual 299	java/io/BufferedInputStream:close	()V
    //   309: goto +8 -> 317
    //   312: astore_0
    //   313: aload_0
    //   314: invokevirtual 448	java/lang/Exception:printStackTrace	()V
    //   317: aload_1
    //   318: invokevirtual 300	java/io/BufferedOutputStream:close	()V
    //   321: return
    //   322: astore_3
    //   323: aload_0
    //   324: astore_2
    //   325: aload_3
    //   326: astore_0
    //   327: goto +79 -> 406
    //   330: astore_2
    //   331: goto +35 -> 366
    //   334: astore_3
    //   335: aload 6
    //   337: astore_1
    //   338: aload_0
    //   339: astore_2
    //   340: aload_3
    //   341: astore_0
    //   342: goto +64 -> 406
    //   345: astore_2
    //   346: aconst_null
    //   347: astore_1
    //   348: goto +18 -> 366
    //   351: astore_0
    //   352: aconst_null
    //   353: astore_2
    //   354: aload 6
    //   356: astore_1
    //   357: goto +49 -> 406
    //   360: astore_2
    //   361: aconst_null
    //   362: astore_1
    //   363: aload 7
    //   365: astore_0
    //   366: aload_2
    //   367: invokevirtual 107	java/lang/Throwable:printStackTrace	()V
    //   370: aload_0
    //   371: ifnull +15 -> 386
    //   374: aload_0
    //   375: invokevirtual 299	java/io/BufferedInputStream:close	()V
    //   378: goto +8 -> 386
    //   381: astore_0
    //   382: aload_0
    //   383: invokevirtual 448	java/lang/Exception:printStackTrace	()V
    //   386: aload_1
    //   387: ifnull +13 -> 400
    //   390: aload_1
    //   391: invokevirtual 300	java/io/BufferedOutputStream:close	()V
    //   394: return
    //   395: astore_0
    //   396: aload_0
    //   397: invokevirtual 448	java/lang/Exception:printStackTrace	()V
    //   400: return
    //   401: astore_3
    //   402: aload_0
    //   403: astore_2
    //   404: aload_3
    //   405: astore_0
    //   406: aload_2
    //   407: ifnull +15 -> 422
    //   410: aload_2
    //   411: invokevirtual 299	java/io/BufferedInputStream:close	()V
    //   414: goto +8 -> 422
    //   417: astore_2
    //   418: aload_2
    //   419: invokevirtual 448	java/lang/Exception:printStackTrace	()V
    //   422: aload_1
    //   423: ifnull +15 -> 438
    //   426: aload_1
    //   427: invokevirtual 300	java/io/BufferedOutputStream:close	()V
    //   430: goto +8 -> 438
    //   433: astore_1
    //   434: aload_1
    //   435: invokevirtual 448	java/lang/Exception:printStackTrace	()V
    //   438: aload_0
    //   439: athrow
    //   440: astore 9
    //   442: goto -255 -> 187
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	445	0	paramContext	Context
    //   0	445	1	paramString1	String
    //   0	445	2	paramString2	String
    //   0	445	3	paramString3	String
    //   0	445	4	paramString4	String
    //   182	9	5	m	int
    //   7	348	6	localStringBuilder	StringBuilder
    //   118	246	7	localProperties	java.util.Properties
    //   126	148	8	localFile	File
    //   440	1	9	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   305	309	312	java/lang/Exception
    //   282	305	322	finally
    //   282	305	330	java/lang/Throwable
    //   163	178	334	finally
    //   178	184	334	finally
    //   195	249	334	finally
    //   252	265	334	finally
    //   265	282	334	finally
    //   163	178	345	java/lang/Throwable
    //   178	184	345	java/lang/Throwable
    //   195	249	345	java/lang/Throwable
    //   252	265	345	java/lang/Throwable
    //   265	282	345	java/lang/Throwable
    //   120	128	351	finally
    //   133	145	351	finally
    //   146	163	351	finally
    //   120	128	360	java/lang/Throwable
    //   133	145	360	java/lang/Throwable
    //   146	163	360	java/lang/Throwable
    //   374	378	381	java/lang/Exception
    //   317	321	395	java/lang/Exception
    //   390	394	395	java/lang/Exception
    //   366	370	401	finally
    //   410	414	417	java/lang/Exception
    //   426	430	433	java/lang/Exception
    //   178	184	440	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsShareManager
 * JD-Core Version:    0.7.0.1
 */