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

class n
{
  public static ThreadLocal<Integer> a;
  static boolean b = false;
  static final FileFilter c = new n.2();
  private static n d = null;
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
    a = new n.1();
    m = null;
    n = new Long[][] { { Long.valueOf(44006L), Long.valueOf(39094008L) }, { Long.valueOf(44005L), Long.valueOf(39094008L) }, { Long.valueOf(43910L), Long.valueOf(38917816L) }, { Long.valueOf(44027L), Long.valueOf(39094008L) }, { Long.valueOf(44028L), Long.valueOf(39094008L) }, { Long.valueOf(44029L), Long.valueOf(39094008L) }, { Long.valueOf(44030L), Long.valueOf(39094008L) }, { Long.valueOf(44032L), Long.valueOf(39094008L) }, { Long.valueOf(44033L), Long.valueOf(39094008L) }, { Long.valueOf(44034L), Long.valueOf(39094008L) }, { Long.valueOf(43909L), Long.valueOf(38917816L) } };
  }
  
  private n()
  {
    if (m == null) {
      m = new n.3(this, l.a().getLooper());
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
    File localFile1 = f(paramContext, 0);
    File localFile2 = q(paramContext);
    if ((localFile1 == null) || (localFile2 == null))
    {
      TbsLog.i("TbsInstaller", "renameTbsCoreShareDir return,tmpTbsCoreUnzipDir=" + localFile1 + "tbsSharePath=" + localFile2);
      return;
    }
    boolean bool = localFile1.renameTo(localFile2);
    TbsLog.i("TbsInstaller", "renameTbsCoreShareDir rename success=" + bool);
    if ((paramContext != null) && ("com.tencent.mm".equals(paramContext.getApplicationContext().getApplicationInfo().packageName)))
    {
      if (!bool) {
        break label141;
      }
      TbsLogReport.getInstance(paramContext).setInstallErrorCode(230, " ");
    }
    for (;;)
    {
      g(paramContext, false);
      return;
      label141:
      TbsLogReport.getInstance(paramContext).setInstallErrorCode(231, " ");
    }
  }
  
  private void C(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--renameTbsCoreCopyDir");
    File localFile1 = f(paramContext, 1);
    File localFile2 = q(paramContext);
    if ((localFile1 == null) || (localFile2 == null)) {
      return;
    }
    localFile1.renameTo(localFile2);
    g(paramContext, false);
  }
  
  private void D(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--renameTbsTpatchCoreDir");
    File localFile1 = f(paramContext, 5);
    File localFile2 = q(paramContext);
    if ((localFile1 == null) || (localFile2 == null)) {
      return;
    }
    localFile1.renameTo(localFile2);
    g(paramContext, false);
  }
  
  private void E(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--clearNewTbsCore");
    File localFile = f(paramContext, 0);
    if (localFile != null) {
      FileUtil.a(localFile, false);
    }
    k.a(paramContext).c(0, 5);
    k.a(paramContext).c(-1);
    QbSdk.a(paramContext, "TbsInstaller::clearNewTbsCore forceSysWebViewInner!");
  }
  
  /* Error */
  static n a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 36	com/tencent/smtt/sdk/n:d	Lcom/tencent/smtt/sdk/n;
    //   6: ifnonnull +25 -> 31
    //   9: ldc 2
    //   11: monitorenter
    //   12: getstatic 36	com/tencent/smtt/sdk/n:d	Lcom/tencent/smtt/sdk/n;
    //   15: ifnonnull +13 -> 28
    //   18: new 2	com/tencent/smtt/sdk/n
    //   21: dup
    //   22: invokespecial 246	com/tencent/smtt/sdk/n:<init>	()V
    //   25: putstatic 36	com/tencent/smtt/sdk/n:d	Lcom/tencent/smtt/sdk/n;
    //   28: ldc 2
    //   30: monitorexit
    //   31: getstatic 36	com/tencent/smtt/sdk/n:d	Lcom/tencent/smtt/sdk/n;
    //   34: astore_0
    //   35: ldc 2
    //   37: monitorexit
    //   38: aload_0
    //   39: areturn
    //   40: astore_0
    //   41: ldc 2
    //   43: monitorexit
    //   44: aload_0
    //   45: athrow
    //   46: astore_0
    //   47: ldc 2
    //   49: monitorexit
    //   50: aload_0
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   34	5	0	localn	n
    //   40	5	0	localObject1	Object
    //   46	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	28	40	finally
    //   28	31	40	finally
    //   41	44	40	finally
    //   3	12	46	finally
    //   31	35	46	finally
    //   44	46	46	finally
  }
  
  /* Error */
  private void a(int paramInt, String paramString, Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: new 169	java/io/File
    //   9: dup
    //   10: aload_2
    //   11: invokespecial 254	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: invokevirtual 258	java/io/File:delete	()Z
    //   17: pop
    //   18: ldc 127
    //   20: new 151	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   27: ldc_w 260
    //   30: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_2
    //   34: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc_w 262
    //   40: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: iconst_1
    //   47: invokestatic 265	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   50: new 169	java/io/File
    //   53: dup
    //   54: aload_3
    //   55: invokestatic 268	com/tencent/smtt/sdk/QbSdk:getTbsFolderDir	(Landroid/content/Context;)Ljava/io/File;
    //   58: ldc_w 270
    //   61: invokespecial 273	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   64: astore_2
    //   65: aload_2
    //   66: ifnull +113 -> 179
    //   69: aload_2
    //   70: invokevirtual 276	java/io/File:canRead	()Z
    //   73: ifeq +106 -> 179
    //   76: new 169	java/io/File
    //   79: dup
    //   80: aload_2
    //   81: ldc_w 278
    //   84: invokespecial 273	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   87: astore_2
    //   88: new 280	java/util/Properties
    //   91: dup
    //   92: invokespecial 281	java/util/Properties:<init>	()V
    //   95: astore 6
    //   97: new 283	java/io/BufferedInputStream
    //   100: dup
    //   101: new 285	java/io/FileInputStream
    //   104: dup
    //   105: aload_2
    //   106: invokespecial 288	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   109: invokespecial 291	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   112: astore_3
    //   113: aload 6
    //   115: aload_3
    //   116: invokevirtual 294	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   119: new 296	java/io/BufferedOutputStream
    //   122: dup
    //   123: new 298	java/io/FileOutputStream
    //   126: dup
    //   127: aload_2
    //   128: invokespecial 299	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   131: invokespecial 302	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   134: astore_2
    //   135: aload 6
    //   137: ldc_w 304
    //   140: ldc_w 306
    //   143: invokevirtual 310	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   146: pop
    //   147: aload 6
    //   149: aload_2
    //   150: aconst_null
    //   151: invokevirtual 314	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   154: ldc 127
    //   156: ldc_w 316
    //   159: iconst_1
    //   160: invokestatic 265	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   163: aload_2
    //   164: ifnull +7 -> 171
    //   167: aload_2
    //   168: invokevirtual 319	java/io/BufferedOutputStream:close	()V
    //   171: aload_3
    //   172: ifnull +7 -> 179
    //   175: aload_3
    //   176: invokevirtual 320	java/io/BufferedInputStream:close	()V
    //   179: return
    //   180: astore_2
    //   181: aload_2
    //   182: invokevirtual 323	java/io/IOException:printStackTrace	()V
    //   185: goto -14 -> 171
    //   188: astore_2
    //   189: aload_2
    //   190: invokevirtual 323	java/io/IOException:printStackTrace	()V
    //   193: return
    //   194: astore 4
    //   196: aconst_null
    //   197: astore_2
    //   198: aload 5
    //   200: astore_3
    //   201: aload 4
    //   203: invokevirtual 324	java/lang/Throwable:printStackTrace	()V
    //   206: aload_2
    //   207: ifnull +7 -> 214
    //   210: aload_2
    //   211: invokevirtual 319	java/io/BufferedOutputStream:close	()V
    //   214: aload_3
    //   215: ifnull -36 -> 179
    //   218: aload_3
    //   219: invokevirtual 320	java/io/BufferedInputStream:close	()V
    //   222: return
    //   223: astore_2
    //   224: aload_2
    //   225: invokevirtual 323	java/io/IOException:printStackTrace	()V
    //   228: return
    //   229: astore_2
    //   230: aload_2
    //   231: invokevirtual 323	java/io/IOException:printStackTrace	()V
    //   234: goto -20 -> 214
    //   237: astore_2
    //   238: aconst_null
    //   239: astore_3
    //   240: aload 4
    //   242: ifnull +8 -> 250
    //   245: aload 4
    //   247: invokevirtual 319	java/io/BufferedOutputStream:close	()V
    //   250: aload_3
    //   251: ifnull +7 -> 258
    //   254: aload_3
    //   255: invokevirtual 320	java/io/BufferedInputStream:close	()V
    //   258: aload_2
    //   259: athrow
    //   260: astore 4
    //   262: aload 4
    //   264: invokevirtual 323	java/io/IOException:printStackTrace	()V
    //   267: goto -17 -> 250
    //   270: astore_3
    //   271: aload_3
    //   272: invokevirtual 323	java/io/IOException:printStackTrace	()V
    //   275: goto -17 -> 258
    //   278: astore_2
    //   279: goto -39 -> 240
    //   282: astore 5
    //   284: aload_2
    //   285: astore 4
    //   287: aload 5
    //   289: astore_2
    //   290: goto -50 -> 240
    //   293: astore 5
    //   295: aload_2
    //   296: astore 4
    //   298: aload 5
    //   300: astore_2
    //   301: goto -61 -> 240
    //   304: astore 4
    //   306: aconst_null
    //   307: astore_2
    //   308: goto -107 -> 201
    //   311: astore 4
    //   313: goto -112 -> 201
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	316	0	this	n
    //   0	316	1	paramInt	int
    //   0	316	2	paramString	String
    //   0	316	3	paramContext	Context
    //   1	1	4	localObject1	Object
    //   194	52	4	localThrowable1	Throwable
    //   260	3	4	localIOException	java.io.IOException
    //   285	12	4	str	String
    //   304	1	4	localThrowable2	Throwable
    //   311	1	4	localThrowable3	Throwable
    //   4	195	5	localObject2	Object
    //   282	6	5	localObject3	Object
    //   293	6	5	localObject4	Object
    //   95	53	6	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   167	171	180	java/io/IOException
    //   175	179	188	java/io/IOException
    //   97	113	194	java/lang/Throwable
    //   218	222	223	java/io/IOException
    //   210	214	229	java/io/IOException
    //   97	113	237	finally
    //   245	250	260	java/io/IOException
    //   254	258	270	java/io/IOException
    //   113	135	278	finally
    //   135	163	282	finally
    //   201	206	293	finally
    //   113	135	304	java/lang/Throwable
    //   135	163	311	java/lang/Throwable
  }
  
  public static void a(Context paramContext)
  {
    if (!v(paramContext))
    {
      if (!a(paramContext, "core_unzip_tmp")) {
        break label46;
      }
      TbsCoreLoadStat.getInstance().a(paramContext, 417, new Throwable("TMP_TBS_UNZIP_FOLDER_NAME"));
      TbsLog.e("TbsInstaller", "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_TBS_UNZIP_FOLDER_NAME");
    }
    label46:
    do
    {
      return;
      if (a(paramContext, "core_share_backup_tmp"))
      {
        TbsCoreLoadStat.getInstance().a(paramContext, 417, new Throwable("TMP_BACKUP_TBSCORE_FOLDER_NAME"));
        TbsLog.e("TbsInstaller", "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_BACKUP_TBSCORE_FOLDER_NAME");
        return;
      }
    } while (!a(paramContext, "core_copy_tmp"));
    TbsCoreLoadStat.getInstance().a(paramContext, 417, new Throwable("TMP_TBS_COPY_FOLDER_NAME"));
    TbsLog.e("TbsInstaller", "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_TBS_COPY_FOLDER_NAME");
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
    //   12: invokevirtual 374	com/tencent/smtt/sdk/n:c	(Landroid/content/Context;)Z
    //   15: ifeq +4 -> 19
    //   18: return
    //   19: ldc 127
    //   21: new 151	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   28: ldc_w 376
    //   31: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: iload_3
    //   35: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   38: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   44: getstatic 384	android/os/Build$VERSION:SDK_INT	I
    //   47: bipush 11
    //   49: if_icmplt +70 -> 119
    //   52: aload_2
    //   53: ldc_w 386
    //   56: iconst_4
    //   57: invokevirtual 390	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   60: astore 13
    //   62: aload 13
    //   64: ldc_w 392
    //   67: iconst_m1
    //   68: invokeinterface 398 3 0
    //   73: iload_3
    //   74: if_icmpne +58 -> 132
    //   77: ldc 127
    //   79: new 151	java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   86: ldc_w 400
    //   89: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: iload_3
    //   93: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   96: ldc_w 402
    //   99: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: invokestatic 346	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   108: aload_1
    //   109: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   112: sipush -525
    //   115: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   118: return
    //   119: aload_2
    //   120: ldc_w 386
    //   123: iconst_0
    //   124: invokevirtual 390	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   127: astore 13
    //   129: goto -67 -> 62
    //   132: aload_0
    //   133: aload_2
    //   134: invokevirtual 405	com/tencent/smtt/sdk/n:t	(Landroid/content/Context;)Z
    //   137: ifne +14 -> 151
    //   140: aload_1
    //   141: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   144: sipush -526
    //   147: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   150: return
    //   151: getstatic 45	com/tencent/smtt/sdk/n:j	Ljava/util/concurrent/locks/Lock;
    //   154: invokeinterface 410 1 0
    //   159: istore 8
    //   161: ldc 127
    //   163: new 151	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   170: ldc_w 412
    //   173: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: iload 8
    //   178: invokevirtual 178	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   181: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   187: iload 8
    //   189: ifeq +1756 -> 1945
    //   192: getstatic 43	com/tencent/smtt/sdk/n:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   195: invokevirtual 415	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   198: aconst_null
    //   199: astore 14
    //   201: aload_2
    //   202: invokestatic 231	com/tencent/smtt/sdk/k:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/k;
    //   205: ldc_w 417
    //   208: invokevirtual 420	com/tencent/smtt/sdk/k:c	(Ljava/lang/String;)I
    //   211: istore 4
    //   213: aload_2
    //   214: invokestatic 231	com/tencent/smtt/sdk/k:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/k;
    //   217: ldc_w 422
    //   220: invokevirtual 424	com/tencent/smtt/sdk/k:b	(Ljava/lang/String;)I
    //   223: istore 5
    //   225: iload 4
    //   227: iload_3
    //   228: if_icmpne +43 -> 271
    //   231: getstatic 427	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   234: sipush 220
    //   237: invokeinterface 432 2 0
    //   242: aload_1
    //   243: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   246: sipush -528
    //   249: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   252: getstatic 43	com/tencent/smtt/sdk/n:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   255: invokevirtual 435	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   258: getstatic 45	com/tencent/smtt/sdk/n:j	Ljava/util/concurrent/locks/Lock;
    //   261: invokeinterface 436 1 0
    //   266: aload_0
    //   267: invokevirtual 438	com/tencent/smtt/sdk/n:b	()V
    //   270: return
    //   271: aload_0
    //   272: aload_2
    //   273: invokevirtual 441	com/tencent/smtt/sdk/n:i	(Landroid/content/Context;)I
    //   276: istore 6
    //   278: ldc 127
    //   280: new 151	java/lang/StringBuilder
    //   283: dup
    //   284: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   287: ldc_w 443
    //   290: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: iload 6
    //   295: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   298: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   301: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   304: iload 6
    //   306: iload_3
    //   307: if_icmpne +69 -> 376
    //   310: getstatic 427	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   313: sipush 220
    //   316: invokeinterface 432 2 0
    //   321: aload_1
    //   322: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   325: sipush -528
    //   328: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   331: ldc 127
    //   333: new 151	java/lang/StringBuilder
    //   336: dup
    //   337: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   340: ldc_w 445
    //   343: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: iload 6
    //   348: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   351: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   354: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   357: getstatic 43	com/tencent/smtt/sdk/n:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   360: invokevirtual 435	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   363: getstatic 45	com/tencent/smtt/sdk/n:j	Ljava/util/concurrent/locks/Lock;
    //   366: invokeinterface 436 1 0
    //   371: aload_0
    //   372: invokevirtual 438	com/tencent/smtt/sdk/n:b	()V
    //   375: return
    //   376: aload_2
    //   377: invokestatic 231	com/tencent/smtt/sdk/k:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/k;
    //   380: invokevirtual 448	com/tencent/smtt/sdk/k:b	()I
    //   383: istore 7
    //   385: iload 7
    //   387: ifle +1615 -> 2002
    //   390: iload_3
    //   391: iload 7
    //   393: if_icmpgt +6 -> 399
    //   396: goto +1606 -> 2002
    //   399: aload_0
    //   400: aload_2
    //   401: invokevirtual 450	com/tencent/smtt/sdk/n:o	(Landroid/content/Context;)V
    //   404: goto +1612 -> 2016
    //   407: aload_0
    //   408: aload_2
    //   409: invokevirtual 450	com/tencent/smtt/sdk/n:o	(Landroid/content/Context;)V
    //   412: ldc 127
    //   414: ldc_w 452
    //   417: iconst_1
    //   418: invokestatic 265	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   421: iconst_m1
    //   422: istore 4
    //   424: aload_2
    //   425: invokestatic 454	com/tencent/smtt/utils/FileUtil:b	(Landroid/content/Context;)Z
    //   428: ifne +88 -> 516
    //   431: invokestatic 459	com/tencent/smtt/utils/o:a	()J
    //   434: lstore 9
    //   436: aload_2
    //   437: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   440: invokevirtual 462	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMinFreeSpace	()J
    //   443: lstore 11
    //   445: aload_1
    //   446: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   449: sipush -529
    //   452: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   455: aload_2
    //   456: invokestatic 208	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   459: sipush 210
    //   462: new 151	java/lang/StringBuilder
    //   465: dup
    //   466: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   469: ldc_w 464
    //   472: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: lload 9
    //   477: invokevirtual 467	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   480: ldc_w 469
    //   483: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: lload 11
    //   488: invokevirtual 467	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   491: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   494: invokevirtual 214	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   497: getstatic 43	com/tencent/smtt/sdk/n:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   500: invokevirtual 435	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   503: getstatic 45	com/tencent/smtt/sdk/n:j	Ljava/util/concurrent/locks/Lock;
    //   506: invokeinterface 436 1 0
    //   511: aload_0
    //   512: invokevirtual 438	com/tencent/smtt/sdk/n:b	()V
    //   515: return
    //   516: iload 4
    //   518: ifle +26 -> 544
    //   521: aload_2
    //   522: invokestatic 474	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   525: ifne +84 -> 609
    //   528: aload_2
    //   529: invokestatic 478	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   532: ifeq +77 -> 609
    //   535: iload_3
    //   536: aload_0
    //   537: aload_2
    //   538: invokevirtual 480	com/tencent/smtt/sdk/n:h	(Landroid/content/Context;)I
    //   541: if_icmpeq +68 -> 609
    //   544: iload 4
    //   546: ifne +125 -> 671
    //   549: aload_2
    //   550: invokestatic 231	com/tencent/smtt/sdk/k:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/k;
    //   553: ldc_w 482
    //   556: invokevirtual 420	com/tencent/smtt/sdk/k:c	(Ljava/lang/String;)I
    //   559: istore 4
    //   561: iload 4
    //   563: iconst_2
    //   564: if_icmple +93 -> 657
    //   567: aload_2
    //   568: invokestatic 208	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   571: sipush 211
    //   574: ldc_w 484
    //   577: invokevirtual 214	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   580: aload_1
    //   581: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   584: sipush -530
    //   587: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   590: getstatic 43	com/tencent/smtt/sdk/n:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   593: invokevirtual 435	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   596: getstatic 45	com/tencent/smtt/sdk/n:j	Ljava/util/concurrent/locks/Lock;
    //   599: invokeinterface 436 1 0
    //   604: aload_0
    //   605: invokevirtual 438	com/tencent/smtt/sdk/n:b	()V
    //   608: return
    //   609: ldc 127
    //   611: new 151	java/lang/StringBuilder
    //   614: dup
    //   615: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   618: ldc_w 486
    //   621: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: aload_0
    //   625: aload_2
    //   626: invokevirtual 480	com/tencent/smtt/sdk/n:h	(Landroid/content/Context;)I
    //   629: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   632: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   635: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   638: getstatic 43	com/tencent/smtt/sdk/n:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   641: invokevirtual 435	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   644: getstatic 45	com/tencent/smtt/sdk/n:j	Ljava/util/concurrent/locks/Lock;
    //   647: invokeinterface 436 1 0
    //   652: aload_0
    //   653: invokevirtual 438	com/tencent/smtt/sdk/n:b	()V
    //   656: return
    //   657: aload_2
    //   658: invokestatic 231	com/tencent/smtt/sdk/k:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/k;
    //   661: ldc_w 482
    //   664: iload 4
    //   666: iconst_1
    //   667: iadd
    //   668: invokevirtual 489	com/tencent/smtt/sdk/k:a	(Ljava/lang/String;I)V
    //   671: aload_0
    //   672: aload_1
    //   673: invokevirtual 138	com/tencent/smtt/sdk/n:q	(Landroid/content/Context;)Ljava/io/File;
    //   676: astore 15
    //   678: aload_2
    //   679: invokestatic 474	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   682: ifne +207 -> 889
    //   685: aload_2
    //   686: invokestatic 478	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   689: ifeq +189 -> 878
    //   692: aload_0
    //   693: aload_2
    //   694: invokevirtual 491	com/tencent/smtt/sdk/n:p	(Landroid/content/Context;)Ljava/io/File;
    //   697: astore 13
    //   699: aload 15
    //   701: ifnull +1140 -> 1841
    //   704: aload 13
    //   706: ifnull +1135 -> 1841
    //   709: aload_2
    //   710: invokestatic 231	com/tencent/smtt/sdk/k:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/k;
    //   713: iload_3
    //   714: iconst_0
    //   715: invokevirtual 493	com/tencent/smtt/sdk/k:a	(II)V
    //   718: new 495	com/tencent/smtt/utils/n
    //   721: dup
    //   722: invokespecial 496	com/tencent/smtt/utils/n:<init>	()V
    //   725: astore 14
    //   727: aload 14
    //   729: aload 15
    //   731: invokevirtual 498	com/tencent/smtt/utils/n:a	(Ljava/io/File;)V
    //   734: invokestatic 503	java/lang/System:currentTimeMillis	()J
    //   737: lstore 9
    //   739: aload_1
    //   740: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   743: sipush -551
    //   746: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   749: aload 15
    //   751: aload 13
    //   753: getstatic 97	com/tencent/smtt/sdk/n:c	Ljava/io/FileFilter;
    //   756: invokestatic 506	com/tencent/smtt/utils/FileUtil:a	(Ljava/io/File;Ljava/io/File;Ljava/io/FileFilter;)Z
    //   759: istore 8
    //   761: aload_2
    //   762: invokestatic 478	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   765: ifeq +7 -> 772
    //   768: aload_2
    //   769: invokestatic 508	com/tencent/smtt/sdk/TbsShareManager:b	(Landroid/content/Context;)V
    //   772: ldc 127
    //   774: new 151	java/lang/StringBuilder
    //   777: dup
    //   778: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   781: ldc_w 510
    //   784: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   787: invokestatic 503	java/lang/System:currentTimeMillis	()J
    //   790: lload 9
    //   792: lsub
    //   793: invokevirtual 467	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   796: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   799: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   802: iload 8
    //   804: ifeq +988 -> 1792
    //   807: aload 14
    //   809: aload 15
    //   811: invokevirtual 512	com/tencent/smtt/utils/n:b	(Ljava/io/File;)V
    //   814: aload 14
    //   816: invokevirtual 514	com/tencent/smtt/utils/n:a	()Z
    //   819: ifne +81 -> 900
    //   822: ldc 127
    //   824: ldc_w 516
    //   827: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   830: aload 13
    //   832: iconst_1
    //   833: invokestatic 143	com/tencent/smtt/utils/FileUtil:a	(Ljava/io/File;Z)V
    //   836: aload_2
    //   837: invokestatic 208	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   840: sipush 213
    //   843: ldc_w 518
    //   846: invokevirtual 214	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   849: aload_1
    //   850: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   853: sipush -531
    //   856: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   859: getstatic 43	com/tencent/smtt/sdk/n:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   862: invokevirtual 435	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   865: getstatic 45	com/tencent/smtt/sdk/n:j	Ljava/util/concurrent/locks/Lock;
    //   868: invokeinterface 436 1 0
    //   873: aload_0
    //   874: invokevirtual 438	com/tencent/smtt/sdk/n:b	()V
    //   877: return
    //   878: aload_0
    //   879: aload_2
    //   880: iconst_1
    //   881: invokevirtual 149	com/tencent/smtt/sdk/n:f	(Landroid/content/Context;I)Ljava/io/File;
    //   884: astore 13
    //   886: goto -187 -> 699
    //   889: aload_0
    //   890: aload_2
    //   891: iconst_1
    //   892: invokevirtual 149	com/tencent/smtt/sdk/n:f	(Landroid/content/Context;I)Ljava/io/File;
    //   895: astore 13
    //   897: goto -198 -> 699
    //   900: aconst_null
    //   901: astore 16
    //   903: new 169	java/io/File
    //   906: dup
    //   907: aload 13
    //   909: ldc_w 520
    //   912: invokespecial 273	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   915: astore 14
    //   917: new 280	java/util/Properties
    //   920: dup
    //   921: invokespecial 281	java/util/Properties:<init>	()V
    //   924: astore 15
    //   926: aload 14
    //   928: ifnull +1136 -> 2064
    //   931: aload 14
    //   933: invokevirtual 523	java/io/File:exists	()Z
    //   936: ifeq +1128 -> 2064
    //   939: aload 15
    //   941: ifnull +1123 -> 2064
    //   944: new 283	java/io/BufferedInputStream
    //   947: dup
    //   948: new 285	java/io/FileInputStream
    //   951: dup
    //   952: aload 14
    //   954: invokespecial 288	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   957: invokespecial 291	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   960: astore 14
    //   962: aload 14
    //   964: astore 17
    //   966: aload 15
    //   968: aload 14
    //   970: invokevirtual 294	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   973: iconst_1
    //   974: istore 4
    //   976: aload 14
    //   978: ifnull +1021 -> 1999
    //   981: aload 14
    //   983: invokevirtual 320	java/io/BufferedInputStream:close	()V
    //   986: iload 4
    //   988: ifeq +999 -> 1987
    //   991: aload 13
    //   993: invokevirtual 527	java/io/File:listFiles	()[Ljava/io/File;
    //   996: astore 14
    //   998: aload_1
    //   999: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1002: sipush -552
    //   1005: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1008: iconst_0
    //   1009: istore 5
    //   1011: iload 5
    //   1013: aload 14
    //   1015: arraylength
    //   1016: if_icmpge +971 -> 1987
    //   1019: aload 14
    //   1021: iload 5
    //   1023: aaload
    //   1024: astore 16
    //   1026: ldc_w 520
    //   1029: aload 16
    //   1031: invokevirtual 530	java/io/File:getName	()Ljava/lang/String;
    //   1034: invokevirtual 202	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1037: ifne +1018 -> 2055
    //   1040: aload 16
    //   1042: invokevirtual 530	java/io/File:getName	()Ljava/lang/String;
    //   1045: ldc_w 532
    //   1048: invokevirtual 536	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1051: ifne +1004 -> 2055
    //   1054: ldc_w 278
    //   1057: aload 16
    //   1059: invokevirtual 530	java/io/File:getName	()Ljava/lang/String;
    //   1062: invokevirtual 202	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1065: ifne +990 -> 2055
    //   1068: aload 16
    //   1070: invokevirtual 539	java/io/File:isDirectory	()Z
    //   1073: ifne +982 -> 2055
    //   1076: aload 16
    //   1078: invokevirtual 530	java/io/File:getName	()Ljava/lang/String;
    //   1081: ldc_w 541
    //   1084: invokevirtual 536	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1087: ifeq +181 -> 1268
    //   1090: goto +965 -> 2055
    //   1093: astore 14
    //   1095: aload 14
    //   1097: invokevirtual 323	java/io/IOException:printStackTrace	()V
    //   1100: goto -114 -> 986
    //   1103: astore 16
    //   1105: aconst_null
    //   1106: astore 15
    //   1108: aconst_null
    //   1109: astore 14
    //   1111: aload 14
    //   1113: astore 17
    //   1115: aload 16
    //   1117: invokevirtual 542	java/lang/Exception:printStackTrace	()V
    //   1120: aload 14
    //   1122: ifnull +871 -> 1993
    //   1125: aload 14
    //   1127: invokevirtual 320	java/io/BufferedInputStream:close	()V
    //   1130: iconst_1
    //   1131: istore 4
    //   1133: goto -147 -> 986
    //   1136: astore 14
    //   1138: aload 14
    //   1140: invokevirtual 323	java/io/IOException:printStackTrace	()V
    //   1143: iconst_1
    //   1144: istore 4
    //   1146: goto -160 -> 986
    //   1149: astore 14
    //   1151: aload 16
    //   1153: astore 15
    //   1155: aload 15
    //   1157: ifnull +8 -> 1165
    //   1160: aload 15
    //   1162: invokevirtual 320	java/io/BufferedInputStream:close	()V
    //   1165: aload 14
    //   1167: athrow
    //   1168: astore 15
    //   1170: aload 13
    //   1172: astore 14
    //   1174: aload 15
    //   1176: astore 13
    //   1178: aload_2
    //   1179: invokestatic 208	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1182: sipush 215
    //   1185: aload 13
    //   1187: invokevirtual 543	java/lang/Exception:toString	()Ljava/lang/String;
    //   1190: invokevirtual 214	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1193: aload_1
    //   1194: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1197: sipush -537
    //   1200: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1203: aload 14
    //   1205: iconst_0
    //   1206: invokestatic 143	com/tencent/smtt/utils/FileUtil:a	(Ljava/io/File;Z)V
    //   1209: aload_2
    //   1210: invokestatic 231	com/tencent/smtt/sdk/k:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/k;
    //   1213: iconst_0
    //   1214: iconst_m1
    //   1215: invokevirtual 493	com/tencent/smtt/sdk/k:a	(II)V
    //   1218: getstatic 43	com/tencent/smtt/sdk/n:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1221: invokevirtual 435	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1224: getstatic 45	com/tencent/smtt/sdk/n:j	Ljava/util/concurrent/locks/Lock;
    //   1227: invokeinterface 436 1 0
    //   1232: aload_0
    //   1233: invokevirtual 438	com/tencent/smtt/sdk/n:b	()V
    //   1236: return
    //   1237: astore 15
    //   1239: aload 15
    //   1241: invokevirtual 323	java/io/IOException:printStackTrace	()V
    //   1244: goto -79 -> 1165
    //   1247: astore_1
    //   1248: getstatic 43	com/tencent/smtt/sdk/n:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1251: invokevirtual 435	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1254: getstatic 45	com/tencent/smtt/sdk/n:j	Ljava/util/concurrent/locks/Lock;
    //   1257: invokeinterface 436 1 0
    //   1262: aload_0
    //   1263: invokevirtual 438	com/tencent/smtt/sdk/n:b	()V
    //   1266: aload_1
    //   1267: athrow
    //   1268: aload 16
    //   1270: invokestatic 548	com/tencent/smtt/utils/a:a	(Ljava/io/File;)Ljava/lang/String;
    //   1273: astore 17
    //   1275: aload 15
    //   1277: aload 16
    //   1279: invokevirtual 530	java/io/File:getName	()Ljava/lang/String;
    //   1282: ldc_w 550
    //   1285: invokevirtual 554	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1288: astore 18
    //   1290: aload 18
    //   1292: ldc_w 550
    //   1295: invokevirtual 202	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1298: ifne +51 -> 1349
    //   1301: aload 17
    //   1303: aload 18
    //   1305: invokevirtual 202	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1308: ifeq +41 -> 1349
    //   1311: ldc 127
    //   1313: new 151	java/lang/StringBuilder
    //   1316: dup
    //   1317: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   1320: ldc_w 556
    //   1323: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1326: aload 16
    //   1328: invokevirtual 530	java/io/File:getName	()Ljava/lang/String;
    //   1331: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1334: ldc_w 558
    //   1337: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1340: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1343: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1346: goto +709 -> 2055
    //   1349: ldc 127
    //   1351: new 151	java/lang/StringBuilder
    //   1354: dup
    //   1355: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   1358: ldc_w 560
    //   1361: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1364: aload 16
    //   1366: invokevirtual 530	java/io/File:getName	()Ljava/lang/String;
    //   1369: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1372: ldc_w 558
    //   1375: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1378: ldc_w 562
    //   1381: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1384: aload 18
    //   1386: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1389: ldc_w 564
    //   1392: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1395: aload 17
    //   1397: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1400: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1403: invokestatic 346	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1406: iconst_0
    //   1407: istore 8
    //   1409: ldc 127
    //   1411: new 151	java/lang/StringBuilder
    //   1414: dup
    //   1415: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   1418: ldc_w 566
    //   1421: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1424: iload 8
    //   1426: invokevirtual 178	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1429: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1432: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1435: iload 4
    //   1437: ifeq +64 -> 1501
    //   1440: iload 8
    //   1442: ifne +59 -> 1501
    //   1445: ldc 127
    //   1447: ldc_w 568
    //   1450: invokestatic 346	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1453: aload 13
    //   1455: iconst_1
    //   1456: invokestatic 143	com/tencent/smtt/utils/FileUtil:a	(Ljava/io/File;Z)V
    //   1459: aload_2
    //   1460: invokestatic 208	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1463: sipush 213
    //   1466: ldc_w 570
    //   1469: invokevirtual 214	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1472: aload_1
    //   1473: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1476: sipush -532
    //   1479: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1482: getstatic 43	com/tencent/smtt/sdk/n:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1485: invokevirtual 435	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1488: getstatic 45	com/tencent/smtt/sdk/n:j	Ljava/util/concurrent/locks/Lock;
    //   1491: invokeinterface 436 1 0
    //   1496: aload_0
    //   1497: invokevirtual 438	com/tencent/smtt/sdk/n:b	()V
    //   1500: return
    //   1501: ldc 127
    //   1503: ldc_w 572
    //   1506: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1509: aload_0
    //   1510: aload_2
    //   1511: iconst_1
    //   1512: invokespecial 217	com/tencent/smtt/sdk/n:g	(Landroid/content/Context;Z)V
    //   1515: aload_1
    //   1516: invokestatic 576	com/tencent/smtt/sdk/j:b	(Landroid/content/Context;)Ljava/io/File;
    //   1519: astore 15
    //   1521: aload 15
    //   1523: ifnull +38 -> 1561
    //   1526: aload 15
    //   1528: invokevirtual 523	java/io/File:exists	()Z
    //   1531: ifeq +30 -> 1561
    //   1534: aload_2
    //   1535: invokestatic 579	com/tencent/smtt/sdk/TbsDownloader:getOverSea	(Landroid/content/Context;)Z
    //   1538: ifeq +182 -> 1720
    //   1541: ldc_w 581
    //   1544: astore 14
    //   1546: new 169	java/io/File
    //   1549: dup
    //   1550: aload 15
    //   1552: aload 14
    //   1554: invokespecial 273	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   1557: aload_2
    //   1558: invokestatic 584	com/tencent/smtt/sdk/j:a	(Ljava/io/File;Landroid/content/Context;)V
    //   1561: aload_2
    //   1562: invokestatic 231	com/tencent/smtt/sdk/k:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/k;
    //   1565: iload_3
    //   1566: iconst_1
    //   1567: invokevirtual 493	com/tencent/smtt/sdk/k:a	(II)V
    //   1570: aload_0
    //   1571: getfield 109	com/tencent/smtt/sdk/n:k	Z
    //   1574: ifeq +155 -> 1729
    //   1577: aload_2
    //   1578: invokestatic 208	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1581: sipush 220
    //   1584: ldc_w 586
    //   1587: invokevirtual 214	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1590: aload_1
    //   1591: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1594: sipush -533
    //   1597: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1600: ldc 127
    //   1602: new 151	java/lang/StringBuilder
    //   1605: dup
    //   1606: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   1609: ldc_w 588
    //   1612: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1615: iload_3
    //   1616: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1619: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1622: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1625: getstatic 384	android/os/Build$VERSION:SDK_INT	I
    //   1628: bipush 11
    //   1630: if_icmplt +115 -> 1745
    //   1633: aload_2
    //   1634: ldc_w 386
    //   1637: iconst_4
    //   1638: invokevirtual 390	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   1641: astore 14
    //   1643: aload 14
    //   1645: invokeinterface 592 1 0
    //   1650: astore 14
    //   1652: aload 14
    //   1654: ldc_w 594
    //   1657: iconst_0
    //   1658: invokeinterface 600 3 0
    //   1663: pop
    //   1664: aload 14
    //   1666: ldc_w 602
    //   1669: iconst_0
    //   1670: invokeinterface 600 3 0
    //   1675: pop
    //   1676: aload 14
    //   1678: ldc_w 604
    //   1681: iload_3
    //   1682: invokeinterface 600 3 0
    //   1687: pop
    //   1688: aload 14
    //   1690: invokeinterface 607 1 0
    //   1695: pop
    //   1696: aload_2
    //   1697: invokestatic 608	com/tencent/smtt/utils/o:a	(Landroid/content/Context;)Z
    //   1700: pop
    //   1701: getstatic 43	com/tencent/smtt/sdk/n:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1704: invokevirtual 435	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1707: getstatic 45	com/tencent/smtt/sdk/n:j	Ljava/util/concurrent/locks/Lock;
    //   1710: invokeinterface 436 1 0
    //   1715: aload_0
    //   1716: invokevirtual 438	com/tencent/smtt/sdk/n:b	()V
    //   1719: return
    //   1720: iconst_0
    //   1721: invokestatic 612	com/tencent/smtt/sdk/TbsDownloader:getBackupFileName	(Z)Ljava/lang/String;
    //   1724: astore 14
    //   1726: goto -180 -> 1546
    //   1729: aload_2
    //   1730: invokestatic 208	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1733: sipush 220
    //   1736: ldc_w 614
    //   1739: invokevirtual 214	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1742: goto -152 -> 1590
    //   1745: aload_2
    //   1746: ldc_w 386
    //   1749: iconst_0
    //   1750: invokevirtual 390	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   1753: astore 14
    //   1755: goto -112 -> 1643
    //   1758: astore 14
    //   1760: ldc 127
    //   1762: new 151	java/lang/StringBuilder
    //   1765: dup
    //   1766: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   1769: ldc_w 616
    //   1772: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1775: aload 14
    //   1777: invokestatic 622	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1780: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1783: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1786: invokestatic 346	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1789: goto -93 -> 1696
    //   1792: ldc 127
    //   1794: ldc_w 624
    //   1797: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1800: aload_2
    //   1801: invokestatic 231	com/tencent/smtt/sdk/k:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/k;
    //   1804: iload_3
    //   1805: iconst_2
    //   1806: invokevirtual 493	com/tencent/smtt/sdk/k:a	(II)V
    //   1809: aload 13
    //   1811: iconst_0
    //   1812: invokestatic 143	com/tencent/smtt/utils/FileUtil:a	(Ljava/io/File;Z)V
    //   1815: aload_1
    //   1816: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1819: sipush -534
    //   1822: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1825: aload_2
    //   1826: invokestatic 208	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1829: sipush 212
    //   1832: ldc_w 626
    //   1835: invokevirtual 214	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1838: goto -137 -> 1701
    //   1841: aload 15
    //   1843: ifnonnull +26 -> 1869
    //   1846: aload_2
    //   1847: invokestatic 208	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1850: sipush 213
    //   1853: ldc_w 628
    //   1856: invokevirtual 214	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1859: aload_1
    //   1860: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1863: sipush -535
    //   1866: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1869: aload 13
    //   1871: ifnonnull -170 -> 1701
    //   1874: aload_2
    //   1875: invokestatic 208	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1878: sipush 214
    //   1881: ldc_w 630
    //   1884: invokevirtual 214	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1887: aload_1
    //   1888: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1891: sipush -536
    //   1894: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1897: goto -196 -> 1701
    //   1900: astore_1
    //   1901: ldc 127
    //   1903: new 151	java/lang/StringBuilder
    //   1906: dup
    //   1907: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   1910: ldc_w 632
    //   1913: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1916: aload_1
    //   1917: invokevirtual 635	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1920: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1923: ldc_w 637
    //   1926: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1929: aload_1
    //   1930: invokevirtual 641	java/lang/Exception:getCause	()Ljava/lang/Throwable;
    //   1933: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1936: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1939: invokestatic 346	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1942: goto -724 -> 1218
    //   1945: aload_0
    //   1946: invokevirtual 438	com/tencent/smtt/sdk/n:b	()V
    //   1949: aload_1
    //   1950: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1953: sipush -538
    //   1956: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1959: return
    //   1960: astore 13
    //   1962: goto -784 -> 1178
    //   1965: astore 14
    //   1967: aload 17
    //   1969: astore 15
    //   1971: goto -816 -> 1155
    //   1974: astore 16
    //   1976: aconst_null
    //   1977: astore 14
    //   1979: goto -868 -> 1111
    //   1982: astore 16
    //   1984: goto -873 -> 1111
    //   1987: iconst_1
    //   1988: istore 8
    //   1990: goto -581 -> 1409
    //   1993: iconst_1
    //   1994: istore 4
    //   1996: goto -1010 -> 986
    //   1999: goto -1013 -> 986
    //   2002: iload 4
    //   2004: ifle +12 -> 2016
    //   2007: iload_3
    //   2008: iload 4
    //   2010: if_icmple +6 -> 2016
    //   2013: goto -1614 -> 399
    //   2016: iload 5
    //   2018: istore 4
    //   2020: iload 5
    //   2022: iconst_3
    //   2023: if_icmpne -1599 -> 424
    //   2026: iload 5
    //   2028: istore 4
    //   2030: iload 6
    //   2032: ifle -1608 -> 424
    //   2035: iload_3
    //   2036: iload 6
    //   2038: if_icmpgt -1631 -> 407
    //   2041: iload 5
    //   2043: istore 4
    //   2045: iload_3
    //   2046: ldc_w 642
    //   2049: if_icmpne -1625 -> 424
    //   2052: goto -1645 -> 407
    //   2055: iload 5
    //   2057: iconst_1
    //   2058: iadd
    //   2059: istore 5
    //   2061: goto -1050 -> 1011
    //   2064: aconst_null
    //   2065: astore 14
    //   2067: iconst_0
    //   2068: istore 4
    //   2070: goto -1094 -> 976
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2073	0	this	n
    //   0	2073	1	paramContext1	Context
    //   0	2073	2	paramContext2	Context
    //   0	2073	3	paramInt	int
    //   211	1858	4	i1	int
    //   223	1837	5	i2	int
    //   276	1763	6	i3	int
    //   383	11	7	i4	int
    //   159	1830	8	bool	boolean
    //   434	357	9	l1	long
    //   443	44	11	l2	long
    //   60	1810	13	localObject1	Object
    //   1960	1	13	localException1	Exception
    //   199	821	14	localObject2	Object
    //   1093	3	14	localIOException1	java.io.IOException
    //   1109	17	14	localObject3	Object
    //   1136	3	14	localIOException2	java.io.IOException
    //   1149	17	14	localObject4	Object
    //   1172	582	14	localObject5	Object
    //   1758	18	14	localThrowable	Throwable
    //   1965	1	14	localObject6	Object
    //   1977	89	14	localObject7	Object
    //   676	485	15	localObject8	Object
    //   1168	7	15	localException2	Exception
    //   1237	39	15	localIOException3	java.io.IOException
    //   1519	451	15	localObject9	Object
    //   901	176	16	localObject10	Object
    //   1103	262	16	localException3	Exception
    //   1974	1	16	localException4	Exception
    //   1982	1	16	localException5	Exception
    //   964	1004	17	localObject11	Object
    //   1288	97	18	str	String
    // Exception table:
    //   from	to	target	type
    //   981	986	1093	java/io/IOException
    //   903	926	1103	java/lang/Exception
    //   1125	1130	1136	java/io/IOException
    //   903	926	1149	finally
    //   931	939	1149	finally
    //   944	962	1149	finally
    //   709	772	1168	java/lang/Exception
    //   772	802	1168	java/lang/Exception
    //   807	859	1168	java/lang/Exception
    //   981	986	1168	java/lang/Exception
    //   991	1008	1168	java/lang/Exception
    //   1011	1019	1168	java/lang/Exception
    //   1026	1090	1168	java/lang/Exception
    //   1095	1100	1168	java/lang/Exception
    //   1125	1130	1168	java/lang/Exception
    //   1138	1143	1168	java/lang/Exception
    //   1160	1165	1168	java/lang/Exception
    //   1165	1168	1168	java/lang/Exception
    //   1239	1244	1168	java/lang/Exception
    //   1268	1346	1168	java/lang/Exception
    //   1349	1406	1168	java/lang/Exception
    //   1409	1435	1168	java/lang/Exception
    //   1445	1482	1168	java/lang/Exception
    //   1501	1521	1168	java/lang/Exception
    //   1526	1541	1168	java/lang/Exception
    //   1546	1561	1168	java/lang/Exception
    //   1561	1590	1168	java/lang/Exception
    //   1590	1643	1168	java/lang/Exception
    //   1643	1696	1168	java/lang/Exception
    //   1696	1701	1168	java/lang/Exception
    //   1720	1726	1168	java/lang/Exception
    //   1729	1742	1168	java/lang/Exception
    //   1745	1755	1168	java/lang/Exception
    //   1760	1789	1168	java/lang/Exception
    //   1792	1838	1168	java/lang/Exception
    //   1846	1869	1168	java/lang/Exception
    //   1874	1897	1168	java/lang/Exception
    //   1160	1165	1237	java/io/IOException
    //   201	225	1247	finally
    //   231	252	1247	finally
    //   271	304	1247	finally
    //   310	357	1247	finally
    //   376	385	1247	finally
    //   399	404	1247	finally
    //   407	421	1247	finally
    //   424	497	1247	finally
    //   521	544	1247	finally
    //   549	561	1247	finally
    //   567	590	1247	finally
    //   609	638	1247	finally
    //   657	671	1247	finally
    //   671	699	1247	finally
    //   709	772	1247	finally
    //   772	802	1247	finally
    //   807	859	1247	finally
    //   878	886	1247	finally
    //   889	897	1247	finally
    //   981	986	1247	finally
    //   991	1008	1247	finally
    //   1011	1019	1247	finally
    //   1026	1090	1247	finally
    //   1095	1100	1247	finally
    //   1125	1130	1247	finally
    //   1138	1143	1247	finally
    //   1160	1165	1247	finally
    //   1165	1168	1247	finally
    //   1178	1203	1247	finally
    //   1203	1218	1247	finally
    //   1239	1244	1247	finally
    //   1268	1346	1247	finally
    //   1349	1406	1247	finally
    //   1409	1435	1247	finally
    //   1445	1482	1247	finally
    //   1501	1521	1247	finally
    //   1526	1541	1247	finally
    //   1546	1561	1247	finally
    //   1561	1590	1247	finally
    //   1590	1643	1247	finally
    //   1643	1696	1247	finally
    //   1696	1701	1247	finally
    //   1720	1726	1247	finally
    //   1729	1742	1247	finally
    //   1745	1755	1247	finally
    //   1760	1789	1247	finally
    //   1792	1838	1247	finally
    //   1846	1869	1247	finally
    //   1874	1897	1247	finally
    //   1901	1942	1247	finally
    //   1643	1696	1758	java/lang/Throwable
    //   1203	1218	1900	java/lang/Exception
    //   201	225	1960	java/lang/Exception
    //   231	252	1960	java/lang/Exception
    //   271	304	1960	java/lang/Exception
    //   310	357	1960	java/lang/Exception
    //   376	385	1960	java/lang/Exception
    //   399	404	1960	java/lang/Exception
    //   407	421	1960	java/lang/Exception
    //   424	497	1960	java/lang/Exception
    //   521	544	1960	java/lang/Exception
    //   549	561	1960	java/lang/Exception
    //   567	590	1960	java/lang/Exception
    //   609	638	1960	java/lang/Exception
    //   657	671	1960	java/lang/Exception
    //   671	699	1960	java/lang/Exception
    //   878	886	1960	java/lang/Exception
    //   889	897	1960	java/lang/Exception
    //   966	973	1965	finally
    //   1115	1120	1965	finally
    //   931	939	1974	java/lang/Exception
    //   944	962	1974	java/lang/Exception
    //   966	973	1982	java/lang/Exception
  }
  
  private boolean a(Context paramContext, File paramFile)
  {
    return a(paramContext, paramFile, false);
  }
  
  /* Error */
  private boolean a(Context paramContext, File paramFile, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 6
    //   3: iconst_1
    //   4: istore 5
    //   6: ldc 127
    //   8: ldc_w 656
    //   11: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: aload_2
    //   15: invokestatic 658	com/tencent/smtt/utils/FileUtil:c	(Ljava/io/File;)Z
    //   18: ifne +28 -> 46
    //   21: aload_1
    //   22: invokestatic 208	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   25: sipush 204
    //   28: ldc_w 660
    //   31: invokevirtual 214	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   34: aload_1
    //   35: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   38: sipush -520
    //   41: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   44: iconst_0
    //   45: ireturn
    //   46: aload_1
    //   47: invokestatic 268	com/tencent/smtt/sdk/QbSdk:getTbsFolderDir	(Landroid/content/Context;)Ljava/io/File;
    //   50: astore 9
    //   52: iload_3
    //   53: ifeq +84 -> 137
    //   56: new 169	java/io/File
    //   59: dup
    //   60: aload 9
    //   62: ldc_w 662
    //   65: invokespecial 273	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   68: astore 9
    //   70: aload 9
    //   72: ifnull +23 -> 95
    //   75: aload 9
    //   77: invokevirtual 523	java/io/File:exists	()Z
    //   80: ifeq +15 -> 95
    //   83: aload_1
    //   84: invokestatic 478	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   87: ifne +8 -> 95
    //   90: aload 9
    //   92: invokestatic 663	com/tencent/smtt/utils/FileUtil:b	(Ljava/io/File;)V
    //   95: iload_3
    //   96: ifeq +92 -> 188
    //   99: aload_0
    //   100: aload_1
    //   101: iconst_2
    //   102: invokevirtual 149	com/tencent/smtt/sdk/n:f	(Landroid/content/Context;I)Ljava/io/File;
    //   105: astore 9
    //   107: aload 9
    //   109: ifnonnull +90 -> 199
    //   112: aload_1
    //   113: invokestatic 208	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   116: sipush 205
    //   119: ldc_w 665
    //   122: invokevirtual 214	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   125: aload_1
    //   126: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   129: sipush -521
    //   132: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   135: iconst_0
    //   136: ireturn
    //   137: new 169	java/io/File
    //   140: dup
    //   141: aload 9
    //   143: ldc_w 270
    //   146: invokespecial 273	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   149: astore 9
    //   151: goto -81 -> 70
    //   154: astore 9
    //   156: ldc 127
    //   158: new 151	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   165: ldc_w 667
    //   168: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: aload 9
    //   173: invokestatic 622	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   176: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: invokestatic 346	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   185: goto -90 -> 95
    //   188: aload_0
    //   189: aload_1
    //   190: iconst_0
    //   191: invokevirtual 149	com/tencent/smtt/sdk/n:f	(Landroid/content/Context;I)Ljava/io/File;
    //   194: astore 9
    //   196: goto -89 -> 107
    //   199: aload 9
    //   201: invokestatic 669	com/tencent/smtt/utils/FileUtil:a	(Ljava/io/File;)Z
    //   204: pop
    //   205: iload_3
    //   206: ifeq +9 -> 215
    //   209: aload 9
    //   211: iconst_1
    //   212: invokestatic 143	com/tencent/smtt/utils/FileUtil:a	(Ljava/io/File;Z)V
    //   215: aload_2
    //   216: aload 9
    //   218: invokestatic 672	com/tencent/smtt/utils/FileUtil:a	(Ljava/io/File;Ljava/io/File;)Z
    //   221: istore 8
    //   223: iload 8
    //   225: istore 7
    //   227: iload 8
    //   229: ifeq +12 -> 241
    //   232: aload_0
    //   233: aload 9
    //   235: aload_1
    //   236: invokespecial 675	com/tencent/smtt/sdk/n:a	(Ljava/io/File;Landroid/content/Context;)Z
    //   239: istore 7
    //   241: iload_3
    //   242: ifeq +81 -> 323
    //   245: aload 9
    //   247: invokevirtual 679	java/io/File:list	()[Ljava/lang/String;
    //   250: astore_2
    //   251: iconst_0
    //   252: istore 4
    //   254: iload 4
    //   256: aload_2
    //   257: arraylength
    //   258: if_icmpge +47 -> 305
    //   261: new 169	java/io/File
    //   264: dup
    //   265: aload 9
    //   267: aload_2
    //   268: iload 4
    //   270: aaload
    //   271: invokespecial 273	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   274: astore 10
    //   276: aload 10
    //   278: invokevirtual 530	java/io/File:getName	()Ljava/lang/String;
    //   281: ldc_w 532
    //   284: invokevirtual 536	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   287: ifeq +9 -> 296
    //   290: aload 10
    //   292: invokevirtual 258	java/io/File:delete	()Z
    //   295: pop
    //   296: iload 4
    //   298: iconst_1
    //   299: iadd
    //   300: istore 4
    //   302: goto -48 -> 254
    //   305: new 169	java/io/File
    //   308: dup
    //   309: aload_1
    //   310: invokestatic 682	com/tencent/smtt/sdk/n:s	(Landroid/content/Context;)Ljava/io/File;
    //   313: ldc_w 684
    //   316: invokespecial 273	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   319: invokevirtual 258	java/io/File:delete	()Z
    //   322: pop
    //   323: iload 7
    //   325: ifne +58 -> 383
    //   328: aload 9
    //   330: invokestatic 663	com/tencent/smtt/utils/FileUtil:b	(Ljava/io/File;)V
    //   333: aload_1
    //   334: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   337: sipush -522
    //   340: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   343: ldc 127
    //   345: new 151	java/lang/StringBuilder
    //   348: dup
    //   349: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   352: ldc_w 686
    //   355: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: aload 9
    //   360: invokevirtual 523	java/io/File:exists	()Z
    //   363: invokevirtual 178	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   366: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   369: invokestatic 346	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   372: ldc 127
    //   374: ldc_w 688
    //   377: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   380: iload 7
    //   382: ireturn
    //   383: aload_0
    //   384: aload_1
    //   385: iconst_1
    //   386: invokespecial 217	com/tencent/smtt/sdk/n:g	(Landroid/content/Context;Z)V
    //   389: iload_3
    //   390: ifeq -18 -> 372
    //   393: aload_0
    //   394: aload_1
    //   395: invokevirtual 491	com/tencent/smtt/sdk/n:p	(Landroid/content/Context;)Ljava/io/File;
    //   398: astore_2
    //   399: aload_2
    //   400: iconst_1
    //   401: invokestatic 143	com/tencent/smtt/utils/FileUtil:a	(Ljava/io/File;Z)V
    //   404: aload 9
    //   406: aload_2
    //   407: invokevirtual 173	java/io/File:renameTo	(Ljava/io/File;)Z
    //   410: pop
    //   411: aload_1
    //   412: invokestatic 508	com/tencent/smtt/sdk/TbsShareManager:b	(Landroid/content/Context;)V
    //   415: goto -43 -> 372
    //   418: astore_2
    //   419: aload_1
    //   420: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   423: sipush -523
    //   426: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   429: aload_1
    //   430: invokestatic 208	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   433: sipush 206
    //   436: aload_2
    //   437: invokevirtual 691	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/Throwable;)V
    //   440: aload 9
    //   442: ifnull +251 -> 693
    //   445: aload 9
    //   447: invokevirtual 523	java/io/File:exists	()Z
    //   450: istore_3
    //   451: iload_3
    //   452: ifeq +241 -> 693
    //   455: iload 5
    //   457: istore 4
    //   459: iload 4
    //   461: ifeq +42 -> 503
    //   464: aload 9
    //   466: ifnull +37 -> 503
    //   469: aload 9
    //   471: invokestatic 663	com/tencent/smtt/utils/FileUtil:b	(Ljava/io/File;)V
    //   474: ldc 127
    //   476: new 151	java/lang/StringBuilder
    //   479: dup
    //   480: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   483: ldc_w 693
    //   486: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: aload 9
    //   491: invokevirtual 523	java/io/File:exists	()Z
    //   494: invokevirtual 178	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   497: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   500: invokestatic 346	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   503: ldc 127
    //   505: ldc_w 688
    //   508: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   511: iconst_0
    //   512: ireturn
    //   513: astore_1
    //   514: ldc 127
    //   516: new 151	java/lang/StringBuilder
    //   519: dup
    //   520: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   523: ldc_w 695
    //   526: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: aload_1
    //   530: invokestatic 622	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   533: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   536: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   539: invokestatic 346	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   542: goto -39 -> 503
    //   545: astore_2
    //   546: aload_1
    //   547: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   550: sipush -523
    //   553: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   556: aload_1
    //   557: invokestatic 208	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   560: sipush 207
    //   563: aload_2
    //   564: invokevirtual 691	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/Throwable;)V
    //   567: aload 9
    //   569: ifnull +118 -> 687
    //   572: aload 9
    //   574: invokevirtual 523	java/io/File:exists	()Z
    //   577: istore_3
    //   578: iload_3
    //   579: ifeq +108 -> 687
    //   582: iload 6
    //   584: istore 4
    //   586: iload 4
    //   588: ifeq +42 -> 630
    //   591: aload 9
    //   593: ifnull +37 -> 630
    //   596: aload 9
    //   598: invokestatic 663	com/tencent/smtt/utils/FileUtil:b	(Ljava/io/File;)V
    //   601: ldc 127
    //   603: new 151	java/lang/StringBuilder
    //   606: dup
    //   607: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   610: ldc_w 693
    //   613: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   616: aload 9
    //   618: invokevirtual 523	java/io/File:exists	()Z
    //   621: invokevirtual 178	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   624: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   627: invokestatic 346	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   630: ldc 127
    //   632: ldc_w 688
    //   635: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   638: iconst_0
    //   639: ireturn
    //   640: astore_1
    //   641: ldc 127
    //   643: new 151	java/lang/StringBuilder
    //   646: dup
    //   647: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   650: ldc_w 695
    //   653: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   656: aload_1
    //   657: invokestatic 622	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   660: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   663: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   666: invokestatic 346	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   669: goto -39 -> 630
    //   672: astore_1
    //   673: ldc 127
    //   675: ldc_w 688
    //   678: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   681: aload_1
    //   682: athrow
    //   683: astore_2
    //   684: goto -361 -> 323
    //   687: iconst_0
    //   688: istore 4
    //   690: goto -104 -> 586
    //   693: iconst_0
    //   694: istore 4
    //   696: goto -237 -> 459
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	699	0	this	n
    //   0	699	1	paramContext	Context
    //   0	699	2	paramFile	File
    //   0	699	3	paramBoolean	boolean
    //   252	443	4	i1	int
    //   4	452	5	i2	int
    //   1	582	6	i3	int
    //   225	156	7	bool1	boolean
    //   221	7	8	bool2	boolean
    //   50	100	9	localFile1	File
    //   154	18	9	localThrowable	Throwable
    //   194	423	9	localFile2	File
    //   274	17	10	localFile3	File
    // Exception table:
    //   from	to	target	type
    //   46	52	154	java/lang/Throwable
    //   56	70	154	java/lang/Throwable
    //   75	95	154	java/lang/Throwable
    //   137	151	154	java/lang/Throwable
    //   199	205	418	java/io/IOException
    //   209	215	418	java/io/IOException
    //   215	223	418	java/io/IOException
    //   232	241	418	java/io/IOException
    //   245	251	418	java/io/IOException
    //   254	296	418	java/io/IOException
    //   305	323	418	java/io/IOException
    //   328	372	418	java/io/IOException
    //   383	389	418	java/io/IOException
    //   393	415	418	java/io/IOException
    //   469	503	513	java/lang/Throwable
    //   199	205	545	java/lang/Exception
    //   209	215	545	java/lang/Exception
    //   215	223	545	java/lang/Exception
    //   232	241	545	java/lang/Exception
    //   245	251	545	java/lang/Exception
    //   254	296	545	java/lang/Exception
    //   328	372	545	java/lang/Exception
    //   383	389	545	java/lang/Exception
    //   393	415	545	java/lang/Exception
    //   596	630	640	java/lang/Throwable
    //   199	205	672	finally
    //   209	215	672	finally
    //   215	223	672	finally
    //   232	241	672	finally
    //   245	251	672	finally
    //   254	296	672	finally
    //   305	323	672	finally
    //   328	372	672	finally
    //   383	389	672	finally
    //   393	415	672	finally
    //   419	440	672	finally
    //   445	451	672	finally
    //   546	567	672	finally
    //   572	578	672	finally
    //   305	323	683	java/lang/Exception
  }
  
  static boolean a(Context paramContext, String paramString)
  {
    paramContext = new File(QbSdk.getTbsFolderDir(paramContext), paramString);
    if ((paramContext == null) || (!paramContext.exists()))
    {
      TbsLog.i("TbsInstaller", "TbsInstaller-isPrepareTbsCore, #1");
      return false;
    }
    paramContext = new File(paramContext, "tbs.conf");
    if ((paramContext == null) || (!paramContext.exists()))
    {
      TbsLog.i("TbsInstaller", "TbsInstaller-isPrepareTbsCore, #2");
      return false;
    }
    TbsLog.i("TbsInstaller", "TbsInstaller-isPrepareTbsCore, #3");
    return true;
  }
  
  /* Error */
  private boolean a(File paramFile, Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 8
    //   6: ldc 127
    //   8: new 151	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   15: ldc_w 703
    //   18: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_1
    //   22: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   25: ldc_w 705
    //   28: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: aload_2
    //   32: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: aload 6
    //   43: astore_2
    //   44: new 169	java/io/File
    //   47: dup
    //   48: aload_1
    //   49: ldc_w 520
    //   52: invokespecial 273	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   55: astore 9
    //   57: aload 6
    //   59: astore_2
    //   60: new 280	java/util/Properties
    //   63: dup
    //   64: invokespecial 281	java/util/Properties:<init>	()V
    //   67: astore 7
    //   69: aload 9
    //   71: ifnull +191 -> 262
    //   74: aload 6
    //   76: astore_2
    //   77: aload 9
    //   79: invokevirtual 523	java/io/File:exists	()Z
    //   82: ifeq +180 -> 262
    //   85: aload 7
    //   87: ifnull +175 -> 262
    //   90: aload 6
    //   92: astore_2
    //   93: new 283	java/io/BufferedInputStream
    //   96: dup
    //   97: new 285	java/io/FileInputStream
    //   100: dup
    //   101: aload 9
    //   103: invokespecial 288	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   106: invokespecial 291	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   109: astore 6
    //   111: aload 7
    //   113: aload 6
    //   115: invokevirtual 294	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   118: iconst_1
    //   119: istore 5
    //   121: aload 6
    //   123: astore_2
    //   124: aload 7
    //   126: astore 6
    //   128: iload 5
    //   130: istore 4
    //   132: aload_2
    //   133: ifnull +15 -> 148
    //   136: aload_2
    //   137: invokevirtual 320	java/io/BufferedInputStream:close	()V
    //   140: iload 5
    //   142: istore 4
    //   144: aload 7
    //   146: astore 6
    //   148: ldc 127
    //   150: new 151	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   157: ldc_w 707
    //   160: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: iload 4
    //   165: invokevirtual 178	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   168: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   174: iload 4
    //   176: ifeq +395 -> 571
    //   179: aload_1
    //   180: invokevirtual 527	java/io/File:listFiles	()[Ljava/io/File;
    //   183: astore_1
    //   184: iconst_0
    //   185: istore_3
    //   186: iload_3
    //   187: aload_1
    //   188: arraylength
    //   189: if_icmpge +382 -> 571
    //   192: aload_1
    //   193: iload_3
    //   194: aaload
    //   195: astore_2
    //   196: ldc_w 520
    //   199: aload_2
    //   200: invokevirtual 530	java/io/File:getName	()Ljava/lang/String;
    //   203: invokevirtual 202	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   206: ifne +49 -> 255
    //   209: aload_2
    //   210: invokevirtual 530	java/io/File:getName	()Ljava/lang/String;
    //   213: ldc_w 532
    //   216: invokevirtual 536	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   219: ifne +36 -> 255
    //   222: ldc_w 278
    //   225: aload_2
    //   226: invokevirtual 530	java/io/File:getName	()Ljava/lang/String;
    //   229: invokevirtual 202	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   232: ifne +23 -> 255
    //   235: aload_2
    //   236: invokevirtual 539	java/io/File:isDirectory	()Z
    //   239: ifne +16 -> 255
    //   242: aload_2
    //   243: invokevirtual 530	java/io/File:getName	()Ljava/lang/String;
    //   246: ldc_w 541
    //   249: invokevirtual 536	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   252: ifeq +93 -> 345
    //   255: iload_3
    //   256: iconst_1
    //   257: iadd
    //   258: istore_3
    //   259: goto -73 -> 186
    //   262: aconst_null
    //   263: astore_2
    //   264: iconst_0
    //   265: istore 5
    //   267: goto -143 -> 124
    //   270: astore_2
    //   271: aload_2
    //   272: invokevirtual 323	java/io/IOException:printStackTrace	()V
    //   275: aload 7
    //   277: astore 6
    //   279: iload 5
    //   281: istore 4
    //   283: goto -135 -> 148
    //   286: astore 7
    //   288: aconst_null
    //   289: astore 6
    //   291: aload 8
    //   293: astore_2
    //   294: aload 7
    //   296: invokevirtual 542	java/lang/Exception:printStackTrace	()V
    //   299: aload 8
    //   301: ifnull +276 -> 577
    //   304: aload 8
    //   306: invokevirtual 320	java/io/BufferedInputStream:close	()V
    //   309: iconst_1
    //   310: istore 4
    //   312: goto -164 -> 148
    //   315: astore_2
    //   316: aload_2
    //   317: invokevirtual 323	java/io/IOException:printStackTrace	()V
    //   320: iconst_1
    //   321: istore 4
    //   323: goto -175 -> 148
    //   326: astore_1
    //   327: aload_2
    //   328: ifnull +7 -> 335
    //   331: aload_2
    //   332: invokevirtual 320	java/io/BufferedInputStream:close	()V
    //   335: aload_1
    //   336: athrow
    //   337: astore_2
    //   338: aload_2
    //   339: invokevirtual 323	java/io/IOException:printStackTrace	()V
    //   342: goto -7 -> 335
    //   345: aload_2
    //   346: invokestatic 548	com/tencent/smtt/utils/a:a	(Ljava/io/File;)Ljava/lang/String;
    //   349: astore 7
    //   351: aload 6
    //   353: aload_2
    //   354: invokevirtual 530	java/io/File:getName	()Ljava/lang/String;
    //   357: ldc_w 550
    //   360: invokevirtual 554	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   363: astore 8
    //   365: aload 8
    //   367: ldc_w 550
    //   370: invokevirtual 202	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   373: ifne +50 -> 423
    //   376: aload 8
    //   378: aload 7
    //   380: invokevirtual 202	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   383: ifeq +40 -> 423
    //   386: ldc 127
    //   388: new 151	java/lang/StringBuilder
    //   391: dup
    //   392: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   395: ldc_w 556
    //   398: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: aload_2
    //   402: invokevirtual 530	java/io/File:getName	()Ljava/lang/String;
    //   405: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: ldc_w 558
    //   411: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   417: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   420: goto -165 -> 255
    //   423: ldc 127
    //   425: new 151	java/lang/StringBuilder
    //   428: dup
    //   429: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   432: ldc_w 560
    //   435: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: aload_2
    //   439: invokevirtual 530	java/io/File:getName	()Ljava/lang/String;
    //   442: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: ldc_w 558
    //   448: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: ldc_w 562
    //   454: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: aload 8
    //   459: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: ldc_w 564
    //   465: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: aload 7
    //   470: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   476: invokestatic 346	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   479: iconst_0
    //   480: istore 5
    //   482: ldc 127
    //   484: new 151	java/lang/StringBuilder
    //   487: dup
    //   488: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   491: ldc_w 709
    //   494: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: iload 5
    //   499: invokevirtual 178	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   502: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   505: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   508: iload 4
    //   510: ifeq +18 -> 528
    //   513: iload 5
    //   515: ifne +13 -> 528
    //   518: ldc 127
    //   520: ldc_w 711
    //   523: invokestatic 346	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   526: iconst_0
    //   527: ireturn
    //   528: ldc 127
    //   530: ldc_w 713
    //   533: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   536: iconst_1
    //   537: ireturn
    //   538: astore_1
    //   539: aload 6
    //   541: astore_2
    //   542: goto -215 -> 327
    //   545: astore_2
    //   546: aload 7
    //   548: astore 6
    //   550: aload_2
    //   551: astore 7
    //   553: goto -262 -> 291
    //   556: astore_2
    //   557: aload 6
    //   559: astore 8
    //   561: aload 7
    //   563: astore 6
    //   565: aload_2
    //   566: astore 7
    //   568: goto -277 -> 291
    //   571: iconst_1
    //   572: istore 5
    //   574: goto -92 -> 482
    //   577: iconst_1
    //   578: istore 4
    //   580: goto -432 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	583	0	this	n
    //   0	583	1	paramFile	File
    //   0	583	2	paramContext	Context
    //   185	74	3	i1	int
    //   130	449	4	bool1	boolean
    //   119	454	5	bool2	boolean
    //   1	563	6	localObject1	Object
    //   67	209	7	localProperties	java.util.Properties
    //   286	9	7	localException	Exception
    //   349	218	7	localObject2	Object
    //   4	556	8	localObject3	Object
    //   55	47	9	localFile	File
    // Exception table:
    //   from	to	target	type
    //   136	140	270	java/io/IOException
    //   44	57	286	java/lang/Exception
    //   60	69	286	java/lang/Exception
    //   304	309	315	java/io/IOException
    //   44	57	326	finally
    //   60	69	326	finally
    //   77	85	326	finally
    //   93	111	326	finally
    //   294	299	326	finally
    //   331	335	337	java/io/IOException
    //   111	118	538	finally
    //   77	85	545	java/lang/Exception
    //   93	111	545	java/lang/Exception
    //   111	118	556	java/lang/Exception
  }
  
  /* Error */
  @android.annotation.TargetApi(11)
  private void b(Context paramContext, String paramString, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 7
    //   3: iconst_1
    //   4: istore 8
    //   6: aload_1
    //   7: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   10: sipush -501
    //   13: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   16: aload_0
    //   17: aload_1
    //   18: invokevirtual 374	com/tencent/smtt/sdk/n:c	(Landroid/content/Context;)Z
    //   21: ifeq +23 -> 44
    //   24: ldc 127
    //   26: ldc_w 715
    //   29: iconst_1
    //   30: invokestatic 265	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   33: aload_1
    //   34: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   37: sipush -502
    //   40: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   43: return
    //   44: ldc 127
    //   46: new 151	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   53: ldc_w 717
    //   56: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: aload_2
    //   60: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   69: ldc 127
    //   71: new 151	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   78: ldc_w 719
    //   81: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: iload_3
    //   85: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   88: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   94: ldc 127
    //   96: new 151	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   103: ldc_w 721
    //   106: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: aload_1
    //   110: invokevirtual 190	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   113: getfield 724	android/content/pm/ApplicationInfo:processName	Ljava/lang/String;
    //   116: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   125: ldc 127
    //   127: new 151	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   134: ldc_w 726
    //   137: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: invokestatic 731	android/os/Process:myPid	()I
    //   143: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   146: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   152: ldc 127
    //   154: new 151	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   161: ldc_w 733
    //   164: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: invokestatic 739	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   170: invokevirtual 740	java/lang/Thread:getName	()Ljava/lang/String;
    //   173: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   182: getstatic 384	android/os/Build$VERSION:SDK_INT	I
    //   185: bipush 11
    //   187: if_icmplt +70 -> 257
    //   190: aload_1
    //   191: ldc_w 386
    //   194: iconst_4
    //   195: invokevirtual 390	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   198: astore 15
    //   200: aload 15
    //   202: ldc_w 392
    //   205: iconst_m1
    //   206: invokeinterface 398 3 0
    //   211: iload_3
    //   212: if_icmpne +58 -> 270
    //   215: ldc 127
    //   217: new 151	java/lang/StringBuilder
    //   220: dup
    //   221: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   224: ldc_w 742
    //   227: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: iload_3
    //   231: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   234: ldc_w 402
    //   237: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   243: invokestatic 346	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   246: aload_1
    //   247: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   250: sipush -503
    //   253: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   256: return
    //   257: aload_1
    //   258: ldc_w 386
    //   261: iconst_0
    //   262: invokevirtual 390	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   265: astore 15
    //   267: goto -67 -> 200
    //   270: aload_1
    //   271: invokestatic 454	com/tencent/smtt/utils/FileUtil:b	(Landroid/content/Context;)Z
    //   274: ifne +70 -> 344
    //   277: invokestatic 459	com/tencent/smtt/utils/o:a	()J
    //   280: lstore 10
    //   282: aload_1
    //   283: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   286: invokevirtual 462	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMinFreeSpace	()J
    //   289: lstore 12
    //   291: aload_1
    //   292: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   295: sipush -504
    //   298: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   301: aload_1
    //   302: invokestatic 208	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   305: sipush 210
    //   308: new 151	java/lang/StringBuilder
    //   311: dup
    //   312: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   315: ldc_w 744
    //   318: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: lload 10
    //   323: invokevirtual 467	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   326: ldc_w 469
    //   329: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: lload 12
    //   334: invokevirtual 467	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   337: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   340: invokevirtual 214	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   343: return
    //   344: aload_0
    //   345: aload_1
    //   346: invokevirtual 405	com/tencent/smtt/sdk/n:t	(Landroid/content/Context;)Z
    //   349: ifne +14 -> 363
    //   352: aload_1
    //   353: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   356: sipush -505
    //   359: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   362: return
    //   363: getstatic 45	com/tencent/smtt/sdk/n:j	Ljava/util/concurrent/locks/Lock;
    //   366: invokeinterface 410 1 0
    //   371: istore 14
    //   373: ldc 127
    //   375: new 151	java/lang/StringBuilder
    //   378: dup
    //   379: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   382: ldc_w 746
    //   385: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: iload 14
    //   390: invokevirtual 178	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   393: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   396: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   399: iload 14
    //   401: ifeq +1973 -> 2374
    //   404: aload_1
    //   405: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   408: sipush -507
    //   411: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   414: getstatic 43	com/tencent/smtt/sdk/n:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   417: invokevirtual 415	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   420: aload_1
    //   421: invokestatic 231	com/tencent/smtt/sdk/k:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/k;
    //   424: ldc_w 417
    //   427: invokevirtual 420	com/tencent/smtt/sdk/k:c	(Ljava/lang/String;)I
    //   430: istore 4
    //   432: aload_1
    //   433: invokestatic 231	com/tencent/smtt/sdk/k:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/k;
    //   436: invokevirtual 448	com/tencent/smtt/sdk/k:b	()I
    //   439: istore 5
    //   441: ldc 127
    //   443: new 151	java/lang/StringBuilder
    //   446: dup
    //   447: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   450: ldc_w 748
    //   453: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: iload 4
    //   458: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   461: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   464: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   467: ldc 127
    //   469: new 151	java/lang/StringBuilder
    //   472: dup
    //   473: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   476: ldc_w 750
    //   479: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: iload 5
    //   484: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   487: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   490: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   493: ldc 127
    //   495: new 151	java/lang/StringBuilder
    //   498: dup
    //   499: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   502: ldc_w 752
    //   505: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: iload_3
    //   509: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   512: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   515: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   518: iload 5
    //   520: ifle +1880 -> 2400
    //   523: iload_3
    //   524: iload 5
    //   526: if_icmpgt +6 -> 532
    //   529: goto +1871 -> 2400
    //   532: aload_0
    //   533: aload_1
    //   534: invokevirtual 450	com/tencent/smtt/sdk/n:o	(Landroid/content/Context;)V
    //   537: aload_1
    //   538: invokestatic 231	com/tencent/smtt/sdk/k:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/k;
    //   541: invokevirtual 754	com/tencent/smtt/sdk/k:c	()I
    //   544: istore 5
    //   546: aload_0
    //   547: aload_1
    //   548: invokevirtual 441	com/tencent/smtt/sdk/n:i	(Landroid/content/Context;)I
    //   551: istore 6
    //   553: ldc 127
    //   555: new 151	java/lang/StringBuilder
    //   558: dup
    //   559: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   562: ldc_w 756
    //   565: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   568: iload 5
    //   570: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   573: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   576: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   579: ldc 127
    //   581: new 151	java/lang/StringBuilder
    //   584: dup
    //   585: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   588: ldc_w 758
    //   591: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   594: iload 6
    //   596: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   599: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   602: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   605: iload 5
    //   607: iflt +159 -> 766
    //   610: iload 5
    //   612: iconst_2
    //   613: if_icmpge +153 -> 766
    //   616: ldc 127
    //   618: ldc_w 760
    //   621: iconst_1
    //   622: invokestatic 265	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   625: iconst_1
    //   626: istore 6
    //   628: aload_1
    //   629: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   632: sipush -508
    //   635: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   638: ldc 127
    //   640: new 151	java/lang/StringBuilder
    //   643: dup
    //   644: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   647: ldc_w 762
    //   650: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   653: iload 5
    //   655: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   658: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   661: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   664: iload 5
    //   666: iconst_1
    //   667: if_icmpge +1160 -> 1827
    //   670: ldc 127
    //   672: ldc_w 764
    //   675: iconst_1
    //   676: invokestatic 265	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   679: aload_1
    //   680: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   683: sipush -509
    //   686: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   689: iload 6
    //   691: ifeq +157 -> 848
    //   694: aload_1
    //   695: invokestatic 231	com/tencent/smtt/sdk/k:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/k;
    //   698: ldc_w 766
    //   701: invokevirtual 420	com/tencent/smtt/sdk/k:c	(Ljava/lang/String;)I
    //   704: istore 4
    //   706: iload 4
    //   708: bipush 10
    //   710: if_icmple +127 -> 837
    //   713: aload_1
    //   714: invokestatic 208	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   717: sipush 201
    //   720: ldc_w 768
    //   723: invokevirtual 214	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   726: aload_0
    //   727: aload_1
    //   728: invokespecial 770	com/tencent/smtt/sdk/n:E	(Landroid/content/Context;)V
    //   731: aload_1
    //   732: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   735: sipush -510
    //   738: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   741: getstatic 43	com/tencent/smtt/sdk/n:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   744: invokevirtual 435	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   747: getstatic 45	com/tencent/smtt/sdk/n:j	Ljava/util/concurrent/locks/Lock;
    //   750: invokeinterface 436 1 0
    //   755: aload_0
    //   756: invokevirtual 438	com/tencent/smtt/sdk/n:b	()V
    //   759: return
    //   760: astore_1
    //   761: aload_1
    //   762: invokevirtual 542	java/lang/Exception:printStackTrace	()V
    //   765: return
    //   766: iload 5
    //   768: istore 4
    //   770: iload 5
    //   772: iconst_3
    //   773: if_icmpne +46 -> 819
    //   776: iload 5
    //   778: istore 4
    //   780: iload 6
    //   782: iflt +37 -> 819
    //   785: iload_3
    //   786: iload 6
    //   788: if_icmpgt +14 -> 802
    //   791: iload 5
    //   793: istore 4
    //   795: iload_3
    //   796: ldc_w 642
    //   799: if_icmpne +20 -> 819
    //   802: iconst_m1
    //   803: istore 4
    //   805: aload_0
    //   806: aload_1
    //   807: invokevirtual 450	com/tencent/smtt/sdk/n:o	(Landroid/content/Context;)V
    //   810: ldc 127
    //   812: ldc_w 772
    //   815: iconst_1
    //   816: invokestatic 265	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   819: iconst_0
    //   820: istore 6
    //   822: iload 4
    //   824: istore 5
    //   826: goto -198 -> 628
    //   829: astore_1
    //   830: aload_1
    //   831: invokevirtual 542	java/lang/Exception:printStackTrace	()V
    //   834: goto -79 -> 755
    //   837: aload_1
    //   838: invokestatic 231	com/tencent/smtt/sdk/k:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/k;
    //   841: iload 4
    //   843: iconst_1
    //   844: iadd
    //   845: invokevirtual 774	com/tencent/smtt/sdk/k:b	(I)V
    //   848: aload_2
    //   849: ifnonnull +80 -> 929
    //   852: aload_1
    //   853: invokestatic 231	com/tencent/smtt/sdk/k:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/k;
    //   856: ldc_w 776
    //   859: invokevirtual 779	com/tencent/smtt/sdk/k:d	(Ljava/lang/String;)Ljava/lang/String;
    //   862: astore 16
    //   864: aload 16
    //   866: astore 15
    //   868: aload 16
    //   870: ifnonnull +62 -> 932
    //   873: aload_1
    //   874: invokestatic 208	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   877: sipush 202
    //   880: ldc_w 781
    //   883: invokevirtual 214	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   886: aload_1
    //   887: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   890: sipush -511
    //   893: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   896: getstatic 43	com/tencent/smtt/sdk/n:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   899: invokevirtual 435	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   902: getstatic 45	com/tencent/smtt/sdk/n:j	Ljava/util/concurrent/locks/Lock;
    //   905: invokeinterface 436 1 0
    //   910: aload_0
    //   911: invokevirtual 438	com/tencent/smtt/sdk/n:b	()V
    //   914: return
    //   915: astore_1
    //   916: aload_1
    //   917: invokevirtual 542	java/lang/Exception:printStackTrace	()V
    //   920: return
    //   921: astore_1
    //   922: aload_1
    //   923: invokevirtual 542	java/lang/Exception:printStackTrace	()V
    //   926: goto -16 -> 910
    //   929: aload_2
    //   930: astore 15
    //   932: ldc 127
    //   934: new 151	java/lang/StringBuilder
    //   937: dup
    //   938: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   941: ldc_w 783
    //   944: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   947: aload 15
    //   949: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   952: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   955: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   958: aload_0
    //   959: aload_1
    //   960: aload 15
    //   962: invokevirtual 786	com/tencent/smtt/sdk/n:c	(Landroid/content/Context;Ljava/lang/String;)I
    //   965: istore 9
    //   967: iload 9
    //   969: ifne +59 -> 1028
    //   972: aload_1
    //   973: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   976: sipush -512
    //   979: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   982: aload_1
    //   983: invokestatic 208	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   986: sipush 203
    //   989: ldc_w 788
    //   992: invokevirtual 214	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   995: getstatic 43	com/tencent/smtt/sdk/n:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   998: invokevirtual 435	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1001: getstatic 45	com/tencent/smtt/sdk/n:j	Ljava/util/concurrent/locks/Lock;
    //   1004: invokeinterface 436 1 0
    //   1009: aload_0
    //   1010: invokevirtual 438	com/tencent/smtt/sdk/n:b	()V
    //   1013: return
    //   1014: astore_1
    //   1015: aload_1
    //   1016: invokevirtual 542	java/lang/Exception:printStackTrace	()V
    //   1019: return
    //   1020: astore_1
    //   1021: aload_1
    //   1022: invokevirtual 542	java/lang/Exception:printStackTrace	()V
    //   1025: goto -16 -> 1009
    //   1028: aload_1
    //   1029: invokestatic 231	com/tencent/smtt/sdk/k:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/k;
    //   1032: ldc_w 776
    //   1035: aload 15
    //   1037: invokevirtual 790	com/tencent/smtt/sdk/k:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1040: aload_1
    //   1041: invokestatic 231	com/tencent/smtt/sdk/k:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/k;
    //   1044: iload 9
    //   1046: iconst_0
    //   1047: invokevirtual 234	com/tencent/smtt/sdk/k:c	(II)V
    //   1050: aload_1
    //   1051: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1054: sipush -548
    //   1057: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1060: aload_1
    //   1061: invokestatic 478	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   1064: ifeq +70 -> 1134
    //   1067: aload_0
    //   1068: aload_1
    //   1069: new 169	java/io/File
    //   1072: dup
    //   1073: aload 15
    //   1075: invokespecial 254	java/io/File:<init>	(Ljava/lang/String;)V
    //   1078: iconst_1
    //   1079: invokespecial 654	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;Ljava/io/File;Z)Z
    //   1082: ifne +115 -> 1197
    //   1085: aload_1
    //   1086: invokestatic 208	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1089: sipush 207
    //   1092: ldc_w 792
    //   1095: getstatic 798	com/tencent/smtt/sdk/TbsLogReport$EventType:TYPE_INSTALL_DECOUPLE	Lcom/tencent/smtt/sdk/TbsLogReport$EventType;
    //   1098: invokevirtual 801	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;Lcom/tencent/smtt/sdk/TbsLogReport$EventType;)V
    //   1101: getstatic 43	com/tencent/smtt/sdk/n:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1104: invokevirtual 435	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1107: getstatic 45	com/tencent/smtt/sdk/n:j	Ljava/util/concurrent/locks/Lock;
    //   1110: invokeinterface 436 1 0
    //   1115: aload_0
    //   1116: invokevirtual 438	com/tencent/smtt/sdk/n:b	()V
    //   1119: return
    //   1120: astore_1
    //   1121: aload_1
    //   1122: invokevirtual 542	java/lang/Exception:printStackTrace	()V
    //   1125: return
    //   1126: astore_1
    //   1127: aload_1
    //   1128: invokevirtual 542	java/lang/Exception:printStackTrace	()V
    //   1131: goto -16 -> 1115
    //   1134: aload_0
    //   1135: aload_1
    //   1136: new 169	java/io/File
    //   1139: dup
    //   1140: aload 15
    //   1142: invokespecial 254	java/io/File:<init>	(Ljava/lang/String;)V
    //   1145: invokespecial 803	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;Ljava/io/File;)Z
    //   1148: ifne +49 -> 1197
    //   1151: aload_1
    //   1152: invokestatic 208	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1155: sipush 207
    //   1158: ldc_w 792
    //   1161: invokevirtual 214	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1164: getstatic 43	com/tencent/smtt/sdk/n:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1167: invokevirtual 435	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1170: getstatic 45	com/tencent/smtt/sdk/n:j	Ljava/util/concurrent/locks/Lock;
    //   1173: invokeinterface 436 1 0
    //   1178: aload_0
    //   1179: invokevirtual 438	com/tencent/smtt/sdk/n:b	()V
    //   1182: return
    //   1183: astore_1
    //   1184: aload_1
    //   1185: invokevirtual 542	java/lang/Exception:printStackTrace	()V
    //   1188: return
    //   1189: astore_1
    //   1190: aload_1
    //   1191: invokevirtual 542	java/lang/Exception:printStackTrace	()V
    //   1194: goto -16 -> 1178
    //   1197: iload 6
    //   1199: ifeq +144 -> 1343
    //   1202: aload_1
    //   1203: invokestatic 231	com/tencent/smtt/sdk/k:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/k;
    //   1206: ldc_w 805
    //   1209: invokevirtual 424	com/tencent/smtt/sdk/k:b	(Ljava/lang/String;)I
    //   1212: istore 4
    //   1214: iload 4
    //   1216: iconst_5
    //   1217: if_icmple +115 -> 1332
    //   1220: aload_1
    //   1221: invokestatic 208	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1224: sipush 223
    //   1227: ldc_w 807
    //   1230: invokevirtual 214	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1233: aload_1
    //   1234: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1237: sipush -553
    //   1240: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1243: aload_0
    //   1244: aload_1
    //   1245: invokespecial 770	com/tencent/smtt/sdk/n:E	(Landroid/content/Context;)V
    //   1248: aload_1
    //   1249: invokestatic 809	com/tencent/smtt/sdk/j:c	(Landroid/content/Context;)V
    //   1252: aload_1
    //   1253: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1256: getfield 813	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1259: ldc_w 815
    //   1262: iconst_1
    //   1263: invokestatic 820	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1266: invokeinterface 826 3 0
    //   1271: pop
    //   1272: aload_1
    //   1273: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1276: getfield 813	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1279: ldc_w 828
    //   1282: iconst_1
    //   1283: invokestatic 820	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1286: invokeinterface 826 3 0
    //   1291: pop
    //   1292: aload_1
    //   1293: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1296: invokevirtual 830	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1299: getstatic 43	com/tencent/smtt/sdk/n:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1302: invokevirtual 435	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1305: getstatic 45	com/tencent/smtt/sdk/n:j	Ljava/util/concurrent/locks/Lock;
    //   1308: invokeinterface 436 1 0
    //   1313: aload_0
    //   1314: invokevirtual 438	com/tencent/smtt/sdk/n:b	()V
    //   1317: return
    //   1318: astore_1
    //   1319: aload_1
    //   1320: invokevirtual 542	java/lang/Exception:printStackTrace	()V
    //   1323: return
    //   1324: astore_1
    //   1325: aload_1
    //   1326: invokevirtual 542	java/lang/Exception:printStackTrace	()V
    //   1329: goto -16 -> 1313
    //   1332: aload_1
    //   1333: invokestatic 231	com/tencent/smtt/sdk/k:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/k;
    //   1336: iload 4
    //   1338: iconst_1
    //   1339: iadd
    //   1340: invokevirtual 832	com/tencent/smtt/sdk/k:d	(I)V
    //   1343: ldc 127
    //   1345: ldc_w 834
    //   1348: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1351: invokestatic 837	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	()Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1354: getfield 841	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   1357: ldc_w 843
    //   1360: iconst_0
    //   1361: invokeinterface 398 3 0
    //   1366: istore 4
    //   1368: aload_0
    //   1369: aload_1
    //   1370: invokevirtual 441	com/tencent/smtt/sdk/n:i	(Landroid/content/Context;)I
    //   1373: ifeq +349 -> 1722
    //   1376: aload_1
    //   1377: ldc_w 845
    //   1380: aconst_null
    //   1381: invokestatic 848	com/tencent/smtt/sdk/QbSdk:a	(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;)Ljava/lang/Object;
    //   1384: astore 15
    //   1386: aload 15
    //   1388: ifnull +1006 -> 2394
    //   1391: aload 15
    //   1393: instanceof 817
    //   1396: ifeq +998 -> 2394
    //   1399: aload 15
    //   1401: checkcast 817	java/lang/Boolean
    //   1404: invokevirtual 851	java/lang/Boolean:booleanValue	()Z
    //   1407: istore 14
    //   1409: iload 14
    //   1411: ifeq +311 -> 1722
    //   1414: new 853	android/os/Bundle
    //   1417: dup
    //   1418: invokespecial 854	android/os/Bundle:<init>	()V
    //   1421: astore 15
    //   1423: aload 15
    //   1425: ldc_w 856
    //   1428: iload 4
    //   1430: invokevirtual 858	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1433: aload_1
    //   1434: invokestatic 478	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   1437: ifeq +89 -> 1526
    //   1440: aload 15
    //   1442: ldc_w 860
    //   1445: aload_0
    //   1446: aload_1
    //   1447: invokevirtual 491	com/tencent/smtt/sdk/n:p	(Landroid/content/Context;)Ljava/io/File;
    //   1450: invokevirtual 863	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1453: invokevirtual 866	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1456: aload_1
    //   1457: ldc_w 868
    //   1460: aload 15
    //   1462: invokestatic 848	com/tencent/smtt/sdk/QbSdk:a	(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;)Ljava/lang/Object;
    //   1465: astore 15
    //   1467: aload 15
    //   1469: ifnonnull +116 -> 1585
    //   1472: ldc 127
    //   1474: ldc_w 870
    //   1477: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1480: aload_1
    //   1481: invokestatic 208	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1484: sipush 222
    //   1487: ldc_w 872
    //   1490: invokevirtual 214	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1493: iconst_0
    //   1494: istore 4
    //   1496: iload 4
    //   1498: ifne +224 -> 1722
    //   1501: getstatic 43	com/tencent/smtt/sdk/n:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1504: invokevirtual 435	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1507: getstatic 45	com/tencent/smtt/sdk/n:j	Ljava/util/concurrent/locks/Lock;
    //   1510: invokeinterface 436 1 0
    //   1515: aload_0
    //   1516: invokevirtual 438	com/tencent/smtt/sdk/n:b	()V
    //   1519: return
    //   1520: astore_1
    //   1521: aload_1
    //   1522: invokevirtual 542	java/lang/Exception:printStackTrace	()V
    //   1525: return
    //   1526: aload 15
    //   1528: ldc_w 860
    //   1531: aload_0
    //   1532: aload_1
    //   1533: iconst_0
    //   1534: invokevirtual 149	com/tencent/smtt/sdk/n:f	(Landroid/content/Context;I)Ljava/io/File;
    //   1537: invokevirtual 863	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1540: invokevirtual 866	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1543: goto -87 -> 1456
    //   1546: astore_1
    //   1547: iload 7
    //   1549: istore_3
    //   1550: getstatic 43	com/tencent/smtt/sdk/n:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1553: invokevirtual 435	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1556: getstatic 45	com/tencent/smtt/sdk/n:j	Ljava/util/concurrent/locks/Lock;
    //   1559: invokeinterface 436 1 0
    //   1564: aload_0
    //   1565: invokevirtual 438	com/tencent/smtt/sdk/n:b	()V
    //   1568: iload_3
    //   1569: ifeq +14 -> 1583
    //   1572: getstatic 427	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   1575: sipush 232
    //   1578: invokeinterface 432 2 0
    //   1583: aload_1
    //   1584: athrow
    //   1585: aload 15
    //   1587: instanceof 817
    //   1590: ifeq +52 -> 1642
    //   1593: aload 15
    //   1595: checkcast 817	java/lang/Boolean
    //   1598: invokevirtual 851	java/lang/Boolean:booleanValue	()Z
    //   1601: ifeq +17 -> 1618
    //   1604: ldc 127
    //   1606: ldc_w 874
    //   1609: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1612: iconst_1
    //   1613: istore 4
    //   1615: goto -119 -> 1496
    //   1618: ldc 127
    //   1620: ldc_w 876
    //   1623: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1626: aload_1
    //   1627: invokestatic 208	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1630: sipush 222
    //   1633: ldc_w 876
    //   1636: invokevirtual 214	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1639: goto +775 -> 2414
    //   1642: aload 15
    //   1644: instanceof 853
    //   1647: ifeq +9 -> 1656
    //   1650: iconst_1
    //   1651: istore 4
    //   1653: goto -157 -> 1496
    //   1656: aload 15
    //   1658: instanceof 249
    //   1661: ifeq +753 -> 2414
    //   1664: ldc 127
    //   1666: new 151	java/lang/StringBuilder
    //   1669: dup
    //   1670: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   1673: ldc_w 878
    //   1676: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1679: aload 15
    //   1681: checkcast 249	java/lang/Throwable
    //   1684: invokestatic 622	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1687: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1690: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1693: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1696: aload_1
    //   1697: invokestatic 208	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1700: sipush 222
    //   1703: aload 15
    //   1705: checkcast 249	java/lang/Throwable
    //   1708: invokevirtual 691	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/Throwable;)V
    //   1711: goto +703 -> 2414
    //   1714: astore_1
    //   1715: aload_1
    //   1716: invokevirtual 542	java/lang/Exception:printStackTrace	()V
    //   1719: goto -204 -> 1515
    //   1722: ldc 127
    //   1724: ldc_w 880
    //   1727: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1730: aload_1
    //   1731: invokestatic 231	com/tencent/smtt/sdk/k:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/k;
    //   1734: iload 9
    //   1736: iconst_1
    //   1737: invokevirtual 234	com/tencent/smtt/sdk/k:c	(II)V
    //   1740: iload 9
    //   1742: istore 4
    //   1744: iload 5
    //   1746: iconst_2
    //   1747: if_icmpge +566 -> 2313
    //   1750: iload 6
    //   1752: ifeq +213 -> 1965
    //   1755: aload_1
    //   1756: invokestatic 231	com/tencent/smtt/sdk/k:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/k;
    //   1759: ldc_w 882
    //   1762: invokevirtual 420	com/tencent/smtt/sdk/k:c	(Ljava/lang/String;)I
    //   1765: istore 5
    //   1767: iload 5
    //   1769: bipush 10
    //   1771: if_icmple +183 -> 1954
    //   1774: aload_1
    //   1775: invokestatic 208	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1778: sipush 208
    //   1781: ldc_w 884
    //   1784: invokevirtual 214	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1787: aload_1
    //   1788: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1791: sipush -514
    //   1794: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1797: aload_0
    //   1798: aload_1
    //   1799: invokespecial 770	com/tencent/smtt/sdk/n:E	(Landroid/content/Context;)V
    //   1802: getstatic 43	com/tencent/smtt/sdk/n:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1805: invokevirtual 435	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1808: getstatic 45	com/tencent/smtt/sdk/n:j	Ljava/util/concurrent/locks/Lock;
    //   1811: invokeinterface 436 1 0
    //   1816: aload_0
    //   1817: invokevirtual 438	com/tencent/smtt/sdk/n:b	()V
    //   1820: return
    //   1821: astore_1
    //   1822: aload_1
    //   1823: invokevirtual 542	java/lang/Exception:printStackTrace	()V
    //   1826: return
    //   1827: aload_1
    //   1828: invokestatic 478	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   1831: ifeq +109 -> 1940
    //   1834: aload_2
    //   1835: ifnonnull +80 -> 1915
    //   1838: aload_1
    //   1839: invokestatic 231	com/tencent/smtt/sdk/k:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/k;
    //   1842: ldc_w 776
    //   1845: invokevirtual 779	com/tencent/smtt/sdk/k:d	(Ljava/lang/String;)Ljava/lang/String;
    //   1848: astore 16
    //   1850: aload 16
    //   1852: astore 15
    //   1854: aload 16
    //   1856: ifnonnull +62 -> 1918
    //   1859: aload_1
    //   1860: invokestatic 208	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1863: sipush 202
    //   1866: ldc_w 781
    //   1869: invokevirtual 214	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1872: aload_1
    //   1873: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1876: sipush -511
    //   1879: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1882: getstatic 43	com/tencent/smtt/sdk/n:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1885: invokevirtual 435	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1888: getstatic 45	com/tencent/smtt/sdk/n:j	Ljava/util/concurrent/locks/Lock;
    //   1891: invokeinterface 436 1 0
    //   1896: aload_0
    //   1897: invokevirtual 438	com/tencent/smtt/sdk/n:b	()V
    //   1900: return
    //   1901: astore_1
    //   1902: aload_1
    //   1903: invokevirtual 542	java/lang/Exception:printStackTrace	()V
    //   1906: return
    //   1907: astore_1
    //   1908: aload_1
    //   1909: invokevirtual 542	java/lang/Exception:printStackTrace	()V
    //   1912: goto -16 -> 1896
    //   1915: aload_2
    //   1916: astore 15
    //   1918: aload_0
    //   1919: aload_1
    //   1920: new 169	java/io/File
    //   1923: dup
    //   1924: aload 15
    //   1926: invokespecial 254	java/io/File:<init>	(Ljava/lang/String;)V
    //   1929: iconst_1
    //   1930: invokespecial 654	com/tencent/smtt/sdk/n:a	(Landroid/content/Context;Ljava/io/File;Z)Z
    //   1933: istore 14
    //   1935: iload 14
    //   1937: ifne +3 -> 1940
    //   1940: iconst_0
    //   1941: istore 4
    //   1943: goto -199 -> 1744
    //   1946: astore_1
    //   1947: aload_1
    //   1948: invokevirtual 542	java/lang/Exception:printStackTrace	()V
    //   1951: goto -135 -> 1816
    //   1954: aload_1
    //   1955: invokestatic 231	com/tencent/smtt/sdk/k:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/k;
    //   1958: iload 5
    //   1960: iconst_1
    //   1961: iadd
    //   1962: invokevirtual 886	com/tencent/smtt/sdk/k:a	(I)V
    //   1965: aload_1
    //   1966: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1969: sipush -549
    //   1972: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1975: aload_0
    //   1976: aload_1
    //   1977: iconst_0
    //   1978: invokespecial 889	com/tencent/smtt/sdk/n:j	(Landroid/content/Context;I)Z
    //   1981: ifne +46 -> 2027
    //   1984: aload_1
    //   1985: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1988: sipush -515
    //   1991: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1994: getstatic 43	com/tencent/smtt/sdk/n:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   1997: invokevirtual 435	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   2000: getstatic 45	com/tencent/smtt/sdk/n:j	Ljava/util/concurrent/locks/Lock;
    //   2003: invokeinterface 436 1 0
    //   2008: aload_0
    //   2009: invokevirtual 438	com/tencent/smtt/sdk/n:b	()V
    //   2012: return
    //   2013: astore_1
    //   2014: aload_1
    //   2015: invokevirtual 542	java/lang/Exception:printStackTrace	()V
    //   2018: return
    //   2019: astore_1
    //   2020: aload_1
    //   2021: invokevirtual 542	java/lang/Exception:printStackTrace	()V
    //   2024: goto -16 -> 2008
    //   2027: aload_1
    //   2028: invokestatic 231	com/tencent/smtt/sdk/k:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/k;
    //   2031: iload 4
    //   2033: iconst_2
    //   2034: invokevirtual 234	com/tencent/smtt/sdk/k:c	(II)V
    //   2037: ldc 127
    //   2039: ldc_w 891
    //   2042: iconst_1
    //   2043: invokestatic 265	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   2046: ldc 127
    //   2048: new 151	java/lang/StringBuilder
    //   2051: dup
    //   2052: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   2055: ldc_w 893
    //   2058: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2061: iload_3
    //   2062: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2065: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2068: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2071: aload_1
    //   2072: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2075: sipush -516
    //   2078: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   2081: getstatic 384	android/os/Build$VERSION:SDK_INT	I
    //   2084: bipush 11
    //   2086: if_icmplt +149 -> 2235
    //   2089: aload_1
    //   2090: ldc_w 386
    //   2093: iconst_4
    //   2094: invokevirtual 390	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   2097: astore 15
    //   2099: aload 15
    //   2101: invokeinterface 592 1 0
    //   2106: astore 15
    //   2108: aload 15
    //   2110: ldc_w 594
    //   2113: iconst_0
    //   2114: invokeinterface 600 3 0
    //   2119: pop
    //   2120: aload 15
    //   2122: ldc_w 602
    //   2125: iconst_0
    //   2126: invokeinterface 600 3 0
    //   2131: pop
    //   2132: aload 15
    //   2134: ldc_w 604
    //   2137: iload_3
    //   2138: invokeinterface 600 3 0
    //   2143: pop
    //   2144: aload 15
    //   2146: invokeinterface 607 1 0
    //   2151: pop
    //   2152: aload_1
    //   2153: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2156: sipush -517
    //   2159: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   2162: iload_3
    //   2163: ldc_w 642
    //   2166: if_icmpne +10 -> 2176
    //   2169: aload_0
    //   2170: iload_3
    //   2171: aload_2
    //   2172: aload_1
    //   2173: invokespecial 895	com/tencent/smtt/sdk/n:a	(ILjava/lang/String;Landroid/content/Context;)V
    //   2176: aload_0
    //   2177: getfield 109	com/tencent/smtt/sdk/n:k	Z
    //   2180: ifeq +112 -> 2292
    //   2183: aload_1
    //   2184: invokestatic 208	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   2187: aload_0
    //   2188: aload_1
    //   2189: invokespecial 898	com/tencent/smtt/sdk/n:u	(Landroid/content/Context;)I
    //   2192: ldc_w 586
    //   2195: invokevirtual 214	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   2198: iload 8
    //   2200: istore_3
    //   2201: getstatic 43	com/tencent/smtt/sdk/n:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   2204: invokevirtual 435	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   2207: getstatic 45	com/tencent/smtt/sdk/n:j	Ljava/util/concurrent/locks/Lock;
    //   2210: invokeinterface 436 1 0
    //   2215: aload_0
    //   2216: invokevirtual 438	com/tencent/smtt/sdk/n:b	()V
    //   2219: iload_3
    //   2220: ifeq -2177 -> 43
    //   2223: getstatic 427	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   2226: sipush 232
    //   2229: invokeinterface 432 2 0
    //   2234: return
    //   2235: aload_1
    //   2236: ldc_w 386
    //   2239: iconst_0
    //   2240: invokevirtual 390	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   2243: astore 15
    //   2245: goto -146 -> 2099
    //   2248: astore 15
    //   2250: ldc 127
    //   2252: new 151	java/lang/StringBuilder
    //   2255: dup
    //   2256: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   2259: ldc_w 900
    //   2262: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2265: aload 15
    //   2267: invokestatic 622	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2270: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2273: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2276: invokestatic 346	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2279: aload_1
    //   2280: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2283: sipush -518
    //   2286: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   2289: goto -127 -> 2162
    //   2292: aload_1
    //   2293: invokestatic 208	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   2296: aload_0
    //   2297: aload_1
    //   2298: invokespecial 898	com/tencent/smtt/sdk/n:u	(Landroid/content/Context;)I
    //   2301: ldc_w 614
    //   2304: invokevirtual 214	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   2307: iload 8
    //   2309: istore_3
    //   2310: goto -109 -> 2201
    //   2313: iload 5
    //   2315: iconst_2
    //   2316: if_icmpne +73 -> 2389
    //   2319: getstatic 427	com/tencent/smtt/sdk/QbSdk:m	Lcom/tencent/smtt/sdk/TbsListener;
    //   2322: sipush 200
    //   2325: invokeinterface 432 2 0
    //   2330: iload 8
    //   2332: istore_3
    //   2333: goto -132 -> 2201
    //   2336: astore_1
    //   2337: iconst_1
    //   2338: istore_3
    //   2339: goto -789 -> 1550
    //   2342: astore_1
    //   2343: aload_1
    //   2344: invokevirtual 542	java/lang/Exception:printStackTrace	()V
    //   2347: goto -132 -> 2215
    //   2350: astore_1
    //   2351: aload_1
    //   2352: invokevirtual 542	java/lang/Exception:printStackTrace	()V
    //   2355: goto -136 -> 2219
    //   2358: astore_2
    //   2359: aload_2
    //   2360: invokevirtual 542	java/lang/Exception:printStackTrace	()V
    //   2363: goto -799 -> 1564
    //   2366: astore_2
    //   2367: aload_2
    //   2368: invokevirtual 542	java/lang/Exception:printStackTrace	()V
    //   2371: goto -803 -> 1568
    //   2374: aload_1
    //   2375: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2378: sipush -519
    //   2381: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   2384: aload_0
    //   2385: invokevirtual 438	com/tencent/smtt/sdk/n:b	()V
    //   2388: return
    //   2389: iconst_0
    //   2390: istore_3
    //   2391: goto -190 -> 2201
    //   2394: iconst_0
    //   2395: istore 14
    //   2397: goto -988 -> 1409
    //   2400: iload 4
    //   2402: ifle -1865 -> 537
    //   2405: iload_3
    //   2406: iload 4
    //   2408: if_icmple -1871 -> 537
    //   2411: goto -1879 -> 532
    //   2414: iconst_0
    //   2415: istore 4
    //   2417: goto -921 -> 1496
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2420	0	this	n
    //   0	2420	1	paramContext	Context
    //   0	2420	2	paramString	String
    //   0	2420	3	paramInt	int
    //   430	1986	4	i1	int
    //   439	1878	5	i2	int
    //   551	1200	6	i3	int
    //   1	1547	7	i4	int
    //   4	2327	8	i5	int
    //   965	776	9	i6	int
    //   280	42	10	l1	long
    //   289	44	12	l2	long
    //   371	2025	14	bool	boolean
    //   198	2046	15	localObject	Object
    //   2248	18	15	localThrowable	Throwable
    //   862	993	16	str	String
    // Exception table:
    //   from	to	target	type
    //   755	759	760	java/lang/Exception
    //   741	755	829	java/lang/Exception
    //   910	914	915	java/lang/Exception
    //   896	910	921	java/lang/Exception
    //   1009	1013	1014	java/lang/Exception
    //   995	1009	1020	java/lang/Exception
    //   1115	1119	1120	java/lang/Exception
    //   1101	1115	1126	java/lang/Exception
    //   1178	1182	1183	java/lang/Exception
    //   1164	1178	1189	java/lang/Exception
    //   1313	1317	1318	java/lang/Exception
    //   1299	1313	1324	java/lang/Exception
    //   1515	1519	1520	java/lang/Exception
    //   420	518	1546	finally
    //   532	537	1546	finally
    //   537	605	1546	finally
    //   616	625	1546	finally
    //   628	664	1546	finally
    //   670	689	1546	finally
    //   694	706	1546	finally
    //   713	741	1546	finally
    //   805	819	1546	finally
    //   837	848	1546	finally
    //   852	864	1546	finally
    //   873	896	1546	finally
    //   932	967	1546	finally
    //   972	995	1546	finally
    //   1028	1101	1546	finally
    //   1134	1164	1546	finally
    //   1202	1214	1546	finally
    //   1220	1299	1546	finally
    //   1332	1343	1546	finally
    //   1343	1386	1546	finally
    //   1391	1409	1546	finally
    //   1414	1456	1546	finally
    //   1456	1467	1546	finally
    //   1472	1493	1546	finally
    //   1526	1543	1546	finally
    //   1585	1612	1546	finally
    //   1618	1639	1546	finally
    //   1642	1650	1546	finally
    //   1656	1711	1546	finally
    //   1722	1740	1546	finally
    //   1755	1767	1546	finally
    //   1774	1802	1546	finally
    //   1827	1834	1546	finally
    //   1838	1850	1546	finally
    //   1859	1882	1546	finally
    //   1918	1935	1546	finally
    //   1954	1965	1546	finally
    //   1965	1994	1546	finally
    //   2027	2099	1546	finally
    //   2099	2162	1546	finally
    //   2169	2176	1546	finally
    //   2176	2198	1546	finally
    //   2235	2245	1546	finally
    //   2250	2289	1546	finally
    //   2292	2307	1546	finally
    //   1501	1515	1714	java/lang/Exception
    //   1816	1820	1821	java/lang/Exception
    //   1896	1900	1901	java/lang/Exception
    //   1882	1896	1907	java/lang/Exception
    //   1802	1816	1946	java/lang/Exception
    //   2008	2012	2013	java/lang/Exception
    //   1994	2008	2019	java/lang/Exception
    //   2099	2162	2248	java/lang/Throwable
    //   2319	2330	2336	finally
    //   2201	2215	2342	java/lang/Exception
    //   2215	2219	2350	java/lang/Exception
    //   1550	1564	2358	java/lang/Exception
    //   1564	1568	2366	java/lang/Exception
  }
  
  /* Error */
  private boolean b(Context paramContext, File paramFile)
  {
    // Byte code:
    //   0: aload_2
    //   1: new 902	com/tencent/smtt/sdk/n$6
    //   4: dup
    //   5: aload_0
    //   6: invokespecial 905	com/tencent/smtt/sdk/n$6:<init>	(Lcom/tencent/smtt/sdk/n;)V
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
    //   68: if_icmpge +63 -> 131
    //   71: ldc 127
    //   73: new 151	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   80: ldc_w 928
    //   83: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: aload 6
    //   88: iload_3
    //   89: aaload
    //   90: invokevirtual 863	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   93: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   102: new 930	dalvik/system/DexClassLoader
    //   105: dup
    //   106: aload 6
    //   108: iload_3
    //   109: aaload
    //   110: invokevirtual 863	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   113: aload_2
    //   114: invokevirtual 863	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   117: aconst_null
    //   118: aload 7
    //   120: invokespecial 933	dalvik/system/DexClassLoader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   123: pop
    //   124: iload_3
    //   125: iconst_1
    //   126: iadd
    //   127: istore_3
    //   128: goto -63 -> 65
    //   131: iconst_1
    //   132: ireturn
    //   133: astore_2
    //   134: aload_2
    //   135: invokevirtual 542	java/lang/Exception:printStackTrace	()V
    //   138: aload_1
    //   139: invokestatic 208	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   142: sipush 209
    //   145: aload_2
    //   146: invokevirtual 543	java/lang/Exception:toString	()Ljava/lang/String;
    //   149: invokevirtual 214	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   152: ldc 127
    //   154: ldc_w 935
    //   157: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   160: iconst_0
    //   161: ireturn
    //   162: astore 7
    //   164: goto -107 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	167	0	this	n
    //   0	167	1	paramContext	Context
    //   0	167	2	paramFile	File
    //   64	64	3	i1	int
    //   17	52	4	i2	int
    //   44	3	5	bool	boolean
    //   12	95	6	arrayOfFile	File[]
    //   61	58	7	localClassLoader	ClassLoader
    //   162	1	7	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   0	46	133	java/lang/Exception
    //   57	63	133	java/lang/Exception
    //   71	124	133	java/lang/Exception
    //   51	57	162	java/lang/Exception
  }
  
  private int c(Context paramContext, Bundle paramBundle)
  {
    int i1;
    try
    {
      Object localObject = QbSdk.a(paramContext, paramBundle);
      TbsLog.i("TbsInstaller", "tpatch finished,ret is" + localObject);
      i1 = ((Bundle)localObject).getInt("patch_result");
      if (i1 == 0)
      {
        localObject = paramBundle.getString("new_apk_location");
        i1 = paramBundle.getInt("new_core_ver");
        int i2 = a(new File((String)localObject));
        if (i1 != i2)
        {
          TbsLog.i("TbsInstaller", "version not equals!!!" + i1 + "patchVersion:" + i2);
          TbsLogReport.getInstance(paramContext).setInstallErrorCode(240, "version=" + i1 + ",patchVersion=" + i2);
          return 1;
        }
        paramBundle = new File(paramBundle.getString("backup_apk"));
        localObject = b.a(paramContext, true, paramBundle);
        if (!"3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a".equals(localObject))
        {
          TbsLog.i("TbsInstaller", "tpatch sig not equals!!!" + paramBundle + "signature:" + (String)localObject);
          TbsLogReport.getInstance(paramContext).setInstallErrorCode(241, "version=" + i1 + ",patchVersion=" + i2);
          FileUtil.b(paramBundle);
          return 0;
        }
      }
    }
    catch (Exception paramBundle)
    {
      paramBundle.printStackTrace();
      TbsLogReport.getInstance(paramContext).setInstallErrorCode(239, "patch exception" + Log.getStackTraceString(paramBundle));
    }
    for (;;)
    {
      return 1;
      if (TbsDownloader.a(paramContext))
      {
        TbsLog.i("TbsInstaller", "Tpatch decouple success!");
        TbsLogReport.getInstance(paramContext).setInstallErrorCode(237, "");
        return 0;
      }
      TbsLog.i("TbsInstaller", "Tpatch success!");
      TbsLogReport.getInstance(paramContext).setInstallErrorCode(236, "");
      return 0;
      paramBundle = paramBundle.getString("new_apk_location");
      if (!TextUtils.isEmpty(paramBundle)) {
        FileUtil.b(new File(paramBundle));
      }
      TbsLogReport.getInstance(paramContext).setInstallErrorCode(i1, "tpatch fail,patch error_code=" + i1);
    }
  }
  
  private boolean c(Context paramContext, File paramFile)
  {
    try
    {
      Object localObject1 = new File(paramFile, "tbs_sdk_extension_dex.jar");
      Object localObject2 = new File(paramFile, "tbs_sdk_extension_dex.dex");
      Object localObject3 = paramContext.getClassLoader();
      new DexClassLoader(((File)localObject1).getAbsolutePath(), paramFile.getAbsolutePath(), null, (ClassLoader)localObject3);
      localObject1 = c.a(paramContext, ((File)localObject2).getAbsolutePath());
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        TbsLogReport.getInstance(paramContext).setInstallErrorCode(226, "can not find oat command");
        return false;
      }
      paramFile = paramFile.listFiles(new n.7(this));
      int i2 = paramFile.length;
      int i1 = 0;
      while (i1 < i2)
      {
        localObject2 = paramFile[i1];
        localObject2 = ((File)localObject2).getName().substring(0, ((File)localObject2).getName().length() - 4);
        localObject3 = ((String)localObject1).replaceAll("tbs_sdk_extension_dex", (String)localObject2);
        localObject2 = "/system/bin/dex2oat " + (String)localObject3 + " --dex-location=" + a().q(paramContext) + File.separator + (String)localObject2 + ".jar";
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
    boolean bool1 = false;
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool3 = true;
    label47:
    try
    {
      TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromTpatch");
      bool2 = bool4;
      try
      {
        boolean bool6 = t(paramContext);
        if (bool6) {
          break label47;
        }
        bool1 = bool5;
      }
      catch (Throwable localThrowable1)
      {
        for (;;)
        {
          try
          {
            i1 = k.a(paramContext).b("tpatch_status");
            i2 = a(false, paramContext);
            TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromTpatch copyStatus =" + i1);
            TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromTpatch tbsCoreInstalledVer =" + i2);
            if (i1 != 1) {
              break label319;
            }
            if (i2 == 0)
            {
              TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromTpatch tbsCoreInstalledVer = 0", true);
              y(paramContext);
              paramBoolean = bool3;
            }
          }
          finally
          {
            bool2 = bool4;
            i.unlock();
            bool2 = bool4;
          }
          try
          {
            i.unlock();
            bool1 = paramBoolean;
            bool2 = bool1;
            b();
          }
          catch (Throwable localThrowable2)
          {
            bool1 = paramBoolean;
            continue;
          }
          localThrowable1 = localThrowable1;
          bool1 = bool2;
          TbsLogReport.getInstance(paramContext).setInstallErrorCode(215, localThrowable1.toString());
          QbSdk.a(paramContext, "TbsInstaller::enableTbsCoreFromTpatch exception:" + Log.getStackTraceString(localThrowable1));
        }
      }
      return bool1;
    }
    finally {}
    boolean bool2 = bool4;
    bool5 = i.tryLock();
    bool2 = bool4;
    TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromTpatch Locked =" + bool5);
    if (bool5) {}
    for (;;)
    {
      int i1;
      int i2;
      if (paramBoolean)
      {
        TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromTpatch tbsCoreInstalledVer != 0", true);
        y(paramContext);
        paramBoolean = bool3;
      }
      else
      {
        label319:
        paramBoolean = false;
      }
    }
  }
  
  /* Error */
  private boolean d(Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: iconst_0
    //   4: istore 8
    //   6: iconst_0
    //   7: istore 9
    //   9: iconst_1
    //   10: istore 7
    //   12: aload_0
    //   13: monitorenter
    //   14: ldc 127
    //   16: ldc_w 1069
    //   19: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: iload 8
    //   24: istore 6
    //   26: aload_0
    //   27: aload_1
    //   28: invokevirtual 405	com/tencent/smtt/sdk/n:t	(Landroid/content/Context;)Z
    //   31: istore 10
    //   33: iload 10
    //   35: ifne +12 -> 47
    //   38: iload 9
    //   40: istore 5
    //   42: aload_0
    //   43: monitorexit
    //   44: iload 5
    //   46: ireturn
    //   47: iload 8
    //   49: istore 6
    //   51: getstatic 43	com/tencent/smtt/sdk/n:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   54: invokevirtual 1046	java/util/concurrent/locks/ReentrantLock:tryLock	()Z
    //   57: istore 9
    //   59: iload 8
    //   61: istore 6
    //   63: ldc 127
    //   65: new 151	java/lang/StringBuilder
    //   68: dup
    //   69: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   72: ldc_w 1071
    //   75: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: iload 9
    //   80: invokevirtual 178	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   83: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: iload 9
    //   91: ifeq +109 -> 200
    //   94: aload_1
    //   95: invokestatic 231	com/tencent/smtt/sdk/k:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/k;
    //   98: ldc_w 422
    //   101: invokevirtual 424	com/tencent/smtt/sdk/k:b	(Ljava/lang/String;)I
    //   104: istore_3
    //   105: aload_0
    //   106: iconst_0
    //   107: aload_1
    //   108: invokevirtual 1053	com/tencent/smtt/sdk/n:a	(ZLandroid/content/Context;)I
    //   111: istore 4
    //   113: ldc 127
    //   115: new 151	java/lang/StringBuilder
    //   118: dup
    //   119: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   122: ldc_w 1073
    //   125: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: iload_3
    //   129: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   132: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   138: ldc 127
    //   140: new 151	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   147: ldc_w 1075
    //   150: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: iload 4
    //   155: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   158: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   164: iload_3
    //   165: iconst_1
    //   166: if_icmpne +156 -> 322
    //   169: iload 4
    //   171: ifne +100 -> 271
    //   174: ldc 127
    //   176: ldc_w 1077
    //   179: iconst_1
    //   180: invokestatic 265	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   183: aload_0
    //   184: aload_1
    //   185: invokespecial 1080	com/tencent/smtt/sdk/n:z	(Landroid/content/Context;)V
    //   188: iload 7
    //   190: istore_2
    //   191: getstatic 43	com/tencent/smtt/sdk/n:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   194: invokevirtual 435	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   197: iload_2
    //   198: istore 5
    //   200: iload 5
    //   202: istore 6
    //   204: aload_0
    //   205: invokevirtual 438	com/tencent/smtt/sdk/n:b	()V
    //   208: goto -166 -> 42
    //   211: astore 11
    //   213: iload 6
    //   215: istore 5
    //   217: aload_1
    //   218: invokestatic 208	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   221: sipush 215
    //   224: aload 11
    //   226: invokevirtual 1063	java/lang/Throwable:toString	()Ljava/lang/String;
    //   229: invokevirtual 214	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   232: aload_1
    //   233: new 151	java/lang/StringBuilder
    //   236: dup
    //   237: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   240: ldc_w 1082
    //   243: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: aload 11
    //   248: invokestatic 622	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   251: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   257: invokestatic 244	com/tencent/smtt/sdk/QbSdk:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   260: goto -218 -> 42
    //   263: astore_1
    //   264: aload_1
    //   265: athrow
    //   266: astore_1
    //   267: aload_0
    //   268: monitorexit
    //   269: aload_1
    //   270: athrow
    //   271: iload_2
    //   272: ifeq +50 -> 322
    //   275: ldc 127
    //   277: ldc_w 1084
    //   280: iconst_1
    //   281: invokestatic 265	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   284: aload_0
    //   285: aload_1
    //   286: invokespecial 1080	com/tencent/smtt/sdk/n:z	(Landroid/content/Context;)V
    //   289: iload 7
    //   291: istore_2
    //   292: goto -101 -> 191
    //   295: astore 11
    //   297: iload 8
    //   299: istore 6
    //   301: getstatic 43	com/tencent/smtt/sdk/n:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   304: invokevirtual 435	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   307: iload 8
    //   309: istore 6
    //   311: aload 11
    //   313: athrow
    //   314: astore 11
    //   316: iload_2
    //   317: istore 5
    //   319: goto -102 -> 217
    //   322: iconst_0
    //   323: istore_2
    //   324: goto -133 -> 191
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	327	0	this	n
    //   0	327	1	paramContext	Context
    //   0	327	2	paramBoolean	boolean
    //   104	63	3	i1	int
    //   111	59	4	i2	int
    //   1	317	5	bool1	boolean
    //   24	286	6	bool2	boolean
    //   10	280	7	bool3	boolean
    //   4	304	8	bool4	boolean
    //   7	83	9	bool5	boolean
    //   31	3	10	bool6	boolean
    //   211	36	11	localThrowable1	Throwable
    //   295	17	11	localObject	Object
    //   314	1	11	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   26	33	211	java/lang/Throwable
    //   51	59	211	java/lang/Throwable
    //   63	89	211	java/lang/Throwable
    //   204	208	211	java/lang/Throwable
    //   301	307	211	java/lang/Throwable
    //   311	314	211	java/lang/Throwable
    //   26	33	263	finally
    //   51	59	263	finally
    //   63	89	263	finally
    //   191	197	263	finally
    //   204	208	263	finally
    //   217	260	263	finally
    //   301	307	263	finally
    //   311	314	263	finally
    //   14	22	266	finally
    //   264	266	266	finally
    //   94	164	295	finally
    //   174	188	295	finally
    //   275	289	295	finally
    //   191	197	314	java/lang/Throwable
  }
  
  private boolean e(Context paramContext, String paramString)
  {
    boolean bool = false;
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0);
      if (paramContext != null) {
        bool = true;
      }
      return bool;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext = null;
      }
    }
  }
  
  private boolean e(Context paramContext, boolean paramBoolean)
  {
    boolean bool3 = true;
    boolean bool1 = false;
    boolean bool4 = false;
    boolean bool5 = false;
    if (paramContext != null) {}
    label106:
    try
    {
      if ("com.tencent.mm".equals(paramContext.getApplicationContext().getApplicationInfo().packageName)) {
        TbsLogReport.getInstance(paramContext).setInstallErrorCode(229, " ");
      }
      TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip canRenameTmpDir =" + paramBoolean);
      TbsLog.i("TbsInstaller", "Tbsinstaller enableTbsCoreFromUnzip #1 ");
      bool2 = bool4;
      try
      {
        boolean bool6 = t(paramContext);
        if (bool6) {
          break label106;
        }
        bool1 = bool5;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          try
          {
            i1 = k.a(paramContext).c();
            TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip installStatus=" + i1);
            i2 = a(false, paramContext);
            if (i1 != 2) {
              break label356;
            }
            TbsLog.i("TbsInstaller", "Tbsinstaller enableTbsCoreFromUnzip #4 ");
            if (i2 == 0)
            {
              TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip tbsCoreInstalledVer = 0", false);
              x(paramContext);
              paramBoolean = bool3;
            }
          }
          finally
          {
            bool2 = bool4;
            i.unlock();
            bool2 = bool4;
          }
          try
          {
            i.unlock();
            bool1 = paramBoolean;
            bool2 = bool1;
            b();
          }
          catch (Exception localException2)
          {
            bool1 = paramBoolean;
            continue;
          }
          localException1 = localException1;
          bool1 = bool2;
          QbSdk.a(paramContext, "TbsInstaller::enableTbsCoreFromUnzip Exception: " + localException1);
          localException1.printStackTrace();
        }
      }
      return bool1;
    }
    finally {}
    boolean bool2 = bool4;
    TbsLog.i("TbsInstaller", "Tbsinstaller enableTbsCoreFromUnzip #2 ");
    bool2 = bool4;
    bool5 = i.tryLock();
    bool2 = bool4;
    TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip locked=" + bool5);
    if (bool5) {}
    for (;;)
    {
      int i1;
      int i2;
      if (paramBoolean)
      {
        TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip tbsCoreInstalledVer != 0", false);
        x(paramContext);
        paramBoolean = bool3;
      }
      else
      {
        label356:
        paramBoolean = false;
      }
    }
  }
  
  private boolean f(Context paramContext, boolean paramBoolean)
  {
    return false;
  }
  
  private void g(Context paramContext, boolean paramBoolean)
  {
    if (paramContext == null) {
      TbsLogReport.getInstance(paramContext).setInstallErrorCode(225, "setTmpFolderCoreToRead context is null");
    }
    for (;;)
    {
      return;
      try
      {
        File localFile = new File(QbSdk.getTbsFolderDir(paramContext), "tmp_folder_core_to_read.conf");
        if (paramBoolean)
        {
          if ((localFile != null) && (localFile.exists())) {
            continue;
          }
          localFile.createNewFile();
        }
      }
      catch (Exception localException)
      {
        TbsLogReport.getInstance(paramContext).setInstallErrorCode(225, "setTmpFolderCoreToRead Exception message is " + localException.getMessage() + " Exception cause is " + localException.getCause());
        return;
      }
    }
    FileUtil.b(localException);
  }
  
  private void h(Context paramContext, int paramInt)
  {
    TbsLog.i("TbsInstaller", "proceedTpatchStatus,result=" + paramInt);
    switch (paramInt)
    {
    }
    for (;;)
    {
      QbSdk.setTBSInstallingStatus(false);
      return;
      if (TbsDownloader.a(paramContext))
      {
        i(paramContext, 6);
      }
      else
      {
        g(paramContext, true);
        paramInt = TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_download_version", 0);
        k.a(paramContext).b(paramInt, 1);
      }
    }
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
    boolean bool = true;
    int i3 = 0;
    TbsLog.i("TbsInstaller", "TbsInstaller-doTbsDexOpt start - dirMode: " + paramInt);
    switch (paramInt)
    {
    default: 
    case 0: 
      try
      {
        TbsLog.e("TbsInstaller", "doDexoptOrDexoat mode error: " + paramInt);
        return false;
      }
      catch (Exception localException)
      {
        File localFile1;
        String str;
        localException.printStackTrace();
        TbsLogReport.getInstance(paramContext).setInstallErrorCode(209, localException.toString());
        TbsLog.i("TbsInstaller", "TbsInstaller-doTbsDexOpt done");
        return true;
      }
      if (TbsDownloader.a(paramContext)) {
        break label317;
      }
      localFile1 = f(paramContext, 0);
    }
    try
    {
      str = System.getProperty("java.vm.version");
      if (str == null) {
        break label320;
      }
      bool = str.startsWith("2");
      if (!bool) {
        break label320;
      }
      paramInt = 1;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        label132:
        TbsLogReport.getInstance(paramContext).setInstallErrorCode(226, localThrowable);
        paramInt = 0;
        continue;
        if (paramInt == 0) {
          break;
        }
        TbsLog.i("TbsInstaller", "doTbsDexOpt -- is ART mode, skip!");
      }
      TbsLog.i("TbsInstaller", "doTbsDexOpt -- doDexoptForDavlikVM");
      bool = b(paramContext, localFile2);
    }
    if (Build.VERSION.SDK_INT == 23) {}
    for (int i1 = 1;; i1 = 0)
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
      File localFile2;
      if ((i2 != 0) && (c(paramContext, localFile1)))
      {
        TbsLog.i("TbsInstaller", "doTbsDexOpt -- doDexoatForArtVm");
        return true;
        localFile2 = f(paramContext, 1);
        break;
        localFile2 = q(paramContext);
        break;
      }
      label317:
      return bool;
      label320:
      paramInt = 0;
      break label132;
    }
  }
  
  static File s(Context paramContext)
  {
    paramContext = new File(QbSdk.getTbsFolderDir(paramContext), "core_private");
    if ((paramContext == null) || ((!paramContext.isDirectory()) && (!paramContext.mkdir()))) {
      return null;
    }
    return paramContext;
  }
  
  private int u(Context paramContext)
  {
    int i1 = 1;
    if (k.a(paramContext).d() == 1) {}
    boolean bool;
    for (;;)
    {
      bool = TbsDownloader.a(paramContext);
      if (i1 == 0) {
        break label39;
      }
      if (!bool) {
        break;
      }
      return 234;
      i1 = 0;
    }
    return 221;
    label39:
    if (bool) {
      return 233;
    }
    return 200;
  }
  
  private static boolean v(Context paramContext)
  {
    if (paramContext == null)
    {
      TbsLog.i("TbsInstaller", "TbsInstaller-getTmpFolderCoreToRead, #1");
      return true;
    }
    try
    {
      if (new File(QbSdk.getTbsFolderDir(paramContext), "tmp_folder_core_to_read.conf").exists())
      {
        TbsLog.i("TbsInstaller", "TbsInstaller-getTmpFolderCoreToRead, #2");
        return true;
      }
    }
    catch (Exception paramContext)
    {
      TbsLog.i("TbsInstaller", "TbsInstaller-getTmpFolderCoreToRead, #4");
      return true;
    }
    TbsLog.i("TbsInstaller", "TbsInstaller-getTmpFolderCoreToRead, #3");
    return false;
  }
  
  private boolean w(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "Tbsinstaller getTbsCoreRenameFileLock #1 ");
    try
    {
      bool = TbsDownloadConfig.getInstance().getTbsCoreLoadRenameFileLockEnable();
      TbsLog.i("TbsInstaller", "Tbsinstaller getTbsCoreRenameFileLock #2  enabled is " + bool);
      if (!bool)
      {
        l = v.a().a(paramContext);
        if (l != null) {
          break label86;
        }
        TbsLog.i("TbsInstaller", "getTbsCoreRenameFileLock## failed!");
        return false;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        boolean bool = true;
        continue;
        l = FileUtil.f(paramContext);
      }
      label86:
      TbsLog.i("TbsInstaller", "Tbsinstaller getTbsCoreRenameFileLock true ");
    }
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
    for (;;)
    {
      try
      {
        A(paramContext);
        B(paramContext);
        TbsLog.i("TbsInstaller", "after renameTbsCoreShareDir");
        if (TbsShareManager.isThirdPartyApp(paramContext)) {
          continue;
        }
        TbsLog.i("TbsInstaller", "prepare to shareTbsCore");
        TbsShareManager.a(paramContext);
        k.a(paramContext).a(0);
        k.a(paramContext).b(0);
        k.a(paramContext).d(0);
        k.a(paramContext).a("incrupdate_retry_num", 0);
        k.a(paramContext).c(0, 3);
        k.a(paramContext).a("");
        k.a(paramContext).a("tpatch_num", 0);
        k.a(paramContext).c(-1);
        if (!TbsShareManager.isThirdPartyApp(paramContext))
        {
          i1 = TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_decouplecoreversion", 0);
          if ((i1 <= 0) || (i1 == a().h(paramContext)) || (i1 != a().i(paramContext))) {
            continue;
          }
          n(paramContext);
        }
      }
      catch (Throwable localThrowable)
      {
        int i1;
        localThrowable.printStackTrace();
        TbsLogReport.getInstance(paramContext).setInstallErrorCode(219, "exception when renameing from unzip:" + localThrowable.toString());
        TbsLog.e("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip Exception", true);
        continue;
        TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip #1 deCoupleCoreVersion is " + i1 + " getTbsCoreShareDecoupleCoreVersion is " + a().h(paramContext) + " getTbsCoreInstalledVerInNolock is " + a().i(paramContext));
        continue;
      }
      if (TbsShareManager.isThirdPartyApp(paramContext)) {
        TbsShareManager.writeCoreInfoForThirdPartyApp(paramContext, m(paramContext), true);
      }
      a.set(Integer.valueOf(0));
      o = 0;
      g(paramContext);
      return;
      TbsLog.i("TbsInstaller", "is thirdapp and not chmod");
    }
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
      k.a(paramContext).b(0, -1);
      k.a(paramContext).a("tpatch_num", 0);
      a.set(Integer.valueOf(0));
      g(paramContext);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        TbsLogReport.getInstance(paramContext).setInstallErrorCode(242, "exception when renameing from tpatch:" + localException.toString());
      }
    }
  }
  
  private void z(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromCopy");
    if (!w(paramContext))
    {
      TbsLog.i("TbsInstaller", "get rename fileLock#4 ## failed!");
      return;
    }
    for (;;)
    {
      try
      {
        A(paramContext);
        C(paramContext);
        TbsShareManager.a(paramContext);
        k.a(paramContext).a(0, 3);
        k.a(paramContext).a("tpatch_num", 0);
        if (!TbsShareManager.isThirdPartyApp(paramContext))
        {
          i1 = TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_decouplecoreversion", 0);
          if ((i1 <= 0) || (i1 == a().h(paramContext)) || (i1 != a().i(paramContext))) {
            continue;
          }
          n(paramContext);
        }
        a.set(Integer.valueOf(0));
      }
      catch (Exception localException)
      {
        int i1;
        localException.printStackTrace();
        TbsLogReport.getInstance(paramContext).setInstallErrorCode(219, "exception when renameing from copy:" + localException.toString());
        continue;
      }
      g(paramContext);
      return;
      TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromCopy #1 deCoupleCoreVersion is " + i1 + " getTbsCoreShareDecoupleCoreVersion is " + a().h(paramContext) + " getTbsCoreInstalledVerInNolock is " + a().i(paramContext));
    }
  }
  
  /* Error */
  int a(File paramFile)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aconst_null
    //   3: astore 5
    //   5: ldc 127
    //   7: new 151	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   14: ldc_w 1282
    //   17: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: aload_1
    //   21: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   24: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: new 169	java/io/File
    //   33: dup
    //   34: aload_1
    //   35: ldc_w 278
    //   38: invokespecial 273	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   41: astore_1
    //   42: aload_1
    //   43: ifnull +14 -> 57
    //   46: aload_1
    //   47: invokevirtual 523	java/io/File:exists	()Z
    //   50: istore 4
    //   52: iload 4
    //   54: ifne +17 -> 71
    //   57: iconst_0
    //   58: ifeq +11 -> 69
    //   61: new 1284	java/lang/NullPointerException
    //   64: dup
    //   65: invokespecial 1285	java/lang/NullPointerException:<init>	()V
    //   68: athrow
    //   69: iload_3
    //   70: ireturn
    //   71: new 280	java/util/Properties
    //   74: dup
    //   75: invokespecial 281	java/util/Properties:<init>	()V
    //   78: astore 6
    //   80: new 283	java/io/BufferedInputStream
    //   83: dup
    //   84: new 285	java/io/FileInputStream
    //   87: dup
    //   88: aload_1
    //   89: invokespecial 288	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   92: invokespecial 291	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   95: astore_1
    //   96: aload 6
    //   98: aload_1
    //   99: invokevirtual 294	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   102: aload_1
    //   103: invokevirtual 320	java/io/BufferedInputStream:close	()V
    //   106: aload 6
    //   108: ldc_w 1287
    //   111: invokevirtual 1288	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   114: astore 5
    //   116: aload 5
    //   118: ifnonnull +16 -> 134
    //   121: aload_1
    //   122: ifnull -53 -> 69
    //   125: aload_1
    //   126: invokevirtual 320	java/io/BufferedInputStream:close	()V
    //   129: iconst_0
    //   130: ireturn
    //   131: astore_1
    //   132: iconst_0
    //   133: ireturn
    //   134: aload 5
    //   136: invokestatic 1291	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   139: istore_2
    //   140: iload_2
    //   141: istore_3
    //   142: aload_1
    //   143: ifnull -74 -> 69
    //   146: aload_1
    //   147: invokevirtual 320	java/io/BufferedInputStream:close	()V
    //   150: iload_2
    //   151: ireturn
    //   152: astore_1
    //   153: iload_2
    //   154: ireturn
    //   155: astore_1
    //   156: aconst_null
    //   157: astore_1
    //   158: aload_1
    //   159: ifnull -90 -> 69
    //   162: aload_1
    //   163: invokevirtual 320	java/io/BufferedInputStream:close	()V
    //   166: iconst_0
    //   167: ireturn
    //   168: astore_1
    //   169: iconst_0
    //   170: ireturn
    //   171: astore_1
    //   172: aload 5
    //   174: ifnull +8 -> 182
    //   177: aload 5
    //   179: invokevirtual 320	java/io/BufferedInputStream:close	()V
    //   182: aload_1
    //   183: athrow
    //   184: astore_1
    //   185: iconst_0
    //   186: ireturn
    //   187: astore 5
    //   189: goto -7 -> 182
    //   192: astore 6
    //   194: aload_1
    //   195: astore 5
    //   197: aload 6
    //   199: astore_1
    //   200: goto -28 -> 172
    //   203: astore 5
    //   205: goto -47 -> 158
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	208	0	this	n
    //   0	208	1	paramFile	File
    //   139	15	2	i1	int
    //   1	141	3	i2	int
    //   50	3	4	bool	boolean
    //   3	175	5	str	String
    //   187	1	5	localIOException	java.io.IOException
    //   195	1	5	localFile	File
    //   203	1	5	localException	Exception
    //   78	29	6	localProperties	java.util.Properties
    //   192	6	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   125	129	131	java/io/IOException
    //   146	150	152	java/io/IOException
    //   5	42	155	java/lang/Exception
    //   46	52	155	java/lang/Exception
    //   71	96	155	java/lang/Exception
    //   162	166	168	java/io/IOException
    //   5	42	171	finally
    //   46	52	171	finally
    //   71	96	171	finally
    //   61	69	184	java/io/IOException
    //   177	182	187	java/io/IOException
    //   96	116	192	finally
    //   134	140	192	finally
    //   96	116	203	java/lang/Exception
    //   134	140	203	java/lang/Exception
  }
  
  /* Error */
  int a(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_1
    //   3: ifnonnull +5 -> 8
    //   6: iload_2
    //   7: ireturn
    //   8: aconst_null
    //   9: astore 5
    //   11: new 169	java/io/File
    //   14: dup
    //   15: new 169	java/io/File
    //   18: dup
    //   19: aload_1
    //   20: invokespecial 254	java/io/File:<init>	(Ljava/lang/String;)V
    //   23: ldc_w 278
    //   26: invokespecial 273	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   29: astore_1
    //   30: aload_1
    //   31: ifnull +14 -> 45
    //   34: aload_1
    //   35: invokevirtual 523	java/io/File:exists	()Z
    //   38: istore 4
    //   40: iload 4
    //   42: ifne +18 -> 60
    //   45: iconst_0
    //   46: ifeq -40 -> 6
    //   49: new 1284	java/lang/NullPointerException
    //   52: dup
    //   53: invokespecial 1285	java/lang/NullPointerException:<init>	()V
    //   56: athrow
    //   57: astore_1
    //   58: iconst_0
    //   59: ireturn
    //   60: new 280	java/util/Properties
    //   63: dup
    //   64: invokespecial 281	java/util/Properties:<init>	()V
    //   67: astore 6
    //   69: new 283	java/io/BufferedInputStream
    //   72: dup
    //   73: new 285	java/io/FileInputStream
    //   76: dup
    //   77: aload_1
    //   78: invokespecial 288	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   81: invokespecial 291	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   84: astore_1
    //   85: aload 6
    //   87: aload_1
    //   88: invokevirtual 294	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   91: aload_1
    //   92: invokevirtual 320	java/io/BufferedInputStream:close	()V
    //   95: aload 6
    //   97: ldc_w 1287
    //   100: invokevirtual 1288	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   103: astore 5
    //   105: aload 5
    //   107: ifnonnull +16 -> 123
    //   110: aload_1
    //   111: ifnull -105 -> 6
    //   114: aload_1
    //   115: invokevirtual 320	java/io/BufferedInputStream:close	()V
    //   118: iconst_0
    //   119: ireturn
    //   120: astore_1
    //   121: iconst_0
    //   122: ireturn
    //   123: aload 5
    //   125: invokestatic 1291	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   128: istore_3
    //   129: iload_3
    //   130: istore_2
    //   131: aload_1
    //   132: ifnull -126 -> 6
    //   135: aload_1
    //   136: invokevirtual 320	java/io/BufferedInputStream:close	()V
    //   139: iload_3
    //   140: ireturn
    //   141: astore_1
    //   142: iload_3
    //   143: ireturn
    //   144: astore_1
    //   145: aconst_null
    //   146: astore_1
    //   147: aload_1
    //   148: ifnull -142 -> 6
    //   151: aload_1
    //   152: invokevirtual 320	java/io/BufferedInputStream:close	()V
    //   155: iconst_0
    //   156: ireturn
    //   157: astore_1
    //   158: iconst_0
    //   159: ireturn
    //   160: astore_1
    //   161: aload 5
    //   163: ifnull +8 -> 171
    //   166: aload 5
    //   168: invokevirtual 320	java/io/BufferedInputStream:close	()V
    //   171: aload_1
    //   172: athrow
    //   173: astore 5
    //   175: goto -4 -> 171
    //   178: astore 6
    //   180: aload_1
    //   181: astore 5
    //   183: aload 6
    //   185: astore_1
    //   186: goto -25 -> 161
    //   189: astore 5
    //   191: goto -44 -> 147
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	194	0	this	n
    //   0	194	1	paramString	String
    //   1	130	2	i1	int
    //   128	15	3	i2	int
    //   38	3	4	bool	boolean
    //   9	158	5	str1	String
    //   173	1	5	localIOException	java.io.IOException
    //   181	1	5	str2	String
    //   189	1	5	localException	Exception
    //   67	29	6	localProperties	java.util.Properties
    //   178	6	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   49	57	57	java/io/IOException
    //   114	118	120	java/io/IOException
    //   135	139	141	java/io/IOException
    //   11	30	144	java/lang/Exception
    //   34	40	144	java/lang/Exception
    //   60	85	144	java/lang/Exception
    //   151	155	157	java/io/IOException
    //   11	30	160	finally
    //   34	40	160	finally
    //   60	85	160	finally
    //   166	171	173	java/io/IOException
    //   85	105	178	finally
    //   123	129	178	finally
    //   85	105	189	java/lang/Exception
    //   123	129	189	java/lang/Exception
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
    paramContext = "";
    switch (paramInt)
    {
    }
    for (;;)
    {
      TbsLog.i("TbsInstaller", "type=" + paramInt + "needMakeDir=" + paramBoolean + "folder=" + paramContext);
      paramContext = new File(localFile, paramContext);
      if (paramContext == null) {
        break label201;
      }
      if (paramContext.isDirectory()) {
        break label199;
      }
      if (!paramBoolean) {
        break;
      }
      if (paramContext.mkdir()) {
        break label199;
      }
      TbsLog.i("TbsInstaller", "getCoreDir,mkdir false");
      return null;
      paramContext = "core_unzip_tmp";
      continue;
      paramContext = "core_unzip_tmp_decouple";
      continue;
      paramContext = "core_share_backup";
      continue;
      paramContext = "core_share_backup_tmp";
      continue;
      paramContext = "core_copy_tmp";
      continue;
      paramContext = "tpatch_tmp";
      continue;
      paramContext = "tpatch_decouple_tmp";
    }
    TbsLog.i("TbsInstaller", "getCoreDir,no need mkdir");
    return null;
    label199:
    return paramContext;
    label201:
    TbsLog.i("TbsInstaller", "getCoreDir,tmpTbsShareDir = null");
    return null;
  }
  
  public void a(Context paramContext, int paramInt)
  {
    g(paramContext, true);
    k.a(paramContext).c(paramInt, 2);
  }
  
  void a(Context paramContext, Bundle paramBundle)
  {
    if ((paramBundle == null) || (paramContext == null)) {
      return;
    }
    Message localMessage = new Message();
    localMessage.what = 3;
    localMessage.obj = new Object[] { paramContext, paramBundle };
    m.sendMessage(localMessage);
  }
  
  void a(Context paramContext, String paramString, int paramInt)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore tbsApkPath=" + paramString);
    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore tbsCoreTargetVer=" + paramInt);
    TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + paramContext.getApplicationInfo().processName);
    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore currentProcessId=" + android.os.Process.myPid());
    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore currentThreadName=" + Thread.currentThread().getName());
    Message localMessage = new Message();
    localMessage.what = 1;
    localMessage.obj = new Object[] { paramContext, paramString, Integer.valueOf(paramInt) };
    m.sendMessage(localMessage);
  }
  
  void a(Context paramContext, boolean paramBoolean)
  {
    int i5 = 0;
    if (paramBoolean) {
      this.k = true;
    }
    TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + paramContext.getApplicationInfo().processName);
    TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessId=" + android.os.Process.myPid());
    TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentThreadName=" + Thread.currentThread().getName());
    if (!t(paramContext)) {
      return;
    }
    if (i.tryLock()) {}
    for (;;)
    {
      try
      {
        i4 = k.a(paramContext).c();
        i3 = k.a(paramContext).b();
        str = k.a(paramContext).d("install_apk_path");
        i1 = k.a(paramContext).c("copy_core_ver");
        i2 = k.a(paramContext).b("copy_status");
        i.unlock();
        b();
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore installStatus=" + i4);
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore tbsCoreInstallVer=" + i3);
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore tbsApkPath=" + str);
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore tbsCoreCopyVer=" + i1);
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore copyStatus=" + i2);
        if (TbsShareManager.isThirdPartyApp(paramContext))
        {
          c(paramContext, TbsShareManager.a(paramContext, false));
          return;
        }
      }
      finally
      {
        i.unlock();
      }
      int i6 = TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_responsecode", 0);
      if ((i6 == 1) || (i6 == 2) || (i6 == 4)) {
        i5 = 1;
      }
      if ((i5 == 0) && (i6 != 0) && (i6 != 5))
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("operation", 10001);
        a(paramContext, localBundle);
      }
      if ((i4 > -1) && (i4 < 2)) {
        a(paramContext, str, i3);
      }
      if (i2 != 0) {
        break;
      }
      b(paramContext, i1);
      return;
      int i2 = -1;
      String str = null;
      int i3 = 0;
      int i4 = -1;
      int i1 = 0;
    }
  }
  
  /* Error */
  public boolean a(Context paramContext1, Context paramContext2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 127
    //   4: ldc_w 1374
    //   7: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   10: getstatic 101	com/tencent/smtt/sdk/n:p	Z
    //   13: istore_3
    //   14: iload_3
    //   15: iconst_1
    //   16: if_icmpne +7 -> 23
    //   19: aload_0
    //   20: monitorexit
    //   21: iconst_1
    //   22: ireturn
    //   23: iconst_1
    //   24: putstatic 101	com/tencent/smtt/sdk/n:p	Z
    //   27: new 1376	com/tencent/smtt/sdk/n$4
    //   30: dup
    //   31: aload_0
    //   32: aload_2
    //   33: aload_1
    //   34: invokespecial 1379	com/tencent/smtt/sdk/n$4:<init>	(Lcom/tencent/smtt/sdk/n;Landroid/content/Context;Landroid/content/Context;)V
    //   37: invokevirtual 1382	com/tencent/smtt/sdk/n$4:start	()V
    //   40: goto -21 -> 19
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	n
    //   0	48	1	paramContext1	Context
    //   0	48	2	paramContext2	Context
    //   13	4	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	14	43	finally
    //   23	40	43	finally
  }
  
  public boolean a(Context paramContext, File paramFile, int paramInt)
  {
    TbsLog.i("TbsInstaller", "unzipTbsCoreToThirdAppTmpInThread #1");
    boolean bool = a(paramContext, paramFile, false);
    TbsLog.i("TbsInstaller", "unzipTbsCoreToThirdAppTmpInThread result is " + bool);
    if (bool) {
      a().a(paramContext, paramInt);
    }
    return bool;
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
    if (paramContext2 != null)
    {
      if ((!paramContext2.isDirectory()) && ((paramContext1 == null) || (!TbsShareManager.isThirdPartyApp(paramContext1))) && (!paramContext2.mkdir()))
      {
        TbsLog.i("TbsInstaller", "getTbsCoreShareDir,mkdir false");
        return null;
      }
      return paramContext2;
    }
    TbsLog.i("TbsInstaller", "getTbsCoreShareDir,tbsShareDir = null");
    return null;
  }
  
  void b()
  {
    for (;;)
    {
      try
      {
        if (this.e <= 0)
        {
          TbsLog.i("TbsInstaller", "releaseTbsInstallingFileLock currentTbsFileLockStackCount=" + this.e + "call stack:" + Log.getStackTraceString(new Throwable()));
          return;
        }
        if (this.e > 1)
        {
          TbsLog.i("TbsInstaller", "releaseTbsInstallingFileLock with skip");
          this.e -= 1;
          continue;
        }
        if (this.e != 1) {
          continue;
        }
      }
      finally {}
      TbsLog.i("TbsInstaller", "releaseTbsInstallingFileLock without skip");
      FileUtil.a(this.f, this.g);
      this.e = 0;
    }
  }
  
  public void b(Context paramContext)
  {
    g(paramContext, true);
    k.a(paramContext).c(h(paramContext), 2);
  }
  
  /* Error */
  void b(Context paramContext, Bundle paramBundle)
  {
    // Byte code:
    //   0: ldc 127
    //   2: new 151	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   9: ldc_w 1427
    //   12: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: invokestatic 739	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   18: invokevirtual 740	java/lang/Thread:getName	()Ljava/lang/String;
    //   21: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: new 249	java/lang/Throwable
    //   27: dup
    //   28: invokespecial 1414	java/lang/Throwable:<init>	()V
    //   31: invokestatic 622	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   34: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: aload_0
    //   44: aload_1
    //   45: invokevirtual 374	com/tencent/smtt/sdk/n:c	(Landroid/content/Context;)Z
    //   48: ifeq +14 -> 62
    //   51: aload_1
    //   52: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   55: sipush -539
    //   58: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   61: return
    //   62: ldc 127
    //   64: ldc_w 1429
    //   67: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   70: aload_2
    //   71: ifnull -10 -> 61
    //   74: aload_1
    //   75: ifnull -14 -> 61
    //   78: aload_1
    //   79: invokestatic 454	com/tencent/smtt/utils/FileUtil:b	(Landroid/content/Context;)Z
    //   82: ifne +70 -> 152
    //   85: invokestatic 459	com/tencent/smtt/utils/o:a	()J
    //   88: lstore 8
    //   90: aload_1
    //   91: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   94: invokevirtual 462	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMinFreeSpace	()J
    //   97: lstore 6
    //   99: aload_1
    //   100: invokestatic 208	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   103: sipush 210
    //   106: new 151	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   113: ldc_w 1431
    //   116: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: lload 8
    //   121: invokevirtual 467	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   124: ldc_w 469
    //   127: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: lload 6
    //   132: invokevirtual 467	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   135: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokevirtual 214	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   141: aload_1
    //   142: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   145: sipush -540
    //   148: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   151: return
    //   152: aload_0
    //   153: aload_1
    //   154: invokevirtual 405	com/tencent/smtt/sdk/n:t	(Landroid/content/Context;)Z
    //   157: ifne +14 -> 171
    //   160: aload_1
    //   161: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   164: sipush -541
    //   167: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   170: return
    //   171: getstatic 45	com/tencent/smtt/sdk/n:j	Ljava/util/concurrent/locks/Lock;
    //   174: invokeinterface 410 1 0
    //   179: istore 10
    //   181: ldc 127
    //   183: new 151	java/lang/StringBuilder
    //   186: dup
    //   187: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   190: ldc_w 1433
    //   193: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: iload 10
    //   198: invokevirtual 178	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   201: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   207: iload 10
    //   209: ifeq +1509 -> 1718
    //   212: aload_1
    //   213: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   216: getfield 841	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   219: ldc_w 843
    //   222: iconst_0
    //   223: invokeinterface 398 3 0
    //   228: istore 5
    //   230: iconst_1
    //   231: invokestatic 1135	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   234: iload 5
    //   236: iconst_5
    //   237: if_icmpne +263 -> 500
    //   240: aload_0
    //   241: aload_1
    //   242: aload_2
    //   243: invokespecial 1435	com/tencent/smtt/sdk/n:c	(Landroid/content/Context;Landroid/os/Bundle;)I
    //   246: istore_3
    //   247: iload_3
    //   248: iconst_1
    //   249: if_icmpne +29 -> 278
    //   252: aload_1
    //   253: invokestatic 231	com/tencent/smtt/sdk/k:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/k;
    //   256: ldc_w 1229
    //   259: invokevirtual 420	com/tencent/smtt/sdk/k:c	(Ljava/lang/String;)I
    //   262: istore 4
    //   264: aload_1
    //   265: invokestatic 231	com/tencent/smtt/sdk/k:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/k;
    //   268: ldc_w 1229
    //   271: iload 4
    //   273: iconst_1
    //   274: iadd
    //   275: invokevirtual 489	com/tencent/smtt/sdk/k:a	(Ljava/lang/String;I)V
    //   278: getstatic 45	com/tencent/smtt/sdk/n:j	Ljava/util/concurrent/locks/Lock;
    //   281: invokeinterface 436 1 0
    //   286: aload_0
    //   287: invokevirtual 438	com/tencent/smtt/sdk/n:b	()V
    //   290: iload 5
    //   292: iconst_5
    //   293: if_icmpne +10 -> 303
    //   296: aload_0
    //   297: aload_1
    //   298: iload_3
    //   299: invokespecial 1437	com/tencent/smtt/sdk/n:h	(Landroid/content/Context;I)V
    //   302: return
    //   303: iload_3
    //   304: ifne +62 -> 366
    //   307: ldc 127
    //   309: ldc_w 1439
    //   312: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   315: aload_1
    //   316: invokestatic 231	com/tencent/smtt/sdk/k:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/k;
    //   319: ldc_w 1225
    //   322: iconst_0
    //   323: invokevirtual 489	com/tencent/smtt/sdk/k:a	(Ljava/lang/String;I)V
    //   326: aload_1
    //   327: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   330: sipush -544
    //   333: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   336: aload_1
    //   337: invokestatic 231	com/tencent/smtt/sdk/k:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/k;
    //   340: iconst_0
    //   341: iconst_m1
    //   342: invokevirtual 234	com/tencent/smtt/sdk/k:c	(II)V
    //   345: aload_1
    //   346: invokestatic 231	com/tencent/smtt/sdk/k:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/k;
    //   349: iconst_1
    //   350: invokevirtual 237	com/tencent/smtt/sdk/k:c	(I)V
    //   353: new 1284	java/lang/NullPointerException
    //   356: dup
    //   357: invokespecial 1285	java/lang/NullPointerException:<init>	()V
    //   360: athrow
    //   361: iconst_0
    //   362: invokestatic 1135	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   365: return
    //   366: iload_3
    //   367: iconst_2
    //   368: if_icmpne +14 -> 382
    //   371: ldc 127
    //   373: ldc_w 1441
    //   376: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   379: goto -18 -> 361
    //   382: aload_1
    //   383: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   386: sipush -546
    //   389: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   392: ldc 127
    //   394: ldc_w 1443
    //   397: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   400: aload_1
    //   401: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   404: getfield 813	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   407: ldc_w 815
    //   410: iconst_1
    //   411: invokestatic 820	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   414: invokeinterface 826 3 0
    //   419: pop
    //   420: aload_1
    //   421: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   424: invokevirtual 830	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   427: aload_1
    //   428: invokestatic 478	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   431: ifeq +36 -> 467
    //   434: aload_1
    //   435: invokestatic 208	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   438: sipush 235
    //   441: new 151	java/lang/StringBuilder
    //   444: dup
    //   445: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   448: ldc_w 1445
    //   451: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   454: iload_3
    //   455: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   458: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   461: invokevirtual 214	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   464: goto -103 -> 361
    //   467: aload_1
    //   468: invokestatic 208	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   471: sipush 217
    //   474: new 151	java/lang/StringBuilder
    //   477: dup
    //   478: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   481: ldc_w 1447
    //   484: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   487: iload_3
    //   488: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   491: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   494: invokevirtual 214	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   497: goto -136 -> 361
    //   500: aload_0
    //   501: aload_1
    //   502: invokevirtual 441	com/tencent/smtt/sdk/n:i	(Landroid/content/Context;)I
    //   505: ifle +14 -> 519
    //   508: aload_1
    //   509: invokestatic 231	com/tencent/smtt/sdk/k:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/k;
    //   512: invokevirtual 1177	com/tencent/smtt/sdk/k:d	()I
    //   515: iconst_1
    //   516: if_icmpne +45 -> 561
    //   519: iconst_0
    //   520: invokestatic 1135	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   523: getstatic 45	com/tencent/smtt/sdk/n:j	Ljava/util/concurrent/locks/Lock;
    //   526: invokeinterface 436 1 0
    //   531: aload_0
    //   532: invokevirtual 438	com/tencent/smtt/sdk/n:b	()V
    //   535: iload 5
    //   537: iconst_5
    //   538: if_icmpne +10 -> 548
    //   541: aload_0
    //   542: aload_1
    //   543: iconst_2
    //   544: invokespecial 1437	com/tencent/smtt/sdk/n:h	(Landroid/content/Context;I)V
    //   547: return
    //   548: ldc 127
    //   550: ldc_w 1441
    //   553: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   556: iconst_0
    //   557: invokestatic 1135	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   560: return
    //   561: iload 5
    //   563: iconst_1
    //   564: if_icmpeq +15 -> 579
    //   567: iload 5
    //   569: iconst_2
    //   570: if_icmpeq +9 -> 579
    //   573: iload 5
    //   575: iconst_4
    //   576: if_icmpne +187 -> 763
    //   579: iconst_1
    //   580: istore_3
    //   581: iload_3
    //   582: ifne +1212 -> 1794
    //   585: iload 5
    //   587: ifeq +1207 -> 1794
    //   590: aload_1
    //   591: invokestatic 231	com/tencent/smtt/sdk/k:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/k;
    //   594: ldc_w 1225
    //   597: invokevirtual 420	com/tencent/smtt/sdk/k:c	(Ljava/lang/String;)I
    //   600: istore_3
    //   601: iload_3
    //   602: iconst_5
    //   603: if_icmple +178 -> 781
    //   606: ldc 127
    //   608: ldc_w 1449
    //   611: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   614: aload_2
    //   615: ldc_w 1451
    //   618: invokevirtual 950	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   621: astore 11
    //   623: aload_2
    //   624: ldc_w 947
    //   627: invokevirtual 950	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   630: astore 12
    //   632: aload_2
    //   633: ldc_w 1453
    //   636: invokevirtual 950	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   639: astore_2
    //   640: aload 11
    //   642: invokestatic 988	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   645: ifne +15 -> 660
    //   648: new 169	java/io/File
    //   651: dup
    //   652: aload 11
    //   654: invokespecial 254	java/io/File:<init>	(Ljava/lang/String;)V
    //   657: invokestatic 663	com/tencent/smtt/utils/FileUtil:b	(Ljava/io/File;)V
    //   660: aload 12
    //   662: invokestatic 988	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   665: ifne +15 -> 680
    //   668: new 169	java/io/File
    //   671: dup
    //   672: aload 12
    //   674: invokespecial 254	java/io/File:<init>	(Ljava/lang/String;)V
    //   677: invokestatic 663	com/tencent/smtt/utils/FileUtil:b	(Ljava/io/File;)V
    //   680: aload_2
    //   681: invokestatic 988	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   684: ifne +14 -> 698
    //   687: new 169	java/io/File
    //   690: dup
    //   691: aload_2
    //   692: invokespecial 254	java/io/File:<init>	(Ljava/lang/String;)V
    //   695: invokestatic 663	com/tencent/smtt/utils/FileUtil:b	(Ljava/io/File;)V
    //   698: aload_1
    //   699: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   702: getfield 813	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   705: ldc_w 815
    //   708: iconst_1
    //   709: invokestatic 820	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   712: invokeinterface 826 3 0
    //   717: pop
    //   718: aload_1
    //   719: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   722: invokevirtual 830	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   725: aload_1
    //   726: invokestatic 208	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   729: sipush 224
    //   732: ldc_w 1455
    //   735: invokevirtual 214	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   738: getstatic 45	com/tencent/smtt/sdk/n:j	Ljava/util/concurrent/locks/Lock;
    //   741: invokeinterface 436 1 0
    //   746: aload_0
    //   747: invokevirtual 438	com/tencent/smtt/sdk/n:b	()V
    //   750: iload 5
    //   752: iconst_5
    //   753: if_icmpne +15 -> 768
    //   756: aload_0
    //   757: aload_1
    //   758: iconst_2
    //   759: invokespecial 1437	com/tencent/smtt/sdk/n:h	(Landroid/content/Context;I)V
    //   762: return
    //   763: iconst_0
    //   764: istore_3
    //   765: goto -184 -> 581
    //   768: ldc 127
    //   770: ldc_w 1441
    //   773: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   776: iconst_0
    //   777: invokestatic 1135	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   780: return
    //   781: aload_1
    //   782: invokestatic 231	com/tencent/smtt/sdk/k:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/k;
    //   785: ldc_w 1225
    //   788: iload_3
    //   789: iconst_1
    //   790: iadd
    //   791: invokevirtual 489	com/tencent/smtt/sdk/k:a	(Ljava/lang/String;I)V
    //   794: aload_1
    //   795: invokestatic 682	com/tencent/smtt/sdk/n:s	(Landroid/content/Context;)Ljava/io/File;
    //   798: astore 11
    //   800: aload 11
    //   802: ifnull +992 -> 1794
    //   805: new 169	java/io/File
    //   808: dup
    //   809: aload 11
    //   811: ldc_w 684
    //   814: invokespecial 273	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   817: astore 11
    //   819: aload 11
    //   821: ifnull +973 -> 1794
    //   824: aload 11
    //   826: invokevirtual 523	java/io/File:exists	()Z
    //   829: ifeq +965 -> 1794
    //   832: aload_1
    //   833: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   836: sipush -550
    //   839: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   842: aload_1
    //   843: aload_2
    //   844: invokestatic 939	com/tencent/smtt/sdk/QbSdk:a	(Landroid/content/Context;Landroid/os/Bundle;)Landroid/os/Bundle;
    //   847: astore 11
    //   849: aload 11
    //   851: ifnonnull +72 -> 923
    //   854: aload_1
    //   855: invokestatic 208	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   858: sipush 228
    //   861: new 151	java/lang/StringBuilder
    //   864: dup
    //   865: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   868: ldc_w 1457
    //   871: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   874: aload_2
    //   875: ldc_w 952
    //   878: invokevirtual 945	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   881: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   884: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   887: invokevirtual 214	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   890: iconst_1
    //   891: istore 4
    //   893: aload 11
    //   895: astore 12
    //   897: getstatic 45	com/tencent/smtt/sdk/n:j	Ljava/util/concurrent/locks/Lock;
    //   900: invokeinterface 436 1 0
    //   905: aload_0
    //   906: invokevirtual 438	com/tencent/smtt/sdk/n:b	()V
    //   909: iload 5
    //   911: iconst_5
    //   912: if_icmpne +169 -> 1081
    //   915: aload_0
    //   916: aload_1
    //   917: iload 4
    //   919: invokespecial 1437	com/tencent/smtt/sdk/n:h	(Landroid/content/Context;I)V
    //   922: return
    //   923: aload 11
    //   925: ldc_w 943
    //   928: invokevirtual 945	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   931: istore_3
    //   932: iload_3
    //   933: istore 4
    //   935: aload 11
    //   937: astore 12
    //   939: iload_3
    //   940: ifeq -43 -> 897
    //   943: aload_1
    //   944: invokestatic 208	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   947: sipush 228
    //   950: new 151	java/lang/StringBuilder
    //   953: dup
    //   954: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   957: ldc_w 1459
    //   960: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   963: iload_3
    //   964: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   967: ldc_w 1461
    //   970: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   973: aload_2
    //   974: ldc_w 952
    //   977: invokevirtual 945	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   980: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   983: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   986: invokevirtual 214	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   989: iload_3
    //   990: istore 4
    //   992: aload 11
    //   994: astore 12
    //   996: goto -99 -> 897
    //   999: astore_2
    //   1000: ldc 127
    //   1002: new 151	java/lang/StringBuilder
    //   1005: dup
    //   1006: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   1009: ldc_w 1463
    //   1012: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1015: aload_2
    //   1016: invokestatic 622	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1019: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1022: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1025: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1028: aload_2
    //   1029: invokevirtual 542	java/lang/Exception:printStackTrace	()V
    //   1032: aload_1
    //   1033: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1036: sipush -543
    //   1039: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1042: aload_1
    //   1043: invokestatic 208	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1046: sipush 218
    //   1049: aload_2
    //   1050: invokevirtual 543	java/lang/Exception:toString	()Ljava/lang/String;
    //   1053: invokevirtual 214	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1056: getstatic 45	com/tencent/smtt/sdk/n:j	Ljava/util/concurrent/locks/Lock;
    //   1059: invokeinterface 436 1 0
    //   1064: aload_0
    //   1065: invokevirtual 438	com/tencent/smtt/sdk/n:b	()V
    //   1068: iload 5
    //   1070: iconst_5
    //   1071: if_icmpne +253 -> 1324
    //   1074: aload_0
    //   1075: aload_1
    //   1076: iconst_1
    //   1077: invokespecial 1437	com/tencent/smtt/sdk/n:h	(Landroid/content/Context;I)V
    //   1080: return
    //   1081: iload 4
    //   1083: ifne +104 -> 1187
    //   1086: ldc 127
    //   1088: ldc_w 1439
    //   1091: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1094: aload_1
    //   1095: invokestatic 231	com/tencent/smtt/sdk/k:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/k;
    //   1098: ldc_w 1225
    //   1101: iconst_0
    //   1102: invokevirtual 489	com/tencent/smtt/sdk/k:a	(Ljava/lang/String;I)V
    //   1105: aload_1
    //   1106: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1109: sipush -544
    //   1112: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1115: aload_1
    //   1116: invokestatic 231	com/tencent/smtt/sdk/k:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/k;
    //   1119: iconst_0
    //   1120: iconst_m1
    //   1121: invokevirtual 234	com/tencent/smtt/sdk/k:c	(II)V
    //   1124: aload_1
    //   1125: invokestatic 231	com/tencent/smtt/sdk/k:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/k;
    //   1128: iconst_1
    //   1129: invokevirtual 237	com/tencent/smtt/sdk/k:c	(I)V
    //   1132: aload 12
    //   1134: ldc_w 1465
    //   1137: invokevirtual 950	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1140: astore_2
    //   1141: new 169	java/io/File
    //   1144: dup
    //   1145: aload_2
    //   1146: invokespecial 254	java/io/File:<init>	(Ljava/lang/String;)V
    //   1149: aload_1
    //   1150: invokestatic 584	com/tencent/smtt/sdk/j:a	(Ljava/io/File;Landroid/content/Context;)V
    //   1153: aload_0
    //   1154: aload_1
    //   1155: aload_2
    //   1156: aload 12
    //   1158: ldc_w 1467
    //   1161: invokevirtual 945	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   1164: invokespecial 650	com/tencent/smtt/sdk/n:b	(Landroid/content/Context;Ljava/lang/String;I)V
    //   1167: aload_1
    //   1168: invokestatic 478	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   1171: ifeq +11 -> 1182
    //   1174: aload_1
    //   1175: invokestatic 231	com/tencent/smtt/sdk/k:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/k;
    //   1178: iconst_m1
    //   1179: invokevirtual 237	com/tencent/smtt/sdk/k:c	(I)V
    //   1182: iconst_0
    //   1183: invokestatic 1135	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   1186: return
    //   1187: iload 4
    //   1189: iconst_2
    //   1190: if_icmpne +14 -> 1204
    //   1193: ldc 127
    //   1195: ldc_w 1441
    //   1198: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1201: goto -19 -> 1182
    //   1204: aload_1
    //   1205: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1208: sipush -546
    //   1211: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1214: ldc 127
    //   1216: ldc_w 1443
    //   1219: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1222: aload_1
    //   1223: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1226: getfield 813	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1229: ldc_w 815
    //   1232: iconst_1
    //   1233: invokestatic 820	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1236: invokeinterface 826 3 0
    //   1241: pop
    //   1242: aload_1
    //   1243: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1246: invokevirtual 830	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1249: aload_1
    //   1250: invokestatic 478	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   1253: ifeq +37 -> 1290
    //   1256: aload_1
    //   1257: invokestatic 208	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1260: sipush 235
    //   1263: new 151	java/lang/StringBuilder
    //   1266: dup
    //   1267: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   1270: ldc_w 1445
    //   1273: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1276: iload 4
    //   1278: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1281: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1284: invokevirtual 214	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1287: goto -105 -> 1182
    //   1290: aload_1
    //   1291: invokestatic 208	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1294: sipush 217
    //   1297: new 151	java/lang/StringBuilder
    //   1300: dup
    //   1301: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   1304: ldc_w 1447
    //   1307: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1310: iload 4
    //   1312: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1315: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1318: invokevirtual 214	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1321: goto -139 -> 1182
    //   1324: aload_1
    //   1325: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1328: sipush -546
    //   1331: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1334: ldc 127
    //   1336: ldc_w 1443
    //   1339: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1342: aload_1
    //   1343: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1346: getfield 813	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1349: ldc_w 815
    //   1352: iconst_1
    //   1353: invokestatic 820	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1356: invokeinterface 826 3 0
    //   1361: pop
    //   1362: aload_1
    //   1363: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1366: invokevirtual 830	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1369: aload_1
    //   1370: invokestatic 478	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   1373: ifeq +38 -> 1411
    //   1376: aload_1
    //   1377: invokestatic 208	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1380: sipush 235
    //   1383: new 151	java/lang/StringBuilder
    //   1386: dup
    //   1387: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   1390: ldc_w 1445
    //   1393: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1396: iconst_1
    //   1397: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1400: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1403: invokevirtual 214	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1406: iconst_0
    //   1407: invokestatic 1135	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   1410: return
    //   1411: aload_1
    //   1412: invokestatic 208	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1415: sipush 217
    //   1418: new 151	java/lang/StringBuilder
    //   1421: dup
    //   1422: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   1425: ldc_w 1447
    //   1428: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1431: iconst_1
    //   1432: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1435: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1438: invokevirtual 214	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1441: goto -35 -> 1406
    //   1444: astore_2
    //   1445: aconst_null
    //   1446: astore 11
    //   1448: iconst_2
    //   1449: istore_3
    //   1450: getstatic 45	com/tencent/smtt/sdk/n:j	Ljava/util/concurrent/locks/Lock;
    //   1453: invokeinterface 436 1 0
    //   1458: aload_0
    //   1459: invokevirtual 438	com/tencent/smtt/sdk/n:b	()V
    //   1462: iload 5
    //   1464: iconst_5
    //   1465: if_icmpne +10 -> 1475
    //   1468: aload_0
    //   1469: aload_1
    //   1470: iload_3
    //   1471: invokespecial 1437	com/tencent/smtt/sdk/n:h	(Landroid/content/Context;I)V
    //   1474: return
    //   1475: iload_3
    //   1476: ifne +108 -> 1584
    //   1479: ldc 127
    //   1481: ldc_w 1439
    //   1484: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1487: aload_1
    //   1488: invokestatic 231	com/tencent/smtt/sdk/k:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/k;
    //   1491: ldc_w 1225
    //   1494: iconst_0
    //   1495: invokevirtual 489	com/tencent/smtt/sdk/k:a	(Ljava/lang/String;I)V
    //   1498: aload_1
    //   1499: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1502: sipush -544
    //   1505: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1508: aload_1
    //   1509: invokestatic 231	com/tencent/smtt/sdk/k:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/k;
    //   1512: iconst_0
    //   1513: iconst_m1
    //   1514: invokevirtual 234	com/tencent/smtt/sdk/k:c	(II)V
    //   1517: aload_1
    //   1518: invokestatic 231	com/tencent/smtt/sdk/k:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/k;
    //   1521: iconst_1
    //   1522: invokevirtual 237	com/tencent/smtt/sdk/k:c	(I)V
    //   1525: aload 11
    //   1527: ldc_w 1465
    //   1530: invokevirtual 950	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1533: astore 12
    //   1535: new 169	java/io/File
    //   1538: dup
    //   1539: aload 12
    //   1541: invokespecial 254	java/io/File:<init>	(Ljava/lang/String;)V
    //   1544: aload_1
    //   1545: invokestatic 584	com/tencent/smtt/sdk/j:a	(Ljava/io/File;Landroid/content/Context;)V
    //   1548: aload_0
    //   1549: aload_1
    //   1550: aload 12
    //   1552: aload 11
    //   1554: ldc_w 1467
    //   1557: invokevirtual 945	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   1560: invokespecial 650	com/tencent/smtt/sdk/n:b	(Landroid/content/Context;Ljava/lang/String;I)V
    //   1563: aload_1
    //   1564: invokestatic 478	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   1567: ifeq +11 -> 1578
    //   1570: aload_1
    //   1571: invokestatic 231	com/tencent/smtt/sdk/k:a	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/k;
    //   1574: iconst_m1
    //   1575: invokevirtual 237	com/tencent/smtt/sdk/k:c	(I)V
    //   1578: iconst_0
    //   1579: invokestatic 1135	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   1582: aload_2
    //   1583: athrow
    //   1584: iload_3
    //   1585: iconst_2
    //   1586: if_icmpne +14 -> 1600
    //   1589: ldc 127
    //   1591: ldc_w 1441
    //   1594: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1597: goto -19 -> 1578
    //   1600: aload_1
    //   1601: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1604: sipush -546
    //   1607: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1610: ldc 127
    //   1612: ldc_w 1443
    //   1615: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1618: aload_1
    //   1619: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1622: getfield 813	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1625: ldc_w 815
    //   1628: iconst_1
    //   1629: invokestatic 820	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1632: invokeinterface 826 3 0
    //   1637: pop
    //   1638: aload_1
    //   1639: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1642: invokevirtual 830	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1645: aload_1
    //   1646: invokestatic 478	com/tencent/smtt/sdk/TbsDownloader:a	(Landroid/content/Context;)Z
    //   1649: ifeq +36 -> 1685
    //   1652: aload_1
    //   1653: invokestatic 208	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1656: sipush 235
    //   1659: new 151	java/lang/StringBuilder
    //   1662: dup
    //   1663: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   1666: ldc_w 1445
    //   1669: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1672: iload_3
    //   1673: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1676: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1679: invokevirtual 214	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1682: goto -104 -> 1578
    //   1685: aload_1
    //   1686: invokestatic 208	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1689: sipush 217
    //   1692: new 151	java/lang/StringBuilder
    //   1695: dup
    //   1696: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   1699: ldc_w 1447
    //   1702: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1705: iload_3
    //   1706: invokevirtual 379	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1709: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1712: invokevirtual 214	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1715: goto -137 -> 1578
    //   1718: aload_1
    //   1719: invokestatic 369	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1722: sipush -547
    //   1725: invokevirtual 372	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1728: aload_0
    //   1729: invokevirtual 438	com/tencent/smtt/sdk/n:b	()V
    //   1732: return
    //   1733: astore_2
    //   1734: aconst_null
    //   1735: astore 11
    //   1737: goto -287 -> 1450
    //   1740: astore_2
    //   1741: iconst_1
    //   1742: istore_3
    //   1743: goto -293 -> 1450
    //   1746: astore_2
    //   1747: iconst_2
    //   1748: istore_3
    //   1749: goto -299 -> 1450
    //   1752: astore_2
    //   1753: goto -303 -> 1450
    //   1756: astore_2
    //   1757: goto -307 -> 1450
    //   1760: astore_2
    //   1761: iconst_1
    //   1762: istore_3
    //   1763: goto -313 -> 1450
    //   1766: astore_2
    //   1767: aconst_null
    //   1768: astore 11
    //   1770: iconst_2
    //   1771: istore_3
    //   1772: goto -772 -> 1000
    //   1775: astore_2
    //   1776: aconst_null
    //   1777: astore 11
    //   1779: goto -779 -> 1000
    //   1782: astore_2
    //   1783: iconst_1
    //   1784: istore_3
    //   1785: goto -785 -> 1000
    //   1788: astore_2
    //   1789: iconst_2
    //   1790: istore_3
    //   1791: goto -791 -> 1000
    //   1794: aconst_null
    //   1795: astore 12
    //   1797: iconst_2
    //   1798: istore 4
    //   1800: goto -903 -> 897
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1803	0	this	n
    //   0	1803	1	paramContext	Context
    //   0	1803	2	paramBundle	Bundle
    //   246	1545	3	i1	int
    //   262	1537	4	i2	int
    //   228	1238	5	i3	int
    //   97	34	6	l1	long
    //   88	32	8	l2	long
    //   179	29	10	bool	boolean
    //   621	1157	11	localObject1	Object
    //   630	1166	12	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   943	989	999	java/lang/Exception
    //   230	234	1444	finally
    //   240	247	1444	finally
    //   500	519	1444	finally
    //   519	523	1444	finally
    //   590	601	1444	finally
    //   606	660	1444	finally
    //   660	680	1444	finally
    //   680	698	1444	finally
    //   698	738	1444	finally
    //   781	800	1444	finally
    //   805	819	1444	finally
    //   824	849	1444	finally
    //   252	278	1733	finally
    //   854	890	1740	finally
    //   923	932	1746	finally
    //   943	989	1752	finally
    //   1000	1032	1756	finally
    //   1032	1056	1760	finally
    //   230	234	1766	java/lang/Exception
    //   240	247	1766	java/lang/Exception
    //   500	519	1766	java/lang/Exception
    //   519	523	1766	java/lang/Exception
    //   590	601	1766	java/lang/Exception
    //   606	660	1766	java/lang/Exception
    //   660	680	1766	java/lang/Exception
    //   680	698	1766	java/lang/Exception
    //   698	738	1766	java/lang/Exception
    //   781	800	1766	java/lang/Exception
    //   805	819	1766	java/lang/Exception
    //   824	849	1766	java/lang/Exception
    //   252	278	1775	java/lang/Exception
    //   854	890	1782	java/lang/Exception
    //   923	932	1788	java/lang/Exception
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
    File localFile;
    if ((TbsShareManager.isThirdPartyApp(paramContext)) && (k.a(paramContext).b("remove_old_core") == 1) && (paramBoolean)) {
      localFile = a().q(paramContext);
    }
    label200:
    label219:
    do
    {
      do
      {
        do
        {
          try
          {
            FileUtil.b(localFile);
            TbsLog.i("TbsInstaller", "thirdAPP success--> delete old core_share Directory");
            k.a(paramContext).a("remove_old_core", 0);
            if (!v(paramContext)) {
              break;
            }
            TbsLog.i("TbsInstaller", "Tbsinstaller installTbsCoreIfNeeded #2 ");
            if (!a(paramContext, "core_unzip_tmp"))
            {
              if (a(paramContext, "core_share_backup_tmp")) {
                continue;
              }
              if (a(paramContext, "core_copy_tmp")) {
                break label200;
              }
              if (a(paramContext, "tpatch_tmp")) {
                break label219;
              }
              TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, error !!", true);
            }
          }
          catch (Throwable localThrowable)
          {
            do
            {
              for (;;)
              {
                localThrowable.printStackTrace();
              }
            } while (!e(paramContext, paramBoolean));
            TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromUnzip!!", true);
            return;
          }
        } while (!f(paramContext, paramBoolean));
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromBackup!!", true);
        return;
      } while (!d(paramContext, paramBoolean));
      TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromCopy!!", true);
      return;
    } while (!c(paramContext, paramBoolean));
    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromTpatch!!", true);
  }
  
  boolean b(Context paramContext, int paramInt)
  {
    if (TbsDownloader.getOverSea(paramContext)) {
      return false;
    }
    TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore targetTbsCoreVer=" + paramInt);
    TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + paramContext.getApplicationInfo().processName);
    TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore currentProcessId=" + android.os.Process.myPid());
    TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore currentThreadName=" + Thread.currentThread().getName());
    Context localContext = d(paramContext, paramInt);
    if (localContext != null)
    {
      Message localMessage = new Message();
      localMessage.what = 2;
      localMessage.obj = new Object[] { localContext, paramContext, Integer.valueOf(paramInt) };
      m.sendMessage(localMessage);
      return true;
    }
    TbsLog.i("TbsInstaller", "TbsInstaller--installLocalTbsCore copy from null");
    return false;
  }
  
  int c(Context paramContext, String paramString)
  {
    int i1 = 0;
    paramContext = paramContext.getPackageManager().getPackageArchiveInfo(paramString, 0);
    if (paramContext != null) {
      i1 = paramContext.versionCode;
    }
    return i1;
  }
  
  void c(Context paramContext, int paramInt)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreForThirdPartyApp");
    if (paramInt <= 0) {}
    int i1;
    do
    {
      do
      {
        return;
        i1 = i(paramContext);
      } while (i1 == paramInt);
      Context localContext = TbsShareManager.e(paramContext);
      if ((localContext != null) || (TbsShareManager.getHostCorePathAppDefined() != null))
      {
        TbsLog.i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp hostContext != null");
        a(paramContext, localContext);
        return;
      }
    } while (i1 > 0);
    TbsLog.i("TbsInstaller", "TbsInstaller--installTbsCoreForThirdPartyApp hostContext == null");
    QbSdk.a(paramContext, "TbsInstaller::installTbsCoreForThirdPartyApp forceSysWebViewInner #2");
  }
  
  /* Error */
  boolean c(Context paramContext)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: new 169	java/io/File
    //   5: dup
    //   6: aload_0
    //   7: aload_1
    //   8: invokevirtual 138	com/tencent/smtt/sdk/n:q	(Landroid/content/Context;)Ljava/io/File;
    //   11: ldc_w 278
    //   14: invokespecial 273	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   17: astore 5
    //   19: aload 5
    //   21: ifnull +11 -> 32
    //   24: aload 5
    //   26: invokevirtual 523	java/io/File:exists	()Z
    //   29: ifne +9 -> 38
    //   32: iconst_0
    //   33: istore 4
    //   35: iload 4
    //   37: ireturn
    //   38: new 280	java/util/Properties
    //   41: dup
    //   42: invokespecial 281	java/util/Properties:<init>	()V
    //   45: astore 6
    //   47: new 283	java/io/BufferedInputStream
    //   50: dup
    //   51: new 285	java/io/FileInputStream
    //   54: dup
    //   55: aload 5
    //   57: invokespecial 288	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   60: invokespecial 291	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   63: astore_1
    //   64: aload 6
    //   66: aload_1
    //   67: invokevirtual 294	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   70: aload 6
    //   72: ldc_w 304
    //   75: ldc_w 1533
    //   78: invokevirtual 554	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   81: invokestatic 1536	java/lang/Boolean:valueOf	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   84: invokevirtual 851	java/lang/Boolean:booleanValue	()Z
    //   87: istore 4
    //   89: iload 4
    //   91: ifeq +175 -> 266
    //   94: invokestatic 503	java/lang/System:currentTimeMillis	()J
    //   97: aload 5
    //   99: invokevirtual 1539	java/io/File:lastModified	()J
    //   102: lsub
    //   103: ldc2_w 1540
    //   106: lcmp
    //   107: ifle +70 -> 177
    //   110: iconst_1
    //   111: istore_3
    //   112: ldc 127
    //   114: new 151	java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   121: ldc_w 1543
    //   124: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: iload 4
    //   129: invokevirtual 178	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   132: ldc_w 1545
    //   135: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: iload_3
    //   139: invokevirtual 178	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   142: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   148: iload_3
    //   149: ifne +33 -> 182
    //   152: iload 4
    //   154: iload_2
    //   155: iand
    //   156: istore_3
    //   157: iload_3
    //   158: istore 4
    //   160: aload_1
    //   161: ifnull -126 -> 35
    //   164: aload_1
    //   165: invokevirtual 320	java/io/BufferedInputStream:close	()V
    //   168: iload_3
    //   169: ireturn
    //   170: astore_1
    //   171: aload_1
    //   172: invokevirtual 323	java/io/IOException:printStackTrace	()V
    //   175: iload_3
    //   176: ireturn
    //   177: iconst_0
    //   178: istore_3
    //   179: goto -67 -> 112
    //   182: iconst_0
    //   183: istore_2
    //   184: goto -32 -> 152
    //   187: astore 5
    //   189: iconst_0
    //   190: istore_3
    //   191: aconst_null
    //   192: astore_1
    //   193: aload 5
    //   195: invokevirtual 324	java/lang/Throwable:printStackTrace	()V
    //   198: iload_3
    //   199: istore 4
    //   201: aload_1
    //   202: ifnull -167 -> 35
    //   205: aload_1
    //   206: invokevirtual 320	java/io/BufferedInputStream:close	()V
    //   209: iload_3
    //   210: ireturn
    //   211: astore_1
    //   212: aload_1
    //   213: invokevirtual 323	java/io/IOException:printStackTrace	()V
    //   216: iload_3
    //   217: ireturn
    //   218: astore 5
    //   220: aconst_null
    //   221: astore_1
    //   222: aload_1
    //   223: ifnull +7 -> 230
    //   226: aload_1
    //   227: invokevirtual 320	java/io/BufferedInputStream:close	()V
    //   230: aload 5
    //   232: athrow
    //   233: astore_1
    //   234: aload_1
    //   235: invokevirtual 323	java/io/IOException:printStackTrace	()V
    //   238: goto -8 -> 230
    //   241: astore 5
    //   243: goto -21 -> 222
    //   246: astore 5
    //   248: goto -26 -> 222
    //   251: astore 5
    //   253: iconst_0
    //   254: istore_3
    //   255: goto -62 -> 193
    //   258: astore 5
    //   260: iload 4
    //   262: istore_3
    //   263: goto -70 -> 193
    //   266: iconst_0
    //   267: istore_3
    //   268: goto -156 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	271	0	this	n
    //   0	271	1	paramContext	Context
    //   1	183	2	bool1	boolean
    //   111	157	3	bool2	boolean
    //   33	228	4	bool3	boolean
    //   17	81	5	localFile	File
    //   187	7	5	localThrowable1	Throwable
    //   218	13	5	localObject1	Object
    //   241	1	5	localObject2	Object
    //   246	1	5	localObject3	Object
    //   251	1	5	localThrowable2	Throwable
    //   258	1	5	localThrowable3	Throwable
    //   45	26	6	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   164	168	170	java/io/IOException
    //   47	64	187	java/lang/Throwable
    //   205	209	211	java/io/IOException
    //   47	64	218	finally
    //   226	230	233	java/io/IOException
    //   64	89	241	finally
    //   94	110	241	finally
    //   112	148	241	finally
    //   193	198	246	finally
    //   64	89	251	java/lang/Throwable
    //   94	110	258	java/lang/Throwable
    //   112	148	258	java/lang/Throwable
  }
  
  public Context d(Context paramContext, int paramInt)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreHostContext tbsCoreTargetVer=" + paramInt);
    if (paramInt <= 0) {
      return null;
    }
    String[] arrayOfString = TbsShareManager.getCoreProviderAppList();
    int i1 = 0;
    if (i1 < arrayOfString.length)
    {
      if (paramContext.getPackageName().equalsIgnoreCase(arrayOfString[i1])) {}
      Context localContext;
      label140:
      int i2;
      do
      {
        for (;;)
        {
          i1 += 1;
          break;
          if (e(paramContext, arrayOfString[i1]))
          {
            localContext = b(paramContext, arrayOfString[i1]);
            if (localContext != null)
            {
              if (f(localContext)) {
                break label140;
              }
              TbsLog.e("TbsInstaller", "TbsInstaller--getTbsCoreHostContext " + arrayOfString[i1] + " illegal signature go on next");
            }
          }
        }
        i2 = i(localContext);
        TbsLog.i("TbsInstaller", "TbsInstaller-getTbsCoreHostContext hostTbsCoreVer=" + i2);
      } while ((i2 == 0) || (i2 != paramInt));
      TbsLog.i("TbsInstaller", "TbsInstaller-getTbsCoreHostContext targetApp=" + arrayOfString[i1]);
      return localContext;
    }
    return null;
  }
  
  /* Error */
  public String d(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_2
    //   4: invokestatic 988	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifeq +6 -> 13
    //   10: aload 4
    //   12: areturn
    //   13: new 169	java/io/File
    //   16: dup
    //   17: aload_0
    //   18: aload_1
    //   19: invokevirtual 138	com/tencent/smtt/sdk/n:q	(Landroid/content/Context;)Ljava/io/File;
    //   22: ldc_w 278
    //   25: invokespecial 273	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   28: astore_1
    //   29: aload_1
    //   30: ifnull +12 -> 42
    //   33: aload_1
    //   34: invokevirtual 523	java/io/File:exists	()Z
    //   37: istore_3
    //   38: iload_3
    //   39: ifne +18 -> 57
    //   42: iconst_0
    //   43: ifeq -33 -> 10
    //   46: new 1284	java/lang/NullPointerException
    //   49: dup
    //   50: invokespecial 1285	java/lang/NullPointerException:<init>	()V
    //   53: athrow
    //   54: astore_1
    //   55: aconst_null
    //   56: areturn
    //   57: new 280	java/util/Properties
    //   60: dup
    //   61: invokespecial 281	java/util/Properties:<init>	()V
    //   64: astore 5
    //   66: new 283	java/io/BufferedInputStream
    //   69: dup
    //   70: new 285	java/io/FileInputStream
    //   73: dup
    //   74: aload_1
    //   75: invokespecial 288	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   78: invokespecial 291	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   81: astore_1
    //   82: aload 5
    //   84: aload_1
    //   85: invokevirtual 294	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   88: aload_1
    //   89: invokevirtual 320	java/io/BufferedInputStream:close	()V
    //   92: aload 5
    //   94: aload_2
    //   95: invokevirtual 1288	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   98: astore_2
    //   99: aload_2
    //   100: astore 4
    //   102: aload_1
    //   103: ifnull -93 -> 10
    //   106: aload_1
    //   107: invokevirtual 320	java/io/BufferedInputStream:close	()V
    //   110: aload_2
    //   111: areturn
    //   112: astore_1
    //   113: aload_2
    //   114: areturn
    //   115: astore_1
    //   116: aconst_null
    //   117: astore_1
    //   118: aload_1
    //   119: ifnull -109 -> 10
    //   122: aload_1
    //   123: invokevirtual 320	java/io/BufferedInputStream:close	()V
    //   126: aconst_null
    //   127: areturn
    //   128: astore_1
    //   129: aconst_null
    //   130: areturn
    //   131: astore_2
    //   132: aconst_null
    //   133: astore_1
    //   134: aload_1
    //   135: ifnull +7 -> 142
    //   138: aload_1
    //   139: invokevirtual 320	java/io/BufferedInputStream:close	()V
    //   142: aload_2
    //   143: athrow
    //   144: astore_1
    //   145: goto -3 -> 142
    //   148: astore_2
    //   149: goto -15 -> 134
    //   152: astore_2
    //   153: goto -35 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	this	n
    //   0	156	1	paramContext	Context
    //   0	156	2	paramString	String
    //   37	2	3	bool	boolean
    //   1	100	4	str	String
    //   64	29	5	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   46	54	54	java/io/IOException
    //   106	110	112	java/io/IOException
    //   13	29	115	java/lang/Exception
    //   33	38	115	java/lang/Exception
    //   57	82	115	java/lang/Exception
    //   122	126	128	java/io/IOException
    //   13	29	131	finally
    //   33	38	131	finally
    //   57	82	131	finally
    //   138	142	144	java/io/IOException
    //   82	99	148	finally
    //   82	99	152	java/lang/Exception
  }
  
  /* Error */
  public void d(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: new 169	java/io/File
    //   7: dup
    //   8: aload_0
    //   9: aload_1
    //   10: invokevirtual 138	com/tencent/smtt/sdk/n:q	(Landroid/content/Context;)Ljava/io/File;
    //   13: ldc_w 278
    //   16: invokespecial 273	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   19: astore 5
    //   21: new 280	java/util/Properties
    //   24: dup
    //   25: invokespecial 281	java/util/Properties:<init>	()V
    //   28: astore 4
    //   30: new 283	java/io/BufferedInputStream
    //   33: dup
    //   34: new 285	java/io/FileInputStream
    //   37: dup
    //   38: aload 5
    //   40: invokespecial 288	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   43: invokespecial 291	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   46: astore_1
    //   47: aload 4
    //   49: aload_1
    //   50: invokevirtual 294	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   53: new 296	java/io/BufferedOutputStream
    //   56: dup
    //   57: new 298	java/io/FileOutputStream
    //   60: dup
    //   61: aload 5
    //   63: invokespecial 299	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   66: invokespecial 302	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   69: astore_2
    //   70: aload 4
    //   72: ldc_w 304
    //   75: ldc_w 1533
    //   78: invokevirtual 310	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   81: pop
    //   82: aload 4
    //   84: aload_2
    //   85: aconst_null
    //   86: invokevirtual 314	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   89: aload_2
    //   90: ifnull +7 -> 97
    //   93: aload_2
    //   94: invokevirtual 319	java/io/BufferedOutputStream:close	()V
    //   97: aload_1
    //   98: ifnull +7 -> 105
    //   101: aload_1
    //   102: invokevirtual 320	java/io/BufferedInputStream:close	()V
    //   105: return
    //   106: astore_1
    //   107: aconst_null
    //   108: astore_1
    //   109: aload_1
    //   110: ifnull +7 -> 117
    //   113: aload_1
    //   114: invokevirtual 319	java/io/BufferedOutputStream:close	()V
    //   117: aload_2
    //   118: ifnull -13 -> 105
    //   121: aload_2
    //   122: invokevirtual 320	java/io/BufferedInputStream:close	()V
    //   125: return
    //   126: astore_1
    //   127: return
    //   128: astore_2
    //   129: aconst_null
    //   130: astore_1
    //   131: aload_3
    //   132: ifnull +7 -> 139
    //   135: aload_3
    //   136: invokevirtual 319	java/io/BufferedOutputStream:close	()V
    //   139: aload_1
    //   140: ifnull +7 -> 147
    //   143: aload_1
    //   144: invokevirtual 320	java/io/BufferedInputStream:close	()V
    //   147: aload_2
    //   148: athrow
    //   149: astore_1
    //   150: return
    //   151: astore_2
    //   152: goto -55 -> 97
    //   155: astore_1
    //   156: return
    //   157: astore_1
    //   158: goto -41 -> 117
    //   161: astore_3
    //   162: goto -23 -> 139
    //   165: astore_1
    //   166: goto -19 -> 147
    //   169: astore_2
    //   170: goto -39 -> 131
    //   173: astore 4
    //   175: aload_2
    //   176: astore_3
    //   177: aload 4
    //   179: astore_2
    //   180: goto -49 -> 131
    //   183: astore_2
    //   184: aconst_null
    //   185: astore_3
    //   186: aload_1
    //   187: astore_2
    //   188: aload_3
    //   189: astore_1
    //   190: goto -81 -> 109
    //   193: astore_3
    //   194: aload_1
    //   195: astore_3
    //   196: aload_2
    //   197: astore_1
    //   198: aload_3
    //   199: astore_2
    //   200: goto -91 -> 109
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	203	0	this	n
    //   0	203	1	paramContext	Context
    //   3	119	2	localBufferedOutputStream	java.io.BufferedOutputStream
    //   128	20	2	localObject1	Object
    //   151	1	2	localIOException1	java.io.IOException
    //   169	7	2	localObject2	Object
    //   179	1	2	localObject3	Object
    //   183	1	2	localThrowable1	Throwable
    //   187	13	2	localContext1	Context
    //   1	135	3	localObject4	Object
    //   161	1	3	localIOException2	java.io.IOException
    //   176	13	3	localObject5	Object
    //   193	1	3	localThrowable2	Throwable
    //   195	4	3	localContext2	Context
    //   28	55	4	localProperties	java.util.Properties
    //   173	5	4	localObject6	Object
    //   19	43	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   30	47	106	java/lang/Throwable
    //   121	125	126	java/io/IOException
    //   30	47	128	finally
    //   4	30	149	java/lang/Throwable
    //   93	97	149	java/lang/Throwable
    //   101	105	149	java/lang/Throwable
    //   113	117	149	java/lang/Throwable
    //   121	125	149	java/lang/Throwable
    //   135	139	149	java/lang/Throwable
    //   143	147	149	java/lang/Throwable
    //   147	149	149	java/lang/Throwable
    //   93	97	151	java/io/IOException
    //   101	105	155	java/io/IOException
    //   113	117	157	java/io/IOException
    //   135	139	161	java/io/IOException
    //   143	147	165	java/io/IOException
    //   47	70	169	finally
    //   70	89	173	finally
    //   47	70	183	java/lang/Throwable
    //   70	89	193	java/lang/Throwable
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
    if (TbsShareManager.getHostCorePathAppDefined() != null) {}
    for (;;)
    {
      return true;
      try
      {
        Signature localSignature = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 64).signatures[0];
        if (paramContext.getPackageName().equals("com.tencent.mtt"))
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
          boolean bool = localSignature.toCharsString().equals("30820239308201a2a00302010202044c96f48f300d06092a864886f70d01010505003060310b300906035504061302434e310b300906035504081302474431123010060355040713094775616e677a686f753110300e060355040a130754656e63656e74310b3009060355040b130233473111300f0603550403130857696c736f6e57753020170d3130303932303035343334335a180f32303635303632333035343334335a3060310b300906035504061302434e310b300906035504081302474431123010060355040713094775616e677a686f753110300e060355040a130754656e63656e74310b3009060355040b130233473111300f0603550403130857696c736f6e577530819f300d06092a864886f70d010101050003818d0030818902818100b56e79dbb1185a79e52d792bb3d0bb3da8010d9b87da92ec69f7dc5ad66ab6bfdff2a6a1ed285dd2358f28b72a468be7c10a2ce30c4c27323ed4edcc936080e5bedc2cbbca0b7e879c08a631182793f44bb3ea284179b263410c298e5f6831032c9702ba4a74e2ccfc9ef857f12201451602fc8e774ac59d6398511586c83d1d0203010001300d06092a864886f70d0101050500038181002475615bb65b8d8786b890535802948840387d06b1692ff3ea47ef4c435719ba1865b81e6bfa6293ce31747c3cd6b34595b485cc1563fd90107ba5845c28b95c79138f0dec288940395bc10f92f2b69d8dc410999deb38900974ce9984b678030edfba8816582f56160d87e38641288d8588d2a31e20b89f223d788dd35cc9c8");
          if (!bool) {
            return false;
          }
        }
      }
      catch (Exception paramContext)
      {
        TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore getPackageInfo fail");
      }
    }
    return false;
  }
  
  public void g(Context paramContext)
  {
    int i1 = 1;
    try
    {
      boolean bool = TbsDownloadConfig.getInstance().getTbsCoreLoadRenameFileLockEnable();
      i1 = bool;
    }
    catch (Throwable localThrowable)
    {
      label11:
      break label11;
    }
    if (i1 == 0) {}
    while (l == null) {
      return;
    }
    FileUtil.a(paramContext, l);
  }
  
  boolean g(Context paramContext, int paramInt)
  {
    for (;;)
    {
      boolean bool;
      int i1;
      try
      {
        bool = TbsShareManager.isThirdPartyApp(paramContext);
        if (bool)
        {
          if (TbsShareManager.j(paramContext))
          {
            localFile = new File(TbsShareManager.c(paramContext));
            if (!localFile.getAbsolutePath().contains("com.tencent.tbs")) {
              break label286;
            }
            return true;
          }
          TbsLog.e("TbsInstaller", "321");
          return false;
        }
        File localFile = q(paramContext);
        if (localFile == null) {
          break label276;
        }
        Long[][] arrayOfLong1 = n;
        int i2 = arrayOfLong1.length;
        i1 = 0;
        if (i1 >= i2) {
          break label289;
        }
        Long[] arrayOfLong = arrayOfLong1[i1];
        if (paramInt != arrayOfLong[0].intValue()) {
          break label291;
        }
        localFile = new File(localFile, "libmttwebview.so");
        if ((localFile != null) && (localFile.exists()) && (localFile.length() == arrayOfLong[1].longValue()))
        {
          TbsLog.d("TbsInstaller", "check so success: " + paramInt + "; file: " + localFile);
          return true;
        }
      }
      catch (Throwable paramContext)
      {
        TbsLog.e("TbsInstaller", "ISTBSCORELEGAL exception getMessage is " + paramContext.getMessage());
        TbsLog.e("TbsInstaller", "ISTBSCORELEGAL exception getCause is " + paramContext.getCause());
        return false;
      }
      if (!bool) {
        FileUtil.b(QbSdk.getTbsFolderDir(paramContext));
      }
      a.set(Integer.valueOf(0));
      TbsLog.e("TbsInstaller", "322");
      return false;
      label276:
      TbsLog.e("TbsInstaller", "323");
      return false;
      label286:
      continue;
      label289:
      return true;
      label291:
      i1 += 1;
    }
  }
  
  /* Error */
  int h(Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aconst_null
    //   3: astore 5
    //   5: new 169	java/io/File
    //   8: dup
    //   9: aload_0
    //   10: aload_1
    //   11: invokevirtual 491	com/tencent/smtt/sdk/n:p	(Landroid/content/Context;)Ljava/io/File;
    //   14: ldc_w 278
    //   17: invokespecial 273	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   20: astore_1
    //   21: aload_1
    //   22: ifnull +14 -> 36
    //   25: aload_1
    //   26: invokevirtual 523	java/io/File:exists	()Z
    //   29: istore 4
    //   31: iload 4
    //   33: ifne +17 -> 50
    //   36: iconst_0
    //   37: ifeq +11 -> 48
    //   40: new 1284	java/lang/NullPointerException
    //   43: dup
    //   44: invokespecial 1285	java/lang/NullPointerException:<init>	()V
    //   47: athrow
    //   48: iload_3
    //   49: ireturn
    //   50: new 280	java/util/Properties
    //   53: dup
    //   54: invokespecial 281	java/util/Properties:<init>	()V
    //   57: astore 6
    //   59: new 283	java/io/BufferedInputStream
    //   62: dup
    //   63: new 285	java/io/FileInputStream
    //   66: dup
    //   67: aload_1
    //   68: invokespecial 288	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   71: invokespecial 291	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   74: astore_1
    //   75: aload 6
    //   77: aload_1
    //   78: invokevirtual 294	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   81: aload_1
    //   82: invokevirtual 320	java/io/BufferedInputStream:close	()V
    //   85: aload 6
    //   87: ldc_w 1287
    //   90: invokevirtual 1288	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   93: astore 5
    //   95: aload 5
    //   97: ifnonnull +16 -> 113
    //   100: aload_1
    //   101: ifnull -53 -> 48
    //   104: aload_1
    //   105: invokevirtual 320	java/io/BufferedInputStream:close	()V
    //   108: iconst_0
    //   109: ireturn
    //   110: astore_1
    //   111: iconst_0
    //   112: ireturn
    //   113: aload 5
    //   115: invokestatic 1291	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   118: istore_2
    //   119: iload_2
    //   120: istore_3
    //   121: aload_1
    //   122: ifnull -74 -> 48
    //   125: aload_1
    //   126: invokevirtual 320	java/io/BufferedInputStream:close	()V
    //   129: iload_2
    //   130: ireturn
    //   131: astore_1
    //   132: iload_2
    //   133: ireturn
    //   134: astore_1
    //   135: aconst_null
    //   136: astore_1
    //   137: aload_1
    //   138: ifnull -90 -> 48
    //   141: aload_1
    //   142: invokevirtual 320	java/io/BufferedInputStream:close	()V
    //   145: iconst_0
    //   146: ireturn
    //   147: astore_1
    //   148: iconst_0
    //   149: ireturn
    //   150: astore_1
    //   151: aload 5
    //   153: ifnull +8 -> 161
    //   156: aload 5
    //   158: invokevirtual 320	java/io/BufferedInputStream:close	()V
    //   161: aload_1
    //   162: athrow
    //   163: astore_1
    //   164: iconst_0
    //   165: ireturn
    //   166: astore 5
    //   168: goto -7 -> 161
    //   171: astore 6
    //   173: aload_1
    //   174: astore 5
    //   176: aload 6
    //   178: astore_1
    //   179: goto -28 -> 151
    //   182: astore 5
    //   184: goto -47 -> 137
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	187	0	this	n
    //   0	187	1	paramContext	Context
    //   118	15	2	i1	int
    //   1	120	3	i2	int
    //   29	3	4	bool	boolean
    //   3	154	5	str	String
    //   166	1	5	localIOException	java.io.IOException
    //   174	1	5	localContext	Context
    //   182	1	5	localException	Exception
    //   57	29	6	localProperties	java.util.Properties
    //   171	6	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   104	108	110	java/io/IOException
    //   125	129	131	java/io/IOException
    //   5	21	134	java/lang/Exception
    //   25	31	134	java/lang/Exception
    //   50	75	134	java/lang/Exception
    //   141	145	147	java/io/IOException
    //   5	21	150	finally
    //   25	31	150	finally
    //   50	75	150	finally
    //   40	48	163	java/io/IOException
    //   156	161	166	java/io/IOException
    //   75	95	171	finally
    //   113	119	171	finally
    //   75	95	182	java/lang/Exception
    //   113	119	182	java/lang/Exception
  }
  
  /* Error */
  int i(Context paramContext)
  {
    // Byte code:
    //   0: new 169	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: aload_1
    //   6: invokevirtual 138	com/tencent/smtt/sdk/n:q	(Landroid/content/Context;)Ljava/io/File;
    //   9: ldc_w 278
    //   12: invokespecial 273	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +12 -> 29
    //   20: aload_1
    //   21: invokevirtual 523	java/io/File:exists	()Z
    //   24: istore_3
    //   25: iload_3
    //   26: ifne +48 -> 74
    //   29: iconst_0
    //   30: ifeq +11 -> 41
    //   33: new 1284	java/lang/NullPointerException
    //   36: dup
    //   37: invokespecial 1285	java/lang/NullPointerException:<init>	()V
    //   40: athrow
    //   41: iconst_0
    //   42: ireturn
    //   43: astore_1
    //   44: ldc 127
    //   46: new 151	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   53: ldc_w 1638
    //   56: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: aload_1
    //   60: invokevirtual 1639	java/io/IOException:toString	()Ljava/lang/String;
    //   63: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: iconst_0
    //   73: ireturn
    //   74: new 280	java/util/Properties
    //   77: dup
    //   78: invokespecial 281	java/util/Properties:<init>	()V
    //   81: astore 5
    //   83: new 283	java/io/BufferedInputStream
    //   86: dup
    //   87: new 285	java/io/FileInputStream
    //   90: dup
    //   91: aload_1
    //   92: invokespecial 288	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   95: invokespecial 291	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   98: astore 4
    //   100: aload 4
    //   102: astore_1
    //   103: aload 5
    //   105: aload 4
    //   107: invokevirtual 294	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   110: aload 4
    //   112: astore_1
    //   113: aload 4
    //   115: invokevirtual 320	java/io/BufferedInputStream:close	()V
    //   118: aload 4
    //   120: astore_1
    //   121: aload 5
    //   123: ldc_w 1287
    //   126: invokevirtual 1288	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   129: astore 5
    //   131: aload 5
    //   133: ifnonnull +46 -> 179
    //   136: aload 4
    //   138: ifnull -97 -> 41
    //   141: aload 4
    //   143: invokevirtual 320	java/io/BufferedInputStream:close	()V
    //   146: iconst_0
    //   147: ireturn
    //   148: astore_1
    //   149: ldc 127
    //   151: new 151	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   158: ldc_w 1638
    //   161: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: aload_1
    //   165: invokevirtual 1639	java/io/IOException:toString	()Ljava/lang/String;
    //   168: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   177: iconst_0
    //   178: ireturn
    //   179: aload 4
    //   181: astore_1
    //   182: aload 5
    //   184: invokestatic 1291	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   187: istore_2
    //   188: aload 4
    //   190: astore_1
    //   191: getstatic 99	com/tencent/smtt/sdk/n:o	I
    //   194: ifne +10 -> 204
    //   197: aload 4
    //   199: astore_1
    //   200: iload_2
    //   201: putstatic 99	com/tencent/smtt/sdk/n:o	I
    //   204: aload 4
    //   206: ifnull +8 -> 214
    //   209: aload 4
    //   211: invokevirtual 320	java/io/BufferedInputStream:close	()V
    //   214: iload_2
    //   215: ireturn
    //   216: astore_1
    //   217: ldc 127
    //   219: new 151	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   226: ldc_w 1638
    //   229: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: aload_1
    //   233: invokevirtual 1639	java/io/IOException:toString	()Ljava/lang/String;
    //   236: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   245: goto -31 -> 214
    //   248: astore 5
    //   250: aconst_null
    //   251: astore 4
    //   253: aload 4
    //   255: astore_1
    //   256: ldc 127
    //   258: new 151	java/lang/StringBuilder
    //   261: dup
    //   262: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   265: ldc_w 1641
    //   268: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: aload 5
    //   273: invokevirtual 543	java/lang/Exception:toString	()Ljava/lang/String;
    //   276: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   282: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   285: aload 4
    //   287: ifnull -246 -> 41
    //   290: aload 4
    //   292: invokevirtual 320	java/io/BufferedInputStream:close	()V
    //   295: iconst_0
    //   296: ireturn
    //   297: astore_1
    //   298: ldc 127
    //   300: new 151	java/lang/StringBuilder
    //   303: dup
    //   304: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   307: ldc_w 1638
    //   310: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: aload_1
    //   314: invokevirtual 1639	java/io/IOException:toString	()Ljava/lang/String;
    //   317: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   323: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   326: iconst_0
    //   327: ireturn
    //   328: astore 4
    //   330: aconst_null
    //   331: astore_1
    //   332: aload_1
    //   333: ifnull +7 -> 340
    //   336: aload_1
    //   337: invokevirtual 320	java/io/BufferedInputStream:close	()V
    //   340: aload 4
    //   342: athrow
    //   343: astore_1
    //   344: ldc 127
    //   346: new 151	java/lang/StringBuilder
    //   349: dup
    //   350: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   353: ldc_w 1638
    //   356: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: aload_1
    //   360: invokevirtual 1639	java/io/IOException:toString	()Ljava/lang/String;
    //   363: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   369: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   372: goto -32 -> 340
    //   375: astore 4
    //   377: goto -45 -> 332
    //   380: astore 5
    //   382: goto -129 -> 253
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	385	0	this	n
    //   0	385	1	paramContext	Context
    //   187	28	2	i1	int
    //   24	2	3	bool	boolean
    //   98	193	4	localBufferedInputStream	java.io.BufferedInputStream
    //   328	13	4	localObject1	Object
    //   375	1	4	localObject2	Object
    //   81	102	5	localObject3	Object
    //   248	24	5	localException1	Exception
    //   380	1	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   33	41	43	java/io/IOException
    //   141	146	148	java/io/IOException
    //   209	214	216	java/io/IOException
    //   0	16	248	java/lang/Exception
    //   20	25	248	java/lang/Exception
    //   74	100	248	java/lang/Exception
    //   290	295	297	java/io/IOException
    //   0	16	328	finally
    //   20	25	328	finally
    //   74	100	328	finally
    //   336	340	343	java/io/IOException
    //   103	110	375	finally
    //   113	118	375	finally
    //   121	131	375	finally
    //   182	188	375	finally
    //   191	197	375	finally
    //   200	204	375	finally
    //   256	285	375	finally
    //   103	110	380	java/lang/Exception
    //   113	118	380	java/lang/Exception
    //   121	131	380	java/lang/Exception
    //   182	188	380	java/lang/Exception
    //   191	197	380	java/lang/Exception
    //   200	204	380	java/lang/Exception
  }
  
  int j(Context paramContext)
  {
    if (o != 0) {
      return o;
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
    paramContext = new File(q(paramContext), "tbs.conf");
    return (paramContext != null) && (paramContext.exists());
  }
  
  /* Error */
  int m(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 405	com/tencent/smtt/sdk/n:t	(Landroid/content/Context;)Z
    //   5: ifne +5 -> 10
    //   8: iconst_m1
    //   9: ireturn
    //   10: getstatic 43	com/tencent/smtt/sdk/n:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   13: invokevirtual 1046	java/util/concurrent/locks/ReentrantLock:tryLock	()Z
    //   16: istore_3
    //   17: ldc 127
    //   19: new 151	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   26: ldc_w 1643
    //   29: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: iload_3
    //   33: invokevirtual 178	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   36: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   42: iload_3
    //   43: ifeq +629 -> 672
    //   46: new 169	java/io/File
    //   49: dup
    //   50: aload_0
    //   51: aload_1
    //   52: invokevirtual 138	com/tencent/smtt/sdk/n:q	(Landroid/content/Context;)Ljava/io/File;
    //   55: ldc_w 278
    //   58: invokespecial 273	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   61: astore_1
    //   62: aload_1
    //   63: ifnull +12 -> 75
    //   66: aload_1
    //   67: invokevirtual 523	java/io/File:exists	()Z
    //   70: istore_3
    //   71: iload_3
    //   72: ifne +97 -> 169
    //   75: iconst_0
    //   76: ifeq +11 -> 87
    //   79: new 1284	java/lang/NullPointerException
    //   82: dup
    //   83: invokespecial 1285	java/lang/NullPointerException:<init>	()V
    //   86: athrow
    //   87: getstatic 43	com/tencent/smtt/sdk/n:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   90: invokevirtual 1646	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   93: ifeq +9 -> 102
    //   96: getstatic 43	com/tencent/smtt/sdk/n:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   99: invokevirtual 435	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   102: aload_0
    //   103: invokevirtual 438	com/tencent/smtt/sdk/n:b	()V
    //   106: iconst_0
    //   107: ireturn
    //   108: astore_1
    //   109: ldc 127
    //   111: new 151	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   118: ldc_w 1648
    //   121: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: aload_1
    //   125: invokevirtual 1639	java/io/IOException:toString	()Ljava/lang/String;
    //   128: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   137: goto -50 -> 87
    //   140: astore_1
    //   141: ldc 127
    //   143: new 151	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   150: ldc_w 1650
    //   153: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: aload_1
    //   157: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 346	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   166: goto -64 -> 102
    //   169: new 280	java/util/Properties
    //   172: dup
    //   173: invokespecial 281	java/util/Properties:<init>	()V
    //   176: astore 5
    //   178: new 283	java/io/BufferedInputStream
    //   181: dup
    //   182: new 285	java/io/FileInputStream
    //   185: dup
    //   186: aload_1
    //   187: invokespecial 288	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   190: invokespecial 291	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   193: astore 4
    //   195: aload 4
    //   197: astore_1
    //   198: aload 5
    //   200: aload 4
    //   202: invokevirtual 294	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   205: aload 4
    //   207: astore_1
    //   208: aload 4
    //   210: invokevirtual 320	java/io/BufferedInputStream:close	()V
    //   213: aload 4
    //   215: astore_1
    //   216: aload 5
    //   218: ldc_w 1287
    //   221: invokevirtual 1288	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   224: astore 5
    //   226: aload 5
    //   228: ifnonnull +95 -> 323
    //   231: aload 4
    //   233: ifnull +8 -> 241
    //   236: aload 4
    //   238: invokevirtual 320	java/io/BufferedInputStream:close	()V
    //   241: getstatic 43	com/tencent/smtt/sdk/n:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   244: invokevirtual 1646	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   247: ifeq +9 -> 256
    //   250: getstatic 43	com/tencent/smtt/sdk/n:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   253: invokevirtual 435	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   256: aload_0
    //   257: invokevirtual 438	com/tencent/smtt/sdk/n:b	()V
    //   260: iconst_0
    //   261: ireturn
    //   262: astore_1
    //   263: ldc 127
    //   265: new 151	java/lang/StringBuilder
    //   268: dup
    //   269: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   272: ldc_w 1648
    //   275: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: aload_1
    //   279: invokevirtual 1639	java/io/IOException:toString	()Ljava/lang/String;
    //   282: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   288: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   291: goto -50 -> 241
    //   294: astore_1
    //   295: ldc 127
    //   297: new 151	java/lang/StringBuilder
    //   300: dup
    //   301: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   304: ldc_w 1650
    //   307: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: aload_1
    //   311: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   314: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   317: invokestatic 346	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   320: goto -64 -> 256
    //   323: aload 4
    //   325: astore_1
    //   326: getstatic 52	com/tencent/smtt/sdk/n:a	Ljava/lang/ThreadLocal;
    //   329: aload 5
    //   331: invokestatic 1291	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   334: invokestatic 1244	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   337: invokevirtual 1250	java/lang/ThreadLocal:set	(Ljava/lang/Object;)V
    //   340: aload 4
    //   342: astore_1
    //   343: getstatic 52	com/tencent/smtt/sdk/n:a	Ljava/lang/ThreadLocal;
    //   346: invokevirtual 1295	java/lang/ThreadLocal:get	()Ljava/lang/Object;
    //   349: checkcast 1241	java/lang/Integer
    //   352: invokevirtual 1298	java/lang/Integer:intValue	()I
    //   355: istore_2
    //   356: aload 4
    //   358: ifnull +8 -> 366
    //   361: aload 4
    //   363: invokevirtual 320	java/io/BufferedInputStream:close	()V
    //   366: getstatic 43	com/tencent/smtt/sdk/n:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   369: invokevirtual 1646	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   372: ifeq +9 -> 381
    //   375: getstatic 43	com/tencent/smtt/sdk/n:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   378: invokevirtual 435	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   381: aload_0
    //   382: invokevirtual 438	com/tencent/smtt/sdk/n:b	()V
    //   385: iload_2
    //   386: ireturn
    //   387: astore_1
    //   388: ldc 127
    //   390: new 151	java/lang/StringBuilder
    //   393: dup
    //   394: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   397: ldc_w 1648
    //   400: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: aload_1
    //   404: invokevirtual 1639	java/io/IOException:toString	()Ljava/lang/String;
    //   407: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   413: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   416: goto -50 -> 366
    //   419: astore_1
    //   420: ldc 127
    //   422: new 151	java/lang/StringBuilder
    //   425: dup
    //   426: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   429: ldc_w 1650
    //   432: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: aload_1
    //   436: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   439: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   442: invokestatic 346	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   445: goto -64 -> 381
    //   448: astore 5
    //   450: aconst_null
    //   451: astore 4
    //   453: aload 4
    //   455: astore_1
    //   456: ldc 127
    //   458: new 151	java/lang/StringBuilder
    //   461: dup
    //   462: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   465: ldc_w 1652
    //   468: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: aload 5
    //   473: invokevirtual 543	java/lang/Exception:toString	()Ljava/lang/String;
    //   476: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   482: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   485: aload 4
    //   487: ifnull +8 -> 495
    //   490: aload 4
    //   492: invokevirtual 320	java/io/BufferedInputStream:close	()V
    //   495: getstatic 43	com/tencent/smtt/sdk/n:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   498: invokevirtual 1646	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   501: ifeq +9 -> 510
    //   504: getstatic 43	com/tencent/smtt/sdk/n:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   507: invokevirtual 435	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   510: aload_0
    //   511: invokevirtual 438	com/tencent/smtt/sdk/n:b	()V
    //   514: iconst_0
    //   515: ireturn
    //   516: astore_1
    //   517: ldc 127
    //   519: new 151	java/lang/StringBuilder
    //   522: dup
    //   523: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   526: ldc_w 1648
    //   529: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: aload_1
    //   533: invokevirtual 1639	java/io/IOException:toString	()Ljava/lang/String;
    //   536: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   539: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   542: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   545: goto -50 -> 495
    //   548: astore_1
    //   549: ldc 127
    //   551: new 151	java/lang/StringBuilder
    //   554: dup
    //   555: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   558: ldc_w 1650
    //   561: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   564: aload_1
    //   565: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   568: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   571: invokestatic 346	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   574: goto -64 -> 510
    //   577: astore 4
    //   579: aconst_null
    //   580: astore_1
    //   581: aload_1
    //   582: ifnull +7 -> 589
    //   585: aload_1
    //   586: invokevirtual 320	java/io/BufferedInputStream:close	()V
    //   589: getstatic 43	com/tencent/smtt/sdk/n:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   592: invokevirtual 1646	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   595: ifeq +9 -> 604
    //   598: getstatic 43	com/tencent/smtt/sdk/n:i	Ljava/util/concurrent/locks/ReentrantLock;
    //   601: invokevirtual 435	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   604: aload_0
    //   605: invokevirtual 438	com/tencent/smtt/sdk/n:b	()V
    //   608: aload 4
    //   610: athrow
    //   611: astore_1
    //   612: ldc 127
    //   614: new 151	java/lang/StringBuilder
    //   617: dup
    //   618: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   621: ldc_w 1648
    //   624: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   627: aload_1
    //   628: invokevirtual 1639	java/io/IOException:toString	()Ljava/lang/String;
    //   631: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   634: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   637: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   640: goto -51 -> 589
    //   643: astore_1
    //   644: ldc 127
    //   646: new 151	java/lang/StringBuilder
    //   649: dup
    //   650: invokespecial 152	java/lang/StringBuilder:<init>	()V
    //   653: ldc_w 1650
    //   656: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   659: aload_1
    //   660: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   663: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   666: invokestatic 346	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   669: goto -65 -> 604
    //   672: aload_0
    //   673: invokevirtual 438	com/tencent/smtt/sdk/n:b	()V
    //   676: iconst_0
    //   677: ireturn
    //   678: astore 4
    //   680: goto -99 -> 581
    //   683: astore 5
    //   685: goto -232 -> 453
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	688	0	this	n
    //   0	688	1	paramContext	Context
    //   355	31	2	i1	int
    //   16	56	3	bool	boolean
    //   193	298	4	localBufferedInputStream	java.io.BufferedInputStream
    //   577	32	4	localObject1	Object
    //   678	1	4	localObject2	Object
    //   176	154	5	localObject3	Object
    //   448	24	5	localException1	Exception
    //   683	1	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   79	87	108	java/io/IOException
    //   87	102	140	java/lang/Throwable
    //   236	241	262	java/io/IOException
    //   241	256	294	java/lang/Throwable
    //   361	366	387	java/io/IOException
    //   366	381	419	java/lang/Throwable
    //   46	62	448	java/lang/Exception
    //   66	71	448	java/lang/Exception
    //   169	195	448	java/lang/Exception
    //   490	495	516	java/io/IOException
    //   495	510	548	java/lang/Throwable
    //   46	62	577	finally
    //   66	71	577	finally
    //   169	195	577	finally
    //   585	589	611	java/io/IOException
    //   589	604	643	java/lang/Throwable
    //   198	205	678	finally
    //   208	213	678	finally
    //   216	226	678	finally
    //   326	340	678	finally
    //   343	356	678	finally
    //   456	485	678	finally
    //   198	205	683	java/lang/Exception
    //   208	213	683	java/lang/Exception
    //   216	226	683	java/lang/Exception
    //   326	340	683	java/lang/Exception
    //   343	356	683	java/lang/Exception
  }
  
  public boolean n(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--coreShareCopyToDecouple #0");
    File localFile1 = q(paramContext);
    File localFile2 = p(paramContext);
    try
    {
      FileUtil.a(localFile2, true);
      FileUtil.a(localFile1, localFile2, new n.5(this));
      TbsShareManager.b(paramContext);
      TbsLog.i("TbsInstaller", "TbsInstaller--coreShareCopyToDecouple success!!!");
      return true;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  void o(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--cleanStatusAndTmpDir");
    k.a(paramContext).a(0);
    k.a(paramContext).b(0);
    k.a(paramContext).d(0);
    k.a(paramContext).a("incrupdate_retry_num", 0);
    if (!TbsDownloader.a(paramContext))
    {
      k.a(paramContext).c(0, -1);
      k.a(paramContext).a("");
      k.a(paramContext).a("copy_retry_num", 0);
      k.a(paramContext).c(-1);
      k.a(paramContext).a(0, -1);
      FileUtil.a(f(paramContext, 0), true);
      FileUtil.a(f(paramContext, 1), true);
    }
  }
  
  File p(Context paramContext)
  {
    paramContext = new File(QbSdk.getTbsFolderDir(paramContext), "core_share_decouple");
    if ((paramContext == null) || ((!paramContext.isDirectory()) && (!paramContext.mkdir()))) {
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
    if ((paramContext == null) || ((!paramContext.isDirectory()) && (!paramContext.mkdir()))) {
      return null;
    }
    return paramContext;
  }
  
  /* Error */
  boolean t(Context paramContext)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 105	com/tencent/smtt/sdk/n:e	I
    //   8: ifle +25 -> 33
    //   11: ldc 127
    //   13: ldc_w 1668
    //   16: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: aload_0
    //   20: aload_0
    //   21: getfield 105	com/tencent/smtt/sdk/n:e	I
    //   24: iconst_1
    //   25: iadd
    //   26: putfield 105	com/tencent/smtt/sdk/n:e	I
    //   29: aload_0
    //   30: monitorexit
    //   31: iload_2
    //   32: ireturn
    //   33: aload_0
    //   34: aload_1
    //   35: iconst_1
    //   36: ldc_w 1670
    //   39: invokestatic 1673	com/tencent/smtt/utils/FileUtil:b	(Landroid/content/Context;ZLjava/lang/String;)Ljava/io/FileOutputStream;
    //   42: putfield 1422	com/tencent/smtt/sdk/n:g	Ljava/io/FileOutputStream;
    //   45: aload_0
    //   46: getfield 1422	com/tencent/smtt/sdk/n:g	Ljava/io/FileOutputStream;
    //   49: ifnull +35 -> 84
    //   52: aload_0
    //   53: aload_1
    //   54: aload_0
    //   55: getfield 1422	com/tencent/smtt/sdk/n:g	Ljava/io/FileOutputStream;
    //   58: invokestatic 1676	com/tencent/smtt/utils/FileUtil:a	(Landroid/content/Context;Ljava/io/FileOutputStream;)Ljava/nio/channels/FileLock;
    //   61: putfield 1420	com/tencent/smtt/sdk/n:f	Ljava/nio/channels/FileLock;
    //   64: aload_0
    //   65: getfield 1420	com/tencent/smtt/sdk/n:f	Ljava/nio/channels/FileLock;
    //   68: ifnonnull +29 -> 97
    //   71: ldc 127
    //   73: ldc_w 1678
    //   76: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   79: iconst_0
    //   80: istore_2
    //   81: goto -52 -> 29
    //   84: ldc 127
    //   86: ldc_w 1680
    //   89: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: iconst_0
    //   93: istore_2
    //   94: goto -65 -> 29
    //   97: ldc 127
    //   99: ldc_w 1682
    //   102: invokestatic 134	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   105: aload_0
    //   106: aload_0
    //   107: getfield 105	com/tencent/smtt/sdk/n:e	I
    //   110: iconst_1
    //   111: iadd
    //   112: putfield 105	com/tencent/smtt/sdk/n:e	I
    //   115: goto -86 -> 29
    //   118: astore_1
    //   119: aload_0
    //   120: monitorexit
    //   121: aload_1
    //   122: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	this	n
    //   0	123	1	paramContext	Context
    //   1	93	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   4	29	118	finally
    //   33	79	118	finally
    //   84	92	118	finally
    //   97	115	118	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.n
 * JD-Core Version:    0.7.0.1
 */