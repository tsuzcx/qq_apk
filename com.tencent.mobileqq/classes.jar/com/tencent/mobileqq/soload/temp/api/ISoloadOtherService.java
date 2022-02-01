package com.tencent.mobileqq.soload.temp.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.soload.biz.OnSoGetPathListener;

@QAPI(process={"all"})
public abstract interface ISoloadOtherService
  extends QRouteApi
{
  public abstract void addReportItem(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4);
  
  public abstract void endReport(long paramLong, String paramString1, String paramString2, int paramInt, String paramString3);
  
  public abstract int getFileExistStatusInMainProcess(String paramString);
  
  public abstract String getResFolderPathSync(String paramString1, String paramString2);
  
  public abstract void getResPathAsync(String paramString1, String paramString2, boolean paramBoolean, OnSoGetPathListener paramOnSoGetPathListener);
  
  public abstract String getResPathSync(String paramString1, String paramString2, String paramString3);
  
  public abstract boolean getResPathSyncWithUnZip(String paramString1, String paramString2, String paramString3, boolean paramBoolean, long paramLong1, long paramLong2, String paramString4, int paramInt);
  
  public abstract boolean isQQProcess();
  
  public abstract void singleReport(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6);
  
  public abstract long startReport(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.soload.temp.api.ISoloadOtherService
 * JD-Core Version:    0.7.0.1
 */