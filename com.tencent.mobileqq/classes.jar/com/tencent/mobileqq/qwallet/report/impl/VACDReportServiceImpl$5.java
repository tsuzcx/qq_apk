package com.tencent.mobileqq.qwallet.report.impl;

import VACDReport.ReportRsp;
import android.os.Bundle;
import mqq.observer.BusinessObserver;

class VACDReportServiceImpl$5
  implements BusinessObserver
{
  VACDReportServiceImpl$5(VACDReportServiceImpl paramVACDReportServiceImpl) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    if (paramBundle.containsKey("rsp")) {}
    for (paramBundle = ((ReportRsp)paramBundle.getSerializable("rsp")).headers;; paramBundle = null)
    {
      VACDReportServiceImpl.access$1100(this.a, paramBundle);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.report.impl.VACDReportServiceImpl.5
 * JD-Core Version:    0.7.0.1
 */