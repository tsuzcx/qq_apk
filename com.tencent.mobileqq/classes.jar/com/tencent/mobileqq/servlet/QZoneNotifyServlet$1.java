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
    QZLog.e("Q.lebatab.UndealCount.QZoneNotifyServlet", "onConsecutiveFailure failCode:" + paramInt1 + ",failCount:" + paramInt2);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    if ((paramInt == 0) && (paramSosoLbsInfo != null))
    {
      QZoneNotifyServlet.a(LbsDataV2.convertFromSoso(paramSosoLbsInfo.mLocation));
      QZLog.i("Q.lebatab.UndealCount.QZoneNotifyServlet", 1, "onLocationFinish succeed! gps=" + QZoneNotifyServlet.a());
      return;
    }
    QZLog.e("Q.lebatab.UndealCount.QZoneNotifyServlet", "onLocationFinish failed: error in force gps info update..");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.QZoneNotifyServlet.1
 * JD-Core Version:    0.7.0.1
 */