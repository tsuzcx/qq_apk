package com.tencent.mobileqq.mini.reuse;

import NS_COMM.COMM.StCommonExt;
import NS_MINI_AD.MiniAppAd.ContextInfo;
import NS_MINI_AD.MiniAppAd.DebugInfo;
import NS_MINI_AD.MiniAppAd.DeviceInfo;
import NS_MINI_AD.MiniAppAd.PositionInfo;
import NS_MINI_AD.MiniAppAd.StGetAdReq;
import NS_MINI_AD.MiniAppAd.UserInfo;
import NS_MINI_CLOUDSTORAGE.CloudStorage.StInteractiveTemplate;
import NS_MINI_INTERFACE.INTERFACE.StUserAuthInfo;
import NS_MINI_INTERFACE.INTERFACE.StUserSettingInfo;
import NS_MINI_SHARE.MiniProgramShare.StAdaptShareInfoReq;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.config.business.MiniAppConfProcessor;
import com.tencent.mobileqq.mini.apkg.ExtConfigInfo;
import com.tencent.mobileqq.mini.apkg.PluginInfo;
import com.tencent.mobileqq.mini.apkg.RecommendAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.GetAppListV2Scene;
import com.tencent.mobileqq.mini.network.http.HttpCmdManager;
import com.tencent.mobileqq.mini.servlet.BatchGetUserInfoServlet;
import com.tencent.mobileqq.mini.servlet.BookShelfInsertServlet;
import com.tencent.mobileqq.mini.servlet.BookShelfQueryServlet;
import com.tencent.mobileqq.mini.servlet.BookShelfUpdateServlet;
import com.tencent.mobileqq.mini.servlet.CMShowSetPetStatusServlet;
import com.tencent.mobileqq.mini.servlet.CheckBindingStateServlet;
import com.tencent.mobileqq.mini.servlet.CloudStorageServlet;
import com.tencent.mobileqq.mini.servlet.CreateUpdatableMsgServlet;
import com.tencent.mobileqq.mini.servlet.DoGameRaffleServlet;
import com.tencent.mobileqq.mini.servlet.FollowServlet;
import com.tencent.mobileqq.mini.servlet.GetCMShowInfoServlet;
import com.tencent.mobileqq.mini.servlet.GetGameRaffleMaterialServlet;
import com.tencent.mobileqq.mini.servlet.GetPotentialFriendListServlet;
import com.tencent.mobileqq.mini.servlet.GetReactiveFriendListServlet;
import com.tencent.mobileqq.mini.servlet.GetUserInteractiveStorageServlet;
import com.tencent.mobileqq.mini.servlet.GetWeixinSDKAppInfoServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppAddPhoneNumberServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppBatchGetContactServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppBatchQueryAppInfoServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppChangeShareImageUrlServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppCheckNavigateRightServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppCheckOfferIdServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppCheckSessionServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppContentAccelerateServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppDataReportServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppDcReportServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppDelPhoneNumberServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppDelUserAppServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppGeneralServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppGetAppInfoByIdForSDKServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppGetAppInfoByIdServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppGetAppInfoByLinkForSDKServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppGetAppInfoByLinkServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppGetAuthListServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppGetExtConfigDetailServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppGetFormIdServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGroupShareInfoServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppGetHotSearchAppsServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppGetKuolieApplistServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppGetLoginCodeServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppGetNativeAppInfoServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppGetNewBaseLibForSDKServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppGetNewBaseLibServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppGetPhoneNumberServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppGetProfileServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppGetRecommendAppListServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppGetRobotUinServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppGetShareInfoServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppGetSwitchListServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppGetTcbTicketServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppGetTinyIdServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppGetUserAppInfoServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppGetUserAppListServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppGetUserAppListServletV2;
import com.tencent.mobileqq.mini.servlet.MiniAppGetUserGroupInfoServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppGetUserInfoExtraServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppGetUserSettingServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppGuessYouLikeServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppLocalSearchDataServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppObserver;
import com.tencent.mobileqq.mini.servlet.MiniAppOpenChannelAbstractServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppRealTimeLogReportServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppReportLogFileServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppSearchAppServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppSendArkMsgServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppSetAuthsServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppSetUserSwitchServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppStoreGetAppListServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppTranRoomIdServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppUpdateUserSettingServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppUseUserAppServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppUserHealthDataServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppVerifyPluginServlet;
import com.tencent.mobileqq.mini.servlet.MiniMidasConsumeServlet;
import com.tencent.mobileqq.mini.servlet.MiniMidasQueryServlet;
import com.tencent.mobileqq.mini.servlet.MiniReportShareServlet;
import com.tencent.mobileqq.mini.servlet.MiniRewardedVideoAdServlet;
import com.tencent.mobileqq.mini.servlet.MiniWxPayCheckUrlServlet;
import com.tencent.mobileqq.mini.servlet.ModifyFriendInteractiveStorageServlet;
import com.tencent.mobileqq.mini.servlet.PersonalizeSetAvatarServlet;
import com.tencent.mobileqq.mini.servlet.RejectFrequentlyRecommendsServlet;
import com.tencent.mobileqq.mini.util.MiniAppSecurityUtil;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy.SenderListener;
import com.tencent.qqmini.sdk.launcher.model.RealTimeLogItem;
import cooperation.qzone.QUA;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class MiniAppCmdUtil
{
  public static final String KEY_APPID = "key_appid";
  public static final String KEY_APP_INFO = "key_app_info";
  public static final String KEY_APP_INFO_PB = "appInfo_pb";
  public static final String KEY_CMD_STRING = "key_cmd_string";
  public static final String KEY_ERROR_MSG = "errMsg";
  public static final String KEY_INDEX = "key_index";
  public static final String KEY_LIBTYPE = "key_libtype";
  public static final String KEY_REQ_DATA = "key_request_data";
  public static final String KEY_RETURN_CODE = "retCode";
  public static final String KEY_RSP_DATA = "key_response_data";
  public static final String KEY_UIN = "key_uin";
  public static final long MINI_RET_CODE_SUB_SWITCH_OFF = 20004L;
  public static final long MINI_RET_CODE_TEMPLATEID_COUNT_OUT_OF_MAX = 20003L;
  public static final long MINI_RET_CODE_TEMPLATEID_INVAILD = 20001L;
  public static final long RET_CODE_SUB_SWITCH_OFF = -101511021L;
  public static final long RET_CODE_TEMPLATEID_COUNT_OUT_OF_MAX = -101511020L;
  public static final long RET_CODE_TEMPLATEID_INVAILD = -101511014L;
  public static String TAG = "MiniAppCmdUtil";
  private static volatile AtomicInteger index = new AtomicInteger(0);
  private static volatile MiniAppCmdUtil instance;
  private MiniAppObserver cmdObserver;
  private ConcurrentHashMap<Integer, MiniAppCmdInterface> listenerMap;
  private ConcurrentHashMap<Integer, MiniAppProxy.SenderListener> senderListenerMap;
  
  private MiniAppCmdUtil()
  {
    if (this.listenerMap == null) {
      this.listenerMap = new ConcurrentHashMap();
    }
    if (this.senderListenerMap == null) {
      this.senderListenerMap = new ConcurrentHashMap();
    }
    if (this.cmdObserver == null) {
      this.cmdObserver = new MiniAppCmdUtil.1(this);
    }
  }
  
  public static int getCallbackIndex()
  {
    return index.getAndIncrement();
  }
  
  private int getCurrentListenerIndex(MiniAppCmdInterface paramMiniAppCmdInterface, String paramString)
  {
    int i = index.incrementAndGet();
    Object localObject = this.listenerMap;
    if ((localObject != null) && (!((ConcurrentHashMap)localObject).containsKey(Integer.valueOf(i))) && (paramMiniAppCmdInterface != null))
    {
      this.listenerMap.put(Integer.valueOf(i), paramMiniAppCmdInterface);
      return i;
    }
    paramMiniAppCmdInterface = TAG;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" index error");
    QLog.e(paramMiniAppCmdInterface, 1, ((StringBuilder)localObject).toString());
    return i;
  }
  
  private int getCurrentListenerIndex(MiniAppProxy.SenderListener paramSenderListener, String paramString)
  {
    int i = index.incrementAndGet();
    Object localObject = this.senderListenerMap;
    if ((localObject != null) && (!((ConcurrentHashMap)localObject).containsKey(Integer.valueOf(i))) && (paramSenderListener != null))
    {
      this.senderListenerMap.put(Integer.valueOf(i), paramSenderListener);
      return i;
    }
    paramSenderListener = TAG;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" index error");
    QLog.e(paramSenderListener, 1, ((StringBuilder)localObject).toString());
    return i;
  }
  
  public static MiniAppCmdUtil getInstance()
  {
    if (instance == null) {
      try
      {
        if (instance == null) {
          instance = new MiniAppCmdUtil();
        }
      }
      finally {}
    }
    return instance;
  }
  
  public static int getReqSeqIndex()
  {
    return index.incrementAndGet();
  }
  
  private void sendCloudRequest(String paramString1, String[] paramArrayOfString, MiniAppCmdInterface paramMiniAppCmdInterface, String paramString2)
  {
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), CloudStorageServlet.class, paramMiniAppCmdInterface, "sendCloudRequest");
    paramMiniAppCmdInterface.putExtra("key_data", paramArrayOfString);
    paramMiniAppCmdInterface.putExtra("request_type", paramString2);
    paramMiniAppCmdInterface.putExtra("app_id", paramString1);
    paramMiniAppCmdInterface.setObserver(this.cmdObserver);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  private boolean shouldUpdateExtConfig(String paramString1, String paramString2)
  {
    boolean bool2 = paramString1.equals(paramString2);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    paramString1 = paramString1.split("\\.");
    paramString2 = paramString2.split("\\.");
    int i = 0;
    for (;;)
    {
      if (i < paramString1.length) {}
      try
      {
        if (i >= paramString2.length) {
          return false;
        }
        int j = Integer.parseInt(paramString1[i]);
        int k = Integer.parseInt(paramString2[i]);
        if (j > k) {
          return false;
        }
        if (j < k) {
          return true;
        }
        i += 1;
      }
      catch (Throwable paramString1) {}
    }
    if (paramString2.length > paramString1.length) {
      bool1 = true;
    }
    return bool1;
    return true;
  }
  
  public void OpenChannel(byte[] paramArrayOfByte, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), MiniAppOpenChannelAbstractServlet.class, paramMiniAppCmdInterface, "OpenChannel").putExtra("key_data", paramArrayOfByte);
  }
  
  public void addPhoneNumber(String paramString1, String paramString2, String paramString3, int paramInt, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), MiniAppAddPhoneNumberServlet.class, paramMiniAppCmdInterface, "addPhoneNumber");
    paramMiniAppCmdInterface.putExtra("key_appid", paramString1);
    paramMiniAppCmdInterface.putExtra("purePhoneNumber", paramString2);
    paramMiniAppCmdInterface.putExtra("countryCode", paramString3);
    paramMiniAppCmdInterface.putExtra("isSave", paramInt);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void batchGetContact(ArrayList<String> paramArrayList, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), MiniAppBatchGetContactServlet.class, paramMiniAppCmdInterface, "batchGetContact");
    paramMiniAppCmdInterface.putStringArrayListExtra("key_app_ids", paramArrayList);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void batchGetFollowingCount(ArrayList<String> paramArrayList, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), FollowServlet.class, paramMiniAppCmdInterface, "batchGetFollowingCount");
    paramMiniAppCmdInterface.putStringArrayListExtra("key_appid_list", paramArrayList);
    paramMiniAppCmdInterface.setObserver(this.cmdObserver);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void changeShareImageUrl(String paramString, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), MiniAppChangeShareImageUrlServlet.class, paramMiniAppCmdInterface, "changeShareImageUrl");
    paramMiniAppCmdInterface.putExtra("key_old_image_url", paramString);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void checkBindingState(String paramString1, String paramString2, int paramInt, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), CheckBindingStateServlet.class, paramMiniAppCmdInterface, "checkBindingState");
    paramMiniAppCmdInterface.putExtra("key_uid", paramString2);
    paramMiniAppCmdInterface.putExtra("key_appId", paramString1);
    paramMiniAppCmdInterface.putExtra("key_bindType", paramInt);
    paramMiniAppCmdInterface.setObserver(this.cmdObserver);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void checkNavigateRight(String paramString1, String paramString2, COMM.StCommonExt paramStCommonExt, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    String str = MiniAppSecurityUtil.getLoginMiniAppUin(BaseApplicationImpl.getApplication());
    str = MiniAppSecurityUtil.getLoginMiniAppForbidToken(BaseApplicationImpl.getApplication(), str);
    int i = 0;
    if (MiniAppConfProcessor.a("miniappsendrequestbyhttps", 0) == 0) {
      i = 1;
    }
    if ((!TextUtils.isEmpty(str)) && (i != 0))
    {
      QLog.d(TAG, 1, "[miniapp-https-request].checkNavigateRight, send request by https.");
      HttpCmdManager.g().checkNavigateRight(paramString1, paramString2, str, new MiniAppCmdUtil.7(this, paramMiniAppCmdInterface));
      return;
    }
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), MiniAppCheckNavigateRightServlet.class, paramMiniAppCmdInterface, "checkNavigateRight");
    paramMiniAppCmdInterface.putExtra("key_appid", paramString1);
    paramMiniAppCmdInterface.putExtra("target_app_id", paramString2);
    if (paramStCommonExt != null) {
      paramMiniAppCmdInterface.putExtra("key_ext", paramStCommonExt.toByteArray());
    }
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void checkOfferId(String paramString1, String paramString2, COMM.StCommonExt paramStCommonExt, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), MiniAppCheckOfferIdServlet.class, paramMiniAppCmdInterface, "checkOfferId");
    paramMiniAppCmdInterface.putExtra("key_appid", paramString1);
    paramMiniAppCmdInterface.putExtra("key_offer_id", paramString2);
    if (paramStCommonExt != null) {
      paramMiniAppCmdInterface.putExtra("key_ext", paramStCommonExt.toByteArray());
    }
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void checkSession(String paramString, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), MiniAppCheckSessionServlet.class, paramMiniAppCmdInterface, "checkSession");
    try
    {
      paramMiniAppCmdInterface.putExtra("key_uin", Long.valueOf(BaseApplicationImpl.getApplication().getRuntime().getAccount()));
    }
    catch (Exception localException)
    {
      QLog.e(TAG, 1, "checkSession ", localException);
    }
    paramMiniAppCmdInterface.putExtra("key_appid", paramString);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void checkWxPayUrl(String paramString1, String paramString2, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), MiniWxPayCheckUrlServlet.class, paramMiniAppCmdInterface, "wxPayCheckUrl");
    paramMiniAppCmdInterface.putExtra("key_appid", paramString1);
    paramMiniAppCmdInterface.putExtra("key_url", paramString2);
    paramMiniAppCmdInterface.setObserver(this.cmdObserver);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void createUpdatableMsg(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, int paramInt4, byte[] paramArrayOfByte, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), CreateUpdatableMsgServlet.class, paramMiniAppCmdInterface, "createUpdatableMsg");
    paramMiniAppCmdInterface.putExtra("key_appid", paramString1);
    paramMiniAppCmdInterface.putExtra("key_template_id", paramString2);
    paramMiniAppCmdInterface.putExtra("key_from", paramInt1);
    paramMiniAppCmdInterface.putExtra("key_scene", paramInt2);
    paramMiniAppCmdInterface.putExtra("key_sub_scene", paramInt3);
    paramMiniAppCmdInterface.putExtra("key_uin", paramString3);
    paramMiniAppCmdInterface.putExtra("key_service_type", paramInt4);
    paramMiniAppCmdInterface.putExtra("key_sig", paramArrayOfByte);
    paramMiniAppCmdInterface.setObserver(this.cmdObserver);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void createUpdatableMsg(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    createUpdatableMsg(paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramString3, 0, null, paramMiniAppCmdInterface);
  }
  
  public void delPhoneNumber(String paramString1, String paramString2, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), MiniAppDelPhoneNumberServlet.class, paramMiniAppCmdInterface, "delPhoneNumbers");
    paramMiniAppCmdInterface.putExtra("key_appid", paramString1);
    paramMiniAppCmdInterface.putExtra("purePhoneNumber", paramString2);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void delUserApp(String paramString, int paramInt1, int paramInt2, int paramInt3, COMM.StCommonExt paramStCommonExt, int paramInt4, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), MiniAppDelUserAppServlet.class, paramMiniAppCmdInterface, "delUserApp");
    paramMiniAppCmdInterface.putExtra("key_appid", paramString);
    paramMiniAppCmdInterface.putExtra("key_version_type", paramInt1);
    paramMiniAppCmdInterface.putExtra("key_is_recommend", paramInt2);
    paramMiniAppCmdInterface.putExtra("key_source_type", paramInt3);
    paramMiniAppCmdInterface.putExtra("key_NoDelTop", paramInt4);
    if (paramStCommonExt != null) {
      paramMiniAppCmdInterface.putExtra("key_ext", paramStCommonExt.toByteArray());
    }
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void delUserApp(String paramString, int paramInt1, int paramInt2, int paramInt3, COMM.StCommonExt paramStCommonExt, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    delUserApp(paramString, paramInt1, paramInt2, paramInt3, paramStCommonExt, 0, paramMiniAppCmdInterface);
  }
  
  public void doGameRaffle(String paramString1, String paramString2, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), DoGameRaffleServlet.class, paramMiniAppCmdInterface, "doGameRaffle");
    paramMiniAppCmdInterface.putExtra("key_appid", paramString1);
    paramMiniAppCmdInterface.putExtra("key_uin", paramString2);
    paramMiniAppCmdInterface.setObserver(this.cmdObserver);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void getAppInfoById(COMM.StCommonExt paramStCommonExt, String paramString1, String paramString2, String paramString3, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    getAppInfoById(paramStCommonExt, paramString1, paramString2, paramString3, null, paramMiniAppCmdInterface);
  }
  
  public void getAppInfoById(COMM.StCommonExt paramStCommonExt, String paramString1, String paramString2, String paramString3, String paramString4, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    String str = MiniAppSecurityUtil.getLoginMiniAppUin(BaseApplicationImpl.getApplication());
    str = MiniAppSecurityUtil.getLoginMiniAppForbidToken(BaseApplicationImpl.getApplication(), str);
    int i = 0;
    if (MiniAppConfProcessor.a("miniappsendrequestbyhttps", 0) == 0) {
      i = 1;
    }
    if ((!TextUtils.isEmpty(str)) && (i != 0))
    {
      QLog.d(TAG, 1, "getAppInfoById, send request by https.");
      HttpCmdManager.g().getAppInfoById(paramStCommonExt, paramString1, paramString2, paramString3, str, paramString4, new MiniAppCmdUtil.4(this, paramMiniAppCmdInterface));
      return;
    }
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), MiniAppGetAppInfoByIdServlet.class, paramMiniAppCmdInterface, "getAppInfoById");
    paramMiniAppCmdInterface.putExtra("key_app_id", paramString1);
    paramMiniAppCmdInterface.putExtra("key_first_path", paramString2);
    paramMiniAppCmdInterface.putExtra("key_env_version", paramString3);
    if (paramString4 != null) {
      paramMiniAppCmdInterface.putExtra("key_from_app_id", paramString4);
    }
    if (paramStCommonExt != null) {
      paramMiniAppCmdInterface.putExtra("key_ext", paramStCommonExt.toByteArray());
    }
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void getAppInfoByIdForSDK(COMM.StCommonExt paramStCommonExt, String paramString1, String paramString2, String paramString3, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    getAppInfoByIdForSDK(paramStCommonExt, paramString1, paramString2, paramString3, null, paramMiniAppCmdInterface);
  }
  
  public void getAppInfoByIdForSDK(COMM.StCommonExt paramStCommonExt, String paramString1, String paramString2, String paramString3, String paramString4, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    String str = MiniAppSecurityUtil.getLoginMiniAppUin(BaseApplicationImpl.getApplication());
    str = MiniAppSecurityUtil.getLoginMiniAppForbidToken(BaseApplicationImpl.getApplication(), str);
    int i = 0;
    if (MiniAppConfProcessor.a("miniappsendrequestbyhttps", 0) == 0) {
      i = 1;
    }
    if ((!TextUtils.isEmpty(str)) && (i != 0))
    {
      QLog.d(TAG, 1, "getAppInfoByIdForSDK, send request by https.");
      HttpCmdManager.g().getAppInfoById(paramStCommonExt, paramString1, paramString2, paramString3, str, paramString4, new MiniAppCmdUtil.6(this, paramMiniAppCmdInterface));
      return;
    }
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), MiniAppGetAppInfoByIdForSDKServlet.class, paramMiniAppCmdInterface, "getAppInfoById");
    paramMiniAppCmdInterface.putExtra("key_app_id", paramString1);
    paramMiniAppCmdInterface.putExtra("key_first_path", paramString2);
    paramMiniAppCmdInterface.putExtra("key_env_version", paramString3);
    if (paramString4 != null) {
      paramMiniAppCmdInterface.putExtra("key_from_app_id", paramString4);
    }
    if (paramStCommonExt != null) {
      paramMiniAppCmdInterface.putExtra("key_ext", paramStCommonExt.toByteArray());
    }
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void getAppInfoByLink(String paramString, int paramInt, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    String str = MiniAppSecurityUtil.getLoginMiniAppUin(BaseApplicationImpl.getApplication());
    str = MiniAppSecurityUtil.getLoginMiniAppForbidToken(BaseApplicationImpl.getApplication(), str);
    int i = 0;
    if (MiniAppConfProcessor.a("miniappsendrequestbyhttps", 0) == 0) {
      i = 1;
    }
    if ((!TextUtils.isEmpty(str)) && (i != 0))
    {
      QLog.d(TAG, 1, "getAppInfoByLink, send request by https.");
      HttpCmdManager.g().getAppInfoByLink(paramString, paramInt, str, new MiniAppCmdUtil.3(this, paramMiniAppCmdInterface));
      return;
    }
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), MiniAppGetAppInfoByLinkServlet.class, paramMiniAppCmdInterface, "getAppInfoByLink");
    try
    {
      paramMiniAppCmdInterface.putExtra("key_uin", Long.valueOf(BaseApplicationImpl.getApplication().getRuntime().getAccount()));
    }
    catch (Exception localException)
    {
      QLog.e(TAG, 1, "getAppInfoByLink ", localException);
    }
    paramMiniAppCmdInterface.putExtra("key_link", paramString);
    paramMiniAppCmdInterface.putExtra("key_link_type", paramInt);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void getAppInfoByLinkForSDK(String paramString, int paramInt, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    String str = MiniAppSecurityUtil.getLoginMiniAppUin(BaseApplicationImpl.getApplication());
    str = MiniAppSecurityUtil.getLoginMiniAppForbidToken(BaseApplicationImpl.getApplication(), str);
    int i = 0;
    if (MiniAppConfProcessor.a("miniappsendrequestbyhttps", 0) == 0) {
      i = 1;
    }
    if ((!TextUtils.isEmpty(str)) && (i != 0))
    {
      QLog.d(TAG, 1, "getAppInfoByLinkForSDK, send request by https.");
      HttpCmdManager.g().getAppInfoByLink(paramString, paramInt, str, new MiniAppCmdUtil.5(this, paramMiniAppCmdInterface));
      return;
    }
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), MiniAppGetAppInfoByLinkForSDKServlet.class, paramMiniAppCmdInterface, "getAppInfoByLink");
    try
    {
      paramMiniAppCmdInterface.putExtra("key_uin", Long.valueOf(BaseApplicationImpl.getApplication().getRuntime().getAccount()));
    }
    catch (Exception localException)
    {
      QLog.e(TAG, 1, "getAppInfoByLinkForSDK ", localException);
    }
    paramMiniAppCmdInterface.putExtra("key_link", paramString);
    paramMiniAppCmdInterface.putExtra("key_link_type", paramInt);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void getAuthList(COMM.StCommonExt paramStCommonExt, String paramString, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), MiniAppGetAuthListServlet.class, paramMiniAppCmdInterface, "getAuthList");
    paramMiniAppCmdInterface.putExtra("key_appid", paramString);
    if (paramStCommonExt != null) {
      paramMiniAppCmdInterface.putExtra("key_ext", paramStCommonExt.toByteArray());
    }
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void getBatchQueryAppInfo(COMM.StCommonExt paramStCommonExt, ArrayList<String> paramArrayList, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), MiniAppBatchQueryAppInfoServlet.class, paramMiniAppCmdInterface, "getBatchQueryAppInfo");
    paramMiniAppCmdInterface.putStringArrayListExtra("key_appid_list", paramArrayList);
    if (paramStCommonExt != null) {
      paramMiniAppCmdInterface.putExtra("key_ext", paramStCommonExt.toByteArray());
    }
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void getCMShowInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), GetCMShowInfoServlet.class, paramMiniAppCmdInterface, "getCMShowInfo");
    paramMiniAppCmdInterface.putExtra("openids", paramString1);
    paramMiniAppCmdInterface.putExtra("appid", paramString2);
    paramMiniAppCmdInterface.putExtra("engine_name", paramString3);
    paramMiniAppCmdInterface.putExtra("engine_version", paramString4);
    paramMiniAppCmdInterface.putExtra("avatar_type", paramString5);
    paramMiniAppCmdInterface.setObserver(this.cmdObserver);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void getContentAccelerate(String paramString1, String paramString2, int paramInt, Map<String, String> paramMap, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), MiniAppContentAccelerateServlet.class, paramMiniAppCmdInterface, "getAppInfoById");
    paramMiniAppCmdInterface.putExtra("key_app_id", paramString1);
    paramMiniAppCmdInterface.putExtra("key_dataurl", paramString2);
    paramMiniAppCmdInterface.putExtra("key_need_code", paramInt);
    paramMiniAppCmdInterface.putExtra("mini_req_header", (Serializable)paramMap);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void getExtConfigDetail(byte[] paramArrayOfByte, ArrayList<ExtConfigInfo> paramArrayList, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.isEmpty()) {
        return;
      }
      ExtConfigInfo localExtConfigInfo = (ExtConfigInfo)paramArrayList.get(0);
      if (localExtConfigInfo != null)
      {
        if (localExtConfigInfo.configVersion == null) {
          return;
        }
        String str = BaseApplicationImpl.getApplication().getSharedPreferences("MiniAppExtConfigDetail", 4).getString("MiniAppExtConfigDetail", null);
        if (!TextUtils.isEmpty(str)) {
          try
          {
            str = new JSONObject(str).optString("configVersion");
            if (!TextUtils.isEmpty(str))
            {
              boolean bool = shouldUpdateExtConfig(str, localExtConfigInfo.configVersion);
              if (!bool) {
                return;
              }
            }
          }
          catch (Exception localException)
          {
            QLog.e(TAG, 1, "getExtConfigDetail parse json error", localException);
          }
        }
        paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), MiniAppGetExtConfigDetailServlet.class, paramMiniAppCmdInterface, "getExtConfigDetail");
        if (paramArrayOfByte != null) {
          paramMiniAppCmdInterface.putExtra("key_common_ext", paramArrayOfByte);
        }
        paramMiniAppCmdInterface.putParcelableArrayListExtra("key_ext_config_info", paramArrayList);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
      }
    }
  }
  
  public void getFormId(String paramString, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), MiniAppGetFormIdServlet.class, paramMiniAppCmdInterface, "getFormId");
    paramMiniAppCmdInterface.putExtra("key_appid", paramString);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void getFriendCloudStorage(String paramString, String[] paramArrayOfString, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    sendCloudRequest(paramString, paramArrayOfString, paramMiniAppCmdInterface, "get_friend_cloud_storage");
  }
  
  public void getGameRaffleMaterial(String paramString1, String paramString2, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), GetGameRaffleMaterialServlet.class, paramMiniAppCmdInterface, "getGameRaffleMaterial");
    paramMiniAppCmdInterface.putExtra("key_appid", paramString1);
    paramMiniAppCmdInterface.putExtra("key_uin", paramString2);
    paramMiniAppCmdInterface.setObserver(this.cmdObserver);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void getGroupCloudStorage(String paramString1, String paramString2, String[] paramArrayOfString, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), CloudStorageServlet.class, paramMiniAppCmdInterface, "getGroupCloudStorage");
    paramMiniAppCmdInterface.putExtra("key_shareticket", paramString2);
    paramMiniAppCmdInterface.putExtra("key_data", paramArrayOfString);
    paramMiniAppCmdInterface.putExtra("app_id", paramString1);
    paramMiniAppCmdInterface.putExtra("request_type", "get_group_cloud_storage");
    paramMiniAppCmdInterface.setObserver(this.cmdObserver);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void getGroupShareInfo(String paramString1, String paramString2, COMM.StCommonExt paramStCommonExt, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), MiniAppGetGroupShareInfoServlet.class, paramMiniAppCmdInterface, "getGroupShareInfo");
    paramMiniAppCmdInterface.putExtra("key_appid", paramString1);
    paramMiniAppCmdInterface.putExtra("key_shareTicket", paramString2);
    paramMiniAppCmdInterface.putExtra("key_appid", paramString1);
    if (paramStCommonExt != null) {
      paramMiniAppCmdInterface.putExtra("key_ext", paramStCommonExt.toByteArray());
    }
    paramMiniAppCmdInterface.setObserver(this.cmdObserver);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void getHotSearchApps(COMM.StCommonExt paramStCommonExt, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), MiniAppGetHotSearchAppsServlet.class, paramMiniAppCmdInterface, "GetHotSearchApps");
    if (paramStCommonExt != null) {
      paramMiniAppCmdInterface.putExtra("key_hot_search_ext_info", paramStCommonExt.toByteArray());
    }
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void getKuolieAppList(COMM.StCommonExt paramStCommonExt, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), MiniAppGetKuolieApplistServlet.class, paramMiniAppCmdInterface, "GetExpandAppList");
    if (paramStCommonExt != null) {
      paramMiniAppCmdInterface.putExtra("key_ext", paramStCommonExt.toByteArray());
    }
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void getLocalSearchData(COMM.StCommonExt paramStCommonExt, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), MiniAppLocalSearchDataServlet.class, paramMiniAppCmdInterface, "getLocalSearchData");
    if (paramStCommonExt != null) {
      paramMiniAppCmdInterface.putExtra("key_ext", paramStCommonExt.toByteArray());
    }
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void getLoginCode(String paramString, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    String str = MiniAppSecurityUtil.getLoginMiniAppUin(BaseApplicationImpl.getApplication());
    str = MiniAppSecurityUtil.getLoginMiniAppForbidToken(BaseApplicationImpl.getApplication(), str);
    int i = 0;
    if (MiniAppConfProcessor.a("miniappsendrequestbyhttps", 0) == 0) {
      i = 1;
    }
    if ((!TextUtils.isEmpty(str)) && (i != 0))
    {
      QLog.d(TAG, 1, "getLoginCode, send request by https");
      HttpCmdManager.g().getCode(paramString, str, new MiniAppCmdUtil.2(this, paramMiniAppCmdInterface));
      return;
    }
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), MiniAppGetLoginCodeServlet.class, paramMiniAppCmdInterface, "getLoginCode");
    try
    {
      paramMiniAppCmdInterface.putExtra("key_uin", Long.valueOf(BaseApplicationImpl.getApplication().getRuntime().getAccount()));
    }
    catch (Exception localException)
    {
      QLog.e(TAG, 1, "getLoginCode ", localException);
    }
    paramMiniAppCmdInterface.putExtra("key_appid", paramString);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void getMidasConsumeResult(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, COMM.StCommonExt paramStCommonExt, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), MiniMidasConsumeServlet.class, paramMiniAppCmdInterface, "getMidasConsumeResult");
    paramMiniAppCmdInterface.putExtra("key_appid", paramString1);
    paramMiniAppCmdInterface.putExtra("key_prepay_id", paramString2);
    paramMiniAppCmdInterface.putExtra("key_star_currency", paramInt1);
    paramMiniAppCmdInterface.putExtra("key_balance_amount", paramInt2);
    paramMiniAppCmdInterface.putExtra("key_topup_amount", paramInt3);
    paramMiniAppCmdInterface.putExtra("key_pay_channel", paramInt4);
    paramMiniAppCmdInterface.putExtra("key_pay_env", paramInt5);
    if (paramStCommonExt != null) {
      paramMiniAppCmdInterface.putExtra("key_ext", paramStCommonExt.toByteArray());
    }
    paramMiniAppCmdInterface.setObserver(this.cmdObserver);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void getMidasQueryResult(String paramString1, String paramString2, int paramInt1, int paramInt2, COMM.StCommonExt paramStCommonExt, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), MiniMidasQueryServlet.class, paramMiniAppCmdInterface, "getMidasQueryResult");
    paramMiniAppCmdInterface.putExtra("key_prepay_id", paramString1);
    paramMiniAppCmdInterface.putExtra("key_star_currency", paramInt1);
    paramMiniAppCmdInterface.putExtra("key_appid", paramString2);
    paramMiniAppCmdInterface.putExtra("key_set_env", paramInt2);
    if (paramStCommonExt != null) {
      paramMiniAppCmdInterface.putExtra("key_ext", paramStCommonExt.toByteArray());
    }
    paramMiniAppCmdInterface.setObserver(this.cmdObserver);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void getMiniAppStoreAppList(int paramInt, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), MiniAppStoreGetAppListServlet.class, paramMiniAppCmdInterface, "getMiniAppStoreAppList");
    paramMiniAppCmdInterface.putExtra("key_app_store_get_app_list_type", paramInt);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void getNativeAppInfoForJump(COMM.StCommonExt paramStCommonExt, String paramString1, String paramString2, String paramString3, int paramInt, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), MiniAppGetNativeAppInfoServlet.class, paramMiniAppCmdInterface, "GetNAppForJump");
    paramMiniAppCmdInterface.putExtra("key_app_id", paramString1);
    paramMiniAppCmdInterface.putExtra("key_package_name", paramString3);
    paramMiniAppCmdInterface.putExtra("key_native_app_id", paramString2);
    paramMiniAppCmdInterface.putExtra("key_scene", paramInt);
    if (paramStCommonExt != null) {
      paramMiniAppCmdInterface.putExtra("key_ext", paramStCommonExt.toByteArray());
    }
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void getPhoneNumber(String paramString, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), MiniAppGetPhoneNumberServlet.class, paramMiniAppCmdInterface, "getPhoneNumber");
    paramMiniAppCmdInterface.putExtra("key_appid", paramString);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void getPotentialFriendList(COMM.StCommonExt paramStCommonExt, String paramString, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), GetPotentialFriendListServlet.class, paramMiniAppCmdInterface, "getPotentialFriendList");
    if (paramStCommonExt != null) {
      paramMiniAppCmdInterface.putExtra("key_ext", paramStCommonExt.toByteArray());
    }
    paramMiniAppCmdInterface.putExtra("key_appid", paramString);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void getReactiveFriendList(COMM.StCommonExt paramStCommonExt, String paramString, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), GetReactiveFriendListServlet.class, paramMiniAppCmdInterface, "getReactiveFriendList");
    if (paramStCommonExt != null) {
      paramMiniAppCmdInterface.putExtra("key_ext", paramStCommonExt.toByteArray());
    }
    paramMiniAppCmdInterface.putExtra("key_appid", paramString);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void getRecommendAppList(COMM.StCommonExt paramStCommonExt, String paramString, int paramInt, long paramLong, ArrayList<RecommendAppInfo> paramArrayList, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), MiniAppGetRecommendAppListServlet.class, paramMiniAppCmdInterface, "getRecommendAppList");
    paramMiniAppCmdInterface.putExtra("key_app_id", paramString);
    if (paramStCommonExt != null) {
      paramMiniAppCmdInterface.putExtra("key_ext_info", paramStCommonExt.toByteArray());
    }
    paramMiniAppCmdInterface.putExtra("key_ver_type", paramInt);
    paramMiniAppCmdInterface.putExtra("key_use_time", paramLong);
    paramMiniAppCmdInterface.putParcelableArrayListExtra("key_old_recommend_list", paramArrayList);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void getRewardedVideoADInfo(MiniAppAd.StGetAdReq paramStGetAdReq, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    if (paramStGetAdReq == null) {
      return;
    }
    COMM.StCommonExt localStCommonExt = (COMM.StCommonExt)paramStGetAdReq.extInfo.get();
    MiniAppAd.UserInfo localUserInfo = (MiniAppAd.UserInfo)paramStGetAdReq.user_info.get();
    MiniAppAd.PositionInfo localPositionInfo;
    if (paramStGetAdReq.position_info.get() != null) {
      localPositionInfo = (MiniAppAd.PositionInfo)paramStGetAdReq.position_info.get().get(0);
    } else {
      localPositionInfo = null;
    }
    MiniAppAd.DeviceInfo localDeviceInfo = (MiniAppAd.DeviceInfo)paramStGetAdReq.device_info.get();
    MiniAppAd.ContextInfo localContextInfo = (MiniAppAd.ContextInfo)paramStGetAdReq.context_info.get();
    MiniAppAd.DebugInfo localDebugInfo = (MiniAppAd.DebugInfo)paramStGetAdReq.debug_info.get();
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), MiniRewardedVideoAdServlet.class, paramMiniAppCmdInterface, "getRewardedVideoADInfo");
    paramMiniAppCmdInterface.putExtra("key_gdt_cookie", paramStGetAdReq.gdt_cookie.get());
    paramMiniAppCmdInterface.putExtra("key_support_https", true);
    paramMiniAppCmdInterface.putExtra("key_busi_cookie", paramStGetAdReq.busi_cookie.get());
    paramMiniAppCmdInterface.putExtra("key_appid", paramStGetAdReq.appid.get());
    paramMiniAppCmdInterface.putExtra("key_ad_type", paramStGetAdReq.ad_type.get());
    if (localStCommonExt != null) {
      paramMiniAppCmdInterface.putExtra("key_ext", localStCommonExt.toByteArray());
    }
    if (localUserInfo != null) {
      paramMiniAppCmdInterface.putExtra("key_user_info", localUserInfo.toByteArray());
    }
    if (localPositionInfo != null) {
      paramMiniAppCmdInterface.putExtra("key_position_info", localPositionInfo.toByteArray());
    }
    if (localDeviceInfo != null) {
      paramMiniAppCmdInterface.putExtra("key_device_info", localDeviceInfo.toByteArray());
    }
    if (localContextInfo != null) {
      paramMiniAppCmdInterface.putExtra("key_context_info", localContextInfo.toByteArray());
    }
    if (localDebugInfo != null) {
      paramMiniAppCmdInterface.putExtra("key_debug_info", localDebugInfo.toByteArray());
    }
    paramMiniAppCmdInterface.setObserver(this.cmdObserver);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void getRobotUin(String paramString, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), MiniAppGetRobotUinServlet.class, paramMiniAppCmdInterface, "GetRobotUin");
    paramMiniAppCmdInterface.putExtra("key_app_id", paramString);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void getShareInfo(MiniProgramShare.StAdaptShareInfoReq paramStAdaptShareInfoReq, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), MiniAppGetShareInfoServlet.class, paramMiniAppCmdInterface, "getShareInfo");
    if (paramStAdaptShareInfoReq != null) {
      paramMiniAppCmdInterface.putExtra("key_data", paramStAdaptShareInfoReq.toByteArray());
    }
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void getSwitchList(COMM.StCommonExt paramStCommonExt, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), MiniAppGetSwitchListServlet.class, paramMiniAppCmdInterface, "getSwitchList");
    if (paramStCommonExt != null) {
      paramMiniAppCmdInterface.putExtra("key_ext", paramStCommonExt.toByteArray());
    }
    paramMiniAppCmdInterface.setObserver(this.cmdObserver);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void getTcbTicket(String paramString1, COMM.StCommonExt paramStCommonExt, String paramString2, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), MiniAppGetTcbTicketServlet.class, paramMiniAppCmdInterface, "getTcbTicket");
    paramMiniAppCmdInterface.putExtra("key_app_id", paramString1);
    paramMiniAppCmdInterface.putExtra("key_env_id", paramString2);
    if (paramStCommonExt != null) {
      paramMiniAppCmdInterface.putExtra("key_ext_info", paramStCommonExt.toByteArray());
    }
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void getTinyId(String paramString, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), MiniAppGetTinyIdServlet.class, paramMiniAppCmdInterface, "Trans4Tinyid");
    paramMiniAppCmdInterface.putExtra("key_app_id", paramString);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void getUserAppInfo(ArrayList<String> paramArrayList, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), MiniAppGetUserAppInfoServlet.class, paramMiniAppCmdInterface, "userAppInfo");
    paramMiniAppCmdInterface.putStringArrayListExtra("key_appids", paramArrayList);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void getUserAppList(long paramLong1, long paramLong2, COMM.StCommonExt paramStCommonExt, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), MiniAppGetUserAppListServlet.class, paramMiniAppCmdInterface, "getUserAppList");
    paramMiniAppCmdInterface.putExtra("key_uin", paramLong1);
    paramMiniAppCmdInterface.putExtra("key_num", paramLong2);
    if (paramStCommonExt != null) {
      paramMiniAppCmdInterface.putExtra("key_ext", paramStCommonExt.toByteArray());
    }
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void getUserAppListV2(COMM.StCommonExt paramStCommonExt, GetAppListV2Scene paramGetAppListV2Scene, ArrayList<RecommendAppInfo> paramArrayList, ArrayList<Integer> paramArrayList1, ArrayList<Integer> paramArrayList2, ArrayList<String> paramArrayList3, int paramInt, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), MiniAppGetUserAppListServletV2.class, paramMiniAppCmdInterface, "getDowloadAppList");
    if (paramStCommonExt != null) {
      try
      {
        paramMiniAppCmdInterface.putExtra("key_ext_info", paramStCommonExt.toByteArray());
      }
      catch (Exception paramStCommonExt)
      {
        QLog.e(TAG, 1, "extInfoBytes extInfo error!", paramStCommonExt);
      }
    }
    paramStCommonExt = paramGetAppListV2Scene;
    if (paramGetAppListV2Scene == null) {
      paramStCommonExt = GetAppListV2Scene.UN_KNOWN;
    }
    paramGetAppListV2Scene = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[getUserAppListV2] scene=");
    localStringBuilder.append(paramStCommonExt.name());
    QLog.i(paramGetAppListV2Scene, 2, localStringBuilder.toString());
    paramMiniAppCmdInterface.putExtra("scene", paramStCommonExt.ordinal());
    paramMiniAppCmdInterface.putIntegerArrayListExtra("key_module_types", paramArrayList1);
    paramMiniAppCmdInterface.putParcelableArrayListExtra("key_old_recommend_list", paramArrayList);
    paramMiniAppCmdInterface.putExtra("key_use_cache", paramInt);
    paramMiniAppCmdInterface.putIntegerArrayListExtra("key_sub_types", paramArrayList2);
    paramMiniAppCmdInterface.putStringArrayListExtra("key_item_ids", paramArrayList3);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void getUserCloudStorage(String paramString, String[] paramArrayOfString, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    sendCloudRequest(paramString, paramArrayOfString, paramMiniAppCmdInterface, "get_cloud_storage");
  }
  
  public void getUserGroupInfo(COMM.StCommonExt paramStCommonExt, String paramString1, String paramString2, long paramLong, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), MiniAppGetUserGroupInfoServlet.class, paramMiniAppCmdInterface, "getUserGroupInfo");
    if (paramStCommonExt != null) {
      paramMiniAppCmdInterface.putExtra("key_ext", paramStCommonExt.toByteArray());
    }
    paramMiniAppCmdInterface.putExtra("key_appid", paramString1);
    paramMiniAppCmdInterface.putExtra("group_id", paramString2);
    paramMiniAppCmdInterface.putExtra("group_class", paramLong);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void getUserHealthData(String paramString, COMM.StCommonExt paramStCommonExt, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), MiniAppUserHealthDataServlet.class, paramMiniAppCmdInterface, "getUserHealthData");
    paramMiniAppCmdInterface.putExtra("key_app_id", paramString);
    if (paramStCommonExt != null) {
      paramMiniAppCmdInterface.putExtra("key_ext_info", paramStCommonExt.toByteArray());
    }
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void getUserInfo(String paramString1, boolean paramBoolean, String paramString2, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), MiniAppGetProfileServlet.class, paramMiniAppCmdInterface, "getUserInfo");
    try
    {
      paramMiniAppCmdInterface.putExtra("key_uin", Long.valueOf(BaseApplicationImpl.getApplication().getRuntime().getAccount()));
    }
    catch (Exception localException)
    {
      QLog.e(TAG, 1, "getUserInfo ", localException);
    }
    paramMiniAppCmdInterface.putExtra("key_appid", paramString1);
    paramMiniAppCmdInterface.putExtra("key_with_credential", paramBoolean);
    paramMiniAppCmdInterface.putExtra("key_lang", paramString2);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void getUserInfoExtra(String paramString, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), MiniAppGetUserInfoExtraServlet.class, paramMiniAppCmdInterface, "GetUserInfoExtra");
    paramMiniAppCmdInterface.putExtra("key_appid", paramString);
    paramMiniAppCmdInterface.setObserver(this.cmdObserver);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void getUserInfoOpenData(String paramString1, String paramString2, String[] paramArrayOfString, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), BatchGetUserInfoServlet.class, paramMiniAppCmdInterface, "batchGetUserInfo");
    paramMiniAppCmdInterface.putExtra("key_appid", paramString1);
    paramMiniAppCmdInterface.putExtra("key_lang", paramString2);
    paramMiniAppCmdInterface.putExtra("key_openid", paramArrayOfString);
    paramMiniAppCmdInterface.setObserver(this.cmdObserver);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void getUserInteractiveStorage(COMM.StCommonExt paramStCommonExt, String paramString, String[] paramArrayOfString, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), GetUserInteractiveStorageServlet.class, paramMiniAppCmdInterface, "getUserInteractiveStorage");
    if (paramStCommonExt != null) {
      paramMiniAppCmdInterface.putExtra("key_ext", paramStCommonExt.toByteArray());
    }
    paramMiniAppCmdInterface.putExtra("key_appid", paramString);
    paramMiniAppCmdInterface.putExtra("key_data", paramArrayOfString);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void getUserSetting(String paramString1, String paramString2, String paramString3, ArrayList<String> paramArrayList, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), MiniAppGetUserSettingServlet.class, paramMiniAppCmdInterface, "GetUserSetting");
    paramMiniAppCmdInterface.putExtra("KEY_APP_ID", paramString1);
    paramMiniAppCmdInterface.putExtra("KEY_OPEN_ID", paramString2);
    paramMiniAppCmdInterface.putExtra("KEY_SETTING_ITEM", paramString3);
    if (paramArrayList != null) {
      paramMiniAppCmdInterface.putStringArrayListExtra("KEY_TEMPLATE_IDS", paramArrayList);
    }
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void getWeixinSDKAppInfo(String paramString, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), GetWeixinSDKAppInfoServlet.class, paramMiniAppCmdInterface, "getWeixinSDKAppInfo");
    try
    {
      paramMiniAppCmdInterface.putExtra("key_uin", Long.valueOf(BaseApplicationImpl.getApplication().getRuntime().getAccount()));
    }
    catch (Exception localException)
    {
      QLog.e(TAG, 1, "getAppInfoByLink ", localException);
    }
    paramMiniAppCmdInterface.putExtra("key_code", paramString);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void guessYouLike(COMM.StCommonExt paramStCommonExt, int paramInt, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), MiniAppGuessYouLikeServlet.class, paramMiniAppCmdInterface, "GetGuessYouLike");
    if (paramStCommonExt != null) {
      paramMiniAppCmdInterface.putExtra("key_search_guess_you_like_ext_info", paramStCommonExt.toByteArray());
    }
    paramMiniAppCmdInterface.putExtra("searchGuessYouLikeCount", paramInt);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void insertBookShelf(String paramString1, String paramString2, ArrayList<String> paramArrayList, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), BookShelfInsertServlet.class, paramMiniAppCmdInterface, "InsertBookShelf");
    paramMiniAppCmdInterface.putExtra("key_appid", paramString1);
    paramMiniAppCmdInterface.putExtra("key_category", paramString2);
    paramMiniAppCmdInterface.putStringArrayListExtra("key_contentIds", paramArrayList);
    paramMiniAppCmdInterface.setObserver(this.cmdObserver);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void modifyFriendInteractiveStorage(COMM.StCommonExt paramStCommonExt, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, HashMap<String, String> paramHashMap, boolean paramBoolean, CloudStorage.StInteractiveTemplate paramStInteractiveTemplate, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), ModifyFriendInteractiveStorageServlet.class, paramMiniAppCmdInterface, "modifyFriendInteractiveStorage");
    if (paramStCommonExt != null) {
      paramMiniAppCmdInterface.putExtra("key_ext", paramStCommonExt.toByteArray());
    }
    if (paramStInteractiveTemplate != null) {
      paramMiniAppCmdInterface.putExtra("key_interactive_template", paramStInteractiveTemplate.toByteArray());
    }
    paramMiniAppCmdInterface.putExtra("key_appid", paramString1);
    paramMiniAppCmdInterface.putExtra("key_to_user", paramString2);
    paramMiniAppCmdInterface.putExtra("KEY_SHARE_ID", paramString3);
    paramMiniAppCmdInterface.putExtra("key_opnum", paramInt);
    paramMiniAppCmdInterface.putExtra("key_operation", paramString4);
    paramMiniAppCmdInterface.putExtra("key_data", paramHashMap);
    paramMiniAppCmdInterface.putExtra("key_quiet", paramBoolean);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void performDataReport(byte[] paramArrayOfByte, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), MiniAppDataReportServlet.class, paramMiniAppCmdInterface, "report");
    paramMiniAppCmdInterface.putExtra("key_data", paramArrayOfByte);
    if (BaseApplicationImpl.getApplication().getRuntime() != null)
    {
      BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
      return;
    }
    QLog.e(TAG, 1, "performReport failed: BaseApplicationImpl.getApplication().getRuntime() is null");
  }
  
  public void performReport(byte[] paramArrayOfByte, MiniAppCmdInterface paramMiniAppCmdInterface, String paramString)
  {
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), MiniAppDcReportServlet.class, paramMiniAppCmdInterface, "report");
    paramMiniAppCmdInterface.putExtra("key_data", paramArrayOfByte);
    paramMiniAppCmdInterface.putExtra("key_cmd", paramString);
    if (BaseApplicationImpl.getApplication().getRuntime() != null)
    {
      BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
      return;
    }
    QLog.e(TAG, 1, "performReport failed: BaseApplicationImpl.getApplication().getRuntime() is null");
  }
  
  public void queryBookShelf(String paramString, ArrayList<String> paramArrayList, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), BookShelfQueryServlet.class, paramMiniAppCmdInterface, "QueryBookShelf");
    paramMiniAppCmdInterface.putExtra("key_appid", paramString);
    paramMiniAppCmdInterface.putStringArrayListExtra("key_contentIds", paramArrayList);
    paramMiniAppCmdInterface.setObserver(this.cmdObserver);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void realTimeLogReport(String paramString1, String paramString2, String paramString3, String[] paramArrayOfString, ArrayList<RealTimeLogItem> paramArrayList, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), MiniAppRealTimeLogReportServlet.class, paramMiniAppCmdInterface, "GetAppInfoByLink");
    paramMiniAppCmdInterface.putExtra("key_page", paramString1);
    paramMiniAppCmdInterface.putExtra("key_jslib_version", paramString2);
    paramMiniAppCmdInterface.putExtra("key_appid", paramString3);
    paramMiniAppCmdInterface.putExtra("key_filter_msg", paramArrayOfString);
    paramMiniAppCmdInterface.putParcelableArrayListExtra("key_log_items", paramArrayList);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void rejectFrequentlyRecommends(String paramString, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), RejectFrequentlyRecommendsServlet.class, paramMiniAppCmdInterface, "rejectFrequentlyRecommends");
    paramMiniAppCmdInterface.putExtra("key_appId", paramString);
    paramMiniAppCmdInterface.setObserver(this.cmdObserver);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void removeUserCloudStorage(String paramString, String[] paramArrayOfString, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    sendCloudRequest(paramString, paramArrayOfString, paramMiniAppCmdInterface, "remove_cloud_storage");
  }
  
  public void reportLogFileUrl(COMM.StCommonExt paramStCommonExt, String paramString1, String paramString2, long paramLong, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), MiniAppReportLogFileServlet.class, paramMiniAppCmdInterface, "reportLogFileUrl");
    paramMiniAppCmdInterface.putExtra("key_app_id", paramString1);
    paramMiniAppCmdInterface.putExtra("key_file_url", paramString2);
    paramMiniAppCmdInterface.putExtra("key_file_size", (int)paramLong);
    if (paramStCommonExt != null) {
      paramMiniAppCmdInterface.putExtra("key_ext", paramStCommonExt.toByteArray());
    }
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void reportShare(COMM.StCommonExt paramStCommonExt, long paramLong, String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), MiniReportShareServlet.class, paramMiniAppCmdInterface, "reportLogFileUrl");
    paramMiniAppCmdInterface.putExtra("key_report_time", paramLong);
    paramMiniAppCmdInterface.putExtra("key_appid", paramString1);
    paramMiniAppCmdInterface.putExtra("key_app_type", paramInt1);
    paramMiniAppCmdInterface.putExtra("key_share_scene", paramInt2);
    paramMiniAppCmdInterface.putExtra("key_share_type", paramInt3);
    paramMiniAppCmdInterface.putExtra("key_dest_type", paramInt4);
    paramMiniAppCmdInterface.putExtra("key_dest_id", paramString2);
    if (paramStCommonExt != null) {
      paramMiniAppCmdInterface.putExtra("key_ext", paramStCommonExt.toByteArray());
    }
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void searchApp(COMM.StCommonExt paramStCommonExt, String paramString, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), MiniAppSearchAppServlet.class, paramMiniAppCmdInterface, "SearchApp");
    if (paramStCommonExt != null) {
      paramMiniAppCmdInterface.putExtra("key_search_app_ext_info", paramStCommonExt.toByteArray());
    }
    paramMiniAppCmdInterface.putExtra("search_app_key_word", paramString);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void sendArkMsg(COMM.StCommonExt paramStCommonExt, String paramString1, String paramString2, String paramString3, String paramString4, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), MiniAppSendArkMsgServlet.class, paramMiniAppCmdInterface, "sendArkMsg");
    if (paramStCommonExt != null) {
      paramMiniAppCmdInterface.putExtra("key_ext", paramStCommonExt.toByteArray());
    }
    paramMiniAppCmdInterface.putExtra("key_appid", paramString1);
    paramMiniAppCmdInterface.putExtra("key_openid", paramString2);
    paramMiniAppCmdInterface.putExtra("key_ark_json", paramString3);
    paramMiniAppCmdInterface.putExtra("key_api_name", paramString4);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void sendRequestByMsf(byte[] paramArrayOfByte, String paramString, MiniAppProxy.SenderListener paramSenderListener)
  {
    paramSenderListener = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), MiniAppGeneralServlet.class, paramSenderListener, "sendRequest");
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    if (!TextUtils.isEmpty(str)) {}
    try
    {
      l = Long.valueOf(str).longValue();
    }
    catch (Exception localException)
    {
      long l;
      label51:
      break label51;
    }
    l = 0L;
    paramSenderListener.putExtra("key_uin", l);
    paramSenderListener.putExtra("key_request_data", paramArrayOfByte);
    paramSenderListener.putExtra("key_cmd_string", paramString);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramSenderListener);
  }
  
  public void setAuth(COMM.StCommonExt paramStCommonExt, String paramString, INTERFACE.StUserAuthInfo paramStUserAuthInfo, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), MiniAppSetAuthsServlet.class, paramMiniAppCmdInterface, "setAuth");
    paramMiniAppCmdInterface.putExtra("key_appid", paramString);
    if (paramStCommonExt != null) {
      paramMiniAppCmdInterface.putExtra("key_ext", paramStCommonExt.toByteArray());
    }
    if (paramStUserAuthInfo != null) {
      paramMiniAppCmdInterface.putExtra("key_auth_info", paramStUserAuthInfo.toByteArray());
    }
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void setCMShowPetStatus(int paramInt1, int paramInt2, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), CMShowSetPetStatusServlet.class, paramMiniAppCmdInterface, "setCMShowPetStatus");
    paramMiniAppCmdInterface.putExtra("petId", paramInt1);
    paramMiniAppCmdInterface.putExtra("petStatus", paramInt2);
    paramMiniAppCmdInterface.setObserver(this.cmdObserver);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void setPersonalizeInfo(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), PersonalizeSetAvatarServlet.class, paramMiniAppCmdInterface, "setAvatar");
    paramMiniAppCmdInterface.putExtra("key_app_id", paramString1);
    paramMiniAppCmdInterface.putExtra("key_app_uin", paramString2);
    paramMiniAppCmdInterface.putExtra("mini_app_settype", paramInt);
    paramMiniAppCmdInterface.putExtra("mini_app_itemid", paramString3);
    paramMiniAppCmdInterface.putExtra("mini_app_busi_info", paramString4);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void setUserAppLike(boolean paramBoolean, COMM.StCommonExt paramStCommonExt, String paramString, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void setUserAppTop(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, COMM.StCommonExt paramStCommonExt, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void setUserAppTop(String paramString, int paramInt1, int paramInt2, COMM.StCommonExt paramStCommonExt, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    setUserAppTop(paramString, paramInt1, paramInt2, -1, 0, paramStCommonExt, paramMiniAppCmdInterface);
  }
  
  public void setUserCloudStorage(String paramString, HashMap<String, String> paramHashMap, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), CloudStorageServlet.class, paramMiniAppCmdInterface, "setUserCloudStorage");
    paramMiniAppCmdInterface.putExtra("key_data", paramHashMap);
    paramMiniAppCmdInterface.putExtra("app_id", paramString);
    paramMiniAppCmdInterface.putExtra("request_type", "set_cloud_storage");
    paramMiniAppCmdInterface.setObserver(this.cmdObserver);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void setUserSwitch(COMM.StCommonExt paramStCommonExt, String paramString, int paramInt, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), MiniAppSetUserSwitchServlet.class, paramMiniAppCmdInterface, "getSwitchList");
    if (paramStCommonExt != null) {
      paramMiniAppCmdInterface.putExtra("key_ext", paramStCommonExt.toByteArray());
    }
    paramMiniAppCmdInterface.putExtra("key", paramString);
    paramMiniAppCmdInterface.putExtra("value", paramInt);
    paramMiniAppCmdInterface.setObserver(this.cmdObserver);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void transForRoomId(String paramString1, String paramString2, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), MiniAppTranRoomIdServlet.class, paramMiniAppCmdInterface, "Trans4Roomid");
    paramMiniAppCmdInterface.putExtra("key_app_id", paramString1);
    paramMiniAppCmdInterface.putExtra("key_group_id", paramString2);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public boolean updateBaseLib(String paramString, boolean paramBoolean1, boolean paramBoolean2, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[MiniEng] doUpdateBaseLib nocheck=");
    localStringBuilder.append(paramBoolean1);
    localStringBuilder.append(", force=");
    localStringBuilder.append(paramBoolean2);
    QLog.i(str, 1, localStringBuilder.toString());
    if ((!paramBoolean1) && (!paramBoolean2))
    {
      long l = StorageUtil.getPreference().getLong("baselib_min_update_time", 0L);
      str = StorageUtil.getPreference().getString("baselib_update_qua", "");
      if ((QUA.getQUA3().equals(str)) && (System.currentTimeMillis() - l <= 0L))
      {
        QLog.i(TAG, 1, "[MiniEng] updateBaseLib 在时间间隔内，暂时不更新");
        return false;
      }
    }
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), MiniAppGetNewBaseLibServlet.class, paramMiniAppCmdInterface, "updateBaseLib");
    try
    {
      paramMiniAppCmdInterface.putExtra("key_uin", Long.valueOf(BaseApplicationImpl.getApplication().getRuntime().getAccount()));
    }
    catch (Exception localException)
    {
      QLog.e(TAG, 1, "", localException);
    }
    paramMiniAppCmdInterface.putExtra("key_version", paramString);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
    return true;
  }
  
  public boolean updateBaseLibForSDK(String paramString, boolean paramBoolean1, boolean paramBoolean2, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[MiniEng] doUpdateBaseLib nocheck=");
    localStringBuilder.append(paramBoolean1);
    localStringBuilder.append(", force=");
    localStringBuilder.append(paramBoolean2);
    QLog.i(str, 1, localStringBuilder.toString());
    if ((!paramBoolean1) && (!paramBoolean2))
    {
      long l = StorageUtil.getPreference().getLong("baselib_min_update_time", 0L);
      str = StorageUtil.getPreference().getString("baselib_update_qua", "");
      if ((QUA.getQUA3().equals(str)) && (System.currentTimeMillis() - l <= 0L))
      {
        QLog.i(TAG, 1, "[MiniEng] updateBaseLib 在时间间隔内，暂时不更新");
        return false;
      }
    }
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), MiniAppGetNewBaseLibForSDKServlet.class, paramMiniAppCmdInterface, "updateBaseLib");
    try
    {
      paramMiniAppCmdInterface.putExtra("key_uin", Long.valueOf(BaseApplicationImpl.getApplication().getRuntime().getAccount()));
    }
    catch (Exception localException)
    {
      QLog.e(TAG, 1, "", localException);
    }
    paramMiniAppCmdInterface.putExtra("key_version", paramString);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
    return true;
  }
  
  public void updateBookshelfReadtime(String paramString1, String paramString2, String paramString3, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), BookShelfUpdateServlet.class, paramMiniAppCmdInterface, "UpdateBookShelfReadTime");
    paramMiniAppCmdInterface.putExtra("key_appid", paramString1);
    paramMiniAppCmdInterface.putExtra("key_category", paramString2);
    paramMiniAppCmdInterface.putExtra("key_contentId", paramString3);
    paramMiniAppCmdInterface.setObserver(this.cmdObserver);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void updateUserSetting(COMM.StCommonExt paramStCommonExt, String paramString, INTERFACE.StUserSettingInfo paramStUserSettingInfo, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), MiniAppUpdateUserSettingServlet.class, paramMiniAppCmdInterface, "updateUserSetting");
    paramMiniAppCmdInterface.putExtra("key_appid", paramString);
    if (paramStCommonExt != null) {
      paramMiniAppCmdInterface.putExtra("key_ext", paramStCommonExt.toByteArray());
    }
    if (paramStUserSettingInfo != null) {
      paramMiniAppCmdInterface.putExtra("key_setting_info", paramStUserSettingInfo.toByteArray());
    }
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void useUserApp(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, COMM.StCommonExt paramStCommonExt, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), MiniAppUseUserAppServlet.class, paramMiniAppCmdInterface, "useUserApp");
    paramMiniAppCmdInterface.putExtra("key_appid", paramString1);
    paramMiniAppCmdInterface.putExtra("key_version_type", paramInt1);
    paramMiniAppCmdInterface.putExtra("key_source", paramInt2);
    paramMiniAppCmdInterface.putExtra("key_refer", paramString2);
    paramMiniAppCmdInterface.putExtra("key_via", paramString3);
    if (paramStCommonExt != null) {
      paramMiniAppCmdInterface.putExtra("key_ext", paramStCommonExt.toByteArray());
    }
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
  
  public void verifyPlugin(String paramString, ArrayList<PluginInfo> paramArrayList, MiniAppCmdInterface paramMiniAppCmdInterface)
  {
    paramMiniAppCmdInterface = new MiniAppCmdUtil.NewIntent(this, BaseApplicationImpl.getApplication(), MiniAppVerifyPluginServlet.class, paramMiniAppCmdInterface, "verifyPlugin");
    paramMiniAppCmdInterface.putExtra("key_app_id", paramString);
    paramMiniAppCmdInterface.putParcelableArrayListExtra("key_plugin_ids", paramArrayList);
    BaseApplicationImpl.getApplication().getRuntime().startServlet(paramMiniAppCmdInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil
 * JD-Core Version:    0.7.0.1
 */