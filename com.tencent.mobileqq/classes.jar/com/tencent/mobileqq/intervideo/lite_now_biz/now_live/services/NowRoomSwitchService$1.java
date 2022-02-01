package com.tencent.mobileqq.intervideo.lite_now_biz.now_live.services;

import com.tencent.falco.base.libapi.http.HttpResponse;
import com.tencent.ilivesdk.roomswitchservice_interface.RoomSwitchInterface.IRoomList;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONObject;

class NowRoomSwitchService$1
  implements HttpResponse
{
  NowRoomSwitchService$1(NowRoomSwitchService paramNowRoomSwitchService, List paramList, RoomSwitchInterface.IRoomList paramIRoomList) {}
  
  public void onResponse(int paramInt, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    if (paramJSONObject.optInt("retcode", -1) == 0)
    {
      paramJSONObject = NowRoomSwitchService.a(this.c, paramJSONObject);
      paramJSONObject = NowRoomSwitchService.a(this.c, this.a, paramJSONObject);
      ThreadManager.getUIHandler().post(new NowRoomSwitchService.1.1(this, paramJSONObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.now_live.services.NowRoomSwitchService.1
 * JD-Core Version:    0.7.0.1
 */