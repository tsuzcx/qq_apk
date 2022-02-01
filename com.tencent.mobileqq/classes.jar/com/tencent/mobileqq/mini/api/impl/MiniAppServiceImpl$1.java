package com.tencent.mobileqq.mini.api.impl;

import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.qroute.module.IQRoutePluginInstallListener;
import com.tencent.qphone.base.util.QLog;

class MiniAppServiceImpl$1
  implements IQRoutePluginInstallListener
{
  MiniAppServiceImpl$1(MiniAppServiceImpl paramMiniAppServiceImpl) {}
  
  public void onInstallBegin(String paramString)
  {
    QLog.d("MiniAppServiceImpl", 1, "start install miniSearchPlugin!");
    MiniReportManager.reportEventType(MiniReportManager.getFakeAppConfigForReport("0000000000"), 1062, "0");
  }
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2) {}
  
  public void onInstallError(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("miniSearchPlugin onInstallError, errMsg:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", code:");
    localStringBuilder.append(paramInt);
    QLog.e("MiniAppServiceImpl", 1, localStringBuilder.toString());
  }
  
  public void onInstallFinish(String paramString)
  {
    MiniReportManager.reportEventType(MiniReportManager.getFakeAppConfigForReport("0000000000"), 1063, "0");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("miniSearchPlugin onInstallFinish!");
    localStringBuilder.append(paramString);
    QLog.d("MiniAppServiceImpl", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.api.impl.MiniAppServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */