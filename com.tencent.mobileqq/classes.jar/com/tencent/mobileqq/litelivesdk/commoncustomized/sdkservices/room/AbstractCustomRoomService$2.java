package com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.room;

import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilivesdk.roomservice_interface.EnterExitRoomCallback;
import com.tencent.ilivesdk.roomservice_interface.RoomServiceAdapter;
import com.tencent.ilivesdk.roomservice_interface.model.LiveInfo;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

class AbstractCustomRoomService$2
  extends HttpCallbacker
{
  AbstractCustomRoomService$2(AbstractCustomRoomService paramAbstractCustomRoomService, long paramLong) {}
  
  public void onResponse(int paramInt, JSONObject paramJSONObject)
  {
    EnterExitRoomCallback localEnterExitRoomCallback = (EnterExitRoomCallback)AbstractCustomRoomService.a(this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedSdkservicesRoomAbstractCustomRoomService).remove(Long.valueOf(a()));
    if (localEnterExitRoomCallback == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedSdkservicesRoomAbstractCustomRoomService.jdField_a_of_type_ComTencentIlivesdkRoomservice_interfaceRoomServiceAdapter.getLogger().i("AbstractCustomRoomService", "listener video callback canceled...", new Object[0]);
      return;
    }
    if ((paramInt == 0) && (paramJSONObject != null)) {
      try
      {
        paramJSONObject = paramJSONObject.getJSONObject("result").getJSONObject("video_info").getString("video_play_url");
        this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedSdkservicesRoomAbstractCustomRoomService.jdField_a_of_type_ComTencentIlivesdkRoomservice_interfaceModelLiveInfo.watchMediaInfo.mUrl = paramJSONObject;
        this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedSdkservicesRoomAbstractCustomRoomService.jdField_a_of_type_ComTencentIlivesdkRoomservice_interfaceModelLiveInfo.watchMediaInfo.mUrlHigh = paramJSONObject;
        this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedSdkservicesRoomAbstractCustomRoomService.jdField_a_of_type_ComTencentIlivesdkRoomservice_interfaceModelLiveInfo.watchMediaInfo.mUrlLow = paramJSONObject;
        this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedSdkservicesRoomAbstractCustomRoomService.jdField_a_of_type_ComTencentIlivesdkRoomservice_interfaceModelLiveInfo.watchMediaInfo.mUrlLowest = paramJSONObject;
        localEnterExitRoomCallback.onSuccess();
        this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedSdkservicesRoomAbstractCustomRoomService.a(System.currentTimeMillis() - this.jdField_a_of_type_Long);
        return;
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        localEnterExitRoomCallback.onFail(-1, "");
        this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedSdkservicesRoomAbstractCustomRoomService.a(System.currentTimeMillis() - this.jdField_a_of_type_Long, -2, paramJSONObject.getMessage());
        return;
      }
    }
    localEnterExitRoomCallback.onFail(-1, "");
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedSdkservicesRoomAbstractCustomRoomService.a(System.currentTimeMillis() - this.jdField_a_of_type_Long, -1, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.room.AbstractCustomRoomService.2
 * JD-Core Version:    0.7.0.1
 */