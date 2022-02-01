package com.tencent.mobileqq.qqlive.anchor.room.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.google.gson.Gson;
import com.tencent.mobileqq.qqlive.anchor.room.QQLiveAnchorRoom;
import com.tencent.mobileqq.qqlive.data.anchor.camera.QQLiveAnchorStreamRecordType;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomConfig;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomInfo;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import mqq.app.AppRuntime;
import org.json.JSONObject;

class QQLiveAnchorHelperFastResume$1
  implements Runnable
{
  QQLiveAnchorHelperFastResume$1(QQLiveAnchorHelperFastResume paramQQLiveAnchorHelperFastResume, Context paramContext, QQLiveAnchorRoom paramQQLiveAnchorRoom) {}
  
  public void run()
  {
    Object localObject1 = this.a.getSharedPreferences("qqlive_fastresume_record", 4);
    JSONObject localJSONObject = new JSONObject();
    Object localObject2 = this.b.f();
    try
    {
      localJSONObject.put("uid", ((QQLiveAnchorRoomInfo)localObject2).uid);
      localJSONObject.put("roomId", ((QQLiveAnchorRoomInfo)localObject2).roomData.id);
      localJSONObject.put("programId", ((QQLiveAnchorRoomInfo)localObject2).roomData.programId);
      localJSONObject.put("streamType", this.b.getRoomConfig().streamRecordType.ordinal());
      localJSONObject.put("recordTime", System.currentTimeMillis());
      localJSONObject.put("roomInfo", new Gson().toJson(localObject2));
      localJSONObject.put("roomConfig", new Gson().toJson(this.b.getRoomConfig()));
      localJSONObject.put("enterRoomTime", this.b.getEnterRoomTime());
      localObject1 = ((SharedPreferences)localObject1).edit();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("anchor_record_");
      ((StringBuilder)localObject2).append(this.b.g().getCurrentUin());
      ((SharedPreferences.Editor)localObject1).putString(((StringBuilder)localObject2).toString(), URLEncoder.encode(localJSONObject.toString(), "UTF-8")).apply();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QQLiveAnchor_fastResume", 1, "record err: ", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.anchor.room.helper.QQLiveAnchorHelperFastResume.1
 * JD-Core Version:    0.7.0.1
 */