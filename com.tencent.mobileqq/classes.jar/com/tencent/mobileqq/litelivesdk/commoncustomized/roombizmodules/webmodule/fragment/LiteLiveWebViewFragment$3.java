package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.fragment;

import com.tencent.biz.ui.TouchWebView;
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
import org.json.JSONObject;

class LiteLiveWebViewFragment$3
  implements JsBizAdapter
{
  LiteLiveWebViewFragment$3(LiteLiveWebViewFragment paramLiteLiveWebViewFragment) {}
  
  public void callJsFunctionByNative(String paramString, JSONObject paramJSONObject, JsBizAdapter.ValueCallback paramValueCallback)
  {
    if (!this.a.isDestroyed())
    {
      if (LiteLiveWebViewFragment.b(this.a) == null) {
        return;
      }
      if (paramJSONObject != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("javascript:(");
        localStringBuilder.append(paramString);
        localStringBuilder.append("(");
        localStringBuilder.append(paramJSONObject.toString());
        localStringBuilder.append("))");
        paramString = localStringBuilder.toString();
      }
      else
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("javascript:");
        paramJSONObject.append(paramString);
        paramJSONObject.append("()");
        paramString = paramJSONObject.toString();
      }
      LiteLiveWebViewFragment.c(this.a).evaluateJavascript(paramString, new LiteLiveWebViewFragment.3.1(this, paramValueCallback));
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
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.fragment.LiteLiveWebViewFragment.3
 * JD-Core Version:    0.7.0.1
 */