package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.falco.base.libapi.activitylife.ActivityLifeService;
import com.tencent.ilive.base.event.ModuleEvent;
import com.tencent.ilive.litepages.room.webmodule.jsmodule.JsBizAdapter;
import com.tencent.ilive.pages.room.events.RoomCloseEvent;
import com.tencent.ilivesdk.roomservice_interface.RoomServiceInterface;
import com.tencent.ilivesdk.roomservice_interface.model.EnterRoomInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveAnchorInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveRoomInfo;
import com.tencent.livesdk.roomengine.RoomEnginLogic;
import com.tencent.livesdk.roomengine.RoomEngine;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.webview.LiteLiveJsInterface;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qqgift.api.IQQGiftManager;
import com.tencent.mobileqq.qqgift.api.IQQGiftSDK;
import com.tencent.mobileqq.qqgift.api.service.IQQGiftWalletIdentifyModule;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDKManager;
import com.tencent.mobileqq.qqlive.api.gift.IQQLiveGiftEntranceService;
import com.tencent.mobileqq.qqlive.api.login.IQQLiveModuleLogin;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.entity.IliveJumpParams;
import cooperation.ilive.lite.IliveLiteHelper;
import cooperation.ilive.lite.event.IliveLiteEventCenter;
import cooperation.ilive.lite.event.IliveLiteEventCenter.Observer;
import cooperation.ilive.lite.report.IliveLiteDataReport;
import cooperation.ilive.lite.rommswitch.LiveLiteRoomSwitchService;
import cooperation.qqlive.QQLiveAudienceGiftFragment;
import cooperation.qqlive.data.QQLiveAudienceGiftData;
import eipc.EIPCClient;
import java.util.HashMap;
import org.json.JSONObject;

