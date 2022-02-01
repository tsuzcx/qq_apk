package com.tencent.mobileqq.qwallet.report.impl;

import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class VACDReportServiceImpl$4
  implements Runnable
{
  VACDReportServiceImpl$4(VACDReportServiceImpl paramVACDReportServiceImpl, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    try
    {
      synchronized ()
      {
        if ((VACDReportServiceImpl.access$700(this.this$0).isEmpty()) && (VACDReportServiceImpl.access$600(this.this$0).isEmpty())) {
          VACDReportServiceImpl.access$000().wait();
        }
      }
    }
    catch (Exception localException1)
    {
      label45:
      label71:
      break label45;
    }
    try
    {
      synchronized (this.a)
      {
        this.a.wait(2000L);
      }
    }
    catch (Exception localException2)
    {
      break label71;
    }
    synchronized (VACDReportServiceImpl.access$000())
    {
      VACDReportServiceImpl.access$800(this.this$0, 2);
      if (VACDReportServiceImpl.access$400(this.this$0))
      {
        VACDReportServiceImpl.access$1000(this.this$0).post(this);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VACDReport", 2, "WriteDBThread exit.");
      }
      return;
    }
    throw localObject3;
    for (;;)
    {
      throw localObject3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.report.impl.VACDReportServiceImpl.4
 * JD-Core Version:    0.7.0.1
 */