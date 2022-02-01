package com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.room;

import com.tencent.ilivesdk.roomservice_interface.EnterExitRoomCallback;
import com.tencent.ilivesdk.roomservice_interface.RoomServiceAdapter;
import com.tencent.ilivesdk.roomservice_interface.model.EnterRoomInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveInfo;
import com.tencent.mobileqq.litelivesdk.utils.https.HttpsInterface.CallBack;
import com.tencent.mobileqq.litelivesdk.utils.log.LogFactory;
import org.json.JSONArray;
import org.json.JSONObject;

class AbstractCustomRoomService$1
  implements HttpsInterface.CallBack
{
  AbstractCustomRoomService$1(AbstractCustomRoomService paramAbstractCustomRoomService, EnterExitRoomCallback paramEnterExitRoomCallback, long paramLong, EnterRoomInfo paramEnterRoomInfo) {}
  
  public void a(int paramInt, String paramString)
  {
    EnterExitRoomCallback localEnterExitRoomCallback = this.jdField_a_of_type_ComTencentIlivesdkRoomservice_interfaceEnterExitRoomCallback;
    if (localEnterExitRoomCallback != null) {
      localEnterExitRoomCallback.onFail(paramInt, "");
    }
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedSdkservicesRoomAbstractCustomRoomService.a(System.currentTimeMillis() - this.jdField_a_of_type_Long, paramInt, paramString);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    LogFactory.a().c("AbstractCustomRoomService", "----------watchEnterRoom，LiveRoom, onRecv");
    if (this.jdField_a_of_type_ComTencentIlivesdkRoomservice_interfaceEnterExitRoomCallback == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedSdkservicesRoomAbstractCustomRoomService.jdField_a_of_type_ComTencentIlivesdkRoomservice_interfaceRoomServiceAdapter.getLogger().i("AbstractCustomRoomService", "listener live callback canceled...", new Object[0]);
      return;
    }
    try
    {
      int i = paramJSONObject.getInt("retcode");
      if (i == 0)
      {
        if (!paramJSONObject.getBoolean("is_on_live"))
        {
          this.jdField_a_of_type_ComTencentIlivesdkRoomservice_interfaceEnterExitRoomCallback.onSuccess();
          this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedSdkservicesRoomAbstractCustomRoomService.a(System.currentTimeMillis() - this.jdField_a_of_type_Long);
          return;
        }
        paramJSONObject = paramJSONObject.getJSONArray("streaming_urls");
        if (paramJSONObject.length() != 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedSdkservicesRoomAbstractCustomRoomService.jdField_a_of_type_ComTencentIlivesdkRoomservice_interfaceModelLiveInfo.watchMediaInfo.mUrl = ((String)paramJSONObject.get(0));
          this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedSdkservicesRoomAbstractCustomRoomService.jdField_a_of_type_ComTencentIlivesdkRoomservice_interfaceModelLiveInfo.watchMediaInfo.mUrlHigh = ((String)paramJSONObject.get(1));
          this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedSdkservicesRoomAbstractCustomRoomService.jdField_a_of_type_ComTencentIlivesdkRoomservice_interfaceModelLiveInfo.watchMediaInfo.mUrlLow = ((String)paramJSONObject.get(2));
          this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedSdkservicesRoomAbstractCustomRoomService.jdField_a_of_type_ComTencentIlivesdkRoomservice_interfaceModelLiveInfo.watchMediaInfo.mUrlLowest = ((String)paramJSONObject.get(3));
          this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedSdkservicesRoomAbstractCustomRoomService.jdField_a_of_type_ComTencentIlivesdkRoomservice_interfaceModelLiveInfo.roomInfo.roomId = this.jdField_a_of_type_ComTencentIlivesdkRoomservice_interfaceModelEnterRoomInfo.roomId;
          this.jdField_a_of_type_ComTencentIlivesdkRoomservice_interfaceEnterExitRoomCallback.onSuccess();
          this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedSdkservicesRoomAbstractCustomRoomService.a(System.currentTimeMillis() - this.jdField_a_of_type_Long);
          return;
        }
        this.jdField_a_of_type_ComTencentIlivesdkRoomservice_interfaceEnterExitRoomCallback.onFail(-1, "");
        this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedSdkservicesRoomAbstractCustomRoomService.a(System.currentTimeMillis() - this.jdField_a_of_type_Long, -1, "");
        return;
      }
      paramJSONObject = this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedSdkservicesRoomAbstractCustomRoomService.jdField_a_of_type_ComTencentIlivesdkRoomservice_interfaceRoomServiceAdapter.getLogger();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("parseGetLivePlayUrlData retCode = ");
      ((StringBuilder)localObject).append(i);
      paramJSONObject.e("AbstractCustomRoomService", ((StringBuilder)localObject).toString(), new Object[0]);
      this.jdField_a_of_type_ComTencentIlivesdkRoomservice_interfaceEnterExitRoomCallback.onFail(-1, "");
      this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedSdkservicesRoomAbstractCustomRoomService.a(System.currentTimeMillis() - this.jdField_a_of_type_Long, -1, "");
      return;
    }
    catch (Exception paramJSONObject)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedSdkservicesRoomAbstractCustomRoomService.jdField_a_of_type_ComTencentIlivesdkRoomservice_interfaceRoomServiceAdapter.getLogger();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("parseGetLivePlayUrlData JSONException = ");
      localStringBuilder.append(paramJSONObject.getMessage());
      ((com.tencent.falco.base.libapi.log.LogInterface)localObject).e("AbstractCustomRoomService", localStringBuilder.toString(), new Object[0]);
      this.jdField_a_of_type_ComTencentIlivesdkRoomservice_interfaceEnterExitRoomCallback.onFail(-1, "");
      this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedSdkservicesRoomAbstractCustomRoomService.a(System.currentTimeMillis() - this.jdField_a_of_type_Long, -2, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.room.AbstractCustomRoomService.1
 * JD-Core Version:    0.7.0.1
 */