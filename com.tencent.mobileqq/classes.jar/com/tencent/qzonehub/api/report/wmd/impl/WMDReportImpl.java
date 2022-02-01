package com.tencent.qzonehub.api.report.wmd.impl;

import com.tencent.mobileqq.service.qzone.QZoneUnreadServletLogic.WMDConfig;
import com.tencent.qzonehub.api.report.wmd.IWMDReport;

public class WMDReportImpl
  implements IWMDReport
{
  QZoneUnreadServletLogic.WMDConfig mConfig;
  
  public int getReportCount()
  {
    QZoneUnreadServletLogic.WMDConfig localWMDConfig = this.mConfig;
    if (localWMDConfig == null) {
      return 0;
    }
    return localWMDConfig.c;
  }
  
  public String getReportId()
  {
    QZoneUnreadServletLogic.WMDConfig localWMDConfig = this.mConfig;
    if (localWMDConfig == null) {
      return null;
    }
    return localWMDConfig.a;
  }
  
  public int getReportTime()
  {
    QZoneUnreadServletLogic.WMDConfig localWMDConfig = this.mConfig;
    if (localWMDConfig == null) {
      return 0;
    }
    return localWMDConfig.d;
  }
  
  public void loadConfig()
  {
    QZoneUnreadServletLogic.WMDConfig localWMDConfig = new QZoneUnreadServletLogic.WMDConfig();
    localWMDConfig.a();
    this.mConfig = localWMDConfig;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qzonehub.api.report.wmd.impl.WMDReportImpl
 * JD-Core Version:    0.7.0.1
 */