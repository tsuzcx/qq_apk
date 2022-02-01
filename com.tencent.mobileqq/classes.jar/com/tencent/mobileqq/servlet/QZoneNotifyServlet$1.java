package com.tencent.mobileqq.servlet;

import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.util.QZLog;

final class QZoneNotifyServlet$1
  extends SosoInterfaceOnLocationListener
{
  public void onConsecutiveFailure(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onConsecutiveFailure failCode:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(",failCount:");
    localStringBuilder.append(paramInt2);
    QZLog.e("Q.lebatab.UndealCount.QZoneNotifyServlet", localStringBuilder.toString());
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    if ((paramInt == 0) && (paramSosoLbsInfo != null))
    {
      QZoneNotifyServlet.a(LbsDataV2.convertFromSoso(paramSosoLbsInfo.mLocation));
      paramSosoLbsInfo = new StringBuilder();
      paramSosoLbsInfo.append("onLocationFinish succeed! gps=");
      paramSosoLbsInfo.append(QZoneNotifyServlet.a());
      QZLog.i("Q.lebatab.UndealCount.QZoneNotifyServlet", 1, paramSosoLbsInfo.toString());
      return;
    }
    QZLog.e("Q.lebatab.UndealCount.QZoneNotifyServlet", "onLocationFinish failed: error in force gps info update..");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.QZoneNotifyServlet.1
 * JD-Core Version:    0.7.0.1
 */