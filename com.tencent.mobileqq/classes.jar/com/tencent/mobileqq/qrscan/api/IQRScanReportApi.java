package com.tencent.mobileqq.qrscan.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQRScanReportApi
  extends QRouteApi
{
  public abstract void doFrame();
  
  public abstract boolean isBaseTestSwitchOn();
  
  public abstract void markScanConsume(int paramInt1, int paramInt2);
  
  public abstract void markScanEnd(int paramInt);
  
  public abstract void markScanStart();
  
  public abstract void onAIOMiniCodeResultReport(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void onAIOScanRecogTypeReport(int paramInt);
  
  public abstract void onDetectFirstCost(int paramInt1, int paramInt2);
  
  public abstract void onDetectInitCost(int paramInt1, int paramInt2);
  
  public abstract void onDetectInitInternalCost(int paramInt1, int paramInt2);
  
  public abstract void onDetectSupportEasyReport(int paramInt1, int paramInt2);
  
  public abstract void onDetectSupportReport(int paramInt1, int paramInt2);
  
  public abstract void onSoCoverReport(boolean paramBoolean, int paramInt, String paramString);
  
  public abstract long readLong(String paramString, long paramLong);
  
  public abstract void setSaveDetectImage(boolean paramBoolean);
  
  public abstract void stopFrame();
  
  public abstract void writeLong(String paramString, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.api.IQRScanReportApi
 * JD-Core Version:    0.7.0.1
 */