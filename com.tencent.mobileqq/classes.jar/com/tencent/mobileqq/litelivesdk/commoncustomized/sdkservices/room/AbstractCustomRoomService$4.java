package com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.room;

import com.tencent.mobileqq.litelivesdk.utils.https.HttpsInterface.CallBack;
import org.json.JSONException;
import org.json.JSONObject;

class AbstractCustomRoomService$4
  implements HttpsInterface.CallBack
{
  AbstractCustomRoomService$4(AbstractCustomRoomService paramAbstractCustomRoomService, HttpCallbacker paramHttpCallbacker) {}
  
  public void a(int paramInt, String paramString)
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedSdkservicesRoomHttpCallbacker.onResponse(paramInt, new JSONObject(paramString));
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkCommoncustomizedSdkservicesRoomHttpCallbacker.onResponse(0, paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.room.AbstractCustomRoomService.4
 * JD-Core Version:    0.7.0.1
 */