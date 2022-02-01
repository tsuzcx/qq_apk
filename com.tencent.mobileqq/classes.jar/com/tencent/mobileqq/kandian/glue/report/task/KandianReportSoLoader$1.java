package com.tencent.mobileqq.kandian.glue.report.task;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
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
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("download so success: a new version: ");
      localStringBuilder.append(KandianReportSoLoader.h());
      QLog.d("kandianreport.KandianReportSoLoader", 1, localStringBuilder.toString());
      ThreadManager.getFileThreadHandler().post(new KandianReportSoLoader.1.1(this));
    }
    else
    {
      if ((paramInt1 != 7) && (paramInt1 != 8) && (paramInt1 != 5) && (!((Boolean)RIJSPUtils.b("kd_fc_so_download", Boolean.valueOf(false))).booleanValue()))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(paramInt1);
        PublicAccountReportUtils.a(null, "", "0X8009A1C", "0X8009A1C", 0, 0, "", "", localStringBuilder.toString(), "download fail", false);
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("download so fail or not update:");
      localStringBuilder.append(paramInt1);
      QLog.d("kandianreport.KandianReportSoLoader", 1, localStringBuilder.toString());
    }
    boolean bool = new File(KandianReportSoLoader.l()).exists();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("local so file exists: ");
    localStringBuilder.append(bool);
    KandianReportSoLoader.a(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.task.KandianReportSoLoader.1
 * JD-Core Version:    0.7.0.1
 */