package com.tencent.mobileqq.servlet;

import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.report.QzoneLbsReporter;
import cooperation.qzone.util.QZLog;

final class QZoneNotifyServlet$2
  extends LbsManagerServiceOnLocationChangeListener
{
  QZoneNotifyServlet$2(String paramString, boolean paramBoolean)
  {
    super(paramString, paramBoolean);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    QZLog.i("Q.lebatab.UndealCount.QZoneNotifyServlet.NewLbsInterface", 1, "[QZ_LBS_MODULE]----locate");
    long l1 = System.currentTimeMillis();
    long l2 = QZoneNotifyServlet.b();
    QzoneLbsReporter.reportLocationResult(paramInt, this.businessId, l1 - l2);
    if ((paramInt == 0) && (paramSosoLbsInfo != null))
    {
      QZoneNotifyServlet.a(LbsDataV2.convertFromSoso(paramSosoLbsInfo.mLocation));
      paramSosoLbsInfo = new StringBuilder();
      paramSosoLbsInfo.append("[QZ_LBS_MODULE]onLocationFinish succeed! gps=");
      paramSosoLbsInfo.append(QZoneNotifyServlet.a());
      QZLog.i("Q.lebatab.UndealCount.QZoneNotifyServlet", 1, paramSosoLbsInfo.toString());
    }
    else
    {
      QZLog.e("Q.lebatab.UndealCount.QZoneNotifyServlet", "[QZ_LBS_MODULE]onLocationFinish failed: error in force gps info update..");
    }
    QZoneNotifyServlet.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.QZoneNotifyServlet.2
 * JD-Core Version:    0.7.0.1
 */