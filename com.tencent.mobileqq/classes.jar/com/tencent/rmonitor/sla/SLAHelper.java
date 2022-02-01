package com.tencent.rmonitor.sla;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.common.util.RMonitorUtil;

public class SLAHelper
  implements Handler.Callback
{
  private static final SLAHelper a = new SLAHelper();
  private boolean b = false;
  private final SLAReporter c = new SLAReporter();
  private final Handler d = new Handler(Looper.getMainLooper(), this);
  
  public static SLAHelper a()
  {
    return a;
  }
  
  private void e()
  {
    if (!RMonitorUtil.a())
    {
      Logger.b.i(new String[] { "RMonitor_sla_SLAHelper", "checkSLAReportInner, not match base info limit." });
      return;
    }
    if (!this.b) {
      RMonitorUtil.a(new SLAHelper.1(this));
    }
  }
  
  public void b()
  {
    if (this.b) {
      return;
    }
    this.d.removeMessages(1);
    this.d.sendEmptyMessageDelayed(1, 30000L);
  }
  
  public void c()
  {
    if (!this.b)
    {
      this.c.a();
      Logger.b.i(new String[] { "RMonitor_sla_SLAHelper", "beginStartRMonitor" });
    }
  }
  
  public void d()
  {
    if (!this.b)
    {
      this.b = this.c.a(1);
      Logger localLogger = Logger.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("endStartRMonitor, isSLAReported: ");
      localStringBuilder.append(this.b);
      localLogger.i(new String[] { "RMonitor_sla_SLAHelper", localStringBuilder.toString() });
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      e();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.sla.SLAHelper
 * JD-Core Version:    0.7.0.1
 */