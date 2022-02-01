package com.tencent.mobileqq.redtouch;

import android.os.Build.VERSION;
import bbav;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.ReportReqBody;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class RedTouchManager$4
  implements Runnable
{
  public RedTouchManager$4(bbav parambbav, BusinessInfoCheckUpdate.AppInfo paramAppInfo, long paramLong) {}
  
  public void run()
  {
    BusinessInfoCheckUpdate.ReportReqBody localReportReqBody = new BusinessInfoCheckUpdate.ReportReqBody();
    localReportReqBody.uin.set(Long.parseLong(this.this$0.a.getCurrentAccountUin()));
    localReportReqBody.clientver.set("8.4.5.4745");
    localReportReqBody.platid.set(109);
    localReportReqBody.appid.set(bbav.a(this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.path.get()));
    localReportReqBody.platver.set(Build.VERSION.SDK_INT + "");
    localReportReqBody.cmd.set(18);
    localReportReqBody.extend.set(this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.extend.get());
    if (this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.missions.has()) {
      localReportReqBody.missionid.set(this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo.missions.get());
    }
    Object localObject2 = new JSONObject();
    label231:
    for (;;)
    {
      try
      {
        Object localObject1 = new JSONObject();
        QLog.e("RedPointLog.RedTouchManager", 1, "residenceReport parse json error " + localObject2);
      }
      catch (Exception localException2)
      {
        try
        {
          ((JSONObject)localObject1).put("time_on_page", this.jdField_a_of_type_Long);
          localReportReqBody.buffer.set(((JSONObject)localObject1).toString());
          localObject1 = bbav.a(this.this$0, "RedTouchSvc.ClientReport");
          ((ToServiceMsg)localObject1).putWupBuffer(localReportReqBody.toByteArray());
          bbav.a(this.this$0, (ToServiceMsg)localObject1);
          return;
        }
        catch (Exception localException1)
        {
          break label231;
        }
        localException2 = localException2;
        localObject1 = localObject2;
        localObject2 = localException2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.RedTouchManager.4
 * JD-Core Version:    0.7.0.1
 */