package com.tencent.mobileqq.flashshow.report.dc;

import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class FSReporter$7
  implements Runnable
{
  public void run()
  {
    FSReporter.h(this.this$0).add(this.a);
    FSReporter.a(this.this$0);
    if (((IAppSettingApi)QRoute.api(IAppSettingApi.class)).isDebugVersion())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("add one SingleDcData:");
      localStringBuilder.append(FSReporter.a(this.a));
      QLog.d("FSReporter_DoCommandReport", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.report.dc.FSReporter.7
 * JD-Core Version:    0.7.0.1
 */