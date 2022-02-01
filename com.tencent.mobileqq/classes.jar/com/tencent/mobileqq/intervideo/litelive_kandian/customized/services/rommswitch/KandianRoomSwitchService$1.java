package com.tencent.mobileqq.intervideo.litelive_kandian.customized.services.rommswitch;

import com.tencent.ilivesdk.roomswitchservice_interface.RoomSwitchInterface.IRoomList;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.litelivesdk.utils.AegisHelper;
import com.tencent.mobileqq.litelivesdk.utils.https.HttpsInterface.CallBack;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

class KandianRoomSwitchService$1
  implements HttpsInterface.CallBack
{
  KandianRoomSwitchService$1(KandianRoomSwitchService paramKandianRoomSwitchService, List paramList, int paramInt, RoomSwitchInterface.IRoomList paramIRoomList) {}
  
  public void a(int paramInt, String paramString)
  {
    ThreadManager.getUIHandler().post(new KandianRoomSwitchService.1.2(this));
    AegisHelper.a(String.format("errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt), paramString }), "RoomSwitchCgiService");
  }
  
  public void a(JSONObject paramJSONObject)
  {
    try
    {
      int i = paramJSONObject.getInt("retcode");
      if (i == 0)
      {
        KandianRoomSwitchService.a(this.jdField_a_of_type_ComTencentMobileqqIntervideoLitelive_kandianCustomizedServicesRommswitchKandianRoomSwitchService, this.jdField_a_of_type_JavaUtilList, paramJSONObject, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentIlivesdkRoomswitchservice_interfaceRoomSwitchInterface$IRoomList);
        return;
      }
      paramJSONObject.getString("errmsg");
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("retCode = ");
      paramJSONObject.append(i);
      AegisHelper.a(paramJSONObject.toString(), "RoomSwitchCgiService");
      ThreadManager.getUIHandler().post(new KandianRoomSwitchService.1.1(this));
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
      AegisHelper.a(paramJSONObject.getMessage(), "RoomSwitchCgiService");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.litelive_kandian.customized.services.rommswitch.KandianRoomSwitchService.1
 * JD-Core Version:    0.7.0.1
 */