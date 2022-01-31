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
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.TbsUtils;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.nio.channels.FileLock;
import java.util.Map;
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
  private static final String MTT_SIG = "3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a";
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
  static final String TBS_FOLDER_NAME = "tbs";
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
  static final String TMP_TBS_UNZIP_FOLDER_NAME = "core_unzip_tmp";
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
  private static final Lock mTbsRenameLock = new ReentrantLock();
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
    mTbsCoreInstalledVer = new ThreadLocal()
    {
      public Integer initialValue()
      {
        return Integer.valueOf(0);
      }
    };
    mTbsInstallerHandler = null;
    WEBCORE_LIB_LENGTH_MAP = new Long[][] { { Long.valueOf(44006L), Long.valueOf(39094008L) }, { Long.valueOf(44005L), Long.valueOf(39094008L) }, { Long.valueOf(43910L), Long.valueOf(38917816L) }, { Long.valueOf(43909L), Long.valueOf(38917816L) } };
    isStaticTbsInstalling = false;
    tbs_core_copy_filter = new FileFilter()
    {
      public boolean accept(File paramAnonymousFile)
      {
        paramAnonymousFile = paramAnonymousFile.getName();
        if (paramAnonymousFile == null) {}
        while ((paramAnonymousFile.endsWith(".jar_is_first_load_dex_flag_file")) || ((Build.VERSION.SDK_INT >= 21) && (paramAnonymousFile.endsWith(".dex")))) {
          return false;
        }
        return true;
      }
    };
    mCoreVersion = 0;
  }
  
  private TbsInstaller()
  {
    if (mTbsInstallerHandler == null) {
      mTbsInstallerHandler = new Handler(TbsHandlerThread.getInstance().getLooper())
      {
        public void handleMessage(Message paramAnonymousMessage)
        {
          QbSdk.setTBSInstallingStatus(true);
          switch (paramAnonymousMessage.what)
          {
          }
          for (;;)
          {
            QbSdk.setTBSInstallingStatus(false);
            super.handleMessage(paramAnonymousMessage);
            return;
            TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_INSTALL_TBS_CORE");
            Object[] arrayOfObject = (Object[])paramAnonymousMessage.obj;
            TbsInstaller.this.installTbsCoreInThread((Context)arrayOfObject[0], (String)arrayOfObject[1], ((Integer)arrayOfObject[2]).intValue());
            continue;
            TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_COPY_TBS_CORE");
            arrayOfObject = (Object[])paramAnonymousMessage.obj;
            TbsInstaller.this.copyTbsCoreInThread((Context)arrayOfObject[0], (Context)arrayOfObject[1], ((Integer)arrayOfObject[2]).intValue());
            continue;
            TbsLog.i("TbsInstaller", "TbsInstaller--handleMessage--MSG_INSTALL_TBS_CORE_EX");
            arrayOfObject = (Object[])paramAnonymousMessage.obj;
            TbsInstaller.this.installLocalTbsCoreExInThread((Context)arrayOfObject[0], (Bundle)arrayOfObject[1]);
          }
        }
      };
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
    File localFile = getTmpTbsCoreUnzipDir(paramContext);
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
    //   3: ldc 164
    //   5: new 459	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 460	java/lang/StringBuilder:<init>	()V
    //   12: ldc_w 462
    //   15: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: aload_2
    //   19: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: invokevirtual 470	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: invokestatic 397	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: aload_1
    //   29: invokevirtual 474	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   32: aload_2
    //   33: invokevirtual 480	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   36: astore_1
    //   37: new 482	java/io/FileOutputStream
    //   40: dup
    //   41: aload_3
    //   42: invokespecial 485	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   45: astore_3
    //   46: ldc_w 486
    //   49: newarray byte
    //   51: astore_2
    //   52: aload_1
    //   53: aload_2
    //   54: invokevirtual 492	java/io/InputStream:read	([B)I
    //   57: istore 4
    //   59: iload 4
    //   61: iconst_m1
    //   62: if_icmpeq +44 -> 106
    //   65: aload_3
    //   66: aload_2
    //   67: iconst_0
    //   68: iload 4
    //   70: invokevirtual 496	java/io/FileOutputStream:write	([BII)V
    //   73: goto -21 -> 52
    //   76: astore 5
    //   78: aload_1
    //   79: astore_2
    //   80: aload_3
    //   81: astore_1
    //   82: aload 5
    //   84: astore_3
    //   85: aload_3
    //   86: invokevirtual 499	java/io/IOException:printStackTrace	()V
    //   89: aload_1
    //   90: ifnull +7 -> 97
    //   93: aload_1
    //   94: invokevirtual 502	java/io/FileOutputStream:close	()V
    //   97: aload_2
    //   98: ifnull +7 -> 105
    //   101: aload_2
    //   102: invokevirtual 503	java/io/InputStream:close	()V
    //   105: return
    //   106: aload_3
    //   107: invokevirtual 506	java/io/FileOutputStream:flush	()V
    //   110: aload_3
    //   111: ifnull +7 -> 118
    //   114: aload_3
    //   115: invokevirtual 502	java/io/FileOutputStream:close	()V
    //   118: aload_1
    //   119: ifnull -14 -> 105
    //   122: aload_1
    //   123: invokevirtual 503	java/io/InputStream:close	()V
    //   126: return
    //   127: astore_1
    //   128: aload_1
    //   129: invokevirtual 499	java/io/IOException:printStackTrace	()V
    //   132: return
    //   133: astore_2
    //   134: aconst_null
    //   135: astore_3
    //   136: aconst_null
    //   137: astore_1
    //   138: aload_3
    //   139: ifnull +7 -> 146
    //   142: aload_3
    //   143: invokevirtual 502	java/io/FileOutputStream:close	()V
    //   146: aload_1
    //   147: ifnull +7 -> 154
    //   150: aload_1
    //   151: invokevirtual 503	java/io/InputStream:close	()V
    //   154: aload_2
    //   155: athrow
    //   156: astore_3
    //   157: aload_3
    //   158: invokevirtual 499	java/io/IOException:printStackTrace	()V
    //   161: goto -15 -> 146
    //   164: astore_1
    //   165: aload_1
    //   166: invokevirtual 499	java/io/IOException:printStackTrace	()V
    //   169: goto -15 -> 154
    //   172: astore_1
    //   173: aload_1
    //   174: invokevirtual 499	java/io/IOException:printStackTrace	()V
    //   177: goto -80 -> 97
    //   180: astore_1
    //   181: goto -53 -> 128
    //   184: astore_2
    //   185: aload_2
    //   186: invokevirtual 499	java/io/IOException:printStackTrace	()V
    //   189: goto -71 -> 118
    //   192: astore_2
    //   193: aconst_null
    //   194: astore_3
    //   195: goto -57 -> 138
    //   198: astore_2
    //   199: goto -61 -> 138
    //   202: astore_3
    //   203: aload_2
    //   204: astore 5
    //   206: aload_3
    //   207: astore_2
    //   208: aload_1
    //   209: astore_3
    //   210: aload 5
    //   212: astore_1
    //   213: goto -75 -> 138
    //   216: astore_3
    //   217: aconst_null
    //   218: astore_1
    //   219: aload 5
    //   221: astore_2
    //   222: goto -137 -> 85
    //   225: astore_3
    //   226: aconst_null
    //   227: astore 5
    //   229: aload_1
    //   230: astore_2
    //   231: aload 5
    //   233: astore_1
    //   234: goto -149 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	237	0	this	TbsInstaller
    //   0	237	1	paramContext	Context
    //   0	237	2	paramString	String
    //   0	237	3	paramFile	File
    //   57	12	4	i	int
    //   1	1	5	localObject	Object
    //   76	7	5	localIOException	java.io.IOException
    //   204	28	5	str	String
    // Exception table:
    //   from	to	target	type
    //   46	52	76	java/io/IOException
    //   52	59	76	java/io/IOException
    //   65	73	76	java/io/IOException
    //   106	110	76	java/io/IOException
    //   122	126	127	java/io/IOException
    //   28	37	133	finally
    //   142	146	156	java/io/IOException
    //   150	154	164	java/io/IOException
    //   93	97	172	java/io/IOException
    //   101	105	180	java/io/IOException
    //   114	118	184	java/io/IOException
    //   37	46	192	finally
    //   46	52	198	finally
    //   52	59	198	finally
    //   65	73	198	finally
    //   106	110	198	finally
    //   85	89	202	finally
    //   28	37	216	java/io/IOException
    //   37	46	225	java/io/IOException
  }
  
  /* Error */
  @TargetApi(11)
  private void copyTbsCoreInThread(Context paramContext1, Context paramContext2, int paramInt)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 9
    //   3: aload_1
    //   4: invokestatic 516	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   7: sipush -524
    //   10: invokevirtual 519	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   13: aload_0
    //   14: aload_2
    //   15: invokevirtual 522	com/tencent/smtt/sdk/TbsInstaller:isTbsLocalInstalled	(Landroid/content/Context;)Z
    //   18: ifeq +4 -> 22
    //   21: return
    //   22: ldc 164
    //   24: new 459	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 460	java/lang/StringBuilder:<init>	()V
    //   31: ldc_w 524
    //   34: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: iload_3
    //   38: invokevirtual 527	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   41: invokevirtual 470	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokestatic 397	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   47: getstatic 532	android/os/Build$VERSION:SDK_INT	I
    //   50: bipush 11
    //   52: if_icmplt +70 -> 122
    //   55: aload_2
    //   56: ldc_w 534
    //   59: iconst_4
    //   60: invokevirtual 538	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   63: astore 14
    //   65: aload 14
    //   67: ldc_w 540
    //   70: iconst_m1
    //   71: invokeinterface 546 3 0
    //   76: iload_3
    //   77: if_icmpne +58 -> 135
    //   80: ldc 164
    //   82: new 459	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 460	java/lang/StringBuilder:<init>	()V
    //   89: ldc_w 548
    //   92: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: iload_3
    //   96: invokevirtual 527	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   99: ldc_w 550
    //   102: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: invokevirtual 470	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: invokestatic 373	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   111: aload_1
    //   112: invokestatic 516	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   115: sipush -525
    //   118: invokevirtual 519	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   121: return
    //   122: aload_2
    //   123: ldc_w 534
    //   126: iconst_0
    //   127: invokevirtual 538	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   130: astore 14
    //   132: goto -67 -> 65
    //   135: aload_0
    //   136: aload_2
    //   137: invokevirtual 553	com/tencent/smtt/sdk/TbsInstaller:getTbsInstallingFileLock	(Landroid/content/Context;)Z
    //   140: ifne +14 -> 154
    //   143: aload_1
    //   144: invokestatic 516	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   147: sipush -526
    //   150: invokevirtual 519	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   153: return
    //   154: getstatic 281	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   157: invokeinterface 558 1 0
    //   162: istore 8
    //   164: ldc 164
    //   166: new 459	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 460	java/lang/StringBuilder:<init>	()V
    //   173: ldc_w 560
    //   176: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: iload 8
    //   181: invokevirtual 563	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   184: invokevirtual 470	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokestatic 397	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   190: iload 8
    //   192: ifeq +1789 -> 1981
    //   195: getstatic 279	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   198: invokeinterface 566 1 0
    //   203: aconst_null
    //   204: astore 15
    //   206: aload_2
    //   207: invokestatic 412	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   210: ldc_w 568
    //   213: invokevirtual 572	com/tencent/smtt/sdk/TbsCoreVerManager:getIntNum	(Ljava/lang/String;)I
    //   216: istore 4
    //   218: aload_2
    //   219: invokestatic 412	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   222: ldc_w 574
    //   225: invokevirtual 577	com/tencent/smtt/sdk/TbsCoreVerManager:getIntStatus	(Ljava/lang/String;)I
    //   228: istore 5
    //   230: iload 4
    //   232: iload_3
    //   233: if_icmpne +45 -> 278
    //   236: getstatic 581	com/tencent/smtt/sdk/QbSdk:mTbsListenerWrapper	Lcom/tencent/smtt/sdk/TbsListener;
    //   239: sipush 220
    //   242: invokeinterface 586 2 0
    //   247: aload_1
    //   248: invokestatic 516	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   251: sipush -528
    //   254: invokevirtual 519	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   257: getstatic 279	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   260: invokeinterface 589 1 0
    //   265: getstatic 281	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   268: invokeinterface 589 1 0
    //   273: aload_0
    //   274: invokevirtual 592	com/tencent/smtt/sdk/TbsInstaller:releaseTbsInstallingFileLock	()V
    //   277: return
    //   278: aload_0
    //   279: aload_2
    //   280: invokevirtual 596	com/tencent/smtt/sdk/TbsInstaller:getTbsCoreInstalledVerInNolock	(Landroid/content/Context;)I
    //   283: istore 6
    //   285: ldc 164
    //   287: new 459	java/lang/StringBuilder
    //   290: dup
    //   291: invokespecial 460	java/lang/StringBuilder:<init>	()V
    //   294: ldc_w 598
    //   297: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: iload 6
    //   302: invokevirtual 527	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   305: invokevirtual 470	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   308: invokestatic 397	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   311: iload 6
    //   313: iload_3
    //   314: if_icmpne +69 -> 383
    //   317: getstatic 581	com/tencent/smtt/sdk/QbSdk:mTbsListenerWrapper	Lcom/tencent/smtt/sdk/TbsListener;
    //   320: sipush 220
    //   323: invokeinterface 586 2 0
    //   328: aload_1
    //   329: invokestatic 516	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   332: sipush -528
    //   335: invokevirtual 519	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   338: ldc 164
    //   340: new 459	java/lang/StringBuilder
    //   343: dup
    //   344: invokespecial 460	java/lang/StringBuilder:<init>	()V
    //   347: ldc_w 600
    //   350: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: iload 6
    //   355: invokevirtual 527	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   358: invokevirtual 470	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   361: invokestatic 397	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   364: getstatic 279	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   367: invokeinterface 589 1 0
    //   372: getstatic 281	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   375: invokeinterface 589 1 0
    //   380: goto -107 -> 273
    //   383: aload_2
    //   384: invokestatic 412	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   387: invokevirtual 604	com/tencent/smtt/sdk/TbsCoreVerManager:getTbsCoreInstallVer	()I
    //   390: istore 7
    //   392: iload 7
    //   394: ifle +1659 -> 2053
    //   397: iload_3
    //   398: iload 7
    //   400: if_icmpgt +6 -> 406
    //   403: goto +1650 -> 2053
    //   406: aload_0
    //   407: aload_2
    //   408: invokevirtual 607	com/tencent/smtt/sdk/TbsInstaller:cleanStatusAndTmpDir	(Landroid/content/Context;)V
    //   411: goto +1656 -> 2067
    //   414: aload_0
    //   415: aload_2
    //   416: invokevirtual 607	com/tencent/smtt/sdk/TbsInstaller:cleanStatusAndTmpDir	(Landroid/content/Context;)V
    //   419: ldc 164
    //   421: ldc_w 609
    //   424: iconst_1
    //   425: invokestatic 612	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   428: iconst_m1
    //   429: istore 4
    //   431: aload_2
    //   432: invokestatic 615	com/tencent/smtt/utils/FileUtil:hasEnoughFreeSpace	(Landroid/content/Context;)Z
    //   435: ifne +88 -> 523
    //   438: invokestatic 621	com/tencent/smtt/utils/TbsUtils:getROMAvailableSize	()J
    //   441: lstore 10
    //   443: aload_2
    //   444: invokestatic 516	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   447: invokevirtual 624	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMinFreeSpace	()J
    //   450: lstore 12
    //   452: aload_1
    //   453: invokestatic 516	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   456: sipush -529
    //   459: invokevirtual 519	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   462: aload_2
    //   463: invokestatic 629	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   466: sipush 210
    //   469: new 459	java/lang/StringBuilder
    //   472: dup
    //   473: invokespecial 460	java/lang/StringBuilder:<init>	()V
    //   476: ldc_w 631
    //   479: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: lload 10
    //   484: invokevirtual 634	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   487: ldc_w 636
    //   490: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: lload 12
    //   495: invokevirtual 634	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   498: invokevirtual 470	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   501: invokevirtual 640	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   504: getstatic 279	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   507: invokeinterface 589 1 0
    //   512: getstatic 281	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   515: invokeinterface 589 1 0
    //   520: goto -247 -> 273
    //   523: iload 4
    //   525: ifle +39 -> 564
    //   528: aload_2
    //   529: invokestatic 645	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   532: ifne +97 -> 629
    //   535: aload_2
    //   536: invokestatic 516	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   539: getfield 649	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   542: ldc_w 651
    //   545: iconst_0
    //   546: invokeinterface 546 3 0
    //   551: iconst_1
    //   552: if_icmpne +77 -> 629
    //   555: iload_3
    //   556: aload_0
    //   557: aload_2
    //   558: invokevirtual 654	com/tencent/smtt/sdk/TbsInstaller:getTbsCoreShareDecoupleCoreVersion	(Landroid/content/Context;)I
    //   561: if_icmpeq +68 -> 629
    //   564: iload 4
    //   566: ifne +125 -> 691
    //   569: aload_2
    //   570: invokestatic 412	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   573: ldc_w 656
    //   576: invokevirtual 572	com/tencent/smtt/sdk/TbsCoreVerManager:getIntNum	(Ljava/lang/String;)I
    //   579: istore 4
    //   581: iload 4
    //   583: iconst_2
    //   584: if_icmple +93 -> 677
    //   587: aload_2
    //   588: invokestatic 629	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   591: sipush 211
    //   594: ldc_w 658
    //   597: invokevirtual 640	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   600: aload_1
    //   601: invokestatic 516	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   604: sipush -530
    //   607: invokevirtual 519	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   610: getstatic 279	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   613: invokeinterface 589 1 0
    //   618: getstatic 281	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   621: invokeinterface 589 1 0
    //   626: goto -353 -> 273
    //   629: ldc 164
    //   631: new 459	java/lang/StringBuilder
    //   634: dup
    //   635: invokespecial 460	java/lang/StringBuilder:<init>	()V
    //   638: ldc_w 660
    //   641: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   644: aload_0
    //   645: aload_2
    //   646: invokevirtual 654	com/tencent/smtt/sdk/TbsInstaller:getTbsCoreShareDecoupleCoreVersion	(Landroid/content/Context;)I
    //   649: invokevirtual 527	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   652: invokevirtual 470	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   655: invokestatic 397	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   658: getstatic 279	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   661: invokeinterface 589 1 0
    //   666: getstatic 281	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   669: invokeinterface 589 1 0
    //   674: goto -401 -> 273
    //   677: aload_2
    //   678: invokestatic 412	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   681: ldc_w 656
    //   684: iload 4
    //   686: iconst_1
    //   687: iadd
    //   688: invokevirtual 664	com/tencent/smtt/sdk/TbsCoreVerManager:setStatus	(Ljava/lang/String;I)V
    //   691: aload_0
    //   692: aload_1
    //   693: invokevirtual 667	com/tencent/smtt/sdk/TbsInstaller:getTbsCoreShareDir	(Landroid/content/Context;)Ljava/io/File;
    //   696: astore 16
    //   698: aload_2
    //   699: invokestatic 645	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   702: ifne +232 -> 934
    //   705: aload_2
    //   706: invokestatic 516	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   709: getfield 649	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   712: ldc_w 651
    //   715: iconst_0
    //   716: invokeinterface 546 3 0
    //   721: iconst_1
    //   722: if_icmpne +202 -> 924
    //   725: aload_0
    //   726: aload_2
    //   727: invokevirtual 670	com/tencent/smtt/sdk/TbsInstaller:getCoreShareDecoupleDir	(Landroid/content/Context;)Ljava/io/File;
    //   730: astore 14
    //   732: aload 16
    //   734: ifnull +1143 -> 1877
    //   737: aload 14
    //   739: ifnull +1138 -> 1877
    //   742: aload_2
    //   743: invokestatic 412	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   746: iload_3
    //   747: iconst_0
    //   748: invokevirtual 673	com/tencent/smtt/sdk/TbsCoreVerManager:setTbsCoreCopyStatus	(II)V
    //   751: new 675	com/tencent/smtt/utils/TbsCopyVerify
    //   754: dup
    //   755: invokespecial 676	com/tencent/smtt/utils/TbsCopyVerify:<init>	()V
    //   758: astore 15
    //   760: aload 15
    //   762: aload 16
    //   764: invokevirtual 679	com/tencent/smtt/utils/TbsCopyVerify:generateReferenceValue	(Ljava/io/File;)V
    //   767: invokestatic 684	java/lang/System:currentTimeMillis	()J
    //   770: lstore 10
    //   772: aload_1
    //   773: invokestatic 516	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   776: sipush -551
    //   779: invokevirtual 519	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   782: aload 16
    //   784: aload 14
    //   786: getstatic 315	com/tencent/smtt/sdk/TbsInstaller:tbs_core_copy_filter	Ljava/io/FileFilter;
    //   789: invokestatic 688	com/tencent/smtt/utils/FileUtil:copyFiles	(Ljava/io/File;Ljava/io/File;Ljava/io/FileFilter;)Z
    //   792: istore 8
    //   794: aload_2
    //   795: invokestatic 516	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   798: getfield 649	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   801: ldc_w 651
    //   804: iconst_0
    //   805: invokeinterface 546 3 0
    //   810: iconst_1
    //   811: if_icmpne +7 -> 818
    //   814: aload_2
    //   815: invokestatic 691	com/tencent/smtt/sdk/TbsShareManager:shareCoreShareDecouple	(Landroid/content/Context;)V
    //   818: ldc 164
    //   820: new 459	java/lang/StringBuilder
    //   823: dup
    //   824: invokespecial 460	java/lang/StringBuilder:<init>	()V
    //   827: ldc_w 693
    //   830: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   833: invokestatic 684	java/lang/System:currentTimeMillis	()J
    //   836: lload 10
    //   838: lsub
    //   839: invokevirtual 634	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   842: invokevirtual 470	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   845: invokestatic 397	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   848: iload 8
    //   850: ifeq +978 -> 1828
    //   853: aload 15
    //   855: aload 16
    //   857: invokevirtual 696	com/tencent/smtt/utils/TbsCopyVerify:generateVerifyValue	(Ljava/io/File;)V
    //   860: aload 15
    //   862: invokevirtual 699	com/tencent/smtt/utils/TbsCopyVerify:verify	()Z
    //   865: ifne +79 -> 944
    //   868: ldc 164
    //   870: ldc_w 701
    //   873: invokestatic 397	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   876: aload 14
    //   878: iconst_1
    //   879: invokestatic 407	com/tencent/smtt/utils/FileUtil:delete	(Ljava/io/File;Z)V
    //   882: aload_2
    //   883: invokestatic 629	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   886: sipush 213
    //   889: ldc_w 703
    //   892: invokevirtual 640	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   895: aload_1
    //   896: invokestatic 516	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   899: sipush -531
    //   902: invokevirtual 519	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   905: getstatic 279	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   908: invokeinterface 589 1 0
    //   913: getstatic 281	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   916: invokeinterface 589 1 0
    //   921: goto -648 -> 273
    //   924: aload_0
    //   925: aload_2
    //   926: invokevirtual 706	com/tencent/smtt/sdk/TbsInstaller:getTmpTbsCoreCopyDir	(Landroid/content/Context;)Ljava/io/File;
    //   929: astore 14
    //   931: goto -199 -> 732
    //   934: aload_0
    //   935: aload_2
    //   936: invokevirtual 706	com/tencent/smtt/sdk/TbsInstaller:getTmpTbsCoreCopyDir	(Landroid/content/Context;)Ljava/io/File;
    //   939: astore 14
    //   941: goto -209 -> 732
    //   944: aconst_null
    //   945: astore 17
    //   947: new 440	java/io/File
    //   950: dup
    //   951: aload 14
    //   953: ldc 114
    //   955: invokespecial 449	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   958: astore 15
    //   960: new 708	java/util/Properties
    //   963: dup
    //   964: invokespecial 709	java/util/Properties:<init>	()V
    //   967: astore 16
    //   969: aload 15
    //   971: ifnull +181 -> 1152
    //   974: aload 15
    //   976: invokevirtual 453	java/io/File:exists	()Z
    //   979: ifeq +173 -> 1152
    //   982: aload 16
    //   984: ifnull +168 -> 1152
    //   987: new 711	java/io/BufferedInputStream
    //   990: dup
    //   991: new 713	java/io/FileInputStream
    //   994: dup
    //   995: aload 15
    //   997: invokespecial 714	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   1000: invokespecial 717	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1003: astore 15
    //   1005: aload 15
    //   1007: astore 18
    //   1009: aload 16
    //   1011: aload 15
    //   1013: invokevirtual 720	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   1016: iconst_1
    //   1017: istore 4
    //   1019: aload 15
    //   1021: ifnull +8 -> 1029
    //   1024: aload 15
    //   1026: invokevirtual 721	java/io/BufferedInputStream:close	()V
    //   1029: iload 9
    //   1031: istore 8
    //   1033: iload 4
    //   1035: ifeq +411 -> 1446
    //   1038: aload 14
    //   1040: invokevirtual 725	java/io/File:listFiles	()[Ljava/io/File;
    //   1043: astore 15
    //   1045: aload_1
    //   1046: invokestatic 516	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1049: sipush -552
    //   1052: invokevirtual 519	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1055: iconst_0
    //   1056: istore 5
    //   1058: iload 9
    //   1060: istore 8
    //   1062: iload 5
    //   1064: aload 15
    //   1066: arraylength
    //   1067: if_icmpge +379 -> 1446
    //   1070: aload 15
    //   1072: iload 5
    //   1074: aaload
    //   1075: astore 17
    //   1077: ldc 114
    //   1079: aload 17
    //   1081: invokevirtual 728	java/io/File:getName	()Ljava/lang/String;
    //   1084: invokevirtual 734	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1087: ifne +56 -> 1143
    //   1090: aload 17
    //   1092: invokevirtual 728	java/io/File:getName	()Ljava/lang/String;
    //   1095: ldc_w 736
    //   1098: invokevirtual 740	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1101: ifne +42 -> 1143
    //   1104: ldc 167
    //   1106: aload 17
    //   1108: invokevirtual 728	java/io/File:getName	()Ljava/lang/String;
    //   1111: invokevirtual 734	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1114: ifne +29 -> 1143
    //   1117: aload 17
    //   1119: invokevirtual 743	java/io/File:isDirectory	()Z
    //   1122: ifne +21 -> 1143
    //   1125: aload 17
    //   1127: invokevirtual 728	java/io/File:getName	()Ljava/lang/String;
    //   1130: ldc_w 745
    //   1133: invokevirtual 740	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   1136: istore 8
    //   1138: iload 8
    //   1140: ifeq +142 -> 1282
    //   1143: iload 5
    //   1145: iconst_1
    //   1146: iadd
    //   1147: istore 5
    //   1149: goto -91 -> 1058
    //   1152: aconst_null
    //   1153: astore 15
    //   1155: iconst_0
    //   1156: istore 4
    //   1158: goto -139 -> 1019
    //   1161: astore 17
    //   1163: aconst_null
    //   1164: astore 16
    //   1166: aconst_null
    //   1167: astore 15
    //   1169: aload 15
    //   1171: astore 18
    //   1173: aload 17
    //   1175: invokevirtual 746	java/lang/Exception:printStackTrace	()V
    //   1178: aload 15
    //   1180: ifnull +8 -> 1188
    //   1183: aload 15
    //   1185: invokevirtual 721	java/io/BufferedInputStream:close	()V
    //   1188: iconst_1
    //   1189: istore 4
    //   1191: goto -162 -> 1029
    //   1194: astore 15
    //   1196: aload 17
    //   1198: astore 16
    //   1200: aload 16
    //   1202: ifnull +8 -> 1210
    //   1205: aload 16
    //   1207: invokevirtual 721	java/io/BufferedInputStream:close	()V
    //   1210: aload 15
    //   1212: athrow
    //   1213: astore 16
    //   1215: aload 14
    //   1217: astore 15
    //   1219: aload 16
    //   1221: astore 14
    //   1223: aload_2
    //   1224: invokestatic 629	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1227: sipush 215
    //   1230: aload 14
    //   1232: invokevirtual 747	java/lang/Exception:toString	()Ljava/lang/String;
    //   1235: invokevirtual 640	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1238: aload_1
    //   1239: invokestatic 516	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1242: sipush -537
    //   1245: invokevirtual 519	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1248: aload 15
    //   1250: iconst_0
    //   1251: invokestatic 407	com/tencent/smtt/utils/FileUtil:delete	(Ljava/io/File;Z)V
    //   1254: aload_2
    //   1255: invokestatic 412	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   1258: iconst_0
    //   1259: iconst_m1
    //   1260: invokevirtual 673	com/tencent/smtt/sdk/TbsCoreVerManager:setTbsCoreCopyStatus	(II)V
    //   1263: getstatic 279	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   1266: invokeinterface 589 1 0
    //   1271: getstatic 281	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   1274: invokeinterface 589 1 0
    //   1279: goto -1006 -> 273
    //   1282: aload 17
    //   1284: invokestatic 753	com/tencent/smtt/utils/ApkUtil:getMd5	(Ljava/io/File;)Ljava/lang/String;
    //   1287: astore 18
    //   1289: aload 16
    //   1291: aload 17
    //   1293: invokevirtual 728	java/io/File:getName	()Ljava/lang/String;
    //   1296: ldc_w 755
    //   1299: invokevirtual 759	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1302: astore 19
    //   1304: aload 19
    //   1306: ldc_w 755
    //   1309: invokevirtual 734	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1312: ifne +74 -> 1386
    //   1315: aload 18
    //   1317: aload 19
    //   1319: invokevirtual 734	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1322: ifeq +64 -> 1386
    //   1325: ldc 164
    //   1327: new 459	java/lang/StringBuilder
    //   1330: dup
    //   1331: invokespecial 460	java/lang/StringBuilder:<init>	()V
    //   1334: ldc_w 761
    //   1337: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1340: aload 17
    //   1342: invokevirtual 728	java/io/File:getName	()Ljava/lang/String;
    //   1345: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1348: ldc_w 763
    //   1351: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1354: invokevirtual 470	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1357: invokestatic 397	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1360: goto -217 -> 1143
    //   1363: astore_1
    //   1364: getstatic 279	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   1367: invokeinterface 589 1 0
    //   1372: getstatic 281	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   1375: invokeinterface 589 1 0
    //   1380: aload_0
    //   1381: invokevirtual 592	com/tencent/smtt/sdk/TbsInstaller:releaseTbsInstallingFileLock	()V
    //   1384: aload_1
    //   1385: athrow
    //   1386: ldc 164
    //   1388: new 459	java/lang/StringBuilder
    //   1391: dup
    //   1392: invokespecial 460	java/lang/StringBuilder:<init>	()V
    //   1395: ldc_w 765
    //   1398: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1401: aload 17
    //   1403: invokevirtual 728	java/io/File:getName	()Ljava/lang/String;
    //   1406: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1409: ldc_w 763
    //   1412: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1415: ldc_w 767
    //   1418: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1421: aload 19
    //   1423: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1426: ldc_w 769
    //   1429: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1432: aload 18
    //   1434: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1437: invokevirtual 470	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1440: invokestatic 373	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1443: iconst_0
    //   1444: istore 8
    //   1446: ldc 164
    //   1448: new 459	java/lang/StringBuilder
    //   1451: dup
    //   1452: invokespecial 460	java/lang/StringBuilder:<init>	()V
    //   1455: ldc_w 771
    //   1458: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1461: iload 8
    //   1463: invokevirtual 563	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1466: invokevirtual 470	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1469: invokestatic 397	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1472: iload 4
    //   1474: ifeq +64 -> 1538
    //   1477: iload 8
    //   1479: ifne +59 -> 1538
    //   1482: ldc 164
    //   1484: ldc_w 773
    //   1487: invokestatic 373	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1490: aload 14
    //   1492: iconst_1
    //   1493: invokestatic 407	com/tencent/smtt/utils/FileUtil:delete	(Ljava/io/File;Z)V
    //   1496: aload_2
    //   1497: invokestatic 629	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1500: sipush 213
    //   1503: ldc_w 775
    //   1506: invokevirtual 640	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1509: aload_1
    //   1510: invokestatic 516	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1513: sipush -532
    //   1516: invokevirtual 519	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1519: getstatic 279	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   1522: invokeinterface 589 1 0
    //   1527: getstatic 281	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   1530: invokeinterface 589 1 0
    //   1535: goto -1262 -> 273
    //   1538: ldc 164
    //   1540: ldc_w 777
    //   1543: invokestatic 397	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1546: aload_0
    //   1547: aload_2
    //   1548: iconst_1
    //   1549: invokespecial 781	com/tencent/smtt/sdk/TbsInstaller:setTmpFolderCoreToRead	(Landroid/content/Context;Z)V
    //   1552: aload_1
    //   1553: invokestatic 786	com/tencent/smtt/sdk/TbsApkDownloader:getHostBackupApkPath	(Landroid/content/Context;)Ljava/io/File;
    //   1556: astore 16
    //   1558: aload 16
    //   1560: ifnull +38 -> 1598
    //   1563: aload 16
    //   1565: invokevirtual 453	java/io/File:exists	()Z
    //   1568: ifeq +30 -> 1598
    //   1571: aload_2
    //   1572: invokestatic 791	com/tencent/smtt/sdk/TbsDownloader:getOverSea	(Landroid/content/Context;)Z
    //   1575: ifeq +182 -> 1757
    //   1578: ldc_w 793
    //   1581: astore 15
    //   1583: new 440	java/io/File
    //   1586: dup
    //   1587: aload 16
    //   1589: aload 15
    //   1591: invokespecial 449	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   1594: aload_2
    //   1595: invokestatic 797	com/tencent/smtt/sdk/TbsApkDownloader:backupTbsApk	(Ljava/io/File;Landroid/content/Context;)V
    //   1598: aload_2
    //   1599: invokestatic 412	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   1602: iload_3
    //   1603: iconst_1
    //   1604: invokevirtual 673	com/tencent/smtt/sdk/TbsCoreVerManager:setTbsCoreCopyStatus	(II)V
    //   1607: aload_0
    //   1608: getfield 327	com/tencent/smtt/sdk/TbsInstaller:isContinueInstallWithoutCore	Z
    //   1611: ifeq +154 -> 1765
    //   1614: aload_2
    //   1615: invokestatic 629	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1618: sipush 220
    //   1621: ldc_w 799
    //   1624: invokevirtual 640	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1627: aload_1
    //   1628: invokestatic 516	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1631: sipush -533
    //   1634: invokevirtual 519	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1637: ldc 164
    //   1639: new 459	java/lang/StringBuilder
    //   1642: dup
    //   1643: invokespecial 460	java/lang/StringBuilder:<init>	()V
    //   1646: ldc_w 801
    //   1649: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1652: iload_3
    //   1653: invokevirtual 527	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1656: invokevirtual 470	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1659: invokestatic 397	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1662: getstatic 532	android/os/Build$VERSION:SDK_INT	I
    //   1665: bipush 11
    //   1667: if_icmplt +114 -> 1781
    //   1670: aload_2
    //   1671: ldc_w 534
    //   1674: iconst_4
    //   1675: invokevirtual 538	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   1678: astore 15
    //   1680: aload 15
    //   1682: invokeinterface 805 1 0
    //   1687: astore 15
    //   1689: aload 15
    //   1691: ldc_w 807
    //   1694: iconst_0
    //   1695: invokeinterface 813 3 0
    //   1700: pop
    //   1701: aload 15
    //   1703: ldc_w 815
    //   1706: iconst_0
    //   1707: invokeinterface 813 3 0
    //   1712: pop
    //   1713: aload 15
    //   1715: ldc_w 817
    //   1718: iload_3
    //   1719: invokeinterface 813 3 0
    //   1724: pop
    //   1725: aload 15
    //   1727: invokeinterface 820 1 0
    //   1732: pop
    //   1733: aload_2
    //   1734: invokestatic 823	com/tencent/smtt/utils/TbsUtils:createDirectoryTBS	(Landroid/content/Context;)Z
    //   1737: pop
    //   1738: getstatic 279	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   1741: invokeinterface 589 1 0
    //   1746: getstatic 281	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   1749: invokeinterface 589 1 0
    //   1754: goto -1481 -> 273
    //   1757: ldc_w 825
    //   1760: astore 15
    //   1762: goto -179 -> 1583
    //   1765: aload_2
    //   1766: invokestatic 629	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1769: sipush 220
    //   1772: ldc_w 827
    //   1775: invokevirtual 640	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1778: goto -151 -> 1627
    //   1781: aload_2
    //   1782: ldc_w 534
    //   1785: iconst_0
    //   1786: invokevirtual 538	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   1789: astore 15
    //   1791: goto -111 -> 1680
    //   1794: astore 15
    //   1796: ldc 164
    //   1798: new 459	java/lang/StringBuilder
    //   1801: dup
    //   1802: invokespecial 460	java/lang/StringBuilder:<init>	()V
    //   1805: ldc_w 829
    //   1808: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1811: aload 15
    //   1813: invokestatic 835	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1816: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1819: invokevirtual 470	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1822: invokestatic 373	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1825: goto -92 -> 1733
    //   1828: ldc 164
    //   1830: ldc_w 837
    //   1833: invokestatic 397	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1836: aload_2
    //   1837: invokestatic 412	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   1840: iload_3
    //   1841: iconst_2
    //   1842: invokevirtual 673	com/tencent/smtt/sdk/TbsCoreVerManager:setTbsCoreCopyStatus	(II)V
    //   1845: aload 14
    //   1847: iconst_0
    //   1848: invokestatic 407	com/tencent/smtt/utils/FileUtil:delete	(Ljava/io/File;Z)V
    //   1851: aload_1
    //   1852: invokestatic 516	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1855: sipush -534
    //   1858: invokevirtual 519	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1861: aload_2
    //   1862: invokestatic 629	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1865: sipush 212
    //   1868: ldc_w 839
    //   1871: invokevirtual 640	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1874: goto -136 -> 1738
    //   1877: aload 16
    //   1879: ifnonnull +26 -> 1905
    //   1882: aload_2
    //   1883: invokestatic 629	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1886: sipush 213
    //   1889: ldc_w 841
    //   1892: invokevirtual 640	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1895: aload_1
    //   1896: invokestatic 516	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1899: sipush -535
    //   1902: invokevirtual 519	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1905: aload 14
    //   1907: ifnonnull -169 -> 1738
    //   1910: aload_2
    //   1911: invokestatic 629	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1914: sipush 214
    //   1917: ldc_w 843
    //   1920: invokevirtual 640	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1923: aload_1
    //   1924: invokestatic 516	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1927: sipush -536
    //   1930: invokevirtual 519	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1933: goto -195 -> 1738
    //   1936: astore_1
    //   1937: ldc 164
    //   1939: new 459	java/lang/StringBuilder
    //   1942: dup
    //   1943: invokespecial 460	java/lang/StringBuilder:<init>	()V
    //   1946: ldc_w 845
    //   1949: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1952: aload_1
    //   1953: invokevirtual 848	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1956: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1959: ldc_w 850
    //   1962: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1965: aload_1
    //   1966: invokevirtual 854	java/lang/Exception:getCause	()Ljava/lang/Throwable;
    //   1969: invokevirtual 857	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1972: invokevirtual 470	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1975: invokestatic 373	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1978: goto -715 -> 1263
    //   1981: aload_0
    //   1982: invokevirtual 592	com/tencent/smtt/sdk/TbsInstaller:releaseTbsInstallingFileLock	()V
    //   1985: aload_1
    //   1986: invokestatic 516	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1989: sipush -538
    //   1992: invokevirtual 519	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1995: return
    //   1996: astore 16
    //   1998: aload 16
    //   2000: invokevirtual 499	java/io/IOException:printStackTrace	()V
    //   2003: goto -793 -> 1210
    //   2006: astore 15
    //   2008: aload 15
    //   2010: invokevirtual 499	java/io/IOException:printStackTrace	()V
    //   2013: goto -825 -> 1188
    //   2016: astore 15
    //   2018: aload 15
    //   2020: invokevirtual 499	java/io/IOException:printStackTrace	()V
    //   2023: goto -994 -> 1029
    //   2026: astore 14
    //   2028: goto -805 -> 1223
    //   2031: astore 15
    //   2033: aload 18
    //   2035: astore 16
    //   2037: goto -837 -> 1200
    //   2040: astore 17
    //   2042: aconst_null
    //   2043: astore 15
    //   2045: goto -876 -> 1169
    //   2048: astore 17
    //   2050: goto -881 -> 1169
    //   2053: iload 4
    //   2055: ifle +12 -> 2067
    //   2058: iload_3
    //   2059: iload 4
    //   2061: if_icmple +6 -> 2067
    //   2064: goto -1658 -> 406
    //   2067: iload 5
    //   2069: istore 4
    //   2071: iload 5
    //   2073: iconst_3
    //   2074: if_icmpne -1643 -> 431
    //   2077: iload 5
    //   2079: istore 4
    //   2081: iload 6
    //   2083: ifle -1652 -> 431
    //   2086: iload_3
    //   2087: iload 6
    //   2089: if_icmpgt -1675 -> 414
    //   2092: iload 5
    //   2094: istore 4
    //   2096: iload_3
    //   2097: ldc_w 858
    //   2100: if_icmpne -1669 -> 431
    //   2103: goto -1689 -> 414
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2106	0	this	TbsInstaller
    //   0	2106	1	paramContext1	Context
    //   0	2106	2	paramContext2	Context
    //   0	2106	3	paramInt	int
    //   216	1879	4	i	int
    //   228	1865	5	j	int
    //   283	1807	6	k	int
    //   390	11	7	m	int
    //   162	1316	8	bool1	boolean
    //   1	1058	9	bool2	boolean
    //   441	396	10	l1	long
    //   450	44	12	l2	long
    //   63	1843	14	localObject1	Object
    //   2026	1	14	localException1	Exception
    //   204	980	15	localObject2	Object
    //   1194	17	15	localObject3	Object
    //   1217	573	15	localObject4	Object
    //   1794	18	15	localThrowable	Throwable
    //   2006	3	15	localIOException1	java.io.IOException
    //   2016	3	15	localIOException2	java.io.IOException
    //   2031	1	15	localObject5	Object
    //   2043	1	15	localObject6	Object
    //   696	510	16	localObject7	Object
    //   1213	77	16	localException2	Exception
    //   1556	322	16	localFile	File
    //   1996	3	16	localIOException3	java.io.IOException
    //   2035	1	16	localObject8	Object
    //   945	181	17	localObject9	Object
    //   1161	241	17	localException3	Exception
    //   2040	1	17	localException4	Exception
    //   2048	1	17	localException5	Exception
    //   1007	1027	18	localObject10	Object
    //   1302	120	19	str	String
    // Exception table:
    //   from	to	target	type
    //   947	969	1161	java/lang/Exception
    //   947	969	1194	finally
    //   974	982	1194	finally
    //   987	1005	1194	finally
    //   742	818	1213	java/lang/Exception
    //   818	848	1213	java/lang/Exception
    //   853	905	1213	java/lang/Exception
    //   1024	1029	1213	java/lang/Exception
    //   1038	1055	1213	java/lang/Exception
    //   1062	1070	1213	java/lang/Exception
    //   1077	1138	1213	java/lang/Exception
    //   1183	1188	1213	java/lang/Exception
    //   1205	1210	1213	java/lang/Exception
    //   1210	1213	1213	java/lang/Exception
    //   1282	1360	1213	java/lang/Exception
    //   1386	1443	1213	java/lang/Exception
    //   1446	1472	1213	java/lang/Exception
    //   1482	1519	1213	java/lang/Exception
    //   1538	1558	1213	java/lang/Exception
    //   1563	1578	1213	java/lang/Exception
    //   1583	1598	1213	java/lang/Exception
    //   1598	1627	1213	java/lang/Exception
    //   1627	1680	1213	java/lang/Exception
    //   1680	1733	1213	java/lang/Exception
    //   1733	1738	1213	java/lang/Exception
    //   1765	1778	1213	java/lang/Exception
    //   1781	1791	1213	java/lang/Exception
    //   1796	1825	1213	java/lang/Exception
    //   1828	1874	1213	java/lang/Exception
    //   1882	1905	1213	java/lang/Exception
    //   1910	1933	1213	java/lang/Exception
    //   1998	2003	1213	java/lang/Exception
    //   2008	2013	1213	java/lang/Exception
    //   2018	2023	1213	java/lang/Exception
    //   206	230	1363	finally
    //   236	257	1363	finally
    //   278	311	1363	finally
    //   317	364	1363	finally
    //   383	392	1363	finally
    //   406	411	1363	finally
    //   414	428	1363	finally
    //   431	504	1363	finally
    //   528	564	1363	finally
    //   569	581	1363	finally
    //   587	610	1363	finally
    //   629	658	1363	finally
    //   677	691	1363	finally
    //   691	732	1363	finally
    //   742	818	1363	finally
    //   818	848	1363	finally
    //   853	905	1363	finally
    //   924	931	1363	finally
    //   934	941	1363	finally
    //   1024	1029	1363	finally
    //   1038	1055	1363	finally
    //   1062	1070	1363	finally
    //   1077	1138	1363	finally
    //   1183	1188	1363	finally
    //   1205	1210	1363	finally
    //   1210	1213	1363	finally
    //   1223	1248	1363	finally
    //   1248	1263	1363	finally
    //   1282	1360	1363	finally
    //   1386	1443	1363	finally
    //   1446	1472	1363	finally
    //   1482	1519	1363	finally
    //   1538	1558	1363	finally
    //   1563	1578	1363	finally
    //   1583	1598	1363	finally
    //   1598	1627	1363	finally
    //   1627	1680	1363	finally
    //   1680	1733	1363	finally
    //   1733	1738	1363	finally
    //   1765	1778	1363	finally
    //   1781	1791	1363	finally
    //   1796	1825	1363	finally
    //   1828	1874	1363	finally
    //   1882	1905	1363	finally
    //   1910	1933	1363	finally
    //   1937	1978	1363	finally
    //   1998	2003	1363	finally
    //   2008	2013	1363	finally
    //   2018	2023	1363	finally
    //   1680	1733	1794	java/lang/Throwable
    //   1248	1263	1936	java/lang/Exception
    //   1205	1210	1996	java/io/IOException
    //   1183	1188	2006	java/io/IOException
    //   1024	1029	2016	java/io/IOException
    //   206	230	2026	java/lang/Exception
    //   236	257	2026	java/lang/Exception
    //   278	311	2026	java/lang/Exception
    //   317	364	2026	java/lang/Exception
    //   383	392	2026	java/lang/Exception
    //   406	411	2026	java/lang/Exception
    //   414	428	2026	java/lang/Exception
    //   431	504	2026	java/lang/Exception
    //   528	564	2026	java/lang/Exception
    //   569	581	2026	java/lang/Exception
    //   587	610	2026	java/lang/Exception
    //   629	658	2026	java/lang/Exception
    //   677	691	2026	java/lang/Exception
    //   691	732	2026	java/lang/Exception
    //   924	931	2026	java/lang/Exception
    //   934	941	2026	java/lang/Exception
    //   1009	1016	2031	finally
    //   1173	1178	2031	finally
    //   974	982	2040	java/lang/Exception
    //   987	1005	2040	java/lang/Exception
    //   1009	1016	2048	java/lang/Exception
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
      paramFile = paramFile.listFiles(new FileFilter()
      {
        public boolean accept(File paramAnonymousFile)
        {
          return paramAnonymousFile.getName().endsWith(".jar");
        }
      });
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
    //   1: new 20	com/tencent/smtt/sdk/TbsInstaller$6
    //   4: dup
    //   5: aload_0
    //   6: invokespecial 942	com/tencent/smtt/sdk/TbsInstaller$6:<init>	(Lcom/tencent/smtt/sdk/TbsInstaller;)V
    //   9: invokevirtual 900	java/io/File:listFiles	(Ljava/io/FileFilter;)[Ljava/io/File;
    //   12: astore 6
    //   14: aload 6
    //   16: arraylength
    //   17: istore 4
    //   19: getstatic 532	android/os/Build$VERSION:SDK_INT	I
    //   22: bipush 16
    //   24: if_icmpge +32 -> 56
    //   27: aload_1
    //   28: invokevirtual 945	android/content/Context:getPackageName	()Ljava/lang/String;
    //   31: ifnull +25 -> 56
    //   34: aload_1
    //   35: invokevirtual 945	android/content/Context:getPackageName	()Ljava/lang/String;
    //   38: ldc 29
    //   40: invokevirtual 948	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   43: istore 5
    //   45: iload 5
    //   47: ifeq +9 -> 56
    //   50: ldc2_w 949
    //   53: invokestatic 956	java/lang/Thread:sleep	(J)V
    //   56: aload_1
    //   57: invokevirtual 872	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   60: astore 7
    //   62: iconst_0
    //   63: istore_3
    //   64: iload_3
    //   65: iload 4
    //   67: if_icmpge +63 -> 130
    //   70: ldc 164
    //   72: new 459	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 460	java/lang/StringBuilder:<init>	()V
    //   79: ldc_w 958
    //   82: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: aload 6
    //   87: iload_3
    //   88: aaload
    //   89: invokevirtual 877	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   92: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: invokevirtual 470	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokestatic 397	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   101: new 874	dalvik/system/DexClassLoader
    //   104: dup
    //   105: aload 6
    //   107: iload_3
    //   108: aaload
    //   109: invokevirtual 877	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   112: aload_2
    //   113: invokevirtual 877	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   116: aconst_null
    //   117: aload 7
    //   119: invokespecial 880	dalvik/system/DexClassLoader:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V
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
    //   134: invokevirtual 746	java/lang/Exception:printStackTrace	()V
    //   137: aload_1
    //   138: invokestatic 629	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   141: sipush 209
    //   144: aload_2
    //   145: invokevirtual 747	java/lang/Exception:toString	()Ljava/lang/String;
    //   148: invokevirtual 640	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   151: ldc 164
    //   153: ldc_w 960
    //   156: invokestatic 397	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
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
    int k = 0;
    TbsLog.i("TbsInstaller", "TbsInstaller-doTbsDexOpt start - dirMode: " + paramInt);
    switch (paramInt)
    {
    }
    try
    {
      TbsLog.e("TbsInstaller", "doDexoptOrDexoat mode error: " + paramInt);
      return false;
    }
    catch (Exception localException)
    {
      File localFile;
      localException.printStackTrace();
      TbsLogReport.getInstance(paramContext).setInstallErrorCode(209, localException.toString());
      TbsLog.i("TbsInstaller", "TbsInstaller-doTbsDexOpt done");
    }
    if (TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_downloaddecouplecore", 0) != 1) {
      localFile = getTmpTbsCoreUnzipDir(paramContext);
    }
    for (;;)
    {
      try
      {
        String str = System.getProperty("java.vm.version");
        if (str == null) {
          break label295;
        }
        bool = str.startsWith("2");
        if (!bool) {
          break label295;
        }
        paramInt = 1;
      }
      catch (Throwable localThrowable)
      {
        boolean bool;
        int j;
        TbsLogReport.getInstance(paramContext).setInstallErrorCode(226, localThrowable);
        paramInt = 0;
        continue;
        int i = 0;
        continue;
      }
      if (Build.VERSION.SDK_INT == 23)
      {
        i = 1;
        bool = TbsDownloadConfig.getInstance(paramContext).mPreferences.getBoolean("tbs_stop_preoat", false);
        j = k;
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
        if ((j != 0) && (doDexoatForArtVm(paramContext, localFile))) {
          break label293;
        }
        return doDexoptForDavlikVM(paramContext, localFile);
        localFile = getTmpTbsCoreCopyDir(paramContext);
        continue;
        localFile = getTbsCoreShareDir(paramContext);
      }
      label293:
      return true;
      label295:
      paramInt = 0;
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
    //   14: ldc 164
    //   16: ldc_w 991
    //   19: invokestatic 397	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: iload 8
    //   24: istore 6
    //   26: aload_0
    //   27: aload_1
    //   28: invokevirtual 553	com/tencent/smtt/sdk/TbsInstaller:getTbsInstallingFileLock	(Landroid/content/Context;)Z
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
    //   51: getstatic 279	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   54: invokeinterface 558 1 0
    //   59: istore 9
    //   61: iload 8
    //   63: istore 6
    //   65: ldc 164
    //   67: new 459	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 460	java/lang/StringBuilder:<init>	()V
    //   74: ldc_w 993
    //   77: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: iload 9
    //   82: invokevirtual 563	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   85: invokevirtual 470	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokestatic 397	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   91: iload 9
    //   93: ifeq +111 -> 204
    //   96: aload_1
    //   97: invokestatic 412	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   100: ldc_w 574
    //   103: invokevirtual 577	com/tencent/smtt/sdk/TbsCoreVerManager:getIntStatus	(Ljava/lang/String;)I
    //   106: istore_3
    //   107: aload_0
    //   108: iconst_0
    //   109: aload_1
    //   110: invokevirtual 997	com/tencent/smtt/sdk/TbsInstaller:getTbsCoreInstalledVerWithNew	(ZLandroid/content/Context;)I
    //   113: istore 4
    //   115: ldc 164
    //   117: new 459	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 460	java/lang/StringBuilder:<init>	()V
    //   124: ldc_w 999
    //   127: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: iload_3
    //   131: invokevirtual 527	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   134: invokevirtual 470	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokestatic 397	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   140: ldc 164
    //   142: new 459	java/lang/StringBuilder
    //   145: dup
    //   146: invokespecial 460	java/lang/StringBuilder:<init>	()V
    //   149: ldc_w 1001
    //   152: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: iload 4
    //   157: invokevirtual 527	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   160: invokevirtual 470	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 397	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   166: iload_3
    //   167: iconst_1
    //   168: if_icmpne +160 -> 328
    //   171: iload 4
    //   173: ifne +102 -> 275
    //   176: ldc 164
    //   178: ldc_w 1003
    //   181: iconst_1
    //   182: invokestatic 612	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   185: aload_0
    //   186: aload_1
    //   187: invokespecial 1006	com/tencent/smtt/sdk/TbsInstaller:generateNewTbsCoreFromCopy	(Landroid/content/Context;)V
    //   190: iload 7
    //   192: istore_2
    //   193: getstatic 279	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   196: invokeinterface 589 1 0
    //   201: iload_2
    //   202: istore 5
    //   204: iload 5
    //   206: istore 6
    //   208: aload_0
    //   209: invokevirtual 592	com/tencent/smtt/sdk/TbsInstaller:releaseTbsInstallingFileLock	()V
    //   212: goto -170 -> 42
    //   215: astore 11
    //   217: iload 6
    //   219: istore 5
    //   221: aload_1
    //   222: invokestatic 629	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   225: sipush 215
    //   228: aload 11
    //   230: invokevirtual 1007	java/lang/Throwable:toString	()Ljava/lang/String;
    //   233: invokevirtual 640	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   236: aload_1
    //   237: new 459	java/lang/StringBuilder
    //   240: dup
    //   241: invokespecial 460	java/lang/StringBuilder:<init>	()V
    //   244: ldc_w 1009
    //   247: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: aload 11
    //   252: invokestatic 835	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   255: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: invokevirtual 470	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   261: invokestatic 428	com/tencent/smtt/sdk/QbSdk:forceSysWebViewInner	(Landroid/content/Context;Ljava/lang/String;)V
    //   264: goto -222 -> 42
    //   267: astore_1
    //   268: aload_1
    //   269: athrow
    //   270: astore_1
    //   271: aload_0
    //   272: monitorexit
    //   273: aload_1
    //   274: athrow
    //   275: iload_2
    //   276: ifeq +52 -> 328
    //   279: ldc 164
    //   281: ldc_w 1011
    //   284: iconst_1
    //   285: invokestatic 612	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   288: aload_0
    //   289: aload_1
    //   290: invokespecial 1006	com/tencent/smtt/sdk/TbsInstaller:generateNewTbsCoreFromCopy	(Landroid/content/Context;)V
    //   293: iload 7
    //   295: istore_2
    //   296: goto -103 -> 193
    //   299: astore 11
    //   301: iload 8
    //   303: istore 6
    //   305: getstatic 279	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   308: invokeinterface 589 1 0
    //   313: iload 8
    //   315: istore 6
    //   317: aload 11
    //   319: athrow
    //   320: astore 11
    //   322: iload_2
    //   323: istore 5
    //   325: goto -104 -> 221
    //   328: iconst_0
    //   329: istore_2
    //   330: goto -137 -> 193
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	333	0	this	TbsInstaller
    //   0	333	1	paramContext	Context
    //   0	333	2	paramBoolean	boolean
    //   106	63	3	i	int
    //   113	59	4	j	int
    //   1	323	5	bool1	boolean
    //   24	292	6	bool2	boolean
    //   10	284	7	bool3	boolean
    //   4	310	8	bool4	boolean
    //   7	85	9	bool5	boolean
    //   31	3	10	bool6	boolean
    //   215	36	11	localThrowable1	Throwable
    //   299	19	11	localObject	Object
    //   320	1	11	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   26	33	215	java/lang/Throwable
    //   51	61	215	java/lang/Throwable
    //   65	91	215	java/lang/Throwable
    //   208	212	215	java/lang/Throwable
    //   305	313	215	java/lang/Throwable
    //   317	320	215	java/lang/Throwable
    //   26	33	267	finally
    //   51	61	267	finally
    //   65	91	267	finally
    //   193	201	267	finally
    //   208	212	267	finally
    //   221	264	267	finally
    //   305	313	267	finally
    //   317	320	267	finally
    //   14	22	270	finally
    //   268	270	270	finally
    //   96	166	299	finally
    //   176	190	299	finally
    //   279	293	299	finally
    //   193	201	320	java/lang/Throwable
  }
  
  private boolean enableTbsCoreFromUnzip(Context paramContext, boolean paramBoolean)
  {
    boolean bool3 = true;
    boolean bool1 = false;
    boolean bool4 = false;
    boolean bool5 = false;
    label64:
    try
    {
      TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip canRenameTmpDir =" + paramBoolean);
      bool2 = bool4;
      try
      {
        boolean bool6 = getTbsInstallingFileLock(paramContext);
        if (bool6) {
          break label64;
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
              break label300;
            }
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
        label300:
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
    //   6: ldc 164
    //   8: new 459	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 460	java/lang/StringBuilder:<init>	()V
    //   15: ldc_w 1034
    //   18: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_1
    //   22: invokevirtual 857	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   25: ldc_w 1036
    //   28: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: aload_2
    //   32: invokevirtual 857	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 470	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 397	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: aload 6
    //   43: astore_2
    //   44: new 440	java/io/File
    //   47: dup
    //   48: aload_1
    //   49: ldc 114
    //   51: invokespecial 449	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   54: astore 9
    //   56: aload 6
    //   58: astore_2
    //   59: new 708	java/util/Properties
    //   62: dup
    //   63: invokespecial 709	java/util/Properties:<init>	()V
    //   66: astore 7
    //   68: aload 9
    //   70: ifnull +189 -> 259
    //   73: aload 6
    //   75: astore_2
    //   76: aload 9
    //   78: invokevirtual 453	java/io/File:exists	()Z
    //   81: ifeq +178 -> 259
    //   84: aload 7
    //   86: ifnull +173 -> 259
    //   89: aload 6
    //   91: astore_2
    //   92: new 711	java/io/BufferedInputStream
    //   95: dup
    //   96: new 713	java/io/FileInputStream
    //   99: dup
    //   100: aload 9
    //   102: invokespecial 714	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   105: invokespecial 717	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   108: astore 6
    //   110: aload 7
    //   112: aload 6
    //   114: invokevirtual 720	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   117: iconst_1
    //   118: istore 4
    //   120: aload 6
    //   122: astore_2
    //   123: aload 7
    //   125: astore 6
    //   127: iload 4
    //   129: istore 5
    //   131: aload_2
    //   132: ifnull +15 -> 147
    //   135: aload_2
    //   136: invokevirtual 721	java/io/BufferedInputStream:close	()V
    //   139: iload 4
    //   141: istore 5
    //   143: aload 7
    //   145: astore 6
    //   147: ldc 164
    //   149: new 459	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 460	java/lang/StringBuilder:<init>	()V
    //   156: ldc_w 1038
    //   159: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: iload 5
    //   164: invokevirtual 563	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   167: invokevirtual 470	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokestatic 397	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   173: iload 5
    //   175: ifeq +390 -> 565
    //   178: aload_1
    //   179: invokevirtual 725	java/io/File:listFiles	()[Ljava/io/File;
    //   182: astore_1
    //   183: iconst_0
    //   184: istore_3
    //   185: iload_3
    //   186: aload_1
    //   187: arraylength
    //   188: if_icmpge +377 -> 565
    //   191: aload_1
    //   192: iload_3
    //   193: aaload
    //   194: astore_2
    //   195: ldc 114
    //   197: aload_2
    //   198: invokevirtual 728	java/io/File:getName	()Ljava/lang/String;
    //   201: invokevirtual 734	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   204: ifne +48 -> 252
    //   207: aload_2
    //   208: invokevirtual 728	java/io/File:getName	()Ljava/lang/String;
    //   211: ldc_w 736
    //   214: invokevirtual 740	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   217: ifne +35 -> 252
    //   220: ldc 167
    //   222: aload_2
    //   223: invokevirtual 728	java/io/File:getName	()Ljava/lang/String;
    //   226: invokevirtual 734	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   229: ifne +23 -> 252
    //   232: aload_2
    //   233: invokevirtual 743	java/io/File:isDirectory	()Z
    //   236: ifne +16 -> 252
    //   239: aload_2
    //   240: invokevirtual 728	java/io/File:getName	()Ljava/lang/String;
    //   243: ldc_w 745
    //   246: invokevirtual 740	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   249: ifeq +58 -> 307
    //   252: iload_3
    //   253: iconst_1
    //   254: iadd
    //   255: istore_3
    //   256: goto -71 -> 185
    //   259: aconst_null
    //   260: astore_2
    //   261: iconst_0
    //   262: istore 4
    //   264: goto -141 -> 123
    //   267: astore 7
    //   269: aconst_null
    //   270: astore 6
    //   272: aload 8
    //   274: astore_2
    //   275: aload 7
    //   277: invokevirtual 746	java/lang/Exception:printStackTrace	()V
    //   280: aload 8
    //   282: ifnull +8 -> 290
    //   285: aload 8
    //   287: invokevirtual 721	java/io/BufferedInputStream:close	()V
    //   290: iconst_1
    //   291: istore 5
    //   293: goto -146 -> 147
    //   296: astore_1
    //   297: aload_2
    //   298: ifnull +7 -> 305
    //   301: aload_2
    //   302: invokevirtual 721	java/io/BufferedInputStream:close	()V
    //   305: aload_1
    //   306: athrow
    //   307: aload_2
    //   308: invokestatic 753	com/tencent/smtt/utils/ApkUtil:getMd5	(Ljava/io/File;)Ljava/lang/String;
    //   311: astore 7
    //   313: aload 6
    //   315: aload_2
    //   316: invokevirtual 728	java/io/File:getName	()Ljava/lang/String;
    //   319: ldc_w 755
    //   322: invokevirtual 759	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   325: astore 8
    //   327: aload 8
    //   329: ldc_w 755
    //   332: invokevirtual 734	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   335: ifne +50 -> 385
    //   338: aload 8
    //   340: aload 7
    //   342: invokevirtual 734	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   345: ifeq +40 -> 385
    //   348: ldc 164
    //   350: new 459	java/lang/StringBuilder
    //   353: dup
    //   354: invokespecial 460	java/lang/StringBuilder:<init>	()V
    //   357: ldc_w 761
    //   360: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: aload_2
    //   364: invokevirtual 728	java/io/File:getName	()Ljava/lang/String;
    //   367: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: ldc_w 763
    //   373: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: invokevirtual 470	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   379: invokestatic 397	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   382: goto -130 -> 252
    //   385: ldc 164
    //   387: new 459	java/lang/StringBuilder
    //   390: dup
    //   391: invokespecial 460	java/lang/StringBuilder:<init>	()V
    //   394: ldc_w 765
    //   397: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: aload_2
    //   401: invokevirtual 728	java/io/File:getName	()Ljava/lang/String;
    //   404: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: ldc_w 763
    //   410: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: ldc_w 767
    //   416: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: aload 8
    //   421: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: ldc_w 769
    //   427: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: aload 7
    //   432: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: invokevirtual 470	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   438: invokestatic 373	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   441: iconst_0
    //   442: istore 4
    //   444: ldc 164
    //   446: new 459	java/lang/StringBuilder
    //   449: dup
    //   450: invokespecial 460	java/lang/StringBuilder:<init>	()V
    //   453: ldc_w 1040
    //   456: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: iload 4
    //   461: invokevirtual 563	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   464: invokevirtual 470	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   467: invokestatic 397	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   470: iload 5
    //   472: ifeq +18 -> 490
    //   475: iload 4
    //   477: ifne +13 -> 490
    //   480: ldc 164
    //   482: ldc_w 1042
    //   485: invokestatic 373	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   488: iconst_0
    //   489: ireturn
    //   490: ldc 164
    //   492: ldc_w 1044
    //   495: invokestatic 397	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   498: iconst_1
    //   499: ireturn
    //   500: astore_2
    //   501: aload_2
    //   502: invokevirtual 499	java/io/IOException:printStackTrace	()V
    //   505: goto -200 -> 305
    //   508: astore_2
    //   509: aload_2
    //   510: invokevirtual 499	java/io/IOException:printStackTrace	()V
    //   513: goto -223 -> 290
    //   516: astore_2
    //   517: aload_2
    //   518: invokevirtual 499	java/io/IOException:printStackTrace	()V
    //   521: aload 7
    //   523: astore 6
    //   525: iload 4
    //   527: istore 5
    //   529: goto -382 -> 147
    //   532: astore_1
    //   533: aload 6
    //   535: astore_2
    //   536: goto -239 -> 297
    //   539: astore_2
    //   540: aload 7
    //   542: astore 6
    //   544: aload_2
    //   545: astore 7
    //   547: goto -275 -> 272
    //   550: astore_2
    //   551: aload 6
    //   553: astore 8
    //   555: aload 7
    //   557: astore 6
    //   559: aload_2
    //   560: astore 7
    //   562: goto -290 -> 272
    //   565: iconst_1
    //   566: istore 4
    //   568: goto -124 -> 444
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	571	0	this	TbsInstaller
    //   0	571	1	paramFile	File
    //   0	571	2	paramContext	Context
    //   184	72	3	i	int
    //   118	449	4	bool1	boolean
    //   129	399	5	bool2	boolean
    //   1	557	6	localObject1	Object
    //   66	78	7	localProperties	java.util.Properties
    //   267	9	7	localException	Exception
    //   311	250	7	localObject2	Object
    //   4	550	8	localObject3	Object
    //   54	47	9	localFile	File
    // Exception table:
    //   from	to	target	type
    //   44	56	267	java/lang/Exception
    //   59	68	267	java/lang/Exception
    //   44	56	296	finally
    //   59	68	296	finally
    //   76	84	296	finally
    //   92	110	296	finally
    //   275	280	296	finally
    //   301	305	500	java/io/IOException
    //   285	290	508	java/io/IOException
    //   135	139	516	java/io/IOException
    //   110	117	532	finally
    //   76	84	539	java/lang/Exception
    //   92	110	539	java/lang/Exception
    //   110	117	550	java/lang/Exception
  }
  
  /* Error */
  private void finishLocalTbsInstall(int paramInt, String paramString, Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: new 440	java/io/File
    //   9: dup
    //   10: aload_2
    //   11: invokespecial 1047	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: invokevirtual 1049	java/io/File:delete	()Z
    //   17: pop
    //   18: ldc 164
    //   20: new 459	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 460	java/lang/StringBuilder:<init>	()V
    //   27: ldc_w 1051
    //   30: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_2
    //   34: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc_w 1053
    //   40: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: invokevirtual 470	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: iconst_1
    //   47: invokestatic 612	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   50: new 440	java/io/File
    //   53: dup
    //   54: aload_3
    //   55: ldc 186
    //   57: iconst_0
    //   58: invokevirtual 446	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   61: ldc 229
    //   63: invokespecial 449	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   66: astore_2
    //   67: aload_2
    //   68: ifnull +111 -> 179
    //   71: aload_2
    //   72: invokevirtual 1056	java/io/File:canRead	()Z
    //   75: ifeq +104 -> 179
    //   78: new 440	java/io/File
    //   81: dup
    //   82: aload_2
    //   83: ldc 167
    //   85: invokespecial 449	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   88: astore_2
    //   89: new 708	java/util/Properties
    //   92: dup
    //   93: invokespecial 709	java/util/Properties:<init>	()V
    //   96: astore 6
    //   98: new 711	java/io/BufferedInputStream
    //   101: dup
    //   102: new 713	java/io/FileInputStream
    //   105: dup
    //   106: aload_2
    //   107: invokespecial 714	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   110: invokespecial 717	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   113: astore_3
    //   114: aload 6
    //   116: aload_3
    //   117: invokevirtual 720	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   120: new 1058	java/io/BufferedOutputStream
    //   123: dup
    //   124: new 482	java/io/FileOutputStream
    //   127: dup
    //   128: aload_2
    //   129: invokespecial 485	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   132: invokespecial 1061	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   135: astore_2
    //   136: aload 6
    //   138: ldc 189
    //   140: ldc_w 1063
    //   143: invokevirtual 1067	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   146: pop
    //   147: aload 6
    //   149: aload_2
    //   150: aconst_null
    //   151: invokevirtual 1071	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   154: ldc 164
    //   156: ldc_w 1073
    //   159: iconst_1
    //   160: invokestatic 612	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   163: aload_2
    //   164: ifnull +7 -> 171
    //   167: aload_2
    //   168: invokevirtual 1074	java/io/BufferedOutputStream:close	()V
    //   171: aload_3
    //   172: ifnull +7 -> 179
    //   175: aload_3
    //   176: invokevirtual 721	java/io/BufferedInputStream:close	()V
    //   179: return
    //   180: astore_2
    //   181: aload_2
    //   182: invokevirtual 499	java/io/IOException:printStackTrace	()V
    //   185: goto -14 -> 171
    //   188: astore_2
    //   189: aload_2
    //   190: invokevirtual 499	java/io/IOException:printStackTrace	()V
    //   193: return
    //   194: astore 4
    //   196: aconst_null
    //   197: astore_2
    //   198: aload 5
    //   200: astore_3
    //   201: aload 4
    //   203: invokevirtual 1075	java/lang/Throwable:printStackTrace	()V
    //   206: aload_2
    //   207: ifnull +7 -> 214
    //   210: aload_2
    //   211: invokevirtual 1074	java/io/BufferedOutputStream:close	()V
    //   214: aload_3
    //   215: ifnull -36 -> 179
    //   218: aload_3
    //   219: invokevirtual 721	java/io/BufferedInputStream:close	()V
    //   222: return
    //   223: astore_2
    //   224: aload_2
    //   225: invokevirtual 499	java/io/IOException:printStackTrace	()V
    //   228: return
    //   229: astore_2
    //   230: aload_2
    //   231: invokevirtual 499	java/io/IOException:printStackTrace	()V
    //   234: goto -20 -> 214
    //   237: astore_2
    //   238: aconst_null
    //   239: astore_3
    //   240: aload 4
    //   242: ifnull +8 -> 250
    //   245: aload 4
    //   247: invokevirtual 1074	java/io/BufferedOutputStream:close	()V
    //   250: aload_3
    //   251: ifnull +7 -> 258
    //   254: aload_3
    //   255: invokevirtual 721	java/io/BufferedInputStream:close	()V
    //   258: aload_2
    //   259: athrow
    //   260: astore 4
    //   262: aload 4
    //   264: invokevirtual 499	java/io/IOException:printStackTrace	()V
    //   267: goto -17 -> 250
    //   270: astore_3
    //   271: aload_3
    //   272: invokevirtual 499	java/io/IOException:printStackTrace	()V
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
    //   0	316	0	this	TbsInstaller
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
    //   96	52	6	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   167	171	180	java/io/IOException
    //   175	179	188	java/io/IOException
    //   98	114	194	java/lang/Throwable
    //   218	222	223	java/io/IOException
    //   210	214	229	java/io/IOException
    //   98	114	237	finally
    //   245	250	260	java/io/IOException
    //   254	258	270	java/io/IOException
    //   114	136	278	finally
    //   136	163	282	finally
    //   201	206	293	finally
    //   114	136	304	java/lang/Throwable
    //   136	163	311	java/lang/Throwable
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
        if (!TbsShareManager.isThirdPartyApp(paramContext)) {
          TbsShareManager.shareTbsCore(paramContext);
        }
        TbsCoreVerManager.getInstance(paramContext).setTbsCoreDexoptRetryNum(0);
        TbsCoreVerManager.getInstance(paramContext).setTbsCoreUnzipRetryNum(0);
        TbsCoreVerManager.getInstance(paramContext).setTbsCoreUnlzmaStatus(0);
        TbsCoreVerManager.getInstance(paramContext).setStatus("incrupdate_retry_num", 0);
        TbsCoreVerManager.getInstance(paramContext).setTbsCoreInstallStatus(0, 3);
        TbsCoreVerManager.getInstance(paramContext).setTbsApkPath("");
        TbsCoreVerManager.getInstance(paramContext).setTbsCoreIncrUpdateStatus(-1);
        if (!TbsShareManager.isThirdPartyApp(paramContext))
        {
          i = TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_decouplecoreversion", 0);
          if ((i <= 0) || (i == getInstance().getTbsCoreShareDecoupleCoreVersion(paramContext)) || (i != getInstance().getTbsCoreInstalledVerInNolock(paramContext))) {
            continue;
          }
          coreShareCopyToDecouple(paramContext);
        }
        if (TbsShareManager.isThirdPartyApp(paramContext)) {
          TbsShareManager.writeCoreInfoForThirdPartyApp(paramContext, getTbsCoreInstalledVer(paramContext), true);
        }
        mTbsCoreInstalledVer.set(Integer.valueOf(0));
        mCoreVersion = 0;
      }
      catch (Throwable localThrowable)
      {
        int i;
        localThrowable.printStackTrace();
        TbsLogReport.getInstance(paramContext).setInstallErrorCode(219, "exception when renameing from unzip:" + localThrowable.toString());
        TbsLog.e("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip Exception", true);
        continue;
      }
      releaseTbsCoreRenameFileLock(paramContext);
      return;
      TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip #1 deCoupleCoreVersion is " + i + " getTbsCoreShareDecoupleCoreVersion is " + getInstance().getTbsCoreShareDecoupleCoreVersion(paramContext) + " getTbsCoreInstalledVerInNolock is " + getInstance().getTbsCoreInstalledVerInNolock(paramContext));
    }
  }
  
  /* Error */
  private String getInstalledTbsTimeStamp(Context paramContext)
  {
    // Byte code:
    //   0: new 440	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: aload_1
    //   6: invokevirtual 667	com/tencent/smtt/sdk/TbsInstaller:getTbsCoreShareDir	(Landroid/content/Context;)Ljava/io/File;
    //   9: ldc 167
    //   11: invokespecial 449	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   14: astore_1
    //   15: aload_1
    //   16: ifnull +12 -> 28
    //   19: aload_1
    //   20: invokevirtual 453	java/io/File:exists	()Z
    //   23: istore_2
    //   24: iload_2
    //   25: ifne +17 -> 42
    //   28: iconst_0
    //   29: ifeq +11 -> 40
    //   32: new 1155	java/lang/NullPointerException
    //   35: dup
    //   36: invokespecial 1156	java/lang/NullPointerException:<init>	()V
    //   39: athrow
    //   40: aconst_null
    //   41: areturn
    //   42: new 708	java/util/Properties
    //   45: dup
    //   46: invokespecial 709	java/util/Properties:<init>	()V
    //   49: astore_3
    //   50: new 711	java/io/BufferedInputStream
    //   53: dup
    //   54: new 713	java/io/FileInputStream
    //   57: dup
    //   58: aload_1
    //   59: invokespecial 714	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   62: invokespecial 717	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   65: astore_1
    //   66: aload_3
    //   67: aload_1
    //   68: invokevirtual 720	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   71: aload_1
    //   72: invokevirtual 721	java/io/BufferedInputStream:close	()V
    //   75: aload_3
    //   76: ldc 170
    //   78: invokevirtual 1157	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   81: astore_3
    //   82: aload_3
    //   83: ifnonnull +16 -> 99
    //   86: aload_1
    //   87: ifnull -47 -> 40
    //   90: aload_1
    //   91: invokevirtual 721	java/io/BufferedInputStream:close	()V
    //   94: aconst_null
    //   95: areturn
    //   96: astore_1
    //   97: aconst_null
    //   98: areturn
    //   99: aload_1
    //   100: ifnull +7 -> 107
    //   103: aload_1
    //   104: invokevirtual 721	java/io/BufferedInputStream:close	()V
    //   107: aload_3
    //   108: areturn
    //   109: astore_3
    //   110: aconst_null
    //   111: astore_1
    //   112: aload_1
    //   113: ifnull +7 -> 120
    //   116: aload_1
    //   117: invokevirtual 721	java/io/BufferedInputStream:close	()V
    //   120: aload_3
    //   121: athrow
    //   122: astore_1
    //   123: aconst_null
    //   124: astore_1
    //   125: aload_1
    //   126: ifnull -86 -> 40
    //   129: aload_1
    //   130: invokevirtual 721	java/io/BufferedInputStream:close	()V
    //   133: aconst_null
    //   134: areturn
    //   135: astore_1
    //   136: goto -16 -> 120
    //   139: astore_1
    //   140: goto -33 -> 107
    //   143: astore_3
    //   144: goto -32 -> 112
    //   147: astore_3
    //   148: goto -23 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	this	TbsInstaller
    //   0	151	1	paramContext	Context
    //   23	2	2	bool	boolean
    //   49	59	3	localObject1	Object
    //   109	12	3	localObject2	Object
    //   143	1	3	localObject3	Object
    //   147	1	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   32	40	96	java/io/IOException
    //   90	94	96	java/io/IOException
    //   129	133	96	java/io/IOException
    //   0	15	109	finally
    //   19	24	109	finally
    //   42	66	109	finally
    //   0	15	122	java/lang/Exception
    //   19	24	122	java/lang/Exception
    //   42	66	122	java/lang/Exception
    //   116	120	135	java/io/IOException
    //   103	107	139	java/io/IOException
    //   66	82	143	finally
    //   66	82	147	java/lang/Exception
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
    //   22: invokespecial 1158	com/tencent/smtt/sdk/TbsInstaller:<init>	()V
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
  
  private Context getTbsCoreHostContext(Context paramContext, int paramInt)
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
  
  static File getTbsCorePrivateDir(Context paramContext)
  {
    paramContext = new File(paramContext.getDir("tbs", 0), "core_private");
    if ((paramContext == null) || ((!paramContext.isDirectory()) && (!paramContext.mkdir()))) {
      return null;
    }
    return paramContext;
  }
  
  private boolean getTbsCoreRenameFileLock(Context paramContext)
  {
    boolean bool2 = true;
    try
    {
      bool1 = TbsDownloadConfig.getInstance().getTbsCoreLoadRenameFileLockEnable();
      if (!bool1)
      {
        mTbsCoreRenameFileLockForMultiProcess = X5CoreEngine.getInstance().tryTbsCoreLoadFileLock(paramContext);
        bool1 = bool2;
        if (mTbsCoreRenameFileLockForMultiProcess == null) {
          bool1 = false;
        }
        return bool1;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        boolean bool1 = true;
        continue;
        mTbsCoreRenameFileLockForMultiProcess = FileUtil.getTbsCoreRenameFileLock(paramContext);
      }
    }
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
      if (new File(paramContext.getDir("tbs", 0), "tmp_folder_core_to_read.conf").exists())
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
  
  @TargetApi(11)
  private void installTbsCoreInThread(Context paramContext, String paramString, int paramInt)
  {
    int m = 200;
    int i1 = 0;
    int n = 0;
    TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(-501);
    if (isTbsLocalInstalled(paramContext))
    {
      TbsLog.i("TbsInstaller", "isTbsLocalInstalled --> no installation!", true);
      TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(-502);
      return;
    }
    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsApkPath=" + paramString);
    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreTargetVer=" + paramInt);
    TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + paramContext.getApplicationInfo().processName);
    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread currentProcessId=" + android.os.Process.myPid());
    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread currentThreadName=" + Thread.currentThread().getName());
    if (Build.VERSION.SDK_INT >= 11) {}
    for (Object localObject = paramContext.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4); ((SharedPreferences)localObject).getInt("tbs_precheck_disable_version", -1) == paramInt; localObject = paramContext.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0))
    {
      TbsLog.e("TbsInstaller", "TbsInstaller-installTbsCoreInThread -- version:" + paramInt + " is disabled by preload_x5_check!");
      TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(-503);
      return;
    }
    if (!FileUtil.hasEnoughFreeSpace(paramContext))
    {
      long l1 = TbsUtils.getROMAvailableSize();
      long l2 = TbsDownloadConfig.getInstance(paramContext).getDownloadMinFreeSpace();
      TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(-504);
      TbsLogReport.getInstance(paramContext).setInstallErrorCode(210, "rom is not enough when installing tbs core! curAvailROM=" + l1 + ",minReqRom=" + l2);
      return;
    }
    if (!getTbsInstallingFileLock(paramContext))
    {
      TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(-505);
      return;
    }
    boolean bool = mTbsInstallLock.tryLock();
    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread locked =" + bool);
    int i;
    int j;
    label544:
    int k;
    if (bool)
    {
      TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(-507);
      mTbsRenameLock.lock();
      label635:
      String str;
      for (;;)
      {
        try
        {
          i = TbsCoreVerManager.getInstance(paramContext).getIntNum("copy_core_ver");
          j = TbsCoreVerManager.getInstance(paramContext).getTbsCoreInstallVer();
          TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreCopyVer =" + i);
          TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreInstallVer =" + j);
          TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreTargetVer =" + paramInt);
          if ((j <= 0) || (paramInt <= j)) {
            break label2279;
          }
          cleanStatusAndTmpDir(paramContext);
          j = TbsCoreVerManager.getInstance(paramContext).getTbsCoreInstallStatus();
          k = getTbsCoreInstalledVerInNolock(paramContext);
          TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread installStatus1=" + j);
          TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreInstalledVer=" + k);
          if ((j >= 0) && (j < 2))
          {
            TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread -- retry.....", true);
            k = 1;
            TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(-508);
            TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread installStatus2=" + j);
            if (j >= 1) {
              break label1756;
            }
            TbsLog.i("TbsInstaller", "STEP 2/2 begin installation.....", true);
            TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(-509);
            if (k == 0) {
              continue;
            }
            i = TbsCoreVerManager.getInstance(paramContext).getIntNum("unzip_retry_num");
            if (i > 10)
            {
              TbsLogReport.getInstance(paramContext).setInstallErrorCode(201, "exceed unzip retry num!");
              clearNewTbsCore(paramContext);
              TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(-510);
            }
          }
          else
          {
            i = j;
            if (j != 3) {
              break label2293;
            }
            i = j;
            if (k <= 0) {
              break label2293;
            }
            if (paramInt <= k)
            {
              i = j;
              if (paramInt != 88888888) {
                break label2293;
              }
            }
            i = -1;
            cleanStatusAndTmpDir(paramContext);
            TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread -- update TBS.....", true);
            break label2293;
          }
          TbsCoreVerManager.getInstance(paramContext).setTbsCoreUnzipRetryNum(i + 1);
          if (paramString == null)
          {
            str = TbsCoreVerManager.getInstance(paramContext).getStringValue("install_apk_path");
            localObject = str;
            if (str == null)
            {
              TbsLogReport.getInstance(paramContext).setInstallErrorCode(202, "apk path is null!");
              TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(-511);
            }
          }
          else
          {
            localObject = paramString;
          }
          TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread apkPath =" + (String)localObject);
          i1 = getTbsCoreVerFromApk(paramContext, (String)localObject);
          if (i1 == 0)
          {
            TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(-512);
            TbsLogReport.getInstance(paramContext).setInstallErrorCode(203, "apk version is 0!");
            return;
          }
          TbsCoreVerManager.getInstance(paramContext).setStatus("install_apk_path", (String)localObject);
          TbsCoreVerManager.getInstance(paramContext).setTbsCoreInstallStatus(i1, 0);
          TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(-548);
          if (TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_downloaddecouplecore", 0) == 1)
          {
            if (!unzipTbsApk(paramContext, new File((String)localObject), true)) {
              TbsLogReport.getInstance(paramContext).setInstallErrorCode(207, "unzipTbsApk failed", TbsLogReport.EventType.TYPE_INSTALL_DECOUPLE);
            }
          }
          else if (!unzipTbsApk(paramContext, new File((String)localObject)))
          {
            TbsLogReport.getInstance(paramContext).setInstallErrorCode(207, "unzipTbsApk failed");
            return;
          }
          if (k != 0)
          {
            i = TbsCoreVerManager.getInstance(paramContext).getIntStatus("unlzma_status");
            if (i > 5)
            {
              TbsLogReport.getInstance(paramContext).setInstallErrorCode(223, "exceed unlzma retry num!");
              TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(-553);
              clearNewTbsCore(paramContext);
              TbsApkDownloader.clearAllApkFile(paramContext);
              TbsDownloadConfig.getInstance(paramContext).mSyncMap.put("tbs_needdownload", Boolean.valueOf(true));
              TbsDownloadConfig.getInstance(paramContext).mSyncMap.put("request_full_package", Boolean.valueOf(true));
              TbsDownloadConfig.getInstance(paramContext).commit();
              return;
            }
            TbsCoreVerManager.getInstance(paramContext).setTbsCoreUnlzmaStatus(i + 1);
          }
          TbsLog.i("TbsInstaller", "unlzma begin");
          i = TbsDownloadConfig.getInstance().mPreferences.getInt("tbs_responsecode", 0);
          if (getTbsCoreInstalledVerInNolock(paramContext) == 0) {
            break;
          }
          localObject = QbSdk.onMiscCallExtension(paramContext, "can_unlzma", null);
          if ((localObject == null) || (!(localObject instanceof Boolean))) {
            break label2273;
          }
          bool = ((Boolean)localObject).booleanValue();
          label1350:
          if (!bool) {
            break;
          }
          localObject = new Bundle();
          ((Bundle)localObject).putInt("responseCode", i);
          if (TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_downloaddecouplecore", 0) == 1)
          {
            ((Bundle)localObject).putString("unzip_temp_path", getCoreShareDecoupleDir(paramContext).getAbsolutePath());
            localObject = QbSdk.onMiscCallExtension(paramContext, "unlzma", (Bundle)localObject);
            if (localObject == null)
            {
              TbsLog.i("TbsInstaller", "unlzma return null");
              TbsLogReport.getInstance(paramContext).setInstallErrorCode(222, "unlzma is null");
              i = n;
              label1448:
              if (i != 0) {
                break;
              }
            }
          }
          else
          {
            ((Bundle)localObject).putString("unzip_temp_path", getTmpTbsCoreUnzipDir(paramContext).getAbsolutePath());
            continue;
          }
          if (!(localObject instanceof Boolean)) {
            break label1575;
          }
        }
        finally
        {
          mTbsRenameLock.unlock();
          mTbsInstallLock.unlock();
          releaseTbsInstallingFileLock();
        }
        if (((Boolean)localObject).booleanValue())
        {
          TbsLog.i("TbsInstaller", "unlzma success");
          i = 1;
          break label2303;
        }
        TbsLog.i("TbsInstaller", "unlzma return false");
        TbsLogReport.getInstance(paramContext).setInstallErrorCode(222, "unlzma return false");
        i = 0;
        break label2303;
        label1575:
        if ((localObject instanceof Bundle))
        {
          i = 1;
        }
        else
        {
          i = n;
          if ((localObject instanceof Throwable))
          {
            TbsLog.i("TbsInstaller", "unlzma failure because Throwable" + Log.getStackTraceString((Throwable)localObject));
            TbsLogReport.getInstance(paramContext).setInstallErrorCode(222, (Throwable)localObject);
            i = n;
          }
        }
      }
      TbsLog.i("TbsInstaller", "unlzma finished");
      TbsCoreVerManager.getInstance(paramContext).setTbsCoreInstallStatus(i1, 1);
      i = i1;
      while (j < 2) {
        if (k != 0)
        {
          j = TbsCoreVerManager.getInstance(paramContext).getIntNum("dexopt_retry_num");
          if (j > 10)
          {
            TbsLogReport.getInstance(paramContext).setInstallErrorCode(208, "exceed dexopt retry num!");
            TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(-514);
            clearNewTbsCore(paramContext);
            mTbsRenameLock.unlock();
            mTbsInstallLock.unlock();
            releaseTbsInstallingFileLock();
            return;
            label1756:
            i = i1;
            if (TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_downloaddecouplecore", 0) == 1)
            {
              if (paramString == null)
              {
                str = TbsCoreVerManager.getInstance(paramContext).getStringValue("install_apk_path");
                localObject = str;
                if (str == null)
                {
                  TbsLogReport.getInstance(paramContext).setInstallErrorCode(202, "apk path is null!");
                  TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(-511);
                  mTbsRenameLock.unlock();
                  mTbsInstallLock.unlock();
                  releaseTbsInstallingFileLock();
                }
              }
              else
              {
                localObject = paramString;
              }
              i = i1;
              if (!unzipTbsApk(paramContext, new File((String)localObject), true)) {
                i = i1;
              }
            }
          }
          else
          {
            TbsCoreVerManager.getInstance(paramContext).setTbsCoreDexoptRetryNum(j + 1);
          }
        }
        else
        {
          TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(-549);
          if (!doDexoptOrDexoat(paramContext, 0))
          {
            TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(-515);
            mTbsRenameLock.unlock();
            mTbsInstallLock.unlock();
            releaseTbsInstallingFileLock();
            return;
          }
          TbsCoreVerManager.getInstance(paramContext).setTbsCoreInstallStatus(i, 2);
          TbsLog.i("TbsInstaller", "STEP 2/2 installation completed! you can restart!", true);
          TbsLog.i("TbsInstaller", "STEP 2/2 installation completed! you can restart! version:" + paramInt);
          TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(-516);
          if (Build.VERSION.SDK_INT >= 11) {
            localObject = paramContext.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4);
          }
          try
          {
            for (;;)
            {
              localObject = ((SharedPreferences)localObject).edit();
              ((SharedPreferences.Editor)localObject).putInt("tbs_preload_x5_counter", 0);
              ((SharedPreferences.Editor)localObject).putInt("tbs_preload_x5_recorder", 0);
              ((SharedPreferences.Editor)localObject).putInt("tbs_preload_x5_version", paramInt);
              ((SharedPreferences.Editor)localObject).commit();
              TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(-517);
              if (paramInt == 88888888) {
                finishLocalTbsInstall(paramInt, paramString, paramContext);
              }
              if (!this.isContinueInstallWithoutCore) {
                break;
              }
              paramString = TbsLogReport.getInstance(paramContext);
              paramInt = m;
              if (TbsCoreVerManager.getInstance(paramContext).getTbsCoreIncrUpdateStatus() == 1) {
                paramInt = 221;
              }
              paramString.setInstallErrorCode(paramInt, "continueInstallWithout core success");
              label2129:
              mTbsRenameLock.unlock();
              mTbsInstallLock.unlock();
              releaseTbsInstallingFileLock();
              return;
              localObject = paramContext.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0);
            }
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              TbsLog.e("TbsInstaller", "Init tbs_preload_x5_counter#1 exception:" + Log.getStackTraceString(localThrowable));
              TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(-518);
            }
            paramString = TbsLogReport.getInstance(paramContext);
            if (TbsCoreVerManager.getInstance(paramContext).getTbsCoreIncrUpdateStatus() != 1) {
              break label2306;
            }
          }
        }
      }
    }
    label2306:
    for (paramInt = 221;; paramInt = 200)
    {
      paramString.setInstallErrorCode(paramInt, "success");
      break label2129;
      if (j != 2) {
        break label2129;
      }
      QbSdk.mTbsListenerWrapper.onInstallFinish(200);
      break label2129;
      TbsDownloadConfig.getInstance(paramContext).setInstallInterruptCode(-519);
      releaseTbsInstallingFileLock();
      return;
      label2273:
      bool = false;
      break label1350;
      label2279:
      if ((i <= 0) || (paramInt <= i)) {
        break label544;
      }
      break;
      label2293:
      k = 0;
      j = i;
      break label635;
      label2303:
      break label1448;
    }
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
  
  private static boolean isPrepareTbsCore(Context paramContext, String paramString)
  {
    paramContext = new File(paramContext.getDir("tbs", 0), paramString);
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
  
  private void releaseTbsCoreRenameFileLock(Context paramContext)
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
  
  private void renameTbsCoreCopyDir(Context paramContext)
  {
    TbsLog.i("TbsInstaller", "TbsInstaller--renameTbsCoreCopyDir");
    File localFile1 = getTmpTbsCoreCopyDir(paramContext);
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
    File localFile1 = getTmpTbsCoreUnzipDir(paramContext);
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
        File localFile = new File(paramContext.getDir("tbs", 0), "tmp_folder_core_to_read.conf");
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
    //   6: ldc 164
    //   8: ldc_w 1451
    //   11: invokestatic 397	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: aload_2
    //   15: invokestatic 1454	com/tencent/smtt/utils/FileUtil:isFileValid	(Ljava/io/File;)Z
    //   18: ifne +28 -> 46
    //   21: aload_1
    //   22: invokestatic 629	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   25: sipush 204
    //   28: ldc_w 1456
    //   31: invokevirtual 640	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   34: aload_1
    //   35: invokestatic 516	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   38: sipush -520
    //   41: invokevirtual 519	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   44: iconst_0
    //   45: ireturn
    //   46: aload_1
    //   47: ldc 186
    //   49: iconst_0
    //   50: invokevirtual 446	android/content/Context:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   53: astore 9
    //   55: iload_3
    //   56: ifeq +95 -> 151
    //   59: new 440	java/io/File
    //   62: dup
    //   63: aload 9
    //   65: ldc 199
    //   67: invokespecial 449	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   70: astore 9
    //   72: aload 9
    //   74: ifnull +36 -> 110
    //   77: aload 9
    //   79: invokevirtual 453	java/io/File:exists	()Z
    //   82: ifeq +28 -> 110
    //   85: aload_1
    //   86: invokestatic 516	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   89: getfield 649	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   92: ldc_w 651
    //   95: iconst_0
    //   96: invokeinterface 546 3 0
    //   101: iconst_1
    //   102: if_icmpeq +8 -> 110
    //   105: aload 9
    //   107: invokestatic 1449	com/tencent/smtt/utils/FileUtil:delete	(Ljava/io/File;)V
    //   110: iload_3
    //   111: ifeq +90 -> 201
    //   114: aload_0
    //   115: aload_1
    //   116: invokevirtual 1459	com/tencent/smtt/sdk/TbsInstaller:getTmpTbsCoreDecoupleUnzipDir	(Landroid/content/Context;)Ljava/io/File;
    //   119: astore 9
    //   121: aload 9
    //   123: ifnonnull +88 -> 211
    //   126: aload_1
    //   127: invokestatic 629	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   130: sipush 205
    //   133: ldc_w 1461
    //   136: invokevirtual 640	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   139: aload_1
    //   140: invokestatic 516	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   143: sipush -521
    //   146: invokevirtual 519	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   149: iconst_0
    //   150: ireturn
    //   151: new 440	java/io/File
    //   154: dup
    //   155: aload 9
    //   157: ldc 229
    //   159: invokespecial 449	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   162: astore 9
    //   164: goto -92 -> 72
    //   167: astore 9
    //   169: ldc 164
    //   171: new 459	java/lang/StringBuilder
    //   174: dup
    //   175: invokespecial 460	java/lang/StringBuilder:<init>	()V
    //   178: ldc_w 1463
    //   181: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: aload 9
    //   186: invokestatic 835	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   189: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: invokevirtual 470	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: invokestatic 373	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   198: goto -88 -> 110
    //   201: aload_0
    //   202: aload_1
    //   203: invokevirtual 401	com/tencent/smtt/sdk/TbsInstaller:getTmpTbsCoreUnzipDir	(Landroid/content/Context;)Ljava/io/File;
    //   206: astore 9
    //   208: goto -87 -> 121
    //   211: aload 9
    //   213: invokestatic 1466	com/tencent/smtt/utils/FileUtil:ensureDirectory	(Ljava/io/File;)Z
    //   216: pop
    //   217: iload_3
    //   218: ifeq +9 -> 227
    //   221: aload 9
    //   223: iconst_1
    //   224: invokestatic 407	com/tencent/smtt/utils/FileUtil:delete	(Ljava/io/File;Z)V
    //   227: aload_2
    //   228: aload 9
    //   230: invokestatic 1470	com/tencent/smtt/utils/FileUtil:copyTbsFilesIfNeeded	(Ljava/io/File;Ljava/io/File;)Z
    //   233: istore 8
    //   235: iload 8
    //   237: istore 7
    //   239: iload 8
    //   241: ifeq +12 -> 253
    //   244: aload_0
    //   245: aload 9
    //   247: aload_1
    //   248: invokespecial 1472	com/tencent/smtt/sdk/TbsInstaller:finalCheckForTbsCoreValidity	(Ljava/io/File;Landroid/content/Context;)Z
    //   251: istore 7
    //   253: iload_3
    //   254: ifeq +81 -> 335
    //   257: aload 9
    //   259: invokevirtual 1475	java/io/File:list	()[Ljava/lang/String;
    //   262: astore_2
    //   263: iconst_0
    //   264: istore 4
    //   266: iload 4
    //   268: aload_2
    //   269: arraylength
    //   270: if_icmpge +47 -> 317
    //   273: new 440	java/io/File
    //   276: dup
    //   277: aload 9
    //   279: aload_2
    //   280: iload 4
    //   282: aaload
    //   283: invokespecial 449	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   286: astore 10
    //   288: aload 10
    //   290: invokevirtual 728	java/io/File:getName	()Ljava/lang/String;
    //   293: ldc_w 736
    //   296: invokevirtual 740	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   299: ifeq +9 -> 308
    //   302: aload 10
    //   304: invokevirtual 1049	java/io/File:delete	()Z
    //   307: pop
    //   308: iload 4
    //   310: iconst_1
    //   311: iadd
    //   312: istore 4
    //   314: goto -48 -> 266
    //   317: new 440	java/io/File
    //   320: dup
    //   321: aload_1
    //   322: invokestatic 1477	com/tencent/smtt/sdk/TbsInstaller:getTbsCorePrivateDir	(Landroid/content/Context;)Ljava/io/File;
    //   325: ldc_w 1479
    //   328: invokespecial 449	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   331: invokevirtual 1049	java/io/File:delete	()Z
    //   334: pop
    //   335: iload 7
    //   337: ifne +58 -> 395
    //   340: aload 9
    //   342: invokestatic 1449	com/tencent/smtt/utils/FileUtil:delete	(Ljava/io/File;)V
    //   345: aload_1
    //   346: invokestatic 516	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   349: sipush -522
    //   352: invokevirtual 519	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   355: ldc 164
    //   357: new 459	java/lang/StringBuilder
    //   360: dup
    //   361: invokespecial 460	java/lang/StringBuilder:<init>	()V
    //   364: ldc_w 1481
    //   367: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: aload 9
    //   372: invokevirtual 453	java/io/File:exists	()Z
    //   375: invokevirtual 563	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   378: invokevirtual 470	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   381: invokestatic 373	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   384: ldc 164
    //   386: ldc_w 1483
    //   389: invokestatic 397	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   392: iload 7
    //   394: ireturn
    //   395: aload_0
    //   396: aload_1
    //   397: iconst_1
    //   398: invokespecial 781	com/tencent/smtt/sdk/TbsInstaller:setTmpFolderCoreToRead	(Landroid/content/Context;Z)V
    //   401: iload_3
    //   402: ifeq -18 -> 384
    //   405: aload_0
    //   406: aload_1
    //   407: invokevirtual 670	com/tencent/smtt/sdk/TbsInstaller:getCoreShareDecoupleDir	(Landroid/content/Context;)Ljava/io/File;
    //   410: astore_2
    //   411: aload_2
    //   412: iconst_1
    //   413: invokestatic 407	com/tencent/smtt/utils/FileUtil:delete	(Ljava/io/File;Z)V
    //   416: aload 9
    //   418: aload_2
    //   419: invokevirtual 1436	java/io/File:renameTo	(Ljava/io/File;)Z
    //   422: pop
    //   423: aload_1
    //   424: invokestatic 691	com/tencent/smtt/sdk/TbsShareManager:shareCoreShareDecouple	(Landroid/content/Context;)V
    //   427: goto -43 -> 384
    //   430: astore_2
    //   431: aload_1
    //   432: invokestatic 516	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   435: sipush -523
    //   438: invokevirtual 519	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   441: aload_1
    //   442: invokestatic 629	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   445: sipush 206
    //   448: aload_2
    //   449: invokevirtual 940	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/Throwable;)V
    //   452: aload 9
    //   454: ifnull +244 -> 698
    //   457: aload 9
    //   459: invokevirtual 453	java/io/File:exists	()Z
    //   462: istore_3
    //   463: iload_3
    //   464: ifeq +234 -> 698
    //   467: iload 5
    //   469: istore 4
    //   471: iload 4
    //   473: ifeq +42 -> 515
    //   476: aload 9
    //   478: ifnull +37 -> 515
    //   481: aload 9
    //   483: invokestatic 1449	com/tencent/smtt/utils/FileUtil:delete	(Ljava/io/File;)V
    //   486: ldc 164
    //   488: new 459	java/lang/StringBuilder
    //   491: dup
    //   492: invokespecial 460	java/lang/StringBuilder:<init>	()V
    //   495: ldc_w 1485
    //   498: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: aload 9
    //   503: invokevirtual 453	java/io/File:exists	()Z
    //   506: invokevirtual 563	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   509: invokevirtual 470	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   512: invokestatic 373	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   515: ldc 164
    //   517: ldc_w 1483
    //   520: invokestatic 397	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   523: iconst_0
    //   524: ireturn
    //   525: astore_2
    //   526: aload_1
    //   527: invokestatic 516	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   530: sipush -523
    //   533: invokevirtual 519	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   536: aload_1
    //   537: invokestatic 629	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   540: sipush 207
    //   543: aload_2
    //   544: invokevirtual 940	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/Throwable;)V
    //   547: aload 9
    //   549: ifnull +143 -> 692
    //   552: aload 9
    //   554: invokevirtual 453	java/io/File:exists	()Z
    //   557: istore_3
    //   558: iload_3
    //   559: ifeq +133 -> 692
    //   562: iload 6
    //   564: istore 4
    //   566: iload 4
    //   568: ifeq +42 -> 610
    //   571: aload 9
    //   573: ifnull +37 -> 610
    //   576: aload 9
    //   578: invokestatic 1449	com/tencent/smtt/utils/FileUtil:delete	(Ljava/io/File;)V
    //   581: ldc 164
    //   583: new 459	java/lang/StringBuilder
    //   586: dup
    //   587: invokespecial 460	java/lang/StringBuilder:<init>	()V
    //   590: ldc_w 1485
    //   593: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: aload 9
    //   598: invokevirtual 453	java/io/File:exists	()Z
    //   601: invokevirtual 563	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   604: invokevirtual 470	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   607: invokestatic 373	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   610: goto -95 -> 515
    //   613: astore_1
    //   614: ldc 164
    //   616: ldc_w 1483
    //   619: invokestatic 397	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   622: aload_1
    //   623: athrow
    //   624: astore_1
    //   625: ldc 164
    //   627: new 459	java/lang/StringBuilder
    //   630: dup
    //   631: invokespecial 460	java/lang/StringBuilder:<init>	()V
    //   634: ldc_w 1487
    //   637: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   640: aload_1
    //   641: invokestatic 835	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   644: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   647: invokevirtual 470	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   650: invokestatic 373	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   653: goto -138 -> 515
    //   656: astore_1
    //   657: ldc 164
    //   659: new 459	java/lang/StringBuilder
    //   662: dup
    //   663: invokespecial 460	java/lang/StringBuilder:<init>	()V
    //   666: ldc_w 1487
    //   669: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   672: aload_1
    //   673: invokestatic 835	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   676: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   679: invokevirtual 470	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   682: invokestatic 373	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   685: goto -75 -> 610
    //   688: astore_2
    //   689: goto -354 -> 335
    //   692: iconst_0
    //   693: istore 4
    //   695: goto -129 -> 566
    //   698: iconst_0
    //   699: istore 4
    //   701: goto -230 -> 471
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	704	0	this	TbsInstaller
    //   0	704	1	paramContext	Context
    //   0	704	2	paramFile	File
    //   0	704	3	paramBoolean	boolean
    //   264	436	4	i	int
    //   4	464	5	j	int
    //   1	562	6	k	int
    //   237	156	7	bool1	boolean
    //   233	7	8	bool2	boolean
    //   53	110	9	localFile1	File
    //   167	18	9	localThrowable	Throwable
    //   206	391	9	localFile2	File
    //   286	17	10	localFile3	File
    // Exception table:
    //   from	to	target	type
    //   46	55	167	java/lang/Throwable
    //   59	72	167	java/lang/Throwable
    //   77	110	167	java/lang/Throwable
    //   151	164	167	java/lang/Throwable
    //   211	217	430	java/io/IOException
    //   221	227	430	java/io/IOException
    //   227	235	430	java/io/IOException
    //   244	253	430	java/io/IOException
    //   257	263	430	java/io/IOException
    //   266	308	430	java/io/IOException
    //   317	335	430	java/io/IOException
    //   340	384	430	java/io/IOException
    //   395	401	430	java/io/IOException
    //   405	427	430	java/io/IOException
    //   211	217	525	java/lang/Exception
    //   221	227	525	java/lang/Exception
    //   227	235	525	java/lang/Exception
    //   244	253	525	java/lang/Exception
    //   257	263	525	java/lang/Exception
    //   266	308	525	java/lang/Exception
    //   340	384	525	java/lang/Exception
    //   395	401	525	java/lang/Exception
    //   405	427	525	java/lang/Exception
    //   211	217	613	finally
    //   221	227	613	finally
    //   227	235	613	finally
    //   244	253	613	finally
    //   257	263	613	finally
    //   266	308	613	finally
    //   317	335	613	finally
    //   340	384	613	finally
    //   395	401	613	finally
    //   405	427	613	finally
    //   431	452	613	finally
    //   457	463	613	finally
    //   526	547	613	finally
    //   552	558	613	finally
    //   481	515	624	java/lang/Throwable
    //   576	610	656	java/lang/Throwable
    //   317	335	688	java/lang/Exception
  }
  
  /* Error */
  public void changeTbsConfForSendRequest(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: new 440	java/io/File
    //   7: dup
    //   8: aload_0
    //   9: aload_1
    //   10: invokevirtual 667	com/tencent/smtt/sdk/TbsInstaller:getTbsCoreShareDir	(Landroid/content/Context;)Ljava/io/File;
    //   13: ldc 167
    //   15: invokespecial 449	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   18: astore 5
    //   20: new 708	java/util/Properties
    //   23: dup
    //   24: invokespecial 709	java/util/Properties:<init>	()V
    //   27: astore 4
    //   29: new 711	java/io/BufferedInputStream
    //   32: dup
    //   33: new 713	java/io/FileInputStream
    //   36: dup
    //   37: aload 5
    //   39: invokespecial 714	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   42: invokespecial 717	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   45: astore_1
    //   46: aload 4
    //   48: aload_1
    //   49: invokevirtual 720	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   52: new 1058	java/io/BufferedOutputStream
    //   55: dup
    //   56: new 482	java/io/FileOutputStream
    //   59: dup
    //   60: aload 5
    //   62: invokespecial 485	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   65: invokespecial 1061	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   68: astore_2
    //   69: aload 4
    //   71: ldc 189
    //   73: ldc_w 1490
    //   76: invokevirtual 1067	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   79: pop
    //   80: aload 4
    //   82: aload_2
    //   83: aconst_null
    //   84: invokevirtual 1071	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   87: aload_2
    //   88: ifnull +7 -> 95
    //   91: aload_2
    //   92: invokevirtual 1074	java/io/BufferedOutputStream:close	()V
    //   95: aload_1
    //   96: ifnull +7 -> 103
    //   99: aload_1
    //   100: invokevirtual 721	java/io/BufferedInputStream:close	()V
    //   103: return
    //   104: astore_1
    //   105: aconst_null
    //   106: astore_1
    //   107: aload_1
    //   108: ifnull +7 -> 115
    //   111: aload_1
    //   112: invokevirtual 1074	java/io/BufferedOutputStream:close	()V
    //   115: aload_2
    //   116: ifnull -13 -> 103
    //   119: aload_2
    //   120: invokevirtual 721	java/io/BufferedInputStream:close	()V
    //   123: return
    //   124: astore_1
    //   125: return
    //   126: astore_2
    //   127: aconst_null
    //   128: astore_1
    //   129: aload_3
    //   130: ifnull +7 -> 137
    //   133: aload_3
    //   134: invokevirtual 1074	java/io/BufferedOutputStream:close	()V
    //   137: aload_1
    //   138: ifnull +7 -> 145
    //   141: aload_1
    //   142: invokevirtual 721	java/io/BufferedInputStream:close	()V
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
    if (TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_downloaddecouplecore", 0) != 1)
    {
      TbsCoreVerManager.getInstance(paramContext).setTbsCoreInstallStatus(0, -1);
      TbsCoreVerManager.getInstance(paramContext).setTbsApkPath("");
      TbsCoreVerManager.getInstance(paramContext).setStatus("copy_retry_num", 0);
      TbsCoreVerManager.getInstance(paramContext).setTbsCoreIncrUpdateStatus(-1);
      TbsCoreVerManager.getInstance(paramContext).setTbsCoreCopyStatus(0, -1);
      FileUtil.delete(getTmpTbsCoreUnzipDir(paramContext), true);
      FileUtil.delete(getTmpTbsCoreCopyDir(paramContext), true);
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
      if ((n == 0) && (i1 != 0))
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
      FileUtil.copyFiles(localFile1, localFile2, new FileFilter()
      {
        public boolean accept(File paramAnonymousFile)
        {
          return (!paramAnonymousFile.getName().endsWith(".dex")) && (!paramAnonymousFile.getName().endsWith(".jar_is_first_load_dex_flag_file"));
        }
      });
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
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: aload_2
    //   7: invokestatic 892	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10: ifeq +8 -> 18
    //   13: aload 6
    //   15: astore_2
    //   16: aload_2
    //   17: areturn
    //   18: new 440	java/io/File
    //   21: dup
    //   22: aload_0
    //   23: aload_1
    //   24: invokevirtual 667	com/tencent/smtt/sdk/TbsInstaller:getTbsCoreShareDir	(Landroid/content/Context;)Ljava/io/File;
    //   27: ldc 167
    //   29: invokespecial 449	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   32: astore 4
    //   34: aload 4
    //   36: ifnull +13 -> 49
    //   39: aload 4
    //   41: invokevirtual 453	java/io/File:exists	()Z
    //   44: istore_3
    //   45: iload_3
    //   46: ifne +24 -> 70
    //   49: aload 6
    //   51: astore_2
    //   52: iconst_0
    //   53: ifeq -37 -> 16
    //   56: aload 5
    //   58: astore_2
    //   59: new 1155	java/lang/NullPointerException
    //   62: dup
    //   63: invokespecial 1156	java/lang/NullPointerException:<init>	()V
    //   66: athrow
    //   67: astore_1
    //   68: aload_2
    //   69: areturn
    //   70: new 708	java/util/Properties
    //   73: dup
    //   74: invokespecial 709	java/util/Properties:<init>	()V
    //   77: astore_1
    //   78: new 711	java/io/BufferedInputStream
    //   81: dup
    //   82: new 713	java/io/FileInputStream
    //   85: dup
    //   86: aload 4
    //   88: invokespecial 714	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   91: invokespecial 717	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   94: astore 4
    //   96: aload_1
    //   97: aload 4
    //   99: invokevirtual 720	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   102: aload 4
    //   104: invokevirtual 721	java/io/BufferedInputStream:close	()V
    //   107: aload_1
    //   108: aload_2
    //   109: invokevirtual 1157	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   112: astore_1
    //   113: aload_1
    //   114: astore_2
    //   115: aload 4
    //   117: ifnull -101 -> 16
    //   120: aload_1
    //   121: astore_2
    //   122: aload 4
    //   124: invokevirtual 721	java/io/BufferedInputStream:close	()V
    //   127: aload_1
    //   128: areturn
    //   129: astore_1
    //   130: aconst_null
    //   131: astore 4
    //   133: aload 4
    //   135: ifnull +8 -> 143
    //   138: aload 4
    //   140: invokevirtual 721	java/io/BufferedInputStream:close	()V
    //   143: aload_1
    //   144: athrow
    //   145: astore_1
    //   146: aconst_null
    //   147: astore 4
    //   149: aload 6
    //   151: astore_2
    //   152: aload 4
    //   154: ifnull -138 -> 16
    //   157: aload 5
    //   159: astore_2
    //   160: aload 4
    //   162: invokevirtual 721	java/io/BufferedInputStream:close	()V
    //   165: aconst_null
    //   166: areturn
    //   167: astore_2
    //   168: goto -25 -> 143
    //   171: astore_1
    //   172: goto -39 -> 133
    //   175: astore_1
    //   176: goto -27 -> 149
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	179	0	this	TbsInstaller
    //   0	179	1	paramContext	Context
    //   0	179	2	paramString	String
    //   44	2	3	bool	boolean
    //   32	129	4	localObject1	Object
    //   1	157	5	localObject2	Object
    //   4	146	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   59	67	67	java/io/IOException
    //   122	127	67	java/io/IOException
    //   160	165	67	java/io/IOException
    //   18	34	129	finally
    //   39	45	129	finally
    //   70	96	129	finally
    //   18	34	145	java/lang/Exception
    //   39	45	145	java/lang/Exception
    //   70	96	145	java/lang/Exception
    //   138	143	167	java/io/IOException
    //   96	113	171	finally
    //   96	113	175	java/lang/Exception
  }
  
  File getCoreShareDecoupleDir(Context paramContext)
  {
    paramContext = new File(paramContext.getDir("tbs", 0), "core_share_decouple");
    if ((paramContext == null) || ((!paramContext.isDirectory()) && (!paramContext.mkdir()))) {
      return null;
    }
    return paramContext;
  }
  
  File getCoreShareDecoupleDir(Context paramContext1, Context paramContext2)
  {
    paramContext2 = new File(paramContext2.getDir("tbs", 0), "core_share_decouple");
    if ((paramContext2 == null) || ((!paramContext2.isDirectory()) && ((paramContext1 == null) || (!TbsShareManager.isThirdPartyApp(paramContext1))) && (!paramContext2.mkdir()))) {
      return null;
    }
    return paramContext2;
  }
  
  /* Error */
  int getTbsCoreInstalledVer(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 553	com/tencent/smtt/sdk/TbsInstaller:getTbsInstallingFileLock	(Landroid/content/Context;)Z
    //   5: ifne +5 -> 10
    //   8: iconst_m1
    //   9: ireturn
    //   10: getstatic 279	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   13: invokeinterface 558 1 0
    //   18: istore_3
    //   19: ldc 164
    //   21: new 459	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 460	java/lang/StringBuilder:<init>	()V
    //   28: ldc_w 1538
    //   31: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: iload_3
    //   35: invokevirtual 563	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   38: invokevirtual 470	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 397	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   44: iload_3
    //   45: ifeq +287 -> 332
    //   48: new 440	java/io/File
    //   51: dup
    //   52: aload_0
    //   53: aload_1
    //   54: invokevirtual 667	com/tencent/smtt/sdk/TbsInstaller:getTbsCoreShareDir	(Landroid/content/Context;)Ljava/io/File;
    //   57: ldc 167
    //   59: invokespecial 449	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   62: astore_1
    //   63: aload_1
    //   64: ifnull +12 -> 76
    //   67: aload_1
    //   68: invokevirtual 453	java/io/File:exists	()Z
    //   71: istore_3
    //   72: iload_3
    //   73: ifne +29 -> 102
    //   76: iconst_0
    //   77: ifeq +11 -> 88
    //   80: new 1155	java/lang/NullPointerException
    //   83: dup
    //   84: invokespecial 1156	java/lang/NullPointerException:<init>	()V
    //   87: athrow
    //   88: getstatic 279	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   91: invokeinterface 589 1 0
    //   96: aload_0
    //   97: invokevirtual 592	com/tencent/smtt/sdk/TbsInstaller:releaseTbsInstallingFileLock	()V
    //   100: iconst_0
    //   101: ireturn
    //   102: new 708	java/util/Properties
    //   105: dup
    //   106: invokespecial 709	java/util/Properties:<init>	()V
    //   109: astore 5
    //   111: new 711	java/io/BufferedInputStream
    //   114: dup
    //   115: new 713	java/io/FileInputStream
    //   118: dup
    //   119: aload_1
    //   120: invokespecial 714	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   123: invokespecial 717	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   126: astore 4
    //   128: aload 4
    //   130: astore_1
    //   131: aload 5
    //   133: aload 4
    //   135: invokevirtual 720	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   138: aload 4
    //   140: astore_1
    //   141: aload 4
    //   143: invokevirtual 721	java/io/BufferedInputStream:close	()V
    //   146: aload 4
    //   148: astore_1
    //   149: aload 5
    //   151: ldc 176
    //   153: invokevirtual 1157	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   156: astore 5
    //   158: aload 5
    //   160: ifnonnull +27 -> 187
    //   163: aload 4
    //   165: ifnull +8 -> 173
    //   168: aload 4
    //   170: invokevirtual 721	java/io/BufferedInputStream:close	()V
    //   173: getstatic 279	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   176: invokeinterface 589 1 0
    //   181: aload_0
    //   182: invokevirtual 592	com/tencent/smtt/sdk/TbsInstaller:releaseTbsInstallingFileLock	()V
    //   185: iconst_0
    //   186: ireturn
    //   187: aload 4
    //   189: astore_1
    //   190: getstatic 286	com/tencent/smtt/sdk/TbsInstaller:mTbsCoreInstalledVer	Ljava/lang/ThreadLocal;
    //   193: aload 5
    //   195: invokestatic 1541	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   198: invokestatic 1100	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   201: invokevirtual 1106	java/lang/ThreadLocal:set	(Ljava/lang/Object;)V
    //   204: aload 4
    //   206: astore_1
    //   207: getstatic 286	com/tencent/smtt/sdk/TbsInstaller:mTbsCoreInstalledVer	Ljava/lang/ThreadLocal;
    //   210: invokevirtual 1545	java/lang/ThreadLocal:get	()Ljava/lang/Object;
    //   213: checkcast 1097	java/lang/Integer
    //   216: invokevirtual 1548	java/lang/Integer:intValue	()I
    //   219: istore_2
    //   220: aload 4
    //   222: ifnull +8 -> 230
    //   225: aload 4
    //   227: invokevirtual 721	java/io/BufferedInputStream:close	()V
    //   230: getstatic 279	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   233: invokeinterface 589 1 0
    //   238: aload_0
    //   239: invokevirtual 592	com/tencent/smtt/sdk/TbsInstaller:releaseTbsInstallingFileLock	()V
    //   242: iload_2
    //   243: ireturn
    //   244: astore 5
    //   246: aconst_null
    //   247: astore 4
    //   249: aload 4
    //   251: astore_1
    //   252: ldc 164
    //   254: new 459	java/lang/StringBuilder
    //   257: dup
    //   258: invokespecial 460	java/lang/StringBuilder:<init>	()V
    //   261: ldc_w 1550
    //   264: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: aload 5
    //   269: invokevirtual 747	java/lang/Exception:toString	()Ljava/lang/String;
    //   272: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: invokevirtual 470	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   278: invokestatic 397	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   281: aload 4
    //   283: ifnull +8 -> 291
    //   286: aload 4
    //   288: invokevirtual 721	java/io/BufferedInputStream:close	()V
    //   291: getstatic 279	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   294: invokeinterface 589 1 0
    //   299: aload_0
    //   300: invokevirtual 592	com/tencent/smtt/sdk/TbsInstaller:releaseTbsInstallingFileLock	()V
    //   303: iconst_0
    //   304: ireturn
    //   305: astore 4
    //   307: aconst_null
    //   308: astore_1
    //   309: aload_1
    //   310: ifnull +7 -> 317
    //   313: aload_1
    //   314: invokevirtual 721	java/io/BufferedInputStream:close	()V
    //   317: getstatic 279	com/tencent/smtt/sdk/TbsInstaller:mTbsRenameLock	Ljava/util/concurrent/locks/Lock;
    //   320: invokeinterface 589 1 0
    //   325: aload_0
    //   326: invokevirtual 592	com/tencent/smtt/sdk/TbsInstaller:releaseTbsInstallingFileLock	()V
    //   329: aload 4
    //   331: athrow
    //   332: aload_0
    //   333: invokevirtual 592	com/tencent/smtt/sdk/TbsInstaller:releaseTbsInstallingFileLock	()V
    //   336: iconst_0
    //   337: ireturn
    //   338: astore_1
    //   339: ldc 164
    //   341: new 459	java/lang/StringBuilder
    //   344: dup
    //   345: invokespecial 460	java/lang/StringBuilder:<init>	()V
    //   348: ldc_w 1552
    //   351: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: aload_1
    //   355: invokevirtual 1553	java/io/IOException:toString	()Ljava/lang/String;
    //   358: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: invokevirtual 470	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   364: invokestatic 397	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   367: goto -50 -> 317
    //   370: astore_1
    //   371: ldc 164
    //   373: new 459	java/lang/StringBuilder
    //   376: dup
    //   377: invokespecial 460	java/lang/StringBuilder:<init>	()V
    //   380: ldc_w 1552
    //   383: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: aload_1
    //   387: invokevirtual 1553	java/io/IOException:toString	()Ljava/lang/String;
    //   390: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: invokevirtual 470	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   396: invokestatic 397	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   399: goto -108 -> 291
    //   402: astore_1
    //   403: ldc 164
    //   405: new 459	java/lang/StringBuilder
    //   408: dup
    //   409: invokespecial 460	java/lang/StringBuilder:<init>	()V
    //   412: ldc_w 1552
    //   415: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: aload_1
    //   419: invokevirtual 1553	java/io/IOException:toString	()Ljava/lang/String;
    //   422: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: invokevirtual 470	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   428: invokestatic 397	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   431: goto -343 -> 88
    //   434: astore_1
    //   435: ldc 164
    //   437: new 459	java/lang/StringBuilder
    //   440: dup
    //   441: invokespecial 460	java/lang/StringBuilder:<init>	()V
    //   444: ldc_w 1552
    //   447: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: aload_1
    //   451: invokevirtual 1553	java/io/IOException:toString	()Ljava/lang/String;
    //   454: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: invokevirtual 470	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   460: invokestatic 397	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   463: goto -290 -> 173
    //   466: astore_1
    //   467: ldc 164
    //   469: new 459	java/lang/StringBuilder
    //   472: dup
    //   473: invokespecial 460	java/lang/StringBuilder:<init>	()V
    //   476: ldc_w 1552
    //   479: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: aload_1
    //   483: invokevirtual 1553	java/io/IOException:toString	()Ljava/lang/String;
    //   486: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: invokevirtual 470	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   492: invokestatic 397	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   495: goto -265 -> 230
    //   498: astore 4
    //   500: goto -191 -> 309
    //   503: astore 5
    //   505: goto -256 -> 249
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	508	0	this	TbsInstaller
    //   0	508	1	paramContext	Context
    //   219	24	2	i	int
    //   18	55	3	bool	boolean
    //   126	161	4	localBufferedInputStream	java.io.BufferedInputStream
    //   305	25	4	localObject1	Object
    //   498	1	4	localObject2	Object
    //   109	85	5	localObject3	Object
    //   244	24	5	localException1	Exception
    //   503	1	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   48	63	244	java/lang/Exception
    //   67	72	244	java/lang/Exception
    //   102	128	244	java/lang/Exception
    //   48	63	305	finally
    //   67	72	305	finally
    //   102	128	305	finally
    //   313	317	338	java/io/IOException
    //   286	291	370	java/io/IOException
    //   80	88	402	java/io/IOException
    //   168	173	434	java/io/IOException
    //   225	230	466	java/io/IOException
    //   131	138	498	finally
    //   141	146	498	finally
    //   149	158	498	finally
    //   190	204	498	finally
    //   207	220	498	finally
    //   252	281	498	finally
    //   131	138	503	java/lang/Exception
    //   141	146	503	java/lang/Exception
    //   149	158	503	java/lang/Exception
    //   190	204	503	java/lang/Exception
    //   207	220	503	java/lang/Exception
  }
  
  /* Error */
  int getTbsCoreInstalledVerInNolock(Context paramContext)
  {
    // Byte code:
    //   0: new 440	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: aload_1
    //   6: invokevirtual 667	com/tencent/smtt/sdk/TbsInstaller:getTbsCoreShareDir	(Landroid/content/Context;)Ljava/io/File;
    //   9: ldc 167
    //   11: invokespecial 449	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   14: astore_1
    //   15: aload_1
    //   16: ifnull +12 -> 28
    //   19: aload_1
    //   20: invokevirtual 453	java/io/File:exists	()Z
    //   23: istore_3
    //   24: iload_3
    //   25: ifne +17 -> 42
    //   28: iconst_0
    //   29: ifeq +11 -> 40
    //   32: new 1155	java/lang/NullPointerException
    //   35: dup
    //   36: invokespecial 1156	java/lang/NullPointerException:<init>	()V
    //   39: athrow
    //   40: iconst_0
    //   41: ireturn
    //   42: new 708	java/util/Properties
    //   45: dup
    //   46: invokespecial 709	java/util/Properties:<init>	()V
    //   49: astore 5
    //   51: new 711	java/io/BufferedInputStream
    //   54: dup
    //   55: new 713	java/io/FileInputStream
    //   58: dup
    //   59: aload_1
    //   60: invokespecial 714	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   63: invokespecial 717	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   66: astore 4
    //   68: aload 4
    //   70: astore_1
    //   71: aload 5
    //   73: aload 4
    //   75: invokevirtual 720	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   78: aload 4
    //   80: astore_1
    //   81: aload 4
    //   83: invokevirtual 721	java/io/BufferedInputStream:close	()V
    //   86: aload 4
    //   88: astore_1
    //   89: aload 5
    //   91: ldc 176
    //   93: invokevirtual 1157	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   96: astore 5
    //   98: aload 5
    //   100: ifnonnull +48 -> 148
    //   103: aload 4
    //   105: ifnull -65 -> 40
    //   108: aload 4
    //   110: invokevirtual 721	java/io/BufferedInputStream:close	()V
    //   113: iconst_0
    //   114: ireturn
    //   115: astore_1
    //   116: new 459	java/lang/StringBuilder
    //   119: dup
    //   120: invokespecial 460	java/lang/StringBuilder:<init>	()V
    //   123: ldc_w 1555
    //   126: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: aload_1
    //   130: invokevirtual 1553	java/io/IOException:toString	()Ljava/lang/String;
    //   133: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: invokevirtual 470	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: astore_1
    //   140: ldc 164
    //   142: aload_1
    //   143: invokestatic 397	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   146: iconst_0
    //   147: ireturn
    //   148: aload 4
    //   150: astore_1
    //   151: aload 5
    //   153: invokestatic 1541	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   156: istore_2
    //   157: aload 4
    //   159: astore_1
    //   160: getstatic 317	com/tencent/smtt/sdk/TbsInstaller:mCoreVersion	I
    //   163: ifne +10 -> 173
    //   166: aload 4
    //   168: astore_1
    //   169: iload_2
    //   170: putstatic 317	com/tencent/smtt/sdk/TbsInstaller:mCoreVersion	I
    //   173: aload 4
    //   175: ifnull +8 -> 183
    //   178: aload 4
    //   180: invokevirtual 721	java/io/BufferedInputStream:close	()V
    //   183: iload_2
    //   184: ireturn
    //   185: astore 5
    //   187: aconst_null
    //   188: astore 4
    //   190: aload 4
    //   192: astore_1
    //   193: ldc 164
    //   195: new 459	java/lang/StringBuilder
    //   198: dup
    //   199: invokespecial 460	java/lang/StringBuilder:<init>	()V
    //   202: ldc_w 1557
    //   205: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: aload 5
    //   210: invokevirtual 747	java/lang/Exception:toString	()Ljava/lang/String;
    //   213: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: invokevirtual 470	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokestatic 397	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   222: aload 4
    //   224: ifnull -184 -> 40
    //   227: aload 4
    //   229: invokevirtual 721	java/io/BufferedInputStream:close	()V
    //   232: iconst_0
    //   233: ireturn
    //   234: astore_1
    //   235: new 459	java/lang/StringBuilder
    //   238: dup
    //   239: invokespecial 460	java/lang/StringBuilder:<init>	()V
    //   242: ldc_w 1555
    //   245: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: aload_1
    //   249: invokevirtual 1553	java/io/IOException:toString	()Ljava/lang/String;
    //   252: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: invokevirtual 470	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: astore_1
    //   259: goto -119 -> 140
    //   262: astore 4
    //   264: aconst_null
    //   265: astore_1
    //   266: aload_1
    //   267: ifnull +7 -> 274
    //   270: aload_1
    //   271: invokevirtual 721	java/io/BufferedInputStream:close	()V
    //   274: aload 4
    //   276: athrow
    //   277: astore_1
    //   278: ldc 164
    //   280: new 459	java/lang/StringBuilder
    //   283: dup
    //   284: invokespecial 460	java/lang/StringBuilder:<init>	()V
    //   287: ldc_w 1555
    //   290: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: aload_1
    //   294: invokevirtual 1553	java/io/IOException:toString	()Ljava/lang/String;
    //   297: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: invokevirtual 470	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: invokestatic 397	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   306: goto -32 -> 274
    //   309: astore_1
    //   310: new 459	java/lang/StringBuilder
    //   313: dup
    //   314: invokespecial 460	java/lang/StringBuilder:<init>	()V
    //   317: ldc_w 1555
    //   320: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: aload_1
    //   324: invokevirtual 1553	java/io/IOException:toString	()Ljava/lang/String;
    //   327: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: invokevirtual 470	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   333: astore_1
    //   334: goto -194 -> 140
    //   337: astore_1
    //   338: ldc 164
    //   340: new 459	java/lang/StringBuilder
    //   343: dup
    //   344: invokespecial 460	java/lang/StringBuilder:<init>	()V
    //   347: ldc_w 1555
    //   350: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: aload_1
    //   354: invokevirtual 1553	java/io/IOException:toString	()Ljava/lang/String;
    //   357: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: invokevirtual 470	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   363: invokestatic 397	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   366: goto -183 -> 183
    //   369: astore 4
    //   371: goto -105 -> 266
    //   374: astore 5
    //   376: goto -186 -> 190
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	379	0	this	TbsInstaller
    //   0	379	1	paramContext	Context
    //   156	28	2	i	int
    //   23	2	3	bool	boolean
    //   66	162	4	localBufferedInputStream	java.io.BufferedInputStream
    //   262	13	4	localObject1	Object
    //   369	1	4	localObject2	Object
    //   49	103	5	localObject3	Object
    //   185	24	5	localException1	Exception
    //   374	1	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   108	113	115	java/io/IOException
    //   0	15	185	java/lang/Exception
    //   19	24	185	java/lang/Exception
    //   42	68	185	java/lang/Exception
    //   227	232	234	java/io/IOException
    //   0	15	262	finally
    //   19	24	262	finally
    //   42	68	262	finally
    //   270	274	277	java/io/IOException
    //   32	40	309	java/io/IOException
    //   178	183	337	java/io/IOException
    //   71	78	369	finally
    //   81	86	369	finally
    //   89	98	369	finally
    //   151	157	369	finally
    //   160	166	369	finally
    //   169	173	369	finally
    //   193	222	369	finally
    //   71	78	374	java/lang/Exception
    //   81	86	374	java/lang/Exception
    //   89	98	374	java/lang/Exception
    //   151	157	374	java/lang/Exception
    //   160	166	374	java/lang/Exception
    //   169	173	374	java/lang/Exception
  }
  
  int getTbsCoreInstalledVerInNolockForCrash(Context paramContext)
  {
    if (mCoreVersion != 0) {
      return mCoreVersion;
    }
    return getTbsCoreInstalledVerInNolock(paramContext);
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
    //   2: iconst_0
    //   3: istore_3
    //   4: aconst_null
    //   5: astore 6
    //   7: new 440	java/io/File
    //   10: dup
    //   11: aload_0
    //   12: aload_1
    //   13: invokevirtual 670	com/tencent/smtt/sdk/TbsInstaller:getCoreShareDecoupleDir	(Landroid/content/Context;)Ljava/io/File;
    //   16: ldc 167
    //   18: invokespecial 449	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   21: astore_1
    //   22: aload_1
    //   23: ifnull +14 -> 37
    //   26: aload_1
    //   27: invokevirtual 453	java/io/File:exists	()Z
    //   30: istore 5
    //   32: iload 5
    //   34: ifne +19 -> 53
    //   37: iconst_0
    //   38: ifeq +13 -> 51
    //   41: iload_2
    //   42: istore_3
    //   43: new 1155	java/lang/NullPointerException
    //   46: dup
    //   47: invokespecial 1156	java/lang/NullPointerException:<init>	()V
    //   50: athrow
    //   51: iload_3
    //   52: ireturn
    //   53: new 708	java/util/Properties
    //   56: dup
    //   57: invokespecial 709	java/util/Properties:<init>	()V
    //   60: astore 7
    //   62: new 711	java/io/BufferedInputStream
    //   65: dup
    //   66: new 713	java/io/FileInputStream
    //   69: dup
    //   70: aload_1
    //   71: invokespecial 714	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   74: invokespecial 717	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   77: astore_1
    //   78: aload 7
    //   80: aload_1
    //   81: invokevirtual 720	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   84: aload_1
    //   85: invokevirtual 721	java/io/BufferedInputStream:close	()V
    //   88: aload 7
    //   90: ldc 176
    //   92: invokevirtual 1157	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   95: astore 6
    //   97: aload 6
    //   99: ifnonnull +18 -> 117
    //   102: aload_1
    //   103: ifnull -52 -> 51
    //   106: iload_2
    //   107: istore_3
    //   108: aload_1
    //   109: invokevirtual 721	java/io/BufferedInputStream:close	()V
    //   112: iconst_0
    //   113: ireturn
    //   114: astore_1
    //   115: iload_3
    //   116: ireturn
    //   117: aload 6
    //   119: invokestatic 1541	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   122: istore 4
    //   124: iload 4
    //   126: istore_2
    //   127: iload_2
    //   128: istore_3
    //   129: aload_1
    //   130: ifnull -79 -> 51
    //   133: iload_2
    //   134: istore_3
    //   135: aload_1
    //   136: invokevirtual 721	java/io/BufferedInputStream:close	()V
    //   139: iload_2
    //   140: ireturn
    //   141: astore_1
    //   142: aload 6
    //   144: ifnull +8 -> 152
    //   147: aload 6
    //   149: invokevirtual 721	java/io/BufferedInputStream:close	()V
    //   152: aload_1
    //   153: athrow
    //   154: astore_1
    //   155: aconst_null
    //   156: astore_1
    //   157: aload_1
    //   158: ifnull -107 -> 51
    //   161: iload_2
    //   162: istore_3
    //   163: aload_1
    //   164: invokevirtual 721	java/io/BufferedInputStream:close	()V
    //   167: iconst_0
    //   168: ireturn
    //   169: astore 6
    //   171: goto -19 -> 152
    //   174: astore 7
    //   176: aload_1
    //   177: astore 6
    //   179: aload 7
    //   181: astore_1
    //   182: goto -40 -> 142
    //   185: astore 6
    //   187: goto -30 -> 157
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	this	TbsInstaller
    //   0	190	1	paramContext	Context
    //   1	161	2	i	int
    //   3	160	3	j	int
    //   122	3	4	k	int
    //   30	3	5	bool	boolean
    //   5	143	6	str	String
    //   169	1	6	localIOException	java.io.IOException
    //   177	1	6	localContext	Context
    //   185	1	6	localException	Exception
    //   60	29	7	localProperties	java.util.Properties
    //   174	6	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   43	51	114	java/io/IOException
    //   108	112	114	java/io/IOException
    //   135	139	114	java/io/IOException
    //   163	167	114	java/io/IOException
    //   7	22	141	finally
    //   26	32	141	finally
    //   53	78	141	finally
    //   7	22	154	java/lang/Exception
    //   26	32	154	java/lang/Exception
    //   53	78	154	java/lang/Exception
    //   147	152	169	java/io/IOException
    //   78	97	174	finally
    //   117	124	174	finally
    //   78	97	185	java/lang/Exception
    //   117	124	185	java/lang/Exception
  }
  
  File getTbsCoreShareDir(Context paramContext)
  {
    return getTbsCoreShareDir(null, paramContext);
  }
  
  File getTbsCoreShareDir(Context paramContext1, Context paramContext2)
  {
    paramContext2 = new File(paramContext2.getDir("tbs", 0), "core_share");
    if ((paramContext2 == null) || ((!paramContext2.isDirectory()) && ((paramContext1 == null) || (!TbsShareManager.isThirdPartyApp(paramContext1))) && (!paramContext2.mkdir()))) {
      return null;
    }
    return paramContext2;
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
    //   2: iconst_0
    //   3: istore 4
    //   5: aload_1
    //   6: ifnonnull +8 -> 14
    //   9: iload 4
    //   11: istore_3
    //   12: iload_3
    //   13: ireturn
    //   14: aconst_null
    //   15: astore 6
    //   17: new 440	java/io/File
    //   20: dup
    //   21: new 440	java/io/File
    //   24: dup
    //   25: aload_1
    //   26: invokespecial 1047	java/io/File:<init>	(Ljava/lang/String;)V
    //   29: ldc 167
    //   31: invokespecial 449	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   34: astore_1
    //   35: aload_1
    //   36: ifnull +14 -> 50
    //   39: aload_1
    //   40: invokevirtual 453	java/io/File:exists	()Z
    //   43: istore 5
    //   45: iload 5
    //   47: ifne +23 -> 70
    //   50: iload 4
    //   52: istore_3
    //   53: iconst_0
    //   54: ifeq -42 -> 12
    //   57: iload_2
    //   58: istore_3
    //   59: new 1155	java/lang/NullPointerException
    //   62: dup
    //   63: invokespecial 1156	java/lang/NullPointerException:<init>	()V
    //   66: athrow
    //   67: astore_1
    //   68: iload_3
    //   69: ireturn
    //   70: new 708	java/util/Properties
    //   73: dup
    //   74: invokespecial 709	java/util/Properties:<init>	()V
    //   77: astore 7
    //   79: new 711	java/io/BufferedInputStream
    //   82: dup
    //   83: new 713	java/io/FileInputStream
    //   86: dup
    //   87: aload_1
    //   88: invokespecial 714	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   91: invokespecial 717	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   94: astore_1
    //   95: aload 7
    //   97: aload_1
    //   98: invokevirtual 720	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   101: aload_1
    //   102: invokevirtual 721	java/io/BufferedInputStream:close	()V
    //   105: aload 7
    //   107: ldc 176
    //   109: invokevirtual 1157	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   112: astore 6
    //   114: aload 6
    //   116: ifnonnull +18 -> 134
    //   119: iload 4
    //   121: istore_3
    //   122: aload_1
    //   123: ifnull -111 -> 12
    //   126: iload_2
    //   127: istore_3
    //   128: aload_1
    //   129: invokevirtual 721	java/io/BufferedInputStream:close	()V
    //   132: iconst_0
    //   133: ireturn
    //   134: aload 6
    //   136: invokestatic 1541	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   139: istore_3
    //   140: iload_3
    //   141: istore_2
    //   142: iload_2
    //   143: istore_3
    //   144: aload_1
    //   145: ifnull -133 -> 12
    //   148: iload_2
    //   149: istore_3
    //   150: aload_1
    //   151: invokevirtual 721	java/io/BufferedInputStream:close	()V
    //   154: iload_2
    //   155: ireturn
    //   156: astore_1
    //   157: aload 6
    //   159: ifnull +8 -> 167
    //   162: aload 6
    //   164: invokevirtual 721	java/io/BufferedInputStream:close	()V
    //   167: aload_1
    //   168: athrow
    //   169: astore_1
    //   170: aconst_null
    //   171: astore_1
    //   172: iload 4
    //   174: istore_3
    //   175: aload_1
    //   176: ifnull -164 -> 12
    //   179: iload_2
    //   180: istore_3
    //   181: aload_1
    //   182: invokevirtual 721	java/io/BufferedInputStream:close	()V
    //   185: iconst_0
    //   186: ireturn
    //   187: astore 6
    //   189: goto -22 -> 167
    //   192: astore 7
    //   194: aload_1
    //   195: astore 6
    //   197: aload 7
    //   199: astore_1
    //   200: goto -43 -> 157
    //   203: astore 6
    //   205: goto -33 -> 172
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	208	0	this	TbsInstaller
    //   0	208	1	paramString	String
    //   1	179	2	i	int
    //   11	170	3	j	int
    //   3	170	4	k	int
    //   43	3	5	bool	boolean
    //   15	148	6	str1	String
    //   187	1	6	localIOException	java.io.IOException
    //   195	1	6	str2	String
    //   203	1	6	localException	Exception
    //   77	29	7	localProperties	java.util.Properties
    //   192	6	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   59	67	67	java/io/IOException
    //   128	132	67	java/io/IOException
    //   150	154	67	java/io/IOException
    //   181	185	67	java/io/IOException
    //   17	35	156	finally
    //   39	45	156	finally
    //   70	95	156	finally
    //   17	35	169	java/lang/Exception
    //   39	45	169	java/lang/Exception
    //   70	95	169	java/lang/Exception
    //   162	167	187	java/io/IOException
    //   95	114	192	finally
    //   134	140	192	finally
    //   95	114	203	java/lang/Exception
    //   134	140	203	java/lang/Exception
  }
  
  boolean getTbsInstallingFileLock(Context paramContext)
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        this.currentTbsFileLockStackCount += 1;
        if (this.isGetTbsInstallingSuccess)
        {
          TbsLog.i("TbsInstaller", "getTbsInstallingFileLock success,is cached= true");
          return bool;
        }
        this.tbsInstallingFos = FileUtil.getLockFos(paramContext, true, "tbslock.txt");
        if (this.tbsInstallingFos != null)
        {
          this.tbsFileLockFileLock = FileUtil.tryFileLock(paramContext, this.tbsInstallingFos);
          if (this.tbsFileLockFileLock == null)
          {
            bool = false;
          }
          else
          {
            TbsLog.i("TbsInstaller", "getTbsInstallingFileLock success,is cached= false");
            this.isGetTbsInstallingSuccess = true;
          }
        }
        else
        {
          bool = false;
        }
      }
      finally {}
    }
  }
  
  File getTbsShareDir(Context paramContext)
  {
    paramContext = new File(paramContext.getDir("tbs", 0), "share");
    if ((paramContext == null) || ((!paramContext.isDirectory()) && (!paramContext.mkdir()))) {
      return null;
    }
    return paramContext;
  }
  
  File getTmpTbsCoreCopyDir(Context paramContext)
  {
    paramContext = new File(paramContext.getDir("tbs", 0), "core_copy_tmp");
    if ((paramContext == null) || ((!paramContext.isDirectory()) && (!paramContext.mkdir()))) {
      return null;
    }
    return paramContext;
  }
  
  File getTmpTbsCoreDecoupleUnzipDir(Context paramContext)
  {
    paramContext = new File(paramContext.getDir("tbs", 0), "core_unzip_tmp_decouple");
    if ((paramContext == null) || ((!paramContext.isDirectory()) && (!paramContext.mkdir()))) {
      return null;
    }
    return paramContext;
  }
  
  File getTmpTbsCoreUnzipDir(Context paramContext)
  {
    paramContext = new File(paramContext.getDir("tbs", 0), "core_unzip_tmp");
    if ((paramContext == null) || ((!paramContext.isDirectory()) && (!paramContext.mkdir()))) {
      return null;
    }
    return paramContext;
  }
  
  /* Error */
  int getTmpTbsCoreVersionUnzipDir(Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iconst_0
    //   3: istore 4
    //   5: aconst_null
    //   6: astore 6
    //   8: aload_0
    //   9: aload_1
    //   10: invokevirtual 401	com/tencent/smtt/sdk/TbsInstaller:getTmpTbsCoreUnzipDir	(Landroid/content/Context;)Ljava/io/File;
    //   13: astore_1
    //   14: ldc 164
    //   16: new 459	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 460	java/lang/StringBuilder:<init>	()V
    //   23: ldc_w 1586
    //   26: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_1
    //   30: invokevirtual 857	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 470	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokestatic 397	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: new 440	java/io/File
    //   42: dup
    //   43: aload_1
    //   44: ldc 167
    //   46: invokespecial 449	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   49: astore_1
    //   50: aload_1
    //   51: ifnull +14 -> 65
    //   54: aload_1
    //   55: invokevirtual 453	java/io/File:exists	()Z
    //   58: istore 5
    //   60: iload 5
    //   62: ifne +22 -> 84
    //   65: iload 4
    //   67: istore_3
    //   68: iconst_0
    //   69: ifeq +13 -> 82
    //   72: iload_2
    //   73: istore_3
    //   74: new 1155	java/lang/NullPointerException
    //   77: dup
    //   78: invokespecial 1156	java/lang/NullPointerException:<init>	()V
    //   81: athrow
    //   82: iload_3
    //   83: ireturn
    //   84: new 708	java/util/Properties
    //   87: dup
    //   88: invokespecial 709	java/util/Properties:<init>	()V
    //   91: astore 7
    //   93: new 711	java/io/BufferedInputStream
    //   96: dup
    //   97: new 713	java/io/FileInputStream
    //   100: dup
    //   101: aload_1
    //   102: invokespecial 714	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   105: invokespecial 717	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   108: astore_1
    //   109: aload 7
    //   111: aload_1
    //   112: invokevirtual 720	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   115: aload_1
    //   116: invokevirtual 721	java/io/BufferedInputStream:close	()V
    //   119: aload 7
    //   121: ldc 176
    //   123: invokevirtual 1157	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   126: astore 6
    //   128: aload 6
    //   130: ifnonnull +21 -> 151
    //   133: iload 4
    //   135: istore_3
    //   136: aload_1
    //   137: ifnull -55 -> 82
    //   140: iload_2
    //   141: istore_3
    //   142: aload_1
    //   143: invokevirtual 721	java/io/BufferedInputStream:close	()V
    //   146: iconst_0
    //   147: ireturn
    //   148: astore_1
    //   149: iload_3
    //   150: ireturn
    //   151: aload 6
    //   153: invokestatic 1541	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   156: istore_3
    //   157: iload_3
    //   158: istore_2
    //   159: iload_2
    //   160: istore_3
    //   161: aload_1
    //   162: ifnull -80 -> 82
    //   165: iload_2
    //   166: istore_3
    //   167: aload_1
    //   168: invokevirtual 721	java/io/BufferedInputStream:close	()V
    //   171: iload_2
    //   172: ireturn
    //   173: astore_1
    //   174: aload 6
    //   176: ifnull +8 -> 184
    //   179: aload 6
    //   181: invokevirtual 721	java/io/BufferedInputStream:close	()V
    //   184: aload_1
    //   185: athrow
    //   186: astore_1
    //   187: aconst_null
    //   188: astore_1
    //   189: iload 4
    //   191: istore_3
    //   192: aload_1
    //   193: ifnull -111 -> 82
    //   196: iload_2
    //   197: istore_3
    //   198: aload_1
    //   199: invokevirtual 721	java/io/BufferedInputStream:close	()V
    //   202: iconst_0
    //   203: ireturn
    //   204: astore 6
    //   206: goto -22 -> 184
    //   209: astore 7
    //   211: aload_1
    //   212: astore 6
    //   214: aload 7
    //   216: astore_1
    //   217: goto -43 -> 174
    //   220: astore 6
    //   222: goto -33 -> 189
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	225	0	this	TbsInstaller
    //   0	225	1	paramContext	Context
    //   1	196	2	i	int
    //   67	131	3	j	int
    //   3	187	4	k	int
    //   58	3	5	bool	boolean
    //   6	174	6	str	String
    //   204	1	6	localIOException	java.io.IOException
    //   212	1	6	localContext	Context
    //   220	1	6	localException	Exception
    //   91	29	7	localProperties	java.util.Properties
    //   209	6	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   74	82	148	java/io/IOException
    //   142	146	148	java/io/IOException
    //   167	171	148	java/io/IOException
    //   198	202	148	java/io/IOException
    //   8	50	173	finally
    //   54	60	173	finally
    //   84	109	173	finally
    //   8	50	186	java/lang/Exception
    //   54	60	186	java/lang/Exception
    //   84	109	186	java/lang/Exception
    //   179	184	204	java/io/IOException
    //   109	128	209	finally
    //   151	157	209	finally
    //   109	128	220	java/lang/Exception
    //   151	157	220	java/lang/Exception
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
        Object localObject = new File(FileUtil.getTBSSdcardFilePath(paramContext, 4), "x5.tbs.decouple");
        File localFile1 = getInstance().getTmpTbsCoreDecoupleUnzipDir(paramContext);
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
          getInstance().setTmpFolderCoreToRead(paramContext, true);
          localObject = getCoreShareDecoupleDir(paramContext);
          FileUtil.delete((File)localObject, true);
          localFile1.renameTo((File)localObject);
          TbsShareManager.shareCoreShareDecouple(paramContext);
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
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 522	com/tencent/smtt/sdk/TbsInstaller:isTbsLocalInstalled	(Landroid/content/Context;)Z
    //   5: ifeq +14 -> 19
    //   8: aload_1
    //   9: invokestatic 516	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   12: sipush -539
    //   15: invokevirtual 519	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   18: return
    //   19: ldc 164
    //   21: ldc_w 1627
    //   24: invokestatic 397	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   27: aload_2
    //   28: ifnull -10 -> 18
    //   31: aload_1
    //   32: ifnull -14 -> 18
    //   35: aload_1
    //   36: invokestatic 615	com/tencent/smtt/utils/FileUtil:hasEnoughFreeSpace	(Landroid/content/Context;)Z
    //   39: ifne +70 -> 109
    //   42: invokestatic 621	com/tencent/smtt/utils/TbsUtils:getROMAvailableSize	()J
    //   45: lstore 5
    //   47: aload_1
    //   48: invokestatic 516	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   51: invokevirtual 624	com/tencent/smtt/sdk/TbsDownloadConfig:getDownloadMinFreeSpace	()J
    //   54: lstore 7
    //   56: aload_1
    //   57: invokestatic 629	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   60: sipush 210
    //   63: new 459	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 460	java/lang/StringBuilder:<init>	()V
    //   70: ldc_w 1629
    //   73: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: lload 5
    //   78: invokevirtual 634	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   81: ldc_w 636
    //   84: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: lload 7
    //   89: invokevirtual 634	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   92: invokevirtual 470	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokevirtual 640	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   98: aload_1
    //   99: invokestatic 516	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   102: sipush -540
    //   105: invokevirtual 519	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   108: return
    //   109: aload_0
    //   110: aload_1
    //   111: invokevirtual 553	com/tencent/smtt/sdk/TbsInstaller:getTbsInstallingFileLock	(Landroid/content/Context;)Z
    //   114: ifne +14 -> 128
    //   117: aload_1
    //   118: invokestatic 516	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   121: sipush -541
    //   124: invokevirtual 519	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   127: return
    //   128: getstatic 281	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   131: invokeinterface 558 1 0
    //   136: istore 9
    //   138: ldc 164
    //   140: new 459	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 460	java/lang/StringBuilder:<init>	()V
    //   147: ldc_w 1631
    //   150: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: iload 9
    //   155: invokevirtual 563	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   158: invokevirtual 470	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokestatic 397	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   164: iload 9
    //   166: ifeq +835 -> 1001
    //   169: aconst_null
    //   170: astore 11
    //   172: aconst_null
    //   173: astore 12
    //   175: aload 11
    //   177: astore 10
    //   179: iconst_1
    //   180: invokestatic 1635	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   183: aload 11
    //   185: astore 10
    //   187: aload_0
    //   188: aload_1
    //   189: invokevirtual 596	com/tencent/smtt/sdk/TbsInstaller:getTbsCoreInstalledVerInNolock	(Landroid/content/Context;)I
    //   192: ifle +18 -> 210
    //   195: aload 11
    //   197: astore 10
    //   199: aload_1
    //   200: invokestatic 412	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   203: invokevirtual 1414	com/tencent/smtt/sdk/TbsCoreVerManager:getTbsCoreIncrUpdateStatus	()I
    //   206: iconst_1
    //   207: if_icmpne +36 -> 243
    //   210: aload 11
    //   212: astore 10
    //   214: iconst_0
    //   215: invokestatic 1635	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   218: getstatic 281	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   221: invokeinterface 589 1 0
    //   226: aload_0
    //   227: invokevirtual 592	com/tencent/smtt/sdk/TbsInstaller:releaseTbsInstallingFileLock	()V
    //   230: ldc 164
    //   232: ldc_w 1637
    //   235: invokestatic 397	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   238: iconst_0
    //   239: invokestatic 1635	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   242: return
    //   243: aload 11
    //   245: astore 10
    //   247: aload_1
    //   248: invokestatic 516	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   251: getfield 649	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   254: ldc_w 1372
    //   257: iconst_0
    //   258: invokeinterface 546 3 0
    //   263: istore 4
    //   265: iload 4
    //   267: iconst_1
    //   268: if_icmpeq +960 -> 1228
    //   271: iload 4
    //   273: iconst_2
    //   274: if_icmpeq +954 -> 1228
    //   277: iload 4
    //   279: iconst_4
    //   280: if_icmpne +239 -> 519
    //   283: goto +945 -> 1228
    //   286: iload_3
    //   287: ifne +933 -> 1220
    //   290: iload 4
    //   292: ifeq +928 -> 1220
    //   295: aload 11
    //   297: astore 10
    //   299: aload_1
    //   300: invokestatic 412	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   303: ldc_w 1133
    //   306: invokevirtual 572	com/tencent/smtt/sdk/TbsCoreVerManager:getIntNum	(Ljava/lang/String;)I
    //   309: istore_3
    //   310: iload_3
    //   311: iconst_5
    //   312: if_icmple +212 -> 524
    //   315: aload 11
    //   317: astore 10
    //   319: ldc 164
    //   321: ldc_w 1639
    //   324: invokestatic 397	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   327: aload 11
    //   329: astore 10
    //   331: aload_2
    //   332: ldc 93
    //   334: invokevirtual 1237	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   337: astore 12
    //   339: aload 11
    //   341: astore 10
    //   343: aload_2
    //   344: ldc 87
    //   346: invokevirtual 1237	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   349: astore 13
    //   351: aload 11
    //   353: astore 10
    //   355: aload_2
    //   356: ldc 84
    //   358: invokevirtual 1237	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   361: astore_2
    //   362: aload 11
    //   364: astore 10
    //   366: aload 12
    //   368: invokestatic 892	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   371: ifne +19 -> 390
    //   374: aload 11
    //   376: astore 10
    //   378: new 440	java/io/File
    //   381: dup
    //   382: aload 12
    //   384: invokespecial 1047	java/io/File:<init>	(Ljava/lang/String;)V
    //   387: invokestatic 1449	com/tencent/smtt/utils/FileUtil:delete	(Ljava/io/File;)V
    //   390: aload 11
    //   392: astore 10
    //   394: aload 13
    //   396: invokestatic 892	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   399: ifne +19 -> 418
    //   402: aload 11
    //   404: astore 10
    //   406: new 440	java/io/File
    //   409: dup
    //   410: aload 13
    //   412: invokespecial 1047	java/io/File:<init>	(Ljava/lang/String;)V
    //   415: invokestatic 1449	com/tencent/smtt/utils/FileUtil:delete	(Ljava/io/File;)V
    //   418: aload 11
    //   420: astore 10
    //   422: aload_2
    //   423: invokestatic 892	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   426: ifne +18 -> 444
    //   429: aload 11
    //   431: astore 10
    //   433: new 440	java/io/File
    //   436: dup
    //   437: aload_2
    //   438: invokespecial 1047	java/io/File:<init>	(Ljava/lang/String;)V
    //   441: invokestatic 1449	com/tencent/smtt/utils/FileUtil:delete	(Ljava/io/File;)V
    //   444: aload 11
    //   446: astore 10
    //   448: aload_1
    //   449: invokestatic 516	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   452: getfield 1351	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   455: ldc_w 1353
    //   458: iconst_1
    //   459: invokestatic 1358	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   462: invokeinterface 1364 3 0
    //   467: pop
    //   468: aload 11
    //   470: astore 10
    //   472: aload_1
    //   473: invokestatic 516	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   476: invokevirtual 1368	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   479: aload 11
    //   481: astore 10
    //   483: aload_1
    //   484: invokestatic 629	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   487: sipush 224
    //   490: ldc_w 1641
    //   493: invokevirtual 640	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   496: getstatic 281	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   499: invokeinterface 589 1 0
    //   504: aload_0
    //   505: invokevirtual 592	com/tencent/smtt/sdk/TbsInstaller:releaseTbsInstallingFileLock	()V
    //   508: ldc 164
    //   510: ldc_w 1637
    //   513: invokestatic 397	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   516: goto -278 -> 238
    //   519: iconst_0
    //   520: istore_3
    //   521: goto -235 -> 286
    //   524: aload 11
    //   526: astore 10
    //   528: aload_1
    //   529: invokestatic 412	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   532: ldc_w 1133
    //   535: iload_3
    //   536: iconst_1
    //   537: iadd
    //   538: invokevirtual 664	com/tencent/smtt/sdk/TbsCoreVerManager:setStatus	(Ljava/lang/String;I)V
    //   541: aload 11
    //   543: astore 10
    //   545: aload_1
    //   546: invokestatic 1477	com/tencent/smtt/sdk/TbsInstaller:getTbsCorePrivateDir	(Landroid/content/Context;)Ljava/io/File;
    //   549: astore 13
    //   551: aload 13
    //   553: ifnull +667 -> 1220
    //   556: aload 11
    //   558: astore 10
    //   560: new 440	java/io/File
    //   563: dup
    //   564: aload 13
    //   566: ldc_w 1479
    //   569: invokespecial 449	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   572: astore 13
    //   574: aload 13
    //   576: ifnull +644 -> 1220
    //   579: aload 11
    //   581: astore 10
    //   583: aload 13
    //   585: invokevirtual 453	java/io/File:exists	()Z
    //   588: ifeq +632 -> 1220
    //   591: aload 11
    //   593: astore 10
    //   595: aload_1
    //   596: invokestatic 516	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   599: sipush -550
    //   602: invokevirtual 519	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   605: aload 11
    //   607: astore 10
    //   609: aload_1
    //   610: aload_2
    //   611: invokestatic 1645	com/tencent/smtt/sdk/QbSdk:incrUpdate	(Landroid/content/Context;Landroid/os/Bundle;)Landroid/os/Bundle;
    //   614: astore_2
    //   615: aload_2
    //   616: ifnonnull +104 -> 720
    //   619: iconst_1
    //   620: istore_3
    //   621: getstatic 281	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   624: invokeinterface 589 1 0
    //   629: aload_0
    //   630: invokevirtual 592	com/tencent/smtt/sdk/TbsInstaller:releaseTbsInstallingFileLock	()V
    //   633: iload_3
    //   634: ifne +476 -> 1110
    //   637: ldc 164
    //   639: ldc_w 1647
    //   642: invokestatic 397	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   645: aload_1
    //   646: invokestatic 412	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   649: ldc_w 1133
    //   652: iconst_0
    //   653: invokevirtual 664	com/tencent/smtt/sdk/TbsCoreVerManager:setStatus	(Ljava/lang/String;I)V
    //   656: aload_1
    //   657: invokestatic 516	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   660: sipush -544
    //   663: invokevirtual 519	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   666: aload_1
    //   667: invokestatic 412	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   670: iconst_0
    //   671: iconst_m1
    //   672: invokevirtual 416	com/tencent/smtt/sdk/TbsCoreVerManager:setTbsCoreInstallStatus	(II)V
    //   675: aload_1
    //   676: invokestatic 412	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   679: iconst_1
    //   680: invokevirtual 420	com/tencent/smtt/sdk/TbsCoreVerManager:setTbsCoreIncrUpdateStatus	(I)V
    //   683: aload_2
    //   684: ldc 102
    //   686: invokevirtual 1237	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   689: astore 10
    //   691: new 440	java/io/File
    //   694: dup
    //   695: aload 10
    //   697: invokespecial 1047	java/io/File:<init>	(Ljava/lang/String;)V
    //   700: aload_1
    //   701: invokestatic 797	com/tencent/smtt/sdk/TbsApkDownloader:backupTbsApk	(Ljava/io/File;Landroid/content/Context;)V
    //   704: aload_0
    //   705: aload_1
    //   706: aload 10
    //   708: aload_2
    //   709: ldc 108
    //   711: invokevirtual 1649	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   714: invokespecial 385	com/tencent/smtt/sdk/TbsInstaller:installTbsCoreInThread	(Landroid/content/Context;Ljava/lang/String;I)V
    //   717: goto -479 -> 238
    //   720: aload_2
    //   721: astore 10
    //   723: aload_2
    //   724: astore 11
    //   726: aload_2
    //   727: ldc 105
    //   729: invokevirtual 1649	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   732: istore_3
    //   733: goto -112 -> 621
    //   736: astore_2
    //   737: aload 10
    //   739: astore 11
    //   741: ldc 164
    //   743: new 459	java/lang/StringBuilder
    //   746: dup
    //   747: invokespecial 460	java/lang/StringBuilder:<init>	()V
    //   750: ldc_w 1651
    //   753: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   756: aload_2
    //   757: invokestatic 835	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   760: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   763: invokevirtual 470	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   766: invokestatic 397	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   769: aload 10
    //   771: astore 11
    //   773: aload_2
    //   774: invokevirtual 746	java/lang/Exception:printStackTrace	()V
    //   777: aload_1
    //   778: invokestatic 516	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   781: sipush -543
    //   784: invokevirtual 519	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   787: aload_1
    //   788: invokestatic 629	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   791: sipush 218
    //   794: aload_2
    //   795: invokevirtual 747	java/lang/Exception:toString	()Ljava/lang/String;
    //   798: invokevirtual 640	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   801: getstatic 281	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   804: invokeinterface 589 1 0
    //   809: aload_0
    //   810: invokevirtual 592	com/tencent/smtt/sdk/TbsInstaller:releaseTbsInstallingFileLock	()V
    //   813: aload_1
    //   814: invokestatic 516	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   817: sipush -546
    //   820: invokevirtual 519	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   823: ldc 164
    //   825: ldc_w 1653
    //   828: invokestatic 397	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   831: aload_1
    //   832: invokestatic 516	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   835: getfield 1351	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   838: ldc_w 1353
    //   841: iconst_1
    //   842: invokestatic 1358	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   845: invokeinterface 1364 3 0
    //   850: pop
    //   851: aload_1
    //   852: invokestatic 516	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   855: invokevirtual 1368	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   858: aload_1
    //   859: invokestatic 629	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   862: sipush 217
    //   865: new 459	java/lang/StringBuilder
    //   868: dup
    //   869: invokespecial 460	java/lang/StringBuilder:<init>	()V
    //   872: ldc_w 1655
    //   875: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   878: iconst_1
    //   879: invokevirtual 527	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   882: invokevirtual 470	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   885: invokevirtual 640	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   888: goto -650 -> 238
    //   891: astore_2
    //   892: aconst_null
    //   893: astore 10
    //   895: iconst_2
    //   896: istore_3
    //   897: getstatic 281	com/tencent/smtt/sdk/TbsInstaller:mTbsInstallLock	Ljava/util/concurrent/locks/Lock;
    //   900: invokeinterface 589 1 0
    //   905: aload_0
    //   906: invokevirtual 592	com/tencent/smtt/sdk/TbsInstaller:releaseTbsInstallingFileLock	()V
    //   909: iload_3
    //   910: ifne +106 -> 1016
    //   913: ldc 164
    //   915: ldc_w 1647
    //   918: invokestatic 397	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   921: aload_1
    //   922: invokestatic 412	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   925: ldc_w 1133
    //   928: iconst_0
    //   929: invokevirtual 664	com/tencent/smtt/sdk/TbsCoreVerManager:setStatus	(Ljava/lang/String;I)V
    //   932: aload_1
    //   933: invokestatic 516	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   936: sipush -544
    //   939: invokevirtual 519	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   942: aload_1
    //   943: invokestatic 412	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   946: iconst_0
    //   947: iconst_m1
    //   948: invokevirtual 416	com/tencent/smtt/sdk/TbsCoreVerManager:setTbsCoreInstallStatus	(II)V
    //   951: aload_1
    //   952: invokestatic 412	com/tencent/smtt/sdk/TbsCoreVerManager:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsCoreVerManager;
    //   955: iconst_1
    //   956: invokevirtual 420	com/tencent/smtt/sdk/TbsCoreVerManager:setTbsCoreIncrUpdateStatus	(I)V
    //   959: aload 10
    //   961: ldc 102
    //   963: invokevirtual 1237	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   966: astore 11
    //   968: new 440	java/io/File
    //   971: dup
    //   972: aload 11
    //   974: invokespecial 1047	java/io/File:<init>	(Ljava/lang/String;)V
    //   977: aload_1
    //   978: invokestatic 797	com/tencent/smtt/sdk/TbsApkDownloader:backupTbsApk	(Ljava/io/File;Landroid/content/Context;)V
    //   981: aload_0
    //   982: aload_1
    //   983: aload 11
    //   985: aload 10
    //   987: ldc 108
    //   989: invokevirtual 1649	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   992: invokespecial 385	com/tencent/smtt/sdk/TbsInstaller:installTbsCoreInThread	(Landroid/content/Context;Ljava/lang/String;I)V
    //   995: iconst_0
    //   996: invokestatic 1635	com/tencent/smtt/sdk/QbSdk:setTBSInstallingStatus	(Z)V
    //   999: aload_2
    //   1000: athrow
    //   1001: aload_1
    //   1002: invokestatic 516	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1005: sipush -547
    //   1008: invokevirtual 519	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1011: aload_0
    //   1012: invokevirtual 592	com/tencent/smtt/sdk/TbsInstaller:releaseTbsInstallingFileLock	()V
    //   1015: return
    //   1016: iload_3
    //   1017: iconst_2
    //   1018: if_icmpne +14 -> 1032
    //   1021: ldc 164
    //   1023: ldc_w 1637
    //   1026: invokestatic 397	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1029: goto -34 -> 995
    //   1032: aload_1
    //   1033: invokestatic 516	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1036: sipush -546
    //   1039: invokevirtual 519	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1042: ldc 164
    //   1044: ldc_w 1653
    //   1047: invokestatic 397	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1050: aload_1
    //   1051: invokestatic 516	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1054: getfield 1351	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1057: ldc_w 1353
    //   1060: iconst_1
    //   1061: invokestatic 1358	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1064: invokeinterface 1364 3 0
    //   1069: pop
    //   1070: aload_1
    //   1071: invokestatic 516	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1074: invokevirtual 1368	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1077: aload_1
    //   1078: invokestatic 629	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1081: sipush 217
    //   1084: new 459	java/lang/StringBuilder
    //   1087: dup
    //   1088: invokespecial 460	java/lang/StringBuilder:<init>	()V
    //   1091: ldc_w 1655
    //   1094: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1097: iload_3
    //   1098: invokevirtual 527	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1101: invokevirtual 470	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1104: invokevirtual 640	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1107: goto -112 -> 995
    //   1110: iload_3
    //   1111: iconst_2
    //   1112: if_icmpne +14 -> 1126
    //   1115: ldc 164
    //   1117: ldc_w 1637
    //   1120: invokestatic 397	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1123: goto -885 -> 238
    //   1126: aload_1
    //   1127: invokestatic 516	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1130: sipush -546
    //   1133: invokevirtual 519	com/tencent/smtt/sdk/TbsDownloadConfig:setInstallInterruptCode	(I)V
    //   1136: ldc 164
    //   1138: ldc_w 1653
    //   1141: invokestatic 397	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1144: aload_1
    //   1145: invokestatic 516	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1148: getfield 1351	com/tencent/smtt/sdk/TbsDownloadConfig:mSyncMap	Ljava/util/Map;
    //   1151: ldc_w 1353
    //   1154: iconst_1
    //   1155: invokestatic 1358	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1158: invokeinterface 1364 3 0
    //   1163: pop
    //   1164: aload_1
    //   1165: invokestatic 516	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   1168: invokevirtual 1368	com/tencent/smtt/sdk/TbsDownloadConfig:commit	()V
    //   1171: aload_1
    //   1172: invokestatic 629	com/tencent/smtt/sdk/TbsLogReport:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsLogReport;
    //   1175: sipush 217
    //   1178: new 459	java/lang/StringBuilder
    //   1181: dup
    //   1182: invokespecial 460	java/lang/StringBuilder:<init>	()V
    //   1185: ldc_w 1655
    //   1188: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1191: iload_3
    //   1192: invokevirtual 527	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1195: invokevirtual 470	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1198: invokevirtual 640	com/tencent/smtt/sdk/TbsLogReport:setInstallErrorCode	(ILjava/lang/String;)V
    //   1201: goto -963 -> 238
    //   1204: astore_2
    //   1205: aload 11
    //   1207: astore 10
    //   1209: iconst_2
    //   1210: istore_3
    //   1211: goto -314 -> 897
    //   1214: astore_2
    //   1215: iconst_1
    //   1216: istore_3
    //   1217: goto -320 -> 897
    //   1220: iconst_2
    //   1221: istore_3
    //   1222: aload 12
    //   1224: astore_2
    //   1225: goto -604 -> 621
    //   1228: iconst_1
    //   1229: istore_3
    //   1230: goto -944 -> 286
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1233	0	this	TbsInstaller
    //   0	1233	1	paramContext	Context
    //   0	1233	2	paramBundle	Bundle
    //   286	944	3	i	int
    //   263	28	4	j	int
    //   45	32	5	l1	long
    //   54	34	7	l2	long
    //   136	29	9	bool	boolean
    //   177	1031	10	localObject1	Object
    //   170	1036	11	localObject2	Object
    //   173	1050	12	str	String
    //   349	235	13	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   179	183	736	java/lang/Exception
    //   187	195	736	java/lang/Exception
    //   199	210	736	java/lang/Exception
    //   214	218	736	java/lang/Exception
    //   247	265	736	java/lang/Exception
    //   299	310	736	java/lang/Exception
    //   319	327	736	java/lang/Exception
    //   331	339	736	java/lang/Exception
    //   343	351	736	java/lang/Exception
    //   355	362	736	java/lang/Exception
    //   366	374	736	java/lang/Exception
    //   378	390	736	java/lang/Exception
    //   394	402	736	java/lang/Exception
    //   406	418	736	java/lang/Exception
    //   422	429	736	java/lang/Exception
    //   433	444	736	java/lang/Exception
    //   448	468	736	java/lang/Exception
    //   472	479	736	java/lang/Exception
    //   483	496	736	java/lang/Exception
    //   528	541	736	java/lang/Exception
    //   545	551	736	java/lang/Exception
    //   560	574	736	java/lang/Exception
    //   583	591	736	java/lang/Exception
    //   595	605	736	java/lang/Exception
    //   609	615	736	java/lang/Exception
    //   726	733	736	java/lang/Exception
    //   179	183	891	finally
    //   187	195	891	finally
    //   199	210	891	finally
    //   214	218	891	finally
    //   247	265	891	finally
    //   299	310	891	finally
    //   319	327	891	finally
    //   331	339	891	finally
    //   343	351	891	finally
    //   355	362	891	finally
    //   366	374	891	finally
    //   378	390	891	finally
    //   394	402	891	finally
    //   406	418	891	finally
    //   422	429	891	finally
    //   433	444	891	finally
    //   448	468	891	finally
    //   472	479	891	finally
    //   483	496	891	finally
    //   528	541	891	finally
    //   545	551	891	finally
    //   560	574	891	finally
    //   583	591	891	finally
    //   595	605	891	finally
    //   609	615	891	finally
    //   726	733	1204	finally
    //   741	769	1204	finally
    //   773	777	1204	finally
    //   777	801	1214	finally
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
    if (QbSdk.mIsSysWebViewForcedByOuter) {}
    label72:
    do
    {
      return;
      if (Build.VERSION.SDK_INT < 8)
      {
        TbsLog.e("TbsInstaller", "android version < 2.1 no need install X5 core", true);
        return;
      }
      try
      {
        if (!TbsShareManager.isThirdPartyApp(paramContext))
        {
          File localFile = getTmpTbsCoreDecoupleUnzipDir(paramContext);
          if ((localFile != null) && (localFile.exists()))
          {
            FileUtil.delete(localFile, false);
            new File(getTbsCorePrivateDir(paramContext), "x5.tbs").delete();
          }
        }
      }
      catch (Throwable localThrowable)
      {
        break label72;
      }
    } while (!getTmpFolderCoreToRead(paramContext));
    if (!isPrepareTbsCore(paramContext, "core_unzip_tmp"))
    {
      if (isPrepareTbsCore(paramContext, "core_share_backup_tmp")) {
        break label135;
      }
      label97:
      if (isPrepareTbsCore(paramContext, "core_copy_tmp")) {
        break label154;
      }
    }
    label135:
    label154:
    while (!enableTbsCoreFromCopy(paramContext, paramBoolean))
    {
      TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, error !!", true);
      return;
      if (!enableTbsCoreFromUnzip(paramContext, paramBoolean)) {
        break;
      }
      TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromUnzip!!", true);
      return;
      if (!enableTbsCoreFromBackup(paramContext, paramBoolean)) {
        break label97;
      }
      TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromBackup!!", true);
      return;
    }
    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromCopy!!", true);
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
              break label287;
            }
            return true;
          }
          TbsLog.e("TbsInstaller", "321");
          return false;
        }
        File localFile = getTbsCoreShareDir(paramContext);
        if (localFile == null) {
          break label277;
        }
        Long[][] arrayOfLong1 = WEBCORE_LIB_LENGTH_MAP;
        int j = arrayOfLong1.length;
        i = 0;
        if (i >= j) {
          break label290;
        }
        Long[] arrayOfLong = arrayOfLong1[i];
        if (paramInt != arrayOfLong[0].intValue()) {
          break label292;
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
        FileUtil.delete(paramContext.getDir("tbs", 0));
      }
      mTbsCoreInstalledVer.set(Integer.valueOf(0));
      TbsLog.e("TbsInstaller", "322");
      return false;
      label277:
      TbsLog.e("TbsInstaller", "323");
      return false;
      label287:
      continue;
      label290:
      return true;
      label292:
      i += 1;
    }
  }
  
  /* Error */
  boolean isTbsLocalInstalled(Context paramContext)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: new 440	java/io/File
    //   5: dup
    //   6: aload_0
    //   7: aload_1
    //   8: invokevirtual 667	com/tencent/smtt/sdk/TbsInstaller:getTbsCoreShareDir	(Landroid/content/Context;)Ljava/io/File;
    //   11: ldc 167
    //   13: invokespecial 449	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   16: astore 5
    //   18: aload 5
    //   20: ifnull +11 -> 31
    //   23: aload 5
    //   25: invokevirtual 453	java/io/File:exists	()Z
    //   28: ifne +9 -> 37
    //   31: iconst_0
    //   32: istore 4
    //   34: iload 4
    //   36: ireturn
    //   37: new 708	java/util/Properties
    //   40: dup
    //   41: invokespecial 709	java/util/Properties:<init>	()V
    //   44: astore 6
    //   46: new 711	java/io/BufferedInputStream
    //   49: dup
    //   50: new 713	java/io/FileInputStream
    //   53: dup
    //   54: aload 5
    //   56: invokespecial 714	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   59: invokespecial 717	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   62: astore_1
    //   63: aload 6
    //   65: aload_1
    //   66: invokevirtual 720	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   69: aload 6
    //   71: ldc 189
    //   73: ldc_w 1490
    //   76: invokevirtual 759	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   79: invokestatic 1740	java/lang/Boolean:valueOf	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   82: invokevirtual 1381	java/lang/Boolean:booleanValue	()Z
    //   85: istore 4
    //   87: iload 4
    //   89: ifeq +175 -> 264
    //   92: invokestatic 684	java/lang/System:currentTimeMillis	()J
    //   95: aload 5
    //   97: invokevirtual 1743	java/io/File:lastModified	()J
    //   100: lsub
    //   101: ldc2_w 192
    //   104: lcmp
    //   105: ifle +70 -> 175
    //   108: iconst_1
    //   109: istore_3
    //   110: ldc 164
    //   112: new 459	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 460	java/lang/StringBuilder:<init>	()V
    //   119: ldc_w 1745
    //   122: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: iload 4
    //   127: invokevirtual 563	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   130: ldc_w 1747
    //   133: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: iload_3
    //   137: invokevirtual 563	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   140: invokevirtual 470	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: invokestatic 397	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   163: invokevirtual 721	java/io/BufferedInputStream:close	()V
    //   166: iload_3
    //   167: ireturn
    //   168: astore_1
    //   169: aload_1
    //   170: invokevirtual 499	java/io/IOException:printStackTrace	()V
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
    //   193: invokevirtual 1075	java/lang/Throwable:printStackTrace	()V
    //   196: iload_3
    //   197: istore 4
    //   199: aload_1
    //   200: ifnull -166 -> 34
    //   203: aload_1
    //   204: invokevirtual 721	java/io/BufferedInputStream:close	()V
    //   207: iload_3
    //   208: ireturn
    //   209: astore_1
    //   210: aload_1
    //   211: invokevirtual 499	java/io/IOException:printStackTrace	()V
    //   214: iload_3
    //   215: ireturn
    //   216: astore 5
    //   218: aconst_null
    //   219: astore_1
    //   220: aload_1
    //   221: ifnull +7 -> 228
    //   224: aload_1
    //   225: invokevirtual 721	java/io/BufferedInputStream:close	()V
    //   228: aload 5
    //   230: athrow
    //   231: astore_1
    //   232: aload_1
    //   233: invokevirtual 499	java/io/IOException:printStackTrace	()V
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
  public boolean quickDexOptForThirdPartyApp(final Context paramContext1, final Context paramContext2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 164
    //   4: ldc_w 1749
    //   7: invokestatic 397	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   10: getstatic 319	com/tencent/smtt/sdk/TbsInstaller:isQuickDexOptForThirdPartyAppCalled	Z
    //   13: istore_3
    //   14: iload_3
    //   15: iconst_1
    //   16: if_icmpne +7 -> 23
    //   19: aload_0
    //   20: monitorexit
    //   21: iconst_1
    //   22: ireturn
    //   23: iconst_1
    //   24: putstatic 319	com/tencent/smtt/sdk/TbsInstaller:isQuickDexOptForThirdPartyAppCalled	Z
    //   27: new 12	com/tencent/smtt/sdk/TbsInstaller$4
    //   30: dup
    //   31: aload_0
    //   32: aload_2
    //   33: aload_1
    //   34: invokespecial 1752	com/tencent/smtt/sdk/TbsInstaller$4:<init>	(Lcom/tencent/smtt/sdk/TbsInstaller;Landroid/content/Context;Landroid/content/Context;)V
    //   37: invokevirtual 1755	com/tencent/smtt/sdk/TbsInstaller$4:start	()V
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
  
  /* Error */
  void releaseTbsInstallingFileLock()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 323	com/tencent/smtt/sdk/TbsInstaller:currentTbsFileLockStackCount	I
    //   6: istore_1
    //   7: aload_0
    //   8: iload_1
    //   9: iconst_1
    //   10: isub
    //   11: putfield 323	com/tencent/smtt/sdk/TbsInstaller:currentTbsFileLockStackCount	I
    //   14: iload_1
    //   15: iconst_1
    //   16: if_icmpgt +10 -> 26
    //   19: aload_0
    //   20: getfield 325	com/tencent/smtt/sdk/TbsInstaller:isGetTbsInstallingSuccess	Z
    //   23: ifne +14 -> 37
    //   26: ldc 164
    //   28: ldc_w 1757
    //   31: invokestatic 397	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   34: aload_0
    //   35: monitorexit
    //   36: return
    //   37: ldc 164
    //   39: ldc_w 1759
    //   42: invokestatic 397	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   45: aload_0
    //   46: getfield 1580	com/tencent/smtt/sdk/TbsInstaller:tbsFileLockFileLock	Ljava/nio/channels/FileLock;
    //   49: aload_0
    //   50: getfield 1574	com/tencent/smtt/sdk/TbsInstaller:tbsInstallingFos	Ljava/io/FileOutputStream;
    //   53: invokestatic 1763	com/tencent/smtt/utils/FileUtil:freeFileLock	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   56: aload_0
    //   57: iconst_0
    //   58: putfield 325	com/tencent/smtt/sdk/TbsInstaller:isGetTbsInstallingSuccess	Z
    //   61: goto -27 -> 34
    //   64: astore_2
    //   65: aload_0
    //   66: monitorexit
    //   67: aload_2
    //   68: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	this	TbsInstaller
    //   6	11	1	i	int
    //   64	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	64	finally
    //   19	26	64	finally
    //   26	34	64	finally
    //   37	61	64	finally
  }
  
  public void setFallBackStatus(Context paramContext)
  {
    setTmpFolderCoreToRead(paramContext, true);
    TbsCoreVerManager.getInstance(paramContext).setTbsCoreInstallStatus(getTbsCoreShareDecoupleCoreVersion(paramContext), 2);
  }
  
  boolean tbsFileConfExists(Context paramContext)
  {
    paramContext = new File(getTbsCoreShareDir(paramContext), "tbs.conf");
    return (paramContext != null) && (paramContext.exists());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsInstaller
 * JD-Core Version:    0.7.0.1
 */