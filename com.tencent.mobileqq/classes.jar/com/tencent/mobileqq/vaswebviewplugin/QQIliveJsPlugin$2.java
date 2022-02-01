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
import cooperation.ilive.lite.event.IliveLiteEventCenter.Observer;
import cooperation.ilive.lite.floatwindow.IliveFloatWindowHelper;
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
        Object localObject = QQIliveJsPlugin.access$000(this.this$0).getModuleRoomEngine();
        if (localObject != null)
        {
          if (paramBundle == null) {
            return false;
          }
          paramString = ((ActivityLifeService)((RoomEngine)localObject).getService(ActivityLifeService.class)).getTopActivity();
          if ((paramString != null) && (paramString.getRequestedOrientation() == 0)) {
            return false;
          }
          localObject = ((RoomEngine)localObject).getEnginLogic();
          if (localObject == null) {
            return false;
          }
          localObject = ((RoomEnginLogic)localObject).getLiveInfo();
          if (localObject != null)
          {
            if (((LiveInfo)localObject).roomInfo == null) {
              return false;
            }
            long l1 = ((LiveInfo)localObject).roomInfo.roomId;
            long l2 = paramBundle.getLong("roomId");
            int i = paramBundle.getInt("closeFrom");
            if ((l1 != l2) || (!QQIliveJsPlugin.access$100(this.this$0))) {
              break label247;
            }
            paramBundle = new JSONObject();
            paramBundle.put("ret", 0);
            paramBundle.put("type", 1);
            if (IliveFloatWindowHelper.a(paramString, new QQIliveJsPlugin.PermissionCallback(this.this$0, l1, i, paramBundle))) {
              return true;
            }
            QQIliveJsPlugin.access$200(this.this$0, l1, i, paramBundle);
            return true;
          }
        }
        return false;
      }
      catch (Exception paramString)
      {
        paramBundle = new StringBuilder();
        paramBundle.append("error getLiveRoomIndex ");
        paramBundle.append(paramString);
        QLog.e("QQIliveJsPlugin", 1, paramBundle.toString());
      }
    }
    label247:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QQIliveJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */