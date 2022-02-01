package com.tencent.mobileqq.redtouch;

import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

class RedTouchManager$5
  implements Runnable
{
  RedTouchManager$5(RedTouchManager paramRedTouchManager, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    Object localObject = this.this$0.b(this.a).iterator();
    for (;;)
    {
      if (((Iterator)localObject).hasNext())
      {
        BusinessInfoCheckUpdate.AppInfo localAppInfo = (BusinessInfoCheckUpdate.AppInfo)((Iterator)localObject).next();
        if (localAppInfo.mission_level.get() == 0) {
          try
          {
            localObject = new JSONObject();
            ((JSONObject)localObject).put("level", 0);
            this.this$0.a(localAppInfo, null, this.b, ((JSONObject)localObject).toString());
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("level zero report appSet:");
            ((StringBuilder)localObject).append(this.a);
            ((StringBuilder)localObject).append(" reportType:");
            ((StringBuilder)localObject).append(this.b);
            ((StringBuilder)localObject).append("appId:");
            ((StringBuilder)localObject).append(localAppInfo.uiAppId.get());
            RedTouchManager.a(((StringBuilder)localObject).toString());
            return;
          }
          catch (JSONException localJSONException)
          {
            QLog.e("RedPointLog.RedTouchManager", 1, "level zero report JSONException ", localJSONException);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.RedTouchManager.5
 * JD-Core Version:    0.7.0.1
 */