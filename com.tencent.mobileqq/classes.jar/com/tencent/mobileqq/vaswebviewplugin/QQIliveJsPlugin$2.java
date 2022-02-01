package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.falco.base.libapi.activitylife.ActivityLifeService;
import com.tencent.ilive.litepages.room.webmodule.jsmodule.JsBizAdapter;
import com.tencent.ilivesdk.roomservice_interface.model.LiveInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveRoomInfo;
import com.tencent.livesdk.roomengine.RoomEnginLogic;
import com.tencent.livesdk.roomengine.RoomEngine;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.lite.IliveLiteHelper;
import cooperation.ilive.lite.event.IliveLiteEventCenter.Observer;
import java.util.HashMap;
import org.json.JSONObject;

class QQIliveJsPlugin$2
  implements IliveLiteEventCenter.Observer
{
  QQIliveJsPlugin$2(QQIliveJsPlugin paramQQIliveJsPlugin) {}
  
  public boolean onCall(String paramString, Bundle paramBundle)
  {
    if ((paramString.equals("ACTION_CLOSE_ROOM")) && (QQIliveJsPlugin.access$000(this.this$0) != null)) {
      try
      {
        paramString = QQIliveJsPlugin.access$000(this.this$0).getModuleRoomEngine();
        if (paramString == null) {
          return false;
        }
        Activity localActivity = ((ActivityLifeService)paramString.getService(ActivityLifeService.class)).getTopActivity();
        if ((localActivity != null) && (localActivity.getRequestedOrientation() == 0)) {
          return false;
        }
        paramString = paramString.getEnginLogic();
        if (paramString == null) {
          return false;
        }
        paramString = paramString.getLiveInfo();
        if ((paramString == null) || (paramString.roomInfo == null)) {
          break label243;
        }
        long l1 = paramString.roomInfo.roomId;
        long l2 = paramBundle.getLong("roomId");
        int i = paramBundle.getInt("closeFrom");
        if ((l1 == l2) && (QQIliveJsPlugin.access$100(this.this$0)))
        {
          paramString = new JSONObject();
          paramString.put("ret", 0);
          paramString.put("type", 1);
          this.this$0.callJs(QQIliveJsPlugin.access$200(this.this$0), new String[] { paramString.toString() });
          QQIliveJsPlugin.access$300(this.this$0).put(Long.valueOf(l1), Integer.valueOf(i));
          IliveLiteHelper.b();
          return true;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("QQIliveJsPlugin", 1, "error getLiveRoomIndex " + paramString);
      }
    } else {
      return false;
    }
    label243:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QQIliveJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */