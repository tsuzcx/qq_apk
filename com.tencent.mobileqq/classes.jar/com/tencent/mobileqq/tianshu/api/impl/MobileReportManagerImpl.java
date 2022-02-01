package com.tencent.mobileqq.tianshu.api.impl;

import NS_USER_ACTION_REPORT.ItemInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.tianshu.api.IMobileReportManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import cooperation.qzone.mobilereport.MobileReportManager;

public class MobileReportManagerImpl
  implements IMobileReportManager
{
  public String getNewDefaultReportInfo(String paramString1, String paramString2)
  {
    return MobileReportManager.getNewDefaultReportInfo(paramString1, paramString2);
  }
  
  public String getNewDefaultReportInfo(String paramString1, String paramString2, String paramString3)
  {
    return MobileReportManager.getNewDefaultReportInfo(paramString1, paramString2, paramString3);
  }
  
  public String getNewReportInfo(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    return MobileReportManager.getNewReportInfo(paramAppInfo);
  }
  
  public String getNewReportInfo(String paramString, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    return MobileReportManager.getNewReportInfo(paramString, paramAppInfo);
  }
  
  public String getNewTraceDetail(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return MobileReportManager.getNewTraceDetail(paramString1, paramString2, paramString3, paramString4);
  }
  
  @NonNull
  public String getStringQboos2H5(@Nullable String paramString1, @Nullable String paramString2, @NonNull String paramString3)
  {
    return MobileReportManager.getStringQboos2H5(paramString1, paramString2, paramString3);
  }
  
  @Nullable
  public String getStringReport2H5(@Nullable BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    return MobileReportManager.getStringReport2H5(paramAppInfo);
  }
  
  public String getStringWithQbossTrace(String paramString1, String paramString2)
  {
    return MobileReportManager.getStringWithQbossTrace(paramString1, paramString2);
  }
  
  public String getStringWithRedAppinfo(String paramString, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    return MobileReportManager.getStringWithRedAppinfo(paramString, paramAppInfo);
  }
  
  public void qqSetingMeReport(int paramInt1, int paramInt2, String paramString)
  {
    MobileReportManager.getInstance().qqSetingMeReport(paramInt1, paramInt2, paramString);
  }
  
  public void reportAction(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong)
  {
    MobileReportManager.getInstance().reportAction(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramLong);
  }
  
  public void reportAction(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, long paramLong)
  {
    MobileReportManager.getInstance().reportAction(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramLong);
  }
  
  public void reportAction(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, int paramInt2)
  {
    MobileReportManager.getInstance().reportAction(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramInt1, paramInt2);
  }
  
  public void reportActionLive(String paramString1, String paramString2, ItemInfo paramItemInfo)
  {
    MobileReportManager.getInstance().reportActionLive(paramString1, paramString2, paramItemInfo);
  }
  
  public void reportActionLive(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, long paramLong, String paramString6)
  {
    MobileReportManager.getInstance().reportActionLive(paramString1, paramString2, paramString3, paramString4, paramString5, paramInt1, paramInt2, paramLong, paramString6);
  }
  
  public void reportActionOfNotice(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2)
  {
    MobileReportManager.getInstance().reportActionOfNotice(paramString1, paramString2, paramString3, paramInt1, paramString4, paramString5, paramInt2);
  }
  
  public void reportH5DomainClick(String paramString1, String paramString2)
  {
    MobileReportManager.getInstance().reportH5DomainClick(paramString1, paramString2);
  }
  
  public void reportH5Trace(String paramString1, int paramInt1, long paramLong, String paramString2, int paramInt2, String paramString3)
  {
    MobileReportManager.getInstance().reportH5Trace(paramString1, paramInt1, paramLong, paramString2, paramInt2, paramString3);
  }
  
  public void reportRedpoint(@Nullable BusinessInfoCheckUpdate.AppInfo paramAppInfo, int paramInt)
  {
    MobileReportManager.getInstance().reportRedpoint(paramAppInfo, paramInt);
  }
  
  public void reportSchemaInfo(String paramString1, String paramString2)
  {
    MobileReportManager.getInstance().reportSchemaInfo(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tianshu.api.impl.MobileReportManagerImpl
 * JD-Core Version:    0.7.0.1
 */