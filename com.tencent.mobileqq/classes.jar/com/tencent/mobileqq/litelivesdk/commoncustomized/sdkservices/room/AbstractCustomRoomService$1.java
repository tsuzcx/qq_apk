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
    EnterExitRoomCallback localEnterExitRoomCallback = this.a;
    if (localEnterExitRoomCallback != null) {
      localEnterExitRoomCallback.onFail(paramInt, "");
    }
    this.d.a(System.currentTimeMillis() - this.b, paramInt, paramString);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    LogFactory.a().c("AbstractCustomRoomService", "----------watchEnterRoom，LiveRoom, onRecv");
    if (this.a == null)
    {
      this.d.a.getLogger().i("AbstractCustomRoomService", "listener live callback canceled...", new Object[0]);
      return;
    }
    try
    {
      int i = paramJSONObject.getInt("retcode");
      if (i == 0)
      {
        if (!paramJSONObject.getBoolean("is_on_live"))
        {
          this.a.onSuccess();
          this.d.a(System.currentTimeMillis() - this.b);
          return;
        }
        paramJSONObject = paramJSONObject.getJSONArray("streaming_urls");
        if (paramJSONObject.length() != 0)
        {
          this.d.b.watchMediaInfo.mUrl = ((String)paramJSONObject.get(0));
          this.d.b.watchMediaInfo.mUrlHigh = ((String)paramJSONObject.get(1));
          this.d.b.watchMediaInfo.mUrlLow = ((String)paramJSONObject.get(2));
          this.d.b.watchMediaInfo.mUrlLowest = ((String)paramJSONObject.get(3));
          this.d.b.roomInfo.roomId = this.c.roomId;
          this.a.onSuccess();
          this.d.a(System.currentTimeMillis() - this.b);
          return;
        }
        this.a.onFail(-1, "");
        this.d.a(System.currentTimeMillis() - this.b, -1, "");
        return;
      }
      paramJSONObject = this.d.a.getLogger();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("parseGetLivePlayUrlData retCode = ");
      ((StringBuilder)localObject).append(i);
      paramJSONObject.e("AbstractCustomRoomService", ((StringBuilder)localObject).toString(), new Object[0]);
      this.a.onFail(-1, "");
      this.d.a(System.currentTimeMillis() - this.b, -1, "");
      return;
    }
    catch (Exception paramJSONObject)
    {
      Object localObject = this.d.a.getLogger();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("parseGetLivePlayUrlData JSONException = ");
      localStringBuilder.append(paramJSONObject.getMessage());
      ((com.tencent.falco.base.libapi.log.LogInterface)localObject).e("AbstractCustomRoomService", localStringBuilder.toString(), new Object[0]);
      this.a.onFail(-1, "");
      this.d.a(System.currentTimeMillis() - this.b, -2, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.room.AbstractCustomRoomService.1
 * JD-Core Version:    0.7.0.1
 */