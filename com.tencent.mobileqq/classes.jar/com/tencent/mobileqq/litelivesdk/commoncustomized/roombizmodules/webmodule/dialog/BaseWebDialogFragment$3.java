package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.dialog;

import com.tencent.falco.base.libapi.http.HttpInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilive.base.event.ModuleEvent;
import com.tencent.ilive.enginemanager.BizEngineMgr;
import com.tencent.ilive.interfaces.RoomPageActionInterface;
import com.tencent.ilive.litepages.room.webmodule.jsmodule.JsBizAdapter;
import com.tencent.ilive.litepages.room.webmodule.jsmodule.JsBizAdapter.ValueCallback;
import com.tencent.ilive.litepages.room.webmodule.model.RoomExtInfo;
import com.tencent.livesdk.liveengine.LiveEngine;
import com.tencent.livesdk.roomengine.RoomEngine;
import com.tencent.smtt.sdk.WebView;
import org.json.JSONObject;

class BaseWebDialogFragment$3
  implements JsBizAdapter
{
  BaseWebDialogFragment$3(BaseWebDialogFragment paramBaseWebDialogFragment) {}
  
  public void callJsFunctionByNative(String paramString, JSONObject paramJSONObject, JsBizAdapter.ValueCallback paramValueCallback)
  {
    if (this.a.a == null) {
      return;
    }
    if (paramJSONObject != null) {}
    for (paramString = "javascript:(" + paramString + "(" + paramJSONObject.toString() + "))";; paramString = "javascript:" + paramString + "()")
    {
      this.a.a.evaluateJavascript(paramString, new BaseWebDialogFragment.3.1(this, paramValueCallback));
      return;
    }
  }
  
  public HttpInterface getHttp()
  {
    return (HttpInterface)BizEngineMgr.getInstance().getLiveEngine().getService(HttpInterface.class);
  }
  
  public LogInterface getLogger()
  {
    return (LogInterface)BizEngineMgr.getInstance().getLiveEngine().getService(LogInterface.class);
  }
  
  public ModuleEvent getModuleEvent()
  {
    return null;
  }
  
  public RoomEngine getModuleRoomEngine()
  {
    return null;
  }
  
  public RoomPageActionInterface getRoomPageAction()
  {
    return null;
  }
  
  public void onGetRoomInfo(RoomExtInfo paramRoomExtInfo) {}
  
  public void onPlayerPause() {}
  
  public void onPlayerResume() {}
  
  public void onSubscribeStateChanged(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.dialog.BaseWebDialogFragment.3
 * JD-Core Version:    0.7.0.1
 */