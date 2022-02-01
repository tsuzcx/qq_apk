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
    synchronized ()
    {
      try
      {
        while ((VACDReportServiceImpl.access$700(this.this$0).isEmpty()) && (VACDReportServiceImpl.access$600(this.this$0).isEmpty())) {
          VACDReportServiceImpl.access$000().wait();
        }
        try
        {
          synchronized (this.a)
          {
            this.a.wait(2000L);
          }
          do
          {
            synchronized (VACDReportServiceImpl.access$000())
            {
              VACDReportServiceImpl.access$800(this.this$0, 2);
              if (VACDReportServiceImpl.access$400(this.this$0))
              {
                VACDReportServiceImpl.access$1000(this.this$0).post(this);
                return;
                localObject1 = finally;
                throw localObject1;
                localObject2 = finally;
                throw localObject2;
              }
            }
          } while (!QLog.isColorLevel());
          QLog.d("VACDReport", 2, "WriteDBThread exit.");
          return;
        }
        catch (Exception localException2)
        {
          break label61;
        }
      }
      catch (Exception localException1) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.report.impl.VACDReportServiceImpl.4
 * JD-Core Version:    0.7.0.1
 */