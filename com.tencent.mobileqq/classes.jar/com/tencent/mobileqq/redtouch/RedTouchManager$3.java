package com.tencent.mobileqq.redtouch;

import android.os.Build.VERSION;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.ReportReqBody;
import com.tencent.mobileqq.tianshu.utils.RedTouchUtil;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class RedTouchManager$3
  implements Runnable
{
  RedTouchManager$3(RedTouchManager paramRedTouchManager, BusinessInfoCheckUpdate.AppInfo paramAppInfo, long paramLong) {}
  
  public void run()
  {
    BusinessInfoCheckUpdate.ReportReqBody localReportReqBody = new BusinessInfoCheckUpdate.ReportReqBody();
    localReportReqBody.uin.set(Long.parseLong(this.this$0.a.getCurrentAccountUin()));
    localReportReqBody.clientver.set("8.8.17.5770");
    localReportReqBody.platid.set(109);
    localReportReqBody.appid.set(RedTouchUtil.a(this.a.path.get()));
    Object localObject1 = localReportReqBody.platver;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(Build.VERSION.SDK_INT);
    ((StringBuilder)localObject2).append("");
    ((PBStringField)localObject1).set(((StringBuilder)localObject2).toString());
    localReportReqBody.cmd.set(18);
    localReportReqBody.extend.set(this.a.extend.get());
    if (this.a.missions.has()) {
      localReportReqBody.missionid.set(this.a.missions.get());
    }
    localObject2 = new JSONObject();
    Object localObject3;
    try
    {
      localObject1 = new JSONObject();
      try
      {
        ((JSONObject)localObject1).put("time_on_page", this.b);
      }
      catch (Exception localException1) {}
      localStringBuilder = new StringBuilder();
    }
    catch (Exception localException2)
    {
      localObject1 = localException1;
      localObject3 = localException2;
    }
    StringBuilder localStringBuilder;
    localStringBuilder.append("residenceReport parse json error ");
    localStringBuilder.append(localObject3);
    QLog.e("RedPointLog.RedTouchManager", 1, localStringBuilder.toString());
    localReportReqBody.buffer.set(((JSONObject)localObject1).toString());
    localObject1 = RedTouchManager.a(this.this$0, "RedTouchSvc.ClientReport");
    ((ToServiceMsg)localObject1).putWupBuffer(localReportReqBody.toByteArray());
    RedTouchManager.a(this.this$0, (ToServiceMsg)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.RedTouchManager.3
 * JD-Core Version:    0.7.0.1
 */