public class QQIliveJsPlugin
  extends VasWebviewJsPluginV2
  implements LiteLiveJsInterface
{
  private static final String ACTION_NOTIFY_FOLLOW_CHANGE = "action_follow_change";
  public static final String ACTION_QQ_LIVE_WEB_FOLLOW_STATE = "ACTION_QQ_LIVE_WEB_FOLLOW_STATE";
  public static final String BUSINESS_NAME = "vaslive";
  public static final String KEY_FOLLOWED_UID = "followedUid";
  private static final String KEY_FOLLOW_STATE = "key_follow_state";
  public static final String KEY_IS_FOLLOWED = "isFollowed";
  public static final String KEY_ROOM_ID = "roomId";
  public static final String KEY_UID = "uid";
  private static final String TAG = "QQIliveJsPlugin";
  private boolean isSpecialAnchor = false;
  private String mCloseCallbackId;
  private boolean mH5LoadFinish = false;
  private JsBizAdapter mJsBizAdapter;
  private IliveLiteEventCenter.Observer mObserver = new QQIliveJsPlugin.2(this);
  private HashMap<Long, Integer> mOptionMap = new HashMap();
  private QQCustomDialog qqCustomDialog;
  
  public QQIliveJsPlugin()
  {
    super("vaslive");
  }
  
  private void callNeedShowGiftIcon(int paramInt, String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("code", paramInt);
    localBundle.putString("message", paramString1);
    localBundle.putString("callback_id", paramString2);
    paramString2 = new StringBuilder();
    paramString2.append("callNeedShowGiftIcon code:");
    paramString2.append(paramInt);
    paramString2.append(", msg:");
    paramString2.append(paramString1);
    QLog.e("QQIliveJsPlugin", 1, paramString2.toString());
    IliveLiteEventCenter.a().a("ACTION_WEBVIEW_NEED_SHOW_GIFT_ICON", localBundle);
  }
  
  private LiveAnchorInfo getAnchorInfo()
  {
    Object localObject = this.mJsBizAdapter.getModuleRoomEngine();
    if ((localObject != null) && (((RoomEngine)localObject).getEnginLogic() != null))
    {
      localObject = ((RoomEngine)localObject).getEnginLogic().getLiveInfo();
      if (localObject == null)
      {
        QLog.e("QQIliveJsPlugin", 1, "[getAnchorInfo] liveInfo is null!");
        return null;
      }
      return ((LiveInfo)localObject).anchorInfo;
    }
    QLog.e("QQIliveJsPlugin", 1, "[getAnchorInfo] roomEngine is null!");
    return null;
  }
  
  private EnterRoomInfo getEnterRooInfo()
  {
    Object localObject = this.mJsBizAdapter.getModuleRoomEngine();
    if ((localObject != null) && (((RoomEngine)localObject).getEnginLogic() != null))
    {
      localObject = (RoomServiceInterface)((RoomEngine)localObject).getService(RoomServiceInterface.class);
      if (localObject != null) {
        return ((RoomServiceInterface)localObject).getEnterRoomInfo();
      }
      return null;
    }
    QLog.e("QQIliveJsPlugin", 1, "[getAnchorInfo] roomEngine is null!");
    return null;
  }
  
  private LiveUserInfo getLoginInfo()
  {
    Object localObject = ((IQQLiveSDKManager)QRoute.api(IQQLiveSDKManager.class)).getSDKImpl("1037");
    if (localObject != null)
    {
      localObject = ((IQQLiveSDK)localObject).getLoginModule();
      if (localObject != null) {
        return ((IQQLiveModuleLogin)localObject).getUserInfo();
      }
    }
    return null;
  }
  
  private long getRoomId()
  {
    Object localObject = this.mJsBizAdapter;
    if (localObject == null) {
      return 0L;
    }
    localObject = ((JsBizAdapter)localObject).getModuleRoomEngine();
    if (localObject == null) {
      return 0L;
    }
    localObject = ((RoomEngine)localObject).getEnginLogic();
    if (localObject == null) {
      return 0L;
    }
    localObject = ((RoomEnginLogic)localObject).getLiveInfo();
    if (localObject != null)
    {
      if (((LiveInfo)localObject).roomInfo == null) {
        return 0L;
      }
      return ((LiveInfo)localObject).roomInfo.roomId;
    }
    return 0L;
  }
  
  private Activity getTopActivity()
  {
    Object localObject = this.mJsBizAdapter.getModuleRoomEngine();
    if ((localObject != null) && (((RoomEngine)localObject).getEnginLogic() != null))
    {
      localObject = (ActivityLifeService)((RoomEngine)localObject).getService(ActivityLifeService.class);
      if (localObject == null)
      {
        QLog.e("QQIliveJsPlugin", 1, "[handleOpenGiftPanel] getService is null!");
        return null;
      }
      return ((ActivityLifeService)localObject).getTopActivity();
    }
    QLog.e("QQIliveJsPlugin", 1, "[handleOpenGiftPanel] roomEngine is null!");
    return null;
  }
  
  private void handleOpenGiftPanel()
  {
    Activity localActivity = getTopActivity();
    if (localActivity == null)
    {
      QLog.e("QQIliveJsPlugin", 1, "[handleOpenGiftPanel] topActivity is null");
      return;
    }
    IQQGiftSDK localIQQGiftSDK = ((IQQGiftManager)QRoute.api(IQQGiftManager.class)).getSDKImpl(10001);
    if (localIQQGiftSDK != null)
    {
      localIQQGiftSDK.h().a(localActivity, new QQIliveJsPlugin.4(this));
      return;
    }
    QLog.e("QQIliveJsPlugin", 1, "handleOpenGiftPanel giftSDK is null!");
  }
  
  private void notifyShowGiftIcon()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQIliveJsPlugin", 2, "notifyShowGiftIcon");
    }
    needShowGiftIcon("showQlivGiftIconEvent");
  }
  
  private void onIdentifyError(int paramInt, String paramString)
  {
    Activity localActivity = getTopActivity();
    if (localActivity == null)
    {
      QLog.e("QQIliveJsPlugin", 1, "onIdentifyError identifyFinish failed, topActivity is null");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onIdentifyError identifyFinish failed, code:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", message:");
    localStringBuilder.append(paramString);
    QLog.e("QQIliveJsPlugin", 1, localStringBuilder.toString());
    if (paramInt == -11153)
    {
      QLog.e("QQIliveJsPlugin", 1, "用户未实名认证，但不拦截送礼面板");
      openGiftPanelFragment();
      return;
    }
    if (paramInt == -11154)
    {
      showDialog(localActivity, paramString);
      return;
    }
    QLog.e("QQIliveJsPlugin", 1, "未知错误，但不拦截送礼面板");
    openGiftPanelFragment();
  }
  
  private void openGiftPanelFragment()
  {
    LiveAnchorInfo localLiveAnchorInfo = getAnchorInfo();
    if (localLiveAnchorInfo == null)
    {
      QLog.e("QQIliveJsPlugin", 1, "[handleOpenGiftPanel] anchorInfo is null!");
      return;
    }
    LiveUserInfo localLiveUserInfo = getLoginInfo();
    if (localLiveUserInfo == null)
    {
      QLog.e("QQIliveJsPlugin", 1, "[handleOpenGiftPanel] loginInfo is null!");
      return;
    }
    Activity localActivity = getTopActivity();
    if (localActivity == null)
    {
      QLog.e("QQIliveJsPlugin", 1, "[handleOpenGiftPanel] topActivity is null");
      return;
    }
    Object localObject2 = getEnterRooInfo();
    String str = "";
    Object localObject1;
    Object localObject3;
    if (localObject2 != null)
    {
      localObject1 = ((EnterRoomInfo)localObject2).extData;
      if (localObject1 != null)
      {
        str = String.valueOf(((Bundle)localObject1).getLong("ext_enter_room_video_source_app_id", 0L));
        localObject1 = ((Bundle)localObject1).getString("trace_info");
      }
      else
      {
        localObject1 = "";
      }
      localObject2 = ((EnterRoomInfo)localObject2).programId;
      localObject3 = str;
    }
    else
    {
      str = "";
      localObject1 = str;
      localObject3 = localObject1;
      localObject2 = localObject1;
      localObject1 = str;
    }
    QQLiveAudienceGiftFragment.a(localActivity, new QQLiveAudienceGiftData(10001, localLiveUserInfo.nick, getRoomId(), localLiveUserInfo.uid, localLiveAnchorInfo.uid, localLiveUserInfo.headUrl, localLiveAnchorInfo.nickName, localLiveAnchorInfo.headUrl, 1, (String)localObject1, (String)localObject2, (String)localObject3, this.isSpecialAnchor));
  }
  
  private void sendToJsExit(long paramLong, int paramInt, JSONObject paramJSONObject)
  {
    callJs(this.mCloseCallbackId, new String[] { paramJSONObject.toString() });
    this.mOptionMap.put(Long.valueOf(paramLong), Integer.valueOf(paramInt));
    IliveLiteHelper.c();
  }
  
  private void showDialog(Activity paramActivity, String paramString)
  {
    if (this.qqCustomDialog == null) {
      this.qqCustomDialog = DialogUtil.a(paramActivity, 230, null, paramString, null, "确认", new QQIliveJsPlugin.5(this), null);
    }
    if (!this.qqCustomDialog.isShowing()) {
      this.qqCustomDialog.show();
    }
  }
  
  @VasWebviewJsPluginV2.JsbridgeSubscribe(args="saveType", method="closeAnchorLive")
  public void closeAnchorLive(int paramInt)
  {
    if (this.mOptionMap.get(Long.valueOf(getRoomId())) != null) {
      paramInt = ((Integer)this.mOptionMap.get(Long.valueOf(getRoomId()))).intValue();
    } else {
      paramInt = 1001;
    }
    JsBizAdapter localJsBizAdapter = this.mJsBizAdapter;
    if ((localJsBizAdapter != null) && (localJsBizAdapter.getModuleEvent() != null)) {
      this.mJsBizAdapter.getModuleEvent().post(new RoomCloseEvent((short)paramInt));
    }
  }
  
  @VasWebviewJsPluginV2.JsbridgeSubscribe(args="callback|p_uin|type", method="followAnchor")
  public void followAnchor(String paramString1, String paramString2, Object paramObject)
  {
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("anchorUin", paramString2);
      localBundle.putInt("followType", ((Integer)paramObject).intValue());
      QIPCClientHelper.getInstance().getClient().callServer("VasLiveIPCModule", "followAccount", localBundle, new QQIliveJsPlugin.1(this, paramObject, paramString1));
      return;
    }
    catch (Exception paramString2)
    {
      super.callJsOnError(paramString1, paramString2.getMessage());
    }
  }
  
  @VasWebviewJsPluginV2.JsbridgeSubscribe(args="callback", method="getCurrentRoomId")
  public void getCurrentRoomId(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getCurrentRoomId callback = ");
    ((StringBuilder)localObject).append(paramString);
    QLog.e("QQIliveJsPlugin", 1, ((StringBuilder)localObject).toString());
    localObject = new Bundle();
    ((Bundle)localObject).putString("callback_id", paramString);
    IliveLiteEventCenter.a().a("ACTION_WEBVIEW_GET_CURRENT_ROOM_ID", (Bundle)localObject);
  }
  
  @VasWebviewJsPluginV2.JsbridgeSubscribe(args="callback|roomId", method="getLiveRoomIndex")
  public void getLiveRoomIndex(String paramString1, String paramString2)
  {
    int i = LiveLiteRoomSwitchService.a(paramString2);
    int j = LiveLiteRoomSwitchService.b();
    try
    {
      paramString2 = new JSONObject();
      paramString2.put("index", i);
      paramString2.put("count", j);
      callJs(paramString1, new String[] { paramString2.toString() });
      return;
    }
    catch (Exception paramString1)
    {
      paramString2 = new StringBuilder();
      paramString2.append("error getLiveRoomIndex ");
      paramString2.append(paramString1);
      QLog.e("QQIliveJsPlugin", 1, paramString2.toString());
    }
  }
  
  @VasWebviewJsPluginV2.JsbridgeSubscribe(args="", method="loadH5Finish")
  public void loadH5Finish()
  {
    this.mH5LoadFinish = true;
    IliveLiteDataReport.a().e();
  }
  
  @VasWebviewJsPluginV2.JsbridgeSubscribe(args="callback", method="needShowGiftIcon")
  public void needShowGiftIcon(String paramString)
  {
    Object localObject = getEnterRooInfo();
    if (localObject == null)
    {
      callNeedShowGiftIcon(-1, "get enterRoomInfo source wrong", paramString);
      return;
    }
    LiveAnchorInfo localLiveAnchorInfo = getAnchorInfo();
    if (localLiveAnchorInfo == null)
    {
      callNeedShowGiftIcon(-1, "get anchorInfo source wrong", paramString);
      return;
    }
    long l1 = ((EnterRoomInfo)localObject).extData.getLong("ext_enter_room_video_source_app_id");
    int i = ((EnterRoomInfo)localObject).extData.getInt("ext_enter_room_room_type");
    int j = ((EnterRoomInfo)localObject).extData.getInt("ext_enter_room_game_id");
    long l2 = localLiveAnchorInfo.uid;
    localObject = ((IQQLiveSDKManager)QRoute.api(IQQLiveSDKManager.class)).getSDKImpl("1037");
    if (localObject != null) {
      ((IQQLiveSDK)localObject).getGiftEntranceService().needShowGiftIcon(l1, i, j, String.valueOf(l2), new QQIliveJsPlugin.3(this, paramString));
    }
  }
  
  @VasWebviewJsPluginV2.JsbridgeSubscribe(args="OperType", method="notifyLiveMessage")
  public void notifyLiveMessage(int paramInt)
  {
    JsBizAdapter localJsBizAdapter = this.mJsBizAdapter;
    if ((localJsBizAdapter != null) && (localJsBizAdapter.getModuleEvent() != null) && (paramInt == 1)) {
      this.mJsBizAdapter.getModuleEvent().post(new RoomCloseEvent((short)1001));
    }
  }
  
  @VasWebviewJsPluginV2.JsbridgeSubscribe(args="roomId|programId|status", method="notifyStatus")
  public void notifyStatus(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = this.mJsBizAdapter;
    if ((paramString1 != null) && (paramString1.getModuleEvent() != null) && (paramString3.equals("2"))) {
      this.mJsBizAdapter.getModuleEvent().post(new RoomCloseEvent((short)1001));
    }
  }
  
  @VasWebviewJsPluginV2.JsbridgeSubscribe(args="visible", method="notifyVisibility")
  public void notifyVisibility(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("notifyVisibility visible = ");
    ((StringBuilder)localObject).append(paramInt);
    localObject = ((StringBuilder)localObject).toString();
    boolean bool = true;
    QLog.e("QQIliveJsPlugin", 1, (String)localObject);
    localObject = new Bundle();
    if (paramInt != 1) {
      bool = false;
    }
    ((Bundle)localObject).putBoolean("webview_visible", bool);
    IliveLiteEventCenter.a().a("ACTION_WEBVIEW_VISIBILITY", (Bundle)localObject);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    IliveLiteEventCenter.a().b(this.mObserver);
    this.mJsBizAdapter = null;
    this.qqCustomDialog = null;
  }
  
  public void onInitJsAdapter(JsBizAdapter paramJsBizAdapter)
  {
    this.mJsBizAdapter = paramJsBizAdapter;
  }
  
  @VasWebviewJsPluginV2.JsbridgeSubscribe(args="", method="openGiftPanel")
  public void openGiftPanel()
  {
    handleOpenGiftPanel();
  }
  
  @VasWebviewJsPluginV2.JsbridgeSubscribe(args="callback|uin", method="openGroupAioOrProfile")
  public void openGroupAioOrProfile(String paramString1, String paramString2)
  {
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("groupUin", paramString2);
      QIPCClientHelper.getInstance().getClient().callServer("VasLiveIPCModule", "enterGroup", localBundle, null);
      super.callJs(paramString1);
      return;
    }
    catch (Exception paramString2)
    {
      super.callJsOnError(paramString1, paramString2.getMessage());
    }
  }
  
  @VasWebviewJsPluginV2.JsbridgeSubscribe(args="callback", method="registerCloseCallbackListener")
  public void registerCloseCallbackListener(String paramString)
  {
    if (this.mJsBizAdapter != null)
    {
      this.mCloseCallbackId = paramString;
      IliveLiteEventCenter.a().a(this.mObserver);
    }
  }
  
  @VasWebviewJsPluginV2.JsbridgeSubscribe(args="url", method="reload")
  public void reload(String paramString)
  {
    QLog.e("QQIliveJsPlugin", 1, "reload");
    Bundle localBundle = new Bundle();
    localBundle.putString("reload_url", paramString);
    IliveLiteEventCenter.a().a("ACTION_WEBVIEW_RELOAD", localBundle);
  }
  
  @VasWebviewJsPluginV2.JsbridgeSubscribe(args="", method="showGuide")
  public void showGuide()
  {
    QLog.e("IliveGuideModule", 1, "showGuide js");
    IliveLiteEventCenter.a().a("ACTION_SHOW_GUIDE", null);
  }
  
  @VasWebviewJsPluginV2.JsbridgeSubscribe(args="roomid", method="switchLiveRoom")
  public void switchLiveRoom(String paramString)
  {
    IliveLiteHelper.a().b();
    paramString = new IliveJumpParams(BaseApplicationImpl.getContext(), "", paramString, "", false, null, "", 99);
    IliveLiteHelper.a().a(paramString);
  }
  
  @VasWebviewJsPluginV2.JsbridgeSubscribe(args="callback", method="switchRoomListener")
  public void switchRoomListener(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("switchRoomListener callback = ");
    ((StringBuilder)localObject).append(paramString);
    QLog.e("QQIliveJsPlugin", 1, ((StringBuilder)localObject).toString());
    localObject = new Bundle();
    ((Bundle)localObject).putString("callback_id", paramString);
    IliveLiteEventCenter.a().a("ACTION_WEBVIEW_SET_SWITCH", (Bundle)localObject);
  }
  
  @VasWebviewJsPluginV2.JsbridgeSubscribe(args="uid|followedUid|isFollowed|roomId", method="syncFollowState")
  public void syncFollowState(long paramLong1, long paramLong2, int paramInt, String paramString)
  {
    Object localObject = new Intent();
    ((Intent)localObject).setAction("ACTION_QQ_LIVE_WEB_FOLLOW_STATE");
    ((Intent)localObject).putExtra("uid", paramLong1);
    ((Intent)localObject).putExtra("followedUid", paramLong2);
    ((Intent)localObject).putExtra("isFollowed", paramInt);
    ((Intent)localObject).putExtra("roomId", paramString);
    BaseApplicationImpl.getApplication().sendBroadcast((Intent)localObject);
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[syncFollowState]:,uid:");
      ((StringBuilder)localObject).append(paramLong1);
      ((StringBuilder)localObject).append(",followedUid:");
      ((StringBuilder)localObject).append(paramLong2);
      ((StringBuilder)localObject).append(",isFollowed:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(",roomId:");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("QQIliveJsPlugin", 4, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QQIliveJsPlugin
 * JD-Core Version:    0.7.0.1
 */