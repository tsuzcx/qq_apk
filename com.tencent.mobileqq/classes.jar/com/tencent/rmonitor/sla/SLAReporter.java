package com.tencent.rmonitor.sla;

import android.os.Debug;
import android.os.Handler;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.base.meta.UrlMeta;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.common.thread.ThreadManager;
import java.net.URL;
import org.jetbrains.annotations.NotNull;

public class SLAReporter
{
  private long a = 0L;
  
  public void a()
  {
    if (this.a == 0L) {
      this.a = System.currentTimeMillis();
    }
  }
  
  public void a(@NotNull AttaParam paramAttaParam)
  {
    try
    {
      paramAttaParam = new AttaReportTask(new URL(BaseInfo.urlMeta.getAttaUrl()), new AttaContentBuilder(paramAttaParam));
      new Handler(ThreadManager.f()).post(paramAttaParam);
      return;
    }
    catch (Throwable paramAttaParam)
    {
      Logger.b.e(new String[] { "RMonitor_sla_SLAReporter", "reportEvent", paramAttaParam.getMessage() });
    }
  }
  
  public boolean a(int paramInt)
  {
    if (this.a == 0L)
    {
      Logger.b.e(new String[] { "RMonitor_sla_SLAReporter", "endStartRMonitor invalid call not start yet." });
      return false;
    }
    long l = System.currentTimeMillis();
    AttaParam localAttaParam = new AttaParam("RMSLALaunchEvent");
    localAttaParam.h = this.a;
    localAttaParam.e = Math.abs(l - localAttaParam.h);
    this.a = 0L;
    localAttaParam.f = paramInt;
    localAttaParam.i = b(localAttaParam);
    a(localAttaParam);
    return true;
  }
  
  public int b(AttaParam paramAttaParam)
  {
    if (paramAttaParam == null) {
      return 1;
    }
    if (Debug.isDebuggerConnected()) {
      return 1;
    }
    if (paramAttaParam.e >= 80L) {
      return 1;
    }
    if (paramAttaParam.f == 0) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.sla.SLAReporter
 * JD-Core Version:    0.7.0.1
 */