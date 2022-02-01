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
    EnterExitRoomCallback localEnterExitRoomCallback = (EnterExitRoomCallback)AbstractCustomRoomService.a(this.b).remove(Long.valueOf(a()));
    if (localEnterExitRoomCallback == null) {
      return;
    }
    if (paramInt == 0) {
      try
      {
        paramInt = paramJSONObject.getInt("retcode");
        if (paramInt == 0) {
          try
          {
            paramJSONObject = paramJSONObject.getString("offset_hls");
            this.b.b.watchMediaInfo.mUrl = paramJSONObject;
            this.b.b.watchMediaInfo.mUrlHigh = paramJSONObject;
            this.b.b.watchMediaInfo.mUrlLow = paramJSONObject;
            this.b.b.watchMediaInfo.mUrlLowest = paramJSONObject;
            localEnterExitRoomCallback.onSuccess();
            this.b.a(System.currentTimeMillis() - this.a);
            return;
          }
          catch (JSONException paramJSONObject)
          {
            paramJSONObject.printStackTrace();
            this.b.a(System.currentTimeMillis() - this.a, -2, paramJSONObject.getMessage());
            return;
          }
        }
        localEnterExitRoomCallback.onFail(-1, "");
        this.b.a(System.currentTimeMillis() - this.a, -1, "");
        return;
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        this.b.a(System.currentTimeMillis() - this.a, -2, paramJSONObject.getMessage());
        return;
      }
    }
    localEnterExitRoomCallback.onFail(-1, "");
    this.b.a(System.currentTimeMillis() - this.a, -1, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.room.AbstractCustomRoomService.3
 * JD-Core Version:    0.7.0.1
 */