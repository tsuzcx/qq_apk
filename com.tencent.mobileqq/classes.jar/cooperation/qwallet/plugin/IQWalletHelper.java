package cooperation.qwallet.plugin;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qrscan.OnQRHandleResultCallback;
import com.tencent.smtt.sdk.WebView;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface IQWalletHelper
  extends QRouteApi
{
  public static final String ACTION_BROADCAST_RERESH_CENTER = "com.qwallet.refresh.center";
  public static final String ACTION_BROADCAST_RERESH_FEEDS = "com.qwallet.feeds_feeds";
  public static final String ACTION_BROADCAST_RERESH_HOME = "com.qwallet.refresh.home";
  public static final String ADS_FILE_PREFIX = "ads_file_prefix_";
  public static final int AES_KEY_LENGTH = 16;
  public static final String BUSINISS_ID = "5076bf";
  public static final String CLASS_QWALLET_APPINTERFACE = "com.qwallet.activity.QWalletAppInterface";
  public static final String CLASS_VFC_APPINTERFACE = "com.vfuchongcontrol.qq.VfuchongAppInterface";
  public static final String CONFIG_SURFIX = "tenpay_qrtoken";
  public static final String DEV_SAVEKEY = "3411587357140026";
  public static final int FULL_WND_TYPE_NORMAL = 0;
  public static final int FULL_WND_TYPE_PULL = 1;
  public static final long GET_PAY_CODE_INTERNAL = 7200000L;
  public static final String IDIOM_REDBAG_BROADCAST_ACTION = "grap_idiom_hb_result_action";
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
  public static final long QWALLET_PROCESS_INIT_PRE_TIME = 5000L;
  public static final String QWALLET_PROCESS_NAME = "com.tencent.mobileqq:tool";
  public static final int SOURCE_QWALLET_MAIN_PAGE = 1;
  public static final int SOURCE_QWALLET_SUCCESS_PAGE = 2;
  public static final String SP_QRTOKEN = "qrtoken_config";
  public static final String TAG_WALLET = "Q.qwallet.";
  public static final String TAG_WALLET_AUTH = "Q.qwallet.auth";
  public static final String TAG_WALLET_HOME = "Q.qwallet.home";
  public static final String TAG_WALLET_OPEN = "Q.qwallet.open";
  public static final String TAG_WALLET_PAY = "Q.qwallet.pay";
  public static final String TAG_WALLET_PUSH = "Q.qwallet.push";
  public static final String TAG_WALLET_REALEVENT = "Q.qwallet.realevent";
  public static final String TAG_WALLET_REDPACK = "Q.qwallet.redpack";
  public static final long TIME_PROTECTED_LAUNCH = 5000L;
  public static final String TROOP_HBLIST_BROADCAST_ACTION = "troop_hblist_broadcast_action";
  public static final int TROOP_HBLIST_CLOSE_RESULT_CODE = -20180323;
  public static final int TROOP_HBLIST_GRAPHB_RESULT_CODE = -20180322;
  public static final long UPDATE_TROOP_TIME_INTERVAL = 1800000L;
  
  public abstract void clearInstance(BaseQQAppInterface paramBaseQQAppInterface);
  
  public abstract AppRuntime createQWalletAppInterface(Context paramContext, String paramString);
  
  public abstract void doF2FRedpack(AppInterface paramAppInterface, Activity paramActivity, String paramString);
  
  public abstract void doQRCodePay(AppInterface paramAppInterface, Activity paramActivity, String paramString, OnQRHandleResultCallback paramOnQRHandleResultCallback);
  
  public abstract void doQWalletQRCode(AppInterface paramAppInterface, Activity paramActivity, String paramString);
  
  public abstract String getAppInfoFromHistory(WebView paramWebView);
  
  public abstract BaseQQAppInterface getAppInterface();
  
  public abstract String getCorrectAppInfo(String paramString1, String paramString2);
  
  public abstract void getPayCode(BaseQQAppInterface paramBaseQQAppInterface);
  
  public abstract String getQWalletExternalPath();
  
  public abstract String getQWalletInternalPath();
  
  public abstract Class<? extends Activity> getQWalletProxyActivityClass();
  
  public abstract AppRuntime getRuntime();
  
  public abstract void gotoF2FRedpack(String paramString1, String paramString2, Activity paramActivity, String paramString3, boolean paramBoolean, long paramLong);
  
  public abstract void gotoQWalletHome(Activity paramActivity);
  
  public abstract boolean isLaunchPayPluginAct(Bundle paramBundle, Context paramContext);
  
  public abstract boolean isValidToLaunchQWallet(long paramLong);
  
  public abstract void launchPayService(Context paramContext, AppRuntime paramAppRuntime, Bundle paramBundle);
  
  public abstract void launchQWalletAct(QBaseActivity paramQBaseActivity, BaseQQAppInterface paramBaseQQAppInterface, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void preloadQWallet(AppInterface paramAppInterface);
  
  public abstract void preloadQWallet(AppRuntime paramAppRuntime, int paramInt, String paramString);
  
  public abstract void resetLaunchTime();
  
  public abstract void updateHongBaoSpeedWitch(BaseQQAppInterface paramBaseQQAppInterface, String paramString);
  
  public abstract void updatePublicAccWhiteMap(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qwallet.plugin.IQWalletHelper
 * JD-Core Version:    0.7.0.1
 */