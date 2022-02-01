package com.tencent.mobileqq.intervideo.lite_now_biz.services;

import com.tencent.ilivesdk.roomservice_interface.EnterExitRoomCallback;
import com.tencent.ilivesdk.roomservice_interface.RoomServiceAdapter;
import com.tencent.ilivesdk.roomservice_interface.model.EnterRoomInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveInfo;
import com.tencent.mobileqq.litelivesdk.utils.https.HttpsInterface.CallBack;
import com.tencent.mobileqq.litelivesdk.utils.log.LogFactory;
import org.json.JSONArray;
import org.json.JSONObject;

class VoiceRoomService$2
  implements HttpsInterface.CallBack
{
  VoiceRoomService$2(VoiceRoomService paramVoiceRoomService, EnterExitRoomCallback paramEnterExitRoomCallback, long paramLong) {}
  
  public void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentIlivesdkRoomservice_interfaceEnterExitRoomCallback != null) {
      this.jdField_a_of_type_ComTencentIlivesdkRoomservice_interfaceEnterExitRoomCallback.onSuccess();
    }
    VoiceRoomService.b(this.jdField_a_of_type_ComTencentMobileqqIntervideoLite_now_bizServicesVoiceRoomService, System.currentTimeMillis() - this.jdField_a_of_type_Long, paramInt, paramString);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    LogFactory.a().c("AbstractCustomRoomService", "----------watchEnterRoom，LiveRoom, onRecv");
    if (this.jdField_a_of_type_ComTencentIlivesdkRoomservice_interfaceEnterExitRoomCallback == null)
    {
      VoiceRoomService.c(this.jdField_a_of_type_ComTencentMobileqqIntervideoLite_now_bizServicesVoiceRoomService).getLogger().i("AbstractCustomRoomService", "listener live callback canceled...", new Object[0]);
      return;
    }
    try
    {
      if ((paramJSONObject.getInt("retcode") == 0) && (paramJSONObject.getBoolean("is_on_live")))
      {
        paramJSONObject = paramJSONObject.getJSONArray("streaming_urls");
        if (paramJSONObject.length() != 0)
        {
          VoiceRoomService.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoLite_now_bizServicesVoiceRoomService).watchMediaInfo.mUrl = ((String)paramJSONObject.get(0));
          VoiceRoomService.b(this.jdField_a_of_type_ComTencentMobileqqIntervideoLite_now_bizServicesVoiceRoomService).watchMediaInfo.mUrlHigh = ((String)paramJSONObject.get(1));
          VoiceRoomService.c(this.jdField_a_of_type_ComTencentMobileqqIntervideoLite_now_bizServicesVoiceRoomService).watchMediaInfo.mUrlLow = ((String)paramJSONObject.get(2));
          VoiceRoomService.d(this.jdField_a_of_type_ComTencentMobileqqIntervideoLite_now_bizServicesVoiceRoomService).watchMediaInfo.mUrlLowest = ((String)paramJSONObject.get(3));
          VoiceRoomService.e(this.jdField_a_of_type_ComTencentMobileqqIntervideoLite_now_bizServicesVoiceRoomService).roomInfo.roomId = VoiceRoomService.b(this.jdField_a_of_type_ComTencentMobileqqIntervideoLite_now_bizServicesVoiceRoomService).roomId;
          VoiceRoomService.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoLite_now_bizServicesVoiceRoomService, System.currentTimeMillis() - this.jdField_a_of_type_Long);
        }
      }
      this.jdField_a_of_type_ComTencentIlivesdkRoomservice_interfaceEnterExitRoomCallback.onSuccess();
      return;
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        VoiceRoomService.d(this.jdField_a_of_type_ComTencentMobileqqIntervideoLite_now_bizServicesVoiceRoomService).getLogger().e("AbstractCustomRoomService", "parseGetLivePlayUrlData JSONException = " + paramJSONObject.getMessage(), new Object[0]);
        VoiceRoomService.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoLite_now_bizServicesVoiceRoomService, System.currentTimeMillis() - this.jdField_a_of_type_Long, -2, "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.services.VoiceRoomService.2
 * JD-Core Version:    0.7.0.1
 */