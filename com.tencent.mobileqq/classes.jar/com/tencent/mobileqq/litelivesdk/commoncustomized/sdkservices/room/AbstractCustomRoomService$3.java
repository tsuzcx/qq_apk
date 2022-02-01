package com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.room;

import com.tencent.ilivesdk.roomservice_interface.EnterExitRoomCallback;
import com.tencent.ilivesdk.roomservice_interface.model.LiveInfo;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

class AbstractCustomRoomService$3
  extends HttpCallbacker
{
  AbstractCustomRoomService$3(AbstractCustomRoomService paramAbstractCustomRoomService, long paramLong) {}
  
  public void onResponse(int paramInt, JSONObject paramJSONObject)
  {
    EnterExitRoomCallback localEnterExitRoomCallback = (EnterExitRoomCallback)AbstractCustomRoomService.a(this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedSdkservicesRoomAbstractCustomRoomService).remove(Long.valueOf(a()));
    if (localEnterExitRoomCallback == null) {
      return;
    }
    if (paramInt == 0)
    {
      try
      {
        paramInt = paramJSONObject.getInt("retcode");
        if (paramInt == 0) {
          try
          {
            paramJSONObject = paramJSONObject.getString("offset_hls");
            this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedSdkservicesRoomAbstractCustomRoomService.a.watchMediaInfo.mUrl = paramJSONObject;
            this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedSdkservicesRoomAbstractCustomRoomService.a.watchMediaInfo.mUrlHigh = paramJSONObject;
            this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedSdkservicesRoomAbstractCustomRoomService.a.watchMediaInfo.mUrlLow = paramJSONObject;
            this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedSdkservicesRoomAbstractCustomRoomService.a.watchMediaInfo.mUrlLowest = paramJSONObject;
            localEnterExitRoomCallback.onSuccess();
            this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedSdkservicesRoomAbstractCustomRoomService.a(System.currentTimeMillis() - this.jdField_a_of_type_Long);
            return;
          }
          catch (JSONException paramJSONObject)
          {
            paramJSONObject.printStackTrace();
            this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedSdkservicesRoomAbstractCustomRoomService.a(System.currentTimeMillis() - this.jdField_a_of_type_Long, -2, paramJSONObject.getMessage());
            return;
          }
        }
        localEnterExitRoomCallback.onFail(-1, "");
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedSdkservicesRoomAbstractCustomRoomService.a(System.currentTimeMillis() - this.jdField_a_of_type_Long, -2, paramJSONObject.getMessage());
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedSdkservicesRoomAbstractCustomRoomService.a(System.currentTimeMillis() - this.jdField_a_of_type_Long, -1, "");
      return;
    }
    localEnterExitRoomCallback.onFail(-1, "");
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedSdkservicesRoomAbstractCustomRoomService.a(System.currentTimeMillis() - this.jdField_a_of_type_Long, -1, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.room.AbstractCustomRoomService.3
 * JD-Core Version:    0.7.0.1
 */