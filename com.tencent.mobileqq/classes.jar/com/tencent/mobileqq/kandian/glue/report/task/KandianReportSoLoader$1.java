package com.tencent.mobileqq.kandian.glue.report.task;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.os.MqqHandler;

final class KandianReportSoLoader$1
  implements TaskOfflineUtils.OfflineCallBack
{
  KandianReportSoLoader$1(Runnable paramRunnable) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      KandianReportSoLoader.a(paramInt2);
      RIJSPUtils.a("kd_fc_so_download", Boolean.valueOf(true));
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("download so success: a new version: ");
      ((StringBuilder)localObject).append(KandianReportSoLoader.b());
      QLog.d("kandianreport.KandianReportSoLoader", 1, ((StringBuilder)localObject).toString());
      ThreadManager.getFileThreadHandler().post(new KandianReportSoLoader.1.1(this));
    }
    else
    {
      if ((paramInt1 != 7) && (paramInt1 != 8) && (paramInt1 != 5) && (!((Boolean)RIJSPUtils.a("kd_fc_so_download", Boolean.valueOf(false))).booleanValue()))
      {
        localObject = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(paramInt1);
        ((IPublicAccountReportUtils)localObject).publicAccountReportClickEvent(null, "", "0X8009A1C", "0X8009A1C", 0, 0, "", "", localStringBuilder.toString(), "download fail", false);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("download so fail or not update:");
      ((StringBuilder)localObject).append(paramInt1);
      QLog.d("kandianreport.KandianReportSoLoader", 1, ((StringBuilder)localObject).toString());
    }
    boolean bool = new File(KandianReportSoLoader.d()).exists();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("local so file exists: ");
    ((StringBuilder)localObject).append(bool);
    KandianReportSoLoader.a(((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.task.KandianReportSoLoader.1
 * JD-Core Version:    0.7.0.1
 */