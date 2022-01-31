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
import android.os.Message;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.smtt.utils.ApkUtil;
import com.tencent.smtt.utils.Apn;
import com.tencent.smtt.utils.AppUtil;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.HttpUtil;
import com.tencent.smtt.utils.TbsCommonConfig;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;
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
  static final int RESPONSECODE_TPATCH = 5;
  static final int RESPONSECODE_UPDATE_APK = 2;
  static final int RESPONSECODE_UPDATE_PATCH = 3;
  private static final String TBS_BACKUP_64_APK_FILENAME_DECOUPLE = "x5.tbs.decouple.64";
  private static final String TBS_BACKUP_APK_FILENAME_DECOUPLE = "x5.tbs.decouple";
  private static final String TBS_EXTENSION_CFG_FILE = "tbs_extension_config";
  public static final String TBS_METADATA = "com.tencent.mm.BuildInfo.CLIENT_VERSION";
  static final String TBS_PRECHECK_DISABLE_VERSION = "tbs_precheck_disable_version";
  static final String TBS_PRELOADX5_CHECK_CFG_FILE = "tbs_preloadx5_check_cfg_file";
  private static final String TBS_SDBACKUP_64_APK_FILENAME = "x5.tbs.org.64";
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
  
  private static void addAppDefinedToCoreVersions(JSONArray paramJSONArray)
  {
    int k = 0;
    int m;
    int i;
    if (TbsShareManager.getHostCorePathAppDefined() != null)
    {
      m = TbsInstaller.getInstance().getTbsCoreVersionAppDefined(TbsShareManager.getHostCorePathAppDefined());
      i = 0;
    }
    for (;;)
    {
      int j = k;
      if (i < paramJSONArray.length())
      {
        if (paramJSONArray.optInt(i) == m) {
          j = 1;
        }
      }
      else
      {
        if (j == 0) {
          paramJSONArray.put(m);
        }
        return;
      }
      i += 1;
    }
  }
  
  private static void addBackupVersionToJsonData(JSONArray paramJSONArray)
  {
    String str;
    int m;
    Context localContext;
    if (!TbsPVConfig.getInstance(sAppContext).isDisableHostBackupCore())
    {
      String[] arrayOfString = getSrcPackageNames();
      int k = arrayOfString.length;
      int i = 0;
      for (;;)
      {
        if (i < k)
        {
          str = arrayOfString[i];
          m = TbsShareManager.getBackupCoreVersion(sAppContext, str);
          if (m > 0)
          {
            localContext = TbsShareManager.getPackageContext(sAppContext, str, false);
            if ((localContext != null) && (!TbsInstaller.getInstance().vertificateApp(localContext)))
            {
              TbsLog.e("TbsDownload", "host check failed,packageName = " + str);
              i += 1;
              continue;
            }
            j = 0;
            label110:
            if (j >= paramJSONArray.length()) {
              break label267;
            }
            if (paramJSONArray.optInt(j) != m) {
              break label211;
            }
          }
        }
      }
    }
    label265:
    label267:
    for (int j = 1;; j = 0)
    {
      if (j == 0) {
        paramJSONArray.put(m);
      }
      m = TbsShareManager.getBackupDecoupleCoreVersion(sAppContext, str);
      if (m <= 0) {
        break;
      }
      localContext = TbsShareManager.getPackageContext(sAppContext, str, false);
      if ((localContext != null) && (!TbsInstaller.getInstance().vertificateApp(localContext)))
      {
        TbsLog.e("TbsDownload", "host check failed,packageName = " + str);
        break;
        label211:
        j += 1;
        break label110;
      }
      j = 0;
      label220:
      if (j < paramJSONArray.length()) {
        if (paramJSONArray.optInt(j) != m) {}
      }
      for (j = 1;; j = 0)
      {
        if (j != 0) {
          break label265;
        }
        paramJSONArray.put(m);
        break;
        j += 1;
        break label220;
        return;
      }
      break;
    }
  }
  
  private static void addCoreVersionToJsonData(JSONArray paramJSONArray)
  {
    String[] arrayOfString = getSrcPackageNames();
    int k = arrayOfString.length;
    int i = 0;
    int m;
    if (i < k)
    {
      String str = arrayOfString[i];
      m = TbsShareManager.getSharedTbsCoreVersion(sAppContext, str);
      if (m > 0)
      {
        Context localContext = TbsShareManager.getPackageContext(sAppContext, str, true);
        if ((localContext == null) || (TbsInstaller.getInstance().vertificateApp(localContext))) {
          break label96;
        }
        TbsLog.e("TbsDownload", "host check failed,packageName = " + str);
      }
    }
    label143:
    for (;;)
    {
      i += 1;
      break;
      label96:
      int j = 0;
      label98:
      if (j < paramJSONArray.length()) {
        if (paramJSONArray.optInt(j) != m) {}
      }
      for (j = 1;; j = 0)
      {
        if (j != 0) {
          break label143;
        }
        paramJSONArray.put(m);
        break;
        j += 1;
        break label98;
        return;
      }
    }
  }
  
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
  
  private static JSONArray getAvailableLocalBackupVersion(boolean paramBoolean)
  {
    JSONArray localJSONArray = new JSONArray();
    String[] arrayOfString = TbsShareManager.getCoreProviderAppList();
    int k = arrayOfString.length;
    int i = 0;
    Object localObject;
    label60:
    label73:
    long l;
    if (i < k)
    {
      localObject = arrayOfString[i];
      if (paramBoolean)
      {
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
              label106:
              if (j >= localJSONArray.length()) {
                break label192;
              }
              if (localJSONArray.optInt(j) != l) {
                break label182;
              }
            }
          }
        }
      }
    }
    label182:
    label192:
    for (int j = 1;; j = 0)
    {
      if (j == 0) {
        localJSONArray.put(l);
      }
      i += 1;
      break;
      localObject = getBackupFileName(false);
      break label60;
      localObject = new File(FileUtil.getTBSSdcardFilePath(sAppContext, (String)localObject, 4, false), "x5.tbs.decouple");
      break label73;
      j += 1;
      break label106;
      return localJSONArray;
    }
  }
  
  public static String getBackupFileName(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (AppUtil.is64BitImpl()) {
        return "x5.tbs.decouple.64";
      }
      return "x5.tbs.decouple";
    }
    if (AppUtil.is64BitImpl()) {
      return "x5.tbs.org.64";
    }
    return "x5.tbs.org";
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
      for (localObject1 = "x5.oversea.tbs.org";; localObject1 = getBackupFileName(false))
      {
        localObject1 = new File((String)localObject2, (String)localObject1);
        if ((localObject1 == null) || (!((File)localObject1).exists())) {
          break label161;
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
      label161:
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
      for (localObject = "x5.oversea.tbs.org";; localObject = getBackupFileName(false))
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
    if (TbsShareManager.isThirdPartyApp(sAppContext))
    {
      JSONArray localJSONArray = new JSONArray();
      addCoreVersionToJsonData(localJSONArray);
      addBackupVersionToJsonData(localJSONArray);
      addAppDefinedToCoreVersions(localJSONArray);
      return localJSONArray;
    }
    return null;
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
  
  private static String[] getSrcPackageNames()
  {
    if (QbSdk.getOnlyDownload()) {
      return new String[] { sAppContext.getApplicationContext().getPackageName() };
    }
    String[] arrayOfString1 = TbsShareManager.getCoreProviderAppList();
    String str = sAppContext.getApplicationContext().getPackageName();
    if (str.equals(TbsShareManager.readPackageNameFromConfig(sAppContext)))
    {
      int i = arrayOfString1.length;
      String[] arrayOfString2 = new String[i + 1];
      System.arraycopy(arrayOfString1, 0, arrayOfString2, 0, i);
      arrayOfString2[i] = str;
      return arrayOfString2;
    }
    return arrayOfString1;
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
        sTbsDownloaderHandler = new TbsDownloader.1(sTbsHandlerThread.getLooper());
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
  
  static boolean isDecoupleCore(Context paramContext)
  {
    return TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_downloaddecouplecore", 0) == 1;
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
    return needDownload(paramContext, paramBoolean, false, true, null);
  }
  
  public static boolean needDownload(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, TbsDownloader.TbsDownloaderCallback paramTbsDownloaderCallback)
  {
    return needDownload(paramContext, paramBoolean1, paramBoolean2, true, paramTbsDownloaderCallback);
  }
  
  public static boolean needDownload(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, TbsDownloader.TbsDownloaderCallback paramTbsDownloaderCallback)
  {
    TbsLog.i("TbsDownload", "needDownload,process=" + QbSdk.getCurrentProcessName(paramContext) + "stack=" + Log.getStackTraceString(new Throwable()));
    TbsDownloadUpload.clear();
    TbsDownloadUpload localTbsDownloadUpload = TbsDownloadUpload.getInstance(paramContext);
    localTbsDownloadUpload.mSyncMap.put("tbs_needdownload_code", Integer.valueOf(140));
    localTbsDownloadUpload.commit();
    TbsLog.i("TbsDownload", "[TbsDownloader.needDownload] oversea=" + paramBoolean1 + ",isDownloadForeground=" + paramBoolean2);
    boolean bool1 = false;
    TbsLog.initIfNeed(paramContext);
    if (TbsInstaller.isStaticTbsInstalling)
    {
      if (paramTbsDownloaderCallback != null) {
        paramTbsDownloaderCallback.onNeedDownloadFinish(false, 0);
      }
      TbsLog.i("TbsDownload", "[TbsDownloader.needDownload]#1,return " + false);
      localTbsDownloadUpload.mSyncMap.put("tbs_needdownload_return", Integer.valueOf(171));
      localTbsDownloadUpload.commit();
    }
    TbsDownloadConfig localTbsDownloadConfig;
    do
    {
      return false;
      TbsLog.app_extra("TbsDownload", paramContext);
      sAppContext = paramContext.getApplicationContext();
      localTbsDownloadConfig = TbsDownloadConfig.getInstance(sAppContext);
      localTbsDownloadConfig.setDownloadInterruptCode(-100);
      if (shouldDoNeedDownload(sAppContext, paramBoolean1)) {
        break;
      }
      TbsLog.i("TbsDownload", "[TbsDownloader.needDownload]#2,return " + false);
      localTbsDownloadUpload.mSyncMap.put("tbs_needdownload_code", Integer.valueOf(141));
      localTbsDownloadUpload.commit();
      localTbsDownloadUpload.mSyncMap.put("tbs_needdownload_return", Integer.valueOf(172));
      localTbsDownloadUpload.commit();
    } while (paramTbsDownloaderCallback == null);
    paramTbsDownloaderCallback.onNeedDownloadFinish(false, 0);
    return false;
    initTbsDownloaderThreadIfNeeded();
    if (mStopDownloadByException)
    {
      if (paramTbsDownloaderCallback != null) {
        paramTbsDownloaderCallback.onNeedDownloadFinish(false, 0);
      }
      localTbsDownloadConfig.setDownloadInterruptCode(-105);
      TbsLog.i("TbsDownload", "[TbsDownloader.needDownload]#3,return " + false);
      localTbsDownloadUpload.mSyncMap.put("tbs_needdownload_code", Integer.valueOf(142));
      localTbsDownloadUpload.commit();
      localTbsDownloadUpload.mSyncMap.put("tbs_needdownload_return", Integer.valueOf(173));
      localTbsDownloadUpload.commit();
      if (paramTbsDownloaderCallback != null) {
        paramTbsDownloaderCallback.onNeedDownloadFinish(false, 0);
      }
      return false;
    }
    boolean bool2 = needSendQueryRequest(sAppContext, paramBoolean2, false);
    TbsLog.i("TbsDownload", "[TbsDownloader.needDownload],needSendRequest=" + bool2);
    if (bool2)
    {
      queryRequest(paramBoolean2, paramTbsDownloaderCallback, paramBoolean3);
      localTbsDownloadConfig.setDownloadInterruptCode(-114);
      sTbsDownloaderHandler.removeMessages(102);
      Message.obtain(sTbsDownloaderHandler, 102).sendToTarget();
      paramBoolean2 = false;
      if (!QbSdk.sAllowThirdPartyAppDownload)
      {
        paramBoolean1 = bool1;
        if (TbsShareManager.isThirdPartyApp(paramContext)) {}
      }
      else
      {
        paramBoolean2 = localTbsDownloadConfig.mPreferences.contains("tbs_needdownload");
        TbsLog.i("TbsDownload", "[TbsDownloader.needDownload] hasNeedDownloadKey=" + paramBoolean2);
        if ((paramBoolean2) || (TbsShareManager.isThirdPartyApp(paramContext))) {
          break label753;
        }
        paramBoolean1 = true;
      }
      label589:
      TbsLog.i("TbsDownload", "[TbsDownloader.needDownload]#4,needDownload=" + paramBoolean1 + ",hasNeedDownloadKey=" + paramBoolean2);
      if (!paramBoolean1) {
        break label789;
      }
      if (needStartDownload()) {
        break label771;
      }
      paramBoolean1 = false;
      TbsLog.i("TbsDownload", "[TbsDownloader.needDownload]#5,set needDownload = false");
      label644:
      if ((!bool2) && (paramTbsDownloaderCallback != null)) {
        paramTbsDownloaderCallback.onNeedDownloadFinish(false, 0);
      }
      TbsLog.i("TbsDownload", "[TbsDownloader.needDownload] needDownload=" + paramBoolean1);
      paramContext = localTbsDownloadUpload.mSyncMap;
      if (!paramBoolean1) {
        break label920;
      }
    }
    label771:
    label789:
    label920:
    for (int i = 170;; i = 174)
    {
      paramContext.put("tbs_needdownload_return", Integer.valueOf(i));
      localTbsDownloadUpload.commit();
      return paramBoolean1;
      localTbsDownloadUpload.mSyncMap.put("tbs_needdownload_code", Integer.valueOf(143));
      localTbsDownloadUpload.commit();
      break;
      label753:
      paramBoolean1 = localTbsDownloadConfig.mPreferences.getBoolean("tbs_needdownload", false);
      break label589;
      localTbsDownloadConfig.setDownloadInterruptCode(-118);
      TbsLog.i("TbsDownload", "[TbsDownloader.needDownload]#6");
      break label644;
      i = TbsInstaller.getInstance().getTbsCoreInstalledVerWithLock(sAppContext);
      TbsLog.i("TbsDownload", "[TbsDownloader.needDownload]#7,tbsLocalVersion=" + i + ",needSendRequest=" + bool2);
      if ((bool2) || (i <= 0))
      {
        sTbsDownloaderHandler.removeMessages(103);
        if ((i <= 0) && (!bool2)) {
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
      break label644;
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
        } while (isDecoupleCore(sAppContext));
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
    int k;
    int m;
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
      TbsPVConfig.releaseInstance();
      k = TbsPVConfig.getInstance(sAppContext).getEmergentCoreVersion();
      m = TbsDownloadConfig.getInstance(sAppContext).mPreferences.getInt("tbs_download_version", 0);
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
      if ((k > TbsInstaller.getInstance().getTbsCoreInstalledVerInNolock(sAppContext)) && (k > m))
      {
        paramBoolean1 = true;
        paramContext = null;
      }
      else if ((TbsShareManager.isThirdPartyApp(sAppContext)) && (l3 > 0L) && (l2 - l3 > l5 * 1000L) && (l4 < 11L))
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
    if (!shouldDoNeedDownload(sAppContext, paramBoolean)) {}
    int i;
    do
    {
      return false;
      i = TbsInstaller.getInstance().getTbsCoreInstalledVerWithLock(paramContext);
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
        break label207;
      }
    }
    label207:
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
          break label777;
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
          localException2.put("REQUEST_TPATCH", 0);
          continue;
          i = TbsDownloadConfig.getInstance(sAppContext).mPreferences.getInt("tbs_download_version", 0);
        }
      }
      if (localObject1 != null) {
        localObject3 = new JSONObject();
      }
    }
    try
    {
      if (TbsCoreVerManager.getInstance(sAppContext).getIntNum("tpatch_num") >= 5) {
        break label780;
      }
      ((JSONObject)localObject3).put("REQUEST_TPATCH", 1);
      ((JSONObject)localObject3).put("TIMEZONEID", localObject2);
      ((JSONObject)localObject3).put("COUNTRYISO", localObject1);
      if (AppUtil.is64BitImpl()) {
        ((JSONObject)localObject3).put("REQUEST_64", 1);
      }
      ((JSONObject)localObject3).put("PROTOCOLVERSION", 1);
      if (!TbsShareManager.isThirdPartyApp(sAppContext)) {
        break label815;
      }
      if (!QbSdk.sAllowThirdPartyAppDownload) {
        break label793;
      }
      i = TbsShareManager.getAvailableTbsCoreVersion(sAppContext, false);
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        int i;
        label239:
        label253:
        int j;
        label318:
        label618:
        continue;
        for (;;)
        {
          label777:
          label780:
          label793:
          label815:
          label1081:
          label1105:
          break;
          label1068:
          i = 0;
        }
        if (i == 0)
        {
          j = 0;
        }
        else
        {
          j = 1;
          continue;
          j = 0;
          continue;
          j = 0;
          continue;
          i = 1;
        }
      }
    }
    if (paramBoolean1)
    {
      ((JSONObject)localObject3).put("FUNCTION", 2);
      if (TbsShareManager.isThirdPartyApp(sAppContext))
      {
        localObject1 = getHostCoreVersions();
        ((JSONObject)localObject3).put("TBSVLARR", localObject1);
        localTbsDownloadConfig.mSyncMap.put("last_thirdapp_sendrequest_coreversion", ((JSONArray)localObject1).toString());
        localTbsDownloadConfig.commit();
        if (QbSdk.sAllowThirdPartyAppDownload) {
          ((JSONObject)localObject3).put("THIRDREQ", 1);
        }
        ((JSONObject)localObject3).put("APPN", sAppContext.getPackageName());
        ((JSONObject)localObject3).put("APPVN", notNullString(localTbsDownloadConfig.mPreferences.getString("app_versionname", null)));
        ((JSONObject)localObject3).put("APPVC", localTbsDownloadConfig.mPreferences.getInt("app_versioncode", 0));
        ((JSONObject)localObject3).put("APPMETA", notNullString(localTbsDownloadConfig.mPreferences.getString("app_metadata", null)));
        ((JSONObject)localObject3).put("TBSSDKV", 43739);
        ((JSONObject)localObject3).put("TBSV", i);
        if (!paramBoolean3) {
          break label1153;
        }
        j = 1;
        ((JSONObject)localObject3).put("DOWNLOADDECOUPLECORE", j);
        localObject1 = localTbsDownloadConfig.mSyncMap;
        if (!paramBoolean3) {
          break label1159;
        }
        j = 1;
        ((Map)localObject1).put("tbs_downloaddecouplecore", Integer.valueOf(j));
        localTbsDownloadConfig.commit();
        if (i != 0) {
          ((JSONObject)localObject3).put("TBSBACKUPV", sTbsApkDownloader.backupApkVersion(paramBoolean3));
        }
        ((JSONObject)localObject3).put("CPU", sCpuabi);
        ((JSONObject)localObject3).put("UA", str1);
        ((JSONObject)localObject3).put("IMSI", notNullString(str2));
        ((JSONObject)localObject3).put("IMEI", notNullString(str3));
        ((JSONObject)localObject3).put("ANDROID_ID", notNullString(str4));
        ((JSONObject)localObject3).put("GUID", AppUtil.getGuid(sAppContext));
        if (!TbsShareManager.isThirdPartyApp(sAppContext))
        {
          if (i == 0) {
            break label1068;
          }
          if (!QbSdk.isX5Disabled(sAppContext, i)) {
            break label1165;
          }
          i = 0;
          ((JSONObject)localObject3).put("STATUS", i);
          ((JSONObject)localObject3).put("TBSDV", TbsInstaller.getInstance().getTbsCoreShareDecoupleCoreVersion(sAppContext));
        }
        paramBoolean3 = TbsDownloadConfig.getInstance(sAppContext).mPreferences.getBoolean("request_full_package", false);
        localObject1 = QbSdk.onMiscCallExtension(sAppContext, "can_unlzma", null);
        if ((localObject1 == null) || (!(localObject1 instanceof Boolean))) {
          break label1081;
        }
        paramBoolean1 = ((Boolean)localObject1).booleanValue();
        break label1105;
      }
      for (;;)
      {
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
        if (paramBoolean3) {}
        for (j = TbsInstaller.getInstance().getTbsCoreInstalledVerInNolock(sAppContext);; j = TbsInstaller.getInstance().getTbsCoreInstalledVerWithLock(sAppContext))
        {
          i = j;
          if (j == 0)
          {
            i = j;
            if (TbsInstaller.getInstance().tbsFileConfExists(sAppContext))
            {
              j = -1;
              i = j;
              if ("com.tencent.mobileqq".equals(sAppContext.getApplicationInfo().packageName))
              {
                TbsDownloadUpload.clear();
                localObject1 = TbsDownloadUpload.getInstance(sAppContext);
                ((TbsDownloadUpload)localObject1).mSyncMap.put("tbs_local_core_version", Integer.valueOf(-1));
                ((TbsDownloadUpload)localObject1).commit();
                TbsPVConfig.releaseInstance();
                i = j;
                if (TbsPVConfig.getInstance(sAppContext).getLocalCoreVersionMoreTimes() == 1) {
                  i = TbsInstaller.getInstance().getTbsCoreInstalledVerInNolock(sAppContext);
                }
              }
            }
          }
          TbsLog.i("TbsDownload", "[TbsDownloader.postJsonData] tbsLocalVersion=" + i + " isDownloadForeground=" + paramBoolean2);
          if (!paramBoolean2) {
            break;
          }
          if (!TbsInstaller.getInstance().tbsFileConfExists(sAppContext)) {
            break label1132;
          }
          break label1129;
        }
        localException2.put("FUNCTION", j);
        break label253;
        localObject1 = getAvailableLocalBackupVersion(paramBoolean3);
        if ((Apn.getApnType(sAppContext) == 3) || (((JSONArray)localObject1).length() == 0) || (i != 0) || (!paramBoolean1)) {
          break label318;
        }
        localException2.put("TBSBACKUPARR", localObject1);
        break label318;
        localException2.put("STATUS", 0);
        break label618;
        paramBoolean1 = false;
        break label1105;
        break label239;
        localObject1 = "";
        break label133;
        localObject2 = "";
        break;
        i = k;
        if (paramBoolean1)
        {
          i = k;
          if (!paramBoolean3) {
            i = 1;
          }
        }
      }
    }
  }
  
  private static void queryRequest(boolean paramBoolean1, TbsDownloader.TbsDownloaderCallback paramTbsDownloaderCallback, boolean paramBoolean2)
  {
    int j = 1;
    TbsLog.i("TbsDownload", "[TbsDownloader.queryConfig]");
    sTbsDownloaderHandler.removeMessages(100);
    Message localMessage = Message.obtain(sTbsDownloaderHandler, 100);
    if (paramTbsDownloaderCallback != null) {
      localMessage.obj = paramTbsDownloaderCallback;
    }
    localMessage.arg1 = 0;
    if (paramBoolean1)
    {
      i = 1;
      localMessage.arg1 = i;
      if (!paramBoolean2) {
        break label81;
      }
    }
    label81:
    for (int i = j;; i = 0)
    {
      localMessage.arg2 = i;
      localMessage.sendToTarget();
      return;
      i = 0;
      break;
    }
  }
  
  /* Error */
  @TargetApi(11)
  private static boolean readResponse(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    // Byte code:
    //   0: ldc 23
    //   2: new 189	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   9: ldc_w 1033
    //   12: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: aload_0
    //   16: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: ldc_w 1035
    //   22: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: iload 4
    //   27: invokevirtual 454	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   30: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokestatic 419	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   36: getstatic 125	com/tencent/smtt/sdk/TbsDownloader:sAppContext	Landroid/content/Context;
    //   39: invokestatic 222	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   42: astore 30
    //   44: aload_0
    //   45: invokestatic 319	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   48: ifeq +35 -> 83
    //   51: iload_2
    //   52: ifeq +20 -> 72
    //   55: aload 30
    //   57: bipush 148
    //   59: invokevirtual 595	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   62: ldc 23
    //   64: ldc_w 1037
    //   67: invokestatic 419	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   70: iconst_0
    //   71: ireturn
    //   72: aload 30
    //   74: sipush -208
    //   77: invokevirtual 595	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   80: goto -18 -> 62
    //   83: new 880	org/json/JSONObject
    //   86: dup
    //   87: aload_0
    //   88: invokespecial 1039	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   91: astore 31
    //   93: aload 31
    //   95: ldc_w 1041
    //   98: invokevirtual 1043	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   101: istore 5
    //   103: iload 5
    //   105: ifeq +53 -> 158
    //   108: iload_2
    //   109: ifeq +38 -> 147
    //   112: aload 30
    //   114: bipush 147
    //   116: invokevirtual 595	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   119: ldc 23
    //   121: new 189	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   128: ldc_w 1045
    //   131: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: iload 5
    //   136: invokevirtual 656	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   139: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: invokestatic 419	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   145: iconst_0
    //   146: ireturn
    //   147: aload 30
    //   149: sipush -209
    //   152: invokevirtual 595	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   155: goto -36 -> 119
    //   158: aload 31
    //   160: ldc_w 1047
    //   163: invokevirtual 1043	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   166: istore 12
    //   168: aload 31
    //   170: ldc_w 1049
    //   173: invokevirtual 1051	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   176: astore 32
    //   178: aload 31
    //   180: ldc_w 1053
    //   183: ldc_w 381
    //   186: invokevirtual 1056	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   189: astore 33
    //   191: aload 31
    //   193: ldc_w 1058
    //   196: invokevirtual 1043	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   199: istore 11
    //   201: aload 31
    //   203: ldc_w 1060
    //   206: invokevirtual 1043	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   209: istore 13
    //   211: aload 31
    //   213: ldc_w 1062
    //   216: invokevirtual 1043	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   219: istore 14
    //   221: aload 31
    //   223: ldc_w 1064
    //   226: invokevirtual 1043	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   229: istore 15
    //   231: aload 31
    //   233: ldc_w 1066
    //   236: invokevirtual 1043	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   239: istore 16
    //   241: aload 31
    //   243: ldc_w 1068
    //   246: invokevirtual 1071	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   249: lstore 23
    //   251: aload 31
    //   253: ldc_w 1073
    //   256: invokevirtual 1071	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   259: lstore 25
    //   261: aload 31
    //   263: ldc_w 1075
    //   266: lconst_0
    //   267: invokevirtual 1078	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   270: lstore 21
    //   272: aload 31
    //   274: ldc_w 1080
    //   277: iconst_m1
    //   278: invokevirtual 1082	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   281: istore 17
    //   283: iconst_0
    //   284: istore 5
    //   286: aload 31
    //   288: ldc_w 1084
    //   291: invokevirtual 1043	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   294: istore 6
    //   296: iload 6
    //   298: istore 5
    //   300: aload 30
    //   302: getfield 918	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   305: ldc_w 1086
    //   308: iload 5
    //   310: invokestatic 560	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   313: invokeinterface 565 3 0
    //   318: pop
    //   319: iload_2
    //   320: ifeq +59 -> 379
    //   323: getstatic 1089	com/tencent/smtt/sdk/QbSdk:mIsBuglyEnabled	Z
    //   326: ifeq +53 -> 379
    //   329: getstatic 125	com/tencent/smtt/sdk/TbsDownloader:sAppContext	Landroid/content/Context;
    //   332: invokestatic 429	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   335: ifeq +44 -> 379
    //   338: aload 31
    //   340: ldc_w 1091
    //   343: iconst_0
    //   344: invokevirtual 1082	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   347: istore 5
    //   349: invokestatic 1096	com/tencent/smtt/sdk/TbsExtensionFunctionManager:getInstance	()Lcom/tencent/smtt/sdk/TbsExtensionFunctionManager;
    //   352: astore_0
    //   353: getstatic 125	com/tencent/smtt/sdk/TbsDownloader:sAppContext	Landroid/content/Context;
    //   356: astore 27
    //   358: iload 5
    //   360: iconst_1
    //   361: if_icmpne +660 -> 1021
    //   364: iconst_1
    //   365: istore 18
    //   367: aload_0
    //   368: aload 27
    //   370: ldc_w 1098
    //   373: iload 18
    //   375: invokevirtual 1102	com/tencent/smtt/sdk/TbsExtensionFunctionManager:setFunctionEnable	(Landroid/content/Context;Ljava/lang/String;Z)Z
    //   378: pop
    //   379: iload_2
    //   380: ifeq +229 -> 609
    //   383: aload 31
    //   385: ldc_w 1104
    //   388: iconst_0
    //   389: invokevirtual 1082	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   392: istore 5
    //   394: iload 5
    //   396: iconst_1
    //   397: iand
    //   398: ifeq +662 -> 1060
    //   401: iconst_1
    //   402: istore 18
    //   404: invokestatic 1096	com/tencent/smtt/sdk/TbsExtensionFunctionManager:getInstance	()Lcom/tencent/smtt/sdk/TbsExtensionFunctionManager;
    //   407: getstatic 125	com/tencent/smtt/sdk/TbsDownloader:sAppContext	Landroid/content/Context;
    //   410: ldc_w 1106
    //   413: iload 18
    //   415: invokevirtual 1102	com/tencent/smtt/sdk/TbsExtensionFunctionManager:setFunctionEnable	(Landroid/content/Context;Ljava/lang/String;Z)Z
    //   418: pop
    //   419: ldc 23
    //   421: new 189	java/lang/StringBuilder
    //   424: dup
    //   425: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   428: ldc_w 1108
    //   431: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: iload 18
    //   436: invokevirtual 454	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   439: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   442: invokestatic 1111	com/tencent/smtt/utils/TbsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   445: iload 5
    //   447: iconst_2
    //   448: iand
    //   449: ifeq +617 -> 1066
    //   452: iconst_1
    //   453: istore 18
    //   455: invokestatic 1096	com/tencent/smtt/sdk/TbsExtensionFunctionManager:getInstance	()Lcom/tencent/smtt/sdk/TbsExtensionFunctionManager;
    //   458: getstatic 125	com/tencent/smtt/sdk/TbsDownloader:sAppContext	Landroid/content/Context;
    //   461: ldc_w 1113
    //   464: iload 18
    //   466: invokevirtual 1102	com/tencent/smtt/sdk/TbsExtensionFunctionManager:setFunctionEnable	(Landroid/content/Context;Ljava/lang/String;Z)Z
    //   469: pop
    //   470: ldc 23
    //   472: new 189	java/lang/StringBuilder
    //   475: dup
    //   476: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   479: ldc_w 1115
    //   482: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: iload 18
    //   487: invokevirtual 454	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   490: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   493: invokestatic 1111	com/tencent/smtt/utils/TbsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   496: iload 5
    //   498: iconst_4
    //   499: iand
    //   500: ifeq +572 -> 1072
    //   503: iconst_1
    //   504: istore 18
    //   506: invokestatic 1096	com/tencent/smtt/sdk/TbsExtensionFunctionManager:getInstance	()Lcom/tencent/smtt/sdk/TbsExtensionFunctionManager;
    //   509: getstatic 125	com/tencent/smtt/sdk/TbsDownloader:sAppContext	Landroid/content/Context;
    //   512: ldc_w 1117
    //   515: iload 18
    //   517: invokevirtual 1102	com/tencent/smtt/sdk/TbsExtensionFunctionManager:setFunctionEnable	(Landroid/content/Context;Ljava/lang/String;Z)Z
    //   520: pop
    //   521: iload 18
    //   523: invokestatic 1121	com/tencent/smtt/sdk/QbSdk:setDisableUnpreinitBySwitch	(Z)V
    //   526: ldc 23
    //   528: new 189	java/lang/StringBuilder
    //   531: dup
    //   532: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   535: ldc_w 1123
    //   538: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: iload 18
    //   543: invokevirtual 454	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   546: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   549: invokestatic 419	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   552: iload 5
    //   554: bipush 8
    //   556: iand
    //   557: ifeq +521 -> 1078
    //   560: iconst_1
    //   561: istore 18
    //   563: invokestatic 1096	com/tencent/smtt/sdk/TbsExtensionFunctionManager:getInstance	()Lcom/tencent/smtt/sdk/TbsExtensionFunctionManager;
    //   566: getstatic 125	com/tencent/smtt/sdk/TbsDownloader:sAppContext	Landroid/content/Context;
    //   569: ldc_w 1125
    //   572: iload 18
    //   574: invokevirtual 1102	com/tencent/smtt/sdk/TbsExtensionFunctionManager:setFunctionEnable	(Landroid/content/Context;Ljava/lang/String;Z)Z
    //   577: pop
    //   578: iload 18
    //   580: invokestatic 1128	com/tencent/smtt/sdk/QbSdk:setDisableUseHostBackupCoreBySwitch	(Z)V
    //   583: ldc 23
    //   585: new 189	java/lang/StringBuilder
    //   588: dup
    //   589: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   592: ldc_w 1130
    //   595: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: iload 18
    //   600: invokevirtual 454	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   603: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   606: invokestatic 419	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   609: aconst_null
    //   610: astore 27
    //   612: iconst_0
    //   613: istore 6
    //   615: iconst_0
    //   616: istore 8
    //   618: iconst_1
    //   619: istore 20
    //   621: iconst_1
    //   622: istore 18
    //   624: ldc_w 381
    //   627: astore 29
    //   629: aload 31
    //   631: ldc_w 1132
    //   634: invokevirtual 1051	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   637: astore_0
    //   638: aload 31
    //   640: ldc_w 1134
    //   643: invokevirtual 1043	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   646: istore 5
    //   648: aload 31
    //   650: ldc_w 1136
    //   653: invokevirtual 1043	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   656: istore 7
    //   658: aload 31
    //   660: ldc_w 1138
    //   663: invokevirtual 1141	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   666: ifeq +2530 -> 3196
    //   669: aload 31
    //   671: ldc_w 1138
    //   674: invokevirtual 1043	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   677: istore 6
    //   679: iload 6
    //   681: ifeq +436 -> 1117
    //   684: iconst_1
    //   685: istore 6
    //   687: aload 29
    //   689: astore 27
    //   691: aload 29
    //   693: astore 28
    //   695: iload 20
    //   697: istore 19
    //   699: aload 31
    //   701: ldc_w 1143
    //   704: invokevirtual 1141	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   707: ifeq +21 -> 728
    //   710: aload 29
    //   712: astore 28
    //   714: iload 20
    //   716: istore 19
    //   718: aload 31
    //   720: ldc_w 1143
    //   723: invokevirtual 1051	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   726: astore 27
    //   728: aload 27
    //   730: astore 28
    //   732: iload 20
    //   734: istore 19
    //   736: aload 31
    //   738: ldc_w 1145
    //   741: invokevirtual 1141	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   744: ifeq +28 -> 772
    //   747: aload 27
    //   749: astore 28
    //   751: iload 20
    //   753: istore 19
    //   755: aload 31
    //   757: ldc_w 1145
    //   760: invokevirtual 1043	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   763: ifeq +360 -> 1123
    //   766: iconst_1
    //   767: istore 18
    //   769: goto +2433 -> 3202
    //   772: aload 27
    //   774: astore 28
    //   776: iload 18
    //   778: istore 19
    //   780: aload 31
    //   782: ldc_w 1147
    //   785: invokevirtual 1141	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   788: ifeq +2402 -> 3190
    //   791: aload 27
    //   793: astore 28
    //   795: iload 18
    //   797: istore 19
    //   799: aload 31
    //   801: ldc_w 1147
    //   804: invokevirtual 1043	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   807: istore 8
    //   809: iload 8
    //   811: ifeq +318 -> 1129
    //   814: iconst_1
    //   815: istore 19
    //   817: iload 7
    //   819: istore 8
    //   821: iload 6
    //   823: istore 9
    //   825: iload 5
    //   827: istore 7
    //   829: iload 8
    //   831: istore 6
    //   833: iload 9
    //   835: istore 5
    //   837: aload 31
    //   839: ldc_w 1149
    //   842: invokevirtual 1043	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   845: istore 8
    //   847: iconst_0
    //   848: istore 9
    //   850: aload 31
    //   852: ldc_w 1151
    //   855: invokevirtual 1043	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   858: istore 10
    //   860: iload 10
    //   862: istore 9
    //   864: getstatic 102	com/tencent/smtt/sdk/TbsDownloader:mProtocolLock	Ljava/lang/Object;
    //   867: astore 28
    //   869: aload 28
    //   871: monitorenter
    //   872: iload 5
    //   874: ifeq +20 -> 894
    //   877: aload 30
    //   879: getfield 918	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   882: ldc_w 1153
    //   885: ldc_w 381
    //   888: invokeinterface 565 3 0
    //   893: pop
    //   894: aload 27
    //   896: invokestatic 319	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   899: ifne +58 -> 957
    //   902: aload 27
    //   904: invokevirtual 398	java/lang/String:length	()I
    //   907: bipush 96
    //   909: if_icmpne +48 -> 957
    //   912: new 189	java/lang/StringBuilder
    //   915: dup
    //   916: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   919: aload 27
    //   921: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   924: ldc_w 1155
    //   927: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   930: invokestatic 1160	com/tencent/smtt/utils/Post3DESEncryption:getDESString	()Ljava/lang/String;
    //   933: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   936: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   939: astore 27
    //   941: aload 30
    //   943: getfield 918	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   946: ldc_w 1153
    //   949: aload 27
    //   951: invokeinterface 565 3 0
    //   956: pop
    //   957: aload 28
    //   959: monitorexit
    //   960: iload 7
    //   962: iconst_1
    //   963: if_icmpne +245 -> 1208
    //   966: iload_2
    //   967: ifeq +225 -> 1192
    //   970: aload 30
    //   972: bipush 146
    //   974: invokevirtual 595	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   977: getstatic 125	com/tencent/smtt/sdk/TbsDownloader:sAppContext	Landroid/content/Context;
    //   980: astore_0
    //   981: iload 9
    //   983: iconst_1
    //   984: if_icmpne +219 -> 1203
    //   987: iconst_1
    //   988: istore_3
    //   989: aload_0
    //   990: iload_3
    //   991: invokestatic 1164	com/tencent/smtt/sdk/QbSdk:reset	(Landroid/content/Context;Z)V
    //   994: ldc 23
    //   996: new 189	java/lang/StringBuilder
    //   999: dup
    //   1000: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   1003: ldc_w 1166
    //   1006: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1009: iload_2
    //   1010: invokevirtual 454	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1013: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1016: invokestatic 419	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1019: iconst_0
    //   1020: ireturn
    //   1021: iconst_0
    //   1022: istore 18
    //   1024: goto -657 -> 367
    //   1027: astore_0
    //   1028: ldc_w 1168
    //   1031: new 189	java/lang/StringBuilder
    //   1034: dup
    //   1035: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   1038: ldc_w 1170
    //   1041: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1044: aload_0
    //   1045: invokevirtual 1171	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1048: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1051: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1054: invokestatic 419	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1057: goto -678 -> 379
    //   1060: iconst_0
    //   1061: istore 18
    //   1063: goto -659 -> 404
    //   1066: iconst_0
    //   1067: istore 18
    //   1069: goto -614 -> 455
    //   1072: iconst_0
    //   1073: istore 18
    //   1075: goto -569 -> 506
    //   1078: iconst_0
    //   1079: istore 18
    //   1081: goto -518 -> 563
    //   1084: astore_0
    //   1085: ldc_w 1168
    //   1088: new 189	java/lang/StringBuilder
    //   1091: dup
    //   1092: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   1095: ldc_w 1170
    //   1098: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1101: aload_0
    //   1102: invokevirtual 1171	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1105: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1108: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1111: invokestatic 419	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1114: goto -505 -> 609
    //   1117: iconst_0
    //   1118: istore 6
    //   1120: goto -433 -> 687
    //   1123: iconst_0
    //   1124: istore 18
    //   1126: goto +2076 -> 3202
    //   1129: iconst_0
    //   1130: istore 19
    //   1132: goto -315 -> 817
    //   1135: astore_0
    //   1136: iconst_1
    //   1137: istore 18
    //   1139: iconst_0
    //   1140: istore 5
    //   1142: ldc_w 381
    //   1145: astore_0
    //   1146: iload 8
    //   1148: istore 7
    //   1150: iload 6
    //   1152: istore 8
    //   1154: aload 27
    //   1156: astore 28
    //   1158: iload 7
    //   1160: istore 6
    //   1162: iconst_1
    //   1163: istore 19
    //   1165: aload_0
    //   1166: astore 27
    //   1168: iload 8
    //   1170: istore 7
    //   1172: aload 28
    //   1174: astore_0
    //   1175: goto -338 -> 837
    //   1178: astore 28
    //   1180: iconst_0
    //   1181: istore 8
    //   1183: goto -336 -> 847
    //   1186: astore_0
    //   1187: aload 28
    //   1189: monitorexit
    //   1190: aload_0
    //   1191: athrow
    //   1192: aload 30
    //   1194: sipush -210
    //   1197: invokevirtual 595	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   1200: goto -223 -> 977
    //   1203: iconst_0
    //   1204: istore_3
    //   1205: goto -216 -> 989
    //   1208: iload 18
    //   1210: ifne +10 -> 1220
    //   1213: aload 30
    //   1215: iload 18
    //   1217: invokevirtual 1174	com/tencent/smtt/sdk/TbsDownloadConfig:setTbsCoreLoadRenameFileLockEnable	(Z)V
    //   1220: iload 19
    //   1222: ifne +10 -> 1232
    //   1225: aload 30
    //   1227: iload 19
    //   1229: invokevirtual 1177	com/tencent/smtt/sdk/TbsDownloadConfig:setTbsCoreLoadRenameFileLockWaitEnable	(Z)V
    //   1232: iload 8
    //   1234: iconst_1
    //   1235: if_icmpne +9 -> 1244
    //   1238: getstatic 125	com/tencent/smtt/sdk/TbsDownloader:sAppContext	Landroid/content/Context;
    //   1241: invokestatic 1180	com/tencent/smtt/sdk/QbSdk:resetDecoupleCore	(Landroid/content/Context;)V
    //   1244: iload 6
    //   1246: iconst_1
    //   1247: if_icmpne +22 -> 1269
    //   1250: getstatic 503	com/tencent/smtt/sdk/TbsDownloader:sTbsDownloaderHandler	Landroid/os/Handler;
    //   1253: bipush 104
    //   1255: invokevirtual 619	android/os/Handler:removeMessages	(I)V
    //   1258: getstatic 503	com/tencent/smtt/sdk/TbsDownloader:sTbsDownloaderHandler	Landroid/os/Handler;
    //   1261: bipush 104
    //   1263: invokestatic 625	android/os/Message:obtain	(Landroid/os/Handler;I)Landroid/os/Message;
    //   1266: invokevirtual 628	android/os/Message:sendToTarget	()V
    //   1269: iload 17
    //   1271: iconst_1
    //   1272: if_icmpne +1907 -> 3179
    //   1275: lload 21
    //   1277: ldc2_w 1181
    //   1280: lcmp
    //   1281: ifle +1906 -> 3187
    //   1284: ldc2_w 1181
    //   1287: lstore 21
    //   1289: lload 21
    //   1291: lconst_0
    //   1292: lcmp
    //   1293: ifle +1886 -> 3179
    //   1296: invokestatic 1184	com/tencent/smtt/sdk/TbsDownloader:getRetryIntervalInSeconds	()J
    //   1299: lconst_0
    //   1300: lcmp
    //   1301: iflt +8 -> 1309
    //   1304: invokestatic 1184	com/tencent/smtt/sdk/TbsDownloader:getRetryIntervalInSeconds	()J
    //   1307: lstore 21
    //   1309: aload 30
    //   1311: getfield 918	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1314: ldc_w 1186
    //   1317: lload 21
    //   1319: invokestatic 1191	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1322: invokeinterface 565 3 0
    //   1327: pop
    //   1328: iconst_0
    //   1329: istore 5
    //   1331: iconst_0
    //   1332: istore 6
    //   1334: iload_2
    //   1335: ifeq +261 -> 1596
    //   1338: aload 31
    //   1340: ldc_w 1193
    //   1343: invokevirtual 1043	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1346: istore 7
    //   1348: iload 7
    //   1350: istore 5
    //   1352: getstatic 125	com/tencent/smtt/sdk/TbsDownloader:sAppContext	Landroid/content/Context;
    //   1355: invokestatic 222	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1358: getfield 439	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   1361: ldc_w 508
    //   1364: iconst_0
    //   1365: invokeinterface 512 3 0
    //   1370: istore 7
    //   1372: iload 7
    //   1374: istore 6
    //   1376: iload 5
    //   1378: istore 7
    //   1380: iload_2
    //   1381: ifeq +36 -> 1417
    //   1384: iload 5
    //   1386: istore 7
    //   1388: getstatic 125	com/tencent/smtt/sdk/TbsDownloader:sAppContext	Landroid/content/Context;
    //   1391: invokestatic 429	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   1394: ifne +23 -> 1417
    //   1397: iload 5
    //   1399: istore 7
    //   1401: iload 5
    //   1403: ifne +14 -> 1417
    //   1406: invokestatic 143	com/tencent/smtt/sdk/TbsInstaller:getInstance	()Lcom/tencent/smtt/sdk/TbsInstaller;
    //   1409: getstatic 125	com/tencent/smtt/sdk/TbsDownloader:sAppContext	Landroid/content/Context;
    //   1412: invokevirtual 306	com/tencent/smtt/sdk/TbsInstaller:getTbsCoreShareDecoupleCoreVersion	(Landroid/content/Context;)I
    //   1415: istore 7
    //   1417: ldc 23
    //   1419: new 189	java/lang/StringBuilder
    //   1422: dup
    //   1423: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   1426: ldc_w 1195
    //   1429: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1432: iload 7
    //   1434: invokevirtual 656	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1437: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1440: invokestatic 419	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1443: aload 30
    //   1445: getfield 918	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1448: ldc_w 680
    //   1451: iload 7
    //   1453: invokestatic 560	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1456: invokeinterface 565 3 0
    //   1461: pop
    //   1462: aload 30
    //   1464: getfield 918	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1467: ldc_w 508
    //   1470: iload 6
    //   1472: invokestatic 560	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1475: invokeinterface 565 3 0
    //   1480: pop
    //   1481: getstatic 125	com/tencent/smtt/sdk/TbsDownloader:sAppContext	Landroid/content/Context;
    //   1484: invokestatic 429	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   1487: ifne +46 -> 1533
    //   1490: iload 7
    //   1492: ifle +131 -> 1623
    //   1495: iload 7
    //   1497: invokestatic 143	com/tencent/smtt/sdk/TbsInstaller:getInstance	()Lcom/tencent/smtt/sdk/TbsInstaller;
    //   1500: getstatic 125	com/tencent/smtt/sdk/TbsDownloader:sAppContext	Landroid/content/Context;
    //   1503: invokevirtual 306	com/tencent/smtt/sdk/TbsInstaller:getTbsCoreShareDecoupleCoreVersion	(Landroid/content/Context;)I
    //   1506: if_icmpeq +117 -> 1623
    //   1509: iload 7
    //   1511: invokestatic 143	com/tencent/smtt/sdk/TbsInstaller:getInstance	()Lcom/tencent/smtt/sdk/TbsInstaller;
    //   1514: getstatic 125	com/tencent/smtt/sdk/TbsDownloader:sAppContext	Landroid/content/Context;
    //   1517: invokevirtual 764	com/tencent/smtt/sdk/TbsInstaller:getTbsCoreInstalledVerInNolock	(Landroid/content/Context;)I
    //   1520: if_icmpne +103 -> 1623
    //   1523: invokestatic 143	com/tencent/smtt/sdk/TbsInstaller:getInstance	()Lcom/tencent/smtt/sdk/TbsInstaller;
    //   1526: getstatic 125	com/tencent/smtt/sdk/TbsDownloader:sAppContext	Landroid/content/Context;
    //   1529: invokevirtual 1198	com/tencent/smtt/sdk/TbsInstaller:coreShareCopyToDecouple	(Landroid/content/Context;)Z
    //   1532: pop
    //   1533: aload 32
    //   1535: invokestatic 319	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1538: ifeq +110 -> 1648
    //   1541: getstatic 125	com/tencent/smtt/sdk/TbsDownloader:sAppContext	Landroid/content/Context;
    //   1544: invokestatic 429	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   1547: ifeq +101 -> 1648
    //   1550: aload 30
    //   1552: getfield 918	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1555: ldc_w 633
    //   1558: iconst_0
    //   1559: invokestatic 1201	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1562: invokeinterface 565 3 0
    //   1567: pop
    //   1568: aload 30
    //   1570: invokevirtual 922	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1573: iload_2
    //   1574: ifeq +12 -> 1586
    //   1577: getstatic 125	com/tencent/smtt/sdk/TbsDownloader:sAppContext	Landroid/content/Context;
    //   1580: iload 11
    //   1582: iconst_0
    //   1583: invokestatic 1205	com/tencent/smtt/sdk/TbsShareManager:writeCoreInfoForThirdPartyApp	(Landroid/content/Context;IZ)V
    //   1586: ldc 23
    //   1588: ldc_w 1207
    //   1591: invokestatic 419	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1594: iconst_0
    //   1595: ireturn
    //   1596: getstatic 125	com/tencent/smtt/sdk/TbsDownloader:sAppContext	Landroid/content/Context;
    //   1599: invokestatic 222	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1602: getfield 439	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   1605: ldc_w 680
    //   1608: iconst_0
    //   1609: invokeinterface 512 3 0
    //   1614: istore 7
    //   1616: iload 7
    //   1618: istore 5
    //   1620: goto -268 -> 1352
    //   1623: iload 7
    //   1625: ifne -92 -> 1533
    //   1628: invokestatic 143	com/tencent/smtt/sdk/TbsInstaller:getInstance	()Lcom/tencent/smtt/sdk/TbsInstaller;
    //   1631: getstatic 125	com/tencent/smtt/sdk/TbsDownloader:sAppContext	Landroid/content/Context;
    //   1634: invokevirtual 1211	com/tencent/smtt/sdk/TbsInstaller:getCoreShareDecoupleDir	(Landroid/content/Context;)Ljava/io/File;
    //   1637: invokestatic 1215	com/tencent/smtt/utils/FileUtil:delete	(Ljava/io/File;)V
    //   1640: goto -107 -> 1533
    //   1643: astore 27
    //   1645: goto -112 -> 1533
    //   1648: ldc 23
    //   1650: new 189	java/lang/StringBuilder
    //   1653: dup
    //   1654: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   1657: ldc_w 1217
    //   1660: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1663: iload 12
    //   1665: invokevirtual 656	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1668: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1671: invokestatic 419	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1674: iload 12
    //   1676: ifne +122 -> 1798
    //   1679: aload 30
    //   1681: getfield 918	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1684: ldc_w 1219
    //   1687: iload 12
    //   1689: invokestatic 560	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1692: invokeinterface 565 3 0
    //   1697: pop
    //   1698: aload 30
    //   1700: getfield 918	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1703: ldc_w 633
    //   1706: iconst_0
    //   1707: invokestatic 1201	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1710: invokeinterface 565 3 0
    //   1715: pop
    //   1716: iload_2
    //   1717: ifeq +50 -> 1767
    //   1720: aload 30
    //   1722: getfield 918	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1725: ldc_w 1221
    //   1728: bipush 145
    //   1730: invokestatic 560	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1733: invokeinterface 565 3 0
    //   1738: pop
    //   1739: aload 30
    //   1741: invokevirtual 922	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1744: getstatic 125	com/tencent/smtt/sdk/TbsDownloader:sAppContext	Landroid/content/Context;
    //   1747: invokestatic 429	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   1750: ifne +7 -> 1757
    //   1753: invokestatic 1224	com/tencent/smtt/sdk/TbsDownloader:startDecoupleCoreIfNeeded	()Z
    //   1756: pop
    //   1757: ldc 23
    //   1759: ldc_w 1226
    //   1762: invokestatic 419	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1765: iconst_0
    //   1766: ireturn
    //   1767: aload 30
    //   1769: getfield 918	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1772: ldc_w 1221
    //   1775: sipush -211
    //   1778: invokestatic 560	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1781: invokeinterface 565 3 0
    //   1786: pop
    //   1787: aload 30
    //   1789: sipush -211
    //   1792: invokevirtual 595	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   1795: goto -56 -> 1739
    //   1798: getstatic 125	com/tencent/smtt/sdk/TbsDownloader:sAppContext	Landroid/content/Context;
    //   1801: invokestatic 222	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1804: getfield 439	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   1807: ldc_w 682
    //   1810: iconst_0
    //   1811: invokeinterface 512 3 0
    //   1816: istore 8
    //   1818: iload 8
    //   1820: iload 11
    //   1822: if_icmple +18 -> 1840
    //   1825: getstatic 129	com/tencent/smtt/sdk/TbsDownloader:sTbsApkDownloader	Lcom/tencent/smtt/sdk/TbsApkDownloader;
    //   1828: invokevirtual 1229	com/tencent/smtt/sdk/TbsApkDownloader:clearCache	()V
    //   1831: invokestatic 143	com/tencent/smtt/sdk/TbsInstaller:getInstance	()Lcom/tencent/smtt/sdk/TbsInstaller;
    //   1834: getstatic 125	com/tencent/smtt/sdk/TbsDownloader:sAppContext	Landroid/content/Context;
    //   1837: invokevirtual 1232	com/tencent/smtt/sdk/TbsInstaller:cleanStatusAndTmpDir	(Landroid/content/Context;)V
    //   1840: iconst_0
    //   1841: istore 5
    //   1843: iconst_0
    //   1844: istore 7
    //   1846: getstatic 125	com/tencent/smtt/sdk/TbsDownloader:sAppContext	Landroid/content/Context;
    //   1849: invokestatic 429	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   1852: ifne +66 -> 1918
    //   1855: invokestatic 143	com/tencent/smtt/sdk/TbsInstaller:getInstance	()Lcom/tencent/smtt/sdk/TbsInstaller;
    //   1858: getstatic 125	com/tencent/smtt/sdk/TbsDownloader:sAppContext	Landroid/content/Context;
    //   1861: iconst_0
    //   1862: invokevirtual 1236	com/tencent/smtt/sdk/TbsInstaller:getTbsVersion	(Landroid/content/Context;I)I
    //   1865: istore 9
    //   1867: iload 7
    //   1869: istore 5
    //   1871: iload 9
    //   1873: iload 11
    //   1875: if_icmplt +6 -> 1881
    //   1878: iconst_1
    //   1879: istore 5
    //   1881: ldc 23
    //   1883: new 189	java/lang/StringBuilder
    //   1886: dup
    //   1887: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   1890: ldc_w 1238
    //   1893: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1896: iload 9
    //   1898: invokevirtual 656	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1901: ldc_w 1240
    //   1904: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1907: iload 11
    //   1909: invokevirtual 656	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1912: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1915: invokestatic 419	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1918: iload_1
    //   1919: iload 11
    //   1921: if_icmpge +16 -> 1937
    //   1924: aload 32
    //   1926: invokestatic 319	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1929: ifne +8 -> 1937
    //   1932: iload 5
    //   1934: ifeq +274 -> 2208
    //   1937: iload 6
    //   1939: iconst_1
    //   1940: if_icmpeq +268 -> 2208
    //   1943: aload 30
    //   1945: getfield 918	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1948: ldc_w 633
    //   1951: iconst_0
    //   1952: invokestatic 1201	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1955: invokeinterface 565 3 0
    //   1960: pop
    //   1961: iload_2
    //   1962: ifeq +172 -> 2134
    //   1965: aload 32
    //   1967: invokestatic 319	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1970: ifeq +87 -> 2057
    //   1973: aload 30
    //   1975: getfield 918	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1978: ldc_w 1221
    //   1981: bipush 132
    //   1983: invokestatic 560	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1986: invokeinterface 565 3 0
    //   1991: pop
    //   1992: aload 30
    //   1994: invokevirtual 922	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1997: ldc 23
    //   1999: new 189	java/lang/StringBuilder
    //   2002: dup
    //   2003: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   2006: ldc_w 1242
    //   2009: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2012: iload_1
    //   2013: invokevirtual 656	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2016: ldc_w 1244
    //   2019: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2022: iload 11
    //   2024: invokevirtual 656	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2027: ldc_w 1246
    //   2030: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2033: iload 8
    //   2035: invokevirtual 656	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2038: ldc_w 1248
    //   2041: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2044: aload 32
    //   2046: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2049: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2052: invokestatic 419	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2055: iconst_0
    //   2056: ireturn
    //   2057: iload 11
    //   2059: ifgt +25 -> 2084
    //   2062: aload 30
    //   2064: getfield 918	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2067: ldc_w 1221
    //   2070: bipush 131
    //   2072: invokestatic 560	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2075: invokeinterface 565 3 0
    //   2080: pop
    //   2081: goto -89 -> 1992
    //   2084: iload_1
    //   2085: iload 11
    //   2087: if_icmplt +25 -> 2112
    //   2090: aload 30
    //   2092: getfield 918	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2095: ldc_w 1221
    //   2098: bipush 129
    //   2100: invokestatic 560	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2103: invokeinterface 565 3 0
    //   2108: pop
    //   2109: goto -117 -> 1992
    //   2112: aload 30
    //   2114: getfield 918	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2117: ldc_w 1221
    //   2120: bipush 144
    //   2122: invokestatic 560	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2125: invokeinterface 565 3 0
    //   2130: pop
    //   2131: goto -139 -> 1992
    //   2134: sipush -212
    //   2137: istore 5
    //   2139: aload 32
    //   2141: invokestatic 319	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2144: ifeq +37 -> 2181
    //   2147: sipush -217
    //   2150: istore 5
    //   2152: aload 30
    //   2154: getfield 918	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2157: ldc_w 1221
    //   2160: iload 5
    //   2162: invokestatic 560	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2165: invokeinterface 565 3 0
    //   2170: pop
    //   2171: aload 30
    //   2173: iload 5
    //   2175: invokevirtual 595	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   2178: goto -186 -> 1992
    //   2181: iload 11
    //   2183: ifgt +11 -> 2194
    //   2186: sipush -218
    //   2189: istore 5
    //   2191: goto -39 -> 2152
    //   2194: iload_1
    //   2195: iload 11
    //   2197: if_icmplt -45 -> 2152
    //   2200: sipush -219
    //   2203: istore 5
    //   2205: goto -53 -> 2152
    //   2208: aload 32
    //   2210: aload 30
    //   2212: getfield 439	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   2215: ldc_w 1250
    //   2218: aconst_null
    //   2219: invokeinterface 687 3 0
    //   2224: invokevirtual 371	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2227: ifne +45 -> 2272
    //   2230: getstatic 129	com/tencent/smtt/sdk/TbsDownloader:sTbsApkDownloader	Lcom/tencent/smtt/sdk/TbsApkDownloader;
    //   2233: invokevirtual 1229	com/tencent/smtt/sdk/TbsApkDownloader:clearCache	()V
    //   2236: aload 30
    //   2238: getfield 918	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2241: ldc_w 814
    //   2244: iconst_0
    //   2245: invokestatic 560	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2248: invokeinterface 565 3 0
    //   2253: pop
    //   2254: aload 30
    //   2256: getfield 918	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2259: ldc_w 804
    //   2262: iconst_0
    //   2263: invokestatic 560	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2266: invokeinterface 565 3 0
    //   2271: pop
    //   2272: aload 30
    //   2274: getfield 918	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2277: ldc_w 682
    //   2280: iload 11
    //   2282: invokestatic 560	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2285: invokeinterface 565 3 0
    //   2290: pop
    //   2291: ldc 23
    //   2293: new 189	java/lang/StringBuilder
    //   2296: dup
    //   2297: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   2300: ldc_w 1252
    //   2303: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2306: iload 11
    //   2308: invokevirtual 656	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2311: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2314: invokestatic 419	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2317: iload 11
    //   2319: ifle +53 -> 2372
    //   2322: iload 6
    //   2324: iconst_1
    //   2325: if_icmpne +346 -> 2671
    //   2328: aload 30
    //   2330: getfield 918	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2333: ldc_w 1254
    //   2336: iconst_1
    //   2337: invokestatic 560	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2340: invokeinterface 565 3 0
    //   2345: pop
    //   2346: ldc 23
    //   2348: new 189	java/lang/StringBuilder
    //   2351: dup
    //   2352: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   2355: ldc_w 1256
    //   2358: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2361: iload 6
    //   2363: invokevirtual 656	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2366: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2369: invokestatic 419	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2372: aload 30
    //   2374: getfield 918	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2377: ldc_w 1250
    //   2380: aload 32
    //   2382: invokeinterface 565 3 0
    //   2387: pop
    //   2388: aload 30
    //   2390: getfield 918	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2393: ldc_w 1258
    //   2396: aload 33
    //   2398: invokeinterface 565 3 0
    //   2403: pop
    //   2404: aload 30
    //   2406: getfield 918	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2409: ldc_w 1219
    //   2412: iload 12
    //   2414: invokestatic 560	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2417: invokeinterface 565 3 0
    //   2422: pop
    //   2423: aload 30
    //   2425: getfield 918	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2428: ldc_w 1260
    //   2431: iload 13
    //   2433: invokestatic 560	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2436: invokeinterface 565 3 0
    //   2441: pop
    //   2442: aload 30
    //   2444: getfield 918	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2447: ldc_w 1262
    //   2450: iload 14
    //   2452: invokestatic 560	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2455: invokeinterface 565 3 0
    //   2460: pop
    //   2461: aload 30
    //   2463: getfield 918	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2466: ldc_w 1264
    //   2469: iload 15
    //   2471: invokestatic 560	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2474: invokeinterface 565 3 0
    //   2479: pop
    //   2480: aload 30
    //   2482: getfield 918	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2485: ldc_w 1266
    //   2488: iload 16
    //   2490: invokestatic 560	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2493: invokeinterface 565 3 0
    //   2498: pop
    //   2499: aload 30
    //   2501: getfield 918	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2504: ldc_w 1268
    //   2507: lload 23
    //   2509: invokestatic 1191	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2512: invokeinterface 565 3 0
    //   2517: pop
    //   2518: aload 30
    //   2520: getfield 918	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2523: ldc_w 1270
    //   2526: lload 25
    //   2528: invokestatic 1191	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2531: invokeinterface 565 3 0
    //   2536: pop
    //   2537: aload 30
    //   2539: invokevirtual 922	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2542: aload_0
    //   2543: ifnull +18 -> 2561
    //   2546: aload 30
    //   2548: getfield 918	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2551: ldc_w 1272
    //   2554: aload_0
    //   2555: invokeinterface 565 3 0
    //   2560: pop
    //   2561: iload_3
    //   2562: ifne +161 -> 2723
    //   2565: iload 4
    //   2567: ifeq +156 -> 2723
    //   2570: invokestatic 143	com/tencent/smtt/sdk/TbsInstaller:getInstance	()Lcom/tencent/smtt/sdk/TbsInstaller;
    //   2573: getstatic 125	com/tencent/smtt/sdk/TbsDownloader:sAppContext	Landroid/content/Context;
    //   2576: iload 11
    //   2578: invokevirtual 1275	com/tencent/smtt/sdk/TbsInstaller:installLocalTbsCore	(Landroid/content/Context;I)Z
    //   2581: ifeq +142 -> 2723
    //   2584: iload_2
    //   2585: ifeq +107 -> 2692
    //   2588: aload 30
    //   2590: getfield 918	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2593: ldc_w 1221
    //   2596: bipush 143
    //   2598: invokestatic 560	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2601: invokeinterface 565 3 0
    //   2606: pop
    //   2607: aload 30
    //   2609: getfield 918	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2612: ldc_w 633
    //   2615: iconst_0
    //   2616: invokestatic 1201	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2619: invokeinterface 565 3 0
    //   2624: pop
    //   2625: ldc 23
    //   2627: ldc_w 1277
    //   2630: invokestatic 419	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2633: aload 31
    //   2635: ldc_w 1279
    //   2638: iconst_0
    //   2639: invokevirtual 1082	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2642: iconst_1
    //   2643: if_icmpne +21 -> 2664
    //   2646: aload 30
    //   2648: getfield 918	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2651: ldc_w 1281
    //   2654: iconst_1
    //   2655: invokestatic 1201	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2658: invokeinterface 565 3 0
    //   2663: pop
    //   2664: aload 30
    //   2666: invokevirtual 922	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   2669: iconst_1
    //   2670: ireturn
    //   2671: aload 30
    //   2673: getfield 918	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2676: ldc_w 1254
    //   2679: iconst_0
    //   2680: invokestatic 560	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2683: invokeinterface 565 3 0
    //   2688: pop
    //   2689: goto -343 -> 2346
    //   2692: aload 30
    //   2694: getfield 918	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2697: ldc_w 1221
    //   2700: sipush -213
    //   2703: invokestatic 560	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2706: invokeinterface 565 3 0
    //   2711: pop
    //   2712: aload 30
    //   2714: sipush -213
    //   2717: invokevirtual 595	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   2720: goto -113 -> 2607
    //   2723: iload_3
    //   2724: ifne +155 -> 2879
    //   2727: iload 4
    //   2729: ifeq +150 -> 2879
    //   2732: getstatic 129	com/tencent/smtt/sdk/TbsDownloader:sTbsApkDownloader	Lcom/tencent/smtt/sdk/TbsApkDownloader;
    //   2735: astore_0
    //   2736: iload 12
    //   2738: iconst_1
    //   2739: if_icmpeq +9 -> 2748
    //   2742: iload 12
    //   2744: iconst_2
    //   2745: if_icmpne +112 -> 2857
    //   2748: iconst_1
    //   2749: istore 4
    //   2751: aload_0
    //   2752: iload_3
    //   2753: iload 4
    //   2755: invokevirtual 1285	com/tencent/smtt/sdk/TbsApkDownloader:installBackupTbsApk	(ZZ)Z
    //   2758: ifeq +121 -> 2879
    //   2761: aload 30
    //   2763: getfield 918	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2766: ldc_w 633
    //   2769: iconst_0
    //   2770: invokestatic 1201	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2773: invokeinterface 565 3 0
    //   2778: pop
    //   2779: getstatic 125	com/tencent/smtt/sdk/TbsDownloader:sAppContext	Landroid/content/Context;
    //   2782: invokestatic 230	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   2785: invokevirtual 742	com/tencent/smtt/sdk/TbsLogReport:tbsLogInfo	()Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   2788: astore_0
    //   2789: aload_0
    //   2790: bipush 100
    //   2792: invokevirtual 747	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setErrorCode	(I)V
    //   2795: aload_0
    //   2796: new 189	java/lang/StringBuilder
    //   2799: dup
    //   2800: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   2803: ldc_w 1287
    //   2806: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2809: getstatic 129	com/tencent/smtt/sdk/TbsDownloader:sTbsApkDownloader	Lcom/tencent/smtt/sdk/TbsApkDownloader;
    //   2812: getfield 1290	com/tencent/smtt/sdk/TbsApkDownloader:localInstallMessage	Ljava/lang/String;
    //   2815: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2818: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2821: invokevirtual 751	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setFailDetail	(Ljava/lang/String;)V
    //   2824: getstatic 125	com/tencent/smtt/sdk/TbsDownloader:sAppContext	Landroid/content/Context;
    //   2827: invokestatic 664	com/tencent/smtt/sdk/TbsDownloader:isDecoupleCore	(Landroid/content/Context;)Z
    //   2830: ifeq +33 -> 2863
    //   2833: getstatic 125	com/tencent/smtt/sdk/TbsDownloader:sAppContext	Landroid/content/Context;
    //   2836: invokestatic 230	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   2839: getstatic 1293	com/tencent/smtt/sdk/TbsLogReport$EventType:TYPE_DOWNLOAD_DECOUPLE	Lcom/tencent/smtt/sdk/TbsLogReport$EventType;
    //   2842: aload_0
    //   2843: invokevirtual 761	com/tencent/smtt/sdk/TbsLogReport:eventReport	(Lcom/tencent/smtt/sdk/TbsLogReport$EventType;Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;)V
    //   2846: ldc 23
    //   2848: ldc_w 1295
    //   2851: invokestatic 419	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2854: goto -221 -> 2633
    //   2857: iconst_0
    //   2858: istore 4
    //   2860: goto -109 -> 2751
    //   2863: getstatic 125	com/tencent/smtt/sdk/TbsDownloader:sAppContext	Landroid/content/Context;
    //   2866: invokestatic 230	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   2869: getstatic 757	com/tencent/smtt/sdk/TbsLogReport$EventType:TYPE_DOWNLOAD	Lcom/tencent/smtt/sdk/TbsLogReport$EventType;
    //   2872: aload_0
    //   2873: invokevirtual 761	com/tencent/smtt/sdk/TbsLogReport:eventReport	(Lcom/tencent/smtt/sdk/TbsLogReport$EventType;Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;)V
    //   2876: goto -30 -> 2846
    //   2879: getstatic 125	com/tencent/smtt/sdk/TbsDownloader:sAppContext	Landroid/content/Context;
    //   2882: invokestatic 222	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2885: getfield 439	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   2888: ldc_w 1254
    //   2891: iconst_0
    //   2892: invokeinterface 512 3 0
    //   2897: iconst_1
    //   2898: if_icmpne +124 -> 3022
    //   2901: getstatic 129	com/tencent/smtt/sdk/TbsDownloader:sTbsApkDownloader	Lcom/tencent/smtt/sdk/TbsApkDownloader;
    //   2904: invokevirtual 1298	com/tencent/smtt/sdk/TbsApkDownloader:verifyAndInstallDecoupleCoreFromBackup	()Z
    //   2907: ifeq +115 -> 3022
    //   2910: aload 30
    //   2912: getfield 918	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   2915: ldc_w 633
    //   2918: iconst_0
    //   2919: invokestatic 1201	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2922: invokeinterface 565 3 0
    //   2927: pop
    //   2928: getstatic 125	com/tencent/smtt/sdk/TbsDownloader:sAppContext	Landroid/content/Context;
    //   2931: invokestatic 230	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   2934: invokevirtual 742	com/tencent/smtt/sdk/TbsLogReport:tbsLogInfo	()Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;
    //   2937: astore_0
    //   2938: aload_0
    //   2939: bipush 100
    //   2941: invokevirtual 747	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setErrorCode	(I)V
    //   2944: aload_0
    //   2945: new 189	java/lang/StringBuilder
    //   2948: dup
    //   2949: invokespecial 190	java/lang/StringBuilder:<init>	()V
    //   2952: ldc_w 1300
    //   2955: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2958: getstatic 129	com/tencent/smtt/sdk/TbsDownloader:sTbsApkDownloader	Lcom/tencent/smtt/sdk/TbsApkDownloader;
    //   2961: getfield 1290	com/tencent/smtt/sdk/TbsApkDownloader:localInstallMessage	Ljava/lang/String;
    //   2964: invokevirtual 196	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2967: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2970: invokevirtual 751	com/tencent/smtt/sdk/TbsLogReport$TbsLogInfo:setFailDetail	(Ljava/lang/String;)V
    //   2973: getstatic 125	com/tencent/smtt/sdk/TbsDownloader:sAppContext	Landroid/content/Context;
    //   2976: invokestatic 664	com/tencent/smtt/sdk/TbsDownloader:isDecoupleCore	(Landroid/content/Context;)Z
    //   2979: ifeq +27 -> 3006
    //   2982: getstatic 125	com/tencent/smtt/sdk/TbsDownloader:sAppContext	Landroid/content/Context;
    //   2985: invokestatic 230	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   2988: getstatic 1293	com/tencent/smtt/sdk/TbsLogReport$EventType:TYPE_DOWNLOAD_DECOUPLE	Lcom/tencent/smtt/sdk/TbsLogReport$EventType;
    //   2991: aload_0
    //   2992: invokevirtual 761	com/tencent/smtt/sdk/TbsLogReport:eventReport	(Lcom/tencent/smtt/sdk/TbsLogReport$EventType;Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;)V
    //   2995: ldc 23
    //   2997: ldc_w 1302
    //   3000: invokestatic 419	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3003: goto -370 -> 2633
    //   3006: getstatic 125	com/tencent/smtt/sdk/TbsDownloader:sAppContext	Landroid/content/Context;
    //   3009: invokestatic 230	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   3012: getstatic 757	com/tencent/smtt/sdk/TbsLogReport$EventType:TYPE_DOWNLOAD	Lcom/tencent/smtt/sdk/TbsLogReport$EventType;
    //   3015: aload_0
    //   3016: invokevirtual 761	com/tencent/smtt/sdk/TbsLogReport:eventReport	(Lcom/tencent/smtt/sdk/TbsLogReport$EventType;Lcom/tencent/smtt/sdk/TbsLogReport$TbsLogInfo;)V
    //   3019: goto -24 -> 2995
    //   3022: iload_2
    //   3023: ifne +11 -> 3034
    //   3026: aload 30
    //   3028: sipush -216
    //   3031: invokevirtual 595	com/tencent/smtt/sdk/TbsDownloadConfig:setDownloadInterruptCode	(I)V
    //   3034: aload 30
    //   3036: getfield 918	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   3039: ldc_w 633
    //   3042: iconst_1
    //   3043: invokestatic 1201	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   3046: invokeinterface 565 3 0
    //   3051: pop
    //   3052: ldc 23
    //   3054: ldc_w 1304
    //   3057: invokestatic 419	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   3060: goto -427 -> 2633
    //   3063: astore 27
    //   3065: goto -1689 -> 1376
    //   3068: astore 27
    //   3070: goto -1718 -> 1352
    //   3073: astore 28
    //   3075: goto -2211 -> 864
    //   3078: astore 27
    //   3080: aload_0
    //   3081: astore 27
    //   3083: iconst_0
    //   3084: istore 5
    //   3086: ldc_w 381
    //   3089: astore_0
    //   3090: iconst_1
    //   3091: istore 18
    //   3093: iload 8
    //   3095: istore 7
    //   3097: goto -1947 -> 1150
    //   3100: astore 27
    //   3102: iload 5
    //   3104: istore 6
    //   3106: aload_0
    //   3107: astore 27
    //   3109: ldc_w 381
    //   3112: astore_0
    //   3113: iconst_1
    //   3114: istore 18
    //   3116: iconst_0
    //   3117: istore 5
    //   3119: iload 8
    //   3121: istore 7
    //   3123: goto -1973 -> 1150
    //   3126: astore 27
    //   3128: iload 5
    //   3130: istore 6
    //   3132: aload_0
    //   3133: astore 27
    //   3135: iconst_1
    //   3136: istore 18
    //   3138: iconst_0
    //   3139: istore 5
    //   3141: ldc_w 381
    //   3144: astore_0
    //   3145: goto -1995 -> 1150
    //   3148: astore 27
    //   3150: iload 19
    //   3152: istore 18
    //   3154: iload 5
    //   3156: istore 8
    //   3158: aload_0
    //   3159: astore 27
    //   3161: aload 28
    //   3163: astore_0
    //   3164: iload 6
    //   3166: istore 5
    //   3168: iload 8
    //   3170: istore 6
    //   3172: goto -2022 -> 1150
    //   3175: astore_0
    //   3176: goto -2876 -> 300
    //   3179: ldc2_w 1305
    //   3182: lstore 21
    //   3184: goto -1888 -> 1296
    //   3187: goto -1898 -> 1289
    //   3190: iconst_1
    //   3191: istore 19
    //   3193: goto -2376 -> 817
    //   3196: iconst_0
    //   3197: istore 6
    //   3199: goto -2512 -> 687
    //   3202: goto -2430 -> 772
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3205	0	paramString	String
    //   0	3205	1	paramInt	int
    //   0	3205	2	paramBoolean1	boolean
    //   0	3205	3	paramBoolean2	boolean
    //   0	3205	4	paramBoolean3	boolean
    //   101	3066	5	i	int
    //   294	2904	6	j	int
    //   656	2466	7	k	int
    //   616	2553	8	m	int
    //   823	1074	9	n	int
    //   858	3	10	i1	int
    //   199	2378	11	i2	int
    //   166	2580	12	i3	int
    //   209	2223	13	i4	int
    //   219	2232	14	i5	int
    //   229	2241	15	i6	int
    //   239	2250	16	i7	int
    //   281	992	17	i8	int
    //   365	2788	18	bool1	boolean
    //   697	2495	19	bool2	boolean
    //   619	133	20	bool3	boolean
    //   270	2913	21	l1	long
    //   249	2259	23	l2	long
    //   259	2268	25	l3	long
    //   356	811	27	localObject1	Object
    //   1643	1	27	localThrowable	Throwable
    //   3063	1	27	localException1	Exception
    //   3068	1	27	localException2	Exception
    //   3078	1	27	localException3	Exception
    //   3081	1	27	str1	String
    //   3100	1	27	localException4	Exception
    //   3107	1	27	str2	String
    //   3126	1	27	localException5	Exception
    //   3133	1	27	str3	String
    //   3148	1	27	localException6	Exception
    //   3159	1	27	str4	String
    //   693	480	28	localObject2	Object
    //   1178	10	28	localException7	Exception
    //   3073	89	28	localException8	Exception
    //   627	84	29	str5	String
    //   42	2993	30	localTbsDownloadConfig	TbsDownloadConfig
    //   91	2543	31	localJSONObject	JSONObject
    //   176	2205	32	str6	String
    //   189	2208	33	str7	String
    // Exception table:
    //   from	to	target	type
    //   338	358	1027	java/lang/Throwable
    //   367	379	1027	java/lang/Throwable
    //   383	394	1084	java/lang/Throwable
    //   404	445	1084	java/lang/Throwable
    //   455	496	1084	java/lang/Throwable
    //   506	552	1084	java/lang/Throwable
    //   563	609	1084	java/lang/Throwable
    //   629	638	1135	java/lang/Exception
    //   837	847	1178	java/lang/Exception
    //   877	894	1186	finally
    //   894	957	1186	finally
    //   957	960	1186	finally
    //   1187	1190	1186	finally
    //   1628	1640	1643	java/lang/Throwable
    //   1352	1372	3063	java/lang/Exception
    //   1338	1348	3068	java/lang/Exception
    //   1596	1616	3068	java/lang/Exception
    //   850	860	3073	java/lang/Exception
    //   638	648	3078	java/lang/Exception
    //   648	658	3100	java/lang/Exception
    //   658	679	3126	java/lang/Exception
    //   699	710	3148	java/lang/Exception
    //   718	728	3148	java/lang/Exception
    //   736	747	3148	java/lang/Exception
    //   755	766	3148	java/lang/Exception
    //   780	791	3148	java/lang/Exception
    //   799	809	3148	java/lang/Exception
    //   286	296	3175	java/lang/Exception
  }
  
  private static boolean sendRequest(boolean paramBoolean1, boolean paramBoolean2)
  {
    return sendRequest(paramBoolean1, paramBoolean2, false, true);
  }
  
  private static boolean sendRequest(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    Object localObject1;
    if (paramBoolean1)
    {
      localObject1 = TbsDownloadUpload.getInstance(sAppContext);
      ((TbsDownloadUpload)localObject1).mSyncMap.put("tbs_needdownload_code", Integer.valueOf(144));
      ((TbsDownloadUpload)localObject1).commit();
      if ((QbSdk.mSettings == null) || (!QbSdk.mSettings.containsKey(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD)) || (!QbSdk.mSettings.get(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD).equals("false"))) {
        break label204;
      }
      TbsLog.i("TbsDownload", "[TbsDownloader.sendRequest] -- SET_SENDREQUEST_AND_UPLOAD is false");
      if (!paramBoolean1) {
        break label164;
      }
      localObject1 = TbsDownloadUpload.getInstance(sAppContext);
      ((TbsDownloadUpload)localObject1).mSyncMap.put("tbs_needdownload_code", Integer.valueOf(145));
      ((TbsDownloadUpload)localObject1).commit();
    }
    for (;;)
    {
      return false;
      if (paramBoolean3) {
        break;
      }
      localObject1 = TbsDownloadUpload.getInstance(sAppContext);
      ((TbsDownloadUpload)localObject1).mSyncMap.put("tbs_startdownload_code", Integer.valueOf(164));
      ((TbsDownloadUpload)localObject1).commit();
      break;
      label164:
      if (!paramBoolean3)
      {
        localObject1 = TbsDownloadUpload.getInstance(sAppContext);
        ((TbsDownloadUpload)localObject1).mSyncMap.put("tbs_startdownload_code", Integer.valueOf(165));
        ((TbsDownloadUpload)localObject1).commit();
      }
    }
    label204:
    TbsLog.i("TbsDownload", "[TbsDownloader.sendRequest]isQuery: " + paramBoolean1 + " forDecoupleCore is " + paramBoolean3);
    if (TbsInstaller.getInstance().isTbsLocalInstalled(sAppContext))
    {
      TbsLog.i("TbsDownload", "[TbsDownloader.sendRequest] -- isTbsLocalInstalled!");
      if (paramBoolean1)
      {
        localObject1 = TbsDownloadUpload.getInstance(sAppContext);
        ((TbsDownloadUpload)localObject1).mSyncMap.put("tbs_needdownload_code", Integer.valueOf(146));
        ((TbsDownloadUpload)localObject1).commit();
      }
      for (;;)
      {
        return false;
        if (!paramBoolean3)
        {
          localObject1 = TbsDownloadUpload.getInstance(sAppContext);
          ((TbsDownloadUpload)localObject1).mSyncMap.put("tbs_startdownload_code", Integer.valueOf(166));
          ((TbsDownloadUpload)localObject1).commit();
        }
      }
    }
    TbsDownloadConfig localTbsDownloadConfig = TbsDownloadConfig.getInstance(sAppContext);
    Object localObject2 = FileUtil.getTBSSdcardFilePath(sAppContext, 1);
    if (getOverSea(sAppContext)) {
      localObject1 = "x5.oversea.tbs.org";
    }
    for (;;)
    {
      localObject2 = new File((String)localObject2, (String)localObject1);
      Object localObject3 = FileUtil.getTBSSdcardFilePath(sAppContext, 2);
      label403:
      label438:
      label473:
      label510:
      int j;
      if (getOverSea(sAppContext))
      {
        localObject1 = "x5.oversea.tbs.org";
        localObject3 = new File((String)localObject3, (String)localObject1);
        Object localObject4 = FileUtil.getTBSSdcardFilePath(sAppContext, 3);
        if (!getOverSea(sAppContext)) {
          break label1008;
        }
        localObject1 = "x5.oversea.tbs.org";
        localObject4 = new File((String)localObject4, (String)localObject1);
        String str2 = FileUtil.getTBSSdcardFilePath(sAppContext, 4);
        if (!getOverSea(sAppContext)) {
          break label1017;
        }
        localObject1 = "x5.oversea.tbs.org";
        localObject1 = new File(str2, (String)localObject1);
        if (!((File)localObject1).exists())
        {
          if (!((File)localObject4).exists()) {
            break label1026;
          }
          ((File)localObject4).renameTo((File)localObject1);
        }
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
      try
      {
        localObject2 = Pattern.compile("i686|mips|x86_64").matcher(sCpuabi);
        localObject1 = localObject2;
      }
      catch (Exception localException2)
      {
        label580:
        break label580;
      }
      int i = j;
      if (localObject1 != null)
      {
        i = j;
        if (((Matcher)localObject1).find())
        {
          if (!TbsShareManager.isThirdPartyApp(sAppContext)) {
            break label1083;
          }
          TbsLog.e("TbsDownload", "don't support x86 devices,skip send request");
          localObject1 = TbsLogReport.getInstance(sAppContext).tbsLogInfo();
          if (!paramBoolean1) {
            break label1064;
          }
          localTbsDownloadConfig.setDownloadInterruptCode(-104);
          ((TbsLogReport.TbsLogInfo)localObject1).setErrorCode(-104);
          label647:
          ((TbsLogReport.TbsLogInfo)localObject1).setFailDetail("mycpu is " + sCpuabi);
          TbsLogReport.getInstance(sAppContext).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, (TbsLogReport.TbsLogInfo)localObject1);
          label688:
          i = 1;
        }
      }
      localTbsDownloadConfig.mSyncMap.put("app_versionname", AppUtil.getAppVersionName(sAppContext));
      localTbsDownloadConfig.mSyncMap.put("app_versioncode", Integer.valueOf(AppUtil.getAppVersionCode(sAppContext)));
      localTbsDownloadConfig.commit();
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
            localTbsDownloadConfig.mSyncMap.put("request_fail", Long.valueOf(l2));
            localTbsDownloadConfig.mSyncMap.put("app_versionname", AppUtil.getAppVersionName(sAppContext));
            localTbsDownloadConfig.mSyncMap.put("app_versioncode", Integer.valueOf(AppUtil.getAppVersionCode(sAppContext)));
            localTbsDownloadConfig.mSyncMap.put("app_metadata", AppUtil.getAppMetadata(sAppContext, "com.tencent.mm.BuildInfo.CLIENT_VERSION"));
            localTbsDownloadConfig.commit();
            if (i == 0) {
              break label1162;
            }
            if (!paramBoolean1) {
              break label1122;
            }
            localObject1 = TbsDownloadUpload.getInstance(sAppContext);
            ((TbsDownloadUpload)localObject1).mSyncMap.put("tbs_needdownload_code", Integer.valueOf(147));
            ((TbsDownloadUpload)localObject1).commit();
            return false;
            localObject1 = getBackupFileName(false);
            continue;
            localObject1 = getBackupFileName(false);
            break label403;
            label1008:
            localObject1 = getBackupFileName(false);
            break label438;
            label1017:
            localObject1 = getBackupFileName(false);
            break label473;
            label1026:
            if (((File)localObject3).exists())
            {
              ((File)localObject3).renameTo((File)localObject1);
              break label510;
            }
            if (!((File)localObject2).exists()) {
              break label510;
            }
            ((File)localObject2).renameTo((File)localObject1);
            break label510;
            label1064:
            localTbsDownloadConfig.setDownloadInterruptCode(-205);
            ((TbsLogReport.TbsLogInfo)localObject1).setErrorCode(-205);
            break label647;
            label1083:
            if (paramBoolean1)
            {
              localTbsDownloadConfig.setDownloadInterruptCode(-104);
              break label688;
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
          continue;
          label1122:
          if (!paramBoolean3)
          {
            localObject1 = TbsDownloadUpload.getInstance(sAppContext);
            ((TbsDownloadUpload)localObject1).mSyncMap.put("tbs_startdownload_code", Integer.valueOf(167));
            ((TbsDownloadUpload)localObject1).commit();
          }
        }
        label1162:
        if ((j != -1) || (paramBoolean3))
        {
          try
          {
            String str1 = TbsCommonConfig.getInstance(sAppContext).getTbsDownloaderPostUrl();
            TbsLog.i("TbsDownload", "[TbsDownloader.sendRequest] postUrl=" + str1);
            if (paramBoolean1)
            {
              localObject3 = TbsDownloadUpload.getInstance(sAppContext);
              ((TbsDownloadUpload)localObject3).mSyncMap.put("tbs_needdownload_code", Integer.valueOf(148));
              ((TbsDownloadUpload)localObject3).mSyncMap.put("tbs_needdownload_sent", Integer.valueOf(1));
              ((TbsDownloadUpload)localObject3).commit();
              TbsLog.i("TbsDownload", "sendRequest query 148");
            }
            for (;;)
            {
              return readResponse(HttpUtil.postData(str1, ((JSONObject)localObject1).toString().getBytes("utf-8"), new TbsDownloader.2(localTbsDownloadConfig, paramBoolean1), false), j, paramBoolean1, paramBoolean2, paramBoolean4);
              if (!paramBoolean3)
              {
                localObject3 = TbsDownloadUpload.getInstance(sAppContext);
                ((TbsDownloadUpload)localObject3).mSyncMap.put("tbs_startdownload_code", Integer.valueOf(168));
                ((TbsDownloadUpload)localObject3).mSyncMap.put("tbs_startdownload_sent", Integer.valueOf(1));
                ((TbsDownloadUpload)localObject3).commit();
                TbsLog.i("TbsDownload", "sendRequest download 168");
              }
            }
            localTbsDownloadConfig.setDownloadInterruptCode(-106);
          }
          catch (Throwable localThrowable)
          {
            localThrowable.printStackTrace();
            if (!paramBoolean1) {}
          }
          for (;;)
          {
            return false;
            localTbsDownloadConfig.setDownloadInterruptCode(-206);
          }
        }
        TbsDownloadUpload localTbsDownloadUpload;
        if (paramBoolean1)
        {
          localTbsDownloadUpload = TbsDownloadUpload.getInstance(sAppContext);
          localTbsDownloadUpload.mSyncMap.put("tbs_needdownload_code", Integer.valueOf(149));
          localTbsDownloadUpload.commit();
          return false;
        }
        if (!paramBoolean3)
        {
          localTbsDownloadUpload = TbsDownloadUpload.getInstance(sAppContext);
          localTbsDownloadUpload.mSyncMap.put("tbs_startdownload_code", Integer.valueOf(169));
          localTbsDownloadUpload.commit();
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
  
  public static void setAppContext(Context paramContext)
  {
    if ((paramContext != null) && (paramContext.getApplicationContext() != null)) {
      sAppContext = paramContext.getApplicationContext();
    }
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
  
  private static boolean shouldDoNeedDownload(Context paramContext, boolean paramBoolean)
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
        TbsLog.e("TbsDownload", "can not support x86 devices!!");
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
      } while ((isDecoupleCore(sAppContext)) || (sTbsDownloaderHandler == null));
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
      TbsDownloadUpload localTbsDownloadUpload;
      try
      {
        localTbsDownloadUpload = TbsDownloadUpload.getInstance(paramContext);
        localTbsDownloadUpload.mSyncMap.put("tbs_startdownload_code", Integer.valueOf(160));
        localTbsDownloadUpload.commit();
        TbsLog.i("TbsDownload", "[TbsDownloader.startDownload] sAppContext=" + sAppContext);
        if (TbsInstaller.isStaticTbsInstalling)
        {
          localTbsDownloadUpload.mSyncMap.put("tbs_startdownload_code", Integer.valueOf(161));
          localTbsDownloadUpload.commit();
          return;
        }
        mIsDownloading = true;
        sAppContext = paramContext.getApplicationContext();
        TbsDownloadConfig.getInstance(sAppContext).setDownloadInterruptCode(-200);
        if (Build.VERSION.SDK_INT < 8)
        {
          QbSdk.mTbsListenerWrapper.onDownloadFinish(110);
          TbsDownloadConfig.getInstance(sAppContext).setDownloadInterruptCode(-201);
          localTbsDownloadUpload.mSyncMap.put("tbs_startdownload_code", Integer.valueOf(162));
          localTbsDownloadUpload.commit();
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
      localTbsDownloadUpload.mSyncMap.put("tbs_startdownload_code", Integer.valueOf(163));
      localTbsDownloadUpload.commit();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsDownloader
 * JD-Core Version:    0.7.0.1
 */