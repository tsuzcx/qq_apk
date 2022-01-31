package com.tencent.mobileqq.mini.servlet;

import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class MiniAppObserver
  implements BusinessObserver
{
  public static final int MINI_APP_BATCH_GET_CONTACT = 1039;
  public static final int MINI_APP_BATCH_GET_USER_INFO = 1028;
  public static final int MINI_APP_BATCH_QUERY_APP_INFO = 1013;
  static final int MINI_APP_CHANGE_SHARE_IMAGE_URL = 1029;
  public static final int MINI_APP_CHECK_NAVIGATE_RIGHT = 1023;
  public static final int MINI_APP_CHECK_OFFER_ID = 1021;
  public static final int MINI_APP_CHECK_SESSION = 1002;
  public static final int MINI_APP_DC_REPORT = 1005;
  public static final int MINI_APP_DEL_ITEM = 1006;
  public static final int MINI_APP_DO_LIKE = 1009;
  public static final int MINI_APP_GET_APPINFO_BY_ID = 1024;
  public static final int MINI_APP_GET_APPINFO_BY_ID_FOR_SDK = 1055;
  public static final int MINI_APP_GET_APPINFO_BY_LINK = 1003;
  public static final int MINI_APP_GET_APPINFO_BY_LINK_FOR_SDK = 1056;
  public static final int MINI_APP_GET_AUTH_LIST = 1043;
  public static final int MINI_APP_GET_CONETNT_ACCELERATE = 1070;
  public static final int MINI_APP_GET_EXT_CONFIG_DETAIL = 1040;
  static final int MINI_APP_GET_FORM_ID = 1020;
  public static final int MINI_APP_GET_FRIEND_CLOUD_STORAGE = 1019;
  public static final int MINI_APP_GET_GROUP_CLOUD_STORAGE = 1018;
  public static final int MINI_APP_GET_GROUP_SHARE_INFO = 1033;
  public static final int MINI_APP_GET_HOT_SEARCH_APPS = 1071;
  public static final int MINI_APP_GET_KUOLIE_APPLIST = 1044;
  public static final int MINI_APP_GET_LOGIN_CODE = 1000;
  public static final int MINI_APP_GET_MINE_STORY_FEED_LIST = 1031;
  public static final int MINI_APP_GET_NATIVE_APPINFO = 1030;
  public static final int MINI_APP_GET_NEW_BASELIB = 1004;
  public static final int MINI_APP_GET_NEW_BASELIB_FOR_SDK = 1057;
  public static final int MINI_APP_GET_PHONE_NUMBER = 1053;
  public static final int MINI_APP_GET_POTENTIAL_FRIEND_LIST = 1060;
  public static final int MINI_APP_GET_PROFILE = 1001;
  public static final int MINI_APP_GET_RECOMMEND_APP_LIST = 1048;
  public static final int MINI_APP_GET_REWARDED_VIDEO_AD_RESULT = 1027;
  public static final int MINI_APP_GET_ROBOT_UIN = 1045;
  public static final int MINI_APP_GET_SHARE_INFO = 1012;
  static final int MINI_APP_GET_STORE_APP_LIST = 1022;
  public static final int MINI_APP_GET_SWITCH_LIST = 1049;
  public static final int MINI_APP_GET_TCB_TICKET = 1046;
  public static final int MINI_APP_GET_USER_APP_INFO = 1008;
  public static final int MINI_APP_GET_USER_APP_LIST = 1010;
  public static final int MINI_APP_GET_USER_APP_LIST_V2 = 1047;
  public static final int MINI_APP_GET_USER_CLOUD_STORAGE = 1016;
  public static final int MINI_APP_GET_USER_GROUP_INFO = 1062;
  public static final int MINI_APP_GET_USER_HEALTH_DATA = 1041;
  public static final int MINI_APP_GET_USER_INFO_EXTRA = 1032;
  public static final int MINI_APP_GET_USER_INTERACTIVE_STORAGE_SERVLET = 1059;
  public static final int MINI_APP_GET_USER_SETTING = 1051;
  public static final int MINI_APP_LOCAL_SEARCH_DATA = 1011;
  public static final int MINI_APP_MIDAS_CONSUME_RESULT = 1025;
  public static final int MINI_APP_MIDAS_QUERY_RESULT = 1026;
  public static final int MINI_APP_MODIFY_FRIEND_INTERACTIVE_STORAGE_SERVLET = 1058;
  public static final int MINI_APP_OPEN_CHANNEL = 1054;
  public static final int MINI_APP_REMOVE_USER_CLOUD_STORAGE = 1017;
  public static final int MINI_APP_REPORT_LOG_FILE_URL = 1035;
  public static final int MINI_APP_REPORT_SHARE = 1063;
  public static final int MINI_APP_SEARCH_APP = 1072;
  public static final int MINI_APP_SEND_ARK_MSG = 1061;
  public static final int MINI_APP_SET_AUTH = 1042;
  public static final int MINI_APP_SET_AVATAR = 1034;
  public static final int MINI_APP_SET_TOP = 1007;
  public static final int MINI_APP_SET_USER_CLOUD_STORAGE = 1015;
  public static final int MINI_APP_SET_USER_SWITCH = 1050;
  public static final int MINI_APP_TRANS_FOR_ROOM_ID = 1037;
  public static final int MINI_APP_TRANS_FOR_TINY_ID = 1036;
  public static final int MINI_APP_UPDATE_USER_SETTING = 1052;
  public static final int MINI_APP_USE_USER_APP = 1014;
  public static final int MINI_APP_VERIFY_PLUGIN = 1038;
  public static final String TAG = "[mini] MiniAppObserver";
  
  public static String getCmdByObserverId(int paramInt)
  {
    if (1000 == paramInt) {
      return "MINI_APP_GET_LOGIN_CODE";
    }
    if (1001 == paramInt) {
      return "MINI_APP_GET_PROFILE";
    }
    if (1002 == paramInt) {
      return "MINI_APP_CHECK_SESSION";
    }
    if (1003 == paramInt) {
      return "MINI_APP_GET_APPINFO_BY_LINK";
    }
    if (1004 == paramInt) {
      return "MINI_APP_GET_NEW_BASELIB";
    }
    if (1005 == paramInt) {
      return "MINI_APP_DC_REPORT";
    }
    if (1006 == paramInt) {
      return "MINI_APP_DEL_ITEM";
    }
    if (1007 == paramInt) {
      return "MINI_APP_SET_TOP";
    }
    if (1009 == paramInt) {
      return "MINI_APP_DO_LIKE";
    }
    if (1010 == paramInt) {
      return "MINI_APP_GET_USER_APP_LIST";
    }
    if (1011 == paramInt) {
      return "MINI_APP_LOCAL_SEARCH_DATA";
    }
    if (1012 == paramInt) {
      return "MINI_APP_GET_SHARE_INFO";
    }
    if (1013 == paramInt) {
      return "MINI_APP_BATCH_QUERY_APP_INFO";
    }
    if (1014 == paramInt) {
      return "MINI_APP_USE_USER_APP";
    }
    if (1015 == paramInt) {
      return "MINI_APP_SET_USER_CLOUD_STORAGE";
    }
    if (1016 == paramInt) {
      return "MINI_APP_GET_USER_CLOUD_STORAGE";
    }
    if (1017 == paramInt) {
      return "MINI_APP_REMOVE_USER_CLOUD_STORAGE";
    }
    if (1018 == paramInt) {
      return "MINI_APP_GET_GROUP_CLOUD_STORAGE";
    }
    if (1019 == paramInt) {
      return "MINI_APP_GET_FRIEND_CLOUD_STORAGE";
    }
    if (1020 == paramInt) {
      return "MINI_APP_GET_FORM_ID";
    }
    if (1021 == paramInt) {
      return "MINI_APP_CHECK_OFFER_ID";
    }
    if (1022 == paramInt) {
      return "MINI_APP_GET_STORE_APP_LIST";
    }
    if (1023 == paramInt) {
      return "MINI_APP_CHECK_NAVIGATE_RIGHT";
    }
    if (1024 == paramInt) {
      return "MINI_APP_GET_APPINFO_BY_ID";
    }
    if (1025 == paramInt) {
      return "MINI_APP_MIDAS_CONSUME_RESULT";
    }
    if (1026 == paramInt) {
      return "MINI_APP_MIDAS_QUERY_RESULT";
    }
    if (1027 == paramInt) {
      return "MINI_APP_GET_REWARDED_VIDEO_AD_RESULT";
    }
    if (1028 == paramInt) {
      return "MINI_APP_BATCH_GET_USER_INFO";
    }
    if (1029 == paramInt) {
      return "MINI_APP_CHANGE_SHARE_IMAGE_URL";
    }
    if (1030 == paramInt) {
      return "MINI_APP_GET_NATIVE_APPINFO";
    }
    if (1031 == paramInt) {
      return "MINI_APP_GET_MINE_STORY_FEED_LIST";
    }
    if (1032 == paramInt) {
      return "MINI_APP_GET_USER_INFO_EXTRA";
    }
    if (1033 == paramInt) {
      return "MINI_APP_GET_GROUP_SHARE_INFO";
    }
    if (1034 == paramInt) {
      return "MINI_APP_SET_AVATAR";
    }
    if (1035 == paramInt) {
      return "MINI_APP_REPORT_LOG_FILE_URL";
    }
    if (1040 == paramInt) {
      return "MINI_APP_GET_EXT_CONFIG_DETAIL";
    }
    if (1051 == paramInt) {
      return "MINI_APP_GET_USER_SETTING";
    }
    if (1049 == paramInt) {
      return "MINI_APP_GET_SWITCH_LIST";
    }
    if (1050 == paramInt) {
      return "MINI_APP_SET_USER_SWITCH";
    }
    if (1046 == paramInt) {
      return "MINI_APP_GET_TCB_TICKET";
    }
    if (1047 == paramInt) {
      return "MINI_APP_GET_USER_APP_LIST_V2";
    }
    if (1048 == paramInt) {
      return "MINI_APP_GET_RECOMMEND_APP_LIST";
    }
    if (1038 == paramInt) {
      return "MINI_APP_VERIFY_PLUGIN";
    }
    if (1039 == paramInt) {
      return "MINI_APP_BATCH_GET_CONTACT";
    }
    if (1008 == paramInt) {
      return "MINI_APP_GET_USER_APP_INFO";
    }
    if (1036 == paramInt) {
      return "MINI_APP_TRANS_FOR_TINY_ID";
    }
    if (1037 == paramInt) {
      return "MINI_APP_TRANS_FOR_ROOM_ID";
    }
    if (1041 == paramInt) {
      return "MINI_APP_GET_USER_HEALTH_DATA";
    }
    if (1042 == paramInt) {
      return "MINI_APP_SET_AUTH";
    }
    if (1043 == paramInt) {
      return "MINI_APP_GET_AUTH_LIST";
    }
    if (1044 == paramInt) {
      return "MINI_APP_GET_KUOLIE_APPLIST";
    }
    if (1045 == paramInt) {
      return "MINI_APP_GET_ROBOT_UIN";
    }
    if (1054 == paramInt) {
      return "MINI_APP_OPEN_CHANNEL";
    }
    if (1055 == paramInt) {
      return "MINI_APP_GET_APPINFO_BY_ID_FOR_SDK";
    }
    if (1056 == paramInt) {
      return "MINI_APP_GET_APPINFO_BY_LINK_FOR_SDK";
    }
    if (1057 == paramInt) {
      return "MINI_APP_GET_NEW_BASELIB_FOR_SDK";
    }
    if (1058 == paramInt) {
      return "MINI_APP_MODIFY_FRIEND_INTERACTIVE_STORAGE_SERVLET";
    }
    if (1059 == paramInt) {
      return "MINI_APP_GET_USER_INTERACTIVE_STORAGE_SERVLET";
    }
    if (1060 == paramInt) {
      return "MINI_APP_GET_POTENTIAL_FRIEND_LIST";
    }
    if (1061 == paramInt) {
      return "MINI_APP_SEND_ARK_MSG";
    }
    if (1062 == paramInt) {
      return "MINI_APP_GET_USER_GROUP_INFO";
    }
    if (1063 == paramInt) {
      return "MINI_APP_REPORT_SHARE";
    }
    if (1070 == paramInt) {
      return "MINI_APP_GET_CONETNT_ACCELERATE";
    }
    if (1071 == paramInt) {
      return "MINI_APP_GET_HOT_SEARCH_APPS";
    }
    if (1072 == paramInt) {
      return "MINI_APP_SEARCH_APP";
    }
    return "default cmd";
  }
  
  public void doOnReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBundle == null) {
      if (QLog.isColorLevel()) {
        QLog.d("[mini] MiniAppObserver", 2, "onReceive data is null");
      }
    }
    int i;
    do
    {
      return;
      i = paramBundle.getInt("key_index", -1);
      String str = paramBundle.getString("key_appid");
      if (paramInt == 1000)
      {
        onGetLoginCodeFin(i, paramBoolean, paramBundle.getString("code"));
        return;
      }
      if (paramInt == 1001)
      {
        onGetProfileFin(i, str, paramBoolean, paramBundle.getString("nick"), paramBundle.getString("avatar"), paramBundle.getInt("gender"), paramBundle.getString("country"), paramBundle.getString("province"), paramBundle.getString("city"), paramBundle.getString("language"), paramBundle.getString("rawData", ""), paramBundle.getString("signature", ""), paramBundle.getString("encryptedData", ""), paramBundle.getString("iv", ""));
        return;
      }
      if (paramInt == 1002)
      {
        long l = paramBundle.getLong("ret");
        paramBundle = paramBundle.getString("errMsg");
        onCheckSessionFin(i, paramBoolean, (int)l, paramBundle);
        return;
      }
      if (paramInt == 1003)
      {
        onGetAppInfoByLinkFin(i, paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1004)
      {
        onGetNewBaseLibFin(i, paramBoolean, paramBundle.getString("version"), paramBundle.getString("downloadUrl"), paramBundle);
        return;
      }
      if (paramInt == 1005)
      {
        onDcReport(i, paramBoolean, paramBundle.getInt("ret"));
        return;
      }
      if (paramInt == 1006)
      {
        onDelMiniAppFin(i, paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1007)
      {
        onSetTopMiniAppFin(i, paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1008)
      {
        onGetUserAppInfoFin(i, paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1009)
      {
        onSetUserAppLikeFin(i, paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1010)
      {
        onGetUserAppList(i, paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1011)
      {
        onLocalSearchDataFin(i, paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1031)
      {
        onGetMineStoryFeedList(i, paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1012)
      {
        onGetShareInfo(i, paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1029)
      {
        onChangeShareImageUrl(i, paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1013)
      {
        onBatchQueryAppInfoFin(i, paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1014)
      {
        onUseUserAppFin(i, paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1015)
      {
        onSetuserCloudStorage(i, paramBoolean);
        return;
      }
      if (paramInt == 1017)
      {
        onRemoveuserCloudStorage(i, paramBoolean);
        return;
      }
      if (paramInt == 1016)
      {
        onGetuserCloudStorage(i, paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1018)
      {
        onGetGroupCloudStorage(i, paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1019)
      {
        onGetFriendCloudStorage(i, paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1020)
      {
        onGetFormId(i, paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1021)
      {
        onCheckOfferIdFin(i, paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1022)
      {
        onGetStoreAppList(i, paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1023)
      {
        onCheckNavigateRightServlet(i, paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1024)
      {
        onGetAppInfoByIdServlet(i, paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1025)
      {
        onGetMidasConsumeResult(i, paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1026)
      {
        onGetMidasQueryResult(i, paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1027)
      {
        onGetRewardedVideoAdResult(i, paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1028)
      {
        onBatchGetUserInfoResult(i, paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1030)
      {
        onGetNativeAppInfoForJump(i, paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1032)
      {
        onGetUserInfoExtra(i, paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1033)
      {
        onGetGroupShareInfo(i, paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1034)
      {
        onSetAvatar(i, paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1035)
      {
        onReportLogFileUrlServlet(i, paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1036)
      {
        onTransForOpenIdAndTinyId(i, paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1037)
      {
        onTransForRoomId(i, paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1039)
      {
        onBatchGetContact(i, paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1038)
      {
        onVerifyPlugin(i, paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1040)
      {
        onGetExtConfigDetail(i, paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1041)
      {
        onGetUserHealthData(i, paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1042)
      {
        onSetAuth(i, paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1043)
      {
        onGetAuthList(i, paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1044)
      {
        onGetKuolieAppListServlet(i, paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1045)
      {
        onGetRobotUin(i, paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1046)
      {
        onGetTcbTicket(i, paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1047)
      {
        onGetUserAppListV2(i, paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1048)
      {
        onGetRecommendAppList(i, paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1049)
      {
        onGetSwitchList(i, paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1050)
      {
        onSetUserSwitch(i, paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1051)
      {
        onGetUserSetting(i, paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1052)
      {
        onUpdateUserSetting(i, paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1053)
      {
        onGetPhoneNumber(i, paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1054)
      {
        onOpenChannel(i, paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1055)
      {
        onGetAppInfoByIdForSDKServlet(i, paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1056)
      {
        onGetAppInfoByLinkFinForSDK(i, paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1057)
      {
        onGetNewBaseLibFinForSDK(i, paramBoolean, paramBundle.getString("version"), paramBundle.getString("downloadUrl"), paramBundle);
        return;
      }
      if (paramInt == 1058)
      {
        onModifyFriendInteractiveStorage(i, paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1059)
      {
        onGetUserInteractiveStorage(i, paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1060)
      {
        onGetPotentialFriendList(i, paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1061)
      {
        onSendArkMsg(i, paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1062)
      {
        onGetUserGroupInfo(i, paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1063)
      {
        onReportShare(i, paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1070)
      {
        onGetContentAccelerateServlet(i, paramBoolean, paramBundle);
        return;
      }
      if (paramInt == 1071)
      {
        onGetHotSearchApps(i, paramBoolean, paramBundle);
        return;
      }
    } while (paramInt != 1072);
    onSearchApp(i, paramBoolean, paramBundle);
  }
  
  protected void onBatchGetContact(int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onBatchGetUserInfoResult(int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onBatchQueryAppInfoFin(int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onChangeShareImageUrl(int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onCheckNavigateRightServlet(int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onCheckOfferIdFin(int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onCheckSessionFin(int paramInt1, boolean paramBoolean, int paramInt2, String paramString) {}
  
  protected void onDcReport(int paramInt1, boolean paramBoolean, int paramInt2) {}
  
  protected void onDelMiniAppFin(int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onGetAppInfoByIdForSDKServlet(int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onGetAppInfoByIdServlet(int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onGetAppInfoByLinkFin(int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onGetAppInfoByLinkFinForSDK(int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onGetAuthList(int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onGetContentAccelerateServlet(int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onGetExtConfigDetail(int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onGetFormId(int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onGetFriendCloudStorage(int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onGetGroupCloudStorage(int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onGetGroupShareInfo(int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onGetHotSearchApps(int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onGetKuolieAppListServlet(int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onGetLoginCodeFin(int paramInt, boolean paramBoolean, String paramString) {}
  
  protected void onGetMidasConsumeResult(int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onGetMidasQueryResult(int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onGetMineStoryFeedList(int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onGetNativeAppInfoForJump(int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onGetNewBaseLibFin(int paramInt, boolean paramBoolean, String paramString1, String paramString2, Bundle paramBundle) {}
  
  protected void onGetNewBaseLibFinForSDK(int paramInt, boolean paramBoolean, String paramString1, String paramString2, Bundle paramBundle) {}
  
  protected void onGetPhoneNumber(int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onGetPotentialFriendList(int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onGetProfileFin(int paramInt1, String paramString1, boolean paramBoolean, String paramString2, String paramString3, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11) {}
  
  protected void onGetRecommendAppList(int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onGetRewardedVideoAdResult(int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onGetRobotUin(int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onGetShareInfo(int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onGetStoreAppList(int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onGetSwitchList(int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onGetTcbTicket(int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onGetUserAppInfoFin(int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onGetUserAppList(int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onGetUserAppListV2(int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onGetUserGroupInfo(int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onGetUserHealthData(int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onGetUserInfoExtra(int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onGetUserInteractiveStorage(int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onGetUserSetting(int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onGetuserCloudStorage(int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onLocalSearchDataFin(int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onModifyFriendInteractiveStorage(int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onOpenChannel(int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    ThreadManagerV2.excute(new MiniAppObserver.1(this, paramInt, paramBoolean, paramBundle), 16, null, false);
  }
  
  protected void onRemoveuserCloudStorage(int paramInt, boolean paramBoolean) {}
  
  protected void onReportLogFileUrlServlet(int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onReportShare(int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onSearchApp(int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onSendArkMsg(int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onSetAuth(int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onSetAvatar(int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onSetTopMiniAppFin(int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onSetUserAppLikeFin(int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onSetUserSwitch(int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onSetuserCloudStorage(int paramInt, boolean paramBoolean) {}
  
  protected void onTransForOpenIdAndTinyId(int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onTransForRoomId(int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onUpdateUserSetting(int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onUseUserAppFin(int paramInt, boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onVerifyPlugin(int paramInt, boolean paramBoolean, Bundle paramBundle) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.MiniAppObserver
 * JD-Core Version:    0.7.0.1
 */