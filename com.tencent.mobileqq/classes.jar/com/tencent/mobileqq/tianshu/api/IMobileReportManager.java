package com.tencent.mobileqq.tianshu.api;

import NS_USER_ACTION_REPORT.ItemInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;

@QAPI(process={"all"})
public abstract interface IMobileReportManager
  extends QRouteApi
{
  public abstract String getNewDefaultReportInfo(String paramString1, String paramString2);
  
  public abstract String getNewDefaultReportInfo(String paramString1, String paramString2, String paramString3);
  
  public abstract String getNewReportInfo(BusinessInfoCheckUpdate.AppInfo paramAppInfo);
  
  public abstract String getNewReportInfo(String paramString, BusinessInfoCheckUpdate.AppInfo paramAppInfo);
  
  public abstract String getNewTraceDetail(String paramString1, String paramString2, String paramString3, String paramString4);
  
  @NonNull
  public abstract String getStringQboos2H5(@Nullable String paramString1, @Nullable String paramString2, @NonNull String paramString3);
  
  @Nullable
  public abstract String getStringReport2H5(@Nullable BusinessInfoCheckUpdate.AppInfo paramAppInfo);
  
  public abstract String getStringWithQbossTrace(String paramString1, String paramString2);
  
  public abstract String getStringWithRedAppinfo(String paramString, BusinessInfoCheckUpdate.AppInfo paramAppInfo);
  
  public abstract void qqSetingMeReport(int paramInt1, int paramInt2, String paramString);
  
  public abstract void reportAction(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong);
  
  public abstract void reportAction(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, long paramLong);
  
  public abstract void reportAction(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, int paramInt2);
  
  public abstract void reportActionLive(String paramString1, String paramString2, ItemInfo paramItemInfo);
  
  public abstract void reportActionLive(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, long paramLong, String paramString6);
  
  public abstract void reportActionOfNotice(String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2);
  
  public abstract void reportH5DomainClick(String paramString1, String paramString2);
  
  public abstract void reportH5Trace(String paramString1, int paramInt1, long paramLong, String paramString2, int paramInt2, String paramString3);
  
  public abstract void reportRedpoint(@Nullable BusinessInfoCheckUpdate.AppInfo paramAppInfo, int paramInt);
  
  public abstract void reportSchemaInfo(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.tianshu.api.IMobileReportManager
 * JD-Core Version:    0.7.0.1
 */