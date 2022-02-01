package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
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
  private static boolean b;
  private static String c = null;
  private static String d = null;
  private static int e = 0;
  private static String f = null;
  private static boolean g = false;
  private static boolean h = false;
  private static boolean i = false;
  private static String j = null;
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
      TbsLinuxToolsJni localTbsLinuxToolsJni = new TbsLinuxToolsJni(paramContext);
      a(paramContext, localTbsLinuxToolsJni, n.a().q(paramContext));
      paramContext = n.a().r(paramContext);
      TbsLog.i("TbsShareManager", "shareTbsCore tbsShareDir is " + paramContext.getAbsolutePath());
      localTbsLinuxToolsJni.a(paramContext.getAbsolutePath(), "755");
      return;
    }
    catch (Throwable paramContext)
    {
      TbsLog.i("TbsShareManager", "shareTbsCore tbsShareDir error is " + paramContext.getMessage() + " ## " + paramContext.getCause());
      paramContext.printStackTrace();
    }
  }
  
  private static void a(Context paramContext, int paramInt)
  {
    String str;
    Object localObject;
    if ((!TbsPVConfig.getInstance(a).isDisableHostBackupCore()) && (n.a().t(paramContext)))
    {
      String[] arrayOfString = new String[5];
      arrayOfString[0] = "com.tencent.tbs";
      arrayOfString[1] = "com.tencent.mm";
      arrayOfString[2] = "com.tencent.mobileqq";
      arrayOfString[3] = "com.qzone";
      arrayOfString[4] = paramContext.getPackageName();
      TbsLog.i("TbsShareManager", "find host backup core to unzip #1" + Log.getStackTraceString(new Throwable()));
      int n = arrayOfString.length;
      int m = 0;
      if (m < n)
      {
        str = arrayOfString[m];
        if (paramInt != getBackupCoreVersion(paramContext, str)) {
          break label218;
        }
        localObject = getPackageContext(paramContext, str, false);
        if (!n.a().f((Context)localObject)) {}
        do
        {
          m += 1;
          break;
          localObject = getBackupCoreFile(paramContext, str);
        } while (!a.a(paramContext, (File)localObject, 0L, paramInt));
        TbsLog.i("TbsShareManager", "find host backup core to unzip normal coreVersion is " + paramInt + " packageName is " + str);
        n.a().a(paramContext, (File)localObject, paramInt);
      }
    }
    for (;;)
    {
      n.a().b();
      return;
      label218:
      if (paramInt != getBackupDecoupleCoreVersion(paramContext, str)) {
        break;
      }
      localObject = getPackageContext(paramContext, str, false);
      if (!n.a().f((Context)localObject)) {
        break;
      }
      localObject = getBackupDecoupleCoreFile(paramContext, str);
      if (!a.a(paramContext, (File)localObject, 0L, paramInt)) {
        break;
      }
      TbsLog.i("TbsShareManager", "find host backup core to unzip decouple coreVersion is " + paramInt + " packageName is " + str);
      n.a().a(paramContext, (File)localObject, paramInt);
    }
  }
  
  private static void a(Context paramContext, TbsLinuxToolsJni paramTbsLinuxToolsJni, File paramFile)
  {
    TbsLog.i("TbsShareManager", "shareAllDirsAndFiles #1");
    if ((paramFile == null) || (!paramFile.exists()) || (!paramFile.isDirectory())) {
      return;
    }
    TbsLog.i("TbsShareManager", "shareAllDirsAndFiles dir is " + paramFile.getAbsolutePath());
    paramTbsLinuxToolsJni.a(paramFile.getAbsolutePath(), "755");
    paramFile = paramFile.listFiles();
    int n = paramFile.length;
    int m = 0;
    label75:
    File localFile;
    if (m < n)
    {
      localFile = paramFile[m];
      if (!localFile.isFile()) {
        break label141;
      }
      if (localFile.getAbsolutePath().indexOf(".so") <= 0) {
        break label126;
      }
      paramTbsLinuxToolsJni.a(localFile.getAbsolutePath(), "755");
    }
    for (;;)
    {
      m += 1;
      break label75;
      break;
      label126:
      paramTbsLinuxToolsJni.a(localFile.getAbsolutePath(), "644");
      continue;
      label141:
      if (localFile.isDirectory()) {
        a(paramContext, paramTbsLinuxToolsJni, localFile);
      } else {
        TbsLog.e("TbsShareManager", "unknown file type.", true);
      }
    }
  }
  
  static void b(Context paramContext)
  {
    try
    {
      a(paramContext, new TbsLinuxToolsJni(paramContext), n.a().p(paramContext));
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
    //   7: ldc 254
    //   9: invokestatic 257	com/tencent/smtt/sdk/TbsShareManager:getTbsShareFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   12: astore 9
    //   14: aload 9
    //   16: ifnonnull +28 -> 44
    //   19: iconst_0
    //   20: ifeq +11 -> 31
    //   23: new 259	java/lang/NullPointerException
    //   26: dup
    //   27: invokespecial 260	java/lang/NullPointerException:<init>	()V
    //   30: athrow
    //   31: iconst_0
    //   32: ifeq +11 -> 43
    //   35: new 259	java/lang/NullPointerException
    //   38: dup
    //   39: invokespecial 260	java/lang/NullPointerException:<init>	()V
    //   42: athrow
    //   43: return
    //   44: new 262	java/io/BufferedInputStream
    //   47: dup
    //   48: new 264	java/io/FileInputStream
    //   51: dup
    //   52: aload 9
    //   54: invokespecial 267	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   57: invokespecial 270	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   60: astore_3
    //   61: new 272	java/util/Properties
    //   64: dup
    //   65: invokespecial 273	java/util/Properties:<init>	()V
    //   68: astore 6
    //   70: aload 6
    //   72: aload_3
    //   73: invokevirtual 276	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   76: aload 6
    //   78: ldc_w 278
    //   81: iconst_0
    //   82: invokestatic 282	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   85: invokevirtual 286	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   88: pop
    //   89: iload_1
    //   90: ifeq +64 -> 154
    //   93: invokestatic 75	com/tencent/smtt/sdk/n:a	()Lcom/tencent/smtt/sdk/n;
    //   96: aload_0
    //   97: invokevirtual 79	com/tencent/smtt/sdk/n:q	(Landroid/content/Context;)Ljava/io/File;
    //   100: invokevirtual 99	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   103: astore 8
    //   105: aload_0
    //   106: invokevirtual 290	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   109: invokevirtual 156	android/content/Context:getPackageName	()Ljava/lang/String;
    //   112: astore 7
    //   114: aload_0
    //   115: invokestatic 295	com/tencent/smtt/utils/b:b	(Landroid/content/Context;)I
    //   118: istore_2
    //   119: aload 6
    //   121: ldc_w 297
    //   124: aload 7
    //   126: invokevirtual 286	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   129: pop
    //   130: aload 6
    //   132: ldc_w 299
    //   135: aload 8
    //   137: invokevirtual 286	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   140: pop
    //   141: aload 6
    //   143: ldc_w 301
    //   146: iload_2
    //   147: invokestatic 304	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   150: invokevirtual 286	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   153: pop
    //   154: new 306	java/io/BufferedOutputStream
    //   157: dup
    //   158: new 308	java/io/FileOutputStream
    //   161: dup
    //   162: aload 9
    //   164: invokespecial 309	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   167: invokespecial 312	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   170: astore_0
    //   171: aload 6
    //   173: aload_0
    //   174: aconst_null
    //   175: invokevirtual 316	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   178: aload_3
    //   179: ifnull +7 -> 186
    //   182: aload_3
    //   183: invokevirtual 319	java/io/BufferedInputStream:close	()V
    //   186: aload_0
    //   187: ifnull -144 -> 43
    //   190: aload_0
    //   191: invokevirtual 320	java/io/BufferedOutputStream:close	()V
    //   194: return
    //   195: astore_0
    //   196: return
    //   197: astore 4
    //   199: aconst_null
    //   200: astore_0
    //   201: aload 5
    //   203: astore_3
    //   204: aload 4
    //   206: invokevirtual 124	java/lang/Throwable:printStackTrace	()V
    //   209: aload_0
    //   210: ifnull +7 -> 217
    //   213: aload_0
    //   214: invokevirtual 319	java/io/BufferedInputStream:close	()V
    //   217: aload_3
    //   218: ifnull -175 -> 43
    //   221: aload_3
    //   222: invokevirtual 320	java/io/BufferedOutputStream:close	()V
    //   225: return
    //   226: astore_0
    //   227: return
    //   228: astore_0
    //   229: aconst_null
    //   230: astore_3
    //   231: aload_3
    //   232: ifnull +7 -> 239
    //   235: aload_3
    //   236: invokevirtual 319	java/io/BufferedInputStream:close	()V
    //   239: aload 4
    //   241: ifnull +8 -> 249
    //   244: aload 4
    //   246: invokevirtual 320	java/io/BufferedOutputStream:close	()V
    //   249: aload_0
    //   250: athrow
    //   251: astore_0
    //   252: goto -221 -> 31
    //   255: astore_0
    //   256: return
    //   257: astore_3
    //   258: goto -72 -> 186
    //   261: astore_0
    //   262: goto -45 -> 217
    //   265: astore_3
    //   266: goto -27 -> 239
    //   269: astore_3
    //   270: goto -21 -> 249
    //   273: astore_0
    //   274: goto -43 -> 231
    //   277: astore 5
    //   279: aload_0
    //   280: astore 4
    //   282: aload 5
    //   284: astore_0
    //   285: goto -54 -> 231
    //   288: astore 4
    //   290: aload_0
    //   291: astore 5
    //   293: aload 4
    //   295: astore_0
    //   296: aload_3
    //   297: astore 4
    //   299: aload 5
    //   301: astore_3
    //   302: goto -71 -> 231
    //   305: astore 4
    //   307: aload_3
    //   308: astore_0
    //   309: aload 5
    //   311: astore_3
    //   312: goto -108 -> 204
    //   315: astore 4
    //   317: aload_0
    //   318: astore 5
    //   320: aload_3
    //   321: astore_0
    //   322: aload 5
    //   324: astore_3
    //   325: goto -121 -> 204
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	328	0	paramContext	Context
    //   0	328	1	paramBoolean	boolean
    //   118	29	2	m	int
    //   60	176	3	localObject1	Object
    //   257	1	3	localException1	Exception
    //   265	1	3	localException2	Exception
    //   269	28	3	localException3	Exception
    //   301	24	3	localContext1	Context
    //   1	1	4	localObject2	Object
    //   197	48	4	localThrowable1	Throwable
    //   280	1	4	localContext2	Context
    //   288	6	4	localObject3	Object
    //   297	1	4	localObject4	Object
    //   305	1	4	localThrowable2	Throwable
    //   315	1	4	localThrowable3	Throwable
    //   4	198	5	localObject5	Object
    //   277	6	5	localObject6	Object
    //   291	32	5	localContext3	Context
    //   68	104	6	localProperties	java.util.Properties
    //   112	13	7	str1	String
    //   103	33	8	str2	String
    //   12	151	9	localFile	File
    // Exception table:
    //   from	to	target	type
    //   190	194	195	java/lang/Exception
    //   6	14	197	java/lang/Throwable
    //   44	61	197	java/lang/Throwable
    //   221	225	226	java/lang/Exception
    //   6	14	228	finally
    //   44	61	228	finally
    //   23	31	251	java/lang/Exception
    //   35	43	255	java/lang/Exception
    //   182	186	257	java/lang/Exception
    //   213	217	261	java/lang/Exception
    //   235	239	265	java/lang/Exception
    //   244	249	269	java/lang/Exception
    //   61	89	273	finally
    //   93	154	273	finally
    //   154	171	273	finally
    //   171	178	277	finally
    //   204	209	288	finally
    //   61	89	305	java/lang/Throwable
    //   93	154	305	java/lang/Throwable
    //   154	171	305	java/lang/Throwable
    //   171	178	315	java/lang/Throwable
  }
  
  static int d(Context paramContext)
  {
    return a(paramContext, true);
  }
  
  private static String[] d(Context paramContext, boolean paramBoolean)
  {
    String[] arrayOfString;
    if (QbSdk.getOnlyDownload())
    {
      arrayOfString = new String[1];
      arrayOfString[0] = paramContext.getApplicationContext().getPackageName();
    }
    do
    {
      return arrayOfString;
      arrayOfString = getCoreProviderAppList();
    } while (!paramBoolean);
    return new String[] { paramContext.getApplicationContext().getPackageName() };
  }
  
  static Context e(Context paramContext)
  {
    Object localObject2 = null;
    j(paramContext);
    Object localObject1 = localObject2;
    if (f != null)
    {
      localObject1 = getPackageContext(paramContext, f, true);
      if (n.a().f((Context)localObject1)) {
        break label48;
      }
      localObject1 = localObject2;
    }
    label48:
    for (;;)
    {
      if (c != null) {
        localObject1 = a;
      }
      return localObject1;
    }
  }
  
  /* Error */
  static String f(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc 2
    //   5: monitorenter
    //   6: aload_0
    //   7: ldc 254
    //   9: invokestatic 257	com/tencent/smtt/sdk/TbsShareManager:getTbsShareFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   12: astore_0
    //   13: aload_0
    //   14: ifnonnull +23 -> 37
    //   17: aload 4
    //   19: astore_0
    //   20: iconst_0
    //   21: ifeq +11 -> 32
    //   24: new 259	java/lang/NullPointerException
    //   27: dup
    //   28: invokespecial 260	java/lang/NullPointerException:<init>	()V
    //   31: athrow
    //   32: ldc 2
    //   34: monitorexit
    //   35: aload_0
    //   36: areturn
    //   37: new 262	java/io/BufferedInputStream
    //   40: dup
    //   41: new 264	java/io/FileInputStream
    //   44: dup
    //   45: aload_0
    //   46: invokespecial 267	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   49: invokespecial 270	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   52: astore_2
    //   53: aload_2
    //   54: astore_0
    //   55: new 272	java/util/Properties
    //   58: dup
    //   59: invokespecial 273	java/util/Properties:<init>	()V
    //   62: astore_3
    //   63: aload_2
    //   64: astore_0
    //   65: aload_3
    //   66: aload_2
    //   67: invokevirtual 276	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   70: aload_2
    //   71: astore_0
    //   72: aload_3
    //   73: ldc_w 297
    //   76: ldc_w 333
    //   79: invokevirtual 337	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   82: astore_3
    //   83: aload_2
    //   84: astore_0
    //   85: ldc_w 333
    //   88: aload_3
    //   89: invokevirtual 341	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   92: istore_1
    //   93: iload_1
    //   94: ifne +16 -> 110
    //   97: aload_2
    //   98: ifnull +7 -> 105
    //   101: aload_2
    //   102: invokevirtual 319	java/io/BufferedInputStream:close	()V
    //   105: aload_3
    //   106: astore_0
    //   107: goto -75 -> 32
    //   110: aload 4
    //   112: astore_0
    //   113: aload_2
    //   114: ifnull -82 -> 32
    //   117: aload_2
    //   118: invokevirtual 319	java/io/BufferedInputStream:close	()V
    //   121: aload 4
    //   123: astore_0
    //   124: goto -92 -> 32
    //   127: astore_0
    //   128: aload 4
    //   130: astore_0
    //   131: goto -99 -> 32
    //   134: astore_3
    //   135: aconst_null
    //   136: astore_2
    //   137: aload_2
    //   138: astore_0
    //   139: aload_3
    //   140: invokevirtual 124	java/lang/Throwable:printStackTrace	()V
    //   143: aload 4
    //   145: astore_0
    //   146: aload_2
    //   147: ifnull -115 -> 32
    //   150: aload_2
    //   151: invokevirtual 319	java/io/BufferedInputStream:close	()V
    //   154: aload 4
    //   156: astore_0
    //   157: goto -125 -> 32
    //   160: astore_0
    //   161: aload 4
    //   163: astore_0
    //   164: goto -132 -> 32
    //   167: astore_2
    //   168: aconst_null
    //   169: astore_0
    //   170: aload_0
    //   171: ifnull +7 -> 178
    //   174: aload_0
    //   175: invokevirtual 319	java/io/BufferedInputStream:close	()V
    //   178: aload_2
    //   179: athrow
    //   180: astore_0
    //   181: ldc 2
    //   183: monitorexit
    //   184: aload_0
    //   185: athrow
    //   186: astore_0
    //   187: aload 4
    //   189: astore_0
    //   190: goto -158 -> 32
    //   193: astore_0
    //   194: goto -89 -> 105
    //   197: astore_0
    //   198: goto -20 -> 178
    //   201: astore_2
    //   202: goto -32 -> 170
    //   205: astore_3
    //   206: goto -69 -> 137
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	209	0	paramContext	Context
    //   92	2	1	bool	boolean
    //   52	99	2	localBufferedInputStream	java.io.BufferedInputStream
    //   167	12	2	localObject1	Object
    //   201	1	2	localObject2	Object
    //   62	44	3	localObject3	Object
    //   134	6	3	localThrowable1	Throwable
    //   205	1	3	localThrowable2	Throwable
    //   1	187	4	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   117	121	127	java/lang/Exception
    //   6	13	134	java/lang/Throwable
    //   37	53	134	java/lang/Throwable
    //   150	154	160	java/lang/Exception
    //   6	13	167	finally
    //   37	53	167	finally
    //   24	32	180	finally
    //   101	105	180	finally
    //   117	121	180	finally
    //   150	154	180	finally
    //   174	178	180	finally
    //   178	180	180	finally
    //   24	32	186	java/lang/Exception
    //   101	105	193	java/lang/Exception
    //   174	178	197	java/lang/Exception
    //   55	63	201	finally
    //   65	70	201	finally
    //   72	83	201	finally
    //   85	93	201	finally
    //   139	143	201	finally
    //   55	63	205	java/lang/Throwable
    //   65	70	205	java/lang/Throwable
    //   72	83	205	java/lang/Throwable
    //   85	93	205	java/lang/Throwable
  }
  
  public static int findCoreForThirdPartyApp(Context paramContext)
  {
    n(paramContext);
    TbsLog.i("TbsShareManager", "core_info mAvailableCoreVersion is " + e + " mAvailableCorePath is " + d + " mSrcPackageName is " + f);
    if (f == null) {
      TbsLog.e("TbsShareManager", "mSrcPackageName is null !!!");
    }
    int m;
    if ((f != null) && (f.equals("AppDefined")))
    {
      if (e != n.a().a(c))
      {
        e = 0;
        d = null;
        f = null;
        TbsLog.i("TbsShareManager", "check AppDefined core is error src is " + e + " dest is " + n.a().a(c));
      }
      if (e > 0)
      {
        ApplicationInfo localApplicationInfo = paramContext.getApplicationInfo();
        if ((!"com.tencent.android.qqdownloader".equals(localApplicationInfo.packageName)) && (!"com.jd.jrapp".equals(localApplicationInfo.packageName))) {
          break label281;
        }
        m = 1;
        label198:
        if (m != 0) {
          break label286;
        }
      }
    }
    label281:
    label286:
    for (boolean bool = QbSdk.a(paramContext, e);; bool = false)
    {
      if ((bool) || (g))
      {
        e = 0;
        d = null;
        f = null;
        TbsLog.i("TbsShareManager", "core_info error QbSdk.isX5Disabled ");
      }
      return e;
      if ((k(paramContext)) || (l(paramContext))) {
        break;
      }
      e = 0;
      d = null;
      f = null;
      TbsLog.i("TbsShareManager", "core_info error checkCoreInfo is false and checkCoreInOthers is false ");
      break;
      m = 0;
      break label198;
    }
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
    }
    catch (Throwable paramContext)
    {
      Log.e("", "getTbsResourcesPath exception: " + Log.getStackTraceString(paramContext));
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
    catch (Throwable paramContext) {}
    return null;
  }
  
  public static int getBackupCoreVersion(Context paramContext, String paramString)
  {
    int m = 0;
    try
    {
      paramContext = new File(new File(FileUtil.a(getPackageContext(paramContext, paramString, false), 4)), TbsDownloader.getBackupFileName(false));
      if (paramContext.exists()) {
        m = a.b(paramContext);
      }
      return m;
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
    catch (Throwable paramContext) {}
    return null;
  }
  
  public static int getBackupDecoupleCoreVersion(Context paramContext, String paramString)
  {
    int m = 0;
    try
    {
      paramContext = new File(new File(FileUtil.a(getPackageContext(paramContext, paramString, false), 4)), TbsDownloader.getBackupFileName(true));
      if (paramContext.exists()) {
        m = a.b(paramContext);
      }
      return m;
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
    long l2 = 0L;
    int m = 0;
    if (m < n)
    {
      String str = arrayOfString[m];
      long l1;
      if (str.equalsIgnoreCase("com.tencent.mm")) {
        l1 = l2 + getSharedTbsCoreVersion(paramContext, str) * 10000000000L;
      }
      for (;;)
      {
        m += 1;
        l2 = l1;
        break;
        if (str.equalsIgnoreCase("com.tencent.mobileqq"))
        {
          l1 = l2 + getSharedTbsCoreVersion(paramContext, str) * 100000L;
        }
        else
        {
          l1 = l2;
          if (str.equalsIgnoreCase("com.qzone")) {
            l1 = l2 + getSharedTbsCoreVersion(paramContext, str);
          }
        }
      }
    }
    return l2;
  }
  
  public static Context getPackageContext(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      if ((!paramContext.getPackageName().equals(paramString)) && (TbsPVConfig.getInstance(paramContext).isEnableNoCoreGray()))
      {
        TbsLog.i("TbsShareManager", "gray no core app,skip get context");
        return null;
      }
      paramContext = paramContext.createPackageContext(paramString, 2);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      return null;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return null;
  }
  
  public static int getSharedTbsCoreVersion(Context paramContext, String paramString)
  {
    paramContext = getPackageContext(paramContext, paramString, true);
    if (paramContext != null) {
      return n.a().i(paramContext);
    }
    return 0;
  }
  
  public static File getTbsShareFile(Context paramContext, String paramString)
  {
    paramContext = n.a().r(paramContext);
    if (paramContext == null) {
      return null;
    }
    paramContext = new File(paramContext, paramString);
    if ((paramContext != null) && (paramContext.exists())) {
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
    //   0: iconst_0
    //   1: istore_2
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc 59
    //   7: ldc_w 465
    //   10: invokestatic 66	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   13: aconst_null
    //   14: astore 4
    //   16: aload_0
    //   17: ldc 254
    //   19: invokestatic 257	com/tencent/smtt/sdk/TbsShareManager:getTbsShareFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   22: astore_0
    //   23: aload_0
    //   24: ifnonnull +46 -> 70
    //   27: ldc 59
    //   29: ldc_w 467
    //   32: invokestatic 66	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: iload_2
    //   36: istore_1
    //   37: iconst_0
    //   38: ifeq +11 -> 49
    //   41: new 259	java/lang/NullPointerException
    //   44: dup
    //   45: invokespecial 260	java/lang/NullPointerException:<init>	()V
    //   48: athrow
    //   49: ldc 2
    //   51: monitorexit
    //   52: iload_1
    //   53: ireturn
    //   54: astore_0
    //   55: aload_0
    //   56: invokevirtual 455	java/lang/Exception:printStackTrace	()V
    //   59: iload_2
    //   60: istore_1
    //   61: goto -12 -> 49
    //   64: astore_0
    //   65: ldc 2
    //   67: monitorexit
    //   68: aload_0
    //   69: athrow
    //   70: new 262	java/io/BufferedInputStream
    //   73: dup
    //   74: new 264	java/io/FileInputStream
    //   77: dup
    //   78: aload_0
    //   79: invokespecial 267	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   82: invokespecial 270	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   85: astore_3
    //   86: new 272	java/util/Properties
    //   89: dup
    //   90: invokespecial 273	java/util/Properties:<init>	()V
    //   93: astore_0
    //   94: aload_0
    //   95: aload_3
    //   96: invokevirtual 276	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   99: aload_0
    //   100: ldc_w 469
    //   103: ldc_w 333
    //   106: invokevirtual 337	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   109: astore_0
    //   110: ldc_w 333
    //   113: aload_0
    //   114: invokevirtual 341	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   117: ifne +45 -> 162
    //   120: ldc 59
    //   122: ldc_w 471
    //   125: invokestatic 66	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   128: aload_0
    //   129: invokestatic 476	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   132: iconst_0
    //   133: invokestatic 482	java/lang/Math:max	(II)I
    //   136: istore_2
    //   137: iload_2
    //   138: istore_1
    //   139: aload_3
    //   140: ifnull -91 -> 49
    //   143: aload_3
    //   144: invokevirtual 319	java/io/BufferedInputStream:close	()V
    //   147: iload_2
    //   148: istore_1
    //   149: goto -100 -> 49
    //   152: astore_0
    //   153: aload_0
    //   154: invokevirtual 455	java/lang/Exception:printStackTrace	()V
    //   157: iload_2
    //   158: istore_1
    //   159: goto -110 -> 49
    //   162: ldc 59
    //   164: ldc_w 484
    //   167: invokestatic 66	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   170: iload_2
    //   171: istore_1
    //   172: aload_3
    //   173: ifnull -124 -> 49
    //   176: aload_3
    //   177: invokevirtual 319	java/io/BufferedInputStream:close	()V
    //   180: iload_2
    //   181: istore_1
    //   182: goto -133 -> 49
    //   185: astore_0
    //   186: aload_0
    //   187: invokevirtual 455	java/lang/Exception:printStackTrace	()V
    //   190: iload_2
    //   191: istore_1
    //   192: goto -143 -> 49
    //   195: astore_3
    //   196: aload 4
    //   198: astore_0
    //   199: aload_3
    //   200: invokevirtual 124	java/lang/Throwable:printStackTrace	()V
    //   203: aload_0
    //   204: ifnull +7 -> 211
    //   207: aload_0
    //   208: invokevirtual 319	java/io/BufferedInputStream:close	()V
    //   211: ldc 59
    //   213: ldc_w 486
    //   216: invokestatic 66	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   219: bipush 254
    //   221: istore_1
    //   222: goto -173 -> 49
    //   225: astore_0
    //   226: aload_0
    //   227: invokevirtual 455	java/lang/Exception:printStackTrace	()V
    //   230: goto -19 -> 211
    //   233: astore_0
    //   234: aconst_null
    //   235: astore_3
    //   236: aload_3
    //   237: ifnull +7 -> 244
    //   240: aload_3
    //   241: invokevirtual 319	java/io/BufferedInputStream:close	()V
    //   244: aload_0
    //   245: athrow
    //   246: astore_3
    //   247: aload_3
    //   248: invokevirtual 455	java/lang/Exception:printStackTrace	()V
    //   251: goto -7 -> 244
    //   254: astore_0
    //   255: goto -19 -> 236
    //   258: astore 4
    //   260: aload_0
    //   261: astore_3
    //   262: aload 4
    //   264: astore_0
    //   265: goto -29 -> 236
    //   268: astore 4
    //   270: aload_3
    //   271: astore_0
    //   272: aload 4
    //   274: astore_3
    //   275: goto -76 -> 199
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	278	0	paramContext	Context
    //   36	186	1	m	int
    //   1	190	2	n	int
    //   85	92	3	localBufferedInputStream	java.io.BufferedInputStream
    //   195	5	3	localThrowable1	Throwable
    //   235	6	3	localObject1	Object
    //   246	2	3	localException	Exception
    //   261	14	3	localObject2	Object
    //   14	183	4	localObject3	Object
    //   258	5	4	localObject4	Object
    //   268	5	4	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   41	49	54	java/lang/Exception
    //   5	13	64	finally
    //   41	49	64	finally
    //   55	59	64	finally
    //   143	147	64	finally
    //   153	157	64	finally
    //   176	180	64	finally
    //   186	190	64	finally
    //   207	211	64	finally
    //   211	219	64	finally
    //   226	230	64	finally
    //   240	244	64	finally
    //   244	246	64	finally
    //   247	251	64	finally
    //   143	147	152	java/lang/Exception
    //   176	180	185	java/lang/Exception
    //   16	23	195	java/lang/Throwable
    //   27	35	195	java/lang/Throwable
    //   70	86	195	java/lang/Throwable
    //   207	211	225	java/lang/Exception
    //   16	23	233	finally
    //   27	35	233	finally
    //   70	86	233	finally
    //   240	244	246	java/lang/Exception
    //   86	137	254	finally
    //   162	170	254	finally
    //   199	203	258	finally
    //   86	137	268	java/lang/Throwable
    //   162	170	268	java/lang/Throwable
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
      else if ((e != 0) && (n.a().a(c) == e)) {
        return true;
      }
      if (l(paramContext)) {
        return true;
      }
      TbsCoreLoadStat.getInstance().a(paramContext, 418, new Throwable("mAvailableCoreVersion=" + e + "; mSrcPackageName=" + f + "; getSharedTbsCoreVersion(ctx, mSrcPackageName) is " + getSharedTbsCoreVersion(paramContext, f) + "; getHostCoreVersions is " + getHostCoreVersions(paramContext)));
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
    for (;;)
    {
      int m;
      try
      {
        if ((a != null) && (a.equals(paramContext.getApplicationContext()))) {
          return b;
        }
        a = paramContext.getApplicationContext();
        paramContext = a.getPackageName();
        String[] arrayOfString = getCoreProviderAppList();
        int n = arrayOfString.length;
        m = 0;
        if (m < n)
        {
          if (!paramContext.equals(arrayOfString[m])) {
            break label78;
          }
          b = false;
          return false;
        }
      }
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
        b = true;
        return true;
      }
      label78:
      m += 1;
    }
  }
  
  static boolean j(Context paramContext)
  {
    return b(paramContext, true);
  }
  
  private static boolean k(Context paramContext)
  {
    if (f == null) {}
    while (e != getSharedTbsCoreVersion(paramContext, f)) {
      return false;
    }
    return true;
  }
  
  private static boolean l(Context paramContext)
  {
    if (QbSdk.getOnlyDownload()) {}
    for (;;)
    {
      return false;
      String[] arrayOfString = getCoreProviderAppList();
      int n = arrayOfString.length;
      int m = 0;
      while (m < n)
      {
        String str = arrayOfString[m];
        if ((e > 0) && (e == getSharedTbsCoreVersion(paramContext, str)))
        {
          Context localContext = getPackageContext(paramContext, str, true);
          if (n.a().f(paramContext))
          {
            d = n.a().b(paramContext, localContext).getAbsolutePath();
            f = str;
            return true;
          }
        }
        m += 1;
      }
    }
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
    //   0: getstatic 45	com/tencent/smtt/sdk/TbsShareManager:l	Z
    //   3: ifeq +4 -> 7
    //   6: return
    //   7: ldc 2
    //   9: monitorenter
    //   10: getstatic 45	com/tencent/smtt/sdk/TbsShareManager:l	Z
    //   13: ifeq +13 -> 26
    //   16: ldc 2
    //   18: monitorexit
    //   19: return
    //   20: astore_0
    //   21: ldc 2
    //   23: monitorexit
    //   24: aload_0
    //   25: athrow
    //   26: aload_0
    //   27: ldc 254
    //   29: invokestatic 257	com/tencent/smtt/sdk/TbsShareManager:getTbsShareFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   32: astore_0
    //   33: aload_0
    //   34: ifnonnull +27 -> 61
    //   37: iconst_0
    //   38: ifeq +11 -> 49
    //   41: new 259	java/lang/NullPointerException
    //   44: dup
    //   45: invokespecial 260	java/lang/NullPointerException:<init>	()V
    //   48: athrow
    //   49: ldc 2
    //   51: monitorexit
    //   52: return
    //   53: astore_0
    //   54: aload_0
    //   55: invokevirtual 455	java/lang/Exception:printStackTrace	()V
    //   58: goto -9 -> 49
    //   61: new 262	java/io/BufferedInputStream
    //   64: dup
    //   65: new 264	java/io/FileInputStream
    //   68: dup
    //   69: aload_0
    //   70: invokespecial 267	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   73: invokespecial 270	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   76: astore_1
    //   77: aload_1
    //   78: astore_0
    //   79: new 272	java/util/Properties
    //   82: dup
    //   83: invokespecial 273	java/util/Properties:<init>	()V
    //   86: astore_2
    //   87: aload_1
    //   88: astore_0
    //   89: aload_2
    //   90: aload_1
    //   91: invokevirtual 276	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   94: aload_1
    //   95: astore_0
    //   96: aload_2
    //   97: ldc_w 469
    //   100: ldc_w 333
    //   103: invokevirtual 337	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   106: astore_3
    //   107: aload_1
    //   108: astore_0
    //   109: ldc_w 333
    //   112: aload_3
    //   113: invokevirtual 341	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   116: ifne +67 -> 183
    //   119: aload_1
    //   120: astore_0
    //   121: aload_3
    //   122: invokestatic 476	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   125: iconst_0
    //   126: invokestatic 482	java/lang/Math:max	(II)I
    //   129: putstatic 31	com/tencent/smtt/sdk/TbsShareManager:e	I
    //   132: aload_1
    //   133: astore_0
    //   134: ldc 59
    //   136: new 87	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   143: ldc_w 532
    //   146: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: getstatic 31	com/tencent/smtt/sdk/TbsShareManager:e	I
    //   152: invokevirtual 189	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   155: ldc_w 534
    //   158: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: new 57	java/lang/Throwable
    //   164: dup
    //   165: ldc_w 536
    //   168: invokespecial 511	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   171: invokestatic 165	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   174: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: invokestatic 66	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   183: aload_1
    //   184: astore_0
    //   185: aload_2
    //   186: ldc_w 297
    //   189: ldc_w 333
    //   192: invokevirtual 337	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   195: astore_3
    //   196: aload_1
    //   197: astore_0
    //   198: ldc_w 333
    //   201: aload_3
    //   202: invokevirtual 341	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   205: ifne +9 -> 214
    //   208: aload_1
    //   209: astore_0
    //   210: aload_3
    //   211: putstatic 33	com/tencent/smtt/sdk/TbsShareManager:f	Ljava/lang/String;
    //   214: aload_1
    //   215: astore_0
    //   216: getstatic 33	com/tencent/smtt/sdk/TbsShareManager:f	Ljava/lang/String;
    //   219: ifnull +34 -> 253
    //   222: aload_1
    //   223: astore_0
    //   224: getstatic 127	com/tencent/smtt/sdk/TbsShareManager:a	Landroid/content/Context;
    //   227: ifnull +26 -> 253
    //   230: aload_1
    //   231: astore_0
    //   232: getstatic 33	com/tencent/smtt/sdk/TbsShareManager:f	Ljava/lang/String;
    //   235: getstatic 127	com/tencent/smtt/sdk/TbsShareManager:a	Landroid/content/Context;
    //   238: invokevirtual 156	android/content/Context:getPackageName	()Ljava/lang/String;
    //   241: invokevirtual 341	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   244: ifeq +107 -> 351
    //   247: aload_1
    //   248: astore_0
    //   249: iconst_1
    //   250: putstatic 43	com/tencent/smtt/sdk/TbsShareManager:k	Z
    //   253: aload_1
    //   254: astore_0
    //   255: aload_2
    //   256: ldc_w 299
    //   259: ldc_w 333
    //   262: invokevirtual 337	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   265: astore_3
    //   266: aload_1
    //   267: astore_0
    //   268: ldc_w 333
    //   271: aload_3
    //   272: invokevirtual 341	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   275: ifne +9 -> 284
    //   278: aload_1
    //   279: astore_0
    //   280: aload_3
    //   281: putstatic 29	com/tencent/smtt/sdk/TbsShareManager:d	Ljava/lang/String;
    //   284: aload_1
    //   285: astore_0
    //   286: aload_2
    //   287: ldc_w 301
    //   290: ldc_w 333
    //   293: invokevirtual 337	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   296: astore_3
    //   297: aload_1
    //   298: astore_0
    //   299: ldc_w 333
    //   302: aload_3
    //   303: invokevirtual 341	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   306: ifne +9 -> 315
    //   309: aload_1
    //   310: astore_0
    //   311: aload_3
    //   312: putstatic 41	com/tencent/smtt/sdk/TbsShareManager:j	Ljava/lang/String;
    //   315: aload_1
    //   316: astore_0
    //   317: aload_2
    //   318: ldc_w 278
    //   321: ldc_w 538
    //   324: invokevirtual 337	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   327: invokestatic 543	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   330: putstatic 35	com/tencent/smtt/sdk/TbsShareManager:g	Z
    //   333: aload_1
    //   334: astore_0
    //   335: iconst_1
    //   336: putstatic 45	com/tencent/smtt/sdk/TbsShareManager:l	Z
    //   339: aload_1
    //   340: ifnull +7 -> 347
    //   343: aload_1
    //   344: invokevirtual 319	java/io/BufferedInputStream:close	()V
    //   347: ldc 2
    //   349: monitorexit
    //   350: return
    //   351: aload_1
    //   352: astore_0
    //   353: iconst_0
    //   354: putstatic 43	com/tencent/smtt/sdk/TbsShareManager:k	Z
    //   357: goto -104 -> 253
    //   360: astore_2
    //   361: aload_1
    //   362: astore_0
    //   363: aload_2
    //   364: invokevirtual 124	java/lang/Throwable:printStackTrace	()V
    //   367: aload_1
    //   368: ifnull -21 -> 347
    //   371: aload_1
    //   372: invokevirtual 319	java/io/BufferedInputStream:close	()V
    //   375: goto -28 -> 347
    //   378: astore_0
    //   379: aload_0
    //   380: invokevirtual 455	java/lang/Exception:printStackTrace	()V
    //   383: goto -36 -> 347
    //   386: astore_0
    //   387: aload_0
    //   388: invokevirtual 455	java/lang/Exception:printStackTrace	()V
    //   391: goto -44 -> 347
    //   394: astore_1
    //   395: aconst_null
    //   396: astore_0
    //   397: aload_0
    //   398: ifnull +7 -> 405
    //   401: aload_0
    //   402: invokevirtual 319	java/io/BufferedInputStream:close	()V
    //   405: aload_1
    //   406: athrow
    //   407: astore_0
    //   408: aload_0
    //   409: invokevirtual 455	java/lang/Exception:printStackTrace	()V
    //   412: goto -7 -> 405
    //   415: astore_1
    //   416: goto -19 -> 397
    //   419: astore_2
    //   420: aconst_null
    //   421: astore_1
    //   422: goto -61 -> 361
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	425	0	paramContext	Context
    //   76	296	1	localBufferedInputStream	java.io.BufferedInputStream
    //   394	12	1	localObject1	Object
    //   415	1	1	localObject2	Object
    //   421	1	1	localObject3	Object
    //   86	232	2	localProperties	java.util.Properties
    //   360	4	2	localThrowable1	Throwable
    //   419	1	2	localThrowable2	Throwable
    //   106	206	3	str	String
    // Exception table:
    //   from	to	target	type
    //   10	19	20	finally
    //   21	24	20	finally
    //   41	49	20	finally
    //   49	52	20	finally
    //   54	58	20	finally
    //   343	347	20	finally
    //   347	350	20	finally
    //   371	375	20	finally
    //   379	383	20	finally
    //   387	391	20	finally
    //   401	405	20	finally
    //   405	407	20	finally
    //   408	412	20	finally
    //   41	49	53	java/lang/Exception
    //   79	87	360	java/lang/Throwable
    //   89	94	360	java/lang/Throwable
    //   96	107	360	java/lang/Throwable
    //   109	119	360	java/lang/Throwable
    //   121	132	360	java/lang/Throwable
    //   134	183	360	java/lang/Throwable
    //   185	196	360	java/lang/Throwable
    //   198	208	360	java/lang/Throwable
    //   210	214	360	java/lang/Throwable
    //   216	222	360	java/lang/Throwable
    //   224	230	360	java/lang/Throwable
    //   232	247	360	java/lang/Throwable
    //   249	253	360	java/lang/Throwable
    //   255	266	360	java/lang/Throwable
    //   268	278	360	java/lang/Throwable
    //   280	284	360	java/lang/Throwable
    //   286	297	360	java/lang/Throwable
    //   299	309	360	java/lang/Throwable
    //   311	315	360	java/lang/Throwable
    //   317	333	360	java/lang/Throwable
    //   335	339	360	java/lang/Throwable
    //   353	357	360	java/lang/Throwable
    //   371	375	378	java/lang/Exception
    //   343	347	386	java/lang/Exception
    //   26	33	394	finally
    //   61	77	394	finally
    //   401	405	407	java/lang/Exception
    //   79	87	415	finally
    //   89	94	415	finally
    //   96	107	415	finally
    //   109	119	415	finally
    //   121	132	415	finally
    //   134	183	415	finally
    //   185	196	415	finally
    //   198	208	415	finally
    //   210	214	415	finally
    //   216	222	415	finally
    //   224	230	415	finally
    //   232	247	415	finally
    //   249	253	415	finally
    //   255	266	415	finally
    //   268	278	415	finally
    //   280	284	415	finally
    //   286	297	415	finally
    //   299	309	415	finally
    //   311	315	415	finally
    //   317	333	415	finally
    //   335	339	415	finally
    //   353	357	415	finally
    //   363	367	415	finally
    //   26	33	419	java/lang/Throwable
    //   61	77	419	java/lang/Throwable
  }
  
  public static void setHostCorePathAppDefined(String paramString)
  {
    c = paramString;
  }
  
  public static void writeCoreInfoForThirdPartyApp(Context paramContext, int paramInt, boolean paramBoolean)
  {
    int i1 = 0;
    label152:
    Object localObject1;
    Object localObject2;
    int n;
    label376:
    Object localObject3;
    for (;;)
    {
      try
      {
        TbsLog.i("TbsShareManager", "writeCoreInfoForThirdPartyApp coreVersion is " + paramInt);
        if (paramInt == 0)
        {
          m(paramContext);
          TbsDownloadConfig.getInstance(a).setDownloadInterruptCode(-401);
          return;
        }
        m = h(paramContext);
        TbsLog.i("TbsShareManager", "writeCoreInfoForThirdPartyApp coreVersionFromConfig is " + m);
        if (m < 0)
        {
          TbsDownloadConfig.getInstance(a).setDownloadInterruptCode(-402);
          continue;
        }
        if (paramInt != m) {
          break label152;
        }
      }
      finally {}
      if ((d(paramContext) == 0) && (!paramBoolean)) {
        a(paramContext, paramInt);
      }
      c(paramContext, paramBoolean);
      TbsDownloadConfig.getInstance(a).setDownloadInterruptCode(-403);
      continue;
      if (paramInt < m)
      {
        m(paramContext);
        TbsDownloadConfig.getInstance(a).setDownloadInterruptCode(-404);
      }
      else
      {
        m = n.a().i(paramContext);
        TbsLog.i("TbsShareManager", "writeCoreInfoForThirdPartyApp coreVersionFromCoreShare is " + m);
        if (paramInt < m)
        {
          m(paramContext);
          TbsDownloadConfig.getInstance(a).setDownloadInterruptCode(-404);
        }
        else
        {
          localObject1 = d(paramContext, paramBoolean);
          if (c == null) {
            break;
          }
          if (paramInt == n.a().a(c))
          {
            writeProperties(paramContext, Integer.toString(paramInt), "AppDefined", c, Integer.toString(1));
            try
            {
              localObject1 = getTbsShareFile(paramContext, "core_info");
              if ((i) || (localObject1 == null)) {
                continue;
              }
              localObject2 = new TbsLinuxToolsJni(a);
              ((TbsLinuxToolsJni)localObject2).a(((File)localObject1).getAbsolutePath(), "644");
              ((TbsLinuxToolsJni)localObject2).a(n.a().r(paramContext).getAbsolutePath(), "755");
              i = true;
            }
            catch (Throwable paramContext)
            {
              paramContext.printStackTrace();
            }
          }
          else
          {
            if (paramInt <= n.a().a(c)) {
              break;
            }
            n = localObject1.length;
            m = 0;
            if (m >= n) {
              break;
            }
            localObject2 = localObject1[m];
            if (paramInt != getSharedTbsCoreVersion(paramContext, (String)localObject2)) {
              break label817;
            }
            localObject3 = getPackageContext(paramContext, (String)localObject2, true);
            localObject2 = n.a().q((Context)localObject3).getAbsolutePath();
            b.b(paramContext);
            if (!n.a().f((Context)localObject3)) {
              break label817;
            }
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
                ((TbsLinuxToolsJni)localObject2).a(n.a().r(paramContext).getAbsolutePath(), "755");
                i = true;
              }
            }
            catch (Throwable paramContext)
            {
              paramContext.printStackTrace();
            }
          }
        }
      }
    }
    int i2 = localObject1.length;
    int m = 0;
    for (;;)
    {
      n = i1;
      if (m < i2)
      {
        localObject2 = localObject1[m];
        if (paramInt == getSharedTbsCoreVersion(paramContext, (String)localObject2))
        {
          localObject3 = getPackageContext(paramContext, (String)localObject2, true);
          String str = n.a().q((Context)localObject3).getAbsolutePath();
          n = b.b(paramContext);
          if (n.a().f((Context)localObject3))
          {
            if (!((String)localObject2).equals(paramContext.getApplicationContext().getPackageName()))
            {
              TbsLog.i("TbsShareManager", "thirdAPP pre--> delete old core_share Directory:" + paramInt);
              k.a(a).a("remove_old_core", 1);
            }
            writeProperties(paramContext, Integer.toString(paramInt), (String)localObject2, str, Integer.toString(n));
          }
        }
      }
      else
      {
        try
        {
          localObject1 = getTbsShareFile(paramContext, "core_info");
          if ((!i) && (localObject1 != null))
          {
            localObject2 = new TbsLinuxToolsJni(a);
            ((TbsLinuxToolsJni)localObject2).a(((File)localObject1).getAbsolutePath(), "644");
            ((TbsLinuxToolsJni)localObject2).a(n.a().r(paramContext).getAbsolutePath(), "755");
            i = true;
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            localThrowable.printStackTrace();
          }
        }
        n = 1;
        if ((n != 0) || (paramBoolean)) {
          break;
        }
        a(paramContext, paramInt);
        break;
        label817:
        m += 1;
        break label376;
      }
      m += 1;
    }
  }
  
  /* Error */
  public static void writeProperties(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 8
    //   6: iconst_0
    //   7: istore 6
    //   9: ldc 59
    //   11: new 87	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 593
    //   21: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_1
    //   25: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc_w 595
    //   31: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: aload_2
    //   35: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: ldc_w 597
    //   41: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: aload_3
    //   45: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 66	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: ldc 59
    //   56: new 87	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 88	java/lang/StringBuilder:<init>	()V
    //   63: ldc_w 599
    //   66: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: new 57	java/lang/Throwable
    //   72: dup
    //   73: ldc_w 536
    //   76: invokespecial 511	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   79: invokestatic 165	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   82: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokestatic 66	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   91: aload_0
    //   92: ldc 254
    //   94: invokestatic 257	com/tencent/smtt/sdk/TbsShareManager:getTbsShareFile	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   97: astore_0
    //   98: aload_0
    //   99: ifnonnull +54 -> 153
    //   102: getstatic 127	com/tencent/smtt/sdk/TbsShareManager:a	Landroid/content/Context;
    //   105: invokestatic 555	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   108: sipush -405
    //   111: invokevirtual 559	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   114: iconst_0
    //   115: ifeq +11 -> 126
    //   118: new 259	java/lang/NullPointerException
    //   121: dup
    //   122: invokespecial 260	java/lang/NullPointerException:<init>	()V
    //   125: athrow
    //   126: iconst_0
    //   127: ifeq +11 -> 138
    //   130: new 259	java/lang/NullPointerException
    //   133: dup
    //   134: invokespecial 260	java/lang/NullPointerException:<init>	()V
    //   137: athrow
    //   138: return
    //   139: astore_0
    //   140: aload_0
    //   141: invokevirtual 455	java/lang/Exception:printStackTrace	()V
    //   144: goto -18 -> 126
    //   147: astore_0
    //   148: aload_0
    //   149: invokevirtual 455	java/lang/Exception:printStackTrace	()V
    //   152: return
    //   153: new 262	java/io/BufferedInputStream
    //   156: dup
    //   157: new 264	java/io/FileInputStream
    //   160: dup
    //   161: aload_0
    //   162: invokespecial 267	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   165: invokespecial 270	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   168: astore 7
    //   170: new 272	java/util/Properties
    //   173: dup
    //   174: invokespecial 273	java/util/Properties:<init>	()V
    //   177: astore 10
    //   179: aload 10
    //   181: aload 7
    //   183: invokevirtual 276	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   186: aload_1
    //   187: invokestatic 476	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   190: istore 5
    //   192: iload 5
    //   194: ifeq +121 -> 315
    //   197: aload 10
    //   199: ldc_w 469
    //   202: aload_1
    //   203: invokevirtual 286	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   206: pop
    //   207: aload 10
    //   209: ldc_w 278
    //   212: iconst_0
    //   213: invokestatic 282	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   216: invokevirtual 286	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   219: pop
    //   220: aload 10
    //   222: ldc_w 297
    //   225: aload_2
    //   226: invokevirtual 286	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   229: pop
    //   230: aload 10
    //   232: ldc_w 299
    //   235: aload_3
    //   236: invokevirtual 286	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   239: pop
    //   240: aload 10
    //   242: ldc_w 301
    //   245: aload 4
    //   247: invokevirtual 286	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   250: pop
    //   251: new 306	java/io/BufferedOutputStream
    //   254: dup
    //   255: new 308	java/io/FileOutputStream
    //   258: dup
    //   259: aload_0
    //   260: invokespecial 309	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   263: invokespecial 312	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   266: astore_0
    //   267: aload 10
    //   269: aload_0
    //   270: aconst_null
    //   271: invokevirtual 316	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   274: iconst_0
    //   275: putstatic 45	com/tencent/smtt/sdk/TbsShareManager:l	Z
    //   278: getstatic 127	com/tencent/smtt/sdk/TbsShareManager:a	Landroid/content/Context;
    //   281: invokestatic 555	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   284: sipush -406
    //   287: invokevirtual 559	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   290: aload 7
    //   292: ifnull +8 -> 300
    //   295: aload 7
    //   297: invokevirtual 319	java/io/BufferedInputStream:close	()V
    //   300: aload_0
    //   301: ifnull -163 -> 138
    //   304: aload_0
    //   305: invokevirtual 320	java/io/BufferedOutputStream:close	()V
    //   308: return
    //   309: astore_0
    //   310: aload_0
    //   311: invokevirtual 455	java/lang/Exception:printStackTrace	()V
    //   314: return
    //   315: aload 10
    //   317: ldc_w 278
    //   320: iconst_1
    //   321: invokestatic 282	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   324: invokevirtual 286	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   327: pop
    //   328: goto -77 -> 251
    //   331: astore_2
    //   332: aload 7
    //   334: astore_0
    //   335: aload 8
    //   337: astore_1
    //   338: aload_2
    //   339: invokevirtual 124	java/lang/Throwable:printStackTrace	()V
    //   342: aload_0
    //   343: ifnull +7 -> 350
    //   346: aload_0
    //   347: invokevirtual 319	java/io/BufferedInputStream:close	()V
    //   350: aload_1
    //   351: ifnull -213 -> 138
    //   354: aload_1
    //   355: invokevirtual 320	java/io/BufferedOutputStream:close	()V
    //   358: return
    //   359: astore_0
    //   360: aload_0
    //   361: invokevirtual 455	java/lang/Exception:printStackTrace	()V
    //   364: return
    //   365: astore_1
    //   366: aload_1
    //   367: invokevirtual 455	java/lang/Exception:printStackTrace	()V
    //   370: goto -70 -> 300
    //   373: astore_0
    //   374: aload_0
    //   375: invokevirtual 455	java/lang/Exception:printStackTrace	()V
    //   378: goto -28 -> 350
    //   381: astore_0
    //   382: aconst_null
    //   383: astore 7
    //   385: aload 9
    //   387: astore_1
    //   388: aload 7
    //   390: ifnull +8 -> 398
    //   393: aload 7
    //   395: invokevirtual 319	java/io/BufferedInputStream:close	()V
    //   398: aload_1
    //   399: ifnull +7 -> 406
    //   402: aload_1
    //   403: invokevirtual 320	java/io/BufferedOutputStream:close	()V
    //   406: aload_0
    //   407: athrow
    //   408: astore_2
    //   409: aload_2
    //   410: invokevirtual 455	java/lang/Exception:printStackTrace	()V
    //   413: goto -15 -> 398
    //   416: astore_1
    //   417: aload_1
    //   418: invokevirtual 455	java/lang/Exception:printStackTrace	()V
    //   421: goto -15 -> 406
    //   424: astore 11
    //   426: iload 6
    //   428: istore 5
    //   430: goto -238 -> 192
    //   433: astore_0
    //   434: aload 9
    //   436: astore_1
    //   437: goto -49 -> 388
    //   440: astore_2
    //   441: aload_0
    //   442: astore_1
    //   443: aload_2
    //   444: astore_0
    //   445: goto -57 -> 388
    //   448: astore_2
    //   449: aload_0
    //   450: astore 7
    //   452: aload_2
    //   453: astore_0
    //   454: goto -66 -> 388
    //   457: astore_2
    //   458: aconst_null
    //   459: astore_0
    //   460: aload 8
    //   462: astore_1
    //   463: goto -125 -> 338
    //   466: astore_2
    //   467: aload_0
    //   468: astore_1
    //   469: aload 7
    //   471: astore_0
    //   472: goto -134 -> 338
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	475	0	paramContext	Context
    //   0	475	1	paramString1	String
    //   0	475	2	paramString2	String
    //   0	475	3	paramString3	String
    //   0	475	4	paramString4	String
    //   190	239	5	m	int
    //   7	420	6	n	int
    //   168	302	7	localObject1	Object
    //   4	457	8	localObject2	Object
    //   1	434	9	localObject3	Object
    //   177	139	10	localProperties	java.util.Properties
    //   424	1	11	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   118	126	139	java/lang/Exception
    //   130	138	147	java/lang/Exception
    //   304	308	309	java/lang/Exception
    //   170	186	331	java/lang/Throwable
    //   186	192	331	java/lang/Throwable
    //   197	251	331	java/lang/Throwable
    //   251	267	331	java/lang/Throwable
    //   315	328	331	java/lang/Throwable
    //   354	358	359	java/lang/Exception
    //   295	300	365	java/lang/Exception
    //   346	350	373	java/lang/Exception
    //   91	98	381	finally
    //   102	114	381	finally
    //   153	170	381	finally
    //   393	398	408	java/lang/Exception
    //   402	406	416	java/lang/Exception
    //   186	192	424	java/lang/Exception
    //   170	186	433	finally
    //   186	192	433	finally
    //   197	251	433	finally
    //   251	267	433	finally
    //   315	328	433	finally
    //   267	290	440	finally
    //   338	342	448	finally
    //   91	98	457	java/lang/Throwable
    //   102	114	457	java/lang/Throwable
    //   153	170	457	java/lang/Throwable
    //   267	290	466	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsShareManager
 * JD-Core Version:    0.7.0.1
 */