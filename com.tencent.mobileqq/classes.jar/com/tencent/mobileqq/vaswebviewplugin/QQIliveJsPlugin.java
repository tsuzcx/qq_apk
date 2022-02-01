package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ilive.base.event.ModuleEvent;
import com.tencent.ilive.litepages.room.webmodule.jsmodule.JsBizAdapter;
import com.tencent.ilive.pages.room.events.RoomCloseEvent;
import com.tencent.ilivesdk.roomservice_interface.model.LiveInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveRoomInfo;
import com.tencent.livesdk.roomengine.RoomEnginLogic;
import com.tencent.livesdk.roomengine.RoomEngine;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.webview.LiteLiveJsInterface;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.entity.IliveJumpParams;
import cooperation.ilive.lite.IliveLiteHelper;
import cooperation.ilive.lite.event.IliveLiteEventCenter;
import cooperation.ilive.lite.event.IliveLiteEventCenter.Observer;
import cooperation.ilive.lite.report.IliveLiteDataReport;
import cooperation.ilive.lite.rommswitch.LiveLiteRoomSwitchService;
import eipc.EIPCClient;
import java.util.HashMap;
import org.json.JSONObject;

public class QQIliveJsPlugin
  extends VasWebviewJsPluginV2
  implements LiteLiveJsInterface
{
  private static final String ACTION_NOTIFY_FOLLOW_CHANGE = "action_follow_change";
  public static final String BUSINESS_NAME = "vaslive";
  private static final String KEY_FOLLOW_STATE = "key_follow_state";
  private static final String TAG = "QQIliveJsPlugin";
  private String mCloseCallbackId;
  private boolean mH5LoadFinish = false;
  private JsBizAdapter mJsBizAdapter;
  private IliveLiteEventCenter.Observer mObserver = new QQIliveJsPlugin.2(this);
  private HashMap<Long, Integer> mOptionMap = new HashMap();
  
  public QQIliveJsPlugin()
  {
    super("vaslive");
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
  
  private void sendToJsExit(long paramLong, int paramInt, JSONObject paramJSONObject)
  {
    callJs(this.mCloseCallbackId, new String[] { paramJSONObject.toString() });
    this.mOptionMap.put(Long.valueOf(paramLong), Integer.valueOf(paramInt));
    IliveLiteHelper.b();
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
    int j = LiveLiteRoomSwitchService.a();
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
    IliveLiteDataReport.a().c();
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
  }
  
  public void onInitJsAdapter(JsBizAdapter paramJsBizAdapter)
  {
    this.mJsBizAdapter = paramJsBizAdapter;
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
    IliveLiteHelper.a().a();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QQIliveJsPlugin
 * JD-Core Version:    0.7.0.1
 */