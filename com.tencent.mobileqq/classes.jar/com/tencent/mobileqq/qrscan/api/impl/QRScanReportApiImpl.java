package com.tencent.mobileqq.qrscan.api.impl;

import com.tencent.mobileqq.qrscan.api.IQRScanReportApi;
import com.tencent.mobileqq.qrscan.minicode.MiniCodeUtil;
import com.tencent.mobileqq.qrscan.minicode.MiniScanReport;

public class QRScanReportApiImpl
  implements IQRScanReportApi
{
  public void doFrame() {}
  
  public boolean isBaseTestSwitchOn()
  {
    return MiniScanReport.a();
  }
  
  public void markScanConsume(int paramInt1, int paramInt2)
  {
    MiniScanReport.a(paramInt1, paramInt2);
  }
  
  public void markScanEnd(int paramInt)
  {
    MiniScanReport.a(paramInt);
  }
  
  public void markScanStart() {}
  
  public void onAIOMiniCodeResultReport(boolean paramBoolean1, boolean paramBoolean2)
  {
    MiniScanReport.a(paramBoolean1, paramBoolean2);
  }
  
  public void onAIOScanRecogTypeReport(int paramInt)
  {
    MiniScanReport.b(paramInt);
  }
  
  public void onDetectFirstCost(int paramInt1, int paramInt2)
  {
    MiniScanReport.f(paramInt1, paramInt2);
  }
  
  public void onDetectInitCost(int paramInt1, int paramInt2)
  {
    MiniScanReport.d(paramInt1, paramInt2);
  }
  
  public void onDetectInitInternalCost(int paramInt1, int paramInt2)
  {
    MiniScanReport.e(paramInt1, paramInt2);
  }
  
  public void onDetectSupportEasyReport(int paramInt1, int paramInt2)
  {
    MiniScanReport.c(paramInt1, paramInt2);
  }
  
  public void onDetectSupportReport(int paramInt1, int paramInt2)
  {
    MiniScanReport.b(paramInt1, paramInt2);
  }
  
  public void onSoCoverReport(boolean paramBoolean, int paramInt, String paramString)
  {
    MiniScanReport.a(paramBoolean, paramInt, paramString);
  }
  
  public long readLong(String paramString, long paramLong)
  {
    return MiniScanReport.a(paramString, paramLong);
  }
  
  public void setSaveDetectImage(boolean paramBoolean)
  {
    MiniCodeUtil.a(paramBoolean);
  }
  
  public void stopFrame() {}
  
  public void writeLong(String paramString, long paramLong)
  {
    MiniScanReport.a(paramString, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.api.impl.QRScanReportApiImpl
 * JD-Core Version:    0.7.0.1
 */