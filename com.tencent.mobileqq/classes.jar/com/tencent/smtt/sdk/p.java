package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
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
import com.tencent.smtt.utils.b;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.nio.channels.FileLock;
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
    Long[] arrayOfLong1 = { Long.valueOf(44005L), localLong1 };
    Long localLong2 = Long.valueOf(38917816L);
    Long[] arrayOfLong2 = { Long.valueOf(44033L), localLong1 };
    n = new Long[][] { { Long.valueOf(44006L), localLong1 }, arrayOfLong1, { Long.valueOf(43910L), localLong2 }, { Long.valueOf(44027L), localLong1 }, { Long.valueOf(44028L), localLong1 }, { Long.valueOf(44029L), localLong1 }, { Long.valueOf(44030L), localLong1 }, { Long.valueOf(44032L), localLong1 }, arrayOfLong2, { Long.valueOf(44034L), localLong1 }, { Long.valueOf(43909L), localLong2 } };
  }
  
  private p()
  {
    if (m == null) {
      m = new p.3(this, n.a().getLooper());
    }
  }
  
  private void A(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--deleteOldCore");
    FileUtil.a(q(paramContext), false);
  }
  
  private void B(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--renameShareDir");
    Object localObject = f(paramContext, 0);
    File localFile = q(paramContext);
    if ((localObject != null) && (localFile != null))
    {
      boolean bool = ((File)localObject).renameTo(localFile);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("renameTbsCoreShareDir rename success=");
      ((StringBuilder)localObject).append(bool);
      TbsLog.i("TbsInstaller", ((StringBuilder)localObject).toString());
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
  
  private void C(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--renameTbsCoreCopyDir");
    File localFile1 = f(paramContext, 1);
    File localFile2 = q(paramContext);
    if (localFile1 != null)
    {
      if (localFile2 == null) {
        return;
      }
      localFile1.renameTo(localFile2);
      g(paramContext, false);
    }
  }
  
  private void D(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--renameTbsTpatchCoreDir");
    File localFile1 = f(paramContext, 5);
    File localFile2 = q(paramContext);
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
    //   0: new 149	java/io/File
    //   3: dup
    //   4: aload_2
    //   5: invokespecial 254	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: invokevirtual 258	java/io/File:delete	()Z
    //   11: pop
    //   12: new 155	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   19: astore 4
    //   21: aload 4
    //   23: ldc_w 260
    //   26: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload 4
    //   32: aload_2
    //   33: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload 4
    //   39: ldc_w 262
    //   42: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: ldc 125
    //   48: aload 4
    //   50: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: iconst_1
    //   54: invokestatic 265	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   57: new 149	java/io/File
    //   60: dup
    //   61: aload_3
    //   62: invokestatic 268	com/tencent/smtt/sdk/QbSdk:getTbsFolderDir	(Landroid/content/Context;)Ljava/io/File;
    //   65: ldc_w 270
    //   68: invokespecial 273	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   71: astore_2
    //   72: aload_2
    //   73: invokevirtual 276	java/io/File:canRead	()Z
    //   76: ifeq +258 -> 334
    //   79: new 149	java/io/File
    //   82: dup
    //   83: aload_2
    //   84: ldc_w 278
    //   87: invokespecial 273	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   90: astore 8
    //   92: new 280	java/util/Properties
    //   95: dup
    //   96: invokespecial 281	java/util/Properties:<init>	()V
    //   99: astore 6
    //   101: aconst_null
    //   102: astore 5
    //   104: aconst_null
    //   105: astore_3
    //   106: aconst_null
    //   107: astore 7
    //   109: new 283	java/io/BufferedInputStream
    //   112: dup
    //   113: new 285	java/io/FileInputStream
    //   116: dup
    //   117: aload 8
    //   119: invokespecial 288	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   122: invokespecial 291	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   125: astore_2
    //   126: aload 5
    //   128: astore_3
    //   129: aload_2
    //   130: astore 4
    //   132: aload 6
    //   134: aload_2
    //   135: invokevirtual 294	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   138: aload 5
    //   140: astore_3
    //   141: aload_2
    //   142: astore 4
    //   144: new 296	java/io/BufferedOutputStream
    //   147: dup
    //   148: new 298	java/io/FileOutputStream
    //   151: dup
    //   152: aload 8
    //   154: invokespecial 299	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   157: invokespecial 302	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   160: astore 5
    //   162: aload 6
    //   164: ldc_w 304
    //   167: ldc_w 306
    //   170: invokevirtual 310	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   173: pop
    //   174: aload 6
    //   176: aload 5
    //   178: aconst_null
    //   179: invokevirtual 314	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   182: ldc 125
    //   184: ldc_w 316
    //   187: iconst_1
    //   188: invokestatic 265	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   191: aload 5
    //   193: invokevirtual 319	java/io/BufferedOutputStream:close	()V
    //   196: goto +8 -> 204
    //   199: astore_3
    //   200: aload_3
    //   201: invokevirtual 322	java/io/IOException:printStackTrace	()V
    //   204: aload_2
    //   205: invokevirtual 323	java/io/BufferedInputStream:close	()V
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
    //   258: invokevirtual 324	java/lang/Throwable:printStackTrace	()V
    //   261: aload 5
    //   263: ifnull +16 -> 279
    //   266: aload 5
    //   268: invokevirtual 319	java/io/BufferedOutputStream:close	()V
    //   271: goto +8 -> 279
    //   274: astore_3
    //   275: aload_3
    //   276: invokevirtual 322	java/io/IOException:printStackTrace	()V
    //   279: aload_2
    //   280: ifnull +54 -> 334
    //   283: aload_2
    //   284: invokevirtual 323	java/io/BufferedInputStream:close	()V
    //   287: return
    //   288: astore_2
    //   289: aload_2
    //   290: invokevirtual 322	java/io/IOException:printStackTrace	()V
    //   293: return
    //   294: astore 5
    //   296: aload 4
    //   298: astore_2
    //   299: aload_3
    //   300: ifnull +15 -> 315
    //   303: aload_3
    //   304: invokevirtual 319	java/io/BufferedOutputStream:close	()V
    //   307: goto +8 -> 315
    //   310: astore_3
    //   311: aload_3
    //   312: invokevirtual 322	java/io/IOException:printStackTrace	()V
    //   315: aload_2
    //   316: ifnull +15 -> 331
    //   319: aload_2
    //   320: invokevirtual 323	java/io/BufferedInputStream:close	()V
    //   323: goto +8 -> 331
    //   326: astore_2
    //   327: aload_2
    //   328: invokevirtual 322	java/io/IOException:printStackTrace	()V
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
    if (!v(paramContext))
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
  @android.annotation.TargetApi(11)
  private void a(Context paramContext1, Context paramContext2, int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4: sipush -524
    //   7: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   10: aload_0
    //   11: aload_2
    //   12: invokevirtual 374	com/tencent/smtt/sdk/p:c	(Landroid/content/Context;)Z
    //   15: ifeq +4 -> 19
    //   18: return
    //   19: new 155	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   26: astore 13
    //   28: aload 13
    //   30: ldc_w 376
    //   33: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload 13
    //   39: iload_3
    //   40: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: ldc 125
    //   46: aload 13
    //   48: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: getstatic 384	android/os/Build$VERSION:SDK_INT	I
    //   57: bipush 11
    //   59: if_icmplt +16 -> 75
    //   62: aload_2
    //   63: ldc_w 386
    //   66: iconst_4
    //   67: invokevirtual 390	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   70: astore 13
    //   72: goto +13 -> 85
    //   75: aload_2
    //   76: ldc_w 386
    //   79: iconst_0
    //   80: invokevirtual 390	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   83: astore 13
    //   85: aload 13
    //   87: ldc_w 392
    //   90: iconst_m1
    //   91: invokeinterface 398 3 0
    //   96: iload_3
    //   97: if_icmpne +53 -> 150
    //   100: new 155	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   107: astore_2
    //   108: aload_2
    //   109: ldc_w 400
    //   112: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload_2
    //   117: iload_3
    //   118: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: aload_2
    //   123: ldc_w 402
    //   126: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: ldc 125
    //   132: aload_2
    //   133: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokestatic 346	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   139: aload_1
    //   140: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   143: sipush -525
    //   146: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   149: return
    //   150: aload_0
    //   151: aload_2
    //   152: invokevirtual 405	com/tencent/smtt/sdk/p:t	(Landroid/content/Context;)Z
    //   155: ifne +14 -> 169
    //   158: aload_1
    //   159: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   162: sipush -526
    //   165: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   168: return
    //   169: getstatic 43	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   172: invokeinterface 410 1 0
    //   177: istore 8
    //   179: new 155	java/lang/StringBuilder
    //   182: dup
    //   183: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   186: astore 13
    //   188: aload 13
    //   190: ldc_w 412
    //   193: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: aload 13
    //   199: iload 8
    //   201: invokevirtual 165	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: ldc 125
    //   207: aload 13
    //   209: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   215: iload 8
    //   217: ifeq +1936 -> 2153
    //   220: getstatic 41	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   223: invokevirtual 415	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   226: aload_2
    //   227: invokestatic 229	com/tencent/smtt/sdk/m:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/m;
    //   230: ldc_w 417
    //   233: invokevirtual 420	com/tencent/smtt/sdk/m:c	(Ljava/lang/String;)I
    //   236: istore 4
    //   238: aload_2
    //   239: invokestatic 229	com/tencent/smtt/sdk/m:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/m;
    //   242: ldc_w 422
    //   245: invokevirtual 424	com/tencent/smtt/sdk/m:b	(Ljava/lang/String;)I
    //   248: istore 5
    //   250: iload 4
    //   252: iload_3
    //   253: if_icmpne +43 -> 296
    //   256: getstatic 427	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   259: sipush 220
    //   262: invokeinterface 432 2 0
    //   267: aload_1
    //   268: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   271: sipush -528
    //   274: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   277: getstatic 41	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   280: invokevirtual 435	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   283: getstatic 43	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   286: invokeinterface 436 1 0
    //   291: aload_0
    //   292: invokevirtual 438	com/tencent/smtt/sdk/p:b	()V
    //   295: return
    //   296: aload_0
    //   297: aload_2
    //   298: invokevirtual 441	com/tencent/smtt/sdk/p:i	(Landroid/content/Context;)I
    //   301: istore 6
    //   303: new 155	java/lang/StringBuilder
    //   306: dup
    //   307: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   310: astore 13
    //   312: aload 13
    //   314: ldc_w 443
    //   317: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: pop
    //   321: aload 13
    //   323: iload 6
    //   325: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   328: pop
    //   329: ldc 125
    //   331: aload 13
    //   333: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   336: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   339: iload 6
    //   341: iload_3
    //   342: if_icmpne +79 -> 421
    //   345: getstatic 427	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   348: sipush 220
    //   351: invokeinterface 432 2 0
    //   356: aload_1
    //   357: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   360: sipush -528
    //   363: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   366: new 155	java/lang/StringBuilder
    //   369: dup
    //   370: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   373: astore 13
    //   375: aload 13
    //   377: ldc_w 445
    //   380: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: pop
    //   384: aload 13
    //   386: iload 6
    //   388: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   391: pop
    //   392: ldc 125
    //   394: aload 13
    //   396: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   399: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   402: getstatic 41	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   405: invokevirtual 435	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   408: getstatic 43	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   411: invokeinterface 436 1 0
    //   416: aload_0
    //   417: invokevirtual 438	com/tencent/smtt/sdk/p:b	()V
    //   420: return
    //   421: aload_2
    //   422: invokestatic 229	com/tencent/smtt/sdk/m:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/m;
    //   425: invokevirtual 448	com/tencent/smtt/sdk/m:b	()I
    //   428: istore 7
    //   430: iload 7
    //   432: ifle +1736 -> 2168
    //   435: iload_3
    //   436: iload 7
    //   438: if_icmpgt +6 -> 444
    //   441: goto +1727 -> 2168
    //   444: aload_0
    //   445: aload_2
    //   446: invokevirtual 450	com/tencent/smtt/sdk/p:o	(Landroid/content/Context;)V
    //   449: goto +1733 -> 2182
    //   452: aload_0
    //   453: aload_2
    //   454: invokevirtual 450	com/tencent/smtt/sdk/p:o	(Landroid/content/Context;)V
    //   457: ldc 125
    //   459: ldc_w 452
    //   462: iconst_1
    //   463: invokestatic 265	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   466: iconst_m1
    //   467: istore 4
    //   469: aload_2
    //   470: invokestatic 454	com/tencent/smtt/utils/FileUtil:b	(Landroid/content/Context;)Z
    //   473: ifne +108 -> 581
    //   476: invokestatic 459	com/tencent/smtt/utils/p:a	()J
    //   479: lstore 9
    //   481: aload_2
    //   482: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   485: invokevirtual 462	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMinFreeSpace	()J
    //   488: lstore 11
    //   490: aload_1
    //   491: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   494: sipush -529
    //   497: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   500: aload_2
    //   501: invokestatic 199	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   504: astore 13
    //   506: new 155	java/lang/StringBuilder
    //   509: dup
    //   510: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   513: astore 14
    //   515: aload 14
    //   517: ldc_w 464
    //   520: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: pop
    //   524: aload 14
    //   526: lload 9
    //   528: invokevirtual 467	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   531: pop
    //   532: aload 14
    //   534: ldc_w 469
    //   537: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: pop
    //   541: aload 14
    //   543: lload 11
    //   545: invokevirtual 467	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   548: pop
    //   549: aload 13
    //   551: sipush 210
    //   554: aload 14
    //   556: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   559: invokevirtual 205	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   562: getstatic 41	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   565: invokevirtual 435	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   568: getstatic 43	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   571: invokeinterface 436 1 0
    //   576: aload_0
    //   577: invokevirtual 438	com/tencent/smtt/sdk/p:b	()V
    //   580: return
    //   581: iload 4
    //   583: ifle +87 -> 670
    //   586: aload_2
    //   587: invokestatic 474	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   590: ifne +22 -> 612
    //   593: aload_2
    //   594: invokestatic 478	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   597: ifeq +15 -> 612
    //   600: iload_3
    //   601: aload_0
    //   602: aload_2
    //   603: invokevirtual 480	com/tencent/smtt/sdk/p:h	(Landroid/content/Context;)I
    //   606: if_icmpeq +6 -> 612
    //   609: goto +61 -> 670
    //   612: new 155	java/lang/StringBuilder
    //   615: dup
    //   616: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   619: astore 13
    //   621: aload 13
    //   623: ldc_w 482
    //   626: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   629: pop
    //   630: aload 13
    //   632: aload_0
    //   633: aload_2
    //   634: invokevirtual 480	com/tencent/smtt/sdk/p:h	(Landroid/content/Context;)I
    //   637: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   640: pop
    //   641: ldc 125
    //   643: aload 13
    //   645: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   648: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   651: getstatic 41	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   654: invokevirtual 435	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   657: getstatic 43	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   660: invokeinterface 436 1 0
    //   665: aload_0
    //   666: invokevirtual 438	com/tencent/smtt/sdk/p:b	()V
    //   669: return
    //   670: iload 4
    //   672: ifne +77 -> 749
    //   675: aload_2
    //   676: invokestatic 229	com/tencent/smtt/sdk/m:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/m;
    //   679: ldc_w 484
    //   682: invokevirtual 420	com/tencent/smtt/sdk/m:c	(Ljava/lang/String;)I
    //   685: istore 4
    //   687: iload 4
    //   689: iconst_2
    //   690: if_icmple +45 -> 735
    //   693: aload_2
    //   694: invokestatic 199	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   697: sipush 211
    //   700: ldc_w 486
    //   703: invokevirtual 205	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   706: aload_1
    //   707: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   710: sipush -530
    //   713: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   716: getstatic 41	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   719: invokevirtual 435	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   722: getstatic 43	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   725: invokeinterface 436 1 0
    //   730: aload_0
    //   731: invokevirtual 438	com/tencent/smtt/sdk/p:b	()V
    //   734: return
    //   735: aload_2
    //   736: invokestatic 229	com/tencent/smtt/sdk/m:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/m;
    //   739: ldc_w 484
    //   742: iload 4
    //   744: iconst_1
    //   745: iadd
    //   746: invokevirtual 489	com/tencent/smtt/sdk/m:a	(Ljava/lang/String;I)V
    //   749: aload_0
    //   750: aload_1
    //   751: invokevirtual 136	com/tencent/smtt/sdk/p:q	(Landroid/content/Context;)Ljava/io/File;
    //   754: astore 14
    //   756: aload_2
    //   757: invokestatic 474	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   760: ifne +20 -> 780
    //   763: aload_2
    //   764: invokestatic 478	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   767: ifeq +13 -> 780
    //   770: aload_0
    //   771: aload_2
    //   772: invokevirtual 491	com/tencent/smtt/sdk/p:p	(Landroid/content/Context;)Ljava/io/File;
    //   775: astore 13
    //   777: goto +11 -> 788
    //   780: aload_0
    //   781: aload_2
    //   782: iconst_1
    //   783: invokevirtual 147	com/tencent/smtt/sdk/p:f	(Landroid/content/Context;I)Ljava/io/File;
    //   786: astore 13
    //   788: aload 14
    //   790: ifnull +1154 -> 1944
    //   793: aload 13
    //   795: ifnull +1149 -> 1944
    //   798: aload_2
    //   799: invokestatic 229	com/tencent/smtt/sdk/m:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/m;
    //   802: iload_3
    //   803: iconst_0
    //   804: invokevirtual 493	com/tencent/smtt/sdk/m:a	(II)V
    //   807: new 495	com/tencent/smtt/utils/o
    //   810: dup
    //   811: invokespecial 496	com/tencent/smtt/utils/o:<init>	()V
    //   814: astore 15
    //   816: aload 15
    //   818: aload 14
    //   820: invokevirtual 498	com/tencent/smtt/utils/o:a	(Ljava/io/File;)V
    //   823: invokestatic 503	java/lang/System:currentTimeMillis	()J
    //   826: lstore 9
    //   828: aload_1
    //   829: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   832: sipush -551
    //   835: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   838: aload 14
    //   840: aload 13
    //   842: getstatic 95	com/tencent/smtt/sdk/p:c	Ljava/io/FileFilter;
    //   845: invokestatic 506	com/tencent/smtt/utils/FileUtil:a	(Ljava/io/File;Ljava/io/File;Ljava/io/FileFilter;)Z
    //   848: istore 8
    //   850: aload_2
    //   851: invokestatic 478	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   854: ifeq +7 -> 861
    //   857: aload_2
    //   858: invokestatic 508	com/tencent/smtt/sdk/TbsShareManager:b	(Landroid/content/Context;)V
    //   861: new 155	java/lang/StringBuilder
    //   864: dup
    //   865: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   868: astore 16
    //   870: aload 16
    //   872: ldc_w 510
    //   875: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   878: pop
    //   879: aload 16
    //   881: invokestatic 503	java/lang/System:currentTimeMillis	()J
    //   884: lload 9
    //   886: lsub
    //   887: invokevirtual 467	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   890: pop
    //   891: ldc 125
    //   893: aload 16
    //   895: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   898: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   901: iload 8
    //   903: ifeq +992 -> 1895
    //   906: aload 15
    //   908: aload 14
    //   910: invokevirtual 512	com/tencent/smtt/utils/o:b	(Ljava/io/File;)V
    //   913: aload 15
    //   915: invokevirtual 514	com/tencent/smtt/utils/o:a	()Z
    //   918: ifne +59 -> 977
    //   921: ldc 125
    //   923: ldc_w 516
    //   926: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   929: aload 13
    //   931: iconst_1
    //   932: invokestatic 141	com/tencent/smtt/utils/FileUtil:a	(Ljava/io/File;Z)V
    //   935: aload_2
    //   936: invokestatic 199	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   939: sipush 213
    //   942: ldc_w 518
    //   945: invokevirtual 205	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   948: aload_1
    //   949: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   952: sipush -531
    //   955: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   958: getstatic 41	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   961: invokevirtual 435	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   964: getstatic 43	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   967: invokeinterface 436 1 0
    //   972: aload_0
    //   973: invokevirtual 438	com/tencent/smtt/sdk/p:b	()V
    //   976: return
    //   977: new 149	java/io/File
    //   980: dup
    //   981: aload 13
    //   983: ldc_w 520
    //   986: invokespecial 273	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   989: astore 15
    //   991: new 280	java/util/Properties
    //   994: dup
    //   995: invokespecial 281	java/util/Properties:<init>	()V
    //   998: astore 14
    //   1000: aload 15
    //   1002: invokevirtual 523	java/io/File:exists	()Z
    //   1005: ifeq +52 -> 1057
    //   1008: new 283	java/io/BufferedInputStream
    //   1011: dup
    //   1012: new 285	java/io/FileInputStream
    //   1015: dup
    //   1016: aload 15
    //   1018: invokespecial 288	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   1021: invokespecial 291	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1024: astore 15
    //   1026: aload 14
    //   1028: aload 15
    //   1030: invokevirtual 294	java/util/Properties:load	(Ljava/io/InputStream;)V
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
    //   1078: invokevirtual 323	java/io/BufferedInputStream:close	()V
    //   1081: iload 4
    //   1083: istore 5
    //   1085: aload 14
    //   1087: astore 16
    //   1089: goto +78 -> 1167
    //   1092: astore 15
    //   1094: aload 15
    //   1096: invokevirtual 322	java/io/IOException:printStackTrace	()V
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
    //   1141: invokevirtual 524	java/lang/Exception:printStackTrace	()V
    //   1144: aload 14
    //   1146: ifnull +1075 -> 2221
    //   1149: aload 14
    //   1151: invokevirtual 323	java/io/BufferedInputStream:close	()V
    //   1154: goto +1067 -> 2221
    //   1157: astore 14
    //   1159: aload 14
    //   1161: invokevirtual 322	java/io/IOException:printStackTrace	()V
    //   1164: goto +1057 -> 2221
    //   1167: iload 5
    //   1169: ifeq +1067 -> 2236
    //   1172: aload 13
    //   1174: invokevirtual 528	java/io/File:listFiles	()[Ljava/io/File;
    //   1177: astore 15
    //   1179: aload_1
    //   1180: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1183: sipush -552
    //   1186: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
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
    //   1207: ldc_w 520
    //   1210: aload 14
    //   1212: invokevirtual 531	java/io/File:getName	()Ljava/lang/String;
    //   1215: invokevirtual 193	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1218: ifne +1009 -> 2227
    //   1221: aload 14
    //   1223: invokevirtual 531	java/io/File:getName	()Ljava/lang/String;
    //   1226: ldc_w 533
    //   1229: invokevirtual 537	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1232: ifne +995 -> 2227
    //   1235: ldc_w 278
    //   1238: aload 14
    //   1240: invokevirtual 531	java/io/File:getName	()Ljava/lang/String;
    //   1243: invokevirtual 193	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1246: ifne +981 -> 2227
    //   1249: aload 14
    //   1251: invokevirtual 540	java/io/File:isDirectory	()Z
    //   1254: ifne +973 -> 2227
    //   1257: aload 14
    //   1259: invokevirtual 531	java/io/File:getName	()Ljava/lang/String;
    //   1262: ldc_w 542
    //   1265: invokevirtual 537	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1268: ifeq +6 -> 1274
    //   1271: goto +956 -> 2227
    //   1274: aload 14
    //   1276: invokestatic 547	com/tencent/smtt/utils/a:a	(Ljava/io/File;)Ljava/lang/String;
    //   1279: astore 17
    //   1281: aload 16
    //   1283: aload 14
    //   1285: invokevirtual 531	java/io/File:getName	()Ljava/lang/String;
    //   1288: ldc_w 549
    //   1291: invokevirtual 553	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1294: astore 18
    //   1296: aload 18
    //   1298: ldc_w 549
    //   1301: invokevirtual 193	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1304: ifne +64 -> 1368
    //   1307: aload 17
    //   1309: aload 18
    //   1311: invokevirtual 193	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1314: ifeq +54 -> 1368
    //   1317: new 155	java/lang/StringBuilder
    //   1320: dup
    //   1321: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   1324: astore 17
    //   1326: aload 17
    //   1328: ldc_w 555
    //   1331: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1334: pop
    //   1335: aload 17
    //   1337: aload 14
    //   1339: invokevirtual 531	java/io/File:getName	()Ljava/lang/String;
    //   1342: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1345: pop
    //   1346: aload 17
    //   1348: ldc_w 557
    //   1351: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1354: pop
    //   1355: ldc 125
    //   1357: aload 17
    //   1359: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1362: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1365: goto +862 -> 2227
    //   1368: new 155	java/lang/StringBuilder
    //   1371: dup
    //   1372: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   1375: astore 15
    //   1377: aload 15
    //   1379: ldc_w 559
    //   1382: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1385: pop
    //   1386: aload 15
    //   1388: aload 14
    //   1390: invokevirtual 531	java/io/File:getName	()Ljava/lang/String;
    //   1393: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1396: pop
    //   1397: aload 15
    //   1399: ldc_w 557
    //   1402: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1405: pop
    //   1406: aload 15
    //   1408: ldc_w 561
    //   1411: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1414: pop
    //   1415: aload 15
    //   1417: aload 18
    //   1419: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1422: pop
    //   1423: aload 15
    //   1425: ldc_w 563
    //   1428: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1431: pop
    //   1432: aload 15
    //   1434: aload 17
    //   1436: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1439: pop
    //   1440: ldc 125
    //   1442: aload 15
    //   1444: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1447: invokestatic 346	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1450: iconst_0
    //   1451: istore 8
    //   1453: goto +3 -> 1456
    //   1456: new 155	java/lang/StringBuilder
    //   1459: dup
    //   1460: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   1463: astore 14
    //   1465: aload 14
    //   1467: ldc_w 565
    //   1470: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1473: pop
    //   1474: aload 14
    //   1476: iload 8
    //   1478: invokevirtual 165	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1481: pop
    //   1482: ldc 125
    //   1484: aload 14
    //   1486: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1489: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1492: iload 5
    //   1494: ifeq +64 -> 1558
    //   1497: iload 8
    //   1499: ifne +59 -> 1558
    //   1502: ldc 125
    //   1504: ldc_w 567
    //   1507: invokestatic 346	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1510: aload 13
    //   1512: iconst_1
    //   1513: invokestatic 141	com/tencent/smtt/utils/FileUtil:a	(Ljava/io/File;Z)V
    //   1516: aload_2
    //   1517: invokestatic 199	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1520: sipush 213
    //   1523: ldc_w 569
    //   1526: invokevirtual 205	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1529: aload_1
    //   1530: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1533: sipush -532
    //   1536: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1539: getstatic 41	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1542: invokevirtual 435	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1545: getstatic 43	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   1548: invokeinterface 436 1 0
    //   1553: aload_0
    //   1554: invokevirtual 438	com/tencent/smtt/sdk/p:b	()V
    //   1557: return
    //   1558: ldc 125
    //   1560: ldc_w 571
    //   1563: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1566: aload_0
    //   1567: aload_2
    //   1568: iconst_1
    //   1569: invokespecial 208	com/tencent/smtt/sdk/p:g	(Landroid/content/Context;Z)V
    //   1572: aload_1
    //   1573: invokestatic 575	com/tencent/smtt/sdk/l:b	(Landroid/content/Context;)Ljava/io/File;
    //   1576: astore 15
    //   1578: aload 15
    //   1580: ifnull +47 -> 1627
    //   1583: aload 15
    //   1585: invokevirtual 523	java/io/File:exists	()Z
    //   1588: ifeq +39 -> 1627
    //   1591: aload_2
    //   1592: invokestatic 578	com/tencent/smtt/sdk/TbsDownloader:getOverSea	(Landroid/content/Context;)Z
    //   1595: ifeq +11 -> 1606
    //   1598: ldc_w 580
    //   1601: astore 14
    //   1603: goto +9 -> 1612
    //   1606: iconst_0
    //   1607: invokestatic 584	com/tencent/smtt/sdk/TbsDownloader:getBackupFileName	(Z)Ljava/lang/String;
    //   1610: astore 14
    //   1612: new 149	java/io/File
    //   1615: dup
    //   1616: aload 15
    //   1618: aload 14
    //   1620: invokespecial 273	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   1623: aload_2
    //   1624: invokestatic 587	com/tencent/smtt/sdk/l:a	(Ljava/io/File;Landroid/content/Context;)V
    //   1627: aload_2
    //   1628: invokestatic 229	com/tencent/smtt/sdk/m:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/m;
    //   1631: iload_3
    //   1632: iconst_1
    //   1633: invokevirtual 493	com/tencent/smtt/sdk/m:a	(II)V
    //   1636: aload_0
    //   1637: getfield 107	com/tencent/smtt/sdk/p:k	Z
    //   1640: ifeq +27 -> 1667
    //   1643: aload_2
    //   1644: invokestatic 199	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1647: astore 14
    //   1649: ldc_w 589
    //   1652: astore 15
    //   1654: aload 14
    //   1656: sipush 220
    //   1659: aload 15
    //   1661: invokevirtual 205	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1664: goto +17 -> 1681
    //   1667: aload_2
    //   1668: invokestatic 199	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1671: astore 14
    //   1673: ldc_w 591
    //   1676: astore 15
    //   1678: goto -24 -> 1654
    //   1681: aload_1
    //   1682: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1685: sipush -533
    //   1688: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1691: new 155	java/lang/StringBuilder
    //   1694: dup
    //   1695: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   1698: astore 14
    //   1700: aload 14
    //   1702: ldc_w 593
    //   1705: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1708: pop
    //   1709: aload 14
    //   1711: iload_3
    //   1712: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1715: pop
    //   1716: ldc 125
    //   1718: aload 14
    //   1720: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1723: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1726: getstatic 384	android/os/Build$VERSION:SDK_INT	I
    //   1729: bipush 11
    //   1731: if_icmplt +16 -> 1747
    //   1734: aload_2
    //   1735: ldc_w 386
    //   1738: iconst_4
    //   1739: invokevirtual 390	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   1742: astore 14
    //   1744: goto +13 -> 1757
    //   1747: aload_2
    //   1748: ldc_w 386
    //   1751: iconst_0
    //   1752: invokevirtual 390	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   1755: astore 14
    //   1757: aload 14
    //   1759: invokeinterface 597 1 0
    //   1764: astore 14
    //   1766: aload 14
    //   1768: ldc_w 599
    //   1771: iconst_0
    //   1772: invokeinterface 605 3 0
    //   1777: pop
    //   1778: aload 14
    //   1780: ldc_w 607
    //   1783: iconst_0
    //   1784: invokeinterface 605 3 0
    //   1789: pop
    //   1790: aload 14
    //   1792: ldc_w 609
    //   1795: iload_3
    //   1796: invokeinterface 605 3 0
    //   1801: pop
    //   1802: aload 14
    //   1804: invokeinterface 612 1 0
    //   1809: pop
    //   1810: goto +44 -> 1854
    //   1813: astore 14
    //   1815: new 155	java/lang/StringBuilder
    //   1818: dup
    //   1819: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   1822: astore 15
    //   1824: aload 15
    //   1826: ldc_w 614
    //   1829: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1832: pop
    //   1833: aload 15
    //   1835: aload 14
    //   1837: invokestatic 620	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1840: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1843: pop
    //   1844: ldc 125
    //   1846: aload 15
    //   1848: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1851: invokestatic 346	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1854: aload_2
    //   1855: invokestatic 621	com/tencent/smtt/utils/p:a	(Landroid/content/Context;)Z
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
    //   1879: invokevirtual 323	java/io/BufferedInputStream:close	()V
    //   1882: goto +10 -> 1892
    //   1885: astore 15
    //   1887: aload 15
    //   1889: invokevirtual 322	java/io/IOException:printStackTrace	()V
    //   1892: aload 14
    //   1894: athrow
    //   1895: ldc 125
    //   1897: ldc_w 623
    //   1900: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1903: aload_2
    //   1904: invokestatic 229	com/tencent/smtt/sdk/m:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/m;
    //   1907: iload_3
    //   1908: iconst_2
    //   1909: invokevirtual 493	com/tencent/smtt/sdk/m:a	(II)V
    //   1912: aload 13
    //   1914: iconst_0
    //   1915: invokestatic 141	com/tencent/smtt/utils/FileUtil:a	(Ljava/io/File;Z)V
    //   1918: aload_1
    //   1919: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1922: sipush -534
    //   1925: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1928: aload_2
    //   1929: invokestatic 199	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1932: sipush 212
    //   1935: ldc_w 625
    //   1938: invokevirtual 205	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1941: goto +173 -> 2114
    //   1944: aload 14
    //   1946: ifnonnull +29 -> 1975
    //   1949: aload_2
    //   1950: invokestatic 199	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1953: sipush 213
    //   1956: ldc_w 627
    //   1959: invokevirtual 205	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1962: aload_1
    //   1963: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1966: sipush -535
    //   1969: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1972: goto +3 -> 1975
    //   1975: aload 13
    //   1977: ifnonnull +137 -> 2114
    //   1980: aload_2
    //   1981: invokestatic 199	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1984: sipush 214
    //   1987: ldc_w 629
    //   1990: invokevirtual 205	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1993: aload_1
    //   1994: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1997: sipush -536
    //   2000: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   2003: goto +111 -> 2114
    //   2006: astore_1
    //   2007: goto +126 -> 2133
    //   2010: astore 13
    //   2012: aconst_null
    //   2013: astore 15
    //   2015: aload 13
    //   2017: astore 14
    //   2019: aload_2
    //   2020: invokestatic 199	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   2023: sipush 215
    //   2026: aload 14
    //   2028: invokevirtual 630	java/lang/Exception:toString	()Ljava/lang/String;
    //   2031: invokevirtual 205	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   2034: aload_1
    //   2035: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2038: sipush -537
    //   2041: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   2044: aload 15
    //   2046: iconst_0
    //   2047: invokestatic 141	com/tencent/smtt/utils/FileUtil:a	(Ljava/io/File;Z)V
    //   2050: aload_2
    //   2051: invokestatic 229	com/tencent/smtt/sdk/m:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/m;
    //   2054: iconst_0
    //   2055: iconst_m1
    //   2056: invokevirtual 493	com/tencent/smtt/sdk/m:a	(II)V
    //   2059: goto +55 -> 2114
    //   2062: astore_1
    //   2063: new 155	java/lang/StringBuilder
    //   2066: dup
    //   2067: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   2070: astore_2
    //   2071: aload_2
    //   2072: ldc_w 632
    //   2075: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2078: pop
    //   2079: aload_2
    //   2080: aload_1
    //   2081: invokevirtual 635	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2084: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2087: pop
    //   2088: aload_2
    //   2089: ldc_w 637
    //   2092: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2095: pop
    //   2096: aload_2
    //   2097: aload_1
    //   2098: invokevirtual 641	java/lang/Exception:getCause	()Ljava/lang/Throwable;
    //   2101: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2104: pop
    //   2105: ldc 125
    //   2107: aload_2
    //   2108: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2111: invokestatic 346	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2114: getstatic 41	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   2117: invokevirtual 435	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   2120: getstatic 43	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   2123: invokeinterface 436 1 0
    //   2128: aload_0
    //   2129: invokevirtual 438	com/tencent/smtt/sdk/p:b	()V
    //   2132: return
    //   2133: getstatic 41	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   2136: invokevirtual 435	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   2139: getstatic 43	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   2142: invokeinterface 436 1 0
    //   2147: aload_0
    //   2148: invokevirtual 438	com/tencent/smtt/sdk/p:b	()V
    //   2151: aload_1
    //   2152: athrow
    //   2153: aload_0
    //   2154: invokevirtual 438	com/tencent/smtt/sdk/p:b	()V
    //   2157: aload_1
    //   2158: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2161: sipush -538
    //   2164: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
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
    //   2212: ldc_w 642
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
    //   0: ldc 125
    //   2: ldc_w 656
    //   5: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   8: aload_2
    //   9: invokestatic 658	com/tencent/smtt/utils/FileUtil:c	(Ljava/io/File;)Z
    //   12: ifne +34 -> 46
    //   15: aload_1
    //   16: invokestatic 199	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   19: sipush 204
    //   22: ldc_w 660
    //   25: invokevirtual 205	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   28: aload_1
    //   29: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   32: astore_1
    //   33: sipush -520
    //   36: istore 4
    //   38: aload_1
    //   39: iload 4
    //   41: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   44: iconst_0
    //   45: ireturn
    //   46: aload_1
    //   47: invokestatic 268	com/tencent/smtt/sdk/QbSdk:getTbsFolderDir	(Landroid/content/Context;)Ljava/io/File;
    //   50: astore 9
    //   52: iload_3
    //   53: ifeq +20 -> 73
    //   56: new 149	java/io/File
    //   59: dup
    //   60: aload 9
    //   62: ldc_w 662
    //   65: invokespecial 273	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   68: astore 9
    //   70: goto +17 -> 87
    //   73: new 149	java/io/File
    //   76: dup
    //   77: aload 9
    //   79: ldc_w 270
    //   82: invokespecial 273	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   85: astore 9
    //   87: aload 9
    //   89: invokevirtual 523	java/io/File:exists	()Z
    //   92: ifeq +59 -> 151
    //   95: aload_1
    //   96: invokestatic 478	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   99: ifne +52 -> 151
    //   102: aload 9
    //   104: invokestatic 663	com/tencent/smtt/utils/FileUtil:b	(Ljava/io/File;)V
    //   107: goto +44 -> 151
    //   110: astore 9
    //   112: new 155	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   119: astore 10
    //   121: aload 10
    //   123: ldc_w 665
    //   126: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: aload 10
    //   132: aload 9
    //   134: invokestatic 620	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   137: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: ldc 125
    //   143: aload 10
    //   145: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokestatic 346	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   151: iload_3
    //   152: ifeq +14 -> 166
    //   155: aload_0
    //   156: aload_1
    //   157: iconst_2
    //   158: invokevirtual 147	com/tencent/smtt/sdk/p:f	(Landroid/content/Context;I)Ljava/io/File;
    //   161: astore 9
    //   163: goto +11 -> 174
    //   166: aload_0
    //   167: aload_1
    //   168: iconst_0
    //   169: invokevirtual 147	com/tencent/smtt/sdk/p:f	(Landroid/content/Context;I)Ljava/io/File;
    //   172: astore 9
    //   174: aload 9
    //   176: ifnonnull +29 -> 205
    //   179: aload_1
    //   180: invokestatic 199	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   183: sipush 205
    //   186: ldc_w 667
    //   189: invokevirtual 205	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   192: aload_1
    //   193: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   196: astore_1
    //   197: sipush -521
    //   200: istore 4
    //   202: goto -164 -> 38
    //   205: iconst_1
    //   206: istore 6
    //   208: iconst_1
    //   209: istore 5
    //   211: aload 9
    //   213: invokestatic 669	com/tencent/smtt/utils/FileUtil:a	(Ljava/io/File;)Z
    //   216: pop
    //   217: iload_3
    //   218: ifeq +9 -> 227
    //   221: aload 9
    //   223: iconst_1
    //   224: invokestatic 141	com/tencent/smtt/utils/FileUtil:a	(Ljava/io/File;Z)V
    //   227: aload_2
    //   228: aload 9
    //   230: invokestatic 672	com/tencent/smtt/utils/FileUtil:a	(Ljava/io/File;Ljava/io/File;)Z
    //   233: istore 8
    //   235: iload 8
    //   237: istore 7
    //   239: iload 8
    //   241: ifeq +12 -> 253
    //   244: aload_0
    //   245: aload 9
    //   247: aload_1
    //   248: invokespecial 675	com/tencent/smtt/sdk/p:a	(Ljava/io/File;Landroid/content/Context;)Z
    //   251: istore 7
    //   253: iload_3
    //   254: ifeq +84 -> 338
    //   257: aload 9
    //   259: invokevirtual 679	java/io/File:list	()[Ljava/lang/String;
    //   262: astore_2
    //   263: iconst_0
    //   264: istore 4
    //   266: iload 4
    //   268: aload_2
    //   269: arraylength
    //   270: if_icmpge +47 -> 317
    //   273: new 149	java/io/File
    //   276: dup
    //   277: aload 9
    //   279: aload_2
    //   280: iload 4
    //   282: aaload
    //   283: invokespecial 273	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   286: astore 10
    //   288: aload 10
    //   290: invokevirtual 531	java/io/File:getName	()Ljava/lang/String;
    //   293: ldc_w 533
    //   296: invokevirtual 537	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   299: ifeq +9 -> 308
    //   302: aload 10
    //   304: invokevirtual 258	java/io/File:delete	()Z
    //   307: pop
    //   308: iload 4
    //   310: iconst_1
    //   311: iadd
    //   312: istore 4
    //   314: goto -48 -> 266
    //   317: new 149	java/io/File
    //   320: dup
    //   321: aload_1
    //   322: invokestatic 682	com/tencent/smtt/sdk/p:s	(Landroid/content/Context;)Ljava/io/File;
    //   325: ldc_w 684
    //   328: invokespecial 273	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   331: invokevirtual 258	java/io/File:delete	()Z
    //   334: pop
    //   335: goto +3 -> 338
    //   338: iload 7
    //   340: ifne +56 -> 396
    //   343: aload 9
    //   345: invokestatic 663	com/tencent/smtt/utils/FileUtil:b	(Ljava/io/File;)V
    //   348: aload_1
    //   349: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   352: sipush -522
    //   355: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   358: new 155	java/lang/StringBuilder
    //   361: dup
    //   362: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   365: astore_2
    //   366: aload_2
    //   367: ldc_w 686
    //   370: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: pop
    //   374: aload_2
    //   375: aload 9
    //   377: invokevirtual 523	java/io/File:exists	()Z
    //   380: invokevirtual 165	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   383: pop
    //   384: ldc 125
    //   386: aload_2
    //   387: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   390: invokestatic 346	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   393: goto +35 -> 428
    //   396: aload_0
    //   397: aload_1
    //   398: iconst_1
    //   399: invokespecial 208	com/tencent/smtt/sdk/p:g	(Landroid/content/Context;Z)V
    //   402: iload_3
    //   403: ifeq +25 -> 428
    //   406: aload_0
    //   407: aload_1
    //   408: invokevirtual 491	com/tencent/smtt/sdk/p:p	(Landroid/content/Context;)Ljava/io/File;
    //   411: astore_2
    //   412: aload_2
    //   413: iconst_1
    //   414: invokestatic 141	com/tencent/smtt/utils/FileUtil:a	(Ljava/io/File;Z)V
    //   417: aload 9
    //   419: aload_2
    //   420: invokevirtual 153	java/io/File:renameTo	(Ljava/io/File;)Z
    //   423: pop
    //   424: aload_1
    //   425: invokestatic 508	com/tencent/smtt/sdk/TbsShareManager:b	(Landroid/content/Context;)V
    //   428: ldc 125
    //   430: ldc_w 688
    //   433: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   436: iload 7
    //   438: ireturn
    //   439: astore_1
    //   440: goto +293 -> 733
    //   443: astore_2
    //   444: aload_1
    //   445: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   448: sipush -523
    //   451: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   454: aload_1
    //   455: invokestatic 199	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   458: sipush 207
    //   461: aload_2
    //   462: invokevirtual 691	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/Throwable;)V
    //   465: aload 9
    //   467: ifnull +20 -> 487
    //   470: aload 9
    //   472: invokevirtual 523	java/io/File:exists	()Z
    //   475: istore_3
    //   476: iload_3
    //   477: ifeq +10 -> 487
    //   480: iload 5
    //   482: istore 4
    //   484: goto +6 -> 490
    //   487: iconst_0
    //   488: istore 4
    //   490: iload 4
    //   492: ifeq +86 -> 578
    //   495: aload 9
    //   497: ifnull +81 -> 578
    //   500: aload 9
    //   502: invokestatic 663	com/tencent/smtt/utils/FileUtil:b	(Ljava/io/File;)V
    //   505: new 155	java/lang/StringBuilder
    //   508: dup
    //   509: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   512: astore_1
    //   513: aload_1
    //   514: ldc_w 693
    //   517: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: pop
    //   521: aload_1
    //   522: aload 9
    //   524: invokevirtual 523	java/io/File:exists	()Z
    //   527: invokevirtual 165	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   530: pop
    //   531: ldc 125
    //   533: aload_1
    //   534: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   537: invokestatic 346	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   540: goto +38 -> 578
    //   543: astore_1
    //   544: new 155	java/lang/StringBuilder
    //   547: dup
    //   548: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   551: astore_2
    //   552: aload_2
    //   553: ldc_w 695
    //   556: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   559: pop
    //   560: aload_2
    //   561: aload_1
    //   562: invokestatic 620	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   565: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   568: pop
    //   569: ldc 125
    //   571: aload_2
    //   572: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   575: invokestatic 346	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   578: ldc 125
    //   580: ldc_w 688
    //   583: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   586: iconst_0
    //   587: ireturn
    //   588: astore_2
    //   589: aload_1
    //   590: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   593: sipush -523
    //   596: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   599: aload_1
    //   600: invokestatic 199	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   603: sipush 206
    //   606: aload_2
    //   607: invokevirtual 691	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/Throwable;)V
    //   610: aload 9
    //   612: ifnull +20 -> 632
    //   615: aload 9
    //   617: invokevirtual 523	java/io/File:exists	()Z
    //   620: istore_3
    //   621: iload_3
    //   622: ifeq +10 -> 632
    //   625: iload 6
    //   627: istore 4
    //   629: goto +6 -> 635
    //   632: iconst_0
    //   633: istore 4
    //   635: iload 4
    //   637: ifeq +86 -> 723
    //   640: aload 9
    //   642: ifnull +81 -> 723
    //   645: aload 9
    //   647: invokestatic 663	com/tencent/smtt/utils/FileUtil:b	(Ljava/io/File;)V
    //   650: new 155	java/lang/StringBuilder
    //   653: dup
    //   654: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   657: astore_1
    //   658: aload_1
    //   659: ldc_w 693
    //   662: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   665: pop
    //   666: aload_1
    //   667: aload 9
    //   669: invokevirtual 523	java/io/File:exists	()Z
    //   672: invokevirtual 165	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   675: pop
    //   676: ldc 125
    //   678: aload_1
    //   679: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   682: invokestatic 346	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   685: goto +38 -> 723
    //   688: astore_1
    //   689: new 155	java/lang/StringBuilder
    //   692: dup
    //   693: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   696: astore_2
    //   697: aload_2
    //   698: ldc_w 695
    //   701: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   704: pop
    //   705: aload_2
    //   706: aload_1
    //   707: invokestatic 620	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   710: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   713: pop
    //   714: ldc 125
    //   716: aload_2
    //   717: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   720: invokestatic 346	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   723: ldc 125
    //   725: ldc_w 688
    //   728: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   731: iconst_0
    //   732: ireturn
    //   733: ldc 125
    //   735: ldc_w 688
    //   738: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   741: goto +5 -> 746
    //   744: aload_1
    //   745: athrow
    //   746: goto -2 -> 744
    //   749: astore_2
    //   750: goto -412 -> 338
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	753	0	this	p
    //   0	753	1	paramContext	Context
    //   0	753	2	paramFile	File
    //   0	753	3	paramBoolean	boolean
    //   36	600	4	i1	int
    //   209	272	5	i2	int
    //   206	420	6	i3	int
    //   237	200	7	bool1	boolean
    //   233	7	8	bool2	boolean
    //   50	53	9	localFile1	File
    //   110	23	9	localThrowable	Throwable
    //   161	507	9	localFile2	File
    //   119	184	10	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   46	52	110	java/lang/Throwable
    //   56	70	110	java/lang/Throwable
    //   73	87	110	java/lang/Throwable
    //   87	107	110	java/lang/Throwable
    //   211	217	439	finally
    //   221	227	439	finally
    //   227	235	439	finally
    //   244	253	439	finally
    //   257	263	439	finally
    //   266	308	439	finally
    //   317	335	439	finally
    //   343	393	439	finally
    //   396	402	439	finally
    //   406	428	439	finally
    //   444	465	439	finally
    //   470	476	439	finally
    //   589	610	439	finally
    //   615	621	439	finally
    //   211	217	443	java/lang/Exception
    //   221	227	443	java/lang/Exception
    //   227	235	443	java/lang/Exception
    //   244	253	443	java/lang/Exception
    //   257	263	443	java/lang/Exception
    //   266	308	443	java/lang/Exception
    //   343	393	443	java/lang/Exception
    //   396	402	443	java/lang/Exception
    //   406	428	443	java/lang/Exception
    //   500	540	543	java/lang/Throwable
    //   211	217	588	java/io/IOException
    //   221	227	588	java/io/IOException
    //   227	235	588	java/io/IOException
    //   244	253	588	java/io/IOException
    //   257	263	588	java/io/IOException
    //   266	308	588	java/io/IOException
    //   317	335	588	java/io/IOException
    //   343	393	588	java/io/IOException
    //   396	402	588	java/io/IOException
    //   406	428	588	java/io/IOException
    //   645	685	688	java/lang/Throwable
    //   317	335	749	java/lang/Exception
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
    //   0: new 155	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   7: astore 6
    //   9: aload 6
    //   11: ldc_w 703
    //   14: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: pop
    //   18: aload 6
    //   20: aload_1
    //   21: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   24: pop
    //   25: aload 6
    //   27: ldc_w 705
    //   30: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload 6
    //   36: aload_2
    //   37: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: ldc 125
    //   43: aload 6
    //   45: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   51: aconst_null
    //   52: astore 7
    //   54: aconst_null
    //   55: astore 9
    //   57: aconst_null
    //   58: astore 6
    //   60: aload 7
    //   62: astore_2
    //   63: new 149	java/io/File
    //   66: dup
    //   67: aload_1
    //   68: ldc_w 520
    //   71: invokespecial 273	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   74: astore 10
    //   76: aload 7
    //   78: astore_2
    //   79: new 280	java/util/Properties
    //   82: dup
    //   83: invokespecial 281	java/util/Properties:<init>	()V
    //   86: astore 8
    //   88: aload 7
    //   90: astore_2
    //   91: aload 10
    //   93: invokevirtual 523	java/io/File:exists	()Z
    //   96: ifeq +62 -> 158
    //   99: aload 7
    //   101: astore_2
    //   102: new 283	java/io/BufferedInputStream
    //   105: dup
    //   106: new 285	java/io/FileInputStream
    //   109: dup
    //   110: aload 10
    //   112: invokespecial 288	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   115: invokespecial 291	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   118: astore 6
    //   120: aload 8
    //   122: aload 6
    //   124: invokevirtual 294	java/util/Properties:load	(Ljava/io/InputStream;)V
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
    //   177: invokevirtual 323	java/io/BufferedInputStream:close	()V
    //   180: iload 4
    //   182: istore 5
    //   184: aload 8
    //   186: astore 6
    //   188: goto +74 -> 262
    //   191: astore_2
    //   192: aload_2
    //   193: invokevirtual 322	java/io/IOException:printStackTrace	()V
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
    //   238: invokevirtual 524	java/lang/Exception:printStackTrace	()V
    //   241: aload 8
    //   243: ifnull +16 -> 259
    //   246: aload 8
    //   248: invokevirtual 323	java/io/BufferedInputStream:close	()V
    //   251: goto +8 -> 259
    //   254: astore_2
    //   255: aload_2
    //   256: invokevirtual 322	java/io/IOException:printStackTrace	()V
    //   259: iconst_1
    //   260: istore 5
    //   262: new 155	java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   269: astore_2
    //   270: aload_2
    //   271: ldc_w 707
    //   274: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: pop
    //   278: aload_2
    //   279: iload 5
    //   281: invokevirtual 165	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   284: pop
    //   285: ldc 125
    //   287: aload_2
    //   288: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   291: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   294: iload 5
    //   296: ifeq +258 -> 554
    //   299: aload_1
    //   300: invokevirtual 528	java/io/File:listFiles	()[Ljava/io/File;
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
    //   316: ldc_w 520
    //   319: aload_1
    //   320: invokevirtual 531	java/io/File:getName	()Ljava/lang/String;
    //   323: invokevirtual 193	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   326: ifne +221 -> 547
    //   329: aload_1
    //   330: invokevirtual 531	java/io/File:getName	()Ljava/lang/String;
    //   333: ldc_w 533
    //   336: invokevirtual 537	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   339: ifne +208 -> 547
    //   342: ldc_w 278
    //   345: aload_1
    //   346: invokevirtual 531	java/io/File:getName	()Ljava/lang/String;
    //   349: invokevirtual 193	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   352: ifne +195 -> 547
    //   355: aload_1
    //   356: invokevirtual 540	java/io/File:isDirectory	()Z
    //   359: ifne +188 -> 547
    //   362: aload_1
    //   363: invokevirtual 531	java/io/File:getName	()Ljava/lang/String;
    //   366: ldc_w 542
    //   369: invokevirtual 537	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   372: ifeq +6 -> 378
    //   375: goto +172 -> 547
    //   378: aload_1
    //   379: invokestatic 547	com/tencent/smtt/utils/a:a	(Ljava/io/File;)Ljava/lang/String;
    //   382: astore 7
    //   384: aload 6
    //   386: aload_1
    //   387: invokevirtual 531	java/io/File:getName	()Ljava/lang/String;
    //   390: ldc_w 549
    //   393: invokevirtual 553	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   396: astore 8
    //   398: aload 8
    //   400: ldc_w 549
    //   403: invokevirtual 193	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   406: ifne +63 -> 469
    //   409: aload 8
    //   411: aload 7
    //   413: invokevirtual 193	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   416: ifeq +53 -> 469
    //   419: new 155	java/lang/StringBuilder
    //   422: dup
    //   423: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   426: astore 7
    //   428: aload 7
    //   430: ldc_w 555
    //   433: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: pop
    //   437: aload 7
    //   439: aload_1
    //   440: invokevirtual 531	java/io/File:getName	()Ljava/lang/String;
    //   443: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: pop
    //   447: aload 7
    //   449: ldc_w 557
    //   452: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: pop
    //   456: ldc 125
    //   458: aload 7
    //   460: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   463: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   466: goto +81 -> 547
    //   469: new 155	java/lang/StringBuilder
    //   472: dup
    //   473: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   476: astore_2
    //   477: aload_2
    //   478: ldc_w 559
    //   481: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: pop
    //   485: aload_2
    //   486: aload_1
    //   487: invokevirtual 531	java/io/File:getName	()Ljava/lang/String;
    //   490: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: pop
    //   494: aload_2
    //   495: ldc_w 557
    //   498: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: pop
    //   502: aload_2
    //   503: ldc_w 561
    //   506: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: pop
    //   510: aload_2
    //   511: aload 8
    //   513: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: pop
    //   517: aload_2
    //   518: ldc_w 563
    //   521: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   524: pop
    //   525: aload_2
    //   526: aload 7
    //   528: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   531: pop
    //   532: ldc 125
    //   534: aload_2
    //   535: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   538: invokestatic 346	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   557: new 155	java/lang/StringBuilder
    //   560: dup
    //   561: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   564: astore_1
    //   565: aload_1
    //   566: ldc_w 709
    //   569: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   572: pop
    //   573: aload_1
    //   574: iload 4
    //   576: invokevirtual 165	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   579: pop
    //   580: ldc 125
    //   582: aload_1
    //   583: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   586: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   589: iload 5
    //   591: ifeq +18 -> 609
    //   594: iload 4
    //   596: ifne +13 -> 609
    //   599: ldc 125
    //   601: ldc_w 711
    //   604: invokestatic 346	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   607: iconst_0
    //   608: ireturn
    //   609: ldc 125
    //   611: ldc_w 713
    //   614: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   617: iconst_1
    //   618: ireturn
    //   619: aload_2
    //   620: ifnull +15 -> 635
    //   623: aload_2
    //   624: invokevirtual 323	java/io/BufferedInputStream:close	()V
    //   627: goto +8 -> 635
    //   630: astore_2
    //   631: aload_2
    //   632: invokevirtual 322	java/io/IOException:printStackTrace	()V
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
  
  /* Error */
  @android.annotation.TargetApi(11)
  private void b(Context paramContext, String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4: sipush -501
    //   7: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   10: aload_0
    //   11: aload_1
    //   12: invokevirtual 374	com/tencent/smtt/sdk/p:c	(Landroid/content/Context;)Z
    //   15: istore 9
    //   17: iconst_1
    //   18: istore 7
    //   20: iconst_1
    //   21: invokestatic 718	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   24: astore 16
    //   26: iload 9
    //   28: ifeq +23 -> 51
    //   31: ldc 125
    //   33: ldc_w 720
    //   36: iconst_1
    //   37: invokestatic 265	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   40: aload_1
    //   41: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   44: sipush -502
    //   47: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   50: return
    //   51: new 155	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   58: astore 14
    //   60: aload 14
    //   62: ldc_w 722
    //   65: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload 14
    //   71: aload_2
    //   72: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: ldc 125
    //   78: aload 14
    //   80: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   86: new 155	java/lang/StringBuilder
    //   89: dup
    //   90: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   93: astore 14
    //   95: aload 14
    //   97: ldc_w 724
    //   100: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: aload 14
    //   106: iload_3
    //   107: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: ldc 125
    //   113: aload 14
    //   115: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   121: new 155	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   128: astore 14
    //   130: aload 14
    //   132: ldc_w 726
    //   135: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: aload 14
    //   141: aload_1
    //   142: invokevirtual 181	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   145: getfield 729	android/content/pm/ApplicationInfo:processName	Ljava/lang/String;
    //   148: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: ldc 125
    //   154: aload 14
    //   156: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   162: new 155	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   169: astore 14
    //   171: aload 14
    //   173: ldc_w 731
    //   176: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: aload 14
    //   182: invokestatic 736	android/os/Process:myPid	()I
    //   185: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: ldc 125
    //   191: aload 14
    //   193: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   196: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   199: new 155	java/lang/StringBuilder
    //   202: dup
    //   203: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   206: astore 14
    //   208: aload 14
    //   210: ldc_w 738
    //   213: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: pop
    //   217: aload 14
    //   219: invokestatic 744	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   222: invokevirtual 745	java/lang/Thread:getName	()Ljava/lang/String;
    //   225: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: pop
    //   229: ldc 125
    //   231: aload 14
    //   233: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   239: getstatic 384	android/os/Build$VERSION:SDK_INT	I
    //   242: bipush 11
    //   244: if_icmplt +16 -> 260
    //   247: aload_1
    //   248: ldc_w 386
    //   251: iconst_4
    //   252: invokevirtual 390	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   255: astore 14
    //   257: goto +13 -> 270
    //   260: aload_1
    //   261: ldc_w 386
    //   264: iconst_0
    //   265: invokevirtual 390	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   268: astore 14
    //   270: aload 14
    //   272: ldc_w 392
    //   275: iconst_m1
    //   276: invokeinterface 398 3 0
    //   281: iload_3
    //   282: if_icmpne +53 -> 335
    //   285: new 155	java/lang/StringBuilder
    //   288: dup
    //   289: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   292: astore_2
    //   293: aload_2
    //   294: ldc_w 747
    //   297: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: pop
    //   301: aload_2
    //   302: iload_3
    //   303: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   306: pop
    //   307: aload_2
    //   308: ldc_w 402
    //   311: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: pop
    //   315: ldc 125
    //   317: aload_2
    //   318: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   321: invokestatic 346	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   324: aload_1
    //   325: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   328: sipush -503
    //   331: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   334: return
    //   335: aload_1
    //   336: invokestatic 454	com/tencent/smtt/utils/FileUtil:b	(Landroid/content/Context;)Z
    //   339: ifne +82 -> 421
    //   342: invokestatic 459	com/tencent/smtt/utils/p:a	()J
    //   345: lstore 10
    //   347: aload_1
    //   348: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   351: invokevirtual 462	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMinFreeSpace	()J
    //   354: lstore 12
    //   356: aload_1
    //   357: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   360: sipush -504
    //   363: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   366: aload_1
    //   367: invokestatic 199	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   370: astore_1
    //   371: new 155	java/lang/StringBuilder
    //   374: dup
    //   375: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   378: astore_2
    //   379: aload_2
    //   380: ldc_w 749
    //   383: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: pop
    //   387: aload_2
    //   388: lload 10
    //   390: invokevirtual 467	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   393: pop
    //   394: aload_2
    //   395: ldc_w 469
    //   398: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: pop
    //   402: aload_2
    //   403: lload 12
    //   405: invokevirtual 467	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   408: pop
    //   409: aload_1
    //   410: sipush 210
    //   413: aload_2
    //   414: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   417: invokevirtual 205	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   420: return
    //   421: aload_0
    //   422: aload_1
    //   423: invokevirtual 405	com/tencent/smtt/sdk/p:t	(Landroid/content/Context;)Z
    //   426: ifne +14 -> 440
    //   429: aload_1
    //   430: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   433: sipush -505
    //   436: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   439: return
    //   440: getstatic 43	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   443: invokeinterface 410 1 0
    //   448: istore 9
    //   450: new 155	java/lang/StringBuilder
    //   453: dup
    //   454: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   457: astore 14
    //   459: aload 14
    //   461: ldc_w 751
    //   464: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: pop
    //   468: aload 14
    //   470: iload 9
    //   472: invokevirtual 165	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   475: pop
    //   476: ldc 125
    //   478: aload 14
    //   480: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   483: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   486: iload 9
    //   488: ifeq +2080 -> 2568
    //   491: aload_1
    //   492: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   495: sipush -507
    //   498: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   501: getstatic 41	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   504: invokevirtual 415	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   507: aload_1
    //   508: invokestatic 229	com/tencent/smtt/sdk/m:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/m;
    //   511: ldc_w 417
    //   514: invokevirtual 420	com/tencent/smtt/sdk/m:c	(Ljava/lang/String;)I
    //   517: istore 4
    //   519: aload_1
    //   520: invokestatic 229	com/tencent/smtt/sdk/m:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/m;
    //   523: invokevirtual 448	com/tencent/smtt/sdk/m:b	()I
    //   526: istore 5
    //   528: new 155	java/lang/StringBuilder
    //   531: dup
    //   532: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   535: astore 14
    //   537: aload 14
    //   539: ldc_w 753
    //   542: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   545: pop
    //   546: aload 14
    //   548: iload 4
    //   550: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   553: pop
    //   554: ldc 125
    //   556: aload 14
    //   558: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   561: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   564: new 155	java/lang/StringBuilder
    //   567: dup
    //   568: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   571: astore 14
    //   573: aload 14
    //   575: ldc_w 755
    //   578: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: pop
    //   582: aload 14
    //   584: iload 5
    //   586: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   589: pop
    //   590: ldc 125
    //   592: aload 14
    //   594: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   597: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   600: new 155	java/lang/StringBuilder
    //   603: dup
    //   604: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   607: astore 14
    //   609: aload 14
    //   611: ldc_w 757
    //   614: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   617: pop
    //   618: aload 14
    //   620: iload_3
    //   621: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   624: pop
    //   625: ldc 125
    //   627: aload 14
    //   629: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   632: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   635: iload 5
    //   637: ifle +9 -> 646
    //   640: iload_3
    //   641: iload 5
    //   643: if_icmpgt +14 -> 657
    //   646: iload 4
    //   648: ifle +21 -> 669
    //   651: iload_3
    //   652: iload 4
    //   654: if_icmple +15 -> 669
    //   657: aload_0
    //   658: aload_1
    //   659: invokevirtual 450	com/tencent/smtt/sdk/p:o	(Landroid/content/Context;)V
    //   662: goto +7 -> 669
    //   665: astore_1
    //   666: goto +1849 -> 2515
    //   669: aload_1
    //   670: invokestatic 229	com/tencent/smtt/sdk/m:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/m;
    //   673: invokevirtual 759	com/tencent/smtt/sdk/m:c	()I
    //   676: istore 5
    //   678: aload_0
    //   679: aload_1
    //   680: invokevirtual 441	com/tencent/smtt/sdk/p:i	(Landroid/content/Context;)I
    //   683: istore 4
    //   685: new 155	java/lang/StringBuilder
    //   688: dup
    //   689: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   692: astore 14
    //   694: aload 14
    //   696: ldc_w 761
    //   699: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   702: pop
    //   703: aload 14
    //   705: iload 5
    //   707: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   710: pop
    //   711: ldc 125
    //   713: aload 14
    //   715: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   718: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   721: new 155	java/lang/StringBuilder
    //   724: dup
    //   725: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   728: astore 14
    //   730: aload 14
    //   732: ldc_w 763
    //   735: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   738: pop
    //   739: aload 14
    //   741: iload 4
    //   743: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   746: pop
    //   747: ldc 125
    //   749: aload 14
    //   751: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   754: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   757: iload 5
    //   759: iflt +1824 -> 2583
    //   762: iload 5
    //   764: iconst_2
    //   765: if_icmpge +1818 -> 2583
    //   768: ldc 125
    //   770: ldc_w 765
    //   773: iconst_1
    //   774: invokestatic 265	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   777: iconst_1
    //   778: istore 4
    //   780: goto +29 -> 809
    //   783: aload_0
    //   784: aload_1
    //   785: invokevirtual 450	com/tencent/smtt/sdk/p:o	(Landroid/content/Context;)V
    //   788: ldc 125
    //   790: ldc_w 767
    //   793: iconst_1
    //   794: invokestatic 265	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   797: iconst_0
    //   798: istore 4
    //   800: iconst_m1
    //   801: istore 5
    //   803: goto +6 -> 809
    //   806: iconst_0
    //   807: istore 4
    //   809: aload_1
    //   810: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   813: sipush -508
    //   816: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   819: new 155	java/lang/StringBuilder
    //   822: dup
    //   823: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   826: astore 14
    //   828: aload 14
    //   830: ldc_w 769
    //   833: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   836: pop
    //   837: aload 14
    //   839: iload 5
    //   841: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   844: pop
    //   845: ldc 125
    //   847: aload 14
    //   849: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   852: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   855: iload 5
    //   857: iconst_1
    //   858: if_icmpge +998 -> 1856
    //   861: ldc 125
    //   863: ldc_w 771
    //   866: iconst_1
    //   867: invokestatic 265	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   870: aload_1
    //   871: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   874: sipush -509
    //   877: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   880: iload 4
    //   882: ifeq +94 -> 976
    //   885: aload_1
    //   886: invokestatic 229	com/tencent/smtt/sdk/m:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/m;
    //   889: ldc_w 773
    //   892: invokevirtual 420	com/tencent/smtt/sdk/m:c	(Ljava/lang/String;)I
    //   895: istore 6
    //   897: iload 6
    //   899: bipush 10
    //   901: if_icmple +64 -> 965
    //   904: aload_1
    //   905: invokestatic 199	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   908: sipush 201
    //   911: ldc_w 775
    //   914: invokevirtual 205	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   917: aload_0
    //   918: aload_1
    //   919: invokespecial 777	com/tencent/smtt/sdk/p:E	(Landroid/content/Context;)V
    //   922: aload_1
    //   923: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   926: sipush -510
    //   929: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   932: getstatic 41	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   935: invokevirtual 435	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   938: getstatic 43	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   941: invokeinterface 436 1 0
    //   946: goto +8 -> 954
    //   949: astore_1
    //   950: aload_1
    //   951: invokevirtual 524	java/lang/Exception:printStackTrace	()V
    //   954: aload_0
    //   955: invokevirtual 438	com/tencent/smtt/sdk/p:b	()V
    //   958: return
    //   959: astore_1
    //   960: aload_1
    //   961: invokevirtual 524	java/lang/Exception:printStackTrace	()V
    //   964: return
    //   965: aload_1
    //   966: invokestatic 229	com/tencent/smtt/sdk/m:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/m;
    //   969: iload 6
    //   971: iconst_1
    //   972: iadd
    //   973: invokevirtual 779	com/tencent/smtt/sdk/m:b	(I)V
    //   976: aload_2
    //   977: ifnonnull +80 -> 1057
    //   980: aload_1
    //   981: invokestatic 229	com/tencent/smtt/sdk/m:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/m;
    //   984: ldc_w 781
    //   987: invokevirtual 784	com/tencent/smtt/sdk/m:d	(Ljava/lang/String;)Ljava/lang/String;
    //   990: astore 15
    //   992: aload 15
    //   994: astore 14
    //   996: aload 15
    //   998: ifnonnull +62 -> 1060
    //   1001: aload_1
    //   1002: invokestatic 199	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1005: sipush 202
    //   1008: ldc_w 786
    //   1011: invokevirtual 205	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1014: aload_1
    //   1015: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1018: sipush -511
    //   1021: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1024: getstatic 41	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1027: invokevirtual 435	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1030: getstatic 43	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   1033: invokeinterface 436 1 0
    //   1038: goto +8 -> 1046
    //   1041: astore_1
    //   1042: aload_1
    //   1043: invokevirtual 524	java/lang/Exception:printStackTrace	()V
    //   1046: aload_0
    //   1047: invokevirtual 438	com/tencent/smtt/sdk/p:b	()V
    //   1050: return
    //   1051: astore_1
    //   1052: aload_1
    //   1053: invokevirtual 524	java/lang/Exception:printStackTrace	()V
    //   1056: return
    //   1057: aload_2
    //   1058: astore 14
    //   1060: new 155	java/lang/StringBuilder
    //   1063: dup
    //   1064: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   1067: astore 15
    //   1069: aload 15
    //   1071: ldc_w 788
    //   1074: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1077: pop
    //   1078: aload 15
    //   1080: aload 14
    //   1082: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1085: pop
    //   1086: ldc 125
    //   1088: aload 15
    //   1090: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1093: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1096: aload_0
    //   1097: aload_1
    //   1098: aload 14
    //   1100: invokevirtual 791	com/tencent/smtt/sdk/p:c	(Landroid/content/Context;Ljava/lang/String;)I
    //   1103: istore 8
    //   1105: iload 8
    //   1107: ifne +59 -> 1166
    //   1110: aload_1
    //   1111: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1114: sipush -512
    //   1117: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1120: aload_1
    //   1121: invokestatic 199	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1124: sipush 203
    //   1127: ldc_w 793
    //   1130: invokevirtual 205	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1133: getstatic 41	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1136: invokevirtual 435	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1139: getstatic 43	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   1142: invokeinterface 436 1 0
    //   1147: goto +8 -> 1155
    //   1150: astore_1
    //   1151: aload_1
    //   1152: invokevirtual 524	java/lang/Exception:printStackTrace	()V
    //   1155: aload_0
    //   1156: invokevirtual 438	com/tencent/smtt/sdk/p:b	()V
    //   1159: return
    //   1160: astore_1
    //   1161: aload_1
    //   1162: invokevirtual 524	java/lang/Exception:printStackTrace	()V
    //   1165: return
    //   1166: aload_1
    //   1167: invokestatic 229	com/tencent/smtt/sdk/m:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/m;
    //   1170: ldc_w 781
    //   1173: aload 14
    //   1175: invokevirtual 795	com/tencent/smtt/sdk/m:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1178: aload_1
    //   1179: invokestatic 229	com/tencent/smtt/sdk/m:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/m;
    //   1182: iload 8
    //   1184: iconst_0
    //   1185: invokevirtual 232	com/tencent/smtt/sdk/m:c	(II)V
    //   1188: aload_1
    //   1189: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1192: sipush -548
    //   1195: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1198: aload_1
    //   1199: invokestatic 478	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   1202: ifeq +70 -> 1272
    //   1205: aload_0
    //   1206: aload_1
    //   1207: new 149	java/io/File
    //   1210: dup
    //   1211: aload 14
    //   1213: invokespecial 254	java/io/File:<init>	(Ljava/lang/String;)V
    //   1216: iconst_1
    //   1217: invokespecial 654	com/tencent/smtt/sdk/p:a	(Landroid/content/Context;Ljava/io/File;Z)Z
    //   1220: ifne +115 -> 1335
    //   1223: aload_1
    //   1224: invokestatic 199	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1227: sipush 207
    //   1230: ldc_w 797
    //   1233: getstatic 803	com/tencent/smtt/sdk/TbsLogReport$EventType:TYPE_INSTALL_DECOUPLE	Lcom/tencent/smtt/sdk/TbsLogReport$EventType;
    //   1236: invokevirtual 806	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;Lcom/tencent/smtt/sdk/TbsLogReport$EventType;)V
    //   1239: getstatic 41	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1242: invokevirtual 435	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1245: getstatic 43	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   1248: invokeinterface 436 1 0
    //   1253: goto +8 -> 1261
    //   1256: astore_1
    //   1257: aload_1
    //   1258: invokevirtual 524	java/lang/Exception:printStackTrace	()V
    //   1261: aload_0
    //   1262: invokevirtual 438	com/tencent/smtt/sdk/p:b	()V
    //   1265: return
    //   1266: astore_1
    //   1267: aload_1
    //   1268: invokevirtual 524	java/lang/Exception:printStackTrace	()V
    //   1271: return
    //   1272: aload_0
    //   1273: aload_1
    //   1274: new 149	java/io/File
    //   1277: dup
    //   1278: aload 14
    //   1280: invokespecial 254	java/io/File:<init>	(Ljava/lang/String;)V
    //   1283: invokespecial 808	com/tencent/smtt/sdk/p:a	(Landroid/content/Context;Ljava/io/File;)Z
    //   1286: ifne +49 -> 1335
    //   1289: aload_1
    //   1290: invokestatic 199	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1293: sipush 207
    //   1296: ldc_w 797
    //   1299: invokevirtual 205	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1302: getstatic 41	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1305: invokevirtual 435	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1308: getstatic 43	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   1311: invokeinterface 436 1 0
    //   1316: goto +8 -> 1324
    //   1319: astore_1
    //   1320: aload_1
    //   1321: invokevirtual 524	java/lang/Exception:printStackTrace	()V
    //   1324: aload_0
    //   1325: invokevirtual 438	com/tencent/smtt/sdk/p:b	()V
    //   1328: return
    //   1329: astore_1
    //   1330: aload_1
    //   1331: invokevirtual 524	java/lang/Exception:printStackTrace	()V
    //   1334: return
    //   1335: iload 4
    //   1337: ifeq +140 -> 1477
    //   1340: aload_1
    //   1341: invokestatic 229	com/tencent/smtt/sdk/m:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/m;
    //   1344: ldc_w 810
    //   1347: invokevirtual 424	com/tencent/smtt/sdk/m:b	(Ljava/lang/String;)I
    //   1350: istore 6
    //   1352: iload 6
    //   1354: iconst_5
    //   1355: if_icmple +111 -> 1466
    //   1358: aload_1
    //   1359: invokestatic 199	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1362: sipush 223
    //   1365: ldc_w 812
    //   1368: invokevirtual 205	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1371: aload_1
    //   1372: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1375: sipush -553
    //   1378: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1381: aload_0
    //   1382: aload_1
    //   1383: invokespecial 777	com/tencent/smtt/sdk/p:E	(Landroid/content/Context;)V
    //   1386: aload_1
    //   1387: invokestatic 814	com/tencent/smtt/sdk/l:c	(Landroid/content/Context;)V
    //   1390: aload_1
    //   1391: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1394: getfield 818	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1397: ldc_w 820
    //   1400: aload 16
    //   1402: invokeinterface 826 3 0
    //   1407: pop
    //   1408: aload_1
    //   1409: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1412: getfield 818	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1415: ldc_w 828
    //   1418: aload 16
    //   1420: invokeinterface 826 3 0
    //   1425: pop
    //   1426: aload_1
    //   1427: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1430: invokevirtual 830	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1433: getstatic 41	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1436: invokevirtual 435	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1439: getstatic 43	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   1442: invokeinterface 436 1 0
    //   1447: goto +8 -> 1455
    //   1450: astore_1
    //   1451: aload_1
    //   1452: invokevirtual 524	java/lang/Exception:printStackTrace	()V
    //   1455: aload_0
    //   1456: invokevirtual 438	com/tencent/smtt/sdk/p:b	()V
    //   1459: return
    //   1460: astore_1
    //   1461: aload_1
    //   1462: invokevirtual 524	java/lang/Exception:printStackTrace	()V
    //   1465: return
    //   1466: aload_1
    //   1467: invokestatic 229	com/tencent/smtt/sdk/m:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/m;
    //   1470: iload 6
    //   1472: iconst_1
    //   1473: iadd
    //   1474: invokevirtual 832	com/tencent/smtt/sdk/m:d	(I)V
    //   1477: ldc 125
    //   1479: ldc_w 834
    //   1482: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1485: invokestatic 837	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	()Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1488: getfield 841	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   1491: ldc_w 843
    //   1494: iconst_0
    //   1495: invokeinterface 398 3 0
    //   1500: istore 6
    //   1502: aload_0
    //   1503: aload_1
    //   1504: invokevirtual 441	com/tencent/smtt/sdk/p:i	(Landroid/content/Context;)I
    //   1507: ifeq +324 -> 1831
    //   1510: aload_1
    //   1511: ldc_w 845
    //   1514: aconst_null
    //   1515: invokestatic 848	com/tencent/smtt/sdk/QbSdk:a	(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;)Ljava/lang/Object;
    //   1518: astore 14
    //   1520: aload 14
    //   1522: ifnull +1088 -> 2610
    //   1525: aload 14
    //   1527: instanceof 715
    //   1530: ifeq +1080 -> 2610
    //   1533: aload 14
    //   1535: checkcast 715	java/lang/Boolean
    //   1538: invokevirtual 851	java/lang/Boolean:booleanValue	()Z
    //   1541: istore 9
    //   1543: goto +3 -> 1546
    //   1546: iload 9
    //   1548: ifeq +283 -> 1831
    //   1551: new 853	android/os/Bundle
    //   1554: dup
    //   1555: invokespecial 854	android/os/Bundle:<init>	()V
    //   1558: astore 15
    //   1560: aload 15
    //   1562: ldc_w 856
    //   1565: iload 6
    //   1567: invokevirtual 858	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1570: aload_1
    //   1571: invokestatic 478	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   1574: ifeq +26 -> 1600
    //   1577: aload_0
    //   1578: aload_1
    //   1579: invokevirtual 491	com/tencent/smtt/sdk/p:p	(Landroid/content/Context;)Ljava/io/File;
    //   1582: invokevirtual 861	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1585: astore 14
    //   1587: aload 15
    //   1589: ldc_w 863
    //   1592: aload 14
    //   1594: invokevirtual 866	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1597: goto +17 -> 1614
    //   1600: aload_0
    //   1601: aload_1
    //   1602: iconst_0
    //   1603: invokevirtual 147	com/tencent/smtt/sdk/p:f	(Landroid/content/Context;I)Ljava/io/File;
    //   1606: invokevirtual 861	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1609: astore 14
    //   1611: goto -24 -> 1587
    //   1614: aload_1
    //   1615: ldc_w 868
    //   1618: aload 15
    //   1620: invokestatic 848	com/tencent/smtt/sdk/QbSdk:a	(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;)Ljava/lang/Object;
    //   1623: astore 14
    //   1625: aload 14
    //   1627: ifnonnull +35 -> 1662
    //   1630: ldc 125
    //   1632: ldc_w 870
    //   1635: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1638: aload_1
    //   1639: invokestatic 199	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1642: astore 14
    //   1644: ldc_w 872
    //   1647: astore 15
    //   1649: aload 14
    //   1651: sipush 222
    //   1654: aload 15
    //   1656: invokevirtual 205	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1659: goto +131 -> 1790
    //   1662: aload 14
    //   1664: instanceof 715
    //   1667: ifeq +47 -> 1714
    //   1670: aload 14
    //   1672: checkcast 715	java/lang/Boolean
    //   1675: invokevirtual 851	java/lang/Boolean:booleanValue	()Z
    //   1678: ifeq +14 -> 1692
    //   1681: ldc 125
    //   1683: ldc_w 874
    //   1686: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1689: goto +927 -> 2616
    //   1692: ldc 125
    //   1694: ldc_w 876
    //   1697: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1700: aload_1
    //   1701: invokestatic 199	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1704: astore 14
    //   1706: ldc_w 876
    //   1709: astore 15
    //   1711: goto -62 -> 1649
    //   1714: aload 14
    //   1716: instanceof 853
    //   1719: ifeq +6 -> 1725
    //   1722: goto +894 -> 2616
    //   1725: aload 14
    //   1727: instanceof 249
    //   1730: ifeq +60 -> 1790
    //   1733: new 155	java/lang/StringBuilder
    //   1736: dup
    //   1737: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   1740: astore 15
    //   1742: aload 15
    //   1744: ldc_w 878
    //   1747: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1750: pop
    //   1751: aload 15
    //   1753: aload 14
    //   1755: checkcast 249	java/lang/Throwable
    //   1758: invokestatic 620	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1761: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1764: pop
    //   1765: ldc 125
    //   1767: aload 15
    //   1769: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1772: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1775: aload_1
    //   1776: invokestatic 199	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1779: sipush 222
    //   1782: aload 14
    //   1784: checkcast 249	java/lang/Throwable
    //   1787: invokevirtual 691	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/Throwable;)V
    //   1790: iconst_0
    //   1791: istore 6
    //   1793: iload 6
    //   1795: ifne +36 -> 1831
    //   1798: getstatic 41	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1801: invokevirtual 435	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1804: getstatic 43	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   1807: invokeinterface 436 1 0
    //   1812: goto +8 -> 1820
    //   1815: astore_1
    //   1816: aload_1
    //   1817: invokevirtual 524	java/lang/Exception:printStackTrace	()V
    //   1820: aload_0
    //   1821: invokevirtual 438	com/tencent/smtt/sdk/p:b	()V
    //   1824: return
    //   1825: astore_1
    //   1826: aload_1
    //   1827: invokevirtual 524	java/lang/Exception:printStackTrace	()V
    //   1830: return
    //   1831: ldc 125
    //   1833: ldc_w 880
    //   1836: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1839: aload_1
    //   1840: invokestatic 229	com/tencent/smtt/sdk/m:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/m;
    //   1843: iload 8
    //   1845: iconst_1
    //   1846: invokevirtual 232	com/tencent/smtt/sdk/m:c	(II)V
    //   1849: iload 8
    //   1851: istore 6
    //   1853: goto +117 -> 1970
    //   1856: aload_1
    //   1857: invokestatic 478	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   1860: istore 9
    //   1862: iload 9
    //   1864: ifeq +758 -> 2622
    //   1867: aload_2
    //   1868: ifnonnull +80 -> 1948
    //   1871: aload_1
    //   1872: invokestatic 229	com/tencent/smtt/sdk/m:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/m;
    //   1875: ldc_w 781
    //   1878: invokevirtual 784	com/tencent/smtt/sdk/m:d	(Ljava/lang/String;)Ljava/lang/String;
    //   1881: astore 15
    //   1883: aload 15
    //   1885: astore 14
    //   1887: aload 15
    //   1889: ifnonnull +62 -> 1951
    //   1892: aload_1
    //   1893: invokestatic 199	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1896: sipush 202
    //   1899: ldc_w 786
    //   1902: invokevirtual 205	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1905: aload_1
    //   1906: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1909: sipush -511
    //   1912: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1915: getstatic 41	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1918: invokevirtual 435	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1921: getstatic 43	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   1924: invokeinterface 436 1 0
    //   1929: goto +8 -> 1937
    //   1932: astore_1
    //   1933: aload_1
    //   1934: invokevirtual 524	java/lang/Exception:printStackTrace	()V
    //   1937: aload_0
    //   1938: invokevirtual 438	com/tencent/smtt/sdk/p:b	()V
    //   1941: return
    //   1942: astore_1
    //   1943: aload_1
    //   1944: invokevirtual 524	java/lang/Exception:printStackTrace	()V
    //   1947: return
    //   1948: aload_2
    //   1949: astore 14
    //   1951: aload_0
    //   1952: aload_1
    //   1953: new 149	java/io/File
    //   1956: dup
    //   1957: aload 14
    //   1959: invokespecial 254	java/io/File:<init>	(Ljava/lang/String;)V
    //   1962: iconst_1
    //   1963: invokespecial 654	com/tencent/smtt/sdk/p:a	(Landroid/content/Context;Ljava/io/File;Z)Z
    //   1966: pop
    //   1967: goto +655 -> 2622
    //   1970: iload 5
    //   1972: iconst_2
    //   1973: if_icmpge +460 -> 2433
    //   1976: iload 4
    //   1978: ifeq +94 -> 2072
    //   1981: aload_1
    //   1982: invokestatic 229	com/tencent/smtt/sdk/m:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/m;
    //   1985: ldc_w 882
    //   1988: invokevirtual 420	com/tencent/smtt/sdk/m:c	(Ljava/lang/String;)I
    //   1991: istore 4
    //   1993: iload 4
    //   1995: bipush 10
    //   1997: if_icmple +64 -> 2061
    //   2000: aload_1
    //   2001: invokestatic 199	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   2004: sipush 208
    //   2007: ldc_w 884
    //   2010: invokevirtual 205	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   2013: aload_1
    //   2014: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2017: sipush -514
    //   2020: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   2023: aload_0
    //   2024: aload_1
    //   2025: invokespecial 777	com/tencent/smtt/sdk/p:E	(Landroid/content/Context;)V
    //   2028: getstatic 41	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   2031: invokevirtual 435	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   2034: getstatic 43	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   2037: invokeinterface 436 1 0
    //   2042: goto +8 -> 2050
    //   2045: astore_1
    //   2046: aload_1
    //   2047: invokevirtual 524	java/lang/Exception:printStackTrace	()V
    //   2050: aload_0
    //   2051: invokevirtual 438	com/tencent/smtt/sdk/p:b	()V
    //   2054: return
    //   2055: astore_1
    //   2056: aload_1
    //   2057: invokevirtual 524	java/lang/Exception:printStackTrace	()V
    //   2060: return
    //   2061: aload_1
    //   2062: invokestatic 229	com/tencent/smtt/sdk/m:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/m;
    //   2065: iload 4
    //   2067: iconst_1
    //   2068: iadd
    //   2069: invokevirtual 886	com/tencent/smtt/sdk/m:a	(I)V
    //   2072: aload_1
    //   2073: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2076: sipush -549
    //   2079: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   2082: aload_0
    //   2083: aload_1
    //   2084: iconst_0
    //   2085: invokespecial 889	com/tencent/smtt/sdk/p:j	(Landroid/content/Context;I)Z
    //   2088: istore 9
    //   2090: iload 9
    //   2092: ifne +46 -> 2138
    //   2095: aload_1
    //   2096: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2099: sipush -515
    //   2102: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   2105: getstatic 41	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   2108: invokevirtual 435	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   2111: getstatic 43	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   2114: invokeinterface 436 1 0
    //   2119: goto +8 -> 2127
    //   2122: astore_1
    //   2123: aload_1
    //   2124: invokevirtual 524	java/lang/Exception:printStackTrace	()V
    //   2127: aload_0
    //   2128: invokevirtual 438	com/tencent/smtt/sdk/p:b	()V
    //   2131: return
    //   2132: astore_1
    //   2133: aload_1
    //   2134: invokevirtual 524	java/lang/Exception:printStackTrace	()V
    //   2137: return
    //   2138: aload_1
    //   2139: invokestatic 229	com/tencent/smtt/sdk/m:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/m;
    //   2142: iload 6
    //   2144: iconst_2
    //   2145: invokevirtual 232	com/tencent/smtt/sdk/m:c	(II)V
    //   2148: ldc 125
    //   2150: ldc_w 891
    //   2153: iconst_1
    //   2154: invokestatic 265	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   2157: new 155	java/lang/StringBuilder
    //   2160: dup
    //   2161: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   2164: astore 14
    //   2166: aload 14
    //   2168: ldc_w 893
    //   2171: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2174: pop
    //   2175: aload 14
    //   2177: iload_3
    //   2178: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2181: pop
    //   2182: ldc 125
    //   2184: aload 14
    //   2186: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2189: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2192: aload_1
    //   2193: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2196: sipush -516
    //   2199: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   2202: getstatic 384	android/os/Build$VERSION:SDK_INT	I
    //   2205: istore 4
    //   2207: iload 4
    //   2209: bipush 11
    //   2211: if_icmplt +16 -> 2227
    //   2214: aload_1
    //   2215: ldc_w 386
    //   2218: iconst_4
    //   2219: invokevirtual 390	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   2222: astore 14
    //   2224: goto +13 -> 2237
    //   2227: aload_1
    //   2228: ldc_w 386
    //   2231: iconst_0
    //   2232: invokevirtual 390	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   2235: astore 14
    //   2237: aload 14
    //   2239: invokeinterface 597 1 0
    //   2244: astore 14
    //   2246: aload 14
    //   2248: ldc_w 599
    //   2251: iconst_0
    //   2252: invokeinterface 605 3 0
    //   2257: pop
    //   2258: aload 14
    //   2260: ldc_w 607
    //   2263: iconst_0
    //   2264: invokeinterface 605 3 0
    //   2269: pop
    //   2270: aload 14
    //   2272: ldc_w 609
    //   2275: iload_3
    //   2276: invokeinterface 605 3 0
    //   2281: pop
    //   2282: aload 14
    //   2284: invokeinterface 612 1 0
    //   2289: pop
    //   2290: aload_1
    //   2291: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2294: sipush -517
    //   2297: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   2300: goto +57 -> 2357
    //   2303: astore 14
    //   2305: new 155	java/lang/StringBuilder
    //   2308: dup
    //   2309: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   2312: astore 15
    //   2314: aload 15
    //   2316: ldc_w 895
    //   2319: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2322: pop
    //   2323: aload 15
    //   2325: aload 14
    //   2327: invokestatic 620	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2330: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2333: pop
    //   2334: ldc 125
    //   2336: aload 15
    //   2338: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2341: invokestatic 346	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2344: aload_1
    //   2345: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2348: sipush -518
    //   2351: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   2354: goto -54 -> 2300
    //   2357: iload_3
    //   2358: ldc_w 642
    //   2361: if_icmpne +10 -> 2371
    //   2364: aload_0
    //   2365: iload_3
    //   2366: aload_2
    //   2367: aload_1
    //   2368: invokespecial 897	com/tencent/smtt/sdk/p:a	(ILjava/lang/String;Landroid/content/Context;)V
    //   2371: aload_0
    //   2372: getfield 107	com/tencent/smtt/sdk/p:k	Z
    //   2375: ifeq +34 -> 2409
    //   2378: aload_1
    //   2379: invokestatic 199	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   2382: astore 14
    //   2384: aload_0
    //   2385: aload_1
    //   2386: invokespecial 900	com/tencent/smtt/sdk/p:u	(Landroid/content/Context;)I
    //   2389: istore_3
    //   2390: ldc_w 589
    //   2393: astore_2
    //   2394: aload 14
    //   2396: astore_1
    //   2397: aload_1
    //   2398: iload_3
    //   2399: aload_2
    //   2400: invokevirtual 205	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   2403: iload 7
    //   2405: istore_3
    //   2406: goto +58 -> 2464
    //   2409: aload_1
    //   2410: invokestatic 199	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   2413: astore_2
    //   2414: aload_0
    //   2415: aload_1
    //   2416: invokespecial 900	com/tencent/smtt/sdk/p:u	(Landroid/content/Context;)I
    //   2419: istore_3
    //   2420: ldc_w 591
    //   2423: astore 14
    //   2425: aload_2
    //   2426: astore_1
    //   2427: aload 14
    //   2429: astore_2
    //   2430: goto -33 -> 2397
    //   2433: iload 5
    //   2435: iconst_2
    //   2436: if_icmpne +26 -> 2462
    //   2439: getstatic 427	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   2442: sipush 200
    //   2445: invokeinterface 432 2 0
    //   2450: iload 7
    //   2452: istore_3
    //   2453: goto +11 -> 2464
    //   2456: astore_1
    //   2457: iconst_1
    //   2458: istore_3
    //   2459: goto +58 -> 2517
    //   2462: iconst_0
    //   2463: istore_3
    //   2464: getstatic 41	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   2467: invokevirtual 435	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   2470: getstatic 43	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   2473: invokeinterface 436 1 0
    //   2478: goto +8 -> 2486
    //   2481: astore_1
    //   2482: aload_1
    //   2483: invokevirtual 524	java/lang/Exception:printStackTrace	()V
    //   2486: aload_0
    //   2487: invokevirtual 438	com/tencent/smtt/sdk/p:b	()V
    //   2490: goto +8 -> 2498
    //   2493: astore_1
    //   2494: aload_1
    //   2495: invokevirtual 524	java/lang/Exception:printStackTrace	()V
    //   2498: iload_3
    //   2499: ifeq +83 -> 2582
    //   2502: getstatic 427	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   2505: sipush 232
    //   2508: invokeinterface 432 2 0
    //   2513: return
    //   2514: astore_1
    //   2515: iconst_0
    //   2516: istore_3
    //   2517: getstatic 41	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   2520: invokevirtual 435	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   2523: getstatic 43	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   2526: invokeinterface 436 1 0
    //   2531: goto +8 -> 2539
    //   2534: astore_2
    //   2535: aload_2
    //   2536: invokevirtual 524	java/lang/Exception:printStackTrace	()V
    //   2539: aload_0
    //   2540: invokevirtual 438	com/tencent/smtt/sdk/p:b	()V
    //   2543: goto +8 -> 2551
    //   2546: astore_2
    //   2547: aload_2
    //   2548: invokevirtual 524	java/lang/Exception:printStackTrace	()V
    //   2551: iload_3
    //   2552: ifeq +14 -> 2566
    //   2555: getstatic 427	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   2558: sipush 232
    //   2561: invokeinterface 432 2 0
    //   2566: aload_1
    //   2567: athrow
    //   2568: aload_1
    //   2569: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2572: sipush -519
    //   2575: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   2578: aload_0
    //   2579: invokevirtual 438	com/tencent/smtt/sdk/p:b	()V
    //   2582: return
    //   2583: iload 5
    //   2585: iconst_3
    //   2586: if_icmpne -1780 -> 806
    //   2589: iload 4
    //   2591: iflt -1785 -> 806
    //   2594: iload_3
    //   2595: iload 4
    //   2597: if_icmpgt -1814 -> 783
    //   2600: iload_3
    //   2601: ldc_w 642
    //   2604: if_icmpne -1798 -> 806
    //   2607: goto -1824 -> 783
    //   2610: iconst_0
    //   2611: istore 9
    //   2613: goto -1067 -> 1546
    //   2616: iconst_1
    //   2617: istore 6
    //   2619: goto -826 -> 1793
    //   2622: iconst_0
    //   2623: istore 6
    //   2625: goto -655 -> 1970
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2628	0	this	p
    //   0	2628	1	paramContext	Context
    //   0	2628	2	paramString	String
    //   0	2628	3	paramInt	int
    //   517	2081	4	i1	int
    //   526	2061	5	i2	int
    //   895	1729	6	i3	int
    //   18	2433	7	i4	int
    //   1103	747	8	i5	int
    //   15	2597	9	bool	boolean
    //   345	44	10	l1	long
    //   354	50	12	l2	long
    //   58	2225	14	localObject1	Object
    //   2303	23	14	localThrowable	Throwable
    //   2382	46	14	localObject2	Object
    //   990	1347	15	localObject3	Object
    //   24	1395	16	localBoolean	java.lang.Boolean
    // Exception table:
    //   from	to	target	type
    //   657	662	665	finally
    //   768	777	665	finally
    //   783	797	665	finally
    //   861	880	665	finally
    //   885	897	665	finally
    //   904	932	665	finally
    //   965	976	665	finally
    //   980	992	665	finally
    //   1001	1024	665	finally
    //   1060	1105	665	finally
    //   1110	1133	665	finally
    //   1166	1239	665	finally
    //   1272	1302	665	finally
    //   1340	1352	665	finally
    //   1358	1433	665	finally
    //   1466	1477	665	finally
    //   1477	1520	665	finally
    //   1525	1543	665	finally
    //   1551	1587	665	finally
    //   1587	1597	665	finally
    //   1600	1611	665	finally
    //   1614	1625	665	finally
    //   1630	1644	665	finally
    //   1649	1659	665	finally
    //   1662	1689	665	finally
    //   1692	1706	665	finally
    //   1714	1722	665	finally
    //   1725	1790	665	finally
    //   1831	1849	665	finally
    //   1871	1883	665	finally
    //   1892	1915	665	finally
    //   1951	1967	665	finally
    //   1981	1993	665	finally
    //   2000	2028	665	finally
    //   2061	2072	665	finally
    //   2095	2105	665	finally
    //   2214	2224	665	finally
    //   2227	2237	665	finally
    //   2237	2300	665	finally
    //   2305	2354	665	finally
    //   2364	2371	665	finally
    //   2371	2390	665	finally
    //   2397	2403	665	finally
    //   2409	2420	665	finally
    //   932	946	949	java/lang/Exception
    //   954	958	959	java/lang/Exception
    //   1024	1038	1041	java/lang/Exception
    //   1046	1050	1051	java/lang/Exception
    //   1133	1147	1150	java/lang/Exception
    //   1155	1159	1160	java/lang/Exception
    //   1239	1253	1256	java/lang/Exception
    //   1261	1265	1266	java/lang/Exception
    //   1302	1316	1319	java/lang/Exception
    //   1324	1328	1329	java/lang/Exception
    //   1433	1447	1450	java/lang/Exception
    //   1455	1459	1460	java/lang/Exception
    //   1798	1812	1815	java/lang/Exception
    //   1820	1824	1825	java/lang/Exception
    //   1915	1929	1932	java/lang/Exception
    //   1937	1941	1942	java/lang/Exception
    //   2028	2042	2045	java/lang/Exception
    //   2050	2054	2055	java/lang/Exception
    //   2105	2119	2122	java/lang/Exception
    //   2127	2131	2132	java/lang/Exception
    //   2237	2300	2303	java/lang/Throwable
    //   2439	2450	2456	finally
    //   2464	2478	2481	java/lang/Exception
    //   2486	2490	2493	java/lang/Exception
    //   507	635	2514	finally
    //   669	757	2514	finally
    //   809	855	2514	finally
    //   1856	1862	2514	finally
    //   2072	2090	2514	finally
    //   2138	2207	2514	finally
    //   2517	2531	2534	java/lang/Exception
    //   2539	2543	2546	java/lang/Exception
  }
  
  /* Error */
  private boolean b(Context paramContext, File paramFile)
  {
    // Byte code:
    //   0: aload_2
    //   1: new 902	com/tencent/smtt/sdk/p$6
    //   4: dup
    //   5: aload_0
    //   6: invokespecial 905	com/tencent/smtt/sdk/p$6:<init>	(Lcom/tencent/smtt/sdk/p;)V
    //   9: invokevirtual 908	java/io/File:listFiles	(Ljava/io/FileFilter;)[Ljava/io/File;
    //   12: astore 6
    //   14: aload 6
    //   16: arraylength
    //   17: istore 4
    //   19: getstatic 384	android/os/Build$VERSION:SDK_INT	I
    //   22: bipush 16
    //   24: if_icmpge +33 -> 57
    //   27: aload_1
    //   28: invokevirtual 911	android/content/Context:getPackageName	()Ljava/lang/String;
    //   31: ifnull +26 -> 57
    //   34: aload_1
    //   35: invokevirtual 911	android/content/Context:getPackageName	()Ljava/lang/String;
    //   38: ldc_w 913
    //   41: invokevirtual 916	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   44: istore 5
    //   46: iload 5
    //   48: ifeq +9 -> 57
    //   51: ldc2_w 917
    //   54: invokestatic 922	java/lang/Thread:sleep	(J)V
    //   57: aload_1
    //   58: invokevirtual 926	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   61: astore 7
    //   63: iconst_0
    //   64: istore_3
    //   65: iload_3
    //   66: iload 4
    //   68: if_icmpge +73 -> 141
    //   71: new 155	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   78: astore 8
    //   80: aload 8
    //   82: ldc_w 928
    //   85: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: aload 8
    //   91: aload 6
    //   93: iload_3
    //   94: aaload
    //   95: invokevirtual 861	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   98: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: ldc 125
    //   104: aload 8
    //   106: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   112: new 930	dalvik/system/DexClassLoader
    //   115: dup
    //   116: aload 6
    //   118: iload_3
    //   119: aaload
    //   120: invokevirtual 861	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   123: aload_2
    //   124: invokevirtual 861	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   127: aconst_null
    //   128: aload 7
    //   130: invokespecial 933	dalvik/system/DexClassLoader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
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
    //   145: invokevirtual 524	java/lang/Exception:printStackTrace	()V
    //   148: aload_1
    //   149: invokestatic 199	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   152: sipush 209
    //   155: aload_2
    //   156: invokevirtual 630	java/lang/Exception:toString	()Ljava/lang/String;
    //   159: invokevirtual 205	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   162: ldc 125
    //   164: ldc_w 935
    //   167: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
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
        paramBundle = new File(paramBundle.getString("backup_apk"));
        localObject = b.a(paramContext, true, paramBundle);
        if (!"3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a".equals(localObject))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("tpatch sig not equals!!!");
          localStringBuilder.append(paramBundle);
          localStringBuilder.append("signature:");
          localStringBuilder.append((String)localObject);
          TbsLog.i("TbsInstaller", localStringBuilder.toString());
          localObject = TbsLogReport.getInstance(paramContext);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("version=");
          localStringBuilder.append(i1);
          localStringBuilder.append(",patchVersion=");
          localStringBuilder.append(i2);
          ((TbsLogReport)localObject).setInstallErrorCode(241, localStringBuilder.toString());
          FileUtil.b(paramBundle);
          return 0;
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
      localObject1 = d.a(paramContext, ((File)localObject2).getAbsolutePath());
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
        localStringBuilder.append(a().q(paramContext));
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
        boolean bool5 = t(paramContext);
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
                y(paramContext);
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
    //   2: ldc 125
    //   4: ldc_w 1069
    //   7: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   25: invokevirtual 405	com/tencent/smtt/sdk/p:t	(Landroid/content/Context;)Z
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
    //   46: invokevirtual 1046	java/util/concurrent/locks/ReentrantLock:tryLock	()Z
    //   49: istore 9
    //   51: iload 8
    //   53: istore 5
    //   55: new 155	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   62: astore 10
    //   64: iload 8
    //   66: istore 5
    //   68: aload 10
    //   70: ldc_w 1071
    //   73: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: iload 8
    //   79: istore 5
    //   81: aload 10
    //   83: iload 9
    //   85: invokevirtual 165	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: iload 8
    //   91: istore 5
    //   93: ldc 125
    //   95: aload 10
    //   97: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   103: iload 9
    //   105: ifeq +179 -> 284
    //   108: aload_1
    //   109: invokestatic 229	com/tencent/smtt/sdk/m:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/m;
    //   112: ldc_w 422
    //   115: invokevirtual 424	com/tencent/smtt/sdk/m:b	(Ljava/lang/String;)I
    //   118: istore_3
    //   119: aload_0
    //   120: iconst_0
    //   121: aload_1
    //   122: invokevirtual 1053	com/tencent/smtt/sdk/p:a	(ZLandroid/content/Context;)I
    //   125: istore 4
    //   127: new 155	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   134: astore 10
    //   136: aload 10
    //   138: ldc_w 1073
    //   141: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: aload 10
    //   147: iload_3
    //   148: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: ldc 125
    //   154: aload 10
    //   156: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   162: new 155	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   169: astore 10
    //   171: aload 10
    //   173: ldc_w 1075
    //   176: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: aload 10
    //   182: iload 4
    //   184: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: ldc 125
    //   190: aload 10
    //   192: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   198: iload 7
    //   200: istore 6
    //   202: iload_3
    //   203: iconst_1
    //   204: if_icmpne +48 -> 252
    //   207: iload 4
    //   209: ifne +23 -> 232
    //   212: ldc 125
    //   214: ldc_w 1077
    //   217: iconst_1
    //   218: invokestatic 265	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   221: aload_0
    //   222: aload_1
    //   223: invokespecial 1080	com/tencent/smtt/sdk/p:z	(Landroid/content/Context;)V
    //   226: iconst_1
    //   227: istore 6
    //   229: goto +23 -> 252
    //   232: iload 7
    //   234: istore 6
    //   236: iload_2
    //   237: ifeq +15 -> 252
    //   240: ldc 125
    //   242: ldc_w 1082
    //   245: iconst_1
    //   246: invokestatic 265	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   249: goto -28 -> 221
    //   252: iload 6
    //   254: istore 5
    //   256: getstatic 41	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   259: invokevirtual 435	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   262: goto +22 -> 284
    //   265: astore 10
    //   267: iload 8
    //   269: istore 5
    //   271: getstatic 41	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   274: invokevirtual 435	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   277: iload 8
    //   279: istore 5
    //   281: aload 10
    //   283: athrow
    //   284: iload 6
    //   286: istore 5
    //   288: aload_0
    //   289: invokevirtual 438	com/tencent/smtt/sdk/p:b	()V
    //   292: iload 6
    //   294: istore 5
    //   296: goto +62 -> 358
    //   299: astore_1
    //   300: goto +63 -> 363
    //   303: astore 10
    //   305: aload_1
    //   306: invokestatic 199	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   309: sipush 215
    //   312: aload 10
    //   314: invokevirtual 1065	java/lang/Throwable:toString	()Ljava/lang/String;
    //   317: invokevirtual 205	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   320: new 155	java/lang/StringBuilder
    //   323: dup
    //   324: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   327: astore 11
    //   329: aload 11
    //   331: ldc_w 1084
    //   334: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: pop
    //   338: aload 11
    //   340: aload 10
    //   342: invokestatic 620	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   345: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: pop
    //   349: aload_1
    //   350: aload 11
    //   352: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   355: invokestatic 242	com/tencent/smtt/sdk/QbSdk:a	(Landroid/content/Context;Ljava/lang/String;)V
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
        boolean bool5 = t(paramContext);
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
                x(paramContext);
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
    File localFile2 = p(paramContext);
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
    localObject = q(paramContext);
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
  
  static File s(Context paramContext)
  {
    paramContext = new File(QbSdk.getTbsFolderDir(paramContext), "core_private");
    if ((!paramContext.isDirectory()) && (!paramContext.mkdir())) {
      return null;
    }
    return paramContext;
  }
  
  private int u(Context paramContext)
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
  
  private static boolean v(Context paramContext)
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
  
  private boolean w(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "Tbsinstaller getTbsCoreRenameFileLock #1 ");
    try
    {
      bool = TbsDownloadConfig.getInstance().getTbsCoreLoadRenameFileLockEnable();
    }
    catch (Throwable localThrowable)
    {
      boolean bool;
      label18:
      StringBuilder localStringBuilder;
      break label18;
    }
    bool = true;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Tbsinstaller getTbsCoreRenameFileLock #2  enabled is ");
    localStringBuilder.append(bool);
    TbsLog.i("TbsInstaller", localStringBuilder.toString());
    if (!bool) {
      paramContext = x.a().a(paramContext);
    } else {
      paramContext = FileUtil.f(paramContext);
    }
    l = paramContext;
    if (l == null)
    {
      TbsLog.i("TbsInstaller", "getTbsCoreRenameFileLock## failed!");
      return false;
    }
    TbsLog.i("TbsInstaller", "Tbsinstaller getTbsCoreRenameFileLock true ");
    return true;
  }
  
  private void x(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip");
    if (!w(paramContext))
    {
      TbsLog.i("TbsInstaller", "get rename fileLock#4 ## failed!");
      return;
    }
    try
    {
      A(paramContext);
      B(paramContext);
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
        if ((i1 > 0) && (i1 != a().h(paramContext)) && (i1 == a().i(paramContext)))
        {
          n(paramContext);
        }
        else
        {
          StringBuilder localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("TbsInstaller--generateNewTbsCoreFromUnzip #1 deCoupleCoreVersion is ");
          localStringBuilder1.append(i1);
          localStringBuilder1.append(" getTbsCoreShareDecoupleCoreVersion is ");
          localStringBuilder1.append(a().h(paramContext));
          localStringBuilder1.append(" getTbsCoreInstalledVerInNolock is ");
          localStringBuilder1.append(a().i(paramContext));
          TbsLog.i("TbsInstaller", localStringBuilder1.toString());
        }
      }
      if (TbsShareManager.isThirdPartyApp(paramContext)) {
        TbsShareManager.writeCoreInfoForThirdPartyApp(paramContext, m(paramContext), true);
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
    g(paramContext);
  }
  
  private void y(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromTpatch");
    if (!w(paramContext))
    {
      TbsLog.i("TbsInstaller", "get rename fileLock#4 ## failed!");
      return;
    }
    try
    {
      A(paramContext);
      D(paramContext);
      TbsShareManager.a(paramContext);
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
    g(paramContext);
  }
  
  private void z(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromCopy");
    if (!w(paramContext))
    {
      TbsLog.i("TbsInstaller", "get rename fileLock#4 ## failed!");
      return;
    }
    try
    {
      A(paramContext);
      C(paramContext);
      TbsShareManager.a(paramContext);
      m.a(paramContext).a(0, 3);
      m.a(paramContext).a("tpatch_num", 0);
      if (!TbsShareManager.isThirdPartyApp(paramContext))
      {
        int i1 = TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_decouplecoreversion", 0);
        if ((i1 > 0) && (i1 != a().h(paramContext)) && (i1 == a().i(paramContext)))
        {
          n(paramContext);
        }
        else
        {
          StringBuilder localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("TbsInstaller--generateNewTbsCoreFromCopy #1 deCoupleCoreVersion is ");
          localStringBuilder1.append(i1);
          localStringBuilder1.append(" getTbsCoreShareDecoupleCoreVersion is ");
          localStringBuilder1.append(a().h(paramContext));
          localStringBuilder1.append(" getTbsCoreInstalledVerInNolock is ");
          localStringBuilder1.append(a().i(paramContext));
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
    g(paramContext);
  }
  
  /* Error */
  int a(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: new 155	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   12: astore 5
    //   14: aload 5
    //   16: ldc_w 1282
    //   19: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: aload 5
    //   25: aload_1
    //   26: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: ldc 125
    //   32: aload 5
    //   34: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   40: new 149	java/io/File
    //   43: dup
    //   44: aload_1
    //   45: ldc_w 278
    //   48: invokespecial 273	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   51: astore_1
    //   52: aload_1
    //   53: invokevirtual 523	java/io/File:exists	()Z
    //   56: ifne +5 -> 61
    //   59: iconst_0
    //   60: ireturn
    //   61: new 280	java/util/Properties
    //   64: dup
    //   65: invokespecial 281	java/util/Properties:<init>	()V
    //   68: astore 5
    //   70: new 283	java/io/BufferedInputStream
    //   73: dup
    //   74: new 285	java/io/FileInputStream
    //   77: dup
    //   78: aload_1
    //   79: invokespecial 288	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   82: invokespecial 291	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   85: astore_1
    //   86: aload 5
    //   88: aload_1
    //   89: invokevirtual 294	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   92: aload_1
    //   93: invokevirtual 323	java/io/BufferedInputStream:close	()V
    //   96: aload 5
    //   98: ldc_w 1284
    //   101: invokevirtual 1285	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   104: astore_3
    //   105: aload_3
    //   106: ifnonnull +9 -> 115
    //   109: aload_1
    //   110: invokevirtual 323	java/io/BufferedInputStream:close	()V
    //   113: iconst_0
    //   114: ireturn
    //   115: aload_3
    //   116: invokestatic 1288	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   119: istore_2
    //   120: aload_1
    //   121: invokevirtual 323	java/io/BufferedInputStream:close	()V
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
    //   145: invokevirtual 323	java/io/BufferedInputStream:close	()V
    //   148: aload_1
    //   149: athrow
    //   150: aload_1
    //   151: ifnull +7 -> 158
    //   154: aload_1
    //   155: invokevirtual 323	java/io/BufferedInputStream:close	()V
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
    //   11: new 149	java/io/File
    //   14: dup
    //   15: new 149	java/io/File
    //   18: dup
    //   19: aload_1
    //   20: invokespecial 254	java/io/File:<init>	(Ljava/lang/String;)V
    //   23: ldc_w 278
    //   26: invokespecial 273	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   29: astore_1
    //   30: aload_1
    //   31: invokevirtual 523	java/io/File:exists	()Z
    //   34: ifne +5 -> 39
    //   37: iconst_0
    //   38: ireturn
    //   39: new 280	java/util/Properties
    //   42: dup
    //   43: invokespecial 281	java/util/Properties:<init>	()V
    //   46: astore 5
    //   48: new 283	java/io/BufferedInputStream
    //   51: dup
    //   52: new 285	java/io/FileInputStream
    //   55: dup
    //   56: aload_1
    //   57: invokespecial 288	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   60: invokespecial 291	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   63: astore_1
    //   64: aload 5
    //   66: aload_1
    //   67: invokevirtual 294	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   70: aload_1
    //   71: invokevirtual 323	java/io/BufferedInputStream:close	()V
    //   74: aload 5
    //   76: ldc_w 1284
    //   79: invokevirtual 1285	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   82: astore_3
    //   83: aload_3
    //   84: ifnonnull +9 -> 93
    //   87: aload_1
    //   88: invokevirtual 323	java/io/BufferedInputStream:close	()V
    //   91: iconst_0
    //   92: ireturn
    //   93: aload_3
    //   94: invokestatic 1288	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   97: istore_2
    //   98: aload_1
    //   99: invokevirtual 323	java/io/BufferedInputStream:close	()V
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
    //   123: invokevirtual 323	java/io/BufferedInputStream:close	()V
    //   126: aload_1
    //   127: athrow
    //   128: aload_1
    //   129: ifnull +7 -> 136
    //   132: aload_1
    //   133: invokevirtual 323	java/io/BufferedInputStream:close	()V
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
      a.set(Integer.valueOf(i(paramContext)));
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
    if (!t(paramContext)) {
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
  
  public void b(Context paramContext)
  {
    g(paramContext, true);
    m.a(paramContext).c(h(paramContext), 2);
  }
  
  /* Error */
  void b(Context paramContext, Bundle paramBundle)
  {
    // Byte code:
    //   0: new 155	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   7: astore 11
    //   9: aload 11
    //   11: ldc_w 1430
    //   14: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: pop
    //   18: aload 11
    //   20: invokestatic 744	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   23: invokevirtual 745	java/lang/Thread:getName	()Ljava/lang/String;
    //   26: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload 11
    //   32: new 249	java/lang/Throwable
    //   35: dup
    //   36: invokespecial 1420	java/lang/Throwable:<init>	()V
    //   39: invokestatic 620	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   42: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: ldc 125
    //   48: aload 11
    //   50: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   56: aload_0
    //   57: aload_1
    //   58: invokevirtual 374	com/tencent/smtt/sdk/p:c	(Landroid/content/Context;)Z
    //   61: ifeq +14 -> 75
    //   64: aload_1
    //   65: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   68: sipush -539
    //   71: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   74: return
    //   75: ldc 125
    //   77: ldc_w 1432
    //   80: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   83: aload_2
    //   84: ifnull +1981 -> 2065
    //   87: aload_1
    //   88: ifnonnull +4 -> 92
    //   91: return
    //   92: aload_1
    //   93: invokestatic 454	com/tencent/smtt/utils/FileUtil:b	(Landroid/content/Context;)Z
    //   96: ifne +84 -> 180
    //   99: invokestatic 459	com/tencent/smtt/utils/p:a	()J
    //   102: lstore 6
    //   104: aload_1
    //   105: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   108: invokevirtual 462	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMinFreeSpace	()J
    //   111: lstore 8
    //   113: aload_1
    //   114: invokestatic 199	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   117: astore 11
    //   119: new 155	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   126: astore_2
    //   127: aload_2
    //   128: ldc_w 1434
    //   131: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: pop
    //   135: aload_2
    //   136: lload 6
    //   138: invokevirtual 467	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: aload_2
    //   143: ldc_w 469
    //   146: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: pop
    //   150: aload_2
    //   151: lload 8
    //   153: invokevirtual 467	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: aload 11
    //   159: sipush 210
    //   162: aload_2
    //   163: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: invokevirtual 205	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   169: aload_1
    //   170: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   173: sipush -540
    //   176: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   179: return
    //   180: aload_0
    //   181: aload_1
    //   182: invokevirtual 405	com/tencent/smtt/sdk/p:t	(Landroid/content/Context;)Z
    //   185: ifne +14 -> 199
    //   188: aload_1
    //   189: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   192: sipush -541
    //   195: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   198: return
    //   199: getstatic 43	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   202: invokeinterface 410 1 0
    //   207: istore 10
    //   209: new 155	java/lang/StringBuilder
    //   212: dup
    //   213: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   216: astore 11
    //   218: aload 11
    //   220: ldc_w 1436
    //   223: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: pop
    //   227: aload 11
    //   229: iload 10
    //   231: invokevirtual 165	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: ldc 125
    //   237: aload 11
    //   239: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   245: iload 10
    //   247: ifeq +1804 -> 2051
    //   250: aload_1
    //   251: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   254: getfield 841	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   257: ldc_w 843
    //   260: iconst_0
    //   261: invokeinterface 398 3 0
    //   266: istore 5
    //   268: iconst_1
    //   269: invokestatic 1141	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   272: iload 5
    //   274: iconst_5
    //   275: if_icmpne +312 -> 587
    //   278: aload_0
    //   279: aload_1
    //   280: aload_2
    //   281: invokespecial 1438	com/tencent/smtt/sdk/p:c	(Landroid/content/Context;Landroid/os/Bundle;)I
    //   284: istore_3
    //   285: iload_3
    //   286: iconst_1
    //   287: if_icmpne +46 -> 333
    //   290: aload_1
    //   291: invokestatic 229	com/tencent/smtt/sdk/m:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/m;
    //   294: ldc_w 1231
    //   297: invokevirtual 420	com/tencent/smtt/sdk/m:c	(Ljava/lang/String;)I
    //   300: istore 4
    //   302: aload_1
    //   303: invokestatic 229	com/tencent/smtt/sdk/m:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/m;
    //   306: ldc_w 1231
    //   309: iload 4
    //   311: iconst_1
    //   312: iadd
    //   313: invokevirtual 489	com/tencent/smtt/sdk/m:a	(Ljava/lang/String;I)V
    //   316: goto +17 -> 333
    //   319: astore_2
    //   320: aconst_null
    //   321: astore 11
    //   323: goto +1431 -> 1754
    //   326: astore_2
    //   327: aconst_null
    //   328: astore 11
    //   330: goto +1134 -> 1464
    //   333: getstatic 43	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   336: invokeinterface 436 1 0
    //   341: aload_0
    //   342: invokevirtual 438	com/tencent/smtt/sdk/p:b	()V
    //   345: iload 5
    //   347: iconst_5
    //   348: if_icmpne +10 -> 358
    //   351: aload_0
    //   352: aload_1
    //   353: iload_3
    //   354: invokespecial 1440	com/tencent/smtt/sdk/p:h	(Landroid/content/Context;I)V
    //   357: return
    //   358: iload_3
    //   359: ifne +57 -> 416
    //   362: ldc 125
    //   364: ldc_w 1442
    //   367: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   370: aload_1
    //   371: invokestatic 229	com/tencent/smtt/sdk/m:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/m;
    //   374: ldc_w 1227
    //   377: iconst_0
    //   378: invokevirtual 489	com/tencent/smtt/sdk/m:a	(Ljava/lang/String;I)V
    //   381: aload_1
    //   382: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   385: sipush -544
    //   388: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   391: aload_1
    //   392: invokestatic 229	com/tencent/smtt/sdk/m:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/m;
    //   395: iconst_0
    //   396: iconst_m1
    //   397: invokevirtual 232	com/tencent/smtt/sdk/m:c	(II)V
    //   400: aload_1
    //   401: invokestatic 229	com/tencent/smtt/sdk/m:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/m;
    //   404: iconst_1
    //   405: invokevirtual 235	com/tencent/smtt/sdk/m:c	(I)V
    //   408: new 1444	java/lang/NullPointerException
    //   411: dup
    //   412: invokespecial 1445	java/lang/NullPointerException:<init>	()V
    //   415: athrow
    //   416: iload_3
    //   417: iconst_2
    //   418: if_icmpne +14 -> 432
    //   421: ldc 125
    //   423: ldc_w 1447
    //   426: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   429: goto +139 -> 568
    //   432: aload_1
    //   433: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   436: sipush -546
    //   439: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   442: ldc 125
    //   444: ldc_w 1449
    //   447: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   450: aload_1
    //   451: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   454: getfield 818	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   457: ldc_w 820
    //   460: iconst_1
    //   461: invokestatic 718	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   464: invokeinterface 826 3 0
    //   469: pop
    //   470: aload_1
    //   471: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   474: invokevirtual 830	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   477: aload_1
    //   478: invokestatic 478	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   481: ifeq +42 -> 523
    //   484: aload_1
    //   485: invokestatic 199	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   488: astore_1
    //   489: new 155	java/lang/StringBuilder
    //   492: dup
    //   493: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   496: astore_2
    //   497: aload_2
    //   498: ldc_w 1451
    //   501: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: pop
    //   505: aload_2
    //   506: iload_3
    //   507: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   510: pop
    //   511: aload_2
    //   512: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   515: astore_2
    //   516: sipush 235
    //   519: istore_3
    //   520: goto +39 -> 559
    //   523: aload_1
    //   524: invokestatic 199	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   527: astore_1
    //   528: new 155	java/lang/StringBuilder
    //   531: dup
    //   532: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   535: astore_2
    //   536: aload_2
    //   537: ldc_w 1453
    //   540: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   543: pop
    //   544: aload_2
    //   545: iload_3
    //   546: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   549: pop
    //   550: aload_2
    //   551: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   554: astore_2
    //   555: sipush 217
    //   558: istore_3
    //   559: aload_1
    //   560: iload_3
    //   561: aload_2
    //   562: invokevirtual 205	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   565: goto -136 -> 429
    //   568: iconst_0
    //   569: invokestatic 1141	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   572: return
    //   573: astore_2
    //   574: aconst_null
    //   575: astore 11
    //   577: goto +876 -> 1453
    //   580: astore_2
    //   581: aconst_null
    //   582: astore 11
    //   584: goto +878 -> 1462
    //   587: aload_0
    //   588: aload_1
    //   589: invokevirtual 441	com/tencent/smtt/sdk/p:i	(Landroid/content/Context;)I
    //   592: ifle +815 -> 1407
    //   595: aload_1
    //   596: invokestatic 229	com/tencent/smtt/sdk/m:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/m;
    //   599: invokevirtual 1177	com/tencent/smtt/sdk/m:d	()I
    //   602: iconst_1
    //   603: if_icmpne +1463 -> 2066
    //   606: goto +801 -> 1407
    //   609: iload_3
    //   610: ifne +501 -> 1111
    //   613: iload 5
    //   615: ifeq +496 -> 1111
    //   618: aload_1
    //   619: invokestatic 229	com/tencent/smtt/sdk/m:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/m;
    //   622: ldc_w 1227
    //   625: invokevirtual 420	com/tencent/smtt/sdk/m:c	(Ljava/lang/String;)I
    //   628: istore_3
    //   629: iload_3
    //   630: iconst_5
    //   631: if_icmple +173 -> 804
    //   634: ldc 125
    //   636: ldc_w 1455
    //   639: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   642: aload_2
    //   643: ldc_w 1457
    //   646: invokevirtual 950	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   649: astore 12
    //   651: aload_2
    //   652: ldc_w 947
    //   655: invokevirtual 950	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   658: astore 11
    //   660: aload_2
    //   661: ldc_w 1459
    //   664: invokevirtual 950	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   667: astore_2
    //   668: aload 12
    //   670: invokestatic 986	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   673: ifne +15 -> 688
    //   676: new 149	java/io/File
    //   679: dup
    //   680: aload 12
    //   682: invokespecial 254	java/io/File:<init>	(Ljava/lang/String;)V
    //   685: invokestatic 663	com/tencent/smtt/utils/FileUtil:b	(Ljava/io/File;)V
    //   688: aload 11
    //   690: invokestatic 986	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   693: ifne +15 -> 708
    //   696: new 149	java/io/File
    //   699: dup
    //   700: aload 11
    //   702: invokespecial 254	java/io/File:<init>	(Ljava/lang/String;)V
    //   705: invokestatic 663	com/tencent/smtt/utils/FileUtil:b	(Ljava/io/File;)V
    //   708: aload_2
    //   709: invokestatic 986	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   712: ifne +14 -> 726
    //   715: new 149	java/io/File
    //   718: dup
    //   719: aload_2
    //   720: invokespecial 254	java/io/File:<init>	(Ljava/lang/String;)V
    //   723: invokestatic 663	com/tencent/smtt/utils/FileUtil:b	(Ljava/io/File;)V
    //   726: aload_1
    //   727: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   730: getfield 818	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   733: ldc_w 820
    //   736: iconst_1
    //   737: invokestatic 718	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   740: invokeinterface 826 3 0
    //   745: pop
    //   746: aload_1
    //   747: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   750: invokevirtual 830	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   753: aload_1
    //   754: invokestatic 199	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   757: sipush 224
    //   760: ldc_w 1461
    //   763: invokevirtual 205	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   766: getstatic 43	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   769: invokeinterface 436 1 0
    //   774: aload_0
    //   775: invokevirtual 438	com/tencent/smtt/sdk/p:b	()V
    //   778: iload 5
    //   780: iconst_5
    //   781: if_icmpne +10 -> 791
    //   784: aload_0
    //   785: aload_1
    //   786: iconst_2
    //   787: invokespecial 1440	com/tencent/smtt/sdk/p:h	(Landroid/content/Context;I)V
    //   790: return
    //   791: ldc 125
    //   793: ldc_w 1447
    //   796: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   799: iconst_0
    //   800: invokestatic 1141	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   803: return
    //   804: aload_1
    //   805: invokestatic 229	com/tencent/smtt/sdk/m:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/m;
    //   808: ldc_w 1227
    //   811: iload_3
    //   812: iconst_1
    //   813: iadd
    //   814: invokevirtual 489	com/tencent/smtt/sdk/m:a	(Ljava/lang/String;I)V
    //   817: aload_1
    //   818: invokestatic 682	com/tencent/smtt/sdk/p:s	(Landroid/content/Context;)Ljava/io/File;
    //   821: astore 11
    //   823: aload 11
    //   825: ifnull +286 -> 1111
    //   828: new 149	java/io/File
    //   831: dup
    //   832: aload 11
    //   834: ldc_w 684
    //   837: invokespecial 273	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   840: invokevirtual 523	java/io/File:exists	()Z
    //   843: ifeq +268 -> 1111
    //   846: aload_1
    //   847: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   850: sipush -550
    //   853: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   856: aload_1
    //   857: aload_2
    //   858: invokestatic 939	com/tencent/smtt/sdk/QbSdk:a	(Landroid/content/Context;Landroid/os/Bundle;)Landroid/os/Bundle;
    //   861: astore 11
    //   863: aload 11
    //   865: ifnonnull +89 -> 954
    //   868: aload 11
    //   870: astore 12
    //   872: aload_1
    //   873: invokestatic 199	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   876: astore 13
    //   878: aload 11
    //   880: astore 12
    //   882: new 155	java/lang/StringBuilder
    //   885: dup
    //   886: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   889: astore 14
    //   891: aload 11
    //   893: astore 12
    //   895: aload 14
    //   897: ldc_w 1463
    //   900: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   903: pop
    //   904: aload 11
    //   906: astore 12
    //   908: aload 14
    //   910: aload_2
    //   911: ldc_w 952
    //   914: invokevirtual 945	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   917: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   920: pop
    //   921: aload 11
    //   923: astore 12
    //   925: aload 13
    //   927: sipush 228
    //   930: aload 14
    //   932: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   935: invokevirtual 205	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   938: iconst_1
    //   939: istore 4
    //   941: aload 11
    //   943: astore 12
    //   945: goto +172 -> 1117
    //   948: astore_2
    //   949: iconst_1
    //   950: istore_3
    //   951: goto +513 -> 1464
    //   954: aload 11
    //   956: ldc_w 943
    //   959: invokevirtual 945	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   962: istore_3
    //   963: aload 11
    //   965: astore 12
    //   967: iload_3
    //   968: istore 4
    //   970: iload_3
    //   971: ifeq +146 -> 1117
    //   974: aload 11
    //   976: astore 12
    //   978: iload_3
    //   979: istore 4
    //   981: aload_1
    //   982: invokestatic 199	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   985: astore 14
    //   987: aload 11
    //   989: astore 12
    //   991: iload_3
    //   992: istore 4
    //   994: new 155	java/lang/StringBuilder
    //   997: dup
    //   998: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   1001: astore 13
    //   1003: aload 11
    //   1005: astore 12
    //   1007: iload_3
    //   1008: istore 4
    //   1010: aload 13
    //   1012: ldc_w 1465
    //   1015: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1018: pop
    //   1019: aload 11
    //   1021: astore 12
    //   1023: iload_3
    //   1024: istore 4
    //   1026: aload 13
    //   1028: iload_3
    //   1029: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1032: pop
    //   1033: aload 11
    //   1035: astore 12
    //   1037: iload_3
    //   1038: istore 4
    //   1040: aload 13
    //   1042: ldc_w 1467
    //   1045: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1048: pop
    //   1049: aload 11
    //   1051: astore 12
    //   1053: iload_3
    //   1054: istore 4
    //   1056: aload 13
    //   1058: aload_2
    //   1059: ldc_w 952
    //   1062: invokevirtual 945	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   1065: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1068: pop
    //   1069: aload 11
    //   1071: astore 12
    //   1073: iload_3
    //   1074: istore 4
    //   1076: aload 14
    //   1078: sipush 228
    //   1081: aload 13
    //   1083: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1086: invokevirtual 205	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1089: aload 11
    //   1091: astore 12
    //   1093: iload_3
    //   1094: istore 4
    //   1096: goto +21 -> 1117
    //   1099: astore_2
    //   1100: goto +364 -> 1464
    //   1103: astore_2
    //   1104: goto +349 -> 1453
    //   1107: astore_2
    //   1108: goto +354 -> 1462
    //   1111: aconst_null
    //   1112: astore 12
    //   1114: iconst_2
    //   1115: istore 4
    //   1117: getstatic 43	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   1120: invokeinterface 436 1 0
    //   1125: aload_0
    //   1126: invokevirtual 438	com/tencent/smtt/sdk/p:b	()V
    //   1129: iload 5
    //   1131: iconst_5
    //   1132: if_icmpne +11 -> 1143
    //   1135: aload_0
    //   1136: aload_1
    //   1137: iload 4
    //   1139: invokespecial 1440	com/tencent/smtt/sdk/p:h	(Landroid/content/Context;I)V
    //   1142: return
    //   1143: iload 4
    //   1145: ifne +102 -> 1247
    //   1148: ldc 125
    //   1150: ldc_w 1442
    //   1153: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1156: aload_1
    //   1157: invokestatic 229	com/tencent/smtt/sdk/m:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/m;
    //   1160: ldc_w 1227
    //   1163: iconst_0
    //   1164: invokevirtual 489	com/tencent/smtt/sdk/m:a	(Ljava/lang/String;I)V
    //   1167: aload_1
    //   1168: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1171: sipush -544
    //   1174: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1177: aload_1
    //   1178: invokestatic 229	com/tencent/smtt/sdk/m:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/m;
    //   1181: iconst_0
    //   1182: iconst_m1
    //   1183: invokevirtual 232	com/tencent/smtt/sdk/m:c	(II)V
    //   1186: aload_1
    //   1187: invokestatic 229	com/tencent/smtt/sdk/m:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/m;
    //   1190: iconst_1
    //   1191: invokevirtual 235	com/tencent/smtt/sdk/m:c	(I)V
    //   1194: aload 12
    //   1196: ldc_w 1469
    //   1199: invokevirtual 950	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1202: astore_2
    //   1203: new 149	java/io/File
    //   1206: dup
    //   1207: aload_2
    //   1208: invokespecial 254	java/io/File:<init>	(Ljava/lang/String;)V
    //   1211: aload_1
    //   1212: invokestatic 587	com/tencent/smtt/sdk/l:a	(Ljava/io/File;Landroid/content/Context;)V
    //   1215: aload_0
    //   1216: aload_1
    //   1217: aload_2
    //   1218: aload 12
    //   1220: ldc_w 1471
    //   1223: invokevirtual 945	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   1226: invokespecial 650	com/tencent/smtt/sdk/p:b	(Landroid/content/Context;Ljava/lang/String;I)V
    //   1229: aload_1
    //   1230: invokestatic 478	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   1233: ifeq +28 -> 1261
    //   1236: aload_1
    //   1237: invokestatic 229	com/tencent/smtt/sdk/m:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/m;
    //   1240: iconst_m1
    //   1241: invokevirtual 235	com/tencent/smtt/sdk/m:c	(I)V
    //   1244: goto +17 -> 1261
    //   1247: iload 4
    //   1249: iconst_2
    //   1250: if_icmpne +14 -> 1264
    //   1253: ldc 125
    //   1255: ldc_w 1447
    //   1258: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1261: goto +141 -> 1402
    //   1264: aload_1
    //   1265: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1268: sipush -546
    //   1271: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1274: ldc 125
    //   1276: ldc_w 1449
    //   1279: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1282: aload_1
    //   1283: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1286: getfield 818	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1289: ldc_w 820
    //   1292: iconst_1
    //   1293: invokestatic 718	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1296: invokeinterface 826 3 0
    //   1301: pop
    //   1302: aload_1
    //   1303: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1306: invokevirtual 830	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1309: aload_1
    //   1310: invokestatic 478	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   1313: ifeq +43 -> 1356
    //   1316: aload_1
    //   1317: invokestatic 199	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1320: astore_2
    //   1321: new 155	java/lang/StringBuilder
    //   1324: dup
    //   1325: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   1328: astore_1
    //   1329: aload_1
    //   1330: ldc_w 1451
    //   1333: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1336: pop
    //   1337: aload_1
    //   1338: iload 4
    //   1340: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1343: pop
    //   1344: aload_1
    //   1345: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1348: astore_1
    //   1349: sipush 235
    //   1352: istore_3
    //   1353: goto +40 -> 1393
    //   1356: aload_1
    //   1357: invokestatic 199	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1360: astore_2
    //   1361: new 155	java/lang/StringBuilder
    //   1364: dup
    //   1365: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   1368: astore_1
    //   1369: aload_1
    //   1370: ldc_w 1453
    //   1373: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1376: pop
    //   1377: aload_1
    //   1378: iload 4
    //   1380: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1383: pop
    //   1384: aload_1
    //   1385: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1388: astore_1
    //   1389: sipush 217
    //   1392: istore_3
    //   1393: aload_2
    //   1394: iload_3
    //   1395: aload_1
    //   1396: invokevirtual 205	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1399: goto -138 -> 1261
    //   1402: iconst_0
    //   1403: invokestatic 1141	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   1406: return
    //   1407: iconst_0
    //   1408: invokestatic 1141	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   1411: getstatic 43	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   1414: invokeinterface 436 1 0
    //   1419: aload_0
    //   1420: invokevirtual 438	com/tencent/smtt/sdk/p:b	()V
    //   1423: iload 5
    //   1425: iconst_5
    //   1426: if_icmpne +10 -> 1436
    //   1429: aload_0
    //   1430: aload_1
    //   1431: iconst_2
    //   1432: invokespecial 1440	com/tencent/smtt/sdk/p:h	(Landroid/content/Context;I)V
    //   1435: return
    //   1436: ldc 125
    //   1438: ldc_w 1447
    //   1441: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1444: iconst_0
    //   1445: invokestatic 1141	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   1448: return
    //   1449: astore_2
    //   1450: aconst_null
    //   1451: astore 11
    //   1453: iconst_2
    //   1454: istore_3
    //   1455: goto +299 -> 1754
    //   1458: astore_2
    //   1459: aconst_null
    //   1460: astore 11
    //   1462: iconst_2
    //   1463: istore_3
    //   1464: aload 11
    //   1466: astore 12
    //   1468: iload_3
    //   1469: istore 4
    //   1471: new 155	java/lang/StringBuilder
    //   1474: dup
    //   1475: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   1478: astore 13
    //   1480: aload 11
    //   1482: astore 12
    //   1484: iload_3
    //   1485: istore 4
    //   1487: aload 13
    //   1489: ldc_w 1473
    //   1492: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1495: pop
    //   1496: aload 11
    //   1498: astore 12
    //   1500: iload_3
    //   1501: istore 4
    //   1503: aload 13
    //   1505: aload_2
    //   1506: invokestatic 620	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1509: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1512: pop
    //   1513: aload 11
    //   1515: astore 12
    //   1517: iload_3
    //   1518: istore 4
    //   1520: ldc 125
    //   1522: aload 13
    //   1524: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1527: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1530: aload 11
    //   1532: astore 12
    //   1534: iload_3
    //   1535: istore 4
    //   1537: aload_2
    //   1538: invokevirtual 524	java/lang/Exception:printStackTrace	()V
    //   1541: aload 11
    //   1543: astore 12
    //   1545: aload_1
    //   1546: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1549: sipush -543
    //   1552: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1555: aload 11
    //   1557: astore 12
    //   1559: aload_1
    //   1560: invokestatic 199	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1563: sipush 218
    //   1566: aload_2
    //   1567: invokevirtual 630	java/lang/Exception:toString	()Ljava/lang/String;
    //   1570: invokevirtual 205	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1573: getstatic 43	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   1576: invokeinterface 436 1 0
    //   1581: aload_0
    //   1582: invokevirtual 438	com/tencent/smtt/sdk/p:b	()V
    //   1585: iload 5
    //   1587: iconst_5
    //   1588: if_icmpne +10 -> 1598
    //   1591: aload_0
    //   1592: aload_1
    //   1593: iconst_1
    //   1594: invokespecial 1440	com/tencent/smtt/sdk/p:h	(Landroid/content/Context;I)V
    //   1597: return
    //   1598: aload_1
    //   1599: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1602: sipush -546
    //   1605: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1608: ldc 125
    //   1610: ldc_w 1449
    //   1613: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1616: aload_1
    //   1617: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1620: getfield 818	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1623: ldc_w 820
    //   1626: iconst_1
    //   1627: invokestatic 718	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1630: invokeinterface 826 3 0
    //   1635: pop
    //   1636: aload_1
    //   1637: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1640: invokevirtual 830	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1643: aload_1
    //   1644: invokestatic 478	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   1647: ifeq +42 -> 1689
    //   1650: aload_1
    //   1651: invokestatic 199	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1654: astore_2
    //   1655: new 155	java/lang/StringBuilder
    //   1658: dup
    //   1659: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   1662: astore_1
    //   1663: aload_1
    //   1664: ldc_w 1451
    //   1667: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1670: pop
    //   1671: aload_1
    //   1672: iconst_1
    //   1673: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1676: pop
    //   1677: aload_1
    //   1678: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1681: astore_1
    //   1682: sipush 235
    //   1685: istore_3
    //   1686: goto +39 -> 1725
    //   1689: aload_1
    //   1690: invokestatic 199	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1693: astore_2
    //   1694: new 155	java/lang/StringBuilder
    //   1697: dup
    //   1698: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   1701: astore_1
    //   1702: aload_1
    //   1703: ldc_w 1453
    //   1706: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1709: pop
    //   1710: aload_1
    //   1711: iconst_1
    //   1712: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1715: pop
    //   1716: aload_1
    //   1717: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1720: astore_1
    //   1721: sipush 217
    //   1724: istore_3
    //   1725: aload_2
    //   1726: iload_3
    //   1727: aload_1
    //   1728: invokevirtual 205	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1731: iconst_0
    //   1732: invokestatic 1141	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   1735: return
    //   1736: astore_2
    //   1737: iconst_1
    //   1738: istore_3
    //   1739: aload 12
    //   1741: astore 11
    //   1743: goto +11 -> 1754
    //   1746: astore_2
    //   1747: iload 4
    //   1749: istore_3
    //   1750: aload 12
    //   1752: astore 11
    //   1754: getstatic 43	com/tencent/smtt/sdk/p:j	Ljava/util/concurrent/locks/Lock;
    //   1757: invokeinterface 436 1 0
    //   1762: aload_0
    //   1763: invokevirtual 438	com/tencent/smtt/sdk/p:b	()V
    //   1766: iload 5
    //   1768: iconst_5
    //   1769: if_icmpne +10 -> 1779
    //   1772: aload_0
    //   1773: aload_1
    //   1774: iload_3
    //   1775: invokespecial 1440	com/tencent/smtt/sdk/p:h	(Landroid/content/Context;I)V
    //   1778: return
    //   1779: iload_3
    //   1780: ifne +105 -> 1885
    //   1783: ldc 125
    //   1785: ldc_w 1442
    //   1788: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1791: aload_1
    //   1792: invokestatic 229	com/tencent/smtt/sdk/m:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/m;
    //   1795: ldc_w 1227
    //   1798: iconst_0
    //   1799: invokevirtual 489	com/tencent/smtt/sdk/m:a	(Ljava/lang/String;I)V
    //   1802: aload_1
    //   1803: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1806: sipush -544
    //   1809: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1812: aload_1
    //   1813: invokestatic 229	com/tencent/smtt/sdk/m:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/m;
    //   1816: iconst_0
    //   1817: iconst_m1
    //   1818: invokevirtual 232	com/tencent/smtt/sdk/m:c	(II)V
    //   1821: aload_1
    //   1822: invokestatic 229	com/tencent/smtt/sdk/m:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/m;
    //   1825: iconst_1
    //   1826: invokevirtual 235	com/tencent/smtt/sdk/m:c	(I)V
    //   1829: aload 11
    //   1831: ldc_w 1469
    //   1834: invokevirtual 950	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1837: astore 12
    //   1839: new 149	java/io/File
    //   1842: dup
    //   1843: aload 12
    //   1845: invokespecial 254	java/io/File:<init>	(Ljava/lang/String;)V
    //   1848: aload_1
    //   1849: invokestatic 587	com/tencent/smtt/sdk/l:a	(Ljava/io/File;Landroid/content/Context;)V
    //   1852: aload_0
    //   1853: aload_1
    //   1854: aload 12
    //   1856: aload 11
    //   1858: ldc_w 1471
    //   1861: invokevirtual 945	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   1864: invokespecial 650	com/tencent/smtt/sdk/p:b	(Landroid/content/Context;Ljava/lang/String;I)V
    //   1867: aload_1
    //   1868: invokestatic 478	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   1871: ifeq +174 -> 2045
    //   1874: aload_1
    //   1875: invokestatic 229	com/tencent/smtt/sdk/m:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/m;
    //   1878: iconst_m1
    //   1879: invokevirtual 235	com/tencent/smtt/sdk/m:c	(I)V
    //   1882: goto +163 -> 2045
    //   1885: iload_3
    //   1886: iconst_2
    //   1887: if_icmpeq +150 -> 2037
    //   1890: aload_1
    //   1891: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1894: sipush -546
    //   1897: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1900: ldc 125
    //   1902: ldc_w 1449
    //   1905: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1908: aload_1
    //   1909: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1912: getfield 818	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1915: ldc_w 820
    //   1918: iconst_1
    //   1919: invokestatic 718	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1922: invokeinterface 826 3 0
    //   1927: pop
    //   1928: aload_1
    //   1929: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1932: invokevirtual 830	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1935: aload_1
    //   1936: invokestatic 478	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   1939: ifeq +47 -> 1986
    //   1942: aload_1
    //   1943: invokestatic 199	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1946: astore_1
    //   1947: new 155	java/lang/StringBuilder
    //   1950: dup
    //   1951: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   1954: astore 11
    //   1956: aload 11
    //   1958: ldc_w 1451
    //   1961: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1964: pop
    //   1965: aload 11
    //   1967: iload_3
    //   1968: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1971: pop
    //   1972: aload 11
    //   1974: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1977: astore 11
    //   1979: sipush 235
    //   1982: istore_3
    //   1983: goto +44 -> 2027
    //   1986: aload_1
    //   1987: invokestatic 199	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1990: astore_1
    //   1991: new 155	java/lang/StringBuilder
    //   1994: dup
    //   1995: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   1998: astore 11
    //   2000: aload 11
    //   2002: ldc_w 1453
    //   2005: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2008: pop
    //   2009: aload 11
    //   2011: iload_3
    //   2012: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2015: pop
    //   2016: aload 11
    //   2018: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2021: astore 11
    //   2023: sipush 217
    //   2026: istore_3
    //   2027: aload_1
    //   2028: iload_3
    //   2029: aload 11
    //   2031: invokevirtual 205	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   2034: goto +11 -> 2045
    //   2037: ldc 125
    //   2039: ldc_w 1447
    //   2042: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2045: iconst_0
    //   2046: invokestatic 1141	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   2049: aload_2
    //   2050: athrow
    //   2051: aload_1
    //   2052: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2055: sipush -547
    //   2058: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   2061: aload_0
    //   2062: invokevirtual 438	com/tencent/smtt/sdk/p:b	()V
    //   2065: return
    //   2066: iload 5
    //   2068: iconst_1
    //   2069: if_icmpeq +23 -> 2092
    //   2072: iload 5
    //   2074: iconst_2
    //   2075: if_icmpeq +17 -> 2092
    //   2078: iload 5
    //   2080: iconst_4
    //   2081: if_icmpne +6 -> 2087
    //   2084: goto +8 -> 2092
    //   2087: iconst_0
    //   2088: istore_3
    //   2089: goto -1480 -> 609
    //   2092: iconst_1
    //   2093: istore_3
    //   2094: goto -1485 -> 609
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2097	0	this	p
    //   0	2097	1	paramContext	Context
    //   0	2097	2	paramBundle	Bundle
    //   284	1810	3	i1	int
    //   300	1448	4	i2	int
    //   266	1816	5	i3	int
    //   102	35	6	l1	long
    //   111	41	8	l2	long
    //   207	39	10	bool	boolean
    //   7	2023	11	localObject1	Object
    //   649	1206	12	localObject2	Object
    //   876	647	13	localObject3	Object
    //   889	188	14	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   290	316	319	finally
    //   290	316	326	java/lang/Exception
    //   278	285	573	finally
    //   278	285	580	java/lang/Exception
    //   872	878	948	java/lang/Exception
    //   882	891	948	java/lang/Exception
    //   895	904	948	java/lang/Exception
    //   908	921	948	java/lang/Exception
    //   925	938	948	java/lang/Exception
    //   981	987	1099	java/lang/Exception
    //   994	1003	1099	java/lang/Exception
    //   1010	1019	1099	java/lang/Exception
    //   1026	1033	1099	java/lang/Exception
    //   1040	1049	1099	java/lang/Exception
    //   1056	1069	1099	java/lang/Exception
    //   1076	1089	1099	java/lang/Exception
    //   954	963	1103	finally
    //   954	963	1107	java/lang/Exception
    //   268	272	1449	finally
    //   587	606	1449	finally
    //   618	629	1449	finally
    //   634	688	1449	finally
    //   688	708	1449	finally
    //   708	726	1449	finally
    //   726	766	1449	finally
    //   804	823	1449	finally
    //   828	863	1449	finally
    //   1407	1411	1449	finally
    //   268	272	1458	java/lang/Exception
    //   587	606	1458	java/lang/Exception
    //   618	629	1458	java/lang/Exception
    //   634	688	1458	java/lang/Exception
    //   688	708	1458	java/lang/Exception
    //   708	726	1458	java/lang/Exception
    //   726	766	1458	java/lang/Exception
    //   804	823	1458	java/lang/Exception
    //   828	863	1458	java/lang/Exception
    //   1407	1411	1458	java/lang/Exception
    //   872	878	1736	finally
    //   882	891	1736	finally
    //   895	904	1736	finally
    //   908	921	1736	finally
    //   925	938	1736	finally
    //   1545	1555	1736	finally
    //   1559	1573	1736	finally
    //   981	987	1746	finally
    //   994	1003	1746	finally
    //   1010	1019	1746	finally
    //   1026	1033	1746	finally
    //   1040	1049	1746	finally
    //   1056	1069	1746	finally
    //   1076	1089	1746	finally
    //   1471	1480	1746	finally
    //   1487	1496	1746	finally
    //   1503	1513	1746	finally
    //   1520	1530	1746	finally
    //   1537	1541	1746	finally
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
      File localFile = a().q(paramContext);
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
    if (!v(paramContext)) {
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
  
  void c(Context paramContext, int paramInt)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreForThirdPartyApp");
    if (paramInt <= 0) {
      return;
    }
    int i1 = i(paramContext);
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
  
  /* Error */
  boolean c(Context paramContext)
  {
    // Byte code:
    //   0: new 149	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: aload_1
    //   6: invokevirtual 136	com/tencent/smtt/sdk/p:q	(Landroid/content/Context;)Ljava/io/File;
    //   9: ldc_w 278
    //   12: invokespecial 273	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   15: astore 7
    //   17: aload 7
    //   19: invokevirtual 523	java/io/File:exists	()Z
    //   22: istore_2
    //   23: iconst_0
    //   24: istore_3
    //   25: iload_2
    //   26: ifne +5 -> 31
    //   29: iconst_0
    //   30: ireturn
    //   31: new 280	java/util/Properties
    //   34: dup
    //   35: invokespecial 281	java/util/Properties:<init>	()V
    //   38: astore 8
    //   40: aconst_null
    //   41: astore 6
    //   43: aconst_null
    //   44: astore 5
    //   46: new 283	java/io/BufferedInputStream
    //   49: dup
    //   50: new 285	java/io/FileInputStream
    //   53: dup
    //   54: aload 7
    //   56: invokespecial 288	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   59: invokespecial 291	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   62: astore_1
    //   63: aload 8
    //   65: aload_1
    //   66: invokevirtual 294	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   69: aload 8
    //   71: ldc_w 304
    //   74: ldc_w 1539
    //   77: invokevirtual 553	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   80: invokestatic 1542	java/lang/Boolean:valueOf	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   83: invokevirtual 851	java/lang/Boolean:booleanValue	()Z
    //   86: istore 4
    //   88: iload_3
    //   89: istore_2
    //   90: iload 4
    //   92: ifeq +23 -> 115
    //   95: iload_3
    //   96: istore_2
    //   97: invokestatic 503	java/lang/System:currentTimeMillis	()J
    //   100: aload 7
    //   102: invokevirtual 1545	java/io/File:lastModified	()J
    //   105: lsub
    //   106: ldc2_w 1546
    //   109: lcmp
    //   110: ifle +5 -> 115
    //   113: iconst_1
    //   114: istore_2
    //   115: new 155	java/lang/StringBuilder
    //   118: dup
    //   119: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   122: astore 5
    //   124: aload 5
    //   126: ldc_w 1549
    //   129: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: aload 5
    //   135: iload 4
    //   137: invokevirtual 165	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: aload 5
    //   143: ldc_w 1551
    //   146: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: pop
    //   150: aload 5
    //   152: iload_2
    //   153: invokevirtual 165	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: ldc 125
    //   159: aload 5
    //   161: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   167: iload 4
    //   169: iload_2
    //   170: iconst_1
    //   171: ixor
    //   172: iand
    //   173: istore_2
    //   174: iload_2
    //   175: istore_3
    //   176: aload_1
    //   177: invokevirtual 323	java/io/BufferedInputStream:close	()V
    //   180: iload_2
    //   181: ireturn
    //   182: astore_1
    //   183: aload_1
    //   184: invokevirtual 322	java/io/IOException:printStackTrace	()V
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
    //   239: invokevirtual 324	java/lang/Throwable:printStackTrace	()V
    //   242: aload 6
    //   244: ifnull +10 -> 254
    //   247: iload_2
    //   248: istore_3
    //   249: aload 6
    //   251: invokevirtual 323	java/io/BufferedInputStream:close	()V
    //   254: iload_2
    //   255: ireturn
    //   256: aload_1
    //   257: ifnull +15 -> 272
    //   260: aload_1
    //   261: invokevirtual 323	java/io/BufferedInputStream:close	()V
    //   264: goto +8 -> 272
    //   267: astore_1
    //   268: aload_1
    //   269: invokevirtual 322	java/io/IOException:printStackTrace	()V
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
          if (!f((Context)localObject2))
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("TbsInstaller--getTbsCoreHostContext ");
            ((StringBuilder)localObject2).append(localObject1[i1]);
            ((StringBuilder)localObject2).append(" illegal signature go on next");
            TbsLog.e("TbsInstaller", ((StringBuilder)localObject2).toString());
          }
          else
          {
            int i2 = i((Context)localObject2);
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
    //   1: invokestatic 986	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: istore_3
    //   5: aconst_null
    //   6: astore 4
    //   8: iload_3
    //   9: ifeq +5 -> 14
    //   12: aconst_null
    //   13: areturn
    //   14: new 149	java/io/File
    //   17: dup
    //   18: aload_0
    //   19: aload_1
    //   20: invokevirtual 136	com/tencent/smtt/sdk/p:q	(Landroid/content/Context;)Ljava/io/File;
    //   23: ldc_w 278
    //   26: invokespecial 273	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   29: astore_1
    //   30: aload_1
    //   31: invokevirtual 523	java/io/File:exists	()Z
    //   34: ifne +5 -> 39
    //   37: aconst_null
    //   38: areturn
    //   39: new 280	java/util/Properties
    //   42: dup
    //   43: invokespecial 281	java/util/Properties:<init>	()V
    //   46: astore 5
    //   48: new 283	java/io/BufferedInputStream
    //   51: dup
    //   52: new 285	java/io/FileInputStream
    //   55: dup
    //   56: aload_1
    //   57: invokespecial 288	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   60: invokespecial 291	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   63: astore_1
    //   64: aload 5
    //   66: aload_1
    //   67: invokevirtual 294	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   70: aload_1
    //   71: invokevirtual 323	java/io/BufferedInputStream:close	()V
    //   74: aload 5
    //   76: aload_2
    //   77: invokevirtual 1285	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   80: astore_2
    //   81: aload_1
    //   82: invokevirtual 323	java/io/BufferedInputStream:close	()V
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
    //   109: invokevirtual 323	java/io/BufferedInputStream:close	()V
    //   112: aload_1
    //   113: athrow
    //   114: aconst_null
    //   115: astore_1
    //   116: aload_1
    //   117: ifnull +7 -> 124
    //   120: aload_1
    //   121: invokevirtual 323	java/io/BufferedInputStream:close	()V
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
  public void d(Context paramContext)
  {
    // Byte code:
    //   0: new 149	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: aload_1
    //   6: invokevirtual 136	com/tencent/smtt/sdk/p:q	(Landroid/content/Context;)Ljava/io/File;
    //   9: ldc_w 278
    //   12: invokespecial 273	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   15: astore_2
    //   16: new 280	java/util/Properties
    //   19: dup
    //   20: invokespecial 281	java/util/Properties:<init>	()V
    //   23: astore 5
    //   25: aconst_null
    //   26: astore 4
    //   28: aconst_null
    //   29: astore_3
    //   30: new 283	java/io/BufferedInputStream
    //   33: dup
    //   34: new 285	java/io/FileInputStream
    //   37: dup
    //   38: aload_2
    //   39: invokespecial 288	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   42: invokespecial 291	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   45: astore_1
    //   46: aload 5
    //   48: aload_1
    //   49: invokevirtual 294	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   52: new 296	java/io/BufferedOutputStream
    //   55: dup
    //   56: new 298	java/io/FileOutputStream
    //   59: dup
    //   60: aload_2
    //   61: invokespecial 299	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   64: invokespecial 302	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   67: astore_2
    //   68: aload 5
    //   70: ldc_w 304
    //   73: ldc_w 1539
    //   76: invokevirtual 310	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   79: pop
    //   80: aload 5
    //   82: aload_2
    //   83: aconst_null
    //   84: invokevirtual 314	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   87: aload_2
    //   88: invokevirtual 319	java/io/BufferedOutputStream:close	()V
    //   91: aload_1
    //   92: invokevirtual 323	java/io/BufferedInputStream:close	()V
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
    //   135: invokevirtual 319	java/io/BufferedOutputStream:close	()V
    //   138: goto +3 -> 141
    //   141: aload_2
    //   142: ifnull +7 -> 149
    //   145: aload_2
    //   146: invokevirtual 323	java/io/BufferedInputStream:close	()V
    //   149: aload_1
    //   150: athrow
    //   151: aconst_null
    //   152: astore_1
    //   153: aload 4
    //   155: astore_2
    //   156: aload_2
    //   157: ifnull +10 -> 167
    //   160: aload_2
    //   161: invokevirtual 319	java/io/BufferedOutputStream:close	()V
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
  
  int e(Context paramContext, int paramInt)
  {
    return a(f(paramContext, paramInt));
  }
  
  public boolean e(Context paramContext)
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
  
  File f(Context paramContext, int paramInt)
  {
    return a(paramContext, paramInt, true);
  }
  
  boolean f(Context paramContext)
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
      label200:
      break label200;
    }
    TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore getPackageInfo fail");
    return false;
  }
  
  public void g(Context paramContext)
  {
    try
    {
      bool = TbsDownloadConfig.getInstance().getTbsCoreLoadRenameFileLockEnable();
    }
    catch (Throwable localThrowable)
    {
      boolean bool;
      label10:
      FileLock localFileLock;
      break label10;
    }
    bool = true;
    if (!bool) {
      return;
    }
    localFileLock = l;
    if (localFileLock != null) {
      FileUtil.a(paramContext, localFileLock);
    }
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
          localObject = q(paramContext);
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
  
  /* Error */
  int h(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: new 149	java/io/File
    //   8: dup
    //   9: aload_0
    //   10: aload_1
    //   11: invokevirtual 491	com/tencent/smtt/sdk/p:p	(Landroid/content/Context;)Ljava/io/File;
    //   14: ldc_w 278
    //   17: invokespecial 273	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   20: astore_1
    //   21: aload_1
    //   22: invokevirtual 523	java/io/File:exists	()Z
    //   25: ifne +5 -> 30
    //   28: iconst_0
    //   29: ireturn
    //   30: new 280	java/util/Properties
    //   33: dup
    //   34: invokespecial 281	java/util/Properties:<init>	()V
    //   37: astore 5
    //   39: new 283	java/io/BufferedInputStream
    //   42: dup
    //   43: new 285	java/io/FileInputStream
    //   46: dup
    //   47: aload_1
    //   48: invokespecial 288	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   51: invokespecial 291	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   54: astore_1
    //   55: aload 5
    //   57: aload_1
    //   58: invokevirtual 294	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   61: aload_1
    //   62: invokevirtual 323	java/io/BufferedInputStream:close	()V
    //   65: aload 5
    //   67: ldc_w 1284
    //   70: invokevirtual 1285	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   73: astore_3
    //   74: aload_3
    //   75: ifnonnull +9 -> 84
    //   78: aload_1
    //   79: invokevirtual 323	java/io/BufferedInputStream:close	()V
    //   82: iconst_0
    //   83: ireturn
    //   84: aload_3
    //   85: invokestatic 1288	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   88: istore_2
    //   89: aload_1
    //   90: invokevirtual 323	java/io/BufferedInputStream:close	()V
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
    //   114: invokevirtual 323	java/io/BufferedInputStream:close	()V
    //   117: aload_1
    //   118: athrow
    //   119: aload_1
    //   120: ifnull +7 -> 127
    //   123: aload_1
    //   124: invokevirtual 323	java/io/BufferedInputStream:close	()V
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
  int i(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aload 4
    //   8: astore_3
    //   9: new 149	java/io/File
    //   12: dup
    //   13: aload_0
    //   14: aload_1
    //   15: invokevirtual 136	com/tencent/smtt/sdk/p:q	(Landroid/content/Context;)Ljava/io/File;
    //   18: ldc_w 278
    //   21: invokespecial 273	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   24: astore_1
    //   25: aload 4
    //   27: astore_3
    //   28: aload_1
    //   29: invokevirtual 523	java/io/File:exists	()Z
    //   32: ifne +5 -> 37
    //   35: iconst_0
    //   36: ireturn
    //   37: aload 4
    //   39: astore_3
    //   40: new 280	java/util/Properties
    //   43: dup
    //   44: invokespecial 281	java/util/Properties:<init>	()V
    //   47: astore 6
    //   49: aload 4
    //   51: astore_3
    //   52: new 283	java/io/BufferedInputStream
    //   55: dup
    //   56: new 285	java/io/FileInputStream
    //   59: dup
    //   60: aload_1
    //   61: invokespecial 288	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   64: invokespecial 291	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   67: astore_1
    //   68: aload 6
    //   70: aload_1
    //   71: invokevirtual 294	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   74: aload_1
    //   75: invokevirtual 323	java/io/BufferedInputStream:close	()V
    //   78: aload 6
    //   80: ldc_w 1284
    //   83: invokevirtual 1285	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   86: astore_3
    //   87: aload_3
    //   88: ifnonnull +46 -> 134
    //   91: aload_1
    //   92: invokevirtual 323	java/io/BufferedInputStream:close	()V
    //   95: iconst_0
    //   96: ireturn
    //   97: astore_1
    //   98: new 155	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   105: astore_3
    //   106: aload_3
    //   107: ldc_w 1644
    //   110: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: aload_3
    //   115: aload_1
    //   116: invokevirtual 1645	java/io/IOException:toString	()Ljava/lang/String;
    //   119: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: ldc 125
    //   125: aload_3
    //   126: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   132: iconst_0
    //   133: ireturn
    //   134: aload_3
    //   135: invokestatic 1288	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   138: istore_2
    //   139: getstatic 97	com/tencent/smtt/sdk/p:o	I
    //   142: ifne +7 -> 149
    //   145: iload_2
    //   146: putstatic 97	com/tencent/smtt/sdk/p:o	I
    //   149: aload_1
    //   150: invokevirtual 323	java/io/BufferedInputStream:close	()V
    //   153: iload_2
    //   154: ireturn
    //   155: astore_1
    //   156: new 155	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   163: astore_3
    //   164: aload_3
    //   165: ldc_w 1644
    //   168: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: aload_3
    //   173: aload_1
    //   174: invokevirtual 1645	java/io/IOException:toString	()Ljava/lang/String;
    //   177: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: ldc 125
    //   183: aload_3
    //   184: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   218: new 155	java/lang/StringBuilder
    //   221: dup
    //   222: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   225: astore 5
    //   227: aload_1
    //   228: astore_3
    //   229: aload 5
    //   231: ldc_w 1647
    //   234: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: pop
    //   238: aload_1
    //   239: astore_3
    //   240: aload 5
    //   242: aload 4
    //   244: invokevirtual 630	java/lang/Exception:toString	()Ljava/lang/String;
    //   247: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: pop
    //   251: aload_1
    //   252: astore_3
    //   253: ldc 125
    //   255: aload 5
    //   257: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   263: aload_1
    //   264: ifnull +44 -> 308
    //   267: aload_1
    //   268: invokevirtual 323	java/io/BufferedInputStream:close	()V
    //   271: iconst_0
    //   272: ireturn
    //   273: astore_1
    //   274: new 155	java/lang/StringBuilder
    //   277: dup
    //   278: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   281: astore_3
    //   282: aload_3
    //   283: ldc_w 1644
    //   286: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: pop
    //   290: aload_3
    //   291: aload_1
    //   292: invokevirtual 1645	java/io/IOException:toString	()Ljava/lang/String;
    //   295: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: pop
    //   299: ldc 125
    //   301: aload_3
    //   302: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   305: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   308: iconst_0
    //   309: ireturn
    //   310: aload_3
    //   311: ifnull +49 -> 360
    //   314: aload_3
    //   315: invokevirtual 323	java/io/BufferedInputStream:close	()V
    //   318: goto +42 -> 360
    //   321: astore_3
    //   322: new 155	java/lang/StringBuilder
    //   325: dup
    //   326: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   329: astore 4
    //   331: aload 4
    //   333: ldc_w 1644
    //   336: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: pop
    //   340: aload 4
    //   342: aload_3
    //   343: invokevirtual 1645	java/io/IOException:toString	()Ljava/lang/String;
    //   346: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: pop
    //   350: ldc 125
    //   352: aload 4
    //   354: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   357: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
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
  
  int j(Context paramContext)
  {
    int i1 = o;
    if (i1 != 0) {
      return i1;
    }
    return i(paramContext);
  }
  
  void k(Context paramContext)
  {
    if (o != 0) {
      return;
    }
    o = i(paramContext);
  }
  
  boolean l(Context paramContext)
  {
    return new File(q(paramContext), "tbs.conf").exists();
  }
  
  /* Error */
  int m(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 405	com/tencent/smtt/sdk/p:t	(Landroid/content/Context;)Z
    //   5: ifne +5 -> 10
    //   8: iconst_m1
    //   9: ireturn
    //   10: getstatic 41	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   13: invokevirtual 1046	java/util/concurrent/locks/ReentrantLock:tryLock	()Z
    //   16: istore_3
    //   17: new 155	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   24: astore 4
    //   26: aload 4
    //   28: ldc_w 1649
    //   31: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload 4
    //   37: iload_3
    //   38: invokevirtual 165	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: ldc 125
    //   44: aload 4
    //   46: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   52: iload_3
    //   53: ifeq +701 -> 754
    //   56: aconst_null
    //   57: astore 6
    //   59: aconst_null
    //   60: astore 5
    //   62: aload 5
    //   64: astore 4
    //   66: new 149	java/io/File
    //   69: dup
    //   70: aload_0
    //   71: aload_1
    //   72: invokevirtual 136	com/tencent/smtt/sdk/p:q	(Landroid/content/Context;)Ljava/io/File;
    //   75: ldc_w 278
    //   78: invokespecial 273	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   81: astore_1
    //   82: aload 5
    //   84: astore 4
    //   86: aload_1
    //   87: invokevirtual 523	java/io/File:exists	()Z
    //   90: istore_3
    //   91: iload_3
    //   92: ifne +63 -> 155
    //   95: getstatic 41	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   98: invokevirtual 1652	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   101: ifeq +48 -> 149
    //   104: getstatic 41	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   107: invokevirtual 435	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   110: goto +39 -> 149
    //   113: astore_1
    //   114: new 155	java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   121: astore 4
    //   123: aload 4
    //   125: ldc_w 1654
    //   128: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: aload 4
    //   134: aload_1
    //   135: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: ldc 125
    //   141: aload 4
    //   143: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokestatic 346	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   149: aload_0
    //   150: invokevirtual 438	com/tencent/smtt/sdk/p:b	()V
    //   153: iconst_0
    //   154: ireturn
    //   155: aload 5
    //   157: astore 4
    //   159: new 280	java/util/Properties
    //   162: dup
    //   163: invokespecial 281	java/util/Properties:<init>	()V
    //   166: astore 7
    //   168: aload 5
    //   170: astore 4
    //   172: new 283	java/io/BufferedInputStream
    //   175: dup
    //   176: new 285	java/io/FileInputStream
    //   179: dup
    //   180: aload_1
    //   181: invokespecial 288	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   184: invokespecial 291	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   187: astore_1
    //   188: aload 7
    //   190: aload_1
    //   191: invokevirtual 294	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   194: aload_1
    //   195: invokevirtual 323	java/io/BufferedInputStream:close	()V
    //   198: aload 7
    //   200: ldc_w 1284
    //   203: invokevirtual 1285	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   206: astore 4
    //   208: aload 4
    //   210: ifnonnull +109 -> 319
    //   213: aload_1
    //   214: invokevirtual 323	java/io/BufferedInputStream:close	()V
    //   217: goto +42 -> 259
    //   220: astore_1
    //   221: new 155	java/lang/StringBuilder
    //   224: dup
    //   225: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   228: astore 4
    //   230: aload 4
    //   232: ldc_w 1656
    //   235: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: pop
    //   239: aload 4
    //   241: aload_1
    //   242: invokevirtual 1645	java/io/IOException:toString	()Ljava/lang/String;
    //   245: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: pop
    //   249: ldc 125
    //   251: aload 4
    //   253: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   259: getstatic 41	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   262: invokevirtual 1652	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   265: ifeq +48 -> 313
    //   268: getstatic 41	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   271: invokevirtual 435	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   274: goto +39 -> 313
    //   277: astore_1
    //   278: new 155	java/lang/StringBuilder
    //   281: dup
    //   282: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   285: astore 4
    //   287: aload 4
    //   289: ldc_w 1654
    //   292: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: pop
    //   296: aload 4
    //   298: aload_1
    //   299: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   302: pop
    //   303: ldc 125
    //   305: aload 4
    //   307: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   310: invokestatic 346	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   313: aload_0
    //   314: invokevirtual 438	com/tencent/smtt/sdk/p:b	()V
    //   317: iconst_0
    //   318: ireturn
    //   319: getstatic 50	com/tencent/smtt/sdk/p:a	Ljava/lang/ThreadLocal;
    //   322: aload 4
    //   324: invokestatic 1288	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   327: invokestatic 1252	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   330: invokevirtual 1258	java/lang/ThreadLocal:set	(Ljava/lang/Object;)V
    //   333: getstatic 50	com/tencent/smtt/sdk/p:a	Ljava/lang/ThreadLocal;
    //   336: invokevirtual 1292	java/lang/ThreadLocal:get	()Ljava/lang/Object;
    //   339: checkcast 1249	java/lang/Integer
    //   342: invokevirtual 1295	java/lang/Integer:intValue	()I
    //   345: istore_2
    //   346: aload_1
    //   347: invokevirtual 323	java/io/BufferedInputStream:close	()V
    //   350: goto +42 -> 392
    //   353: astore_1
    //   354: new 155	java/lang/StringBuilder
    //   357: dup
    //   358: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   361: astore 4
    //   363: aload 4
    //   365: ldc_w 1656
    //   368: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: pop
    //   372: aload 4
    //   374: aload_1
    //   375: invokevirtual 1645	java/io/IOException:toString	()Ljava/lang/String;
    //   378: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: pop
    //   382: ldc 125
    //   384: aload 4
    //   386: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   389: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   392: getstatic 41	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   395: invokevirtual 1652	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   398: ifeq +48 -> 446
    //   401: getstatic 41	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   404: invokevirtual 435	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   407: goto +39 -> 446
    //   410: astore_1
    //   411: new 155	java/lang/StringBuilder
    //   414: dup
    //   415: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   418: astore 4
    //   420: aload 4
    //   422: ldc_w 1654
    //   425: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: pop
    //   429: aload 4
    //   431: aload_1
    //   432: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   435: pop
    //   436: ldc 125
    //   438: aload 4
    //   440: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   443: invokestatic 346	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   446: aload_0
    //   447: invokevirtual 438	com/tencent/smtt/sdk/p:b	()V
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
    //   480: new 155	java/lang/StringBuilder
    //   483: dup
    //   484: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   487: astore 6
    //   489: aload_1
    //   490: astore 4
    //   492: aload 6
    //   494: ldc_w 1658
    //   497: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: pop
    //   501: aload_1
    //   502: astore 4
    //   504: aload 6
    //   506: aload 5
    //   508: invokevirtual 630	java/lang/Exception:toString	()Ljava/lang/String;
    //   511: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: pop
    //   515: aload_1
    //   516: astore 4
    //   518: ldc 125
    //   520: aload 6
    //   522: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   525: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   528: aload_1
    //   529: ifnull +49 -> 578
    //   532: aload_1
    //   533: invokevirtual 323	java/io/BufferedInputStream:close	()V
    //   536: goto +42 -> 578
    //   539: astore_1
    //   540: new 155	java/lang/StringBuilder
    //   543: dup
    //   544: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   547: astore 4
    //   549: aload 4
    //   551: ldc_w 1656
    //   554: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: pop
    //   558: aload 4
    //   560: aload_1
    //   561: invokevirtual 1645	java/io/IOException:toString	()Ljava/lang/String;
    //   564: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   567: pop
    //   568: ldc 125
    //   570: aload 4
    //   572: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   575: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   578: getstatic 41	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   581: invokevirtual 1652	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   584: ifeq +48 -> 632
    //   587: getstatic 41	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   590: invokevirtual 435	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   593: goto +39 -> 632
    //   596: astore_1
    //   597: new 155	java/lang/StringBuilder
    //   600: dup
    //   601: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   604: astore 4
    //   606: aload 4
    //   608: ldc_w 1654
    //   611: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   614: pop
    //   615: aload 4
    //   617: aload_1
    //   618: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   621: pop
    //   622: ldc 125
    //   624: aload 4
    //   626: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   629: invokestatic 346	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   632: aload_0
    //   633: invokevirtual 438	com/tencent/smtt/sdk/p:b	()V
    //   636: iconst_0
    //   637: ireturn
    //   638: aload 4
    //   640: ifnull +52 -> 692
    //   643: aload 4
    //   645: invokevirtual 323	java/io/BufferedInputStream:close	()V
    //   648: goto +44 -> 692
    //   651: astore 4
    //   653: new 155	java/lang/StringBuilder
    //   656: dup
    //   657: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   660: astore 5
    //   662: aload 5
    //   664: ldc_w 1656
    //   667: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: pop
    //   671: aload 5
    //   673: aload 4
    //   675: invokevirtual 1645	java/io/IOException:toString	()Ljava/lang/String;
    //   678: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   681: pop
    //   682: ldc 125
    //   684: aload 5
    //   686: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   689: invokestatic 132	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   692: getstatic 41	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   695: invokevirtual 1652	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   698: ifeq +50 -> 748
    //   701: getstatic 41	com/tencent/smtt/sdk/p:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   704: invokevirtual 435	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   707: goto +41 -> 748
    //   710: astore 4
    //   712: new 155	java/lang/StringBuilder
    //   715: dup
    //   716: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   719: astore 5
    //   721: aload 5
    //   723: ldc_w 1654
    //   726: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   729: pop
    //   730: aload 5
    //   732: aload 4
    //   734: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   737: pop
    //   738: ldc 125
    //   740: aload 5
    //   742: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   745: invokestatic 346	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   748: aload_0
    //   749: invokevirtual 438	com/tencent/smtt/sdk/p:b	()V
    //   752: aload_1
    //   753: athrow
    //   754: aload_0
    //   755: invokevirtual 438	com/tencent/smtt/sdk/p:b	()V
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
  
  public boolean n(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--coreShareCopyToDecouple #0");
    File localFile1 = q(paramContext);
    File localFile2 = p(paramContext);
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
  
  void o(Context paramContext)
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
  
  File p(Context paramContext)
  {
    paramContext = new File(QbSdk.getTbsFolderDir(paramContext), "core_share_decouple");
    if ((!paramContext.isDirectory()) && (!paramContext.mkdir())) {
      return null;
    }
    return paramContext;
  }
  
  File q(Context paramContext)
  {
    return b(null, paramContext);
  }
  
  File r(Context paramContext)
  {
    paramContext = new File(QbSdk.getTbsFolderDir(paramContext), "share");
    if ((!paramContext.isDirectory()) && (!paramContext.mkdir())) {
      return null;
    }
    return paramContext;
  }
  
  boolean t(Context paramContext)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.smtt.sdk.p
 * JD-Core Version:    0.7.0.1
 */