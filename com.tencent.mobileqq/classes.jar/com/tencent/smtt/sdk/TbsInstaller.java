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
import com.tencent.smtt.utils.AppUtil;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.nio.channels.FileLock;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class TbsInstaller
{
  private static final String APK_FOLDER = "tbs_apk";
  static final String APP_DEMO = "com.tencent.tbs";
  static final String APP_DEMO_TEST = "com.tencent.mtt.sdk.test";
  static final String APP_QB = "com.tencent.mtt";
  static final String APP_QQ = "com.tencent.mobileqq";
  static final String APP_QQPIMSECURE = "com.tencent.qqpimsecure";
  static final String APP_QZONE = "com.qzone";
  static final String APP_WX = "com.tencent.mm";
  static final String BACKUP_TBSCORE_FOLDER_NAME = "core_share_backup";
  static final int COPY_STATUS_FAIL = 2;
  static final int COPY_STATUS_START = 0;
  static final int COPY_STATUS_SUCCESS = 1;
  static final int COPY_STATUS_UNKNOWN = -1;
  static final int COPY_STATUS_WILLUSE = 3;
  private static final String DEFAULT_MAX_SUPPORTED_API_LEVEL = "23";
  private static final String DEFAULT_MIN_SUPPORTED_API_LEVEL = "8";
  private static final String DEMO_SIG = "3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a";
  static final int INCRUPDATE_STATUS_PATCH_SUCCESS = 1;
  static final int INCRUPDATE_STATUS_UNKNOW = -1;
  static final int INSTALL_STATUS_CANNOTUSE = 5;
  static final int INSTALL_STATUS_DEXOPT = 1;
  static final int INSTALL_STATUS_RENAME = 2;
  static final int INSTALL_STATUS_UNKNOWN = -1;
  static final int INSTALL_STATUS_UNZIP = 0;
  static final int INSTALL_STATUS_USING = 4;
  static final int INSTALL_STATUS_WILLUSE = 3;
  static final String KEY_BACKUP_FILE_LOCATION = "backup_apk";
  static final String KEY_DIFF_FILE_LOCATION = "diff_file_location";
  static final String KEY_NEW_APK_LOCATION = "new_apk_location";
  static final String KEY_NEW_CORE_VERSION = "new_core_ver";
  static final String KEY_OLD_APK_LOCATION = "old_apk_location";
  static final String KEY_OLD_CORE_VERSION = "old_core_ver";
  static final String KEY_OPERATION = "operation";
  private static final String KEY_PATCH_APK_PATH = "apk_path";
  private static final String KEY_PATCH_RESULT = "patch_result";
  private static final String KEY_PATCH_TBSCORE_VER = "tbs_core_ver";
  private static final String LAST_APP_ID_FOR_STATIC_TBS = "last_app_id_for_static_tbs";
  private static final String MD5_FILE = "1";
  private static final String MISC_CALL_UNLZMA = "unlzma";
  private static final String MM_SIG = "308202eb30820254a00302010202044d36f7a4300d06092a864886f70d01010505003081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e74301e170d3131303131393134333933325a170d3431303131313134333933325a3081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e7430819f300d06092a864886f70d010101050003818d0030818902818100c05f34b231b083fb1323670bfbe7bdab40c0c0a6efc87ef2072a1ff0d60cc67c8edb0d0847f210bea6cbfaa241be70c86daf56be08b723c859e52428a064555d80db448cdcacc1aea2501eba06f8bad12a4fa49d85cacd7abeb68945a5cb5e061629b52e3254c373550ee4e40cb7c8ae6f7a8151ccd8df582d446f39ae0c5e930203010001300d06092a864886f70d0101050500038181009c8d9d7f2f908c42081b4c764c377109a8b2c70582422125ce545842d5f520aea69550b6bd8bfd94e987b75a3077eb04ad341f481aac266e89d3864456e69fba13df018acdc168b9a19dfd7ad9d9cc6f6ace57c746515f71234df3a053e33ba93ece5cd0fc15f3e389a3f365588a9fcb439e069d3629cd7732a13fff7b891499";
  private static final String MOBILEQQ_SIG = "30820253308201bca00302010202044bbb0361300d06092a864886f70d0101050500306d310e300c060355040613054368696e61310f300d06035504080c06e58c97e4baac310f300d06035504070c06e58c97e4baac310f300d060355040a0c06e885bee8aeaf311b3019060355040b0c12e697a0e7babfe4b89ae58aa1e7b3bbe7bb9f310b30090603550403130251513020170d3130303430363039343831375a180f32323834303132303039343831375a306d310e300c060355040613054368696e61310f300d06035504080c06e58c97e4baac310f300d06035504070c06e58c97e4baac310f300d060355040a0c06e885bee8aeaf311b3019060355040b0c12e697a0e7babfe4b89ae58aa1e7b3bbe7bb9f310b300906035504031302515130819f300d06092a864886f70d010101050003818d0030818902818100a15e9756216f694c5915e0b529095254367c4e64faeff07ae13488d946615a58ddc31a415f717d019edc6d30b9603d3e2a7b3de0ab7e0cf52dfee39373bc472fa997027d798d59f81d525a69ecf156e885fd1e2790924386b2230cc90e3b7adc95603ddcf4c40bdc72f22db0f216a99c371d3bf89cba6578c60699e8a0d536950203010001300d06092a864886f70d01010505000381810094a9b80e80691645dd42d6611775a855f71bcd4d77cb60a8e29404035a5e00b21bcc5d4a562482126bd91b6b0e50709377ceb9ef8c2efd12cc8b16afd9a159f350bb270b14204ff065d843832720702e28b41491fbc3a205f5f2f42526d67f17614d8a974de6487b2c866efede3b4e49a0f916baa3c1336fd2ee1b1629652049";
  private static final int MSG_COPY_TBS_CORE = 2;
  private static final int MSG_INSTALL_TBS_CORE = 1;
  private static final int MSG_INSTALL_TBS_CORE_EX = 3;
  private static final int MSG_UNZIP_TBS_CORE = 4;
  static final String MTT_SIG = "3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a";
  private static final int OP_CONTINUE_PATCH = 10001;
  private static final int PATCH_FAIL = 1;
  private static final int PATCH_LOAD_ERROR = 3;
  private static final int PATCH_NONEEDPATCH = 2;
  private static final int PATCH_SUCCESS = 0;
  private static final String QQPIMSECURE_SIG = "30820239308201a2a00302010202044c96f48f300d06092a864886f70d01010505003060310b300906035504061302434e310b300906035504081302474431123010060355040713094775616e677a686f753110300e060355040a130754656e63656e74310b3009060355040b130233473111300f0603550403130857696c736f6e57753020170d3130303932303035343334335a180f32303635303632333035343334335a3060310b300906035504061302434e310b300906035504081302474431123010060355040713094775616e677a686f753110300e060355040a130754656e63656e74310b3009060355040b130233473111300f0603550403130857696c736f6e577530819f300d06092a864886f70d010101050003818d0030818902818100b56e79dbb1185a79e52d792bb3d0bb3da8010d9b87da92ec69f7dc5ad66ab6bfdff2a6a1ed285dd2358f28b72a468be7c10a2ce30c4c27323ed4edcc936080e5bedc2cbbca0b7e879c08a631182793f44bb3ea284179b263410c298e5f6831032c9702ba4a74e2ccfc9ef857f12201451602fc8e774ac59d6398511586c83d1d0203010001300d06092a864886f70d0101050500038181002475615bb65b8d8786b890535802948840387d06b1692ff3ea47ef4c435719ba1865b81e6bfa6293ce31747c3cd6b34595b485cc1563fd90107ba5845c28b95c79138f0dec288940395bc10f92f2b69d8dc410999deb38900974ce9984b678030edfba8816582f56160d87e38641288d8588d2a31e20b89f223d788dd35cc9c8";
  private static final String QZONE_SIG = "308202ad30820216a00302010202044c26cea2300d06092a864886f70d010105050030819a310b3009060355040613023836311530130603550408130c4265696a696e672043697479311530130603550407130c4265696a696e67204369747931263024060355040a131d515a6f6e65205465616d206f662054656e63656e7420436f6d70616e7931183016060355040b130f54656e63656e7420436f6d70616e79311b301906035504031312416e64726f696420515a6f6e65205465616d301e170d3130303632373034303830325a170d3335303632313034303830325a30819a310b3009060355040613023836311530130603550408130c4265696a696e672043697479311530130603550407130c4265696a696e67204369747931263024060355040a131d515a6f6e65205465616d206f662054656e63656e7420436f6d70616e7931183016060355040b130f54656e63656e7420436f6d70616e79311b301906035504031312416e64726f696420515a6f6e65205465616d30819f300d06092a864886f70d010101050003818d003081890281810082d6aca037a9843fbbe88b6dd19f36e9c24ce174c1b398f3a529e2a7fe02de99c27539602c026edf96ad8d43df32a85458bca1e6fbf11958658a7d6751a1d9b782bf43a8c19bd1c06bdbfd94c0516326ae3cf638ac42bb470580e340c46e6f306a772c1ef98f10a559edf867f3f31fe492808776b7bd953b2cba2d2b2d66a44f0203010001300d06092a864886f70d0101050500038181006003b04a8a8c5be9650f350cda6896e57dd13e6e83e7f891fc70f6a3c2eaf75cfa4fc998365deabbd1b9092159edf4b90df5702a0d101f8840b5d4586eb92a1c3cd19d95fbc1c2ac956309eda8eef3944baf08c4a49d3b9b3ffb06bc13dab94ecb5b8eb74e8789aa0ba21cb567f538bbc59c2a11e6919924a24272eb79251677";
  private static final String RESPONSE_CODE = "responseCode";
  private static final int RETRY_NUM_COPY = 2;
  private static final int RETRY_NUM_DEXOPT = 10;
  private static final int RETRY_NUM_INCREUPDATE_NUM = 5;
  private static final int RETRY_NUM_LZMA = 5;
  private static final int RETRY_NUM_TPATCH = 5;
  private static final int RETRY_NUM_UNZIP = 10;
  private static final int STATIC_TBS_CORE_SIZE = 10240;
  static final String STATIC_TBS_INSTALLATION_CONF = "static_tbs_installation_conf";
  private static final int STATIC_TBS_INSTALLATION_MAX_TRY_TIMES = 6;
  private static final String STATIC_TBS_INSTALLATION_TRIED_APPID = "static_tbs_installation_tried_appid";
  private static final String STATIC_TBS_INSTALLATION_TRIED_TIMES = "static_tbs_installation_tried_times";
  private static final String TAG = "TbsInstaller";
  private static final String TBS_CONF = "tbs.conf";
  private static final String TBS_CONF_TIMESTAMP = "tbs_core_build_number";
  public static final String TBS_CORE_COOKIE_DB_VERSION = "cookies_database_version";
  static final String TBS_CORE_VER = "tbs_core_version";
  static final String TBS_EXTENSION_CFG_FILE = "tbs_extension.conf";
  private static final String TBS_FILE_APK = "tbs.apk";
  static final String TBS_FILE_CONF = "tbs.conf";
  private static final String TBS_LOCAL_INSTALLATION = "tbs_local_installation";
  private static final long TBS_LOCAL_INSTALLATION_EXPIRED_TIME = 259200000L;
  static final String TBS_PRIVATE_FOLDER_NAME = "core_private";
  static final String TBS_SHARE_FOLDER_DECOUPLE_NAME = "core_share_decouple";
  static final String TBS_SHARE_FOLDER_NAME = "core_share";
  static final String TBS_SHARE_NAME = "share";
  private static final String TBS_STATIC_FILE_LIBRARY_PATTERN = "libtbs\\.(.*)\\.so";
  static final String TMP_BACKUP_TBSCORE_FOLDER_NAME = "core_share_backup_tmp";
  private static final int TMP_COPY_TBS_INSTALLATION = 1;
  private static final int TMP_DOWNLOAD_TBS_INSTALLATION = 0;
  private static final String TMP_OAT_FILE_NAME = "tbs_sdk_extension_dex";
  private static final int TMP_STATIC_TBS_INSTALLATION = 2;
  static final String TMP_TBS_COPY_FOLDER_NAME = "core_copy_tmp";
  static final String TMP_TBS_DECOUPLE_UNZIP_FOLDER_NAME = "core_unzip_tmp_decouple";
  private static final String TMP_TBS_STATIC_FOLDER_NAME = "core_static_tbs_tmp";
  static final String TMP_TBS_TPATCH_DECOUPLE_TMP_FOLDER = "tpatch_decouple_tmp";
  static final String TMP_TBS_TPATCH_TMP_FOLDER = "tpatch_tmp";
  static final String TMP_TBS_UNZIP_FOLDER_NAME = "core_unzip_tmp";
  static final int TPATCH_STATUS_SUCCESS = 1;
  static final int TPATCH_STATUS_UNKNOWN = -1;
  static final int TYPE_BACKUP_DIR = 3;
  static final int TYPE_COPY_TMP = 1;
  static final int TYPE_DECOUPE_TMP = 2;
  static final int TYPE_TMP_BACKUP_DIR = 4;
  static final int TYPE_TMP_DECOUPLE_TPATCH_TMP_DIR = 6;
  static final int TYPE_TMP_TPATCH_TMP_DIR = 5;
  static final int TYPE_UNZIP_TMP = 0;
  private static final int UNLZMA_FAILURE = -3;
  private static final int UNLZMA_NO_NEED_UNZIP = 1;
  private static final int UNLZMA_PATH_IS_NULL = -1;
  private static final int UNLZMA_SUCCESS = 2;
  private static final int UNLZMA_TMP_PATH_NOT_EXIST = -2;
  private static final String UNZIP_TMP_PATH = "unzip_temp_path";
  private static final String WEBCORE_LIB_FILENAME = "libmttwebview.so";
  private static final Long[][] WEBCORE_LIB_LENGTH_MAP;
  private static boolean isQuickDexOptForThirdPartyAppCalled = false;
  static boolean isStaticTbsInstalling;
  private static int mCoreVersion;
  private static TbsInstaller mInstance = null;
  public static ThreadLocal<Integer> mTbsCoreInstalledVer;
  private static FileLock mTbsCoreRenameFileLockForMultiProcess;
  private static final Lock mTbsInstallLock;
  private static Handler mTbsInstallerHandler;
  private static final ReentrantLock mTbsRenameLock = new ReentrantLock();
  static final FileFilter tbs_core_copy_filter;
  private int currentTbsFileLockStackCount = 0;
  private boolean isContinueInstallWithoutCore = false;
  private boolean isGetTbsInstallingSuccess = false;
  private FileLock tbsFileLockFileLock;
  private FileOutputStream tbsInstallingFos;
  
  static
  {
    mTbsInstallLock = new ReentrantLock();
    mTbsCoreRenameFileLockForMultiProcess = null;
    mTbsCoreInstalledVer = new TbsInstaller.1();
    mTbsInstallerHandler = null;
    Long[] arrayOfLong1 = { Long.valueOf(44005L), Long.valueOf(39094008L) };
    Long[] arrayOfLong2 = { Long.valueOf(43910L), Long.valueOf(38917816L) };
    Long[] arrayOfLong3 = { Long.valueOf(44027L), Long.valueOf(39094008L) };
    Long[] arrayOfLong4 = { Long.valueOf(44029L), Long.valueOf(39094008L) };
    Long[] arrayOfLong5 = { Long.valueOf(44030L), Long.valueOf(39094008L) };
    Long[] arrayOfLong6 = { Long.valueOf(44032L), Long.valueOf(39094008L) };
    Long[] arrayOfLong7 = { Long.valueOf(44034L), Long.valueOf(39094008L) };
    WEBCORE_LIB_LENGTH_MAP = new Long[][] { { Long.valueOf(44006L), Long.valueOf(39094008L) }, arrayOfLong1, arrayOfLong2, arrayOfLong3, { Long.valueOf(44028L), Long.valueOf(39094008L) }, arrayOfLong4, arrayOfLong5, arrayOfLong6, { Long.valueOf(44033L), Long.valueOf(39094008L) }, arrayOfLong7, { Long.valueOf(43909L), Long.valueOf(38917816L) } };
    isStaticTbsInstalling = false;
    tbs_core_copy_filter = new TbsInstaller.2();
    mCoreVersion = 0;
  }
  
  private TbsInstaller()
  {
    if (mTbsInstallerHandler == null) {
      mTbsInstallerHandler = new TbsInstaller.3(this, TbsHandlerThread.getInstance().getLooper());
    }
  }
  
  public static void UploadIfTempCoreExistConfError(Context paramContext)
  {
    if (!getTmpFolderCoreToRead(paramContext))
    {
      if (!isPrepareTbsCore(paramContext, "core_unzip_tmp")) {
        break label45;
      }
      TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 417, new Throwable("TMP_TBS_UNZIP_FOLDER_NAME"));
      TbsLog.e("TbsInstaller", "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_TBS_UNZIP_FOLDER_NAME");
    }
    label45:
    do
    {
      return;
      if (isPrepareTbsCore(paramContext, "core_share_backup_tmp"))
      {
        TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 417, new Throwable("TMP_BACKUP_TBSCORE_FOLDER_NAME"));
        TbsLog.e("TbsInstaller", "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_BACKUP_TBSCORE_FOLDER_NAME");
        return;
      }
    } while (!isPrepareTbsCore(paramContext, "core_copy_tmp"));
    TbsCoreLoadStat.getInstance().setLoadErrorCode(paramContext, 417, new Throwable("TMP_TBS_COPY_FOLDER_NAME"));
    TbsLog.e("TbsInstaller", "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_TBS_COPY_FOLDER_NAME");
  }
  
  private void clearNewTbsCore(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--clearNewTbsCore");
    File localFile = getCoreDir(paramContext, 0);
    if (localFile != null) {
      FileUtil.delete(localFile, false);
    }
    TbsCoreVerManager.getInstance(paramContext).setTbsCoreInstallStatus(0, 5);
    TbsCoreVerManager.getInstance(paramContext).setTbsCoreIncrUpdateStatus(-1);
    QbSdk.forceSysWebViewInner(paramContext, "TbsInstaller::clearNewTbsCore forceSysWebViewInner!");
  }
  
  private void copyApkFromAssets(Context paramContext, String paramString, File paramFile)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller-copyApkFromAssets");
    copyAssetsFileTo(paramContext, paramString, paramFile);
  }
  
  private void copyApkFromAssetsIfNeeded(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller-copyApkFromAssetsIfNeeded");
    File localFile = new File(paramContext.getDir("tbs_apk", 0), "tbs.apk");
    if (localFile.exists()) {
      return;
    }
    copyApkFromAssets(paramContext, "tbs.apk", localFile);
  }
  
  /* Error */
  private void copyAssetsFileTo(Context paramContext, String paramString, File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: ldc 151
    //   5: new 479	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   12: ldc_w 482
    //   15: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: aload_2
    //   19: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: aload_1
    //   29: invokevirtual 494	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   32: aload_2
    //   33: invokevirtual 500	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   36: astore_1
    //   37: new 502	java/io/FileOutputStream
    //   40: dup
    //   41: aload_3
    //   42: invokespecial 505	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   45: astore_3
    //   46: ldc_w 506
    //   49: newarray byte
    //   51: astore_2
    //   52: aload_1
    //   53: aload_2
    //   54: invokevirtual 512	java/io/InputStream:read	([B)I
    //   57: istore 4
    //   59: iload 4
    //   61: iconst_m1
    //   62: if_icmpeq +44 -> 106
    //   65: aload_3
    //   66: aload_2
    //   67: iconst_0
    //   68: iload 4
    //   70: invokevirtual 516	java/io/FileOutputStream:write	([BII)V
    //   73: goto -21 -> 52
    //   76: astore 5
    //   78: aload_1
    //   79: astore_2
    //   80: aload_3
    //   81: astore_1
    //   82: aload 5
    //   84: astore_3
    //   85: aload_3
    //   86: invokevirtual 519	java/io/IOException:printStackTrace	()V
    //   89: aload_1
    //   90: ifnull +7 -> 97
    //   93: aload_1
    //   94: invokevirtual 522	java/io/FileOutputStream:close	()V
    //   97: aload_2
    //   98: ifnull +7 -> 105
    //   101: aload_2
    //   102: invokevirtual 523	java/io/InputStream:close	()V
    //   105: return
    //   106: aload_3
    //   107: invokevirtual 526	java/io/FileOutputStream:flush	()V
    //   110: aload_3
    //   111: ifnull +7 -> 118
    //   114: aload_3
    //   115: invokevirtual 522	java/io/FileOutputStream:close	()V
    //   118: aload_1
    //   119: ifnull -14 -> 105
    //   122: aload_1
    //   123: invokevirtual 523	java/io/InputStream:close	()V
    //   126: return
    //   127: astore_1
    //   128: aload_1
    //   129: invokevirtual 519	java/io/IOException:printStackTrace	()V
    //   132: return
    //   133: astore_2
    //   134: aload_2
    //   135: invokevirtual 519	java/io/IOException:printStackTrace	()V
    //   138: goto -20 -> 118
    //   141: astore_1
    //   142: aload_1
    //   143: invokevirtual 519	java/io/IOException:printStackTrace	()V
    //   146: goto -49 -> 97
    //   149: astore_1
    //   150: aload_1
    //   151: invokevirtual 519	java/io/IOException:printStackTrace	()V
    //   154: return
    //   155: astore_2
    //   156: aconst_null
    //   157: astore_3
    //   158: aconst_null
    //   159: astore_1
    //   160: aload_3
    //   161: ifnull +7 -> 168
    //   164: aload_3
    //   165: invokevirtual 522	java/io/FileOutputStream:close	()V
    //   168: aload_1
    //   169: ifnull +7 -> 176
    //   172: aload_1
    //   173: invokevirtual 523	java/io/InputStream:close	()V
    //   176: aload_2
    //   177: athrow
    //   178: astore_3
    //   179: aload_3
    //   180: invokevirtual 519	java/io/IOException:printStackTrace	()V
    //   183: goto -15 -> 168
    //   186: astore_1
    //   187: aload_1
    //   188: invokevirtual 519	java/io/IOException:printStackTrace	()V
    //   191: goto -15 -> 176
    //   194: astore_2
    //   195: aconst_null
    //   196: astore_3
    //   197: goto -37 -> 160
    //   200: astore_2
    //   201: goto -41 -> 160
    //   204: astore_3
    //   205: aload_2
    //   206: astore 5
    //   208: aload_3
    //   209: astore_2
    //   210: aload_1
    //   211: astore_3
    //   212: aload 5
    //   214: astore_1
    //   215: goto -55 -> 160
    //   218: astore_3
    //   219: aconst_null
    //   220: astore_1
    //   221: aload 5
    //   223: astore_2
    //   224: goto -139 -> 85
    //   227: astore_3
    //   228: aconst_null
    //   229: astore 5
    //   231: aload_1
    //   232: astore_2
    //   233: aload 5
    //   235: astore_1
    //   236: goto -151 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	239	0	this	TbsInstaller
    //   0	239	1	paramContext	Context
    //   0	239	2	paramString	String
    //   0	239	3	paramFile	File
    //   57	12	4	i	int
    //   1	1	5	localObject	Object
    //   76	7	5	localIOException	java.io.IOException
    //   206	28	5	str	String
    // Exception table:
    //   from	to	target	type
    //   46	52	76	java/io/IOException
    //   52	59	76	java/io/IOException
    //   65	73	76	java/io/IOException
    //   106	110	76	java/io/IOException
    //   122	126	127	java/io/IOException
    //   114	118	133	java/io/IOException
    //   93	97	141	java/io/IOException
    //   101	105	149	java/io/IOException
    //   28	37	155	finally
    //   164	168	178	java/io/IOException
    //   172	176	186	java/io/IOException
    //   37	46	194	finally
    //   46	52	200	finally
    //   52	59	200	finally
    //   65	73	200	finally
    //   106	110	200	finally
    //   85	89	204	finally
    //   28	37	218	java/io/IOException
    //   37	46	227	java/io/IOException
  }
  
  /* Error */
  @android.annotation.TargetApi(11)
  private void copyTbsCoreInThread(Context paramContext1, Context paramContext2, int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   4: sipush -524
    //   7: invokevirtual 539	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   10: aload_0
    //   11: aload_2
    //   12: invokevirtual 542	com/tencent/smtt/sdk/TbsInstaller:isTbsLocalInstalled	(Landroid/content/Context;)Z
    //   15: ifeq +4 -> 19
    //   18: return
    //   19: ldc 151
    //   21: new 479	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   28: ldc_w 544
    //   31: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: iload_3
    //   35: invokevirtual 547	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   38: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   44: getstatic 552	android/os/Build$VERSION:SDK_INT	I
    //   47: bipush 11
    //   49: if_icmplt +70 -> 119
    //   52: aload_2
    //   53: ldc_w 554
    //   56: iconst_4
    //   57: invokevirtual 558	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   60: astore 13
    //   62: aload 13
    //   64: ldc_w 560
    //   67: iconst_m1
    //   68: invokeinterface 566 3 0
    //   73: iload_3
    //   74: if_icmpne +58 -> 132
    //   77: ldc 151
    //   79: new 479	java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   86: ldc_w 568
    //   89: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: iload_3
    //   93: invokevirtual 547	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   96: ldc_w 570
    //   99: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: invokestatic 393	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   108: aload_1
    //   109: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   112: sipush -525
    //   115: invokevirtual 539	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   118: return
    //   119: aload_2
    //   120: ldc_w 554
    //   123: iconst_0
    //   124: invokevirtual 558	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   127: astore 13
    //   129: goto -67 -> 62
    //   132: aload_0
    //   133: aload_2
    //   134: invokevirtual 573	com/tencent/smtt/sdk/TbsInstaller:getTbsInstallingFileLock	(Landroid/content/Context;)Z
    //   137: ifne +14 -> 151
    //   140: aload_1
    //   141: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   144: sipush -526
    //   147: invokevirtual 539	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   150: return
    //   151: getstatic 281	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   154: invokeinterface 578 1 0
    //   159: istore 8
    //   161: ldc 151
    //   163: new 479	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   170: ldc_w 580
    //   173: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: iload 8
    //   178: invokevirtual 583	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   181: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   187: iload 8
    //   189: ifeq +1747 -> 1936
    //   192: getstatic 279	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   195: invokevirtual 586	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   198: aconst_null
    //   199: astore 14
    //   201: aload_2
    //   202: invokestatic 432	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   205: ldc_w 588
    //   208: invokevirtual 592	com/tencent/smtt/sdk/TbsCoreVerManager:getIntNum	(Ljava/lang/String;)I
    //   211: istore 4
    //   213: aload_2
    //   214: invokestatic 432	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   217: ldc_w 594
    //   220: invokevirtual 597	com/tencent/smtt/sdk/TbsCoreVerManager:getIntStatus	(Ljava/lang/String;)I
    //   223: istore 5
    //   225: iload 4
    //   227: iload_3
    //   228: if_icmpne +43 -> 271
    //   231: getstatic 601	com/tencent/smtt/sdk/QbSdk:mTbsListenerWrapper	Lcom/tencent/smtt/sdk/TbsListener;
    //   234: sipush 220
    //   237: invokeinterface 606 2 0
    //   242: aload_1
    //   243: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   246: sipush -528
    //   249: invokevirtual 539	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   252: getstatic 279	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   255: invokevirtual 609	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   258: getstatic 281	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   261: invokeinterface 610 1 0
    //   266: aload_0
    //   267: invokevirtual 613	com/tencent/smtt/sdk/TbsInstaller:releaseTbsInstallingFileLock	()V
    //   270: return
    //   271: aload_0
    //   272: aload_2
    //   273: invokevirtual 617	com/tencent/smtt/sdk/TbsInstaller:getTbsCoreInstalledVerInNolock	(Landroid/content/Context;)I
    //   276: istore 6
    //   278: ldc 151
    //   280: new 479	java/lang/StringBuilder
    //   283: dup
    //   284: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   287: ldc_w 619
    //   290: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: iload 6
    //   295: invokevirtual 547	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   298: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   301: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   304: iload 6
    //   306: iload_3
    //   307: if_icmpne +69 -> 376
    //   310: getstatic 601	com/tencent/smtt/sdk/QbSdk:mTbsListenerWrapper	Lcom/tencent/smtt/sdk/TbsListener;
    //   313: sipush 220
    //   316: invokeinterface 606 2 0
    //   321: aload_1
    //   322: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   325: sipush -528
    //   328: invokevirtual 539	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   331: ldc 151
    //   333: new 479	java/lang/StringBuilder
    //   336: dup
    //   337: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   340: ldc_w 621
    //   343: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: iload 6
    //   348: invokevirtual 547	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   351: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   354: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   357: getstatic 279	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   360: invokevirtual 609	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   363: getstatic 281	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   366: invokeinterface 610 1 0
    //   371: aload_0
    //   372: invokevirtual 613	com/tencent/smtt/sdk/TbsInstaller:releaseTbsInstallingFileLock	()V
    //   375: return
    //   376: aload_2
    //   377: invokestatic 432	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   380: invokevirtual 625	com/tencent/smtt/sdk/TbsCoreVerManager:getTbsCoreInstallVer	()I
    //   383: istore 7
    //   385: iload 7
    //   387: ifle +1606 -> 1993
    //   390: iload_3
    //   391: iload 7
    //   393: if_icmpgt +6 -> 399
    //   396: goto +1597 -> 1993
    //   399: aload_0
    //   400: aload_2
    //   401: invokevirtual 628	com/tencent/smtt/sdk/TbsInstaller:cleanStatusAndTmpDir	(Landroid/content/Context;)V
    //   404: goto +1603 -> 2007
    //   407: aload_0
    //   408: aload_2
    //   409: invokevirtual 628	com/tencent/smtt/sdk/TbsInstaller:cleanStatusAndTmpDir	(Landroid/content/Context;)V
    //   412: ldc 151
    //   414: ldc_w 630
    //   417: iconst_1
    //   418: invokestatic 633	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   421: iconst_m1
    //   422: istore 4
    //   424: aload_2
    //   425: invokestatic 636	com/tencent/smtt/utils/FileUtil:hasEnoughFreeSpace	(Landroid/content/Context;)Z
    //   428: ifne +88 -> 516
    //   431: invokestatic 642	com/tencent/smtt/utils/TbsUtils:getROMAvailableSize	()J
    //   434: lstore 9
    //   436: aload_2
    //   437: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   440: invokevirtual 645	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMinFreeSpace	()J
    //   443: lstore 11
    //   445: aload_1
    //   446: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   449: sipush -529
    //   452: invokevirtual 539	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   455: aload_2
    //   456: invokestatic 650	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   459: sipush 210
    //   462: new 479	java/lang/StringBuilder
    //   465: dup
    //   466: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   469: ldc_w 652
    //   472: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: lload 9
    //   477: invokevirtual 655	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   480: ldc_w 657
    //   483: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: lload 11
    //   488: invokevirtual 655	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   491: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   494: invokevirtual 661	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   497: getstatic 279	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   500: invokevirtual 609	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   503: getstatic 281	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   506: invokeinterface 610 1 0
    //   511: aload_0
    //   512: invokevirtual 613	com/tencent/smtt/sdk/TbsInstaller:releaseTbsInstallingFileLock	()V
    //   515: return
    //   516: iload 4
    //   518: ifle +26 -> 544
    //   521: aload_2
    //   522: invokestatic 666	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   525: ifne +84 -> 609
    //   528: aload_2
    //   529: invokestatic 671	com/tencent/smtt/sdk/TbsDownloader:isDecoupleCore	(Landroid/content/Context;)Z
    //   532: ifeq +77 -> 609
    //   535: iload_3
    //   536: aload_0
    //   537: aload_2
    //   538: invokevirtual 674	com/tencent/smtt/sdk/TbsInstaller:getTbsCoreShareDecoupleCoreVersion	(Landroid/content/Context;)I
    //   541: if_icmpeq +68 -> 609
    //   544: iload 4
    //   546: ifne +125 -> 671
    //   549: aload_2
    //   550: invokestatic 432	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   553: ldc_w 676
    //   556: invokevirtual 592	com/tencent/smtt/sdk/TbsCoreVerManager:getIntNum	(Ljava/lang/String;)I
    //   559: istore 4
    //   561: iload 4
    //   563: iconst_2
    //   564: if_icmple +93 -> 657
    //   567: aload_2
    //   568: invokestatic 650	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   571: sipush 211
    //   574: ldc_w 678
    //   577: invokevirtual 661	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   580: aload_1
    //   581: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   584: sipush -530
    //   587: invokevirtual 539	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   590: getstatic 279	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   593: invokevirtual 609	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   596: getstatic 281	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   599: invokeinterface 610 1 0
    //   604: aload_0
    //   605: invokevirtual 613	com/tencent/smtt/sdk/TbsInstaller:releaseTbsInstallingFileLock	()V
    //   608: return
    //   609: ldc 151
    //   611: new 479	java/lang/StringBuilder
    //   614: dup
    //   615: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   618: ldc_w 680
    //   621: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: aload_0
    //   625: aload_2
    //   626: invokevirtual 674	com/tencent/smtt/sdk/TbsInstaller:getTbsCoreShareDecoupleCoreVersion	(Landroid/content/Context;)I
    //   629: invokevirtual 547	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   632: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   635: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   638: getstatic 279	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   641: invokevirtual 609	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   644: getstatic 281	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   647: invokeinterface 610 1 0
    //   652: aload_0
    //   653: invokevirtual 613	com/tencent/smtt/sdk/TbsInstaller:releaseTbsInstallingFileLock	()V
    //   656: return
    //   657: aload_2
    //   658: invokestatic 432	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   661: ldc_w 676
    //   664: iload 4
    //   666: iconst_1
    //   667: iadd
    //   668: invokevirtual 684	com/tencent/smtt/sdk/TbsCoreVerManager:setStatus	(Ljava/lang/String;I)V
    //   671: aload_0
    //   672: aload_1
    //   673: invokevirtual 688	com/tencent/smtt/sdk/TbsInstaller:getTbsCoreShareDir	(Landroid/content/Context;)Ljava/io/File;
    //   676: astore 15
    //   678: aload_2
    //   679: invokestatic 666	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   682: ifne +207 -> 889
    //   685: aload_2
    //   686: invokestatic 671	com/tencent/smtt/sdk/TbsDownloader:isDecoupleCore	(Landroid/content/Context;)Z
    //   689: ifeq +189 -> 878
    //   692: aload_0
    //   693: aload_2
    //   694: invokevirtual 691	com/tencent/smtt/sdk/TbsInstaller:getCoreShareDecoupleDir	(Landroid/content/Context;)Ljava/io/File;
    //   697: astore 13
    //   699: aload 15
    //   701: ifnull +1131 -> 1832
    //   704: aload 13
    //   706: ifnull +1126 -> 1832
    //   709: aload_2
    //   710: invokestatic 432	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   713: iload_3
    //   714: iconst_0
    //   715: invokevirtual 694	com/tencent/smtt/sdk/TbsCoreVerManager:setTbsCoreCopyStatus	(II)V
    //   718: new 696	com/tencent/smtt/utils/TbsCopyVerify
    //   721: dup
    //   722: invokespecial 697	com/tencent/smtt/utils/TbsCopyVerify:<init>	()V
    //   725: astore 14
    //   727: aload 14
    //   729: aload 15
    //   731: invokevirtual 700	com/tencent/smtt/utils/TbsCopyVerify:generateReferenceValue	(Ljava/io/File;)V
    //   734: invokestatic 705	java/lang/System:currentTimeMillis	()J
    //   737: lstore 9
    //   739: aload_1
    //   740: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   743: sipush -551
    //   746: invokevirtual 539	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   749: aload 15
    //   751: aload 13
    //   753: getstatic 333	com/tencent/smtt/sdk/TbsInstaller:tbs_core_copy_filter	Ljava/io/FileFilter;
    //   756: invokestatic 709	com/tencent/smtt/utils/FileUtil:copyFiles	(Ljava/io/File;Ljava/io/File;Ljava/io/FileFilter;)Z
    //   759: istore 8
    //   761: aload_2
    //   762: invokestatic 671	com/tencent/smtt/sdk/TbsDownloader:isDecoupleCore	(Landroid/content/Context;)Z
    //   765: ifeq +7 -> 772
    //   768: aload_2
    //   769: invokestatic 712	com/tencent/smtt/sdk/TbsShareManager:shareCoreShareDecouple	(Landroid/content/Context;)V
    //   772: ldc 151
    //   774: new 479	java/lang/StringBuilder
    //   777: dup
    //   778: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   781: ldc_w 714
    //   784: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   787: invokestatic 705	java/lang/System:currentTimeMillis	()J
    //   790: lload 9
    //   792: lsub
    //   793: invokevirtual 655	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   796: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   799: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   802: iload 8
    //   804: ifeq +979 -> 1783
    //   807: aload 14
    //   809: aload 15
    //   811: invokevirtual 717	com/tencent/smtt/utils/TbsCopyVerify:generateVerifyValue	(Ljava/io/File;)V
    //   814: aload 14
    //   816: invokevirtual 720	com/tencent/smtt/utils/TbsCopyVerify:verify	()Z
    //   819: ifne +81 -> 900
    //   822: ldc 151
    //   824: ldc_w 722
    //   827: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   830: aload 13
    //   832: iconst_1
    //   833: invokestatic 427	com/tencent/smtt/utils/FileUtil:delete	(Ljava/io/File;Z)V
    //   836: aload_2
    //   837: invokestatic 650	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   840: sipush 213
    //   843: ldc_w 724
    //   846: invokevirtual 661	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   849: aload_1
    //   850: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   853: sipush -531
    //   856: invokevirtual 539	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   859: getstatic 279	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   862: invokevirtual 609	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   865: getstatic 281	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   868: invokeinterface 610 1 0
    //   873: aload_0
    //   874: invokevirtual 613	com/tencent/smtt/sdk/TbsInstaller:releaseTbsInstallingFileLock	()V
    //   877: return
    //   878: aload_0
    //   879: aload_2
    //   880: iconst_1
    //   881: invokevirtual 421	com/tencent/smtt/sdk/TbsInstaller:getCoreDir	(Landroid/content/Context;I)Ljava/io/File;
    //   884: astore 13
    //   886: goto -187 -> 699
    //   889: aload_0
    //   890: aload_2
    //   891: iconst_1
    //   892: invokevirtual 421	com/tencent/smtt/sdk/TbsInstaller:getCoreDir	(Landroid/content/Context;I)Ljava/io/File;
    //   895: astore 13
    //   897: goto -198 -> 699
    //   900: aconst_null
    //   901: astore 16
    //   903: new 460	java/io/File
    //   906: dup
    //   907: aload 13
    //   909: ldc 99
    //   911: invokespecial 469	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   914: astore 14
    //   916: new 726	java/util/Properties
    //   919: dup
    //   920: invokespecial 727	java/util/Properties:<init>	()V
    //   923: astore 15
    //   925: aload 14
    //   927: ifnull +1128 -> 2055
    //   930: aload 14
    //   932: invokevirtual 473	java/io/File:exists	()Z
    //   935: ifeq +1120 -> 2055
    //   938: aload 15
    //   940: ifnull +1115 -> 2055
    //   943: new 729	java/io/BufferedInputStream
    //   946: dup
    //   947: new 731	java/io/FileInputStream
    //   950: dup
    //   951: aload 14
    //   953: invokespecial 732	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   956: invokespecial 735	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   959: astore 14
    //   961: aload 14
    //   963: astore 17
    //   965: aload 15
    //   967: aload 14
    //   969: invokevirtual 738	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   972: iconst_1
    //   973: istore 4
    //   975: aload 14
    //   977: ifnull +1013 -> 1990
    //   980: aload 14
    //   982: invokevirtual 739	java/io/BufferedInputStream:close	()V
    //   985: iload 4
    //   987: ifeq +991 -> 1978
    //   990: aload 13
    //   992: invokevirtual 743	java/io/File:listFiles	()[Ljava/io/File;
    //   995: astore 14
    //   997: aload_1
    //   998: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1001: sipush -552
    //   1004: invokevirtual 539	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1007: iconst_0
    //   1008: istore 5
    //   1010: iload 5
    //   1012: aload 14
    //   1014: arraylength
    //   1015: if_icmpge +963 -> 1978
    //   1018: aload 14
    //   1020: iload 5
    //   1022: aaload
    //   1023: astore 16
    //   1025: ldc 99
    //   1027: aload 16
    //   1029: invokevirtual 746	java/io/File:getName	()Ljava/lang/String;
    //   1032: invokevirtual 752	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1035: ifne +1011 -> 2046
    //   1038: aload 16
    //   1040: invokevirtual 746	java/io/File:getName	()Ljava/lang/String;
    //   1043: ldc_w 754
    //   1046: invokevirtual 758	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1049: ifne +997 -> 2046
    //   1052: ldc 154
    //   1054: aload 16
    //   1056: invokevirtual 746	java/io/File:getName	()Ljava/lang/String;
    //   1059: invokevirtual 752	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1062: ifne +984 -> 2046
    //   1065: aload 16
    //   1067: invokevirtual 761	java/io/File:isDirectory	()Z
    //   1070: ifne +976 -> 2046
    //   1073: aload 16
    //   1075: invokevirtual 746	java/io/File:getName	()Ljava/lang/String;
    //   1078: ldc_w 763
    //   1081: invokevirtual 758	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1084: ifeq +181 -> 1265
    //   1087: goto +959 -> 2046
    //   1090: astore 14
    //   1092: aload 14
    //   1094: invokevirtual 519	java/io/IOException:printStackTrace	()V
    //   1097: goto -112 -> 985
    //   1100: astore 16
    //   1102: aconst_null
    //   1103: astore 15
    //   1105: aconst_null
    //   1106: astore 14
    //   1108: aload 14
    //   1110: astore 17
    //   1112: aload 16
    //   1114: invokevirtual 764	java/lang/Exception:printStackTrace	()V
    //   1117: aload 14
    //   1119: ifnull +865 -> 1984
    //   1122: aload 14
    //   1124: invokevirtual 739	java/io/BufferedInputStream:close	()V
    //   1127: iconst_1
    //   1128: istore 4
    //   1130: goto -145 -> 985
    //   1133: astore 14
    //   1135: aload 14
    //   1137: invokevirtual 519	java/io/IOException:printStackTrace	()V
    //   1140: iconst_1
    //   1141: istore 4
    //   1143: goto -158 -> 985
    //   1146: astore 14
    //   1148: aload 16
    //   1150: astore 15
    //   1152: aload 15
    //   1154: ifnull +8 -> 1162
    //   1157: aload 15
    //   1159: invokevirtual 739	java/io/BufferedInputStream:close	()V
    //   1162: aload 14
    //   1164: athrow
    //   1165: astore 15
    //   1167: aload 13
    //   1169: astore 14
    //   1171: aload 15
    //   1173: astore 13
    //   1175: aload_2
    //   1176: invokestatic 650	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1179: sipush 215
    //   1182: aload 13
    //   1184: invokevirtual 765	java/lang/Exception:toString	()Ljava/lang/String;
    //   1187: invokevirtual 661	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1190: aload_1
    //   1191: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1194: sipush -537
    //   1197: invokevirtual 539	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1200: aload 14
    //   1202: iconst_0
    //   1203: invokestatic 427	com/tencent/smtt/utils/FileUtil:delete	(Ljava/io/File;Z)V
    //   1206: aload_2
    //   1207: invokestatic 432	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   1210: iconst_0
    //   1211: iconst_m1
    //   1212: invokevirtual 694	com/tencent/smtt/sdk/TbsCoreVerManager:setTbsCoreCopyStatus	(II)V
    //   1215: getstatic 279	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   1218: invokevirtual 609	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1221: getstatic 281	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   1224: invokeinterface 610 1 0
    //   1229: aload_0
    //   1230: invokevirtual 613	com/tencent/smtt/sdk/TbsInstaller:releaseTbsInstallingFileLock	()V
    //   1233: return
    //   1234: astore 15
    //   1236: aload 15
    //   1238: invokevirtual 519	java/io/IOException:printStackTrace	()V
    //   1241: goto -79 -> 1162
    //   1244: astore_1
    //   1245: getstatic 279	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   1248: invokevirtual 609	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1251: getstatic 281	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   1254: invokeinterface 610 1 0
    //   1259: aload_0
    //   1260: invokevirtual 613	com/tencent/smtt/sdk/TbsInstaller:releaseTbsInstallingFileLock	()V
    //   1263: aload_1
    //   1264: athrow
    //   1265: aload 16
    //   1267: invokestatic 771	com/tencent/smtt/utils/ApkUtil:getMd5	(Ljava/io/File;)Ljava/lang/String;
    //   1270: astore 17
    //   1272: aload 15
    //   1274: aload 16
    //   1276: invokevirtual 746	java/io/File:getName	()Ljava/lang/String;
    //   1279: ldc_w 773
    //   1282: invokevirtual 777	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1285: astore 18
    //   1287: aload 18
    //   1289: ldc_w 773
    //   1292: invokevirtual 752	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1295: ifne +51 -> 1346
    //   1298: aload 17
    //   1300: aload 18
    //   1302: invokevirtual 752	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1305: ifeq +41 -> 1346
    //   1308: ldc 151
    //   1310: new 479	java/lang/StringBuilder
    //   1313: dup
    //   1314: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   1317: ldc_w 779
    //   1320: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1323: aload 16
    //   1325: invokevirtual 746	java/io/File:getName	()Ljava/lang/String;
    //   1328: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1331: ldc_w 781
    //   1334: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1337: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1340: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1343: goto +703 -> 2046
    //   1346: ldc 151
    //   1348: new 479	java/lang/StringBuilder
    //   1351: dup
    //   1352: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   1355: ldc_w 783
    //   1358: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1361: aload 16
    //   1363: invokevirtual 746	java/io/File:getName	()Ljava/lang/String;
    //   1366: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1369: ldc_w 785
    //   1372: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1375: aload 18
    //   1377: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1380: ldc_w 787
    //   1383: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1386: aload 17
    //   1388: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1391: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1394: invokestatic 393	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1397: iconst_0
    //   1398: istore 8
    //   1400: ldc 151
    //   1402: new 479	java/lang/StringBuilder
    //   1405: dup
    //   1406: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   1409: ldc_w 789
    //   1412: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1415: iload 8
    //   1417: invokevirtual 583	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1420: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1423: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1426: iload 4
    //   1428: ifeq +64 -> 1492
    //   1431: iload 8
    //   1433: ifne +59 -> 1492
    //   1436: ldc 151
    //   1438: ldc_w 791
    //   1441: invokestatic 393	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1444: aload 13
    //   1446: iconst_1
    //   1447: invokestatic 427	com/tencent/smtt/utils/FileUtil:delete	(Ljava/io/File;Z)V
    //   1450: aload_2
    //   1451: invokestatic 650	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1454: sipush 213
    //   1457: ldc_w 793
    //   1460: invokevirtual 661	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1463: aload_1
    //   1464: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1467: sipush -532
    //   1470: invokevirtual 539	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1473: getstatic 279	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   1476: invokevirtual 609	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1479: getstatic 281	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   1482: invokeinterface 610 1 0
    //   1487: aload_0
    //   1488: invokevirtual 613	com/tencent/smtt/sdk/TbsInstaller:releaseTbsInstallingFileLock	()V
    //   1491: return
    //   1492: ldc 151
    //   1494: ldc_w 795
    //   1497: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1500: aload_0
    //   1501: aload_2
    //   1502: iconst_1
    //   1503: invokespecial 799	com/tencent/smtt/sdk/TbsInstaller:setTmpFolderCoreToRead	(Landroid/content/Context;Z)V
    //   1506: aload_1
    //   1507: invokestatic 804	com/tencent/smtt/sdk/TbsApkDownloader:getHostBackupApkPath	(Landroid/content/Context;)Ljava/io/File;
    //   1510: astore 15
    //   1512: aload 15
    //   1514: ifnull +38 -> 1552
    //   1517: aload 15
    //   1519: invokevirtual 473	java/io/File:exists	()Z
    //   1522: ifeq +30 -> 1552
    //   1525: aload_2
    //   1526: invokestatic 807	com/tencent/smtt/sdk/TbsDownloader:getOverSea	(Landroid/content/Context;)Z
    //   1529: ifeq +182 -> 1711
    //   1532: ldc_w 809
    //   1535: astore 14
    //   1537: new 460	java/io/File
    //   1540: dup
    //   1541: aload 15
    //   1543: aload 14
    //   1545: invokespecial 469	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   1548: aload_2
    //   1549: invokestatic 813	com/tencent/smtt/sdk/TbsApkDownloader:backupTbsApk	(Ljava/io/File;Landroid/content/Context;)V
    //   1552: aload_2
    //   1553: invokestatic 432	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   1556: iload_3
    //   1557: iconst_1
    //   1558: invokevirtual 694	com/tencent/smtt/sdk/TbsCoreVerManager:setTbsCoreCopyStatus	(II)V
    //   1561: aload_0
    //   1562: getfield 345	com/tencent/smtt/sdk/TbsInstaller:isContinueInstallWithoutCore	Z
    //   1565: ifeq +155 -> 1720
    //   1568: aload_2
    //   1569: invokestatic 650	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1572: sipush 220
    //   1575: ldc_w 815
    //   1578: invokevirtual 661	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1581: aload_1
    //   1582: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1585: sipush -533
    //   1588: invokevirtual 539	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1591: ldc 151
    //   1593: new 479	java/lang/StringBuilder
    //   1596: dup
    //   1597: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   1600: ldc_w 817
    //   1603: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1606: iload_3
    //   1607: invokevirtual 547	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1610: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1613: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1616: getstatic 552	android/os/Build$VERSION:SDK_INT	I
    //   1619: bipush 11
    //   1621: if_icmplt +115 -> 1736
    //   1624: aload_2
    //   1625: ldc_w 554
    //   1628: iconst_4
    //   1629: invokevirtual 558	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   1632: astore 14
    //   1634: aload 14
    //   1636: invokeinterface 821 1 0
    //   1641: astore 14
    //   1643: aload 14
    //   1645: ldc_w 823
    //   1648: iconst_0
    //   1649: invokeinterface 829 3 0
    //   1654: pop
    //   1655: aload 14
    //   1657: ldc_w 831
    //   1660: iconst_0
    //   1661: invokeinterface 829 3 0
    //   1666: pop
    //   1667: aload 14
    //   1669: ldc_w 833
    //   1672: iload_3
    //   1673: invokeinterface 829 3 0
    //   1678: pop
    //   1679: aload 14
    //   1681: invokeinterface 836 1 0
    //   1686: pop
    //   1687: aload_2
    //   1688: invokestatic 839	com/tencent/smtt/utils/TbsUtils:createDirectoryTBS	(Landroid/content/Context;)Z
    //   1691: pop
    //   1692: getstatic 279	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   1695: invokevirtual 609	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1698: getstatic 281	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   1701: invokeinterface 610 1 0
    //   1706: aload_0
    //   1707: invokevirtual 613	com/tencent/smtt/sdk/TbsInstaller:releaseTbsInstallingFileLock	()V
    //   1710: return
    //   1711: iconst_0
    //   1712: invokestatic 843	com/tencent/smtt/sdk/TbsDownloader:getBackupFileName	(Z)Ljava/lang/String;
    //   1715: astore 14
    //   1717: goto -180 -> 1537
    //   1720: aload_2
    //   1721: invokestatic 650	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1724: sipush 220
    //   1727: ldc_w 845
    //   1730: invokevirtual 661	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1733: goto -152 -> 1581
    //   1736: aload_2
    //   1737: ldc_w 554
    //   1740: iconst_0
    //   1741: invokevirtual 558	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   1744: astore 14
    //   1746: goto -112 -> 1634
    //   1749: astore 14
    //   1751: ldc 151
    //   1753: new 479	java/lang/StringBuilder
    //   1756: dup
    //   1757: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   1760: ldc_w 847
    //   1763: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1766: aload 14
    //   1768: invokestatic 853	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1771: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1774: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1777: invokestatic 393	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1780: goto -93 -> 1687
    //   1783: ldc 151
    //   1785: ldc_w 855
    //   1788: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1791: aload_2
    //   1792: invokestatic 432	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   1795: iload_3
    //   1796: iconst_2
    //   1797: invokevirtual 694	com/tencent/smtt/sdk/TbsCoreVerManager:setTbsCoreCopyStatus	(II)V
    //   1800: aload 13
    //   1802: iconst_0
    //   1803: invokestatic 427	com/tencent/smtt/utils/FileUtil:delete	(Ljava/io/File;Z)V
    //   1806: aload_1
    //   1807: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1810: sipush -534
    //   1813: invokevirtual 539	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1816: aload_2
    //   1817: invokestatic 650	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1820: sipush 212
    //   1823: ldc_w 857
    //   1826: invokevirtual 661	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1829: goto -137 -> 1692
    //   1832: aload 15
    //   1834: ifnonnull +26 -> 1860
    //   1837: aload_2
    //   1838: invokestatic 650	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1841: sipush 213
    //   1844: ldc_w 859
    //   1847: invokevirtual 661	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1850: aload_1
    //   1851: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1854: sipush -535
    //   1857: invokevirtual 539	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1860: aload 13
    //   1862: ifnonnull -170 -> 1692
    //   1865: aload_2
    //   1866: invokestatic 650	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1869: sipush 214
    //   1872: ldc_w 861
    //   1875: invokevirtual 661	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1878: aload_1
    //   1879: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1882: sipush -536
    //   1885: invokevirtual 539	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1888: goto -196 -> 1692
    //   1891: astore_1
    //   1892: ldc 151
    //   1894: new 479	java/lang/StringBuilder
    //   1897: dup
    //   1898: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   1901: ldc_w 863
    //   1904: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1907: aload_1
    //   1908: invokevirtual 866	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1911: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1914: ldc_w 868
    //   1917: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1920: aload_1
    //   1921: invokevirtual 872	java/lang/Exception:getCause	()Ljava/lang/Throwable;
    //   1924: invokevirtual 875	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1927: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1930: invokestatic 393	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1933: goto -718 -> 1215
    //   1936: aload_0
    //   1937: invokevirtual 613	com/tencent/smtt/sdk/TbsInstaller:releaseTbsInstallingFileLock	()V
    //   1940: aload_1
    //   1941: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1944: sipush -538
    //   1947: invokevirtual 539	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1950: return
    //   1951: astore 13
    //   1953: goto -778 -> 1175
    //   1956: astore 14
    //   1958: aload 17
    //   1960: astore 15
    //   1962: goto -810 -> 1152
    //   1965: astore 16
    //   1967: aconst_null
    //   1968: astore 14
    //   1970: goto -862 -> 1108
    //   1973: astore 16
    //   1975: goto -867 -> 1108
    //   1978: iconst_1
    //   1979: istore 8
    //   1981: goto -581 -> 1400
    //   1984: iconst_1
    //   1985: istore 4
    //   1987: goto -1002 -> 985
    //   1990: goto -1005 -> 985
    //   1993: iload 4
    //   1995: ifle +12 -> 2007
    //   1998: iload_3
    //   1999: iload 4
    //   2001: if_icmple +6 -> 2007
    //   2004: goto -1605 -> 399
    //   2007: iload 5
    //   2009: istore 4
    //   2011: iload 5
    //   2013: iconst_3
    //   2014: if_icmpne -1590 -> 424
    //   2017: iload 5
    //   2019: istore 4
    //   2021: iload 6
    //   2023: ifle -1599 -> 424
    //   2026: iload_3
    //   2027: iload 6
    //   2029: if_icmpgt -1622 -> 407
    //   2032: iload 5
    //   2034: istore 4
    //   2036: iload_3
    //   2037: ldc_w 876
    //   2040: if_icmpne -1616 -> 424
    //   2043: goto -1636 -> 407
    //   2046: iload 5
    //   2048: iconst_1
    //   2049: iadd
    //   2050: istore 5
    //   2052: goto -1042 -> 1010
    //   2055: aconst_null
    //   2056: astore 14
    //   2058: iconst_0
    //   2059: istore 4
    //   2061: goto -1086 -> 975
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2064	0	this	TbsInstaller
    //   0	2064	1	paramContext1	Context
    //   0	2064	2	paramContext2	Context
    //   0	2064	3	paramInt	int
    //   211	1849	4	i	int
    //   223	1828	5	j	int
    //   276	1754	6	k	int
    //   383	11	7	m	int
    //   159	1821	8	bool	boolean
    //   434	357	9	l1	long
    //   443	44	11	l2	long
    //   60	1801	13	localObject1	Object
    //   1951	1	13	localException1	Exception
    //   199	820	14	localObject2	Object
    //   1090	3	14	localIOException1	java.io.IOException
    //   1106	17	14	localObject3	Object
    //   1133	3	14	localIOException2	java.io.IOException
    //   1146	17	14	localObject4	Object
    //   1169	576	14	localObject5	Object
    //   1749	18	14	localThrowable	Throwable
    //   1956	1	14	localObject6	Object
    //   1968	89	14	localObject7	Object
    //   676	482	15	localObject8	Object
    //   1165	7	15	localException2	Exception
    //   1234	39	15	localIOException3	java.io.IOException
    //   1510	451	15	localObject9	Object
    //   901	173	16	localObject10	Object
    //   1100	262	16	localException3	Exception
    //   1965	1	16	localException4	Exception
    //   1973	1	16	localException5	Exception
    //   963	996	17	localObject11	Object
    //   1285	91	18	str	String
    // Exception table:
    //   from	to	target	type
    //   980	985	1090	java/io/IOException
    //   903	925	1100	java/lang/Exception
    //   1122	1127	1133	java/io/IOException
    //   903	925	1146	finally
    //   930	938	1146	finally
    //   943	961	1146	finally
    //   709	772	1165	java/lang/Exception
    //   772	802	1165	java/lang/Exception
    //   807	859	1165	java/lang/Exception
    //   980	985	1165	java/lang/Exception
    //   990	1007	1165	java/lang/Exception
    //   1010	1018	1165	java/lang/Exception
    //   1025	1087	1165	java/lang/Exception
    //   1092	1097	1165	java/lang/Exception
    //   1122	1127	1165	java/lang/Exception
    //   1135	1140	1165	java/lang/Exception
    //   1157	1162	1165	java/lang/Exception
    //   1162	1165	1165	java/lang/Exception
    //   1236	1241	1165	java/lang/Exception
    //   1265	1343	1165	java/lang/Exception
    //   1346	1397	1165	java/lang/Exception
    //   1400	1426	1165	java/lang/Exception
    //   1436	1473	1165	java/lang/Exception
    //   1492	1512	1165	java/lang/Exception
    //   1517	1532	1165	java/lang/Exception
    //   1537	1552	1165	java/lang/Exception
    //   1552	1581	1165	java/lang/Exception
    //   1581	1634	1165	java/lang/Exception
    //   1634	1687	1165	java/lang/Exception
    //   1687	1692	1165	java/lang/Exception
    //   1711	1717	1165	java/lang/Exception
    //   1720	1733	1165	java/lang/Exception
    //   1736	1746	1165	java/lang/Exception
    //   1751	1780	1165	java/lang/Exception
    //   1783	1829	1165	java/lang/Exception
    //   1837	1860	1165	java/lang/Exception
    //   1865	1888	1165	java/lang/Exception
    //   1157	1162	1234	java/io/IOException
    //   201	225	1244	finally
    //   231	252	1244	finally
    //   271	304	1244	finally
    //   310	357	1244	finally
    //   376	385	1244	finally
    //   399	404	1244	finally
    //   407	421	1244	finally
    //   424	497	1244	finally
    //   521	544	1244	finally
    //   549	561	1244	finally
    //   567	590	1244	finally
    //   609	638	1244	finally
    //   657	671	1244	finally
    //   671	699	1244	finally
    //   709	772	1244	finally
    //   772	802	1244	finally
    //   807	859	1244	finally
    //   878	886	1244	finally
    //   889	897	1244	finally
    //   980	985	1244	finally
    //   990	1007	1244	finally
    //   1010	1018	1244	finally
    //   1025	1087	1244	finally
    //   1092	1097	1244	finally
    //   1122	1127	1244	finally
    //   1135	1140	1244	finally
    //   1157	1162	1244	finally
    //   1162	1165	1244	finally
    //   1175	1200	1244	finally
    //   1200	1215	1244	finally
    //   1236	1241	1244	finally
    //   1265	1343	1244	finally
    //   1346	1397	1244	finally
    //   1400	1426	1244	finally
    //   1436	1473	1244	finally
    //   1492	1512	1244	finally
    //   1517	1532	1244	finally
    //   1537	1552	1244	finally
    //   1552	1581	1244	finally
    //   1581	1634	1244	finally
    //   1634	1687	1244	finally
    //   1687	1692	1244	finally
    //   1711	1717	1244	finally
    //   1720	1733	1244	finally
    //   1736	1746	1244	finally
    //   1751	1780	1244	finally
    //   1783	1829	1244	finally
    //   1837	1860	1244	finally
    //   1865	1888	1244	finally
    //   1892	1933	1244	finally
    //   1634	1687	1749	java/lang/Throwable
    //   1200	1215	1891	java/lang/Exception
    //   201	225	1951	java/lang/Exception
    //   231	252	1951	java/lang/Exception
    //   271	304	1951	java/lang/Exception
    //   310	357	1951	java/lang/Exception
    //   376	385	1951	java/lang/Exception
    //   399	404	1951	java/lang/Exception
    //   407	421	1951	java/lang/Exception
    //   424	497	1951	java/lang/Exception
    //   521	544	1951	java/lang/Exception
    //   549	561	1951	java/lang/Exception
    //   567	590	1951	java/lang/Exception
    //   609	638	1951	java/lang/Exception
    //   657	671	1951	java/lang/Exception
    //   671	699	1951	java/lang/Exception
    //   878	886	1951	java/lang/Exception
    //   889	897	1951	java/lang/Exception
    //   965	972	1956	finally
    //   1112	1117	1956	finally
    //   930	938	1965	java/lang/Exception
    //   943	961	1965	java/lang/Exception
    //   965	972	1973	java/lang/Exception
  }
  
  private void deleteOldTbsCore(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--deleteOldCore");
    FileUtil.delete(getTbsCoreShareDir(paramContext), false);
  }
  
  private boolean doDexoatForArtVm(Context paramContext, File paramFile)
  {
    try
    {
      Object localObject1 = new File(paramFile, "tbs_sdk_extension_dex.jar");
      Object localObject2 = new File(paramFile, "tbs_sdk_extension_dex.dex");
      Object localObject3 = paramContext.getClassLoader();
      new DexClassLoader(((File)localObject1).getAbsolutePath(), paramFile.getAbsolutePath(), null, (ClassLoader)localObject3);
      localObject1 = OatHelper.getOatCommand(paramContext, ((File)localObject2).getAbsolutePath());
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        TbsLogReport.getInstance(paramContext).setInstallErrorCode(226, "can not find oat command");
        return false;
      }
      paramFile = paramFile.listFiles(new TbsInstaller.7(this));
      int j = paramFile.length;
      int i = 0;
      while (i < j)
      {
        localObject2 = paramFile[i];
        localObject2 = ((File)localObject2).getName().substring(0, ((File)localObject2).getName().length() - 4);
        localObject3 = ((String)localObject1).replaceAll("tbs_sdk_extension_dex", (String)localObject2);
        localObject2 = "/system/bin/dex2oat " + (String)localObject3 + " --dex-location=" + getInstance().getTbsCoreShareDir(paramContext) + File.separator + (String)localObject2 + ".jar";
        Runtime.getRuntime().exec((String)localObject2).waitFor();
        i += 1;
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
  
  /* Error */
  private boolean doDexoptForDavlikVM(Context paramContext, File paramFile)
  {
    // Byte code:
    //   0: aload_2
    //   1: new 963	com/tencent/smtt/sdk/TbsInstaller$6
    //   4: dup
    //   5: aload_0
    //   6: invokespecial 964	com/tencent/smtt/sdk/TbsInstaller$6:<init>	(Lcom/tencent/smtt/sdk/TbsInstaller;)V
    //   9: invokevirtual 920	java/io/File:listFiles	(Ljava/io/FileFilter;)[Ljava/io/File;
    //   12: astore 6
    //   14: aload 6
    //   16: arraylength
    //   17: istore 4
    //   19: getstatic 552	android/os/Build$VERSION:SDK_INT	I
    //   22: bipush 16
    //   24: if_icmpge +32 -> 56
    //   27: aload_1
    //   28: invokevirtual 967	android/content/Context:getPackageName	()Ljava/lang/String;
    //   31: ifnull +25 -> 56
    //   34: aload_1
    //   35: invokevirtual 967	android/content/Context:getPackageName	()Ljava/lang/String;
    //   38: ldc 11
    //   40: invokevirtual 970	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   43: istore 5
    //   45: iload 5
    //   47: ifeq +9 -> 56
    //   50: ldc2_w 971
    //   53: invokestatic 978	java/lang/Thread:sleep	(J)V
    //   56: aload_1
    //   57: invokevirtual 890	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   60: astore 7
    //   62: iconst_0
    //   63: istore_3
    //   64: iload_3
    //   65: iload 4
    //   67: if_icmpge +63 -> 130
    //   70: ldc 151
    //   72: new 479	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   79: ldc_w 980
    //   82: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: aload 6
    //   87: iload_3
    //   88: aaload
    //   89: invokevirtual 895	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   92: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   101: new 892	dalvik/system/DexClassLoader
    //   104: dup
    //   105: aload 6
    //   107: iload_3
    //   108: aaload
    //   109: invokevirtual 895	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   112: aload_2
    //   113: invokevirtual 895	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   116: aconst_null
    //   117: aload 7
    //   119: invokespecial 898	dalvik/system/DexClassLoader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   122: pop
    //   123: iload_3
    //   124: iconst_1
    //   125: iadd
    //   126: istore_3
    //   127: goto -63 -> 64
    //   130: iconst_1
    //   131: ireturn
    //   132: astore_2
    //   133: aload_2
    //   134: invokevirtual 764	java/lang/Exception:printStackTrace	()V
    //   137: aload_1
    //   138: invokestatic 650	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   141: sipush 209
    //   144: aload_2
    //   145: invokevirtual 765	java/lang/Exception:toString	()Ljava/lang/String;
    //   148: invokevirtual 661	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   151: ldc 151
    //   153: ldc_w 982
    //   156: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   159: iconst_0
    //   160: ireturn
    //   161: astore 7
    //   163: goto -107 -> 56
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	this	TbsInstaller
    //   0	166	1	paramContext	Context
    //   0	166	2	paramFile	File
    //   63	64	3	i	int
    //   17	51	4	j	int
    //   43	3	5	bool	boolean
    //   12	94	6	arrayOfFile	File[]
    //   60	58	7	localClassLoader	ClassLoader
    //   161	1	7	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   0	45	132	java/lang/Exception
    //   56	62	132	java/lang/Exception
    //   70	123	132	java/lang/Exception
    //   50	56	161	java/lang/Exception
  }
  
  private boolean doDexoptOrDexoat(Context paramContext, int paramInt)
  {
    boolean bool = true;
    int k = 0;
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
      if (TbsDownloader.isDecoupleCore(paramContext)) {
        break label317;
      }
      localFile1 = getCoreDir(paramContext, 0);
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
      bool = doDexoptForDavlikVM(paramContext, localFile2);
    }
    if (Build.VERSION.SDK_INT == 23) {}
    for (int i = 1;; i = 0)
    {
      bool = TbsDownloadConfig.getInstance(paramContext).mPreferences.getBoolean("tbs_stop_preoat", false);
      int j = k;
      if (paramInt != 0)
      {
        j = k;
        if (i != 0)
        {
          j = k;
          if (!bool) {
            j = 1;
          }
        }
      }
      File localFile2;
      if ((j != 0) && (doDexoatForArtVm(paramContext, localFile1)))
      {
        TbsLog.i("TbsInstaller", "doTbsDexOpt -- doDexoatForArtVm");
        return true;
        localFile2 = getCoreDir(paramContext, 1);
        break;
        localFile2 = getTbsCoreShareDir(paramContext);
        break;
      }
      label317:
      return bool;
      label320:
      paramInt = 0;
      break label132;
    }
  }
  
  private int doTpatch(Context paramContext, Bundle paramBundle)
  {
    int i;
    try
    {
      Object localObject = QbSdk.incrUpdate(paramContext, paramBundle);
      TbsLog.i("TbsInstaller", "tpatch finished,ret is" + localObject);
      i = ((Bundle)localObject).getInt("patch_result");
      if (i == 0)
      {
        localObject = paramBundle.getString("new_apk_location");
        i = paramBundle.getInt("new_core_ver");
        int j = getTbsVersion(new File((String)localObject));
        if (i != j)
        {
          TbsLog.i("TbsInstaller", "version not equals!!!" + i + "patchVersion:" + j);
          TbsLogReport.getInstance(paramContext).setInstallErrorCode(240, "version=" + i + ",patchVersion=" + j);
          return 1;
        }
        paramBundle = new File(paramBundle.getString("backup_apk"));
        localObject = AppUtil.getSignatureFromApk(paramContext, true, paramBundle);
        if (!"3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a".equals(localObject))
        {
          TbsLog.i("TbsInstaller", "tpatch sig not equals!!!" + paramBundle + "signature:" + (String)localObject);
          TbsLogReport.getInstance(paramContext).setInstallErrorCode(241, "version=" + i + ",patchVersion=" + j);
          FileUtil.delete(paramBundle);
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
      if (TbsDownloader.isDecoupleCore(paramContext))
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
        FileUtil.delete(new File(paramBundle));
      }
      TbsLogReport.getInstance(paramContext).setInstallErrorCode(i, "tpatch fail,patch error_code=" + i);
    }
  }
  
  private boolean enableTbsCoreFromBackup(Context paramContext, boolean paramBoolean)
  {
    return false;
  }
  
  /* Error */
  private boolean enableTbsCoreFromCopy(Context paramContext, boolean paramBoolean)
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
    //   14: ldc 151
    //   16: ldc_w 1071
    //   19: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: iload 8
    //   24: istore 6
    //   26: aload_0
    //   27: aload_1
    //   28: invokevirtual 573	com/tencent/smtt/sdk/TbsInstaller:getTbsInstallingFileLock	(Landroid/content/Context;)Z
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
    //   51: getstatic 279	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   54: invokevirtual 1072	java/util/concurrent/locks/ReentrantLock:tryLock	()Z
    //   57: istore 9
    //   59: iload 8
    //   61: istore 6
    //   63: ldc 151
    //   65: new 479	java/lang/StringBuilder
    //   68: dup
    //   69: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   72: ldc_w 1074
    //   75: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: iload 9
    //   80: invokevirtual 583	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   83: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: iload 9
    //   91: ifeq +109 -> 200
    //   94: aload_1
    //   95: invokestatic 432	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   98: ldc_w 594
    //   101: invokevirtual 597	com/tencent/smtt/sdk/TbsCoreVerManager:getIntStatus	(Ljava/lang/String;)I
    //   104: istore_3
    //   105: aload_0
    //   106: iconst_0
    //   107: aload_1
    //   108: invokevirtual 1078	com/tencent/smtt/sdk/TbsInstaller:getTbsCoreInstalledVerWithNew	(ZLandroid/content/Context;)I
    //   111: istore 4
    //   113: ldc 151
    //   115: new 479	java/lang/StringBuilder
    //   118: dup
    //   119: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   122: ldc_w 1080
    //   125: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: iload_3
    //   129: invokevirtual 547	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   132: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   138: ldc 151
    //   140: new 479	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   147: ldc_w 1082
    //   150: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: iload 4
    //   155: invokevirtual 547	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   158: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   164: iload_3
    //   165: iconst_1
    //   166: if_icmpne +156 -> 322
    //   169: iload 4
    //   171: ifne +100 -> 271
    //   174: ldc 151
    //   176: ldc_w 1084
    //   179: iconst_1
    //   180: invokestatic 633	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   183: aload_0
    //   184: aload_1
    //   185: invokespecial 1087	com/tencent/smtt/sdk/TbsInstaller:generateNewTbsCoreFromCopy	(Landroid/content/Context;)V
    //   188: iload 7
    //   190: istore_2
    //   191: getstatic 279	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   194: invokevirtual 609	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   197: iload_2
    //   198: istore 5
    //   200: iload 5
    //   202: istore 6
    //   204: aload_0
    //   205: invokevirtual 613	com/tencent/smtt/sdk/TbsInstaller:releaseTbsInstallingFileLock	()V
    //   208: goto -166 -> 42
    //   211: astore 11
    //   213: iload 6
    //   215: istore 5
    //   217: aload_1
    //   218: invokestatic 650	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   221: sipush 215
    //   224: aload 11
    //   226: invokevirtual 1088	java/lang/Throwable:toString	()Ljava/lang/String;
    //   229: invokevirtual 661	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   232: aload_1
    //   233: new 479	java/lang/StringBuilder
    //   236: dup
    //   237: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   240: ldc_w 1090
    //   243: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: aload 11
    //   248: invokestatic 853	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   251: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   257: invokestatic 448	com/tencent/smtt/sdk/QbSdk:forceSysWebViewInner	(Landroid/content/Context;Ljava/lang/String;)V
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
    //   275: ldc 151
    //   277: ldc_w 1092
    //   280: iconst_1
    //   281: invokestatic 633	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   284: aload_0
    //   285: aload_1
    //   286: invokespecial 1087	com/tencent/smtt/sdk/TbsInstaller:generateNewTbsCoreFromCopy	(Landroid/content/Context;)V
    //   289: iload 7
    //   291: istore_2
    //   292: goto -101 -> 191
    //   295: astore 11
    //   297: iload 8
    //   299: istore 6
    //   301: getstatic 279	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   304: invokevirtual 609	java/util/concurrent/locks/ReentrantLock:unlock	()V
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
    //   0	327	0	this	TbsInstaller
    //   0	327	1	paramContext	Context
    //   0	327	2	paramBoolean	boolean
    //   104	63	3	i	int
    //   111	59	4	j	int
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
  
  private boolean enableTbsCoreFromTpatch(Context paramContext, boolean paramBoolean)
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
        boolean bool6 = getTbsInstallingFileLock(paramContext);
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
            i = TbsCoreVerManager.getInstance(paramContext).getIntStatus("tpatch_status");
            j = getTbsCoreInstalledVerWithNew(false, paramContext);
            TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromTpatch copyStatus =" + i);
            TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromTpatch tbsCoreInstalledVer =" + j);
            if (i != 1) {
              break label319;
            }
            if (j == 0)
            {
              TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromTpatch tbsCoreInstalledVer = 0", true);
              generateNewTbsCoreFromTpatch(paramContext);
              paramBoolean = bool3;
            }
          }
          finally
          {
            bool2 = bool4;
            mTbsRenameLock.unlock();
            bool2 = bool4;
          }
          try
          {
            mTbsRenameLock.unlock();
            bool1 = paramBoolean;
            bool2 = bool1;
            releaseTbsInstallingFileLock();
          }
          catch (Throwable localThrowable2)
          {
            bool1 = paramBoolean;
            continue;
          }
          localThrowable1 = localThrowable1;
          bool1 = bool2;
          TbsLogReport.getInstance(paramContext).setInstallErrorCode(215, localThrowable1.toString());
          QbSdk.forceSysWebViewInner(paramContext, "TbsInstaller::enableTbsCoreFromTpatch exception:" + Log.getStackTraceString(localThrowable1));
        }
      }
      return bool1;
    }
    finally {}
    boolean bool2 = bool4;
    bool5 = mTbsRenameLock.tryLock();
    bool2 = bool4;
    TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromTpatch Locked =" + bool5);
    if (bool5) {}
    for (;;)
    {
      int i;
      int j;
      if (paramBoolean)
      {
        TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromTpatch tbsCoreInstalledVer != 0", true);
        generateNewTbsCoreFromTpatch(paramContext);
        paramBoolean = bool3;
      }
      else
      {
        label319:
        paramBoolean = false;
      }
    }
  }
  
  private boolean enableTbsCoreFromUnzip(Context paramContext, boolean paramBoolean)
  {
    boolean bool3 = true;
    boolean bool1 = false;
    boolean bool4 = false;
    boolean bool5 = false;
    if (paramContext != null) {}
    label107:
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
        boolean bool6 = getTbsInstallingFileLock(paramContext);
        if (bool6) {
          break label107;
        }
        bool1 = bool5;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          try
          {
            i = TbsCoreVerManager.getInstance(paramContext).getTbsCoreInstallStatus();
            TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip installStatus=" + i);
            j = getTbsCoreInstalledVerWithNew(false, paramContext);
            if (i != 2) {
              break label357;
            }
            TbsLog.i("TbsInstaller", "Tbsinstaller enableTbsCoreFromUnzip #4 ");
            if (j == 0)
            {
              TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip tbsCoreInstalledVer = 0", false);
              generateNewTbsCoreFromUnzip(paramContext);
              paramBoolean = bool3;
            }
          }
          finally
          {
            bool2 = bool4;
            mTbsRenameLock.unlock();
            bool2 = bool4;
          }
          try
          {
            mTbsRenameLock.unlock();
            bool1 = paramBoolean;
            bool2 = bool1;
            releaseTbsInstallingFileLock();
          }
          catch (Exception localException2)
          {
            bool1 = paramBoolean;
            continue;
          }
          localException1 = localException1;
          bool1 = bool2;
          QbSdk.forceSysWebViewInner(paramContext, "TbsInstaller::enableTbsCoreFromUnzip Exception: " + localException1);
          localException1.printStackTrace();
        }
      }
      return bool1;
    }
    finally {}
    boolean bool2 = bool4;
    TbsLog.i("TbsInstaller", "Tbsinstaller enableTbsCoreFromUnzip #2 ");
    bool2 = bool4;
    bool5 = mTbsRenameLock.tryLock();
    bool2 = bool4;
    TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip locked=" + bool5);
    if (bool5) {}
    for (;;)
    {
      int i;
      int j;
      if (paramBoolean)
      {
        TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip tbsCoreInstalledVer != 0", false);
        generateNewTbsCoreFromUnzip(paramContext);
        paramBoolean = bool3;
      }
      else
      {
        label357:
        paramBoolean = false;
      }
    }
  }
  
  /* Error */
  private boolean finalCheckForTbsCoreValidity(File paramFile, Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 8
    //   6: ldc 151
    //   8: new 479	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   15: ldc_w 1156
    //   18: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_1
    //   22: invokevirtual 875	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   25: ldc_w 1158
    //   28: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: aload_2
    //   32: invokevirtual 875	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: aload 6
    //   43: astore_2
    //   44: new 460	java/io/File
    //   47: dup
    //   48: aload_1
    //   49: ldc 99
    //   51: invokespecial 469	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   54: astore 9
    //   56: aload 6
    //   58: astore_2
    //   59: new 726	java/util/Properties
    //   62: dup
    //   63: invokespecial 727	java/util/Properties:<init>	()V
    //   66: astore 7
    //   68: aload 9
    //   70: ifnull +189 -> 259
    //   73: aload 6
    //   75: astore_2
    //   76: aload 9
    //   78: invokevirtual 473	java/io/File:exists	()Z
    //   81: ifeq +178 -> 259
    //   84: aload 7
    //   86: ifnull +173 -> 259
    //   89: aload 6
    //   91: astore_2
    //   92: new 729	java/io/BufferedInputStream
    //   95: dup
    //   96: new 731	java/io/FileInputStream
    //   99: dup
    //   100: aload 9
    //   102: invokespecial 732	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   105: invokespecial 735	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   108: astore 6
    //   110: aload 7
    //   112: aload 6
    //   114: invokevirtual 738	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   117: iconst_1
    //   118: istore 5
    //   120: aload 6
    //   122: astore_2
    //   123: aload 7
    //   125: astore 6
    //   127: iload 5
    //   129: istore 4
    //   131: aload_2
    //   132: ifnull +15 -> 147
    //   135: aload_2
    //   136: invokevirtual 739	java/io/BufferedInputStream:close	()V
    //   139: iload 5
    //   141: istore 4
    //   143: aload 7
    //   145: astore 6
    //   147: ldc 151
    //   149: new 479	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   156: ldc_w 1160
    //   159: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: iload 4
    //   164: invokevirtual 583	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   167: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   173: iload 4
    //   175: ifeq +387 -> 562
    //   178: aload_1
    //   179: invokevirtual 743	java/io/File:listFiles	()[Ljava/io/File;
    //   182: astore_1
    //   183: iconst_0
    //   184: istore_3
    //   185: iload_3
    //   186: aload_1
    //   187: arraylength
    //   188: if_icmpge +374 -> 562
    //   191: aload_1
    //   192: iload_3
    //   193: aaload
    //   194: astore_2
    //   195: ldc 99
    //   197: aload_2
    //   198: invokevirtual 746	java/io/File:getName	()Ljava/lang/String;
    //   201: invokevirtual 752	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   204: ifne +48 -> 252
    //   207: aload_2
    //   208: invokevirtual 746	java/io/File:getName	()Ljava/lang/String;
    //   211: ldc_w 754
    //   214: invokevirtual 758	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   217: ifne +35 -> 252
    //   220: ldc 154
    //   222: aload_2
    //   223: invokevirtual 746	java/io/File:getName	()Ljava/lang/String;
    //   226: invokevirtual 752	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   229: ifne +23 -> 252
    //   232: aload_2
    //   233: invokevirtual 761	java/io/File:isDirectory	()Z
    //   236: ifne +16 -> 252
    //   239: aload_2
    //   240: invokevirtual 746	java/io/File:getName	()Ljava/lang/String;
    //   243: ldc_w 763
    //   246: invokevirtual 758	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   249: ifeq +93 -> 342
    //   252: iload_3
    //   253: iconst_1
    //   254: iadd
    //   255: istore_3
    //   256: goto -71 -> 185
    //   259: aconst_null
    //   260: astore_2
    //   261: iconst_0
    //   262: istore 5
    //   264: goto -141 -> 123
    //   267: astore_2
    //   268: aload_2
    //   269: invokevirtual 519	java/io/IOException:printStackTrace	()V
    //   272: aload 7
    //   274: astore 6
    //   276: iload 5
    //   278: istore 4
    //   280: goto -133 -> 147
    //   283: astore 7
    //   285: aconst_null
    //   286: astore 6
    //   288: aload 8
    //   290: astore_2
    //   291: aload 7
    //   293: invokevirtual 764	java/lang/Exception:printStackTrace	()V
    //   296: aload 8
    //   298: ifnull +270 -> 568
    //   301: aload 8
    //   303: invokevirtual 739	java/io/BufferedInputStream:close	()V
    //   306: iconst_1
    //   307: istore 4
    //   309: goto -162 -> 147
    //   312: astore_2
    //   313: aload_2
    //   314: invokevirtual 519	java/io/IOException:printStackTrace	()V
    //   317: iconst_1
    //   318: istore 4
    //   320: goto -173 -> 147
    //   323: astore_1
    //   324: aload_2
    //   325: ifnull +7 -> 332
    //   328: aload_2
    //   329: invokevirtual 739	java/io/BufferedInputStream:close	()V
    //   332: aload_1
    //   333: athrow
    //   334: astore_2
    //   335: aload_2
    //   336: invokevirtual 519	java/io/IOException:printStackTrace	()V
    //   339: goto -7 -> 332
    //   342: aload_2
    //   343: invokestatic 771	com/tencent/smtt/utils/ApkUtil:getMd5	(Ljava/io/File;)Ljava/lang/String;
    //   346: astore 7
    //   348: aload 6
    //   350: aload_2
    //   351: invokevirtual 746	java/io/File:getName	()Ljava/lang/String;
    //   354: ldc_w 773
    //   357: invokevirtual 777	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   360: astore 8
    //   362: aload 8
    //   364: ldc_w 773
    //   367: invokevirtual 752	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   370: ifne +50 -> 420
    //   373: aload 8
    //   375: aload 7
    //   377: invokevirtual 752	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   380: ifeq +40 -> 420
    //   383: ldc 151
    //   385: new 479	java/lang/StringBuilder
    //   388: dup
    //   389: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   392: ldc_w 779
    //   395: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: aload_2
    //   399: invokevirtual 746	java/io/File:getName	()Ljava/lang/String;
    //   402: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: ldc_w 781
    //   408: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   414: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   417: goto -165 -> 252
    //   420: ldc 151
    //   422: new 479	java/lang/StringBuilder
    //   425: dup
    //   426: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   429: ldc_w 783
    //   432: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: aload_2
    //   436: invokevirtual 746	java/io/File:getName	()Ljava/lang/String;
    //   439: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: ldc_w 785
    //   445: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: aload 8
    //   450: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: ldc_w 787
    //   456: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: aload 7
    //   461: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   467: invokestatic 393	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   470: iconst_0
    //   471: istore 5
    //   473: ldc 151
    //   475: new 479	java/lang/StringBuilder
    //   478: dup
    //   479: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   482: ldc_w 1162
    //   485: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   488: iload 5
    //   490: invokevirtual 583	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   493: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   496: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   499: iload 4
    //   501: ifeq +18 -> 519
    //   504: iload 5
    //   506: ifne +13 -> 519
    //   509: ldc 151
    //   511: ldc_w 1164
    //   514: invokestatic 393	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   517: iconst_0
    //   518: ireturn
    //   519: ldc 151
    //   521: ldc_w 1166
    //   524: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   527: iconst_1
    //   528: ireturn
    //   529: astore_1
    //   530: aload 6
    //   532: astore_2
    //   533: goto -209 -> 324
    //   536: astore_2
    //   537: aload 7
    //   539: astore 6
    //   541: aload_2
    //   542: astore 7
    //   544: goto -256 -> 288
    //   547: astore_2
    //   548: aload 6
    //   550: astore 8
    //   552: aload 7
    //   554: astore 6
    //   556: aload_2
    //   557: astore 7
    //   559: goto -271 -> 288
    //   562: iconst_1
    //   563: istore 5
    //   565: goto -92 -> 473
    //   568: iconst_1
    //   569: istore 4
    //   571: goto -424 -> 147
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	574	0	this	TbsInstaller
    //   0	574	1	paramFile	File
    //   0	574	2	paramContext	Context
    //   184	72	3	i	int
    //   129	441	4	bool1	boolean
    //   118	446	5	bool2	boolean
    //   1	554	6	localObject1	Object
    //   66	207	7	localProperties	java.util.Properties
    //   283	9	7	localException	Exception
    //   346	212	7	localObject2	Object
    //   4	547	8	localObject3	Object
    //   54	47	9	localFile	File
    // Exception table:
    //   from	to	target	type
    //   135	139	267	java/io/IOException
    //   44	56	283	java/lang/Exception
    //   59	68	283	java/lang/Exception
    //   301	306	312	java/io/IOException
    //   44	56	323	finally
    //   59	68	323	finally
    //   76	84	323	finally
    //   92	110	323	finally
    //   291	296	323	finally
    //   328	332	334	java/io/IOException
    //   110	117	529	finally
    //   76	84	536	java/lang/Exception
    //   92	110	536	java/lang/Exception
    //   110	117	547	java/lang/Exception
  }
  
  /* Error */
  private void finishLocalTbsInstall(int paramInt, String paramString, Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: new 460	java/io/File
    //   9: dup
    //   10: aload_2
    //   11: invokespecial 1034	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: invokevirtual 1170	java/io/File:delete	()Z
    //   17: pop
    //   18: ldc 151
    //   20: new 479	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   27: ldc_w 1172
    //   30: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_2
    //   34: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc_w 1174
    //   40: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: iconst_1
    //   47: invokestatic 633	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   50: new 460	java/io/File
    //   53: dup
    //   54: aload_3
    //   55: invokestatic 1177	com/tencent/smtt/sdk/QbSdk:getTbsFolderDir	(Landroid/content/Context;)Ljava/io/File;
    //   58: ldc 219
    //   60: invokespecial 469	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   63: astore_2
    //   64: aload_2
    //   65: ifnull +111 -> 176
    //   68: aload_2
    //   69: invokevirtual 1180	java/io/File:canRead	()Z
    //   72: ifeq +104 -> 176
    //   75: new 460	java/io/File
    //   78: dup
    //   79: aload_2
    //   80: ldc 154
    //   82: invokespecial 469	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   85: astore_2
    //   86: new 726	java/util/Properties
    //   89: dup
    //   90: invokespecial 727	java/util/Properties:<init>	()V
    //   93: astore 6
    //   95: new 729	java/io/BufferedInputStream
    //   98: dup
    //   99: new 731	java/io/FileInputStream
    //   102: dup
    //   103: aload_2
    //   104: invokespecial 732	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   107: invokespecial 735	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   110: astore_3
    //   111: aload 6
    //   113: aload_3
    //   114: invokevirtual 738	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   117: new 1182	java/io/BufferedOutputStream
    //   120: dup
    //   121: new 502	java/io/FileOutputStream
    //   124: dup
    //   125: aload_2
    //   126: invokespecial 505	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   129: invokespecial 1185	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   132: astore_2
    //   133: aload 6
    //   135: ldc 173
    //   137: ldc_w 1187
    //   140: invokevirtual 1191	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   143: pop
    //   144: aload 6
    //   146: aload_2
    //   147: aconst_null
    //   148: invokevirtual 1195	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   151: ldc 151
    //   153: ldc_w 1197
    //   156: iconst_1
    //   157: invokestatic 633	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   160: aload_2
    //   161: ifnull +7 -> 168
    //   164: aload_2
    //   165: invokevirtual 1198	java/io/BufferedOutputStream:close	()V
    //   168: aload_3
    //   169: ifnull +7 -> 176
    //   172: aload_3
    //   173: invokevirtual 739	java/io/BufferedInputStream:close	()V
    //   176: return
    //   177: astore_2
    //   178: aload_2
    //   179: invokevirtual 519	java/io/IOException:printStackTrace	()V
    //   182: goto -14 -> 168
    //   185: astore_2
    //   186: aload_2
    //   187: invokevirtual 519	java/io/IOException:printStackTrace	()V
    //   190: return
    //   191: astore 4
    //   193: aconst_null
    //   194: astore_2
    //   195: aload 5
    //   197: astore_3
    //   198: aload 4
    //   200: invokevirtual 1199	java/lang/Throwable:printStackTrace	()V
    //   203: aload_2
    //   204: ifnull +7 -> 211
    //   207: aload_2
    //   208: invokevirtual 1198	java/io/BufferedOutputStream:close	()V
    //   211: aload_3
    //   212: ifnull -36 -> 176
    //   215: aload_3
    //   216: invokevirtual 739	java/io/BufferedInputStream:close	()V
    //   219: return
    //   220: astore_2
    //   221: aload_2
    //   222: invokevirtual 519	java/io/IOException:printStackTrace	()V
    //   225: return
    //   226: astore_2
    //   227: aload_2
    //   228: invokevirtual 519	java/io/IOException:printStackTrace	()V
    //   231: goto -20 -> 211
    //   234: astore_2
    //   235: aconst_null
    //   236: astore_3
    //   237: aload 4
    //   239: ifnull +8 -> 247
    //   242: aload 4
    //   244: invokevirtual 1198	java/io/BufferedOutputStream:close	()V
    //   247: aload_3
    //   248: ifnull +7 -> 255
    //   251: aload_3
    //   252: invokevirtual 739	java/io/BufferedInputStream:close	()V
    //   255: aload_2
    //   256: athrow
    //   257: astore 4
    //   259: aload 4
    //   261: invokevirtual 519	java/io/IOException:printStackTrace	()V
    //   264: goto -17 -> 247
    //   267: astore_3
    //   268: aload_3
    //   269: invokevirtual 519	java/io/IOException:printStackTrace	()V
    //   272: goto -17 -> 255
    //   275: astore_2
    //   276: goto -39 -> 237
    //   279: astore 5
    //   281: aload_2
    //   282: astore 4
    //   284: aload 5
    //   286: astore_2
    //   287: goto -50 -> 237
    //   290: astore 5
    //   292: aload_2
    //   293: astore 4
    //   295: aload 5
    //   297: astore_2
    //   298: goto -61 -> 237
    //   301: astore 4
    //   303: aconst_null
    //   304: astore_2
    //   305: goto -107 -> 198
    //   308: astore 4
    //   310: goto -112 -> 198
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	313	0	this	TbsInstaller
    //   0	313	1	paramInt	int
    //   0	313	2	paramString	String
    //   0	313	3	paramContext	Context
    //   1	1	4	localObject1	Object
    //   191	52	4	localThrowable1	Throwable
    //   257	3	4	localIOException	java.io.IOException
    //   282	12	4	str	String
    //   301	1	4	localThrowable2	Throwable
    //   308	1	4	localThrowable3	Throwable
    //   4	192	5	localObject2	Object
    //   279	6	5	localObject3	Object
    //   290	6	5	localObject4	Object
    //   93	52	6	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   164	168	177	java/io/IOException
    //   172	176	185	java/io/IOException
    //   95	111	191	java/lang/Throwable
    //   215	219	220	java/io/IOException
    //   207	211	226	java/io/IOException
    //   95	111	234	finally
    //   242	247	257	java/io/IOException
    //   251	255	267	java/io/IOException
    //   111	133	275	finally
    //   133	160	279	finally
    //   198	203	290	finally
    //   111	133	301	java/lang/Throwable
    //   133	160	308	java/lang/Throwable
  }
  
  private void generateNewTbsCoreFromCopy(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromCopy");
    if (!getTbsCoreRenameFileLock(paramContext))
    {
      TbsLog.i("TbsInstaller", "get rename fileLock#4 ## failed!");
      return;
    }
    for (;;)
    {
      try
      {
        deleteOldTbsCore(paramContext);
        renameTbsCoreCopyDir(paramContext);
        TbsShareManager.shareTbsCore(paramContext);
        TbsCoreVerManager.getInstance(paramContext).setTbsCoreCopyStatus(0, 3);
        TbsCoreVerManager.getInstance(paramContext).setStatus("tpatch_num", 0);
        if (!TbsShareManager.isThirdPartyApp(paramContext))
        {
          i = TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_decouplecoreversion", 0);
          if ((i <= 0) || (i == getInstance().getTbsCoreShareDecoupleCoreVersion(paramContext)) || (i != getInstance().getTbsCoreInstalledVerInNolock(paramContext))) {
            continue;
          }
          coreShareCopyToDecouple(paramContext);
        }
        mTbsCoreInstalledVer.set(Integer.valueOf(0));
      }
      catch (Exception localException)
      {
        int i;
        localException.printStackTrace();
        TbsLogReport.getInstance(paramContext).setInstallErrorCode(219, "exception when renameing from copy:" + localException.toString());
        continue;
      }
      releaseTbsCoreRenameFileLock(paramContext);
      return;
      TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromCopy #1 deCoupleCoreVersion is " + i + " getTbsCoreShareDecoupleCoreVersion is " + getInstance().getTbsCoreShareDecoupleCoreVersion(paramContext) + " getTbsCoreInstalledVerInNolock is " + getInstance().getTbsCoreInstalledVerInNolock(paramContext));
    }
  }
  
  private void generateNewTbsCoreFromTpatch(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromTpatch");
    if (!getTbsCoreRenameFileLock(paramContext))
    {
      TbsLog.i("TbsInstaller", "get rename fileLock#4 ## failed!");
      return;
    }
    try
    {
      deleteOldTbsCore(paramContext);
      renameTbsTpatchCoreDir(paramContext);
      TbsShareManager.shareTbsCore(paramContext);
      TbsCoreVerManager.getInstance(paramContext).setTbsCoreTpatchStatus(0, -1);
      TbsCoreVerManager.getInstance(paramContext).setStatus("tpatch_num", 0);
      mTbsCoreInstalledVer.set(Integer.valueOf(0));
      releaseTbsCoreRenameFileLock(paramContext);
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
  
  private void generateNewTbsCoreFromUnzip(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip");
    if (!getTbsCoreRenameFileLock(paramContext))
    {
      TbsLog.i("TbsInstaller", "get rename fileLock#4 ## failed!");
      return;
    }
    for (;;)
    {
      try
      {
        deleteOldTbsCore(paramContext);
        renameTbsCoreShareDir(paramContext);
        TbsLog.i("TbsInstaller", "after renameTbsCoreShareDir");
        if (TbsShareManager.isThirdPartyApp(paramContext)) {
          continue;
        }
        TbsLog.i("TbsInstaller", "prepare to shareTbsCore");
        TbsShareManager.shareTbsCore(paramContext);
        TbsCoreVerManager.getInstance(paramContext).setTbsCoreDexoptRetryNum(0);
        TbsCoreVerManager.getInstance(paramContext).setTbsCoreUnzipRetryNum(0);
        TbsCoreVerManager.getInstance(paramContext).setTbsCoreUnlzmaStatus(0);
        TbsCoreVerManager.getInstance(paramContext).setStatus("incrupdate_retry_num", 0);
        TbsCoreVerManager.getInstance(paramContext).setTbsCoreInstallStatus(0, 3);
        TbsCoreVerManager.getInstance(paramContext).setTbsApkPath("");
        TbsCoreVerManager.getInstance(paramContext).setStatus("tpatch_num", 0);
        TbsCoreVerManager.getInstance(paramContext).setTbsCoreIncrUpdateStatus(-1);
        if (!TbsShareManager.isThirdPartyApp(paramContext))
        {
          i = TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_decouplecoreversion", 0);
          if ((i <= 0) || (i == getInstance().getTbsCoreShareDecoupleCoreVersion(paramContext)) || (i != getInstance().getTbsCoreInstalledVerInNolock(paramContext))) {
            continue;
          }
          coreShareCopyToDecouple(paramContext);
        }
      }
      catch (Throwable localThrowable)
      {
        int i;
        localThrowable.printStackTrace();
        TbsLogReport.getInstance(paramContext).setInstallErrorCode(219, "exception when renameing from unzip:" + localThrowable.toString());
        TbsLog.e("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip Exception", true);
        continue;
        TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip #1 deCoupleCoreVersion is " + i + " getTbsCoreShareDecoupleCoreVersion is " + getInstance().getTbsCoreShareDecoupleCoreVersion(paramContext) + " getTbsCoreInstalledVerInNolock is " + getInstance().getTbsCoreInstalledVerInNolock(paramContext));
        continue;
      }
      if (TbsShareManager.isThirdPartyApp(paramContext)) {
        TbsShareManager.writeCoreInfoForThirdPartyApp(paramContext, getTbsCoreInstalledVerWithLock(paramContext), true);
      }
      mTbsCoreInstalledVer.set(Integer.valueOf(0));
      mCoreVersion = 0;
      releaseTbsCoreRenameFileLock(paramContext);
      return;
      TbsLog.i("TbsInstaller", "is thirdapp and not chmod");
    }
  }
  
  /* Error */
  private String getInstalledTbsTimeStamp(Context paramContext)
  {
    // Byte code:
    //   0: new 460	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: aload_1
    //   6: invokevirtual 688	com/tencent/smtt/sdk/TbsInstaller:getTbsCoreShareDir	(Landroid/content/Context;)Ljava/io/File;
    //   9: ldc 154
    //   11: invokespecial 469	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   14: astore_1
    //   15: aload_1
    //   16: ifnull +12 -> 28
    //   19: aload_1
    //   20: invokevirtual 473	java/io/File:exists	()Z
    //   23: istore_2
    //   24: iload_2
    //   25: ifne +17 -> 42
    //   28: iconst_0
    //   29: ifeq +11 -> 40
    //   32: new 1297	java/lang/NullPointerException
    //   35: dup
    //   36: invokespecial 1298	java/lang/NullPointerException:<init>	()V
    //   39: athrow
    //   40: aconst_null
    //   41: areturn
    //   42: new 726	java/util/Properties
    //   45: dup
    //   46: invokespecial 727	java/util/Properties:<init>	()V
    //   49: astore_3
    //   50: new 729	java/io/BufferedInputStream
    //   53: dup
    //   54: new 731	java/io/FileInputStream
    //   57: dup
    //   58: aload_1
    //   59: invokespecial 732	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   62: invokespecial 735	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   65: astore_1
    //   66: aload_3
    //   67: aload_1
    //   68: invokevirtual 738	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   71: aload_1
    //   72: invokevirtual 739	java/io/BufferedInputStream:close	()V
    //   75: aload_3
    //   76: ldc 157
    //   78: invokevirtual 1299	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   81: astore_3
    //   82: aload_3
    //   83: ifnonnull +16 -> 99
    //   86: aload_1
    //   87: ifnull -47 -> 40
    //   90: aload_1
    //   91: invokevirtual 739	java/io/BufferedInputStream:close	()V
    //   94: aconst_null
    //   95: areturn
    //   96: astore_1
    //   97: aconst_null
    //   98: areturn
    //   99: aload_1
    //   100: ifnull +7 -> 107
    //   103: aload_1
    //   104: invokevirtual 739	java/io/BufferedInputStream:close	()V
    //   107: aload_3
    //   108: areturn
    //   109: astore_1
    //   110: aconst_null
    //   111: astore_1
    //   112: aload_1
    //   113: ifnull -73 -> 40
    //   116: aload_1
    //   117: invokevirtual 739	java/io/BufferedInputStream:close	()V
    //   120: aconst_null
    //   121: areturn
    //   122: astore_1
    //   123: aconst_null
    //   124: areturn
    //   125: astore_3
    //   126: aconst_null
    //   127: astore_1
    //   128: aload_1
    //   129: ifnull +7 -> 136
    //   132: aload_1
    //   133: invokevirtual 739	java/io/BufferedInputStream:close	()V
    //   136: aload_3
    //   137: athrow
    //   138: astore_1
    //   139: aconst_null
    //   140: areturn
    //   141: astore_1
    //   142: goto -35 -> 107
    //   145: astore_1
    //   146: goto -10 -> 136
    //   149: astore_3
    //   150: goto -22 -> 128
    //   153: astore_3
    //   154: goto -42 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	this	TbsInstaller
    //   0	157	1	paramContext	Context
    //   23	2	2	bool	boolean
    //   49	59	3	localObject1	Object
    //   125	12	3	localObject2	Object
    //   149	1	3	localObject3	Object
    //   153	1	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   90	94	96	java/io/IOException
    //   0	15	109	java/lang/Exception
    //   19	24	109	java/lang/Exception
    //   42	66	109	java/lang/Exception
    //   116	120	122	java/io/IOException
    //   0	15	125	finally
    //   19	24	125	finally
    //   42	66	125	finally
    //   32	40	138	java/io/IOException
    //   103	107	141	java/io/IOException
    //   132	136	145	java/io/IOException
    //   66	82	149	finally
    //   66	82	153	java/lang/Exception
  }
  
  /* Error */
  static TbsInstaller getInstance()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 272	com/tencent/smtt/sdk/TbsInstaller:mInstance	Lcom/tencent/smtt/sdk/TbsInstaller;
    //   6: ifnonnull +25 -> 31
    //   9: ldc 2
    //   11: monitorenter
    //   12: getstatic 272	com/tencent/smtt/sdk/TbsInstaller:mInstance	Lcom/tencent/smtt/sdk/TbsInstaller;
    //   15: ifnonnull +13 -> 28
    //   18: new 2	com/tencent/smtt/sdk/TbsInstaller
    //   21: dup
    //   22: invokespecial 1300	com/tencent/smtt/sdk/TbsInstaller:<init>	()V
    //   25: putstatic 272	com/tencent/smtt/sdk/TbsInstaller:mInstance	Lcom/tencent/smtt/sdk/TbsInstaller;
    //   28: ldc 2
    //   30: monitorexit
    //   31: getstatic 272	com/tencent/smtt/sdk/TbsInstaller:mInstance	Lcom/tencent/smtt/sdk/TbsInstaller;
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
    //   34	5	0	localTbsInstaller	TbsInstaller
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
  
  private int getSuccessErrorCode(Context paramContext)
  {
    int i = 1;
    if (TbsCoreVerManager.getInstance(paramContext).getTbsCoreIncrUpdateStatus() == 1) {}
    boolean bool;
    for (;;)
    {
      bool = TbsDownloader.isDecoupleCore(paramContext);
      if (i == 0) {
        break label39;
      }
      if (!bool) {
        break;
      }
      return 234;
      i = 0;
    }
    return 221;
    label39:
    if (bool) {
      return 233;
    }
    return 200;
  }
  
  static File getTbsCorePrivateDir(Context paramContext)
  {
    paramContext = new File(QbSdk.getTbsFolderDir(paramContext), "core_private");
    if ((paramContext == null) || ((!paramContext.isDirectory()) && (!paramContext.mkdir()))) {
      return null;
    }
    return paramContext;
  }
  
  private boolean getTbsCoreRenameFileLock(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "Tbsinstaller getTbsCoreRenameFileLock #1 ");
    try
    {
      bool = TbsDownloadConfig.getInstance().getTbsCoreLoadRenameFileLockEnable();
      TbsLog.i("TbsInstaller", "Tbsinstaller getTbsCoreRenameFileLock #2  enabled is " + bool);
      if (!bool)
      {
        mTbsCoreRenameFileLockForMultiProcess = X5CoreEngine.getInstance().tryTbsCoreLoadFileLock(paramContext);
        if (mTbsCoreRenameFileLockForMultiProcess != null) {
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
        mTbsCoreRenameFileLockForMultiProcess = FileUtil.getTbsCoreRenameFileLock(paramContext);
      }
      label86:
      TbsLog.i("TbsInstaller", "Tbsinstaller getTbsCoreRenameFileLock true ");
    }
    return true;
  }
  
  private String getTbsCoreTimeStampFromApk(Context paramContext, String paramString)
  {
    paramContext = paramContext.getPackageManager().getPackageArchiveInfo(paramString, 128);
    if (paramContext != null)
    {
      TbsLog.i("TbsInstaller", "TbsInstaller-getTbsCoreTimeStampFromApk  timestamp=" + paramContext.applicationInfo.metaData.getString("TIMESTAMP"));
      return paramContext.applicationInfo.metaData.getString("TIMESTAMP");
    }
    return null;
  }
  
  private static boolean getTmpFolderCoreToRead(Context paramContext)
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
  
  private void installForDecoupleCore(Context paramContext, int paramInt)
  {
    File localFile1 = getInstance().getCoreDir(paramContext, paramInt);
    getInstance().setTmpFolderCoreToRead(paramContext, true);
    File localFile2 = getCoreShareDecoupleDir(paramContext);
    FileUtil.delete(localFile2, true);
    localFile1.renameTo(localFile2);
    TbsShareManager.shareCoreShareDecouple(paramContext);
  }
  
  /* Error */
  @android.annotation.TargetApi(11)
  private void installTbsCoreInThread(Context paramContext, String paramString, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 7
    //   3: iconst_1
    //   4: istore 8
    //   6: aload_1
    //   7: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   10: sipush -501
    //   13: invokevirtual 539	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   16: aload_0
    //   17: aload_1
    //   18: invokevirtual 542	com/tencent/smtt/sdk/TbsInstaller:isTbsLocalInstalled	(Landroid/content/Context;)Z
    //   21: ifeq +23 -> 44
    //   24: ldc 151
    //   26: ldc_w 1376
    //   29: iconst_1
    //   30: invokestatic 633	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   33: aload_1
    //   34: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   37: sipush -502
    //   40: invokevirtual 539	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   43: return
    //   44: ldc 151
    //   46: new 479	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   53: ldc_w 1378
    //   56: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: aload_2
    //   60: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   69: ldc 151
    //   71: new 479	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   78: ldc_w 1380
    //   81: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: iload_3
    //   85: invokevirtual 547	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   88: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   94: ldc 151
    //   96: new 479	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   103: ldc_w 1382
    //   106: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: aload_1
    //   110: invokevirtual 1121	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   113: getfield 1385	android/content/pm/ApplicationInfo:processName	Ljava/lang/String;
    //   116: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   125: ldc 151
    //   127: new 479	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   134: ldc_w 1387
    //   137: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: invokestatic 1392	android/os/Process:myPid	()I
    //   143: invokevirtual 547	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   146: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   152: ldc 151
    //   154: new 479	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   161: ldc_w 1394
    //   164: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: invokestatic 1398	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   170: invokevirtual 1399	java/lang/Thread:getName	()Ljava/lang/String;
    //   173: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   182: getstatic 552	android/os/Build$VERSION:SDK_INT	I
    //   185: bipush 11
    //   187: if_icmplt +70 -> 257
    //   190: aload_1
    //   191: ldc_w 554
    //   194: iconst_4
    //   195: invokevirtual 558	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   198: astore 15
    //   200: aload 15
    //   202: ldc_w 560
    //   205: iconst_m1
    //   206: invokeinterface 566 3 0
    //   211: iload_3
    //   212: if_icmpne +58 -> 270
    //   215: ldc 151
    //   217: new 479	java/lang/StringBuilder
    //   220: dup
    //   221: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   224: ldc_w 1401
    //   227: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: iload_3
    //   231: invokevirtual 547	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   234: ldc_w 570
    //   237: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   243: invokestatic 393	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   246: aload_1
    //   247: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   250: sipush -503
    //   253: invokevirtual 539	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   256: return
    //   257: aload_1
    //   258: ldc_w 554
    //   261: iconst_0
    //   262: invokevirtual 558	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   265: astore 15
    //   267: goto -67 -> 200
    //   270: aload_1
    //   271: invokestatic 636	com/tencent/smtt/utils/FileUtil:hasEnoughFreeSpace	(Landroid/content/Context;)Z
    //   274: ifne +70 -> 344
    //   277: invokestatic 642	com/tencent/smtt/utils/TbsUtils:getROMAvailableSize	()J
    //   280: lstore 10
    //   282: aload_1
    //   283: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   286: invokevirtual 645	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMinFreeSpace	()J
    //   289: lstore 12
    //   291: aload_1
    //   292: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   295: sipush -504
    //   298: invokevirtual 539	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   301: aload_1
    //   302: invokestatic 650	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   305: sipush 210
    //   308: new 479	java/lang/StringBuilder
    //   311: dup
    //   312: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   315: ldc_w 1403
    //   318: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: lload 10
    //   323: invokevirtual 655	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   326: ldc_w 657
    //   329: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: lload 12
    //   334: invokevirtual 655	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   337: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   340: invokevirtual 661	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   343: return
    //   344: aload_0
    //   345: aload_1
    //   346: invokevirtual 573	com/tencent/smtt/sdk/TbsInstaller:getTbsInstallingFileLock	(Landroid/content/Context;)Z
    //   349: ifne +14 -> 363
    //   352: aload_1
    //   353: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   356: sipush -505
    //   359: invokevirtual 539	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   362: return
    //   363: getstatic 281	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   366: invokeinterface 578 1 0
    //   371: istore 14
    //   373: ldc 151
    //   375: new 479	java/lang/StringBuilder
    //   378: dup
    //   379: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   382: ldc_w 1405
    //   385: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: iload 14
    //   390: invokevirtual 583	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   393: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   396: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   399: iload 14
    //   401: ifeq +1969 -> 2370
    //   404: aload_1
    //   405: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   408: sipush -507
    //   411: invokevirtual 539	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   414: getstatic 279	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   417: invokevirtual 586	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   420: aload_1
    //   421: invokestatic 432	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   424: ldc_w 588
    //   427: invokevirtual 592	com/tencent/smtt/sdk/TbsCoreVerManager:getIntNum	(Ljava/lang/String;)I
    //   430: istore 4
    //   432: aload_1
    //   433: invokestatic 432	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   436: invokevirtual 625	com/tencent/smtt/sdk/TbsCoreVerManager:getTbsCoreInstallVer	()I
    //   439: istore 5
    //   441: ldc 151
    //   443: new 479	java/lang/StringBuilder
    //   446: dup
    //   447: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   450: ldc_w 1407
    //   453: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: iload 4
    //   458: invokevirtual 547	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   461: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   464: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   467: ldc 151
    //   469: new 479	java/lang/StringBuilder
    //   472: dup
    //   473: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   476: ldc_w 1409
    //   479: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: iload 5
    //   484: invokevirtual 547	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   487: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   490: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   493: ldc 151
    //   495: new 479	java/lang/StringBuilder
    //   498: dup
    //   499: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   502: ldc_w 1411
    //   505: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: iload_3
    //   509: invokevirtual 547	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   512: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   515: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   518: iload 5
    //   520: ifle +1876 -> 2396
    //   523: iload_3
    //   524: iload 5
    //   526: if_icmpgt +6 -> 532
    //   529: goto +1867 -> 2396
    //   532: aload_0
    //   533: aload_1
    //   534: invokevirtual 628	com/tencent/smtt/sdk/TbsInstaller:cleanStatusAndTmpDir	(Landroid/content/Context;)V
    //   537: aload_1
    //   538: invokestatic 432	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   541: invokevirtual 1139	com/tencent/smtt/sdk/TbsCoreVerManager:getTbsCoreInstallStatus	()I
    //   544: istore 5
    //   546: aload_0
    //   547: aload_1
    //   548: invokevirtual 617	com/tencent/smtt/sdk/TbsInstaller:getTbsCoreInstalledVerInNolock	(Landroid/content/Context;)I
    //   551: istore 6
    //   553: ldc 151
    //   555: new 479	java/lang/StringBuilder
    //   558: dup
    //   559: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   562: ldc_w 1413
    //   565: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   568: iload 5
    //   570: invokevirtual 547	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   573: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   576: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   579: ldc 151
    //   581: new 479	java/lang/StringBuilder
    //   584: dup
    //   585: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   588: ldc_w 1415
    //   591: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   594: iload 6
    //   596: invokevirtual 547	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   599: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   602: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   605: iload 5
    //   607: iflt +159 -> 766
    //   610: iload 5
    //   612: iconst_2
    //   613: if_icmpge +153 -> 766
    //   616: ldc 151
    //   618: ldc_w 1417
    //   621: iconst_1
    //   622: invokestatic 633	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   625: iconst_1
    //   626: istore 6
    //   628: aload_1
    //   629: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   632: sipush -508
    //   635: invokevirtual 539	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   638: ldc 151
    //   640: new 479	java/lang/StringBuilder
    //   643: dup
    //   644: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   647: ldc_w 1419
    //   650: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   653: iload 5
    //   655: invokevirtual 547	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   658: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   661: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   664: iload 5
    //   666: iconst_1
    //   667: if_icmpge +1156 -> 1823
    //   670: ldc 151
    //   672: ldc_w 1421
    //   675: iconst_1
    //   676: invokestatic 633	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   679: aload_1
    //   680: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   683: sipush -509
    //   686: invokevirtual 539	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   689: iload 6
    //   691: ifeq +157 -> 848
    //   694: aload_1
    //   695: invokestatic 432	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   698: ldc_w 1423
    //   701: invokevirtual 592	com/tencent/smtt/sdk/TbsCoreVerManager:getIntNum	(Ljava/lang/String;)I
    //   704: istore 4
    //   706: iload 4
    //   708: bipush 10
    //   710: if_icmple +127 -> 837
    //   713: aload_1
    //   714: invokestatic 650	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   717: sipush 201
    //   720: ldc_w 1425
    //   723: invokevirtual 661	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   726: aload_0
    //   727: aload_1
    //   728: invokespecial 1427	com/tencent/smtt/sdk/TbsInstaller:clearNewTbsCore	(Landroid/content/Context;)V
    //   731: aload_1
    //   732: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   735: sipush -510
    //   738: invokevirtual 539	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   741: getstatic 279	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   744: invokevirtual 609	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   747: getstatic 281	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   750: invokeinterface 610 1 0
    //   755: aload_0
    //   756: invokevirtual 613	com/tencent/smtt/sdk/TbsInstaller:releaseTbsInstallingFileLock	()V
    //   759: return
    //   760: astore_1
    //   761: aload_1
    //   762: invokevirtual 764	java/lang/Exception:printStackTrace	()V
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
    //   796: ldc_w 876
    //   799: if_icmpne +20 -> 819
    //   802: iconst_m1
    //   803: istore 4
    //   805: aload_0
    //   806: aload_1
    //   807: invokevirtual 628	com/tencent/smtt/sdk/TbsInstaller:cleanStatusAndTmpDir	(Landroid/content/Context;)V
    //   810: ldc 151
    //   812: ldc_w 1429
    //   815: iconst_1
    //   816: invokestatic 633	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   819: iconst_0
    //   820: istore 6
    //   822: iload 4
    //   824: istore 5
    //   826: goto -198 -> 628
    //   829: astore_1
    //   830: aload_1
    //   831: invokevirtual 764	java/lang/Exception:printStackTrace	()V
    //   834: goto -79 -> 755
    //   837: aload_1
    //   838: invokestatic 432	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   841: iload 4
    //   843: iconst_1
    //   844: iadd
    //   845: invokevirtual 1268	com/tencent/smtt/sdk/TbsCoreVerManager:setTbsCoreUnzipRetryNum	(I)V
    //   848: aload_2
    //   849: ifnonnull +80 -> 929
    //   852: aload_1
    //   853: invokestatic 432	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   856: ldc_w 1431
    //   859: invokevirtual 1434	com/tencent/smtt/sdk/TbsCoreVerManager:getStringValue	(Ljava/lang/String;)Ljava/lang/String;
    //   862: astore 16
    //   864: aload 16
    //   866: astore 15
    //   868: aload 16
    //   870: ifnonnull +62 -> 932
    //   873: aload_1
    //   874: invokestatic 650	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   877: sipush 202
    //   880: ldc_w 1436
    //   883: invokevirtual 661	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   886: aload_1
    //   887: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   890: sipush -511
    //   893: invokevirtual 539	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   896: getstatic 279	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   899: invokevirtual 609	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   902: getstatic 281	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   905: invokeinterface 610 1 0
    //   910: aload_0
    //   911: invokevirtual 613	com/tencent/smtt/sdk/TbsInstaller:releaseTbsInstallingFileLock	()V
    //   914: return
    //   915: astore_1
    //   916: aload_1
    //   917: invokevirtual 764	java/lang/Exception:printStackTrace	()V
    //   920: return
    //   921: astore_1
    //   922: aload_1
    //   923: invokevirtual 764	java/lang/Exception:printStackTrace	()V
    //   926: goto -16 -> 910
    //   929: aload_2
    //   930: astore 15
    //   932: ldc 151
    //   934: new 479	java/lang/StringBuilder
    //   937: dup
    //   938: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   941: ldc_w 1438
    //   944: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   947: aload 15
    //   949: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   952: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   955: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   958: aload_0
    //   959: aload_1
    //   960: aload 15
    //   962: invokevirtual 1442	com/tencent/smtt/sdk/TbsInstaller:getTbsCoreVerFromApk	(Landroid/content/Context;Ljava/lang/String;)I
    //   965: istore 9
    //   967: iload 9
    //   969: ifne +59 -> 1028
    //   972: aload_1
    //   973: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   976: sipush -512
    //   979: invokevirtual 539	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   982: aload_1
    //   983: invokestatic 650	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   986: sipush 203
    //   989: ldc_w 1444
    //   992: invokevirtual 661	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   995: getstatic 279	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   998: invokevirtual 609	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1001: getstatic 281	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   1004: invokeinterface 610 1 0
    //   1009: aload_0
    //   1010: invokevirtual 613	com/tencent/smtt/sdk/TbsInstaller:releaseTbsInstallingFileLock	()V
    //   1013: return
    //   1014: astore_1
    //   1015: aload_1
    //   1016: invokevirtual 764	java/lang/Exception:printStackTrace	()V
    //   1019: return
    //   1020: astore_1
    //   1021: aload_1
    //   1022: invokevirtual 764	java/lang/Exception:printStackTrace	()V
    //   1025: goto -16 -> 1009
    //   1028: aload_1
    //   1029: invokestatic 432	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   1032: ldc_w 1431
    //   1035: aload 15
    //   1037: invokevirtual 1446	com/tencent/smtt/sdk/TbsCoreVerManager:setStatus	(Ljava/lang/String;Ljava/lang/String;)V
    //   1040: aload_1
    //   1041: invokestatic 432	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   1044: iload 9
    //   1046: iconst_0
    //   1047: invokevirtual 436	com/tencent/smtt/sdk/TbsCoreVerManager:setTbsCoreInstallStatus	(II)V
    //   1050: aload_1
    //   1051: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1054: sipush -548
    //   1057: invokevirtual 539	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1060: aload_1
    //   1061: invokestatic 671	com/tencent/smtt/sdk/TbsDownloader:isDecoupleCore	(Landroid/content/Context;)Z
    //   1064: ifeq +70 -> 1134
    //   1067: aload_0
    //   1068: aload_1
    //   1069: new 460	java/io/File
    //   1072: dup
    //   1073: aload 15
    //   1075: invokespecial 1034	java/io/File:<init>	(Ljava/lang/String;)V
    //   1078: iconst_1
    //   1079: invokespecial 1450	com/tencent/smtt/sdk/TbsInstaller:unzipTbsApk	(Landroid/content/Context;Ljava/io/File;Z)Z
    //   1082: ifne +115 -> 1197
    //   1085: aload_1
    //   1086: invokestatic 650	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1089: sipush 207
    //   1092: ldc_w 1452
    //   1095: getstatic 1458	com/tencent/smtt/sdk/TbsLogReport$EventType:TYPE_INSTALL_DECOUPLE	Lcom/tencent/smtt/sdk/TbsLogReport$EventType;
    //   1098: invokevirtual 1461	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;Lcom/tencent/smtt/sdk/TbsLogReport$EventType;)V
    //   1101: getstatic 279	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   1104: invokevirtual 609	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1107: getstatic 281	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   1110: invokeinterface 610 1 0
    //   1115: aload_0
    //   1116: invokevirtual 613	com/tencent/smtt/sdk/TbsInstaller:releaseTbsInstallingFileLock	()V
    //   1119: return
    //   1120: astore_1
    //   1121: aload_1
    //   1122: invokevirtual 764	java/lang/Exception:printStackTrace	()V
    //   1125: return
    //   1126: astore_1
    //   1127: aload_1
    //   1128: invokevirtual 764	java/lang/Exception:printStackTrace	()V
    //   1131: goto -16 -> 1115
    //   1134: aload_0
    //   1135: aload_1
    //   1136: new 460	java/io/File
    //   1139: dup
    //   1140: aload 15
    //   1142: invokespecial 1034	java/io/File:<init>	(Ljava/lang/String;)V
    //   1145: invokespecial 1463	com/tencent/smtt/sdk/TbsInstaller:unzipTbsApk	(Landroid/content/Context;Ljava/io/File;)Z
    //   1148: ifne +49 -> 1197
    //   1151: aload_1
    //   1152: invokestatic 650	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1155: sipush 207
    //   1158: ldc_w 1452
    //   1161: invokevirtual 661	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1164: getstatic 279	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   1167: invokevirtual 609	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1170: getstatic 281	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   1173: invokeinterface 610 1 0
    //   1178: aload_0
    //   1179: invokevirtual 613	com/tencent/smtt/sdk/TbsInstaller:releaseTbsInstallingFileLock	()V
    //   1182: return
    //   1183: astore_1
    //   1184: aload_1
    //   1185: invokevirtual 764	java/lang/Exception:printStackTrace	()V
    //   1188: return
    //   1189: astore_1
    //   1190: aload_1
    //   1191: invokevirtual 764	java/lang/Exception:printStackTrace	()V
    //   1194: goto -16 -> 1178
    //   1197: iload 6
    //   1199: ifeq +144 -> 1343
    //   1202: aload_1
    //   1203: invokestatic 432	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   1206: ldc_w 1465
    //   1209: invokevirtual 597	com/tencent/smtt/sdk/TbsCoreVerManager:getIntStatus	(Ljava/lang/String;)I
    //   1212: istore 4
    //   1214: iload 4
    //   1216: iconst_5
    //   1217: if_icmple +115 -> 1332
    //   1220: aload_1
    //   1221: invokestatic 650	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1224: sipush 223
    //   1227: ldc_w 1467
    //   1230: invokevirtual 661	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1233: aload_1
    //   1234: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1237: sipush -553
    //   1240: invokevirtual 539	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1243: aload_0
    //   1244: aload_1
    //   1245: invokespecial 1427	com/tencent/smtt/sdk/TbsInstaller:clearNewTbsCore	(Landroid/content/Context;)V
    //   1248: aload_1
    //   1249: invokestatic 1470	com/tencent/smtt/sdk/TbsApkDownloader:clearAllApkFile	(Landroid/content/Context;)V
    //   1252: aload_1
    //   1253: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1256: getfield 1474	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1259: ldc_w 1476
    //   1262: iconst_1
    //   1263: invokestatic 1481	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1266: invokeinterface 1487 3 0
    //   1271: pop
    //   1272: aload_1
    //   1273: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1276: getfield 1474	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1279: ldc_w 1489
    //   1282: iconst_1
    //   1283: invokestatic 1481	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1286: invokeinterface 1487 3 0
    //   1291: pop
    //   1292: aload_1
    //   1293: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1296: invokevirtual 1491	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1299: getstatic 279	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   1302: invokevirtual 609	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1305: getstatic 281	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   1308: invokeinterface 610 1 0
    //   1313: aload_0
    //   1314: invokevirtual 613	com/tencent/smtt/sdk/TbsInstaller:releaseTbsInstallingFileLock	()V
    //   1317: return
    //   1318: astore_1
    //   1319: aload_1
    //   1320: invokevirtual 764	java/lang/Exception:printStackTrace	()V
    //   1323: return
    //   1324: astore_1
    //   1325: aload_1
    //   1326: invokevirtual 764	java/lang/Exception:printStackTrace	()V
    //   1329: goto -16 -> 1313
    //   1332: aload_1
    //   1333: invokestatic 432	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   1336: iload 4
    //   1338: iconst_1
    //   1339: iadd
    //   1340: invokevirtual 1271	com/tencent/smtt/sdk/TbsCoreVerManager:setTbsCoreUnlzmaStatus	(I)V
    //   1343: ldc 151
    //   1345: ldc_w 1493
    //   1348: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1351: invokestatic 1313	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	()Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1354: getfield 1002	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   1357: ldc_w 1495
    //   1360: iconst_0
    //   1361: invokeinterface 566 3 0
    //   1366: istore 4
    //   1368: aload_0
    //   1369: aload_1
    //   1370: invokevirtual 617	com/tencent/smtt/sdk/TbsInstaller:getTbsCoreInstalledVerInNolock	(Landroid/content/Context;)I
    //   1373: ifeq +345 -> 1718
    //   1376: aload_1
    //   1377: ldc_w 1497
    //   1380: aconst_null
    //   1381: invokestatic 1501	com/tencent/smtt/sdk/QbSdk:onMiscCallExtension	(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;)Ljava/lang/Object;
    //   1384: astore 15
    //   1386: aload 15
    //   1388: ifnull +1002 -> 2390
    //   1391: aload 15
    //   1393: instanceof 1478
    //   1396: ifeq +994 -> 2390
    //   1399: aload 15
    //   1401: checkcast 1478	java/lang/Boolean
    //   1404: invokevirtual 1504	java/lang/Boolean:booleanValue	()Z
    //   1407: istore 14
    //   1409: iload 14
    //   1411: ifeq +307 -> 1718
    //   1414: new 1028	android/os/Bundle
    //   1417: dup
    //   1418: invokespecial 1505	android/os/Bundle:<init>	()V
    //   1421: astore 15
    //   1423: aload 15
    //   1425: ldc 128
    //   1427: iload 4
    //   1429: invokevirtual 1507	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1432: aload_1
    //   1433: invokestatic 671	com/tencent/smtt/sdk/TbsDownloader:isDecoupleCore	(Landroid/content/Context;)Z
    //   1436: ifeq +87 -> 1523
    //   1439: aload 15
    //   1441: ldc 238
    //   1443: aload_0
    //   1444: aload_1
    //   1445: invokevirtual 691	com/tencent/smtt/sdk/TbsInstaller:getCoreShareDecoupleDir	(Landroid/content/Context;)Ljava/io/File;
    //   1448: invokevirtual 895	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1451: invokevirtual 1510	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1454: aload_1
    //   1455: ldc 102
    //   1457: aload 15
    //   1459: invokestatic 1501	com/tencent/smtt/sdk/QbSdk:onMiscCallExtension	(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;)Ljava/lang/Object;
    //   1462: astore 15
    //   1464: aload 15
    //   1466: ifnonnull +115 -> 1581
    //   1469: ldc 151
    //   1471: ldc_w 1512
    //   1474: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1477: aload_1
    //   1478: invokestatic 650	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1481: sipush 222
    //   1484: ldc_w 1514
    //   1487: invokevirtual 661	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1490: iconst_0
    //   1491: istore 4
    //   1493: iload 4
    //   1495: ifne +223 -> 1718
    //   1498: getstatic 279	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   1501: invokevirtual 609	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1504: getstatic 281	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   1507: invokeinterface 610 1 0
    //   1512: aload_0
    //   1513: invokevirtual 613	com/tencent/smtt/sdk/TbsInstaller:releaseTbsInstallingFileLock	()V
    //   1516: return
    //   1517: astore_1
    //   1518: aload_1
    //   1519: invokevirtual 764	java/lang/Exception:printStackTrace	()V
    //   1522: return
    //   1523: aload 15
    //   1525: ldc 238
    //   1527: aload_0
    //   1528: aload_1
    //   1529: iconst_0
    //   1530: invokevirtual 421	com/tencent/smtt/sdk/TbsInstaller:getCoreDir	(Landroid/content/Context;I)Ljava/io/File;
    //   1533: invokevirtual 895	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1536: invokevirtual 1510	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1539: goto -85 -> 1454
    //   1542: astore_1
    //   1543: iload 7
    //   1545: istore_3
    //   1546: getstatic 279	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   1549: invokevirtual 609	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1552: getstatic 281	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   1555: invokeinterface 610 1 0
    //   1560: aload_0
    //   1561: invokevirtual 613	com/tencent/smtt/sdk/TbsInstaller:releaseTbsInstallingFileLock	()V
    //   1564: iload_3
    //   1565: ifeq +14 -> 1579
    //   1568: getstatic 601	com/tencent/smtt/sdk/QbSdk:mTbsListenerWrapper	Lcom/tencent/smtt/sdk/TbsListener;
    //   1571: sipush 232
    //   1574: invokeinterface 606 2 0
    //   1579: aload_1
    //   1580: athrow
    //   1581: aload 15
    //   1583: instanceof 1478
    //   1586: ifeq +52 -> 1638
    //   1589: aload 15
    //   1591: checkcast 1478	java/lang/Boolean
    //   1594: invokevirtual 1504	java/lang/Boolean:booleanValue	()Z
    //   1597: ifeq +17 -> 1614
    //   1600: ldc 151
    //   1602: ldc_w 1516
    //   1605: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1608: iconst_1
    //   1609: istore 4
    //   1611: goto -118 -> 1493
    //   1614: ldc 151
    //   1616: ldc_w 1518
    //   1619: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1622: aload_1
    //   1623: invokestatic 650	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1626: sipush 222
    //   1629: ldc_w 1518
    //   1632: invokevirtual 661	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1635: goto +775 -> 2410
    //   1638: aload 15
    //   1640: instanceof 1028
    //   1643: ifeq +9 -> 1652
    //   1646: iconst_1
    //   1647: istore 4
    //   1649: goto -156 -> 1493
    //   1652: aload 15
    //   1654: instanceof 377
    //   1657: ifeq +753 -> 2410
    //   1660: ldc 151
    //   1662: new 479	java/lang/StringBuilder
    //   1665: dup
    //   1666: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   1669: ldc_w 1520
    //   1672: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1675: aload 15
    //   1677: checkcast 377	java/lang/Throwable
    //   1680: invokestatic 853	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1683: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1686: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1689: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1692: aload_1
    //   1693: invokestatic 650	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1696: sipush 222
    //   1699: aload 15
    //   1701: checkcast 377	java/lang/Throwable
    //   1704: invokevirtual 960	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/Throwable;)V
    //   1707: goto +703 -> 2410
    //   1710: astore_1
    //   1711: aload_1
    //   1712: invokevirtual 764	java/lang/Exception:printStackTrace	()V
    //   1715: goto -203 -> 1512
    //   1718: ldc 151
    //   1720: ldc_w 1522
    //   1723: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1726: aload_1
    //   1727: invokestatic 432	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   1730: iload 9
    //   1732: iconst_1
    //   1733: invokevirtual 436	com/tencent/smtt/sdk/TbsCoreVerManager:setTbsCoreInstallStatus	(II)V
    //   1736: iload 9
    //   1738: istore 4
    //   1740: iload 5
    //   1742: iconst_2
    //   1743: if_icmpge +566 -> 2309
    //   1746: iload 6
    //   1748: ifeq +213 -> 1961
    //   1751: aload_1
    //   1752: invokestatic 432	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   1755: ldc_w 1524
    //   1758: invokevirtual 592	com/tencent/smtt/sdk/TbsCoreVerManager:getIntNum	(Ljava/lang/String;)I
    //   1761: istore 5
    //   1763: iload 5
    //   1765: bipush 10
    //   1767: if_icmple +183 -> 1950
    //   1770: aload_1
    //   1771: invokestatic 650	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1774: sipush 208
    //   1777: ldc_w 1526
    //   1780: invokevirtual 661	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1783: aload_1
    //   1784: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1787: sipush -514
    //   1790: invokevirtual 539	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1793: aload_0
    //   1794: aload_1
    //   1795: invokespecial 1427	com/tencent/smtt/sdk/TbsInstaller:clearNewTbsCore	(Landroid/content/Context;)V
    //   1798: getstatic 279	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   1801: invokevirtual 609	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1804: getstatic 281	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   1807: invokeinterface 610 1 0
    //   1812: aload_0
    //   1813: invokevirtual 613	com/tencent/smtt/sdk/TbsInstaller:releaseTbsInstallingFileLock	()V
    //   1816: return
    //   1817: astore_1
    //   1818: aload_1
    //   1819: invokevirtual 764	java/lang/Exception:printStackTrace	()V
    //   1822: return
    //   1823: aload_1
    //   1824: invokestatic 671	com/tencent/smtt/sdk/TbsDownloader:isDecoupleCore	(Landroid/content/Context;)Z
    //   1827: ifeq +109 -> 1936
    //   1830: aload_2
    //   1831: ifnonnull +80 -> 1911
    //   1834: aload_1
    //   1835: invokestatic 432	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   1838: ldc_w 1431
    //   1841: invokevirtual 1434	com/tencent/smtt/sdk/TbsCoreVerManager:getStringValue	(Ljava/lang/String;)Ljava/lang/String;
    //   1844: astore 16
    //   1846: aload 16
    //   1848: astore 15
    //   1850: aload 16
    //   1852: ifnonnull +62 -> 1914
    //   1855: aload_1
    //   1856: invokestatic 650	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1859: sipush 202
    //   1862: ldc_w 1436
    //   1865: invokevirtual 661	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1868: aload_1
    //   1869: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1872: sipush -511
    //   1875: invokevirtual 539	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1878: getstatic 279	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   1881: invokevirtual 609	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1884: getstatic 281	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   1887: invokeinterface 610 1 0
    //   1892: aload_0
    //   1893: invokevirtual 613	com/tencent/smtt/sdk/TbsInstaller:releaseTbsInstallingFileLock	()V
    //   1896: return
    //   1897: astore_1
    //   1898: aload_1
    //   1899: invokevirtual 764	java/lang/Exception:printStackTrace	()V
    //   1902: return
    //   1903: astore_1
    //   1904: aload_1
    //   1905: invokevirtual 764	java/lang/Exception:printStackTrace	()V
    //   1908: goto -16 -> 1892
    //   1911: aload_2
    //   1912: astore 15
    //   1914: aload_0
    //   1915: aload_1
    //   1916: new 460	java/io/File
    //   1919: dup
    //   1920: aload 15
    //   1922: invokespecial 1034	java/io/File:<init>	(Ljava/lang/String;)V
    //   1925: iconst_1
    //   1926: invokespecial 1450	com/tencent/smtt/sdk/TbsInstaller:unzipTbsApk	(Landroid/content/Context;Ljava/io/File;Z)Z
    //   1929: istore 14
    //   1931: iload 14
    //   1933: ifne +3 -> 1936
    //   1936: iconst_0
    //   1937: istore 4
    //   1939: goto -199 -> 1740
    //   1942: astore_1
    //   1943: aload_1
    //   1944: invokevirtual 764	java/lang/Exception:printStackTrace	()V
    //   1947: goto -135 -> 1812
    //   1950: aload_1
    //   1951: invokestatic 432	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   1954: iload 5
    //   1956: iconst_1
    //   1957: iadd
    //   1958: invokevirtual 1265	com/tencent/smtt/sdk/TbsCoreVerManager:setTbsCoreDexoptRetryNum	(I)V
    //   1961: aload_1
    //   1962: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1965: sipush -549
    //   1968: invokevirtual 539	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1971: aload_0
    //   1972: aload_1
    //   1973: iconst_0
    //   1974: invokespecial 1528	com/tencent/smtt/sdk/TbsInstaller:doDexoptOrDexoat	(Landroid/content/Context;I)Z
    //   1977: ifne +46 -> 2023
    //   1980: aload_1
    //   1981: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1984: sipush -515
    //   1987: invokevirtual 539	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1990: getstatic 279	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   1993: invokevirtual 609	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1996: getstatic 281	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   1999: invokeinterface 610 1 0
    //   2004: aload_0
    //   2005: invokevirtual 613	com/tencent/smtt/sdk/TbsInstaller:releaseTbsInstallingFileLock	()V
    //   2008: return
    //   2009: astore_1
    //   2010: aload_1
    //   2011: invokevirtual 764	java/lang/Exception:printStackTrace	()V
    //   2014: return
    //   2015: astore_1
    //   2016: aload_1
    //   2017: invokevirtual 764	java/lang/Exception:printStackTrace	()V
    //   2020: goto -16 -> 2004
    //   2023: aload_1
    //   2024: invokestatic 432	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   2027: iload 4
    //   2029: iconst_2
    //   2030: invokevirtual 436	com/tencent/smtt/sdk/TbsCoreVerManager:setTbsCoreInstallStatus	(II)V
    //   2033: ldc 151
    //   2035: ldc_w 1530
    //   2038: iconst_1
    //   2039: invokestatic 633	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   2042: ldc 151
    //   2044: new 479	java/lang/StringBuilder
    //   2047: dup
    //   2048: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   2051: ldc_w 1532
    //   2054: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2057: iload_3
    //   2058: invokevirtual 547	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2061: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2064: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2067: aload_1
    //   2068: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2071: sipush -516
    //   2074: invokevirtual 539	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   2077: getstatic 552	android/os/Build$VERSION:SDK_INT	I
    //   2080: bipush 11
    //   2082: if_icmplt +149 -> 2231
    //   2085: aload_1
    //   2086: ldc_w 554
    //   2089: iconst_4
    //   2090: invokevirtual 558	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   2093: astore 15
    //   2095: aload 15
    //   2097: invokeinterface 821 1 0
    //   2102: astore 15
    //   2104: aload 15
    //   2106: ldc_w 823
    //   2109: iconst_0
    //   2110: invokeinterface 829 3 0
    //   2115: pop
    //   2116: aload 15
    //   2118: ldc_w 831
    //   2121: iconst_0
    //   2122: invokeinterface 829 3 0
    //   2127: pop
    //   2128: aload 15
    //   2130: ldc_w 833
    //   2133: iload_3
    //   2134: invokeinterface 829 3 0
    //   2139: pop
    //   2140: aload 15
    //   2142: invokeinterface 836 1 0
    //   2147: pop
    //   2148: aload_1
    //   2149: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2152: sipush -517
    //   2155: invokevirtual 539	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   2158: iload_3
    //   2159: ldc_w 876
    //   2162: if_icmpne +10 -> 2172
    //   2165: aload_0
    //   2166: iload_3
    //   2167: aload_2
    //   2168: aload_1
    //   2169: invokespecial 1534	com/tencent/smtt/sdk/TbsInstaller:finishLocalTbsInstall	(ILjava/lang/String;Landroid/content/Context;)V
    //   2172: aload_0
    //   2173: getfield 345	com/tencent/smtt/sdk/TbsInstaller:isContinueInstallWithoutCore	Z
    //   2176: ifeq +112 -> 2288
    //   2179: aload_1
    //   2180: invokestatic 650	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   2183: aload_0
    //   2184: aload_1
    //   2185: invokespecial 1536	com/tencent/smtt/sdk/TbsInstaller:getSuccessErrorCode	(Landroid/content/Context;)I
    //   2188: ldc_w 815
    //   2191: invokevirtual 661	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   2194: iload 8
    //   2196: istore_3
    //   2197: getstatic 279	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   2200: invokevirtual 609	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   2203: getstatic 281	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   2206: invokeinterface 610 1 0
    //   2211: aload_0
    //   2212: invokevirtual 613	com/tencent/smtt/sdk/TbsInstaller:releaseTbsInstallingFileLock	()V
    //   2215: iload_3
    //   2216: ifeq -2173 -> 43
    //   2219: getstatic 601	com/tencent/smtt/sdk/QbSdk:mTbsListenerWrapper	Lcom/tencent/smtt/sdk/TbsListener;
    //   2222: sipush 232
    //   2225: invokeinterface 606 2 0
    //   2230: return
    //   2231: aload_1
    //   2232: ldc_w 554
    //   2235: iconst_0
    //   2236: invokevirtual 558	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   2239: astore 15
    //   2241: goto -146 -> 2095
    //   2244: astore 15
    //   2246: ldc 151
    //   2248: new 479	java/lang/StringBuilder
    //   2251: dup
    //   2252: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   2255: ldc_w 1538
    //   2258: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2261: aload 15
    //   2263: invokestatic 853	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2266: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2269: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2272: invokestatic 393	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2275: aload_1
    //   2276: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2279: sipush -518
    //   2282: invokevirtual 539	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   2285: goto -127 -> 2158
    //   2288: aload_1
    //   2289: invokestatic 650	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   2292: aload_0
    //   2293: aload_1
    //   2294: invokespecial 1536	com/tencent/smtt/sdk/TbsInstaller:getSuccessErrorCode	(Landroid/content/Context;)I
    //   2297: ldc_w 845
    //   2300: invokevirtual 661	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   2303: iload 8
    //   2305: istore_3
    //   2306: goto -109 -> 2197
    //   2309: iload 5
    //   2311: iconst_2
    //   2312: if_icmpne +73 -> 2385
    //   2315: getstatic 601	com/tencent/smtt/sdk/QbSdk:mTbsListenerWrapper	Lcom/tencent/smtt/sdk/TbsListener;
    //   2318: sipush 200
    //   2321: invokeinterface 606 2 0
    //   2326: iload 8
    //   2328: istore_3
    //   2329: goto -132 -> 2197
    //   2332: astore_1
    //   2333: iconst_1
    //   2334: istore_3
    //   2335: goto -789 -> 1546
    //   2338: astore_1
    //   2339: aload_1
    //   2340: invokevirtual 764	java/lang/Exception:printStackTrace	()V
    //   2343: goto -132 -> 2211
    //   2346: astore_1
    //   2347: aload_1
    //   2348: invokevirtual 764	java/lang/Exception:printStackTrace	()V
    //   2351: goto -136 -> 2215
    //   2354: astore_2
    //   2355: aload_2
    //   2356: invokevirtual 764	java/lang/Exception:printStackTrace	()V
    //   2359: goto -799 -> 1560
    //   2362: astore_2
    //   2363: aload_2
    //   2364: invokevirtual 764	java/lang/Exception:printStackTrace	()V
    //   2367: goto -803 -> 1564
    //   2370: aload_1
    //   2371: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   2374: sipush -519
    //   2377: invokevirtual 539	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   2380: aload_0
    //   2381: invokevirtual 613	com/tencent/smtt/sdk/TbsInstaller:releaseTbsInstallingFileLock	()V
    //   2384: return
    //   2385: iconst_0
    //   2386: istore_3
    //   2387: goto -190 -> 2197
    //   2390: iconst_0
    //   2391: istore 14
    //   2393: goto -984 -> 1409
    //   2396: iload 4
    //   2398: ifle -1861 -> 537
    //   2401: iload_3
    //   2402: iload 4
    //   2404: if_icmple -1867 -> 537
    //   2407: goto -1875 -> 532
    //   2410: iconst_0
    //   2411: istore 4
    //   2413: goto -920 -> 1493
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2416	0	this	TbsInstaller
    //   0	2416	1	paramContext	Context
    //   0	2416	2	paramString	String
    //   0	2416	3	paramInt	int
    //   430	1982	4	i	int
    //   439	1874	5	j	int
    //   551	1196	6	k	int
    //   1	1543	7	m	int
    //   4	2323	8	n	int
    //   965	772	9	i1	int
    //   280	42	10	l1	long
    //   289	44	12	l2	long
    //   371	2021	14	bool	boolean
    //   198	2042	15	localObject	Object
    //   2244	18	15	localThrowable	Throwable
    //   862	989	16	str	String
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
    //   1512	1516	1517	java/lang/Exception
    //   420	518	1542	finally
    //   532	537	1542	finally
    //   537	605	1542	finally
    //   616	625	1542	finally
    //   628	664	1542	finally
    //   670	689	1542	finally
    //   694	706	1542	finally
    //   713	741	1542	finally
    //   805	819	1542	finally
    //   837	848	1542	finally
    //   852	864	1542	finally
    //   873	896	1542	finally
    //   932	967	1542	finally
    //   972	995	1542	finally
    //   1028	1101	1542	finally
    //   1134	1164	1542	finally
    //   1202	1214	1542	finally
    //   1220	1299	1542	finally
    //   1332	1343	1542	finally
    //   1343	1386	1542	finally
    //   1391	1409	1542	finally
    //   1414	1454	1542	finally
    //   1454	1464	1542	finally
    //   1469	1490	1542	finally
    //   1523	1539	1542	finally
    //   1581	1608	1542	finally
    //   1614	1635	1542	finally
    //   1638	1646	1542	finally
    //   1652	1707	1542	finally
    //   1718	1736	1542	finally
    //   1751	1763	1542	finally
    //   1770	1798	1542	finally
    //   1823	1830	1542	finally
    //   1834	1846	1542	finally
    //   1855	1878	1542	finally
    //   1914	1931	1542	finally
    //   1950	1961	1542	finally
    //   1961	1990	1542	finally
    //   2023	2095	1542	finally
    //   2095	2158	1542	finally
    //   2165	2172	1542	finally
    //   2172	2194	1542	finally
    //   2231	2241	1542	finally
    //   2246	2285	1542	finally
    //   2288	2303	1542	finally
    //   1498	1512	1710	java/lang/Exception
    //   1812	1816	1817	java/lang/Exception
    //   1892	1896	1897	java/lang/Exception
    //   1878	1892	1903	java/lang/Exception
    //   1798	1812	1942	java/lang/Exception
    //   2004	2008	2009	java/lang/Exception
    //   1990	2004	2015	java/lang/Exception
    //   2095	2158	2244	java/lang/Throwable
    //   2315	2326	2332	finally
    //   2197	2211	2338	java/lang/Exception
    //   2211	2215	2346	java/lang/Exception
    //   1546	1560	2354	java/lang/Exception
    //   1560	1564	2362	java/lang/Exception
  }
  
  private boolean isHostAppInstalled(Context paramContext, String paramString)
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
  
  static boolean isPrepareTbsCore(Context paramContext, String paramString)
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
  
  private void proceedTpatchStatus(Context paramContext, int paramInt)
  {
    TbsLog.i("TbsInstaller", "proceedTpatchStatus,result=" + paramInt);
    switch (paramInt)
    {
    }
    for (;;)
    {
      QbSdk.setTBSInstallingStatus(false);
      return;
      if (TbsDownloader.isDecoupleCore(paramContext))
      {
        installForDecoupleCore(paramContext, 6);
      }
      else
      {
        setTmpFolderCoreToRead(paramContext, true);
        paramInt = TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_download_version", 0);
        TbsCoreVerManager.getInstance(paramContext).setTbsCoreTpatchStatus(paramInt, 1);
      }
    }
  }
  
  private void renameTbsCoreCopyDir(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--renameTbsCoreCopyDir");
    File localFile1 = getCoreDir(paramContext, 1);
    File localFile2 = getTbsCoreShareDir(paramContext);
    if ((localFile1 == null) || (localFile2 == null)) {
      return;
    }
    localFile1.renameTo(localFile2);
    setTmpFolderCoreToRead(paramContext, false);
  }
  
  private void renameTbsCoreShareDir(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--renameShareDir");
    File localFile1 = getCoreDir(paramContext, 0);
    File localFile2 = getTbsCoreShareDir(paramContext);
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
        break label146;
      }
      TbsLogReport.getInstance(paramContext).setInstallErrorCode(230, " ");
    }
    for (;;)
    {
      setTmpFolderCoreToRead(paramContext, false);
      return;
      label146:
      TbsLogReport.getInstance(paramContext).setInstallErrorCode(231, " ");
    }
  }
  
  private void renameTbsTpatchCoreDir(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--renameTbsTpatchCoreDir");
    File localFile1 = getCoreDir(paramContext, 5);
    File localFile2 = getTbsCoreShareDir(paramContext);
    if ((localFile1 == null) || (localFile2 == null)) {
      return;
    }
    localFile1.renameTo(localFile2);
    setTmpFolderCoreToRead(paramContext, false);
  }
  
  private void setTmpFolderCoreToRead(Context paramContext, boolean paramBoolean)
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
    FileUtil.delete(localException);
  }
  
  private boolean unzipTbsApk(Context paramContext, File paramFile)
  {
    return unzipTbsApk(paramContext, paramFile, false);
  }
  
  /* Error */
  private boolean unzipTbsApk(Context paramContext, File paramFile, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 6
    //   3: iconst_1
    //   4: istore 5
    //   6: ldc 151
    //   8: ldc_w 1584
    //   11: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: aload_2
    //   15: invokestatic 1587	com/tencent/smtt/utils/FileUtil:isFileValid	(Ljava/io/File;)Z
    //   18: ifne +28 -> 46
    //   21: aload_1
    //   22: invokestatic 650	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   25: sipush 204
    //   28: ldc_w 1589
    //   31: invokevirtual 661	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   34: aload_1
    //   35: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   38: sipush -520
    //   41: invokevirtual 539	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   44: iconst_0
    //   45: ireturn
    //   46: aload_1
    //   47: invokestatic 1177	com/tencent/smtt/sdk/QbSdk:getTbsFolderDir	(Landroid/content/Context;)Ljava/io/File;
    //   50: astore 9
    //   52: iload_3
    //   53: ifeq +83 -> 136
    //   56: new 460	java/io/File
    //   59: dup
    //   60: aload 9
    //   62: ldc 183
    //   64: invokespecial 469	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   67: astore 9
    //   69: aload 9
    //   71: ifnull +23 -> 94
    //   74: aload 9
    //   76: invokevirtual 473	java/io/File:exists	()Z
    //   79: ifeq +15 -> 94
    //   82: aload_1
    //   83: invokestatic 671	com/tencent/smtt/sdk/TbsDownloader:isDecoupleCore	(Landroid/content/Context;)Z
    //   86: ifne +8 -> 94
    //   89: aload 9
    //   91: invokestatic 1058	com/tencent/smtt/utils/FileUtil:delete	(Ljava/io/File;)V
    //   94: iload_3
    //   95: ifeq +91 -> 186
    //   98: aload_0
    //   99: aload_1
    //   100: iconst_2
    //   101: invokevirtual 421	com/tencent/smtt/sdk/TbsInstaller:getCoreDir	(Landroid/content/Context;I)Ljava/io/File;
    //   104: astore 9
    //   106: aload 9
    //   108: ifnonnull +89 -> 197
    //   111: aload_1
    //   112: invokestatic 650	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   115: sipush 205
    //   118: ldc_w 1591
    //   121: invokevirtual 661	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   124: aload_1
    //   125: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   128: sipush -521
    //   131: invokevirtual 539	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   134: iconst_0
    //   135: ireturn
    //   136: new 460	java/io/File
    //   139: dup
    //   140: aload 9
    //   142: ldc 219
    //   144: invokespecial 469	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   147: astore 9
    //   149: goto -80 -> 69
    //   152: astore 9
    //   154: ldc 151
    //   156: new 479	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   163: ldc_w 1593
    //   166: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: aload 9
    //   171: invokestatic 853	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   174: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: invokestatic 393	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   183: goto -89 -> 94
    //   186: aload_0
    //   187: aload_1
    //   188: iconst_0
    //   189: invokevirtual 421	com/tencent/smtt/sdk/TbsInstaller:getCoreDir	(Landroid/content/Context;I)Ljava/io/File;
    //   192: astore 9
    //   194: goto -88 -> 106
    //   197: aload 9
    //   199: invokestatic 1596	com/tencent/smtt/utils/FileUtil:ensureDirectory	(Ljava/io/File;)Z
    //   202: pop
    //   203: iload_3
    //   204: ifeq +9 -> 213
    //   207: aload 9
    //   209: iconst_1
    //   210: invokestatic 427	com/tencent/smtt/utils/FileUtil:delete	(Ljava/io/File;Z)V
    //   213: aload_2
    //   214: aload 9
    //   216: invokestatic 1600	com/tencent/smtt/utils/FileUtil:copyTbsFilesIfNeeded	(Ljava/io/File;Ljava/io/File;)Z
    //   219: istore 8
    //   221: iload 8
    //   223: istore 7
    //   225: iload 8
    //   227: ifeq +12 -> 239
    //   230: aload_0
    //   231: aload 9
    //   233: aload_1
    //   234: invokespecial 1602	com/tencent/smtt/sdk/TbsInstaller:finalCheckForTbsCoreValidity	(Ljava/io/File;Landroid/content/Context;)Z
    //   237: istore 7
    //   239: iload_3
    //   240: ifeq +81 -> 321
    //   243: aload 9
    //   245: invokevirtual 1606	java/io/File:list	()[Ljava/lang/String;
    //   248: astore_2
    //   249: iconst_0
    //   250: istore 4
    //   252: iload 4
    //   254: aload_2
    //   255: arraylength
    //   256: if_icmpge +47 -> 303
    //   259: new 460	java/io/File
    //   262: dup
    //   263: aload 9
    //   265: aload_2
    //   266: iload 4
    //   268: aaload
    //   269: invokespecial 469	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   272: astore 10
    //   274: aload 10
    //   276: invokevirtual 746	java/io/File:getName	()Ljava/lang/String;
    //   279: ldc_w 754
    //   282: invokevirtual 758	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   285: ifeq +9 -> 294
    //   288: aload 10
    //   290: invokevirtual 1170	java/io/File:delete	()Z
    //   293: pop
    //   294: iload 4
    //   296: iconst_1
    //   297: iadd
    //   298: istore 4
    //   300: goto -48 -> 252
    //   303: new 460	java/io/File
    //   306: dup
    //   307: aload_1
    //   308: invokestatic 1608	com/tencent/smtt/sdk/TbsInstaller:getTbsCorePrivateDir	(Landroid/content/Context;)Ljava/io/File;
    //   311: ldc_w 1610
    //   314: invokespecial 469	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   317: invokevirtual 1170	java/io/File:delete	()Z
    //   320: pop
    //   321: iload 7
    //   323: ifne +58 -> 381
    //   326: aload 9
    //   328: invokestatic 1058	com/tencent/smtt/utils/FileUtil:delete	(Ljava/io/File;)V
    //   331: aload_1
    //   332: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   335: sipush -522
    //   338: invokevirtual 539	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   341: ldc 151
    //   343: new 479	java/lang/StringBuilder
    //   346: dup
    //   347: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   350: ldc_w 1612
    //   353: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: aload 9
    //   358: invokevirtual 473	java/io/File:exists	()Z
    //   361: invokevirtual 583	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   364: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   367: invokestatic 393	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   370: ldc 151
    //   372: ldc_w 1614
    //   375: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   378: iload 7
    //   380: ireturn
    //   381: aload_0
    //   382: aload_1
    //   383: iconst_1
    //   384: invokespecial 799	com/tencent/smtt/sdk/TbsInstaller:setTmpFolderCoreToRead	(Landroid/content/Context;Z)V
    //   387: iload_3
    //   388: ifeq -18 -> 370
    //   391: aload_0
    //   392: aload_1
    //   393: invokevirtual 691	com/tencent/smtt/sdk/TbsInstaller:getCoreShareDecoupleDir	(Landroid/content/Context;)Ljava/io/File;
    //   396: astore_2
    //   397: aload_2
    //   398: iconst_1
    //   399: invokestatic 427	com/tencent/smtt/utils/FileUtil:delete	(Ljava/io/File;Z)V
    //   402: aload 9
    //   404: aload_2
    //   405: invokevirtual 1374	java/io/File:renameTo	(Ljava/io/File;)Z
    //   408: pop
    //   409: aload_1
    //   410: invokestatic 712	com/tencent/smtt/sdk/TbsShareManager:shareCoreShareDecouple	(Landroid/content/Context;)V
    //   413: goto -43 -> 370
    //   416: astore_2
    //   417: aload_1
    //   418: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   421: sipush -523
    //   424: invokevirtual 539	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   427: aload_1
    //   428: invokestatic 650	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   431: sipush 206
    //   434: aload_2
    //   435: invokevirtual 960	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/Throwable;)V
    //   438: aload 9
    //   440: ifnull +251 -> 691
    //   443: aload 9
    //   445: invokevirtual 473	java/io/File:exists	()Z
    //   448: istore_3
    //   449: iload_3
    //   450: ifeq +241 -> 691
    //   453: iload 5
    //   455: istore 4
    //   457: iload 4
    //   459: ifeq +42 -> 501
    //   462: aload 9
    //   464: ifnull +37 -> 501
    //   467: aload 9
    //   469: invokestatic 1058	com/tencent/smtt/utils/FileUtil:delete	(Ljava/io/File;)V
    //   472: ldc 151
    //   474: new 479	java/lang/StringBuilder
    //   477: dup
    //   478: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   481: ldc_w 1616
    //   484: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   487: aload 9
    //   489: invokevirtual 473	java/io/File:exists	()Z
    //   492: invokevirtual 583	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   495: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   498: invokestatic 393	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   501: ldc 151
    //   503: ldc_w 1614
    //   506: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   509: iconst_0
    //   510: ireturn
    //   511: astore_1
    //   512: ldc 151
    //   514: new 479	java/lang/StringBuilder
    //   517: dup
    //   518: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   521: ldc_w 1618
    //   524: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: aload_1
    //   528: invokestatic 853	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   531: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   537: invokestatic 393	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   540: goto -39 -> 501
    //   543: astore_2
    //   544: aload_1
    //   545: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   548: sipush -523
    //   551: invokevirtual 539	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   554: aload_1
    //   555: invokestatic 650	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   558: sipush 207
    //   561: aload_2
    //   562: invokevirtual 960	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/Throwable;)V
    //   565: aload 9
    //   567: ifnull +118 -> 685
    //   570: aload 9
    //   572: invokevirtual 473	java/io/File:exists	()Z
    //   575: istore_3
    //   576: iload_3
    //   577: ifeq +108 -> 685
    //   580: iload 6
    //   582: istore 4
    //   584: iload 4
    //   586: ifeq +42 -> 628
    //   589: aload 9
    //   591: ifnull +37 -> 628
    //   594: aload 9
    //   596: invokestatic 1058	com/tencent/smtt/utils/FileUtil:delete	(Ljava/io/File;)V
    //   599: ldc 151
    //   601: new 479	java/lang/StringBuilder
    //   604: dup
    //   605: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   608: ldc_w 1616
    //   611: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   614: aload 9
    //   616: invokevirtual 473	java/io/File:exists	()Z
    //   619: invokevirtual 583	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   622: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   625: invokestatic 393	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   628: ldc 151
    //   630: ldc_w 1614
    //   633: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   636: iconst_0
    //   637: ireturn
    //   638: astore_1
    //   639: ldc 151
    //   641: new 479	java/lang/StringBuilder
    //   644: dup
    //   645: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   648: ldc_w 1618
    //   651: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   654: aload_1
    //   655: invokestatic 853	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   658: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   661: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   664: invokestatic 393	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   667: goto -39 -> 628
    //   670: astore_1
    //   671: ldc 151
    //   673: ldc_w 1614
    //   676: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   679: aload_1
    //   680: athrow
    //   681: astore_2
    //   682: goto -361 -> 321
    //   685: iconst_0
    //   686: istore 4
    //   688: goto -104 -> 584
    //   691: iconst_0
    //   692: istore 4
    //   694: goto -237 -> 457
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	697	0	this	TbsInstaller
    //   0	697	1	paramContext	Context
    //   0	697	2	paramFile	File
    //   0	697	3	paramBoolean	boolean
    //   250	443	4	i	int
    //   4	450	5	j	int
    //   1	580	6	k	int
    //   223	156	7	bool1	boolean
    //   219	7	8	bool2	boolean
    //   50	98	9	localFile1	File
    //   152	18	9	localThrowable	Throwable
    //   192	423	9	localFile2	File
    //   272	17	10	localFile3	File
    // Exception table:
    //   from	to	target	type
    //   46	52	152	java/lang/Throwable
    //   56	69	152	java/lang/Throwable
    //   74	94	152	java/lang/Throwable
    //   136	149	152	java/lang/Throwable
    //   197	203	416	java/io/IOException
    //   207	213	416	java/io/IOException
    //   213	221	416	java/io/IOException
    //   230	239	416	java/io/IOException
    //   243	249	416	java/io/IOException
    //   252	294	416	java/io/IOException
    //   303	321	416	java/io/IOException
    //   326	370	416	java/io/IOException
    //   381	387	416	java/io/IOException
    //   391	413	416	java/io/IOException
    //   467	501	511	java/lang/Throwable
    //   197	203	543	java/lang/Exception
    //   207	213	543	java/lang/Exception
    //   213	221	543	java/lang/Exception
    //   230	239	543	java/lang/Exception
    //   243	249	543	java/lang/Exception
    //   252	294	543	java/lang/Exception
    //   326	370	543	java/lang/Exception
    //   381	387	543	java/lang/Exception
    //   391	413	543	java/lang/Exception
    //   594	628	638	java/lang/Throwable
    //   197	203	670	finally
    //   207	213	670	finally
    //   213	221	670	finally
    //   230	239	670	finally
    //   243	249	670	finally
    //   252	294	670	finally
    //   303	321	670	finally
    //   326	370	670	finally
    //   381	387	670	finally
    //   391	413	670	finally
    //   417	438	670	finally
    //   443	449	670	finally
    //   544	565	670	finally
    //   570	576	670	finally
    //   303	321	681	java/lang/Exception
  }
  
  /* Error */
  public void changeTbsConfForSendRequest(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: new 460	java/io/File
    //   7: dup
    //   8: aload_0
    //   9: aload_1
    //   10: invokevirtual 688	com/tencent/smtt/sdk/TbsInstaller:getTbsCoreShareDir	(Landroid/content/Context;)Ljava/io/File;
    //   13: ldc 154
    //   15: invokespecial 469	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   18: astore 5
    //   20: new 726	java/util/Properties
    //   23: dup
    //   24: invokespecial 727	java/util/Properties:<init>	()V
    //   27: astore 4
    //   29: new 729	java/io/BufferedInputStream
    //   32: dup
    //   33: new 731	java/io/FileInputStream
    //   36: dup
    //   37: aload 5
    //   39: invokespecial 732	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   42: invokespecial 735	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   45: astore_1
    //   46: aload 4
    //   48: aload_1
    //   49: invokevirtual 738	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   52: new 1182	java/io/BufferedOutputStream
    //   55: dup
    //   56: new 502	java/io/FileOutputStream
    //   59: dup
    //   60: aload 5
    //   62: invokespecial 505	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   65: invokespecial 1185	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   68: astore_2
    //   69: aload 4
    //   71: ldc 173
    //   73: ldc_w 1621
    //   76: invokevirtual 1191	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   79: pop
    //   80: aload 4
    //   82: aload_2
    //   83: aconst_null
    //   84: invokevirtual 1195	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   87: aload_2
    //   88: ifnull +7 -> 95
    //   91: aload_2
    //   92: invokevirtual 1198	java/io/BufferedOutputStream:close	()V
    //   95: aload_1
    //   96: ifnull +7 -> 103
    //   99: aload_1
    //   100: invokevirtual 739	java/io/BufferedInputStream:close	()V
    //   103: return
    //   104: astore_1
    //   105: aconst_null
    //   106: astore_1
    //   107: aload_1
    //   108: ifnull +7 -> 115
    //   111: aload_1
    //   112: invokevirtual 1198	java/io/BufferedOutputStream:close	()V
    //   115: aload_2
    //   116: ifnull -13 -> 103
    //   119: aload_2
    //   120: invokevirtual 739	java/io/BufferedInputStream:close	()V
    //   123: return
    //   124: astore_1
    //   125: return
    //   126: astore_2
    //   127: aconst_null
    //   128: astore_1
    //   129: aload_3
    //   130: ifnull +7 -> 137
    //   133: aload_3
    //   134: invokevirtual 1198	java/io/BufferedOutputStream:close	()V
    //   137: aload_1
    //   138: ifnull +7 -> 145
    //   141: aload_1
    //   142: invokevirtual 739	java/io/BufferedInputStream:close	()V
    //   145: aload_2
    //   146: athrow
    //   147: astore_1
    //   148: return
    //   149: astore_2
    //   150: goto -55 -> 95
    //   153: astore_1
    //   154: return
    //   155: astore_1
    //   156: goto -41 -> 115
    //   159: astore_3
    //   160: goto -23 -> 137
    //   163: astore_1
    //   164: goto -19 -> 145
    //   167: astore_2
    //   168: goto -39 -> 129
    //   171: astore 4
    //   173: aload_2
    //   174: astore_3
    //   175: aload 4
    //   177: astore_2
    //   178: goto -49 -> 129
    //   181: astore_2
    //   182: aconst_null
    //   183: astore_3
    //   184: aload_1
    //   185: astore_2
    //   186: aload_3
    //   187: astore_1
    //   188: goto -81 -> 107
    //   191: astore_3
    //   192: aload_1
    //   193: astore_3
    //   194: aload_2
    //   195: astore_1
    //   196: aload_3
    //   197: astore_2
    //   198: goto -91 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	201	0	this	TbsInstaller
    //   0	201	1	paramContext	Context
    //   3	117	2	localBufferedOutputStream	java.io.BufferedOutputStream
    //   126	20	2	localObject1	Object
    //   149	1	2	localIOException1	java.io.IOException
    //   167	7	2	localObject2	Object
    //   177	1	2	localObject3	Object
    //   181	1	2	localThrowable1	Throwable
    //   185	13	2	localContext1	Context
    //   1	133	3	localObject4	Object
    //   159	1	3	localIOException2	java.io.IOException
    //   174	13	3	localObject5	Object
    //   191	1	3	localThrowable2	Throwable
    //   193	4	3	localContext2	Context
    //   27	54	4	localProperties	java.util.Properties
    //   171	5	4	localObject6	Object
    //   18	43	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   29	46	104	java/lang/Throwable
    //   119	123	124	java/io/IOException
    //   29	46	126	finally
    //   4	29	147	java/lang/Throwable
    //   91	95	147	java/lang/Throwable
    //   99	103	147	java/lang/Throwable
    //   111	115	147	java/lang/Throwable
    //   119	123	147	java/lang/Throwable
    //   133	137	147	java/lang/Throwable
    //   141	145	147	java/lang/Throwable
    //   145	147	147	java/lang/Throwable
    //   91	95	149	java/io/IOException
    //   99	103	153	java/io/IOException
    //   111	115	155	java/io/IOException
    //   133	137	159	java/io/IOException
    //   141	145	163	java/io/IOException
    //   46	69	167	finally
    //   69	87	171	finally
    //   46	69	181	java/lang/Throwable
    //   69	87	191	java/lang/Throwable
  }
  
  void cleanStatusAndTmpDir(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--cleanStatusAndTmpDir");
    TbsCoreVerManager.getInstance(paramContext).setTbsCoreDexoptRetryNum(0);
    TbsCoreVerManager.getInstance(paramContext).setTbsCoreUnzipRetryNum(0);
    TbsCoreVerManager.getInstance(paramContext).setTbsCoreUnlzmaStatus(0);
    TbsCoreVerManager.getInstance(paramContext).setStatus("incrupdate_retry_num", 0);
    if (!TbsDownloader.isDecoupleCore(paramContext))
    {
      TbsCoreVerManager.getInstance(paramContext).setTbsCoreInstallStatus(0, -1);
      TbsCoreVerManager.getInstance(paramContext).setTbsApkPath("");
      TbsCoreVerManager.getInstance(paramContext).setStatus("copy_retry_num", 0);
      TbsCoreVerManager.getInstance(paramContext).setTbsCoreIncrUpdateStatus(-1);
      TbsCoreVerManager.getInstance(paramContext).setTbsCoreCopyStatus(0, -1);
      FileUtil.delete(getCoreDir(paramContext, 0), true);
      FileUtil.delete(getCoreDir(paramContext, 1), true);
    }
  }
  
  void continueInstallTbsCore(Context paramContext, boolean paramBoolean)
  {
    int n = 0;
    if (paramBoolean) {
      this.isContinueInstallWithoutCore = true;
    }
    TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + paramContext.getApplicationInfo().processName);
    TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessId=" + android.os.Process.myPid());
    TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentThreadName=" + Thread.currentThread().getName());
    if (!getTbsInstallingFileLock(paramContext)) {
      return;
    }
    if (mTbsRenameLock.tryLock()) {}
    for (;;)
    {
      try
      {
        m = TbsCoreVerManager.getInstance(paramContext).getTbsCoreInstallStatus();
        k = TbsCoreVerManager.getInstance(paramContext).getTbsCoreInstallVer();
        str = TbsCoreVerManager.getInstance(paramContext).getStringValue("install_apk_path");
        i = TbsCoreVerManager.getInstance(paramContext).getIntNum("copy_core_ver");
        j = TbsCoreVerManager.getInstance(paramContext).getIntStatus("copy_status");
        mTbsRenameLock.unlock();
        releaseTbsInstallingFileLock();
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore installStatus=" + m);
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore tbsCoreInstallVer=" + k);
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore tbsApkPath=" + str);
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore tbsCoreCopyVer=" + i);
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore copyStatus=" + j);
        if (TbsShareManager.isThirdPartyApp(paramContext))
        {
          installTbsCoreForThirdPartyApp(paramContext, TbsShareManager.getAvailableTbsCoreVersion(paramContext, false));
          return;
        }
      }
      finally
      {
        mTbsRenameLock.unlock();
      }
      int i1 = TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_responsecode", 0);
      if ((i1 == 1) || (i1 == 2) || (i1 == 4)) {
        n = 1;
      }
      if ((n == 0) && (i1 != 0) && (i1 != 5))
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("operation", 10001);
        installLocalTesCoreEx(paramContext, localBundle);
      }
      if ((m > -1) && (m < 2)) {
        installTbsCore(paramContext, str, k);
      }
      if (j != 0) {
        break;
      }
      installLocalTbsCore(paramContext, i);
      return;
      int j = -1;
      String str = null;
      int k = 0;
      int m = -1;
      int i = 0;
    }
  }
  
  public boolean coreShareCopyToDecouple(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--coreShareCopyToDecouple #0");
    File localFile1 = getTbsCoreShareDir(paramContext);
    File localFile2 = getCoreShareDecoupleDir(paramContext);
    try
    {
      FileUtil.delete(localFile2, true);
      FileUtil.copyFiles(localFile1, localFile2, new TbsInstaller.5(this));
      TbsShareManager.shareCoreShareDecouple(paramContext);
      TbsLog.i("TbsInstaller", "TbsInstaller--coreShareCopyToDecouple success!!!");
      return true;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  Context createHostContext(Context paramContext, String paramString)
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
  
  /* Error */
  public String getConfileFileProperty(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_2
    //   4: invokestatic 910	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifeq +6 -> 13
    //   10: aload 4
    //   12: areturn
    //   13: new 460	java/io/File
    //   16: dup
    //   17: aload_0
    //   18: aload_1
    //   19: invokevirtual 688	com/tencent/smtt/sdk/TbsInstaller:getTbsCoreShareDir	(Landroid/content/Context;)Ljava/io/File;
    //   22: ldc 154
    //   24: invokespecial 469	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   27: astore_1
    //   28: aload_1
    //   29: ifnull +12 -> 41
    //   32: aload_1
    //   33: invokevirtual 473	java/io/File:exists	()Z
    //   36: istore_3
    //   37: iload_3
    //   38: ifne +18 -> 56
    //   41: iconst_0
    //   42: ifeq -32 -> 10
    //   45: new 1297	java/lang/NullPointerException
    //   48: dup
    //   49: invokespecial 1298	java/lang/NullPointerException:<init>	()V
    //   52: athrow
    //   53: astore_1
    //   54: aconst_null
    //   55: areturn
    //   56: new 726	java/util/Properties
    //   59: dup
    //   60: invokespecial 727	java/util/Properties:<init>	()V
    //   63: astore 5
    //   65: new 729	java/io/BufferedInputStream
    //   68: dup
    //   69: new 731	java/io/FileInputStream
    //   72: dup
    //   73: aload_1
    //   74: invokespecial 732	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   77: invokespecial 735	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   80: astore_1
    //   81: aload 5
    //   83: aload_1
    //   84: invokevirtual 738	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   87: aload_1
    //   88: invokevirtual 739	java/io/BufferedInputStream:close	()V
    //   91: aload 5
    //   93: aload_2
    //   94: invokevirtual 1299	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   97: astore_2
    //   98: aload_2
    //   99: astore 4
    //   101: aload_1
    //   102: ifnull -92 -> 10
    //   105: aload_1
    //   106: invokevirtual 739	java/io/BufferedInputStream:close	()V
    //   109: aload_2
    //   110: areturn
    //   111: astore_1
    //   112: aload_2
    //   113: areturn
    //   114: astore_1
    //   115: aconst_null
    //   116: astore_1
    //   117: aload_1
    //   118: ifnull -108 -> 10
    //   121: aload_1
    //   122: invokevirtual 739	java/io/BufferedInputStream:close	()V
    //   125: aconst_null
    //   126: areturn
    //   127: astore_1
    //   128: aconst_null
    //   129: areturn
    //   130: astore_2
    //   131: aconst_null
    //   132: astore_1
    //   133: aload_1
    //   134: ifnull +7 -> 141
    //   137: aload_1
    //   138: invokevirtual 739	java/io/BufferedInputStream:close	()V
    //   141: aload_2
    //   142: athrow
    //   143: astore_1
    //   144: goto -3 -> 141
    //   147: astore_2
    //   148: goto -15 -> 133
    //   151: astore_2
    //   152: goto -35 -> 117
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	155	0	this	TbsInstaller
    //   0	155	1	paramContext	Context
    //   0	155	2	paramString	String
    //   36	2	3	bool	boolean
    //   1	99	4	str	String
    //   63	29	5	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   45	53	53	java/io/IOException
    //   105	109	111	java/io/IOException
    //   13	28	114	java/lang/Exception
    //   32	37	114	java/lang/Exception
    //   56	81	114	java/lang/Exception
    //   121	125	127	java/io/IOException
    //   13	28	130	finally
    //   32	37	130	finally
    //   56	81	130	finally
    //   137	141	143	java/io/IOException
    //   81	98	147	finally
    //   81	98	151	java/lang/Exception
  }
  
  File getCoreDir(Context paramContext, int paramInt)
  {
    return getCoreDir(paramContext, paramInt, true);
  }
  
  File getCoreDir(Context paramContext, int paramInt, boolean paramBoolean)
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
        break label194;
      }
      if (paramContext.isDirectory()) {
        break label192;
      }
      if (!paramBoolean) {
        break;
      }
      if (paramContext.mkdir()) {
        break label192;
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
    label192:
    return paramContext;
    label194:
    TbsLog.i("TbsInstaller", "getCoreDir,tmpTbsShareDir = null");
    return null;
  }
  
  File getCoreShareDecoupleDir(Context paramContext)
  {
    paramContext = new File(QbSdk.getTbsFolderDir(paramContext), "core_share_decouple");
    if ((paramContext == null) || ((!paramContext.isDirectory()) && (!paramContext.mkdir()))) {
      return null;
    }
    return paramContext;
  }
  
  File getCoreShareDecoupleDir(Context paramContext1, Context paramContext2)
  {
    paramContext2 = new File(QbSdk.getTbsFolderDir(paramContext2), "core_share_decouple");
    if ((paramContext2 == null) || ((!paramContext2.isDirectory()) && ((paramContext1 == null) || (!TbsShareManager.isThirdPartyApp(paramContext1))) && (!paramContext2.mkdir()))) {
      return null;
    }
    return paramContext2;
  }
  
  public Context getTbsCoreHostContext(Context paramContext, int paramInt)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreHostContext tbsCoreTargetVer=" + paramInt);
    if (paramInt <= 0) {
      return null;
    }
    String[] arrayOfString = TbsShareManager.getCoreProviderAppList();
    int i = 0;
    if (i < arrayOfString.length)
    {
      if (paramContext.getPackageName().equalsIgnoreCase(arrayOfString[i])) {}
      Context localContext;
      label140:
      int j;
      do
      {
        for (;;)
        {
          i += 1;
          break;
          if (isHostAppInstalled(paramContext, arrayOfString[i]))
          {
            localContext = createHostContext(paramContext, arrayOfString[i]);
            if (localContext != null)
            {
              if (vertificateApp(localContext)) {
                break label140;
              }
              TbsLog.e("TbsInstaller", "TbsInstaller--getTbsCoreHostContext " + arrayOfString[i] + " illegal signature go on next");
            }
          }
        }
        j = getTbsCoreInstalledVerInNolock(localContext);
        TbsLog.i("TbsInstaller", "TbsInstaller-getTbsCoreHostContext hostTbsCoreVer=" + j);
      } while ((j == 0) || (j != paramInt));
      TbsLog.i("TbsInstaller", "TbsInstaller-getTbsCoreHostContext targetApp=" + arrayOfString[i]);
      return localContext;
    }
    return null;
  }
  
  /* Error */
  int getTbsCoreInstalledVerInNolock(Context paramContext)
  {
    // Byte code:
    //   0: new 460	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: aload_1
    //   6: invokevirtual 688	com/tencent/smtt/sdk/TbsInstaller:getTbsCoreShareDir	(Landroid/content/Context;)Ljava/io/File;
    //   9: ldc 154
    //   11: invokespecial 469	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   14: astore_1
    //   15: aload_1
    //   16: ifnull +12 -> 28
    //   19: aload_1
    //   20: invokevirtual 473	java/io/File:exists	()Z
    //   23: istore_3
    //   24: iload_3
    //   25: ifne +48 -> 73
    //   28: iconst_0
    //   29: ifeq +11 -> 40
    //   32: new 1297	java/lang/NullPointerException
    //   35: dup
    //   36: invokespecial 1298	java/lang/NullPointerException:<init>	()V
    //   39: athrow
    //   40: iconst_0
    //   41: ireturn
    //   42: astore_1
    //   43: ldc 151
    //   45: new 479	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   52: ldc_w 1717
    //   55: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload_1
    //   59: invokevirtual 1718	java/io/IOException:toString	()Ljava/lang/String;
    //   62: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   71: iconst_0
    //   72: ireturn
    //   73: new 726	java/util/Properties
    //   76: dup
    //   77: invokespecial 727	java/util/Properties:<init>	()V
    //   80: astore 5
    //   82: new 729	java/io/BufferedInputStream
    //   85: dup
    //   86: new 731	java/io/FileInputStream
    //   89: dup
    //   90: aload_1
    //   91: invokespecial 732	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   94: invokespecial 735	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   97: astore 4
    //   99: aload 4
    //   101: astore_1
    //   102: aload 5
    //   104: aload 4
    //   106: invokevirtual 738	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   109: aload 4
    //   111: astore_1
    //   112: aload 4
    //   114: invokevirtual 739	java/io/BufferedInputStream:close	()V
    //   117: aload 4
    //   119: astore_1
    //   120: aload 5
    //   122: ldc 163
    //   124: invokevirtual 1299	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   127: astore 5
    //   129: aload 5
    //   131: ifnonnull +46 -> 177
    //   134: aload 4
    //   136: ifnull -96 -> 40
    //   139: aload 4
    //   141: invokevirtual 739	java/io/BufferedInputStream:close	()V
    //   144: iconst_0
    //   145: ireturn
    //   146: astore_1
    //   147: ldc 151
    //   149: new 479	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   156: ldc_w 1717
    //   159: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload_1
    //   163: invokevirtual 1718	java/io/IOException:toString	()Ljava/lang/String;
    //   166: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   175: iconst_0
    //   176: ireturn
    //   177: aload 4
    //   179: astore_1
    //   180: aload 5
    //   182: invokestatic 1721	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   185: istore_2
    //   186: aload 4
    //   188: astore_1
    //   189: getstatic 335	com/tencent/smtt/sdk/TbsInstaller:mCoreVersion	I
    //   192: ifne +10 -> 202
    //   195: aload 4
    //   197: astore_1
    //   198: iload_2
    //   199: putstatic 335	com/tencent/smtt/sdk/TbsInstaller:mCoreVersion	I
    //   202: aload 4
    //   204: ifnull +8 -> 212
    //   207: aload 4
    //   209: invokevirtual 739	java/io/BufferedInputStream:close	()V
    //   212: iload_2
    //   213: ireturn
    //   214: astore_1
    //   215: ldc 151
    //   217: new 479	java/lang/StringBuilder
    //   220: dup
    //   221: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   224: ldc_w 1717
    //   227: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: aload_1
    //   231: invokevirtual 1718	java/io/IOException:toString	()Ljava/lang/String;
    //   234: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   243: goto -31 -> 212
    //   246: astore 5
    //   248: aconst_null
    //   249: astore 4
    //   251: aload 4
    //   253: astore_1
    //   254: ldc 151
    //   256: new 479	java/lang/StringBuilder
    //   259: dup
    //   260: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   263: ldc_w 1723
    //   266: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: aload 5
    //   271: invokevirtual 765	java/lang/Exception:toString	()Ljava/lang/String;
    //   274: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   280: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   283: aload 4
    //   285: ifnull -245 -> 40
    //   288: aload 4
    //   290: invokevirtual 739	java/io/BufferedInputStream:close	()V
    //   293: iconst_0
    //   294: ireturn
    //   295: astore_1
    //   296: ldc 151
    //   298: new 479	java/lang/StringBuilder
    //   301: dup
    //   302: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   305: ldc_w 1717
    //   308: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: aload_1
    //   312: invokevirtual 1718	java/io/IOException:toString	()Ljava/lang/String;
    //   315: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   321: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   324: iconst_0
    //   325: ireturn
    //   326: astore 4
    //   328: aconst_null
    //   329: astore_1
    //   330: aload_1
    //   331: ifnull +7 -> 338
    //   334: aload_1
    //   335: invokevirtual 739	java/io/BufferedInputStream:close	()V
    //   338: aload 4
    //   340: athrow
    //   341: astore_1
    //   342: ldc 151
    //   344: new 479	java/lang/StringBuilder
    //   347: dup
    //   348: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   351: ldc_w 1717
    //   354: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: aload_1
    //   358: invokevirtual 1718	java/io/IOException:toString	()Ljava/lang/String;
    //   361: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   367: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   370: goto -32 -> 338
    //   373: astore 4
    //   375: goto -45 -> 330
    //   378: astore 5
    //   380: goto -129 -> 251
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	383	0	this	TbsInstaller
    //   0	383	1	paramContext	Context
    //   185	28	2	i	int
    //   23	2	3	bool	boolean
    //   97	192	4	localBufferedInputStream	java.io.BufferedInputStream
    //   326	13	4	localObject1	Object
    //   373	1	4	localObject2	Object
    //   80	101	5	localObject3	Object
    //   246	24	5	localException1	Exception
    //   378	1	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   32	40	42	java/io/IOException
    //   139	144	146	java/io/IOException
    //   207	212	214	java/io/IOException
    //   0	15	246	java/lang/Exception
    //   19	24	246	java/lang/Exception
    //   73	99	246	java/lang/Exception
    //   288	293	295	java/io/IOException
    //   0	15	326	finally
    //   19	24	326	finally
    //   73	99	326	finally
    //   334	338	341	java/io/IOException
    //   102	109	373	finally
    //   112	117	373	finally
    //   120	129	373	finally
    //   180	186	373	finally
    //   189	195	373	finally
    //   198	202	373	finally
    //   254	283	373	finally
    //   102	109	378	java/lang/Exception
    //   112	117	378	java/lang/Exception
    //   120	129	378	java/lang/Exception
    //   180	186	378	java/lang/Exception
    //   189	195	378	java/lang/Exception
    //   198	202	378	java/lang/Exception
  }
  
  int getTbsCoreInstalledVerInNolockForCrash(Context paramContext)
  {
    if (mCoreVersion != 0) {
      return mCoreVersion;
    }
    return getTbsCoreInstalledVerInNolock(paramContext);
  }
  
  /* Error */
  int getTbsCoreInstalledVerWithLock(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 573	com/tencent/smtt/sdk/TbsInstaller:getTbsInstallingFileLock	(Landroid/content/Context;)Z
    //   5: ifne +5 -> 10
    //   8: iconst_m1
    //   9: ireturn
    //   10: getstatic 279	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   13: invokevirtual 1072	java/util/concurrent/locks/ReentrantLock:tryLock	()Z
    //   16: istore_3
    //   17: ldc 151
    //   19: new 479	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   26: ldc_w 1726
    //   29: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: iload_3
    //   33: invokevirtual 583	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   36: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   42: iload_3
    //   43: ifeq +627 -> 670
    //   46: new 460	java/io/File
    //   49: dup
    //   50: aload_0
    //   51: aload_1
    //   52: invokevirtual 688	com/tencent/smtt/sdk/TbsInstaller:getTbsCoreShareDir	(Landroid/content/Context;)Ljava/io/File;
    //   55: ldc 154
    //   57: invokespecial 469	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   60: astore_1
    //   61: aload_1
    //   62: ifnull +12 -> 74
    //   65: aload_1
    //   66: invokevirtual 473	java/io/File:exists	()Z
    //   69: istore_3
    //   70: iload_3
    //   71: ifne +97 -> 168
    //   74: iconst_0
    //   75: ifeq +11 -> 86
    //   78: new 1297	java/lang/NullPointerException
    //   81: dup
    //   82: invokespecial 1298	java/lang/NullPointerException:<init>	()V
    //   85: athrow
    //   86: getstatic 279	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   89: invokevirtual 1729	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   92: ifeq +9 -> 101
    //   95: getstatic 279	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   98: invokevirtual 609	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   101: aload_0
    //   102: invokevirtual 613	com/tencent/smtt/sdk/TbsInstaller:releaseTbsInstallingFileLock	()V
    //   105: iconst_0
    //   106: ireturn
    //   107: astore_1
    //   108: ldc 151
    //   110: new 479	java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   117: ldc_w 1731
    //   120: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: aload_1
    //   124: invokevirtual 1718	java/io/IOException:toString	()Ljava/lang/String;
    //   127: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   136: goto -50 -> 86
    //   139: astore_1
    //   140: ldc 151
    //   142: new 479	java/lang/StringBuilder
    //   145: dup
    //   146: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   149: ldc_w 1733
    //   152: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: aload_1
    //   156: invokevirtual 875	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   159: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokestatic 393	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   165: goto -64 -> 101
    //   168: new 726	java/util/Properties
    //   171: dup
    //   172: invokespecial 727	java/util/Properties:<init>	()V
    //   175: astore 5
    //   177: new 729	java/io/BufferedInputStream
    //   180: dup
    //   181: new 731	java/io/FileInputStream
    //   184: dup
    //   185: aload_1
    //   186: invokespecial 732	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   189: invokespecial 735	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   192: astore 4
    //   194: aload 4
    //   196: astore_1
    //   197: aload 5
    //   199: aload 4
    //   201: invokevirtual 738	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   204: aload 4
    //   206: astore_1
    //   207: aload 4
    //   209: invokevirtual 739	java/io/BufferedInputStream:close	()V
    //   212: aload 4
    //   214: astore_1
    //   215: aload 5
    //   217: ldc 163
    //   219: invokevirtual 1299	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   222: astore 5
    //   224: aload 5
    //   226: ifnonnull +95 -> 321
    //   229: aload 4
    //   231: ifnull +8 -> 239
    //   234: aload 4
    //   236: invokevirtual 739	java/io/BufferedInputStream:close	()V
    //   239: getstatic 279	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   242: invokevirtual 1729	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   245: ifeq +9 -> 254
    //   248: getstatic 279	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   251: invokevirtual 609	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   254: aload_0
    //   255: invokevirtual 613	com/tencent/smtt/sdk/TbsInstaller:releaseTbsInstallingFileLock	()V
    //   258: iconst_0
    //   259: ireturn
    //   260: astore_1
    //   261: ldc 151
    //   263: new 479	java/lang/StringBuilder
    //   266: dup
    //   267: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   270: ldc_w 1731
    //   273: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: aload_1
    //   277: invokevirtual 1718	java/io/IOException:toString	()Ljava/lang/String;
    //   280: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   286: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   289: goto -50 -> 239
    //   292: astore_1
    //   293: ldc 151
    //   295: new 479	java/lang/StringBuilder
    //   298: dup
    //   299: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   302: ldc_w 1733
    //   305: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: aload_1
    //   309: invokevirtual 875	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   312: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   315: invokestatic 393	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   318: goto -64 -> 254
    //   321: aload 4
    //   323: astore_1
    //   324: getstatic 288	com/tencent/smtt/sdk/TbsInstaller:mTbsCoreInstalledVer	Ljava/lang/ThreadLocal;
    //   327: aload 5
    //   329: invokestatic 1721	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   332: invokestatic 1226	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   335: invokevirtual 1232	java/lang/ThreadLocal:set	(Ljava/lang/Object;)V
    //   338: aload 4
    //   340: astore_1
    //   341: getstatic 288	com/tencent/smtt/sdk/TbsInstaller:mTbsCoreInstalledVer	Ljava/lang/ThreadLocal;
    //   344: invokevirtual 1737	java/lang/ThreadLocal:get	()Ljava/lang/Object;
    //   347: checkcast 1223	java/lang/Integer
    //   350: invokevirtual 1740	java/lang/Integer:intValue	()I
    //   353: istore_2
    //   354: aload 4
    //   356: ifnull +8 -> 364
    //   359: aload 4
    //   361: invokevirtual 739	java/io/BufferedInputStream:close	()V
    //   364: getstatic 279	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   367: invokevirtual 1729	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   370: ifeq +9 -> 379
    //   373: getstatic 279	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   376: invokevirtual 609	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   379: aload_0
    //   380: invokevirtual 613	com/tencent/smtt/sdk/TbsInstaller:releaseTbsInstallingFileLock	()V
    //   383: iload_2
    //   384: ireturn
    //   385: astore_1
    //   386: ldc 151
    //   388: new 479	java/lang/StringBuilder
    //   391: dup
    //   392: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   395: ldc_w 1731
    //   398: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: aload_1
    //   402: invokevirtual 1718	java/io/IOException:toString	()Ljava/lang/String;
    //   405: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   411: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   414: goto -50 -> 364
    //   417: astore_1
    //   418: ldc 151
    //   420: new 479	java/lang/StringBuilder
    //   423: dup
    //   424: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   427: ldc_w 1733
    //   430: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: aload_1
    //   434: invokevirtual 875	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   437: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   440: invokestatic 393	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   443: goto -64 -> 379
    //   446: astore 5
    //   448: aconst_null
    //   449: astore 4
    //   451: aload 4
    //   453: astore_1
    //   454: ldc 151
    //   456: new 479	java/lang/StringBuilder
    //   459: dup
    //   460: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   463: ldc_w 1742
    //   466: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: aload 5
    //   471: invokevirtual 765	java/lang/Exception:toString	()Ljava/lang/String;
    //   474: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   480: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   483: aload 4
    //   485: ifnull +8 -> 493
    //   488: aload 4
    //   490: invokevirtual 739	java/io/BufferedInputStream:close	()V
    //   493: getstatic 279	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   496: invokevirtual 1729	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   499: ifeq +9 -> 508
    //   502: getstatic 279	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   505: invokevirtual 609	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   508: aload_0
    //   509: invokevirtual 613	com/tencent/smtt/sdk/TbsInstaller:releaseTbsInstallingFileLock	()V
    //   512: iconst_0
    //   513: ireturn
    //   514: astore_1
    //   515: ldc 151
    //   517: new 479	java/lang/StringBuilder
    //   520: dup
    //   521: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   524: ldc_w 1731
    //   527: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: aload_1
    //   531: invokevirtual 1718	java/io/IOException:toString	()Ljava/lang/String;
    //   534: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   537: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   540: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   543: goto -50 -> 493
    //   546: astore_1
    //   547: ldc 151
    //   549: new 479	java/lang/StringBuilder
    //   552: dup
    //   553: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   556: ldc_w 1733
    //   559: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: aload_1
    //   563: invokevirtual 875	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   566: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   569: invokestatic 393	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   572: goto -64 -> 508
    //   575: astore 4
    //   577: aconst_null
    //   578: astore_1
    //   579: aload_1
    //   580: ifnull +7 -> 587
    //   583: aload_1
    //   584: invokevirtual 739	java/io/BufferedInputStream:close	()V
    //   587: getstatic 279	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   590: invokevirtual 1729	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   593: ifeq +9 -> 602
    //   596: getstatic 279	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   599: invokevirtual 609	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   602: aload_0
    //   603: invokevirtual 613	com/tencent/smtt/sdk/TbsInstaller:releaseTbsInstallingFileLock	()V
    //   606: aload 4
    //   608: athrow
    //   609: astore_1
    //   610: ldc 151
    //   612: new 479	java/lang/StringBuilder
    //   615: dup
    //   616: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   619: ldc_w 1731
    //   622: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   625: aload_1
    //   626: invokevirtual 1718	java/io/IOException:toString	()Ljava/lang/String;
    //   629: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   632: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   635: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   638: goto -51 -> 587
    //   641: astore_1
    //   642: ldc 151
    //   644: new 479	java/lang/StringBuilder
    //   647: dup
    //   648: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   651: ldc_w 1733
    //   654: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   657: aload_1
    //   658: invokevirtual 875	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   661: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   664: invokestatic 393	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   667: goto -65 -> 602
    //   670: aload_0
    //   671: invokevirtual 613	com/tencent/smtt/sdk/TbsInstaller:releaseTbsInstallingFileLock	()V
    //   674: iconst_0
    //   675: ireturn
    //   676: astore 4
    //   678: goto -99 -> 579
    //   681: astore 5
    //   683: goto -232 -> 451
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	686	0	this	TbsInstaller
    //   0	686	1	paramContext	Context
    //   353	31	2	i	int
    //   16	55	3	bool	boolean
    //   192	297	4	localBufferedInputStream	java.io.BufferedInputStream
    //   575	32	4	localObject1	Object
    //   676	1	4	localObject2	Object
    //   175	153	5	localObject3	Object
    //   446	24	5	localException1	Exception
    //   681	1	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   78	86	107	java/io/IOException
    //   86	101	139	java/lang/Throwable
    //   234	239	260	java/io/IOException
    //   239	254	292	java/lang/Throwable
    //   359	364	385	java/io/IOException
    //   364	379	417	java/lang/Throwable
    //   46	61	446	java/lang/Exception
    //   65	70	446	java/lang/Exception
    //   168	194	446	java/lang/Exception
    //   488	493	514	java/io/IOException
    //   493	508	546	java/lang/Throwable
    //   46	61	575	finally
    //   65	70	575	finally
    //   168	194	575	finally
    //   583	587	609	java/io/IOException
    //   587	602	641	java/lang/Throwable
    //   197	204	676	finally
    //   207	212	676	finally
    //   215	224	676	finally
    //   324	338	676	finally
    //   341	354	676	finally
    //   454	483	676	finally
    //   197	204	681	java/lang/Exception
    //   207	212	681	java/lang/Exception
    //   215	224	681	java/lang/Exception
    //   324	338	681	java/lang/Exception
    //   341	354	681	java/lang/Exception
  }
  
  public int getTbsCoreInstalledVerWithNew(boolean paramBoolean, Context paramContext)
  {
    if ((paramBoolean) || (((Integer)mTbsCoreInstalledVer.get()).intValue() <= 0)) {
      mTbsCoreInstalledVer.set(Integer.valueOf(getTbsCoreInstalledVerInNolock(paramContext)));
    }
    return ((Integer)mTbsCoreInstalledVer.get()).intValue();
  }
  
  /* Error */
  int getTbsCoreShareDecoupleCoreVersion(Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aconst_null
    //   3: astore 5
    //   5: new 460	java/io/File
    //   8: dup
    //   9: aload_0
    //   10: aload_1
    //   11: invokevirtual 691	com/tencent/smtt/sdk/TbsInstaller:getCoreShareDecoupleDir	(Landroid/content/Context;)Ljava/io/File;
    //   14: ldc 154
    //   16: invokespecial 469	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   19: astore_1
    //   20: aload_1
    //   21: ifnull +14 -> 35
    //   24: aload_1
    //   25: invokevirtual 473	java/io/File:exists	()Z
    //   28: istore 4
    //   30: iload 4
    //   32: ifne +17 -> 49
    //   35: iconst_0
    //   36: ifeq +11 -> 47
    //   39: new 1297	java/lang/NullPointerException
    //   42: dup
    //   43: invokespecial 1298	java/lang/NullPointerException:<init>	()V
    //   46: athrow
    //   47: iload_2
    //   48: ireturn
    //   49: new 726	java/util/Properties
    //   52: dup
    //   53: invokespecial 727	java/util/Properties:<init>	()V
    //   56: astore 6
    //   58: new 729	java/io/BufferedInputStream
    //   61: dup
    //   62: new 731	java/io/FileInputStream
    //   65: dup
    //   66: aload_1
    //   67: invokespecial 732	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   70: invokespecial 735	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   73: astore_1
    //   74: aload 6
    //   76: aload_1
    //   77: invokevirtual 738	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   80: aload_1
    //   81: invokevirtual 739	java/io/BufferedInputStream:close	()V
    //   84: aload 6
    //   86: ldc 163
    //   88: invokevirtual 1299	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   91: astore 5
    //   93: aload 5
    //   95: ifnonnull +16 -> 111
    //   98: aload_1
    //   99: ifnull -52 -> 47
    //   102: aload_1
    //   103: invokevirtual 739	java/io/BufferedInputStream:close	()V
    //   106: iconst_0
    //   107: ireturn
    //   108: astore_1
    //   109: iconst_0
    //   110: ireturn
    //   111: aload 5
    //   113: invokestatic 1721	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   116: istore_3
    //   117: iload_3
    //   118: istore_2
    //   119: aload_1
    //   120: ifnull -73 -> 47
    //   123: aload_1
    //   124: invokevirtual 739	java/io/BufferedInputStream:close	()V
    //   127: iload_3
    //   128: ireturn
    //   129: astore_1
    //   130: iload_3
    //   131: ireturn
    //   132: astore_1
    //   133: aconst_null
    //   134: astore_1
    //   135: aload_1
    //   136: ifnull -89 -> 47
    //   139: aload_1
    //   140: invokevirtual 739	java/io/BufferedInputStream:close	()V
    //   143: iconst_0
    //   144: ireturn
    //   145: astore_1
    //   146: iconst_0
    //   147: ireturn
    //   148: astore_1
    //   149: aload 5
    //   151: ifnull +8 -> 159
    //   154: aload 5
    //   156: invokevirtual 739	java/io/BufferedInputStream:close	()V
    //   159: aload_1
    //   160: athrow
    //   161: astore_1
    //   162: iconst_0
    //   163: ireturn
    //   164: astore 5
    //   166: goto -7 -> 159
    //   169: astore 6
    //   171: aload_1
    //   172: astore 5
    //   174: aload 6
    //   176: astore_1
    //   177: goto -28 -> 149
    //   180: astore 5
    //   182: goto -47 -> 135
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	this	TbsInstaller
    //   0	185	1	paramContext	Context
    //   1	118	2	i	int
    //   116	15	3	j	int
    //   28	3	4	bool	boolean
    //   3	152	5	str	String
    //   164	1	5	localIOException	java.io.IOException
    //   172	1	5	localContext	Context
    //   180	1	5	localException	Exception
    //   56	29	6	localProperties	java.util.Properties
    //   169	6	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   102	106	108	java/io/IOException
    //   123	127	129	java/io/IOException
    //   5	20	132	java/lang/Exception
    //   24	30	132	java/lang/Exception
    //   49	74	132	java/lang/Exception
    //   139	143	145	java/io/IOException
    //   5	20	148	finally
    //   24	30	148	finally
    //   49	74	148	finally
    //   39	47	161	java/io/IOException
    //   154	159	164	java/io/IOException
    //   74	93	169	finally
    //   111	117	169	finally
    //   74	93	180	java/lang/Exception
    //   111	117	180	java/lang/Exception
  }
  
  File getTbsCoreShareDir(Context paramContext)
  {
    return getTbsCoreShareDir(null, paramContext);
  }
  
  File getTbsCoreShareDir(Context paramContext1, Context paramContext2)
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
  
  int getTbsCoreVerFromApk(Context paramContext, String paramString)
  {
    int i = 0;
    paramContext = paramContext.getPackageManager().getPackageArchiveInfo(paramString, 0);
    if (paramContext != null) {
      i = paramContext.versionCode;
    }
    return i;
  }
  
  /* Error */
  int getTbsCoreVersionAppDefined(String paramString)
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
    //   11: new 460	java/io/File
    //   14: dup
    //   15: new 460	java/io/File
    //   18: dup
    //   19: aload_1
    //   20: invokespecial 1034	java/io/File:<init>	(Ljava/lang/String;)V
    //   23: ldc 154
    //   25: invokespecial 469	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   28: astore_1
    //   29: aload_1
    //   30: ifnull +14 -> 44
    //   33: aload_1
    //   34: invokevirtual 473	java/io/File:exists	()Z
    //   37: istore 4
    //   39: iload 4
    //   41: ifne +18 -> 59
    //   44: iconst_0
    //   45: ifeq -39 -> 6
    //   48: new 1297	java/lang/NullPointerException
    //   51: dup
    //   52: invokespecial 1298	java/lang/NullPointerException:<init>	()V
    //   55: athrow
    //   56: astore_1
    //   57: iconst_0
    //   58: ireturn
    //   59: new 726	java/util/Properties
    //   62: dup
    //   63: invokespecial 727	java/util/Properties:<init>	()V
    //   66: astore 6
    //   68: new 729	java/io/BufferedInputStream
    //   71: dup
    //   72: new 731	java/io/FileInputStream
    //   75: dup
    //   76: aload_1
    //   77: invokespecial 732	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   80: invokespecial 735	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   83: astore_1
    //   84: aload 6
    //   86: aload_1
    //   87: invokevirtual 738	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   90: aload_1
    //   91: invokevirtual 739	java/io/BufferedInputStream:close	()V
    //   94: aload 6
    //   96: ldc 163
    //   98: invokevirtual 1299	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   101: astore 5
    //   103: aload 5
    //   105: ifnonnull +16 -> 121
    //   108: aload_1
    //   109: ifnull -103 -> 6
    //   112: aload_1
    //   113: invokevirtual 739	java/io/BufferedInputStream:close	()V
    //   116: iconst_0
    //   117: ireturn
    //   118: astore_1
    //   119: iconst_0
    //   120: ireturn
    //   121: aload 5
    //   123: invokestatic 1721	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   126: istore_3
    //   127: iload_3
    //   128: istore_2
    //   129: aload_1
    //   130: ifnull -124 -> 6
    //   133: aload_1
    //   134: invokevirtual 739	java/io/BufferedInputStream:close	()V
    //   137: iload_3
    //   138: ireturn
    //   139: astore_1
    //   140: iload_3
    //   141: ireturn
    //   142: astore_1
    //   143: aconst_null
    //   144: astore_1
    //   145: aload_1
    //   146: ifnull -140 -> 6
    //   149: aload_1
    //   150: invokevirtual 739	java/io/BufferedInputStream:close	()V
    //   153: iconst_0
    //   154: ireturn
    //   155: astore_1
    //   156: iconst_0
    //   157: ireturn
    //   158: astore_1
    //   159: aload 5
    //   161: ifnull +8 -> 169
    //   164: aload 5
    //   166: invokevirtual 739	java/io/BufferedInputStream:close	()V
    //   169: aload_1
    //   170: athrow
    //   171: astore 5
    //   173: goto -4 -> 169
    //   176: astore 6
    //   178: aload_1
    //   179: astore 5
    //   181: aload 6
    //   183: astore_1
    //   184: goto -25 -> 159
    //   187: astore 5
    //   189: goto -44 -> 145
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	192	0	this	TbsInstaller
    //   0	192	1	paramString	String
    //   1	128	2	i	int
    //   126	15	3	j	int
    //   37	3	4	bool	boolean
    //   9	156	5	str1	String
    //   171	1	5	localIOException	java.io.IOException
    //   179	1	5	str2	String
    //   187	1	5	localException	Exception
    //   66	29	6	localProperties	java.util.Properties
    //   176	6	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   48	56	56	java/io/IOException
    //   112	116	118	java/io/IOException
    //   133	137	139	java/io/IOException
    //   11	29	142	java/lang/Exception
    //   33	39	142	java/lang/Exception
    //   59	84	142	java/lang/Exception
    //   149	153	155	java/io/IOException
    //   11	29	158	finally
    //   33	39	158	finally
    //   59	84	158	finally
    //   164	169	171	java/io/IOException
    //   84	103	176	finally
    //   121	127	176	finally
    //   84	103	187	java/lang/Exception
    //   121	127	187	java/lang/Exception
  }
  
  /* Error */
  boolean getTbsInstallingFileLock(Context paramContext)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 341	com/tencent/smtt/sdk/TbsInstaller:currentTbsFileLockStackCount	I
    //   8: ifle +25 -> 33
    //   11: ldc 151
    //   13: ldc_w 1754
    //   16: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: aload_0
    //   20: aload_0
    //   21: getfield 341	com/tencent/smtt/sdk/TbsInstaller:currentTbsFileLockStackCount	I
    //   24: iconst_1
    //   25: iadd
    //   26: putfield 341	com/tencent/smtt/sdk/TbsInstaller:currentTbsFileLockStackCount	I
    //   29: aload_0
    //   30: monitorexit
    //   31: iload_2
    //   32: ireturn
    //   33: aload_0
    //   34: aload_1
    //   35: iconst_1
    //   36: ldc_w 1756
    //   39: invokestatic 1760	com/tencent/smtt/utils/FileUtil:getLockFos	(Landroid/content/Context;ZLjava/lang/String;)Ljava/io/FileOutputStream;
    //   42: putfield 1762	com/tencent/smtt/sdk/TbsInstaller:tbsInstallingFos	Ljava/io/FileOutputStream;
    //   45: aload_0
    //   46: getfield 1762	com/tencent/smtt/sdk/TbsInstaller:tbsInstallingFos	Ljava/io/FileOutputStream;
    //   49: ifnull +35 -> 84
    //   52: aload_0
    //   53: aload_1
    //   54: aload_0
    //   55: getfield 1762	com/tencent/smtt/sdk/TbsInstaller:tbsInstallingFos	Ljava/io/FileOutputStream;
    //   58: invokestatic 1766	com/tencent/smtt/utils/FileUtil:tryFileLock	(Landroid/content/Context;Ljava/io/FileOutputStream;)Ljava/nio/channels/FileLock;
    //   61: putfield 1768	com/tencent/smtt/sdk/TbsInstaller:tbsFileLockFileLock	Ljava/nio/channels/FileLock;
    //   64: aload_0
    //   65: getfield 1768	com/tencent/smtt/sdk/TbsInstaller:tbsFileLockFileLock	Ljava/nio/channels/FileLock;
    //   68: ifnonnull +29 -> 97
    //   71: ldc 151
    //   73: ldc_w 1770
    //   76: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   79: iconst_0
    //   80: istore_2
    //   81: goto -52 -> 29
    //   84: ldc 151
    //   86: ldc_w 1772
    //   89: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: iconst_0
    //   93: istore_2
    //   94: goto -65 -> 29
    //   97: ldc 151
    //   99: ldc_w 1774
    //   102: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   105: aload_0
    //   106: aload_0
    //   107: getfield 341	com/tencent/smtt/sdk/TbsInstaller:currentTbsFileLockStackCount	I
    //   110: iconst_1
    //   111: iadd
    //   112: putfield 341	com/tencent/smtt/sdk/TbsInstaller:currentTbsFileLockStackCount	I
    //   115: goto -86 -> 29
    //   118: astore_1
    //   119: aload_0
    //   120: monitorexit
    //   121: aload_1
    //   122: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	this	TbsInstaller
    //   0	123	1	paramContext	Context
    //   1	93	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   4	29	118	finally
    //   33	79	118	finally
    //   84	92	118	finally
    //   97	115	118	finally
  }
  
  File getTbsShareDir(Context paramContext)
  {
    paramContext = new File(QbSdk.getTbsFolderDir(paramContext), "share");
    if ((paramContext == null) || ((!paramContext.isDirectory()) && (!paramContext.mkdir()))) {
      return null;
    }
    return paramContext;
  }
  
  int getTbsVersion(Context paramContext, int paramInt)
  {
    return getTbsVersion(getCoreDir(paramContext, paramInt));
  }
  
  /* Error */
  int getTbsVersion(File paramFile)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aconst_null
    //   3: astore 5
    //   5: ldc 151
    //   7: new 479	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   14: ldc_w 1778
    //   17: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: aload_1
    //   21: invokevirtual 875	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   24: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: new 460	java/io/File
    //   33: dup
    //   34: aload_1
    //   35: ldc 154
    //   37: invokespecial 469	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   40: astore_1
    //   41: aload_1
    //   42: ifnull +14 -> 56
    //   45: aload_1
    //   46: invokevirtual 473	java/io/File:exists	()Z
    //   49: istore 4
    //   51: iload 4
    //   53: ifne +17 -> 70
    //   56: iconst_0
    //   57: ifeq +11 -> 68
    //   60: new 1297	java/lang/NullPointerException
    //   63: dup
    //   64: invokespecial 1298	java/lang/NullPointerException:<init>	()V
    //   67: athrow
    //   68: iload_2
    //   69: ireturn
    //   70: new 726	java/util/Properties
    //   73: dup
    //   74: invokespecial 727	java/util/Properties:<init>	()V
    //   77: astore 6
    //   79: new 729	java/io/BufferedInputStream
    //   82: dup
    //   83: new 731	java/io/FileInputStream
    //   86: dup
    //   87: aload_1
    //   88: invokespecial 732	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   91: invokespecial 735	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   94: astore_1
    //   95: aload 6
    //   97: aload_1
    //   98: invokevirtual 738	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   101: aload_1
    //   102: invokevirtual 739	java/io/BufferedInputStream:close	()V
    //   105: aload 6
    //   107: ldc 163
    //   109: invokevirtual 1299	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   112: astore 5
    //   114: aload 5
    //   116: ifnonnull +16 -> 132
    //   119: aload_1
    //   120: ifnull -52 -> 68
    //   123: aload_1
    //   124: invokevirtual 739	java/io/BufferedInputStream:close	()V
    //   127: iconst_0
    //   128: ireturn
    //   129: astore_1
    //   130: iconst_0
    //   131: ireturn
    //   132: aload 5
    //   134: invokestatic 1721	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   137: istore_3
    //   138: iload_3
    //   139: istore_2
    //   140: aload_1
    //   141: ifnull -73 -> 68
    //   144: aload_1
    //   145: invokevirtual 739	java/io/BufferedInputStream:close	()V
    //   148: iload_3
    //   149: ireturn
    //   150: astore_1
    //   151: iload_3
    //   152: ireturn
    //   153: astore_1
    //   154: aconst_null
    //   155: astore_1
    //   156: aload_1
    //   157: ifnull -89 -> 68
    //   160: aload_1
    //   161: invokevirtual 739	java/io/BufferedInputStream:close	()V
    //   164: iconst_0
    //   165: ireturn
    //   166: astore_1
    //   167: iconst_0
    //   168: ireturn
    //   169: astore_1
    //   170: aload 5
    //   172: ifnull +8 -> 180
    //   175: aload 5
    //   177: invokevirtual 739	java/io/BufferedInputStream:close	()V
    //   180: aload_1
    //   181: athrow
    //   182: astore_1
    //   183: iconst_0
    //   184: ireturn
    //   185: astore 5
    //   187: goto -7 -> 180
    //   190: astore 6
    //   192: aload_1
    //   193: astore 5
    //   195: aload 6
    //   197: astore_1
    //   198: goto -28 -> 170
    //   201: astore 5
    //   203: goto -47 -> 156
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	this	TbsInstaller
    //   0	206	1	paramFile	File
    //   1	139	2	i	int
    //   137	15	3	j	int
    //   49	3	4	bool	boolean
    //   3	173	5	str	String
    //   185	1	5	localIOException	java.io.IOException
    //   193	1	5	localFile	File
    //   201	1	5	localException	Exception
    //   77	29	6	localProperties	java.util.Properties
    //   190	6	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   123	127	129	java/io/IOException
    //   144	148	150	java/io/IOException
    //   5	41	153	java/lang/Exception
    //   45	51	153	java/lang/Exception
    //   70	95	153	java/lang/Exception
    //   160	164	166	java/io/IOException
    //   5	41	169	finally
    //   45	51	169	finally
    //   70	95	169	finally
    //   60	68	182	java/io/IOException
    //   175	180	185	java/io/IOException
    //   95	114	190	finally
    //   132	138	190	finally
    //   95	114	201	java/lang/Exception
    //   132	138	201	java/lang/Exception
  }
  
  public boolean hasStaticTbsInstalled(Context paramContext, File[] paramArrayOfFile)
  {
    return false;
  }
  
  void initTbsCoreInstalledVer(Context paramContext)
  {
    if (mCoreVersion != 0) {
      return;
    }
    mCoreVersion = getTbsCoreInstalledVerInNolock(paramContext);
  }
  
  public boolean installDecoupleCoreFromBackup(Context paramContext)
  {
    for (;;)
    {
      int i;
      try
      {
        Object localObject = new File(FileUtil.getTBSSdcardFilePath(paramContext, 4), TbsDownloader.getBackupFileName(true));
        File localFile1 = getInstance().getCoreDir(paramContext, 2);
        FileUtil.ensureDirectory(localFile1);
        FileUtil.delete(localFile1, true);
        FileUtil.copyTbsFilesIfNeeded((File)localObject, localFile1);
        localObject = localFile1.list();
        i = 0;
        if (i < localObject.length)
        {
          File localFile2 = new File(localFile1, localObject[i]);
          if (localFile2.getName().endsWith(".dex")) {
            localFile2.delete();
          }
        }
        else
        {
          installForDecoupleCore(paramContext, 2);
          return true;
        }
      }
      catch (Exception paramContext)
      {
        return false;
      }
      i += 1;
    }
  }
  
  boolean installLocalTbsCore(Context paramContext, int paramInt)
  {
    if (TbsDownloader.getOverSea(paramContext)) {
      return false;
    }
    TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore targetTbsCoreVer=" + paramInt);
    TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + paramContext.getApplicationInfo().processName);
    TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore currentProcessId=" + android.os.Process.myPid());
    TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore currentThreadName=" + Thread.currentThread().getName());
    Context localContext = getTbsCoreHostContext(paramContext, paramInt);
    if (localContext != null)
    {
      Message localMessage = new Message();
      localMessage.what = 2;
      localMessage.obj = new Object[] { localContext, paramContext, Integer.valueOf(paramInt) };
      mTbsInstallerHandler.sendMessage(localMessage);
      return true;
    }
    TbsLog.i("TbsInstaller", "TbsInstaller--installLocalTbsCore copy from null");
    return false;
  }
  
  /* Error */
  void installLocalTbsCoreExInThread(Context paramContext, Bundle paramBundle)
  {
    // Byte code:
    //   0: ldc 151
    //   2: new 479	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   9: ldc_w 1817
    //   12: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: invokestatic 1398	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   18: invokevirtual 1399	java/lang/Thread:getName	()Ljava/lang/String;
    //   21: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: new 377	java/lang/Throwable
    //   27: dup
    //   28: invokespecial 1818	java/lang/Throwable:<init>	()V
    //   31: invokestatic 853	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   34: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: aload_0
    //   44: aload_1
    //   45: invokevirtual 542	com/tencent/smtt/sdk/TbsInstaller:isTbsLocalInstalled	(Landroid/content/Context;)Z
    //   48: ifeq +14 -> 62
    //   51: aload_1
    //   52: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   55: sipush -539
    //   58: invokevirtual 539	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   61: return
    //   62: ldc 151
    //   64: ldc_w 1820
    //   67: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   70: aload_2
    //   71: ifnull -10 -> 61
    //   74: aload_1
    //   75: ifnull -14 -> 61
    //   78: aload_1
    //   79: invokestatic 636	com/tencent/smtt/utils/FileUtil:hasEnoughFreeSpace	(Landroid/content/Context;)Z
    //   82: ifne +70 -> 152
    //   85: invokestatic 642	com/tencent/smtt/utils/TbsUtils:getROMAvailableSize	()J
    //   88: lstore 8
    //   90: aload_1
    //   91: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   94: invokevirtual 645	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMinFreeSpace	()J
    //   97: lstore 6
    //   99: aload_1
    //   100: invokestatic 650	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   103: sipush 210
    //   106: new 479	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   113: ldc_w 1822
    //   116: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: lload 8
    //   121: invokevirtual 655	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   124: ldc_w 657
    //   127: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: lload 6
    //   132: invokevirtual 655	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   135: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokevirtual 661	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   141: aload_1
    //   142: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   145: sipush -540
    //   148: invokevirtual 539	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   151: return
    //   152: aload_0
    //   153: aload_1
    //   154: invokevirtual 573	com/tencent/smtt/sdk/TbsInstaller:getTbsInstallingFileLock	(Landroid/content/Context;)Z
    //   157: ifne +14 -> 171
    //   160: aload_1
    //   161: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   164: sipush -541
    //   167: invokevirtual 539	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   170: return
    //   171: getstatic 281	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   174: invokeinterface 578 1 0
    //   179: istore 10
    //   181: ldc 151
    //   183: new 479	java/lang/StringBuilder
    //   186: dup
    //   187: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   190: ldc_w 1824
    //   193: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: iload 10
    //   198: invokevirtual 583	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   201: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   204: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   207: iload 10
    //   209: ifeq +1499 -> 1708
    //   212: aload_1
    //   213: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   216: getfield 1002	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   219: ldc_w 1495
    //   222: iconst_0
    //   223: invokeinterface 566 3 0
    //   228: istore 5
    //   230: iconst_1
    //   231: invokestatic 1557	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   234: iload 5
    //   236: iconst_5
    //   237: if_icmpne +263 -> 500
    //   240: aload_0
    //   241: aload_1
    //   242: aload_2
    //   243: invokespecial 1826	com/tencent/smtt/sdk/TbsInstaller:doTpatch	(Landroid/content/Context;Landroid/os/Bundle;)I
    //   246: istore_3
    //   247: iload_3
    //   248: iconst_1
    //   249: if_icmpne +29 -> 278
    //   252: aload_1
    //   253: invokestatic 432	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   256: ldc_w 1216
    //   259: invokevirtual 592	com/tencent/smtt/sdk/TbsCoreVerManager:getIntNum	(Ljava/lang/String;)I
    //   262: istore 4
    //   264: aload_1
    //   265: invokestatic 432	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   268: ldc_w 1216
    //   271: iload 4
    //   273: iconst_1
    //   274: iadd
    //   275: invokevirtual 684	com/tencent/smtt/sdk/TbsCoreVerManager:setStatus	(Ljava/lang/String;I)V
    //   278: getstatic 281	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   281: invokeinterface 610 1 0
    //   286: aload_0
    //   287: invokevirtual 613	com/tencent/smtt/sdk/TbsInstaller:releaseTbsInstallingFileLock	()V
    //   290: iload 5
    //   292: iconst_5
    //   293: if_icmpne +10 -> 303
    //   296: aload_0
    //   297: aload_1
    //   298: iload_3
    //   299: invokespecial 1828	com/tencent/smtt/sdk/TbsInstaller:proceedTpatchStatus	(Landroid/content/Context;I)V
    //   302: return
    //   303: iload_3
    //   304: ifne +62 -> 366
    //   307: ldc 151
    //   309: ldc_w 1830
    //   312: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   315: aload_1
    //   316: invokestatic 432	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   319: ldc_w 1273
    //   322: iconst_0
    //   323: invokevirtual 684	com/tencent/smtt/sdk/TbsCoreVerManager:setStatus	(Ljava/lang/String;I)V
    //   326: aload_1
    //   327: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   330: sipush -544
    //   333: invokevirtual 539	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   336: aload_1
    //   337: invokestatic 432	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   340: iconst_0
    //   341: iconst_m1
    //   342: invokevirtual 436	com/tencent/smtt/sdk/TbsCoreVerManager:setTbsCoreInstallStatus	(II)V
    //   345: aload_1
    //   346: invokestatic 432	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   349: iconst_1
    //   350: invokevirtual 440	com/tencent/smtt/sdk/TbsCoreVerManager:setTbsCoreIncrUpdateStatus	(I)V
    //   353: new 1297	java/lang/NullPointerException
    //   356: dup
    //   357: invokespecial 1298	java/lang/NullPointerException:<init>	()V
    //   360: athrow
    //   361: iconst_0
    //   362: invokestatic 1557	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   365: return
    //   366: iload_3
    //   367: iconst_2
    //   368: if_icmpne +14 -> 382
    //   371: ldc 151
    //   373: ldc_w 1832
    //   376: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   379: goto -18 -> 361
    //   382: aload_1
    //   383: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   386: sipush -546
    //   389: invokevirtual 539	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   392: ldc 151
    //   394: ldc_w 1834
    //   397: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   400: aload_1
    //   401: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   404: getfield 1474	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   407: ldc_w 1476
    //   410: iconst_1
    //   411: invokestatic 1481	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   414: invokeinterface 1487 3 0
    //   419: pop
    //   420: aload_1
    //   421: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   424: invokevirtual 1491	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   427: aload_1
    //   428: invokestatic 671	com/tencent/smtt/sdk/TbsDownloader:isDecoupleCore	(Landroid/content/Context;)Z
    //   431: ifeq +36 -> 467
    //   434: aload_1
    //   435: invokestatic 650	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   438: sipush 235
    //   441: new 479	java/lang/StringBuilder
    //   444: dup
    //   445: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   448: ldc_w 1836
    //   451: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   454: iload_3
    //   455: invokevirtual 547	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   458: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   461: invokevirtual 661	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   464: goto -103 -> 361
    //   467: aload_1
    //   468: invokestatic 650	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   471: sipush 217
    //   474: new 479	java/lang/StringBuilder
    //   477: dup
    //   478: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   481: ldc_w 1838
    //   484: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   487: iload_3
    //   488: invokevirtual 547	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   491: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   494: invokevirtual 661	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   497: goto -136 -> 361
    //   500: aload_0
    //   501: aload_1
    //   502: invokevirtual 617	com/tencent/smtt/sdk/TbsInstaller:getTbsCoreInstalledVerInNolock	(Landroid/content/Context;)I
    //   505: ifle +14 -> 519
    //   508: aload_1
    //   509: invokestatic 432	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   512: invokevirtual 1304	com/tencent/smtt/sdk/TbsCoreVerManager:getTbsCoreIncrUpdateStatus	()I
    //   515: iconst_1
    //   516: if_icmpne +45 -> 561
    //   519: iconst_0
    //   520: invokestatic 1557	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   523: getstatic 281	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   526: invokeinterface 610 1 0
    //   531: aload_0
    //   532: invokevirtual 613	com/tencent/smtt/sdk/TbsInstaller:releaseTbsInstallingFileLock	()V
    //   535: iload 5
    //   537: iconst_5
    //   538: if_icmpne +10 -> 548
    //   541: aload_0
    //   542: aload_1
    //   543: iconst_2
    //   544: invokespecial 1828	com/tencent/smtt/sdk/TbsInstaller:proceedTpatchStatus	(Landroid/content/Context;I)V
    //   547: return
    //   548: ldc 151
    //   550: ldc_w 1832
    //   553: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   556: iconst_0
    //   557: invokestatic 1557	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   560: return
    //   561: iload 5
    //   563: iconst_1
    //   564: if_icmpeq +15 -> 579
    //   567: iload 5
    //   569: iconst_2
    //   570: if_icmpeq +9 -> 579
    //   573: iload 5
    //   575: iconst_4
    //   576: if_icmpne +184 -> 760
    //   579: iconst_1
    //   580: istore_3
    //   581: iload_3
    //   582: ifne +1202 -> 1784
    //   585: iload 5
    //   587: ifeq +1197 -> 1784
    //   590: aload_1
    //   591: invokestatic 432	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   594: ldc_w 1273
    //   597: invokevirtual 592	com/tencent/smtt/sdk/TbsCoreVerManager:getIntNum	(Ljava/lang/String;)I
    //   600: istore_3
    //   601: iload_3
    //   602: iconst_5
    //   603: if_icmple +175 -> 778
    //   606: ldc 151
    //   608: ldc_w 1840
    //   611: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   614: aload_2
    //   615: ldc 78
    //   617: invokevirtual 1033	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   620: astore 11
    //   622: aload_2
    //   623: ldc 72
    //   625: invokevirtual 1033	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   628: astore 12
    //   630: aload_2
    //   631: ldc 69
    //   633: invokevirtual 1033	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   636: astore_2
    //   637: aload 11
    //   639: invokestatic 910	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   642: ifne +15 -> 657
    //   645: new 460	java/io/File
    //   648: dup
    //   649: aload 11
    //   651: invokespecial 1034	java/io/File:<init>	(Ljava/lang/String;)V
    //   654: invokestatic 1058	com/tencent/smtt/utils/FileUtil:delete	(Ljava/io/File;)V
    //   657: aload 12
    //   659: invokestatic 910	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   662: ifne +15 -> 677
    //   665: new 460	java/io/File
    //   668: dup
    //   669: aload 12
    //   671: invokespecial 1034	java/io/File:<init>	(Ljava/lang/String;)V
    //   674: invokestatic 1058	com/tencent/smtt/utils/FileUtil:delete	(Ljava/io/File;)V
    //   677: aload_2
    //   678: invokestatic 910	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   681: ifne +14 -> 695
    //   684: new 460	java/io/File
    //   687: dup
    //   688: aload_2
    //   689: invokespecial 1034	java/io/File:<init>	(Ljava/lang/String;)V
    //   692: invokestatic 1058	com/tencent/smtt/utils/FileUtil:delete	(Ljava/io/File;)V
    //   695: aload_1
    //   696: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   699: getfield 1474	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   702: ldc_w 1476
    //   705: iconst_1
    //   706: invokestatic 1481	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   709: invokeinterface 1487 3 0
    //   714: pop
    //   715: aload_1
    //   716: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   719: invokevirtual 1491	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   722: aload_1
    //   723: invokestatic 650	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   726: sipush 224
    //   729: ldc_w 1842
    //   732: invokevirtual 661	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   735: getstatic 281	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   738: invokeinterface 610 1 0
    //   743: aload_0
    //   744: invokevirtual 613	com/tencent/smtt/sdk/TbsInstaller:releaseTbsInstallingFileLock	()V
    //   747: iload 5
    //   749: iconst_5
    //   750: if_icmpne +15 -> 765
    //   753: aload_0
    //   754: aload_1
    //   755: iconst_2
    //   756: invokespecial 1828	com/tencent/smtt/sdk/TbsInstaller:proceedTpatchStatus	(Landroid/content/Context;I)V
    //   759: return
    //   760: iconst_0
    //   761: istore_3
    //   762: goto -181 -> 581
    //   765: ldc 151
    //   767: ldc_w 1832
    //   770: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   773: iconst_0
    //   774: invokestatic 1557	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   777: return
    //   778: aload_1
    //   779: invokestatic 432	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   782: ldc_w 1273
    //   785: iload_3
    //   786: iconst_1
    //   787: iadd
    //   788: invokevirtual 684	com/tencent/smtt/sdk/TbsCoreVerManager:setStatus	(Ljava/lang/String;I)V
    //   791: aload_1
    //   792: invokestatic 1608	com/tencent/smtt/sdk/TbsInstaller:getTbsCorePrivateDir	(Landroid/content/Context;)Ljava/io/File;
    //   795: astore 11
    //   797: aload 11
    //   799: ifnull +985 -> 1784
    //   802: new 460	java/io/File
    //   805: dup
    //   806: aload 11
    //   808: ldc_w 1610
    //   811: invokespecial 469	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   814: astore 11
    //   816: aload 11
    //   818: ifnull +966 -> 1784
    //   821: aload 11
    //   823: invokevirtual 473	java/io/File:exists	()Z
    //   826: ifeq +958 -> 1784
    //   829: aload_1
    //   830: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   833: sipush -550
    //   836: invokevirtual 539	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   839: aload_1
    //   840: aload_2
    //   841: invokestatic 1024	com/tencent/smtt/sdk/QbSdk:incrUpdate	(Landroid/content/Context;Landroid/os/Bundle;)Landroid/os/Bundle;
    //   844: astore 11
    //   846: aload 11
    //   848: ifnonnull +71 -> 919
    //   851: aload_1
    //   852: invokestatic 650	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   855: sipush 228
    //   858: new 479	java/lang/StringBuilder
    //   861: dup
    //   862: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   865: ldc_w 1844
    //   868: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   871: aload_2
    //   872: ldc 75
    //   874: invokevirtual 1030	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   877: invokevirtual 547	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   880: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   883: invokevirtual 661	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   886: iconst_1
    //   887: istore 4
    //   889: aload 11
    //   891: astore 12
    //   893: getstatic 281	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   896: invokeinterface 610 1 0
    //   901: aload_0
    //   902: invokevirtual 613	com/tencent/smtt/sdk/TbsInstaller:releaseTbsInstallingFileLock	()V
    //   905: iload 5
    //   907: iconst_5
    //   908: if_icmpne +167 -> 1075
    //   911: aload_0
    //   912: aload_1
    //   913: iload 4
    //   915: invokespecial 1828	com/tencent/smtt/sdk/TbsInstaller:proceedTpatchStatus	(Landroid/content/Context;I)V
    //   918: return
    //   919: aload 11
    //   921: ldc 90
    //   923: invokevirtual 1030	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   926: istore_3
    //   927: iload_3
    //   928: istore 4
    //   930: aload 11
    //   932: astore 12
    //   934: iload_3
    //   935: ifeq -42 -> 893
    //   938: aload_1
    //   939: invokestatic 650	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   942: sipush 228
    //   945: new 479	java/lang/StringBuilder
    //   948: dup
    //   949: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   952: ldc_w 1846
    //   955: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   958: iload_3
    //   959: invokevirtual 547	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   962: ldc_w 1848
    //   965: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   968: aload_2
    //   969: ldc 75
    //   971: invokevirtual 1030	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   974: invokevirtual 547	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   977: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   980: invokevirtual 661	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   983: iload_3
    //   984: istore 4
    //   986: aload 11
    //   988: astore 12
    //   990: goto -97 -> 893
    //   993: astore_2
    //   994: ldc 151
    //   996: new 479	java/lang/StringBuilder
    //   999: dup
    //   1000: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   1003: ldc_w 1850
    //   1006: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1009: aload_2
    //   1010: invokestatic 853	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1013: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1016: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1019: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1022: aload_2
    //   1023: invokevirtual 764	java/lang/Exception:printStackTrace	()V
    //   1026: aload_1
    //   1027: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1030: sipush -543
    //   1033: invokevirtual 539	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1036: aload_1
    //   1037: invokestatic 650	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1040: sipush 218
    //   1043: aload_2
    //   1044: invokevirtual 765	java/lang/Exception:toString	()Ljava/lang/String;
    //   1047: invokevirtual 661	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1050: getstatic 281	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   1053: invokeinterface 610 1 0
    //   1058: aload_0
    //   1059: invokevirtual 613	com/tencent/smtt/sdk/TbsInstaller:releaseTbsInstallingFileLock	()V
    //   1062: iload 5
    //   1064: iconst_5
    //   1065: if_icmpne +251 -> 1316
    //   1068: aload_0
    //   1069: aload_1
    //   1070: iconst_1
    //   1071: invokespecial 1828	com/tencent/smtt/sdk/TbsInstaller:proceedTpatchStatus	(Landroid/content/Context;I)V
    //   1074: return
    //   1075: iload 4
    //   1077: ifne +102 -> 1179
    //   1080: ldc 151
    //   1082: ldc_w 1830
    //   1085: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1088: aload_1
    //   1089: invokestatic 432	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   1092: ldc_w 1273
    //   1095: iconst_0
    //   1096: invokevirtual 684	com/tencent/smtt/sdk/TbsCoreVerManager:setStatus	(Ljava/lang/String;I)V
    //   1099: aload_1
    //   1100: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1103: sipush -544
    //   1106: invokevirtual 539	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1109: aload_1
    //   1110: invokestatic 432	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   1113: iconst_0
    //   1114: iconst_m1
    //   1115: invokevirtual 436	com/tencent/smtt/sdk/TbsCoreVerManager:setTbsCoreInstallStatus	(II)V
    //   1118: aload_1
    //   1119: invokestatic 432	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   1122: iconst_1
    //   1123: invokevirtual 440	com/tencent/smtt/sdk/TbsCoreVerManager:setTbsCoreIncrUpdateStatus	(I)V
    //   1126: aload 12
    //   1128: ldc 87
    //   1130: invokevirtual 1033	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1133: astore_2
    //   1134: new 460	java/io/File
    //   1137: dup
    //   1138: aload_2
    //   1139: invokespecial 1034	java/io/File:<init>	(Ljava/lang/String;)V
    //   1142: aload_1
    //   1143: invokestatic 813	com/tencent/smtt/sdk/TbsApkDownloader:backupTbsApk	(Ljava/io/File;Landroid/content/Context;)V
    //   1146: aload_0
    //   1147: aload_1
    //   1148: aload_2
    //   1149: aload 12
    //   1151: ldc 93
    //   1153: invokevirtual 1030	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   1156: invokespecial 405	com/tencent/smtt/sdk/TbsInstaller:installTbsCoreInThread	(Landroid/content/Context;Ljava/lang/String;I)V
    //   1159: aload_1
    //   1160: invokestatic 671	com/tencent/smtt/sdk/TbsDownloader:isDecoupleCore	(Landroid/content/Context;)Z
    //   1163: ifeq +11 -> 1174
    //   1166: aload_1
    //   1167: invokestatic 432	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   1170: iconst_m1
    //   1171: invokevirtual 440	com/tencent/smtt/sdk/TbsCoreVerManager:setTbsCoreIncrUpdateStatus	(I)V
    //   1174: iconst_0
    //   1175: invokestatic 1557	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   1178: return
    //   1179: iload 4
    //   1181: iconst_2
    //   1182: if_icmpne +14 -> 1196
    //   1185: ldc 151
    //   1187: ldc_w 1832
    //   1190: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1193: goto -19 -> 1174
    //   1196: aload_1
    //   1197: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1200: sipush -546
    //   1203: invokevirtual 539	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1206: ldc 151
    //   1208: ldc_w 1834
    //   1211: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1214: aload_1
    //   1215: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1218: getfield 1474	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1221: ldc_w 1476
    //   1224: iconst_1
    //   1225: invokestatic 1481	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1228: invokeinterface 1487 3 0
    //   1233: pop
    //   1234: aload_1
    //   1235: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1238: invokevirtual 1491	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1241: aload_1
    //   1242: invokestatic 671	com/tencent/smtt/sdk/TbsDownloader:isDecoupleCore	(Landroid/content/Context;)Z
    //   1245: ifeq +37 -> 1282
    //   1248: aload_1
    //   1249: invokestatic 650	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1252: sipush 235
    //   1255: new 479	java/lang/StringBuilder
    //   1258: dup
    //   1259: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   1262: ldc_w 1836
    //   1265: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1268: iload 4
    //   1270: invokevirtual 547	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1273: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1276: invokevirtual 661	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1279: goto -105 -> 1174
    //   1282: aload_1
    //   1283: invokestatic 650	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1286: sipush 217
    //   1289: new 479	java/lang/StringBuilder
    //   1292: dup
    //   1293: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   1296: ldc_w 1838
    //   1299: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1302: iload 4
    //   1304: invokevirtual 547	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1307: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1310: invokevirtual 661	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1313: goto -139 -> 1174
    //   1316: aload_1
    //   1317: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1320: sipush -546
    //   1323: invokevirtual 539	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1326: ldc 151
    //   1328: ldc_w 1834
    //   1331: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1334: aload_1
    //   1335: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1338: getfield 1474	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1341: ldc_w 1476
    //   1344: iconst_1
    //   1345: invokestatic 1481	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1348: invokeinterface 1487 3 0
    //   1353: pop
    //   1354: aload_1
    //   1355: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1358: invokevirtual 1491	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1361: aload_1
    //   1362: invokestatic 671	com/tencent/smtt/sdk/TbsDownloader:isDecoupleCore	(Landroid/content/Context;)Z
    //   1365: ifeq +38 -> 1403
    //   1368: aload_1
    //   1369: invokestatic 650	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1372: sipush 235
    //   1375: new 479	java/lang/StringBuilder
    //   1378: dup
    //   1379: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   1382: ldc_w 1836
    //   1385: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1388: iconst_1
    //   1389: invokevirtual 547	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1392: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1395: invokevirtual 661	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1398: iconst_0
    //   1399: invokestatic 1557	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   1402: return
    //   1403: aload_1
    //   1404: invokestatic 650	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1407: sipush 217
    //   1410: new 479	java/lang/StringBuilder
    //   1413: dup
    //   1414: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   1417: ldc_w 1838
    //   1420: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1423: iconst_1
    //   1424: invokevirtual 547	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1427: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1430: invokevirtual 661	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1433: goto -35 -> 1398
    //   1436: astore_2
    //   1437: aconst_null
    //   1438: astore 11
    //   1440: iconst_2
    //   1441: istore_3
    //   1442: getstatic 281	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   1445: invokeinterface 610 1 0
    //   1450: aload_0
    //   1451: invokevirtual 613	com/tencent/smtt/sdk/TbsInstaller:releaseTbsInstallingFileLock	()V
    //   1454: iload 5
    //   1456: iconst_5
    //   1457: if_icmpne +10 -> 1467
    //   1460: aload_0
    //   1461: aload_1
    //   1462: iload_3
    //   1463: invokespecial 1828	com/tencent/smtt/sdk/TbsInstaller:proceedTpatchStatus	(Landroid/content/Context;I)V
    //   1466: return
    //   1467: iload_3
    //   1468: ifne +106 -> 1574
    //   1471: ldc 151
    //   1473: ldc_w 1830
    //   1476: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1479: aload_1
    //   1480: invokestatic 432	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   1483: ldc_w 1273
    //   1486: iconst_0
    //   1487: invokevirtual 684	com/tencent/smtt/sdk/TbsCoreVerManager:setStatus	(Ljava/lang/String;I)V
    //   1490: aload_1
    //   1491: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1494: sipush -544
    //   1497: invokevirtual 539	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1500: aload_1
    //   1501: invokestatic 432	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   1504: iconst_0
    //   1505: iconst_m1
    //   1506: invokevirtual 436	com/tencent/smtt/sdk/TbsCoreVerManager:setTbsCoreInstallStatus	(II)V
    //   1509: aload_1
    //   1510: invokestatic 432	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   1513: iconst_1
    //   1514: invokevirtual 440	com/tencent/smtt/sdk/TbsCoreVerManager:setTbsCoreIncrUpdateStatus	(I)V
    //   1517: aload 11
    //   1519: ldc 87
    //   1521: invokevirtual 1033	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1524: astore 12
    //   1526: new 460	java/io/File
    //   1529: dup
    //   1530: aload 12
    //   1532: invokespecial 1034	java/io/File:<init>	(Ljava/lang/String;)V
    //   1535: aload_1
    //   1536: invokestatic 813	com/tencent/smtt/sdk/TbsApkDownloader:backupTbsApk	(Ljava/io/File;Landroid/content/Context;)V
    //   1539: aload_0
    //   1540: aload_1
    //   1541: aload 12
    //   1543: aload 11
    //   1545: ldc 93
    //   1547: invokevirtual 1030	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   1550: invokespecial 405	com/tencent/smtt/sdk/TbsInstaller:installTbsCoreInThread	(Landroid/content/Context;Ljava/lang/String;I)V
    //   1553: aload_1
    //   1554: invokestatic 671	com/tencent/smtt/sdk/TbsDownloader:isDecoupleCore	(Landroid/content/Context;)Z
    //   1557: ifeq +11 -> 1568
    //   1560: aload_1
    //   1561: invokestatic 432	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   1564: iconst_m1
    //   1565: invokevirtual 440	com/tencent/smtt/sdk/TbsCoreVerManager:setTbsCoreIncrUpdateStatus	(I)V
    //   1568: iconst_0
    //   1569: invokestatic 1557	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   1572: aload_2
    //   1573: athrow
    //   1574: iload_3
    //   1575: iconst_2
    //   1576: if_icmpne +14 -> 1590
    //   1579: ldc 151
    //   1581: ldc_w 1832
    //   1584: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1587: goto -19 -> 1568
    //   1590: aload_1
    //   1591: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1594: sipush -546
    //   1597: invokevirtual 539	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1600: ldc 151
    //   1602: ldc_w 1834
    //   1605: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1608: aload_1
    //   1609: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1612: getfield 1474	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1615: ldc_w 1476
    //   1618: iconst_1
    //   1619: invokestatic 1481	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1622: invokeinterface 1487 3 0
    //   1627: pop
    //   1628: aload_1
    //   1629: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1632: invokevirtual 1491	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1635: aload_1
    //   1636: invokestatic 671	com/tencent/smtt/sdk/TbsDownloader:isDecoupleCore	(Landroid/content/Context;)Z
    //   1639: ifeq +36 -> 1675
    //   1642: aload_1
    //   1643: invokestatic 650	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1646: sipush 235
    //   1649: new 479	java/lang/StringBuilder
    //   1652: dup
    //   1653: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   1656: ldc_w 1836
    //   1659: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1662: iload_3
    //   1663: invokevirtual 547	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1666: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1669: invokevirtual 661	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1672: goto -104 -> 1568
    //   1675: aload_1
    //   1676: invokestatic 650	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1679: sipush 217
    //   1682: new 479	java/lang/StringBuilder
    //   1685: dup
    //   1686: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   1689: ldc_w 1838
    //   1692: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1695: iload_3
    //   1696: invokevirtual 547	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1699: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1702: invokevirtual 661	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1705: goto -137 -> 1568
    //   1708: aload_1
    //   1709: invokestatic 536	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1712: sipush -547
    //   1715: invokevirtual 539	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1718: aload_0
    //   1719: invokevirtual 613	com/tencent/smtt/sdk/TbsInstaller:releaseTbsInstallingFileLock	()V
    //   1722: return
    //   1723: astore_2
    //   1724: aconst_null
    //   1725: astore 11
    //   1727: goto -285 -> 1442
    //   1730: astore_2
    //   1731: iconst_1
    //   1732: istore_3
    //   1733: goto -291 -> 1442
    //   1736: astore_2
    //   1737: iconst_2
    //   1738: istore_3
    //   1739: goto -297 -> 1442
    //   1742: astore_2
    //   1743: goto -301 -> 1442
    //   1746: astore_2
    //   1747: goto -305 -> 1442
    //   1750: astore_2
    //   1751: iconst_1
    //   1752: istore_3
    //   1753: goto -311 -> 1442
    //   1756: astore_2
    //   1757: aconst_null
    //   1758: astore 11
    //   1760: iconst_2
    //   1761: istore_3
    //   1762: goto -768 -> 994
    //   1765: astore_2
    //   1766: aconst_null
    //   1767: astore 11
    //   1769: goto -775 -> 994
    //   1772: astore_2
    //   1773: iconst_1
    //   1774: istore_3
    //   1775: goto -781 -> 994
    //   1778: astore_2
    //   1779: iconst_2
    //   1780: istore_3
    //   1781: goto -787 -> 994
    //   1784: aconst_null
    //   1785: astore 12
    //   1787: iconst_2
    //   1788: istore 4
    //   1790: goto -897 -> 893
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1793	0	this	TbsInstaller
    //   0	1793	1	paramContext	Context
    //   0	1793	2	paramBundle	Bundle
    //   246	1535	3	i	int
    //   262	1527	4	j	int
    //   228	1230	5	k	int
    //   97	34	6	l1	long
    //   88	32	8	l2	long
    //   179	29	10	bool	boolean
    //   620	1148	11	localObject1	Object
    //   628	1158	12	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   938	983	993	java/lang/Exception
    //   230	234	1436	finally
    //   240	247	1436	finally
    //   500	519	1436	finally
    //   519	523	1436	finally
    //   590	601	1436	finally
    //   606	657	1436	finally
    //   657	677	1436	finally
    //   677	695	1436	finally
    //   695	735	1436	finally
    //   778	797	1436	finally
    //   802	816	1436	finally
    //   821	846	1436	finally
    //   252	278	1723	finally
    //   851	886	1730	finally
    //   919	927	1736	finally
    //   938	983	1742	finally
    //   994	1026	1746	finally
    //   1026	1050	1750	finally
    //   230	234	1756	java/lang/Exception
    //   240	247	1756	java/lang/Exception
    //   500	519	1756	java/lang/Exception
    //   519	523	1756	java/lang/Exception
    //   590	601	1756	java/lang/Exception
    //   606	657	1756	java/lang/Exception
    //   657	677	1756	java/lang/Exception
    //   677	695	1756	java/lang/Exception
    //   695	735	1756	java/lang/Exception
    //   778	797	1756	java/lang/Exception
    //   802	816	1756	java/lang/Exception
    //   821	846	1756	java/lang/Exception
    //   252	278	1765	java/lang/Exception
    //   851	886	1772	java/lang/Exception
    //   919	927	1778	java/lang/Exception
  }
  
  void installLocalTesCoreEx(Context paramContext, Bundle paramBundle)
  {
    if ((paramBundle == null) || (paramContext == null)) {
      return;
    }
    Message localMessage = new Message();
    localMessage.what = 3;
    localMessage.obj = new Object[] { paramContext, paramBundle };
    mTbsInstallerHandler.sendMessage(localMessage);
  }
  
  void installTbsCore(Context paramContext, String paramString, int paramInt)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore tbsApkPath=" + paramString);
    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore tbsCoreTargetVer=" + paramInt);
    TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + paramContext.getApplicationInfo().processName);
    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore currentProcessId=" + android.os.Process.myPid());
    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore currentThreadName=" + Thread.currentThread().getName());
    Message localMessage = new Message();
    localMessage.what = 1;
    localMessage.obj = new Object[] { paramContext, paramString, Integer.valueOf(paramInt) };
    mTbsInstallerHandler.sendMessage(localMessage);
  }
  
  void installTbsCoreForThirdPartyApp(Context paramContext, int paramInt)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreForThirdPartyApp");
    if (paramInt <= 0) {}
    int i;
    do
    {
      do
      {
        return;
        i = getTbsCoreInstalledVerInNolock(paramContext);
      } while (i == paramInt);
      Context localContext = TbsShareManager.getAvailableTbsCoreHostContext(paramContext);
      if ((localContext != null) || (TbsShareManager.getHostCorePathAppDefined() != null))
      {
        TbsLog.i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp hostContext != null");
        quickDexOptForThirdPartyApp(paramContext, localContext);
        return;
      }
    } while (i > 0);
    TbsLog.i("TbsInstaller", "TbsInstaller--installTbsCoreForThirdPartyApp hostContext == null");
    QbSdk.forceSysWebViewInner(paramContext, "TbsInstaller::installTbsCoreForThirdPartyApp forceSysWebViewInner #2");
  }
  
  void installTbsCoreIfNeeded(Context paramContext, boolean paramBoolean)
  {
    if (QbSdk.mIsSysWebViewForcedByOuter) {
      return;
    }
    if (Build.VERSION.SDK_INT < 8)
    {
      TbsLog.e("TbsInstaller", "android version < 2.1 no need install X5 core", true);
      return;
    }
    TbsLog.i("TbsInstaller", "Tbsinstaller installTbsCoreIfNeeded #1 ");
    File localFile;
    if ((TbsShareManager.isThirdPartyApp(paramContext)) && (TbsCoreVerManager.getInstance(paramContext).getIntStatus("remove_old_core") == 1) && (paramBoolean)) {
      localFile = getInstance().getTbsCoreShareDir(paramContext);
    }
    label196:
    label215:
    do
    {
      do
      {
        do
        {
          try
          {
            FileUtil.delete(localFile);
            TbsLog.i("TbsInstaller", "thirdAPP success--> delete old core_share Directory");
            TbsCoreVerManager.getInstance(paramContext).setStatus("remove_old_core", 0);
            if (!getTmpFolderCoreToRead(paramContext)) {
              break;
            }
            TbsLog.i("TbsInstaller", "Tbsinstaller installTbsCoreIfNeeded #2 ");
            if (!isPrepareTbsCore(paramContext, "core_unzip_tmp"))
            {
              if (isPrepareTbsCore(paramContext, "core_share_backup_tmp")) {
                continue;
              }
              if (isPrepareTbsCore(paramContext, "core_copy_tmp")) {
                break label196;
              }
              if (isPrepareTbsCore(paramContext, "tpatch_tmp")) {
                break label215;
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
            } while (!enableTbsCoreFromUnzip(paramContext, paramBoolean));
            TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromUnzip!!", true);
            return;
          }
        } while (!enableTbsCoreFromBackup(paramContext, paramBoolean));
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromBackup!!", true);
        return;
      } while (!enableTbsCoreFromCopy(paramContext, paramBoolean));
      TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromCopy!!", true);
      return;
    } while (!enableTbsCoreFromTpatch(paramContext, paramBoolean));
    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromTpatch!!", true);
  }
  
  boolean isTbsCoreLegal(Context paramContext, int paramInt)
  {
    for (;;)
    {
      boolean bool;
      int i;
      try
      {
        bool = TbsShareManager.isThirdPartyApp(paramContext);
        if (bool)
        {
          if (TbsShareManager.isShareTbsCoreAvailable(paramContext))
          {
            localFile = new File(TbsShareManager.getAvailableTbsCorePath(paramContext));
            if (!localFile.getAbsolutePath().contains("com.tencent.tbs")) {
              break label284;
            }
            return true;
          }
          TbsLog.e("TbsInstaller", "321");
          return false;
        }
        File localFile = getTbsCoreShareDir(paramContext);
        if (localFile == null) {
          break label274;
        }
        Long[][] arrayOfLong1 = WEBCORE_LIB_LENGTH_MAP;
        int j = arrayOfLong1.length;
        i = 0;
        if (i >= j) {
          break label287;
        }
        Long[] arrayOfLong = arrayOfLong1[i];
        if (paramInt != arrayOfLong[0].intValue()) {
          break label289;
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
        FileUtil.delete(QbSdk.getTbsFolderDir(paramContext));
      }
      mTbsCoreInstalledVer.set(Integer.valueOf(0));
      TbsLog.e("TbsInstaller", "322");
      return false;
      label274:
      TbsLog.e("TbsInstaller", "323");
      return false;
      label284:
      continue;
      label287:
      return true;
      label289:
      i += 1;
    }
  }
  
  /* Error */
  boolean isTbsLocalInstalled(Context paramContext)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: new 460	java/io/File
    //   5: dup
    //   6: aload_0
    //   7: aload_1
    //   8: invokevirtual 688	com/tencent/smtt/sdk/TbsInstaller:getTbsCoreShareDir	(Landroid/content/Context;)Ljava/io/File;
    //   11: ldc 154
    //   13: invokespecial 469	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   16: astore 5
    //   18: aload 5
    //   20: ifnull +11 -> 31
    //   23: aload 5
    //   25: invokevirtual 473	java/io/File:exists	()Z
    //   28: ifne +9 -> 37
    //   31: iconst_0
    //   32: istore 4
    //   34: iload 4
    //   36: ireturn
    //   37: new 726	java/util/Properties
    //   40: dup
    //   41: invokespecial 727	java/util/Properties:<init>	()V
    //   44: astore 6
    //   46: new 729	java/io/BufferedInputStream
    //   49: dup
    //   50: new 731	java/io/FileInputStream
    //   53: dup
    //   54: aload 5
    //   56: invokespecial 732	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   59: invokespecial 735	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   62: astore_1
    //   63: aload 6
    //   65: aload_1
    //   66: invokevirtual 738	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   69: aload 6
    //   71: ldc 173
    //   73: ldc_w 1621
    //   76: invokevirtual 777	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   79: invokestatic 1947	java/lang/Boolean:valueOf	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   82: invokevirtual 1504	java/lang/Boolean:booleanValue	()Z
    //   85: istore 4
    //   87: iload 4
    //   89: ifeq +175 -> 264
    //   92: invokestatic 705	java/lang/System:currentTimeMillis	()J
    //   95: aload 5
    //   97: invokevirtual 1950	java/io/File:lastModified	()J
    //   100: lsub
    //   101: ldc2_w 176
    //   104: lcmp
    //   105: ifle +70 -> 175
    //   108: iconst_1
    //   109: istore_3
    //   110: ldc 151
    //   112: new 479	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 480	java/lang/StringBuilder:<init>	()V
    //   119: ldc_w 1952
    //   122: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: iload 4
    //   127: invokevirtual 583	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   130: ldc_w 1954
    //   133: invokevirtual 486	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: iload_3
    //   137: invokevirtual 583	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   140: invokevirtual 490	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   146: iload_3
    //   147: ifne +33 -> 180
    //   150: iload 4
    //   152: iload_2
    //   153: iand
    //   154: istore_3
    //   155: iload_3
    //   156: istore 4
    //   158: aload_1
    //   159: ifnull -125 -> 34
    //   162: aload_1
    //   163: invokevirtual 739	java/io/BufferedInputStream:close	()V
    //   166: iload_3
    //   167: ireturn
    //   168: astore_1
    //   169: aload_1
    //   170: invokevirtual 519	java/io/IOException:printStackTrace	()V
    //   173: iload_3
    //   174: ireturn
    //   175: iconst_0
    //   176: istore_3
    //   177: goto -67 -> 110
    //   180: iconst_0
    //   181: istore_2
    //   182: goto -32 -> 150
    //   185: astore 5
    //   187: iconst_0
    //   188: istore_3
    //   189: aconst_null
    //   190: astore_1
    //   191: aload 5
    //   193: invokevirtual 1199	java/lang/Throwable:printStackTrace	()V
    //   196: iload_3
    //   197: istore 4
    //   199: aload_1
    //   200: ifnull -166 -> 34
    //   203: aload_1
    //   204: invokevirtual 739	java/io/BufferedInputStream:close	()V
    //   207: iload_3
    //   208: ireturn
    //   209: astore_1
    //   210: aload_1
    //   211: invokevirtual 519	java/io/IOException:printStackTrace	()V
    //   214: iload_3
    //   215: ireturn
    //   216: astore 5
    //   218: aconst_null
    //   219: astore_1
    //   220: aload_1
    //   221: ifnull +7 -> 228
    //   224: aload_1
    //   225: invokevirtual 739	java/io/BufferedInputStream:close	()V
    //   228: aload 5
    //   230: athrow
    //   231: astore_1
    //   232: aload_1
    //   233: invokevirtual 519	java/io/IOException:printStackTrace	()V
    //   236: goto -8 -> 228
    //   239: astore 5
    //   241: goto -21 -> 220
    //   244: astore 5
    //   246: goto -26 -> 220
    //   249: astore 5
    //   251: iconst_0
    //   252: istore_3
    //   253: goto -62 -> 191
    //   256: astore 5
    //   258: iload 4
    //   260: istore_3
    //   261: goto -70 -> 191
    //   264: iconst_0
    //   265: istore_3
    //   266: goto -156 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	269	0	this	TbsInstaller
    //   0	269	1	paramContext	Context
    //   1	181	2	bool1	boolean
    //   109	157	3	bool2	boolean
    //   32	227	4	bool3	boolean
    //   16	80	5	localFile	File
    //   185	7	5	localThrowable1	Throwable
    //   216	13	5	localObject1	Object
    //   239	1	5	localObject2	Object
    //   244	1	5	localObject3	Object
    //   249	1	5	localThrowable2	Throwable
    //   256	1	5	localThrowable3	Throwable
    //   44	26	6	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   162	166	168	java/io/IOException
    //   46	63	185	java/lang/Throwable
    //   203	207	209	java/io/IOException
    //   46	63	216	finally
    //   224	228	231	java/io/IOException
    //   63	87	239	finally
    //   92	108	239	finally
    //   110	146	239	finally
    //   191	196	244	finally
    //   63	87	249	java/lang/Throwable
    //   92	108	256	java/lang/Throwable
    //   110	146	256	java/lang/Throwable
  }
  
  /* Error */
  public boolean quickDexOptForThirdPartyApp(Context paramContext1, Context paramContext2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 151
    //   4: ldc_w 1956
    //   7: invokestatic 417	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   10: getstatic 337	com/tencent/smtt/sdk/TbsInstaller:isQuickDexOptForThirdPartyAppCalled	Z
    //   13: istore_3
    //   14: iload_3
    //   15: iconst_1
    //   16: if_icmpne +7 -> 23
    //   19: aload_0
    //   20: monitorexit
    //   21: iconst_1
    //   22: ireturn
    //   23: iconst_1
    //   24: putstatic 337	com/tencent/smtt/sdk/TbsInstaller:isQuickDexOptForThirdPartyAppCalled	Z
    //   27: new 1958	com/tencent/smtt/sdk/TbsInstaller$4
    //   30: dup
    //   31: aload_0
    //   32: aload_2
    //   33: aload_1
    //   34: invokespecial 1961	com/tencent/smtt/sdk/TbsInstaller$4:<init>	(Lcom/tencent/smtt/sdk/TbsInstaller;Landroid/content/Context;Landroid/content/Context;)V
    //   37: invokevirtual 1964	com/tencent/smtt/sdk/TbsInstaller$4:start	()V
    //   40: goto -21 -> 19
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	TbsInstaller
    //   0	48	1	paramContext1	Context
    //   0	48	2	paramContext2	Context
    //   13	4	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	14	43	finally
    //   23	40	43	finally
  }
  
  public void releaseTbsCoreRenameFileLock(Context paramContext)
  {
    int i = 1;
    try
    {
      boolean bool = TbsDownloadConfig.getInstance().getTbsCoreLoadRenameFileLockEnable();
      i = bool;
    }
    catch (Throwable localThrowable)
    {
      label11:
      break label11;
    }
    if (i == 0) {}
    while (mTbsCoreRenameFileLockForMultiProcess == null) {
      return;
    }
    FileUtil.releaseTbsCoreRenameFileLock(paramContext, mTbsCoreRenameFileLockForMultiProcess);
  }
  
  void releaseTbsInstallingFileLock()
  {
    for (;;)
    {
      try
      {
        if (this.currentTbsFileLockStackCount <= 0)
        {
          TbsLog.i("TbsInstaller", "releaseTbsInstallingFileLock currentTbsFileLockStackCount=" + this.currentTbsFileLockStackCount + "call stack:" + Log.getStackTraceString(new Throwable()));
          return;
        }
        if (this.currentTbsFileLockStackCount > 1)
        {
          TbsLog.i("TbsInstaller", "releaseTbsInstallingFileLock with skip");
          this.currentTbsFileLockStackCount -= 1;
          continue;
        }
        if (this.currentTbsFileLockStackCount != 1) {
          continue;
        }
      }
      finally {}
      TbsLog.i("TbsInstaller", "releaseTbsInstallingFileLock without skip");
      FileUtil.freeFileLock(this.tbsFileLockFileLock, this.tbsInstallingFos);
      this.currentTbsFileLockStackCount = 0;
    }
  }
  
  public void setFallBackStatus(Context paramContext)
  {
    setTmpFolderCoreToRead(paramContext, true);
    TbsCoreVerManager.getInstance(paramContext).setTbsCoreInstallStatus(getTbsCoreShareDecoupleCoreVersion(paramContext), 2);
  }
  
  public void setRenameTmpCoreStatus(Context paramContext, int paramInt)
  {
    setTmpFolderCoreToRead(paramContext, true);
    TbsCoreVerManager.getInstance(paramContext).setTbsCoreInstallStatus(paramInt, 2);
  }
  
  boolean tbsFileConfExists(Context paramContext)
  {
    paramContext = new File(getTbsCoreShareDir(paramContext), "tbs.conf");
    return (paramContext != null) && (paramContext.exists());
  }
  
  public void tryInstallTbsCore(Context paramContext, boolean paramBoolean)
  {
    TbsLog.i("TbsInstaller", "tryInstallTbsCore #1");
    if (QbSdk.mIsSysWebViewForcedByOuter) {}
    do
    {
      return;
      if (Build.VERSION.SDK_INT < 8)
      {
        TbsLog.e("TbsInstaller", "android version < 2.1 no need install X5 core", true);
        return;
      }
    } while (!getTmpFolderCoreToRead(paramContext));
    TbsLog.i("TbsInstaller", "tryInstallTbsCore #2 ");
    if (!isPrepareTbsCore(paramContext, "core_unzip_tmp"))
    {
      if (isPrepareTbsCore(paramContext, "core_share_backup_tmp")) {
        break label104;
      }
      label66:
      if (isPrepareTbsCore(paramContext, "core_copy_tmp")) {
        break label123;
      }
    }
    label104:
    label123:
    while (!enableTbsCoreFromCopy(paramContext, paramBoolean))
    {
      TbsLog.i("TbsInstaller", "tryInstallTbsCore, no need ", true);
      return;
      if (!enableTbsCoreFromUnzip(paramContext, paramBoolean)) {
        break;
      }
      TbsLog.i("TbsInstaller", "tryInstallTbsCore, enableTbsCoreFromUnzip!!", true);
      return;
      if (!enableTbsCoreFromBackup(paramContext, paramBoolean)) {
        break label66;
      }
      TbsLog.i("TbsInstaller", "tryInstallTbsCore, enableTbsCoreFromBackup!!", true);
      return;
    }
    TbsLog.i("TbsInstaller", "tryInstallTbsCore, enableTbsCoreFromCopy!!", true);
  }
  
  void unzipTbsCoreToThirdAppTmp(Context paramContext, File paramFile, int paramInt)
  {
    TbsLog.i("TbsInstaller", "unzipTbsCoreToThirdAppTmp,ctx=" + paramContext + "File=" + paramFile + "coreVersion=" + paramInt);
    if ((paramFile == null) || (paramContext == null)) {
      return;
    }
    Message localMessage = new Message();
    localMessage.what = 4;
    localMessage.obj = new Object[] { paramContext, paramFile, Integer.valueOf(paramInt) };
    mTbsInstallerHandler.sendMessage(localMessage);
  }
  
  public boolean unzipTbsCoreToThirdAppTmpInThread(Context paramContext, File paramFile, int paramInt)
  {
    TbsLog.i("TbsInstaller", "unzipTbsCoreToThirdAppTmpInThread #1");
    boolean bool = unzipTbsApk(paramContext, paramFile, false);
    TbsLog.i("TbsInstaller", "unzipTbsCoreToThirdAppTmpInThread result is " + bool);
    if (bool) {
      getInstance().setRenameTmpCoreStatus(paramContext, paramInt);
    }
    return bool;
  }
  
  boolean vertificateApp(Context paramContext)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsInstaller
 * JD-Core Version:    0.7.0.1
 */