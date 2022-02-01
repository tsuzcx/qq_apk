package com.tencent.mobileqq.redtouch;

import bbbq;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class RedTouchManager$6
  implements Runnable
{
  public RedTouchManager$6(bbbq parambbbq, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    Object localObject = this.this$0.b(this.a).iterator();
    BusinessInfoCheckUpdate.AppInfo localAppInfo;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localAppInfo = (BusinessInfoCheckUpdate.AppInfo)((Iterator)localObject).next();
    } while (localAppInfo.mission_level.get() != 0);
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("level", 0);
      this.this$0.a(localAppInfo, null, this.b, ((JSONObject)localObject).toString());
      bbbq.a("level zero report appSet:" + this.a + " reportType:" + this.b + "appId:" + localAppInfo.uiAppId.get());
      return;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("RedPointLog.RedTouchManager", 1, "level zero report JSONException ", localJSONException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.RedTouchManager.6
 * JD-Core Version:    0.7.0.1
 */