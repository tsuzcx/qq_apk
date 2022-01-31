package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings.System;
import android.util.Log;
import com.tencent.smtt.utils.ApkUtil;
import com.tencent.smtt.utils.Apn;
import com.tencent.smtt.utils.AppUtil;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.TbsUtils;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TbsApkDownloader
{
  public static final String BACKUPNAME = "backup";
  private static final int BUFFER_SIZE = 8192;
  public static final long DOWNLOAD_PERIOD = 86400000L;
  public static final int LOCAL_SDCARD_TBS_VERSION = 88888888;
  private static int MAX_RETRY_TIMES_DEFAULT = 5;
  private static int MAX_RETRY_TIMES_FOREGROUND = 1;
  private static final long MIN_RETRY_INTERVAL = 20000L;
  private static final int MSG_NETWORK_DETECTOR = 150;
  private static final long NETWORK_DETECT_RETRY_TIME = 120000L;
  private static final long NETWORK_WIFI_CHECK_STEP_SIZE = 1048576L;
  private static final String TBS_APK_FILENAME = "x5.tbs";
  private static final String TBS_APK_TEMP_FILENAME = "x5.tbs.temp";
  static final String TBS_BACKUP_APK_FILENAME_OVERSEA = "x5.oversea.tbs.org";
  private static final String[] TBS_DOWNLOADING_APP_KEYS = { "tbs_downloading_com.tencent.mtt", "tbs_downloading_com.tencent.mm", "tbs_downloading_com.tencent.mobileqq", "tbs_downloading_com.tencent.tbs", "tbs_downloading_com.qzone" };
  private static final String TBS_DOWNLOADING_KEY_HEAD = "tbs_downloading_";
  private static final int WALLED_GARDEN_SOCKET_TIMEOUT_MS = 10000;
  private static final String WALLED_GARDEN_URL = "http://pms.mb.qq.com/rsp204";
  int curUrlIndex = 0;
  String localInstallMessage;
  private String mApnInfo;
  private int mApnType;
  private boolean mCanceled;
  private int mConnectTimeout = 20000;
  private long mContentLength;
  private Context mContext;
  private TbsLogReport.TbsLogInfo mDownloadStat;
  private String mDownloadUrl;
  private File mFilePath;
  private boolean mFinished;
  private boolean mHasTmpTryNoRange;
  private HttpURLConnection mHttpRequest;
  private boolean mIsDownloadForeground;
  private String mLastDownloadUrl;
  private String mLocalDownloadingKey;
  private String mLocation;
  private int mMaxRetryTimes = MAX_RETRY_TIMES_DEFAULT;
  private boolean mNeedDownloadStat;
  private Handler mNetworkDetectorHandler;
  private int mReadTimeout = 30000;
  private int mRetryTimes;
  private int mRetryTimes302;
  private Set<String> mWifiUnavailableList;
  String[] urlArray = null;
  
  public TbsApkDownloader(Context paramContext)
  {
    this.mContext = paramContext.getApplicationContext();
    this.mDownloadStat = TbsLogReport.getInstance(this.mContext).tbsLogInfo();
    this.mWifiUnavailableList = new HashSet();
    this.mLocalDownloadingKey = ("tbs_downloading_" + this.mContext.getPackageName());
    TbsInstaller.getInstance();
    this.mFilePath = TbsInstaller.getTbsCorePrivateDir(this.mContext);
    if (this.mFilePath == null) {
      throw new NullPointerException("TbsCorePrivateDir is null!");
    }
    resetArgs();
    this.mApnInfo = null;
    this.mApnType = -1;
  }
  
  @TargetApi(8)
  static File backupApkPath(Context paramContext)
  {
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT >= 8)
        {
          paramContext = new File(FileUtil.getTBSSdcardFilePath(paramContext, 4));
          if ((paramContext != null) && (!paramContext.exists()) && (!paramContext.isDirectory())) {
            paramContext.mkdirs();
          }
          return paramContext;
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        TbsLog.e("TbsDownload", "[TbsApkDownloader.backupApkPath] Exception is " + paramContext.getMessage());
        return null;
      }
      paramContext = null;
    }
  }
  
  public static void backupTbsApk(File paramFile, Context paramContext)
  {
    int i = 0;
    if (paramFile != null) {}
    for (;;)
    {
      File localFile;
      boolean bool2;
      try
      {
        if (!paramFile.exists()) {
          return;
        }
        try
        {
          localFile = backupApkPath(paramContext);
          if (localFile != null)
          {
            if (TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_download_version_type", 0) == 1)
            {
              localObject1 = new File(localFile, TbsDownloader.getBackupFileName(true));
              ((File)localObject1).delete();
              FileUtil.copyFiles(paramFile, (File)localObject1);
              boolean bool1 = ((File)localObject1).getName().contains("tbs.org");
              bool2 = ((File)localObject1).getName().contains("x5.tbs.decouple");
              if ((!bool2) && (!bool1)) {
                break label340;
              }
              localObject1 = localFile.listFiles();
              Pattern localPattern = Pattern.compile(ApkUtil.getCoreVersionCfgFile(bool2) + "(.*)");
              int j = localObject1.length;
              if (i >= j) {
                break label253;
              }
              Object localObject2 = localObject1[i];
              if ((!localPattern.matcher(localObject2.getName()).find()) || (!localObject2.isFile()) || (!localObject2.exists())) {
                break label487;
              }
              localObject2.delete();
              break label487;
            }
            if (TbsDownloader.getOverSea(paramContext))
            {
              localObject1 = "x5.oversea.tbs.org";
              localObject1 = new File(localFile, (String)localObject1);
              continue;
            }
          }
          else
          {
            paramFile = finally;
          }
        }
        catch (Exception paramFile)
        {
          return;
        }
        localObject1 = TbsDownloader.getBackupFileName(false);
      }
      finally {}
      continue;
      label253:
      i = TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_download_version", 0);
      Object localObject1 = new File(localFile, ApkUtil.getCoreVersionCfgFile(bool2) + "." + i);
      if ((localObject1 != null) && (((File)localObject1).exists()))
      {
        TbsLog.e("TbsDownload", "[TbsApkDownloader.backupTbsApk]delete bacup config file error ");
        return;
      }
      ((File)localObject1).createNewFile();
      label340:
      if ((TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_download_version_type", 0) != 1) && (TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_decouplecoreversion", 0) == ApkUtil.getApkVersion(paramContext, paramFile)))
      {
        i = TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_responsecode", 0);
        if ((i == 5) || (i == 3)) {
          TbsLog.i("TbsApkDownloader", "response code=" + i + "return backup decouple apk");
        }
        localObject1 = new File(localFile, TbsDownloader.getBackupFileName(true));
        if (ApkUtil.getApkVersion(paramContext, paramFile) != ApkUtil.getApkVersion(paramContext, (File)localObject1))
        {
          ((File)localObject1).delete();
          FileUtil.copyFiles(paramFile, (File)localObject1);
          continue;
          label487:
          i += 1;
        }
      }
    }
  }
  
  public static void clearAllApkFile(Context paramContext)
  {
    int j = 0;
    for (;;)
    {
      int i;
      try
      {
        TbsInstaller.getInstance();
        Object localObject1 = TbsInstaller.getTbsCorePrivateDir(paramContext);
        new File((File)localObject1, "x5.tbs").delete();
        new File((File)localObject1, "x5.tbs.temp").delete();
        paramContext = backupApkPath(paramContext);
        if (paramContext != null)
        {
          new File(paramContext, TbsDownloader.getBackupFileName(false)).delete();
          new File(paramContext, "x5.oversea.tbs.org").delete();
          paramContext = paramContext.listFiles();
          localObject1 = Pattern.compile(ApkUtil.getCoreVersionCfgFile(true) + "(.*)");
          int k = paramContext.length;
          i = 0;
          Object localObject2;
          if (i < k)
          {
            localObject2 = paramContext[i];
            if ((!((Pattern)localObject1).matcher(localObject2.getName()).find()) || (!localObject2.isFile()) || (!localObject2.exists())) {
              break label260;
            }
            localObject2.delete();
            break label260;
          }
          localObject1 = Pattern.compile(ApkUtil.getCoreVersionCfgFile(false) + "(.*)");
          k = paramContext.length;
          i = j;
          if (i < k)
          {
            localObject2 = paramContext[i];
            if ((((Pattern)localObject1).matcher(localObject2.getName()).find()) && (localObject2.isFile()) && (localObject2.exists())) {
              localObject2.delete();
            }
            i += 1;
            continue;
          }
        }
        return;
      }
      catch (Exception paramContext) {}
      label260:
      i += 1;
    }
  }
  
  private void closeHttpRequest()
  {
    TbsLog.i("TbsDownload", "[TbsApkDownloader.closeHttpRequest]");
    if (this.mHttpRequest != null) {
      if (!this.mCanceled) {
        this.mDownloadStat.setResolveIp(getDomainIp(this.mHttpRequest.getURL()));
      }
    }
    try
    {
      this.mHttpRequest.disconnect();
      this.mHttpRequest = null;
      int i = this.mDownloadStat.mErrorCode;
      if ((!this.mCanceled) && (this.mNeedDownloadStat))
      {
        this.mDownloadStat.setEventTime(System.currentTimeMillis());
        String str2 = Apn.getApnInfo(this.mContext);
        String str1 = str2;
        if (str2 == null) {
          str1 = "";
        }
        int j = Apn.getApnType(this.mContext);
        this.mDownloadStat.setApn(str1);
        this.mDownloadStat.setNetworkType(j);
        if ((j != this.mApnType) || (!str1.equals(this.mApnInfo))) {
          this.mDownloadStat.setNetworkChange(0);
        }
        if (((this.mDownloadStat.mErrorCode == 0) || (this.mDownloadStat.mErrorCode == 107)) && (this.mDownloadStat.getDownFinalFlag() == 0))
        {
          if (!Apn.isNetworkAvailable(this.mContext)) {
            setDownloadStat(101, null, true);
          }
        }
        else
        {
          if (!TbsDownloader.isDecoupleCore(this.mContext)) {
            break label306;
          }
          TbsLogReport.getInstance(this.mContext).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD_DECOUPLE, this.mDownloadStat);
          this.mDownloadStat.resetArgs();
          if (i != 100) {
            QbSdk.mTbsListenerWrapper.onDownloadFinish(i);
          }
          return;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        TbsLog.e("TbsDownload", "[closeHttpRequest] mHttpRequest.disconnect() Throwable:" + localThrowable.toString());
        continue;
        if (!ping())
        {
          setDownloadStat(101, null, true);
          continue;
          label306:
          TbsLogReport.getInstance(this.mContext).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, this.mDownloadStat);
        }
      }
      TbsDownloader.mIsDownloading = false;
    }
  }
  
  private void closeStream(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable) {}
  }
  
  private boolean copyTbsApkFromBackupToInstall(int paramInt)
  {
    boolean bool = false;
    try
    {
      File localFile1 = new File(this.mFilePath, "x5.tbs");
      File localFile2 = backupApkPath(this.mContext);
      if (localFile2 != null)
      {
        if (TbsDownloader.getOverSea(this.mContext)) {}
        for (Object localObject = "x5.oversea.tbs.org";; localObject = TbsDownloader.getBackupFileName(false))
        {
          localObject = new File(localFile2, (String)localObject);
          localFile1.delete();
          FileUtil.copyFiles((File)localObject, localFile1);
          if (ApkUtil.verifyTbsApk(this.mContext, localFile1, 0L, paramInt)) {
            break;
          }
          TbsLog.i("TbsDownload", "[TbsApkDownloader.copyTbsApkFromBackupToInstall] verifyTbsApk error!!");
          return false;
        }
        bool = true;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      TbsLog.e("TbsDownload", "[TbsApkDownloader.copyTbsApkFromBackupToInstall] Exception is " + localException.getMessage());
      return false;
    }
    return bool;
  }
  
  private boolean deleteFile(boolean paramBoolean)
  {
    TbsLog.i("TbsDownload", "[TbsApkDownloader.deleteFile] isApk=" + paramBoolean);
    if (paramBoolean) {}
    for (File localFile = new File(this.mFilePath, "x5.tbs");; localFile = new File(this.mFilePath, "x5.tbs.temp"))
    {
      if ((localFile != null) && (localFile.exists())) {
        FileUtil.delete(localFile);
      }
      return true;
    }
  }
  
  private void deleteFileBackuped()
  {
    try
    {
      Object localObject = getBackupCorePath();
      if ((localObject != null) && (((File)localObject).exists()))
      {
        FileUtil.delete((File)localObject);
        localObject = ((File)localObject).getParentFile().listFiles();
        Pattern localPattern = Pattern.compile(ApkUtil.getCoreVersionCfgFile(TbsDownloader.isDecoupleCore(this.mContext)) + "(.*)");
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          File localFile = localObject[i];
          if ((localPattern.matcher(localFile.getName()).find()) && (localFile.isFile()) && (localFile.exists())) {
            FileUtil.delete(localFile);
          }
          i += 1;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  /* Error */
  private boolean detectWifiNetworkAvailable()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 6
    //   6: iconst_1
    //   7: istore 4
    //   9: iconst_0
    //   10: istore 5
    //   12: aload_0
    //   13: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   16: invokestatic 402	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   19: iconst_3
    //   20: if_icmpne +275 -> 295
    //   23: iconst_1
    //   24: istore_3
    //   25: ldc 225
    //   27: new 146	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   34: ldc_w 503
    //   37: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: iload_3
    //   41: invokevirtual 490	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   44: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 347	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   50: iload 5
    //   52: istore_2
    //   53: iload_3
    //   54: ifeq +140 -> 194
    //   57: aload_0
    //   58: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   61: invokestatic 506	com/tencent/smtt/utils/Apn:getWifiSSID	(Landroid/content/Context;)Ljava/lang/String;
    //   64: astore 6
    //   66: ldc 225
    //   68: new 146	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   75: ldc_w 508
    //   78: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: aload 6
    //   83: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: invokestatic 347	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: new 510	java/net/URL
    //   95: dup
    //   96: ldc 50
    //   98: invokespecial 511	java/net/URL:<init>	(Ljava/lang/String;)V
    //   101: invokevirtual 515	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   104: checkcast 359	java/net/HttpURLConnection
    //   107: astore 7
    //   109: aload 7
    //   111: iconst_0
    //   112: invokevirtual 519	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   115: aload 7
    //   117: sipush 10000
    //   120: invokevirtual 522	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   123: aload 7
    //   125: sipush 10000
    //   128: invokevirtual 525	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   131: aload 7
    //   133: iconst_0
    //   134: invokevirtual 528	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   137: aload 7
    //   139: invokevirtual 532	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   142: pop
    //   143: aload 7
    //   145: invokevirtual 535	java/net/HttpURLConnection:getResponseCode	()I
    //   148: istore_1
    //   149: ldc 225
    //   151: new 146	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   158: ldc_w 537
    //   161: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: iload_1
    //   165: invokevirtual 325	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   168: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: invokestatic 347	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   174: iload_1
    //   175: sipush 204
    //   178: if_icmpne +122 -> 300
    //   181: iload 4
    //   183: istore_2
    //   184: aload 7
    //   186: ifnull +203 -> 389
    //   189: aload 7
    //   191: invokevirtual 375	java/net/HttpURLConnection:disconnect	()V
    //   194: iload_2
    //   195: ifne +68 -> 263
    //   198: aload 6
    //   200: invokestatic 542	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   203: ifne +60 -> 263
    //   206: aload_0
    //   207: getfield 144	com/tencent/smtt/sdk/TbsApkDownloader:mWifiUnavailableList	Ljava/util/Set;
    //   210: aload 6
    //   212: invokeinterface 546 2 0
    //   217: ifne +46 -> 263
    //   220: aload_0
    //   221: getfield 144	com/tencent/smtt/sdk/TbsApkDownloader:mWifiUnavailableList	Ljava/util/Set;
    //   224: aload 6
    //   226: invokeinterface 549 2 0
    //   231: pop
    //   232: aload_0
    //   233: invokespecial 552	com/tencent/smtt/sdk/TbsApkDownloader:initNetworkDetectorHandlerIfNeeded	()V
    //   236: aload_0
    //   237: getfield 554	com/tencent/smtt/sdk/TbsApkDownloader:mNetworkDetectorHandler	Landroid/os/Handler;
    //   240: sipush 150
    //   243: aload 6
    //   245: invokevirtual 560	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   248: astore 7
    //   250: aload_0
    //   251: getfield 554	com/tencent/smtt/sdk/TbsApkDownloader:mNetworkDetectorHandler	Landroid/os/Handler;
    //   254: aload 7
    //   256: ldc2_w 27
    //   259: invokevirtual 564	android/os/Handler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   262: pop
    //   263: iload_2
    //   264: ifeq +29 -> 293
    //   267: aload_0
    //   268: getfield 144	com/tencent/smtt/sdk/TbsApkDownloader:mWifiUnavailableList	Ljava/util/Set;
    //   271: aload 6
    //   273: invokeinterface 546 2 0
    //   278: ifeq +15 -> 293
    //   281: aload_0
    //   282: getfield 144	com/tencent/smtt/sdk/TbsApkDownloader:mWifiUnavailableList	Ljava/util/Set;
    //   285: aload 6
    //   287: invokeinterface 567 2 0
    //   292: pop
    //   293: iload_2
    //   294: ireturn
    //   295: iconst_0
    //   296: istore_3
    //   297: goto -272 -> 25
    //   300: iconst_0
    //   301: istore_2
    //   302: goto -118 -> 184
    //   305: astore 7
    //   307: goto -113 -> 194
    //   310: astore 8
    //   312: aconst_null
    //   313: astore 7
    //   315: aload 8
    //   317: invokevirtual 568	java/lang/Throwable:printStackTrace	()V
    //   320: aload 7
    //   322: ifnull +61 -> 383
    //   325: aload 7
    //   327: invokevirtual 375	java/net/HttpURLConnection:disconnect	()V
    //   330: iload 5
    //   332: istore_2
    //   333: goto -139 -> 194
    //   336: astore 7
    //   338: iload 5
    //   340: istore_2
    //   341: goto -147 -> 194
    //   344: astore 6
    //   346: aload 8
    //   348: astore 7
    //   350: aload 7
    //   352: ifnull +8 -> 360
    //   355: aload 7
    //   357: invokevirtual 375	java/net/HttpURLConnection:disconnect	()V
    //   360: aload 6
    //   362: athrow
    //   363: astore 7
    //   365: goto -5 -> 360
    //   368: astore 6
    //   370: goto -20 -> 350
    //   373: astore 6
    //   375: goto -25 -> 350
    //   378: astore 8
    //   380: goto -65 -> 315
    //   383: iload 5
    //   385: istore_2
    //   386: goto -192 -> 194
    //   389: goto -195 -> 194
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	392	0	this	TbsApkDownloader
    //   148	31	1	i	int
    //   52	334	2	bool1	boolean
    //   24	273	3	bool2	boolean
    //   7	175	4	bool3	boolean
    //   10	374	5	bool4	boolean
    //   4	282	6	str	String
    //   344	17	6	localObject1	Object
    //   368	1	6	localObject2	Object
    //   373	1	6	localObject3	Object
    //   107	148	7	localObject4	Object
    //   305	1	7	localException1	Exception
    //   313	13	7	localObject5	Object
    //   336	1	7	localException2	Exception
    //   348	8	7	localThrowable1	Throwable
    //   363	1	7	localException3	Exception
    //   1	1	8	localObject6	Object
    //   310	37	8	localThrowable2	Throwable
    //   378	1	8	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   189	194	305	java/lang/Exception
    //   92	109	310	java/lang/Throwable
    //   325	330	336	java/lang/Exception
    //   92	109	344	finally
    //   355	360	363	java/lang/Exception
    //   109	174	368	finally
    //   315	320	373	finally
    //   109	174	378	java/lang/Throwable
  }
  
  private boolean downloadFileExists()
  {
    boolean bool2 = false;
    File localFile = new File(this.mFilePath, "x5.tbs.temp");
    boolean bool1 = bool2;
    if (localFile != null)
    {
      bool1 = bool2;
      if (localFile.exists()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private long downloadFileSize()
  {
    long l2 = 0L;
    File localFile = new File(this.mFilePath, "x5.tbs.temp");
    long l1 = l2;
    if (localFile != null)
    {
      l1 = l2;
      if (localFile.exists()) {
        l1 = localFile.length();
      }
    }
    return l1;
  }
  
  private void downloadSuccess(boolean paramBoolean)
  {
    TbsUtils.createDirectoryTBS(this.mContext);
    Object localObject1 = TbsDownloadConfig.getInstance(this.mContext);
    ((TbsDownloadConfig)localObject1).mSyncMap.put("request_full_package", Boolean.valueOf(false));
    ((TbsDownloadConfig)localObject1).mSyncMap.put("tbs_needdownload", Boolean.valueOf(false));
    ((TbsDownloadConfig)localObject1).mSyncMap.put("tbs_download_interrupt_code_reason", Integer.valueOf(-123));
    ((TbsDownloadConfig)localObject1).commit();
    Object localObject2 = QbSdk.mTbsListenerWrapper;
    if (paramBoolean) {}
    for (int i = 100;; i = 120)
    {
      ((TbsListener)localObject2).onDownloadFinish(i);
      i = ((TbsDownloadConfig)localObject1).mPreferences.getInt("tbs_responsecode", 0);
      paramBoolean = TbsDownloader.isDecoupleCore(this.mContext);
      if (i != 5) {
        break label149;
      }
      localObject1 = gettpatchBundle(i, paramBoolean);
      if (localObject1 != null) {
        break;
      }
      return;
    }
    TbsInstaller.getInstance().installLocalTbsCoreExInThread(this.mContext, (Bundle)localObject1);
    return;
    label149:
    if ((i == 3) || (i > 10000))
    {
      localObject2 = backupApkPath(this.mContext);
      if (localObject2 != null)
      {
        localObject1 = getincrupdateBundle(i, (File)localObject2, paramBoolean);
        TbsInstaller.getInstance().installLocalTbsCoreExInThread(this.mContext, (Bundle)localObject1);
        return;
      }
      clearCache();
      ((TbsDownloadConfig)localObject1).mSyncMap.put("tbs_needdownload", Boolean.valueOf(true));
      ((TbsDownloadConfig)localObject1).commit();
      return;
    }
    i = ((TbsDownloadConfig)localObject1).mPreferences.getInt("tbs_download_version", 0);
    TbsInstaller.getInstance().installTbsCore(this.mContext, new File(this.mFilePath, "x5.tbs").getAbsolutePath(), i);
    backupTbsApk(new File(this.mFilePath, "x5.tbs"), this.mContext);
  }
  
  private String errorToString(Throwable paramThrowable)
  {
    String str = Log.getStackTraceString(paramThrowable);
    paramThrowable = str;
    if (str.length() > 1024) {
      paramThrowable = str.substring(0, 1024);
    }
    return paramThrowable;
  }
  
  private static File getApkFilePath(Context paramContext, int paramInt)
  {
    File localFile = new File(FileUtil.getTBSSdcardFilePath(paramContext, paramInt));
    if ((localFile == null) || (!localFile.exists()) || (!localFile.isDirectory())) {
      return null;
    }
    if (TbsDownloader.getOverSea(paramContext)) {}
    for (paramContext = "x5.oversea.tbs.org";; paramContext = TbsDownloader.getBackupFileName(false))
    {
      paramContext = new File(localFile, paramContext);
      if ((paramContext == null) || (!paramContext.exists())) {
        break;
      }
      return localFile;
    }
    return null;
  }
  
  private File getBackupCorePath()
  {
    String str = FileUtil.getTBSSdcardFilePath(this.mContext, 4);
    if (TbsDownloader.getOverSea(this.mContext)) {}
    for (Object localObject = "x5.oversea.tbs.org";; localObject = TbsDownloader.getBackupFileName(false))
    {
      localObject = new File(str, (String)localObject);
      if (!TbsDownloader.isDecoupleCore(this.mContext)) {
        break;
      }
      return new File(FileUtil.getTBSSdcardFilePath(this.mContext, 4), TbsDownloader.getBackupFileName(true));
    }
    return localObject;
  }
  
  private String getDomainIp(URL paramURL)
  {
    try
    {
      paramURL = InetAddress.getByName(paramURL.getHost()).getHostAddress();
      return paramURL;
    }
    catch (Exception paramURL)
    {
      paramURL.printStackTrace();
      return "";
    }
    catch (Error paramURL)
    {
      paramURL.printStackTrace();
    }
    return "";
  }
  
  @TargetApi(8)
  static File getHostBackupApkPath(Context paramContext)
  {
    try
    {
      if (Build.VERSION.SDK_INT >= 8)
      {
        Object localObject2 = getApkFilePath(paramContext, 4);
        Object localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = getApkFilePath(paramContext, 3);
        }
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = getApkFilePath(paramContext, 2);
        }
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = getApkFilePath(paramContext, 1);
        }
        return localObject1;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      TbsLog.e("TbsDownload", "[TbsApkDownloader.backupApkPath] Exception is " + paramContext.getMessage());
      return null;
    }
    return null;
  }
  
  public static File getLocalTbsFromSdcard(Context paramContext)
  {
    paramContext = new File(FileUtil.getTBSSdcardFilePath(paramContext, 5));
    if ((paramContext == null) || (!paramContext.isDirectory()))
    {
      TbsLog.w("TbsDownload", "[TbsApkDownloader.getLocalTbsFromSdcard] " + paramContext.getAbsolutePath() + "not found!");
      return null;
    }
    paramContext = paramContext.listFiles();
    Pattern localPattern = Pattern.compile("tbs(.*).apk");
    int j = paramContext.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramContext[i];
      if ((localPattern.matcher(localObject.getName()).find()) && (localObject.isFile()) && (localObject.exists()) && (localObject.canRead()))
      {
        TbsLog.w("TbsDownload", "[TbsApkDownloader.getLocalTbsFromSdcard] got tbs apk:" + localObject);
        return localObject;
      }
      i += 1;
    }
    TbsLog.w("TbsDownload", "[TbsApkDownloader.getLocalTbsFromSdcard] No tbs apk found!");
    return null;
  }
  
  private void initHttpRequest(String paramString)
  {
    paramString = new URL(paramString);
    if (this.mHttpRequest != null) {}
    try
    {
      this.mHttpRequest.disconnect();
      this.mHttpRequest = ((HttpURLConnection)paramString.openConnection());
      this.mHttpRequest.setRequestProperty("User-Agent", TbsDownloader.getDefaultUserAgent(this.mContext));
      this.mHttpRequest.setRequestProperty("Accept-Encoding", "identity");
      this.mHttpRequest.setRequestMethod("GET");
      this.mHttpRequest.setInstanceFollowRedirects(false);
      this.mHttpRequest.setConnectTimeout(this.mConnectTimeout);
      this.mHttpRequest.setReadTimeout(this.mReadTimeout);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        TbsLog.e("TbsDownload", "[initHttpRequest] mHttpRequest.disconnect() Throwable:" + localThrowable.toString());
      }
    }
  }
  
  private void initNetworkDetectorHandlerIfNeeded()
  {
    if (this.mNetworkDetectorHandler == null) {
      this.mNetworkDetectorHandler = new TbsApkDownloader.1(this, TbsHandlerThread.getInstance().getLooper());
    }
  }
  
  /* Error */
  private boolean ping()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 9
    //   9: invokestatic 728	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   12: astore 5
    //   14: aload 5
    //   16: new 146	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   23: ldc_w 730
    //   26: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc_w 732
    //   32: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokevirtual 736	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   41: invokevirtual 739	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   44: astore 5
    //   46: new 741	java/io/InputStreamReader
    //   49: dup
    //   50: aload 5
    //   52: invokespecial 744	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   55: astore 7
    //   57: new 746	java/io/BufferedReader
    //   60: dup
    //   61: aload 7
    //   63: invokespecial 749	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   66: astore 6
    //   68: iconst_0
    //   69: istore_1
    //   70: aload 6
    //   72: invokevirtual 752	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   75: astore 8
    //   77: iload 4
    //   79: istore_3
    //   80: aload 8
    //   82: ifnull +29 -> 111
    //   85: aload 8
    //   87: ldc_w 754
    //   90: invokevirtual 285	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   93: ifne +16 -> 109
    //   96: aload 8
    //   98: ldc_w 756
    //   101: invokevirtual 285	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   104: istore_3
    //   105: iload_3
    //   106: ifeq +25 -> 131
    //   109: iconst_1
    //   110: istore_3
    //   111: aload_0
    //   112: aload 5
    //   114: invokespecial 758	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   117: aload_0
    //   118: aload 7
    //   120: invokespecial 758	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   123: aload_0
    //   124: aload 6
    //   126: invokespecial 758	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   129: iload_3
    //   130: ireturn
    //   131: iload_1
    //   132: iconst_1
    //   133: iadd
    //   134: istore_2
    //   135: iload_2
    //   136: istore_1
    //   137: iload_2
    //   138: iconst_5
    //   139: if_icmplt -69 -> 70
    //   142: iload 4
    //   144: istore_3
    //   145: goto -34 -> 111
    //   148: astore 7
    //   150: aconst_null
    //   151: astore 5
    //   153: aconst_null
    //   154: astore 6
    //   156: aload 9
    //   158: astore 8
    //   160: aload 7
    //   162: invokevirtual 568	java/lang/Throwable:printStackTrace	()V
    //   165: aload_0
    //   166: aload 6
    //   168: invokespecial 758	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   171: aload_0
    //   172: aload 8
    //   174: invokespecial 758	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   177: aload_0
    //   178: aload 5
    //   180: invokespecial 758	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   183: iconst_0
    //   184: ireturn
    //   185: astore 6
    //   187: aconst_null
    //   188: astore 7
    //   190: aconst_null
    //   191: astore 5
    //   193: aload_0
    //   194: aload 5
    //   196: invokespecial 758	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   199: aload_0
    //   200: aload 7
    //   202: invokespecial 758	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   205: aload_0
    //   206: aload 8
    //   208: invokespecial 758	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   211: aload 6
    //   213: athrow
    //   214: astore 6
    //   216: aconst_null
    //   217: astore 7
    //   219: goto -26 -> 193
    //   222: astore 6
    //   224: goto -31 -> 193
    //   227: astore 9
    //   229: aload 6
    //   231: astore 8
    //   233: aload 9
    //   235: astore 6
    //   237: goto -44 -> 193
    //   240: astore 10
    //   242: aload 6
    //   244: astore 9
    //   246: aload 8
    //   248: astore 7
    //   250: aload 10
    //   252: astore 6
    //   254: aload 5
    //   256: astore 8
    //   258: aload 9
    //   260: astore 5
    //   262: goto -69 -> 193
    //   265: astore 7
    //   267: aconst_null
    //   268: astore 8
    //   270: aload 5
    //   272: astore 6
    //   274: aload 8
    //   276: astore 5
    //   278: aload 9
    //   280: astore 8
    //   282: goto -122 -> 160
    //   285: astore 10
    //   287: aconst_null
    //   288: astore 9
    //   290: aload 7
    //   292: astore 8
    //   294: aload 5
    //   296: astore 6
    //   298: aload 10
    //   300: astore 7
    //   302: aload 9
    //   304: astore 5
    //   306: goto -146 -> 160
    //   309: astore 10
    //   311: aload 7
    //   313: astore 8
    //   315: aload 5
    //   317: astore 9
    //   319: aload 10
    //   321: astore 7
    //   323: aload 6
    //   325: astore 5
    //   327: aload 9
    //   329: astore 6
    //   331: goto -171 -> 160
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	334	0	this	TbsApkDownloader
    //   69	68	1	i	int
    //   134	6	2	j	int
    //   79	66	3	bool1	boolean
    //   1	142	4	bool2	boolean
    //   12	314	5	localObject1	Object
    //   66	101	6	localBufferedReader	java.io.BufferedReader
    //   185	27	6	localObject2	Object
    //   214	1	6	localObject3	Object
    //   222	8	6	localObject4	Object
    //   235	95	6	localObject5	Object
    //   55	64	7	localInputStreamReader	java.io.InputStreamReader
    //   148	13	7	localThrowable1	Throwable
    //   188	61	7	localObject6	Object
    //   265	26	7	localThrowable2	Throwable
    //   300	22	7	localObject7	Object
    //   4	310	8	localObject8	Object
    //   7	150	9	localObject9	Object
    //   227	7	9	localObject10	Object
    //   244	84	9	localObject11	Object
    //   240	11	10	localObject12	Object
    //   285	14	10	localThrowable3	Throwable
    //   309	11	10	localThrowable4	Throwable
    // Exception table:
    //   from	to	target	type
    //   14	46	148	java/lang/Throwable
    //   14	46	185	finally
    //   46	57	214	finally
    //   57	68	222	finally
    //   70	77	227	finally
    //   85	105	227	finally
    //   160	165	240	finally
    //   46	57	265	java/lang/Throwable
    //   57	68	285	java/lang/Throwable
    //   70	77	309	java/lang/Throwable
    //   85	105	309	java/lang/Throwable
  }
  
  private void resetArgs()
  {
    this.mRetryTimes = 0;
    this.mRetryTimes302 = 0;
    this.mContentLength = -1L;
    this.mLocation = null;
    this.mHasTmpTryNoRange = false;
    this.mCanceled = false;
    this.mFinished = false;
    this.mNeedDownloadStat = false;
  }
  
  private void retry(long paramLong)
  {
    this.mRetryTimes += 1;
    long l = paramLong;
    if (paramLong <= 0L) {}
    try
    {
      l = retryInterval();
      Thread.sleep(l);
      return;
    }
    catch (Exception localException) {}
  }
  
  private long retryInterval()
  {
    switch (this.mRetryTimes)
    {
    default: 
      return 20000L * 10L;
    case 1: 
    case 2: 
      return 20000L * this.mRetryTimes;
    }
    return 20000L * 5L;
  }
  
  private long saveDownloadDataStat(long paramLong1, long paramLong2)
  {
    long l = System.currentTimeMillis();
    this.mDownloadStat.setDownConsumeTime(l - paramLong1);
    this.mDownloadStat.setDownloadSize(paramLong2);
    return l;
  }
  
  private void setDownloadStat(int paramInt, String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) || (this.mRetryTimes > this.mMaxRetryTimes))
    {
      this.mDownloadStat.setErrorCode(paramInt);
      this.mDownloadStat.setFailDetail(paramString);
    }
  }
  
  private boolean verifyTBSApkBackuped(File paramFile)
  {
    int j = TbsDownloadConfig.getInstance(this.mContext).mPreferences.getInt("use_backup_version", 0);
    int i = j;
    if (j == 0) {
      i = TbsDownloadConfig.getInstance(this.mContext).mPreferences.getInt("tbs_download_version", 0);
    }
    return ApkUtil.verifyTbsApk(this.mContext, paramFile, 0L, i);
  }
  
  private boolean verifyTbsApk(boolean paramBoolean1, boolean paramBoolean2)
  {
    long l2 = 0L;
    TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] isTempFile=" + paramBoolean1);
    Object localObject2 = this.mFilePath;
    Object localObject1;
    if (!paramBoolean1)
    {
      localObject1 = "x5.tbs";
      localObject1 = new File((File)localObject2, (String)localObject1);
      if (((File)localObject1).exists()) {
        break label72;
      }
    }
    label72:
    Object localObject3;
    do
    {
      return false;
      localObject1 = "x5.tbs.temp";
      break;
      localObject2 = TbsDownloadConfig.getInstance(this.mContext).mPreferences.getString("tbs_apk_md5", null);
      localObject3 = ApkUtil.getMd5((File)localObject1);
      if ((localObject2 != null) && (((String)localObject2).equals(localObject3))) {
        break label162;
      }
      TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] isTempFile=" + paramBoolean1 + " md5 failed");
    } while (!paramBoolean1);
    this.mDownloadStat.setCheckErrorDetail("fileMd5 not match");
    return false;
    label162:
    TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] md5(" + (String)localObject3 + ") successful!");
    long l1 = l2;
    long l3;
    if (paramBoolean1)
    {
      l3 = TbsDownloadConfig.getInstance(this.mContext).mPreferences.getLong("tbs_apkfilesize", 0L);
      if ((localObject1 == null) || (!((File)localObject1).exists())) {
        break label756;
      }
      l1 = l2;
      if (l3 > 0L)
      {
        l1 = ((File)localObject1).length();
        if (l3 == l1) {}
      }
    }
    for (;;)
    {
      TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] isTempFile=" + paramBoolean1 + " filelength failed");
      this.mDownloadStat.setCheckErrorDetail("fileLength:" + l1 + ",contentLength:" + l3);
      return false;
      TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] length(" + l1 + ") successful!");
      int j = -1;
      int i = j;
      if (paramBoolean2)
      {
        i = j;
        if (!paramBoolean1)
        {
          j = ApkUtil.getApkVersion(this.mContext, (File)localObject1);
          int k = TbsDownloadConfig.getInstance(this.mContext).mPreferences.getInt("tbs_download_version", 0);
          i = j;
          if (k != j)
          {
            TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] isTempFile=" + paramBoolean1 + " versionCode failed");
            if (!paramBoolean1) {
              break;
            }
            this.mDownloadStat.setCheckErrorDetail("fileVersion:" + j + ",configVersion:" + k);
            return false;
          }
        }
      }
      TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] tbsApkVersionCode(" + i + ") successful!");
      if ((paramBoolean2) && (!paramBoolean1))
      {
        String str = AppUtil.getSignatureFromApk(this.mContext, false, (File)localObject1);
        if (!"3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a".equals(str))
        {
          TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] isTempFile=" + paramBoolean1 + " signature failed");
          if (!paramBoolean1) {
            break;
          }
          localObject2 = this.mDownloadStat;
          localObject3 = new StringBuilder().append("signature:");
          if (str == null) {}
          for (localObject1 = "null";; localObject1 = Integer.valueOf(str.length()))
          {
            ((TbsLogReport.TbsLogInfo)localObject2).setCheckErrorDetail(localObject1);
            return false;
          }
        }
      }
      TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] signature successful!");
      if (paramBoolean1)
      {
        try
        {
          paramBoolean1 = ((File)localObject1).renameTo(new File(this.mFilePath, "x5.tbs"));
          localObject1 = null;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            paramBoolean1 = false;
          }
        }
        paramBoolean2 = paramBoolean1;
        if (paramBoolean1) {
          break label723;
        }
        setDownloadStat(109, errorToString((Throwable)localObject1), true);
        return false;
      }
      paramBoolean2 = false;
      label723:
      TbsLog.i("TbsDownload", "[TbsApkDownloader.verifyTbsApk] rename(" + paramBoolean2 + ") successful!");
      return true;
      label756:
      l1 = 0L;
    }
  }
  
  public int backupApkVersion(boolean paramBoolean)
  {
    File localFile = backupApkPath(this.mContext);
    if (paramBoolean) {
      if (localFile != null) {}
    }
    while (localFile == null)
    {
      return 0;
      return ApkUtil.getApkVersion(this.mContext, new File(localFile, TbsDownloader.getBackupFileName(true)));
    }
    Context localContext = this.mContext;
    if (TbsDownloader.getOverSea(this.mContext)) {}
    for (String str = "x5.oversea.tbs.org";; str = TbsDownloader.getBackupFileName(false)) {
      return ApkUtil.getApkVersion(localContext, new File(localFile, str));
    }
  }
  
  public void clearCache()
  {
    stopDownload();
    deleteFile(false);
    deleteFile(true);
  }
  
  public Bundle getincrupdateBundle(int paramInt, File paramFile, boolean paramBoolean)
  {
    int i;
    if (paramBoolean)
    {
      paramFile = new File(paramFile, TbsDownloader.getBackupFileName(true));
      i = ApkUtil.getApkVersion(this.mContext, paramFile);
      localObject = new File(this.mFilePath, "x5.tbs");
      if (!((File)localObject).exists()) {
        break label188;
      }
    }
    label188:
    for (Object localObject = ((File)localObject).getAbsolutePath();; localObject = null)
    {
      int j = TbsDownloadConfig.getInstance(this.mContext).mPreferences.getInt("tbs_download_version", 0);
      Bundle localBundle = new Bundle();
      localBundle.putInt("operation", paramInt);
      localBundle.putInt("old_core_ver", i);
      localBundle.putInt("new_core_ver", j);
      localBundle.putString("old_apk_location", paramFile.getAbsolutePath());
      localBundle.putString("new_apk_location", (String)localObject);
      localBundle.putString("diff_file_location", (String)localObject);
      return localBundle;
      if (TbsDownloader.getOverSea(this.mContext)) {}
      for (localObject = "x5.oversea.tbs.org";; localObject = TbsDownloader.getBackupFileName(false))
      {
        paramFile = new File(paramFile, (String)localObject);
        break;
      }
    }
  }
  
  public Bundle gettpatchBundle(int paramInt, boolean paramBoolean)
  {
    Object localObject1;
    int i;
    if (paramBoolean)
    {
      localObject1 = TbsInstaller.getInstance().getCoreShareDecoupleDir(this.mContext);
      i = TbsInstaller.getInstance().getTbsCoreShareDecoupleCoreVersion(this.mContext);
      localObject2 = new File(this.mFilePath, "x5.tbs");
      if (!((File)localObject2).exists()) {
        break label90;
      }
    }
    label90:
    for (Object localObject2 = ((File)localObject2).getAbsolutePath();; localObject2 = null)
    {
      if (localObject2 != null) {
        break label96;
      }
      return null;
      localObject1 = TbsInstaller.getInstance().getTbsCoreShareDir(this.mContext);
      i = TbsInstaller.getInstance().getTbsCoreInstalledVerInNolock(this.mContext);
      break;
    }
    label96:
    int j = TbsDownloadConfig.getInstance(this.mContext).mPreferences.getInt("tbs_download_version", 0);
    if (paramBoolean) {}
    for (File localFile = TbsInstaller.getInstance().getCoreDir(this.mContext, 6);; localFile = TbsInstaller.getInstance().getCoreDir(this.mContext, 5))
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("operation", paramInt);
      localBundle.putInt("old_core_ver", i);
      localBundle.putInt("new_core_ver", j);
      localBundle.putString("old_apk_location", ((File)localObject1).getAbsolutePath());
      localBundle.putString("new_apk_location", localFile.getAbsolutePath());
      localBundle.putString("diff_file_location", (String)localObject2);
      localObject1 = FileUtil.getTBSSdcardFilePath(this.mContext, 7);
      localObject2 = new File((String)localObject1);
      if (!((File)localObject2).exists()) {
        ((File)localObject2).mkdirs();
      }
      localBundle.putString("backup_apk", new File((String)localObject1, j + ".tbs").getAbsolutePath());
      return localBundle;
    }
  }
  
  public boolean hasSameTbsDownloading()
  {
    bool1 = true;
    for (;;)
    {
      try
      {
        l1 = System.currentTimeMillis();
        j = TbsDownloadConfig.getInstance(this.mContext).mPreferences.getInt("tbs_download_version", 0);
        String[] arrayOfString = TBS_DOWNLOADING_APP_KEYS;
        int k = arrayOfString.length;
        i = 0;
        if (i >= k) {
          continue;
        }
        localObject1 = arrayOfString[i];
        boolean bool2 = ((String)localObject1).equals(this.mLocalDownloadingKey);
        if (bool2) {
          continue;
        }
      }
      catch (Exception localException)
      {
        long l1;
        int j;
        int i;
        Object localObject1;
        Object localObject2;
        localException.printStackTrace();
        bool1 = false;
        continue;
      }
      try
      {
        localObject1 = Settings.System.getString(this.mContext.getContentResolver(), (String)localObject1);
        if (localObject1 != null)
        {
          localObject1 = ((String)localObject1).split("\\|");
          Object localObject3 = localObject1[0];
          long l2 = Long.parseLong(localObject1[1]);
          if ((localObject3 != null) && (localObject3.equals(String.valueOf(j))) && (l2 > 0L))
          {
            long l3 = TbsDownloadConfig.getInstance(this.mContext).getDownloadSingleTimeout();
            if (l1 - l2 < l3)
            {
              TbsLog.i("TbsDownload", "[TbsApkDownloader.hasSameTbsDownloading] result=" + bool1);
              return bool1;
            }
          }
        }
      }
      catch (SecurityException localSecurityException)
      {
        localSecurityException.printStackTrace();
        localObject2 = null;
        continue;
      }
      i += 1;
    }
  }
  
  public boolean installBackupTbsApk(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (Build.VERSION.SDK_INT == 23) {}
    label73:
    label334:
    label336:
    label352:
    label358:
    label378:
    do
    {
      return false;
      int i = TbsDownloadConfig.getInstance(this.mContext).mPreferences.getInt("use_backup_version", 0);
      int j = TbsInstaller.getInstance().getTbsCoreInstalledVerInNolock(this.mContext);
      File localFile;
      Object localObject;
      if (i == 0)
      {
        i = TbsDownloadConfig.getInstance(this.mContext).mPreferences.getInt("tbs_download_version", 0);
        this.localInstallMessage = "by default key";
        if ((i == 0) || (i == j)) {
          break label334;
        }
        if (!paramBoolean2) {
          break label427;
        }
        localFile = TbsDownloader.getExistBackupCore(i);
        if ((localFile == null) || (!localFile.exists())) {
          break label352;
        }
        String str = FileUtil.getTBSSdcardFilePath(this.mContext, 4);
        if (!TbsDownloader.getOverSea(this.mContext)) {
          break label336;
        }
        localObject = "x5.oversea.tbs.org";
        localObject = new File(str, (String)localObject);
      }
      for (;;)
      {
        try
        {
          if (TbsDownloadConfig.getInstance(this.mContext).mPreferences.getInt("tbs_download_version_type", 0) == 1) {
            break label352;
          }
          FileUtil.copyFiles(localFile, (File)localObject);
          j = 1;
          localObject = getBackupCorePath();
          if ((localObject == null) || (!((File)localObject).exists()) || (!verifyTBSApkBackuped((File)localObject))) {
            break label378;
          }
          if (!copyTbsApkFromBackupToInstall(i)) {
            break label427;
          }
          TbsDownloadConfig.getInstance(this.mContext).mSyncMap.put("tbs_download_interrupt_code_reason", Integer.valueOf(-214));
          TbsDownloadConfig.getInstance(this.mContext).setDownloadInterruptCode(-214);
          downloadSuccess(false);
          if (j != 0)
          {
            setDownloadStat(100, "use local backup apk in startDownload" + this.localInstallMessage, true);
            if (!TbsDownloader.isDecoupleCore(this.mContext)) {
              break label358;
            }
            TbsLogReport.getInstance(this.mContext).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD_DECOUPLE, this.mDownloadStat);
            this.mDownloadStat.resetArgs();
          }
          return true;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        this.localInstallMessage = "by new key";
        break label73;
        break;
        localObject = TbsDownloader.getBackupFileName(false);
        break label130;
        j = 0;
        continue;
        TbsLogReport.getInstance(this.mContext).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, this.mDownloadStat);
      }
      deleteFileBackuped();
      if ((localFile != null) && (localFile.exists()) && (!ApkUtil.verifyTbsApk(this.mContext, localFile, 0L, i)) && (localFile != null) && (localFile.exists())) {
        FileUtil.delete(localFile);
      }
      if (verifyTbsApk(false, paramBoolean2))
      {
        TbsDownloadConfig.getInstance(this.mContext).mSyncMap.put("tbs_download_interrupt_code_reason", Integer.valueOf(-214));
        TbsDownloadConfig.getInstance(this.mContext).setDownloadInterruptCode(-214);
        downloadSuccess(false);
        return true;
      }
    } while ((deleteFile(true)) || (deleteFile(true)));
    label130:
    label427:
    TbsLog.e("TbsDownload", "[TbsApkDownloader] delete file failed!");
    TbsDownloadConfig.getInstance(this.mContext).setDownloadInterruptCode(-301);
    return false;
  }
  
  public boolean isDownloadForeground()
  {
    TbsLog.i("TbsDownload", "[TbsApkDownloader.isDownloadForeground] mIsDownloadForeground=" + this.mIsDownloadForeground);
    return this.mIsDownloadForeground;
  }
  
  public void removeTbsApkIfNeeded(int paramInt)
  {
    if (TbsInstaller.getInstance().getTbsInstallingFileLock(this.mContext)) {
      TbsInstaller.getInstance().releaseTbsInstallingFileLock();
    }
    try
    {
      File localFile = new File(this.mFilePath, "x5.tbs");
      int i = ApkUtil.getApkVersion(this.mContext, localFile);
      if ((-1 == i) || ((paramInt > 0) && (paramInt == i))) {
        FileUtil.delete(localFile);
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void startDownload(boolean paramBoolean)
  {
    startDownload(paramBoolean, false);
  }
  
  /* Error */
  public void startDownload(boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: invokestatic 165	com/tencent/smtt/sdk/TbsInstaller:getInstance	()Lcom/tencent/smtt/sdk/TbsInstaller;
    //   3: aload_0
    //   4: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   7: invokevirtual 1003	com/tencent/smtt/sdk/TbsInstaller:isTbsLocalInstalled	(Landroid/content/Context;)Z
    //   10: ifeq +25 -> 35
    //   13: iload_1
    //   14: ifne +21 -> 35
    //   17: iconst_0
    //   18: putstatic 464	com/tencent/smtt/sdk/TbsDownloader:mIsDownloading	Z
    //   21: aload_0
    //   22: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   25: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   28: sipush -322
    //   31: invokevirtual 972	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   34: return
    //   35: aload_0
    //   36: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   39: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   42: getfield 252	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   45: ldc_w 338
    //   48: iconst_0
    //   49: invokeinterface 260 3 0
    //   54: istore_3
    //   55: iload_3
    //   56: iconst_1
    //   57: if_icmpeq +13 -> 70
    //   60: iload_3
    //   61: iconst_2
    //   62: if_icmpeq +8 -> 70
    //   65: iload_3
    //   66: iconst_4
    //   67: if_icmpne +25 -> 92
    //   70: iconst_1
    //   71: istore 8
    //   73: iload_2
    //   74: ifne +24 -> 98
    //   77: aload_0
    //   78: iload_1
    //   79: iload 8
    //   81: invokevirtual 1005	com/tencent/smtt/sdk/TbsApkDownloader:installBackupTbsApk	(ZZ)Z
    //   84: ifeq +14 -> 98
    //   87: iconst_0
    //   88: putstatic 464	com/tencent/smtt/sdk/TbsDownloader:mIsDownloading	Z
    //   91: return
    //   92: iconst_0
    //   93: istore 8
    //   95: goto -22 -> 73
    //   98: aload_0
    //   99: iload_1
    //   100: putfield 989	com/tencent/smtt/sdk/TbsApkDownloader:mIsDownloadForeground	Z
    //   103: aload_0
    //   104: aload_0
    //   105: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   108: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   111: getfield 252	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   114: ldc_w 1007
    //   117: aconst_null
    //   118: invokeinterface 812 3 0
    //   123: putfield 1009	com/tencent/smtt/sdk/TbsApkDownloader:mDownloadUrl	Ljava/lang/String;
    //   126: aload_0
    //   127: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   130: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   133: getfield 252	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   136: ldc_w 1011
    //   139: aconst_null
    //   140: invokeinterface 812 3 0
    //   145: astore 27
    //   147: ldc 225
    //   149: new 146	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   156: ldc_w 1013
    //   159: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload 27
    //   164: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: iconst_1
    //   171: invokestatic 1016	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   174: aload_0
    //   175: aconst_null
    //   176: putfield 117	com/tencent/smtt/sdk/TbsApkDownloader:urlArray	[Ljava/lang/String;
    //   179: aload_0
    //   180: iconst_0
    //   181: putfield 119	com/tencent/smtt/sdk/TbsApkDownloader:curUrlIndex	I
    //   184: iload_1
    //   185: ifne +37 -> 222
    //   188: aload 27
    //   190: ifnull +32 -> 222
    //   193: ldc_w 398
    //   196: aload 27
    //   198: invokevirtual 1019	java/lang/String:trim	()Ljava/lang/String;
    //   201: invokevirtual 413	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   204: ifne +18 -> 222
    //   207: aload_0
    //   208: aload 27
    //   210: invokevirtual 1019	java/lang/String:trim	()Ljava/lang/String;
    //   213: ldc_w 1021
    //   216: invokevirtual 941	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   219: putfield 117	com/tencent/smtt/sdk/TbsApkDownloader:urlArray	[Ljava/lang/String;
    //   222: ldc 225
    //   224: new 146	java/lang/StringBuilder
    //   227: dup
    //   228: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   231: ldc_w 1023
    //   234: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: aload_0
    //   238: getfield 1009	com/tencent/smtt/sdk/TbsApkDownloader:mDownloadUrl	Ljava/lang/String;
    //   241: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: ldc_w 1025
    //   247: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: aload 27
    //   252: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: ldc_w 1027
    //   258: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: aload_0
    //   262: getfield 768	com/tencent/smtt/sdk/TbsApkDownloader:mLocation	Ljava/lang/String;
    //   265: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: ldc_w 1029
    //   271: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: aload_0
    //   275: getfield 357	com/tencent/smtt/sdk/TbsApkDownloader:mCanceled	Z
    //   278: invokevirtual 490	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   281: ldc_w 1031
    //   284: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: aload_0
    //   288: getfield 355	com/tencent/smtt/sdk/TbsApkDownloader:mHttpRequest	Ljava/net/HttpURLConnection;
    //   291: invokevirtual 686	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   294: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   297: invokestatic 347	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   300: aload_0
    //   301: getfield 1009	com/tencent/smtt/sdk/TbsApkDownloader:mDownloadUrl	Ljava/lang/String;
    //   304: ifnonnull +34 -> 338
    //   307: aload_0
    //   308: getfield 768	com/tencent/smtt/sdk/TbsApkDownloader:mLocation	Ljava/lang/String;
    //   311: ifnonnull +27 -> 338
    //   314: getstatic 447	com/tencent/smtt/sdk/QbSdk:mTbsListenerWrapper	Lcom/tencent/smtt/sdk/TbsListener;
    //   317: bipush 110
    //   319: invokeinterface 452 2 0
    //   324: aload_0
    //   325: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   328: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   331: sipush -302
    //   334: invokevirtual 972	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   337: return
    //   338: aload_0
    //   339: getfield 355	com/tencent/smtt/sdk/TbsApkDownloader:mHttpRequest	Ljava/net/HttpURLConnection;
    //   342: ifnull +34 -> 376
    //   345: aload_0
    //   346: getfield 357	com/tencent/smtt/sdk/TbsApkDownloader:mCanceled	Z
    //   349: ifne +27 -> 376
    //   352: getstatic 447	com/tencent/smtt/sdk/QbSdk:mTbsListenerWrapper	Lcom/tencent/smtt/sdk/TbsListener;
    //   355: bipush 110
    //   357: invokeinterface 452 2 0
    //   362: aload_0
    //   363: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   366: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   369: sipush -303
    //   372: invokevirtual 972	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   375: return
    //   376: iload_1
    //   377: ifne +54 -> 431
    //   380: aload_0
    //   381: getfield 144	com/tencent/smtt/sdk/TbsApkDownloader:mWifiUnavailableList	Ljava/util/Set;
    //   384: aload_0
    //   385: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   388: invokestatic 506	com/tencent/smtt/utils/Apn:getWifiSSID	(Landroid/content/Context;)Ljava/lang/String;
    //   391: invokeinterface 546 2 0
    //   396: ifeq +35 -> 431
    //   399: ldc 225
    //   401: ldc_w 1033
    //   404: invokestatic 347	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   407: getstatic 447	com/tencent/smtt/sdk/QbSdk:mTbsListenerWrapper	Lcom/tencent/smtt/sdk/TbsListener;
    //   410: bipush 110
    //   412: invokeinterface 452 2 0
    //   417: aload_0
    //   418: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   421: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   424: sipush -304
    //   427: invokevirtual 972	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   430: return
    //   431: aload_0
    //   432: invokespecial 181	com/tencent/smtt/sdk/TbsApkDownloader:resetArgs	()V
    //   435: ldc 225
    //   437: ldc_w 1035
    //   440: iconst_1
    //   441: invokestatic 1016	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   444: aload_0
    //   445: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   448: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   451: invokevirtual 1038	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMaxflow	()J
    //   454: lstore 25
    //   456: iconst_0
    //   457: istore_2
    //   458: aload_0
    //   459: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   462: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   465: getfield 252	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   468: ldc_w 1040
    //   471: lconst_0
    //   472: invokeinterface 833 4 0
    //   477: lstore 11
    //   479: iload_1
    //   480: ifeq +216 -> 696
    //   483: aload_0
    //   484: getstatic 90	com/tencent/smtt/sdk/TbsApkDownloader:MAX_RETRY_TIMES_FOREGROUND	I
    //   487: putfield 115	com/tencent/smtt/sdk/TbsApkDownloader:mMaxRetryTimes	I
    //   490: aload_0
    //   491: getfield 760	com/tencent/smtt/sdk/TbsApkDownloader:mRetryTimes	I
    //   494: aload_0
    //   495: getfield 115	com/tencent/smtt/sdk/TbsApkDownloader:mMaxRetryTimes	I
    //   498: if_icmple +208 -> 706
    //   501: iload_2
    //   502: istore 5
    //   504: aload_0
    //   505: getfield 357	com/tencent/smtt/sdk/TbsApkDownloader:mCanceled	Z
    //   508: ifne +183 -> 691
    //   511: iload 5
    //   513: istore_1
    //   514: aload_0
    //   515: getfield 772	com/tencent/smtt/sdk/TbsApkDownloader:mFinished	Z
    //   518: ifeq +102 -> 620
    //   521: iload 5
    //   523: istore_1
    //   524: aload_0
    //   525: getfield 117	com/tencent/smtt/sdk/TbsApkDownloader:urlArray	[Ljava/lang/String;
    //   528: ifnonnull +19 -> 547
    //   531: iload 5
    //   533: istore_1
    //   534: iload 5
    //   536: ifne +11 -> 547
    //   539: aload_0
    //   540: iconst_1
    //   541: iload 8
    //   543: invokespecial 982	com/tencent/smtt/sdk/TbsApkDownloader:verifyTbsApk	(ZZ)Z
    //   546: istore_1
    //   547: aload_0
    //   548: getfield 139	com/tencent/smtt/sdk/TbsApkDownloader:mDownloadStat	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   551: astore 27
    //   553: iload_1
    //   554: ifeq +5682 -> 6236
    //   557: iconst_1
    //   558: istore_3
    //   559: aload 27
    //   561: iload_3
    //   562: invokevirtual 1043	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setUnpkgFlag	(I)V
    //   565: iload 8
    //   567: ifne +5679 -> 6246
    //   570: aload_0
    //   571: getfield 139	com/tencent/smtt/sdk/TbsApkDownloader:mDownloadStat	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   574: astore 27
    //   576: iload_1
    //   577: ifeq +5664 -> 6241
    //   580: iconst_1
    //   581: istore_3
    //   582: aload 27
    //   584: iload_3
    //   585: invokevirtual 1046	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setPatchUpdateFlag	(I)V
    //   588: iload_1
    //   589: ifeq +5668 -> 6257
    //   592: aload_0
    //   593: iconst_1
    //   594: invokespecial 974	com/tencent/smtt/sdk/TbsApkDownloader:downloadSuccess	(Z)V
    //   597: aload_0
    //   598: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   601: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   604: sipush -317
    //   607: invokevirtual 972	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   610: aload_0
    //   611: bipush 100
    //   613: ldc_w 1048
    //   616: iconst_1
    //   617: invokespecial 427	com/tencent/smtt/sdk/TbsApkDownloader:setDownloadStat	(ILjava/lang/String;Z)V
    //   620: aload_0
    //   621: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   624: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   627: astore 27
    //   629: iload_1
    //   630: ifeq +5649 -> 6279
    //   633: aload 27
    //   635: getfield 252	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   638: ldc_w 1050
    //   641: iconst_0
    //   642: invokeinterface 260 3 0
    //   647: istore_3
    //   648: aload 27
    //   650: getfield 583	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   653: ldc_w 1050
    //   656: iload_3
    //   657: iconst_1
    //   658: iadd
    //   659: invokestatic 606	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   662: invokeinterface 597 3 0
    //   667: pop
    //   668: aload 27
    //   670: invokevirtual 609	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   673: aload_0
    //   674: getfield 139	com/tencent/smtt/sdk/TbsApkDownloader:mDownloadStat	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   677: astore 27
    //   679: iload_1
    //   680: ifeq +5660 -> 6340
    //   683: iconst_1
    //   684: istore_3
    //   685: aload 27
    //   687: iload_3
    //   688: invokevirtual 1053	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setDownFinalFlag	(I)V
    //   691: aload_0
    //   692: invokespecial 1055	com/tencent/smtt/sdk/TbsApkDownloader:closeHttpRequest	()V
    //   695: return
    //   696: aload_0
    //   697: getstatic 88	com/tencent/smtt/sdk/TbsApkDownloader:MAX_RETRY_TIMES_DEFAULT	I
    //   700: putfield 115	com/tencent/smtt/sdk/TbsApkDownloader:mMaxRetryTimes	I
    //   703: goto -213 -> 490
    //   706: aload_0
    //   707: getfield 762	com/tencent/smtt/sdk/TbsApkDownloader:mRetryTimes302	I
    //   710: bipush 8
    //   712: if_icmple +30 -> 742
    //   715: aload_0
    //   716: bipush 123
    //   718: aconst_null
    //   719: iconst_1
    //   720: invokespecial 427	com/tencent/smtt/sdk/TbsApkDownloader:setDownloadStat	(ILjava/lang/String;Z)V
    //   723: aload_0
    //   724: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   727: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   730: sipush -306
    //   733: invokevirtual 972	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   736: iload_2
    //   737: istore 5
    //   739: goto -235 -> 504
    //   742: invokestatic 386	java/lang/System:currentTimeMillis	()J
    //   745: lstore 23
    //   747: lload 11
    //   749: lstore 9
    //   751: iload_1
    //   752: ifne +441 -> 1193
    //   755: lload 11
    //   757: lstore 15
    //   759: iload_2
    //   760: istore 5
    //   762: lload 11
    //   764: lstore 13
    //   766: lload 23
    //   768: aload_0
    //   769: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   772: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   775: getfield 252	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   778: ldc_w 1057
    //   781: lconst_0
    //   782: invokeinterface 833 4 0
    //   787: lsub
    //   788: ldc2_w 14
    //   791: lcmp
    //   792: ifle +246 -> 1038
    //   795: lload 11
    //   797: lstore 15
    //   799: iload_2
    //   800: istore 5
    //   802: lload 11
    //   804: lstore 13
    //   806: ldc 225
    //   808: ldc_w 1059
    //   811: invokestatic 347	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   814: lload 11
    //   816: lstore 15
    //   818: iload_2
    //   819: istore 5
    //   821: lload 11
    //   823: lstore 13
    //   825: aload_0
    //   826: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   829: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   832: getfield 583	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   835: ldc_w 1057
    //   838: lload 23
    //   840: invokestatic 1062	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   843: invokeinterface 597 3 0
    //   848: pop
    //   849: lload 11
    //   851: lstore 15
    //   853: iload_2
    //   854: istore 5
    //   856: lload 11
    //   858: lstore 13
    //   860: aload_0
    //   861: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   864: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   867: getfield 583	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   870: ldc_w 1040
    //   873: lconst_0
    //   874: invokestatic 1062	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   877: invokeinterface 597 3 0
    //   882: pop
    //   883: lload 11
    //   885: lstore 15
    //   887: iload_2
    //   888: istore 5
    //   890: lload 11
    //   892: lstore 13
    //   894: aload_0
    //   895: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   898: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   901: invokevirtual 609	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   904: lconst_0
    //   905: lstore 9
    //   907: iload_2
    //   908: istore 5
    //   910: lload 9
    //   912: lstore 11
    //   914: lload 9
    //   916: lstore 13
    //   918: aload_0
    //   919: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   922: invokestatic 1065	com/tencent/smtt/utils/FileUtil:hasEnoughFreeSpace	(Landroid/content/Context;)Z
    //   925: ifne +268 -> 1193
    //   928: iload_2
    //   929: istore 5
    //   931: lload 9
    //   933: lstore 11
    //   935: lload 9
    //   937: lstore 13
    //   939: ldc 225
    //   941: ldc_w 1067
    //   944: iconst_1
    //   945: invokestatic 1016	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   948: iload_2
    //   949: istore 5
    //   951: lload 9
    //   953: lstore 11
    //   955: lload 9
    //   957: lstore 13
    //   959: aload_0
    //   960: bipush 105
    //   962: aconst_null
    //   963: iconst_1
    //   964: invokespecial 427	com/tencent/smtt/sdk/TbsApkDownloader:setDownloadStat	(ILjava/lang/String;Z)V
    //   967: iload_2
    //   968: istore 5
    //   970: lload 9
    //   972: lstore 11
    //   974: lload 9
    //   976: lstore 13
    //   978: aload_0
    //   979: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   982: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   985: sipush -308
    //   988: invokevirtual 972	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   991: iload_2
    //   992: istore 5
    //   994: iload_1
    //   995: ifne -491 -> 504
    //   998: aload_0
    //   999: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   1002: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1005: getfield 583	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1008: ldc_w 1040
    //   1011: lload 9
    //   1013: invokestatic 1062	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1016: invokeinterface 597 3 0
    //   1021: pop
    //   1022: aload_0
    //   1023: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   1026: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1029: invokevirtual 609	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1032: iload_2
    //   1033: istore 5
    //   1035: goto -531 -> 504
    //   1038: lload 11
    //   1040: lstore 15
    //   1042: iload_2
    //   1043: istore 5
    //   1045: lload 11
    //   1047: lstore 13
    //   1049: ldc 225
    //   1051: new 146	java/lang/StringBuilder
    //   1054: dup
    //   1055: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   1058: ldc_w 1069
    //   1061: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1064: lload 11
    //   1066: invokevirtual 840	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1069: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1072: invokestatic 347	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1075: lload 11
    //   1077: lload 25
    //   1079: lcmp
    //   1080: iflt +5470 -> 6550
    //   1083: lload 11
    //   1085: lstore 15
    //   1087: iload_2
    //   1088: istore 5
    //   1090: lload 11
    //   1092: lstore 13
    //   1094: ldc 225
    //   1096: ldc_w 1071
    //   1099: iconst_1
    //   1100: invokestatic 1016	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1103: lload 11
    //   1105: lstore 15
    //   1107: iload_2
    //   1108: istore 5
    //   1110: lload 11
    //   1112: lstore 13
    //   1114: aload_0
    //   1115: bipush 112
    //   1117: aconst_null
    //   1118: iconst_1
    //   1119: invokespecial 427	com/tencent/smtt/sdk/TbsApkDownloader:setDownloadStat	(ILjava/lang/String;Z)V
    //   1122: lload 11
    //   1124: lstore 15
    //   1126: iload_2
    //   1127: istore 5
    //   1129: lload 11
    //   1131: lstore 13
    //   1133: aload_0
    //   1134: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   1137: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1140: sipush -307
    //   1143: invokevirtual 972	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   1146: iload_2
    //   1147: istore 5
    //   1149: iload_1
    //   1150: ifne -646 -> 504
    //   1153: aload_0
    //   1154: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   1157: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1160: getfield 583	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1163: ldc_w 1040
    //   1166: lload 11
    //   1168: invokestatic 1062	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1171: invokeinterface 597 3 0
    //   1176: pop
    //   1177: aload_0
    //   1178: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   1181: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1184: invokevirtual 609	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1187: iload_2
    //   1188: istore 5
    //   1190: goto -686 -> 504
    //   1193: lload 9
    //   1195: lstore 15
    //   1197: iload_2
    //   1198: istore 5
    //   1200: lload 9
    //   1202: lstore 13
    //   1204: aload_0
    //   1205: iconst_1
    //   1206: putfield 380	com/tencent/smtt/sdk/TbsApkDownloader:mNeedDownloadStat	Z
    //   1209: lload 9
    //   1211: lstore 15
    //   1213: iload_2
    //   1214: istore 5
    //   1216: lload 9
    //   1218: lstore 13
    //   1220: aload_0
    //   1221: getfield 768	com/tencent/smtt/sdk/TbsApkDownloader:mLocation	Ljava/lang/String;
    //   1224: ifnull +846 -> 2070
    //   1227: lload 9
    //   1229: lstore 15
    //   1231: iload_2
    //   1232: istore 5
    //   1234: lload 9
    //   1236: lstore 13
    //   1238: aload_0
    //   1239: getfield 768	com/tencent/smtt/sdk/TbsApkDownloader:mLocation	Ljava/lang/String;
    //   1242: astore 27
    //   1244: lload 9
    //   1246: lstore 15
    //   1248: iload_2
    //   1249: istore 5
    //   1251: lload 9
    //   1253: lstore 13
    //   1255: ldc 225
    //   1257: new 146	java/lang/StringBuilder
    //   1260: dup
    //   1261: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   1264: ldc_w 1073
    //   1267: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1270: aload 27
    //   1272: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1275: ldc_w 1075
    //   1278: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1281: aload_0
    //   1282: getfield 760	com/tencent/smtt/sdk/TbsApkDownloader:mRetryTimes	I
    //   1285: invokevirtual 325	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1288: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1291: iconst_1
    //   1292: invokestatic 1016	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1295: lload 9
    //   1297: lstore 15
    //   1299: iload_2
    //   1300: istore 5
    //   1302: lload 9
    //   1304: lstore 13
    //   1306: aload 27
    //   1308: aload_0
    //   1309: getfield 1077	com/tencent/smtt/sdk/TbsApkDownloader:mLastDownloadUrl	Ljava/lang/String;
    //   1312: invokevirtual 413	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1315: ifne +23 -> 1338
    //   1318: lload 9
    //   1320: lstore 15
    //   1322: iload_2
    //   1323: istore 5
    //   1325: lload 9
    //   1327: lstore 13
    //   1329: aload_0
    //   1330: getfield 139	com/tencent/smtt/sdk/TbsApkDownloader:mDownloadStat	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   1333: aload 27
    //   1335: invokevirtual 1080	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setDownloadUrl	(Ljava/lang/String;)V
    //   1338: lload 9
    //   1340: lstore 15
    //   1342: iload_2
    //   1343: istore 5
    //   1345: lload 9
    //   1347: lstore 13
    //   1349: aload_0
    //   1350: aload 27
    //   1352: putfield 1077	com/tencent/smtt/sdk/TbsApkDownloader:mLastDownloadUrl	Ljava/lang/String;
    //   1355: lload 9
    //   1357: lstore 15
    //   1359: iload_2
    //   1360: istore 5
    //   1362: lload 9
    //   1364: lstore 13
    //   1366: aload_0
    //   1367: aload 27
    //   1369: invokespecial 1082	com/tencent/smtt/sdk/TbsApkDownloader:initHttpRequest	(Ljava/lang/String;)V
    //   1372: lconst_0
    //   1373: lstore 11
    //   1375: lload 9
    //   1377: lstore 15
    //   1379: iload_2
    //   1380: istore 5
    //   1382: lload 9
    //   1384: lstore 13
    //   1386: aload_0
    //   1387: getfield 770	com/tencent/smtt/sdk/TbsApkDownloader:mHasTmpTryNoRange	Z
    //   1390: ifne +163 -> 1553
    //   1393: lload 9
    //   1395: lstore 15
    //   1397: iload_2
    //   1398: istore 5
    //   1400: lload 9
    //   1402: lstore 13
    //   1404: aload_0
    //   1405: invokespecial 1084	com/tencent/smtt/sdk/TbsApkDownloader:downloadFileSize	()J
    //   1408: lstore 11
    //   1410: lload 9
    //   1412: lstore 15
    //   1414: iload_2
    //   1415: istore 5
    //   1417: lload 9
    //   1419: lstore 13
    //   1421: ldc 225
    //   1423: new 146	java/lang/StringBuilder
    //   1426: dup
    //   1427: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   1430: ldc_w 1086
    //   1433: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1436: lload 11
    //   1438: invokevirtual 840	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1441: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1444: invokestatic 347	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1447: lload 9
    //   1449: lstore 15
    //   1451: iload_2
    //   1452: istore 5
    //   1454: lload 9
    //   1456: lstore 13
    //   1458: aload_0
    //   1459: getfield 766	com/tencent/smtt/sdk/TbsApkDownloader:mContentLength	J
    //   1462: lconst_0
    //   1463: lcmp
    //   1464: ifgt +626 -> 2090
    //   1467: lload 9
    //   1469: lstore 15
    //   1471: iload_2
    //   1472: istore 5
    //   1474: lload 9
    //   1476: lstore 13
    //   1478: ldc 225
    //   1480: new 146	java/lang/StringBuilder
    //   1483: dup
    //   1484: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   1487: ldc_w 1088
    //   1490: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1493: lload 11
    //   1495: invokevirtual 840	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1498: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1501: iconst_1
    //   1502: invokestatic 1016	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1505: lload 9
    //   1507: lstore 15
    //   1509: iload_2
    //   1510: istore 5
    //   1512: lload 9
    //   1514: lstore 13
    //   1516: aload_0
    //   1517: getfield 355	com/tencent/smtt/sdk/TbsApkDownloader:mHttpRequest	Ljava/net/HttpURLConnection;
    //   1520: ldc_w 1090
    //   1523: new 146	java/lang/StringBuilder
    //   1526: dup
    //   1527: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   1530: ldc_w 1092
    //   1533: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1536: lload 11
    //   1538: invokevirtual 840	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1541: ldc_w 1094
    //   1544: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1547: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1550: invokevirtual 697	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1553: lload 9
    //   1555: lstore 15
    //   1557: iload_2
    //   1558: istore 5
    //   1560: lload 9
    //   1562: lstore 13
    //   1564: aload_0
    //   1565: getfield 139	com/tencent/smtt/sdk/TbsApkDownloader:mDownloadStat	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   1568: astore 27
    //   1570: lload 11
    //   1572: lconst_0
    //   1573: lcmp
    //   1574: ifne +800 -> 2374
    //   1577: iconst_0
    //   1578: istore_3
    //   1579: lload 9
    //   1581: lstore 15
    //   1583: iload_2
    //   1584: istore 5
    //   1586: lload 9
    //   1588: lstore 13
    //   1590: aload 27
    //   1592: iload_3
    //   1593: invokevirtual 1097	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setDownloadCancel	(I)V
    //   1596: lload 9
    //   1598: lstore 15
    //   1600: iload_2
    //   1601: istore 5
    //   1603: lload 9
    //   1605: lstore 13
    //   1607: aload_0
    //   1608: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   1611: invokestatic 402	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   1614: istore_3
    //   1615: lload 9
    //   1617: lstore 15
    //   1619: iload_2
    //   1620: istore 5
    //   1622: lload 9
    //   1624: lstore 13
    //   1626: aload_0
    //   1627: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   1630: invokestatic 396	com/tencent/smtt/utils/Apn:getApnInfo	(Landroid/content/Context;)Ljava/lang/String;
    //   1633: astore 27
    //   1635: lload 9
    //   1637: lstore 15
    //   1639: iload_2
    //   1640: istore 5
    //   1642: lload 9
    //   1644: lstore 13
    //   1646: aload_0
    //   1647: getfield 183	com/tencent/smtt/sdk/TbsApkDownloader:mApnInfo	Ljava/lang/String;
    //   1650: ifnonnull +729 -> 2379
    //   1653: lload 9
    //   1655: lstore 15
    //   1657: iload_2
    //   1658: istore 5
    //   1660: lload 9
    //   1662: lstore 13
    //   1664: aload_0
    //   1665: getfield 185	com/tencent/smtt/sdk/TbsApkDownloader:mApnType	I
    //   1668: iconst_m1
    //   1669: if_icmpne +710 -> 2379
    //   1672: lload 9
    //   1674: lstore 15
    //   1676: iload_2
    //   1677: istore 5
    //   1679: lload 9
    //   1681: lstore 13
    //   1683: aload_0
    //   1684: aload 27
    //   1686: putfield 183	com/tencent/smtt/sdk/TbsApkDownloader:mApnInfo	Ljava/lang/String;
    //   1689: lload 9
    //   1691: lstore 15
    //   1693: iload_2
    //   1694: istore 5
    //   1696: lload 9
    //   1698: lstore 13
    //   1700: aload_0
    //   1701: iload_3
    //   1702: putfield 185	com/tencent/smtt/sdk/TbsApkDownloader:mApnType	I
    //   1705: lload 9
    //   1707: lstore 15
    //   1709: iload_2
    //   1710: istore 5
    //   1712: lload 9
    //   1714: lstore 13
    //   1716: aload_0
    //   1717: getfield 760	com/tencent/smtt/sdk/TbsApkDownloader:mRetryTimes	I
    //   1720: iconst_1
    //   1721: if_icmplt +28 -> 1749
    //   1724: lload 9
    //   1726: lstore 15
    //   1728: iload_2
    //   1729: istore 5
    //   1731: lload 9
    //   1733: lstore 13
    //   1735: aload_0
    //   1736: getfield 355	com/tencent/smtt/sdk/TbsApkDownloader:mHttpRequest	Ljava/net/HttpURLConnection;
    //   1739: ldc_w 1099
    //   1742: aload_0
    //   1743: getfield 1009	com/tencent/smtt/sdk/TbsApkDownloader:mDownloadUrl	Ljava/lang/String;
    //   1746: invokevirtual 1102	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1749: lload 9
    //   1751: lstore 15
    //   1753: iload_2
    //   1754: istore 5
    //   1756: lload 9
    //   1758: lstore 13
    //   1760: aload_0
    //   1761: getfield 355	com/tencent/smtt/sdk/TbsApkDownloader:mHttpRequest	Ljava/net/HttpURLConnection;
    //   1764: invokevirtual 535	java/net/HttpURLConnection:getResponseCode	()I
    //   1767: istore_3
    //   1768: lload 9
    //   1770: lstore 15
    //   1772: iload_2
    //   1773: istore 5
    //   1775: lload 9
    //   1777: lstore 13
    //   1779: ldc 225
    //   1781: new 146	java/lang/StringBuilder
    //   1784: dup
    //   1785: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   1788: ldc_w 1104
    //   1791: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1794: iload_3
    //   1795: invokevirtual 325	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1798: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1801: invokestatic 347	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1804: lload 9
    //   1806: lstore 15
    //   1808: iload_2
    //   1809: istore 5
    //   1811: lload 9
    //   1813: lstore 13
    //   1815: aload_0
    //   1816: getfield 139	com/tencent/smtt/sdk/TbsApkDownloader:mDownloadStat	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   1819: iload_3
    //   1820: invokevirtual 1107	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setHttpCode	(I)V
    //   1823: iload_1
    //   1824: ifne +157 -> 1981
    //   1827: lload 9
    //   1829: lstore 15
    //   1831: iload_2
    //   1832: istore 5
    //   1834: lload 9
    //   1836: lstore 13
    //   1838: aload_0
    //   1839: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   1842: invokestatic 318	com/tencent/smtt/sdk/TbsDownloader:getOverSea	(Landroid/content/Context;)Z
    //   1845: ifne +136 -> 1981
    //   1848: lload 9
    //   1850: lstore 15
    //   1852: iload_2
    //   1853: istore 5
    //   1855: lload 9
    //   1857: lstore 13
    //   1859: aload_0
    //   1860: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   1863: invokestatic 402	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   1866: iconst_3
    //   1867: if_icmpne +24 -> 1891
    //   1870: lload 9
    //   1872: lstore 15
    //   1874: iload_2
    //   1875: istore 5
    //   1877: lload 9
    //   1879: lstore 13
    //   1881: aload_0
    //   1882: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   1885: invokestatic 402	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   1888: ifne +93 -> 1981
    //   1891: lload 9
    //   1893: lstore 15
    //   1895: iload_2
    //   1896: istore 5
    //   1898: lload 9
    //   1900: lstore 13
    //   1902: invokestatic 1110	com/tencent/smtt/sdk/QbSdk:getDownloadWithoutWifi	()Z
    //   1905: ifne +76 -> 1981
    //   1908: lload 9
    //   1910: lstore 15
    //   1912: iload_2
    //   1913: istore 5
    //   1915: lload 9
    //   1917: lstore 13
    //   1919: aload_0
    //   1920: invokevirtual 880	com/tencent/smtt/sdk/TbsApkDownloader:stopDownload	()V
    //   1923: lload 9
    //   1925: lstore 15
    //   1927: iload_2
    //   1928: istore 5
    //   1930: lload 9
    //   1932: lstore 13
    //   1934: getstatic 447	com/tencent/smtt/sdk/QbSdk:mTbsListenerWrapper	Lcom/tencent/smtt/sdk/TbsListener;
    //   1937: ifnull +24 -> 1961
    //   1940: lload 9
    //   1942: lstore 15
    //   1944: iload_2
    //   1945: istore 5
    //   1947: lload 9
    //   1949: lstore 13
    //   1951: getstatic 447	com/tencent/smtt/sdk/QbSdk:mTbsListenerWrapper	Lcom/tencent/smtt/sdk/TbsListener;
    //   1954: bipush 111
    //   1956: invokeinterface 452 2 0
    //   1961: lload 9
    //   1963: lstore 15
    //   1965: iload_2
    //   1966: istore 5
    //   1968: lload 9
    //   1970: lstore 13
    //   1972: ldc 225
    //   1974: ldc_w 1112
    //   1977: iconst_0
    //   1978: invokestatic 1016	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   1981: lload 9
    //   1983: lstore 15
    //   1985: iload_2
    //   1986: istore 5
    //   1988: lload 9
    //   1990: lstore 13
    //   1992: aload_0
    //   1993: getfield 357	com/tencent/smtt/sdk/TbsApkDownloader:mCanceled	Z
    //   1996: ifeq +523 -> 2519
    //   1999: lload 9
    //   2001: lstore 15
    //   2003: iload_2
    //   2004: istore 5
    //   2006: lload 9
    //   2008: lstore 13
    //   2010: aload_0
    //   2011: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   2014: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2017: sipush -309
    //   2020: invokevirtual 972	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   2023: iload_2
    //   2024: istore 5
    //   2026: iload_1
    //   2027: ifne -1523 -> 504
    //   2030: aload_0
    //   2031: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   2034: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2037: getfield 583	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2040: ldc_w 1040
    //   2043: lload 9
    //   2045: invokestatic 1062	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2048: invokeinterface 597 3 0
    //   2053: pop
    //   2054: aload_0
    //   2055: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   2058: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2061: invokevirtual 609	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2064: iload_2
    //   2065: istore 5
    //   2067: goto -1563 -> 504
    //   2070: lload 9
    //   2072: lstore 15
    //   2074: iload_2
    //   2075: istore 5
    //   2077: lload 9
    //   2079: lstore 13
    //   2081: aload_0
    //   2082: getfield 1009	com/tencent/smtt/sdk/TbsApkDownloader:mDownloadUrl	Ljava/lang/String;
    //   2085: astore 27
    //   2087: goto -843 -> 1244
    //   2090: lload 9
    //   2092: lstore 15
    //   2094: iload_2
    //   2095: istore 5
    //   2097: lload 9
    //   2099: lstore 13
    //   2101: ldc 225
    //   2103: new 146	java/lang/StringBuilder
    //   2106: dup
    //   2107: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   2110: ldc_w 1114
    //   2113: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2116: lload 11
    //   2118: invokevirtual 840	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2121: ldc_w 1116
    //   2124: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2127: aload_0
    //   2128: getfield 766	com/tencent/smtt/sdk/TbsApkDownloader:mContentLength	J
    //   2131: invokevirtual 840	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2134: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2137: iconst_1
    //   2138: invokestatic 1016	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   2141: lload 9
    //   2143: lstore 15
    //   2145: iload_2
    //   2146: istore 5
    //   2148: lload 9
    //   2150: lstore 13
    //   2152: aload_0
    //   2153: getfield 355	com/tencent/smtt/sdk/TbsApkDownloader:mHttpRequest	Ljava/net/HttpURLConnection;
    //   2156: ldc_w 1090
    //   2159: new 146	java/lang/StringBuilder
    //   2162: dup
    //   2163: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   2166: ldc_w 1092
    //   2169: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2172: lload 11
    //   2174: invokevirtual 840	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2177: ldc_w 1094
    //   2180: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2183: aload_0
    //   2184: getfield 766	com/tencent/smtt/sdk/TbsApkDownloader:mContentLength	J
    //   2187: invokevirtual 840	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2190: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2193: invokevirtual 697	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   2196: goto -643 -> 1553
    //   2199: astore 27
    //   2201: iload 5
    //   2203: istore 6
    //   2205: lload 15
    //   2207: lstore 13
    //   2209: aload 27
    //   2211: instanceof 1118
    //   2214: ifeq +3910 -> 6124
    //   2217: iload_1
    //   2218: ifne +3906 -> 6124
    //   2221: lload 15
    //   2223: lstore 13
    //   2225: aload_0
    //   2226: getfield 117	com/tencent/smtt/sdk/TbsApkDownloader:urlArray	[Ljava/lang/String;
    //   2229: ifnull +3895 -> 6124
    //   2232: lload 15
    //   2234: lstore 13
    //   2236: aload_0
    //   2237: iconst_0
    //   2238: invokevirtual 1121	com/tencent/smtt/sdk/TbsApkDownloader:tryNextUrl	(Z)Z
    //   2241: ifeq +3883 -> 6124
    //   2244: lload 15
    //   2246: lstore 13
    //   2248: ldc 225
    //   2250: new 146	java/lang/StringBuilder
    //   2253: dup
    //   2254: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   2257: ldc_w 1123
    //   2260: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2263: aload_0
    //   2264: getfield 768	com/tencent/smtt/sdk/TbsApkDownloader:mLocation	Ljava/lang/String;
    //   2267: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2270: ldc_w 1125
    //   2273: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2276: aload 27
    //   2278: invokevirtual 455	java/lang/Throwable:toString	()Ljava/lang/String;
    //   2281: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2284: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2287: invokestatic 236	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2290: lload 15
    //   2292: lstore 13
    //   2294: aload_0
    //   2295: bipush 125
    //   2297: aconst_null
    //   2298: iconst_1
    //   2299: invokespecial 427	com/tencent/smtt/sdk/TbsApkDownloader:setDownloadStat	(ILjava/lang/String;Z)V
    //   2302: lload 15
    //   2304: lstore 13
    //   2306: aload_0
    //   2307: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   2310: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2313: sipush -316
    //   2316: invokevirtual 972	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   2319: lload 15
    //   2321: lstore 11
    //   2323: iload 6
    //   2325: istore_2
    //   2326: iload_1
    //   2327: ifne -1837 -> 490
    //   2330: aload_0
    //   2331: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   2334: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2337: getfield 583	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2340: ldc_w 1040
    //   2343: lload 15
    //   2345: invokestatic 1062	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2348: invokeinterface 597 3 0
    //   2353: pop
    //   2354: aload_0
    //   2355: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   2358: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2361: invokevirtual 609	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2364: lload 15
    //   2366: lstore 11
    //   2368: iload 6
    //   2370: istore_2
    //   2371: goto -1881 -> 490
    //   2374: iconst_1
    //   2375: istore_3
    //   2376: goto -797 -> 1579
    //   2379: lload 9
    //   2381: lstore 15
    //   2383: iload_2
    //   2384: istore 5
    //   2386: lload 9
    //   2388: lstore 13
    //   2390: iload_3
    //   2391: aload_0
    //   2392: getfield 185	com/tencent/smtt/sdk/TbsApkDownloader:mApnType	I
    //   2395: if_icmpne +26 -> 2421
    //   2398: lload 9
    //   2400: lstore 15
    //   2402: iload_2
    //   2403: istore 5
    //   2405: lload 9
    //   2407: lstore 13
    //   2409: aload 27
    //   2411: aload_0
    //   2412: getfield 183	com/tencent/smtt/sdk/TbsApkDownloader:mApnInfo	Ljava/lang/String;
    //   2415: invokevirtual 413	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2418: ifne -713 -> 1705
    //   2421: lload 9
    //   2423: lstore 15
    //   2425: iload_2
    //   2426: istore 5
    //   2428: lload 9
    //   2430: lstore 13
    //   2432: aload_0
    //   2433: getfield 139	com/tencent/smtt/sdk/TbsApkDownloader:mDownloadStat	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   2436: iconst_0
    //   2437: invokevirtual 416	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setNetworkChange	(I)V
    //   2440: lload 9
    //   2442: lstore 15
    //   2444: iload_2
    //   2445: istore 5
    //   2447: lload 9
    //   2449: lstore 13
    //   2451: aload_0
    //   2452: aload 27
    //   2454: putfield 183	com/tencent/smtt/sdk/TbsApkDownloader:mApnInfo	Ljava/lang/String;
    //   2457: lload 9
    //   2459: lstore 15
    //   2461: iload_2
    //   2462: istore 5
    //   2464: lload 9
    //   2466: lstore 13
    //   2468: aload_0
    //   2469: iload_3
    //   2470: putfield 185	com/tencent/smtt/sdk/TbsApkDownloader:mApnType	I
    //   2473: goto -768 -> 1705
    //   2476: astore 27
    //   2478: iload_1
    //   2479: ifne +37 -> 2516
    //   2482: aload_0
    //   2483: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   2486: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2489: getfield 583	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2492: ldc_w 1040
    //   2495: lload 13
    //   2497: invokestatic 1062	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2500: invokeinterface 597 3 0
    //   2505: pop
    //   2506: aload_0
    //   2507: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   2510: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2513: invokevirtual 609	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2516: aload 27
    //   2518: athrow
    //   2519: iload_3
    //   2520: sipush 200
    //   2523: if_icmpeq +10 -> 2533
    //   2526: iload_3
    //   2527: sipush 206
    //   2530: if_icmpne +2407 -> 4937
    //   2533: lload 9
    //   2535: lstore 15
    //   2537: iload_2
    //   2538: istore 5
    //   2540: lload 9
    //   2542: lstore 13
    //   2544: aload_0
    //   2545: aload_0
    //   2546: getfield 355	com/tencent/smtt/sdk/TbsApkDownloader:mHttpRequest	Ljava/net/HttpURLConnection;
    //   2549: invokevirtual 1128	java/net/HttpURLConnection:getContentLength	()I
    //   2552: i2l
    //   2553: lload 11
    //   2555: ladd
    //   2556: putfield 766	com/tencent/smtt/sdk/TbsApkDownloader:mContentLength	J
    //   2559: lload 9
    //   2561: lstore 15
    //   2563: iload_2
    //   2564: istore 5
    //   2566: lload 9
    //   2568: lstore 13
    //   2570: ldc 225
    //   2572: new 146	java/lang/StringBuilder
    //   2575: dup
    //   2576: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   2579: ldc_w 1130
    //   2582: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2585: aload_0
    //   2586: getfield 766	com/tencent/smtt/sdk/TbsApkDownloader:mContentLength	J
    //   2589: invokevirtual 840	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2592: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2595: invokestatic 347	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2598: lload 9
    //   2600: lstore 15
    //   2602: iload_2
    //   2603: istore 5
    //   2605: lload 9
    //   2607: lstore 13
    //   2609: aload_0
    //   2610: getfield 139	com/tencent/smtt/sdk/TbsApkDownloader:mDownloadStat	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   2613: aload_0
    //   2614: getfield 766	com/tencent/smtt/sdk/TbsApkDownloader:mContentLength	J
    //   2617: invokevirtual 1133	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setPkgSize	(J)V
    //   2620: lload 9
    //   2622: lstore 15
    //   2624: iload_2
    //   2625: istore 5
    //   2627: lload 9
    //   2629: lstore 13
    //   2631: aload_0
    //   2632: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   2635: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2638: getfield 252	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   2641: ldc_w 829
    //   2644: lconst_0
    //   2645: invokeinterface 833 4 0
    //   2650: lstore 17
    //   2652: lload 17
    //   2654: lconst_0
    //   2655: lcmp
    //   2656: ifeq +396 -> 3052
    //   2659: lload 9
    //   2661: lstore 15
    //   2663: iload_2
    //   2664: istore 5
    //   2666: lload 9
    //   2668: lstore 13
    //   2670: aload_0
    //   2671: getfield 766	com/tencent/smtt/sdk/TbsApkDownloader:mContentLength	J
    //   2674: lload 17
    //   2676: lcmp
    //   2677: ifeq +375 -> 3052
    //   2680: lload 9
    //   2682: lstore 15
    //   2684: iload_2
    //   2685: istore 5
    //   2687: lload 9
    //   2689: lstore 13
    //   2691: ldc 225
    //   2693: new 146	java/lang/StringBuilder
    //   2696: dup
    //   2697: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   2700: ldc_w 1135
    //   2703: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2706: lload 17
    //   2708: invokevirtual 840	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2711: ldc_w 1137
    //   2714: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2717: aload_0
    //   2718: getfield 766	com/tencent/smtt/sdk/TbsApkDownloader:mContentLength	J
    //   2721: invokevirtual 840	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2724: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2727: iconst_1
    //   2728: invokestatic 1016	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   2731: iload_1
    //   2732: ifne +272 -> 3004
    //   2735: lload 9
    //   2737: lstore 15
    //   2739: iload_2
    //   2740: istore 5
    //   2742: lload 9
    //   2744: lstore 13
    //   2746: aload_0
    //   2747: invokespecial 191	com/tencent/smtt/sdk/TbsApkDownloader:detectWifiNetworkAvailable	()Z
    //   2750: ifne +41 -> 2791
    //   2753: lload 9
    //   2755: lstore 15
    //   2757: iload_2
    //   2758: istore 5
    //   2760: lload 9
    //   2762: lstore 13
    //   2764: invokestatic 1110	com/tencent/smtt/sdk/QbSdk:getDownloadWithoutWifi	()Z
    //   2767: ifeq +237 -> 3004
    //   2770: lload 9
    //   2772: lstore 15
    //   2774: iload_2
    //   2775: istore 5
    //   2777: lload 9
    //   2779: lstore 13
    //   2781: aload_0
    //   2782: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   2785: invokestatic 423	com/tencent/smtt/utils/Apn:isNetworkAvailable	(Landroid/content/Context;)Z
    //   2788: ifeq +216 -> 3004
    //   2791: lload 9
    //   2793: lstore 15
    //   2795: iload_2
    //   2796: istore 5
    //   2798: lload 9
    //   2800: lstore 13
    //   2802: aload_0
    //   2803: getfield 117	com/tencent/smtt/sdk/TbsApkDownloader:urlArray	[Ljava/lang/String;
    //   2806: ifnull +75 -> 2881
    //   2809: lload 9
    //   2811: lstore 15
    //   2813: iload_2
    //   2814: istore 5
    //   2816: lload 9
    //   2818: lstore 13
    //   2820: aload_0
    //   2821: iconst_0
    //   2822: invokevirtual 1121	com/tencent/smtt/sdk/TbsApkDownloader:tryNextUrl	(Z)Z
    //   2825: istore 6
    //   2827: iload 6
    //   2829: ifeq +52 -> 2881
    //   2832: lload 9
    //   2834: lstore 11
    //   2836: iload_1
    //   2837: ifne -2347 -> 490
    //   2840: aload_0
    //   2841: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   2844: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2847: getfield 583	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2850: ldc_w 1040
    //   2853: lload 9
    //   2855: invokestatic 1062	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2858: invokeinterface 597 3 0
    //   2863: pop
    //   2864: aload_0
    //   2865: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   2868: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2871: invokevirtual 609	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2874: lload 9
    //   2876: lstore 11
    //   2878: goto -2388 -> 490
    //   2881: lload 9
    //   2883: lstore 15
    //   2885: iload_2
    //   2886: istore 5
    //   2888: lload 9
    //   2890: lstore 13
    //   2892: aload_0
    //   2893: bipush 113
    //   2895: new 146	java/lang/StringBuilder
    //   2898: dup
    //   2899: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   2902: ldc_w 1139
    //   2905: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2908: lload 17
    //   2910: invokevirtual 840	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2913: ldc_w 1137
    //   2916: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2919: aload_0
    //   2920: getfield 766	com/tencent/smtt/sdk/TbsApkDownloader:mContentLength	J
    //   2923: invokevirtual 840	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2926: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2929: iconst_1
    //   2930: invokespecial 427	com/tencent/smtt/sdk/TbsApkDownloader:setDownloadStat	(ILjava/lang/String;Z)V
    //   2933: lload 9
    //   2935: lstore 15
    //   2937: iload_2
    //   2938: istore 5
    //   2940: lload 9
    //   2942: lstore 13
    //   2944: aload_0
    //   2945: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   2948: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2951: sipush -310
    //   2954: invokevirtual 972	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   2957: iload_2
    //   2958: istore 5
    //   2960: iload_1
    //   2961: ifne -2457 -> 504
    //   2964: aload_0
    //   2965: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   2968: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2971: getfield 583	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2974: ldc_w 1040
    //   2977: lload 9
    //   2979: invokestatic 1062	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2982: invokeinterface 597 3 0
    //   2987: pop
    //   2988: aload_0
    //   2989: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   2992: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2995: invokevirtual 609	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2998: iload_2
    //   2999: istore 5
    //   3001: goto -2497 -> 504
    //   3004: lload 9
    //   3006: lstore 15
    //   3008: iload_2
    //   3009: istore 5
    //   3011: lload 9
    //   3013: lstore 13
    //   3015: aload_0
    //   3016: bipush 101
    //   3018: ldc_w 1141
    //   3021: iconst_1
    //   3022: invokespecial 427	com/tencent/smtt/sdk/TbsApkDownloader:setDownloadStat	(ILjava/lang/String;Z)V
    //   3025: lload 9
    //   3027: lstore 15
    //   3029: iload_2
    //   3030: istore 5
    //   3032: lload 9
    //   3034: lstore 13
    //   3036: aload_0
    //   3037: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   3040: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3043: sipush -304
    //   3046: invokevirtual 972	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   3049: goto -92 -> 2957
    //   3052: aconst_null
    //   3053: astore 31
    //   3055: aconst_null
    //   3056: astore 27
    //   3058: aconst_null
    //   3059: astore 29
    //   3061: lload 9
    //   3063: lstore 15
    //   3065: iload_2
    //   3066: istore 5
    //   3068: lload 9
    //   3070: lstore 13
    //   3072: ldc 225
    //   3074: ldc_w 1143
    //   3077: invokestatic 347	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3080: aload_0
    //   3081: getfield 355	com/tencent/smtt/sdk/TbsApkDownloader:mHttpRequest	Ljava/net/HttpURLConnection;
    //   3084: invokevirtual 532	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   3087: astore 28
    //   3089: aload 28
    //   3091: ifnull +3450 -> 6541
    //   3094: aload_0
    //   3095: getfield 355	com/tencent/smtt/sdk/TbsApkDownloader:mHttpRequest	Ljava/net/HttpURLConnection;
    //   3098: invokevirtual 1146	java/net/HttpURLConnection:getContentEncoding	()Ljava/lang/String;
    //   3101: astore 27
    //   3103: aload 27
    //   3105: ifnull +257 -> 3362
    //   3108: aload 27
    //   3110: ldc_w 1148
    //   3113: invokevirtual 285	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3116: ifeq +246 -> 3362
    //   3119: new 1150	java/util/zip/GZIPInputStream
    //   3122: dup
    //   3123: aload 28
    //   3125: invokespecial 1151	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   3128: astore 27
    //   3130: sipush 8192
    //   3133: newarray byte
    //   3135: astore 29
    //   3137: new 1153	java/io/FileOutputStream
    //   3140: dup
    //   3141: new 204	java/io/File
    //   3144: dup
    //   3145: aload_0
    //   3146: getfield 171	com/tencent/smtt/sdk/TbsApkDownloader:mFilePath	Ljava/io/File;
    //   3149: ldc 37
    //   3151: invokespecial 269	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   3154: iconst_1
    //   3155: invokespecial 1156	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   3158: astore 30
    //   3160: invokestatic 386	java/lang/System:currentTimeMillis	()J
    //   3163: lstore 15
    //   3165: iconst_0
    //   3166: istore_3
    //   3167: lload 11
    //   3169: lstore 21
    //   3171: lload 11
    //   3173: lstore 13
    //   3175: iload_2
    //   3176: istore 6
    //   3178: lload 9
    //   3180: lstore 17
    //   3182: iload_2
    //   3183: istore 7
    //   3185: lload 9
    //   3187: lstore 19
    //   3189: aload_0
    //   3190: getfield 357	com/tencent/smtt/sdk/TbsApkDownloader:mCanceled	Z
    //   3193: ifeq +386 -> 3579
    //   3196: iload_2
    //   3197: istore 6
    //   3199: lload 9
    //   3201: lstore 17
    //   3203: iload_2
    //   3204: istore 7
    //   3206: lload 9
    //   3208: lstore 19
    //   3210: ldc 225
    //   3212: ldc_w 1158
    //   3215: iconst_1
    //   3216: invokestatic 1016	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   3219: iload_2
    //   3220: istore 6
    //   3222: lload 9
    //   3224: lstore 17
    //   3226: iload_2
    //   3227: istore 7
    //   3229: lload 9
    //   3231: lstore 19
    //   3233: aload_0
    //   3234: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   3237: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3240: sipush -309
    //   3243: invokevirtual 972	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   3246: iload_2
    //   3247: istore 6
    //   3249: iload_3
    //   3250: ifeq +1121 -> 4371
    //   3253: lload 9
    //   3255: lstore 15
    //   3257: iload 6
    //   3259: istore 5
    //   3261: lload 9
    //   3263: lstore 13
    //   3265: aload_0
    //   3266: aload 30
    //   3268: invokespecial 758	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   3271: lload 9
    //   3273: lstore 15
    //   3275: iload 6
    //   3277: istore 5
    //   3279: lload 9
    //   3281: lstore 13
    //   3283: aload_0
    //   3284: aload 27
    //   3286: invokespecial 758	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   3289: lload 9
    //   3291: lstore 15
    //   3293: iload 6
    //   3295: istore 5
    //   3297: lload 9
    //   3299: lstore 13
    //   3301: aload_0
    //   3302: aload 28
    //   3304: invokespecial 758	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   3307: lload 9
    //   3309: lstore 11
    //   3311: iload 6
    //   3313: istore_2
    //   3314: iload_1
    //   3315: ifne -2825 -> 490
    //   3318: aload_0
    //   3319: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   3322: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3325: getfield 583	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   3328: ldc_w 1040
    //   3331: lload 9
    //   3333: invokestatic 1062	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3336: invokeinterface 597 3 0
    //   3341: pop
    //   3342: aload_0
    //   3343: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   3346: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3349: invokevirtual 609	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   3352: lload 9
    //   3354: lstore 11
    //   3356: iload 6
    //   3358: istore_2
    //   3359: goto -2869 -> 490
    //   3362: aload 27
    //   3364: ifnull +208 -> 3572
    //   3367: aload 27
    //   3369: ldc_w 1160
    //   3372: invokevirtual 285	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3375: ifeq +197 -> 3572
    //   3378: new 1162	java/util/zip/InflaterInputStream
    //   3381: dup
    //   3382: aload 28
    //   3384: new 1164	java/util/zip/Inflater
    //   3387: dup
    //   3388: iconst_1
    //   3389: invokespecial 1166	java/util/zip/Inflater:<init>	(Z)V
    //   3392: invokespecial 1169	java/util/zip/InflaterInputStream:<init>	(Ljava/io/InputStream;Ljava/util/zip/Inflater;)V
    //   3395: astore 27
    //   3397: goto -267 -> 3130
    //   3400: astore 32
    //   3402: aload 28
    //   3404: astore 27
    //   3406: aload 31
    //   3408: astore 30
    //   3410: aload 32
    //   3412: astore 28
    //   3414: iload_2
    //   3415: istore 6
    //   3417: aload 28
    //   3419: invokevirtual 1170	java/io/IOException:printStackTrace	()V
    //   3422: aload 28
    //   3424: instanceof 1172
    //   3427: ifne +11 -> 3438
    //   3430: aload 28
    //   3432: instanceof 1174
    //   3435: ifeq +1079 -> 4514
    //   3438: aload_0
    //   3439: ldc_w 1175
    //   3442: putfield 111	com/tencent/smtt/sdk/TbsApkDownloader:mReadTimeout	I
    //   3445: aload_0
    //   3446: lconst_0
    //   3447: invokespecial 1177	com/tencent/smtt/sdk/TbsApkDownloader:retry	(J)V
    //   3450: aload_0
    //   3451: bipush 103
    //   3453: aload_0
    //   3454: aload 28
    //   3456: invokespecial 873	com/tencent/smtt/sdk/TbsApkDownloader:errorToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   3459: iconst_0
    //   3460: invokespecial 427	com/tencent/smtt/sdk/TbsApkDownloader:setDownloadStat	(ILjava/lang/String;Z)V
    //   3463: lload 9
    //   3465: lstore 15
    //   3467: iload 6
    //   3469: istore 5
    //   3471: lload 9
    //   3473: lstore 13
    //   3475: aload_0
    //   3476: aload 30
    //   3478: invokespecial 758	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   3481: lload 9
    //   3483: lstore 15
    //   3485: iload 6
    //   3487: istore 5
    //   3489: lload 9
    //   3491: lstore 13
    //   3493: aload_0
    //   3494: aload 29
    //   3496: invokespecial 758	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   3499: lload 9
    //   3501: lstore 15
    //   3503: iload 6
    //   3505: istore 5
    //   3507: lload 9
    //   3509: lstore 13
    //   3511: aload_0
    //   3512: aload 27
    //   3514: invokespecial 758	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   3517: lload 9
    //   3519: lstore 11
    //   3521: iload 6
    //   3523: istore_2
    //   3524: iload_1
    //   3525: ifne -3035 -> 490
    //   3528: aload_0
    //   3529: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   3532: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3535: getfield 583	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   3538: ldc_w 1040
    //   3541: lload 9
    //   3543: invokestatic 1062	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3546: invokeinterface 597 3 0
    //   3551: pop
    //   3552: aload_0
    //   3553: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   3556: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3559: invokevirtual 609	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   3562: lload 9
    //   3564: lstore 11
    //   3566: iload 6
    //   3568: istore_2
    //   3569: goto -3079 -> 490
    //   3572: aload 28
    //   3574: astore 27
    //   3576: goto -446 -> 3130
    //   3579: iload_2
    //   3580: istore 6
    //   3582: lload 9
    //   3584: lstore 17
    //   3586: iload_2
    //   3587: istore 7
    //   3589: lload 9
    //   3591: lstore 19
    //   3593: aload 27
    //   3595: aload 29
    //   3597: iconst_0
    //   3598: sipush 8192
    //   3601: invokevirtual 1183	java/io/InputStream:read	([BII)I
    //   3604: istore 4
    //   3606: iload 4
    //   3608: ifgt +189 -> 3797
    //   3611: iload_2
    //   3612: istore 6
    //   3614: lload 9
    //   3616: lstore 17
    //   3618: iload_2
    //   3619: istore 7
    //   3621: lload 9
    //   3623: lstore 19
    //   3625: aload_0
    //   3626: getfield 117	com/tencent/smtt/sdk/TbsApkDownloader:urlArray	[Ljava/lang/String;
    //   3629: ifnull +86 -> 3715
    //   3632: iload_2
    //   3633: istore 6
    //   3635: lload 9
    //   3637: lstore 17
    //   3639: iload_2
    //   3640: istore 7
    //   3642: lload 9
    //   3644: lstore 19
    //   3646: aload_0
    //   3647: iconst_1
    //   3648: iload 8
    //   3650: invokespecial 982	com/tencent/smtt/sdk/TbsApkDownloader:verifyTbsApk	(ZZ)Z
    //   3653: ifne +62 -> 3715
    //   3656: iload_1
    //   3657: ifne +33 -> 3690
    //   3660: iload_2
    //   3661: istore 6
    //   3663: lload 9
    //   3665: lstore 17
    //   3667: iload_2
    //   3668: istore 7
    //   3670: lload 9
    //   3672: lstore 19
    //   3674: aload_0
    //   3675: iconst_0
    //   3676: invokevirtual 1121	com/tencent/smtt/sdk/TbsApkDownloader:tryNextUrl	(Z)Z
    //   3679: ifeq +11 -> 3690
    //   3682: iconst_1
    //   3683: istore_3
    //   3684: iload_2
    //   3685: istore 6
    //   3687: goto -438 -> 3249
    //   3690: iload_2
    //   3691: istore 6
    //   3693: lload 9
    //   3695: lstore 17
    //   3697: iload_2
    //   3698: istore 7
    //   3700: lload 9
    //   3702: lstore 19
    //   3704: aload_0
    //   3705: iconst_1
    //   3706: putfield 772	com/tencent/smtt/sdk/TbsApkDownloader:mFinished	Z
    //   3709: iconst_0
    //   3710: istore 6
    //   3712: goto -463 -> 3249
    //   3715: iload_2
    //   3716: istore 6
    //   3718: lload 9
    //   3720: lstore 17
    //   3722: iload_2
    //   3723: istore 7
    //   3725: lload 9
    //   3727: lstore 19
    //   3729: aload_0
    //   3730: iconst_1
    //   3731: putfield 772	com/tencent/smtt/sdk/TbsApkDownloader:mFinished	Z
    //   3734: iload_2
    //   3735: istore 5
    //   3737: iload_2
    //   3738: istore 6
    //   3740: lload 9
    //   3742: lstore 17
    //   3744: iload_2
    //   3745: istore 7
    //   3747: lload 9
    //   3749: lstore 19
    //   3751: aload_0
    //   3752: getfield 117	com/tencent/smtt/sdk/TbsApkDownloader:urlArray	[Ljava/lang/String;
    //   3755: ifnull +6 -> 3761
    //   3758: iconst_1
    //   3759: istore 5
    //   3761: iload 5
    //   3763: istore 6
    //   3765: lload 9
    //   3767: lstore 17
    //   3769: iload 5
    //   3771: istore 7
    //   3773: lload 9
    //   3775: lstore 19
    //   3777: aload_0
    //   3778: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   3781: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3784: sipush -311
    //   3787: invokevirtual 972	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   3790: iload 5
    //   3792: istore 6
    //   3794: goto -545 -> 3249
    //   3797: iload_2
    //   3798: istore 6
    //   3800: lload 9
    //   3802: lstore 17
    //   3804: iload_2
    //   3805: istore 7
    //   3807: lload 9
    //   3809: lstore 19
    //   3811: aload 30
    //   3813: aload 29
    //   3815: iconst_0
    //   3816: iload 4
    //   3818: invokevirtual 1187	java/io/FileOutputStream:write	([BII)V
    //   3821: iload_2
    //   3822: istore 6
    //   3824: lload 9
    //   3826: lstore 17
    //   3828: iload_2
    //   3829: istore 7
    //   3831: lload 9
    //   3833: lstore 19
    //   3835: aload 30
    //   3837: invokevirtual 1190	java/io/FileOutputStream:flush	()V
    //   3840: lload 9
    //   3842: lstore 11
    //   3844: iload_1
    //   3845: ifne +274 -> 4119
    //   3848: lload 9
    //   3850: iload 4
    //   3852: i2l
    //   3853: ladd
    //   3854: lstore 9
    //   3856: lload 9
    //   3858: lload 25
    //   3860: lcmp
    //   3861: iflt +112 -> 3973
    //   3864: iload_2
    //   3865: istore 6
    //   3867: lload 9
    //   3869: lstore 17
    //   3871: iload_2
    //   3872: istore 7
    //   3874: lload 9
    //   3876: lstore 19
    //   3878: ldc 225
    //   3880: ldc_w 1071
    //   3883: iconst_1
    //   3884: invokestatic 1016	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   3887: iload_2
    //   3888: istore 6
    //   3890: lload 9
    //   3892: lstore 17
    //   3894: iload_2
    //   3895: istore 7
    //   3897: lload 9
    //   3899: lstore 19
    //   3901: aload_0
    //   3902: bipush 112
    //   3904: new 146	java/lang/StringBuilder
    //   3907: dup
    //   3908: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   3911: ldc_w 1192
    //   3914: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3917: lload 9
    //   3919: invokevirtual 840	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3922: ldc_w 1194
    //   3925: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3928: lload 25
    //   3930: invokevirtual 840	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3933: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3936: iconst_1
    //   3937: invokespecial 427	com/tencent/smtt/sdk/TbsApkDownloader:setDownloadStat	(ILjava/lang/String;Z)V
    //   3940: iload_2
    //   3941: istore 6
    //   3943: lload 9
    //   3945: lstore 17
    //   3947: iload_2
    //   3948: istore 7
    //   3950: lload 9
    //   3952: lstore 19
    //   3954: aload_0
    //   3955: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   3958: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   3961: sipush -307
    //   3964: invokevirtual 972	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   3967: iload_2
    //   3968: istore 6
    //   3970: goto -721 -> 3249
    //   3973: lload 9
    //   3975: lstore 11
    //   3977: iload_2
    //   3978: istore 6
    //   3980: lload 9
    //   3982: lstore 17
    //   3984: iload_2
    //   3985: istore 7
    //   3987: lload 9
    //   3989: lstore 19
    //   3991: aload_0
    //   3992: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   3995: invokestatic 1065	com/tencent/smtt/utils/FileUtil:hasEnoughFreeSpace	(Landroid/content/Context;)Z
    //   3998: ifne +121 -> 4119
    //   4001: iload_2
    //   4002: istore 6
    //   4004: lload 9
    //   4006: lstore 17
    //   4008: iload_2
    //   4009: istore 7
    //   4011: lload 9
    //   4013: lstore 19
    //   4015: ldc 225
    //   4017: ldc_w 1196
    //   4020: iconst_1
    //   4021: invokestatic 1016	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   4024: iload_2
    //   4025: istore 6
    //   4027: lload 9
    //   4029: lstore 17
    //   4031: iload_2
    //   4032: istore 7
    //   4034: lload 9
    //   4036: lstore 19
    //   4038: aload_0
    //   4039: bipush 105
    //   4041: new 146	java/lang/StringBuilder
    //   4044: dup
    //   4045: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   4048: ldc_w 1198
    //   4051: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4054: invokestatic 1201	com/tencent/smtt/utils/TbsUtils:getROMAvailableSize	()J
    //   4057: invokevirtual 840	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4060: ldc_w 1203
    //   4063: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4066: aload_0
    //   4067: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   4070: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4073: invokevirtual 1206	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMinFreeSpace	()J
    //   4076: invokevirtual 840	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4079: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4082: iconst_1
    //   4083: invokespecial 427	com/tencent/smtt/sdk/TbsApkDownloader:setDownloadStat	(ILjava/lang/String;Z)V
    //   4086: iload_2
    //   4087: istore 6
    //   4089: lload 9
    //   4091: lstore 17
    //   4093: iload_2
    //   4094: istore 7
    //   4096: lload 9
    //   4098: lstore 19
    //   4100: aload_0
    //   4101: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   4104: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4107: sipush -308
    //   4110: invokevirtual 972	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   4113: iload_2
    //   4114: istore 6
    //   4116: goto -867 -> 3249
    //   4119: iload 4
    //   4121: i2l
    //   4122: lstore 9
    //   4124: aload_0
    //   4125: lload 23
    //   4127: lload 9
    //   4129: invokespecial 1208	com/tencent/smtt/sdk/TbsApkDownloader:saveDownloadDataStat	(JJ)J
    //   4132: lstore 23
    //   4134: invokestatic 386	java/lang/System:currentTimeMillis	()J
    //   4137: lstore 19
    //   4139: iload 4
    //   4141: i2l
    //   4142: lload 21
    //   4144: ladd
    //   4145: lstore 17
    //   4147: lload 19
    //   4149: lload 15
    //   4151: lsub
    //   4152: ldc2_w 1209
    //   4155: lcmp
    //   4156: ifle +2374 -> 6530
    //   4159: ldc 225
    //   4161: new 146	java/lang/StringBuilder
    //   4164: dup
    //   4165: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   4168: ldc_w 1212
    //   4171: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4174: lload 17
    //   4176: invokevirtual 840	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4179: ldc_w 1116
    //   4182: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4185: aload_0
    //   4186: getfield 766	com/tencent/smtt/sdk/TbsApkDownloader:mContentLength	J
    //   4189: invokevirtual 840	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4192: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4195: iconst_1
    //   4196: invokestatic 1016	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   4199: getstatic 447	com/tencent/smtt/sdk/QbSdk:mTbsListenerWrapper	Lcom/tencent/smtt/sdk/TbsListener;
    //   4202: ifnull +29 -> 4231
    //   4205: lload 17
    //   4207: l2d
    //   4208: aload_0
    //   4209: getfield 766	com/tencent/smtt/sdk/TbsApkDownloader:mContentLength	J
    //   4212: l2d
    //   4213: ddiv
    //   4214: ldc2_w 1213
    //   4217: dmul
    //   4218: d2i
    //   4219: istore 4
    //   4221: getstatic 447	com/tencent/smtt/sdk/QbSdk:mTbsListenerWrapper	Lcom/tencent/smtt/sdk/TbsListener;
    //   4224: iload 4
    //   4226: invokeinterface 1217 2 0
    //   4231: lload 13
    //   4233: lstore 9
    //   4235: iload_1
    //   4236: ifne +112 -> 4348
    //   4239: lload 13
    //   4241: lstore 9
    //   4243: lload 17
    //   4245: lload 13
    //   4247: lsub
    //   4248: ldc2_w 30
    //   4251: lcmp
    //   4252: ifle +96 -> 4348
    //   4255: aload_0
    //   4256: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   4259: invokestatic 318	com/tencent/smtt/sdk/TbsDownloader:getOverSea	(Landroid/content/Context;)Z
    //   4262: ifne +82 -> 4344
    //   4265: aload_0
    //   4266: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   4269: invokestatic 402	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   4272: iconst_3
    //   4273: if_icmpne +13 -> 4286
    //   4276: aload_0
    //   4277: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   4280: invokestatic 402	com/tencent/smtt/utils/Apn:getApnType	(Landroid/content/Context;)I
    //   4283: ifne +61 -> 4344
    //   4286: invokestatic 1110	com/tencent/smtt/sdk/QbSdk:getDownloadWithoutWifi	()Z
    //   4289: ifne +55 -> 4344
    //   4292: aload_0
    //   4293: invokevirtual 880	com/tencent/smtt/sdk/TbsApkDownloader:stopDownload	()V
    //   4296: getstatic 447	com/tencent/smtt/sdk/QbSdk:mTbsListenerWrapper	Lcom/tencent/smtt/sdk/TbsListener;
    //   4299: ifnull +13 -> 4312
    //   4302: getstatic 447	com/tencent/smtt/sdk/QbSdk:mTbsListenerWrapper	Lcom/tencent/smtt/sdk/TbsListener;
    //   4305: bipush 111
    //   4307: invokeinterface 452 2 0
    //   4312: ldc 225
    //   4314: ldc_w 1219
    //   4317: iconst_0
    //   4318: invokestatic 1016	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   4321: aload_0
    //   4322: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   4325: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4328: sipush -304
    //   4331: invokevirtual 972	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   4334: lload 11
    //   4336: lstore 9
    //   4338: iload_2
    //   4339: istore 6
    //   4341: goto -1092 -> 3249
    //   4344: lload 17
    //   4346: lstore 9
    //   4348: lload 19
    //   4350: lstore 13
    //   4352: lload 13
    //   4354: lstore 15
    //   4356: lload 9
    //   4358: lstore 13
    //   4360: lload 11
    //   4362: lstore 9
    //   4364: lload 17
    //   4366: lstore 21
    //   4368: goto -1193 -> 3175
    //   4371: iload 6
    //   4373: istore_2
    //   4374: iload_2
    //   4375: istore 5
    //   4377: lload 9
    //   4379: lstore 11
    //   4381: lload 9
    //   4383: lstore 13
    //   4385: aload_0
    //   4386: aload 30
    //   4388: invokespecial 758	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   4391: iload_2
    //   4392: istore 5
    //   4394: lload 9
    //   4396: lstore 11
    //   4398: lload 9
    //   4400: lstore 13
    //   4402: aload_0
    //   4403: aload 27
    //   4405: invokespecial 758	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   4408: iload_2
    //   4409: istore 5
    //   4411: lload 9
    //   4413: lstore 11
    //   4415: lload 9
    //   4417: lstore 13
    //   4419: aload_0
    //   4420: aload 28
    //   4422: invokespecial 758	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   4425: iload_2
    //   4426: istore 5
    //   4428: lload 9
    //   4430: lstore 11
    //   4432: lload 9
    //   4434: lstore 13
    //   4436: aload_0
    //   4437: getfield 772	com/tencent/smtt/sdk/TbsApkDownloader:mFinished	Z
    //   4440: ifne +27 -> 4467
    //   4443: iload_2
    //   4444: istore 5
    //   4446: lload 9
    //   4448: lstore 11
    //   4450: lload 9
    //   4452: lstore 13
    //   4454: aload_0
    //   4455: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   4458: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4461: sipush -319
    //   4464: invokevirtual 972	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   4467: iload_2
    //   4468: istore 5
    //   4470: iload_1
    //   4471: ifne -3967 -> 504
    //   4474: aload_0
    //   4475: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   4478: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4481: getfield 583	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   4484: ldc_w 1040
    //   4487: lload 9
    //   4489: invokestatic 1062	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4492: invokeinterface 597 3 0
    //   4497: pop
    //   4498: aload_0
    //   4499: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   4502: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4505: invokevirtual 609	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   4508: iload_2
    //   4509: istore 5
    //   4511: goto -4007 -> 504
    //   4514: iload_1
    //   4515: ifne +177 -> 4692
    //   4518: aload_0
    //   4519: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   4522: invokestatic 1065	com/tencent/smtt/utils/FileUtil:hasEnoughFreeSpace	(Landroid/content/Context;)Z
    //   4525: ifne +167 -> 4692
    //   4528: aload_0
    //   4529: bipush 105
    //   4531: new 146	java/lang/StringBuilder
    //   4534: dup
    //   4535: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   4538: ldc_w 1198
    //   4541: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4544: invokestatic 1201	com/tencent/smtt/utils/TbsUtils:getROMAvailableSize	()J
    //   4547: invokevirtual 840	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4550: ldc_w 1203
    //   4553: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4556: aload_0
    //   4557: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   4560: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4563: invokevirtual 1206	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMinFreeSpace	()J
    //   4566: invokevirtual 840	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4569: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4572: iconst_1
    //   4573: invokespecial 427	com/tencent/smtt/sdk/TbsApkDownloader:setDownloadStat	(ILjava/lang/String;Z)V
    //   4576: aload_0
    //   4577: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   4580: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4583: sipush -308
    //   4586: invokevirtual 972	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   4589: lload 9
    //   4591: lstore 15
    //   4593: iload 6
    //   4595: istore 5
    //   4597: lload 9
    //   4599: lstore 13
    //   4601: aload_0
    //   4602: aload 30
    //   4604: invokespecial 758	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   4607: lload 9
    //   4609: lstore 15
    //   4611: iload 6
    //   4613: istore 5
    //   4615: lload 9
    //   4617: lstore 13
    //   4619: aload_0
    //   4620: aload 29
    //   4622: invokespecial 758	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   4625: lload 9
    //   4627: lstore 15
    //   4629: iload 6
    //   4631: istore 5
    //   4633: lload 9
    //   4635: lstore 13
    //   4637: aload_0
    //   4638: aload 27
    //   4640: invokespecial 758	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   4643: iload 6
    //   4645: istore 5
    //   4647: iload_1
    //   4648: ifne -4144 -> 504
    //   4651: aload_0
    //   4652: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   4655: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4658: getfield 583	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   4661: ldc_w 1040
    //   4664: lload 9
    //   4666: invokestatic 1062	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4669: invokeinterface 597 3 0
    //   4674: pop
    //   4675: aload_0
    //   4676: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   4679: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4682: invokevirtual 609	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   4685: iload 6
    //   4687: istore 5
    //   4689: goto -4185 -> 504
    //   4692: aload_0
    //   4693: lconst_0
    //   4694: invokespecial 1177	com/tencent/smtt/sdk/TbsApkDownloader:retry	(J)V
    //   4697: aload_0
    //   4698: invokespecial 1221	com/tencent/smtt/sdk/TbsApkDownloader:downloadFileExists	()Z
    //   4701: ifne +125 -> 4826
    //   4704: aload_0
    //   4705: bipush 106
    //   4707: aload_0
    //   4708: aload 28
    //   4710: invokespecial 873	com/tencent/smtt/sdk/TbsApkDownloader:errorToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   4713: iconst_0
    //   4714: invokespecial 427	com/tencent/smtt/sdk/TbsApkDownloader:setDownloadStat	(ILjava/lang/String;Z)V
    //   4717: lload 9
    //   4719: lstore 15
    //   4721: iload 6
    //   4723: istore 5
    //   4725: lload 9
    //   4727: lstore 13
    //   4729: aload_0
    //   4730: aload 30
    //   4732: invokespecial 758	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   4735: lload 9
    //   4737: lstore 15
    //   4739: iload 6
    //   4741: istore 5
    //   4743: lload 9
    //   4745: lstore 13
    //   4747: aload_0
    //   4748: aload 29
    //   4750: invokespecial 758	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   4753: lload 9
    //   4755: lstore 15
    //   4757: iload 6
    //   4759: istore 5
    //   4761: lload 9
    //   4763: lstore 13
    //   4765: aload_0
    //   4766: aload 27
    //   4768: invokespecial 758	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   4771: lload 9
    //   4773: lstore 11
    //   4775: iload 6
    //   4777: istore_2
    //   4778: iload_1
    //   4779: ifne -4289 -> 490
    //   4782: aload_0
    //   4783: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   4786: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4789: getfield 583	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   4792: ldc_w 1040
    //   4795: lload 9
    //   4797: invokestatic 1062	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4800: invokeinterface 597 3 0
    //   4805: pop
    //   4806: aload_0
    //   4807: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   4810: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4813: invokevirtual 609	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   4816: lload 9
    //   4818: lstore 11
    //   4820: iload 6
    //   4822: istore_2
    //   4823: goto -4333 -> 490
    //   4826: aload_0
    //   4827: bipush 104
    //   4829: aload_0
    //   4830: aload 28
    //   4832: invokespecial 873	com/tencent/smtt/sdk/TbsApkDownloader:errorToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   4835: iconst_0
    //   4836: invokespecial 427	com/tencent/smtt/sdk/TbsApkDownloader:setDownloadStat	(ILjava/lang/String;Z)V
    //   4839: goto -122 -> 4717
    //   4842: astore 31
    //   4844: aload 27
    //   4846: astore 28
    //   4848: aload 29
    //   4850: astore 27
    //   4852: iload 6
    //   4854: istore_2
    //   4855: aload 31
    //   4857: astore 29
    //   4859: iload_2
    //   4860: istore 5
    //   4862: lload 9
    //   4864: lstore 11
    //   4866: lload 9
    //   4868: lstore 13
    //   4870: aload_0
    //   4871: aload 30
    //   4873: invokespecial 758	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   4876: iload_2
    //   4877: istore 5
    //   4879: lload 9
    //   4881: lstore 11
    //   4883: lload 9
    //   4885: lstore 13
    //   4887: aload_0
    //   4888: aload 27
    //   4890: invokespecial 758	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   4893: iload_2
    //   4894: istore 5
    //   4896: lload 9
    //   4898: lstore 11
    //   4900: lload 9
    //   4902: lstore 13
    //   4904: aload_0
    //   4905: aload 28
    //   4907: invokespecial 758	com/tencent/smtt/sdk/TbsApkDownloader:closeStream	(Ljava/io/Closeable;)V
    //   4910: iload_2
    //   4911: istore 5
    //   4913: lload 9
    //   4915: lstore 11
    //   4917: lload 9
    //   4919: lstore 13
    //   4921: aload 29
    //   4923: athrow
    //   4924: astore 27
    //   4926: lload 11
    //   4928: lstore 15
    //   4930: iload 5
    //   4932: istore 6
    //   4934: goto -2729 -> 2205
    //   4937: iload_3
    //   4938: sipush 300
    //   4941: if_icmplt +229 -> 5170
    //   4944: iload_3
    //   4945: sipush 307
    //   4948: if_icmpgt +222 -> 5170
    //   4951: lload 9
    //   4953: lstore 15
    //   4955: iload_2
    //   4956: istore 5
    //   4958: lload 9
    //   4960: lstore 13
    //   4962: aload_0
    //   4963: getfield 355	com/tencent/smtt/sdk/TbsApkDownloader:mHttpRequest	Ljava/net/HttpURLConnection;
    //   4966: ldc_w 1223
    //   4969: invokevirtual 1227	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   4972: astore 27
    //   4974: lload 9
    //   4976: lstore 15
    //   4978: iload_2
    //   4979: istore 5
    //   4981: lload 9
    //   4983: lstore 13
    //   4985: aload 27
    //   4987: invokestatic 542	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4990: ifne +90 -> 5080
    //   4993: lload 9
    //   4995: lstore 15
    //   4997: iload_2
    //   4998: istore 5
    //   5000: lload 9
    //   5002: lstore 13
    //   5004: aload_0
    //   5005: aload 27
    //   5007: putfield 768	com/tencent/smtt/sdk/TbsApkDownloader:mLocation	Ljava/lang/String;
    //   5010: lload 9
    //   5012: lstore 15
    //   5014: iload_2
    //   5015: istore 5
    //   5017: lload 9
    //   5019: lstore 13
    //   5021: aload_0
    //   5022: aload_0
    //   5023: getfield 762	com/tencent/smtt/sdk/TbsApkDownloader:mRetryTimes302	I
    //   5026: iconst_1
    //   5027: iadd
    //   5028: putfield 762	com/tencent/smtt/sdk/TbsApkDownloader:mRetryTimes302	I
    //   5031: lload 9
    //   5033: lstore 11
    //   5035: iload_1
    //   5036: ifne -4546 -> 490
    //   5039: aload_0
    //   5040: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   5043: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5046: getfield 583	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   5049: ldc_w 1040
    //   5052: lload 9
    //   5054: invokestatic 1062	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5057: invokeinterface 597 3 0
    //   5062: pop
    //   5063: aload_0
    //   5064: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   5067: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5070: invokevirtual 609	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5073: lload 9
    //   5075: lstore 11
    //   5077: goto -4587 -> 490
    //   5080: lload 9
    //   5082: lstore 15
    //   5084: iload_2
    //   5085: istore 5
    //   5087: lload 9
    //   5089: lstore 13
    //   5091: aload_0
    //   5092: bipush 124
    //   5094: aconst_null
    //   5095: iconst_1
    //   5096: invokespecial 427	com/tencent/smtt/sdk/TbsApkDownloader:setDownloadStat	(ILjava/lang/String;Z)V
    //   5099: lload 9
    //   5101: lstore 15
    //   5103: iload_2
    //   5104: istore 5
    //   5106: lload 9
    //   5108: lstore 13
    //   5110: aload_0
    //   5111: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   5114: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5117: sipush -312
    //   5120: invokevirtual 972	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   5123: iload_2
    //   5124: istore 5
    //   5126: iload_1
    //   5127: ifne -4623 -> 504
    //   5130: aload_0
    //   5131: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   5134: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5137: getfield 583	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   5140: ldc_w 1040
    //   5143: lload 9
    //   5145: invokestatic 1062	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5148: invokeinterface 597 3 0
    //   5153: pop
    //   5154: aload_0
    //   5155: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   5158: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5161: invokevirtual 609	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5164: iload_2
    //   5165: istore 5
    //   5167: goto -4663 -> 504
    //   5170: lload 9
    //   5172: lstore 15
    //   5174: iload_2
    //   5175: istore 5
    //   5177: lload 9
    //   5179: lstore 13
    //   5181: aload_0
    //   5182: bipush 102
    //   5184: iload_3
    //   5185: invokestatic 950	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   5188: iconst_0
    //   5189: invokespecial 427	com/tencent/smtt/sdk/TbsApkDownloader:setDownloadStat	(ILjava/lang/String;Z)V
    //   5192: iload_3
    //   5193: sipush 416
    //   5196: if_icmpne +185 -> 5381
    //   5199: lload 9
    //   5201: lstore 15
    //   5203: iload_2
    //   5204: istore 5
    //   5206: lload 9
    //   5208: lstore 13
    //   5210: aload_0
    //   5211: iconst_1
    //   5212: iload 8
    //   5214: invokespecial 982	com/tencent/smtt/sdk/TbsApkDownloader:verifyTbsApk	(ZZ)Z
    //   5217: ifeq +76 -> 5293
    //   5220: iconst_1
    //   5221: istore 5
    //   5223: iconst_1
    //   5224: istore_2
    //   5225: lload 9
    //   5227: lstore 15
    //   5229: lload 9
    //   5231: lstore 13
    //   5233: aload_0
    //   5234: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   5237: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5240: sipush -214
    //   5243: invokevirtual 972	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   5246: iload_2
    //   5247: istore 5
    //   5249: iload_1
    //   5250: ifne -4746 -> 504
    //   5253: aload_0
    //   5254: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   5257: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5260: getfield 583	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   5263: ldc_w 1040
    //   5266: lload 9
    //   5268: invokestatic 1062	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5271: invokeinterface 597 3 0
    //   5276: pop
    //   5277: aload_0
    //   5278: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   5281: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5284: invokevirtual 609	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5287: iload_2
    //   5288: istore 5
    //   5290: goto -4786 -> 504
    //   5293: lload 9
    //   5295: lstore 15
    //   5297: iload_2
    //   5298: istore 5
    //   5300: lload 9
    //   5302: lstore 13
    //   5304: aload_0
    //   5305: iconst_0
    //   5306: invokespecial 882	com/tencent/smtt/sdk/TbsApkDownloader:deleteFile	(Z)Z
    //   5309: pop
    //   5310: lload 9
    //   5312: lstore 15
    //   5314: iload_2
    //   5315: istore 5
    //   5317: lload 9
    //   5319: lstore 13
    //   5321: aload_0
    //   5322: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   5325: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5328: sipush -313
    //   5331: invokevirtual 972	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   5334: iload_2
    //   5335: istore 5
    //   5337: iload_1
    //   5338: ifne -4834 -> 504
    //   5341: aload_0
    //   5342: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   5345: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5348: getfield 583	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   5351: ldc_w 1040
    //   5354: lload 9
    //   5356: invokestatic 1062	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5359: invokeinterface 597 3 0
    //   5364: pop
    //   5365: aload_0
    //   5366: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   5369: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5372: invokevirtual 609	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5375: iload_2
    //   5376: istore 5
    //   5378: goto -4874 -> 504
    //   5381: iload_3
    //   5382: sipush 403
    //   5385: if_icmpeq +10 -> 5395
    //   5388: iload_3
    //   5389: sipush 406
    //   5392: if_icmpne +96 -> 5488
    //   5395: lload 9
    //   5397: lstore 15
    //   5399: iload_2
    //   5400: istore 5
    //   5402: lload 9
    //   5404: lstore 13
    //   5406: aload_0
    //   5407: getfield 766	com/tencent/smtt/sdk/TbsApkDownloader:mContentLength	J
    //   5410: ldc2_w 763
    //   5413: lcmp
    //   5414: ifne +74 -> 5488
    //   5417: lload 9
    //   5419: lstore 15
    //   5421: iload_2
    //   5422: istore 5
    //   5424: lload 9
    //   5426: lstore 13
    //   5428: aload_0
    //   5429: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   5432: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5435: sipush -314
    //   5438: invokevirtual 972	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   5441: iload_2
    //   5442: istore 5
    //   5444: iload_1
    //   5445: ifne -4941 -> 504
    //   5448: aload_0
    //   5449: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   5452: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5455: getfield 583	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   5458: ldc_w 1040
    //   5461: lload 9
    //   5463: invokestatic 1062	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5466: invokeinterface 597 3 0
    //   5471: pop
    //   5472: aload_0
    //   5473: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   5476: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5479: invokevirtual 609	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5482: iload_2
    //   5483: istore 5
    //   5485: goto -4981 -> 504
    //   5488: iload_3
    //   5489: sipush 202
    //   5492: if_icmpne +52 -> 5544
    //   5495: lload 9
    //   5497: lstore 11
    //   5499: iload_1
    //   5500: ifne -5010 -> 490
    //   5503: aload_0
    //   5504: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   5507: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5510: getfield 583	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   5513: ldc_w 1040
    //   5516: lload 9
    //   5518: invokestatic 1062	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5521: invokeinterface 597 3 0
    //   5526: pop
    //   5527: aload_0
    //   5528: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   5531: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5534: invokevirtual 609	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5537: lload 9
    //   5539: lstore 11
    //   5541: goto -5051 -> 490
    //   5544: lload 9
    //   5546: lstore 15
    //   5548: iload_2
    //   5549: istore 5
    //   5551: lload 9
    //   5553: lstore 13
    //   5555: aload_0
    //   5556: getfield 760	com/tencent/smtt/sdk/TbsApkDownloader:mRetryTimes	I
    //   5559: aload_0
    //   5560: getfield 115	com/tencent/smtt/sdk/TbsApkDownloader:mMaxRetryTimes	I
    //   5563: if_icmpge +176 -> 5739
    //   5566: iload_3
    //   5567: sipush 503
    //   5570: if_icmpne +169 -> 5739
    //   5573: lload 9
    //   5575: lstore 15
    //   5577: iload_2
    //   5578: istore 5
    //   5580: lload 9
    //   5582: lstore 13
    //   5584: aload_0
    //   5585: aload_0
    //   5586: getfield 355	com/tencent/smtt/sdk/TbsApkDownloader:mHttpRequest	Ljava/net/HttpURLConnection;
    //   5589: ldc_w 1229
    //   5592: invokevirtual 1227	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   5595: invokestatic 947	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   5598: invokespecial 1177	com/tencent/smtt/sdk/TbsApkDownloader:retry	(J)V
    //   5601: lload 9
    //   5603: lstore 15
    //   5605: iload_2
    //   5606: istore 5
    //   5608: lload 9
    //   5610: lstore 13
    //   5612: aload_0
    //   5613: getfield 357	com/tencent/smtt/sdk/TbsApkDownloader:mCanceled	Z
    //   5616: ifeq +74 -> 5690
    //   5619: lload 9
    //   5621: lstore 15
    //   5623: iload_2
    //   5624: istore 5
    //   5626: lload 9
    //   5628: lstore 13
    //   5630: aload_0
    //   5631: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   5634: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5637: sipush -309
    //   5640: invokevirtual 972	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   5643: iload_2
    //   5644: istore 5
    //   5646: iload_1
    //   5647: ifne -5143 -> 504
    //   5650: aload_0
    //   5651: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   5654: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5657: getfield 583	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   5660: ldc_w 1040
    //   5663: lload 9
    //   5665: invokestatic 1062	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5668: invokeinterface 597 3 0
    //   5673: pop
    //   5674: aload_0
    //   5675: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   5678: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5681: invokevirtual 609	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5684: iload_2
    //   5685: istore 5
    //   5687: goto -5183 -> 504
    //   5690: lload 9
    //   5692: lstore 11
    //   5694: iload_1
    //   5695: ifne -5205 -> 490
    //   5698: aload_0
    //   5699: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   5702: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5705: getfield 583	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   5708: ldc_w 1040
    //   5711: lload 9
    //   5713: invokestatic 1062	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5716: invokeinterface 597 3 0
    //   5721: pop
    //   5722: aload_0
    //   5723: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   5726: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5729: invokevirtual 609	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5732: lload 9
    //   5734: lstore 11
    //   5736: goto -5246 -> 490
    //   5739: lload 9
    //   5741: lstore 15
    //   5743: iload_2
    //   5744: istore 5
    //   5746: lload 9
    //   5748: lstore 13
    //   5750: aload_0
    //   5751: getfield 760	com/tencent/smtt/sdk/TbsApkDownloader:mRetryTimes	I
    //   5754: aload_0
    //   5755: getfield 115	com/tencent/smtt/sdk/TbsApkDownloader:mMaxRetryTimes	I
    //   5758: if_icmpge +185 -> 5943
    //   5761: iload_3
    //   5762: sipush 408
    //   5765: if_icmpeq +24 -> 5789
    //   5768: iload_3
    //   5769: sipush 504
    //   5772: if_icmpeq +17 -> 5789
    //   5775: iload_3
    //   5776: sipush 502
    //   5779: if_icmpeq +10 -> 5789
    //   5782: iload_3
    //   5783: sipush 408
    //   5786: if_icmpne +157 -> 5943
    //   5789: lload 9
    //   5791: lstore 15
    //   5793: iload_2
    //   5794: istore 5
    //   5796: lload 9
    //   5798: lstore 13
    //   5800: aload_0
    //   5801: lconst_0
    //   5802: invokespecial 1177	com/tencent/smtt/sdk/TbsApkDownloader:retry	(J)V
    //   5805: lload 9
    //   5807: lstore 15
    //   5809: iload_2
    //   5810: istore 5
    //   5812: lload 9
    //   5814: lstore 13
    //   5816: aload_0
    //   5817: getfield 357	com/tencent/smtt/sdk/TbsApkDownloader:mCanceled	Z
    //   5820: ifeq +74 -> 5894
    //   5823: lload 9
    //   5825: lstore 15
    //   5827: iload_2
    //   5828: istore 5
    //   5830: lload 9
    //   5832: lstore 13
    //   5834: aload_0
    //   5835: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   5838: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5841: sipush -309
    //   5844: invokevirtual 972	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   5847: iload_2
    //   5848: istore 5
    //   5850: iload_1
    //   5851: ifne -5347 -> 504
    //   5854: aload_0
    //   5855: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   5858: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5861: getfield 583	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   5864: ldc_w 1040
    //   5867: lload 9
    //   5869: invokestatic 1062	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5872: invokeinterface 597 3 0
    //   5877: pop
    //   5878: aload_0
    //   5879: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   5882: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5885: invokevirtual 609	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5888: iload_2
    //   5889: istore 5
    //   5891: goto -5387 -> 504
    //   5894: lload 9
    //   5896: lstore 11
    //   5898: iload_1
    //   5899: ifne -5409 -> 490
    //   5902: aload_0
    //   5903: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   5906: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5909: getfield 583	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   5912: ldc_w 1040
    //   5915: lload 9
    //   5917: invokestatic 1062	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   5920: invokeinterface 597 3 0
    //   5925: pop
    //   5926: aload_0
    //   5927: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   5930: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   5933: invokevirtual 609	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   5936: lload 9
    //   5938: lstore 11
    //   5940: goto -5450 -> 490
    //   5943: lload 9
    //   5945: lstore 15
    //   5947: iload_2
    //   5948: istore 5
    //   5950: lload 9
    //   5952: lstore 13
    //   5954: aload_0
    //   5955: invokespecial 1084	com/tencent/smtt/sdk/TbsApkDownloader:downloadFileSize	()J
    //   5958: lconst_0
    //   5959: lcmp
    //   5960: ifgt +93 -> 6053
    //   5963: lload 9
    //   5965: lstore 15
    //   5967: iload_2
    //   5968: istore 5
    //   5970: lload 9
    //   5972: lstore 13
    //   5974: aload_0
    //   5975: getfield 770	com/tencent/smtt/sdk/TbsApkDownloader:mHasTmpTryNoRange	Z
    //   5978: ifne +75 -> 6053
    //   5981: iload_3
    //   5982: sipush 410
    //   5985: if_icmpeq +68 -> 6053
    //   5988: lload 9
    //   5990: lstore 15
    //   5992: iload_2
    //   5993: istore 5
    //   5995: lload 9
    //   5997: lstore 13
    //   5999: aload_0
    //   6000: iconst_1
    //   6001: putfield 770	com/tencent/smtt/sdk/TbsApkDownloader:mHasTmpTryNoRange	Z
    //   6004: lload 9
    //   6006: lstore 11
    //   6008: iload_1
    //   6009: ifne -5519 -> 490
    //   6012: aload_0
    //   6013: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   6016: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6019: getfield 583	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   6022: ldc_w 1040
    //   6025: lload 9
    //   6027: invokestatic 1062	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6030: invokeinterface 597 3 0
    //   6035: pop
    //   6036: aload_0
    //   6037: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   6040: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6043: invokevirtual 609	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   6046: lload 9
    //   6048: lstore 11
    //   6050: goto -5560 -> 490
    //   6053: lload 9
    //   6055: lstore 15
    //   6057: iload_2
    //   6058: istore 5
    //   6060: lload 9
    //   6062: lstore 13
    //   6064: aload_0
    //   6065: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   6068: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6071: sipush -315
    //   6074: invokevirtual 972	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   6077: iload_2
    //   6078: istore 5
    //   6080: iload_1
    //   6081: ifne -5577 -> 504
    //   6084: aload_0
    //   6085: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   6088: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6091: getfield 583	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   6094: ldc_w 1040
    //   6097: lload 9
    //   6099: invokestatic 1062	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6102: invokeinterface 597 3 0
    //   6107: pop
    //   6108: aload_0
    //   6109: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   6112: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6115: invokevirtual 609	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   6118: iload_2
    //   6119: istore 5
    //   6121: goto -5617 -> 504
    //   6124: lload 15
    //   6126: lstore 13
    //   6128: aload 27
    //   6130: invokevirtual 568	java/lang/Throwable:printStackTrace	()V
    //   6133: lload 15
    //   6135: lstore 13
    //   6137: aload_0
    //   6138: lconst_0
    //   6139: invokespecial 1177	com/tencent/smtt/sdk/TbsApkDownloader:retry	(J)V
    //   6142: lload 15
    //   6144: lstore 13
    //   6146: aload_0
    //   6147: bipush 107
    //   6149: aload_0
    //   6150: aload 27
    //   6152: invokespecial 873	com/tencent/smtt/sdk/TbsApkDownloader:errorToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   6155: iconst_0
    //   6156: invokespecial 427	com/tencent/smtt/sdk/TbsApkDownloader:setDownloadStat	(ILjava/lang/String;Z)V
    //   6159: lload 15
    //   6161: lstore 13
    //   6163: aload_0
    //   6164: getfield 357	com/tencent/smtt/sdk/TbsApkDownloader:mCanceled	Z
    //   6167: ifeq -3865 -> 2302
    //   6170: lload 15
    //   6172: lstore 13
    //   6174: aload_0
    //   6175: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   6178: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6181: sipush -309
    //   6184: invokevirtual 972	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   6187: iload 6
    //   6189: istore 5
    //   6191: iload_1
    //   6192: ifne -5688 -> 504
    //   6195: aload_0
    //   6196: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   6199: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6202: getfield 583	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   6205: ldc_w 1040
    //   6208: lload 15
    //   6210: invokestatic 1062	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6213: invokeinterface 597 3 0
    //   6218: pop
    //   6219: aload_0
    //   6220: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   6223: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6226: invokevirtual 609	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   6229: iload 6
    //   6231: istore 5
    //   6233: goto -5729 -> 504
    //   6236: iconst_0
    //   6237: istore_3
    //   6238: goto -5679 -> 559
    //   6241: iconst_2
    //   6242: istore_3
    //   6243: goto -5661 -> 582
    //   6246: aload_0
    //   6247: getfield 139	com/tencent/smtt/sdk/TbsApkDownloader:mDownloadStat	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   6250: iconst_0
    //   6251: invokevirtual 1046	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setPatchUpdateFlag	(I)V
    //   6254: goto -5666 -> 588
    //   6257: aload_0
    //   6258: getfield 127	com/tencent/smtt/sdk/TbsApkDownloader:mContext	Landroid/content/Context;
    //   6261: invokestatic 248	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   6264: sipush -318
    //   6267: invokevirtual 972	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   6270: aload_0
    //   6271: iconst_0
    //   6272: invokespecial 882	com/tencent/smtt/sdk/TbsApkDownloader:deleteFile	(Z)Z
    //   6275: pop
    //   6276: goto -5656 -> 620
    //   6279: aload 27
    //   6281: getfield 252	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   6284: ldc_w 1231
    //   6287: iconst_0
    //   6288: invokeinterface 260 3 0
    //   6293: istore_3
    //   6294: aload 27
    //   6296: getfield 583	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   6299: astore 28
    //   6301: iload_3
    //   6302: iconst_1
    //   6303: iadd
    //   6304: istore_3
    //   6305: aload 28
    //   6307: ldc_w 1231
    //   6310: iload_3
    //   6311: invokestatic 606	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   6314: invokeinterface 597 3 0
    //   6319: pop
    //   6320: iload_3
    //   6321: aload 27
    //   6323: invokevirtual 1234	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadFailedMaxRetrytimes	()I
    //   6326: if_icmpne -5658 -> 668
    //   6329: aload_0
    //   6330: getfield 139	com/tencent/smtt/sdk/TbsApkDownloader:mDownloadStat	Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   6333: iconst_2
    //   6334: invokevirtual 1097	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setDownloadCancel	(I)V
    //   6337: goto -5669 -> 668
    //   6340: iconst_0
    //   6341: istore_3
    //   6342: goto -5657 -> 685
    //   6345: astore 27
    //   6347: goto -3869 -> 2478
    //   6350: astore 29
    //   6352: aconst_null
    //   6353: astore 27
    //   6355: aconst_null
    //   6356: astore 28
    //   6358: aconst_null
    //   6359: astore 30
    //   6361: goto -1502 -> 4859
    //   6364: astore 29
    //   6366: aconst_null
    //   6367: astore 27
    //   6369: aconst_null
    //   6370: astore 30
    //   6372: goto -1513 -> 4859
    //   6375: astore 29
    //   6377: aconst_null
    //   6378: astore 30
    //   6380: goto -1521 -> 4859
    //   6383: astore 29
    //   6385: goto -1526 -> 4859
    //   6388: astore 29
    //   6390: iload 6
    //   6392: istore_2
    //   6393: lload 17
    //   6395: lstore 9
    //   6397: goto -1538 -> 4859
    //   6400: astore 29
    //   6402: lload 11
    //   6404: lstore 9
    //   6406: goto -1547 -> 4859
    //   6409: astore 28
    //   6411: iload_2
    //   6412: istore 6
    //   6414: aload 31
    //   6416: astore 30
    //   6418: goto -3001 -> 3417
    //   6421: astore 29
    //   6423: aload 28
    //   6425: astore 30
    //   6427: iload_2
    //   6428: istore 6
    //   6430: aload 29
    //   6432: astore 28
    //   6434: aload 27
    //   6436: astore 29
    //   6438: aload 30
    //   6440: astore 27
    //   6442: aload 31
    //   6444: astore 30
    //   6446: goto -3029 -> 3417
    //   6449: astore 29
    //   6451: aload 28
    //   6453: astore 31
    //   6455: iload_2
    //   6456: istore 6
    //   6458: aload 29
    //   6460: astore 28
    //   6462: aload 27
    //   6464: astore 29
    //   6466: aload 31
    //   6468: astore 27
    //   6470: goto -3053 -> 3417
    //   6473: astore 29
    //   6475: lload 19
    //   6477: lstore 9
    //   6479: aload 28
    //   6481: astore 31
    //   6483: iload 7
    //   6485: istore 6
    //   6487: aload 29
    //   6489: astore 28
    //   6491: aload 27
    //   6493: astore 29
    //   6495: aload 31
    //   6497: astore 27
    //   6499: goto -3082 -> 3417
    //   6502: astore 29
    //   6504: aload 28
    //   6506: astore 31
    //   6508: lload 11
    //   6510: lstore 9
    //   6512: iload_2
    //   6513: istore 6
    //   6515: aload 29
    //   6517: astore 28
    //   6519: aload 27
    //   6521: astore 29
    //   6523: aload 31
    //   6525: astore 27
    //   6527: goto -3110 -> 3417
    //   6530: lload 13
    //   6532: lstore 9
    //   6534: lload 15
    //   6536: lstore 13
    //   6538: goto -2186 -> 4352
    //   6541: aconst_null
    //   6542: astore 27
    //   6544: aconst_null
    //   6545: astore 30
    //   6547: goto -2173 -> 4374
    //   6550: lload 11
    //   6552: lstore 9
    //   6554: goto -5647 -> 907
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	6557	0	this	TbsApkDownloader
    //   0	6557	1	paramBoolean1	boolean
    //   0	6557	2	paramBoolean2	boolean
    //   54	6288	3	i	int
    //   3604	621	4	j	int
    //   502	5730	5	bool1	boolean
    //   2203	4311	6	bool2	boolean
    //   3183	3301	7	bool3	boolean
    //   71	5142	8	bool4	boolean
    //   749	5804	9	l1	long
    //   477	6074	11	l2	long
    //   764	5773	13	l3	long
    //   757	5778	15	l4	long
    //   2650	3744	17	l5	long
    //   3187	3289	19	l6	long
    //   3169	1198	21	l7	long
    //   745	3388	23	l8	long
    //   454	3475	25	l9	long
    //   145	1941	27	localObject1	Object
    //   2199	254	27	localThrowable1	Throwable
    //   2476	41	27	localObject2	Object
    //   3056	1833	27	localObject3	Object
    //   4924	1	27	localThrowable2	Throwable
    //   4972	1350	27	str	String
    //   6345	1	27	localObject4	Object
    //   6353	190	27	localObject5	Object
    //   3087	3270	28	localObject6	Object
    //   6409	15	28	localIOException1	IOException
    //   6432	86	28	localIOException2	IOException
    //   3059	1863	29	localObject7	Object
    //   6350	1	29	localObject8	Object
    //   6364	1	29	localObject9	Object
    //   6375	1	29	localObject10	Object
    //   6383	1	29	localObject11	Object
    //   6388	1	29	localObject12	Object
    //   6400	1	29	localObject13	Object
    //   6421	10	29	localIOException3	IOException
    //   6436	1	29	localObject14	Object
    //   6449	10	29	localIOException4	IOException
    //   6464	1	29	localObject15	Object
    //   6473	15	29	localIOException5	IOException
    //   6493	1	29	localObject16	Object
    //   6502	14	29	localIOException6	IOException
    //   6521	1	29	localObject17	Object
    //   3158	3388	30	localObject18	Object
    //   3053	354	31	localObject19	Object
    //   4842	1601	31	localObject20	Object
    //   6453	71	31	localObject21	Object
    //   3400	11	32	localIOException7	IOException
    // Exception table:
    //   from	to	target	type
    //   766	795	2199	java/lang/Throwable
    //   806	814	2199	java/lang/Throwable
    //   825	849	2199	java/lang/Throwable
    //   860	883	2199	java/lang/Throwable
    //   894	904	2199	java/lang/Throwable
    //   1049	1075	2199	java/lang/Throwable
    //   1094	1103	2199	java/lang/Throwable
    //   1114	1122	2199	java/lang/Throwable
    //   1133	1146	2199	java/lang/Throwable
    //   1204	1209	2199	java/lang/Throwable
    //   1220	1227	2199	java/lang/Throwable
    //   1238	1244	2199	java/lang/Throwable
    //   1255	1295	2199	java/lang/Throwable
    //   1306	1318	2199	java/lang/Throwable
    //   1329	1338	2199	java/lang/Throwable
    //   1349	1355	2199	java/lang/Throwable
    //   1366	1372	2199	java/lang/Throwable
    //   1386	1393	2199	java/lang/Throwable
    //   1404	1410	2199	java/lang/Throwable
    //   1421	1447	2199	java/lang/Throwable
    //   1458	1467	2199	java/lang/Throwable
    //   1478	1505	2199	java/lang/Throwable
    //   1516	1553	2199	java/lang/Throwable
    //   1564	1570	2199	java/lang/Throwable
    //   1590	1596	2199	java/lang/Throwable
    //   1607	1615	2199	java/lang/Throwable
    //   1626	1635	2199	java/lang/Throwable
    //   1646	1653	2199	java/lang/Throwable
    //   1664	1672	2199	java/lang/Throwable
    //   1683	1689	2199	java/lang/Throwable
    //   1700	1705	2199	java/lang/Throwable
    //   1716	1724	2199	java/lang/Throwable
    //   1735	1749	2199	java/lang/Throwable
    //   1760	1768	2199	java/lang/Throwable
    //   1779	1804	2199	java/lang/Throwable
    //   1815	1823	2199	java/lang/Throwable
    //   1838	1848	2199	java/lang/Throwable
    //   1859	1870	2199	java/lang/Throwable
    //   1881	1891	2199	java/lang/Throwable
    //   1902	1908	2199	java/lang/Throwable
    //   1919	1923	2199	java/lang/Throwable
    //   1934	1940	2199	java/lang/Throwable
    //   1951	1961	2199	java/lang/Throwable
    //   1972	1981	2199	java/lang/Throwable
    //   1992	1999	2199	java/lang/Throwable
    //   2010	2023	2199	java/lang/Throwable
    //   2081	2087	2199	java/lang/Throwable
    //   2101	2141	2199	java/lang/Throwable
    //   2152	2196	2199	java/lang/Throwable
    //   2390	2398	2199	java/lang/Throwable
    //   2409	2421	2199	java/lang/Throwable
    //   2432	2440	2199	java/lang/Throwable
    //   2451	2457	2199	java/lang/Throwable
    //   2468	2473	2199	java/lang/Throwable
    //   2544	2559	2199	java/lang/Throwable
    //   2570	2598	2199	java/lang/Throwable
    //   2609	2620	2199	java/lang/Throwable
    //   2631	2652	2199	java/lang/Throwable
    //   2670	2680	2199	java/lang/Throwable
    //   2691	2731	2199	java/lang/Throwable
    //   2746	2753	2199	java/lang/Throwable
    //   2764	2770	2199	java/lang/Throwable
    //   2781	2791	2199	java/lang/Throwable
    //   2802	2809	2199	java/lang/Throwable
    //   2820	2827	2199	java/lang/Throwable
    //   2892	2933	2199	java/lang/Throwable
    //   2944	2957	2199	java/lang/Throwable
    //   3015	3025	2199	java/lang/Throwable
    //   3036	3049	2199	java/lang/Throwable
    //   3072	3080	2199	java/lang/Throwable
    //   3265	3271	2199	java/lang/Throwable
    //   3283	3289	2199	java/lang/Throwable
    //   3301	3307	2199	java/lang/Throwable
    //   3475	3481	2199	java/lang/Throwable
    //   3493	3499	2199	java/lang/Throwable
    //   3511	3517	2199	java/lang/Throwable
    //   4601	4607	2199	java/lang/Throwable
    //   4619	4625	2199	java/lang/Throwable
    //   4637	4643	2199	java/lang/Throwable
    //   4729	4735	2199	java/lang/Throwable
    //   4747	4753	2199	java/lang/Throwable
    //   4765	4771	2199	java/lang/Throwable
    //   4962	4974	2199	java/lang/Throwable
    //   4985	4993	2199	java/lang/Throwable
    //   5004	5010	2199	java/lang/Throwable
    //   5021	5031	2199	java/lang/Throwable
    //   5091	5099	2199	java/lang/Throwable
    //   5110	5123	2199	java/lang/Throwable
    //   5181	5192	2199	java/lang/Throwable
    //   5210	5220	2199	java/lang/Throwable
    //   5233	5246	2199	java/lang/Throwable
    //   5304	5310	2199	java/lang/Throwable
    //   5321	5334	2199	java/lang/Throwable
    //   5406	5417	2199	java/lang/Throwable
    //   5428	5441	2199	java/lang/Throwable
    //   5555	5566	2199	java/lang/Throwable
    //   5584	5601	2199	java/lang/Throwable
    //   5612	5619	2199	java/lang/Throwable
    //   5630	5643	2199	java/lang/Throwable
    //   5750	5761	2199	java/lang/Throwable
    //   5800	5805	2199	java/lang/Throwable
    //   5816	5823	2199	java/lang/Throwable
    //   5834	5847	2199	java/lang/Throwable
    //   5954	5963	2199	java/lang/Throwable
    //   5974	5981	2199	java/lang/Throwable
    //   5999	6004	2199	java/lang/Throwable
    //   6064	6077	2199	java/lang/Throwable
    //   766	795	2476	finally
    //   806	814	2476	finally
    //   825	849	2476	finally
    //   860	883	2476	finally
    //   894	904	2476	finally
    //   1049	1075	2476	finally
    //   1094	1103	2476	finally
    //   1114	1122	2476	finally
    //   1133	1146	2476	finally
    //   1204	1209	2476	finally
    //   1220	1227	2476	finally
    //   1238	1244	2476	finally
    //   1255	1295	2476	finally
    //   1306	1318	2476	finally
    //   1329	1338	2476	finally
    //   1349	1355	2476	finally
    //   1366	1372	2476	finally
    //   1386	1393	2476	finally
    //   1404	1410	2476	finally
    //   1421	1447	2476	finally
    //   1458	1467	2476	finally
    //   1478	1505	2476	finally
    //   1516	1553	2476	finally
    //   1564	1570	2476	finally
    //   1590	1596	2476	finally
    //   1607	1615	2476	finally
    //   1626	1635	2476	finally
    //   1646	1653	2476	finally
    //   1664	1672	2476	finally
    //   1683	1689	2476	finally
    //   1700	1705	2476	finally
    //   1716	1724	2476	finally
    //   1735	1749	2476	finally
    //   1760	1768	2476	finally
    //   1779	1804	2476	finally
    //   1815	1823	2476	finally
    //   1838	1848	2476	finally
    //   1859	1870	2476	finally
    //   1881	1891	2476	finally
    //   1902	1908	2476	finally
    //   1919	1923	2476	finally
    //   1934	1940	2476	finally
    //   1951	1961	2476	finally
    //   1972	1981	2476	finally
    //   1992	1999	2476	finally
    //   2010	2023	2476	finally
    //   2081	2087	2476	finally
    //   2101	2141	2476	finally
    //   2152	2196	2476	finally
    //   2209	2217	2476	finally
    //   2225	2232	2476	finally
    //   2236	2244	2476	finally
    //   2248	2290	2476	finally
    //   2294	2302	2476	finally
    //   2306	2319	2476	finally
    //   2390	2398	2476	finally
    //   2409	2421	2476	finally
    //   2432	2440	2476	finally
    //   2451	2457	2476	finally
    //   2468	2473	2476	finally
    //   2544	2559	2476	finally
    //   2570	2598	2476	finally
    //   2609	2620	2476	finally
    //   2631	2652	2476	finally
    //   2670	2680	2476	finally
    //   2691	2731	2476	finally
    //   2746	2753	2476	finally
    //   2764	2770	2476	finally
    //   2781	2791	2476	finally
    //   2802	2809	2476	finally
    //   2820	2827	2476	finally
    //   2892	2933	2476	finally
    //   2944	2957	2476	finally
    //   3015	3025	2476	finally
    //   3036	3049	2476	finally
    //   3072	3080	2476	finally
    //   3265	3271	2476	finally
    //   3283	3289	2476	finally
    //   3301	3307	2476	finally
    //   3475	3481	2476	finally
    //   3493	3499	2476	finally
    //   3511	3517	2476	finally
    //   4601	4607	2476	finally
    //   4619	4625	2476	finally
    //   4637	4643	2476	finally
    //   4729	4735	2476	finally
    //   4747	4753	2476	finally
    //   4765	4771	2476	finally
    //   4962	4974	2476	finally
    //   4985	4993	2476	finally
    //   5004	5010	2476	finally
    //   5021	5031	2476	finally
    //   5091	5099	2476	finally
    //   5110	5123	2476	finally
    //   5181	5192	2476	finally
    //   5210	5220	2476	finally
    //   5233	5246	2476	finally
    //   5304	5310	2476	finally
    //   5321	5334	2476	finally
    //   5406	5417	2476	finally
    //   5428	5441	2476	finally
    //   5555	5566	2476	finally
    //   5584	5601	2476	finally
    //   5612	5619	2476	finally
    //   5630	5643	2476	finally
    //   5750	5761	2476	finally
    //   5800	5805	2476	finally
    //   5816	5823	2476	finally
    //   5834	5847	2476	finally
    //   5954	5963	2476	finally
    //   5974	5981	2476	finally
    //   5999	6004	2476	finally
    //   6064	6077	2476	finally
    //   6128	6133	2476	finally
    //   6137	6142	2476	finally
    //   6146	6159	2476	finally
    //   6163	6170	2476	finally
    //   6174	6187	2476	finally
    //   3094	3103	3400	java/io/IOException
    //   3108	3130	3400	java/io/IOException
    //   3367	3397	3400	java/io/IOException
    //   3417	3438	4842	finally
    //   3438	3463	4842	finally
    //   4518	4589	4842	finally
    //   4692	4717	4842	finally
    //   4826	4839	4842	finally
    //   918	928	4924	java/lang/Throwable
    //   939	948	4924	java/lang/Throwable
    //   959	967	4924	java/lang/Throwable
    //   978	991	4924	java/lang/Throwable
    //   4385	4391	4924	java/lang/Throwable
    //   4402	4408	4924	java/lang/Throwable
    //   4419	4425	4924	java/lang/Throwable
    //   4436	4443	4924	java/lang/Throwable
    //   4454	4467	4924	java/lang/Throwable
    //   4870	4876	4924	java/lang/Throwable
    //   4887	4893	4924	java/lang/Throwable
    //   4904	4910	4924	java/lang/Throwable
    //   4921	4924	4924	java/lang/Throwable
    //   918	928	6345	finally
    //   939	948	6345	finally
    //   959	967	6345	finally
    //   978	991	6345	finally
    //   4385	4391	6345	finally
    //   4402	4408	6345	finally
    //   4419	4425	6345	finally
    //   4436	4443	6345	finally
    //   4454	4467	6345	finally
    //   4870	4876	6345	finally
    //   4887	4893	6345	finally
    //   4904	4910	6345	finally
    //   4921	4924	6345	finally
    //   3080	3089	6350	finally
    //   3094	3103	6364	finally
    //   3108	3130	6364	finally
    //   3367	3397	6364	finally
    //   3130	3160	6375	finally
    //   3160	3165	6383	finally
    //   3189	3196	6388	finally
    //   3210	3219	6388	finally
    //   3233	3246	6388	finally
    //   3593	3606	6388	finally
    //   3625	3632	6388	finally
    //   3646	3656	6388	finally
    //   3674	3682	6388	finally
    //   3704	3709	6388	finally
    //   3729	3734	6388	finally
    //   3751	3758	6388	finally
    //   3777	3790	6388	finally
    //   3811	3821	6388	finally
    //   3835	3840	6388	finally
    //   3878	3887	6388	finally
    //   3901	3940	6388	finally
    //   3954	3967	6388	finally
    //   3991	4001	6388	finally
    //   4015	4024	6388	finally
    //   4038	4086	6388	finally
    //   4100	4113	6388	finally
    //   4124	4139	6400	finally
    //   4159	4231	6400	finally
    //   4255	4286	6400	finally
    //   4286	4312	6400	finally
    //   4312	4334	6400	finally
    //   3080	3089	6409	java/io/IOException
    //   3130	3160	6421	java/io/IOException
    //   3160	3165	6449	java/io/IOException
    //   3189	3196	6473	java/io/IOException
    //   3210	3219	6473	java/io/IOException
    //   3233	3246	6473	java/io/IOException
    //   3593	3606	6473	java/io/IOException
    //   3625	3632	6473	java/io/IOException
    //   3646	3656	6473	java/io/IOException
    //   3674	3682	6473	java/io/IOException
    //   3704	3709	6473	java/io/IOException
    //   3729	3734	6473	java/io/IOException
    //   3751	3758	6473	java/io/IOException
    //   3777	3790	6473	java/io/IOException
    //   3811	3821	6473	java/io/IOException
    //   3835	3840	6473	java/io/IOException
    //   3878	3887	6473	java/io/IOException
    //   3901	3940	6473	java/io/IOException
    //   3954	3967	6473	java/io/IOException
    //   3991	4001	6473	java/io/IOException
    //   4015	4024	6473	java/io/IOException
    //   4038	4086	6473	java/io/IOException
    //   4100	4113	6473	java/io/IOException
    //   4124	4139	6502	java/io/IOException
    //   4159	4231	6502	java/io/IOException
    //   4255	4286	6502	java/io/IOException
    //   4286	4312	6502	java/io/IOException
    //   4312	4334	6502	java/io/IOException
  }
  
  public void stopDownload()
  {
    this.mCanceled = true;
    TbsLogReport.TbsLogInfo localTbsLogInfo;
    if (TbsShareManager.isThirdPartyApp(this.mContext))
    {
      localTbsLogInfo = TbsLogReport.getInstance(this.mContext).tbsLogInfo();
      localTbsLogInfo.setErrorCode(-309);
      localTbsLogInfo.setFailDetail(new Exception());
      if (TbsDownloader.isDecoupleCore(this.mContext)) {
        TbsLogReport.getInstance(this.mContext).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD_DECOUPLE, localTbsLogInfo);
      }
    }
    else
    {
      return;
    }
    TbsLogReport.getInstance(this.mContext).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, localTbsLogInfo);
  }
  
  public boolean tryNextUrl(boolean paramBoolean)
  {
    if ((paramBoolean) && (!detectWifiNetworkAvailable()) && ((!QbSdk.getDownloadWithoutWifi()) || (!Apn.isNetworkAvailable(this.mContext)))) {}
    while ((this.urlArray == null) || (this.curUrlIndex < 0) || (this.curUrlIndex >= this.urlArray.length)) {
      return false;
    }
    String[] arrayOfString = this.urlArray;
    int i = this.curUrlIndex;
    this.curUrlIndex = (i + 1);
    this.mLocation = arrayOfString[i];
    this.mRetryTimes = 0;
    this.mRetryTimes302 = 0;
    this.mContentLength = -1L;
    this.mHasTmpTryNoRange = false;
    this.mCanceled = false;
    this.mFinished = false;
    this.mNeedDownloadStat = false;
    return true;
  }
  
  public boolean verifyAndInstallDecoupleCoreFromBackup()
  {
    TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup #1");
    try
    {
      File localFile1 = new File(FileUtil.getTBSSdcardFilePath(this.mContext, 4), TbsDownloader.getBackupFileName(true));
      if ((localFile1 != null) && (localFile1.exists())) {
        TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup #2");
      }
      while (ApkUtil.verifyTbsApk(this.mContext, localFile1, 0L, TbsDownloadConfig.getInstance(this.mContext).mPreferences.getInt("tbs_decouplecoreversion", -1)))
      {
        TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup #3");
        return TbsInstaller.getInstance().installDecoupleCoreFromBackup(this.mContext);
        File localFile2 = TbsDownloader.getExistBackupCoreForDecouple(TbsDownloadConfig.getInstance(this.mContext).mPreferences.getInt("tbs_decouplecoreversion", -1));
        if ((localFile2 != null) && (localFile2.exists())) {
          FileUtil.copyFiles(localFile2, localFile1);
        }
      }
      return false;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsApkDownloader
 * JD-Core Version:    0.7.0.1
 */