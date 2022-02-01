package cooperation.qwallet.plugin;

import akqq;
import akrn;
import aktw;
import aktz;
import akwm;
import akyj;
import akyl;
import albe;
import albu;
import albw;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Base64;
import aveg;
import avlg;
import bdiw;
import bgzd;
import blvy;
import blwh;
import com.qq.jce.wup.BasicClassTypeUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadModule;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadResource;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketManager;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.microapp.sdk.MiniAppController;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.pluginsdk.SplashDialogWrapper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebBackForwardList;
import com.tencent.smtt.sdk.WebHistoryItem;
import com.tencent.smtt.sdk.WebView;
import com.tencent.util.QQDeviceInfo;
import cooperation.plugin.PluginInfo;
import cooperation.qwallet.plugin.ipc.QWalletResultReceiver;
import cooperation.qwallet.plugin.pay.PayLogic;
import cooperation.thirdpay.VfcPluginProxyActivity;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.Constants.PropertiesKey;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QWalletHelper
{
  public static final String ACTION_BROADCAST_RERESH_CENTER = "com.qwallet.refresh.center";
  public static final String ACTION_BROADCAST_RERESH_FEEDS = "com.qwallet.feeds_feeds";
  public static final String ACTION_BROADCAST_RERESH_HOME = "com.qwallet.refresh.home";
  public static final String ADS_FILE_PREFIX = "ads_file_prefix_";
  public static int AES_KEY_LENGTH = 16;
  private static final String APPINFO_MATCH_PARAM = "qqwallet_appinfo=";
  public static final String BUSINISS_ID = "5076bf";
  public static final String CLASS_QWALLET_APPINTERFACE = "com.qwallet.activity.QWalletAppInterface";
  public static final String CLASS_VFC_APPINTERFACE = "com.vfuchongcontrol.qq.VfuchongAppInterface";
  private static final String CONFIG_SURFIX = "tenpay_qrtoken";
  private static final String DEV_SAVEKEY = "3411587357140026";
  public static final String FILE_PRECONNECT_NAME = "pre_connect";
  public static int FULL_WND_TYPE_NORMAL = 0;
  public static int FULL_WND_TYPE_PULL = 0;
  public static final long GET_PAY_CODE_INTERNAL = 7200000L;
  public static final String IDIOM_REDBAG_BROADCAST_ACTION = "grap_idiom_hb_result_action";
  public static final String KEY_PRECONNECT_LAST_TIME = "pre_connect_last_time";
  public static final String PREF_KEY_MULTI_IS_REFRESH_CENTER = "is_refresh_center";
  public static final String PREF_KEY_MULTI_IS_REFRESH_HOME = "is_refresh_home";
  public static final String PREF_KEY_MULTI_IS_TENPAY_YELLOWTIP_VALID = "is_tenpay_yellowtip_valid";
  public static final String PREF_KEY_MULTI_PUBLICACC_WHITE_LIST = "publicAcc_white_list";
  public static final String PREF_KEY_MULTI_TENWATCH_REQ_TIME_PREFIX = "tenwatch_req_time_prefix_";
  public static final String PREF_NAME_MULTI_PROCESS = "qwallet_multi";
  public static final String QWALLET_ENTRY_EXTRA_INFO = "entry_extra_config";
  public static final String QWALLET_ENTRY_FEEDS_TAB_REDPOINT = "feeds_tab_redpoint";
  public static final String QWALLET_ENTRY_TAB_INFO = "entry_tab_info";
  public static final String QWALLET_EXTRA_KEY_ACCOUNT_NICK_NAME = "QWalletExtra.Account.NickName";
  public static final String QWALLET_EXTRA_KEY_ACCOUNT_UIN = "QWalletExtra.Account.Uin";
  public static final String QWALLET_EXTRA_KEY_INFO_THR_CONTENT = "QWalletExtra.MQQ.INFO.THR.RedPointContent";
  public static final String QWALLET_EXTRA_KEY_INFO_THR_DESC = "QWalletExtra.MQQ.INFO.THR.RedPointDesc";
  public static final String QWALLET_EXTRA_KEY_INFO_THR_ID = "QWalletExtra.MQQ.INFO.THR.RedPointId";
  public static final String QWALLET_EXTRA_KEY_INFO_THR_INFO = "QWalletExtra.MQQ.INFO.THR.RedPointInfo";
  public static final String QWALLET_EXTRA_KEY_INFO_THR_PATH = "QWalletExtra.MQQ.INFO.THR.RedPointPath";
  public static final String QWALLET_EXTRA_KEY_INFO_TWO_INFO = "QWalletExtra.MQQ.INFO.TWO.RedPointInfo";
  public static final String QWALLET_EXTRA_KEY_INFO_TWO_PATH = "QWalletExtra.MQQ.INFO.TWO.RedPointPath";
  public static final String QWALLET_EXTRA_KEY_IS_FLING = "QWalletExtra.isFling";
  public static final String QWALLET_EXTRA_KEY_IS_GET_DATA = "QWalletExtra.PayBridge.isGetData";
  public static final String QWALLET_EXTRA_KEY_MQQ_APP_GUID = "QWalletExtra.MQQ.GUID";
  public static final String QWALLET_EXTRA_KEY_MQQ_APP_ID = "QWalletExtra.MQQ.APPID";
  public static final String QWALLET_EXTRA_KEY_MQQ_RECEIVER = "QWalletExtra.MQQ.Receiver";
  public static final String QWALLET_EXTRA_KEY_MSG_REDPOINT_BUF = "QWalletExtra.MQQ.MSG.RedPointBuf";
  public static final String QWALLET_EXTRA_KEY_MSG_REDPOINT_INFO = "QWalletExtra.MQQ.MSG.RedPointInfo";
  public static final String QWALLET_EXTRA_KEY_MSG_REDPOINT_PATH = "QWalletExtra.MQQ.MSG.RedPointPath";
  public static final String QWALLET_EXTRA_KEY_PAY_BUNDLE = "QWalletExtra.PayBridge.PayBundle";
  public static final String QWALLET_EXTRA_KEY_PAY_TIME_START = "QWalletExtra.PayBridge.PayTimeStart";
  public static final String QWALLET_EXTRA_KEY_PLUGIN_ISLOADING = "QWalletExtra.Plugin.isloading";
  public static final String QWALLET_EXTRA_KEY_PLUGIN_ISREFRESHEHOME = "QWalletExtra.Plugin.isRefreshHome";
  public static final String QWALLET_EXTRA_KEY_SRV_REDPOINT_BUF = "QWalletExtra.MQQ.App.RedPointBuf";
  public static final String QWALLET_EXTRA_KEY_SRV_REDPOINT_ID = "QWalletExtra.MQQ.App.RedPointId";
  public static final String QWALLET_EXTRA_KEY_SRV_REDPOINT_INFO = "QWalletExtra.MQQ.App.RedPointInfo";
  public static final String QWALLET_EXTRA_KEY_SRV_REDPOINT_INFO_THR = "QWalletExtra.MQQ.App.RedPointInfoThr";
  public static final String QWALLET_EXTRA_KEY_SRV_REDPOINT_PATH = "QWalletExtra.MQQ.App.RedPointPath";
  public static final String QWALLET_EXTRA_KEY_SRV_REDPOINT_PATH_THR = "QWalletExtra.MQQ.App.RedPointPathThr";
  public static final String QWALLET_EXTRA_KEY_SRV_REDPOINT_SUBID = "QWalletExtra.MQQ.App.RedPointSubId";
  public static final String QWALLET_HOMEPAGE_IS_NEED_OPEN_PATTERN_LOCK = "is_need_open_pattern_lock";
  public static final String QWALLET_HOMEPAGE_REPORT_SEQ = "report_seq";
  public static final String QWALLET_IS_FROM_QQSETTINGME = "is_from_qqsettingme";
  public static final String QWALLET_LOAD_BEING_TIME = "QWallet.load.beginTime";
  private static final long QWALLET_PROCESS_INIT_PRE_TIME = 5000L;
  private static final String QWALLET_PROCESS_NAME = "com.tencent.mobileqq:tool";
  public static final int SOURCE_QWALLET_MAIN_PAGE = 1;
  public static final int SOURCE_QWALLET_SUCCESS_PAGE = 2;
  private static final String SP_QRTOKEN = "qrtoken_config";
  private static final String TAG = "QWalletHelper";
  private static final String TAG_WALLET = "Q.qwallet.";
  public static final String TAG_WALLET_AUTH = "Q.qwallet.auth";
  public static final String TAG_WALLET_HOME = "Q.qwallet.home";
  public static final String TAG_WALLET_OPEN = "Q.qwallet.open";
  public static final String TAG_WALLET_PAY = "Q.qwallet.pay";
  public static final String TAG_WALLET_PUSH = "Q.qwallet.push";
  public static final String TAG_WALLET_REALEVENT = "Q.qwallet.realevent";
  public static final String TAG_WALLET_REDPACK = "Q.qwallet.redpack";
  private static final long TIME_PROTECTED_LAUNCH = 5000L;
  public static final String TROOP_HBLIST_BROADCAST_ACTION = "troop_hblist_broadcast_action";
  public static final int TROOP_HBLIST_CLOSE_RESULT_CODE = -20180323;
  public static final int TROOP_HBLIST_GRAPHB_RESULT_CODE = -20180322;
  public static final String TYPE_PRECONNECT_M = "type_mqq_and_myun";
  public static final long UPDATE_TROOP_TIME_INTERVAL = 1800000L;
  public static boolean graphbSpeedEnable;
  private static byte[] iv;
  public static long lastTime;
  private static QQAppInterface mAppInterface;
  private static String mBeforeDeviceId;
  private static String mDeviceId;
  private static boolean mIsRefreshHome = true;
  public static String mQWalletExternalPath = "";
  public static String mQWalletInternalPath = "";
  private static long qLaunchTime;
  public static Set<String> sBuiltInActPayPkgs;
  public static int sFullWindowActivitySource;
  public static int sFullWndCurID;
  public static int sFullWndCurType;
  private static HashMap<String, String> sPublicAccWhiteMap;
  
  static
  {
    FULL_WND_TYPE_PULL = FULL_WND_TYPE_NORMAL + 1;
    sBuiltInActPayPkgs = new HashSet();
    sBuiltInActPayPkgs.add("com.tencent.mtt");
    lastTime = -1L;
    iv = new byte[] { 7, 2, 8, 9, 1, 6, 5, 3 };
  }
  
  private static void addExtraForQvipPayWalletAct(Context paramContext, AppInterface paramAppInterface, Intent paramIntent, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramAppInterface == null) || (paramIntent == null)) {}
    String str1;
    do
    {
      return;
      str1 = paramAppInterface.getCurrentAccountUin();
      String str2 = paramAppInterface.getApplication().getProperty(Constants.PropertiesKey.nickName.toString() + str1);
      paramIntent.putExtra("QWalletExtra.Account.Uin", paramAppInterface.getCurrentAccountUin());
      paramIntent.putExtra("QWalletExtra.Account.NickName", str2);
      paramIntent.putExtra("QWalletExtra.MQQ.APPID", AppSetting.a());
      paramIntent.putExtra("QWalletExtra.MQQ.GUID", NetConnInfoCenter.GUID);
      paramIntent.putExtra("QWalletExtra.MQQ.Receiver", QWalletResultReceiver.getInstance());
      paramIntent.putExtra("QWalletExtra.Plugin.isloading", paramBoolean1);
      paramIntent.putExtra("QWalletExtra.Plugin.isRefreshHome", mIsRefreshHome);
      mIsRefreshHome = false;
      if (PatternLockUtils.isPatternLockOpened(paramContext, str1))
      {
        paramIntent.putExtra("pluginsdk_is_Use_QWallet_PatternLock", true);
        paramIntent.putExtra("pluginsdk_is_QWallet_PLock_Bg_interval_time", PatternLockUtils.getForgroundIntervalTime(paramContext, str1));
      }
    } while (!paramBoolean2);
    if (!GesturePWDUtils.getAppForground(paramContext)) {}
    for (paramBoolean1 = PatternLockUtils.isPatternLockOpened(paramContext, str1);; paramBoolean1 = PatternLockUtils.isNeedOpenPatternLock(paramContext, str1))
    {
      paramIntent.putExtra("is_need_open_pattern_lock", paramBoolean1);
      if (!paramBoolean1) {
        break;
      }
      try
      {
        paramAppInterface = new Intent();
        paramAppInterface.setAction("com.tencent.mobileqq.gestureunlock");
        paramAppInterface.putExtra("timeid", System.currentTimeMillis());
        paramContext.sendBroadcast(paramAppInterface);
        return;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        return;
      }
    }
  }
  
  private static void addLoadingDialogInfo(Context paramContext, AppInterface paramAppInterface, Bundle paramBundle, blwh paramblwh)
  {
    int i = 1;
    if (!(paramContext instanceof Activity)) {}
    for (;;)
    {
      return;
      paramContext = (Activity)paramContext;
      if (isForePay(paramBundle))
      {
        paramAppInterface = paramBundle.getBundle("extra_ext_data");
        if ((paramAppInterface != null) && (paramAppInterface.getInt("extra_ext_data_type", 0) == 1)) {}
        while ((i == 0) && (!isQWalletProcessExist(paramContext)))
        {
          paramAppInterface = new QWalletPayProgressDialog(paramContext);
          paramAppInterface.show();
          paramblwh.jdField_a_of_type_AndroidAppDialog = paramAppInterface;
          paramblwh.jdField_b_of_type_Boolean = false;
          paramblwh.c = 10000;
          paramblwh.f = null;
          new SplashDialogWrapper(paramContext, paramblwh.jdField_a_of_type_AndroidAppDialog, paramblwh.d, paramblwh.jdField_b_of_type_JavaLangString, paramblwh.jdField_b_of_type_Boolean, paramblwh.c).show();
          return;
          i = 0;
        }
      }
    }
  }
  
  static void addWalletEntryConfig(Intent paramIntent, QQAppInterface paramQQAppInterface)
  {
    ArrayList localArrayList = parseTabsConfig(paramQQAppInterface);
    if ((localArrayList != null) && (localArrayList.size() > 0)) {
      paramIntent.putExtra("entry_tab_info", localArrayList);
    }
    paramQQAppInterface = parseExtraConfig(paramQQAppInterface);
    if (paramQQAppInterface != null) {
      paramIntent.putExtra("entry_extra_config", paramQQAppInterface);
    }
  }
  
  public static void clearInstance(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      albe localalbe = (albe)paramQQAppInterface.getManager(QQManagerFactory.VACD_REPORT_MANAGER);
      if (localalbe != null) {
        localalbe.onDestroy();
      }
    }
    mIsRefreshHome = true;
    if ((mAppInterface != null) && (mAppInterface == paramQQAppInterface)) {
      mAppInterface = null;
    }
    aveg.a();
    QWalletResultReceiver.clear();
    bgzd.a().a();
    akqq.a().b();
    CustomizeStrategyFactory.a().b();
    PayLogic.clearCache();
    lastTime = -1L;
  }
  
  public static boolean compare(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {}
    int k;
    do
    {
      do
      {
        return false;
        paramString1 = paramString1.toCharArray();
        paramString2 = paramString2.toCharArray();
      } while ((paramString1 == null) || (paramString2 == null));
      k = paramString1.length;
    } while (k != paramString2.length);
    int i = 0;
    for (;;)
    {
      if (i >= k) {
        break label174;
      }
      if (paramString2[i] != paramString1[i])
      {
        int j = 0;
        for (;;)
        {
          if (j >= 6) {
            break label167;
          }
          if (new char[] { 97, 98, 99, 100, 101, 102 }[j] == paramString2[i]) {
            if (new char[] { 65, 66, 67, 68, 69, 70 }[j] != paramString1[i]) {
              break;
            }
          }
          j += 1;
        }
      }
      label167:
      i += 1;
    }
    label174:
    return true;
  }
  
  public static AppRuntime createQWalletAppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    if ((paramBaseApplicationImpl == null) || (paramString == null)) {
      return null;
    }
    try
    {
      paramString = Class.forName("com.qwallet.activity.QWalletAppInterface");
      paramBaseApplicationImpl = paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      for (;;)
      {
        paramString = PluginStatic.getOrCreateClassLoader(paramBaseApplicationImpl, "qwallet_plugin.apk");
        paramBaseApplicationImpl = paramString.loadClass("com.qwallet.activity.QWalletAppInterface");
        BasicClassTypeUtil.setClassLoader(true, paramString);
      }
    }
    catch (Exception paramBaseApplicationImpl)
    {
      if (!QLog.isColorLevel()) {
        break label100;
      }
      QLog.e("Q.qwallet.", 2, "*createQWalletAppInterface exception:" + paramBaseApplicationImpl.toString());
      label100:
      return null;
    }
    if (paramBaseApplicationImpl == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.qwallet.", 2, "*createQWalletAppInterface load class fail");
      }
    }
    else
    {
      do
      {
        paramBaseApplicationImpl = paramBaseApplicationImpl.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      } while ((paramBaseApplicationImpl == null) || (!(paramBaseApplicationImpl instanceof AppRuntime)));
      paramBaseApplicationImpl = (AppRuntime)paramBaseApplicationImpl;
      return paramBaseApplicationImpl;
    }
    return null;
  }
  
  public static AppRuntime createVfcPluginAppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    if ((paramBaseApplicationImpl == null) || (paramString == null)) {
      return null;
    }
    try
    {
      paramString = Class.forName("com.vfuchongcontrol.qq.VfuchongAppInterface");
      paramBaseApplicationImpl = paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      for (;;)
      {
        paramString = PluginStatic.getOrCreateClassLoader(paramBaseApplicationImpl, "vfc_plugin.apk");
        paramBaseApplicationImpl = paramString.loadClass("com.vfuchongcontrol.qq.VfuchongAppInterface");
        BasicClassTypeUtil.setClassLoader(true, paramString);
      }
    }
    catch (Exception paramBaseApplicationImpl)
    {
      if (!QLog.isColorLevel()) {
        break label100;
      }
      QLog.e("Q.qwallet.", 2, "*createVfcAppInterface exception:" + paramBaseApplicationImpl.toString());
      label100:
      return null;
    }
    if (paramBaseApplicationImpl == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.qwallet.", 2, "*createVfctAppInterface load class fail");
      }
    }
    else
    {
      do
      {
        paramBaseApplicationImpl = paramBaseApplicationImpl.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
      } while ((paramBaseApplicationImpl == null) || (!(paramBaseApplicationImpl instanceof AppRuntime)));
      paramBaseApplicationImpl = (AppRuntime)paramBaseApplicationImpl;
      return paramBaseApplicationImpl;
    }
    return null;
  }
  
  public static long dateToStamp(String paramString)
  {
    try
    {
      long l = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(paramString).getTime();
      return l;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return 0L;
  }
  
  public static String desDecrypt(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (AES_KEY_LENGTH != paramString2.length()) || (AES_KEY_LENGTH != paramString3.length()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qwallet.redpack", 2, "AES decrypt key error = " + paramString2 + " : " + paramString3);
      }
      return null;
    }
    try
    {
      paramString1 = Base64.decode(paramString1, 2);
      paramString3 = new IvParameterSpec(paramString3.getBytes());
      paramString2 = new SecretKeySpec(paramString2.getBytes(), "AES");
      Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      localCipher.init(2, paramString2, paramString3);
      paramString1 = new String(localCipher.doFinal(paramString1));
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return "";
  }
  
  public static String desEncrypt(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (AES_KEY_LENGTH != paramString2.length()) || (AES_KEY_LENGTH != paramString3.length()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qwallet.redpack", 2, "AES encrypt key error = " + paramString2 + " : " + paramString3);
      }
      return null;
    }
    try
    {
      paramString3 = new IvParameterSpec(paramString3.getBytes());
      paramString2 = new SecretKeySpec(paramString2.getBytes(), "AES");
      Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      localCipher.init(1, paramString2, paramString3);
      paramString1 = Base64.encodeToString(localCipher.doFinal(paramString1.getBytes()), 2);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return "";
  }
  
  public static void doF2FRedpack(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString)
  {
    if ((paramQQAppInterface == null) || (paramActivity == null) || (TextUtils.isEmpty(paramString))) {}
    long l;
    do
    {
      return;
      l = VACDReportUtil.a(null, "qqwallet", "graphb", "invoke", paramString, 0, null);
      if ((akrn.a(paramQQAppInterface.getCurrentAccountUin(), "F2FRedpackQRCheck", true)) && (!isValidUrl(paramString)))
      {
        paramQQAppInterface = new Intent(paramActivity, PayBridgeActivity.class);
        paramQQAppInterface.putExtra("pay_requestcode", 200);
        paramActivity.startActivity(paramQQAppInterface);
        VACDReportUtil.endReport(l, "invalidUrl", null, -900, null);
        return;
      }
      if (!akrn.a(paramQQAppInterface.getCurrentAccountUin(), "F2FRedpackGIF", true)) {
        break;
      }
      VACDReportUtil.a(l, null, "checkAnim", null, 0, null);
    } while (playF2FRedPackAnim(paramQQAppInterface, paramActivity, paramString, l));
    gotoF2FRedpack(paramQQAppInterface.getCurrentAccountUin(), paramQQAppInterface.getCurrentNickname(), paramActivity, paramString, false, l);
  }
  
  public static void doQRCodePay(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString)
  {
    if ((paramActivity == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return;
      long l = VACDReportUtil.a(null, "qqwallet", "pay-qrcode", "payinvoke", null, 0, null);
      int i = paramString.indexOf("://qpay.qq.com/qr/");
      if (i == -1) {
        continue;
      }
      String str = paramString.substring(i + "://qpay.qq.com/qr/".length());
      try
      {
        Object localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("tokenId", str);
        ((JSONObject)localObject2).put("comeForm", "3");
        str = ((JSONObject)localObject2).toString();
        if (str == null) {
          continue;
        }
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("payparmas_callback_sn", "0");
        ((Bundle)localObject2).putString("payparmas_json", str);
        ((Bundle)localObject2).putInt("payparmas_paytype", 8);
        ((Bundle)localObject2).putString("payparmas_url_appinfo", "appid#3155944709|bargainor_id#|channel#offline");
        ((Bundle)localObject2).putLong("vacreport_key_seq", l);
        ((Bundle)localObject2).putString("payparmas_h5_url", paramString);
        paramString = new WeakReference(paramActivity);
        paramQQAppInterface = PayBridgeActivity.a(paramQQAppInterface, paramActivity, new QWalletHelper.2(ThreadManager.getUIHandlerV2(), paramString), 9, (Bundle)localObject2);
        if (paramQQAppInterface.getInt("retCode", -1) == 0) {
          continue;
        }
        VACDReportUtil.endReport(l, "parseurl", null, 668801, paramQQAppInterface.getString("retJson"));
        return;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
          Object localObject1 = null;
        }
      }
    }
  }
  
  /* Error */
  public static void doQWalletQRCode(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +10 -> 11
    //   4: aload_2
    //   5: invokestatic 660	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8: ifeq +4 -> 12
    //   11: return
    //   12: new 313	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 314	java/lang/StringBuilder:<init>	()V
    //   19: astore 6
    //   21: aload 6
    //   23: ldc_w 866
    //   26: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: bipush 124
    //   31: invokevirtual 869	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   34: aload_0
    //   35: invokevirtual 728	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   38: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: bipush 124
    //   43: invokevirtual 869	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   46: ldc_w 291
    //   49: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: bipush 124
    //   54: invokevirtual 869	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   57: ldc_w 871
    //   60: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: bipush 124
    //   65: invokevirtual 869	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   68: ldc_w 873
    //   71: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: bipush 124
    //   76: invokevirtual 869	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   79: iconst_0
    //   80: invokevirtual 876	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   83: bipush 124
    //   85: invokevirtual 869	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   88: iconst_1
    //   89: invokevirtual 876	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   92: bipush 124
    //   94: invokevirtual 869	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   97: iconst_0
    //   98: invokevirtual 876	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   101: bipush 124
    //   103: invokevirtual 869	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   106: ldc_w 291
    //   109: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: bipush 124
    //   114: invokevirtual 869	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   117: ldc_w 291
    //   120: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: bipush 124
    //   125: invokevirtual 869	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   128: ldc_w 291
    //   131: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: bipush 124
    //   136: invokevirtual 869	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   139: ldc_w 291
    //   142: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: bipush 124
    //   147: invokevirtual 869	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: aconst_null
    //   152: invokestatic 881	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   155: aload_0
    //   156: aload 6
    //   158: invokevirtual 328	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokevirtual 885	com/tencent/mobileqq/statistics/StatisticCollector:reportToPCliOper	(Lmqq/app/AppRuntime;Ljava/lang/String;)V
    //   164: aload_2
    //   165: bipush 63
    //   167: invokevirtual 888	java/lang/String:indexOf	(I)I
    //   170: istore_3
    //   171: iload_3
    //   172: iconst_m1
    //   173: if_icmpeq -162 -> 11
    //   176: aload_2
    //   177: iload_3
    //   178: iconst_1
    //   179: iadd
    //   180: invokevirtual 790	java/lang/String:substring	(I)Ljava/lang/String;
    //   183: ldc_w 890
    //   186: invokevirtual 894	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   189: astore 8
    //   191: new 896	java/util/HashMap
    //   194: dup
    //   195: invokespecial 897	java/util/HashMap:<init>	()V
    //   198: astore 7
    //   200: aload 8
    //   202: arraylength
    //   203: istore 4
    //   205: iconst_0
    //   206: istore_3
    //   207: iload_3
    //   208: iload 4
    //   210: if_icmpge +108 -> 318
    //   213: aload 8
    //   215: iload_3
    //   216: aaload
    //   217: invokestatic 660	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   220: ifeq +6 -> 226
    //   223: goto +512 -> 735
    //   226: aload 8
    //   228: iload_3
    //   229: aaload
    //   230: bipush 61
    //   232: invokevirtual 888	java/lang/String:indexOf	(I)I
    //   235: istore 5
    //   237: iload 5
    //   239: iconst_m1
    //   240: if_icmpeq +495 -> 735
    //   243: aload 8
    //   245: iload_3
    //   246: aaload
    //   247: iconst_0
    //   248: iload 5
    //   250: invokevirtual 900	java/lang/String:substring	(II)Ljava/lang/String;
    //   253: astore 9
    //   255: aload 8
    //   257: iload_3
    //   258: aaload
    //   259: iload 5
    //   261: iconst_1
    //   262: iadd
    //   263: invokevirtual 790	java/lang/String:substring	(I)Ljava/lang/String;
    //   266: ldc_w 902
    //   269: invokestatic 907	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   272: astore 6
    //   274: aload 9
    //   276: invokestatic 660	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   279: ifne +456 -> 735
    //   282: aload 7
    //   284: aload 9
    //   286: aload 6
    //   288: invokeinterface 912 3 0
    //   293: pop
    //   294: goto +441 -> 735
    //   297: astore_0
    //   298: aload_0
    //   299: invokevirtual 416	java/lang/Exception:printStackTrace	()V
    //   302: return
    //   303: astore 6
    //   305: aload 6
    //   307: invokevirtual 416	java/lang/Exception:printStackTrace	()V
    //   310: ldc_w 291
    //   313: astore 6
    //   315: goto -41 -> 274
    //   318: aload 7
    //   320: invokeinterface 913 1 0
    //   325: ifle -314 -> 11
    //   328: aload 7
    //   330: ldc_w 915
    //   333: invokeinterface 919 2 0
    //   338: checkcast 555	java/lang/String
    //   341: astore 6
    //   343: aload 7
    //   345: ldc_w 920
    //   348: invokeinterface 919 2 0
    //   353: checkcast 555	java/lang/String
    //   356: astore 8
    //   358: aload 6
    //   360: invokestatic 660	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   363: ifne +352 -> 715
    //   366: aload 8
    //   368: invokestatic 660	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   371: ifne +344 -> 715
    //   374: aload 6
    //   376: ldc_w 922
    //   379: invokevirtual 925	java/lang/String:compareTo	(Ljava/lang/String;)I
    //   382: ifne +313 -> 695
    //   385: aload 8
    //   387: ldc_w 927
    //   390: invokevirtual 925	java/lang/String:compareTo	(Ljava/lang/String;)I
    //   393: ifne +302 -> 695
    //   396: aload 7
    //   398: ldc_w 929
    //   401: invokeinterface 919 2 0
    //   406: checkcast 555	java/lang/String
    //   409: astore 8
    //   411: aload 7
    //   413: ldc_w 931
    //   416: invokeinterface 919 2 0
    //   421: checkcast 555	java/lang/String
    //   424: astore 9
    //   426: aload 7
    //   428: ldc_w 932
    //   431: invokeinterface 919 2 0
    //   436: checkcast 555	java/lang/String
    //   439: astore 6
    //   441: aload 6
    //   443: invokestatic 660	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   446: ifne +208 -> 654
    //   449: aload 6
    //   451: ldc_w 934
    //   454: invokevirtual 925	java/lang/String:compareTo	(Ljava/lang/String;)I
    //   457: ifeq +197 -> 654
    //   460: new 313	java/lang/StringBuilder
    //   463: dup
    //   464: invokespecial 314	java/lang/StringBuilder:<init>	()V
    //   467: ldc_w 936
    //   470: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: aload 6
    //   475: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: invokevirtual 328	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   481: astore 6
    //   483: new 792	org/json/JSONObject
    //   486: dup
    //   487: invokespecial 793	org/json/JSONObject:<init>	()V
    //   490: astore 7
    //   492: new 792	org/json/JSONObject
    //   495: dup
    //   496: invokespecial 793	org/json/JSONObject:<init>	()V
    //   499: astore 10
    //   501: aload 10
    //   503: ldc_w 938
    //   506: aload_2
    //   507: invokevirtual 799	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   510: pop
    //   511: aload 10
    //   513: ldc_w 940
    //   516: aload 8
    //   518: invokevirtual 799	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   521: pop
    //   522: aload 10
    //   524: ldc_w 942
    //   527: aload 9
    //   529: invokevirtual 799	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   532: pop
    //   533: aload 7
    //   535: ldc_w 944
    //   538: aload_0
    //   539: invokevirtual 728	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   542: invokevirtual 799	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   545: pop
    //   546: aload 7
    //   548: ldc_w 946
    //   551: ldc_w 948
    //   554: invokevirtual 799	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   557: pop
    //   558: aload 7
    //   560: ldc_w 950
    //   563: aload 6
    //   565: invokevirtual 799	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   568: pop
    //   569: aload 7
    //   571: ldc_w 952
    //   574: iconst_5
    //   575: invokevirtual 955	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   578: pop
    //   579: aload 7
    //   581: ldc_w 957
    //   584: aload 10
    //   586: invokevirtual 799	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   589: pop
    //   590: new 431	android/os/Bundle
    //   593: dup
    //   594: invokespecial 805	android/os/Bundle:<init>	()V
    //   597: astore_0
    //   598: aload_0
    //   599: ldc_w 959
    //   602: aload 7
    //   604: invokevirtual 804	org/json/JSONObject:toString	()Ljava/lang/String;
    //   607: invokevirtual 813	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   610: aload_0
    //   611: ldc_w 961
    //   614: ldc_w 809
    //   617: invokevirtual 813	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   620: new 336	android/content/Intent
    //   623: dup
    //   624: aload_1
    //   625: ldc_w 741
    //   628: invokespecial 744	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   631: astore_2
    //   632: aload_2
    //   633: aload_0
    //   634: invokevirtual 965	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   637: pop
    //   638: aload_2
    //   639: ldc_w 746
    //   642: iconst_5
    //   643: invokevirtual 349	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   646: pop
    //   647: aload_1
    //   648: aload_2
    //   649: iconst_1
    //   650: invokevirtual 969	android/app/Activity:startActivityForResult	(Landroid/content/Intent;I)V
    //   653: return
    //   654: new 313	java/lang/StringBuilder
    //   657: dup
    //   658: invokespecial 314	java/lang/StringBuilder:<init>	()V
    //   661: ldc_w 936
    //   664: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   667: ldc_w 971
    //   670: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   673: invokevirtual 328	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   676: astore 6
    //   678: goto -195 -> 483
    //   681: astore_0
    //   682: invokestatic 974	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   685: ifeq -95 -> 590
    //   688: aload_0
    //   689: invokevirtual 416	java/lang/Exception:printStackTrace	()V
    //   692: goto -102 -> 590
    //   695: aload_1
    //   696: ldc_w 975
    //   699: invokestatic 979	anvx:a	(I)Ljava/lang/String;
    //   702: iconst_0
    //   703: invokestatic 984	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   706: invokevirtual 987	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   709: pop
    //   710: aload_1
    //   711: invokevirtual 990	android/app/Activity:finish	()V
    //   714: return
    //   715: aload_1
    //   716: ldc_w 991
    //   719: invokestatic 979	anvx:a	(I)Ljava/lang/String;
    //   722: iconst_0
    //   723: invokestatic 984	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;Ljava/lang/CharSequence;I)Lcom/tencent/mobileqq/widget/QQToast;
    //   726: invokevirtual 987	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   729: pop
    //   730: aload_1
    //   731: invokevirtual 990	android/app/Activity:finish	()V
    //   734: return
    //   735: iload_3
    //   736: iconst_1
    //   737: iadd
    //   738: istore_3
    //   739: goto -532 -> 207
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	742	0	paramQQAppInterface	QQAppInterface
    //   0	742	1	paramActivity	Activity
    //   0	742	2	paramString	String
    //   170	569	3	i	int
    //   203	8	4	j	int
    //   235	28	5	k	int
    //   19	268	6	localObject1	Object
    //   303	3	6	localException	Exception
    //   313	364	6	str1	String
    //   198	405	7	localObject2	Object
    //   189	328	8	localObject3	Object
    //   253	275	9	str2	String
    //   499	86	10	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   176	205	297	java/lang/Exception
    //   213	223	297	java/lang/Exception
    //   226	237	297	java/lang/Exception
    //   243	255	297	java/lang/Exception
    //   274	294	297	java/lang/Exception
    //   305	310	297	java/lang/Exception
    //   318	483	297	java/lang/Exception
    //   483	492	297	java/lang/Exception
    //   590	653	297	java/lang/Exception
    //   654	678	297	java/lang/Exception
    //   682	692	297	java/lang/Exception
    //   695	714	297	java/lang/Exception
    //   715	734	297	java/lang/Exception
    //   255	274	303	java/lang/Exception
    //   492	590	681	java/lang/Exception
  }
  
  public static void doQWalletQRCodeRet(Activity paramActivity, String paramString)
  {
    if ((paramActivity == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          Object localObject2 = new JSONObject(paramString);
          if (localObject2 != null)
          {
            localObject1 = ((JSONObject)localObject2).optString("exec_code", "-1");
            paramString = ((JSONObject)localObject2).optString("url", "");
            localObject2 = ((JSONObject)localObject2).optString("uin", "");
            switch (Integer.valueOf((String)localObject1).intValue())
            {
            case 1: 
              if (!TextUtils.isEmpty((CharSequence)localObject2))
              {
                paramString = "mqqapi://im/chat?src_type=web&uin=" + (String)localObject2 + "&attach_content=&version=1&chat_type=c2c";
                localObject1 = new Intent(paramActivity, JumpActivity.class);
                ((Intent)localObject1).setData(Uri.parse(paramString));
                paramActivity.startActivity((Intent)localObject1);
                paramActivity.finish();
                return;
              }
              break;
            }
          }
        }
        catch (Exception paramActivity)
        {
          paramActivity.printStackTrace();
          return;
        }
      }
      paramString = new Intent(paramActivity, SplashActivity.class);
      paramString.putExtra("tab_index", MainFragment.jdField_b_of_type_Int);
      paramString.setFlags(67108864);
      paramActivity.startActivity(paramString);
      paramActivity.finish();
      return;
    } while (TextUtils.isEmpty(paramString));
    Object localObject1 = new Intent(paramActivity, QQBrowserActivity.class);
    ((Intent)localObject1).putExtra("url", paramString);
    ((Intent)localObject1).putExtra("startOpenPageTime", System.currentTimeMillis());
    paramActivity.startActivity((Intent)localObject1);
    paramActivity.finish();
    return;
  }
  
  public static String getAccountConfigFileName(String paramString)
  {
    return MD5.toMD5("qwallet_home_accountconfig_" + paramString);
  }
  
  private static String getAppInfoByUrl(String paramString)
  {
    String str2 = "";
    String str1 = str2;
    if (!TextUtils.isEmpty(paramString))
    {
      int k = paramString.toLowerCase().indexOf("qqwallet_appinfo=");
      str1 = str2;
      if (k != -1)
      {
        int j = paramString.indexOf('&', "qqwallet_appinfo=".length() + k);
        int i = j;
        if (j == -1) {
          i = paramString.length();
        }
        str1 = paramString.substring(k + "qqwallet_appinfo=".length(), i);
      }
    }
    return str1;
  }
  
  public static String getAppInfoFromHistory()
  {
    try
    {
      BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
      if ((localBaseApplicationImpl != null) && (localBaseApplicationImpl.appActivities != null))
      {
        int i = localBaseApplicationImpl.appActivities.size() - 1;
        while (i >= 0)
        {
          Object localObject = (WeakReference)localBaseApplicationImpl.appActivities.get(i);
          if (localObject != null)
          {
            localObject = (AppActivity)((WeakReference)localObject).get();
            if ((localObject != null) && ((localObject instanceof QQBrowserActivity)))
            {
              localObject = getAppInfoFromHistory(((QQBrowserActivity)localObject).getHostWebView());
              boolean bool = TextUtils.isEmpty((CharSequence)localObject);
              if (!bool) {
                try
                {
                  localObject = URLDecoder.decode((String)localObject, "UTF-8");
                  return localObject;
                }
                catch (UnsupportedEncodingException localUnsupportedEncodingException)
                {
                  localUnsupportedEncodingException.printStackTrace();
                }
              }
            }
          }
          i -= 1;
        }
      }
      return "";
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  private static String getAppInfoFromHistory(WebView paramWebView)
  {
    Object localObject = "";
    if (paramWebView != null)
    {
      localObject = getAppInfoByUrl(paramWebView.getUrl());
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label25;
      }
    }
    label25:
    label120:
    for (;;)
    {
      return localObject;
      String str = getAppInfoByUrl(paramWebView.getOriginalUrl());
      localObject = str;
      if (TextUtils.isEmpty(str))
      {
        WebBackForwardList localWebBackForwardList = paramWebView.copyBackForwardList();
        localObject = str;
        if (localWebBackForwardList != null)
        {
          int i = localWebBackForwardList.getSize() - 1;
          for (localObject = str;; localObject = paramWebView)
          {
            if (i < 0) {
              break label120;
            }
            paramWebView = getAppInfoByUrl(localWebBackForwardList.getItemAtIndex(i).getUrl());
            localObject = paramWebView;
            if (!TextUtils.isEmpty(paramWebView)) {
              break;
            }
            paramWebView = getAppInfoByUrl(localWebBackForwardList.getItemAtIndex(i).getOriginalUrl());
            localObject = paramWebView;
            if (!TextUtils.isEmpty(paramWebView)) {
              break;
            }
            i -= 1;
          }
        }
      }
    }
  }
  
  public static QQAppInterface getAppInterface()
  {
    return mAppInterface;
  }
  
  public static String getCorrectAppInfo(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      localObject1 = paramString2;
    }
    do
    {
      do
      {
        return localObject1;
        localObject1 = paramString1;
      } while (TextUtils.isEmpty(paramString2));
      localObject1 = paramString1;
    } while (paramString1.equals(paramString2));
    Object localObject1 = "";
    String str5 = "";
    Object localObject4 = "";
    Object localObject2 = "";
    String str3 = "";
    String str2 = "";
    int j = paramString1.lastIndexOf("|channel#");
    Object localObject3 = localObject4;
    String str1 = str5;
    String str4;
    int i;
    if (j != -1)
    {
      str4 = paramString1.substring("|channel#".length() + j);
      i = paramString1.indexOf("|bargainor_id#");
      localObject3 = localObject4;
      str1 = str5;
      localObject1 = str4;
      if (i != -1)
      {
        str5 = paramString1.substring("|bargainor_id#".length() + i, j);
        j = paramString1.indexOf("appid#");
        localObject3 = localObject4;
        str1 = str5;
        localObject1 = str4;
        if (j != -1)
        {
          localObject3 = paramString1.substring("appid#".length() + j, i);
          localObject1 = str4;
          str1 = str5;
        }
      }
    }
    j = paramString2.lastIndexOf("|channel#");
    localObject4 = str2;
    paramString1 = str3;
    if (j != -1)
    {
      str4 = paramString2.substring("|channel#".length() + j);
      i = paramString2.indexOf("|bargainor_id#");
      localObject4 = str2;
      paramString1 = str3;
      localObject2 = str4;
      if (i != -1)
      {
        str3 = paramString2.substring("|bargainor_id#".length() + i, j);
        j = paramString2.indexOf("appid#");
        localObject4 = str2;
        paramString1 = str3;
        localObject2 = str4;
        if (j != -1)
        {
          localObject4 = paramString2.substring("appid#".length() + j, i);
          localObject2 = str4;
          paramString1 = str3;
        }
      }
    }
    if (!TextUtils.isEmpty((CharSequence)localObject4))
    {
      paramString2 = "appid#" + (String)localObject4;
      paramString2 = paramString2 + "|bargainor_id#";
      if (!TextUtils.isEmpty(str1)) {
        break label460;
      }
      paramString1 = paramString2 + paramString1;
      label384:
      paramString1 = paramString1 + "|channel#";
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label516;
      }
    }
    label516:
    for (paramString1 = paramString1 + (String)localObject2;; paramString1 = paramString1 + (String)localObject1)
    {
      return paramString1;
      paramString2 = "appid#" + (String)localObject3;
      break;
      label460:
      if (str1.compareTo("0") == 0)
      {
        paramString1 = paramString2 + paramString1;
        break label384;
      }
      paramString1 = paramString2 + str1;
      break label384;
    }
  }
  
  public static String getIMSI()
  {
    return QQDeviceInfo.getIMSI("5076bf");
  }
  
  public static long getLastUpdateToopMemberNumTime(String paramString)
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (Build.VERSION.SDK_INT > 10) {}
    for (int i = 4;; i = 0) {
      return localBaseApplicationImpl.getSharedPreferences("qwallet_multi", i).getLong(paramString, 0L);
    }
  }
  
  public static String getMacAddress()
  {
    return QQDeviceInfo.getMAC("5076bf");
  }
  
  /* Error */
  public static void getPayCode(QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnonnull +7 -> 11
    //   7: ldc 2
    //   9: monitorexit
    //   10: return
    //   11: aload_0
    //   12: getstatic 1159	com/tencent/mobileqq/app/QQManagerFactory:MGR_PLUGIN	I
    //   15: invokevirtual 1163	com/tencent/mobileqq/app/QQAppInterface:isCreateManager	(I)Z
    //   18: ifeq -11 -> 7
    //   21: aload_0
    //   22: getstatic 1159	com/tencent/mobileqq/app/QQManagerFactory:MGR_PLUGIN	I
    //   25: invokevirtual 513	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   28: checkcast 1165	blvy
    //   31: ldc_w 595
    //   34: invokevirtual 1168	blvy:isPlugininstalled	(Ljava/lang/String;)Z
    //   37: istore_1
    //   38: ldc 207
    //   40: iconst_1
    //   41: new 313	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 314	java/lang/StringBuilder:<init>	()V
    //   48: ldc_w 1170
    //   51: invokevirtual 327	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: iload_1
    //   55: invokevirtual 1173	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   58: invokevirtual 328	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 669	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   64: iload_1
    //   65: ifeq -58 -> 7
    //   68: aload_0
    //   69: invokevirtual 1177	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   72: aload_0
    //   73: invokevirtual 728	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   76: invokestatic 1182	cooperation/pluginbridge/BridgeHelper:a	(Landroid/content/Context;Ljava/lang/String;)Lcooperation/pluginbridge/BridgeHelper;
    //   79: astore 4
    //   81: aload 4
    //   83: ifnull -76 -> 7
    //   86: aload 4
    //   88: ldc_w 1184
    //   91: invokevirtual 1186	cooperation/pluginbridge/BridgeHelper:a	(Ljava/lang/String;)Ljava/lang/String;
    //   94: astore 4
    //   96: aload 4
    //   98: ifnull -91 -> 7
    //   101: aload 4
    //   103: ldc_w 809
    //   106: invokevirtual 1121	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   109: ifne -102 -> 7
    //   112: invokestatic 407	java/lang/System:currentTimeMillis	()J
    //   115: lstore_2
    //   116: getstatic 279	cooperation/qwallet/plugin/QWalletHelper:lastTime	J
    //   119: ldc2_w 276
    //   122: lcmp
    //   123: ifeq +15 -> 138
    //   126: lload_2
    //   127: getstatic 279	cooperation/qwallet/plugin/QWalletHelper:lastTime	J
    //   130: lsub
    //   131: ldc2_w 46
    //   134: lcmp
    //   135: iflt -128 -> 7
    //   138: lload_2
    //   139: putstatic 279	cooperation/qwallet/plugin/QWalletHelper:lastTime	J
    //   142: invokestatic 587	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   145: ifeq +12 -> 157
    //   148: ldc 192
    //   150: iconst_4
    //   151: ldc_w 1188
    //   154: invokestatic 1191	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   157: aload_0
    //   158: invokevirtual 728	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   161: astore 5
    //   163: new 431	android/os/Bundle
    //   166: dup
    //   167: invokespecial 805	android/os/Bundle:<init>	()V
    //   170: astore 6
    //   172: aload_0
    //   173: iconst_2
    //   174: invokevirtual 513	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   177: checkcast 1193	mqq/manager/TicketManager
    //   180: astore 4
    //   182: aload 4
    //   184: ifnull +90 -> 274
    //   187: aload 4
    //   189: aload 5
    //   191: invokeinterface 1196 2 0
    //   196: astore 4
    //   198: aload 6
    //   200: ldc_w 940
    //   203: aload 5
    //   205: invokevirtual 813	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   208: aload 6
    //   210: ldc_w 1198
    //   213: aload 4
    //   215: invokevirtual 813	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   218: aload 6
    //   220: ldc_w 1200
    //   223: ldc_w 1202
    //   226: invokevirtual 813	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   229: aload 6
    //   231: ldc_w 1204
    //   234: bipush 23
    //   236: invokevirtual 821	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   239: getstatic 1208	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   242: aload_0
    //   243: aload 6
    //   245: invokestatic 1214	cooperation/qwallet/plugin/QWalletPayBridge:launchBackground	(Landroid/content/Context;Lcom/tencent/common/app/AppInterface;Landroid/os/Bundle;)Z
    //   248: pop
    //   249: goto -242 -> 7
    //   252: astore_0
    //   253: ldc 2
    //   255: monitorexit
    //   256: aload_0
    //   257: athrow
    //   258: astore 4
    //   260: ldc 207
    //   262: iconst_1
    //   263: ldc_w 1170
    //   266: aload 4
    //   268: invokestatic 1217	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   271: goto -203 -> 68
    //   274: ldc_w 291
    //   277: astore 4
    //   279: goto -81 -> 198
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	282	0	paramQQAppInterface	QQAppInterface
    //   37	28	1	bool	boolean
    //   115	24	2	l	long
    //   79	135	4	localObject	Object
    //   258	9	4	localThrowable	Throwable
    //   277	1	4	str1	String
    //   161	43	5	str2	String
    //   170	74	6	localBundle	Bundle
    // Exception table:
    //   from	to	target	type
    //   11	64	252	finally
    //   68	81	252	finally
    //   86	96	252	finally
    //   101	138	252	finally
    //   138	157	252	finally
    //   157	182	252	finally
    //   187	198	252	finally
    //   198	249	252	finally
    //   260	271	252	finally
    //   11	64	258	java/lang/Throwable
  }
  
  public static String getPersonalInfoFileName(String paramString)
  {
    return MD5.toMD5("qwallet_home_personalInfo_" + paramString);
  }
  
  public static String getPersonalScoreFileName(String paramString)
  {
    return MD5.toMD5("qwallet_home_personalscore_" + paramString);
  }
  
  public static int getProcessPid(Context paramContext, String paramString)
  {
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    if (paramContext != null)
    {
      paramContext = paramContext.getRunningAppProcesses();
      if (paramContext != null)
      {
        paramContext = paramContext.iterator();
        while (paramContext.hasNext())
        {
          ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
          if (paramString.compareTo(localRunningAppProcessInfo.processName) == 0) {
            return localRunningAppProcessInfo.pid;
          }
        }
      }
    }
    return -1;
  }
  
  public static HashMap<String, String> getPublicAccWhiteMap()
  {
    BaseApplicationImpl localBaseApplicationImpl;
    if ((sPublicAccWhiteMap == null) || (sPublicAccWhiteMap.isEmpty()))
    {
      localBaseApplicationImpl = BaseApplicationImpl.getApplication();
      if (Build.VERSION.SDK_INT <= 10) {
        break label53;
      }
    }
    label53:
    for (int i = 4;; i = 0)
    {
      updatePublicAccWhiteMap(localBaseApplicationImpl.getSharedPreferences("qwallet_multi", i).getString("publicAcc_white_list", ""));
      return sPublicAccWhiteMap;
    }
  }
  
  public static String getQWDevId()
  {
    if (mDeviceId == null) {}
    try
    {
      mDeviceId = QQDeviceInfo.getIMEI("5076bf");
      if (QLog.isColorLevel()) {
        QLog.i("QWalletHelper", 1, "deviceId is:" + mDeviceId);
      }
      return mDeviceId;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public static String getQWalletExternalPath()
  {
    if (!TextUtils.isEmpty(mQWalletExternalPath)) {
      return mQWalletExternalPath;
    }
    try
    {
      if ("mounted".equals(Environment.getExternalStorageState())) {
        mQWalletExternalPath = BaseApplicationImpl.getApplication().getExternalFilesDir("QWallet").getAbsolutePath() + "/";
      }
      if (TextUtils.isEmpty(mQWalletExternalPath)) {
        mQWalletExternalPath = getQWalletInternalPath();
      }
      if (QLog.isColorLevel()) {
        QLog.d("QWalletHelper", 1, "getQWalletExternalPath = " + mQWalletExternalPath);
      }
      return mQWalletExternalPath;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.d("QWalletHelper", 1, "getQWalletExternalPath is error,throwable:", localThrowable);
      }
    }
  }
  
  public static String getQWalletInternalPath()
  {
    if (!TextUtils.isEmpty(mQWalletInternalPath)) {
      return mQWalletInternalPath;
    }
    mQWalletInternalPath = BaseApplicationImpl.getApplication().getFilesDir().getAbsolutePath() + "/QWallet/";
    return mQWalletInternalPath;
  }
  
  public static String getRecommendFileName(String paramString)
  {
    return MD5.toMD5("qwallet_home_recomment_" + paramString);
  }
  
  public static boolean getSyncPatternLockState(Context paramContext, String paramString)
  {
    boolean bool = paramContext.getSharedPreferences("qwallet_patternlock", 4).getBoolean("is_need_sync" + paramString, true);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qwallet.pay", 2, "getSyncPatternLockState.uin=" + paramString + ",isNeedSync=" + bool);
    }
    return bool;
  }
  
  public static void gotoF2FRedpack(String paramString1, String paramString2, Activity paramActivity, String paramString3, boolean paramBoolean, long paramLong)
  {
    VACDReportUtil.a(paramLong, null, "startGrapHb", null, 0, null);
    if ((paramActivity == null) || (TextUtils.isEmpty(paramString3))) {}
    for (;;)
    {
      return;
      int i = paramString3.lastIndexOf('#');
      if (i == -1) {
        continue;
      }
      String str = paramString3.substring(i + 1);
      if (TextUtils.isEmpty(str)) {
        continue;
      }
      Object localObject = new JSONObject();
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("channel", 2048);
        localJSONObject.put("qr_data", str);
        localJSONObject.put("name", paramString2);
        ((JSONObject)localObject).put("userId", paramString1);
        ((JSONObject)localObject).put("viewTag", "graphb");
        ((JSONObject)localObject).put("app_info", "");
        ((JSONObject)localObject).put("come_from", 2);
        ((JSONObject)localObject).put("extra_data", localJSONObject);
        paramString2 = new Bundle();
        paramString2.putInt("extra_ext_data_type", 1);
        paramString2.putBoolean("extra_ext_f2fredpack_is_anim", paramBoolean);
        paramString1 = new Bundle();
        localObject = ((JSONObject)localObject).toString();
        paramString1.putBundle("extra_ext_data", paramString2);
        paramString1.putString("json", (String)localObject);
        paramString1.putString("callbackSn", "0");
        new StringBuilder().append("url=").append(paramString3).toString();
        paramString1.putLong("vacreport_key_seq", paramLong);
        paramString2 = new Intent(paramActivity, PayBridgeActivity.class);
        paramString2.putExtras(paramString1);
        paramString2.putExtra("pay_requestcode", 5);
        try
        {
          paramActivity.startActivity(paramString2);
          return;
        }
        catch (Exception paramString1)
        {
          if (QLog.isDevelopLevel()) {
            paramString1.printStackTrace();
          }
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.qwallet.redpack", 2, "QWalletHelper failed to startActivity : " + paramString3, paramString1);
        return;
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          if (QLog.isDevelopLevel()) {
            paramString1.printStackTrace();
          }
        }
      }
    }
  }
  
  private static void gotoQWalletAct(BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface, long paramLong, boolean paramBoolean, QWalletLoadingDialog paramQWalletLoadingDialog)
  {
    if ((paramBaseActivity == null) || (paramQQAppInterface == null)) {
      return;
    }
    mAppInterface = paramQQAppInterface;
    Intent localIntent = new Intent();
    localIntent.putExtra("userQqResources", 1);
    localIntent.putExtra("useSkinEngine", true);
    localIntent.putExtra("param_plugin_gesturelock", true);
    localIntent.putExtra("QWallet.load.beginTime", qLaunchTime);
    localIntent.putExtra("QWalletExtra.isFling", true);
    if (paramLong != 0L) {
      localIntent.putExtra("report_seq", paramLong);
    }
    addWalletEntryConfig(localIntent, paramQQAppInterface);
    localIntent.putExtra("feeds_tab_redpoint", hasShowRedPoint(paramQQAppInterface));
    localIntent.putExtra("is_from_qqsettingme", paramBoolean);
    localIntent.putExtra("big_brother_source_key", "biz_src_zf_qianbao");
    if (paramQWalletLoadingDialog != null) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      addExtraForQvipPayWalletAct(paramBaseActivity, paramQQAppInterface, localIntent, paramBoolean, true);
      blwh localblwh = new blwh(0);
      localblwh.jdField_b_of_type_JavaLangString = "qwallet_plugin.apk";
      localblwh.d = "QWallet";
      localblwh.jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
      localblwh.e = "com.qwallet.activity.QWalletHomeActivity";
      localblwh.jdField_a_of_type_JavaLangClass = QWalletPluginProxyActivity.class;
      localblwh.jdField_a_of_type_AndroidContentIntent = localIntent;
      localblwh.jdField_b_of_type_Int = -1;
      localblwh.jdField_a_of_type_AndroidAppDialog = paramQWalletLoadingDialog;
      localblwh.jdField_b_of_type_Boolean = false;
      localblwh.c = 10000;
      localblwh.f = null;
      blvy.a(paramBaseActivity, localblwh);
      if (paramLong == 0L) {
        break;
      }
      VACDReportUtil.a(paramLong, null, "plugin_begin", null, 0, null);
      return;
    }
  }
  
  public static void gotoQWalletHome(Activity paramActivity)
  {
    Intent localIntent = new Intent();
    localIntent.setData(Uri.parse("mqqapi://wallet/open?src_type=web&viewtype=0&version=1"));
    localIntent.setAction("android.intent.action.VIEW");
    paramActivity.startActivity(localIntent);
  }
  
  public static boolean hasShowRedPoint(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    return ((akyj)paramQQAppInterface.getManager(QQManagerFactory.QWALLET_RED_MANAGER)).a("4001").a;
  }
  
  private static String hexdigest(String paramString)
  {
    int i = 0;
    if (paramString == null) {
      return "";
    }
    char[] arrayOfChar = new char[16];
    char[] tmp18_16 = arrayOfChar;
    tmp18_16[0] = 48;
    char[] tmp24_18 = tmp18_16;
    tmp24_18[1] = 49;
    char[] tmp30_24 = tmp24_18;
    tmp30_24[2] = 50;
    char[] tmp36_30 = tmp30_24;
    tmp36_30[3] = 51;
    char[] tmp42_36 = tmp36_30;
    tmp42_36[4] = 52;
    char[] tmp48_42 = tmp42_36;
    tmp48_42[5] = 53;
    char[] tmp54_48 = tmp48_42;
    tmp54_48[6] = 54;
    char[] tmp61_54 = tmp54_48;
    tmp61_54[7] = 55;
    char[] tmp68_61 = tmp61_54;
    tmp68_61[8] = 56;
    char[] tmp75_68 = tmp68_61;
    tmp75_68[9] = 57;
    char[] tmp82_75 = tmp75_68;
    tmp82_75[10] = 65;
    char[] tmp89_82 = tmp82_75;
    tmp89_82[11] = 66;
    char[] tmp96_89 = tmp89_82;
    tmp96_89[12] = 67;
    char[] tmp103_96 = tmp96_89;
    tmp103_96[13] = 68;
    char[] tmp110_103 = tmp103_96;
    tmp110_103[14] = 69;
    char[] tmp117_110 = tmp110_103;
    tmp117_110[15] = 70;
    tmp117_110;
    for (;;)
    {
      Object localObject;
      int j;
      try
      {
        localObject = MessageDigest.getInstance("MD5");
        ((MessageDigest)localObject).update(paramString.getBytes());
        paramString = ((MessageDigest)localObject).digest();
        localObject = new char[32];
        j = 0;
      }
      catch (Exception paramString)
      {
        return null;
      }
      paramString = new String((char[])localObject);
      return paramString;
      while (i < 16)
      {
        int k = paramString[i];
        int m = j + 1;
        localObject[j] = arrayOfChar[(k >>> 4 & 0xF)];
        j = m + 1;
        localObject[m] = arrayOfChar[(k & 0xF)];
        i += 1;
      }
    }
  }
  
  private static boolean isCurrTaskNotValid(Activity paramActivity)
  {
    boolean bool1;
    try
    {
      if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface))
      {
        boolean bool2 = isSplashNotExist();
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.i("Q.qwallet.pay.QWalletPayBridge", 2, "isCurrTaskNotValid, isSplashNotExist=" + bool2);
          return bool2;
        }
      }
      else
      {
        paramActivity = ((ActivityManager)paramActivity.getSystemService("activity")).getRunningTasks(1);
        if ((paramActivity != null) && (paramActivity.size() > 0) && (paramActivity.get(0) != null))
        {
          int i = ((ActivityManager.RunningTaskInfo)paramActivity.get(0)).numActivities;
          if (i >= 2) {
            return false;
          }
        }
      }
    }
    catch (Throwable paramActivity)
    {
      paramActivity.printStackTrace();
      bool1 = true;
    }
    return bool1;
  }
  
  public static boolean isDeviceIdDiff(String paramString)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    if (TextUtils.isEmpty(paramString)) {}
    String str1;
    do
    {
      return bool2;
      str1 = getQWDevId();
    } while (TextUtils.isEmpty(str1));
    boolean bool1;
    if (TextUtils.isEmpty(mBeforeDeviceId))
    {
      String str2 = akrn.a(paramString, "business_Device", "");
      bool1 = bool3;
      if (!TextUtils.isEmpty(str2))
      {
        String str3 = hexdigest("3411587357140026");
        mBeforeDeviceId = desDecrypt(str2, str3.substring(0, AES_KEY_LENGTH), str3.substring(str3.length() - AES_KEY_LENGTH, str3.length()));
        if (!TextUtils.isEmpty(mBeforeDeviceId)) {
          break label200;
        }
        bool1 = bool3;
      }
    }
    for (;;)
    {
      if (bool1) {
        QLog.i("QWalletHelper", 1, "Cache DeviceId is:" + mBeforeDeviceId + " qwDevId:" + str1);
      }
      if (!TextUtils.isEmpty(mBeforeDeviceId))
      {
        bool2 = bool1;
        if (TextUtils.isEmpty(mBeforeDeviceId)) {
          break;
        }
        bool2 = bool1;
        if (mBeforeDeviceId.equals(str1)) {
          break;
        }
      }
      saveDeviceId(paramString, str1);
      mBeforeDeviceId = str1;
      return bool1;
      label200:
      if (QLog.isColorLevel()) {
        QLog.i("QWalletHelper", 1, "mBeforeDeviceId is null,Cache DeviceId is:" + mBeforeDeviceId);
      }
      bool1 = bool3;
      if (!mBeforeDeviceId.equals(str1))
      {
        bool1 = true;
        continue;
        if (QLog.isColorLevel()) {
          QLog.i("QWalletHelper", 1, "mBeforeDeviceId not null,Cache DeviceId is:" + mBeforeDeviceId);
        }
        bool1 = bool3;
        if (!mBeforeDeviceId.equals(str1)) {
          bool1 = true;
        }
      }
    }
  }
  
  private static boolean isForePay(Bundle paramBundle)
  {
    boolean bool = false;
    if (paramBundle.getInt("launch_type", 0) == 0) {
      bool = true;
    }
    return bool;
  }
  
  private static boolean isFromDiffTaskAffinity(Activity paramActivity)
  {
    try
    {
      List localList = ((ActivityManager)paramActivity.getSystemService("activity")).getRunningTasks(1);
      if ((localList != null) && (localList.size() > 0) && (localList.get(0) != null) && (((ActivityManager.RunningTaskInfo)localList.get(0)).baseActivity != null))
      {
        if (((ActivityManager.RunningTaskInfo)localList.get(0)).id != paramActivity.getTaskId()) {
          return true;
        }
        Object localObject = ((ActivityManager.RunningTaskInfo)localList.get(0)).baseActivity;
        paramActivity = paramActivity.getPackageManager().getActivityInfo((ComponentName)localObject, 128).taskAffinity;
        localObject = BaseApplicationImpl.getContext().getApplicationInfo().taskAffinity;
        if (QLog.isColorLevel()) {
          QLog.i("Q.qwallet.pay.QWalletPayBridge", 2, "isFromDiffTaskAffinity, baseTask=" + (String)localObject + "reqTask=" + paramActivity + ", numA:" + ((ActivityManager.RunningTaskInfo)localList.get(0)).numActivities);
        }
        boolean bool = ((String)localObject).equals(paramActivity);
        if (bool) {
          return false;
        }
      }
    }
    catch (Throwable paramActivity)
    {
      QLog.e("Q.qwallet.pay.QWalletPayBridge", 2, paramActivity.getMessage());
    }
    return true;
  }
  
  private static boolean isFromOnlyActScene(Bundle paramBundle)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramBundle != null)
    {
      i = paramBundle.getInt("comeForm", 0);
      if (i != 9) {
        break label27;
      }
      bool1 = true;
    }
    label27:
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (i != 4);
      paramBundle = paramBundle.getString("packageName");
      bool1 = bool2;
    } while (TextUtils.isEmpty(paramBundle));
    Object localObject = albw.a();
    if (localObject != null)
    {
      localObject = (aktz)((QQAppInterface)localObject).getManager(QQManagerFactory.QWALLET_CONFIG_MANAGER);
      if (localObject != null)
      {
        localObject = ((aktz)localObject).a("common", new String[] { "act_pay_pkgs" });
        if (localObject != null)
        {
          i = 0;
          while (i < ((JSONArray)localObject).length())
          {
            if (TextUtils.equals(paramBundle, ((JSONArray)localObject).optString(i))) {
              return true;
            }
            i += 1;
          }
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      bool1 = bool2;
      if (i != 0) {
        break;
      }
      bool1 = bool2;
      if (!sBuiltInActPayPkgs.contains(paramBundle)) {
        break;
      }
      return true;
    }
  }
  
  private static boolean isFromSpecifyModel()
  {
    try
    {
      String str = Build.MANUFACTURER;
      if (TextUtils.isEmpty(str)) {
        return false;
      }
      boolean bool = str.equals("360");
      return bool;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return false;
  }
  
  private static boolean isLaunchPayPluginAct(Bundle paramBundle, Context paramContext)
  {
    if ((isForePay(paramBundle)) && ((paramContext instanceof Activity)))
    {
      paramContext = (Activity)paramContext;
      if ((isFromOnlyActScene(paramBundle)) || (isFromDiffTaskAffinity(paramContext)) || (isFromSpecifyModel()) || (isCurrTaskNotValid(paramContext))) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean isNeedPreConnect(Context paramContext, String paramString1, String paramString2)
  {
    long l1 = System.currentTimeMillis();
    paramContext = paramContext.getSharedPreferences("pre_connect" + paramString1, 4);
    long l2 = paramContext.getLong("pre_connect_last_time" + paramString2, 0L);
    if (TimeUnit.MILLISECONDS.toSeconds(l1 - l2) < 120000L) {
      return false;
    }
    paramContext = paramContext.edit();
    paramContext.putLong("pre_connect_last_time" + paramString2, l1);
    paramContext.commit();
    return true;
  }
  
  public static boolean isNeedUpdateTroopMemberNum(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (NetConnInfoCenter.getServerTimeMillis() - getLastUpdateToopMemberNumTime(paramString) < 1800000L) {
      return false;
    }
    return true;
  }
  
  public static boolean isPhoneRooted()
  {
    String[] arrayOfString = new String[5];
    arrayOfString[0] = "/system/bin/";
    arrayOfString[1] = "/system/xbin/";
    arrayOfString[2] = "/system/sbin/";
    arrayOfString[3] = "/sbin/";
    arrayOfString[4] = "/vendor/bin/";
    try
    {
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        boolean bool = new File(arrayOfString[i] + "su").exists();
        if (bool) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    catch (Exception localException)
    {
      return false;
    }
  }
  
  public static boolean isQWalletProcessExist(Context paramContext)
  {
    try
    {
      paramContext = (ActivityManager)paramContext.getSystemService("activity");
      if (paramContext == null) {
        return false;
      }
      paramContext = paramContext.getRunningAppProcesses();
      if (paramContext == null) {
        return false;
      }
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        int i = "com.tencent.mobileqq:tool".compareTo(((ActivityManager.RunningAppProcessInfo)paramContext.next()).processName);
        if (i == 0) {
          return true;
        }
      }
    }
    catch (Throwable paramContext)
    {
      if (QLog.isDevelopLevel()) {
        paramContext.printStackTrace();
      }
    }
    return false;
  }
  
  private static boolean isSplashNotExist()
  {
    return (SplashActivity.a == null) || (SplashActivity.a.get() == null);
  }
  
  public static boolean isValidToLaunchQWallet(long paramLong)
  {
    return (paramLong - qLaunchTime > 5000L) || (paramLong - qLaunchTime < 0L);
  }
  
  /* Error */
  public static boolean isValidUrl(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc_w 1650
    //   4: invokevirtual 786	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   7: iconst_1
    //   8: iadd
    //   9: istore_1
    //   10: aload_0
    //   11: iconst_0
    //   12: iload_1
    //   13: iconst_1
    //   14: isub
    //   15: invokevirtual 900	java/lang/String:substring	(II)Ljava/lang/String;
    //   18: astore 6
    //   20: aload_0
    //   21: ldc_w 1652
    //   24: invokevirtual 786	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   27: iconst_1
    //   28: iadd
    //   29: istore_2
    //   30: aload_0
    //   31: iload_1
    //   32: iconst_2
    //   33: iadd
    //   34: iload_2
    //   35: iconst_1
    //   36: isub
    //   37: invokevirtual 900	java/lang/String:substring	(II)Ljava/lang/String;
    //   40: astore 5
    //   42: aload_0
    //   43: iload_2
    //   44: aload_0
    //   45: invokevirtual 663	java/lang/String:length	()I
    //   48: invokevirtual 900	java/lang/String:substring	(II)Ljava/lang/String;
    //   51: astore_0
    //   52: new 1654	java/lang/StringBuffer
    //   55: dup
    //   56: invokespecial 1655	java/lang/StringBuffer:<init>	()V
    //   59: astore 7
    //   61: aload 7
    //   63: aload 6
    //   65: invokevirtual 1658	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   68: pop
    //   69: aload 7
    //   71: ldc_w 1652
    //   74: invokevirtual 1658	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   77: pop
    //   78: aload 7
    //   80: aload_0
    //   81: invokevirtual 1658	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   84: pop
    //   85: aload 7
    //   87: ldc_w 1660
    //   90: invokevirtual 1658	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   93: pop
    //   94: aload 7
    //   96: invokevirtual 1661	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   99: invokestatic 1484	cooperation/qwallet/plugin/QWalletHelper:hexdigest	(Ljava/lang/String;)Ljava/lang/String;
    //   102: iconst_0
    //   103: iconst_4
    //   104: invokevirtual 900	java/lang/String:substring	(II)Ljava/lang/String;
    //   107: astore_0
    //   108: aload_0
    //   109: aload 5
    //   111: invokevirtual 1121	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   114: istore_3
    //   115: iload_3
    //   116: istore 4
    //   118: iload_3
    //   119: ifne +11 -> 130
    //   122: aload_0
    //   123: aload 5
    //   125: invokestatic 1663	cooperation/qwallet/plugin/QWalletHelper:compare	(Ljava/lang/String;Ljava/lang/String;)Z
    //   128: istore 4
    //   130: iload 4
    //   132: ireturn
    //   133: astore_0
    //   134: iconst_0
    //   135: istore_3
    //   136: aload_0
    //   137: invokevirtual 416	java/lang/Exception:printStackTrace	()V
    //   140: iload_3
    //   141: ireturn
    //   142: astore_0
    //   143: goto -7 -> 136
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	paramString	String
    //   9	25	1	i	int
    //   29	15	2	j	int
    //   114	27	3	bool1	boolean
    //   116	15	4	bool2	boolean
    //   40	84	5	str1	String
    //   18	46	6	str2	String
    //   59	36	7	localStringBuffer	java.lang.StringBuffer
    // Exception table:
    //   from	to	target	type
    //   0	115	133	java/lang/Exception
    //   122	130	142	java/lang/Exception
  }
  
  public static void launchPayBridgeService(Context paramContext, AppInterface paramAppInterface, Bundle paramBundle)
  {
    if ((paramContext == null) || (paramAppInterface == null) || (paramBundle == null)) {
      return;
    }
    if ((paramAppInterface instanceof QQAppInterface)) {
      mAppInterface = (QQAppInterface)paramAppInterface;
    }
    Intent localIntent = new Intent(paramAppInterface.getApp(), QWalletPluginProxyService.class);
    localIntent.putExtra("QWalletExtra.PayBridge.PayBundle", paramBundle);
    localIntent.putExtra("QWalletExtra.PayBridge.PayTimeStart", System.currentTimeMillis());
    localIntent.putExtra("param_plugin_gesturelock", true);
    localIntent.putExtra("uin", paramAppInterface.getCurrentAccountUin());
    localIntent.putExtra("pluginsdk_disable_PatternLock", true);
    Object localObject = (TicketManager)paramAppInterface.getManager(2);
    if (localObject != null) {}
    for (localObject = ((TicketManager)localObject).getSkey(paramAppInterface.getCurrentAccountUin());; localObject = null)
    {
      localIntent.putExtra("qqskey", (String)localObject);
      label216:
      String str;
      if (paramBundle.containsKey("tag"))
      {
        localObject = (String)paramBundle.get("tag");
        if ((!"graphb".equals(localObject)) && (graphbSpeedEnable)) {
          localIntent.putExtra("useSkinEngine", true);
        }
        localIntent.putExtra("userQqResources", 1);
        if (!paramBundle.containsKey("entry")) {
          break label429;
        }
        localObject = (String)paramBundle.get("entry");
        if (!paramBundle.containsKey("viewParam")) {
          break label437;
        }
        str = (String)paramBundle.get("viewParam");
        label238:
        if ((!"2".equals(localObject)) || (!"10".equals(str))) {
          break label452;
        }
      }
      label429:
      label437:
      label452:
      for (boolean bool = true;; bool = false)
      {
        addExtraForQvipPayWalletAct(paramContext, paramAppInterface, localIntent, false, bool);
        localObject = new blwh(0);
        str = paramBundle.getString("preload_from");
        if (!TextUtils.isEmpty(str)) {
          ((blwh)localObject).jdField_a_of_type_Avlg = new avlg(str, "com.tencent.mobileqq:tool", "qwallet_plugin.apk");
        }
        ((blwh)localObject).jdField_b_of_type_JavaLangString = "qwallet_plugin.apk";
        ((blwh)localObject).d = "Wallet";
        ((blwh)localObject).jdField_a_of_type_JavaLangString = paramAppInterface.getCurrentAccountUin();
        ((blwh)localObject).e = "com.qwallet.service.QWalletPluginService";
        ((blwh)localObject).jdField_a_of_type_AndroidContentIntent = localIntent;
        ((blwh)localObject).jdField_a_of_type_AndroidContentServiceConnection = null;
        addLoadingDialogInfo(paramContext, paramAppInterface, paramBundle, (blwh)localObject);
        bool = isLaunchPayPluginAct(paramBundle, paramContext);
        if (QLog.isColorLevel()) {
          QLog.i("Q.qwallet.pay.QWalletPayBridge", 2, "isLaunchPayPluginAct =" + bool);
        }
        if (bool)
        {
          launchPayPluginAct((blwh)localObject, localIntent, paramContext);
          return;
          localObject = null;
          break;
          localObject = "";
          break label216;
          str = "";
          break label238;
        }
        blvy.c(paramContext, (blwh)localObject);
        return;
      }
    }
  }
  
  private static void launchPayPluginAct(blwh paramblwh, Intent paramIntent, Context paramContext)
  {
    Intent localIntent = new Intent();
    if ((paramIntent != null) && (paramIntent.getExtras() != null)) {
      localIntent.putExtras(paramIntent.getExtras());
    }
    paramblwh.e = "com.qwallet.activity.QvipPayBridgeActivity";
    paramblwh.jdField_a_of_type_JavaLangClass = QWalletPluginProxyActivity.class;
    paramblwh.jdField_a_of_type_AndroidContentIntent = localIntent;
    paramblwh.jdField_b_of_type_Int = 3001;
    blvy.a((Activity)paramContext, paramblwh);
  }
  
  public static void launchQWalletAct(BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBaseActivity == null) || (paramQQAppInterface == null)) {}
    while ((paramBoolean1) && (QWalletPrivacyUtils.isOpenPrivacyDialog(paramBaseActivity, paramQQAppInterface))) {
      return;
    }
    if (paramBoolean2) {
      MiniAppController.preloadMiniProcess(paramBaseActivity.app.getApp());
    }
    albu.a("homepage_onclick");
    paramBoolean1 = PatternLockUtils.isNeedOpenPatternLock(paramBaseActivity, paramQQAppInterface.getCurrentAccountUin());
    long l1 = bdiw.a("com.tencent.mobileqq:tool");
    long l2 = VACDReportUtil.a(null, "qqwallet", "homepage", "click", "toolRunTime=" + l1, 0, null);
    qLaunchTime = System.currentTimeMillis();
    if (l1 > 5000L)
    {
      gotoQWalletAct(paramBaseActivity, paramQQAppInterface, l2, paramBoolean2, null);
      return;
    }
    QWalletLoadingDialog localQWalletLoadingDialog = new QWalletLoadingDialog(paramBaseActivity, paramBoolean1);
    localQWalletLoadingDialog.show();
    gotoQWalletAct(paramBaseActivity, paramQQAppInterface, l2, paramBoolean2, localQWalletLoadingDialog);
  }
  
  public static void launchVfcPlugin(BaseActivity paramBaseActivity, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("userQqResources", -1);
    localIntent.putExtra("useSkinEngine", true);
    localIntent.putExtra("param_plugin_gesturelock", true);
    localIntent.putExtra("params_remote_connect_at_launch", false);
    localIntent.putExtra("from_type", 1);
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    localIntent.putExtra("openid", str);
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    localIntent.putExtra("imei", paramString1);
    paramString1 = paramString3;
    if (paramString3 == null) {
      paramString1 = "";
    }
    localIntent.putExtra("vfcAccountFlag", paramString1);
    localIntent.addFlags(67108864);
    paramString1 = new blwh(1);
    paramString1.jdField_b_of_type_JavaLangString = "vfc_plugin.apk";
    paramString1.d = PluginInfo.o;
    paramString1.jdField_a_of_type_AndroidAppDialog = null;
    paramString1.jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
    paramString1.jdField_a_of_type_AndroidContentIntent = localIntent;
    paramString1.e = "com.vfuchongcontrol.qq.activity.MainActivity";
    paramString1.jdField_a_of_type_JavaLangClass = VfcPluginProxyActivity.class;
    paramString1.jdField_b_of_type_Int = -1;
    paramString1.c = 15000;
    paramString1.jdField_b_of_type_Boolean = true;
    paramString1.f = null;
    blvy.a(paramBaseActivity, paramString1);
  }
  
  public static JSONObject loadUnifiedConfig(Context paramContext)
  {
    Object localObject3 = null;
    Object localObject1 = null;
    if (paramContext != null)
    {
      localObject3 = FileUtils.readFile(paramContext.getFilesDir() + "/qb_tenpay_unified_config");
      if (localObject3 == null) {
        break label111;
      }
      localObject1 = new String((byte[])localObject3);
    }
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        i = 1;
        localObject3 = localObject1;
        if (i == 0)
        {
          paramContext = paramContext.getSharedPreferences("qb_tenpay_prefer", 0).edit();
          paramContext.putInt("qpay_unified_config_ver", -1);
          paramContext.commit();
          localObject3 = localObject1;
        }
        return localObject3;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        Object localObject2 = null;
        continue;
      }
      label111:
      int i = 0;
    }
  }
  
  static Bundle parseExtraConfig(QQAppInterface paramQQAppInterface)
  {
    Bundle localBundle = new Bundle();
    paramQQAppInterface = (aktz)paramQQAppInterface.getManager(QQManagerFactory.QWALLET_CONFIG_MANAGER);
    if (paramQQAppInterface != null) {
      localBundle.putInt("accountShowType", paramQQAppInterface.a("common", 0, new String[] { "accountShow", "type" }));
    }
    return localBundle;
  }
  
  static ArrayList<HashMap<String, String>> parseTabsConfig(QQAppInterface paramQQAppInterface)
  {
    Object localObject1 = (aktz)paramQQAppInterface.getManager(QQManagerFactory.QWALLET_CONFIG_MANAGER);
    String str1 = ((aktz)localObject1).a("wallet_entry", "", new String[] { "tab1", "url" });
    Object localObject2 = ((aktz)localObject1).a("wallet_entry", "", new String[] { "tab1", "beginTime" });
    String str2 = ((aktz)localObject1).a("wallet_entry", "", new String[] { "tab1", "endTime" });
    if ((RedPacketManager.isValidDate((String)localObject2, str2)) && (!TextUtils.isEmpty(str1)))
    {
      paramQQAppInterface = new ArrayList();
      HashMap localHashMap1 = new HashMap();
      localHashMap1.put("showTab", ((aktz)localObject1).a("wallet_entry", 0, new String[] { "showTab" }) + "");
      localHashMap1.put("name", ((aktz)localObject1).a("wallet_entry", "", new String[] { "tab0", "name" }));
      localHashMap1.put("iconNormal", ((aktz)localObject1).a("wallet_entry", "", new String[] { "tab0", "icon_normal" }));
      localHashMap1.put("iconSelect", ((aktz)localObject1).a("wallet_entry", "", new String[] { "tab0", "icon_select" }));
      HashMap localHashMap2 = new HashMap();
      localHashMap2.put("name", ((aktz)localObject1).a("wallet_entry", "", new String[] { "tab1", "name" }));
      localHashMap2.put("iconNormal", ((aktz)localObject1).a("wallet_entry", "", new String[] { "tab1", "icon_normal" }));
      localHashMap2.put("iconSelect", ((aktz)localObject1).a("wallet_entry", "", new String[] { "tab1", "icon_select" }));
      localHashMap2.put("colorTop", ((aktz)localObject1).a("wallet_entry", "", new String[] { "tab1", "colorTop" }));
      localHashMap2.put("colorBottom", ((aktz)localObject1).a("wallet_entry", "", new String[] { "tab1", "colorBottom" }));
      localHashMap2.put("url", str1);
      localHashMap2.put("beginTime", localObject2);
      localHashMap2.put("endTime", str2);
      localHashMap2.put("action", ((aktz)localObject1).a("wallet_entry", 0, new String[] { "tab1", "action" }) + "");
      localObject1 = ((aktz)localObject1).a("wallet_entry", "", new String[] { "tab1", "search" });
      try
      {
        localObject2 = new JSONObject((String)localObject1);
        localObject1 = ((JSONObject)localObject2).getString("url");
        str1 = ((JSONObject)localObject2).getString("beginTime");
        localObject2 = ((JSONObject)localObject2).getString("endTime");
        if ((RedPacketManager.isValidDate(str1, (String)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
        {
          localHashMap2.put("search_url", localObject1);
          localHashMap2.put("search_beginTime", str1);
          localHashMap2.put("search_endTime", localObject2);
        }
        paramQQAppInterface.add(localHashMap1);
        paramQQAppInterface.add(localHashMap2);
        return paramQQAppInterface;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
    }
    return null;
  }
  
  public static ArrayList<HashMap<String, String>> parseTabsConfig(String paramString)
  {
    if (StringUtil.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      try
      {
        Object localObject1 = new JSONObject(paramString);
        String str1 = aktw.a((JSONObject)localObject1, "", new String[] { "tab1", "url" });
        Object localObject2 = aktw.a((JSONObject)localObject1, "", new String[] { "tab1", "beginTime" });
        String str2 = aktw.a((JSONObject)localObject1, "", new String[] { "tab1", "endTime" });
        if ((!RedPacketManager.isValidDate((String)localObject2, str2)) || (TextUtils.isEmpty(str1))) {
          continue;
        }
        paramString = new ArrayList();
        HashMap localHashMap1 = new HashMap();
        localHashMap1.put("showTab", aktw.a((JSONObject)localObject1, 0, new String[] { "showTab" }) + "");
        localHashMap1.put("name", aktw.a((JSONObject)localObject1, "", new String[] { "tab0", "name" }));
        localHashMap1.put("iconNormal", aktw.a((JSONObject)localObject1, "", new String[] { "tab0", "icon_normal" }));
        localHashMap1.put("iconSelect", aktw.a((JSONObject)localObject1, "", new String[] { "tab0", "icon_select" }));
        HashMap localHashMap2 = new HashMap();
        localHashMap2.put("name", aktw.a((JSONObject)localObject1, "", new String[] { "tab1", "name" }));
        localHashMap2.put("iconNormal", aktw.a((JSONObject)localObject1, "", new String[] { "tab1", "icon_normal" }));
        localHashMap2.put("iconSelect", aktw.a((JSONObject)localObject1, "", new String[] { "tab1", "icon_select" }));
        localHashMap2.put("colorTop", aktw.a((JSONObject)localObject1, "", new String[] { "tab1", "colorTop" }));
        localHashMap2.put("colorBottom", aktw.a((JSONObject)localObject1, "", new String[] { "tab1", "colorBottom" }));
        localHashMap2.put("url", str1);
        localHashMap2.put("beginTime", localObject2);
        localHashMap2.put("endTime", str2);
        localHashMap2.put("action", aktw.a((JSONObject)localObject1, 0, new String[] { "tab1", "action" }) + "");
        localObject1 = aktw.a((JSONObject)localObject1, "", new String[] { "tab1", "search" });
        try
        {
          localObject2 = new JSONObject((String)localObject1);
          localObject1 = ((JSONObject)localObject2).getString("url");
          str1 = ((JSONObject)localObject2).getString("beginTime");
          localObject2 = ((JSONObject)localObject2).getString("endTime");
          if ((RedPacketManager.isValidDate(str1, (String)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
          {
            localHashMap2.put("search_url", localObject1);
            localHashMap2.put("search_beginTime", str1);
            localHashMap2.put("search_endTime", localObject2);
          }
          paramString.add(localHashMap1);
          paramString.add(localHashMap2);
          return paramString;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
          }
        }
        return null;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  protected static boolean playF2FRedPackAnim(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString, long paramLong)
  {
    if ((paramQQAppInterface == null) || (paramActivity == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    Object localObject1 = (PreloadManager)paramQQAppInterface.getManager(QQManagerFactory.PRELOAD_MANAGER);
    if (localObject1 == null) {
      return false;
    }
    Object localObject2 = ((PreloadManager)localObject1).a("f2f_redpacket");
    if (localObject2 == null) {
      return false;
    }
    localObject2 = ((PreloadModule)localObject2).getResList();
    if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
      return false;
    }
    localObject2 = (PreloadResource)((List)localObject2).get(0);
    if ((localObject2 == null) || (TextUtils.isEmpty(((PreloadResource)localObject2).url))) {
      return false;
    }
    localObject2 = PreloadManager.f(((PreloadResource)localObject2).url);
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      ((PreloadManager)localObject1).a("f2f_redpacket", true);
      return false;
    }
    localObject1 = paramQQAppInterface.getCurrentAccountUin();
    paramQQAppInterface = paramQQAppInterface.getCurrentNickname();
    ThreadManager.post(new QWalletHelper.3((String)localObject2, new WeakReference(paramActivity), paramLong, (String)localObject1, paramQQAppInterface, paramString), 5, null, true);
    return true;
  }
  
  public static void preloadQWallet(AppInterface paramAppInterface)
  {
    preloadQWallet(paramAppInterface, 5000, "qwallet_default");
  }
  
  public static void preloadQWallet(AppInterface paramAppInterface, int paramInt, String paramString)
  {
    if (paramAppInterface == null) {
      return;
    }
    if ((paramAppInterface != null) && ((paramAppInterface instanceof QQAppInterface))) {
      mAppInterface = (QQAppInterface)paramAppInterface;
    }
    String str = paramAppInterface.getCurrentAccountUin();
    Object localObject = (TicketManager)paramAppInterface.getManager(2);
    if (localObject == null) {}
    for (localObject = null;; localObject = ((TicketManager)localObject).getSkey(str))
    {
      paramAppInterface = new WeakReference(paramAppInterface);
      ThreadManager.getSubThreadHandler().postDelayed(new QWalletHelper.1(paramAppInterface, str, (String)localObject, paramString), paramInt);
      return;
    }
  }
  
  public static String readQRTokenConfig(Context paramContext, String paramString)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return "";
      try
      {
        paramContext = paramContext.getSharedPreferences("qrtoken_config", 0).getString("qrtoken" + paramString, "");
        paramString = hexdigest(paramString + "tenpayguid" + getQWDevId());
        paramContext = desDecrypt(paramContext, paramString.substring(0, AES_KEY_LENGTH), paramString.substring(paramString.length() - AES_KEY_LENGTH, paramString.length()));
        if (QLog.isColorLevel()) {
          QLog.d("Q.qwallet.redpack", 2, "readQRTokenConfig plain = " + paramContext);
        }
        if ((paramContext != null) && (paramContext.endsWith("tenpay_qrtoken")))
        {
          paramContext = paramContext.substring(0, paramContext.length() - "tenpay_qrtoken".length());
          return paramContext;
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    return "";
  }
  
  public static void release() {}
  
  public static void resetLaunchTime()
  {
    qLaunchTime = 0L;
  }
  
  public static void saveDeviceId(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString1)))
    {
      String str = hexdigest("3411587357140026");
      str = desEncrypt(paramString2, str.substring(0, AES_KEY_LENGTH), str.substring(str.length() - AES_KEY_LENGTH, str.length()));
      if (QLog.isColorLevel()) {
        QLog.d("QWalletHelper", 1, "save deviceId:" + paramString2);
      }
      if (!TextUtils.isEmpty(str)) {
        akrn.a(paramString1, "business_Device", str);
      }
    }
  }
  
  public static void saveLastUpdateToopMemberNumTime(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (Build.VERSION.SDK_INT > 10) {}
    for (int i = 4;; i = 0)
    {
      localBaseApplicationImpl.getSharedPreferences("qwallet_multi", i).edit().putLong(paramString, NetConnInfoCenter.getServerTimeMillis());
      return;
    }
  }
  
  public static void saveQRTokenConfig(Context paramContext, String paramString1, String paramString2)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1))) {}
    for (;;)
    {
      return;
      try
      {
        Object localObject = new StringBuilder().append(paramString2).append("tenpayguid");
        String str = QQDeviceInfo.getIMEI("5076bf");
        mDeviceId = str;
        str = hexdigest(str);
        localObject = str.substring(0, AES_KEY_LENGTH);
        str = str.substring(str.length() - AES_KEY_LENGTH, str.length());
        paramString1 = desEncrypt(paramString1 + "tenpay_qrtoken", (String)localObject, str);
        if (QLog.isColorLevel()) {
          QLog.d("Q.qwallet.redpack", 2, "saveQRTokenConfig ciper = " + paramString1);
        }
        if (paramString1 != null)
        {
          paramContext = paramContext.getSharedPreferences("qrtoken_config", 0).edit();
          paramContext.putString("qrtoken" + paramString2, paramString1);
          paramContext.commit();
          return;
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  public static void setAppInterface(QQAppInterface paramQQAppInterface)
  {
    mAppInterface = paramQQAppInterface;
  }
  
  public static void updateHongBaoSpeedWitch(QQAppInterface paramQQAppInterface, String paramString)
  {
    boolean bool = true;
    try
    {
      i = Integer.parseInt(paramString);
      if (i == 1)
      {
        graphbSpeedEnable = bool;
        return;
      }
    }
    catch (NumberFormatException paramQQAppInterface)
    {
      for (;;)
      {
        paramQQAppInterface.printStackTrace();
        int i = 0;
        continue;
        bool = false;
      }
    }
  }
  
  public static void updatePublicAccWhiteMap(String paramString)
  {
    int i;
    if (sPublicAccWhiteMap == null)
    {
      sPublicAccWhiteMap = new HashMap(16);
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      String[] arrayOfString = paramString.split("\\|");
      if (arrayOfString == null) {
        return;
      }
      int j = arrayOfString.length;
      i = 0;
      label42:
      if (i >= j) {
        return;
      }
      paramString = arrayOfString[i];
      if (!TextUtils.isEmpty(paramString)) {
        break label74;
      }
    }
    label74:
    do
    {
      i += 1;
      break label42;
      sPublicAccWhiteMap.clear();
      break;
      paramString = paramString.split("#");
    } while ((paramString == null) || (TextUtils.isEmpty(paramString[0])));
    HashMap localHashMap = sPublicAccWhiteMap;
    Object localObject = paramString[0];
    if (paramString.length > 1) {}
    for (paramString = paramString[1];; paramString = "0")
    {
      localHashMap.put(localObject, paramString);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qwallet.plugin.QWalletHelper
 * JD-Core Version:    0.7.0.1
 */