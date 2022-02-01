package com.tencent.rmonitor.fd;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.NonNull;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.base.plugin.monitor.PluginController;
import com.tencent.rmonitor.base.plugin.monitor.QAPMMonitorPlugin;
import com.tencent.rmonitor.base.reporter.uvreport.UVEventReport;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.common.thread.ThreadManager;
import com.tencent.rmonitor.common.util.AndroidVersion;
import com.tencent.rmonitor.common.util.CrashProtector;
import com.tencent.rmonitor.fd.dump.dumpers.FdProcFdDumper;
import com.tencent.rmonitor.fd.hook.FdOpenStackManager;
import com.tencent.rmonitor.fd.report.FdLeakAttaReporter;
import com.tencent.rmonitor.fd.report.FdLeakReporter;
import com.tencent.rmonitor.fd.utils.LogUtils;
import com.tencent.rmonitor.memory.MemoryUtils;
import java.util.List;

public class FdLeakMonitor
  extends QAPMMonitorPlugin
  implements Handler.Callback
{
  private final Handler a = new Handler(ThreadManager.e(), this);
  private final FdLeakReporter b = new FdLeakReporter();
  private final FdLeakTrigger c = new FdLeakTrigger(this.b);
  private long d = 5000L;
  
  private boolean b()
  {
    return FdProcFdDumper.d() > FdLeakConfigHelper.e();
  }
  
  private boolean c()
  {
    return MemoryUtils.a(151);
  }
  
  private boolean d()
  {
    SharedPreferences localSharedPreferences = BaseInfo.sharePreference;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localSharedPreferences != null)
    {
      bool1 = bool2;
      if (localSharedPreferences.getInt("fd_dump_exception_count", 0) >= 5) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static FdLeakMonitor getInstance()
  {
    return FdLeakMonitor.Holder.a();
  }
  
  public boolean handleMessage(@NonNull Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      paramMessage = new StringBuilder();
      paramMessage.append("current fd: ");
      paramMessage.append(FdProcFdDumper.d());
      LogUtils.a("FdLeakMonitor", paramMessage.toString());
      if (b())
      {
        if (this.c.a()) {
          this.d = 90000L;
        }
      }
      else {
        this.d = 5000L;
      }
      this.a.removeMessages(1);
      if (PluginController.b.b(151))
      {
        this.a.sendEmptyMessageDelayed(1, this.d);
        return true;
      }
      LogUtils.c("FdLeakMonitor", "fd leak can't collect, stop detect.");
      stop();
    }
    return true;
  }
  
  public void start()
  {
    Logger localLogger = Logger.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fdLeakConfig: ");
    localStringBuilder.append(FdLeakConfigHelper.g());
    localLogger.i(new String[] { "FdLeakMonitor", localStringBuilder.toString() });
    if (!AndroidVersion.c())
    {
      Logger.b.d(new String[] { "FdLeakMonitor", "cannot start fd leak monitor due to system version not permitted" });
      FdLeakAttaReporter.b(1);
      return;
    }
    if (!c())
    {
      Logger.b.d(new String[] { "FdLeakMonitor", "cannot start fd leak monitor due to not sampled." });
      FdLeakAttaReporter.b(2);
      return;
    }
    if (d())
    {
      Logger.b.e(new String[] { "FdLeakMonitor", "dump heap exception too many times." });
      FdLeakAttaReporter.b(3);
      return;
    }
    if ((FdLeakConfigHelper.c()) && (CrashProtector.a(151, 120000L)))
    {
      Logger.b.e(new String[] { "FdLeakMonitor", "cannot start fd leak monitor due to too many crashes" });
      FdLeakAttaReporter.b(4);
      return;
    }
    UVEventReport.a.add(new Integer(151));
    this.a.removeMessages(1);
    this.a.sendEmptyMessageDelayed(1, this.d);
    if (FdLeakConfigHelper.c()) {
      FdOpenStackManager.a();
    }
    Logger.b.i(new String[] { "FdLeakMonitor", "fd leak monitor started." });
    FdLeakAttaReporter.b(0);
  }
  
  public void stop()
  {
    UVEventReport.a.remove(Integer.valueOf(151));
    this.a.removeMessages(1);
    if (FdLeakConfigHelper.c()) {
      FdOpenStackManager.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.fd.FdLeakMonitor
 * JD-Core Version:    0.7.0.1
 */