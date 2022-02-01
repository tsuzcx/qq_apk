package cooperation.qzone.patch;

import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.pluginsdk.PluginUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QUA;
import cooperation.qzone.QZoneHelper;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QZonePatchService
{
  public static final String MM_REPORT = "qz_patch";
  public static final String PATCH_DIR = "patchs";
  public static final String PATCH_MERGE_DIR = "patchs_merge";
  public static final String PATCH_O_DEX_DIR = "dex";
  public static final String PATCH_SUFFIX = ".jar";
  public static final String PATCH_SUFFIX_DEX = ".dex";
  public static final int RET_PATCH_DEL_SUCCEED = 11;
  public static final int RET_PATCH_DOWNLOAD_SUCCEED = 10;
  public static final int RET_PATCH_VERIFY_FAILED = 12;
  public static final String SP_LENGTH = "p_len";
  public static final String SP_MERGE_LENGTH = "p_merge_len";
  public static final String SP_MERGE_ODEX_LENGTH = "p_merge_odex_len";
  public static final String SP_QZONE_LENGTH = "p_qzone_len";
  public static final String SP_VERSION = "p_ver";
  public static final String TAG = "qz_patch";
  private static volatile boolean bPatchUpdating = false;
  private static String curPatchMd5;
  private static Object lock = new Object();
  private static QZonePatchService mInstance;
  private static int sPatchVersion = 0;
  
  public static void cachePatchVersion(String paramString)
  {
    int i = getPatchVersion(paramString);
    sPatchVersion = i;
    resetPatchVersion(i);
  }
  
  private static void deleteMergeAndOdexFiles()
  {
    deleteMergedFiles();
    deleteMergedOdexFiles();
  }
  
  private static void deleteMergedFiles()
  {
    int i = 0;
    if (Build.VERSION.SDK_INT < 24) {
      return;
    }
    Object localObject1 = BaseApplicationImpl.getContext().getDir("patchs_merge", 0);
    if (((File)localObject1).exists())
    {
      localObject1 = ((File)localObject1).listFiles();
      int j = localObject1.length;
      if (i < j)
      {
        Object localObject2 = localObject1[i];
        if (localObject2.isDirectory()) {}
        for (;;)
        {
          i += 1;
          break;
          localObject2.delete();
        }
      }
    }
    saveConfigPatchMergeFileLength(0L);
  }
  
  private static void deleteMergedOdexFiles()
  {
    int i = 0;
    if (Build.VERSION.SDK_INT < 24) {
      return;
    }
    Object localObject1 = BaseApplicationImpl.getContext().getDir("dex", 0);
    if (((File)localObject1).exists())
    {
      localObject1 = ((File)localObject1).listFiles();
      int j = localObject1.length;
      if (i < j)
      {
        Object localObject2 = localObject1[i];
        if (localObject2.isDirectory()) {}
        for (;;)
        {
          i += 1;
          break;
          localObject2.delete();
        }
      }
    }
    saveConfigPatchMergeOdexFileLength(0L);
  }
  
  /* Error */
  private static void downloadPatchAndClear(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 141	cooperation/qzone/patch/QZonePatchService:getPatchPath	(Ljava/lang/String;)Ljava/lang/String;
    //   4: astore 7
    //   6: invokestatic 145	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   9: invokevirtual 149	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   12: checkcast 151	com/tencent/common/app/AppInterface
    //   15: aload_1
    //   16: new 111	java/io/File
    //   19: dup
    //   20: aload 7
    //   22: invokespecial 153	java/io/File:<init>	(Ljava/lang/String;)V
    //   25: invokestatic 159	com/tencent/mobileqq/utils/HttpDownloadUtil:download	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/io/File;)Z
    //   28: ifeq +378 -> 406
    //   31: new 161	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   38: ldc 163
    //   40: invokestatic 169	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   43: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: aload 7
    //   48: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokestatic 180	cooperation/qzone/patch/QZonePatchService:log	(Ljava/lang/String;)V
    //   57: invokestatic 103	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   60: ldc 11
    //   62: iconst_0
    //   63: invokevirtual 109	com/tencent/qphone/base/util/BaseApplication:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   66: astore 7
    //   68: aload 7
    //   70: invokevirtual 115	java/io/File:exists	()Z
    //   73: ifeq +333 -> 406
    //   76: aload 7
    //   78: invokevirtual 119	java/io/File:listFiles	()[Ljava/io/File;
    //   81: astore 9
    //   83: aload 9
    //   85: arraylength
    //   86: istore_3
    //   87: iconst_0
    //   88: istore_2
    //   89: iload_2
    //   90: iload_3
    //   91: if_icmpge +315 -> 406
    //   94: aload 9
    //   96: iload_2
    //   97: aaload
    //   98: astore 10
    //   100: aload 10
    //   102: invokevirtual 122	java/io/File:isDirectory	()Z
    //   105: ifeq +6 -> 111
    //   108: goto +390 -> 498
    //   111: new 161	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   118: aload_0
    //   119: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: ldc 20
    //   124: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: aload 10
    //   132: invokevirtual 183	java/io/File:getName	()Ljava/lang/String;
    //   135: invokevirtual 189	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   138: istore 4
    //   140: iload 4
    //   142: ifeq +342 -> 484
    //   145: aload 10
    //   147: invokevirtual 192	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   150: invokestatic 197	com/tencent/mobileqq/pluginsdk/PluginStatic:encodeFile	(Ljava/lang/String;)Ljava/lang/String;
    //   153: astore 7
    //   155: new 161	java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   162: ldc 199
    //   164: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: aload 7
    //   169: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: invokestatic 180	cooperation/qzone/patch/QZonePatchService:log	(Ljava/lang/String;)V
    //   178: aload_0
    //   179: aload 7
    //   181: invokevirtual 202	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   184: ifeq +242 -> 426
    //   187: ldc 204
    //   189: invokestatic 180	cooperation/qzone/patch/QZonePatchService:log	(Ljava/lang/String;)V
    //   192: new 161	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   199: invokestatic 209	cooperation/qzone/QUA:getQUA3	()Ljava/lang/String;
    //   202: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: ldc 33
    //   207: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: astore 7
    //   215: aload 10
    //   217: invokevirtual 213	java/io/File:length	()J
    //   220: lstore 5
    //   222: new 161	java/lang/StringBuilder
    //   225: dup
    //   226: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   229: aload 7
    //   231: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: ldc 215
    //   236: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: lload 5
    //   241: invokevirtual 218	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   244: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: invokestatic 180	cooperation/qzone/patch/QZonePatchService:log	(Ljava/lang/String;)V
    //   250: aload 7
    //   252: lload 5
    //   254: invokestatic 224	cooperation/qzone/LocalMultiProcConfig:putLong	(Ljava/lang/String;J)V
    //   257: ldc 8
    //   259: iconst_2
    //   260: new 161	java/lang/StringBuilder
    //   263: dup
    //   264: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   267: ldc 226
    //   269: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: aload_0
    //   273: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: ldc 228
    //   278: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: lload 5
    //   283: invokevirtual 218	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   286: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   289: invokestatic 234	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   292: aload_1
    //   293: invokestatic 236	cooperation/qzone/patch/QZonePatchService:cachePatchVersion	(Ljava/lang/String;)V
    //   296: invokestatic 145	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   299: invokevirtual 149	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   302: checkcast 238	com/tencent/mobileqq/app/QQAppInterface
    //   305: ldc 8
    //   307: bipush 10
    //   309: aconst_null
    //   310: invokestatic 242	cooperation/qzone/patch/QZonePatchService:getPatchResultCode	(ILjava/lang/String;)I
    //   313: new 161	java/lang/StringBuilder
    //   316: dup
    //   317: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   320: ldc 244
    //   322: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: aload_0
    //   326: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: ldc 228
    //   331: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: lload 5
    //   336: invokevirtual 218	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   339: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   342: iconst_1
    //   343: invokestatic 249	java/lang/System:currentTimeMillis	()J
    //   346: invokestatic 255	cooperation/qzone/QZoneHelper:preloadQZoneForHaboReport	(Lmqq/app/AppRuntime;Ljava/lang/String;ILjava/lang/String;IJ)V
    //   349: ldc 8
    //   351: iconst_1
    //   352: new 161	java/lang/StringBuilder
    //   355: dup
    //   356: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   359: ldc_w 257
    //   362: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: bipush 10
    //   367: aconst_null
    //   368: invokestatic 242	cooperation/qzone/patch/QZonePatchService:getPatchResultCode	(ILjava/lang/String;)I
    //   371: invokevirtual 260	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   374: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   377: invokestatic 234	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   380: invokestatic 103	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   383: aload 10
    //   385: invokevirtual 192	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   388: aload_0
    //   389: invokestatic 264	cooperation/qzone/patch/QZonePatchService:processPatchForAboveAndroidN	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   392: goto +106 -> 498
    //   395: astore_0
    //   396: ldc 8
    //   398: iconst_1
    //   399: aload_0
    //   400: invokestatic 268	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   403: invokestatic 271	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   406: return
    //   407: astore 8
    //   409: aconst_null
    //   410: astore 7
    //   412: ldc 8
    //   414: iconst_1
    //   415: aload 8
    //   417: invokestatic 268	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   420: invokestatic 271	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   423: goto -245 -> 178
    //   426: ldc_w 273
    //   429: invokestatic 180	cooperation/qzone/patch/QZonePatchService:log	(Ljava/lang/String;)V
    //   432: ldc 8
    //   434: iconst_1
    //   435: new 161	java/lang/StringBuilder
    //   438: dup
    //   439: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   442: ldc_w 275
    //   445: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: aload 7
    //   450: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: ldc_w 277
    //   456: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: aload_0
    //   460: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: ldc_w 279
    //   466: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   472: invokestatic 234	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   475: aload 10
    //   477: invokevirtual 125	java/io/File:delete	()Z
    //   480: pop
    //   481: goto +17 -> 498
    //   484: aload 10
    //   486: invokevirtual 125	java/io/File:delete	()Z
    //   489: pop
    //   490: goto +8 -> 498
    //   493: astore 8
    //   495: goto -83 -> 412
    //   498: iload_2
    //   499: iconst_1
    //   500: iadd
    //   501: istore_2
    //   502: goto -413 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	505	0	paramString1	String
    //   0	505	1	paramString2	String
    //   88	414	2	i	int
    //   86	6	3	j	int
    //   138	3	4	bool	boolean
    //   220	115	5	l	long
    //   4	445	7	localObject	Object
    //   407	9	8	localException1	Exception
    //   493	1	8	localException2	Exception
    //   81	14	9	arrayOfFile	File[]
    //   98	387	10	localFile	File
    // Exception table:
    //   from	to	target	type
    //   31	87	395	java/lang/Error
    //   100	108	395	java/lang/Error
    //   111	140	395	java/lang/Error
    //   145	155	395	java/lang/Error
    //   155	178	395	java/lang/Error
    //   178	392	395	java/lang/Error
    //   412	423	395	java/lang/Error
    //   426	481	395	java/lang/Error
    //   484	490	395	java/lang/Error
    //   145	155	407	java/lang/Exception
    //   155	178	493	java/lang/Exception
  }
  
  private static long getConfigPatchMergeFileLength()
  {
    return LocalMultiProcConfig.getLong(QUA.getQUA3() + "p_merge_len", 0L);
  }
  
  private static long getConfigPatchMergeOdexFileLength()
  {
    return LocalMultiProcConfig.getLong(QUA.getQUA3() + "p_merge_odex_len", 0L);
  }
  
  private static long getConfigQZonePatchFileLength()
  {
    return LocalMultiProcConfig.getLong(QUA.getQUA3() + "p_len", 0L);
  }
  
  private static long getFileLength(String paramString)
  {
    paramString = new File(paramString);
    if (paramString.exists()) {
      return paramString.length();
    }
    return 0L;
  }
  
  public static QZonePatchService getInstance()
  {
    if (mInstance == null) {}
    synchronized (lock)
    {
      if (mInstance == null) {
        mInstance = new QZonePatchService();
      }
      return mInstance;
    }
  }
  
  private static String getPatchMergeOdexPath(String paramString)
  {
    paramString = paramString + ".dex";
    File localFile = BaseApplicationImpl.getContext().getDir("dex", 0);
    return localFile.getAbsolutePath() + File.separator + paramString;
  }
  
  private static String getPatchMergePath(String paramString)
  {
    paramString = paramString + ".jar";
    File localFile = BaseApplicationImpl.getContext().getDir("patchs_merge", 0);
    return localFile.getAbsolutePath() + File.separator + paramString;
  }
  
  private static String getPatchPath(String paramString)
  {
    paramString = paramString + ".jar";
    File localFile = BaseApplicationImpl.getContext().getDir("patchs", 0);
    return localFile.getAbsolutePath() + File.separator + paramString;
  }
  
  public static int getPatchResultCode(int paramInt, String paramString)
  {
    int i = paramInt;
    if (paramString == null) {
      i = paramInt + sPatchVersion * 10000;
    }
    return i;
  }
  
  private static int getPatchVersion(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        return 0;
        paramString = Uri.parse(paramString).getLastPathSegment();
      } while (TextUtils.isEmpty(paramString));
      paramString = Pattern.compile("_r(\\d+)").matcher(paramString);
    } while (!paramString.find());
    paramString = paramString.group(1);
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (Exception paramString) {}
    return 0;
  }
  
  private static String getQZonePluginPath()
  {
    File localFile = PluginUtils.getInstalledPluginPath(BaseApplicationImpl.sApplication, "qzone_plugin.apk");
    if (localFile != null) {
      return localFile.getAbsolutePath();
    }
    return null;
  }
  
  public static void log(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("qz_patch", 2, paramString);
    }
  }
  
  private static DexClassLoader preCompileMergePatch(Context paramContext, String paramString, ClassLoader paramClassLoader)
  {
    try
    {
      paramContext = new DexClassLoader(paramString, paramContext.getDir("dex", 0).getAbsolutePath(), paramString, paramClassLoader);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      log("preCompileMergePatch failed :" + paramContext.getMessage() + "  stacktrace: " + Log.getStackTraceString(paramContext));
    }
    return null;
  }
  
  private static void processPatchForAboveAndroidN(Context paramContext, String paramString1, String paramString2)
  {
    if (Build.VERSION.SDK_INT >= 24)
    {
      log("start to merge...");
      if ((getConfigQZonePatchFileLength() == 0L) || (getConfigPatchMergeFileLength() == 0L)) {
        deleteMergeAndOdexFiles();
      }
      if (getConfigPatchMergeOdexFileLength() == 0L) {
        deleteMergedOdexFiles();
      }
      String str2 = getQZonePluginPath();
      String str1;
      if (str2 != null)
      {
        if ((getConfigQZonePatchFileLength() != 0L) && (getConfigQZonePatchFileLength() != getFileLength(paramString1)))
        {
          deleteMergeAndOdexFiles();
          saveConfigQZonePatchFileLength(getFileLength(paramString1));
        }
        str1 = getPatchMergePath(paramString2);
        if ((getConfigPatchMergeFileLength() != 0L) && (getConfigPatchMergeFileLength() == getFileLength(str1))) {
          break label269;
        }
        deleteMergeAndOdexFiles();
        log("---> merge :" + str1);
        if (!PatchMergeUtils.MergeApk(str2, paramString1, str1)) {
          break label265;
        }
        saveConfigPatchMergeFileLength(getFileLength(str1));
        paramString1 = getPatchMergeOdexPath(paramString2);
        if ((getConfigPatchMergeOdexFileLength() != 0L) && (getConfigPatchMergeOdexFileLength() == getFileLength(paramString1))) {
          break label310;
        }
        deleteMergedOdexFiles();
        log("---> compile :" + paramString1);
        if (preCompileMergePatch(paramContext, str1, paramContext.getClassLoader()) != null)
        {
          saveConfigPatchMergeOdexFileLength(getFileLength(paramString1));
          log("---> succeed to merge and compile, merge len:" + getFileLength(str1) + "   odex len:" + getFileLength(paramString1));
        }
      }
      for (;;)
      {
        log("end to merge...");
        return;
        label265:
        deleteMergeAndOdexFiles();
        return;
        label269:
        log("---> merge : not merge share_pref len:" + getConfigPatchMergeFileLength() + "  file len:" + getFileLength(str1));
        break;
        label310:
        log("---> merge : not compile share_pref len:" + getConfigPatchMergeOdexFileLength() + " file len:" + getFileLength(paramString1));
      }
    }
    log("not need to merge...");
  }
  
  private static void resetPatchVersion(int paramInt)
  {
    LocalMultiProcConfig.putInt(AppSetting.a() + "p_ver", paramInt);
  }
  
  private static void saveConfigPatchMergeFileLength(long paramLong)
  {
    LocalMultiProcConfig.putLong(QUA.getQUA3() + "p_merge_len", paramLong);
  }
  
  private static void saveConfigPatchMergeOdexFileLength(long paramLong)
  {
    LocalMultiProcConfig.putLong(QUA.getQUA3() + "p_merge_odex_len", paramLong);
  }
  
  private static void saveConfigQZonePatchFileLength(long paramLong)
  {
    LocalMultiProcConfig.putLong(QUA.getQUA3() + "p_qzone_len", paramLong);
  }
  
  private static void updatePatchDex(String paramString1, String paramString2)
  {
    log(HardCodeUtil.a(2131712044));
    if (TextUtils.isEmpty(paramString1)) {
      log(HardCodeUtil.a(2131712049));
    }
    while (bPatchUpdating) {
      return;
    }
    bPatchUpdating = true;
    if (curPatchMd5 == null)
    {
      QLog.d("qz_patch", 1, "本地没有补丁包");
      if (!"del".equals(paramString1)) {}
    }
    for (;;)
    {
      bPatchUpdating = false;
      return;
      if ((paramString2 != null) && (!TextUtils.isEmpty(paramString2)))
      {
        downloadPatchAndClear(paramString1, paramString2);
        curPatchMd5 = paramString1;
        continue;
        QLog.d("qz_patch", 1, "本地有补丁包");
        if (!curPatchMd5.equals(paramString1)) {
          break;
        }
        log(HardCodeUtil.a(2131712045));
        processPatchForAboveAndroidN(BaseApplicationImpl.getContext(), getPatchPath(paramString1), paramString1);
      }
    }
    if ((paramString1.equals("del")) || (paramString1.equals("delete"))) {
      QLog.d("qz_patch", 1, "md5是del，直接删除旧的Patch");
    }
    for (;;)
    {
      int i;
      try
      {
        paramString1 = BaseApplicationImpl.getContext().getDir("patchs", 0);
        if (paramString1.exists())
        {
          paramString1 = paramString1.listFiles();
          int j = paramString1.length;
          i = 0;
          if (i < j)
          {
            paramString2 = paramString1[i];
            if (paramString2.isDirectory()) {
              break label368;
            }
            paramString2.delete();
          }
        }
      }
      catch (Throwable paramString1)
      {
        QLog.w("qz_patch", 1, QLog.getStackTraceString(paramString1));
      }
      for (;;)
      {
        QZoneHelper.preloadQZoneForHaboReport((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), "qz_patch", 11, "clear patch:" + curPatchMd5, 1, System.currentTimeMillis());
        QLog.d("qz_patch", 1, "report [qz_patch] clear patch:" + curPatchMd5);
        break;
        LocalMultiProcConfig.putLong(QUA.getQUA3() + "p_len", 0L);
        curPatchMd5 = null;
        deleteMergeAndOdexFiles();
      }
      log(HardCodeUtil.a(2131712042));
      deleteMergeAndOdexFiles();
      if ((paramString2 == null) || (TextUtils.isEmpty(paramString2))) {
        break;
      }
      downloadPatchAndClear(paramString1, paramString2);
      curPatchMd5 = paramString1;
      break;
      label368:
      i += 1;
    }
  }
  
  private static void verifyPatchFile()
  {
    log(HardCodeUtil.a(2131712046));
    curPatchMd5 = null;
    Object localObject1 = BaseApplicationImpl.getContext().getDir("patchs", 0);
    long l;
    int i;
    Object localObject3;
    if (((File)localObject1).exists())
    {
      Object localObject2 = QUA.getQUA3() + "p_len";
      l = LocalMultiProcConfig.getLong((String)localObject2, 0L);
      log((String)localObject2 + " = " + l);
      log(HardCodeUtil.a(2131712041) + l);
      localObject2 = ((File)localObject1).listFiles();
      if ((localObject2 != null) && (localObject2.length > 0))
      {
        int j = localObject2.length;
        i = 0;
        if (i < j)
        {
          localObject3 = localObject2[i];
          if (localObject3 != null) {}
        }
      }
    }
    for (;;)
    {
      i += 1;
      break;
      if (!localObject3.isDirectory()) {
        if (l != localObject3.length()) {
          localObject3.delete();
        } else {
          try
          {
            localObject1 = PluginStatic.encodeFile(localObject3.getAbsolutePath()).toLowerCase();
            String str2 = localObject3.getName();
            str3 = str2.substring(0, str2.length() - ".jar".length());
            if (((String)localObject1 + ".jar").endsWith(str2.toLowerCase()))
            {
              curPatchMd5 = str3;
              if (!TextUtils.isEmpty(curPatchMd5)) {
                break label408;
              }
              log(HardCodeUtil.a(2131712040));
              return;
            }
          }
          catch (Exception localException)
          {
            String str3;
            String str1;
            for (;;)
            {
              QLog.w("qz_patch", 1, QLog.getStackTraceString(localException));
              str1 = null;
            }
            localObject3.delete();
            deleteMergeAndOdexFiles();
            QZoneHelper.preloadQZoneForHaboReport((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), "qz_patch", 12, "patch verify failed: file md5: " + str1 + " but expected md5: " + str3, 1, System.currentTimeMillis());
            QLog.d("qz_patch", 1, "report [qz_patch] patch verify failed: file md5: " + str1 + " but expected md5: " + str3);
            curPatchMd5 = null;
          }
        }
      }
    }
    label408:
    log("当前补丁包的md5是" + curPatchMd5);
  }
  
  public void onPatchResponse(String paramString1, String paramString2)
  {
    if (QzoneConfig.getInstance().getConfig("QZoneSetting", "isPatchEnable", 1) == 0) {
      return;
    }
    ThreadManager.postDownLoadTask(new QZonePatchService.1(this, paramString1, paramString2), 8, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.patch.QZonePatchService
 * JD-Core Version:    0.7.0.1
 */