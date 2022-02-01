package com.tencent.mobileqq.qwallet.report.impl;

import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQDeviceInfo;

final class ReportUtils$1
  implements Runnable
{
  public void run()
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("networkType=");
      ((StringBuilder)localObject).append(HttpUtil.getNetWorkType());
      ((StringBuilder)localObject).append("&stackType=");
      ((StringBuilder)localObject).append(NetConnInfoCenter.getActiveNetIpFamily(true));
      ((StringBuilder)localObject).append("&carrierType=");
      ((StringBuilder)localObject).append(DeviceInfoUtil.a(QQDeviceInfo.getIMSI("5076bf")));
      localObject = ((StringBuilder)localObject).toString();
      VACDReportUtil.b((String)localObject, "qqwallet", "walletNetworkStack", "walletNetworkStack", null, 0, null);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("reportNetworkStack...data:");
        localStringBuilder.append((String)localObject);
        QLog.i("ReportUtils", 2, localStringBuilder.toString());
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.report.impl.ReportUtils.1
 * JD-Core Version:    0.7.0.1
 */