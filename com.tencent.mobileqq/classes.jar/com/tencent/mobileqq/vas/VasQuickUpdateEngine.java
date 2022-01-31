package com.tencent.mobileqq.vas;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.mobileqq.transfile.predownload.RunnableTask;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.open.base.BspatchUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

public class VasQuickUpdateEngine
{
  public static final String ENGINE_CONFIG_PATH = BaseApplicationImpl.getApplication().getFilesDir().getAbsolutePath() + File.separator + "quickupdate";
  public static final int LOAD_SO_MAX_RETRY_TIME = 2;
  private static final String TAG = "VasQuickUpdateEngine";
  private static final String TAG_NATIVE = "VasQuickUpdateEngine_Native";
  public static AtomicBoolean hasSoLoaded = new AtomicBoolean(false);
  public static AtomicBoolean isSoLoadFail = new AtomicBoolean(false);
  public static int loadSoRetryTime;
  private static VasQuickUpdateEngine mInstance;
  Vector downloadList = new Vector();
  AtomicBoolean hasRegistered = new AtomicBoolean(false);
  public AtomicBoolean isEngineInit = new AtomicBoolean(false);
  public Map mBusinessCallbackList = new HashMap();
  public VasQuickUpdateEngine.QuickUpdateBusinessCallback mDefaultCallback;
  public VasQuickUpdateEngine.QuickUpdateListener mDefaultListener;
  public VasExtensionHandler mExtensionHandler;
  public Map mUpdateListenerList = new HashMap();
  public long mUpdateManagerInstance;
  
  private VasQuickUpdateEngine()
  {
    loadSo();
  }
  
