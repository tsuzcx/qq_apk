package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.q;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.nio.channels.FileLock;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class p
{
  public static ThreadLocal<Integer> a;
  static boolean b = false;
  static final FileFilter c = new p.2();
  private static p d;
  private static final ReentrantLock i = new ReentrantLock();
  private static final Lock j = new ReentrantLock();
  private static FileLock l = null;
  private static Handler m;
  private static final Long[][] n;
  private static int o = 0;
  private static boolean p = false;
  private int e = 0;
  private FileLock f;
  private FileOutputStream g;
  private boolean h = false;
  private boolean k = false;
  
  static
  {
    a = new p.1();
    m = null;
    Long localLong1 = Long.valueOf(39094008L);
    Long[] arrayOfLong = { Long.valueOf(44006L), localLong1 };
    Long localLong2 = Long.valueOf(38917816L);
    n = new Long[][] { arrayOfLong, { Long.valueOf(44005L), localLong1 }, { Long.valueOf(43910L), localLong2 }, { Long.valueOf(44027L), localLong1 }, { Long.valueOf(44028L), localLong1 }, { Long.valueOf(44029L), localLong1 }, { Long.valueOf(44030L), localLong1 }, { Long.valueOf(44032L), localLong1 }, { Long.valueOf(44033L), localLong1 }, { Long.valueOf(44034L), localLong1 }, { Long.valueOf(43909L), localLong2 } };
  }
  
  private p()
  {
    if (m == null) {
      m = new p.3(this, n.a().getLooper());
    }
  }
  
  private void A(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromCopy");
    if (!x(paramContext))
    {
      TbsLog.i("TbsInstaller", "get rename fileLock#4 ## failed!");
      return;
    }
    try
    {
      B(paramContext);
      D(paramContext);
      if (TbsShareManager.isThirdPartyApp(paramContext)) {
        TbsShareManager.writeCoreInfoForThirdPartyApp(paramContext, n(paramContext), true);
      } else {
        TbsShareManager.a(paramContext);
      }
      m.a(paramContext).a(0, 3);
      m.a(paramContext).a("tpatch_num", 0);
      if (!TbsShareManager.isThirdPartyApp(paramContext))
      {
        int i1 = TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_decouplecoreversion", 0);
        if ((i1 > 0) && (i1 != a().i(paramContext)) && (i1 == a().j(paramContext)))
        {
          o(paramContext);
        }
        else
        {
          StringBuilder localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("TbsInstaller--generateNewTbsCoreFromCopy #1 deCoupleCoreVersion is ");
          localStringBuilder1.append(i1);
          localStringBuilder1.append(" getTbsCoreShareDecoupleCoreVersion is ");
          localStringBuilder1.append(a().i(paramContext));
          localStringBuilder1.append(" getTbsCoreInstalledVerInNolock is ");
          localStringBuilder1.append(a().j(paramContext));
          TbsLog.i("TbsInstaller", localStringBuilder1.toString());
        }
      }
      a.set(Integer.valueOf(0));
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      TbsLogReport localTbsLogReport = TbsLogReport.getInstance(paramContext);
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("exception when renameing from copy:");
      localStringBuilder2.append(localException.toString());
      localTbsLogReport.setInstallErrorCode(219, localStringBuilder2.toString());
    }
    h(paramContext);
  }
  
  private void B(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--deleteOldCore");
    FileUtil.a(r(paramContext), false);
  }
  
  private void C(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--renameShareDir");
    Object localObject = f(paramContext, 0);
    File localFile = r(paramContext);
    if ((localObject != null) && (localFile != null))
    {
      boolean bool = ((File)localObject).renameTo(localFile);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("renameTbsCoreShareDir rename success=");
      ((StringBuilder)localObject).append(bool);
      TbsLog.i("TbsInstaller", ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("8is");
      ((StringBuilder)localObject).append(bool);
      q.a(((StringBuilder)localObject).toString());
      if ((paramContext != null) && ("com.tencent.mm".equals(paramContext.getApplicationContext().getApplicationInfo().packageName)))
      {
        int i1;
        if (bool)
        {
          localObject = TbsLogReport.getInstance(paramContext);
          i1 = 230;
        }
        else
        {
          localObject = TbsLogReport.getInstance(paramContext);
          i1 = 231;
        }
        ((TbsLogReport)localObject).setInstallErrorCode(i1, " ");
      }
      g(paramContext, false);
      return;
    }
    paramContext = new StringBuilder();
    paramContext.append("renameTbsCoreShareDir return,tmpTbsCoreUnzipDir=");
    paramContext.append(localObject);
    paramContext.append("tbsSharePath=");
    paramContext.append(localFile);
    TbsLog.i("TbsInstaller", paramContext.toString());
  }
  
  private void D(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--renameTbsCoreCopyDir");
    File localFile1 = f(paramContext, 1);
    File localFile2 = r(paramContext);
    if (localFile1 != null)
    {
      if (localFile2 == null) {
        return;
      }
      localFile1.renameTo(localFile2);
      g(paramContext, false);
    }
  }
  
  private void E(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--renameTbsTpatchCoreDir");
    File localFile1 = f(paramContext, 5);
    File localFile2 = r(paramContext);
    if (localFile1 != null)
    {
      if (localFile2 == null) {
        return;
      }
      localFile1.renameTo(localFile2);
      g(paramContext, false);
    }
  }
  
  private void F(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--clearNewTbsCore");
    File localFile = f(paramContext, 0);
    if (localFile != null) {
      FileUtil.a(localFile, false);
    }
    m.a(paramContext).c(0, 5);
    m.a(paramContext).c(-1);
    QbSdk.a(paramContext, "TbsInstaller::clearNewTbsCore forceSysWebViewInner!");
  }
  
  static p a()
  {
    try
    {
      if (d == null) {
        try
        {
          if (d == null) {
            d = new p();
          }
        }
        finally {}
      }
      p localp = d;
      return localp;
    }
    finally {}
  }
  
  /* Error */
  private void a(int paramInt, String paramString, Context paramContext)
  {
    // Byte code:
    //   0: new 267	java/io/File
    //   3: dup
    //   4: aload_2
    //   5: invokespecial 349	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: invokevirtual 353	java/io/File:delete	()Z
    //   11: pop
    //   12: new 202	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   19: astore 4
    //   21: aload 4
    //   23: ldc_w 355
    //   26: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload 4
    //   32: aload_2
    //   33: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload 4
    //   39: ldc_w 357
    //   42: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: ldc 127
    //   48: aload 4
    //   50: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: iconst_1
    //   54: invokestatic 360	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   57: new 267	java/io/File
    //   60: dup
    //   61: aload_3
    //   62: invokestatic 363	com/tencent/smtt/sdk/QbSdk:getTbsFolderDir	(Landroid/content/Context;)Ljava/io/File;
    //   65: ldc_w 365
    //   68: invokespecial 368	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   71: astore_2
    //   72: aload_2
    //   73: invokevirtual 371	java/io/File:canRead	()Z
    //   76: ifeq +258 -> 334
    //   79: new 267	java/io/File
    //   82: dup
    //   83: aload_2
    //   84: ldc_w 373
    //   87: invokespecial 368	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   90: astore 8
    //   92: new 375	java/util/Properties
    //   95: dup
    //   96: invokespecial 376	java/util/Properties:<init>	()V
    //   99: astore 6
    //   101: aconst_null
    //   102: astore 5
    //   104: aconst_null
    //   105: astore_3
    //   106: aconst_null
    //   107: astore 7
    //   109: new 378	java/io/BufferedInputStream
    //   112: dup
    //   113: new 380	java/io/FileInputStream
    //   116: dup
    //   117: aload 8
    //   119: invokespecial 383	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   122: invokespecial 386	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   125: astore_2
    //   126: aload 5
    //   128: astore_3
    //   129: aload_2
    //   130: astore 4
    //   132: aload 6
    //   134: aload_2
    //   135: invokevirtual 389	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   138: aload 5
    //   140: astore_3
    //   141: aload_2
    //   142: astore 4
    //   144: new 391	java/io/BufferedOutputStream
    //   147: dup
    //   148: new 393	java/io/FileOutputStream
    //   151: dup
    //   152: aload 8
    //   154: invokespecial 394	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   157: invokespecial 397	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   160: astore 5
    //   162: aload 6
    //   164: ldc_w 399
    //   167: ldc_w 401
    //   170: invokevirtual 405	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   173: pop
    //   174: aload 6
    //   176: aload 5
    //   178: aconst_null
    //   179: invokevirtual 409	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   182: ldc 127
    //   184: ldc_w 411
    //   187: iconst_1
    //   188: invokestatic 360	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   191: aload 5
    //   193: invokevirtual 414	java/io/BufferedOutputStream:close	()V
    //   196: goto +8 -> 204
    //   199: astore_3
    //   200: aload_3
    //   201: invokevirtual 415	java/io/IOException:printStackTrace	()V
    //   204: aload_2
    //   205: invokevirtual 416	java/io/BufferedInputStream:close	()V
    //   208: return
    //   209: astore 4
    //   211: aload 5
    //   213: astore_3
    //   214: aload 4
    //   216: astore 5
    //   218: goto +81 -> 299
    //   221: astore 6
    //   223: goto +27 -> 250
    //   226: astore 6
    //   228: aload 7
    //   230: astore 5
    //   232: goto +18 -> 250
    //   235: astore 5
    //   237: aconst_null
    //   238: astore_2
    //   239: goto +60 -> 299
    //   242: astore 6
    //   244: aconst_null
    //   245: astore_2
    //   246: aload 7
    //   248: astore 5
    //   250: aload 5
    //   252: astore_3
    //   253: aload_2
    //   254: astore 4
    //   256: aload 6
    //   258: invokevirtual 417	java/lang/Throwable:printStackTrace	()V
    //   261: aload 5
    //   263: ifnull +16 -> 279
    //   266: aload 5
    //   268: invokevirtual 414	java/io/BufferedOutputStream:close	()V
    //   271: goto +8 -> 279
    //   274: astore_3
    //   275: aload_3
    //   276: invokevirtual 415	java/io/IOException:printStackTrace	()V
    //   279: aload_2
    //   280: ifnull +54 -> 334
    //   283: aload_2
    //   284: invokevirtual 416	java/io/BufferedInputStream:close	()V
    //   287: return
    //   288: astore_2
    //   289: aload_2
    //   290: invokevirtual 415	java/io/IOException:printStackTrace	()V
    //   293: return
    //   294: astore 5
    //   296: aload 4
    //   298: astore_2
    //   299: aload_3
    //   300: ifnull +15 -> 315
    //   303: aload_3
    //   304: invokevirtual 414	java/io/BufferedOutputStream:close	()V
    //   307: goto +8 -> 315
    //   310: astore_3
    //   311: aload_3
    //   312: invokevirtual 415	java/io/IOException:printStackTrace	()V
    //   315: aload_2
    //   316: ifnull +15 -> 331
    //   319: aload_2
    //   320: invokevirtual 416	java/io/BufferedInputStream:close	()V
    //   323: goto +8 -> 331
    //   326: astore_2
    //   327: aload_2
    //   328: invokevirtual 415	java/io/IOException:printStackTrace	()V
    //   331: aload 5
    //   333: athrow
    //   334: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	335	0	this	p
    //   0	335	1	paramInt	int
    //   0	335	2	paramString	String
    //   0	335	3	paramContext	Context
    //   19	124	4	localObject1	Object
    //   209	6	4	localObject2	Object
    //   254	43	4	str	String
    //   102	129	5	localObject3	Object
    //   235	1	5	localObject4	Object
    //   248	19	5	localObject5	Object
    //   294	38	5	localObject6	Object
    //   99	76	6	localProperties	java.util.Properties
    //   221	1	6	localThrowable1	Throwable
    //   226	1	6	localThrowable2	Throwable
    //   242	15	6	localThrowable3	Throwable
    //   107	140	7	localObject7	Object
    //   90	63	8	localFile	File
    // Exception table:
    //   from	to	target	type
    //   191	196	199	java/io/IOException
    //   162	191	209	finally
    //   162	191	221	java/lang/Throwable
    //   132	138	226	java/lang/Throwable
    //   144	162	226	java/lang/Throwable
    //   109	126	235	finally
    //   109	126	242	java/lang/Throwable
    //   266	271	274	java/io/IOException
    //   204	208	288	java/io/IOException
    //   283	287	288	java/io/IOException
    //   132	138	294	finally
    //   144	162	294	finally
    //   256	261	294	finally
    //   303	307	310	java/io/IOException
    //   319	323	326	java/io/IOException
  }
  
  public static void a(Context paramContext)
  {
    if (!w(paramContext))
    {
      if (a(paramContext, "core_unzip_tmp"))
      {
        TbsCoreLoadStat.getInstance().a(paramContext, 417, new Throwable("TMP_TBS_UNZIP_FOLDER_NAME"));
        paramContext = "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_TBS_UNZIP_FOLDER_NAME";
      }
      for (;;)
      {
        TbsLog.e("TbsInstaller", paramContext);
        return;
        if (a(paramContext, "core_share_backup_tmp"))
        {
          TbsCoreLoadStat.getInstance().a(paramContext, 417, new Throwable("TMP_BACKUP_TBSCORE_FOLDER_NAME"));
          paramContext = "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_BACKUP_TBSCORE_FOLDER_NAME";
        }
        else
        {
          if (!a(paramContext, "core_copy_tmp")) {
            break;
          }
          TbsCoreLoadStat.getInstance().a(paramContext, 417, new Throwable("TMP_TBS_COPY_FOLDER_NAME"));
          paramContext = "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_TBS_COPY_FOLDER_NAME";
        }
      }
    }
  }
  
  /* Error */
  @TargetApi(11)
  private void a(Context paramContext1, Context paramContext2, int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 179	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4: sipush -524
    //   7: invokevirtual 457	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   10: aload_0
    //   11: aload_2
    //   12: invokevirtual 459	com/tencent/smtt/sdk/p:d	(Landroid/content/Context;)Z
    //   15: ifeq +4 -> 19
    //   18: return
    //   19: new 202	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   26: astore 13
    //   28: aload 13
    //   30: ldc_w 461
    //   33: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload 13
    //   39: iload_3
    //   40: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: ldc 127
    //   46: aload 13
    //   48: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: getstatic 466	android/os/Build$VERSION:SDK_INT	I
    //   57: bipush 11
    //   59: if_icmplt +16 -> 75
    //   62: aload_2
    //   63: ldc_w 468
    //   66: iconst_4
    //   67: invokevirtual 472	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   70: astore 13
    //   72: goto +13 -> 85
    //   75: aload_2
    //   76: ldc_w 468
    //   79: iconst_0
    //   80: invokevirtual 472	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   83: astore 13
    //   85: aload 13
    //   87: ldc_w 474
    //   90: iconst_m1
    //   91: invokeinterface 191 3 0
    //   96: iload_3
    //   97: if_icmpne +53 -> 150
    //   100: new 202	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   107: astore_2
    //   108: aload_2
    //   109: ldc_w 476
    //   112: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload_2
    //   117: iload_3
    //   118: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: aload_2
    //   123: ldc_w 478
    //   126: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: ldc 127
    //   132: aload_2
    //   133: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokestatic 438	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   139: aload_1
    //   140: invokestatic 179	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   143: sipush -525
    //   146: invokevirtual 457	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   149: return
    //   150: aload_0
    //   151: aload_2
    //   152: invokevirtual 481	com/tencent/smtt/sdk/p:u	(Landroid/content/Context;)Z
    //   155: ifne +14 -> 169
    //   158: aload_1
    //   159: invokestatic 179	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   162: sipush -526
    //   165: invokevirtual 457	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   168: return
    //   169: getstatic 43	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   172: invokeinterface 486 1 0
    //   177: istore 8
    //   179: new 202	java/lang/StringBuilder
    //   182: dup
    //   183: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   186: astore 13
    //   188: aload 13
    //   190: ldc_w 488
    //   193: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: aload 13
    //   199: iload 8
    //   201: invokevirtual 276	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: ldc 127
    //   207: aload 13
    //   209: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   215: iload 8
    //   217: ifeq +1936 -> 2153
    //   220: getstatic 41	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   223: invokevirtual 491	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   226: aload_2
    //   227: invokestatic 165	com/tencent/smtt/sdk/m:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/m;
    //   230: ldc_w 493
    //   233: invokevirtual 496	com/tencent/smtt/sdk/m:c	(Ljava/lang/String;)I
    //   236: istore 4
    //   238: aload_2
    //   239: invokestatic 165	com/tencent/smtt/sdk/m:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/m;
    //   242: ldc_w 498
    //   245: invokevirtual 500	com/tencent/smtt/sdk/m:b	(Ljava/lang/String;)I
    //   248: istore 5
    //   250: iload 4
    //   252: iload_3
    //   253: if_icmpne +43 -> 296
    //   256: getstatic 503	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   259: sipush 220
    //   262: invokeinterface 508 2 0
    //   267: aload_1
    //   268: invokestatic 179	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   271: sipush -528
    //   274: invokevirtual 457	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   277: getstatic 41	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   280: invokevirtual 511	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   283: getstatic 43	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   286: invokeinterface 512 1 0
    //   291: aload_0
    //   292: invokevirtual 514	com/tencent/smtt/sdk/p:b	()V
    //   295: return
    //   296: aload_0
    //   297: aload_2
    //   298: invokevirtual 198	com/tencent/smtt/sdk/p:j	(Landroid/content/Context;)I
    //   301: istore 6
    //   303: new 202	java/lang/StringBuilder
    //   306: dup
    //   307: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   310: astore 13
    //   312: aload 13
    //   314: ldc_w 516
    //   317: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: pop
    //   321: aload 13
    //   323: iload 6
    //   325: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   328: pop
    //   329: ldc 127
    //   331: aload 13
    //   333: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   336: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   339: iload 6
    //   341: iload_3
    //   342: if_icmpne +79 -> 421
    //   345: getstatic 503	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   348: sipush 220
    //   351: invokeinterface 508 2 0
    //   356: aload_1
    //   357: invokestatic 179	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   360: sipush -528
    //   363: invokevirtual 457	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   366: new 202	java/lang/StringBuilder
    //   369: dup
    //   370: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   373: astore 13
    //   375: aload 13
    //   377: ldc_w 518
    //   380: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: pop
    //   384: aload 13
    //   386: iload 6
    //   388: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   391: pop
    //   392: ldc 127
    //   394: aload 13
    //   396: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   399: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   402: getstatic 41	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   405: invokevirtual 511	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   408: getstatic 43	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   411: invokeinterface 512 1 0
    //   416: aload_0
    //   417: invokevirtual 514	com/tencent/smtt/sdk/p:b	()V
    //   420: return
    //   421: aload_2
    //   422: invokestatic 165	com/tencent/smtt/sdk/m:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/m;
    //   425: invokevirtual 521	com/tencent/smtt/sdk/m:b	()I
    //   428: istore 7
    //   430: iload 7
    //   432: ifle +1736 -> 2168
    //   435: iload_3
    //   436: iload 7
    //   438: if_icmpgt +6 -> 444
    //   441: goto +1727 -> 2168
    //   444: aload_0
    //   445: aload_2
    //   446: invokevirtual 523	com/tencent/smtt/sdk/p:p	(Landroid/content/Context;)V
    //   449: goto +1733 -> 2182
    //   452: aload_0
    //   453: aload_2
    //   454: invokevirtual 523	com/tencent/smtt/sdk/p:p	(Landroid/content/Context;)V
    //   457: ldc 127
    //   459: ldc_w 525
    //   462: iconst_1
    //   463: invokestatic 360	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   466: iconst_m1
    //   467: istore 4
    //   469: aload_2
    //   470: invokestatic 527	com/tencent/smtt/utils/FileUtil:b	(Landroid/content/Context;)Z
    //   473: ifne +108 -> 581
    //   476: invokestatic 530	com/tencent/smtt/utils/q:a	()J
    //   479: lstore 9
    //   481: aload_2
    //   482: invokestatic 179	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   485: invokevirtual 533	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMinFreeSpace	()J
    //   488: lstore 11
    //   490: aload_1
    //   491: invokestatic 179	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   494: sipush -529
    //   497: invokevirtual 457	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   500: aload_2
    //   501: invokestatic 239	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   504: astore 13
    //   506: new 202	java/lang/StringBuilder
    //   509: dup
    //   510: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   513: astore 14
    //   515: aload 14
    //   517: ldc_w 535
    //   520: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: pop
    //   524: aload 14
    //   526: lload 9
    //   528: invokevirtual 538	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   531: pop
    //   532: aload 14
    //   534: ldc_w 540
    //   537: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: pop
    //   541: aload 14
    //   543: lload 11
    //   545: invokevirtual 538	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   548: pop
    //   549: aload 13
    //   551: sipush 210
    //   554: aload 14
    //   556: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   559: invokevirtual 246	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   562: getstatic 41	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   565: invokevirtual 511	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   568: getstatic 43	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   571: invokeinterface 512 1 0
    //   576: aload_0
    //   577: invokevirtual 514	com/tencent/smtt/sdk/p:b	()V
    //   580: return
    //   581: iload 4
    //   583: ifle +87 -> 670
    //   586: aload_2
    //   587: invokestatic 151	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   590: ifne +22 -> 612
    //   593: aload_2
    //   594: invokestatic 544	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   597: ifeq +15 -> 612
    //   600: iload_3
    //   601: aload_0
    //   602: aload_2
    //   603: invokevirtual 196	com/tencent/smtt/sdk/p:i	(Landroid/content/Context;)I
    //   606: if_icmpeq +6 -> 612
    //   609: goto +61 -> 670
    //   612: new 202	java/lang/StringBuilder
    //   615: dup
    //   616: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   619: astore 13
    //   621: aload 13
    //   623: ldc_w 546
    //   626: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   629: pop
    //   630: aload 13
    //   632: aload_0
    //   633: aload_2
    //   634: invokevirtual 196	com/tencent/smtt/sdk/p:i	(Landroid/content/Context;)I
    //   637: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   640: pop
    //   641: ldc 127
    //   643: aload 13
    //   645: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   648: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   651: getstatic 41	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   654: invokevirtual 511	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   657: getstatic 43	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   660: invokeinterface 512 1 0
    //   665: aload_0
    //   666: invokevirtual 514	com/tencent/smtt/sdk/p:b	()V
    //   669: return
    //   670: iload 4
    //   672: ifne +77 -> 749
    //   675: aload_2
    //   676: invokestatic 165	com/tencent/smtt/sdk/m:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/m;
    //   679: ldc_w 548
    //   682: invokevirtual 496	com/tencent/smtt/sdk/m:c	(Ljava/lang/String;)I
    //   685: istore 4
    //   687: iload 4
    //   689: iconst_2
    //   690: if_icmple +45 -> 735
    //   693: aload_2
    //   694: invokestatic 239	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   697: sipush 211
    //   700: ldc_w 550
    //   703: invokevirtual 246	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   706: aload_1
    //   707: invokestatic 179	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   710: sipush -530
    //   713: invokevirtual 457	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   716: getstatic 41	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   719: invokevirtual 511	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   722: getstatic 43	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   725: invokeinterface 512 1 0
    //   730: aload_0
    //   731: invokevirtual 514	com/tencent/smtt/sdk/p:b	()V
    //   734: return
    //   735: aload_2
    //   736: invokestatic 165	com/tencent/smtt/sdk/m:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/m;
    //   739: ldc_w 548
    //   742: iload 4
    //   744: iconst_1
    //   745: iadd
    //   746: invokevirtual 173	com/tencent/smtt/sdk/m:a	(Ljava/lang/String;I)V
    //   749: aload_0
    //   750: aload_1
    //   751: invokevirtual 254	com/tencent/smtt/sdk/p:r	(Landroid/content/Context;)Ljava/io/File;
    //   754: astore 14
    //   756: aload_2
    //   757: invokestatic 151	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   760: ifne +20 -> 780
    //   763: aload_2
    //   764: invokestatic 544	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   767: ifeq +13 -> 780
    //   770: aload_0
    //   771: aload_2
    //   772: invokevirtual 553	com/tencent/smtt/sdk/p:q	(Landroid/content/Context;)Ljava/io/File;
    //   775: astore 13
    //   777: goto +11 -> 788
    //   780: aload_0
    //   781: aload_2
    //   782: iconst_1
    //   783: invokevirtual 265	com/tencent/smtt/sdk/p:f	(Landroid/content/Context;I)Ljava/io/File;
    //   786: astore 13
    //   788: aload 14
    //   790: ifnull +1154 -> 1944
    //   793: aload 13
    //   795: ifnull +1149 -> 1944
    //   798: aload_2
    //   799: invokestatic 165	com/tencent/smtt/sdk/m:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/m;
    //   802: iload_3
    //   803: iconst_0
    //   804: invokevirtual 168	com/tencent/smtt/sdk/m:a	(II)V
    //   807: new 555	com/tencent/smtt/utils/p
    //   810: dup
    //   811: invokespecial 556	com/tencent/smtt/utils/p:<init>	()V
    //   814: astore 15
    //   816: aload 15
    //   818: aload 14
    //   820: invokevirtual 558	com/tencent/smtt/utils/p:a	(Ljava/io/File;)V
    //   823: invokestatic 563	java/lang/System:currentTimeMillis	()J
    //   826: lstore 9
    //   828: aload_1
    //   829: invokestatic 179	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   832: sipush -551
    //   835: invokevirtual 457	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   838: aload 14
    //   840: aload 13
    //   842: getstatic 95	com/tencent/smtt/sdk/p:c	Ljava/io/FileFilter;
    //   845: invokestatic 566	com/tencent/smtt/utils/FileUtil:a	(Ljava/io/File;Ljava/io/File;Ljava/io/FileFilter;)Z
    //   848: istore 8
    //   850: aload_2
    //   851: invokestatic 544	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   854: ifeq +7 -> 861
    //   857: aload_2
    //   858: invokestatic 568	com/tencent/smtt/sdk/TbsShareManager:b	(Landroid/content/Context;)V
    //   861: new 202	java/lang/StringBuilder
    //   864: dup
    //   865: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   868: astore 16
    //   870: aload 16
    //   872: ldc_w 570
    //   875: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   878: pop
    //   879: aload 16
    //   881: invokestatic 563	java/lang/System:currentTimeMillis	()J
    //   884: lload 9
    //   886: lsub
    //   887: invokevirtual 538	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   890: pop
    //   891: ldc 127
    //   893: aload 16
    //   895: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   898: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   901: iload 8
    //   903: ifeq +992 -> 1895
    //   906: aload 15
    //   908: aload 14
    //   910: invokevirtual 572	com/tencent/smtt/utils/p:b	(Ljava/io/File;)V
    //   913: aload 15
    //   915: invokevirtual 574	com/tencent/smtt/utils/p:a	()Z
    //   918: ifne +59 -> 977
    //   921: ldc 127
    //   923: ldc_w 576
    //   926: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   929: aload 13
    //   931: iconst_1
    //   932: invokestatic 259	com/tencent/smtt/utils/FileUtil:a	(Ljava/io/File;Z)V
    //   935: aload_2
    //   936: invokestatic 239	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   939: sipush 213
    //   942: ldc_w 578
    //   945: invokevirtual 246	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   948: aload_1
    //   949: invokestatic 179	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   952: sipush -531
    //   955: invokevirtual 457	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   958: getstatic 41	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   961: invokevirtual 511	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   964: getstatic 43	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   967: invokeinterface 512 1 0
    //   972: aload_0
    //   973: invokevirtual 514	com/tencent/smtt/sdk/p:b	()V
    //   976: return
    //   977: new 267	java/io/File
    //   980: dup
    //   981: aload 13
    //   983: ldc_w 580
    //   986: invokespecial 368	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   989: astore 15
    //   991: new 375	java/util/Properties
    //   994: dup
    //   995: invokespecial 376	java/util/Properties:<init>	()V
    //   998: astore 14
    //   1000: aload 15
    //   1002: invokevirtual 583	java/io/File:exists	()Z
    //   1005: ifeq +52 -> 1057
    //   1008: new 378	java/io/BufferedInputStream
    //   1011: dup
    //   1012: new 380	java/io/FileInputStream
    //   1015: dup
    //   1016: aload 15
    //   1018: invokespecial 383	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   1021: invokespecial 386	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1024: astore 15
    //   1026: aload 14
    //   1028: aload 15
    //   1030: invokevirtual 389	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   1033: iconst_1
    //   1034: istore 4
    //   1036: goto +27 -> 1063
    //   1039: astore 14
    //   1041: goto +831 -> 1872
    //   1044: astore 17
    //   1046: aload 14
    //   1048: astore 16
    //   1050: aload 15
    //   1052: astore 14
    //   1054: goto +85 -> 1139
    //   1057: iconst_0
    //   1058: istore 4
    //   1060: aconst_null
    //   1061: astore 15
    //   1063: iload 4
    //   1065: istore 5
    //   1067: aload 14
    //   1069: astore 16
    //   1071: aload 15
    //   1073: ifnull +94 -> 1167
    //   1076: aload 15
    //   1078: invokevirtual 416	java/io/BufferedInputStream:close	()V
    //   1081: iload 4
    //   1083: istore 5
    //   1085: aload 14
    //   1087: astore 16
    //   1089: goto +78 -> 1167
    //   1092: astore 15
    //   1094: aload 15
    //   1096: invokevirtual 415	java/io/IOException:printStackTrace	()V
    //   1099: iload 4
    //   1101: istore 5
    //   1103: aload 14
    //   1105: astore 16
    //   1107: goto +60 -> 1167
    //   1110: astore 15
    //   1112: aload 14
    //   1114: astore 16
    //   1116: goto +16 -> 1132
    //   1119: astore 14
    //   1121: aconst_null
    //   1122: astore 15
    //   1124: goto +748 -> 1872
    //   1127: astore 15
    //   1129: aconst_null
    //   1130: astore 16
    //   1132: aconst_null
    //   1133: astore 14
    //   1135: aload 15
    //   1137: astore 17
    //   1139: aload 17
    //   1141: invokevirtual 234	java/lang/Exception:printStackTrace	()V
    //   1144: aload 14
    //   1146: ifnull +1075 -> 2221
    //   1149: aload 14
    //   1151: invokevirtual 416	java/io/BufferedInputStream:close	()V
    //   1154: goto +1067 -> 2221
    //   1157: astore 14
    //   1159: aload 14
    //   1161: invokevirtual 415	java/io/IOException:printStackTrace	()V
    //   1164: goto +1057 -> 2221
    //   1167: iload 5
    //   1169: ifeq +1067 -> 2236
    //   1172: aload 13
    //   1174: invokevirtual 587	java/io/File:listFiles	()[Ljava/io/File;
    //   1177: astore 15
    //   1179: aload_1
    //   1180: invokestatic 179	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1183: sipush -552
    //   1186: invokevirtual 457	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1189: iconst_0
    //   1190: istore 4
    //   1192: iload 4
    //   1194: aload 15
    //   1196: arraylength
    //   1197: if_icmpge +1039 -> 2236
    //   1200: aload 15
    //   1202: iload 4
    //   1204: aaload
    //   1205: astore 14
    //   1207: ldc_w 580
    //   1210: aload 14
    //   1212: invokevirtual 590	java/io/File:getName	()Ljava/lang/String;
    //   1215: invokevirtual 307	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1218: ifne +1009 -> 2227
    //   1221: aload 14
    //   1223: invokevirtual 590	java/io/File:getName	()Ljava/lang/String;
    //   1226: ldc_w 592
    //   1229: invokevirtual 596	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1232: ifne +995 -> 2227
    //   1235: ldc_w 373
    //   1238: aload 14
    //   1240: invokevirtual 590	java/io/File:getName	()Ljava/lang/String;
    //   1243: invokevirtual 307	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1246: ifne +981 -> 2227
    //   1249: aload 14
    //   1251: invokevirtual 599	java/io/File:isDirectory	()Z
    //   1254: ifne +973 -> 2227
    //   1257: aload 14
    //   1259: invokevirtual 590	java/io/File:getName	()Ljava/lang/String;
    //   1262: ldc_w 601
    //   1265: invokevirtual 596	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1268: ifeq +6 -> 1274
    //   1271: goto +956 -> 2227
    //   1274: aload 14
    //   1276: invokestatic 606	com/tencent/smtt/utils/a:a	(Ljava/io/File;)Ljava/lang/String;
    //   1279: astore 17
    //   1281: aload 16
    //   1283: aload 14
    //   1285: invokevirtual 590	java/io/File:getName	()Ljava/lang/String;
    //   1288: ldc_w 608
    //   1291: invokevirtual 612	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1294: astore 18
    //   1296: aload 18
    //   1298: ldc_w 608
    //   1301: invokevirtual 307	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1304: ifne +64 -> 1368
    //   1307: aload 17
    //   1309: aload 18
    //   1311: invokevirtual 307	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1314: ifeq +54 -> 1368
    //   1317: new 202	java/lang/StringBuilder
    //   1320: dup
    //   1321: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   1324: astore 17
    //   1326: aload 17
    //   1328: ldc_w 614
    //   1331: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1334: pop
    //   1335: aload 17
    //   1337: aload 14
    //   1339: invokevirtual 590	java/io/File:getName	()Ljava/lang/String;
    //   1342: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1345: pop
    //   1346: aload 17
    //   1348: ldc_w 616
    //   1351: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1354: pop
    //   1355: ldc 127
    //   1357: aload 17
    //   1359: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1362: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1365: goto +862 -> 2227
    //   1368: new 202	java/lang/StringBuilder
    //   1371: dup
    //   1372: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   1375: astore 15
    //   1377: aload 15
    //   1379: ldc_w 618
    //   1382: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1385: pop
    //   1386: aload 15
    //   1388: aload 14
    //   1390: invokevirtual 590	java/io/File:getName	()Ljava/lang/String;
    //   1393: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1396: pop
    //   1397: aload 15
    //   1399: ldc_w 616
    //   1402: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1405: pop
    //   1406: aload 15
    //   1408: ldc_w 620
    //   1411: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1414: pop
    //   1415: aload 15
    //   1417: aload 18
    //   1419: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1422: pop
    //   1423: aload 15
    //   1425: ldc_w 622
    //   1428: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1431: pop
    //   1432: aload 15
    //   1434: aload 17
    //   1436: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1439: pop
    //   1440: ldc 127
    //   1442: aload 15
    //   1444: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1447: invokestatic 438	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1450: iconst_0
    //   1451: istore 8
    //   1453: goto +3 -> 1456
    //   1456: new 202	java/lang/StringBuilder
    //   1459: dup
    //   1460: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   1463: astore 14
    //   1465: aload 14
    //   1467: ldc_w 624
    //   1470: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1473: pop
    //   1474: aload 14
    //   1476: iload 8
    //   1478: invokevirtual 276	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1481: pop
    //   1482: ldc 127
    //   1484: aload 14
    //   1486: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1489: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1492: iload 5
    //   1494: ifeq +64 -> 1558
    //   1497: iload 8
    //   1499: ifne +59 -> 1558
    //   1502: ldc 127
    //   1504: ldc_w 626
    //   1507: invokestatic 438	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1510: aload 13
    //   1512: iconst_1
    //   1513: invokestatic 259	com/tencent/smtt/utils/FileUtil:a	(Ljava/io/File;Z)V
    //   1516: aload_2
    //   1517: invokestatic 239	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1520: sipush 213
    //   1523: ldc_w 628
    //   1526: invokevirtual 246	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1529: aload_1
    //   1530: invokestatic 179	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1533: sipush -532
    //   1536: invokevirtual 457	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1539: getstatic 41	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1542: invokevirtual 511	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1545: getstatic 43	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   1548: invokeinterface 512 1 0
    //   1553: aload_0
    //   1554: invokevirtual 514	com/tencent/smtt/sdk/p:b	()V
    //   1557: return
    //   1558: ldc 127
    //   1560: ldc_w 630
    //   1563: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1566: aload_0
    //   1567: aload_2
    //   1568: iconst_1
    //   1569: invokespecial 312	com/tencent/smtt/sdk/p:g	(Landroid/content/Context;Z)V
    //   1572: aload_1
    //   1573: invokestatic 634	com/tencent/smtt/sdk/l:b	(Landroid/content/Context;)Ljava/io/File;
    //   1576: astore 15
    //   1578: aload 15
    //   1580: ifnull +47 -> 1627
    //   1583: aload 15
    //   1585: invokevirtual 583	java/io/File:exists	()Z
    //   1588: ifeq +39 -> 1627
    //   1591: aload_2
    //   1592: invokestatic 637	com/tencent/smtt/sdk/TbsDownloader:getOverSea	(Landroid/content/Context;)Z
    //   1595: ifeq +11 -> 1606
    //   1598: ldc_w 639
    //   1601: astore 14
    //   1603: goto +9 -> 1612
    //   1606: iconst_0
    //   1607: invokestatic 643	com/tencent/smtt/sdk/TbsDownloader:getBackupFileName	(Z)Ljava/lang/String;
    //   1610: astore 14
    //   1612: new 267	java/io/File
    //   1615: dup
    //   1616: aload 15
    //   1618: aload 14
    //   1620: invokespecial 368	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   1623: aload_2
    //   1624: invokestatic 646	com/tencent/smtt/sdk/l:a	(Ljava/io/File;Landroid/content/Context;)V
    //   1627: aload_2
    //   1628: invokestatic 165	com/tencent/smtt/sdk/m:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/m;
    //   1631: iload_3
    //   1632: iconst_1
    //   1633: invokevirtual 168	com/tencent/smtt/sdk/m:a	(II)V
    //   1636: aload_0
    //   1637: getfield 107	com/tencent/smtt/sdk/p:k	Z
    //   1640: ifeq +27 -> 1667
    //   1643: aload_2
    //   1644: invokestatic 239	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1647: astore 14
    //   1649: ldc_w 648
    //   1652: astore 15
    //   1654: aload 14
    //   1656: sipush 220
    //   1659: aload 15
    //   1661: invokevirtual 246	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1664: goto +17 -> 1681
    //   1667: aload_2
    //   1668: invokestatic 239	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1671: astore 14
    //   1673: ldc_w 650
    //   1676: astore 15
    //   1678: goto -24 -> 1654
    //   1681: aload_1
    //   1682: invokestatic 179	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1685: sipush -533
    //   1688: invokevirtual 457	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1691: new 202	java/lang/StringBuilder
    //   1694: dup
    //   1695: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   1698: astore 14
    //   1700: aload 14
    //   1702: ldc_w 652
    //   1705: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1708: pop
    //   1709: aload 14
    //   1711: iload_3
    //   1712: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1715: pop
    //   1716: ldc 127
    //   1718: aload 14
    //   1720: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1723: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1726: getstatic 466	android/os/Build$VERSION:SDK_INT	I
    //   1729: bipush 11
    //   1731: if_icmplt +16 -> 1747
    //   1734: aload_2
    //   1735: ldc_w 468
    //   1738: iconst_4
    //   1739: invokevirtual 472	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   1742: astore 14
    //   1744: goto +13 -> 1757
    //   1747: aload_2
    //   1748: ldc_w 468
    //   1751: iconst_0
    //   1752: invokevirtual 472	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   1755: astore 14
    //   1757: aload 14
    //   1759: invokeinterface 656 1 0
    //   1764: astore 14
    //   1766: aload 14
    //   1768: ldc_w 658
    //   1771: iconst_0
    //   1772: invokeinterface 664 3 0
    //   1777: pop
    //   1778: aload 14
    //   1780: ldc_w 666
    //   1783: iconst_0
    //   1784: invokeinterface 664 3 0
    //   1789: pop
    //   1790: aload 14
    //   1792: ldc_w 668
    //   1795: iload_3
    //   1796: invokeinterface 664 3 0
    //   1801: pop
    //   1802: aload 14
    //   1804: invokeinterface 671 1 0
    //   1809: pop
    //   1810: goto +44 -> 1854
    //   1813: astore 14
    //   1815: new 202	java/lang/StringBuilder
    //   1818: dup
    //   1819: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   1822: astore 15
    //   1824: aload 15
    //   1826: ldc_w 673
    //   1829: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1832: pop
    //   1833: aload 15
    //   1835: aload 14
    //   1837: invokestatic 679	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1840: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1843: pop
    //   1844: ldc 127
    //   1846: aload 15
    //   1848: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1851: invokestatic 438	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1854: aload_2
    //   1855: invokestatic 680	com/tencent/smtt/utils/q:a	(Landroid/content/Context;)Z
    //   1858: pop
    //   1859: goto +255 -> 2114
    //   1862: astore 16
    //   1864: aload 14
    //   1866: astore 15
    //   1868: aload 16
    //   1870: astore 14
    //   1872: aload 15
    //   1874: ifnull +18 -> 1892
    //   1877: aload 15
    //   1879: invokevirtual 416	java/io/BufferedInputStream:close	()V
    //   1882: goto +10 -> 1892
    //   1885: astore 15
    //   1887: aload 15
    //   1889: invokevirtual 415	java/io/IOException:printStackTrace	()V
    //   1892: aload 14
    //   1894: athrow
    //   1895: ldc 127
    //   1897: ldc_w 682
    //   1900: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1903: aload_2
    //   1904: invokestatic 165	com/tencent/smtt/sdk/m:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/m;
    //   1907: iload_3
    //   1908: iconst_2
    //   1909: invokevirtual 168	com/tencent/smtt/sdk/m:a	(II)V
    //   1912: aload 13
    //   1914: iconst_0
    //   1915: invokestatic 259	com/tencent/smtt/utils/FileUtil:a	(Ljava/io/File;Z)V
    //   1918: aload_1
    //   1919: invokestatic 179	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1922: sipush -534
    //   1925: invokevirtual 457	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1928: aload_2
    //   1929: invokestatic 239	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1932: sipush 212
    //   1935: ldc_w 684
    //   1938: invokevirtual 246	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1941: goto +173 -> 2114
    //   1944: aload 14
    //   1946: ifnonnull +29 -> 1975
    //   1949: aload_2
    //   1950: invokestatic 239	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1953: sipush 213
    //   1956: ldc_w 686
    //   1959: invokevirtual 246	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1962: aload_1
    //   1963: invokestatic 179	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1966: sipush -535
    //   1969: invokevirtual 457	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1972: goto +3 -> 1975
    //   1975: aload 13
    //   1977: ifnonnull +137 -> 2114
    //   1980: aload_2
    //   1981: invokestatic 239	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1984: sipush 214
    //   1987: ldc_w 688
    //   1990: invokevirtual 246	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1993: aload_1
    //   1994: invokestatic 179	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1997: sipush -536
    //   2000: invokevirtual 457	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   2003: goto +111 -> 2114
    //   2006: astore_1
    //   2007: goto +126 -> 2133
    //   2010: astore 13
    //   2012: aconst_null
    //   2013: astore 15
    //   2015: aload 13
    //   2017: astore 14
    //   2019: aload_2
    //   2020: invokestatic 239	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   2023: sipush 215
    //   2026: aload 14
    //   2028: invokevirtual 242	java/lang/Exception:toString	()Ljava/lang/String;
    //   2031: invokevirtual 246	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   2034: aload_1
    //   2035: invokestatic 179	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2038: sipush -537
    //   2041: invokevirtual 457	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   2044: aload 15
    //   2046: iconst_0
    //   2047: invokestatic 259	com/tencent/smtt/utils/FileUtil:a	(Ljava/io/File;Z)V
    //   2050: aload_2
    //   2051: invokestatic 165	com/tencent/smtt/sdk/m:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/m;
    //   2054: iconst_0
    //   2055: iconst_m1
    //   2056: invokevirtual 168	com/tencent/smtt/sdk/m:a	(II)V
    //   2059: goto +55 -> 2114
    //   2062: astore_1
    //   2063: new 202	java/lang/StringBuilder
    //   2066: dup
    //   2067: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   2070: astore_2
    //   2071: aload_2
    //   2072: ldc_w 690
    //   2075: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2078: pop
    //   2079: aload_2
    //   2080: aload_1
    //   2081: invokevirtual 693	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2084: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2087: pop
    //   2088: aload_2
    //   2089: ldc_w 695
    //   2092: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2095: pop
    //   2096: aload_2
    //   2097: aload_1
    //   2098: invokevirtual 699	java/lang/Exception:getCause	()Ljava/lang/Throwable;
    //   2101: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2104: pop
    //   2105: ldc 127
    //   2107: aload_2
    //   2108: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2111: invokestatic 438	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2114: getstatic 41	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   2117: invokevirtual 511	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   2120: getstatic 43	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   2123: invokeinterface 512 1 0
    //   2128: aload_0
    //   2129: invokevirtual 514	com/tencent/smtt/sdk/p:b	()V
    //   2132: return
    //   2133: getstatic 41	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   2136: invokevirtual 511	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   2139: getstatic 43	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   2142: invokeinterface 512 1 0
    //   2147: aload_0
    //   2148: invokevirtual 514	com/tencent/smtt/sdk/p:b	()V
    //   2151: aload_1
    //   2152: athrow
    //   2153: aload_0
    //   2154: invokevirtual 514	com/tencent/smtt/sdk/p:b	()V
    //   2157: aload_1
    //   2158: invokestatic 179	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2161: sipush -538
    //   2164: invokevirtual 457	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   2167: return
    //   2168: iload 4
    //   2170: ifle +12 -> 2182
    //   2173: iload_3
    //   2174: iload 4
    //   2176: if_icmple +6 -> 2182
    //   2179: goto -1735 -> 444
    //   2182: iload 5
    //   2184: istore 4
    //   2186: iload 5
    //   2188: iconst_3
    //   2189: if_icmpne -1720 -> 469
    //   2192: iload 5
    //   2194: istore 4
    //   2196: iload 6
    //   2198: ifle -1729 -> 469
    //   2201: iload_3
    //   2202: iload 6
    //   2204: if_icmpgt -1752 -> 452
    //   2207: iload 5
    //   2209: istore 4
    //   2211: iload_3
    //   2212: ldc_w 700
    //   2215: if_icmpne -1746 -> 469
    //   2218: goto -1766 -> 452
    //   2221: iconst_1
    //   2222: istore 5
    //   2224: goto -1057 -> 1167
    //   2227: iload 4
    //   2229: iconst_1
    //   2230: iadd
    //   2231: istore 4
    //   2233: goto -1041 -> 1192
    //   2236: iconst_1
    //   2237: istore 8
    //   2239: goto -783 -> 1456
    //   2242: astore 14
    //   2244: aload 13
    //   2246: astore 15
    //   2248: goto -229 -> 2019
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2251	0	this	p
    //   0	2251	1	paramContext1	Context
    //   0	2251	2	paramContext2	Context
    //   0	2251	3	paramInt	int
    //   236	1996	4	i1	int
    //   248	1975	5	i2	int
    //   301	1904	6	i3	int
    //   428	11	7	i4	int
    //   177	2061	8	bool	boolean
    //   479	406	9	l1	long
    //   488	56	11	l2	long
    //   26	1950	13	localObject1	Object
    //   2010	235	13	localException1	Exception
    //   513	514	14	localObject2	Object
    //   1039	8	14	localObject3	Object
    //   1052	61	14	localObject4	Object
    //   1119	1	14	localObject5	Object
    //   1133	17	14	localObject6	Object
    //   1157	3	14	localIOException1	java.io.IOException
    //   1205	598	14	localObject7	Object
    //   1813	52	14	localThrowable	Throwable
    //   1870	157	14	localObject8	Object
    //   2242	1	14	localException2	Exception
    //   814	263	15	localObject9	Object
    //   1092	3	15	localIOException2	java.io.IOException
    //   1110	1	15	localException3	Exception
    //   1122	1	15	localObject10	Object
    //   1127	9	15	localException4	Exception
    //   1177	701	15	localObject11	Object
    //   1885	3	15	localIOException3	java.io.IOException
    //   2013	234	15	localObject12	Object
    //   868	414	16	localObject13	Object
    //   1862	7	16	localObject14	Object
    //   1044	1	17	localException5	Exception
    //   1137	298	17	localObject15	Object
    //   1294	124	18	str	String
    // Exception table:
    //   from	to	target	type
    //   1026	1033	1039	finally
    //   1026	1033	1044	java/lang/Exception
    //   1076	1081	1092	java/io/IOException
    //   1000	1026	1110	java/lang/Exception
    //   977	1000	1119	finally
    //   1000	1026	1119	finally
    //   977	1000	1127	java/lang/Exception
    //   1149	1154	1157	java/io/IOException
    //   1757	1810	1813	java/lang/Throwable
    //   1139	1144	1862	finally
    //   1877	1882	1885	java/io/IOException
    //   226	250	2006	finally
    //   256	277	2006	finally
    //   296	339	2006	finally
    //   345	402	2006	finally
    //   421	430	2006	finally
    //   444	449	2006	finally
    //   452	466	2006	finally
    //   469	562	2006	finally
    //   586	609	2006	finally
    //   612	651	2006	finally
    //   675	687	2006	finally
    //   693	716	2006	finally
    //   735	749	2006	finally
    //   749	777	2006	finally
    //   780	788	2006	finally
    //   798	861	2006	finally
    //   861	901	2006	finally
    //   906	958	2006	finally
    //   1076	1081	2006	finally
    //   1094	1099	2006	finally
    //   1149	1154	2006	finally
    //   1159	1164	2006	finally
    //   1172	1189	2006	finally
    //   1192	1200	2006	finally
    //   1207	1271	2006	finally
    //   1274	1365	2006	finally
    //   1368	1450	2006	finally
    //   1456	1492	2006	finally
    //   1502	1539	2006	finally
    //   1558	1578	2006	finally
    //   1583	1598	2006	finally
    //   1606	1612	2006	finally
    //   1612	1627	2006	finally
    //   1627	1649	2006	finally
    //   1654	1664	2006	finally
    //   1667	1673	2006	finally
    //   1681	1744	2006	finally
    //   1747	1757	2006	finally
    //   1757	1810	2006	finally
    //   1815	1854	2006	finally
    //   1854	1859	2006	finally
    //   1877	1882	2006	finally
    //   1887	1892	2006	finally
    //   1892	1895	2006	finally
    //   1895	1941	2006	finally
    //   1949	1972	2006	finally
    //   1980	2003	2006	finally
    //   2019	2044	2006	finally
    //   2044	2059	2006	finally
    //   2063	2114	2006	finally
    //   226	250	2010	java/lang/Exception
    //   256	277	2010	java/lang/Exception
    //   296	339	2010	java/lang/Exception
    //   345	402	2010	java/lang/Exception
    //   421	430	2010	java/lang/Exception
    //   444	449	2010	java/lang/Exception
    //   452	466	2010	java/lang/Exception
    //   469	562	2010	java/lang/Exception
    //   586	609	2010	java/lang/Exception
    //   612	651	2010	java/lang/Exception
    //   675	687	2010	java/lang/Exception
    //   693	716	2010	java/lang/Exception
    //   735	749	2010	java/lang/Exception
    //   749	777	2010	java/lang/Exception
    //   780	788	2010	java/lang/Exception
    //   2044	2059	2062	java/lang/Exception
    //   798	861	2242	java/lang/Exception
    //   861	901	2242	java/lang/Exception
    //   906	958	2242	java/lang/Exception
    //   1076	1081	2242	java/lang/Exception
    //   1094	1099	2242	java/lang/Exception
    //   1149	1154	2242	java/lang/Exception
    //   1159	1164	2242	java/lang/Exception
    //   1172	1189	2242	java/lang/Exception
    //   1192	1200	2242	java/lang/Exception
    //   1207	1271	2242	java/lang/Exception
    //   1274	1365	2242	java/lang/Exception
    //   1368	1450	2242	java/lang/Exception
    //   1456	1492	2242	java/lang/Exception
    //   1502	1539	2242	java/lang/Exception
    //   1558	1578	2242	java/lang/Exception
    //   1583	1598	2242	java/lang/Exception
    //   1606	1612	2242	java/lang/Exception
    //   1612	1627	2242	java/lang/Exception
    //   1627	1649	2242	java/lang/Exception
    //   1654	1664	2242	java/lang/Exception
    //   1667	1673	2242	java/lang/Exception
    //   1681	1744	2242	java/lang/Exception
    //   1747	1757	2242	java/lang/Exception
    //   1757	1810	2242	java/lang/Exception
    //   1815	1854	2242	java/lang/Exception
    //   1854	1859	2242	java/lang/Exception
    //   1877	1882	2242	java/lang/Exception
    //   1887	1892	2242	java/lang/Exception
    //   1892	1895	2242	java/lang/Exception
    //   1895	1941	2242	java/lang/Exception
    //   1949	1972	2242	java/lang/Exception
    //   1980	2003	2242	java/lang/Exception
  }
  
  private boolean a(Context paramContext, File paramFile)
  {
    return a(paramContext, paramFile, false);
  }
  
  /* Error */
  private boolean a(Context paramContext, File paramFile, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 127
    //   2: ldc_w 714
    //   5: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   8: aload_2
    //   9: invokestatic 716	com/tencent/smtt/utils/FileUtil:c	(Ljava/io/File;)Z
    //   12: ifne +34 -> 46
    //   15: aload_1
    //   16: invokestatic 239	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   19: sipush 204
    //   22: ldc_w 718
    //   25: invokevirtual 246	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   28: aload_1
    //   29: invokestatic 179	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   32: astore_1
    //   33: sipush -520
    //   36: istore 4
    //   38: aload_1
    //   39: iload 4
    //   41: invokevirtual 457	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   44: iconst_0
    //   45: ireturn
    //   46: aload_1
    //   47: invokestatic 363	com/tencent/smtt/sdk/QbSdk:getTbsFolderDir	(Landroid/content/Context;)Ljava/io/File;
    //   50: astore 9
    //   52: iload_3
    //   53: ifeq +20 -> 73
    //   56: new 267	java/io/File
    //   59: dup
    //   60: aload 9
    //   62: ldc_w 720
    //   65: invokespecial 368	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   68: astore 9
    //   70: goto +17 -> 87
    //   73: new 267	java/io/File
    //   76: dup
    //   77: aload 9
    //   79: ldc_w 365
    //   82: invokespecial 368	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   85: astore 9
    //   87: aload 9
    //   89: invokevirtual 583	java/io/File:exists	()Z
    //   92: ifeq +59 -> 151
    //   95: aload_1
    //   96: invokestatic 544	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   99: ifne +52 -> 151
    //   102: aload 9
    //   104: invokestatic 721	com/tencent/smtt/utils/FileUtil:b	(Ljava/io/File;)V
    //   107: goto +44 -> 151
    //   110: astore 9
    //   112: new 202	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   119: astore 10
    //   121: aload 10
    //   123: ldc_w 723
    //   126: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: aload 10
    //   132: aload 9
    //   134: invokestatic 679	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   137: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: ldc 127
    //   143: aload 10
    //   145: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokestatic 438	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   151: iload_3
    //   152: ifeq +14 -> 166
    //   155: aload_0
    //   156: aload_1
    //   157: iconst_2
    //   158: invokevirtual 265	com/tencent/smtt/sdk/p:f	(Landroid/content/Context;I)Ljava/io/File;
    //   161: astore 9
    //   163: goto +11 -> 174
    //   166: aload_0
    //   167: aload_1
    //   168: iconst_0
    //   169: invokevirtual 265	com/tencent/smtt/sdk/p:f	(Landroid/content/Context;I)Ljava/io/File;
    //   172: astore 9
    //   174: aload 9
    //   176: ifnonnull +29 -> 205
    //   179: aload_1
    //   180: invokestatic 239	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   183: sipush 205
    //   186: ldc_w 725
    //   189: invokevirtual 246	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   192: aload_1
    //   193: invokestatic 179	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   196: astore_1
    //   197: sipush -521
    //   200: istore 4
    //   202: goto -164 -> 38
    //   205: iconst_1
    //   206: istore 6
    //   208: iconst_1
    //   209: istore 5
    //   211: aload 9
    //   213: invokestatic 727	com/tencent/smtt/utils/FileUtil:a	(Ljava/io/File;)Z
    //   216: pop
    //   217: iload_3
    //   218: ifeq +9 -> 227
    //   221: aload 9
    //   223: iconst_1
    //   224: invokestatic 259	com/tencent/smtt/utils/FileUtil:a	(Ljava/io/File;Z)V
    //   227: aload_2
    //   228: aload 9
    //   230: invokestatic 730	com/tencent/smtt/utils/FileUtil:a	(Ljava/io/File;Ljava/io/File;)Z
    //   233: istore 8
    //   235: iload 8
    //   237: istore 7
    //   239: iload 8
    //   241: ifeq +12 -> 253
    //   244: aload_0
    //   245: aload 9
    //   247: aload_1
    //   248: invokespecial 733	com/tencent/smtt/sdk/p:a	(Ljava/io/File;Landroid/content/Context;)Z
    //   251: istore 7
    //   253: iload_3
    //   254: ifeq +84 -> 338
    //   257: aload 9
    //   259: invokevirtual 737	java/io/File:list	()[Ljava/lang/String;
    //   262: astore_2
    //   263: iconst_0
    //   264: istore 4
    //   266: iload 4
    //   268: aload_2
    //   269: arraylength
    //   270: if_icmpge +47 -> 317
    //   273: new 267	java/io/File
    //   276: dup
    //   277: aload 9
    //   279: aload_2
    //   280: iload 4
    //   282: aaload
    //   283: invokespecial 368	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   286: astore 10
    //   288: aload 10
    //   290: invokevirtual 590	java/io/File:getName	()Ljava/lang/String;
    //   293: ldc_w 592
    //   296: invokevirtual 596	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   299: ifeq +9 -> 308
    //   302: aload 10
    //   304: invokevirtual 353	java/io/File:delete	()Z
    //   307: pop
    //   308: iload 4
    //   310: iconst_1
    //   311: iadd
    //   312: istore 4
    //   314: goto -48 -> 266
    //   317: new 267	java/io/File
    //   320: dup
    //   321: aload_1
    //   322: invokestatic 740	com/tencent/smtt/sdk/p:t	(Landroid/content/Context;)Ljava/io/File;
    //   325: ldc_w 742
    //   328: invokespecial 368	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   331: invokevirtual 353	java/io/File:delete	()Z
    //   334: pop
    //   335: goto +3 -> 338
    //   338: iload 7
    //   340: ifne +56 -> 396
    //   343: aload 9
    //   345: invokestatic 721	com/tencent/smtt/utils/FileUtil:b	(Ljava/io/File;)V
    //   348: aload_1
    //   349: invokestatic 179	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   352: sipush -522
    //   355: invokevirtual 457	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   358: new 202	java/lang/StringBuilder
    //   361: dup
    //   362: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   365: astore_2
    //   366: aload_2
    //   367: ldc_w 744
    //   370: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: pop
    //   374: aload_2
    //   375: aload 9
    //   377: invokevirtual 583	java/io/File:exists	()Z
    //   380: invokevirtual 276	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   383: pop
    //   384: ldc 127
    //   386: aload_2
    //   387: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   390: invokestatic 438	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   393: goto +35 -> 428
    //   396: aload_0
    //   397: aload_1
    //   398: iconst_1
    //   399: invokespecial 312	com/tencent/smtt/sdk/p:g	(Landroid/content/Context;Z)V
    //   402: iload_3
    //   403: ifeq +25 -> 428
    //   406: aload_0
    //   407: aload_1
    //   408: invokevirtual 553	com/tencent/smtt/sdk/p:q	(Landroid/content/Context;)Ljava/io/File;
    //   411: astore_2
    //   412: aload_2
    //   413: iconst_1
    //   414: invokestatic 259	com/tencent/smtt/utils/FileUtil:a	(Ljava/io/File;Z)V
    //   417: aload 9
    //   419: aload_2
    //   420: invokevirtual 271	java/io/File:renameTo	(Ljava/io/File;)Z
    //   423: pop
    //   424: aload_1
    //   425: invokestatic 568	com/tencent/smtt/sdk/TbsShareManager:b	(Landroid/content/Context;)V
    //   428: ldc 127
    //   430: ldc_w 746
    //   433: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   436: ldc_w 748
    //   439: invokestatic 283	com/tencent/smtt/utils/q:a	(Ljava/lang/String;)V
    //   442: iload 7
    //   444: ireturn
    //   445: astore_1
    //   446: goto +266 -> 712
    //   449: astore_2
    //   450: aload_1
    //   451: invokestatic 179	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   454: sipush -523
    //   457: invokevirtual 457	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   460: aload_1
    //   461: invokestatic 239	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   464: sipush 207
    //   467: aload_2
    //   468: invokevirtual 751	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/Throwable;)V
    //   471: aload 9
    //   473: ifnull +20 -> 493
    //   476: aload 9
    //   478: invokevirtual 583	java/io/File:exists	()Z
    //   481: istore_3
    //   482: iload_3
    //   483: ifeq +10 -> 493
    //   486: iload 5
    //   488: istore 4
    //   490: goto +6 -> 496
    //   493: iconst_0
    //   494: istore 4
    //   496: iload 4
    //   498: ifeq +86 -> 584
    //   501: aload 9
    //   503: ifnull +81 -> 584
    //   506: aload 9
    //   508: invokestatic 721	com/tencent/smtt/utils/FileUtil:b	(Ljava/io/File;)V
    //   511: new 202	java/lang/StringBuilder
    //   514: dup
    //   515: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   518: astore_1
    //   519: aload_1
    //   520: ldc_w 753
    //   523: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   526: pop
    //   527: aload_1
    //   528: aload 9
    //   530: invokevirtual 583	java/io/File:exists	()Z
    //   533: invokevirtual 276	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   536: pop
    //   537: ldc 127
    //   539: aload_1
    //   540: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   543: invokestatic 438	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   546: goto +38 -> 584
    //   549: astore_1
    //   550: new 202	java/lang/StringBuilder
    //   553: dup
    //   554: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   557: astore_2
    //   558: aload_2
    //   559: ldc_w 755
    //   562: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   565: pop
    //   566: aload_2
    //   567: aload_1
    //   568: invokestatic 679	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   571: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   574: pop
    //   575: ldc 127
    //   577: aload_2
    //   578: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   581: invokestatic 438	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   584: ldc 127
    //   586: ldc_w 746
    //   589: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   592: ldc_w 748
    //   595: invokestatic 283	com/tencent/smtt/utils/q:a	(Ljava/lang/String;)V
    //   598: iconst_0
    //   599: ireturn
    //   600: astore_2
    //   601: aload_1
    //   602: invokestatic 179	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   605: sipush -523
    //   608: invokevirtual 457	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   611: aload_1
    //   612: invokestatic 239	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   615: sipush 206
    //   618: aload_2
    //   619: invokevirtual 751	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/Throwable;)V
    //   622: aload 9
    //   624: ifnull +20 -> 644
    //   627: aload 9
    //   629: invokevirtual 583	java/io/File:exists	()Z
    //   632: istore_3
    //   633: iload_3
    //   634: ifeq +10 -> 644
    //   637: iload 6
    //   639: istore 4
    //   641: goto +6 -> 647
    //   644: iconst_0
    //   645: istore 4
    //   647: iload 4
    //   649: ifeq -65 -> 584
    //   652: aload 9
    //   654: ifnull -70 -> 584
    //   657: aload 9
    //   659: invokestatic 721	com/tencent/smtt/utils/FileUtil:b	(Ljava/io/File;)V
    //   662: new 202	java/lang/StringBuilder
    //   665: dup
    //   666: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   669: astore_1
    //   670: aload_1
    //   671: ldc_w 753
    //   674: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   677: pop
    //   678: aload_1
    //   679: aload 9
    //   681: invokevirtual 583	java/io/File:exists	()Z
    //   684: invokevirtual 276	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   687: pop
    //   688: ldc 127
    //   690: aload_1
    //   691: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   694: invokestatic 438	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   697: goto -113 -> 584
    //   700: astore_1
    //   701: new 202	java/lang/StringBuilder
    //   704: dup
    //   705: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   708: astore_2
    //   709: goto -151 -> 558
    //   712: ldc 127
    //   714: ldc_w 746
    //   717: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   720: ldc_w 748
    //   723: invokestatic 283	com/tencent/smtt/utils/q:a	(Ljava/lang/String;)V
    //   726: goto +5 -> 731
    //   729: aload_1
    //   730: athrow
    //   731: goto -2 -> 729
    //   734: astore_2
    //   735: goto -397 -> 338
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	738	0	this	p
    //   0	738	1	paramContext	Context
    //   0	738	2	paramFile	File
    //   0	738	3	paramBoolean	boolean
    //   36	612	4	i1	int
    //   209	278	5	i2	int
    //   206	432	6	i3	int
    //   237	206	7	bool1	boolean
    //   233	7	8	bool2	boolean
    //   50	53	9	localFile1	File
    //   110	23	9	localThrowable	Throwable
    //   161	519	9	localFile2	File
    //   119	184	10	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   46	52	110	java/lang/Throwable
    //   56	70	110	java/lang/Throwable
    //   73	87	110	java/lang/Throwable
    //   87	107	110	java/lang/Throwable
    //   211	217	445	finally
    //   221	227	445	finally
    //   227	235	445	finally
    //   244	253	445	finally
    //   257	263	445	finally
    //   266	308	445	finally
    //   317	335	445	finally
    //   343	393	445	finally
    //   396	402	445	finally
    //   406	428	445	finally
    //   450	471	445	finally
    //   476	482	445	finally
    //   601	622	445	finally
    //   627	633	445	finally
    //   211	217	449	java/lang/Exception
    //   221	227	449	java/lang/Exception
    //   227	235	449	java/lang/Exception
    //   244	253	449	java/lang/Exception
    //   257	263	449	java/lang/Exception
    //   266	308	449	java/lang/Exception
    //   343	393	449	java/lang/Exception
    //   396	402	449	java/lang/Exception
    //   406	428	449	java/lang/Exception
    //   506	546	549	java/lang/Throwable
    //   211	217	600	java/io/IOException
    //   221	227	600	java/io/IOException
    //   227	235	600	java/io/IOException
    //   244	253	600	java/io/IOException
    //   257	263	600	java/io/IOException
    //   266	308	600	java/io/IOException
    //   317	335	600	java/io/IOException
    //   343	393	600	java/io/IOException
    //   396	402	600	java/io/IOException
    //   406	428	600	java/io/IOException
    //   657	697	700	java/lang/Throwable
    //   317	335	734	java/lang/Exception
  }
  
  static boolean a(Context paramContext, String paramString)
  {
    paramContext = new File(QbSdk.getTbsFolderDir(paramContext), paramString);
    if (!paramContext.exists()) {}
    for (paramContext = "TbsInstaller-isPrepareTbsCore, #1";; paramContext = "TbsInstaller-isPrepareTbsCore, #2")
    {
      TbsLog.i("TbsInstaller", paramContext);
      return false;
      if (new File(paramContext, "tbs.conf").exists()) {
        break;
      }
    }
    TbsLog.i("TbsInstaller", "TbsInstaller-isPrepareTbsCore, #3");
    return true;
  }
  
  /* Error */
  private boolean a(File paramFile, Context paramContext)
  {
    // Byte code:
    //   0: new 202	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   7: astore 6
    //   9: aload 6
    //   11: ldc_w 763
    //   14: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: pop
    //   18: aload 6
    //   20: aload_1
    //   21: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   24: pop
    //   25: aload 6
    //   27: ldc_w 765
    //   30: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload 6
    //   36: aload_2
    //   37: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: ldc 127
    //   43: aload 6
    //   45: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   51: aconst_null
    //   52: astore 7
    //   54: aconst_null
    //   55: astore 9
    //   57: aconst_null
    //   58: astore 6
    //   60: aload 7
    //   62: astore_2
    //   63: new 267	java/io/File
    //   66: dup
    //   67: aload_1
    //   68: ldc_w 580
    //   71: invokespecial 368	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   74: astore 10
    //   76: aload 7
    //   78: astore_2
    //   79: new 375	java/util/Properties
    //   82: dup
    //   83: invokespecial 376	java/util/Properties:<init>	()V
    //   86: astore 8
    //   88: aload 7
    //   90: astore_2
    //   91: aload 10
    //   93: invokevirtual 583	java/io/File:exists	()Z
    //   96: ifeq +62 -> 158
    //   99: aload 7
    //   101: astore_2
    //   102: new 378	java/io/BufferedInputStream
    //   105: dup
    //   106: new 380	java/io/FileInputStream
    //   109: dup
    //   110: aload 10
    //   112: invokespecial 383	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   115: invokespecial 386	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   118: astore 6
    //   120: aload 8
    //   122: aload 6
    //   124: invokevirtual 389	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   127: aload 6
    //   129: astore_2
    //   130: iconst_1
    //   131: istore 4
    //   133: goto +31 -> 164
    //   136: astore_1
    //   137: aload 6
    //   139: astore_2
    //   140: goto +479 -> 619
    //   143: astore 7
    //   145: aload 6
    //   147: astore_2
    //   148: aload 8
    //   150: astore 6
    //   152: aload_2
    //   153: astore 8
    //   155: goto +78 -> 233
    //   158: iconst_0
    //   159: istore 4
    //   161: aload 6
    //   163: astore_2
    //   164: iload 4
    //   166: istore 5
    //   168: aload 8
    //   170: astore 6
    //   172: aload_2
    //   173: ifnull +89 -> 262
    //   176: aload_2
    //   177: invokevirtual 416	java/io/BufferedInputStream:close	()V
    //   180: iload 4
    //   182: istore 5
    //   184: aload 8
    //   186: astore 6
    //   188: goto +74 -> 262
    //   191: astore_2
    //   192: aload_2
    //   193: invokevirtual 415	java/io/IOException:printStackTrace	()V
    //   196: iload 4
    //   198: istore 5
    //   200: aload 8
    //   202: astore 6
    //   204: goto +58 -> 262
    //   207: astore 7
    //   209: aload 8
    //   211: astore 6
    //   213: aload 9
    //   215: astore 8
    //   217: goto +16 -> 233
    //   220: astore_1
    //   221: goto +398 -> 619
    //   224: astore 7
    //   226: aconst_null
    //   227: astore 6
    //   229: aload 9
    //   231: astore 8
    //   233: aload 8
    //   235: astore_2
    //   236: aload 7
    //   238: invokevirtual 234	java/lang/Exception:printStackTrace	()V
    //   241: aload 8
    //   243: ifnull +16 -> 259
    //   246: aload 8
    //   248: invokevirtual 416	java/io/BufferedInputStream:close	()V
    //   251: goto +8 -> 259
    //   254: astore_2
    //   255: aload_2
    //   256: invokevirtual 415	java/io/IOException:printStackTrace	()V
    //   259: iconst_1
    //   260: istore 5
    //   262: new 202	java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   269: astore_2
    //   270: aload_2
    //   271: ldc_w 767
    //   274: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: pop
    //   278: aload_2
    //   279: iload 5
    //   281: invokevirtual 276	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   284: pop
    //   285: ldc 127
    //   287: aload_2
    //   288: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   291: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   294: iload 5
    //   296: ifeq +258 -> 554
    //   299: aload_1
    //   300: invokevirtual 587	java/io/File:listFiles	()[Ljava/io/File;
    //   303: astore_2
    //   304: iconst_0
    //   305: istore_3
    //   306: iload_3
    //   307: aload_2
    //   308: arraylength
    //   309: if_icmpge +245 -> 554
    //   312: aload_2
    //   313: iload_3
    //   314: aaload
    //   315: astore_1
    //   316: ldc_w 580
    //   319: aload_1
    //   320: invokevirtual 590	java/io/File:getName	()Ljava/lang/String;
    //   323: invokevirtual 307	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   326: ifne +221 -> 547
    //   329: aload_1
    //   330: invokevirtual 590	java/io/File:getName	()Ljava/lang/String;
    //   333: ldc_w 592
    //   336: invokevirtual 596	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   339: ifne +208 -> 547
    //   342: ldc_w 373
    //   345: aload_1
    //   346: invokevirtual 590	java/io/File:getName	()Ljava/lang/String;
    //   349: invokevirtual 307	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   352: ifne +195 -> 547
    //   355: aload_1
    //   356: invokevirtual 599	java/io/File:isDirectory	()Z
    //   359: ifne +188 -> 547
    //   362: aload_1
    //   363: invokevirtual 590	java/io/File:getName	()Ljava/lang/String;
    //   366: ldc_w 601
    //   369: invokevirtual 596	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   372: ifeq +6 -> 378
    //   375: goto +172 -> 547
    //   378: aload_1
    //   379: invokestatic 606	com/tencent/smtt/utils/a:a	(Ljava/io/File;)Ljava/lang/String;
    //   382: astore 7
    //   384: aload 6
    //   386: aload_1
    //   387: invokevirtual 590	java/io/File:getName	()Ljava/lang/String;
    //   390: ldc_w 608
    //   393: invokevirtual 612	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   396: astore 8
    //   398: aload 8
    //   400: ldc_w 608
    //   403: invokevirtual 307	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   406: ifne +63 -> 469
    //   409: aload 8
    //   411: aload 7
    //   413: invokevirtual 307	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   416: ifeq +53 -> 469
    //   419: new 202	java/lang/StringBuilder
    //   422: dup
    //   423: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   426: astore 7
    //   428: aload 7
    //   430: ldc_w 614
    //   433: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: pop
    //   437: aload 7
    //   439: aload_1
    //   440: invokevirtual 590	java/io/File:getName	()Ljava/lang/String;
    //   443: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: pop
    //   447: aload 7
    //   449: ldc_w 616
    //   452: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: pop
    //   456: ldc 127
    //   458: aload 7
    //   460: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   463: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   466: goto +81 -> 547
    //   469: new 202	java/lang/StringBuilder
    //   472: dup
    //   473: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   476: astore_2
    //   477: aload_2
    //   478: ldc_w 618
    //   481: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: pop
    //   485: aload_2
    //   486: aload_1
    //   487: invokevirtual 590	java/io/File:getName	()Ljava/lang/String;
    //   490: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: pop
    //   494: aload_2
    //   495: ldc_w 616
    //   498: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: pop
    //   502: aload_2
    //   503: ldc_w 620
    //   506: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: pop
    //   510: aload_2
    //   511: aload 8
    //   513: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: pop
    //   517: aload_2
    //   518: ldc_w 622
    //   521: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   524: pop
    //   525: aload_2
    //   526: aload 7
    //   528: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   531: pop
    //   532: ldc 127
    //   534: aload_2
    //   535: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   538: invokestatic 438	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   541: iconst_0
    //   542: istore 4
    //   544: goto +13 -> 557
    //   547: iload_3
    //   548: iconst_1
    //   549: iadd
    //   550: istore_3
    //   551: goto -245 -> 306
    //   554: iconst_1
    //   555: istore 4
    //   557: new 202	java/lang/StringBuilder
    //   560: dup
    //   561: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   564: astore_1
    //   565: aload_1
    //   566: ldc_w 769
    //   569: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   572: pop
    //   573: aload_1
    //   574: iload 4
    //   576: invokevirtual 276	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   579: pop
    //   580: ldc 127
    //   582: aload_1
    //   583: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   586: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   589: iload 5
    //   591: ifeq +18 -> 609
    //   594: iload 4
    //   596: ifne +13 -> 609
    //   599: ldc 127
    //   601: ldc_w 771
    //   604: invokestatic 438	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   607: iconst_0
    //   608: ireturn
    //   609: ldc 127
    //   611: ldc_w 773
    //   614: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   617: iconst_1
    //   618: ireturn
    //   619: aload_2
    //   620: ifnull +15 -> 635
    //   623: aload_2
    //   624: invokevirtual 416	java/io/BufferedInputStream:close	()V
    //   627: goto +8 -> 635
    //   630: astore_2
    //   631: aload_2
    //   632: invokevirtual 415	java/io/IOException:printStackTrace	()V
    //   635: goto +5 -> 640
    //   638: aload_1
    //   639: athrow
    //   640: goto -2 -> 638
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	643	0	this	p
    //   0	643	1	paramFile	File
    //   0	643	2	paramContext	Context
    //   305	246	3	i1	int
    //   131	464	4	bool1	boolean
    //   166	424	5	bool2	boolean
    //   7	378	6	localObject1	Object
    //   52	48	7	localObject2	Object
    //   143	1	7	localException1	Exception
    //   207	1	7	localException2	Exception
    //   224	13	7	localException3	Exception
    //   382	145	7	localObject3	Object
    //   86	426	8	localObject4	Object
    //   55	175	9	localObject5	Object
    //   74	37	10	localFile	File
    // Exception table:
    //   from	to	target	type
    //   120	127	136	finally
    //   120	127	143	java/lang/Exception
    //   176	180	191	java/io/IOException
    //   91	99	207	java/lang/Exception
    //   102	120	207	java/lang/Exception
    //   63	76	220	finally
    //   79	88	220	finally
    //   91	99	220	finally
    //   102	120	220	finally
    //   236	241	220	finally
    //   63	76	224	java/lang/Exception
    //   79	88	224	java/lang/Exception
    //   246	251	254	java/io/IOException
    //   623	627	630	java/io/IOException
  }
  
  @TargetApi(11)
  private void b(Context paramContext, String paramString, int paramInt)
  {
    TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(-501);
    boolean bool = d(paramContext);
    Boolean localBoolean = Boolean.valueOf(true);
    if (bool)
    {
      TbsLog.i("TbsInstaller", "isTbsLocalInstalled --> no installation!", true);
      TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(-502);
      QbSdk.m.onInstallFinish(-502);
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("TbsInstaller-installTbsCoreInThread tbsApkPath=");
    ((StringBuilder)localObject1).append(paramString);
    TbsLog.i("TbsInstaller", ((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("TbsInstaller-installTbsCoreInThread tbsCoreTargetVer=");
    ((StringBuilder)localObject1).append(paramInt);
    TbsLog.i("TbsInstaller", ((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("TbsInstaller-continueInstallTbsCore currentProcessName=");
    ((StringBuilder)localObject1).append(paramContext.getApplicationInfo().processName);
    TbsLog.i("TbsInstaller", ((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("TbsInstaller-installTbsCoreInThread currentProcessId=");
    ((StringBuilder)localObject1).append(android.os.Process.myPid());
    TbsLog.i("TbsInstaller", ((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("TbsInstaller-installTbsCoreInThread currentThreadName=");
    ((StringBuilder)localObject1).append(Thread.currentThread().getName());
    TbsLog.i("TbsInstaller", ((StringBuilder)localObject1).toString());
    if (Build.VERSION.SDK_INT >= 11) {
      localObject1 = paramContext.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4);
    } else {
      localObject1 = paramContext.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0);
    }
    if (((SharedPreferences)localObject1).getInt("tbs_precheck_disable_version", -1) == paramInt)
    {
      paramString = new StringBuilder();
      paramString.append("TbsInstaller-installTbsCoreInThread -- version:");
      paramString.append(paramInt);
      paramString.append(" is disabled by preload_x5_check!");
      TbsLog.e("TbsInstaller", paramString.toString());
      TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(-503);
      QbSdk.m.onInstallFinish(-503);
      return;
    }
    if (!FileUtil.b(paramContext))
    {
      long l1 = q.a();
      long l2 = TbsDownloadConfig.getInstance(paramContext).getDownloadMinFreeSpace();
      TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(-504);
      paramString = new StringBuilder();
      paramString.append("rom is not enough when installing tbs core! curAvailROM=");
      paramString.append(l1);
      paramString.append(",minReqRom=");
      paramString.append(l2);
      paramString = paramString.toString();
      TbsLogReport.getInstance(paramContext).setInstallErrorCode(210, paramString);
      TbsLog.i("TbsInstaller", paramString);
      QbSdk.m.onInstallFinish(210);
      return;
    }
    if (!u(paramContext))
    {
      TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(-505);
      TbsLog.i("TbsInstaller", "getInstalling file lock failed,return!");
      QbSdk.m.onInstallFinish(-505);
      return;
    }
    bool = j.tryLock();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("TbsInstaller-installTbsCoreInThread locked =");
    ((StringBuilder)localObject1).append(bool);
    TbsLog.i("TbsInstaller", ((StringBuilder)localObject1).toString());
    if (bool)
    {
      TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(-507);
      i.lock();
    }
    for (;;)
    {
      int i1;
      int i2;
      int i3;
      try
      {
        i1 = m.a(paramContext).c("copy_core_ver");
        i2 = m.a(paramContext).b();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("TbsInstaller-installTbsCoreInThread tbsCoreCopyVer =");
        ((StringBuilder)localObject1).append(i1);
        TbsLog.i("TbsInstaller", ((StringBuilder)localObject1).toString());
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("TbsInstaller-installTbsCoreInThread tbsCoreInstallVer =");
        ((StringBuilder)localObject1).append(i2);
        TbsLog.i("TbsInstaller", ((StringBuilder)localObject1).toString());
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("TbsInstaller-installTbsCoreInThread tbsCoreTargetVer =");
        ((StringBuilder)localObject1).append(paramInt);
        TbsLog.i("TbsInstaller", ((StringBuilder)localObject1).toString());
        if ((i2 <= 0) || (paramInt <= i2)) {
          break label2562;
        }
        p(paramContext);
        i2 = m.a(paramContext).c();
        i3 = j(paramContext);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("TbsInstaller-installTbsCoreInThread installStatus1=");
        ((StringBuilder)localObject1).append(i2);
        TbsLog.i("TbsInstaller", ((StringBuilder)localObject1).toString());
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("TbsInstaller-installTbsCoreInThread tbsCoreInstalledVer=");
        ((StringBuilder)localObject1).append(i3);
        TbsLog.i("TbsInstaller", ((StringBuilder)localObject1).toString());
        if ((i2 < 0) || (i2 >= 2)) {
          break label2576;
        }
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread -- retry.....", true);
        i3 = 1;
        i1 = i2;
        i2 = i3;
        continue;
        p(paramContext);
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread -- update TBS.....", true);
        i1 = -1;
        break label2615;
        TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(-508);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("TbsInstaller-installTbsCoreInThread installStatus2=");
        ((StringBuilder)localObject1).append(i1);
        TbsLog.i("TbsInstaller", ((StringBuilder)localObject1).toString());
        Object localObject3;
        if (i1 < 1)
        {
          TbsLog.i("TbsInstaller", "STEP 2/2 begin installation.....", true);
          TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(-509);
          if (i2 != 0)
          {
            i3 = m.a(paramContext).c("unzip_retry_num");
            if (i3 > 10)
            {
              TbsLogReport.getInstance(paramContext).setInstallErrorCode(201, "exceed unzip retry num!");
              F(paramContext);
              TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(-510);
              try
              {
                i.unlock();
                j.unlock();
              }
              catch (Exception paramContext)
              {
                paramContext.printStackTrace();
              }
              try
              {
                b();
                return;
              }
              catch (Exception paramContext)
              {
                paramContext.printStackTrace();
                return;
              }
            }
            m.a(paramContext).b(i3 + 1);
          }
          if (paramString == null)
          {
            localObject3 = m.a(paramContext).d("install_apk_path");
            localObject1 = localObject3;
            if (localObject3 != null) {
              continue;
            }
            TbsLogReport.getInstance(paramContext).setInstallErrorCode(202, "apk path is null!");
            TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(-511);
            try
            {
              i.unlock();
              j.unlock();
            }
            catch (Exception paramContext)
            {
              paramContext.printStackTrace();
            }
            try
            {
              b();
              return;
            }
            catch (Exception paramContext)
            {
              paramContext.printStackTrace();
              return;
            }
          }
          localObject1 = paramString;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("TbsInstaller-installTbsCoreInThread apkPath =");
          ((StringBuilder)localObject3).append((String)localObject1);
          TbsLog.i("TbsInstaller", ((StringBuilder)localObject3).toString());
          int i4 = c(paramContext, (String)localObject1);
          if (i4 == 0)
          {
            TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(-512);
            TbsLogReport.getInstance(paramContext).setInstallErrorCode(203, "apk version is 0!");
            try
            {
              i.unlock();
              j.unlock();
            }
            catch (Exception paramContext)
            {
              paramContext.printStackTrace();
            }
            try
            {
              b();
              return;
            }
            catch (Exception paramContext)
            {
              paramContext.printStackTrace();
              return;
            }
          }
          m.a(paramContext).a("install_apk_path", (String)localObject1);
          m.a(paramContext).c(i4, 0);
          TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(-548);
          if (TbsDownloader.a(paramContext))
          {
            if (a(paramContext, new File((String)localObject1), true)) {
              continue;
            }
            TbsLogReport.getInstance(paramContext).setInstallErrorCode(207, "unzipTbsApk failed", TbsLogReport.EventType.TYPE_INSTALL_DECOUPLE);
            try
            {
              i.unlock();
              j.unlock();
            }
            catch (Exception paramContext)
            {
              paramContext.printStackTrace();
            }
            try
            {
              b();
              return;
            }
            catch (Exception paramContext)
            {
              paramContext.printStackTrace();
              return;
            }
          }
          if (!a(paramContext, new File((String)localObject1)))
          {
            TbsLogReport.getInstance(paramContext).setInstallErrorCode(207, "unzipTbsApk failed");
            try
            {
              i.unlock();
              j.unlock();
            }
            catch (Exception paramContext)
            {
              paramContext.printStackTrace();
            }
            try
            {
              b();
              return;
            }
            catch (Exception paramContext)
            {
              paramContext.printStackTrace();
              return;
            }
          }
          if (i2 != 0)
          {
            i3 = m.a(paramContext).b("unlzma_status");
            if (i3 > 5)
            {
              TbsLogReport.getInstance(paramContext).setInstallErrorCode(223, "exceed unlzma retry num!");
              TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(-553);
              F(paramContext);
              l.c(paramContext);
              TbsDownloadConfig.getInstance(paramContext).mSyncMap.put("tbs_needdownload", localBoolean);
              TbsDownloadConfig.getInstance(paramContext).mSyncMap.put("request_full_package", localBoolean);
              TbsDownloadConfig.getInstance(paramContext).commit();
              try
              {
                i.unlock();
                j.unlock();
              }
              catch (Exception paramContext)
              {
                paramContext.printStackTrace();
              }
              try
              {
                b();
                return;
              }
              catch (Exception paramContext)
              {
                paramContext.printStackTrace();
                return;
              }
            }
            m.a(paramContext).d(i3 + 1);
          }
          TbsLog.i("TbsInstaller", "unlzma begin");
          i3 = TbsDownloadConfig.getInstance().mPreferences.getInt("tbs_responsecode", 0);
          if (j(paramContext) != 0)
          {
            localObject1 = QbSdk.a(paramContext, "can_unlzma", null);
            if ((localObject1 == null) || (!(localObject1 instanceof Boolean))) {
              break label2621;
            }
            bool = ((Boolean)localObject1).booleanValue();
            if (bool)
            {
              localObject3 = new Bundle();
              ((Bundle)localObject3).putInt("responseCode", i3);
              if (TbsDownloader.a(paramContext))
              {
                localObject1 = q(paramContext).getAbsolutePath();
                ((Bundle)localObject3).putString("unzip_temp_path", (String)localObject1);
              }
              else
              {
                localObject1 = f(paramContext, 0).getAbsolutePath();
                continue;
              }
              localObject1 = QbSdk.a(paramContext, "unlzma", (Bundle)localObject3);
              if (localObject1 == null)
              {
                TbsLog.i("TbsInstaller", "unlzma return null");
                localObject1 = TbsLogReport.getInstance(paramContext);
                localObject3 = "unlzma is null";
                ((TbsLogReport)localObject1).setInstallErrorCode(222, (String)localObject3);
              }
              else
              {
                if ((localObject1 instanceof Boolean))
                {
                  if (((Boolean)localObject1).booleanValue())
                  {
                    TbsLog.i("TbsInstaller", "unlzma success");
                    break label2627;
                  }
                  TbsLog.i("TbsInstaller", "unlzma return false");
                  localObject1 = TbsLogReport.getInstance(paramContext);
                  localObject3 = "unlzma return false";
                  continue;
                }
                if ((localObject1 instanceof Bundle)) {
                  break label2627;
                }
                if ((localObject1 instanceof Throwable))
                {
                  localObject3 = new StringBuilder();
                  ((StringBuilder)localObject3).append("unlzma failure because Throwable");
                  ((StringBuilder)localObject3).append(Log.getStackTraceString((Throwable)localObject1));
                  TbsLog.i("TbsInstaller", ((StringBuilder)localObject3).toString());
                  TbsLogReport.getInstance(paramContext).setInstallErrorCode(222, (Throwable)localObject1);
                }
              }
              i3 = 0;
              if (i3 == 0)
              {
                try
                {
                  i.unlock();
                  j.unlock();
                }
                catch (Exception paramContext)
                {
                  paramContext.printStackTrace();
                }
                try
                {
                  b();
                  return;
                }
                catch (Exception paramContext)
                {
                  paramContext.printStackTrace();
                  return;
                }
              }
            }
          }
          TbsLog.i("TbsInstaller", "unlzma finished");
          m.a(paramContext).c(i4, 1);
          i3 = i4;
        }
        else
        {
          if (!TbsDownloader.a(paramContext)) {
            break label2633;
          }
          if (paramString == null)
          {
            localObject3 = m.a(paramContext).d("install_apk_path");
            localObject1 = localObject3;
            if (localObject3 != null) {
              continue;
            }
            TbsLogReport.getInstance(paramContext).setInstallErrorCode(202, "apk path is null!");
            TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(-511);
            try
            {
              i.unlock();
              j.unlock();
            }
            catch (Exception paramContext)
            {
              paramContext.printStackTrace();
            }
            try
            {
              b();
              return;
            }
            catch (Exception paramContext)
            {
              paramContext.printStackTrace();
              return;
            }
          }
          localObject1 = paramString;
          a(paramContext, new File((String)localObject1), true);
          break label2633;
        }
        if (i1 < 2)
        {
          if (i2 != 0)
          {
            i1 = m.a(paramContext).c("dexopt_retry_num");
            if (i1 > 10)
            {
              TbsLogReport.getInstance(paramContext).setInstallErrorCode(208, "exceed dexopt retry num!");
              TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(-514);
              F(paramContext);
              try
              {
                i.unlock();
                j.unlock();
              }
              catch (Exception paramContext)
              {
                paramContext.printStackTrace();
              }
              try
              {
                b();
                return;
              }
              catch (Exception paramContext)
              {
                paramContext.printStackTrace();
                return;
              }
            }
            m.a(paramContext).a(i1 + 1);
          }
          TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(-549);
          if (!j(paramContext, 0))
          {
            TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(-515);
            try
            {
              i.unlock();
              j.unlock();
            }
            catch (Exception paramContext)
            {
              paramContext.printStackTrace();
            }
            try
            {
              b();
              return;
            }
            catch (Exception paramContext)
            {
              paramContext.printStackTrace();
              return;
            }
          }
          m.a(paramContext).c(i3, 2);
          TbsLog.i("TbsInstaller", "STEP 2/2 installation completed! you can restart!", true);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("STEP 2/2 installation completed! you can restart! version:");
          ((StringBuilder)localObject1).append(paramInt);
          TbsLog.i("TbsInstaller", ((StringBuilder)localObject1).toString());
          TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(-516);
          if (Build.VERSION.SDK_INT >= 11) {
            localObject1 = paramContext.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4);
          } else {
            localObject1 = paramContext.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0);
          }
          try
          {
            localObject1 = ((SharedPreferences)localObject1).edit();
            ((SharedPreferences.Editor)localObject1).putInt("tbs_preload_x5_counter", 0);
            ((SharedPreferences.Editor)localObject1).putInt("tbs_preload_x5_recorder", 0);
            ((SharedPreferences.Editor)localObject1).putInt("tbs_preload_x5_version", paramInt);
            ((SharedPreferences.Editor)localObject1).commit();
            TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(-517);
          }
          catch (Throwable localThrowable)
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("Init tbs_preload_x5_counter#1 exception:");
            ((StringBuilder)localObject3).append(Log.getStackTraceString(localThrowable));
            TbsLog.e("TbsInstaller", ((StringBuilder)localObject3).toString());
            TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(-518);
            continue;
          }
          if (paramInt == 88888888) {
            a(paramInt, paramString, paramContext);
          }
          Object localObject2;
          if (this.k)
          {
            localObject2 = TbsLogReport.getInstance(paramContext);
            paramInt = v(paramContext);
            paramString = "continueInstallWithout core success";
            paramContext = (Context)localObject2;
            paramContext.setInstallErrorCode(paramInt, paramString);
          }
          else
          {
            paramString = TbsLogReport.getInstance(paramContext);
            paramInt = v(paramContext);
            localObject2 = "success";
            paramContext = paramString;
            paramString = (String)localObject2;
            continue;
          }
        }
        else if (i1 == 2)
        {
          QbSdk.m.onInstallFinish(200);
        }
        try
        {
          i.unlock();
          j.unlock();
        }
        catch (Exception paramContext)
        {
          paramContext.printStackTrace();
        }
        try
        {
          b();
          return;
        }
        catch (Exception paramContext)
        {
          paramContext.printStackTrace();
          return;
        }
        TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(-519);
      }
      finally
      {
        try
        {
          i.unlock();
          j.unlock();
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
        }
        try
        {
          b();
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
        }
      }
      b();
      return;
      label2562:
      if ((i1 > 0) && (paramInt > i1))
      {
        continue;
        label2576:
        i1 = i2;
        if (i2 == 3)
        {
          i1 = i2;
          if (i3 >= 0)
          {
            if (paramInt > i3) {
              continue;
            }
            i1 = i2;
            if (paramInt == 88888888) {
              continue;
            }
          }
        }
        label2615:
        i2 = 0;
        continue;
        label2621:
        bool = false;
        continue;
        label2627:
        i3 = 1;
        continue;
        label2633:
        i3 = 0;
      }
    }
  }
  
  /* Error */
  private boolean b(Context paramContext, File paramFile)
  {
    // Byte code:
    //   0: aload_2
    //   1: new 960	com/tencent/smtt/sdk/p$6
    //   4: dup
    //   5: aload_0
    //   6: invokespecial 963	com/tencent/smtt/sdk/p$6:<init>	(Lcom/tencent/smtt/sdk/p;)V
    //   9: invokevirtual 966	java/io/File:listFiles	(Ljava/io/FileFilter;)[Ljava/io/File;
    //   12: astore 6
    //   14: aload 6
    //   16: arraylength
    //   17: istore 4
    //   19: getstatic 466	android/os/Build$VERSION:SDK_INT	I
    //   22: bipush 16
    //   24: if_icmpge +33 -> 57
    //   27: aload_1
    //   28: invokevirtual 969	android/content/Context:getPackageName	()Ljava/lang/String;
    //   31: ifnull +26 -> 57
    //   34: aload_1
    //   35: invokevirtual 969	android/content/Context:getPackageName	()Ljava/lang/String;
    //   38: ldc_w 971
    //   41: invokevirtual 974	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   44: istore 5
    //   46: iload 5
    //   48: ifeq +9 -> 57
    //   51: ldc2_w 975
    //   54: invokestatic 980	java/lang/Thread:sleep	(J)V
    //   57: aload_1
    //   58: invokevirtual 984	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   61: astore 7
    //   63: iconst_0
    //   64: istore_3
    //   65: iload_3
    //   66: iload 4
    //   68: if_icmpge +73 -> 141
    //   71: new 202	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   78: astore 8
    //   80: aload 8
    //   82: ldc_w 986
    //   85: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: aload 8
    //   91: aload 6
    //   93: iload_3
    //   94: aaload
    //   95: invokevirtual 919	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   98: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: ldc 127
    //   104: aload 8
    //   106: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   112: new 988	dalvik/system/DexClassLoader
    //   115: dup
    //   116: aload 6
    //   118: iload_3
    //   119: aaload
    //   120: invokevirtual 919	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   123: aload_2
    //   124: invokevirtual 919	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   127: aconst_null
    //   128: aload 7
    //   130: invokespecial 991	dalvik/system/DexClassLoader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   133: pop
    //   134: iload_3
    //   135: iconst_1
    //   136: iadd
    //   137: istore_3
    //   138: goto -73 -> 65
    //   141: iconst_1
    //   142: ireturn
    //   143: astore_2
    //   144: aload_2
    //   145: invokevirtual 234	java/lang/Exception:printStackTrace	()V
    //   148: aload_1
    //   149: invokestatic 239	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   152: sipush 209
    //   155: aload_2
    //   156: invokevirtual 242	java/lang/Exception:toString	()Ljava/lang/String;
    //   159: invokevirtual 246	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   162: ldc 127
    //   164: ldc_w 993
    //   167: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   170: iconst_0
    //   171: ireturn
    //   172: astore 7
    //   174: goto -117 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	this	p
    //   0	177	1	paramContext	Context
    //   0	177	2	paramFile	File
    //   64	74	3	i1	int
    //   17	52	4	i2	int
    //   44	3	5	bool	boolean
    //   12	105	6	arrayOfFile	File[]
    //   61	68	7	localClassLoader	ClassLoader
    //   172	1	7	localException	Exception
    //   78	27	8	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   0	46	143	java/lang/Exception
    //   57	63	143	java/lang/Exception
    //   71	134	143	java/lang/Exception
    //   51	57	172	java/lang/Exception
  }
  
  private int c(Context paramContext, Bundle paramBundle)
  {
    try
    {
      localObject = QbSdk.a(paramContext, paramBundle);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("tpatch finished,ret is");
      localStringBuilder.append(localObject);
      TbsLog.i("TbsInstaller", localStringBuilder.toString());
      int i1 = ((Bundle)localObject).getInt("patch_result");
      if (i1 == 0)
      {
        localObject = paramBundle.getString("new_apk_location");
        i1 = paramBundle.getInt("new_core_ver");
        int i2 = a(new File((String)localObject));
        if (i1 != i2)
        {
          paramBundle = new StringBuilder();
          paramBundle.append("version not equals!!!");
          paramBundle.append(i1);
          paramBundle.append("patchVersion:");
          paramBundle.append(i2);
          TbsLog.i("TbsInstaller", paramBundle.toString());
          paramBundle = TbsLogReport.getInstance(paramContext);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("version=");
          ((StringBuilder)localObject).append(i1);
          ((StringBuilder)localObject).append(",patchVersion=");
          ((StringBuilder)localObject).append(i2);
          paramBundle.setInstallErrorCode(240, ((StringBuilder)localObject).toString());
          return 1;
        }
        boolean bool = TbsDownloader.a(paramContext);
        if (bool)
        {
          TbsLog.i("TbsInstaller", "Tpatch decouple success!");
          paramBundle = TbsLogReport.getInstance(paramContext);
        }
        for (i1 = 237;; i1 = 236)
        {
          paramBundle.setInstallErrorCode(i1, "");
          break;
          TbsLog.i("TbsInstaller", "Tpatch success!");
          paramBundle = TbsLogReport.getInstance(paramContext);
        }
      }
      paramBundle = paramBundle.getString("new_apk_location");
      if (!TextUtils.isEmpty(paramBundle)) {
        FileUtil.b(new File(paramBundle));
      }
      paramBundle = TbsLogReport.getInstance(paramContext);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("tpatch fail,patch error_code=");
      ((StringBuilder)localObject).append(i1);
      paramBundle.setInstallErrorCode(i1, ((StringBuilder)localObject).toString());
      return 1;
    }
    catch (Exception paramBundle)
    {
      paramBundle.printStackTrace();
      paramContext = TbsLogReport.getInstance(paramContext);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("patch exception");
      ((StringBuilder)localObject).append(Log.getStackTraceString(paramBundle));
      paramContext.setInstallErrorCode(239, ((StringBuilder)localObject).toString());
      return 1;
    }
    return 0;
  }
  
  private boolean c(Context paramContext, File paramFile)
  {
    try
    {
      Object localObject1 = new File(paramFile, "tbs_sdk_extension_dex.jar");
      Object localObject2 = new File(paramFile, "tbs_sdk_extension_dex.dex");
      Object localObject3 = paramContext.getClassLoader();
      new DexClassLoader(((File)localObject1).getAbsolutePath(), paramFile.getAbsolutePath(), null, (ClassLoader)localObject3);
      localObject1 = e.a(paramContext, ((File)localObject2).getAbsolutePath());
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        TbsLogReport.getInstance(paramContext).setInstallErrorCode(226, "can not find oat command");
        return false;
      }
      paramFile = paramFile.listFiles(new p.7(this));
      int i2 = paramFile.length;
      int i1 = 0;
      while (i1 < i2)
      {
        localObject2 = paramFile[i1];
        localObject2 = ((File)localObject2).getName().substring(0, ((File)localObject2).getName().length() - 4);
        localObject3 = ((String)localObject1).replaceAll("tbs_sdk_extension_dex", (String)localObject2);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("/system/bin/dex2oat ");
        localStringBuilder.append((String)localObject3);
        localStringBuilder.append(" --dex-location=");
        localStringBuilder.append(a().r(paramContext));
        localStringBuilder.append(File.separator);
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append(".jar");
        localObject2 = localStringBuilder.toString();
        Runtime.getRuntime().exec((String)localObject2).waitFor();
        i1 += 1;
      }
      return true;
    }
    catch (Exception paramFile)
    {
      paramFile.printStackTrace();
      TbsLogReport.getInstance(paramContext).setInstallErrorCode(226, paramFile);
    }
    return false;
  }
  
  private boolean c(Context paramContext, boolean paramBoolean)
  {
    try
    {
      TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromTpatch");
      boolean bool2 = false;
      boolean bool4 = false;
      boolean bool3 = false;
      boolean bool1 = bool4;
      try
      {
        boolean bool5 = u(paramContext);
        if (!bool5) {
          return false;
        }
        bool1 = bool4;
        bool5 = i.tryLock();
        bool1 = bool4;
        StringBuilder localStringBuilder1 = new StringBuilder();
        bool1 = bool4;
        localStringBuilder1.append("TbsInstaller-enableTbsCoreFromTpatch Locked =");
        bool1 = bool4;
        localStringBuilder1.append(bool5);
        bool1 = bool4;
        TbsLog.i("TbsInstaller", localStringBuilder1.toString());
        if (bool5) {
          try
          {
            int i1 = m.a(paramContext).b("tpatch_status");
            int i2 = a(false, paramContext);
            localStringBuilder1 = new StringBuilder();
            localStringBuilder1.append("TbsInstaller-enableTbsCoreFromTpatch copyStatus =");
            localStringBuilder1.append(i1);
            TbsLog.i("TbsInstaller", localStringBuilder1.toString());
            localStringBuilder1 = new StringBuilder();
            localStringBuilder1.append("TbsInstaller-enableTbsCoreFromTpatch tbsCoreInstalledVer =");
            localStringBuilder1.append(i2);
            TbsLog.i("TbsInstaller", localStringBuilder1.toString());
            bool2 = bool3;
            if (i1 == 1)
            {
              if (i2 == 0) {
                TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromTpatch tbsCoreInstalledVer = 0", true);
              }
              for (;;)
              {
                z(paramContext);
                bool2 = true;
                break;
                bool2 = bool3;
                if (!paramBoolean) {
                  break;
                }
                TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromTpatch tbsCoreInstalledVer != 0", true);
              }
            }
            bool1 = bool2;
            i.unlock();
          }
          finally
          {
            bool1 = bool4;
            i.unlock();
            bool1 = bool4;
          }
        }
        bool1 = bool2;
        b();
        bool1 = bool2;
      }
      catch (Throwable localThrowable)
      {
        TbsLogReport.getInstance(paramContext).setInstallErrorCode(215, localThrowable.toString());
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("TbsInstaller::enableTbsCoreFromTpatch exception:");
        localStringBuilder2.append(Log.getStackTraceString(localThrowable));
        QbSdk.a(paramContext, localStringBuilder2.toString());
      }
      return bool1;
    }
    finally {}
    for (;;)
    {
      throw paramContext;
    }
  }
  
  /* Error */
  private boolean d(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 127
    //   4: ldc_w 1112
    //   7: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   10: iconst_0
    //   11: istore 6
    //   13: iconst_0
    //   14: istore 8
    //   16: iconst_0
    //   17: istore 7
    //   19: iload 8
    //   21: istore 5
    //   23: aload_0
    //   24: aload_1
    //   25: invokevirtual 481	com/tencent/smtt/sdk/p:u	(Landroid/content/Context;)Z
    //   28: istore 9
    //   30: iload 9
    //   32: ifne +7 -> 39
    //   35: aload_0
    //   36: monitorexit
    //   37: iconst_0
    //   38: ireturn
    //   39: iload 8
    //   41: istore 5
    //   43: getstatic 41	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   46: invokevirtual 1089	java/util/concurrent/locks/ReentrantLock:tryLock	()Z
    //   49: istore 9
    //   51: iload 8
    //   53: istore 5
    //   55: new 202	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   62: astore 10
    //   64: iload 8
    //   66: istore 5
    //   68: aload 10
    //   70: ldc_w 1114
    //   73: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: iload 8
    //   79: istore 5
    //   81: aload 10
    //   83: iload 9
    //   85: invokevirtual 276	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: iload 8
    //   91: istore 5
    //   93: ldc 127
    //   95: aload 10
    //   97: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   103: iload 9
    //   105: ifeq +179 -> 284
    //   108: aload_1
    //   109: invokestatic 165	com/tencent/smtt/sdk/m:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/m;
    //   112: ldc_w 498
    //   115: invokevirtual 500	com/tencent/smtt/sdk/m:b	(Ljava/lang/String;)I
    //   118: istore_3
    //   119: aload_0
    //   120: iconst_0
    //   121: aload_1
    //   122: invokevirtual 1096	com/tencent/smtt/sdk/p:a	(ZLandroid/content/Context;)I
    //   125: istore 4
    //   127: new 202	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   134: astore 10
    //   136: aload 10
    //   138: ldc_w 1116
    //   141: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: aload 10
    //   147: iload_3
    //   148: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: ldc 127
    //   154: aload 10
    //   156: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   162: new 202	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   169: astore 10
    //   171: aload 10
    //   173: ldc_w 1118
    //   176: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: aload 10
    //   182: iload 4
    //   184: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: ldc 127
    //   190: aload 10
    //   192: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   198: iload 7
    //   200: istore 6
    //   202: iload_3
    //   203: iconst_1
    //   204: if_icmpne +48 -> 252
    //   207: iload 4
    //   209: ifne +23 -> 232
    //   212: ldc 127
    //   214: ldc_w 1120
    //   217: iconst_1
    //   218: invokestatic 360	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   221: aload_0
    //   222: aload_1
    //   223: invokespecial 1122	com/tencent/smtt/sdk/p:A	(Landroid/content/Context;)V
    //   226: iconst_1
    //   227: istore 6
    //   229: goto +23 -> 252
    //   232: iload 7
    //   234: istore 6
    //   236: iload_2
    //   237: ifeq +15 -> 252
    //   240: ldc 127
    //   242: ldc_w 1124
    //   245: iconst_1
    //   246: invokestatic 360	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   249: goto -28 -> 221
    //   252: iload 6
    //   254: istore 5
    //   256: getstatic 41	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   259: invokevirtual 511	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   262: goto +22 -> 284
    //   265: astore 10
    //   267: iload 8
    //   269: istore 5
    //   271: getstatic 41	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   274: invokevirtual 511	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   277: iload 8
    //   279: istore 5
    //   281: aload 10
    //   283: athrow
    //   284: iload 6
    //   286: istore 5
    //   288: aload_0
    //   289: invokevirtual 514	com/tencent/smtt/sdk/p:b	()V
    //   292: iload 6
    //   294: istore 5
    //   296: goto +62 -> 358
    //   299: astore_1
    //   300: goto +63 -> 363
    //   303: astore 10
    //   305: aload_1
    //   306: invokestatic 239	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   309: sipush 215
    //   312: aload 10
    //   314: invokevirtual 1108	java/lang/Throwable:toString	()Ljava/lang/String;
    //   317: invokevirtual 246	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   320: new 202	java/lang/StringBuilder
    //   323: dup
    //   324: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   327: astore 11
    //   329: aload 11
    //   331: ldc_w 1126
    //   334: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: pop
    //   338: aload 11
    //   340: aload 10
    //   342: invokestatic 679	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   345: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: pop
    //   349: aload_1
    //   350: aload 11
    //   352: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   355: invokestatic 339	com/tencent/smtt/sdk/QbSdk:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   358: aload_0
    //   359: monitorexit
    //   360: iload 5
    //   362: ireturn
    //   363: aload_1
    //   364: athrow
    //   365: astore_1
    //   366: aload_0
    //   367: monitorexit
    //   368: goto +5 -> 373
    //   371: aload_1
    //   372: athrow
    //   373: goto -2 -> 371
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	376	0	this	p
    //   0	376	1	paramContext	Context
    //   0	376	2	paramBoolean	boolean
    //   118	87	3	i1	int
    //   125	83	4	i2	int
    //   21	340	5	bool1	boolean
    //   11	282	6	bool2	boolean
    //   17	216	7	bool3	boolean
    //   14	264	8	bool4	boolean
    //   28	76	9	bool5	boolean
    //   62	129	10	localStringBuilder1	StringBuilder
    //   265	17	10	localObject	Object
    //   303	38	10	localThrowable	Throwable
    //   327	24	11	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   108	198	265	finally
    //   212	221	265	finally
    //   221	226	265	finally
    //   240	249	265	finally
    //   23	30	299	finally
    //   43	51	299	finally
    //   55	64	299	finally
    //   68	77	299	finally
    //   81	89	299	finally
    //   93	103	299	finally
    //   256	262	299	finally
    //   271	277	299	finally
    //   281	284	299	finally
    //   288	292	299	finally
    //   305	358	299	finally
    //   23	30	303	java/lang/Throwable
    //   43	51	303	java/lang/Throwable
    //   55	64	303	java/lang/Throwable
    //   68	77	303	java/lang/Throwable
    //   81	89	303	java/lang/Throwable
    //   93	103	303	java/lang/Throwable
    //   256	262	303	java/lang/Throwable
    //   271	277	303	java/lang/Throwable
    //   281	284	303	java/lang/Throwable
    //   288	292	303	java/lang/Throwable
    //   2	10	365	finally
    //   363	365	365	finally
  }
  
  private boolean e(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0);
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      label13:
      break label13;
    }
    paramContext = null;
    return paramContext != null;
  }
  
  private boolean e(Context paramContext, boolean paramBoolean)
  {
    if (paramContext != null) {}
    try
    {
      if ("com.tencent.mm".equals(paramContext.getApplicationContext().getApplicationInfo().packageName)) {
        TbsLogReport.getInstance(paramContext).setInstallErrorCode(229, " ");
      }
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("TbsInstaller-enableTbsCoreFromUnzip canRenameTmpDir =");
      localStringBuilder1.append(paramBoolean);
      TbsLog.i("TbsInstaller", localStringBuilder1.toString());
      TbsLog.i("TbsInstaller", "Tbsinstaller enableTbsCoreFromUnzip #1 ");
      boolean bool2 = false;
      boolean bool4 = false;
      boolean bool3 = false;
      boolean bool1 = bool4;
      try
      {
        boolean bool5 = u(paramContext);
        if (!bool5) {
          return false;
        }
        bool1 = bool4;
        TbsLog.i("TbsInstaller", "Tbsinstaller enableTbsCoreFromUnzip #2 ");
        bool1 = bool4;
        bool5 = i.tryLock();
        bool1 = bool4;
        localStringBuilder1 = new StringBuilder();
        bool1 = bool4;
        localStringBuilder1.append("TbsInstaller-enableTbsCoreFromUnzip locked=");
        bool1 = bool4;
        localStringBuilder1.append(bool5);
        bool1 = bool4;
        TbsLog.i("TbsInstaller", localStringBuilder1.toString());
        if (bool5) {
          try
          {
            int i1 = m.a(paramContext).c();
            localStringBuilder1 = new StringBuilder();
            localStringBuilder1.append("TbsInstaller-enableTbsCoreFromUnzip installStatus=");
            localStringBuilder1.append(i1);
            TbsLog.i("TbsInstaller", localStringBuilder1.toString());
            int i2 = a(false, paramContext);
            bool2 = bool3;
            if (i1 == 2)
            {
              TbsLog.i("TbsInstaller", "Tbsinstaller enableTbsCoreFromUnzip #4 ");
              if (i2 == 0) {
                TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip tbsCoreInstalledVer = 0", false);
              }
              for (;;)
              {
                y(paramContext);
                bool2 = true;
                break;
                bool2 = bool3;
                if (!paramBoolean) {
                  break;
                }
                TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip tbsCoreInstalledVer != 0", false);
              }
            }
            bool1 = bool2;
            i.unlock();
          }
          finally
          {
            bool1 = bool4;
            i.unlock();
            bool1 = bool4;
          }
        }
        bool1 = bool2;
        b();
        bool1 = bool2;
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("TbsInstaller::enableTbsCoreFromUnzip Exception: ");
        localStringBuilder2.append(localException);
        QbSdk.a(paramContext, localStringBuilder2.toString());
        localException.printStackTrace();
      }
      return bool1;
    }
    finally {}
    for (;;)
    {
      throw paramContext;
    }
  }
  
  private boolean f(Context paramContext, boolean paramBoolean)
  {
    return false;
  }
  
  private void g(Context paramContext, boolean paramBoolean)
  {
    if (paramContext == null)
    {
      TbsLogReport.getInstance(paramContext).setInstallErrorCode(225, "setTmpFolderCoreToRead context is null");
      return;
    }
    try
    {
      File localFile = new File(QbSdk.getTbsFolderDir(paramContext), "tmp_folder_core_to_read.conf");
      if (paramBoolean)
      {
        if (localFile.exists()) {
          return;
        }
        localFile.createNewFile();
        return;
      }
      FileUtil.b(localFile);
      return;
    }
    catch (Exception localException)
    {
      paramContext = TbsLogReport.getInstance(paramContext);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setTmpFolderCoreToRead Exception message is ");
      localStringBuilder.append(localException.getMessage());
      localStringBuilder.append(" Exception cause is ");
      localStringBuilder.append(localException.getCause());
      paramContext.setInstallErrorCode(225, localStringBuilder.toString());
    }
  }
  
  private void h(Context paramContext, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("proceedTpatchStatus,result=");
    localStringBuilder.append(paramInt);
    TbsLog.i("TbsInstaller", localStringBuilder.toString());
    if (paramInt == 0) {
      if (TbsDownloader.a(paramContext))
      {
        i(paramContext, 6);
      }
      else
      {
        g(paramContext, true);
        paramInt = TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_download_version", 0);
        m.a(paramContext).b(paramInt, 1);
      }
    }
    QbSdk.setTBSInstallingStatus(false);
  }
  
  private void i(Context paramContext, int paramInt)
  {
    File localFile1 = a().f(paramContext, paramInt);
    a().g(paramContext, true);
    File localFile2 = q(paramContext);
    FileUtil.a(localFile2, true);
    localFile1.renameTo(localFile2);
    TbsShareManager.b(paramContext);
  }
  
  private boolean j(Context paramContext, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TbsInstaller-doTbsDexOpt start - dirMode: ");
    ((StringBuilder)localObject).append(paramInt);
    TbsLog.i("TbsInstaller", ((StringBuilder)localObject).toString());
    int i3 = 0;
    if ((paramInt == 0) || ((paramInt == 1) || (paramInt != 2))) {}
    try
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doDexoptOrDexoat mode error: ");
      ((StringBuilder)localObject).append(paramInt);
      TbsLog.e("TbsInstaller", ((StringBuilder)localObject).toString());
      return false;
    }
    catch (Exception localException)
    {
      boolean bool;
      localException.printStackTrace();
      TbsLogReport.getInstance(paramContext).setInstallErrorCode(209, localException.toString());
      TbsLog.i("TbsInstaller", "TbsInstaller-doTbsDexOpt done");
      return true;
    }
    localObject = r(paramContext);
    break label127;
    localObject = f(paramContext, 1);
    break label127;
    if (TbsDownloader.a(paramContext)) {
      return true;
    }
    localObject = f(paramContext, 0);
    try
    {
      label127:
      String str = System.getProperty("java.vm.version");
      if (str == null) {
        break label328;
      }
      bool = str.startsWith("2");
      if (!bool) {
        break label328;
      }
      paramInt = 1;
    }
    catch (Throwable localThrowable)
    {
      TbsLogReport.getInstance(paramContext).setInstallErrorCode(226, localThrowable);
      break label328;
    }
    int i1;
    if (Build.VERSION.SDK_INT == 23) {
      i1 = 1;
    }
    for (;;)
    {
      bool = TbsDownloadConfig.getInstance(paramContext).mPreferences.getBoolean("tbs_stop_preoat", false);
      int i2 = i3;
      if (paramInt != 0)
      {
        i2 = i3;
        if (i1 != 0)
        {
          i2 = i3;
          if (!bool) {
            i2 = 1;
          }
        }
      }
      if ((i2 != 0) && (c(paramContext, (File)localObject)))
      {
        TbsLog.i("TbsInstaller", "doTbsDexOpt -- doDexoatForArtVm");
        return true;
      }
      if (paramInt != 0)
      {
        TbsLog.i("TbsInstaller", "doTbsDexOpt -- is ART mode, skip!");
      }
      else
      {
        TbsLog.i("TbsInstaller", "doTbsDexOpt -- doDexoptForDavlikVM");
        bool = b(paramContext, (File)localObject);
        return bool;
      }
      label328:
      paramInt = 0;
      break;
      i1 = 0;
    }
  }
  
  static File t(Context paramContext)
  {
    paramContext = new File(QbSdk.getTbsFolderDir(paramContext), "core_private");
    if ((!paramContext.isDirectory()) && (!paramContext.mkdir())) {
      return null;
    }
    return paramContext;
  }
  
  private int v(Context paramContext)
  {
    int i2 = m.a(paramContext).d();
    int i1 = 1;
    if (i2 != 1) {
      i1 = 0;
    }
    boolean bool = TbsDownloader.a(paramContext);
    if (i1 != 0)
    {
      if (bool) {
        return 234;
      }
      return 221;
    }
    if (bool) {
      return 233;
    }
    return 200;
  }
  
  private static boolean w(Context paramContext)
  {
    if (paramContext == null) {}
    for (paramContext = "TbsInstaller-getTmpFolderCoreToRead, #1";; paramContext = "TbsInstaller-getTmpFolderCoreToRead, #4")
    {
      TbsLog.i("TbsInstaller", paramContext);
      return true;
      try
      {
        if (new File(QbSdk.getTbsFolderDir(paramContext), "tmp_folder_core_to_read.conf").exists())
        {
          TbsLog.i("TbsInstaller", "TbsInstaller-getTmpFolderCoreToRead, #2");
          return true;
        }
        TbsLog.i("TbsInstaller", "TbsInstaller-getTmpFolderCoreToRead, #3");
        return false;
      }
      catch (Exception paramContext)
      {
        label56:
        break label56;
      }
    }
  }
  
  private boolean x(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "Tbsinstaller getTbsCoreRenameFileLock #1 ");
    l = FileUtil.f(paramContext);
    if (l == null)
    {
      TbsLog.i("TbsInstaller", "getTbsCoreRenameFileLock## failed!");
      return false;
    }
    TbsLog.i("TbsInstaller", "Tbsinstaller getTbsCoreRenameFileLock true ");
    return true;
  }
  
  private void y(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip");
    if (!x(paramContext))
    {
      TbsLog.i("TbsInstaller", "get rename fileLock#4 ## failed!");
      return;
    }
    try
    {
      B(paramContext);
      C(paramContext);
      TbsLog.i("TbsInstaller", "after renameTbsCoreShareDir");
      if (!TbsShareManager.isThirdPartyApp(paramContext))
      {
        TbsLog.i("TbsInstaller", "prepare to shareTbsCore");
        TbsShareManager.a(paramContext);
      }
      else
      {
        TbsLog.i("TbsInstaller", "is thirdapp and not chmod");
      }
      m.a(paramContext).a(0);
      m.a(paramContext).b(0);
      m.a(paramContext).d(0);
      m.a(paramContext).a("incrupdate_retry_num", 0);
      m.a(paramContext).c(0, 3);
      m.a(paramContext).a("");
      m.a(paramContext).a("tpatch_num", 0);
      m.a(paramContext).c(-1);
      if (!TbsShareManager.isThirdPartyApp(paramContext))
      {
        int i1 = TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_decouplecoreversion", 0);
        if ((i1 > 0) && (i1 != a().i(paramContext)) && (i1 == a().j(paramContext)))
        {
          o(paramContext);
        }
        else
        {
          StringBuilder localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("TbsInstaller--generateNewTbsCoreFromUnzip #1 deCoupleCoreVersion is ");
          localStringBuilder1.append(i1);
          localStringBuilder1.append(" getTbsCoreShareDecoupleCoreVersion is ");
          localStringBuilder1.append(a().i(paramContext));
          localStringBuilder1.append(" getTbsCoreInstalledVerInNolock is ");
          localStringBuilder1.append(a().j(paramContext));
          TbsLog.i("TbsInstaller", localStringBuilder1.toString());
        }
      }
      if (TbsShareManager.isThirdPartyApp(paramContext)) {
        TbsShareManager.writeCoreInfoForThirdPartyApp(paramContext, n(paramContext), true);
      }
      a.set(Integer.valueOf(0));
      o = 0;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      TbsLogReport localTbsLogReport = TbsLogReport.getInstance(paramContext);
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("exception when renameing from unzip:");
      localStringBuilder2.append(localThrowable.toString());
      localTbsLogReport.setInstallErrorCode(219, localStringBuilder2.toString());
      TbsLog.e("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip Exception", true);
    }
    h(paramContext);
  }
  
  private void z(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromTpatch");
    if (!x(paramContext))
    {
      TbsLog.i("TbsInstaller", "get rename fileLock#4 ## failed!");
      return;
    }
    try
    {
      B(paramContext);
      E(paramContext);
      if (TbsShareManager.isThirdPartyApp(paramContext)) {
        TbsShareManager.writeCoreInfoForThirdPartyApp(paramContext, n(paramContext), true);
      } else {
        TbsShareManager.a(paramContext);
      }
      m.a(paramContext).b(0, -1);
      m.a(paramContext).a("tpatch_num", 0);
      a.set(Integer.valueOf(0));
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      TbsLogReport localTbsLogReport = TbsLogReport.getInstance(paramContext);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("exception when renameing from tpatch:");
      localStringBuilder.append(localException.toString());
      localTbsLogReport.setInstallErrorCode(242, localStringBuilder.toString());
    }
    h(paramContext);
  }
  
  /* Error */
  int a(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: new 202	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   12: astore 5
    //   14: aload 5
    //   16: ldc_w 1265
    //   19: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: aload 5
    //   25: aload_1
    //   26: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: ldc 127
    //   32: aload 5
    //   34: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   40: new 267	java/io/File
    //   43: dup
    //   44: aload_1
    //   45: ldc_w 373
    //   48: invokespecial 368	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   51: astore_1
    //   52: aload_1
    //   53: invokevirtual 583	java/io/File:exists	()Z
    //   56: ifne +5 -> 61
    //   59: iconst_0
    //   60: ireturn
    //   61: new 375	java/util/Properties
    //   64: dup
    //   65: invokespecial 376	java/util/Properties:<init>	()V
    //   68: astore 5
    //   70: new 378	java/io/BufferedInputStream
    //   73: dup
    //   74: new 380	java/io/FileInputStream
    //   77: dup
    //   78: aload_1
    //   79: invokespecial 383	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   82: invokespecial 386	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   85: astore_1
    //   86: aload 5
    //   88: aload_1
    //   89: invokevirtual 389	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   92: aload_1
    //   93: invokevirtual 416	java/io/BufferedInputStream:close	()V
    //   96: aload 5
    //   98: ldc_w 1267
    //   101: invokevirtual 1268	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   104: astore_3
    //   105: aload_3
    //   106: ifnonnull +9 -> 115
    //   109: aload_1
    //   110: invokevirtual 416	java/io/BufferedInputStream:close	()V
    //   113: iconst_0
    //   114: ireturn
    //   115: aload_3
    //   116: invokestatic 1271	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   119: istore_2
    //   120: aload_1
    //   121: invokevirtual 416	java/io/BufferedInputStream:close	()V
    //   124: iload_2
    //   125: ireturn
    //   126: astore 4
    //   128: aload_1
    //   129: astore_3
    //   130: aload 4
    //   132: astore_1
    //   133: goto +7 -> 140
    //   136: goto +14 -> 150
    //   139: astore_1
    //   140: aload_3
    //   141: ifnull +7 -> 148
    //   144: aload_3
    //   145: invokevirtual 416	java/io/BufferedInputStream:close	()V
    //   148: aload_1
    //   149: athrow
    //   150: aload_1
    //   151: ifnull +7 -> 158
    //   154: aload_1
    //   155: invokevirtual 416	java/io/BufferedInputStream:close	()V
    //   158: iconst_0
    //   159: ireturn
    //   160: astore_1
    //   161: aload 4
    //   163: astore_1
    //   164: goto -14 -> 150
    //   167: astore_3
    //   168: goto -32 -> 136
    //   171: astore_1
    //   172: iconst_0
    //   173: ireturn
    //   174: astore_1
    //   175: iload_2
    //   176: ireturn
    //   177: astore_3
    //   178: goto -30 -> 148
    //   181: astore_1
    //   182: iconst_0
    //   183: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	this	p
    //   0	184	1	paramFile	File
    //   119	57	2	i1	int
    //   4	141	3	localObject1	Object
    //   167	1	3	localException	Exception
    //   177	1	3	localIOException	java.io.IOException
    //   1	1	4	localObject2	Object
    //   126	36	4	localObject3	Object
    //   12	85	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   86	105	126	finally
    //   115	120	126	finally
    //   5	59	139	finally
    //   61	86	139	finally
    //   5	59	160	java/lang/Exception
    //   61	86	160	java/lang/Exception
    //   86	105	167	java/lang/Exception
    //   115	120	167	java/lang/Exception
    //   109	113	171	java/io/IOException
    //   120	124	174	java/io/IOException
    //   144	148	177	java/io/IOException
    //   154	158	181	java/io/IOException
  }
  
  /* Error */
  int a(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: iconst_0
    //   5: ireturn
    //   6: aconst_null
    //   7: astore 4
    //   9: aconst_null
    //   10: astore_3
    //   11: new 267	java/io/File
    //   14: dup
    //   15: new 267	java/io/File
    //   18: dup
    //   19: aload_1
    //   20: invokespecial 349	java/io/File:<init>	(Ljava/lang/String;)V
    //   23: ldc_w 373
    //   26: invokespecial 368	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   29: astore_1
    //   30: aload_1
    //   31: invokevirtual 583	java/io/File:exists	()Z
    //   34: ifne +5 -> 39
    //   37: iconst_0
    //   38: ireturn
    //   39: new 375	java/util/Properties
    //   42: dup
    //   43: invokespecial 376	java/util/Properties:<init>	()V
    //   46: astore 5
    //   48: new 378	java/io/BufferedInputStream
    //   51: dup
    //   52: new 380	java/io/FileInputStream
    //   55: dup
    //   56: aload_1
    //   57: invokespecial 383	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   60: invokespecial 386	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   63: astore_1
    //   64: aload 5
    //   66: aload_1
    //   67: invokevirtual 389	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   70: aload_1
    //   71: invokevirtual 416	java/io/BufferedInputStream:close	()V
    //   74: aload 5
    //   76: ldc_w 1267
    //   79: invokevirtual 1268	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   82: astore_3
    //   83: aload_3
    //   84: ifnonnull +9 -> 93
    //   87: aload_1
    //   88: invokevirtual 416	java/io/BufferedInputStream:close	()V
    //   91: iconst_0
    //   92: ireturn
    //   93: aload_3
    //   94: invokestatic 1271	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   97: istore_2
    //   98: aload_1
    //   99: invokevirtual 416	java/io/BufferedInputStream:close	()V
    //   102: iload_2
    //   103: ireturn
    //   104: astore 4
    //   106: aload_1
    //   107: astore_3
    //   108: aload 4
    //   110: astore_1
    //   111: goto +7 -> 118
    //   114: goto +14 -> 128
    //   117: astore_1
    //   118: aload_3
    //   119: ifnull +7 -> 126
    //   122: aload_3
    //   123: invokevirtual 416	java/io/BufferedInputStream:close	()V
    //   126: aload_1
    //   127: athrow
    //   128: aload_1
    //   129: ifnull +7 -> 136
    //   132: aload_1
    //   133: invokevirtual 416	java/io/BufferedInputStream:close	()V
    //   136: iconst_0
    //   137: ireturn
    //   138: astore_1
    //   139: aload 4
    //   141: astore_1
    //   142: goto -14 -> 128
    //   145: astore_3
    //   146: goto -32 -> 114
    //   149: astore_1
    //   150: iconst_0
    //   151: ireturn
    //   152: astore_1
    //   153: iload_2
    //   154: ireturn
    //   155: astore_3
    //   156: goto -30 -> 126
    //   159: astore_1
    //   160: iconst_0
    //   161: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	162	0	this	p
    //   0	162	1	paramString	String
    //   97	57	2	i1	int
    //   10	113	3	str	String
    //   145	1	3	localException	Exception
    //   155	1	3	localIOException	java.io.IOException
    //   7	1	4	localObject1	Object
    //   104	36	4	localObject2	Object
    //   46	29	5	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   64	83	104	finally
    //   93	98	104	finally
    //   11	37	117	finally
    //   39	64	117	finally
    //   11	37	138	java/lang/Exception
    //   39	64	138	java/lang/Exception
    //   64	83	145	java/lang/Exception
    //   93	98	145	java/lang/Exception
    //   87	91	149	java/io/IOException
    //   98	102	152	java/io/IOException
    //   122	126	155	java/io/IOException
    //   132	136	159	java/io/IOException
  }
  
  public int a(boolean paramBoolean, Context paramContext)
  {
    if ((paramBoolean) || (((Integer)a.get()).intValue() <= 0)) {
      a.set(Integer.valueOf(j(paramContext)));
    }
    return ((Integer)a.get()).intValue();
  }
  
  File a(Context paramContext, int paramInt, boolean paramBoolean)
  {
    File localFile = QbSdk.getTbsFolderDir(paramContext);
    switch (paramInt)
    {
    default: 
      paramContext = "";
      break;
    case 6: 
      paramContext = "tpatch_decouple_tmp";
      break;
    case 5: 
      paramContext = "tpatch_tmp";
      break;
    case 4: 
      paramContext = "core_share_backup_tmp";
      break;
    case 3: 
      paramContext = "core_share_backup";
      break;
    case 2: 
      paramContext = "core_unzip_tmp_decouple";
      break;
    case 1: 
      paramContext = "core_copy_tmp";
      break;
    case 0: 
      paramContext = "core_unzip_tmp";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("type=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("needMakeDir=");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("folder=");
    localStringBuilder.append(paramContext);
    TbsLog.i("TbsInstaller", localStringBuilder.toString());
    paramContext = new File(localFile, paramContext);
    if (!paramContext.isDirectory()) {
      if (paramBoolean)
      {
        if (paramContext.mkdir()) {}
      }
      else {
        for (paramContext = "getCoreDir,mkdir false";; paramContext = "getCoreDir,no need mkdir")
        {
          TbsLog.i("TbsInstaller", paramContext);
          return null;
        }
      }
    }
    return paramContext;
  }
  
  public void a(Context paramContext, int paramInt)
  {
    g(paramContext, true);
    m.a(paramContext).c(paramInt, 2);
  }
  
  void a(Context paramContext, Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      if (paramContext == null) {
        return;
      }
      Message localMessage = new Message();
      localMessage.what = 3;
      localMessage.obj = new Object[] { paramContext, paramBundle };
      m.sendMessage(localMessage);
    }
  }
  
  public void a(Context paramContext, File paramFile, int paramInt)
  {
    FileOutputStream localFileOutputStream = FileUtil.b(paramContext, true, "core_unzip.lock");
    FileLock localFileLock = FileUtil.a(paramContext, localFileOutputStream);
    if (localFileLock != null)
    {
      TbsLog.i("TbsInstaller", "unzipTbsCoreToThirdAppTmpInThread #1");
      boolean bool = a(paramContext, paramFile, false);
      paramFile = new StringBuilder();
      paramFile.append("unzipTbsCoreToThirdAppTmpInThread result is ");
      paramFile.append(bool);
      TbsLog.i("TbsInstaller", paramFile.toString());
      if (bool) {
        a().a(paramContext, paramInt);
      }
      FileUtil.a(localFileLock, localFileOutputStream);
      return;
    }
    TbsLog.i("TbsInstaller", "can not get Core unzip FileLock,skip!!!");
  }
  
  void a(Context paramContext, String paramString, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TbsInstaller-installTbsCore tbsApkPath=");
    ((StringBuilder)localObject).append(paramString);
    TbsLog.i("TbsInstaller", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TbsInstaller-installTbsCore tbsCoreTargetVer=");
    ((StringBuilder)localObject).append(paramInt);
    TbsLog.i("TbsInstaller", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TbsInstaller-continueInstallTbsCore currentProcessName=");
    ((StringBuilder)localObject).append(paramContext.getApplicationInfo().processName);
    TbsLog.i("TbsInstaller", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TbsInstaller-installTbsCore currentProcessId=");
    ((StringBuilder)localObject).append(android.os.Process.myPid());
    TbsLog.i("TbsInstaller", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TbsInstaller-installTbsCore currentThreadName=");
    ((StringBuilder)localObject).append(Thread.currentThread().getName());
    TbsLog.i("TbsInstaller", ((StringBuilder)localObject).toString());
    localObject = new Message();
    ((Message)localObject).what = 1;
    ((Message)localObject).obj = new Object[] { paramContext, paramString, Integer.valueOf(paramInt) };
    m.sendMessage((Message)localObject);
  }
  
  void a(Context paramContext, boolean paramBoolean)
  {
    int i6 = 1;
    if (paramBoolean) {
      this.k = true;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("TbsInstaller-continueInstallTbsCore currentProcessName=");
    ((StringBuilder)localObject1).append(paramContext.getApplicationInfo().processName);
    TbsLog.i("TbsInstaller", ((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("TbsInstaller-continueInstallTbsCore currentProcessId=");
    ((StringBuilder)localObject1).append(android.os.Process.myPid());
    TbsLog.i("TbsInstaller", ((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("TbsInstaller-continueInstallTbsCore currentThreadName=");
    ((StringBuilder)localObject1).append(Thread.currentThread().getName());
    TbsLog.i("TbsInstaller", ((StringBuilder)localObject1).toString());
    if (!u(paramContext)) {
      return;
    }
    if (i.tryLock()) {}
    try
    {
      i4 = m.a(paramContext).c();
      i1 = m.a(paramContext).b();
      localObject1 = m.a(paramContext).d("install_apk_path");
      i2 = m.a(paramContext).c("copy_core_ver");
      i3 = m.a(paramContext).b("copy_status");
      i.unlock();
    }
    finally
    {
      i.unlock();
    }
    int i4 = -1;
    int i1 = 0;
    int i2 = 0;
    int i3 = -1;
    b();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("TbsInstaller-continueInstallTbsCore installStatus=");
    ((StringBuilder)localObject2).append(i4);
    TbsLog.i("TbsInstaller", ((StringBuilder)localObject2).toString());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("TbsInstaller-continueInstallTbsCore tbsCoreInstallVer=");
    ((StringBuilder)localObject2).append(i1);
    TbsLog.i("TbsInstaller", ((StringBuilder)localObject2).toString());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("TbsInstaller-continueInstallTbsCore tbsApkPath=");
    ((StringBuilder)localObject2).append((String)localObject1);
    TbsLog.i("TbsInstaller", ((StringBuilder)localObject2).toString());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("TbsInstaller-continueInstallTbsCore tbsCoreCopyVer=");
    ((StringBuilder)localObject2).append(i2);
    TbsLog.i("TbsInstaller", ((StringBuilder)localObject2).toString());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("TbsInstaller-continueInstallTbsCore copyStatus=");
    ((StringBuilder)localObject2).append(i3);
    TbsLog.i("TbsInstaller", ((StringBuilder)localObject2).toString());
    if (TbsShareManager.isThirdPartyApp(paramContext))
    {
      c(paramContext, TbsShareManager.a(paramContext, false));
      return;
    }
    int i7 = TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_responsecode", 0);
    int i5 = i6;
    if (i7 != 1)
    {
      i5 = i6;
      if (i7 != 2) {
        if (i7 == 4) {
          i5 = i6;
        } else {
          i5 = 0;
        }
      }
    }
    if ((i5 == 0) && (i7 != 0) && (i7 != 5))
    {
      localObject2 = new Bundle();
      ((Bundle)localObject2).putInt("operation", 10001);
      a(paramContext, (Bundle)localObject2);
    }
    if ((i4 > -1) && (i4 < 2)) {
      a(paramContext, (String)localObject1, i1);
    }
    if (i3 == 0) {
      b(paramContext, i2);
    }
  }
  
  public boolean a(Context paramContext1, Context paramContext2)
  {
    try
    {
      TbsLog.i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp");
      boolean bool = p;
      if (bool == true) {
        return true;
      }
      p = true;
      new p.4(this, paramContext2, paramContext1).start();
      return true;
    }
    finally {}
  }
  
  public int b(Context paramContext)
  {
    if (w(paramContext))
    {
      if (a(paramContext, "core_unzip_tmp")) {
        return -1;
      }
      if (a(paramContext, "core_share_backup_tmp")) {
        return -2;
      }
      if (a(paramContext, "core_copy_tmp")) {
        return -3;
      }
      if (a(paramContext, "tpatch_tmp")) {
        return -4;
      }
      return 1;
    }
    return 0;
  }
  
  Context b(Context paramContext, String paramString)
  {
    try
    {
      if ((paramContext.getPackageName() != paramString) && (TbsPVConfig.getInstance(paramContext).isEnableNoCoreGray())) {
        return null;
      }
      paramContext = paramContext.createPackageContext(paramString, 2);
      return paramContext;
    }
    catch (Exception paramContext) {}
    return null;
  }
  
  File b(Context paramContext1, Context paramContext2)
  {
    paramContext2 = new File(QbSdk.getTbsFolderDir(paramContext2), "core_share");
    if ((!paramContext2.isDirectory()) && ((paramContext1 == null) || (!TbsShareManager.isThirdPartyApp(paramContext1))) && (!paramContext2.mkdir()))
    {
      TbsLog.i("TbsInstaller", "getTbsCoreShareDir,mkdir false");
      return null;
    }
    return paramContext2;
  }
  
  void b()
  {
    try
    {
      if (this.e <= 0)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("releaseTbsInstallingFileLock currentTbsFileLockStackCount=");
        localStringBuilder.append(this.e);
        localStringBuilder.append("call stack:");
        localStringBuilder.append(Log.getStackTraceString(new Throwable()));
        TbsLog.i("TbsInstaller", localStringBuilder.toString());
        return;
      }
      if (this.e > 1)
      {
        TbsLog.i("TbsInstaller", "releaseTbsInstallingFileLock with skip");
        this.e -= 1;
        return;
      }
      if (this.e == 1)
      {
        TbsLog.i("TbsInstaller", "releaseTbsInstallingFileLock without skip");
        FileUtil.a(this.f, this.g);
        this.e = 0;
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  void b(Context paramContext, Bundle paramBundle)
  {
    // Byte code:
    //   0: new 202	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   7: astore 11
    //   9: aload 11
    //   11: ldc_w 1413
    //   14: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: pop
    //   18: aload 11
    //   20: invokestatic 804	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   23: invokevirtual 805	java/lang/Thread:getName	()Ljava/lang/String;
    //   26: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload 11
    //   32: new 345	java/lang/Throwable
    //   35: dup
    //   36: invokespecial 1403	java/lang/Throwable:<init>	()V
    //   39: invokestatic 679	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   42: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: ldc 127
    //   48: aload 11
    //   50: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   56: aload_0
    //   57: aload_1
    //   58: invokevirtual 459	com/tencent/smtt/sdk/p:d	(Landroid/content/Context;)Z
    //   61: ifeq +14 -> 75
    //   64: aload_1
    //   65: invokestatic 179	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   68: sipush -539
    //   71: invokevirtual 457	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   74: return
    //   75: ldc 127
    //   77: ldc_w 1415
    //   80: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   83: aload_2
    //   84: ifnull +1983 -> 2067
    //   87: aload_1
    //   88: ifnonnull +4 -> 92
    //   91: return
    //   92: aload_1
    //   93: invokestatic 527	com/tencent/smtt/utils/FileUtil:b	(Landroid/content/Context;)Z
    //   96: ifne +88 -> 184
    //   99: invokestatic 530	com/tencent/smtt/utils/q:a	()J
    //   102: lstore 6
    //   104: aload_1
    //   105: invokestatic 179	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   108: invokevirtual 533	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMinFreeSpace	()J
    //   111: lstore 8
    //   113: aload_1
    //   114: invokestatic 239	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   117: astore_2
    //   118: new 202	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   125: astore 11
    //   127: aload 11
    //   129: ldc_w 1417
    //   132: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: pop
    //   136: aload 11
    //   138: lload 6
    //   140: invokevirtual 538	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   143: pop
    //   144: aload 11
    //   146: ldc_w 540
    //   149: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: aload 11
    //   155: lload 8
    //   157: invokevirtual 538	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload_2
    //   162: sipush 210
    //   165: aload 11
    //   167: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokevirtual 246	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   173: aload_1
    //   174: invokestatic 179	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   177: sipush -540
    //   180: invokevirtual 457	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   183: return
    //   184: aload_0
    //   185: aload_1
    //   186: invokevirtual 481	com/tencent/smtt/sdk/p:u	(Landroid/content/Context;)Z
    //   189: ifne +14 -> 203
    //   192: aload_1
    //   193: invokestatic 179	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   196: sipush -541
    //   199: invokevirtual 457	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   202: return
    //   203: getstatic 43	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   206: invokeinterface 486 1 0
    //   211: istore 10
    //   213: new 202	java/lang/StringBuilder
    //   216: dup
    //   217: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   220: astore 11
    //   222: aload 11
    //   224: ldc_w 1419
    //   227: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: pop
    //   231: aload 11
    //   233: iload 10
    //   235: invokevirtual 276	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   238: pop
    //   239: ldc 127
    //   241: aload 11
    //   243: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   246: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   249: iload 10
    //   251: ifeq +1802 -> 2053
    //   254: aload_1
    //   255: invokestatic 179	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   258: getfield 183	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   261: ldc_w 901
    //   264: iconst_0
    //   265: invokeinterface 191 3 0
    //   270: istore 5
    //   272: iconst_1
    //   273: invokestatic 1183	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   276: iload 5
    //   278: iconst_5
    //   279: if_icmpne +310 -> 589
    //   282: aload_0
    //   283: aload_1
    //   284: aload_2
    //   285: invokespecial 1421	com/tencent/smtt/sdk/p:c	(Landroid/content/Context;Landroid/os/Bundle;)I
    //   288: istore_3
    //   289: iload_3
    //   290: iconst_1
    //   291: if_icmpne +44 -> 335
    //   294: aload_1
    //   295: invokestatic 165	com/tencent/smtt/sdk/m:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/m;
    //   298: ldc 170
    //   300: invokevirtual 496	com/tencent/smtt/sdk/m:c	(Ljava/lang/String;)I
    //   303: istore 4
    //   305: aload_1
    //   306: invokestatic 165	com/tencent/smtt/sdk/m:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/m;
    //   309: ldc 170
    //   311: iload 4
    //   313: iconst_1
    //   314: iadd
    //   315: invokevirtual 173	com/tencent/smtt/sdk/m:a	(Ljava/lang/String;I)V
    //   318: goto +17 -> 335
    //   321: astore_2
    //   322: aconst_null
    //   323: astore 11
    //   325: goto +1431 -> 1756
    //   328: astore_2
    //   329: aconst_null
    //   330: astore 11
    //   332: goto +1134 -> 1466
    //   335: getstatic 43	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   338: invokeinterface 512 1 0
    //   343: aload_0
    //   344: invokevirtual 514	com/tencent/smtt/sdk/p:b	()V
    //   347: iload 5
    //   349: iconst_5
    //   350: if_icmpne +10 -> 360
    //   353: aload_0
    //   354: aload_1
    //   355: iload_3
    //   356: invokespecial 1423	com/tencent/smtt/sdk/p:h	(Landroid/content/Context;I)V
    //   359: return
    //   360: iload_3
    //   361: ifne +57 -> 418
    //   364: ldc 127
    //   366: ldc_w 1425
    //   369: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   372: aload_1
    //   373: invokestatic 165	com/tencent/smtt/sdk/m:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/m;
    //   376: ldc_w 1248
    //   379: iconst_0
    //   380: invokevirtual 173	com/tencent/smtt/sdk/m:a	(Ljava/lang/String;I)V
    //   383: aload_1
    //   384: invokestatic 179	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   387: sipush -544
    //   390: invokevirtual 457	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   393: aload_1
    //   394: invokestatic 165	com/tencent/smtt/sdk/m:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/m;
    //   397: iconst_0
    //   398: iconst_m1
    //   399: invokevirtual 329	com/tencent/smtt/sdk/m:c	(II)V
    //   402: aload_1
    //   403: invokestatic 165	com/tencent/smtt/sdk/m:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/m;
    //   406: iconst_1
    //   407: invokevirtual 332	com/tencent/smtt/sdk/m:c	(I)V
    //   410: new 1427	java/lang/NullPointerException
    //   413: dup
    //   414: invokespecial 1428	java/lang/NullPointerException:<init>	()V
    //   417: athrow
    //   418: iload_3
    //   419: iconst_2
    //   420: if_icmpne +14 -> 434
    //   423: ldc 127
    //   425: ldc_w 1430
    //   428: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   431: goto +139 -> 570
    //   434: aload_1
    //   435: invokestatic 179	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   438: sipush -546
    //   441: invokevirtual 457	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   444: ldc 127
    //   446: ldc_w 1432
    //   449: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   452: aload_1
    //   453: invokestatic 179	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   456: getfield 880	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   459: ldc_w 882
    //   462: iconst_1
    //   463: invokestatic 778	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   466: invokeinterface 888 3 0
    //   471: pop
    //   472: aload_1
    //   473: invokestatic 179	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   476: invokevirtual 892	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   479: aload_1
    //   480: invokestatic 544	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   483: ifeq +42 -> 525
    //   486: aload_1
    //   487: invokestatic 239	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   490: astore_2
    //   491: new 202	java/lang/StringBuilder
    //   494: dup
    //   495: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   498: astore_1
    //   499: aload_1
    //   500: ldc_w 1434
    //   503: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   506: pop
    //   507: aload_1
    //   508: iload_3
    //   509: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   512: pop
    //   513: aload_1
    //   514: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   517: astore_1
    //   518: sipush 235
    //   521: istore_3
    //   522: goto +39 -> 561
    //   525: aload_1
    //   526: invokestatic 239	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   529: astore_2
    //   530: new 202	java/lang/StringBuilder
    //   533: dup
    //   534: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   537: astore_1
    //   538: aload_1
    //   539: ldc_w 1436
    //   542: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   545: pop
    //   546: aload_1
    //   547: iload_3
    //   548: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   551: pop
    //   552: aload_1
    //   553: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   556: astore_1
    //   557: sipush 217
    //   560: istore_3
    //   561: aload_2
    //   562: iload_3
    //   563: aload_1
    //   564: invokevirtual 246	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   567: goto -136 -> 431
    //   570: iconst_0
    //   571: invokestatic 1183	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   574: return
    //   575: astore_2
    //   576: aconst_null
    //   577: astore 11
    //   579: goto +876 -> 1455
    //   582: astore_2
    //   583: aconst_null
    //   584: astore 11
    //   586: goto +878 -> 1464
    //   589: aload_0
    //   590: aload_1
    //   591: invokevirtual 198	com/tencent/smtt/sdk/p:j	(Landroid/content/Context;)I
    //   594: ifle +815 -> 1409
    //   597: aload_1
    //   598: invokestatic 165	com/tencent/smtt/sdk/m:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/m;
    //   601: invokevirtual 1219	com/tencent/smtt/sdk/m:d	()I
    //   604: iconst_1
    //   605: if_icmpne +1463 -> 2068
    //   608: goto +801 -> 1409
    //   611: iload_3
    //   612: ifne +501 -> 1113
    //   615: iload 5
    //   617: ifeq +496 -> 1113
    //   620: aload_1
    //   621: invokestatic 165	com/tencent/smtt/sdk/m:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/m;
    //   624: ldc_w 1248
    //   627: invokevirtual 496	com/tencent/smtt/sdk/m:c	(Ljava/lang/String;)I
    //   630: istore_3
    //   631: iload_3
    //   632: iconst_5
    //   633: if_icmple +173 -> 806
    //   636: ldc 127
    //   638: ldc_w 1438
    //   641: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   644: aload_2
    //   645: ldc_w 1440
    //   648: invokevirtual 1008	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   651: astore 11
    //   653: aload_2
    //   654: ldc_w 1005
    //   657: invokevirtual 1008	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   660: astore 12
    //   662: aload_2
    //   663: ldc_w 1442
    //   666: invokevirtual 1008	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   669: astore_2
    //   670: aload 11
    //   672: invokestatic 1031	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   675: ifne +15 -> 690
    //   678: new 267	java/io/File
    //   681: dup
    //   682: aload 11
    //   684: invokespecial 349	java/io/File:<init>	(Ljava/lang/String;)V
    //   687: invokestatic 721	com/tencent/smtt/utils/FileUtil:b	(Ljava/io/File;)V
    //   690: aload 12
    //   692: invokestatic 1031	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   695: ifne +15 -> 710
    //   698: new 267	java/io/File
    //   701: dup
    //   702: aload 12
    //   704: invokespecial 349	java/io/File:<init>	(Ljava/lang/String;)V
    //   707: invokestatic 721	com/tencent/smtt/utils/FileUtil:b	(Ljava/io/File;)V
    //   710: aload_2
    //   711: invokestatic 1031	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   714: ifne +14 -> 728
    //   717: new 267	java/io/File
    //   720: dup
    //   721: aload_2
    //   722: invokespecial 349	java/io/File:<init>	(Ljava/lang/String;)V
    //   725: invokestatic 721	com/tencent/smtt/utils/FileUtil:b	(Ljava/io/File;)V
    //   728: aload_1
    //   729: invokestatic 179	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   732: getfield 880	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   735: ldc_w 882
    //   738: iconst_1
    //   739: invokestatic 778	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   742: invokeinterface 888 3 0
    //   747: pop
    //   748: aload_1
    //   749: invokestatic 179	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   752: invokevirtual 892	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   755: aload_1
    //   756: invokestatic 239	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   759: sipush 224
    //   762: ldc_w 1444
    //   765: invokevirtual 246	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   768: getstatic 43	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   771: invokeinterface 512 1 0
    //   776: aload_0
    //   777: invokevirtual 514	com/tencent/smtt/sdk/p:b	()V
    //   780: iload 5
    //   782: iconst_5
    //   783: if_icmpne +10 -> 793
    //   786: aload_0
    //   787: aload_1
    //   788: iconst_2
    //   789: invokespecial 1423	com/tencent/smtt/sdk/p:h	(Landroid/content/Context;I)V
    //   792: return
    //   793: ldc 127
    //   795: ldc_w 1430
    //   798: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   801: iconst_0
    //   802: invokestatic 1183	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   805: return
    //   806: aload_1
    //   807: invokestatic 165	com/tencent/smtt/sdk/m:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/m;
    //   810: ldc_w 1248
    //   813: iload_3
    //   814: iconst_1
    //   815: iadd
    //   816: invokevirtual 173	com/tencent/smtt/sdk/m:a	(Ljava/lang/String;I)V
    //   819: aload_1
    //   820: invokestatic 740	com/tencent/smtt/sdk/p:t	(Landroid/content/Context;)Ljava/io/File;
    //   823: astore 11
    //   825: aload 11
    //   827: ifnull +286 -> 1113
    //   830: new 267	java/io/File
    //   833: dup
    //   834: aload 11
    //   836: ldc_w 742
    //   839: invokespecial 368	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   842: invokevirtual 583	java/io/File:exists	()Z
    //   845: ifeq +268 -> 1113
    //   848: aload_1
    //   849: invokestatic 179	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   852: sipush -550
    //   855: invokevirtual 457	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   858: aload_1
    //   859: aload_2
    //   860: invokestatic 997	com/tencent/smtt/sdk/QbSdk:a	(Landroid/content/Context;Landroid/os/Bundle;)Landroid/os/Bundle;
    //   863: astore 11
    //   865: aload 11
    //   867: ifnonnull +89 -> 956
    //   870: aload 11
    //   872: astore 12
    //   874: aload_1
    //   875: invokestatic 239	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   878: astore 13
    //   880: aload 11
    //   882: astore 12
    //   884: new 202	java/lang/StringBuilder
    //   887: dup
    //   888: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   891: astore 14
    //   893: aload 11
    //   895: astore 12
    //   897: aload 14
    //   899: ldc_w 1446
    //   902: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   905: pop
    //   906: aload 11
    //   908: astore 12
    //   910: aload 14
    //   912: aload_2
    //   913: ldc_w 1010
    //   916: invokevirtual 1003	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   919: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   922: pop
    //   923: aload 11
    //   925: astore 12
    //   927: aload 13
    //   929: sipush 228
    //   932: aload 14
    //   934: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   937: invokevirtual 246	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   940: iconst_1
    //   941: istore 4
    //   943: aload 11
    //   945: astore 12
    //   947: goto +172 -> 1119
    //   950: astore_2
    //   951: iconst_1
    //   952: istore_3
    //   953: goto +513 -> 1466
    //   956: aload 11
    //   958: ldc_w 1001
    //   961: invokevirtual 1003	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   964: istore_3
    //   965: aload 11
    //   967: astore 12
    //   969: iload_3
    //   970: istore 4
    //   972: iload_3
    //   973: ifeq +146 -> 1119
    //   976: aload 11
    //   978: astore 12
    //   980: iload_3
    //   981: istore 4
    //   983: aload_1
    //   984: invokestatic 239	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   987: astore 14
    //   989: aload 11
    //   991: astore 12
    //   993: iload_3
    //   994: istore 4
    //   996: new 202	java/lang/StringBuilder
    //   999: dup
    //   1000: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   1003: astore 13
    //   1005: aload 11
    //   1007: astore 12
    //   1009: iload_3
    //   1010: istore 4
    //   1012: aload 13
    //   1014: ldc_w 1448
    //   1017: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1020: pop
    //   1021: aload 11
    //   1023: astore 12
    //   1025: iload_3
    //   1026: istore 4
    //   1028: aload 13
    //   1030: iload_3
    //   1031: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1034: pop
    //   1035: aload 11
    //   1037: astore 12
    //   1039: iload_3
    //   1040: istore 4
    //   1042: aload 13
    //   1044: ldc_w 1450
    //   1047: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1050: pop
    //   1051: aload 11
    //   1053: astore 12
    //   1055: iload_3
    //   1056: istore 4
    //   1058: aload 13
    //   1060: aload_2
    //   1061: ldc_w 1010
    //   1064: invokevirtual 1003	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   1067: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1070: pop
    //   1071: aload 11
    //   1073: astore 12
    //   1075: iload_3
    //   1076: istore 4
    //   1078: aload 14
    //   1080: sipush 228
    //   1083: aload 13
    //   1085: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1088: invokevirtual 246	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1091: aload 11
    //   1093: astore 12
    //   1095: iload_3
    //   1096: istore 4
    //   1098: goto +21 -> 1119
    //   1101: astore_2
    //   1102: goto +364 -> 1466
    //   1105: astore_2
    //   1106: goto +349 -> 1455
    //   1109: astore_2
    //   1110: goto +354 -> 1464
    //   1113: aconst_null
    //   1114: astore 12
    //   1116: iconst_2
    //   1117: istore 4
    //   1119: getstatic 43	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   1122: invokeinterface 512 1 0
    //   1127: aload_0
    //   1128: invokevirtual 514	com/tencent/smtt/sdk/p:b	()V
    //   1131: iload 5
    //   1133: iconst_5
    //   1134: if_icmpne +11 -> 1145
    //   1137: aload_0
    //   1138: aload_1
    //   1139: iload 4
    //   1141: invokespecial 1423	com/tencent/smtt/sdk/p:h	(Landroid/content/Context;I)V
    //   1144: return
    //   1145: iload 4
    //   1147: ifne +102 -> 1249
    //   1150: ldc 127
    //   1152: ldc_w 1425
    //   1155: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1158: aload_1
    //   1159: invokestatic 165	com/tencent/smtt/sdk/m:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/m;
    //   1162: ldc_w 1248
    //   1165: iconst_0
    //   1166: invokevirtual 173	com/tencent/smtt/sdk/m:a	(Ljava/lang/String;I)V
    //   1169: aload_1
    //   1170: invokestatic 179	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1173: sipush -544
    //   1176: invokevirtual 457	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1179: aload_1
    //   1180: invokestatic 165	com/tencent/smtt/sdk/m:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/m;
    //   1183: iconst_0
    //   1184: iconst_m1
    //   1185: invokevirtual 329	com/tencent/smtt/sdk/m:c	(II)V
    //   1188: aload_1
    //   1189: invokestatic 165	com/tencent/smtt/sdk/m:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/m;
    //   1192: iconst_1
    //   1193: invokevirtual 332	com/tencent/smtt/sdk/m:c	(I)V
    //   1196: aload 12
    //   1198: ldc_w 1452
    //   1201: invokevirtual 1008	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1204: astore_2
    //   1205: new 267	java/io/File
    //   1208: dup
    //   1209: aload_2
    //   1210: invokespecial 349	java/io/File:<init>	(Ljava/lang/String;)V
    //   1213: aload_1
    //   1214: invokestatic 646	com/tencent/smtt/sdk/l:a	(Ljava/io/File;Landroid/content/Context;)V
    //   1217: aload_0
    //   1218: aload_1
    //   1219: aload_2
    //   1220: aload 12
    //   1222: ldc_w 1454
    //   1225: invokevirtual 1003	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   1228: invokespecial 708	com/tencent/smtt/sdk/p:b	(Landroid/content/Context;Ljava/lang/String;I)V
    //   1231: aload_1
    //   1232: invokestatic 544	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   1235: ifeq +28 -> 1263
    //   1238: aload_1
    //   1239: invokestatic 165	com/tencent/smtt/sdk/m:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/m;
    //   1242: iconst_m1
    //   1243: invokevirtual 332	com/tencent/smtt/sdk/m:c	(I)V
    //   1246: goto +17 -> 1263
    //   1249: iload 4
    //   1251: iconst_2
    //   1252: if_icmpne +14 -> 1266
    //   1255: ldc 127
    //   1257: ldc_w 1430
    //   1260: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1263: goto +141 -> 1404
    //   1266: aload_1
    //   1267: invokestatic 179	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1270: sipush -546
    //   1273: invokevirtual 457	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1276: ldc 127
    //   1278: ldc_w 1432
    //   1281: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1284: aload_1
    //   1285: invokestatic 179	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1288: getfield 880	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1291: ldc_w 882
    //   1294: iconst_1
    //   1295: invokestatic 778	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1298: invokeinterface 888 3 0
    //   1303: pop
    //   1304: aload_1
    //   1305: invokestatic 179	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1308: invokevirtual 892	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1311: aload_1
    //   1312: invokestatic 544	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   1315: ifeq +43 -> 1358
    //   1318: aload_1
    //   1319: invokestatic 239	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1322: astore_2
    //   1323: new 202	java/lang/StringBuilder
    //   1326: dup
    //   1327: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   1330: astore_1
    //   1331: aload_1
    //   1332: ldc_w 1434
    //   1335: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1338: pop
    //   1339: aload_1
    //   1340: iload 4
    //   1342: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1345: pop
    //   1346: aload_1
    //   1347: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1350: astore_1
    //   1351: sipush 235
    //   1354: istore_3
    //   1355: goto +40 -> 1395
    //   1358: aload_1
    //   1359: invokestatic 239	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1362: astore_2
    //   1363: new 202	java/lang/StringBuilder
    //   1366: dup
    //   1367: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   1370: astore_1
    //   1371: aload_1
    //   1372: ldc_w 1436
    //   1375: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1378: pop
    //   1379: aload_1
    //   1380: iload 4
    //   1382: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1385: pop
    //   1386: aload_1
    //   1387: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1390: astore_1
    //   1391: sipush 217
    //   1394: istore_3
    //   1395: aload_2
    //   1396: iload_3
    //   1397: aload_1
    //   1398: invokevirtual 246	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1401: goto -138 -> 1263
    //   1404: iconst_0
    //   1405: invokestatic 1183	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   1408: return
    //   1409: iconst_0
    //   1410: invokestatic 1183	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   1413: getstatic 43	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   1416: invokeinterface 512 1 0
    //   1421: aload_0
    //   1422: invokevirtual 514	com/tencent/smtt/sdk/p:b	()V
    //   1425: iload 5
    //   1427: iconst_5
    //   1428: if_icmpne +10 -> 1438
    //   1431: aload_0
    //   1432: aload_1
    //   1433: iconst_2
    //   1434: invokespecial 1423	com/tencent/smtt/sdk/p:h	(Landroid/content/Context;I)V
    //   1437: return
    //   1438: ldc 127
    //   1440: ldc_w 1430
    //   1443: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1446: iconst_0
    //   1447: invokestatic 1183	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   1450: return
    //   1451: astore_2
    //   1452: aconst_null
    //   1453: astore 11
    //   1455: iconst_2
    //   1456: istore_3
    //   1457: goto +299 -> 1756
    //   1460: astore_2
    //   1461: aconst_null
    //   1462: astore 11
    //   1464: iconst_2
    //   1465: istore_3
    //   1466: aload 11
    //   1468: astore 12
    //   1470: iload_3
    //   1471: istore 4
    //   1473: new 202	java/lang/StringBuilder
    //   1476: dup
    //   1477: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   1480: astore 13
    //   1482: aload 11
    //   1484: astore 12
    //   1486: iload_3
    //   1487: istore 4
    //   1489: aload 13
    //   1491: ldc_w 1456
    //   1494: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1497: pop
    //   1498: aload 11
    //   1500: astore 12
    //   1502: iload_3
    //   1503: istore 4
    //   1505: aload 13
    //   1507: aload_2
    //   1508: invokestatic 679	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1511: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1514: pop
    //   1515: aload 11
    //   1517: astore 12
    //   1519: iload_3
    //   1520: istore 4
    //   1522: ldc 127
    //   1524: aload 13
    //   1526: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1529: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1532: aload 11
    //   1534: astore 12
    //   1536: iload_3
    //   1537: istore 4
    //   1539: aload_2
    //   1540: invokevirtual 234	java/lang/Exception:printStackTrace	()V
    //   1543: aload 11
    //   1545: astore 12
    //   1547: aload_1
    //   1548: invokestatic 179	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1551: sipush -543
    //   1554: invokevirtual 457	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1557: aload 11
    //   1559: astore 12
    //   1561: aload_1
    //   1562: invokestatic 239	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1565: sipush 218
    //   1568: aload_2
    //   1569: invokevirtual 242	java/lang/Exception:toString	()Ljava/lang/String;
    //   1572: invokevirtual 246	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1575: getstatic 43	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   1578: invokeinterface 512 1 0
    //   1583: aload_0
    //   1584: invokevirtual 514	com/tencent/smtt/sdk/p:b	()V
    //   1587: iload 5
    //   1589: iconst_5
    //   1590: if_icmpne +10 -> 1600
    //   1593: aload_0
    //   1594: aload_1
    //   1595: iconst_1
    //   1596: invokespecial 1423	com/tencent/smtt/sdk/p:h	(Landroid/content/Context;I)V
    //   1599: return
    //   1600: aload_1
    //   1601: invokestatic 179	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1604: sipush -546
    //   1607: invokevirtual 457	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1610: ldc 127
    //   1612: ldc_w 1432
    //   1615: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1618: aload_1
    //   1619: invokestatic 179	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1622: getfield 880	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1625: ldc_w 882
    //   1628: iconst_1
    //   1629: invokestatic 778	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1632: invokeinterface 888 3 0
    //   1637: pop
    //   1638: aload_1
    //   1639: invokestatic 179	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1642: invokevirtual 892	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1645: aload_1
    //   1646: invokestatic 544	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   1649: ifeq +42 -> 1691
    //   1652: aload_1
    //   1653: invokestatic 239	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1656: astore_1
    //   1657: new 202	java/lang/StringBuilder
    //   1660: dup
    //   1661: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   1664: astore_2
    //   1665: aload_2
    //   1666: ldc_w 1434
    //   1669: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1672: pop
    //   1673: aload_2
    //   1674: iconst_1
    //   1675: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1678: pop
    //   1679: aload_2
    //   1680: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1683: astore_2
    //   1684: sipush 235
    //   1687: istore_3
    //   1688: goto +39 -> 1727
    //   1691: aload_1
    //   1692: invokestatic 239	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1695: astore_1
    //   1696: new 202	java/lang/StringBuilder
    //   1699: dup
    //   1700: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   1703: astore_2
    //   1704: aload_2
    //   1705: ldc_w 1436
    //   1708: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1711: pop
    //   1712: aload_2
    //   1713: iconst_1
    //   1714: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1717: pop
    //   1718: aload_2
    //   1719: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1722: astore_2
    //   1723: sipush 217
    //   1726: istore_3
    //   1727: aload_1
    //   1728: iload_3
    //   1729: aload_2
    //   1730: invokevirtual 246	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1733: iconst_0
    //   1734: invokestatic 1183	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   1737: return
    //   1738: astore_2
    //   1739: iconst_1
    //   1740: istore_3
    //   1741: aload 12
    //   1743: astore 11
    //   1745: goto +11 -> 1756
    //   1748: astore_2
    //   1749: iload 4
    //   1751: istore_3
    //   1752: aload 12
    //   1754: astore 11
    //   1756: getstatic 43	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   1759: invokeinterface 512 1 0
    //   1764: aload_0
    //   1765: invokevirtual 514	com/tencent/smtt/sdk/p:b	()V
    //   1768: iload 5
    //   1770: iconst_5
    //   1771: if_icmpne +10 -> 1781
    //   1774: aload_0
    //   1775: aload_1
    //   1776: iload_3
    //   1777: invokespecial 1423	com/tencent/smtt/sdk/p:h	(Landroid/content/Context;I)V
    //   1780: return
    //   1781: iload_3
    //   1782: ifne +105 -> 1887
    //   1785: ldc 127
    //   1787: ldc_w 1425
    //   1790: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1793: aload_1
    //   1794: invokestatic 165	com/tencent/smtt/sdk/m:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/m;
    //   1797: ldc_w 1248
    //   1800: iconst_0
    //   1801: invokevirtual 173	com/tencent/smtt/sdk/m:a	(Ljava/lang/String;I)V
    //   1804: aload_1
    //   1805: invokestatic 179	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1808: sipush -544
    //   1811: invokevirtual 457	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1814: aload_1
    //   1815: invokestatic 165	com/tencent/smtt/sdk/m:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/m;
    //   1818: iconst_0
    //   1819: iconst_m1
    //   1820: invokevirtual 329	com/tencent/smtt/sdk/m:c	(II)V
    //   1823: aload_1
    //   1824: invokestatic 165	com/tencent/smtt/sdk/m:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/m;
    //   1827: iconst_1
    //   1828: invokevirtual 332	com/tencent/smtt/sdk/m:c	(I)V
    //   1831: aload 11
    //   1833: ldc_w 1452
    //   1836: invokevirtual 1008	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1839: astore 12
    //   1841: new 267	java/io/File
    //   1844: dup
    //   1845: aload 12
    //   1847: invokespecial 349	java/io/File:<init>	(Ljava/lang/String;)V
    //   1850: aload_1
    //   1851: invokestatic 646	com/tencent/smtt/sdk/l:a	(Ljava/io/File;Landroid/content/Context;)V
    //   1854: aload_0
    //   1855: aload_1
    //   1856: aload 12
    //   1858: aload 11
    //   1860: ldc_w 1454
    //   1863: invokevirtual 1003	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   1866: invokespecial 708	com/tencent/smtt/sdk/p:b	(Landroid/content/Context;Ljava/lang/String;I)V
    //   1869: aload_1
    //   1870: invokestatic 544	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   1873: ifeq +174 -> 2047
    //   1876: aload_1
    //   1877: invokestatic 165	com/tencent/smtt/sdk/m:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/m;
    //   1880: iconst_m1
    //   1881: invokevirtual 332	com/tencent/smtt/sdk/m:c	(I)V
    //   1884: goto +163 -> 2047
    //   1887: iload_3
    //   1888: iconst_2
    //   1889: if_icmpeq +150 -> 2039
    //   1892: aload_1
    //   1893: invokestatic 179	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1896: sipush -546
    //   1899: invokevirtual 457	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1902: ldc 127
    //   1904: ldc_w 1432
    //   1907: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1910: aload_1
    //   1911: invokestatic 179	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1914: getfield 880	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1917: ldc_w 882
    //   1920: iconst_1
    //   1921: invokestatic 778	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1924: invokeinterface 888 3 0
    //   1929: pop
    //   1930: aload_1
    //   1931: invokestatic 179	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1934: invokevirtual 892	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1937: aload_1
    //   1938: invokestatic 544	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   1941: ifeq +47 -> 1988
    //   1944: aload_1
    //   1945: invokestatic 239	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1948: astore_1
    //   1949: new 202	java/lang/StringBuilder
    //   1952: dup
    //   1953: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   1956: astore 11
    //   1958: aload 11
    //   1960: ldc_w 1434
    //   1963: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1966: pop
    //   1967: aload 11
    //   1969: iload_3
    //   1970: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1973: pop
    //   1974: aload 11
    //   1976: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1979: astore 11
    //   1981: sipush 235
    //   1984: istore_3
    //   1985: goto +44 -> 2029
    //   1988: aload_1
    //   1989: invokestatic 239	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1992: astore_1
    //   1993: new 202	java/lang/StringBuilder
    //   1996: dup
    //   1997: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   2000: astore 11
    //   2002: aload 11
    //   2004: ldc_w 1436
    //   2007: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2010: pop
    //   2011: aload 11
    //   2013: iload_3
    //   2014: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2017: pop
    //   2018: aload 11
    //   2020: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2023: astore 11
    //   2025: sipush 217
    //   2028: istore_3
    //   2029: aload_1
    //   2030: iload_3
    //   2031: aload 11
    //   2033: invokevirtual 246	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   2036: goto +11 -> 2047
    //   2039: ldc 127
    //   2041: ldc_w 1430
    //   2044: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2047: iconst_0
    //   2048: invokestatic 1183	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   2051: aload_2
    //   2052: athrow
    //   2053: aload_1
    //   2054: invokestatic 179	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2057: sipush -547
    //   2060: invokevirtual 457	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   2063: aload_0
    //   2064: invokevirtual 514	com/tencent/smtt/sdk/p:b	()V
    //   2067: return
    //   2068: iload 5
    //   2070: iconst_1
    //   2071: if_icmpeq +23 -> 2094
    //   2074: iload 5
    //   2076: iconst_2
    //   2077: if_icmpeq +17 -> 2094
    //   2080: iload 5
    //   2082: iconst_4
    //   2083: if_icmpne +6 -> 2089
    //   2086: goto +8 -> 2094
    //   2089: iconst_0
    //   2090: istore_3
    //   2091: goto -1480 -> 611
    //   2094: iconst_1
    //   2095: istore_3
    //   2096: goto -1485 -> 611
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2099	0	this	p
    //   0	2099	1	paramContext	Context
    //   0	2099	2	paramBundle	Bundle
    //   288	1808	3	i1	int
    //   303	1447	4	i2	int
    //   270	1814	5	i3	int
    //   102	37	6	l1	long
    //   111	45	8	l2	long
    //   211	39	10	bool	boolean
    //   7	2025	11	localObject1	Object
    //   660	1197	12	localObject2	Object
    //   878	647	13	localObject3	Object
    //   891	188	14	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   294	318	321	finally
    //   294	318	328	java/lang/Exception
    //   282	289	575	finally
    //   282	289	582	java/lang/Exception
    //   874	880	950	java/lang/Exception
    //   884	893	950	java/lang/Exception
    //   897	906	950	java/lang/Exception
    //   910	923	950	java/lang/Exception
    //   927	940	950	java/lang/Exception
    //   983	989	1101	java/lang/Exception
    //   996	1005	1101	java/lang/Exception
    //   1012	1021	1101	java/lang/Exception
    //   1028	1035	1101	java/lang/Exception
    //   1042	1051	1101	java/lang/Exception
    //   1058	1071	1101	java/lang/Exception
    //   1078	1091	1101	java/lang/Exception
    //   956	965	1105	finally
    //   956	965	1109	java/lang/Exception
    //   272	276	1451	finally
    //   589	608	1451	finally
    //   620	631	1451	finally
    //   636	690	1451	finally
    //   690	710	1451	finally
    //   710	728	1451	finally
    //   728	768	1451	finally
    //   806	825	1451	finally
    //   830	865	1451	finally
    //   1409	1413	1451	finally
    //   272	276	1460	java/lang/Exception
    //   589	608	1460	java/lang/Exception
    //   620	631	1460	java/lang/Exception
    //   636	690	1460	java/lang/Exception
    //   690	710	1460	java/lang/Exception
    //   710	728	1460	java/lang/Exception
    //   728	768	1460	java/lang/Exception
    //   806	825	1460	java/lang/Exception
    //   830	865	1460	java/lang/Exception
    //   1409	1413	1460	java/lang/Exception
    //   874	880	1738	finally
    //   884	893	1738	finally
    //   897	906	1738	finally
    //   910	923	1738	finally
    //   927	940	1738	finally
    //   1547	1557	1738	finally
    //   1561	1575	1738	finally
    //   983	989	1748	finally
    //   996	1005	1748	finally
    //   1012	1021	1748	finally
    //   1028	1035	1748	finally
    //   1042	1051	1748	finally
    //   1058	1071	1748	finally
    //   1078	1091	1748	finally
    //   1473	1482	1748	finally
    //   1489	1498	1748	finally
    //   1505	1515	1748	finally
    //   1522	1532	1748	finally
    //   1539	1543	1748	finally
  }
  
  void b(Context paramContext, boolean paramBoolean)
  {
    if (QbSdk.b) {
      return;
    }
    if (Build.VERSION.SDK_INT < 8)
    {
      TbsLog.e("TbsInstaller", "android version < 2.1 no need install X5 core", true);
      return;
    }
    TbsLog.i("TbsInstaller", "Tbsinstaller installTbsCoreIfNeeded #1 ");
    if ((TbsShareManager.isThirdPartyApp(paramContext)) && (m.a(paramContext).b("remove_old_core") == 1) && (paramBoolean))
    {
      File localFile = a().r(paramContext);
      try
      {
        FileUtil.b(localFile);
        TbsLog.i("TbsInstaller", "thirdAPP success--> delete old core_share Directory");
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
      m.a(paramContext).a("remove_old_core", 0);
    }
    if (!w(paramContext)) {
      return;
    }
    TbsLog.i("TbsInstaller", "Tbsinstaller installTbsCoreIfNeeded #2 ");
    if ((a(paramContext, "core_unzip_tmp")) && (e(paramContext, paramBoolean))) {
      paramContext = "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromUnzip!!";
    }
    for (;;)
    {
      TbsLog.i("TbsInstaller", paramContext, true);
      return;
      if ((a(paramContext, "core_share_backup_tmp")) && (f(paramContext, paramBoolean)))
      {
        paramContext = "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromBackup!!";
      }
      else if ((a(paramContext, "core_copy_tmp")) && (d(paramContext, paramBoolean)))
      {
        paramContext = "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromCopy!!";
      }
      else
      {
        if ((!a(paramContext, "tpatch_tmp")) || (!c(paramContext, paramBoolean))) {
          break;
        }
        paramContext = "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromTpatch!!";
      }
    }
    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, error !!", true);
  }
  
  boolean b(Context paramContext, int paramInt)
  {
    if (TbsDownloader.getOverSea(paramContext)) {
      return false;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TbsInstaller-installLocalTbsCore targetTbsCoreVer=");
    ((StringBuilder)localObject).append(paramInt);
    TbsLog.i("TbsInstaller", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TbsInstaller-continueInstallTbsCore currentProcessName=");
    ((StringBuilder)localObject).append(paramContext.getApplicationInfo().processName);
    TbsLog.i("TbsInstaller", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TbsInstaller-installLocalTbsCore currentProcessId=");
    ((StringBuilder)localObject).append(android.os.Process.myPid());
    TbsLog.i("TbsInstaller", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("TbsInstaller-installLocalTbsCore currentThreadName=");
    ((StringBuilder)localObject).append(Thread.currentThread().getName());
    TbsLog.i("TbsInstaller", ((StringBuilder)localObject).toString());
    localObject = d(paramContext, paramInt);
    if (localObject != null)
    {
      Message localMessage = new Message();
      localMessage.what = 2;
      localMessage.obj = new Object[] { localObject, paramContext, Integer.valueOf(paramInt) };
      m.sendMessage(localMessage);
      return true;
    }
    TbsLog.i("TbsInstaller", "TbsInstaller--installLocalTbsCore copy from null");
    return false;
  }
  
  int c(Context paramContext, String paramString)
  {
    paramContext = paramContext.getPackageManager().getPackageArchiveInfo(paramString, 0);
    if (paramContext != null) {
      return paramContext.versionCode;
    }
    return 0;
  }
  
  public void c(Context paramContext)
  {
    g(paramContext, true);
    m.a(paramContext).c(i(paramContext), 2);
  }
  
  void c(Context paramContext, int paramInt)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreForThirdPartyApp");
    if (paramInt <= 0) {
      return;
    }
    int i1 = j(paramContext);
    if (i1 == paramInt) {
      return;
    }
    Context localContext = TbsShareManager.e(paramContext);
    if ((localContext == null) && (TbsShareManager.getHostCorePathAppDefined() == null))
    {
      if (i1 <= 0)
      {
        TbsLog.i("TbsInstaller", "TbsInstaller--installTbsCoreForThirdPartyApp hostContext == null");
        QbSdk.a(paramContext, "TbsInstaller::installTbsCoreForThirdPartyApp forceSysWebViewInner #2");
      }
    }
    else
    {
      TbsLog.i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp hostContext != null");
      a(paramContext, localContext);
    }
  }
  
  public Context d(Context paramContext, int paramInt)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("TbsInstaller--getTbsCoreHostContext tbsCoreTargetVer=");
    ((StringBuilder)localObject1).append(paramInt);
    TbsLog.i("TbsInstaller", ((StringBuilder)localObject1).toString());
    if (paramInt <= 0) {
      return null;
    }
    localObject1 = TbsShareManager.getCoreProviderAppList();
    int i1 = 0;
    while (i1 < localObject1.length)
    {
      if ((!paramContext.getPackageName().equalsIgnoreCase(localObject1[i1])) && (e(paramContext, localObject1[i1])))
      {
        Object localObject2 = b(paramContext, localObject1[i1]);
        if (localObject2 != null) {
          if (!g((Context)localObject2))
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("TbsInstaller--getTbsCoreHostContext ");
            ((StringBuilder)localObject2).append(localObject1[i1]);
            ((StringBuilder)localObject2).append(" illegal signature go on next");
            TbsLog.e("TbsInstaller", ((StringBuilder)localObject2).toString());
          }
          else
          {
            int i2 = j((Context)localObject2);
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("TbsInstaller-getTbsCoreHostContext hostTbsCoreVer=");
            localStringBuilder.append(i2);
            TbsLog.i("TbsInstaller", localStringBuilder.toString());
            if ((i2 != 0) && (i2 == paramInt))
            {
              paramContext = new StringBuilder();
              paramContext.append("TbsInstaller-getTbsCoreHostContext targetApp=");
              paramContext.append(localObject1[i1]);
              TbsLog.i("TbsInstaller", paramContext.toString());
              return localObject2;
            }
          }
        }
      }
      i1 += 1;
    }
    return null;
  }
  
  /* Error */
  public String d(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokestatic 1031	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: istore_3
    //   5: aconst_null
    //   6: astore 4
    //   8: iload_3
    //   9: ifeq +5 -> 14
    //   12: aconst_null
    //   13: areturn
    //   14: new 267	java/io/File
    //   17: dup
    //   18: aload_0
    //   19: aload_1
    //   20: invokevirtual 254	com/tencent/smtt/sdk/p:r	(Landroid/content/Context;)Ljava/io/File;
    //   23: ldc_w 373
    //   26: invokespecial 368	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   29: astore_1
    //   30: aload_1
    //   31: invokevirtual 583	java/io/File:exists	()Z
    //   34: ifne +5 -> 39
    //   37: aconst_null
    //   38: areturn
    //   39: new 375	java/util/Properties
    //   42: dup
    //   43: invokespecial 376	java/util/Properties:<init>	()V
    //   46: astore 5
    //   48: new 378	java/io/BufferedInputStream
    //   51: dup
    //   52: new 380	java/io/FileInputStream
    //   55: dup
    //   56: aload_1
    //   57: invokespecial 383	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   60: invokespecial 386	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   63: astore_1
    //   64: aload 5
    //   66: aload_1
    //   67: invokevirtual 389	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   70: aload_1
    //   71: invokevirtual 416	java/io/BufferedInputStream:close	()V
    //   74: aload 5
    //   76: aload_2
    //   77: invokevirtual 1268	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   80: astore_2
    //   81: aload_1
    //   82: invokevirtual 416	java/io/BufferedInputStream:close	()V
    //   85: aload_2
    //   86: areturn
    //   87: astore 4
    //   89: aload_1
    //   90: astore_2
    //   91: aload 4
    //   93: astore_1
    //   94: goto +10 -> 104
    //   97: goto +19 -> 116
    //   100: astore_1
    //   101: aload 4
    //   103: astore_2
    //   104: aload_2
    //   105: ifnull +7 -> 112
    //   108: aload_2
    //   109: invokevirtual 416	java/io/BufferedInputStream:close	()V
    //   112: aload_1
    //   113: athrow
    //   114: aconst_null
    //   115: astore_1
    //   116: aload_1
    //   117: ifnull +7 -> 124
    //   120: aload_1
    //   121: invokevirtual 416	java/io/BufferedInputStream:close	()V
    //   124: aconst_null
    //   125: areturn
    //   126: astore_1
    //   127: goto -13 -> 114
    //   130: astore_2
    //   131: goto -34 -> 97
    //   134: astore_1
    //   135: aload_2
    //   136: areturn
    //   137: astore_2
    //   138: goto -26 -> 112
    //   141: astore_1
    //   142: aconst_null
    //   143: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	this	p
    //   0	144	1	paramContext	Context
    //   0	144	2	paramString	String
    //   4	5	3	bool	boolean
    //   6	1	4	localObject1	Object
    //   87	15	4	localObject2	Object
    //   46	29	5	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   64	81	87	finally
    //   14	37	100	finally
    //   39	64	100	finally
    //   14	37	126	java/lang/Exception
    //   39	64	126	java/lang/Exception
    //   64	81	130	java/lang/Exception
    //   81	85	134	java/io/IOException
    //   108	112	137	java/io/IOException
    //   120	124	141	java/io/IOException
  }
  
  /* Error */
  boolean d(Context paramContext)
  {
    // Byte code:
    //   0: new 267	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: aload_1
    //   6: invokevirtual 254	com/tencent/smtt/sdk/p:r	(Landroid/content/Context;)Ljava/io/File;
    //   9: ldc_w 373
    //   12: invokespecial 368	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   15: astore 7
    //   17: aload 7
    //   19: invokevirtual 583	java/io/File:exists	()Z
    //   22: istore_2
    //   23: iconst_0
    //   24: istore_3
    //   25: iload_2
    //   26: ifne +5 -> 31
    //   29: iconst_0
    //   30: ireturn
    //   31: new 375	java/util/Properties
    //   34: dup
    //   35: invokespecial 376	java/util/Properties:<init>	()V
    //   38: astore 8
    //   40: aconst_null
    //   41: astore 6
    //   43: aconst_null
    //   44: astore 5
    //   46: new 378	java/io/BufferedInputStream
    //   49: dup
    //   50: new 380	java/io/FileInputStream
    //   53: dup
    //   54: aload 7
    //   56: invokespecial 383	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   59: invokespecial 386	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   62: astore_1
    //   63: aload 8
    //   65: aload_1
    //   66: invokevirtual 389	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   69: aload 8
    //   71: ldc_w 399
    //   74: ldc_w 1541
    //   77: invokevirtual 612	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   80: invokestatic 1544	java/lang/Boolean:valueOf	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   83: invokevirtual 909	java/lang/Boolean:booleanValue	()Z
    //   86: istore 4
    //   88: iload_3
    //   89: istore_2
    //   90: iload 4
    //   92: ifeq +23 -> 115
    //   95: iload_3
    //   96: istore_2
    //   97: invokestatic 563	java/lang/System:currentTimeMillis	()J
    //   100: aload 7
    //   102: invokevirtual 1547	java/io/File:lastModified	()J
    //   105: lsub
    //   106: ldc2_w 1548
    //   109: lcmp
    //   110: ifle +5 -> 115
    //   113: iconst_1
    //   114: istore_2
    //   115: new 202	java/lang/StringBuilder
    //   118: dup
    //   119: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   122: astore 5
    //   124: aload 5
    //   126: ldc_w 1551
    //   129: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: aload 5
    //   135: iload 4
    //   137: invokevirtual 276	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: aload 5
    //   143: ldc_w 1553
    //   146: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: pop
    //   150: aload 5
    //   152: iload_2
    //   153: invokevirtual 276	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: ldc 127
    //   159: aload 5
    //   161: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   167: iload 4
    //   169: iload_2
    //   170: iconst_1
    //   171: ixor
    //   172: iand
    //   173: istore_2
    //   174: iload_2
    //   175: istore_3
    //   176: aload_1
    //   177: invokevirtual 416	java/io/BufferedInputStream:close	()V
    //   180: iload_2
    //   181: ireturn
    //   182: astore_1
    //   183: aload_1
    //   184: invokevirtual 415	java/io/IOException:printStackTrace	()V
    //   187: iload_3
    //   188: ireturn
    //   189: astore 5
    //   191: aload_1
    //   192: astore 6
    //   194: aload 5
    //   196: astore_1
    //   197: iload 4
    //   199: istore_2
    //   200: goto +34 -> 234
    //   203: astore 5
    //   205: goto +51 -> 256
    //   208: astore 5
    //   210: aload_1
    //   211: astore 6
    //   213: aload 5
    //   215: astore_1
    //   216: goto +16 -> 232
    //   219: astore 6
    //   221: aload 5
    //   223: astore_1
    //   224: aload 6
    //   226: astore 5
    //   228: goto +28 -> 256
    //   231: astore_1
    //   232: iconst_0
    //   233: istore_2
    //   234: aload 6
    //   236: astore 5
    //   238: aload_1
    //   239: invokevirtual 417	java/lang/Throwable:printStackTrace	()V
    //   242: aload 6
    //   244: ifnull +10 -> 254
    //   247: iload_2
    //   248: istore_3
    //   249: aload 6
    //   251: invokevirtual 416	java/io/BufferedInputStream:close	()V
    //   254: iload_2
    //   255: ireturn
    //   256: aload_1
    //   257: ifnull +15 -> 272
    //   260: aload_1
    //   261: invokevirtual 416	java/io/BufferedInputStream:close	()V
    //   264: goto +8 -> 272
    //   267: astore_1
    //   268: aload_1
    //   269: invokevirtual 415	java/io/IOException:printStackTrace	()V
    //   272: aload 5
    //   274: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	275	0	this	p
    //   0	275	1	paramContext	Context
    //   22	233	2	bool1	boolean
    //   24	225	3	bool2	boolean
    //   86	112	4	bool3	boolean
    //   44	116	5	localStringBuilder	StringBuilder
    //   189	6	5	localThrowable1	Throwable
    //   203	1	5	localObject1	Object
    //   208	14	5	localThrowable2	Throwable
    //   226	47	5	localObject2	Object
    //   41	171	6	localContext	Context
    //   219	31	6	localObject3	Object
    //   15	86	7	localFile	File
    //   38	32	8	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   176	180	182	java/io/IOException
    //   249	254	182	java/io/IOException
    //   97	113	189	java/lang/Throwable
    //   115	167	189	java/lang/Throwable
    //   63	88	203	finally
    //   97	113	203	finally
    //   115	167	203	finally
    //   63	88	208	java/lang/Throwable
    //   46	63	219	finally
    //   238	242	219	finally
    //   46	63	231	java/lang/Throwable
    //   260	264	267	java/io/IOException
  }
  
  int e(Context paramContext, int paramInt)
  {
    return a(f(paramContext, paramInt));
  }
  
  /* Error */
  public void e(Context paramContext)
  {
    // Byte code:
    //   0: new 267	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: aload_1
    //   6: invokevirtual 254	com/tencent/smtt/sdk/p:r	(Landroid/content/Context;)Ljava/io/File;
    //   9: ldc_w 373
    //   12: invokespecial 368	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   15: astore_2
    //   16: new 375	java/util/Properties
    //   19: dup
    //   20: invokespecial 376	java/util/Properties:<init>	()V
    //   23: astore 5
    //   25: aconst_null
    //   26: astore 4
    //   28: aconst_null
    //   29: astore_3
    //   30: new 378	java/io/BufferedInputStream
    //   33: dup
    //   34: new 380	java/io/FileInputStream
    //   37: dup
    //   38: aload_2
    //   39: invokespecial 383	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   42: invokespecial 386	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   45: astore_1
    //   46: aload 5
    //   48: aload_1
    //   49: invokevirtual 389	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   52: new 391	java/io/BufferedOutputStream
    //   55: dup
    //   56: new 393	java/io/FileOutputStream
    //   59: dup
    //   60: aload_2
    //   61: invokespecial 394	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   64: invokespecial 397	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   67: astore_2
    //   68: aload 5
    //   70: ldc_w 399
    //   73: ldc_w 1541
    //   76: invokevirtual 405	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   79: pop
    //   80: aload 5
    //   82: aload_2
    //   83: aconst_null
    //   84: invokevirtual 409	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   87: aload_2
    //   88: invokevirtual 414	java/io/BufferedOutputStream:close	()V
    //   91: aload_1
    //   92: invokevirtual 416	java/io/BufferedInputStream:close	()V
    //   95: return
    //   96: astore 4
    //   98: aload_2
    //   99: astore_3
    //   100: aload_1
    //   101: astore_2
    //   102: aload 4
    //   104: astore_1
    //   105: goto +25 -> 130
    //   108: goto +48 -> 156
    //   111: astore 4
    //   113: aload_1
    //   114: astore_2
    //   115: aload 4
    //   117: astore_1
    //   118: goto +12 -> 130
    //   121: aload 4
    //   123: astore_2
    //   124: goto +32 -> 156
    //   127: astore_1
    //   128: aconst_null
    //   129: astore_2
    //   130: aload_3
    //   131: ifnull +10 -> 141
    //   134: aload_3
    //   135: invokevirtual 414	java/io/BufferedOutputStream:close	()V
    //   138: goto +3 -> 141
    //   141: aload_2
    //   142: ifnull +7 -> 149
    //   145: aload_2
    //   146: invokevirtual 416	java/io/BufferedInputStream:close	()V
    //   149: aload_1
    //   150: athrow
    //   151: aconst_null
    //   152: astore_1
    //   153: aload 4
    //   155: astore_2
    //   156: aload_2
    //   157: ifnull +10 -> 167
    //   160: aload_2
    //   161: invokevirtual 414	java/io/BufferedOutputStream:close	()V
    //   164: goto +3 -> 167
    //   167: aload_1
    //   168: ifnull +6 -> 174
    //   171: goto -80 -> 91
    //   174: return
    //   175: astore_1
    //   176: return
    //   177: astore_1
    //   178: goto -27 -> 151
    //   181: astore_2
    //   182: goto -61 -> 121
    //   185: astore_3
    //   186: goto -78 -> 108
    //   189: astore_2
    //   190: goto -99 -> 91
    //   193: astore_3
    //   194: goto -53 -> 141
    //   197: astore_2
    //   198: goto -49 -> 149
    //   201: astore_2
    //   202: goto -35 -> 167
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	205	0	this	p
    //   0	205	1	paramContext	Context
    //   15	146	2	localObject1	Object
    //   181	1	2	localThrowable1	Throwable
    //   189	1	2	localIOException1	java.io.IOException
    //   197	1	2	localIOException2	java.io.IOException
    //   201	1	2	localIOException3	java.io.IOException
    //   29	106	3	localObject2	Object
    //   185	1	3	localThrowable2	Throwable
    //   193	1	3	localIOException4	java.io.IOException
    //   26	1	4	localObject3	Object
    //   96	7	4	localObject4	Object
    //   111	43	4	localObject5	Object
    //   23	58	5	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   68	87	96	finally
    //   46	68	111	finally
    //   30	46	127	finally
    //   0	25	175	java/lang/Throwable
    //   87	91	175	java/lang/Throwable
    //   91	95	175	java/io/IOException
    //   91	95	175	java/lang/Throwable
    //   134	138	175	java/lang/Throwable
    //   145	149	175	java/lang/Throwable
    //   149	151	175	java/lang/Throwable
    //   160	164	175	java/lang/Throwable
    //   30	46	177	java/lang/Throwable
    //   46	68	181	java/lang/Throwable
    //   68	87	185	java/lang/Throwable
    //   87	91	189	java/io/IOException
    //   134	138	193	java/io/IOException
    //   145	149	197	java/io/IOException
    //   160	164	201	java/io/IOException
  }
  
  File f(Context paramContext, int paramInt)
  {
    return a(paramContext, paramInt, true);
  }
  
  public boolean f(Context paramContext)
  {
    for (;;)
    {
      int i1;
      try
      {
        Object localObject = new File(FileUtil.a(paramContext, 4), TbsDownloader.getBackupFileName(true));
        File localFile1 = a().f(paramContext, 2);
        FileUtil.a(localFile1);
        FileUtil.a(localFile1, true);
        FileUtil.a((File)localObject, localFile1);
        localObject = localFile1.list();
        i1 = 0;
        if (i1 < localObject.length)
        {
          File localFile2 = new File(localFile1, localObject[i1]);
          if (localFile2.getName().endsWith(".dex")) {
            localFile2.delete();
          }
        }
        else
        {
          i(paramContext, 2);
          return true;
        }
      }
      catch (Exception paramContext)
      {
        return false;
      }
      i1 += 1;
    }
  }
  
  boolean g(Context paramContext)
  {
    if (TbsShareManager.getHostCorePathAppDefined() != null) {
      return true;
    }
    try
    {
      Signature localSignature = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 64).signatures[0];
      boolean bool = paramContext.getPackageName().equals("com.tencent.mtt");
      if (bool)
      {
        if (!localSignature.toCharsString().equals("3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a")) {
          return false;
        }
      }
      else if (paramContext.getPackageName().equals("com.tencent.mm"))
      {
        if (!localSignature.toCharsString().equals("308202eb30820254a00302010202044d36f7a4300d06092a864886f70d01010505003081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e74301e170d3131303131393134333933325a170d3431303131313134333933325a3081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e7430819f300d06092a864886f70d010101050003818d0030818902818100c05f34b231b083fb1323670bfbe7bdab40c0c0a6efc87ef2072a1ff0d60cc67c8edb0d0847f210bea6cbfaa241be70c86daf56be08b723c859e52428a064555d80db448cdcacc1aea2501eba06f8bad12a4fa49d85cacd7abeb68945a5cb5e061629b52e3254c373550ee4e40cb7c8ae6f7a8151ccd8df582d446f39ae0c5e930203010001300d06092a864886f70d0101050500038181009c8d9d7f2f908c42081b4c764c377109a8b2c70582422125ce545842d5f520aea69550b6bd8bfd94e987b75a3077eb04ad341f481aac266e89d3864456e69fba13df018acdc168b9a19dfd7ad9d9cc6f6ace57c746515f71234df3a053e33ba93ece5cd0fc15f3e389a3f365588a9fcb439e069d3629cd7732a13fff7b891499")) {
          return false;
        }
      }
      else if (paramContext.getPackageName().equals("com.tencent.mobileqq"))
      {
        if (!localSignature.toCharsString().equals("30820253308201bca00302010202044bbb0361300d06092a864886f70d0101050500306d310e300c060355040613054368696e61310f300d06035504080c06e58c97e4baac310f300d06035504070c06e58c97e4baac310f300d060355040a0c06e885bee8aeaf311b3019060355040b0c12e697a0e7babfe4b89ae58aa1e7b3bbe7bb9f310b30090603550403130251513020170d3130303430363039343831375a180f32323834303132303039343831375a306d310e300c060355040613054368696e61310f300d06035504080c06e58c97e4baac310f300d06035504070c06e58c97e4baac310f300d060355040a0c06e885bee8aeaf311b3019060355040b0c12e697a0e7babfe4b89ae58aa1e7b3bbe7bb9f310b300906035504031302515130819f300d06092a864886f70d010101050003818d0030818902818100a15e9756216f694c5915e0b529095254367c4e64faeff07ae13488d946615a58ddc31a415f717d019edc6d30b9603d3e2a7b3de0ab7e0cf52dfee39373bc472fa997027d798d59f81d525a69ecf156e885fd1e2790924386b2230cc90e3b7adc95603ddcf4c40bdc72f22db0f216a99c371d3bf89cba6578c60699e8a0d536950203010001300d06092a864886f70d01010505000381810094a9b80e80691645dd42d6611775a855f71bcd4d77cb60a8e29404035a5e00b21bcc5d4a562482126bd91b6b0e50709377ceb9ef8c2efd12cc8b16afd9a159f350bb270b14204ff065d843832720702e28b41491fbc3a205f5f2f42526d67f17614d8a974de6487b2c866efede3b4e49a0f916baa3c1336fd2ee1b1629652049")) {
          return false;
        }
      }
      else if (paramContext.getPackageName().equals("com.tencent.tbs"))
      {
        if (!localSignature.toCharsString().equals("3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a")) {
          return false;
        }
      }
      else if (paramContext.getPackageName().equals("com.qzone"))
      {
        if (!localSignature.toCharsString().equals("308202ad30820216a00302010202044c26cea2300d06092a864886f70d010105050030819a310b3009060355040613023836311530130603550408130c4265696a696e672043697479311530130603550407130c4265696a696e67204369747931263024060355040a131d515a6f6e65205465616d206f662054656e63656e7420436f6d70616e7931183016060355040b130f54656e63656e7420436f6d70616e79311b301906035504031312416e64726f696420515a6f6e65205465616d301e170d3130303632373034303830325a170d3335303632313034303830325a30819a310b3009060355040613023836311530130603550408130c4265696a696e672043697479311530130603550407130c4265696a696e67204369747931263024060355040a131d515a6f6e65205465616d206f662054656e63656e7420436f6d70616e7931183016060355040b130f54656e63656e7420436f6d70616e79311b301906035504031312416e64726f696420515a6f6e65205465616d30819f300d06092a864886f70d010101050003818d003081890281810082d6aca037a9843fbbe88b6dd19f36e9c24ce174c1b398f3a529e2a7fe02de99c27539602c026edf96ad8d43df32a85458bca1e6fbf11958658a7d6751a1d9b782bf43a8c19bd1c06bdbfd94c0516326ae3cf638ac42bb470580e340c46e6f306a772c1ef98f10a559edf867f3f31fe492808776b7bd953b2cba2d2b2d66a44f0203010001300d06092a864886f70d0101050500038181006003b04a8a8c5be9650f350cda6896e57dd13e6e83e7f891fc70f6a3c2eaf75cfa4fc998365deabbd1b9092159edf4b90df5702a0d101f8840b5d4586eb92a1c3cd19d95fbc1c2ac956309eda8eef3944baf08c4a49d3b9b3ffb06bc13dab94ecb5b8eb74e8789aa0ba21cb567f538bbc59c2a11e6919924a24272eb79251677")) {
          return false;
        }
      }
      else if (paramContext.getPackageName().equals("com.tencent.qqpimsecure"))
      {
        bool = localSignature.toCharsString().equals("30820239308201a2a00302010202044c96f48f300d06092a864886f70d01010505003060310b300906035504061302434e310b300906035504081302474431123010060355040713094775616e677a686f753110300e060355040a130754656e63656e74310b3009060355040b130233473111300f0603550403130857696c736f6e57753020170d3130303932303035343334335a180f32303635303632333035343334335a3060310b300906035504061302434e310b300906035504081302474431123010060355040713094775616e677a686f753110300e060355040a130754656e63656e74310b3009060355040b130233473111300f0603550403130857696c736f6e577530819f300d06092a864886f70d010101050003818d0030818902818100b56e79dbb1185a79e52d792bb3d0bb3da8010d9b87da92ec69f7dc5ad66ab6bfdff2a6a1ed285dd2358f28b72a468be7c10a2ce30c4c27323ed4edcc936080e5bedc2cbbca0b7e879c08a631182793f44bb3ea284179b263410c298e5f6831032c9702ba4a74e2ccfc9ef857f12201451602fc8e774ac59d6398511586c83d1d0203010001300d06092a864886f70d0101050500038181002475615bb65b8d8786b890535802948840387d06b1692ff3ea47ef4c435719ba1865b81e6bfa6293ce31747c3cd6b34595b485cc1563fd90107ba5845c28b95c79138f0dec288940395bc10f92f2b69d8dc410999deb38900974ce9984b678030edfba8816582f56160d87e38641288d8588d2a31e20b89f223d788dd35cc9c8");
        if (!bool) {
          return false;
        }
      }
      return true;
    }
    catch (Exception paramContext)
    {
      label201:
      break label201;
    }
    TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore getPackageInfo fail");
    return false;
  }
  
  boolean g(Context paramContext, int paramInt)
  {
    for (;;)
    {
      try
      {
        boolean bool = TbsShareManager.isThirdPartyApp(paramContext);
        File localFile;
        Object localObject;
        if (bool)
        {
          if (TbsShareManager.j(paramContext))
          {
            localFile = new File(TbsShareManager.c(paramContext));
            localObject = localFile;
            if (localFile.getAbsolutePath().contains("com.tencent.tbs")) {
              return true;
            }
          }
          else
          {
            TbsLog.e("TbsInstaller", "321");
            return false;
          }
        }
        else {
          localObject = r(paramContext);
        }
        int i1;
        if (localObject != null)
        {
          Long[][] arrayOfLong = n;
          int i2 = arrayOfLong.length;
          i1 = 0;
          if (i1 >= i2) {
            break;
          }
          localFile = arrayOfLong[i1];
          if (paramInt == localFile[0].intValue())
          {
            localObject = new File((File)localObject, "libmttwebview.so");
            if ((((File)localObject).exists()) && (((File)localObject).length() == localFile[1].longValue()))
            {
              paramContext = new StringBuilder();
              paramContext.append("check so success: ");
              paramContext.append(paramInt);
              paramContext.append("; file: ");
              paramContext.append(localObject);
              TbsLog.d("TbsInstaller", paramContext.toString());
              break;
            }
            if (!bool) {
              FileUtil.b(QbSdk.getTbsFolderDir(paramContext));
            }
            a.set(Integer.valueOf(0));
            paramContext = "322";
            TbsLog.e("TbsInstaller", paramContext);
            return false;
          }
        }
        else
        {
          paramContext = "323";
          continue;
        }
        i1 += 1;
      }
      catch (Throwable paramContext)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("ISTBSCORELEGAL exception getMessage is ");
        ((StringBuilder)localObject).append(paramContext.getMessage());
        TbsLog.e("TbsInstaller", ((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("ISTBSCORELEGAL exception getCause is ");
        ((StringBuilder)localObject).append(paramContext.getCause());
        TbsLog.e("TbsInstaller", ((StringBuilder)localObject).toString());
        return false;
      }
    }
    return true;
  }
  
  public void h(Context paramContext)
  {
    FileLock localFileLock = l;
    if (localFileLock != null) {
      FileUtil.a(paramContext, localFileLock);
    }
  }
  
  /* Error */
  int i(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: new 267	java/io/File
    //   8: dup
    //   9: aload_0
    //   10: aload_1
    //   11: invokevirtual 553	com/tencent/smtt/sdk/p:q	(Landroid/content/Context;)Ljava/io/File;
    //   14: ldc_w 373
    //   17: invokespecial 368	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   20: astore_1
    //   21: aload_1
    //   22: invokevirtual 583	java/io/File:exists	()Z
    //   25: ifne +5 -> 30
    //   28: iconst_0
    //   29: ireturn
    //   30: new 375	java/util/Properties
    //   33: dup
    //   34: invokespecial 376	java/util/Properties:<init>	()V
    //   37: astore 5
    //   39: new 378	java/io/BufferedInputStream
    //   42: dup
    //   43: new 380	java/io/FileInputStream
    //   46: dup
    //   47: aload_1
    //   48: invokespecial 383	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   51: invokespecial 386	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   54: astore_1
    //   55: aload 5
    //   57: aload_1
    //   58: invokevirtual 389	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   61: aload_1
    //   62: invokevirtual 416	java/io/BufferedInputStream:close	()V
    //   65: aload 5
    //   67: ldc_w 1267
    //   70: invokevirtual 1268	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   73: astore_3
    //   74: aload_3
    //   75: ifnonnull +9 -> 84
    //   78: aload_1
    //   79: invokevirtual 416	java/io/BufferedInputStream:close	()V
    //   82: iconst_0
    //   83: ireturn
    //   84: aload_3
    //   85: invokestatic 1271	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   88: istore_2
    //   89: aload_1
    //   90: invokevirtual 416	java/io/BufferedInputStream:close	()V
    //   93: iload_2
    //   94: ireturn
    //   95: astore 4
    //   97: aload_1
    //   98: astore_3
    //   99: aload 4
    //   101: astore_1
    //   102: goto +7 -> 109
    //   105: goto +14 -> 119
    //   108: astore_1
    //   109: aload_3
    //   110: ifnull +7 -> 117
    //   113: aload_3
    //   114: invokevirtual 416	java/io/BufferedInputStream:close	()V
    //   117: aload_1
    //   118: athrow
    //   119: aload_1
    //   120: ifnull +7 -> 127
    //   123: aload_1
    //   124: invokevirtual 416	java/io/BufferedInputStream:close	()V
    //   127: iconst_0
    //   128: ireturn
    //   129: astore_1
    //   130: aload 4
    //   132: astore_1
    //   133: goto -14 -> 119
    //   136: astore_3
    //   137: goto -32 -> 105
    //   140: astore_1
    //   141: iconst_0
    //   142: ireturn
    //   143: astore_1
    //   144: iload_2
    //   145: ireturn
    //   146: astore_3
    //   147: goto -30 -> 117
    //   150: astore_1
    //   151: iconst_0
    //   152: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	this	p
    //   0	153	1	paramContext	Context
    //   88	57	2	i1	int
    //   4	110	3	localObject1	Object
    //   136	1	3	localException	Exception
    //   146	1	3	localIOException	java.io.IOException
    //   1	1	4	localObject2	Object
    //   95	36	4	localObject3	Object
    //   37	29	5	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   55	74	95	finally
    //   84	89	95	finally
    //   5	28	108	finally
    //   30	55	108	finally
    //   5	28	129	java/lang/Exception
    //   30	55	129	java/lang/Exception
    //   55	74	136	java/lang/Exception
    //   84	89	136	java/lang/Exception
    //   78	82	140	java/io/IOException
    //   89	93	143	java/io/IOException
    //   113	117	146	java/io/IOException
    //   123	127	150	java/io/IOException
  }
  
  /* Error */
  int j(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aload 4
    //   8: astore_3
    //   9: new 267	java/io/File
    //   12: dup
    //   13: aload_0
    //   14: aload_1
    //   15: invokevirtual 254	com/tencent/smtt/sdk/p:r	(Landroid/content/Context;)Ljava/io/File;
    //   18: ldc_w 373
    //   21: invokespecial 368	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   24: astore_1
    //   25: aload 4
    //   27: astore_3
    //   28: aload_1
    //   29: invokevirtual 583	java/io/File:exists	()Z
    //   32: ifne +5 -> 37
    //   35: iconst_0
    //   36: ireturn
    //   37: aload 4
    //   39: astore_3
    //   40: new 375	java/util/Properties
    //   43: dup
    //   44: invokespecial 376	java/util/Properties:<init>	()V
    //   47: astore 6
    //   49: aload 4
    //   51: astore_3
    //   52: new 378	java/io/BufferedInputStream
    //   55: dup
    //   56: new 380	java/io/FileInputStream
    //   59: dup
    //   60: aload_1
    //   61: invokespecial 383	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   64: invokespecial 386	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   67: astore_1
    //   68: aload 6
    //   70: aload_1
    //   71: invokevirtual 389	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   74: aload_1
    //   75: invokevirtual 416	java/io/BufferedInputStream:close	()V
    //   78: aload 6
    //   80: ldc_w 1267
    //   83: invokevirtual 1268	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   86: astore_3
    //   87: aload_3
    //   88: ifnonnull +46 -> 134
    //   91: aload_1
    //   92: invokevirtual 416	java/io/BufferedInputStream:close	()V
    //   95: iconst_0
    //   96: ireturn
    //   97: astore_1
    //   98: new 202	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   105: astore_3
    //   106: aload_3
    //   107: ldc_w 1629
    //   110: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: aload_3
    //   115: aload_1
    //   116: invokevirtual 1630	java/io/IOException:toString	()Ljava/lang/String;
    //   119: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: ldc 127
    //   125: aload_3
    //   126: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   132: iconst_0
    //   133: ireturn
    //   134: aload_3
    //   135: invokestatic 1271	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   138: istore_2
    //   139: getstatic 97	com/tencent/smtt/sdk/p:o	I
    //   142: ifne +7 -> 149
    //   145: iload_2
    //   146: putstatic 97	com/tencent/smtt/sdk/p:o	I
    //   149: aload_1
    //   150: invokevirtual 416	java/io/BufferedInputStream:close	()V
    //   153: iload_2
    //   154: ireturn
    //   155: astore_1
    //   156: new 202	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   163: astore_3
    //   164: aload_3
    //   165: ldc_w 1629
    //   168: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: aload_3
    //   173: aload_1
    //   174: invokevirtual 1630	java/io/IOException:toString	()Ljava/lang/String;
    //   177: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: ldc 127
    //   183: aload_3
    //   184: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   190: iload_2
    //   191: ireturn
    //   192: astore 4
    //   194: aload_1
    //   195: astore_3
    //   196: aload 4
    //   198: astore_1
    //   199: goto +111 -> 310
    //   202: astore 4
    //   204: goto +12 -> 216
    //   207: astore_1
    //   208: goto +102 -> 310
    //   211: astore 4
    //   213: aload 5
    //   215: astore_1
    //   216: aload_1
    //   217: astore_3
    //   218: new 202	java/lang/StringBuilder
    //   221: dup
    //   222: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   225: astore 5
    //   227: aload_1
    //   228: astore_3
    //   229: aload 5
    //   231: ldc_w 1632
    //   234: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: pop
    //   238: aload_1
    //   239: astore_3
    //   240: aload 5
    //   242: aload 4
    //   244: invokevirtual 242	java/lang/Exception:toString	()Ljava/lang/String;
    //   247: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: pop
    //   251: aload_1
    //   252: astore_3
    //   253: ldc 127
    //   255: aload 5
    //   257: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   263: aload_1
    //   264: ifnull +44 -> 308
    //   267: aload_1
    //   268: invokevirtual 416	java/io/BufferedInputStream:close	()V
    //   271: iconst_0
    //   272: ireturn
    //   273: astore_1
    //   274: new 202	java/lang/StringBuilder
    //   277: dup
    //   278: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   281: astore_3
    //   282: aload_3
    //   283: ldc_w 1629
    //   286: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: pop
    //   290: aload_3
    //   291: aload_1
    //   292: invokevirtual 1630	java/io/IOException:toString	()Ljava/lang/String;
    //   295: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: pop
    //   299: ldc 127
    //   301: aload_3
    //   302: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   305: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   308: iconst_0
    //   309: ireturn
    //   310: aload_3
    //   311: ifnull +49 -> 360
    //   314: aload_3
    //   315: invokevirtual 416	java/io/BufferedInputStream:close	()V
    //   318: goto +42 -> 360
    //   321: astore_3
    //   322: new 202	java/lang/StringBuilder
    //   325: dup
    //   326: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   329: astore 4
    //   331: aload 4
    //   333: ldc_w 1629
    //   336: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: pop
    //   340: aload 4
    //   342: aload_3
    //   343: invokevirtual 1630	java/io/IOException:toString	()Ljava/lang/String;
    //   346: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: pop
    //   350: ldc 127
    //   352: aload 4
    //   354: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   357: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   360: aload_1
    //   361: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	362	0	this	p
    //   0	362	1	paramContext	Context
    //   138	53	2	i1	int
    //   8	307	3	localObject1	Object
    //   321	22	3	localIOException	java.io.IOException
    //   4	46	4	localObject2	Object
    //   192	5	4	localObject3	Object
    //   202	1	4	localException1	Exception
    //   211	32	4	localException2	Exception
    //   329	24	4	localStringBuilder1	StringBuilder
    //   1	255	5	localStringBuilder2	StringBuilder
    //   47	32	6	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   91	95	97	java/io/IOException
    //   149	153	155	java/io/IOException
    //   68	87	192	finally
    //   134	149	192	finally
    //   68	87	202	java/lang/Exception
    //   134	149	202	java/lang/Exception
    //   9	25	207	finally
    //   28	35	207	finally
    //   40	49	207	finally
    //   52	68	207	finally
    //   218	227	207	finally
    //   229	238	207	finally
    //   240	251	207	finally
    //   253	263	207	finally
    //   9	25	211	java/lang/Exception
    //   28	35	211	java/lang/Exception
    //   40	49	211	java/lang/Exception
    //   52	68	211	java/lang/Exception
    //   267	271	273	java/io/IOException
    //   314	318	321	java/io/IOException
  }
  
  int k(Context paramContext)
  {
    int i1 = o;
    if (i1 != 0) {
      return i1;
    }
    return j(paramContext);
  }
  
  void l(Context paramContext)
  {
    if (o != 0) {
      return;
    }
    o = j(paramContext);
  }
  
  boolean m(Context paramContext)
  {
    return new File(r(paramContext), "tbs.conf").exists();
  }
  
  /* Error */
  int n(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 481	com/tencent/smtt/sdk/p:u	(Landroid/content/Context;)Z
    //   5: ifne +5 -> 10
    //   8: iconst_m1
    //   9: ireturn
    //   10: getstatic 41	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   13: invokevirtual 1089	java/util/concurrent/locks/ReentrantLock:tryLock	()Z
    //   16: istore_3
    //   17: new 202	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   24: astore 4
    //   26: aload 4
    //   28: ldc_w 1634
    //   31: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload 4
    //   37: iload_3
    //   38: invokevirtual 276	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: ldc 127
    //   44: aload 4
    //   46: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   52: iload_3
    //   53: ifeq +701 -> 754
    //   56: aconst_null
    //   57: astore 6
    //   59: aconst_null
    //   60: astore 5
    //   62: aload 5
    //   64: astore 4
    //   66: new 267	java/io/File
    //   69: dup
    //   70: aload_0
    //   71: aload_1
    //   72: invokevirtual 254	com/tencent/smtt/sdk/p:r	(Landroid/content/Context;)Ljava/io/File;
    //   75: ldc_w 373
    //   78: invokespecial 368	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   81: astore_1
    //   82: aload 5
    //   84: astore 4
    //   86: aload_1
    //   87: invokevirtual 583	java/io/File:exists	()Z
    //   90: istore_3
    //   91: iload_3
    //   92: ifne +63 -> 155
    //   95: getstatic 41	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   98: invokevirtual 1637	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   101: ifeq +48 -> 149
    //   104: getstatic 41	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   107: invokevirtual 511	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   110: goto +39 -> 149
    //   113: astore_1
    //   114: new 202	java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   121: astore 4
    //   123: aload 4
    //   125: ldc_w 1639
    //   128: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: aload 4
    //   134: aload_1
    //   135: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: ldc 127
    //   141: aload 4
    //   143: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokestatic 438	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   149: aload_0
    //   150: invokevirtual 514	com/tencent/smtt/sdk/p:b	()V
    //   153: iconst_0
    //   154: ireturn
    //   155: aload 5
    //   157: astore 4
    //   159: new 375	java/util/Properties
    //   162: dup
    //   163: invokespecial 376	java/util/Properties:<init>	()V
    //   166: astore 7
    //   168: aload 5
    //   170: astore 4
    //   172: new 378	java/io/BufferedInputStream
    //   175: dup
    //   176: new 380	java/io/FileInputStream
    //   179: dup
    //   180: aload_1
    //   181: invokespecial 383	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   184: invokespecial 386	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   187: astore_1
    //   188: aload 7
    //   190: aload_1
    //   191: invokevirtual 389	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   194: aload_1
    //   195: invokevirtual 416	java/io/BufferedInputStream:close	()V
    //   198: aload 7
    //   200: ldc_w 1267
    //   203: invokevirtual 1268	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   206: astore 4
    //   208: aload 4
    //   210: ifnonnull +109 -> 319
    //   213: aload_1
    //   214: invokevirtual 416	java/io/BufferedInputStream:close	()V
    //   217: goto +42 -> 259
    //   220: astore_1
    //   221: new 202	java/lang/StringBuilder
    //   224: dup
    //   225: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   228: astore 4
    //   230: aload 4
    //   232: ldc_w 1641
    //   235: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: pop
    //   239: aload 4
    //   241: aload_1
    //   242: invokevirtual 1630	java/io/IOException:toString	()Ljava/lang/String;
    //   245: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: pop
    //   249: ldc 127
    //   251: aload 4
    //   253: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   259: getstatic 41	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   262: invokevirtual 1637	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   265: ifeq +48 -> 313
    //   268: getstatic 41	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   271: invokevirtual 511	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   274: goto +39 -> 313
    //   277: astore_1
    //   278: new 202	java/lang/StringBuilder
    //   281: dup
    //   282: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   285: astore 4
    //   287: aload 4
    //   289: ldc_w 1639
    //   292: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: pop
    //   296: aload 4
    //   298: aload_1
    //   299: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   302: pop
    //   303: ldc 127
    //   305: aload 4
    //   307: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   310: invokestatic 438	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   313: aload_0
    //   314: invokevirtual 514	com/tencent/smtt/sdk/p:b	()V
    //   317: iconst_0
    //   318: ireturn
    //   319: getstatic 50	com/tencent/smtt/sdk/p:a	Ljava/lang/ThreadLocal;
    //   322: aload 4
    //   324: invokestatic 1271	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   327: invokestatic 225	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   330: invokevirtual 231	java/lang/ThreadLocal:set	(Ljava/lang/Object;)V
    //   333: getstatic 50	com/tencent/smtt/sdk/p:a	Ljava/lang/ThreadLocal;
    //   336: invokevirtual 1275	java/lang/ThreadLocal:get	()Ljava/lang/Object;
    //   339: checkcast 222	java/lang/Integer
    //   342: invokevirtual 1278	java/lang/Integer:intValue	()I
    //   345: istore_2
    //   346: aload_1
    //   347: invokevirtual 416	java/io/BufferedInputStream:close	()V
    //   350: goto +42 -> 392
    //   353: astore_1
    //   354: new 202	java/lang/StringBuilder
    //   357: dup
    //   358: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   361: astore 4
    //   363: aload 4
    //   365: ldc_w 1641
    //   368: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: pop
    //   372: aload 4
    //   374: aload_1
    //   375: invokevirtual 1630	java/io/IOException:toString	()Ljava/lang/String;
    //   378: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: pop
    //   382: ldc 127
    //   384: aload 4
    //   386: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   389: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   392: getstatic 41	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   395: invokevirtual 1637	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   398: ifeq +48 -> 446
    //   401: getstatic 41	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   404: invokevirtual 511	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   407: goto +39 -> 446
    //   410: astore_1
    //   411: new 202	java/lang/StringBuilder
    //   414: dup
    //   415: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   418: astore 4
    //   420: aload 4
    //   422: ldc_w 1639
    //   425: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: pop
    //   429: aload 4
    //   431: aload_1
    //   432: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   435: pop
    //   436: ldc 127
    //   438: aload 4
    //   440: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   443: invokestatic 438	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   446: aload_0
    //   447: invokevirtual 514	com/tencent/smtt/sdk/p:b	()V
    //   450: iload_2
    //   451: ireturn
    //   452: astore 5
    //   454: aload_1
    //   455: astore 4
    //   457: aload 5
    //   459: astore_1
    //   460: goto +178 -> 638
    //   463: astore 5
    //   465: goto +12 -> 477
    //   468: astore_1
    //   469: goto +169 -> 638
    //   472: astore 5
    //   474: aload 6
    //   476: astore_1
    //   477: aload_1
    //   478: astore 4
    //   480: new 202	java/lang/StringBuilder
    //   483: dup
    //   484: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   487: astore 6
    //   489: aload_1
    //   490: astore 4
    //   492: aload 6
    //   494: ldc_w 1643
    //   497: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: pop
    //   501: aload_1
    //   502: astore 4
    //   504: aload 6
    //   506: aload 5
    //   508: invokevirtual 242	java/lang/Exception:toString	()Ljava/lang/String;
    //   511: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: pop
    //   515: aload_1
    //   516: astore 4
    //   518: ldc 127
    //   520: aload 6
    //   522: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   525: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   528: aload_1
    //   529: ifnull +49 -> 578
    //   532: aload_1
    //   533: invokevirtual 416	java/io/BufferedInputStream:close	()V
    //   536: goto +42 -> 578
    //   539: astore_1
    //   540: new 202	java/lang/StringBuilder
    //   543: dup
    //   544: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   547: astore 4
    //   549: aload 4
    //   551: ldc_w 1641
    //   554: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: pop
    //   558: aload 4
    //   560: aload_1
    //   561: invokevirtual 1630	java/io/IOException:toString	()Ljava/lang/String;
    //   564: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   567: pop
    //   568: ldc 127
    //   570: aload 4
    //   572: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   575: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   578: getstatic 41	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   581: invokevirtual 1637	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   584: ifeq +48 -> 632
    //   587: getstatic 41	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   590: invokevirtual 511	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   593: goto +39 -> 632
    //   596: astore_1
    //   597: new 202	java/lang/StringBuilder
    //   600: dup
    //   601: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   604: astore 4
    //   606: aload 4
    //   608: ldc_w 1639
    //   611: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   614: pop
    //   615: aload 4
    //   617: aload_1
    //   618: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   621: pop
    //   622: ldc 127
    //   624: aload 4
    //   626: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   629: invokestatic 438	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   632: aload_0
    //   633: invokevirtual 514	com/tencent/smtt/sdk/p:b	()V
    //   636: iconst_0
    //   637: ireturn
    //   638: aload 4
    //   640: ifnull +52 -> 692
    //   643: aload 4
    //   645: invokevirtual 416	java/io/BufferedInputStream:close	()V
    //   648: goto +44 -> 692
    //   651: astore 4
    //   653: new 202	java/lang/StringBuilder
    //   656: dup
    //   657: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   660: astore 5
    //   662: aload 5
    //   664: ldc_w 1641
    //   667: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: pop
    //   671: aload 5
    //   673: aload 4
    //   675: invokevirtual 1630	java/io/IOException:toString	()Ljava/lang/String;
    //   678: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   681: pop
    //   682: ldc 127
    //   684: aload 5
    //   686: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   689: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   692: getstatic 41	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   695: invokevirtual 1637	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   698: ifeq +50 -> 748
    //   701: getstatic 41	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   704: invokevirtual 511	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   707: goto +41 -> 748
    //   710: astore 4
    //   712: new 202	java/lang/StringBuilder
    //   715: dup
    //   716: invokespecial 203	java/lang/StringBuilder:<init>	()V
    //   719: astore 5
    //   721: aload 5
    //   723: ldc_w 1639
    //   726: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   729: pop
    //   730: aload 5
    //   732: aload 4
    //   734: invokevirtual 317	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   737: pop
    //   738: ldc 127
    //   740: aload 5
    //   742: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   745: invokestatic 438	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   748: aload_0
    //   749: invokevirtual 514	com/tencent/smtt/sdk/p:b	()V
    //   752: aload_1
    //   753: athrow
    //   754: aload_0
    //   755: invokevirtual 514	com/tencent/smtt/sdk/p:b	()V
    //   758: iconst_0
    //   759: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	760	0	this	p
    //   0	760	1	paramContext	Context
    //   345	106	2	i1	int
    //   16	76	3	bool	boolean
    //   24	620	4	localObject1	Object
    //   651	23	4	localIOException	java.io.IOException
    //   710	23	4	localThrowable	Throwable
    //   60	109	5	localObject2	Object
    //   452	6	5	localObject3	Object
    //   463	1	5	localException1	Exception
    //   472	35	5	localException2	Exception
    //   660	81	5	localStringBuilder1	StringBuilder
    //   57	464	6	localStringBuilder2	StringBuilder
    //   166	33	7	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   95	110	113	java/lang/Throwable
    //   213	217	220	java/io/IOException
    //   259	274	277	java/lang/Throwable
    //   346	350	353	java/io/IOException
    //   392	407	410	java/lang/Throwable
    //   188	208	452	finally
    //   319	346	452	finally
    //   188	208	463	java/lang/Exception
    //   319	346	463	java/lang/Exception
    //   66	82	468	finally
    //   86	91	468	finally
    //   159	168	468	finally
    //   172	188	468	finally
    //   480	489	468	finally
    //   492	501	468	finally
    //   504	515	468	finally
    //   518	528	468	finally
    //   66	82	472	java/lang/Exception
    //   86	91	472	java/lang/Exception
    //   159	168	472	java/lang/Exception
    //   172	188	472	java/lang/Exception
    //   532	536	539	java/io/IOException
    //   578	593	596	java/lang/Throwable
    //   643	648	651	java/io/IOException
    //   692	707	710	java/lang/Throwable
  }
  
  public boolean o(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--coreShareCopyToDecouple #0");
    File localFile1 = r(paramContext);
    File localFile2 = q(paramContext);
    try
    {
      FileUtil.a(localFile2, true);
      FileUtil.a(localFile1, localFile2, new p.5(this));
      TbsShareManager.b(paramContext);
      TbsLog.i("TbsInstaller", "TbsInstaller--coreShareCopyToDecouple success!!!");
      return true;
    }
    catch (Exception paramContext)
    {
      label53:
      break label53;
    }
    return false;
  }
  
  void p(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--cleanStatusAndTmpDir");
    m.a(paramContext).a(0);
    m.a(paramContext).b(0);
    m.a(paramContext).d(0);
    m.a(paramContext).a("incrupdate_retry_num", 0);
    if (!TbsDownloader.a(paramContext))
    {
      m.a(paramContext).c(0, -1);
      m.a(paramContext).a("");
      m.a(paramContext).a("copy_retry_num", 0);
      m.a(paramContext).c(-1);
      m.a(paramContext).a(0, -1);
      FileUtil.a(f(paramContext, 0), true);
      FileUtil.a(f(paramContext, 1), true);
    }
  }
  
  File q(Context paramContext)
  {
    paramContext = new File(QbSdk.getTbsFolderDir(paramContext), "core_share_decouple");
    if ((!paramContext.isDirectory()) && (!paramContext.mkdir())) {
      return null;
    }
    return paramContext;
  }
  
  File r(Context paramContext)
  {
    return b(null, paramContext);
  }
  
  File s(Context paramContext)
  {
    paramContext = new File(QbSdk.getTbsFolderDir(paramContext), "share");
    if ((!paramContext.isDirectory()) && (!paramContext.mkdir())) {
      return null;
    }
    return paramContext;
  }
  
  boolean u(Context paramContext)
  {
    try
    {
      if (this.e > 0)
      {
        TbsLog.i("TbsInstaller", "getTbsInstallingFileLock success,is cached= true");
        this.e += 1;
        return true;
      }
      this.g = FileUtil.b(paramContext, true, "tbslock.txt");
      if (this.g != null)
      {
        this.f = FileUtil.a(paramContext, this.g);
        if (this.f == null)
        {
          TbsLog.i("TbsInstaller", "getTbsInstallingFileLock tbsFileLockFileLock == null");
          return false;
        }
        TbsLog.i("TbsInstaller", "getTbsInstallingFileLock success,is cached= false");
        this.e += 1;
        return true;
      }
      TbsLog.i("TbsInstaller", "getTbsInstallingFileLock get install fos failed");
      return false;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.sdk.p
 * JD-Core Version:    0.7.0.1
 */