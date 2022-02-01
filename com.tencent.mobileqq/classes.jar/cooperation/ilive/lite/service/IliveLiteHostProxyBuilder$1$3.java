package cooperation.ilive.lite.service;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.falco.base.libapi.activitylife.ActivityLifeService;
import com.tencent.falco.base.libapi.hostproxy.HostChargeCallback;
import com.tencent.falco.base.libapi.hostproxy.SdkEventInterface;
import com.tencent.ilive.enginemanager.BizEngineMgr;
import com.tencent.ilivesdk.roomservice_interface.model.LiveInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveRoomInfo;
import com.tencent.livesdk.accountengine.UserEngine;
import com.tencent.livesdk.roomengine.RoomEnginLogic;
import com.tencent.livesdk.roomengine.RoomEngine;
import com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.webview.WebViewPool;
import com.tencent.mobileqq.vas.VasStatisticCollector;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.lite.IliveLiteMonitorUtil;
import cooperation.ilive.lite.event.IliveLiteEventCenter;
import cooperation.ilive.lite.module.IliveSingleWebModule;
import cooperation.ilive.lite.report.IliveLiteDataReport;
import cooperation.ilive.lite.rommswitch.LiveLiteRoomSwitchService;
import java.util.HashMap;
import java.util.Map;

class IliveLiteHostProxyBuilder$1$3
  implements SdkEventInterface
{
  IliveLiteHostProxyBuilder$1$3(IliveLiteHostProxyBuilder.1 param1) {}
  
  public boolean onBackPressed()
  {
    boolean bool2 = true;
    boolean bool1;
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putLong("roomId", BizEngineMgr.getInstance().getUserEngine().getCurrentRoomEngine().getEnginLogic().getLiveInfo().roomInfo.roomId);
      localBundle.putInt("closeFrom", 1004);
      bool1 = IliveLiteEventCenter.a().a("ACTION_CLOSE_ROOM", localBundle);
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handle on backpress error ");
      localStringBuilder.append(localException);
      QLog.e("IliveLiteHostProxyBuilder", 1, localStringBuilder.toString());
      bool1 = false;
    }
    if (!bool1) {
      bool2 = IliveLiteEventCenter.a().a("ACTION_BACK_PRESS", null);
    }
    return bool2;
  }
  
  public void onChargeJump(HostChargeCallback paramHostChargeCallback) {}
  
  public void onCoreUILoaded() {}
  
  public void onCreateRoom()
  {
    IliveLiteDataReport.a().a();
    IliveLiteMonitorUtil.a("live_enter_tick_time", "create_room");
  }
  
  public void onDestroyRoom()
  {
    WebViewPool.a.b();
    LiveLiteRoomSwitchService.a();
    Activity localActivity = ((ActivityLifeService)BizEngineMgr.getInstance().getUserEngine().getCurrentRoomEngine().getService(ActivityLifeService.class)).getTopActivity();
    if (localActivity != null) {
      localActivity.overridePendingTransition(0, 0);
    }
    IliveLiteDataReport.a().d();
    IliveSingleWebModule.c();
  }
  
  public void onEnterRoom(long paramLong, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("roomid", String.valueOf(paramLong));
    VasStatisticCollector.a("lite_on_enter_room", localHashMap, 0L);
  }
  
  public void onExitLive() {}
  
  public void onExitRoom()
  {
    VasStatisticCollector.a("lite_on_exit_room", null, 0L);
  }
  
  public void onFirstFrame()
  {
    IliveLiteDataReport.a().b();
  }
  
  public void onLoginFail(String paramString, int paramInt) {}
  
  public void onLoginSuccess(long paramLong, String paramString) {}
  
  public void onStartEnterRoom(long paramLong) {}
  
  public void onStartLive() {}
  
  public void onTransferWebViewAction(String paramString, Runnable paramRunnable, Map<String, String> paramMap) {}
  
  public void overridePendingTransition(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.lite.service.IliveLiteHostProxyBuilder.1.3
 * JD-Core Version:    0.7.0.1
 */