  public static void QuickUpdateLog(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("VasQuickUpdateEngine_Native", 2, paramString);
      }
      break;
    }
    do
    {
      do
      {
        do
        {
          return;
          QLog.e("VasQuickUpdateEngine_Native", 1, paramString);
          return;
        } while (!QLog.isColorLevel());
        QLog.w("VasQuickUpdateEngine_Native", 2, paramString);
        return;
      } while (!QLog.isColorLevel());
      QLog.i("VasQuickUpdateEngine_Native", 2, paramString);
      return;
    } while (!QLog.isColorLevel());
    QLog.d("VasQuickUpdateEngine_Native", 2, paramString);
  }
  
  private boolean bsPatch(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasQuickUpdateEngine", 2, "bsPatch: srcFile = " + paramString1 + " patchFile = " + paramString2);
    }
    return BspatchUtil.a(paramString1, paramString2, paramString1);
  }
  
  public static VasQuickUpdateEngine getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new VasQuickUpdateEngine();
      }
      VasQuickUpdateEngine localVasQuickUpdateEngine = mInstance;
      return localVasQuickUpdateEngine;
    }
    finally {}
  }
  
  private int getNetType()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasQuickUpdateEngine", 2, "getNetType");
    }
    int j = HttpUtil.a();
    int i = j;
    if (j == 5) {
      i = 1;
    }
    return i + 1;
  }
  
  private boolean isFileExists(long paramLong, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasQuickUpdateEngine", 2, "isFileExists bid = " + paramLong + " scid = " + paramString);
    }
    VasQuickUpdateEngine.QuickUpdateBusinessCallback localQuickUpdateBusinessCallback = this.mDefaultCallback;
    if (this.mBusinessCallbackList.containsKey(Long.valueOf(paramLong))) {
      localQuickUpdateBusinessCallback = (VasQuickUpdateEngine.QuickUpdateBusinessCallback)this.mBusinessCallbackList.get(Long.valueOf(paramLong));
    }
    return (localQuickUpdateBusinessCallback != null) && (localQuickUpdateBusinessCallback.isFileExists(paramLong, paramString));
  }
  
  private boolean loadSo()
  {
    boolean bool = true;
    try
    {
      if ((!hasSoLoaded.get()) || (isSoLoadFail.get()))
      {
        ThreadManager.post(new VasQuickUpdateEngine.1(this), 8, null, true);
        if (QLog.isColorLevel()) {
          QLog.d("VasQuickUpdateEngine", 2, "async loadso");
        }
        bool = false;
      }
      return bool;
    }
    finally {}
  }
  
  private void onPreloadDownloadComplete(String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VasQuickUpdateEngine", 2, "onPreloadDownloadComplete url = " + paramString + " fileSize = " + paramLong);
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface))
    {
      ((PreDownloadController)((QQAppInterface)localAppRuntime).getManager(192)).a(paramString, paramLong);
      return;
    }
    QLog.e("VasQuickUpdateEngine", 1, "onPreloadDownloadComplete app is not QQAppInterface");
  }
  
  private void onPreloadDownloadStart(String paramString1, String paramString2, String paramString3, long paramLong, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VasQuickUpdateEngine", 2, "onPreloadDownloadStart");
    }
    paramString4 = new VasQuickUpdateEngine.2(this, paramString1, paramString2, paramString3, paramLong, paramString4);
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)localObject;
      localObject = (PreDownloadController)localQQAppInterface.getManager(192);
      paramString4 = new RunnableTask(localQQAppInterface, paramString1, paramString4, 4000L);
      ((PreDownloadController)localObject).a(10019, "vas", paramString1, ((Integer)PreDownloadConstants.c.get(Integer.valueOf(10019))).intValue(), paramString2, paramString3, 2, 0, true, paramString4);
      return;
    }
    QLog.e("VasQuickUpdateEngine", 1, "onPreloadDownloadStart app is not QQAppInterface");
    paramString4.run();
  }
  
  private void recordFlowBytes(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasQuickUpdateEngine", 2, "recordFlowBytes nBytes = " + paramInt1 + " netType = " + paramInt2);
    }
    int i = paramInt2 - 1;
    paramInt2 = i;
    if (i == 5) {
      paramInt2 = 0;
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().waitAppRuntime(null);
    String str = localAppRuntime.getAccount();
    if ((localAppRuntime instanceof AppInterface)) {
      ((AppInterface)localAppRuntime).sendAppDataIncerment(str, false, paramInt2, 0, 8999, paramInt1);
    }
  }
  
  private void reportDLEvent(int paramInt1, long paramLong, String paramString1, String paramString2, boolean paramBoolean, int paramInt2, int paramInt3, int paramInt4, String paramString3, String paramString4, String paramString5)
  {
    VasWebviewUtil.reportQuickUpdateDownload(paramInt1, paramLong, paramString1, paramString2, paramBoolean, paramInt2, paramInt3, paramInt4, paramString3, paramString4, paramString5);
  }
  
  private void reportSTEvent(long paramLong, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, String paramString4, String paramString5)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasQuickUpdateEngine", 2, "reportSTEvent:");
    }
    VasWebviewUtil.reportQuickUpdateST(paramLong, paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramString3, paramString4, paramString5);
  }
  
  public static boolean safeDeleteFile(File paramFile)
  {
    if (!paramFile.exists()) {
      return true;
    }
    if (paramFile.isDirectory())
    {
      localObject = paramFile.listFiles();
      if (localObject != null)
      {
        int i = 0;
        while (i < localObject.length)
        {
          safeDeleteFile(localObject[i]);
          i += 1;
        }
      }
    }
    Object localObject = new File(paramFile.getParent() + File.separator + System.currentTimeMillis());
    paramFile.renameTo((File)localObject);
    return ((File)localObject).delete();
  }
  
  private boolean sendPbMsg(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasQuickUpdateEngine", 2, "sendPbMsg: cmd = " + paramString1 + " buff = " + paramString2);
    }
    if (this.mExtensionHandler != null) {
      return this.mExtensionHandler.a(paramString1, paramString2);
    }
    if (QLog.isColorLevel()) {
      QLog.d("VasQuickUpdateEngine", 2, "sendPbMsg: error ExtenaionHandler = null");
    }
    return false;
  }
  
  /* Error */
  private static String unZipFile(File paramFile, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 347	com/tencent/commonsdk/zip/QZipFile
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 350	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/io/File;)V
    //   11: astore 6
    //   13: aload 6
    //   15: invokevirtual 354	com/tencent/commonsdk/zip/QZipFile:entries	()Ljava/util/Enumeration;
    //   18: astore 10
    //   20: sipush 8192
    //   23: newarray byte
    //   25: astore 11
    //   27: aconst_null
    //   28: astore_3
    //   29: aconst_null
    //   30: astore 5
    //   32: aload 4
    //   34: astore_0
    //   35: aload 6
    //   37: astore 9
    //   39: aload_3
    //   40: astore 8
    //   42: aload 5
    //   44: astore 7
    //   46: aload 10
    //   48: invokeinterface 359 1 0
    //   53: ifeq +490 -> 543
    //   56: aload 6
    //   58: astore 9
    //   60: aload_3
    //   61: astore 8
    //   63: aload 5
    //   65: astore 7
    //   67: aload 10
    //   69: invokeinterface 363 1 0
    //   74: checkcast 365	java/util/zip/ZipEntry
    //   77: astore 12
    //   79: aload 6
    //   81: astore 9
    //   83: aload_3
    //   84: astore 8
    //   86: aload 5
    //   88: astore 7
    //   90: aload 12
    //   92: invokevirtual 368	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   95: ldc_w 370
    //   98: invokevirtual 376	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   101: ifne -66 -> 35
    //   104: aload 6
    //   106: astore 9
    //   108: aload_3
    //   109: astore 8
    //   111: aload 5
    //   113: astore 7
    //   115: aload 12
    //   117: invokevirtual 377	java/util/zip/ZipEntry:isDirectory	()Z
    //   120: ifeq +199 -> 319
    //   123: aload 6
    //   125: astore 9
    //   127: aload_3
    //   128: astore 8
    //   130: aload 5
    //   132: astore 7
    //   134: invokestatic 380	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   137: ifeq +45 -> 182
    //   140: aload 6
    //   142: astore 9
    //   144: aload_3
    //   145: astore 8
    //   147: aload 5
    //   149: astore 7
    //   151: ldc_w 382
    //   154: iconst_4
    //   155: new 40	java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   162: ldc_w 384
    //   165: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: aload 12
    //   170: invokevirtual 368	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   173: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   182: aload 6
    //   184: astore 9
    //   186: aload_3
    //   187: astore 8
    //   189: aload 5
    //   191: astore 7
    //   193: new 372	java/lang/String
    //   196: dup
    //   197: new 40	java/lang/StringBuilder
    //   200: dup
    //   201: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   204: aload_1
    //   205: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: aload 12
    //   210: invokevirtual 368	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   213: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: ldc_w 386
    //   222: invokevirtual 390	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   225: ldc_w 392
    //   228: invokespecial 395	java/lang/String:<init>	([BLjava/lang/String;)V
    //   231: astore 4
    //   233: aload 6
    //   235: astore 9
    //   237: aload_3
    //   238: astore 8
    //   240: aload 5
    //   242: astore 7
    //   244: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   247: ifeq +42 -> 289
    //   250: aload 6
    //   252: astore 9
    //   254: aload_3
    //   255: astore 8
    //   257: aload 5
    //   259: astore 7
    //   261: ldc_w 382
    //   264: iconst_2
    //   265: new 40	java/lang/StringBuilder
    //   268: dup
    //   269: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   272: ldc_w 397
    //   275: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: aload 4
    //   280: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   286: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   289: aload 6
    //   291: astore 9
    //   293: aload_3
    //   294: astore 8
    //   296: aload 5
    //   298: astore 7
    //   300: new 55	java/io/File
    //   303: dup
    //   304: aload 4
    //   306: invokespecial 322	java/io/File:<init>	(Ljava/lang/String;)V
    //   309: invokevirtual 400	java/io/File:mkdir	()Z
    //   312: pop
    //   313: aload 4
    //   315: astore_0
    //   316: goto -281 -> 35
    //   319: aload 6
    //   321: astore 9
    //   323: aload_3
    //   324: astore 8
    //   326: aload 5
    //   328: astore 7
    //   330: aload 12
    //   332: invokevirtual 368	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   335: astore 4
    //   337: aload 6
    //   339: astore 9
    //   341: aload_3
    //   342: astore 8
    //   344: aload 5
    //   346: astore 7
    //   348: new 55	java/io/File
    //   351: dup
    //   352: new 40	java/lang/StringBuilder
    //   355: dup
    //   356: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   359: aload_1
    //   360: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: aload 12
    //   365: invokevirtual 368	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   368: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   374: invokespecial 322	java/io/File:<init>	(Ljava/lang/String;)V
    //   377: astore_0
    //   378: aload 6
    //   380: astore 9
    //   382: aload_3
    //   383: astore 8
    //   385: aload 5
    //   387: astore 7
    //   389: aload_0
    //   390: invokevirtual 403	java/io/File:getParentFile	()Ljava/io/File;
    //   393: invokevirtual 406	java/io/File:mkdirs	()Z
    //   396: pop
    //   397: aload 6
    //   399: astore 9
    //   401: aload_3
    //   402: astore 8
    //   404: aload 5
    //   406: astore 7
    //   408: new 408	java/io/BufferedOutputStream
    //   411: dup
    //   412: new 410	java/io/FileOutputStream
    //   415: dup
    //   416: aload_0
    //   417: invokespecial 411	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   420: invokespecial 414	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   423: astore_0
    //   424: aload 6
    //   426: aload 12
    //   428: invokevirtual 418	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   431: astore 5
    //   433: aload 5
    //   435: aload 11
    //   437: iconst_0
    //   438: sipush 8192
    //   441: invokevirtual 424	java/io/InputStream:read	([BII)I
    //   444: istore_2
    //   445: iload_2
    //   446: iconst_m1
    //   447: if_icmpeq +75 -> 522
    //   450: aload_0
    //   451: aload 11
    //   453: iconst_0
    //   454: iload_2
    //   455: invokevirtual 430	java/io/OutputStream:write	([BII)V
    //   458: goto -25 -> 433
    //   461: astore_1
    //   462: aload_0
    //   463: astore_3
    //   464: aload 4
    //   466: astore_0
    //   467: aload 5
    //   469: astore 4
    //   471: aload 6
    //   473: astore 9
    //   475: aload 4
    //   477: astore 8
    //   479: aload_3
    //   480: astore 7
    //   482: ldc 12
    //   484: iconst_1
    //   485: ldc_w 432
    //   488: aload_1
    //   489: invokestatic 435	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   492: aload_3
    //   493: ifnull +7 -> 500
    //   496: aload_3
    //   497: invokevirtual 438	java/io/OutputStream:close	()V
    //   500: aload 4
    //   502: ifnull +8 -> 510
    //   505: aload 4
    //   507: invokevirtual 439	java/io/InputStream:close	()V
    //   510: aload 6
    //   512: ifnull +8 -> 520
    //   515: aload 6
    //   517: invokevirtual 440	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   520: aload_0
    //   521: areturn
    //   522: aload 5
    //   524: invokevirtual 439	java/io/InputStream:close	()V
    //   527: aload_0
    //   528: invokevirtual 438	java/io/OutputStream:close	()V
    //   531: aload 5
    //   533: astore_3
    //   534: aload_0
    //   535: astore 5
    //   537: aload 4
    //   539: astore_0
    //   540: goto -505 -> 35
    //   543: aload 6
    //   545: astore 9
    //   547: aload_3
    //   548: astore 8
    //   550: aload 5
    //   552: astore 7
    //   554: aload 6
    //   556: invokevirtual 440	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   559: aload 5
    //   561: ifnull +8 -> 569
    //   564: aload 5
    //   566: invokevirtual 438	java/io/OutputStream:close	()V
    //   569: aload_3
    //   570: ifnull +7 -> 577
    //   573: aload_3
    //   574: invokevirtual 439	java/io/InputStream:close	()V
    //   577: aload 6
    //   579: ifnull +279 -> 858
    //   582: aload 6
    //   584: invokevirtual 440	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   587: aload_0
    //   588: areturn
    //   589: astore_1
    //   590: ldc 12
    //   592: iconst_1
    //   593: ldc_w 442
    //   596: aload_1
    //   597: invokestatic 435	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   600: goto -31 -> 569
    //   603: astore_1
    //   604: ldc 12
    //   606: iconst_1
    //   607: ldc_w 442
    //   610: aload_1
    //   611: invokestatic 435	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   614: goto -37 -> 577
    //   617: astore_1
    //   618: ldc 12
    //   620: iconst_1
    //   621: ldc_w 442
    //   624: aload_1
    //   625: invokestatic 435	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   628: aload_0
    //   629: areturn
    //   630: astore_1
    //   631: ldc 12
    //   633: iconst_1
    //   634: ldc_w 442
    //   637: aload_1
    //   638: invokestatic 435	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   641: goto -141 -> 500
    //   644: astore_1
    //   645: ldc 12
    //   647: iconst_1
    //   648: ldc_w 442
    //   651: aload_1
    //   652: invokestatic 435	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   655: goto -145 -> 510
    //   658: astore_1
    //   659: ldc 12
    //   661: iconst_1
    //   662: ldc_w 442
    //   665: aload_1
    //   666: invokestatic 435	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   669: aload_0
    //   670: areturn
    //   671: astore_0
    //   672: aconst_null
    //   673: astore 6
    //   675: aconst_null
    //   676: astore_3
    //   677: aconst_null
    //   678: astore_1
    //   679: aload_1
    //   680: ifnull +7 -> 687
    //   683: aload_1
    //   684: invokevirtual 438	java/io/OutputStream:close	()V
    //   687: aload_3
    //   688: ifnull +7 -> 695
    //   691: aload_3
    //   692: invokevirtual 439	java/io/InputStream:close	()V
    //   695: aload 6
    //   697: ifnull +8 -> 705
    //   700: aload 6
    //   702: invokevirtual 440	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   705: aload_0
    //   706: athrow
    //   707: astore_1
    //   708: ldc 12
    //   710: iconst_1
    //   711: ldc_w 442
    //   714: aload_1
    //   715: invokestatic 435	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   718: goto -31 -> 687
    //   721: astore_1
    //   722: ldc 12
    //   724: iconst_1
    //   725: ldc_w 442
    //   728: aload_1
    //   729: invokestatic 435	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   732: goto -37 -> 695
    //   735: astore_1
    //   736: ldc 12
    //   738: iconst_1
    //   739: ldc_w 442
    //   742: aload_1
    //   743: invokestatic 435	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   746: goto -41 -> 705
    //   749: astore_0
    //   750: aconst_null
    //   751: astore_3
    //   752: aconst_null
    //   753: astore_1
    //   754: goto -75 -> 679
    //   757: astore 4
    //   759: aload 5
    //   761: astore_3
    //   762: aload_0
    //   763: astore_1
    //   764: aload 4
    //   766: astore_0
    //   767: goto -88 -> 679
    //   770: astore_0
    //   771: aload 9
    //   773: astore 6
    //   775: aload 8
    //   777: astore_3
    //   778: aload 7
    //   780: astore_1
    //   781: goto -102 -> 679
    //   784: astore 4
    //   786: aload_0
    //   787: astore_1
    //   788: aload 4
    //   790: astore_0
    //   791: goto -112 -> 679
    //   794: astore_1
    //   795: aconst_null
    //   796: astore 6
    //   798: aconst_null
    //   799: astore 4
    //   801: aconst_null
    //   802: astore_3
    //   803: aconst_null
    //   804: astore_0
    //   805: goto -334 -> 471
    //   808: astore_1
    //   809: aconst_null
    //   810: astore 4
    //   812: aconst_null
    //   813: astore_3
    //   814: aconst_null
    //   815: astore_0
    //   816: goto -345 -> 471
    //   819: astore_1
    //   820: aload_3
    //   821: astore 4
    //   823: aload 5
    //   825: astore_3
    //   826: goto -355 -> 471
    //   829: astore_1
    //   830: aload 4
    //   832: astore_0
    //   833: aload_3
    //   834: astore 4
    //   836: aload 5
    //   838: astore_3
    //   839: goto -368 -> 471
    //   842: astore_1
    //   843: aload_0
    //   844: astore 5
    //   846: aload 4
    //   848: astore_0
    //   849: aload_3
    //   850: astore 4
    //   852: aload 5
    //   854: astore_3
    //   855: goto -384 -> 471
    //   858: aload_0
    //   859: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	860	0	paramFile	File
    //   0	860	1	paramString	String
    //   444	11	2	i	int
    //   28	827	3	localObject1	Object
    //   1	537	4	localObject2	Object
    //   757	8	4	localObject3	Object
    //   784	5	4	localObject4	Object
    //   799	52	4	localObject5	Object
    //   30	823	5	localObject6	Object
    //   11	786	6	localObject7	Object
    //   44	735	7	localObject8	Object
    //   40	736	8	localObject9	Object
    //   37	735	9	localObject10	Object
    //   18	50	10	localEnumeration	java.util.Enumeration
    //   25	427	11	arrayOfByte	byte[]
    //   77	350	12	localZipEntry	java.util.zip.ZipEntry
    // Exception table:
    //   from	to	target	type
    //   433	445	461	java/lang/Exception
    //   450	458	461	java/lang/Exception
    //   522	531	461	java/lang/Exception
    //   564	569	589	java/lang/Exception
    //   573	577	603	java/lang/Exception
    //   582	587	617	java/lang/Exception
    //   496	500	630	java/lang/Exception
    //   505	510	644	java/lang/Exception
    //   515	520	658	java/lang/Exception
    //   3	13	671	finally
    //   683	687	707	java/lang/Exception
    //   691	695	721	java/lang/Exception
    //   700	705	735	java/lang/Exception
    //   13	27	749	finally
    //   433	445	757	finally
    //   450	458	757	finally
    //   522	531	757	finally
    //   46	56	770	finally
    //   67	79	770	finally
    //   90	104	770	finally
    //   115	123	770	finally
    //   134	140	770	finally
    //   151	182	770	finally
    //   193	233	770	finally
    //   244	250	770	finally
    //   261	289	770	finally
    //   300	313	770	finally
    //   330	337	770	finally
    //   348	378	770	finally
    //   389	397	770	finally
    //   408	424	770	finally
    //   482	492	770	finally
    //   554	559	770	finally
    //   424	433	784	finally
    //   3	13	794	java/lang/Exception
    //   13	27	808	java/lang/Exception
    //   46	56	819	java/lang/Exception
    //   67	79	819	java/lang/Exception
    //   90	104	819	java/lang/Exception
    //   115	123	819	java/lang/Exception
    //   134	140	819	java/lang/Exception
    //   151	182	819	java/lang/Exception
    //   193	233	819	java/lang/Exception
    //   244	250	819	java/lang/Exception
    //   261	289	819	java/lang/Exception
    //   300	313	819	java/lang/Exception
    //   330	337	819	java/lang/Exception
    //   554	559	819	java/lang/Exception
    //   348	378	829	java/lang/Exception
    //   389	397	829	java/lang/Exception
    //   408	424	829	java/lang/Exception
    //   424	433	842	java/lang/Exception
  }
  
  private String uncompressZip(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasQuickUpdateEngine", 2, "uncompressZip: bZip0 = " + paramBoolean + " srcFile = " + paramString);
    }
    Object localObject = new File(paramString);
    paramString = ((File)localObject).getParent() + File.separator;
    try
    {
      localObject = unZipFile((File)localObject, paramString);
      if (localObject != null)
      {
        paramString = paramString + (String)localObject;
        if (!QLog.isColorLevel()) {
          return paramString;
        }
        QLog.d("VasQuickUpdateEngine", 2, "uncompressZip result = " + paramString);
        return paramString;
      }
      if (QLog.isColorLevel()) {
        QLog.e("VasQuickUpdateEngine", 2, "uncompressZip fail");
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("VasQuickUpdateEngine", 2, "uncompressZip error : ", paramString);
        }
      }
    }
    return null;
    return paramString;
  }
  
  public void DBdeleteItem(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasQuickUpdateEngine", 2, "DBdeleteItem: table = " + paramInt + " itemId = " + paramString);
    }
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("quick_update_" + paramInt, 0).edit();
    localEditor.remove(paramString);
    if (!localEditor.commit()) {
      QLog.e("VasQuickUpdateEngine", 1, "DBdeleteItem table = " + paramInt + " itemId = " + paramString + " fail");
    }
  }
  
  public ArrayList DBselectAllItems(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasQuickUpdateEngine", 2, "DBselectAllItems: table = " + paramInt);
    }
    Object localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences("quick_update_" + paramInt, 0);
    if (localObject1 == null) {}
    do
    {
      return null;
      localObject2 = ((SharedPreferences)localObject1).getAll();
    } while ((localObject2 == null) || (((Map)localObject2).size() <= 0));
    localObject1 = new ArrayList();
    Object localObject2 = ((Map)localObject2).entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
      VasQuickUpdateEngine.TagItemRecord localTagItemRecord = new VasQuickUpdateEngine.TagItemRecord(this);
      localTagItemRecord.itemId = ((String)localEntry.getKey());
      localTagItemRecord.content = ((String)localEntry.getValue());
      ((ArrayList)localObject1).add(localTagItemRecord);
      if (QLog.isColorLevel()) {
        QLog.d("VasQuickUpdateEngine", 2, "DBselectAllItems table = " + paramInt + " itemId = " + localTagItemRecord.itemId + " content = " + localTagItemRecord.content);
      }
    }
    return localObject1;
  }
  
  public String DBselectItem(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasQuickUpdateEngine", 2, "DBselectItem: table = " + paramInt + " itemId = " + paramString);
    }
    paramString = BaseApplicationImpl.getApplication().getSharedPreferences("quick_update_" + paramInt, 0).getString(paramString, "");
    if (QLog.isColorLevel()) {
      QLog.d("VasQuickUpdateEngine", 2, "DBselectItem result = " + paramString);
    }
    return paramString;
  }
  
  public ArrayList DBselectOldItems(int[] paramArrayOfInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasQuickUpdateEngine", 2, "DBselectOldItems bids = " + paramArrayOfInt);
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      int j = paramArrayOfInt[i];
      i += 1;
    }
    return localArrayList;
  }
  
  public void DBupdateItem(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasQuickUpdateEngine", 2, "DBupdateItem: table = " + paramInt + " itemId = " + paramString1 + " content = " + paramString2);
    }
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("quick_update_" + paramInt, 0).edit();
    localEditor.putString(paramString1, paramString2);
    if (!localEditor.commit()) {
      QLog.e("VasQuickUpdateEngine", 1, "DBupdateItem table = " + paramInt + " itemId = " + paramString1 + " content = " + paramString2 + " fail");
    }
  }
  
  void addDownloadItem(VasQuickUpdateEngine.DownloadItem paramDownloadItem)
  {
    Vector localVector = this.downloadList;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.downloadList.size())
        {
          if (!((VasQuickUpdateEngine.DownloadItem)this.downloadList.get(i)).equals(paramDownloadItem)) {}
        }
        else
        {
          this.downloadList.add(paramDownloadItem);
          return;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  public boolean canUpdate(long paramLong, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasQuickUpdateEngine", 2, "canUpdate bid = " + paramLong + " scid = " + paramString1 + " from = " + paramString2);
    }
    VasQuickUpdateEngine.QuickUpdateBusinessCallback localQuickUpdateBusinessCallback = this.mDefaultCallback;
    if (this.mBusinessCallbackList.containsKey(Long.valueOf(paramLong))) {
      localQuickUpdateBusinessCallback = (VasQuickUpdateEngine.QuickUpdateBusinessCallback)this.mBusinessCallbackList.get(Long.valueOf(paramLong));
    }
    return (localQuickUpdateBusinessCallback != null) && (localQuickUpdateBusinessCallback.canUpdate(paramLong, paramString1, paramString2));
  }
  
  public void cancelDwonloadItem(long paramLong, String paramString)
  {
    if (isSoLoadFail.get()) {
      if (loadSoRetryTime < 2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VasQuickUpdateEngine", 2, "downloadItem so load fail, retry " + (loadSoRetryTime + 1) + "time");
        }
        loadSo();
        loadSoRetryTime += 1;
        removeDownloadItem(new VasQuickUpdateEngine.DownloadItem(paramLong, paramString, null));
      }
    }
    do
    {
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.e("VasQuickUpdateEngine", 2, "downloadItem so load fail, has retried 2 times");
      return;
      if (!hasSoLoaded.get())
      {
        removeDownloadItem(new VasQuickUpdateEngine.DownloadItem(paramLong, paramString, null));
        return;
      }
    } while (this.mUpdateManagerInstance == 0L);
    nativeCancelDownload(this.mUpdateManagerInstance, paramLong, paramString);
  }
  
  public boolean deleteFiles(long paramLong, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasQuickUpdateEngine", 2, "deleteFiles bid = " + paramLong + " scid = " + paramString);
    }
    VasQuickUpdateEngine.QuickUpdateBusinessCallback localQuickUpdateBusinessCallback = this.mDefaultCallback;
    if (this.mBusinessCallbackList.containsKey(Long.valueOf(paramLong))) {
      localQuickUpdateBusinessCallback = (VasQuickUpdateEngine.QuickUpdateBusinessCallback)this.mBusinessCallbackList.get(Long.valueOf(paramLong));
    }
    return (localQuickUpdateBusinessCallback != null) && (localQuickUpdateBusinessCallback.deleteFiles(paramLong, paramString));
  }
  
  void downloadFromList()
  {
    Vector localVector = this.downloadList;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.downloadList.size())
        {
          VasQuickUpdateEngine.DownloadItem localDownloadItem = (VasQuickUpdateEngine.DownloadItem)this.downloadList.get(i);
          if (this.mUpdateManagerInstance != 0L) {
            nativeDownloadItem(this.mUpdateManagerInstance, localDownloadItem.bid, localDownloadItem.scid, localDownloadItem.from);
          }
        }
        else
        {
          this.downloadList.clear();
          return;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  public void downloadGatherItem(long paramLong, String paramString1, String[] paramArrayOfString, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasQuickUpdateEngine", 2, "downloadItem bid = " + paramLong + " scid = " + paramString1 + " scidList = " + paramArrayOfString + " from = " + paramString2);
    }
    if (this.mUpdateManagerInstance != 0L) {
      nativeDownloadGatherItem(this.mUpdateManagerInstance, paramLong, paramString1, paramArrayOfString, paramString2);
    }
  }
  
  public void downloadItem(long paramLong, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasQuickUpdateEngine", 2, "downloadItem bid = " + paramLong + " scid = " + paramString1 + " from = " + paramString2);
    }
    if (isSoLoadFail.get()) {
      if (loadSoRetryTime < 2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VasQuickUpdateEngine", 2, "downloadItem so load fail, retry " + (loadSoRetryTime + 1) + "time");
        }
        loadSo();
        loadSoRetryTime += 1;
        addDownloadItem(new VasQuickUpdateEngine.DownloadItem(paramLong, paramString1, paramString2));
      }
    }
    do
    {
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.e("VasQuickUpdateEngine", 2, "downloadItem so load fail, has retried 2 times");
      return;
      if (!hasSoLoaded.get())
      {
        addDownloadItem(new VasQuickUpdateEngine.DownloadItem(paramLong, paramString1, paramString2));
        return;
      }
    } while (this.mUpdateManagerInstance == 0L);
    nativeDownloadItem(this.mUpdateManagerInstance, paramLong, paramString1, paramString2);
  }
  
  public ArrayList getDirectConnectIpsByHost(String paramString)
  {
    ArrayList localArrayList = InnerDns.a().a(paramString, 1014);
    if (QLog.isColorLevel()) {
      QLog.d("VasQuickUpdateEngine", 2, "getDirectConnectIpsByHost host = " + paramString + " ip = " + localArrayList);
    }
    return localArrayList;
  }
  
  public VasQuickUpdateEngine.TagItemInfo getItemInfo(long paramLong, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasQuickUpdateEngine", 2, "getItemInfo bid = " + paramLong + " scid = " + paramString);
    }
    VasQuickUpdateEngine.QuickUpdateBusinessCallback localQuickUpdateBusinessCallback = this.mDefaultCallback;
    if (this.mBusinessCallbackList.containsKey(Long.valueOf(paramLong))) {
      localQuickUpdateBusinessCallback = (VasQuickUpdateEngine.QuickUpdateBusinessCallback)this.mBusinessCallbackList.get(Long.valueOf(paramLong));
    }
    if (localQuickUpdateBusinessCallback == null) {
      return null;
    }
    return localQuickUpdateBusinessCallback.getItemInfo(paramLong, paramString);
  }
  
  /* Error */
  public boolean initEngine(String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: aload_0
    //   6: aload_1
    //   7: invokestatic 679	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   10: invokestatic 682	android/net/Proxy:getDefaultPort	()I
    //   13: invokevirtual 686	com/tencent/mobileqq/vas/VasQuickUpdateEngine:nativeCreateManager	(Ljava/lang/String;Ljava/lang/String;I)J
    //   16: putfield 613	com/tencent/mobileqq/vas/VasQuickUpdateEngine:mUpdateManagerInstance	J
    //   19: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   22: ifeq +12 -> 34
    //   25: ldc 12
    //   27: iconst_2
    //   28: ldc_w 688
    //   31: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   34: aload_0
    //   35: getfield 613	com/tencent/mobileqq/vas/VasQuickUpdateEngine:mUpdateManagerInstance	J
    //   38: lconst_0
    //   39: lcmp
    //   40: ifeq +43 -> 83
    //   43: aload_0
    //   44: aload_0
    //   45: getfield 613	com/tencent/mobileqq/vas/VasQuickUpdateEngine:mUpdateManagerInstance	J
    //   48: ldc_w 690
    //   51: ldc_w 692
    //   54: invokestatic 49	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   57: invokestatic 698	com/tencent/mobileqq/theme/ThemeUtil:getThemeDensity	(Landroid/content/Context;)Ljava/lang/String;
    //   60: invokevirtual 702	com/tencent/mobileqq/vas/VasQuickUpdateEngine:nativeSetLocalInfo	(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   63: aload_0
    //   64: getfield 86	com/tencent/mobileqq/vas/VasQuickUpdateEngine:isEngineInit	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   67: iconst_1
    //   68: invokevirtual 705	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   71: aload_0
    //   72: invokevirtual 708	com/tencent/mobileqq/vas/VasQuickUpdateEngine:registerAllUpdateItem	()V
    //   75: aload_0
    //   76: invokevirtual 710	com/tencent/mobileqq/vas/VasQuickUpdateEngine:downloadFromList	()V
    //   79: aload_0
    //   80: monitorexit
    //   81: iload_2
    //   82: ireturn
    //   83: iconst_0
    //   84: istore_2
    //   85: goto -6 -> 79
    //   88: astore_1
    //   89: aload_0
    //   90: monitorexit
    //   91: aload_1
    //   92: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	this	VasQuickUpdateEngine
    //   0	93	1	paramString	String
    //   1	84	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   4	34	88	finally
    //   34	79	88	finally
  }
  
  public native void nativeCancelDownload(long paramLong1, long paramLong2, String paramString);
  
  public native long nativeCreateManager(String paramString1, String paramString2, int paramInt);
  
  public native void nativeDestroyManager(long paramLong);
  
  public native void nativeDownloadGatherItem(long paramLong1, long paramLong2, String paramString1, String[] paramArrayOfString, String paramString2);
  
  public native void nativeDownloadItem(long paramLong1, long paramLong2, String paramString1, String paramString2);
  
  public native void nativeOnPbMsgRecv(long paramLong, int paramInt, String paramString1, String paramString2);
  
  public native void nativeRegisterUpdateItem(long paramLong1, long paramLong2, String paramString);
  
  public native void nativeSetLocalInfo(long paramLong, String paramString1, String paramString2, String paramString3);
  
  public native void nativeStartPreloadDownload(long paramLong1, String paramString1, String paramString2, String paramString3, long paramLong2, String paramString4);
  
  public native void nativeUnregisterUpdateItem(long paramLong1, long paramLong2, String paramString);
  
  public native void nativeupdateAllItem(long paramLong);
  
  public void onCompleted(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasQuickUpdateEngine", 2, "onCompleted bid = " + paramLong + " scid = " + paramString1 + " from = " + paramString3 + " dlFrom = " + paramInt1 + " errorCode = " + paramInt2 + " httpCode = " + paramInt3);
    }
    VasQuickUpdateEngine.QuickUpdateListener localQuickUpdateListener = this.mDefaultListener;
    if (this.mUpdateListenerList.containsKey(Long.valueOf(paramLong))) {
      localQuickUpdateListener = (VasQuickUpdateEngine.QuickUpdateListener)this.mUpdateListenerList.get(Long.valueOf(paramLong));
    }
    if (localQuickUpdateListener != null) {
      localQuickUpdateListener.onCompleted(paramLong, paramString1, paramString2, paramString3, paramInt2, paramInt3);
    }
  }
  
  public void onPbMsgRecv(int paramInt, String paramString1, String paramString2)
  {
    if (this.mUpdateManagerInstance != 0L) {
      nativeOnPbMsgRecv(this.mUpdateManagerInstance, paramInt, paramString1, paramString2);
    }
  }
  
  public void onProgress(long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasQuickUpdateEngine", 2, "onProgress bid = " + paramLong1 + " scid = " + paramString1 + " cfgScid = " + paramString2 + "dwProgress = " + paramLong2 + " dwProgressMax = " + paramLong3);
    }
    VasQuickUpdateEngine.QuickUpdateListener localQuickUpdateListener = this.mDefaultListener;
    if (this.mUpdateListenerList.containsKey(Long.valueOf(paramLong1))) {
      localQuickUpdateListener = (VasQuickUpdateEngine.QuickUpdateListener)this.mUpdateListenerList.get(Long.valueOf(paramLong1));
    }
    if (localQuickUpdateListener != null) {
      localQuickUpdateListener.onProgress(paramLong1, paramString1, paramString2, paramLong2, paramLong3);
    }
  }
  
  public void registerAllUpdateItem()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new Pair(Long.valueOf(1000L), "keywordList_2.json"));
    localArrayList.add(new Pair(Long.valueOf(1000L), "diytheme.style.json"));
    localArrayList.add(new Pair(Long.valueOf(1000L), "diytheme.json"));
    localArrayList.add(new Pair(Long.valueOf(5L), "font.main.android."));
    localArrayList.add(new Pair(Long.valueOf(5L), "font.fzfont.android."));
    localArrayList.add(new Pair(Long.valueOf(5L), "magicFontConfig.json"));
    localArrayList.add(new Pair(Long.valueOf(3L), "theme."));
    localArrayList.add(new Pair(Long.valueOf(16L), "iRedPacket_v3.json"));
    localArrayList.add(new Pair(Long.valueOf(16L), "iRedPacket_v3.char300.json"));
    localArrayList.add(new Pair(Long.valueOf(16L), "luckyMoney.item."));
    localArrayList.add(new Pair(Long.valueOf(16L), "iRedPacket_v3.font.zip"));
    localArrayList.add(new Pair(Long.valueOf(16L), "iRedPacket_v3.specialChar.zip"));
    localArrayList.add(new Pair(Long.valueOf(1001L), "sonicTemplateUpdate.json"));
    localArrayList.add(new Pair(Long.valueOf(1000L), "vipData_individuation_url.android.json"));
    localArrayList.add(new Pair(Long.valueOf(1000L), "vipData_app_webviewNavStyle.json"));
    localArrayList.add(new Pair(Long.valueOf(1000L), "VASBiz_FuncDev_webview.json"));
    localArrayList.add(new Pair(Long.valueOf(2L), "bubble.android."));
    localArrayList.add(new Pair(Long.valueOf(4L), "pendant."));
    localArrayList.add(new Pair(Long.valueOf(1000L), "pendant_market_json.android.v2"));
    localArrayList.add(new Pair(Long.valueOf(1000L), "changeVoice_json"));
    localArrayList.add(new Pair(Long.valueOf(2L), "bubble.paster."));
    localArrayList.add(new Pair(Long.valueOf(1000L), "vip_personal_card.json"));
    localArrayList.add(new Pair(Long.valueOf(1000L), "monitorAppid"));
    localArrayList.add(new Pair(Long.valueOf(20L), "praise.android."));
    localArrayList.add(new Pair(Long.valueOf(15L), "cardWZ.zip"));
    localArrayList.add(new Pair(Long.valueOf(1000L), "praise.config.json"));
    localArrayList.add(new Pair(Long.valueOf(1003L), "emotionRecommendEffect"));
    localArrayList.add(new Pair(Long.valueOf(1004L), "emojiStickerGuideZip_v2"));
    localArrayList.add(new Pair(Long.valueOf(1004L), "libFlatBuffersParser"));
    localArrayList.add(new Pair(Long.valueOf(1004L), "libtmsdualcore"));
    localArrayList.add(new Pair(Long.valueOf(1004L), "bqmall.android.h5magic."));
    localArrayList.add(new Pair(Long.valueOf(1004L), "libColorFont_760"));
    localArrayList.add(new Pair(Long.valueOf(1004L), "libVipFont_765"));
    localArrayList.add(new Pair(Long.valueOf(1004L), "libqgplayer_765"));
    localArrayList.add(new Pair(Long.valueOf(1004L), "libAPNG_765"));
    localArrayList.add(new Pair(Long.valueOf(1002L), "flashchat."));
    localArrayList.add(new Pair(Long.valueOf(1000L), "xydata.qq.hifont.recommend.json"));
    localArrayList.add(new Pair(Long.valueOf(22L), "colorScreen.android."));
    localArrayList.add(new Pair(Long.valueOf(23L), "face."));
    localArrayList.add(new Pair(Long.valueOf(5L), "font.hifontQQ.android."));
    localArrayList.add(new Pair(Long.valueOf(1000L), "card.diyFontConfig.json"));
    localArrayList.add(new Pair(Long.valueOf(5L), "font.diycard.android."));
    localArrayList.add(new Pair(Long.valueOf(21L), "poke.item.effect."));
    localArrayList.add(new Pair(Long.valueOf(4L), "faceAddon.sticker."));
    localArrayList.add(new Pair(Long.valueOf(21L), "poke.item.res."));
    localArrayList.add(new Pair(Long.valueOf(4L), "faceAddon.stickerFont.android."));
    localArrayList.add(new Pair(Long.valueOf(21L), "poke.effectList"));
    localArrayList.add(new Pair(Long.valueOf(9L), "signature.sticker."));
    localArrayList.add(new Pair(Long.valueOf(1000L), "vipComic_config_v2.json"));
    localArrayList.add(new Pair(Long.valueOf(100L), "vipComic_nav_config.json"));
    localArrayList.add(new Pair(Long.valueOf(100L), "vipComic_nav_tabIcon.zip"));
    localArrayList.add(new Pair(Long.valueOf(1999L), "scupdate.test."));
    localArrayList.add(new Pair(Long.valueOf(1005L), "flashcar.gameres.2000.zip"));
    localArrayList.add(new Pair(Long.valueOf(1000L), "watch_focus.json"));
    localArrayList.add(new Pair(Long.valueOf(1000L), "emoji_app_vip_emoji_aio_android_config.json"));
    localArrayList.add(new Pair(Long.valueOf(1000L), "signature.item."));
    localArrayList.add(new Pair(Long.valueOf(1000L), "groupeffect_config.json"));
    localArrayList.add(new Pair(Long.valueOf(25L), "groupeffect_item_"));
    localArrayList.add(new Pair(Long.valueOf(15L), "card."));
    if ((this.mUpdateManagerInstance != 0L) && (!this.hasRegistered.get()))
    {
      int i = 0;
      while (i < localArrayList.size())
      {
        Pair localPair = (Pair)localArrayList.get(i);
        nativeRegisterUpdateItem(this.mUpdateManagerInstance, ((Long)localPair.first).longValue(), (String)localPair.second);
        i += 1;
      }
      nativeupdateAllItem(this.mUpdateManagerInstance);
      this.hasRegistered.set(true);
    }
  }
  
  void removeDownloadItem(VasQuickUpdateEngine.DownloadItem paramDownloadItem)
  {
    Vector localVector = this.downloadList;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.downloadList.size())
        {
          if (((VasQuickUpdateEngine.DownloadItem)this.downloadList.get(i)).equals(paramDownloadItem)) {
            this.downloadList.remove(i);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasQuickUpdateEngine
 * JD-Core Version:    0.7.0.1
 */