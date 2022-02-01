package com.tencent.mobileqq.flashshow.report.dc;

import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import qqcircle.QQCircleReport.SingleDcData;

class FSReporter$5
  implements Runnable
{
  FSReporter$5(FSReporter paramFSReporter, QQCircleReport.SingleDcData paramSingleDcData, boolean paramBoolean) {}
  
  public void run()
  {
    if (FSReporter.c(this.this$0) != null) {
      FSReporter.c(this.this$0).a(this.a.dcid.get(), this.a.report_data.get());
    }
    if (this.b)
    {
      FSReporter.d(this.this$0).add(this.a);
      FSReporter.e(this.this$0);
    }
    else
    {
      FSReporter.f(this.this$0).add(this.a);
    }
    FSReporter.a(this.this$0);
    if (((IAppSettingApi)QRoute.api(IAppSettingApi.class)).isDebugVersion())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("FSReporter");
      if (this.b) {
        str = "_DoImmediate";
      } else {
        str = "_DoNormal";
      }
      localStringBuilder.append(str);
      String str = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("add one SingleDcData:");
      localStringBuilder.append(FSReporter.a(this.a));
      QLog.d(str, 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.report.dc.FSReporter.5
 * JD-Core Version:    0.7.0.1
 */