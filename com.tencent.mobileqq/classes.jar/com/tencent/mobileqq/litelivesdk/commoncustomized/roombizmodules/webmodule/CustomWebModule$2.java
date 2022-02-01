package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule;

import com.tencent.biz.ui.TouchWebView;
import com.tencent.falco.base.libapi.http.HttpInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilive.base.event.ModuleEvent;
import com.tencent.ilive.interfaces.IAudienceRoomPager;
import com.tencent.ilive.interfaces.RoomPageActionInterface;
import com.tencent.ilive.litepages.room.webmodule.jsmodule.JsBizAdapter;
import com.tencent.ilive.litepages.room.webmodule.jsmodule.JsBizAdapter.ValueCallback;
import com.tencent.ilive.litepages.room.webmodule.model.RoomExtInfo;
import com.tencent.livesdk.roomengine.RoomEngine;
import org.json.JSONObject;

class CustomWebModule$2
  implements JsBizAdapter
{
  CustomWebModule$2(CustomWebModule paramCustomWebModule) {}
  
  public void callJsFunctionByNative(String paramString, JSONObject paramJSONObject, JsBizAdapter.ValueCallback paramValueCallback)
  {
    if (paramJSONObject != null) {}
    for (paramString = "javascript:(" + paramString + "(" + paramJSONObject.toString() + "))";; paramString = "javascript:" + paramString + "()")
    {
      if (this.a.a != null) {
        this.a.a.evaluateJavascript(paramString, new CustomWebModule.2.1(this, paramValueCallback));
      }
      return;
    }
  }
  
  public HttpInterface getHttp()
  {
    return this.a.getHttp();
  }
  
  public LogInterface getLogger()
  {
    return this.a.getLog();
  }
  
  public ModuleEvent getModuleEvent()
  {
    return this.a.getEvent();
  }
  
  public RoomEngine getModuleRoomEngine()
  {
    return this.a.getRoomEngine();
  }
  
  public RoomPageActionInterface getRoomPageAction()
  {
    return this.a.getAudienceRoomPager().getRoomPageAction();
  }
  
  public void onGetRoomInfo(RoomExtInfo paramRoomExtInfo)
  {
    this.a.a(paramRoomExtInfo);
  }
  
  public void onPlayerPause()
  {
    CustomWebModule.a(this.a, true);
  }
  
  public void onPlayerResume()
  {
    CustomWebModule.b(this.a);
  }
  
  public void onSubscribeStateChanged(boolean paramBoolean)
  {
    this.a.a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.CustomWebModule.2
 * JD-Core Version:    0.7.0.1
 */