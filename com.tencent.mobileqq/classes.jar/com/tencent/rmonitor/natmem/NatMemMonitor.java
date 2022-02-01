package com.tencent.rmonitor.natmem;

import android.os.Build.VERSION;
import android.os.Message;
import com.tencent.rmonitor.base.config.ConfigCenter;
import com.tencent.rmonitor.base.config.ConfigProxy;
import com.tencent.rmonitor.base.config.DefaultPluginConfig;
import com.tencent.rmonitor.base.config.data.NatMemPluginConfig;
import com.tencent.rmonitor.base.plugin.listener.IBaseListener;
import com.tencent.rmonitor.base.plugin.listener.ListenerManager;
import com.tencent.rmonitor.base.plugin.listener.MonitorListenerMng;
import com.tencent.rmonitor.base.plugin.monitor.PluginController;
import com.tencent.rmonitor.base.plugin.monitor.QAPMMonitorPlugin;
import com.tencent.rmonitor.base.reporter.uvreport.UVEventReport;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.common.thread.ThreadManager;
import com.tencent.rmonitor.common.util.CrashProtector;
import com.tencent.rmonitor.memory.MemoryUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class NatMemMonitor
  extends QAPMMonitorPlugin
{
  protected static boolean a = false;
  private static NatMemMonitor b;
  private static boolean e;
  private NatMemHandler c;
  private NatMemPluginConfig d;
  private AtomicBoolean f = new AtomicBoolean(false);
  
  static
  {
    try
    {
      System.loadLibrary("rmonitor_natmem");
      e = true;
      return;
    }
    catch (Throwable localThrowable)
    {
      Logger.b.a("NatMem", localThrowable);
      e = false;
    }
  }
  
  private NatMemMonitor()
  {
    if (e)
    {
      this.d = new NatMemPluginConfig(0, 0, 0.0F, 0, 0, 0, 0, false, true, 9223372036854775807L);
      this.c = new NatMemHandler(ThreadManager.e());
    }
    b = this;
    this.f.set(false);
  }
  
  private boolean g()
  {
    return MemoryUtils.a(154);
  }
  
  public static NatMemMonitor getInstance()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new NatMemMonitor();
        }
      }
      finally {}
    }
    return b;
  }
  
  public void b()
  {
    if ((e) && (!a))
    {
      this.d = ((NatMemPluginConfig)ConfigProxy.INSTANCE.getConfig().b(154).f);
      this.c.obtainMessage(1).sendToTarget();
      this.c.obtainMessage(2).sendToTarget();
      a = true;
      return;
    }
    Logger localLogger = Logger.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startMonitor failed,mSoLoadSuccess = ");
    localStringBuilder.append(e);
    localLogger.e(new String[] { localStringBuilder.toString() });
  }
  
  public void c()
  {
    if (e)
    {
      this.c.obtainMessage(3).sendToTarget();
      return;
    }
    Logger.b.e(new String[] { "dumpNatMemLeakInfo failed" });
  }
  
  public void d()
  {
    if (e)
    {
      this.c.obtainMessage(4).sendToTarget();
      return;
    }
    Logger.b.e(new String[] { "dumpNatMemUsageInfo failed" });
  }
  
  public NatMemPluginConfig e()
  {
    return this.d;
  }
  
  protected int f()
  {
    if (Build.VERSION.SDK_INT < 26)
    {
      Logger.b.d(new String[] { "NatMem", "start native memory monitor fail, for android version" });
      NatMemAttaReporter.a("android_verison");
      return 2;
    }
    if (!g())
    {
      Logger.b.d(new String[] { "NatMem", "start native memory monitor fail, for sample" });
      NatMemAttaReporter.a("sample");
      return 3;
    }
    if ((!PluginController.b.a()) && (CrashProtector.a(154, 600000L)))
    {
      Logger.b.e(new String[] { "NatMem", "start native memory monitor fail, for start failed many times" });
      NatMemAttaReporter.a("crash_times");
      return 1;
    }
    return 0;
  }
  
  native int nativeDumpNatMemLeakInfo(String paramString);
  
  native int nativeDumpNatMemUsageInfo(String paramString);
  
  native int nativeIgnoreLib(String paramString);
  
  native int nativeInit();
  
  native void nativeInitAppHookParameter(int paramInt);
  
  native void nativeInitSysHookParameter(int paramInt1, int paramInt2, int paramInt3);
  
  native int nativeRegisterAppLib(String paramString);
  
  native int nativeRegisterSysLib(String paramString);
  
  native int nativeStartHook();
  
  public void start()
  {
    if ((e) && (!this.f.get()))
    {
      int i = f();
      if (i != 0)
      {
        Iterator localIterator = ListenerManager.k.a().iterator();
        while (localIterator.hasNext())
        {
          IBaseListener localIBaseListener = (IBaseListener)localIterator.next();
          if ((localIBaseListener instanceof INatMemListener)) {
            ((INatMemListener)localIBaseListener).a(i);
          }
        }
        return;
      }
      b();
      UVEventReport.a.add(new Integer(154));
      this.f.set(true);
      Logger.b.d(new String[] { "NatMem", "start natmem monitor!!" });
    }
  }
  
  public void stop() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.natmem.NatMemMonitor
 * JD-Core Version:    0.7.0.1
 */