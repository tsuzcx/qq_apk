package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.os.Bundle;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.cc_sso_report_svr.cc_sso_report_svr.ReportInfoRsp;

class QualityReporter$ResponseObserver
  implements BusinessObserver
{
  private NewIntent a;
  
  QualityReporter$ResponseObserver(NewIntent paramNewIntent)
  {
    this.a = paramNewIntent;
  }
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QualityReporter", 2, "onSuccess: ");
    }
  }
  
  private void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onError: code=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", msg=");
      localStringBuilder.append(paramString);
      QLog.d("QualityReporter", 2, localStringBuilder.toString());
    }
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.a.setObserver(null);
    if (paramBoolean) {}
    try
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle == null)
      {
        a(-123, "data null");
        return;
      }
      cc_sso_report_svr.ReportInfoRsp localReportInfoRsp = new cc_sso_report_svr.ReportInfoRsp();
      localReportInfoRsp.mergeFrom(paramBundle);
      if ((localReportInfoRsp.ret_code.has()) && (localReportInfoRsp.ret_code.get() == 0))
      {
        a();
        return;
      }
      a(localReportInfoRsp.ret_code.get(), localReportInfoRsp.ret_msg.get());
      return;
    }
    catch (Exception paramBundle)
    {
      paramBundle.printStackTrace();
    }
    a(-123, "success=false");
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.QualityReporter.ResponseObserver
 * JD-Core Version:    0.7.0.1
 */