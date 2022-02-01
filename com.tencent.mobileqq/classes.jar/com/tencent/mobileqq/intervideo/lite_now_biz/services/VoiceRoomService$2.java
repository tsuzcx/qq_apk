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
    EnterExitRoomCallback localEnterExitRoomCallback = this.a;
    if (localEnterExitRoomCallback != null) {
      localEnterExitRoomCallback.onSuccess();
    }
    VoiceRoomService.b(this.c, System.currentTimeMillis() - this.b, paramInt, paramString);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    LogFactory.a().c("AbstractCustomRoomService", "----------watchEnterRoom，LiveRoom, onRecv");
    if (this.a == null)
    {
      VoiceRoomService.d(this.c).getLogger().i("AbstractCustomRoomService", "listener live callback canceled...", new Object[0]);
      return;
    }
    try
    {
      if ((paramJSONObject.getInt("retcode") == 0) && (paramJSONObject.getBoolean("is_on_live")))
      {
        paramJSONObject = paramJSONObject.getJSONArray("streaming_urls");
        if (paramJSONObject.length() != 0)
        {
          VoiceRoomService.e(this.c).watchMediaInfo.mUrl = ((String)paramJSONObject.get(0));
          VoiceRoomService.f(this.c).watchMediaInfo.mUrlHigh = ((String)paramJSONObject.get(1));
          VoiceRoomService.g(this.c).watchMediaInfo.mUrlLow = ((String)paramJSONObject.get(2));
          VoiceRoomService.h(this.c).watchMediaInfo.mUrlLowest = ((String)paramJSONObject.get(3));
          VoiceRoomService.i(this.c).roomInfo.roomId = VoiceRoomService.j(this.c).roomId;
          VoiceRoomService.a(this.c, System.currentTimeMillis() - this.b);
        }
      }
    }
    catch (Exception paramJSONObject)
    {
      com.tencent.falco.base.libapi.log.LogInterface localLogInterface = VoiceRoomService.k(this.c).getLogger();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("parseGetLivePlayUrlData JSONException = ");
      localStringBuilder.append(paramJSONObject.getMessage());
      localLogInterface.e("AbstractCustomRoomService", localStringBuilder.toString(), new Object[0]);
      VoiceRoomService.a(this.c, System.currentTimeMillis() - this.b, -2, "");
    }
    this.a.onSuccess();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.services.VoiceRoomService.2
 * JD-Core Version:    0.7.0.1
 */