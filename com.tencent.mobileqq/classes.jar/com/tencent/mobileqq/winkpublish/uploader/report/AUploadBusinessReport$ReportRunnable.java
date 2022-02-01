package com.tencent.mobileqq.winkpublish.uploader.report;

import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.winkpublish.account.LoginData;
import com.tencent.mobileqq.winkpublish.api.IUploadLocalConfig;
import com.tencent.mobileqq.winkpublish.common.AUploadCommonSetting;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCirclePublishQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import feedcloud.FeedCloudCommon.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class AUploadBusinessReport$ReportRunnable
  implements Runnable
{
  boolean a = false;
  ArrayList<ReportObj> b;
  int c;
  int d;
  
  public AUploadBusinessReport$ReportRunnable(ArrayList<ReportObj> paramArrayList, int paramInt1, int paramInt2)
  {
    this.b = paramArrayList;
    this.c = paramInt1;
    this.d = paramInt2;
  }
  
  private void a()
  {
    if (this.a)
    {
      QLog.w("[upload2]QcirclrBusinessReport", 1, "inited = true");
      return;
    }
    if (this.b.isEmpty())
    {
      QLog.e("[upload2]QcirclrBusinessReport", 1, "listToSend is empty.");
      return;
    }
    Object localObject1 = this.b;
    try
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject3 = (ReportObj)((Iterator)localObject1).next();
        if (((ReportObj)localObject3).b())
        {
          localObject2 = ((ReportObj)localObject3).c();
          StatisticCollector.getInstance(RFApplication.getApplication()).collectPerformance(String.valueOf(LoginData.a().b()), "QcircleUploadReport", true, 0L, 0L, (HashMap)localObject2, null);
          AUploadCommonSetting.a().uploadQualityReport(QCirclePublishQualityReporter.P_UPLOAD_COST, Arrays.asList(new FeedCloudCommon.Entry[] { QCircleReportHelper.newEntry("ext1", String.valueOf(((ReportObj)localObject3).p)), QCircleReportHelper.newEntry("ext2", String.valueOf(((ReportObj)localObject3).o)), QCircleReportHelper.newEntry("ext3", String.valueOf(((ReportObj)localObject3).l)), QCircleReportHelper.newEntry("ext4", String.valueOf(((ReportObj)localObject3).u)), QCircleReportHelper.newEntry("ret_code", String.valueOf(((ReportObj)localObject3).m)) }));
          if (this.d == 0)
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("upload2: --- ");
            ((StringBuilder)localObject3).append(((HashMap)localObject2).toString());
            QLog.i("[upload2]QcirclrBusinessReport", 1, ((StringBuilder)localObject3).toString());
          }
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("JSONException when uploadReport.");
      ((StringBuilder)localObject2).append(localException.getMessage());
      QLog.e("[upload2]QcirclrBusinessReport", 1, ((StringBuilder)localObject2).toString());
      this.a = true;
    }
  }
  
  public void run()
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.uploader.report.AUploadBusinessReport.ReportRunnable
 * JD-Core Version:    0.7.0.1
 */