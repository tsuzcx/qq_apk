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
    if (paramJSONObject == null) {}
    while (paramJSONObject.optInt("retcode", -1) != 0) {
      return;
    }
    paramJSONObject = NowRoomSwitchService.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoLite_now_bizNow_liveServicesNowRoomSwitchService, paramJSONObject);
    paramJSONObject = NowRoomSwitchService.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoLite_now_bizNow_liveServicesNowRoomSwitchService, this.jdField_a_of_type_JavaUtilList, paramJSONObject);
    ThreadManager.getUIHandler().post(new NowRoomSwitchService.1.1(this, paramJSONObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.now_live.services.NowRoomSwitchService.1
 * JD-Core Version:    0.7.0.1
 */