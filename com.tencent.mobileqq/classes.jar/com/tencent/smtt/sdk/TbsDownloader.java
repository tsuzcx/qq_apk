package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.smtt.utils.ApkUtil;
import com.tencent.smtt.utils.Apn;
import com.tencent.smtt.utils.AppUtil;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.HttpUtil;
import com.tencent.smtt.utils.HttpUtil.HttpResponseListener;
import com.tencent.smtt.utils.TbsCommonConfig;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public class TbsDownloader
{
  private static final int CONTINUE_INSTALL_ALREADY_CORE = 1;
  private static final int CONTINUE_INSTALL_NO_CORE = 0;
  public static final boolean DEBUG_DISABLE_DOWNLOAD = false;
  private static final String DEVICE_CUPABI_BLACKLIST = "i686|mips|x86_64";
  public static boolean DOWNLOAD_OVERSEA_TBS = false;
  private static final int FUNCTION_DOWNLOAD = 0;
  private static final int FUNCTION_QUERY = 2;
  private static final int FUNCTION_UPDATE = 1;
  public static final String LOGTAG = "TbsDownload";
  private static final int MAX_INTERVAL = 604800;
  static final int MAX_SDK_RESPONSECODE = 10000;
  static final String MISC_CALL_CAN_UNLZMA = "can_unlzma";
  private static final int MSG_CONTINUEINSTALL_TBSCORE = 103;
  private static final int MSG_PREPARE_DOWNLOAD = 102;
  private static final int MSG_SEND_CHECKCONFIG_REQUEST = 100;
  private static final int MSG_START_DOWNLOAD_DECOUPLECORE = 108;
  private static final int MSG_START_DOWNLOAD_TBSAPK = 101;
  private static final int MSG_UPLOAD_TBSLOG = 104;
  private static final int PROTOCOL_VERSION = 1;
  static final int RESPONSECODE_APK = 1;
  static final int RESPONSECODE_LZMA_APK = 4;
  static final int RESPONSECODE_UPDATE_APK = 2;
  static final int RESPONSECODE_UPDATE_PATCH = 3;
  private static final String TBS_BACKUP_APK_FILENAME_DECOUPLE = "x5.tbs.decouple";
  private static final String TBS_EXTENSION_CFG_FILE = "tbs_extension_config";
  static final String TBS_METADATA = "com.tencent.mm.BuildInfo.CLIENT_VERSION";
  static final String TBS_PRECHECK_DISABLE_VERSION = "tbs_precheck_disable_version";
  static final String TBS_PRELOADX5_CHECK_CFG_FILE = "tbs_preloadx5_check_cfg_file";
  private static final String TBS_SDBACKUP_APK_FILENAME = "x5.tbs.org";
  private static final String TBS_SDBACKUP_APK_FILENAME_OVERSEA = "x5.oversea.tbs.org";
  static boolean mIsDownloading;
  private static Object mProtocolLock = new byte[0];
  private static long mRetryIntervalInSeconds = -1L;
  private static boolean mStopDownloadByException = false;
  private static Context sAppContext;
  private static String sCpuabi;
  private static String sDefalutUserAgent;
  private static boolean sOverSea = false;
  private static boolean sOverSeaInited = false;
  private static TbsApkDownloader sTbsApkDownloader;
  private static Handler sTbsDownloaderHandler;
  private static HandlerThread sTbsHandlerThread;
  
  @TargetApi(11)
  static void clearAllCache(Context paramContext)
  {
    TbsDownloadConfig.getInstance(paramContext).clear();
    TbsLogReport.getInstance(paramContext).clear();
    TbsApkDownloader.clearAllApkFile(paramContext);
    SharedPreferences localSharedPreferences;
    if (Build.VERSION.SDK_INT >= 11)
    {
      localSharedPreferences = paramContext.getSharedPreferences("tbs_extension_config", 4);
      localSharedPreferences.edit().clear().commit();
      if (Build.VERSION.SDK_INT < 11) {
        break label96;
      }
    }
    label96:
    for (paramContext = paramContext.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4);; paramContext = paramContext.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0))
    {
      paramContext.edit().clear().commit();
      return;
      localSharedPreferences = paramContext.getSharedPreferences("tbs_extension_config", 0);
      break;
    }
  }
  
  private static JSONArray getAvailableLocalBackupVersion()
  {
    JSONArray localJSONArray = new JSONArray();
    String[] arrayOfString = TbsShareManager.getCoreProviderAppList();
    int k = arrayOfString.length;
    int i = 0;
    Object localObject;
    label56:
    long l;
    if (i < k)
    {
      localObject = arrayOfString[i];
      String str = FileUtil.getTBSSdcardFilePath(sAppContext, (String)localObject, 4, false);
      if (getOverSea(sAppContext))
      {
        localObject = "x5.oversea.tbs.org";
        localObject = new File(str, (String)localObject);
        if ((localObject != null) && (((File)localObject).exists()))
        {
          l = ApkUtil.getApkVersion(sAppContext, (File)localObject);
          if (l > 0L)
          {
            j = 0;
            label100:
            if (j >= localJSONArray.length()) {
              break label158;
            }
            if (localJSONArray.optInt(j) != l) {
              break label148;
            }
          }
        }
      }
    }
    label148:
    label158:
    for (int j = 1;; j = 0)
    {
      if (j == 0) {
        localJSONArray.put(l);
      }
      i += 1;
      break;
      localObject = "x5.tbs.org";
      break label56;
      j += 1;
      break label100;
      return localJSONArray;
    }
  }
  
  public static int getCoreShareDecoupleCoreVersion()
  {
    return TbsInstaller.getInstance().getTbsCoreShareDecoupleCoreVersion(sAppContext);
  }
  
  public static int getCoreShareDecoupleCoreVersionByContext(Context paramContext)
  {
    return TbsInstaller.getInstance().getTbsCoreShareDecoupleCoreVersion(paramContext);
  }
  
  static String getDefaultUserAgent(Context paramContext)
  {
    if (!TextUtils.isEmpty(sDefalutUserAgent)) {
      return sDefalutUserAgent;
    }
    Locale localLocale = Locale.getDefault();
    localStringBuffer = new StringBuffer();
    paramContext = Build.VERSION.RELEASE;
    try
    {
      str = new String(paramContext.getBytes("UTF-8"), "ISO8859-1");
      paramContext = str;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        String str;
        continue;
        if (paramContext.length() > 0)
        {
          localStringBuffer.append(paramContext);
        }
        else
        {
          localStringBuffer.append("1.0");
          continue;
          localStringBuffer.append("en");
        }
      }
    }
    if (paramContext == null)
    {
      localStringBuffer.append("1.0");
      localStringBuffer.append("; ");
      paramContext = localLocale.getLanguage();
      if (paramContext == null) {
        break label254;
      }
      localStringBuffer.append(paramContext.toLowerCase());
      paramContext = localLocale.getCountry();
      if (paramContext != null)
      {
        localStringBuffer.append("-");
        localStringBuffer.append(paramContext.toLowerCase());
      }
      if ("REL".equals(Build.VERSION.CODENAME)) {
        paramContext = Build.MODEL;
      }
    }
    try
    {
      str = new String(paramContext.getBytes("UTF-8"), "ISO8859-1");
      paramContext = str;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        continue;
        if (paramContext.length() > 0)
        {
          localStringBuffer.append("; ");
          localStringBuffer.append(paramContext);
          continue;
          paramContext = Build.ID;
          continue;
          if (paramContext.length() > 0)
          {
            localStringBuffer.append(" Build/");
            localStringBuffer.append(paramContext);
          }
        }
      }
    }
    if (paramContext == null)
    {
      localStringBuffer.append("; ");
      if (Build.ID != null) {
        break label293;
      }
      paramContext = "";
      paramContext = paramContext.replaceAll("[一-龥]", "");
      if (paramContext != null) {
        break label300;
      }
      localStringBuffer.append(" Build/");
      localStringBuffer.append("00");
      paramContext = String.format("Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/533.1 (KHTML, like Gecko)Version/4.0 Mobile Safari/533.1", new Object[] { localStringBuffer });
      sDefalutUserAgent = paramContext;
      return paramContext;
    }
  }
  
  protected static File getExistBackupCore(int paramInt)
  {
    String[] arrayOfString = TbsShareManager.getCoreProviderAppList();
    Object localObject1 = null;
    int j = arrayOfString.length;
    int i = 0;
    Object localObject2 = localObject1;
    if (i < j)
    {
      localObject2 = arrayOfString[i];
      if (!((String)localObject2).equals(sAppContext.getApplicationInfo().packageName)) {}
    }
    for (;;)
    {
      i += 1;
      break;
      localObject2 = FileUtil.getTBSSdcardFilePath(sAppContext, (String)localObject2, 4, false);
      if (getOverSea(sAppContext)) {}
      for (localObject1 = "x5.oversea.tbs.org";; localObject1 = "x5.tbs.org")
      {
        localObject1 = new File((String)localObject2, (String)localObject1);
        if ((localObject1 == null) || (!((File)localObject1).exists())) {
          break label159;
        }
        if (ApkUtil.getApkVersion(sAppContext, (File)localObject1) != paramInt) {
          break;
        }
        TbsLog.i("TbsDownload", "local tbs version fond,path = " + ((File)localObject1).getAbsolutePath());
        localObject2 = localObject1;
        return localObject2;
      }
      TbsLog.i("TbsDownload", "version is not match");
      continue;
      label159:
      TbsLog.i("TbsDownload", "can not find local backup core file");
    }
  }
  
  protected static File getExistBackupCoreForDecouple(int paramInt)
  {
    String[] arrayOfString = TbsShareManager.getCoreProviderAppList();
    Object localObject = null;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      String str1;
      String str2;
      if (i < j)
      {
        str1 = arrayOfString[i];
        str2 = FileUtil.getTBSSdcardFilePath(sAppContext, str1, 4, false);
        if (!getOverSea(sAppContext)) {
          break label111;
        }
      }
      label111:
      for (localObject = "x5.oversea.tbs.org";; localObject = "x5.tbs.org")
      {
        localObject = new File(str2, (String)localObject);
        if ((localObject == null) || (!((File)localObject).exists()) || (ApkUtil.getApkVersion(sAppContext, (File)localObject) != paramInt)) {
          break;
        }
        TbsLog.i("TbsDownload", "local tbs version fond,path = " + ((File)localObject).getAbsolutePath());
        return localObject;
      }
      localObject = new File(FileUtil.getTBSSdcardFilePath(sAppContext, str1, 4, false), "x5.tbs.decouple");
      if ((localObject != null) && (((File)localObject).exists()) && (ApkUtil.getApkVersion(sAppContext, (File)localObject) == paramInt))
      {
        TbsLog.i("TbsDownload", "local tbs version fond,path = " + ((File)localObject).getAbsolutePath());
        return localObject;
      }
      i += 1;
    }
  }
  
  private static JSONArray getHostCoreVersions()
  {
    int k = 0;
    JSONArray localJSONArray;
    Object localObject1;
    if (TbsShareManager.isThirdPartyApp(sAppContext))
    {
      localJSONArray = new JSONArray();
      if (QbSdk.getOnlyDownload())
      {
        localObject1 = new String[1];
        localObject1[0] = sAppContext.getApplicationContext().getPackageName();
      }
    }
    label51:
    label317:
    label319:
    for (;;)
    {
      int m = localObject1.length;
      int i = 0;
      Object localObject2;
      int n;
      Object localObject3;
      if (i < m)
      {
        localObject2 = localObject1[i];
        n = TbsShareManager.getSharedTbsCoreVersion(sAppContext, (String)localObject2);
        if (n > 0)
        {
          localObject3 = TbsShareManager.getPackageContext(sAppContext, (String)localObject2);
          if ((localObject3 == null) || (TbsInstaller.getInstance().vertificateApp((Context)localObject3))) {
            break label201;
          }
          TbsLog.e("TbsDownload", "host check failed,packageName = " + (String)localObject2);
        }
      }
      for (;;)
      {
        i += 1;
        break label51;
        localObject1 = TbsShareManager.getCoreProviderAppList();
        localObject3 = sAppContext.getApplicationContext().getPackageName();
        if (!((String)localObject3).equals(TbsShareManager.readPackageNameFromConfig(sAppContext))) {
          break label319;
        }
        i = localObject1.length;
        localObject2 = new String[i + 1];
        System.arraycopy(localObject1, 0, localObject2, 0, i);
        localObject2[i] = localObject3;
        localObject1 = localObject2;
        break;
        label201:
        int j = 0;
        label203:
        if (j < localJSONArray.length()) {
          if (localJSONArray.optInt(j) != n) {}
        }
        for (j = 1;; j = 0)
        {
          if (j != 0) {
            break label317;
          }
          localJSONArray.put(n);
          break;
          j += 1;
          break label203;
          if (TbsShareManager.getHostCorePathAppDefined() != null)
          {
            m = TbsInstaller.getInstance().getTbsCoreVersionAppDefined(TbsShareManager.getHostCorePathAppDefined());
            i = 0;
            for (;;)
            {
              j = k;
              if (i < localJSONArray.length())
              {
                if (localJSONArray.optInt(i) == m) {
                  j = 1;
                }
              }
              else
              {
                if (j == 0) {
                  localJSONArray.put(m);
                }
                return localJSONArray;
              }
              i += 1;
            }
          }
          return localJSONArray;
          return null;
        }
      }
    }
  }
  
  public static boolean getOverSea(Context paramContext)
  {
    try
    {
      if (!sOverSeaInited)
      {
        sOverSeaInited = true;
        paramContext = TbsDownloadConfig.getInstance(paramContext);
        if (paramContext.mPreferences.contains("is_oversea"))
        {
          sOverSea = paramContext.mPreferences.getBoolean("is_oversea", false);
          TbsLog.i("TbsDownload", "[TbsDownloader.getOverSea]  first called. sOverSea = " + sOverSea);
        }
        TbsLog.i("TbsDownload", "[TbsDownloader.getOverSea]  sOverSea = " + sOverSea);
      }
      boolean bool = sOverSea;
      return bool;
    }
    finally {}
  }
  
  public static long getRetryIntervalInSeconds()
  {
    return mRetryIntervalInSeconds;
  }
  
  public static HandlerThread getsTbsHandlerThread()
  {
    return sTbsHandlerThread;
  }
  
  private static void initTbsDownloaderThreadIfNeeded()
  {
    try
    {
      if (sTbsHandlerThread == null) {
        sTbsHandlerThread = TbsHandlerThread.getInstance();
      }
      try
      {
        sTbsApkDownloader = new TbsApkDownloader(sAppContext);
        sTbsDownloaderHandler = new Handler(sTbsHandlerThread.getLooper())
        {
          public void handleMessage(Message paramAnonymousMessage)
          {
            boolean bool3 = true;
            int i;
            boolean bool1;
            switch (paramAnonymousMessage.what)
            {
            case 105: 
            case 106: 
            case 107: 
            default: 
              return;
            case 100: 
              if (paramAnonymousMessage.arg1 == 1) {}
              for (i = 1;; i = 0)
              {
                bool1 = TbsDownloader.sendRequest(true, false);
                if ((paramAnonymousMessage.obj != null) && ((paramAnonymousMessage.obj instanceof TbsDownloader.TbsDownloaderCallback)))
                {
                  TbsLog.i("TbsDownload", "needDownload-onNeedDownloadFinish needStartDownload=" + bool1);
                  if ((!bool1) || (i != 0)) {
                    ((TbsDownloader.TbsDownloaderCallback)paramAnonymousMessage.obj).onNeedDownloadFinish(bool1, TbsDownloadConfig.getInstance(TbsDownloader.sAppContext).mPreferences.getInt("tbs_download_version", 0));
                  }
                }
                if ((!TbsShareManager.isThirdPartyApp(TbsDownloader.sAppContext)) || (!bool1)) {
                  break;
                }
                TbsDownloader.startDownload(TbsDownloader.sAppContext);
                return;
              }
            case 101: 
            case 108: 
              Object localObject1 = null;
              Object localObject2 = "tbs_download_lock_file" + TbsDownloadConfig.getInstance(TbsDownloader.sAppContext).mPreferences.getInt("tbs_download_version", 0) + ".txt";
              FileOutputStream localFileOutputStream = FileUtil.getLockFos(TbsDownloader.sAppContext, false, (String)localObject2);
              if (localFileOutputStream != null)
              {
                localObject2 = FileUtil.tryFileLock(TbsDownloader.sAppContext, localFileOutputStream);
                localObject1 = localObject2;
                if (localObject2 == null)
                {
                  TbsLog.i("TbsDownload", "file lock locked,wx or qq is downloading");
                  TbsDownloadConfig.getInstance(TbsDownloader.sAppContext).setDownloadInterruptCode(-203);
                  TbsLog.i("TbsDownload", "MSG_START_DOWNLOAD_DECOUPLECORE return #1");
                }
              }
              else if (FileUtil.isSdcardDirWritable(TbsDownloader.sAppContext))
              {
                TbsDownloadConfig.getInstance(TbsDownloader.sAppContext).setDownloadInterruptCode(-204);
                TbsLog.i("TbsDownload", "MSG_START_DOWNLOAD_DECOUPLECORE return #2");
                return;
              }
              boolean bool2;
              if (paramAnonymousMessage.arg1 == 1)
              {
                bool1 = true;
                localObject2 = TbsDownloadConfig.getInstance(TbsDownloader.sAppContext);
                if (108 != paramAnonymousMessage.what) {
                  break label424;
                }
                bool2 = true;
                if (!TbsDownloader.sendRequest(false, bool1, bool2)) {
                  break label506;
                }
                if ((!bool1) || (!TbsInstaller.getInstance().installLocalTbsCore(TbsDownloader.sAppContext, TbsDownloadConfig.getInstance(TbsDownloader.sAppContext).mPreferences.getInt("tbs_download_version", 0)))) {
                  break label430;
                }
                QbSdk.mTbsListenerWrapper.onDownloadFinish(122);
                ((TbsDownloadConfig)localObject2).setDownloadInterruptCode(-213);
              }
              for (;;)
              {
                TbsLog.i("TbsDownload", "------freeFileLock called :");
                FileUtil.freeFileLock(localObject1, localFileOutputStream);
                return;
                bool1 = false;
                break;
                bool2 = false;
                break label343;
                if (((TbsDownloadConfig)localObject2).mPreferences.getBoolean("tbs_needdownload", false))
                {
                  TbsDownloadConfig.getInstance(TbsDownloader.sAppContext).setDownloadInterruptCode(-215);
                  localObject2 = TbsDownloader.sTbsApkDownloader;
                  if (108 == paramAnonymousMessage.what) {}
                  for (bool2 = bool3;; bool2 = false)
                  {
                    ((TbsApkDownloader)localObject2).startDownload(bool1, bool2);
                    break;
                  }
                }
                QbSdk.mTbsListenerWrapper.onDownloadFinish(110);
                continue;
                QbSdk.mTbsListenerWrapper.onDownloadFinish(110);
              }
            case 102: 
              TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] MSG_REPORT_DOWNLOAD_STAT");
              if (TbsShareManager.isThirdPartyApp(TbsDownloader.sAppContext)) {}
              for (i = TbsShareManager.getAvailableTbsCoreVersion(TbsDownloader.sAppContext, false);; i = TbsInstaller.getInstance().getTbsCoreInstalledVer(TbsDownloader.sAppContext))
              {
                TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] localTbsVersion=" + i);
                TbsDownloader.sTbsApkDownloader.removeTbsApkIfNeeded(i);
                TbsLogReport.getInstance(TbsDownloader.sAppContext).dailyReport();
                return;
              }
            case 104: 
              label343:
              label506:
              TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] MSG_UPLOAD_TBSLOG");
              label424:
              label430:
              TbsLogReport.getInstance(TbsDownloader.sAppContext).reportTbsLog();
              return;
            }
            TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] MSG_CONTINUEINSTALL_TBSCORE");
            if (paramAnonymousMessage.arg1 == 0)
            {
              TbsInstaller.getInstance().continueInstallTbsCore((Context)paramAnonymousMessage.obj, true);
              return;
            }
            TbsInstaller.getInstance().continueInstallTbsCore((Context)paramAnonymousMessage.obj, false);
          }
        };
      }
      catch (Exception localException)
      {
        for (;;)
        {
          mStopDownloadByException = true;
          TbsLog.e("TbsDownload", "TbsApkDownloader init has Exception");
        }
      }
      return;
    }
    finally {}
  }
  
  public static boolean isDownloadForeground()
  {
    return (sTbsApkDownloader != null) && (sTbsApkDownloader.isDownloadForeground());
  }
  
  public static boolean isDownloading()
  {
    try
    {
      TbsLog.i("TbsDownload", "[TbsDownloader.isDownloading] is " + mIsDownloading);
      boolean bool = mIsDownloading;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean needDownload(Context paramContext, boolean paramBoolean)
  {
    return needDownload(paramContext, paramBoolean, false, null);
  }
  
  public static boolean needDownload(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, TbsDownloaderCallback paramTbsDownloaderCallback)
  {
    TbsLog.i("TbsDownload", "[TbsDownloader.needDownload] oversea=" + paramBoolean1 + ",isDownloadForeground=" + paramBoolean2);
    TbsLog.initIfNeed(paramContext);
    if (TbsInstaller.isStaticTbsInstalling)
    {
      if (paramTbsDownloaderCallback != null) {
        paramTbsDownloaderCallback.onNeedDownloadFinish(false, 0);
      }
      TbsLog.i("TbsDownload", "[TbsDownloader.needDownload]#1,return " + false);
      return false;
    }
    TbsLog.app_extra("TbsDownload", paramContext);
    sAppContext = paramContext.getApplicationContext();
    TbsDownloadConfig localTbsDownloadConfig = TbsDownloadConfig.getInstance(sAppContext);
    localTbsDownloadConfig.setDownloadInterruptCode(-100);
    if (!shouldDoNeedDownload(sAppContext, paramBoolean1, paramTbsDownloaderCallback))
    {
      TbsLog.i("TbsDownload", "[TbsDownloader.needDownload]#2,return " + false);
      return false;
    }
    initTbsDownloaderThreadIfNeeded();
    if (mStopDownloadByException)
    {
      if (paramTbsDownloaderCallback != null) {
        paramTbsDownloaderCallback.onNeedDownloadFinish(false, 0);
      }
      localTbsDownloadConfig.setDownloadInterruptCode(-105);
      TbsLog.i("TbsDownload", "[TbsDownloader.needDownload]#3,return " + false);
      return false;
    }
    boolean bool = needSendQueryRequest(sAppContext, paramBoolean2, false);
    TbsLog.i("TbsDownload", "[TbsDownloader.needDownload],needSendRequest=" + bool);
    if (bool)
    {
      queryRequest(paramBoolean2, paramTbsDownloaderCallback);
      localTbsDownloadConfig.setDownloadInterruptCode(-114);
    }
    sTbsDownloaderHandler.removeMessages(102);
    Message.obtain(sTbsDownloaderHandler, 102).sendToTarget();
    if ((QbSdk.sAllowThirdPartyAppDownload) || (!TbsShareManager.isThirdPartyApp(paramContext)))
    {
      paramBoolean2 = localTbsDownloadConfig.mPreferences.contains("tbs_needdownload");
      TbsLog.i("TbsDownload", "[TbsDownloader.needDownload] hasNeedDownloadKey=" + paramBoolean2);
      if ((!paramBoolean2) && (!TbsShareManager.isThirdPartyApp(paramContext))) {
        paramBoolean1 = true;
      }
    }
    for (;;)
    {
      TbsLog.i("TbsDownload", "[TbsDownloader.needDownload]#4,needDownload=" + paramBoolean1 + ",hasNeedDownloadKey=" + paramBoolean2);
      if (paramBoolean1) {
        if (!needStartDownload())
        {
          TbsLog.i("TbsDownload", "[TbsDownloader.needDownload]#5,set needDownload = false");
          paramBoolean1 = false;
        }
      }
      for (;;)
      {
        if ((!bool) && (paramTbsDownloaderCallback != null)) {
          paramTbsDownloaderCallback.onNeedDownloadFinish(false, 0);
        }
        TbsLog.i("TbsDownload", "[TbsDownloader.needDownload] needDownload=" + paramBoolean1);
        return paramBoolean1;
        paramBoolean1 = localTbsDownloadConfig.mPreferences.getBoolean("tbs_needdownload", false);
        break;
        localTbsDownloadConfig.setDownloadInterruptCode(-118);
        TbsLog.i("TbsDownload", "[TbsDownloader.needDownload]#6");
        continue;
        int i = TbsInstaller.getInstance().getTbsCoreInstalledVer(sAppContext);
        TbsLog.i("TbsDownload", "[TbsDownloader.needDownload]#7,tbsLocalVersion=" + i + ",needSendRequest=" + bool);
        if ((bool) || (i <= 0))
        {
          sTbsDownloaderHandler.removeMessages(103);
          if ((i <= 0) && (!bool)) {
            Message.obtain(sTbsDownloaderHandler, 103, 0, 0, sAppContext).sendToTarget();
          }
          for (;;)
          {
            localTbsDownloadConfig.setDownloadInterruptCode(-121);
            break;
            Message.obtain(sTbsDownloaderHandler, 103, 1, 0, sAppContext).sendToTarget();
          }
        }
        localTbsDownloadConfig.setDownloadInterruptCode(-119);
      }
      paramBoolean2 = false;
      paramBoolean1 = false;
    }
  }
  
  public static boolean needDownloadDecoupleCore()
  {
    if (TbsShareManager.isThirdPartyApp(sAppContext)) {}
    int i;
    do
    {
      long l;
      do
      {
        do
        {
          return false;
        } while (TbsDownloadConfig.getInstance(sAppContext).mPreferences.getInt("tbs_downloaddecouplecore", 0) == 1);
        l = TbsDownloadConfig.getInstance(sAppContext).mPreferences.getLong("last_download_decouple_core", 0L);
      } while (System.currentTimeMillis() - l < 1000L * TbsDownloadConfig.getInstance(sAppContext).getRetryInterval());
      i = TbsDownloadConfig.getInstance(sAppContext).mPreferences.getInt("tbs_decouplecoreversion", 0);
    } while ((i <= 0) || (i == TbsInstaller.getInstance().getTbsCoreShareDecoupleCoreVersion(sAppContext)) || (TbsDownloadConfig.getInstance(sAppContext).mPreferences.getInt("tbs_download_version", 0) == i));
    return true;
  }
  
  private static boolean needSendQueryRequest(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramContext = TbsDownloadConfig.getInstance(paramContext);
    Object localObject;
    int i;
    String str1;
    String str2;
    int j;
    String str3;
    long l2;
    long l3;
    long l1;
    long l4;
    long l5;
    if (!paramBoolean1)
    {
      localObject = paramContext.mPreferences.getString("app_versionname", null);
      i = paramContext.mPreferences.getInt("app_versioncode", 0);
      str1 = paramContext.mPreferences.getString("app_metadata", null);
      str2 = AppUtil.getAppVersionName(sAppContext);
      j = AppUtil.getAppVersionCode(sAppContext);
      str3 = AppUtil.getAppMetadata(sAppContext, "com.tencent.mm.BuildInfo.CLIENT_VERSION");
      TbsLog.i("TbsDownload", "[TbsDownloader.needSendQueryRequest] appVersionName=" + str2 + " oldAppVersionName=" + (String)localObject + " appVersionCode=" + j + " oldAppVersionCode=" + i + " appMetadata=" + str3 + " oldAppVersionMetadata=" + str1);
      l2 = System.currentTimeMillis();
      l3 = paramContext.mPreferences.getLong("last_check", 0L);
      TbsLog.i("TbsDownload", "[TbsDownloader.needSendQueryRequest] timeLastCheck=" + l3 + " timeNow=" + l2);
      l1 = l3;
      if (paramBoolean2)
      {
        paramBoolean1 = paramContext.mPreferences.contains("last_check");
        TbsLog.i("TbsDownload", "[TbsDownloader.needSendQueryRequest] hasLaskCheckKey=" + paramBoolean1);
        l1 = l3;
        if (paramBoolean1)
        {
          l1 = l3;
          if (l3 == 0L) {
            l1 = l2;
          }
        }
      }
      l3 = paramContext.mPreferences.getLong("last_request_success", 0L);
      l4 = paramContext.mPreferences.getLong("count_request_fail_in_24hours", 0L);
      l5 = paramContext.getRetryInterval();
      TbsLog.i("TbsDownload", "retryInterval = " + l5 + " s");
      if (l2 - l1 > 1000L * l5)
      {
        paramBoolean1 = true;
        paramContext = null;
      }
    }
    for (;;)
    {
      if ((!paramBoolean1) && (TbsShareManager.isThirdPartyApp(sAppContext)))
      {
        localObject = TbsLogReport.getInstance(sAppContext).tbsLogInfo();
        ((TbsLogReport.TbsLogInfo)localObject).setErrorCode(-119);
        ((TbsLogReport.TbsLogInfo)localObject).setFailDetail(paramContext);
        TbsLogReport.getInstance(sAppContext).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, (TbsLogReport.TbsLogInfo)localObject);
      }
      return paramBoolean1;
      if ((TbsShareManager.isThirdPartyApp(sAppContext)) && (l3 > 0L) && (l2 - l3 > l5 * 1000L) && (l4 < 11L))
      {
        paramBoolean1 = true;
        paramContext = null;
      }
      else if ((TbsShareManager.isThirdPartyApp(sAppContext)) && (TbsShareManager.findCoreForThirdPartyApp(sAppContext) == 0) && (!sendRequestWithSameHostCoreVersion()))
      {
        TbsInstaller.getInstance().changeTbsConfForSendRequest(sAppContext);
        paramBoolean1 = true;
        paramContext = null;
      }
      else
      {
        if ((str2 != null) && (j != 0) && (str3 != null))
        {
          if ((!str2.equals(localObject)) || (j != i) || (!str3.equals(str1)))
          {
            paramBoolean1 = true;
            paramContext = null;
          }
        }
        else if (TbsShareManager.isThirdPartyApp(sAppContext))
        {
          paramContext = "timeNow - timeLastCheck is " + (l2 - l1) + " TbsShareManager.findCoreForThirdPartyApp(sAppContext) is " + TbsShareManager.findCoreForThirdPartyApp(sAppContext) + " sendRequestWithSameHostCoreVersion() is " + sendRequestWithSameHostCoreVersion() + " appVersionName is " + str2 + " appVersionCode is " + j + " appMetadata is " + str3 + " oldAppVersionName is " + (String)localObject + " oldAppVersionCode is " + i + " oldAppVersionMetadata is " + str1;
          paramBoolean1 = false;
          continue;
          paramBoolean1 = true;
          paramContext = null;
          continue;
        }
        paramContext = null;
        paramBoolean1 = false;
      }
    }
  }
  
  public static boolean needSendRequest(Context paramContext, boolean paramBoolean)
  {
    boolean bool = true;
    sAppContext = paramContext.getApplicationContext();
    TbsLog.initIfNeed(paramContext);
    if (!shouldDoNeedDownload(sAppContext, paramBoolean, null)) {}
    int i;
    do
    {
      return false;
      i = TbsInstaller.getInstance().getTbsCoreInstalledVer(paramContext);
      TbsLog.i("TbsDownload", "[TbsDownloader.needSendRequest] localTbsVersion=" + i);
    } while (i > 0);
    if (needSendQueryRequest(sAppContext, false, true)) {
      return true;
    }
    paramContext = TbsDownloadConfig.getInstance(sAppContext);
    paramBoolean = paramContext.mPreferences.contains("tbs_needdownload");
    TbsLog.i("TbsDownload", "[TbsDownloader.needSendRequest] hasNeedDownloadKey=" + paramBoolean);
    if (!paramBoolean)
    {
      paramBoolean = true;
      TbsLog.i("TbsDownload", "[TbsDownloader.needSendRequest] needDownload=" + paramBoolean);
      if ((!paramBoolean) || (!needStartDownload())) {
        break label208;
      }
    }
    label208:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      TbsLog.i("TbsDownload", "[TbsDownloader.needSendRequest] ret=" + paramBoolean);
      return paramBoolean;
      paramBoolean = paramContext.mPreferences.getBoolean("tbs_needdownload", false);
      break;
    }
  }
  
  private static boolean needStartDownload()
  {
    TbsDownloadConfig localTbsDownloadConfig = TbsDownloadConfig.getInstance(sAppContext);
    if (localTbsDownloadConfig.mPreferences.getInt("tbs_download_success_retrytimes", 0) >= localTbsDownloadConfig.getDownloadSuccessMaxRetrytimes())
    {
      TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] out of success retrytimes", true);
      localTbsDownloadConfig.setDownloadInterruptCode(-115);
      return false;
    }
    if (localTbsDownloadConfig.mPreferences.getInt("tbs_download_failed_retrytimes", 0) >= localTbsDownloadConfig.getDownloadFailedMaxRetrytimes())
    {
      TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] out of failed retrytimes", true);
      localTbsDownloadConfig.setDownloadInterruptCode(-116);
      return false;
    }
    if (!FileUtil.hasEnoughFreeSpace(sAppContext))
    {
      TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] local rom freespace limit", true);
      localTbsDownloadConfig.setDownloadInterruptCode(-117);
      return false;
    }
    if (System.currentTimeMillis() - localTbsDownloadConfig.mPreferences.getLong("tbs_downloadstarttime", 0L) <= 86400000L)
    {
      long l = localTbsDownloadConfig.mPreferences.getLong("tbs_downloadflow", 0L);
      TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] downloadFlow=" + l);
      if (l >= localTbsDownloadConfig.getDownloadMaxflow())
      {
        TbsLog.i("TbsDownload", "[TbsDownloader.needStartDownload] failed because you exceeded max flow!", true);
        localTbsDownloadConfig.setDownloadInterruptCode(-120);
        return false;
      }
    }
    return true;
  }
  
  private static String notNullString(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  private static JSONObject postJsonData(boolean paramBoolean1, boolean paramBoolean2)
  {
    return postJsonData(paramBoolean1, paramBoolean2, false);
  }
  
  private static JSONObject postJsonData(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int k = 0;
    TbsLog.i("TbsDownload", "[TbsDownloader.postJsonData]isQuery: " + paramBoolean1 + " forDecoupleCore is " + paramBoolean3);
    TbsDownloadConfig localTbsDownloadConfig = TbsDownloadConfig.getInstance(sAppContext);
    String str1 = getDefaultUserAgent(sAppContext);
    String str2 = AppUtil.getImsi(sAppContext);
    String str3 = AppUtil.getImei(sAppContext);
    String str4 = AppUtil.getAndroidID(sAppContext);
    Object localObject1 = TimeZone.getDefault().getID();
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      try
      {
        localObject3 = (TelephonyManager)sAppContext.getSystemService("phone");
        if (localObject3 == null) {
          break label719;
        }
        localObject3 = ((TelephonyManager)localObject3).getSimCountryIso();
        localObject1 = localObject3;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Object localObject3;
          label133:
          localException2.printStackTrace();
          continue;
          i = TbsDownloadConfig.getInstance(sAppContext).mPreferences.getInt("tbs_download_version", 0);
        }
        j = TbsInstaller.getInstance().getTbsCoreInstalledVer(sAppContext);
        i = j;
        if (j != 0) {
          break label780;
        }
        i = j;
        if (!TbsInstaller.getInstance().tbsFileConfExists(sAppContext)) {
          break label780;
        }
        i = -1;
        TbsLog.i("TbsDownload", "[TbsDownloader.postJsonData] tbsLocalVersion=" + i + " isDownloadForeground=" + paramBoolean2);
        if (!paramBoolean2) {
          break label911;
        }
      }
      if (localObject1 != null) {
        localObject3 = new JSONObject();
      }
    }
    try
    {
      ((JSONObject)localObject3).put("TIMEZONEID", localObject2);
      ((JSONObject)localObject3).put("COUNTRYISO", localObject1);
      ((JSONObject)localObject3).put("PROTOCOLVERSION", 1);
      if (!TbsShareManager.isThirdPartyApp(sAppContext)) {
        break label744;
      }
      if (!QbSdk.sAllowThirdPartyAppDownload) {
        break label722;
      }
      i = TbsShareManager.getAvailableTbsCoreVersion(sAppContext, false);
      label197:
      if (!paramBoolean1) {
        break label957;
      }
      ((JSONObject)localObject3).put("FUNCTION", 2);
      label211:
      if (!TbsShareManager.isThirdPartyApp(sAppContext)) {
        break label848;
      }
      localObject1 = getHostCoreVersions();
      ((JSONObject)localObject3).put("TBSVLARR", localObject1);
      localTbsDownloadConfig.mSyncMap.put("last_thirdapp_sendrequest_coreversion", ((JSONArray)localObject1).toString());
      localTbsDownloadConfig.commit();
      if (QbSdk.sAllowThirdPartyAppDownload) {
        ((JSONObject)localObject3).put("THIRDREQ", 1);
      }
      label276:
      ((JSONObject)localObject3).put("APPN", sAppContext.getPackageName());
      ((JSONObject)localObject3).put("APPVN", notNullString(localTbsDownloadConfig.mPreferences.getString("app_versionname", null)));
      ((JSONObject)localObject3).put("APPVC", localTbsDownloadConfig.mPreferences.getInt("app_versioncode", 0));
      ((JSONObject)localObject3).put("APPMETA", notNullString(localTbsDownloadConfig.mPreferences.getString("app_metadata", null)));
      ((JSONObject)localObject3).put("TBSSDKV", 43609);
      ((JSONObject)localObject3).put("TBSV", i);
      if (!paramBoolean3) {
        break label978;
      }
      j = 1;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        label560:
        label633:
        continue;
        label719:
        label722:
        label744:
        int j = 1;
        label780:
        label848:
        continue;
        label906:
        label911:
        label930:
        label949:
        label952:
        label957:
        j = 0;
        continue;
        j = 0;
        continue;
        int i = 1;
      }
    }
    ((JSONObject)localObject3).put("DOWNLOADDECOUPLECORE", j);
    localObject1 = localTbsDownloadConfig.mSyncMap;
    if (paramBoolean3)
    {
      j = 1;
      ((Map)localObject1).put("tbs_downloaddecouplecore", Integer.valueOf(j));
      localTbsDownloadConfig.commit();
      if (i != 0) {
        ((JSONObject)localObject3).put("TBSBACKUPV", sTbsApkDownloader.backupApkVersion());
      }
      ((JSONObject)localObject3).put("CPU", sCpuabi);
      ((JSONObject)localObject3).put("UA", str1);
      ((JSONObject)localObject3).put("IMSI", notNullString(str2));
      ((JSONObject)localObject3).put("IMEI", notNullString(str3));
      ((JSONObject)localObject3).put("ANDROID_ID", notNullString(str4));
      if (!TbsShareManager.isThirdPartyApp(sAppContext))
      {
        if (i != 0)
        {
          if (!QbSdk.isX5Disabled(sAppContext, i)) {
            break label990;
          }
          i = 0;
          ((JSONObject)localObject3).put("STATUS", i);
          ((JSONObject)localObject3).put("TBSDV", TbsInstaller.getInstance().getTbsCoreShareDecoupleCoreVersion(sAppContext));
        }
      }
      else
      {
        paramBoolean3 = TbsDownloadConfig.getInstance(sAppContext).mPreferences.getBoolean("request_full_package", false);
        localObject1 = QbSdk.onMiscCallExtension(sAppContext, "can_unlzma", null);
        if ((localObject1 == null) || (!(localObject1 instanceof Boolean))) {
          break label906;
        }
        paramBoolean1 = ((Boolean)localObject1).booleanValue();
        break label930;
        if (i != 0) {
          ((JSONObject)localObject3).put("REQUEST_LZMA", 1);
        }
        if (getOverSea(sAppContext)) {
          ((JSONObject)localObject3).put("OVERSEA", 1);
        }
        if (paramBoolean2) {
          ((JSONObject)localObject3).put("DOWNLOAD_FOREGROUND", 1);
        }
        TbsLog.i("TbsDownload", "[TbsDownloader.postJsonData] jsonData=" + ((JSONObject)localObject3).toString());
        return localObject3;
        if (!TbsInstaller.getInstance().tbsFileConfExists(sAppContext)) {
          break label952;
        }
        break label949;
      }
      for (;;)
      {
        localException2.put("FUNCTION", j);
        break label211;
        localObject1 = getAvailableLocalBackupVersion();
        if ((Apn.getApnType(sAppContext) == 3) || (((JSONArray)localObject1).length() == 0) || (i != 0) || (!paramBoolean1)) {
          break label276;
        }
        localException2.put("TBSBACKUPARR", localObject1);
        break label276;
        localException2.put("STATUS", 0);
        break label560;
        paramBoolean1 = false;
        break label930;
        break label197;
        localObject1 = "";
        break label133;
        localObject2 = "";
        break;
        i = k;
        if (!paramBoolean1) {
          break label633;
        }
        i = k;
        if (paramBoolean3) {
          break label633;
        }
        i = 1;
        break label633;
        for (;;)
        {
          break;
          i = 0;
        }
        if (i != 0) {
          break label972;
        }
        j = 0;
      }
    }
  }
  
  private static void queryRequest(boolean paramBoolean, TbsDownloaderCallback paramTbsDownloaderCallback)
  {
    int i = 0;
    TbsLog.i("TbsDownload", "[TbsDownloader.queryConfig]");
    sTbsDownloaderHandler.removeMessages(100);
    Message localMessage = Message.obtain(sTbsDownloaderHandler, 100);
    if (paramTbsDownloaderCallback != null) {
      localMessage.obj = paramTbsDownloaderCallback;
    }
    localMessage.arg1 = 0;
    if (paramBoolean) {
      i = 1;
    }
    localMessage.arg1 = i;
    localMessage.sendToTarget();
  }
  
  /* Error */
  @TargetApi(11)
  private static boolean readResponse(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    throws Exception
  {
    // Byte code:
    //   0: ldc 30
    //   2: new 349	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 350	java/lang/StringBuilder:<init>	()V
    //   9: ldc_w 929
    //   12: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: aload_0
    //   16: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: invokevirtual 361	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: invokestatic 366	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   25: getstatic 124	com/tencent/smtt/sdk/TbsDownloader:sAppContext	Landroid/content/Context;
    //   28: invokestatic 143	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   31: astore 27
    //   33: aload_0
    //   34: invokestatic 253	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   37: ifeq +35 -> 72
    //   40: iload_2
    //   41: ifeq +20 -> 61
    //   44: aload 27
    //   46: bipush 148
    //   48: invokevirtual 506	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   51: ldc 30
    //   53: ldc_w 931
    //   56: invokestatic 366	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   59: iconst_0
    //   60: ireturn
    //   61: aload 27
    //   63: sipush -208
    //   66: invokevirtual 506	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   69: goto -18 -> 51
    //   72: new 789	org/json/JSONObject
    //   75: dup
    //   76: aload_0
    //   77: invokespecial 933	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   80: astore 28
    //   82: aload 28
    //   84: ldc_w 935
    //   87: invokevirtual 937	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   90: istore 4
    //   92: iload 4
    //   94: ifeq +53 -> 147
    //   97: iload_2
    //   98: ifeq +38 -> 136
    //   101: aload 27
    //   103: bipush 147
    //   105: invokevirtual 506	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   108: ldc 30
    //   110: new 349	java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial 350	java/lang/StringBuilder:<init>	()V
    //   117: ldc_w 939
    //   120: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: iload 4
    //   125: invokevirtual 568	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   128: invokevirtual 361	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokestatic 366	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   134: iconst_0
    //   135: ireturn
    //   136: aload 27
    //   138: sipush -209
    //   141: invokevirtual 506	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   144: goto -36 -> 108
    //   147: aload 28
    //   149: ldc_w 941
    //   152: invokevirtual 937	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   155: istore 11
    //   157: aload 28
    //   159: ldc_w 943
    //   162: invokevirtual 945	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   165: astore 29
    //   167: aload 28
    //   169: ldc_w 947
    //   172: ldc_w 317
    //   175: invokevirtual 950	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   178: astore 30
    //   180: aload 28
    //   182: ldc_w 952
    //   185: invokevirtual 937	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   188: istore 10
    //   190: aload 28
    //   192: ldc_w 954
    //   195: invokevirtual 937	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   198: istore 12
    //   200: aload 28
    //   202: ldc_w 956
    //   205: invokevirtual 937	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   208: istore 13
    //   210: aload 28
    //   212: ldc_w 958
    //   215: invokevirtual 937	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   218: istore 14
    //   220: aload 28
    //   222: ldc_w 960
    //   225: invokevirtual 937	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   228: istore 15
    //   230: aload 28
    //   232: ldc_w 962
    //   235: invokevirtual 965	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   238: lstore 20
    //   240: aload 28
    //   242: ldc_w 967
    //   245: invokevirtual 965	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   248: lstore 22
    //   250: aload 28
    //   252: ldc_w 969
    //   255: lconst_0
    //   256: invokevirtual 972	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   259: lstore 18
    //   261: aload 28
    //   263: ldc_w 974
    //   266: iconst_m1
    //   267: invokevirtual 976	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   270: istore 16
    //   272: iconst_0
    //   273: istore 4
    //   275: aload 28
    //   277: ldc_w 978
    //   280: invokevirtual 937	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   283: istore 5
    //   285: iload 5
    //   287: istore 4
    //   289: aload 27
    //   291: getfield 816	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   294: ldc_w 980
    //   297: iload 4
    //   299: invokestatic 851	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   302: invokeinterface 824 3 0
    //   307: pop
    //   308: iload_2
    //   309: ifeq +59 -> 368
    //   312: getstatic 983	com/tencent/smtt/sdk/QbSdk:mIsBuglyEnabled	Z
    //   315: ifeq +53 -> 368
    //   318: getstatic 124	com/tencent/smtt/sdk/TbsDownloader:sAppContext	Landroid/content/Context;
    //   321: invokestatic 375	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   324: ifeq +44 -> 368
    //   327: aload 28
    //   329: ldc_w 985
    //   332: iconst_0
    //   333: invokevirtual 976	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   336: istore 4
    //   338: invokestatic 990	com/tencent/smtt/sdk/TbsExtensionFunctionManager:getInstance	()Lcom/tencent/smtt/sdk/TbsExtensionFunctionManager;
    //   341: astore_0
    //   342: getstatic 124	com/tencent/smtt/sdk/TbsDownloader:sAppContext	Landroid/content/Context;
    //   345: astore 24
    //   347: iload 4
    //   349: iconst_1
    //   350: if_icmpne +426 -> 776
    //   353: iconst_1
    //   354: istore 17
    //   356: aload_0
    //   357: aload 24
    //   359: ldc_w 992
    //   362: iload 17
    //   364: invokevirtual 996	com/tencent/smtt/sdk/TbsExtensionFunctionManager:setFunctionEnable	(Landroid/content/Context;Ljava/lang/String;Z)Z
    //   367: pop
    //   368: iload_2
    //   369: ifeq +61 -> 430
    //   372: aload 28
    //   374: ldc_w 998
    //   377: iconst_0
    //   378: invokevirtual 976	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   381: iconst_1
    //   382: iand
    //   383: ifeq +432 -> 815
    //   386: iconst_1
    //   387: istore 17
    //   389: invokestatic 990	com/tencent/smtt/sdk/TbsExtensionFunctionManager:getInstance	()Lcom/tencent/smtt/sdk/TbsExtensionFunctionManager;
    //   392: getstatic 124	com/tencent/smtt/sdk/TbsDownloader:sAppContext	Landroid/content/Context;
    //   395: ldc_w 1000
    //   398: iload 17
    //   400: invokevirtual 996	com/tencent/smtt/sdk/TbsExtensionFunctionManager:setFunctionEnable	(Landroid/content/Context;Ljava/lang/String;Z)Z
    //   403: pop
    //   404: ldc 30
    //   406: new 349	java/lang/StringBuilder
    //   409: dup
    //   410: invokespecial 350	java/lang/StringBuilder:<init>	()V
    //   413: ldc_w 1002
    //   416: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: iload 17
    //   421: invokevirtual 440	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   424: invokevirtual 361	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   427: invokestatic 1005	com/tencent/smtt/utils/TbsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   430: aconst_null
    //   431: astore 24
    //   433: iconst_0
    //   434: istore 5
    //   436: iconst_0
    //   437: istore 7
    //   439: ldc_w 317
    //   442: astore 26
    //   444: aload 28
    //   446: ldc_w 1007
    //   449: invokevirtual 945	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   452: astore_0
    //   453: aload 28
    //   455: ldc_w 1009
    //   458: invokevirtual 937	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   461: istore 4
    //   463: aload 28
    //   465: ldc_w 1011
    //   468: invokevirtual 937	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   471: istore 6
    //   473: aload 28
    //   475: ldc_w 1013
    //   478: invokevirtual 1016	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   481: ifeq +2433 -> 2914
    //   484: aload 28
    //   486: ldc_w 1013
    //   489: invokevirtual 937	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   492: istore 5
    //   494: iload 5
    //   496: ifeq +358 -> 854
    //   499: iconst_1
    //   500: istore 5
    //   502: aload 26
    //   504: astore 24
    //   506: aload 26
    //   508: astore 25
    //   510: aload 28
    //   512: ldc_w 1018
    //   515: invokevirtual 1016	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   518: ifeq +17 -> 535
    //   521: aload 26
    //   523: astore 25
    //   525: aload 28
    //   527: ldc_w 1018
    //   530: invokevirtual 945	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   533: astore 24
    //   535: aload 24
    //   537: astore 25
    //   539: aload 28
    //   541: ldc_w 1020
    //   544: invokevirtual 1016	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   547: ifeq +2361 -> 2908
    //   550: aload 24
    //   552: astore 25
    //   554: aload 28
    //   556: ldc_w 1020
    //   559: invokevirtual 937	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   562: istore 7
    //   564: iload 7
    //   566: ifeq +294 -> 860
    //   569: iconst_1
    //   570: istore 17
    //   572: iload 6
    //   574: istore 7
    //   576: iload 5
    //   578: istore 8
    //   580: iload 4
    //   582: istore 6
    //   584: iload 7
    //   586: istore 5
    //   588: iload 8
    //   590: istore 4
    //   592: aload 28
    //   594: ldc_w 1022
    //   597: invokevirtual 937	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   600: istore 7
    //   602: iconst_0
    //   603: istore 8
    //   605: aload 28
    //   607: ldc_w 1024
    //   610: invokevirtual 937	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   613: istore 9
    //   615: iload 9
    //   617: istore 8
    //   619: getstatic 101	com/tencent/smtt/sdk/TbsDownloader:mProtocolLock	Ljava/lang/Object;
    //   622: astore 25
    //   624: aload 25
    //   626: monitorenter
    //   627: iload 4
    //   629: ifeq +20 -> 649
    //   632: aload 27
    //   634: getfield 816	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   637: ldc_w 1026
    //   640: ldc_w 317
    //   643: invokeinterface 824 3 0
    //   648: pop
    //   649: aload 24
    //   651: invokestatic 253	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   654: ifne +58 -> 712
    //   657: aload 24
    //   659: invokevirtual 334	java/lang/String:length	()I
    //   662: bipush 96
    //   664: if_icmpne +48 -> 712
    //   667: new 349	java/lang/StringBuilder
    //   670: dup
    //   671: invokespecial 350	java/lang/StringBuilder:<init>	()V
    //   674: aload 24
    //   676: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   679: ldc_w 1028
    //   682: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   685: invokestatic 1033	com/tencent/smtt/utils/Post3DESEncryption:getDESString	()Ljava/lang/String;
    //   688: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   691: invokevirtual 361	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   694: astore 24
    //   696: aload 27
    //   698: getfield 816	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   701: ldc_w 1026
    //   704: aload 24
    //   706: invokeinterface 824 3 0
    //   711: pop
    //   712: aload 25
    //   714: monitorexit
    //   715: iload 6
    //   717: iconst_1
    //   718: if_icmpne +218 -> 936
    //   721: iload_2
    //   722: ifeq +198 -> 920
    //   725: aload 27
    //   727: bipush 146
    //   729: invokevirtual 506	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   732: getstatic 124	com/tencent/smtt/sdk/TbsDownloader:sAppContext	Landroid/content/Context;
    //   735: astore_0
    //   736: iload 8
    //   738: iconst_1
    //   739: if_icmpne +192 -> 931
    //   742: iconst_1
    //   743: istore_3
    //   744: aload_0
    //   745: iload_3
    //   746: invokestatic 1037	com/tencent/smtt/sdk/QbSdk:reset	(Landroid/content/Context;Z)V
    //   749: ldc 30
    //   751: new 349	java/lang/StringBuilder
    //   754: dup
    //   755: invokespecial 350	java/lang/StringBuilder:<init>	()V
    //   758: ldc_w 1039
    //   761: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   764: iload_2
    //   765: invokevirtual 440	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   768: invokevirtual 361	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   771: invokestatic 366	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   774: iconst_0
    //   775: ireturn
    //   776: iconst_0
    //   777: istore 17
    //   779: goto -423 -> 356
    //   782: astore_0
    //   783: ldc_w 1041
    //   786: new 349	java/lang/StringBuilder
    //   789: dup
    //   790: invokespecial 350	java/lang/StringBuilder:<init>	()V
    //   793: ldc_w 1043
    //   796: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   799: aload_0
    //   800: invokevirtual 1044	java/lang/Throwable:toString	()Ljava/lang/String;
    //   803: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   806: invokevirtual 361	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   809: invokestatic 366	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   812: goto -444 -> 368
    //   815: iconst_0
    //   816: istore 17
    //   818: goto -429 -> 389
    //   821: astore_0
    //   822: ldc_w 1041
    //   825: new 349	java/lang/StringBuilder
    //   828: dup
    //   829: invokespecial 350	java/lang/StringBuilder:<init>	()V
    //   832: ldc_w 1043
    //   835: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   838: aload_0
    //   839: invokevirtual 1044	java/lang/Throwable:toString	()Ljava/lang/String;
    //   842: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   845: invokevirtual 361	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   848: invokestatic 366	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   851: goto -421 -> 430
    //   854: iconst_0
    //   855: istore 5
    //   857: goto -355 -> 502
    //   860: iconst_0
    //   861: istore 17
    //   863: goto -291 -> 572
    //   866: astore_0
    //   867: iconst_0
    //   868: istore 4
    //   870: ldc_w 317
    //   873: astore_0
    //   874: iload 7
    //   876: istore 6
    //   878: iload 5
    //   880: istore 7
    //   882: aload 24
    //   884: astore 25
    //   886: iload 6
    //   888: istore 5
    //   890: iconst_1
    //   891: istore 17
    //   893: aload_0
    //   894: astore 24
    //   896: iload 7
    //   898: istore 6
    //   900: aload 25
    //   902: astore_0
    //   903: goto -311 -> 592
    //   906: astore 25
    //   908: iconst_0
    //   909: istore 7
    //   911: goto -309 -> 602
    //   914: astore_0
    //   915: aload 25
    //   917: monitorexit
    //   918: aload_0
    //   919: athrow
    //   920: aload 27
    //   922: sipush -210
    //   925: invokevirtual 506	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   928: goto -196 -> 732
    //   931: iconst_0
    //   932: istore_3
    //   933: goto -189 -> 744
    //   936: iload 17
    //   938: ifne +10 -> 948
    //   941: aload 27
    //   943: iload 17
    //   945: invokevirtual 1048	com/tencent/smtt/sdk/TbsDownloadConfig:setTbsCoreLoadRenameFileLockEnable	(Z)V
    //   948: iload 7
    //   950: iconst_1
    //   951: if_icmpne +9 -> 960
    //   954: getstatic 124	com/tencent/smtt/sdk/TbsDownloader:sAppContext	Landroid/content/Context;
    //   957: invokestatic 1051	com/tencent/smtt/sdk/QbSdk:resetDecoupleCore	(Landroid/content/Context;)V
    //   960: iload 5
    //   962: iconst_1
    //   963: if_icmpne +22 -> 985
    //   966: getstatic 467	com/tencent/smtt/sdk/TbsDownloader:sTbsDownloaderHandler	Landroid/os/Handler;
    //   969: bipush 104
    //   971: invokevirtual 531	android/os/Handler:removeMessages	(I)V
    //   974: getstatic 467	com/tencent/smtt/sdk/TbsDownloader:sTbsDownloaderHandler	Landroid/os/Handler;
    //   977: bipush 104
    //   979: invokestatic 537	android/os/Message:obtain	(Landroid/os/Handler;I)Landroid/os/Message;
    //   982: invokevirtual 540	android/os/Message:sendToTarget	()V
    //   985: iload 16
    //   987: iconst_1
    //   988: if_icmpne +1909 -> 2897
    //   991: lload 18
    //   993: ldc2_w 1052
    //   996: lcmp
    //   997: ifle +1908 -> 2905
    //   1000: ldc2_w 1052
    //   1003: lstore 18
    //   1005: lload 18
    //   1007: lconst_0
    //   1008: lcmp
    //   1009: ifle +1888 -> 2897
    //   1012: invokestatic 1055	com/tencent/smtt/sdk/TbsDownloader:getRetryIntervalInSeconds	()J
    //   1015: lconst_0
    //   1016: lcmp
    //   1017: iflt +8 -> 1025
    //   1020: invokestatic 1055	com/tencent/smtt/sdk/TbsDownloader:getRetryIntervalInSeconds	()J
    //   1023: lstore 18
    //   1025: aload 27
    //   1027: getfield 816	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1030: ldc_w 1057
    //   1033: lload 18
    //   1035: invokestatic 1062	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1038: invokeinterface 824 3 0
    //   1043: pop
    //   1044: iconst_0
    //   1045: istore 4
    //   1047: iconst_0
    //   1048: istore 5
    //   1050: iload_2
    //   1051: ifeq +261 -> 1312
    //   1054: aload 28
    //   1056: ldc_w 1064
    //   1059: invokevirtual 937	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1062: istore 6
    //   1064: iload 6
    //   1066: istore 4
    //   1068: getstatic 124	com/tencent/smtt/sdk/TbsDownloader:sAppContext	Landroid/content/Context;
    //   1071: invokestatic 143	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1074: getfield 425	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   1077: ldc_w 576
    //   1080: iconst_0
    //   1081: invokeinterface 580 3 0
    //   1086: istore 6
    //   1088: iload 6
    //   1090: istore 5
    //   1092: iload 4
    //   1094: istore 6
    //   1096: iload_2
    //   1097: ifeq +36 -> 1133
    //   1100: iload 4
    //   1102: istore 6
    //   1104: getstatic 124	com/tencent/smtt/sdk/TbsDownloader:sAppContext	Landroid/content/Context;
    //   1107: invokestatic 375	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   1110: ifne +23 -> 1133
    //   1113: iload 4
    //   1115: istore 6
    //   1117: iload 4
    //   1119: ifne +14 -> 1133
    //   1122: invokestatic 236	com/tencent/smtt/sdk/TbsInstaller:getInstance	()Lcom/tencent/smtt/sdk/TbsInstaller;
    //   1125: getstatic 124	com/tencent/smtt/sdk/TbsDownloader:sAppContext	Landroid/content/Context;
    //   1128: invokevirtual 240	com/tencent/smtt/sdk/TbsInstaller:getTbsCoreShareDecoupleCoreVersion	(Landroid/content/Context;)I
    //   1131: istore 6
    //   1133: ldc 30
    //   1135: new 349	java/lang/StringBuilder
    //   1138: dup
    //   1139: invokespecial 350	java/lang/StringBuilder:<init>	()V
    //   1142: ldc_w 1066
    //   1145: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1148: iload 6
    //   1150: invokevirtual 568	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1153: invokevirtual 361	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1156: invokestatic 366	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1159: aload 27
    //   1161: getfield 816	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1164: ldc_w 596
    //   1167: iload 6
    //   1169: invokestatic 851	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1172: invokeinterface 824 3 0
    //   1177: pop
    //   1178: aload 27
    //   1180: getfield 816	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1183: ldc_w 576
    //   1186: iload 5
    //   1188: invokestatic 851	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1191: invokeinterface 824 3 0
    //   1196: pop
    //   1197: getstatic 124	com/tencent/smtt/sdk/TbsDownloader:sAppContext	Landroid/content/Context;
    //   1200: invokestatic 375	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   1203: ifne +46 -> 1249
    //   1206: iload 6
    //   1208: ifle +131 -> 1339
    //   1211: iload 6
    //   1213: invokestatic 236	com/tencent/smtt/sdk/TbsInstaller:getInstance	()Lcom/tencent/smtt/sdk/TbsInstaller;
    //   1216: getstatic 124	com/tencent/smtt/sdk/TbsDownloader:sAppContext	Landroid/content/Context;
    //   1219: invokevirtual 240	com/tencent/smtt/sdk/TbsInstaller:getTbsCoreShareDecoupleCoreVersion	(Landroid/content/Context;)I
    //   1222: if_icmpeq +117 -> 1339
    //   1225: iload 6
    //   1227: invokestatic 236	com/tencent/smtt/sdk/TbsInstaller:getInstance	()Lcom/tencent/smtt/sdk/TbsInstaller;
    //   1230: getstatic 124	com/tencent/smtt/sdk/TbsDownloader:sAppContext	Landroid/content/Context;
    //   1233: invokevirtual 1069	com/tencent/smtt/sdk/TbsInstaller:getTbsCoreInstalledVerInNolock	(Landroid/content/Context;)I
    //   1236: if_icmpne +103 -> 1339
    //   1239: invokestatic 236	com/tencent/smtt/sdk/TbsInstaller:getInstance	()Lcom/tencent/smtt/sdk/TbsInstaller;
    //   1242: getstatic 124	com/tencent/smtt/sdk/TbsDownloader:sAppContext	Landroid/content/Context;
    //   1245: invokevirtual 1072	com/tencent/smtt/sdk/TbsInstaller:coreShareCopyToDecouple	(Landroid/content/Context;)Z
    //   1248: pop
    //   1249: aload 29
    //   1251: invokestatic 253	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1254: ifeq +110 -> 1364
    //   1257: getstatic 124	com/tencent/smtt/sdk/TbsDownloader:sAppContext	Landroid/content/Context;
    //   1260: invokestatic 375	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   1263: ifeq +101 -> 1364
    //   1266: aload 27
    //   1268: getfield 816	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1271: ldc_w 545
    //   1274: iconst_0
    //   1275: invokestatic 1075	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1278: invokeinterface 824 3 0
    //   1283: pop
    //   1284: aload 27
    //   1286: invokevirtual 826	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1289: iload_2
    //   1290: ifeq +12 -> 1302
    //   1293: getstatic 124	com/tencent/smtt/sdk/TbsDownloader:sAppContext	Landroid/content/Context;
    //   1296: iload 10
    //   1298: iconst_0
    //   1299: invokestatic 1079	com/tencent/smtt/sdk/TbsShareManager:writeCoreInfoForThirdPartyApp	(Landroid/content/Context;IZ)V
    //   1302: ldc 30
    //   1304: ldc_w 1081
    //   1307: invokestatic 366	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1310: iconst_0
    //   1311: ireturn
    //   1312: getstatic 124	com/tencent/smtt/sdk/TbsDownloader:sAppContext	Landroid/content/Context;
    //   1315: invokestatic 143	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1318: getfield 425	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   1321: ldc_w 596
    //   1324: iconst_0
    //   1325: invokeinterface 580 3 0
    //   1330: istore 6
    //   1332: iload 6
    //   1334: istore 4
    //   1336: goto -268 -> 1068
    //   1339: iload 6
    //   1341: ifne -92 -> 1249
    //   1344: invokestatic 236	com/tencent/smtt/sdk/TbsInstaller:getInstance	()Lcom/tencent/smtt/sdk/TbsInstaller;
    //   1347: getstatic 124	com/tencent/smtt/sdk/TbsDownloader:sAppContext	Landroid/content/Context;
    //   1350: invokevirtual 1085	com/tencent/smtt/sdk/TbsInstaller:getCoreShareDecoupleDir	(Landroid/content/Context;)Ljava/io/File;
    //   1353: invokestatic 1089	com/tencent/smtt/utils/FileUtil:delete	(Ljava/io/File;)V
    //   1356: goto -107 -> 1249
    //   1359: astore 24
    //   1361: goto -112 -> 1249
    //   1364: ldc 30
    //   1366: new 349	java/lang/StringBuilder
    //   1369: dup
    //   1370: invokespecial 350	java/lang/StringBuilder:<init>	()V
    //   1373: ldc_w 1091
    //   1376: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1379: iload 11
    //   1381: invokevirtual 568	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1384: invokevirtual 361	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1387: invokestatic 366	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1390: iload 11
    //   1392: ifne +122 -> 1514
    //   1395: aload 27
    //   1397: getfield 816	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1400: ldc_w 1093
    //   1403: iload 11
    //   1405: invokestatic 851	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1408: invokeinterface 824 3 0
    //   1413: pop
    //   1414: aload 27
    //   1416: getfield 816	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1419: ldc_w 545
    //   1422: iconst_0
    //   1423: invokestatic 1075	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1426: invokeinterface 824 3 0
    //   1431: pop
    //   1432: iload_2
    //   1433: ifeq +50 -> 1483
    //   1436: aload 27
    //   1438: getfield 816	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1441: ldc_w 1095
    //   1444: bipush 145
    //   1446: invokestatic 851	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1449: invokeinterface 824 3 0
    //   1454: pop
    //   1455: aload 27
    //   1457: invokevirtual 826	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1460: getstatic 124	com/tencent/smtt/sdk/TbsDownloader:sAppContext	Landroid/content/Context;
    //   1463: invokestatic 375	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   1466: ifne +7 -> 1473
    //   1469: invokestatic 1098	com/tencent/smtt/sdk/TbsDownloader:startDecoupleCoreIfNeeded	()Z
    //   1472: pop
    //   1473: ldc 30
    //   1475: ldc_w 1100
    //   1478: invokestatic 366	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1481: iconst_0
    //   1482: ireturn
    //   1483: aload 27
    //   1485: getfield 816	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1488: ldc_w 1095
    //   1491: sipush -211
    //   1494: invokestatic 851	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1497: invokeinterface 824 3 0
    //   1502: pop
    //   1503: aload 27
    //   1505: sipush -211
    //   1508: invokevirtual 506	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   1511: goto -56 -> 1455
    //   1514: getstatic 124	com/tencent/smtt/sdk/TbsDownloader:sAppContext	Landroid/content/Context;
    //   1517: invokestatic 143	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1520: getfield 425	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   1523: ldc_w 598
    //   1526: iconst_0
    //   1527: invokeinterface 580 3 0
    //   1532: istore 7
    //   1534: iload 7
    //   1536: iload 10
    //   1538: if_icmple +18 -> 1556
    //   1541: getstatic 132	com/tencent/smtt/sdk/TbsDownloader:sTbsApkDownloader	Lcom/tencent/smtt/sdk/TbsApkDownloader;
    //   1544: invokevirtual 1103	com/tencent/smtt/sdk/TbsApkDownloader:clearCache	()V
    //   1547: invokestatic 236	com/tencent/smtt/sdk/TbsInstaller:getInstance	()Lcom/tencent/smtt/sdk/TbsInstaller;
    //   1550: getstatic 124	com/tencent/smtt/sdk/TbsDownloader:sAppContext	Landroid/content/Context;
    //   1553: invokevirtual 1106	com/tencent/smtt/sdk/TbsInstaller:cleanStatusAndTmpDir	(Landroid/content/Context;)V
    //   1556: iconst_0
    //   1557: istore 4
    //   1559: iconst_0
    //   1560: istore 6
    //   1562: getstatic 124	com/tencent/smtt/sdk/TbsDownloader:sAppContext	Landroid/content/Context;
    //   1565: invokestatic 375	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   1568: ifne +65 -> 1633
    //   1571: invokestatic 236	com/tencent/smtt/sdk/TbsInstaller:getInstance	()Lcom/tencent/smtt/sdk/TbsInstaller;
    //   1574: getstatic 124	com/tencent/smtt/sdk/TbsDownloader:sAppContext	Landroid/content/Context;
    //   1577: invokevirtual 1109	com/tencent/smtt/sdk/TbsInstaller:getTmpTbsCoreVersionUnzipDir	(Landroid/content/Context;)I
    //   1580: istore 8
    //   1582: iload 6
    //   1584: istore 4
    //   1586: iload 8
    //   1588: iload 10
    //   1590: if_icmplt +6 -> 1596
    //   1593: iconst_1
    //   1594: istore 4
    //   1596: ldc 30
    //   1598: new 349	java/lang/StringBuilder
    //   1601: dup
    //   1602: invokespecial 350	java/lang/StringBuilder:<init>	()V
    //   1605: ldc_w 1111
    //   1608: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1611: iload 8
    //   1613: invokevirtual 568	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1616: ldc_w 1113
    //   1619: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1622: iload 10
    //   1624: invokevirtual 568	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1627: invokevirtual 361	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1630: invokestatic 366	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1633: iload_1
    //   1634: iload 10
    //   1636: if_icmpge +16 -> 1652
    //   1639: aload 29
    //   1641: invokestatic 253	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1644: ifne +8 -> 1652
    //   1647: iload 4
    //   1649: ifeq +274 -> 1923
    //   1652: iload 5
    //   1654: iconst_1
    //   1655: if_icmpeq +268 -> 1923
    //   1658: aload 27
    //   1660: getfield 816	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1663: ldc_w 545
    //   1666: iconst_0
    //   1667: invokestatic 1075	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1670: invokeinterface 824 3 0
    //   1675: pop
    //   1676: iload_2
    //   1677: ifeq +172 -> 1849
    //   1680: aload 29
    //   1682: invokestatic 253	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1685: ifeq +87 -> 1772
    //   1688: aload 27
    //   1690: getfield 816	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1693: ldc_w 1095
    //   1696: bipush 132
    //   1698: invokestatic 851	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1701: invokeinterface 824 3 0
    //   1706: pop
    //   1707: aload 27
    //   1709: invokevirtual 826	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1712: ldc 30
    //   1714: new 349	java/lang/StringBuilder
    //   1717: dup
    //   1718: invokespecial 350	java/lang/StringBuilder:<init>	()V
    //   1721: ldc_w 1115
    //   1724: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1727: iload_1
    //   1728: invokevirtual 568	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1731: ldc_w 1117
    //   1734: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1737: iload 10
    //   1739: invokevirtual 568	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1742: ldc_w 1119
    //   1745: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1748: iload 7
    //   1750: invokevirtual 568	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1753: ldc_w 1121
    //   1756: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1759: aload 29
    //   1761: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1764: invokevirtual 361	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1767: invokestatic 366	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1770: iconst_0
    //   1771: ireturn
    //   1772: iload 10
    //   1774: ifgt +25 -> 1799
    //   1777: aload 27
    //   1779: getfield 816	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1782: ldc_w 1095
    //   1785: bipush 131
    //   1787: invokestatic 851	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1790: invokeinterface 824 3 0
    //   1795: pop
    //   1796: goto -89 -> 1707
    //   1799: iload_1
    //   1800: iload 10
    //   1802: if_icmplt +25 -> 1827
    //   1805: aload 27
    //   1807: getfield 816	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1810: ldc_w 1095
    //   1813: bipush 129
    //   1815: invokestatic 851	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1818: invokeinterface 824 3 0
    //   1823: pop
    //   1824: goto -117 -> 1707
    //   1827: aload 27
    //   1829: getfield 816	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1832: ldc_w 1095
    //   1835: bipush 144
    //   1837: invokestatic 851	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1840: invokeinterface 824 3 0
    //   1845: pop
    //   1846: goto -139 -> 1707
    //   1849: sipush -212
    //   1852: istore 4
    //   1854: aload 29
    //   1856: invokestatic 253	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1859: ifeq +37 -> 1896
    //   1862: sipush -217
    //   1865: istore 4
    //   1867: aload 27
    //   1869: getfield 816	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1872: ldc_w 1095
    //   1875: iload 4
    //   1877: invokestatic 851	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1880: invokeinterface 824 3 0
    //   1885: pop
    //   1886: aload 27
    //   1888: iload 4
    //   1890: invokevirtual 506	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   1893: goto -186 -> 1707
    //   1896: iload 10
    //   1898: ifgt +11 -> 1909
    //   1901: sipush -218
    //   1904: istore 4
    //   1906: goto -39 -> 1867
    //   1909: iload_1
    //   1910: iload 10
    //   1912: if_icmplt -45 -> 1867
    //   1915: sipush -219
    //   1918: istore 4
    //   1920: goto -53 -> 1867
    //   1923: aload 29
    //   1925: aload 27
    //   1927: getfield 425	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   1930: ldc_w 1123
    //   1933: aconst_null
    //   1934: invokeinterface 603 3 0
    //   1939: invokevirtual 307	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1942: ifne +45 -> 1987
    //   1945: getstatic 132	com/tencent/smtt/sdk/TbsDownloader:sTbsApkDownloader	Lcom/tencent/smtt/sdk/TbsApkDownloader;
    //   1948: invokevirtual 1103	com/tencent/smtt/sdk/TbsApkDownloader:clearCache	()V
    //   1951: aload 27
    //   1953: getfield 816	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1956: ldc_w 723
    //   1959: iconst_0
    //   1960: invokestatic 851	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1963: invokeinterface 824 3 0
    //   1968: pop
    //   1969: aload 27
    //   1971: getfield 816	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1974: ldc_w 713
    //   1977: iconst_0
    //   1978: invokestatic 851	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1981: invokeinterface 824 3 0
    //   1986: pop
    //   1987: aload 27
    //   1989: getfield 816	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1992: ldc_w 598
    //   1995: iload 10
    //   1997: invokestatic 851	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2000: invokeinterface 824 3 0
    //   2005: pop
    //   2006: ldc 30
    //   2008: new 349	java/lang/StringBuilder
    //   2011: dup
    //   2012: invokespecial 350	java/lang/StringBuilder:<init>	()V
    //   2015: ldc_w 1125
    //   2018: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2021: iload 10
    //   2023: invokevirtual 568	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2026: invokevirtual 361	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2029: invokestatic 366	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2032: iload 10
    //   2034: ifle +53 -> 2087
    //   2037: iload 5
    //   2039: iconst_1
    //   2040: if_icmpne +341 -> 2381
    //   2043: aload 27
    //   2045: getfield 816	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2048: ldc_w 1127
    //   2051: iconst_1
    //   2052: invokestatic 851	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2055: invokeinterface 824 3 0
    //   2060: pop
    //   2061: ldc 30
    //   2063: new 349	java/lang/StringBuilder
    //   2066: dup
    //   2067: invokespecial 350	java/lang/StringBuilder:<init>	()V
    //   2070: ldc_w 1129
    //   2073: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2076: iload 5
    //   2078: invokevirtual 568	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2081: invokevirtual 361	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2084: invokestatic 366	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2087: aload 27
    //   2089: getfield 816	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2092: ldc_w 1123
    //   2095: aload 29
    //   2097: invokeinterface 824 3 0
    //   2102: pop
    //   2103: aload 27
    //   2105: getfield 816	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2108: ldc_w 1131
    //   2111: aload 30
    //   2113: invokeinterface 824 3 0
    //   2118: pop
    //   2119: aload 27
    //   2121: getfield 816	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2124: ldc_w 1093
    //   2127: iload 11
    //   2129: invokestatic 851	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2132: invokeinterface 824 3 0
    //   2137: pop
    //   2138: aload 27
    //   2140: getfield 816	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2143: ldc_w 1133
    //   2146: iload 12
    //   2148: invokestatic 851	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2151: invokeinterface 824 3 0
    //   2156: pop
    //   2157: aload 27
    //   2159: getfield 816	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2162: ldc_w 1135
    //   2165: iload 13
    //   2167: invokestatic 851	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2170: invokeinterface 824 3 0
    //   2175: pop
    //   2176: aload 27
    //   2178: getfield 816	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2181: ldc_w 1137
    //   2184: iload 14
    //   2186: invokestatic 851	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2189: invokeinterface 824 3 0
    //   2194: pop
    //   2195: aload 27
    //   2197: getfield 816	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2200: ldc_w 1139
    //   2203: iload 15
    //   2205: invokestatic 851	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2208: invokeinterface 824 3 0
    //   2213: pop
    //   2214: aload 27
    //   2216: getfield 816	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2219: ldc_w 1141
    //   2222: lload 20
    //   2224: invokestatic 1062	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2227: invokeinterface 824 3 0
    //   2232: pop
    //   2233: aload 27
    //   2235: getfield 816	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2238: ldc_w 1143
    //   2241: lload 22
    //   2243: invokestatic 1062	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2246: invokeinterface 824 3 0
    //   2251: pop
    //   2252: aload 27
    //   2254: invokevirtual 826	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2257: aload_0
    //   2258: ifnull +18 -> 2276
    //   2261: aload 27
    //   2263: getfield 816	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2266: ldc_w 1145
    //   2269: aload_0
    //   2270: invokeinterface 824 3 0
    //   2275: pop
    //   2276: iload_3
    //   2277: ifne +156 -> 2433
    //   2280: invokestatic 236	com/tencent/smtt/sdk/TbsInstaller:getInstance	()Lcom/tencent/smtt/sdk/TbsInstaller;
    //   2283: getstatic 124	com/tencent/smtt/sdk/TbsDownloader:sAppContext	Landroid/content/Context;
    //   2286: iload 10
    //   2288: invokevirtual 1148	com/tencent/smtt/sdk/TbsInstaller:installLocalTbsCore	(Landroid/content/Context;I)Z
    //   2291: ifeq +142 -> 2433
    //   2294: iload_2
    //   2295: ifeq +107 -> 2402
    //   2298: aload 27
    //   2300: getfield 816	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2303: ldc_w 1095
    //   2306: bipush 143
    //   2308: invokestatic 851	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2311: invokeinterface 824 3 0
    //   2316: pop
    //   2317: aload 27
    //   2319: getfield 816	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2322: ldc_w 545
    //   2325: iconst_0
    //   2326: invokestatic 1075	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2329: invokeinterface 824 3 0
    //   2334: pop
    //   2335: ldc 30
    //   2337: ldc_w 1150
    //   2340: invokestatic 366	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2343: aload 28
    //   2345: ldc_w 1152
    //   2348: iconst_0
    //   2349: invokevirtual 976	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2352: iconst_1
    //   2353: if_icmpne +21 -> 2374
    //   2356: aload 27
    //   2358: getfield 816	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2361: ldc_w 1154
    //   2364: iconst_1
    //   2365: invokestatic 1075	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2368: invokeinterface 824 3 0
    //   2373: pop
    //   2374: aload 27
    //   2376: invokevirtual 826	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2379: iconst_1
    //   2380: ireturn
    //   2381: aload 27
    //   2383: getfield 816	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2386: ldc_w 1127
    //   2389: iconst_0
    //   2390: invokestatic 851	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2393: invokeinterface 824 3 0
    //   2398: pop
    //   2399: goto -338 -> 2061
    //   2402: aload 27
    //   2404: getfield 816	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2407: ldc_w 1095
    //   2410: sipush -213
    //   2413: invokestatic 851	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2416: invokeinterface 824 3 0
    //   2421: pop
    //   2422: aload 27
    //   2424: sipush -213
    //   2427: invokevirtual 506	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   2430: goto -113 -> 2317
    //   2433: iload_3
    //   2434: ifne +163 -> 2597
    //   2437: getstatic 132	com/tencent/smtt/sdk/TbsDownloader:sTbsApkDownloader	Lcom/tencent/smtt/sdk/TbsApkDownloader;
    //   2440: astore_0
    //   2441: iload 11
    //   2443: iconst_1
    //   2444: if_icmpeq +9 -> 2453
    //   2447: iload 11
    //   2449: iconst_2
    //   2450: if_icmpne +125 -> 2575
    //   2453: iconst_1
    //   2454: istore 17
    //   2456: aload_0
    //   2457: iload_3
    //   2458: iload 17
    //   2460: invokevirtual 1157	com/tencent/smtt/sdk/TbsApkDownloader:installBackupTbsApk	(ZZ)Z
    //   2463: ifeq +134 -> 2597
    //   2466: aload 27
    //   2468: getfield 816	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2471: ldc_w 545
    //   2474: iconst_0
    //   2475: invokestatic 1075	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2478: invokeinterface 824 3 0
    //   2483: pop
    //   2484: getstatic 124	com/tencent/smtt/sdk/TbsDownloader:sAppContext	Landroid/content/Context;
    //   2487: invokestatic 151	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   2490: invokevirtual 654	com/tencent/smtt/sdk/TbsLogReport:tbsLogInfo	()Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   2493: astore_0
    //   2494: aload_0
    //   2495: bipush 100
    //   2497: invokevirtual 659	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setErrorCode	(I)V
    //   2500: aload_0
    //   2501: new 349	java/lang/StringBuilder
    //   2504: dup
    //   2505: invokespecial 350	java/lang/StringBuilder:<init>	()V
    //   2508: ldc_w 1159
    //   2511: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2514: getstatic 132	com/tencent/smtt/sdk/TbsDownloader:sTbsApkDownloader	Lcom/tencent/smtt/sdk/TbsApkDownloader;
    //   2517: getfield 1162	com/tencent/smtt/sdk/TbsApkDownloader:localInstallMessage	Ljava/lang/String;
    //   2520: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2523: invokevirtual 361	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2526: invokevirtual 663	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setFailDetail	(Ljava/lang/String;)V
    //   2529: getstatic 124	com/tencent/smtt/sdk/TbsDownloader:sAppContext	Landroid/content/Context;
    //   2532: invokestatic 143	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2535: getfield 425	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   2538: ldc_w 576
    //   2541: iconst_0
    //   2542: invokeinterface 580 3 0
    //   2547: iconst_1
    //   2548: if_icmpne +33 -> 2581
    //   2551: getstatic 124	com/tencent/smtt/sdk/TbsDownloader:sAppContext	Landroid/content/Context;
    //   2554: invokestatic 151	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   2557: getstatic 1165	com/tencent/smtt/sdk/TbsLogReport$EventType:TYPE_DOWNLOAD_DECOUPLE	Lcom/tencent/smtt/sdk/TbsLogReport$EventType;
    //   2560: aload_0
    //   2561: invokevirtual 673	com/tencent/smtt/sdk/TbsLogReport:eventReport	(Lcom/tencent/smtt/sdk/TbsLogReport$EventType;Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;)V
    //   2564: ldc 30
    //   2566: ldc_w 1167
    //   2569: invokestatic 366	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2572: goto -229 -> 2343
    //   2575: iconst_0
    //   2576: istore 17
    //   2578: goto -122 -> 2456
    //   2581: getstatic 124	com/tencent/smtt/sdk/TbsDownloader:sAppContext	Landroid/content/Context;
    //   2584: invokestatic 151	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   2587: getstatic 669	com/tencent/smtt/sdk/TbsLogReport$EventType:TYPE_DOWNLOAD	Lcom/tencent/smtt/sdk/TbsLogReport$EventType;
    //   2590: aload_0
    //   2591: invokevirtual 673	com/tencent/smtt/sdk/TbsLogReport:eventReport	(Lcom/tencent/smtt/sdk/TbsLogReport$EventType;Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;)V
    //   2594: goto -30 -> 2564
    //   2597: getstatic 124	com/tencent/smtt/sdk/TbsDownloader:sAppContext	Landroid/content/Context;
    //   2600: invokestatic 143	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2603: getfield 425	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   2606: ldc_w 1127
    //   2609: iconst_0
    //   2610: invokeinterface 580 3 0
    //   2615: iconst_1
    //   2616: if_icmpne +137 -> 2753
    //   2619: getstatic 132	com/tencent/smtt/sdk/TbsDownloader:sTbsApkDownloader	Lcom/tencent/smtt/sdk/TbsApkDownloader;
    //   2622: invokevirtual 1170	com/tencent/smtt/sdk/TbsApkDownloader:verifyAndInstallDecoupleCoreFromBackup	()Z
    //   2625: ifeq +128 -> 2753
    //   2628: aload 27
    //   2630: getfield 816	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2633: ldc_w 545
    //   2636: iconst_0
    //   2637: invokestatic 1075	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2640: invokeinterface 824 3 0
    //   2645: pop
    //   2646: getstatic 124	com/tencent/smtt/sdk/TbsDownloader:sAppContext	Landroid/content/Context;
    //   2649: invokestatic 151	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   2652: invokevirtual 654	com/tencent/smtt/sdk/TbsLogReport:tbsLogInfo	()Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   2655: astore_0
    //   2656: aload_0
    //   2657: bipush 100
    //   2659: invokevirtual 659	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setErrorCode	(I)V
    //   2662: aload_0
    //   2663: new 349	java/lang/StringBuilder
    //   2666: dup
    //   2667: invokespecial 350	java/lang/StringBuilder:<init>	()V
    //   2670: ldc_w 1172
    //   2673: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2676: getstatic 132	com/tencent/smtt/sdk/TbsDownloader:sTbsApkDownloader	Lcom/tencent/smtt/sdk/TbsApkDownloader;
    //   2679: getfield 1162	com/tencent/smtt/sdk/TbsApkDownloader:localInstallMessage	Ljava/lang/String;
    //   2682: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2685: invokevirtual 361	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2688: invokevirtual 663	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setFailDetail	(Ljava/lang/String;)V
    //   2691: getstatic 124	com/tencent/smtt/sdk/TbsDownloader:sAppContext	Landroid/content/Context;
    //   2694: invokestatic 143	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2697: getfield 425	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   2700: ldc_w 576
    //   2703: iconst_0
    //   2704: invokeinterface 580 3 0
    //   2709: iconst_1
    //   2710: if_icmpne +27 -> 2737
    //   2713: getstatic 124	com/tencent/smtt/sdk/TbsDownloader:sAppContext	Landroid/content/Context;
    //   2716: invokestatic 151	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   2719: getstatic 1165	com/tencent/smtt/sdk/TbsLogReport$EventType:TYPE_DOWNLOAD_DECOUPLE	Lcom/tencent/smtt/sdk/TbsLogReport$EventType;
    //   2722: aload_0
    //   2723: invokevirtual 673	com/tencent/smtt/sdk/TbsLogReport:eventReport	(Lcom/tencent/smtt/sdk/TbsLogReport$EventType;Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;)V
    //   2726: ldc 30
    //   2728: ldc_w 1174
    //   2731: invokestatic 366	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2734: goto -391 -> 2343
    //   2737: getstatic 124	com/tencent/smtt/sdk/TbsDownloader:sAppContext	Landroid/content/Context;
    //   2740: invokestatic 151	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   2743: getstatic 669	com/tencent/smtt/sdk/TbsLogReport$EventType:TYPE_DOWNLOAD	Lcom/tencent/smtt/sdk/TbsLogReport$EventType;
    //   2746: aload_0
    //   2747: invokevirtual 673	com/tencent/smtt/sdk/TbsLogReport:eventReport	(Lcom/tencent/smtt/sdk/TbsLogReport$EventType;Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;)V
    //   2750: goto -24 -> 2726
    //   2753: iload_2
    //   2754: ifne +11 -> 2765
    //   2757: aload 27
    //   2759: sipush -216
    //   2762: invokevirtual 506	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   2765: aload 27
    //   2767: getfield 816	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2770: ldc_w 545
    //   2773: iconst_1
    //   2774: invokestatic 1075	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2777: invokeinterface 824 3 0
    //   2782: pop
    //   2783: ldc 30
    //   2785: ldc_w 1176
    //   2788: invokestatic 366	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2791: goto -448 -> 2343
    //   2794: astore 24
    //   2796: goto -1704 -> 1092
    //   2799: astore 24
    //   2801: goto -1733 -> 1068
    //   2804: astore 25
    //   2806: goto -2187 -> 619
    //   2809: astore 24
    //   2811: aload_0
    //   2812: astore 24
    //   2814: ldc_w 317
    //   2817: astore_0
    //   2818: iconst_0
    //   2819: istore 4
    //   2821: iload 7
    //   2823: istore 6
    //   2825: goto -1947 -> 878
    //   2828: astore 24
    //   2830: iload 4
    //   2832: istore 5
    //   2834: aload_0
    //   2835: astore 24
    //   2837: iconst_0
    //   2838: istore 4
    //   2840: ldc_w 317
    //   2843: astore_0
    //   2844: iload 7
    //   2846: istore 6
    //   2848: goto -1970 -> 878
    //   2851: astore 24
    //   2853: iload 4
    //   2855: istore 5
    //   2857: aload_0
    //   2858: astore 24
    //   2860: ldc_w 317
    //   2863: astore_0
    //   2864: iconst_0
    //   2865: istore 4
    //   2867: goto -1989 -> 878
    //   2870: astore 24
    //   2872: iload 4
    //   2874: istore 7
    //   2876: aload_0
    //   2877: astore 24
    //   2879: aload 25
    //   2881: astore_0
    //   2882: iload 5
    //   2884: istore 4
    //   2886: iload 7
    //   2888: istore 5
    //   2890: goto -2012 -> 878
    //   2893: astore_0
    //   2894: goto -2605 -> 289
    //   2897: ldc2_w 1177
    //   2900: lstore 18
    //   2902: goto -1890 -> 1012
    //   2905: goto -1900 -> 1005
    //   2908: iconst_1
    //   2909: istore 17
    //   2911: goto -2339 -> 572
    //   2914: iconst_0
    //   2915: istore 5
    //   2917: goto -2415 -> 502
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2920	0	paramString	String
    //   0	2920	1	paramInt	int
    //   0	2920	2	paramBoolean1	boolean
    //   0	2920	3	paramBoolean2	boolean
    //   90	2795	4	i	int
    //   283	2633	5	j	int
    //   471	2376	6	k	int
    //   437	2450	7	m	int
    //   578	1034	8	n	int
    //   613	3	9	i1	int
    //   188	2099	10	i2	int
    //   155	2296	11	i3	int
    //   198	1949	12	i4	int
    //   208	1958	13	i5	int
    //   218	1967	14	i6	int
    //   228	1976	15	i7	int
    //   270	719	16	i8	int
    //   354	2556	17	bool	boolean
    //   259	2642	18	l1	long
    //   238	1985	20	l2	long
    //   248	1994	22	l3	long
    //   345	550	24	localObject1	Object
    //   1359	1	24	localThrowable	Throwable
    //   2794	1	24	localException1	Exception
    //   2799	1	24	localException2	Exception
    //   2809	1	24	localException3	Exception
    //   2812	1	24	str1	String
    //   2828	1	24	localException4	Exception
    //   2835	1	24	str2	String
    //   2851	1	24	localException5	Exception
    //   2858	1	24	str3	String
    //   2870	1	24	localException6	Exception
    //   2877	1	24	str4	String
    //   508	393	25	localObject2	Object
    //   906	10	25	localException7	Exception
    //   2804	76	25	localException8	Exception
    //   442	80	26	str5	String
    //   31	2735	27	localTbsDownloadConfig	TbsDownloadConfig
    //   80	2264	28	localJSONObject	JSONObject
    //   165	1931	29	str6	String
    //   178	1934	30	str7	String
    // Exception table:
    //   from	to	target	type
    //   327	347	782	java/lang/Throwable
    //   356	368	782	java/lang/Throwable
    //   372	386	821	java/lang/Throwable
    //   389	430	821	java/lang/Throwable
    //   444	453	866	java/lang/Exception
    //   592	602	906	java/lang/Exception
    //   632	649	914	finally
    //   649	712	914	finally
    //   712	715	914	finally
    //   915	918	914	finally
    //   1344	1356	1359	java/lang/Throwable
    //   1068	1088	2794	java/lang/Exception
    //   1054	1064	2799	java/lang/Exception
    //   1312	1332	2799	java/lang/Exception
    //   605	615	2804	java/lang/Exception
    //   453	463	2809	java/lang/Exception
    //   463	473	2828	java/lang/Exception
    //   473	494	2851	java/lang/Exception
    //   510	521	2870	java/lang/Exception
    //   525	535	2870	java/lang/Exception
    //   539	550	2870	java/lang/Exception
    //   554	564	2870	java/lang/Exception
    //   275	285	2893	java/lang/Exception
  }
  
  private static boolean sendRequest(boolean paramBoolean1, boolean paramBoolean2)
  {
    return sendRequest(paramBoolean1, paramBoolean2, false);
  }
  
  private static boolean sendRequest(final boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((QbSdk.mSettings != null) && (QbSdk.mSettings.containsKey(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD)) && (QbSdk.mSettings.get(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD).equals("false")))
    {
      TbsLog.i("TbsDownload", "[TbsDownloader.sendRequest] -- SET_SENDREQUEST_AND_UPLOAD is false");
      return false;
    }
    TbsLog.i("TbsDownload", "[TbsDownloader.sendRequest]isQuery: " + paramBoolean1 + " forDecoupleCore is " + paramBoolean3);
    if (TbsInstaller.getInstance().isTbsLocalInstalled(sAppContext))
    {
      TbsLog.i("TbsDownload", "[TbsDownloader.sendRequest] -- isTbsLocalInstalled!");
      return false;
    }
    TbsDownloadConfig localTbsDownloadConfig = TbsDownloadConfig.getInstance(sAppContext);
    Object localObject2 = FileUtil.getTBSSdcardFilePath(sAppContext, 1);
    Object localObject1;
    if (getOverSea(sAppContext)) {
      localObject1 = "x5.oversea.tbs.org";
    }
    for (;;)
    {
      localObject2 = new File((String)localObject2, (String)localObject1);
      Object localObject3 = FileUtil.getTBSSdcardFilePath(sAppContext, 2);
      label172:
      label207:
      label242:
      int j;
      if (getOverSea(sAppContext))
      {
        localObject1 = "x5.oversea.tbs.org";
        localObject3 = new File((String)localObject3, (String)localObject1);
        Object localObject4 = FileUtil.getTBSSdcardFilePath(sAppContext, 3);
        if (!getOverSea(sAppContext)) {
          break label693;
        }
        localObject1 = "x5.oversea.tbs.org";
        localObject4 = new File((String)localObject4, (String)localObject1);
        String str2 = FileUtil.getTBSSdcardFilePath(sAppContext, 4);
        if (!getOverSea(sAppContext)) {
          break label700;
        }
        localObject1 = "x5.oversea.tbs.org";
        localObject1 = new File(str2, (String)localObject1);
        if (!((File)localObject1).exists())
        {
          if (!((File)localObject4).exists()) {
            break label707;
          }
          ((File)localObject4).renameTo((File)localObject1);
        }
        label279:
        if (sCpuabi == null)
        {
          sCpuabi = AppUtil.getDeviceCpuabi();
          localTbsDownloadConfig.mSyncMap.put("device_cpuabi", sCpuabi);
          localTbsDownloadConfig.commit();
        }
        j = 0;
        i = j;
        if (!TextUtils.isEmpty(sCpuabi)) {
          localObject1 = null;
        }
      }
      label405:
      label446:
      label707:
      try
      {
        localObject2 = Pattern.compile("i686|mips|x86_64").matcher(sCpuabi);
        localObject1 = localObject2;
      }
      catch (Exception localException2)
      {
        label348:
        label745:
        label764:
        break label348;
      }
      int i = j;
      if (localObject1 != null)
      {
        i = j;
        if (((Matcher)localObject1).find())
        {
          if (!TbsShareManager.isThirdPartyApp(sAppContext)) {
            break label764;
          }
          localObject1 = TbsLogReport.getInstance(sAppContext).tbsLogInfo();
          if (!paramBoolean1) {
            break label745;
          }
          localTbsDownloadConfig.setDownloadInterruptCode(-104);
          ((TbsLogReport.TbsLogInfo)localObject1).setErrorCode(-104);
          ((TbsLogReport.TbsLogInfo)localObject1).setFailDetail("mycpu is " + sCpuabi);
          TbsLogReport.getInstance(sAppContext).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, (TbsLogReport.TbsLogInfo)localObject1);
          i = 1;
        }
      }
      localObject1 = postJsonData(paramBoolean1, paramBoolean2, paramBoolean3);
      try
      {
        j = ((JSONObject)localObject1).getInt("TBSV");
        if ((i != 0) || (j != -1))
        {
          long l2 = System.currentTimeMillis();
          if (TbsShareManager.isThirdPartyApp(sAppContext))
          {
            l1 = localTbsDownloadConfig.mPreferences.getLong("request_fail", 0L);
            long l3 = localTbsDownloadConfig.mPreferences.getLong("count_request_fail_in_24hours", 0L);
            if (l2 - l1 < localTbsDownloadConfig.getRetryInterval() * 1000L)
            {
              l1 = 1L + l3;
              localTbsDownloadConfig.mSyncMap.put("count_request_fail_in_24hours", Long.valueOf(l1));
            }
          }
          else
          {
            localTbsDownloadConfig.mSyncMap.put("last_check", Long.valueOf(l2));
            localTbsDownloadConfig.mSyncMap.put("request_fail", Long.valueOf(l2));
            localTbsDownloadConfig.mSyncMap.put("app_versionname", AppUtil.getAppVersionName(sAppContext));
            localTbsDownloadConfig.mSyncMap.put("app_versioncode", Integer.valueOf(AppUtil.getAppVersionCode(sAppContext)));
            localTbsDownloadConfig.mSyncMap.put("app_metadata", AppUtil.getAppMetadata(sAppContext, "com.tencent.mm.BuildInfo.CLIENT_VERSION"));
            localTbsDownloadConfig.commit();
            if (i == 0) {
              break label803;
            }
            return false;
            localObject1 = "x5.tbs.org";
            continue;
            localObject1 = "x5.tbs.org";
            break label172;
            label693:
            localObject1 = "x5.tbs.org";
            break label207;
            label700:
            localObject1 = "x5.tbs.org";
            break label242;
            if (((File)localObject3).exists())
            {
              ((File)localObject3).renameTo((File)localObject1);
              break label279;
            }
            if (!((File)localObject2).exists()) {
              break label279;
            }
            ((File)localObject2).renameTo((File)localObject1);
            break label279;
            localTbsDownloadConfig.setDownloadInterruptCode(-205);
            ((TbsLogReport.TbsLogInfo)localObject1).setErrorCode(-205);
            break label405;
            if (paramBoolean1)
            {
              localTbsDownloadConfig.setDownloadInterruptCode(-104);
              break label446;
            }
            localTbsDownloadConfig.setDownloadInterruptCode(-205);
          }
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          j = -1;
          continue;
          long l1 = 1L;
        }
        label803:
        if (j != -1) {
          try
          {
            String str1 = TbsCommonConfig.getInstance(sAppContext).getTbsDownloaderPostUrl();
            TbsLog.i("TbsDownload", "[TbsDownloader.sendRequest] postUrl=" + str1);
            paramBoolean2 = readResponse(HttpUtil.postData(str1, ((JSONObject)localObject1).toString().getBytes("utf-8"), new HttpUtil.HttpResponseListener()
            {
              public void onHttpResponseCode(int paramAnonymousInt)
              {
                TbsLog.i("TbsDownload", "[TbsDownloader.sendRequest] httpResponseCode=" + paramAnonymousInt);
                if ((TbsShareManager.isThirdPartyApp(TbsDownloader.sAppContext)) && (paramAnonymousInt == 200))
                {
                  this.val$tbsDownloadConfig.mSyncMap.put("last_request_success", Long.valueOf(System.currentTimeMillis()));
                  this.val$tbsDownloadConfig.mSyncMap.put("request_fail", Long.valueOf(0L));
                  this.val$tbsDownloadConfig.mSyncMap.put("count_request_fail_in_24hours", Long.valueOf(0L));
                  this.val$tbsDownloadConfig.commit();
                }
                if (paramAnonymousInt >= 300)
                {
                  if (paramBoolean1) {
                    this.val$tbsDownloadConfig.setDownloadInterruptCode(-107);
                  }
                }
                else {
                  return;
                }
                this.val$tbsDownloadConfig.setDownloadInterruptCode(-207);
              }
            }, false), j, paramBoolean1, paramBoolean2);
            return paramBoolean2;
          }
          catch (Throwable localThrowable)
          {
            localThrowable.printStackTrace();
            if (paramBoolean1)
            {
              localTbsDownloadConfig.setDownloadInterruptCode(-106);
              return false;
            }
            localTbsDownloadConfig.setDownloadInterruptCode(-206);
          }
        }
        return false;
      }
    }
  }
  
  private static boolean sendRequestWithSameHostCoreVersion()
  {
    try
    {
      JSONArray localJSONArray = getHostCoreVersions();
      boolean bool = TbsDownloadConfig.getInstance(sAppContext).mPreferences.getString("last_thirdapp_sendrequest_coreversion", "").equals(localJSONArray.toString());
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static void setRetryIntervalInSeconds(Context paramContext, long paramLong)
  {
    if (paramContext == null) {
      return;
    }
    if (paramContext.getApplicationInfo().packageName.equals("com.tencent.qqlive")) {
      mRetryIntervalInSeconds = paramLong;
    }
    TbsLog.i("TbsDownload", "mRetryIntervalInSeconds is " + mRetryIntervalInSeconds);
  }
  
  private static boolean shouldDoNeedDownload(Context paramContext, boolean paramBoolean, TbsDownloaderCallback paramTbsDownloaderCallback)
  {
    Object localObject = null;
    TbsDownloadConfig localTbsDownloadConfig = TbsDownloadConfig.getInstance(paramContext);
    if (Build.VERSION.SDK_INT < 8)
    {
      localTbsDownloadConfig.setDownloadInterruptCode(-102);
      return false;
    }
    if (!localTbsDownloadConfig.mPreferences.contains("is_oversea"))
    {
      boolean bool = paramBoolean;
      if (paramBoolean)
      {
        bool = paramBoolean;
        if (!"com.tencent.mm".equals(paramContext.getApplicationInfo().packageName))
        {
          TbsLog.i("TbsDownload", "needDownload-oversea is true, but not WX");
          bool = false;
        }
      }
      localTbsDownloadConfig.mSyncMap.put("is_oversea", Boolean.valueOf(bool));
      localTbsDownloadConfig.commit();
      sOverSea = bool;
      TbsLog.i("TbsDownload", "needDownload-first-called--isoversea = " + bool);
    }
    if ((getOverSea(paramContext)) && (Build.VERSION.SDK_INT != 16) && (Build.VERSION.SDK_INT != 17) && (Build.VERSION.SDK_INT != 18))
    {
      TbsLog.i("TbsDownload", "needDownload- return false,  because of  version is " + Build.VERSION.SDK_INT + ", and overea");
      if (paramTbsDownloaderCallback != null) {
        paramTbsDownloaderCallback.onNeedDownloadFinish(false, 0);
      }
      localTbsDownloadConfig.setDownloadInterruptCode(-103);
      return false;
    }
    sCpuabi = localTbsDownloadConfig.mPreferences.getString("device_cpuabi", null);
    if (!TextUtils.isEmpty(sCpuabi)) {}
    try
    {
      paramContext = Pattern.compile("i686|mips|x86_64").matcher(sCpuabi);
      if ((paramContext != null) && (paramContext.find()))
      {
        if (paramTbsDownloaderCallback != null) {
          paramTbsDownloaderCallback.onNeedDownloadFinish(false, 0);
        }
        localTbsDownloadConfig.setDownloadInterruptCode(-104);
        return false;
      }
      return true;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext = localObject;
      }
    }
  }
  
  public static boolean startDecoupleCoreIfNeeded()
  {
    TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded ");
    if (TbsShareManager.isThirdPartyApp(sAppContext)) {}
    long l;
    do
    {
      do
      {
        return false;
        TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded #1");
      } while (TbsDownloadConfig.getInstance(sAppContext).mPreferences.getInt("tbs_downloaddecouplecore", 0) == 1);
      TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded #2");
      l = TbsDownloadConfig.getInstance(sAppContext).mPreferences.getLong("last_download_decouple_core", 0L);
    } while (System.currentTimeMillis() - l < 1000L * TbsDownloadConfig.getInstance(sAppContext).getRetryInterval());
    TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded #3");
    int i = TbsDownloadConfig.getInstance(sAppContext).mPreferences.getInt("tbs_decouplecoreversion", 0);
    if ((i > 0) && (i != TbsInstaller.getInstance().getTbsCoreShareDecoupleCoreVersion(sAppContext)))
    {
      if ((TbsDownloadConfig.getInstance(sAppContext).mPreferences.getInt("tbs_download_version", 0) != i) || (TbsDownloadConfig.getInstance(sAppContext).mPreferences.getInt("tbs_download_version_type", 0) == 1))
      {
        TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded #4");
        mIsDownloading = true;
        sTbsDownloaderHandler.removeMessages(108);
        Message localMessage = Message.obtain(sTbsDownloaderHandler, 108, QbSdk.mTbsListenerWrapper);
        localMessage.arg1 = 0;
        localMessage.sendToTarget();
        TbsDownloadConfig.getInstance(sAppContext).mSyncMap.put("last_download_decouple_core", Long.valueOf(System.currentTimeMillis()));
        return true;
      }
      TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded no need, KEY_TBS_DOWNLOAD_V is " + TbsDownloadConfig.getInstance(sAppContext).mPreferences.getInt("tbs_download_version", 0) + " deCoupleCoreVersion is " + i + " KEY_TBS_DOWNLOAD_V_TYPE is " + TbsDownloadConfig.getInstance(sAppContext).mPreferences.getInt("tbs_download_version_type", 0));
      return false;
    }
    TbsLog.i("TbsDownload", "startDecoupleCoreIfNeeded no need, deCoupleCoreVersion is " + i + " getTbsCoreShareDecoupleCoreVersion is " + TbsInstaller.getInstance().getTbsCoreShareDecoupleCoreVersion(sAppContext));
    return false;
  }
  
  public static void startDownload(Context paramContext)
  {
    startDownload(paramContext, false);
  }
  
  public static void startDownload(Context paramContext, boolean paramBoolean)
  {
    int i = 1;
    for (;;)
    {
      try
      {
        TbsLog.i("TbsDownload", "[TbsDownloader.startDownload] sAppContext=" + sAppContext);
        boolean bool = TbsInstaller.isStaticTbsInstalling;
        if (bool) {
          return;
        }
        mIsDownloading = true;
        sAppContext = paramContext.getApplicationContext();
        TbsDownloadConfig.getInstance(sAppContext).setDownloadInterruptCode(-200);
        if (Build.VERSION.SDK_INT < 8)
        {
          QbSdk.mTbsListenerWrapper.onDownloadFinish(110);
          TbsDownloadConfig.getInstance(sAppContext).setDownloadInterruptCode(-201);
          continue;
        }
        initTbsDownloaderThreadIfNeeded();
      }
      finally {}
      if (!mStopDownloadByException) {
        break;
      }
      QbSdk.mTbsListenerWrapper.onDownloadFinish(121);
      TbsDownloadConfig.getInstance(sAppContext).setDownloadInterruptCode(-202);
    }
    if (paramBoolean) {
      stopDownload();
    }
    sTbsDownloaderHandler.removeMessages(101);
    sTbsDownloaderHandler.removeMessages(100);
    paramContext = Message.obtain(sTbsDownloaderHandler, 101, QbSdk.mTbsListenerWrapper);
    if (paramBoolean) {}
    for (;;)
    {
      paramContext.arg1 = i;
      paramContext.sendToTarget();
      break;
      i = 0;
    }
  }
  
  public static void stopDownload()
  {
    if (mStopDownloadByException) {}
    do
    {
      return;
      TbsLog.i("TbsDownload", "[TbsDownloader.stopDownload]");
      if (sTbsApkDownloader != null) {
        sTbsApkDownloader.stopDownload();
      }
    } while (sTbsDownloaderHandler == null);
    sTbsDownloaderHandler.removeMessages(100);
    sTbsDownloaderHandler.removeMessages(101);
    sTbsDownloaderHandler.removeMessages(108);
  }
  
  public static abstract interface TbsDownloaderCallback
  {
    public abstract void onNeedDownloadFinish(boolean paramBoolean, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsDownloader
 * JD-Core Version:    0.7.0.1
 */