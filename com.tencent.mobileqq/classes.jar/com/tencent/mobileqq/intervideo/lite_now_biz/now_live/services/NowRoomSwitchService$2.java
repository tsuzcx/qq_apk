package com.tencent.mobileqq.intervideo.lite_now_biz.now_live.services;

import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilivesdk.roomswitchservice_interface.SwitchRoomInfo;
import com.tencent.mobileqq.litelivesdk.utils.https.HttpsInterface.CallBack;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class NowRoomSwitchService$2
  implements HttpsInterface.CallBack
{
  NowRoomSwitchService$2(NowRoomSwitchService paramNowRoomSwitchService, SwitchRoomInfo paramSwitchRoomInfo) {}
  
  public void a(int paramInt, String paramString)
  {
    NowRoomSwitchService.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoLite_now_bizNow_liveServicesNowRoomSwitchService).e("NowRoomSwitchService", "watchEnterRoom，LiveRoom, errCode[%d]  errMsg[%s] ", new Object[] { Integer.valueOf(paramInt), paramString });
  }
  
  public void a(JSONObject paramJSONObject)
  {
    NowRoomSwitchService.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoLite_now_bizNow_liveServicesNowRoomSwitchService).i("NowRoomSwitchService", "watchEnterRoom，LiveRoom, onRecv", new Object[0]);
    if (paramJSONObject == null) {
      return;
    }
    try
    {
      int i = paramJSONObject.getInt("retcode");
      if (i != 0)
      {
        NowRoomSwitchService.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoLite_now_bizNow_liveServicesNowRoomSwitchService).i("NowRoomSwitchService", "watchEnterRoom，LiveRoom, onRecv retCode [%d] ", new Object[] { Integer.valueOf(i) });
        return;
      }
      paramJSONObject = paramJSONObject.getJSONArray("streaming_urls");
      if (paramJSONObject.length() == 0)
      {
        NowRoomSwitchService.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoLite_now_bizNow_liveServicesNowRoomSwitchService).i("NowRoomSwitchService", "watchEnterRoom，LiveRoom, onRecv length[%d] ", new Object[] { Integer.valueOf(paramJSONObject.length()) });
        return;
      }
      NowRoomSwitchService.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoLite_now_bizNow_liveServicesNowRoomSwitchService).e("AVPlayerModule", "watchEnterRoom，switchRoomInfo.videoUrl[%s] ", new Object[] { this.jdField_a_of_type_ComTencentIlivesdkRoomswitchservice_interfaceSwitchRoomInfo.videoUrl });
      this.jdField_a_of_type_ComTencentIlivesdkRoomswitchservice_interfaceSwitchRoomInfo.videoUrl = ((String)paramJSONObject.get(0));
      return;
    }
    catch (JSONException paramJSONObject)
    {
      NowRoomSwitchService.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoLite_now_bizNow_liveServicesNowRoomSwitchService).e("NowRoomSwitchService", "watchEnterRoom，LiveRoom, onRecv  JSONException[%s] ", new Object[] { paramJSONObject });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.now_live.services.NowRoomSwitchService.2
 * JD-Core Version:    0.7.0.1
 */