package com.tencent.rmonitor.fd;

import android.text.TextUtils;
import com.tencent.rmonitor.base.config.data.FdLeakPluginConfig;
import com.tencent.rmonitor.base.plugin.listener.ListenerManager;
import com.tencent.rmonitor.base.plugin.listener.MonitorListenerMng;
import com.tencent.rmonitor.base.plugin.monitor.PluginController;
import com.tencent.rmonitor.common.network.NetworkWatcher;
import com.tencent.rmonitor.fd.analysis.FdLeakAnalyzer;
import com.tencent.rmonitor.fd.cluser.FdCluster;
import com.tencent.rmonitor.fd.cluser.FdClusterItem;
import com.tencent.rmonitor.fd.dump.FdLeakDumpHelper;
import com.tencent.rmonitor.fd.dump.FdLeakDumpResult;
import com.tencent.rmonitor.fd.dump.dumpers.FdProcFdDumper;
import com.tencent.rmonitor.fd.report.FdLeakAttaReporter;
import com.tencent.rmonitor.fd.report.FdLeakReporter;
import com.tencent.rmonitor.fd.utils.LogUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FdLeakTrigger
{
  private final FdLeakAnalyzer a = new FdLeakAnalyzer();
  private final FdLeakReporter b;
  private FdLeakListener c;
  private int d = 0;
  
  public FdLeakTrigger(FdLeakReporter paramFdLeakReporter)
  {
    this.b = paramFdLeakReporter;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (NetworkWatcher.a.b())
    {
      String str = FdLeakDumpHelper.a(FdLeakDumpHelper.a(b()), false);
      if (!TextUtils.isEmpty(str))
      {
        this.b.a(paramInt1, paramInt2, str);
        return;
      }
      LogUtils.d("FdLeakTrigger", "zip dump files failed");
    }
  }
  
  private void a(int paramInt1, int paramInt2, FdLeakDumpResult paramFdLeakDumpResult)
  {
    this.a.a(paramInt1, paramInt2, paramFdLeakDumpResult, new FdLeakTrigger.1(this, b()));
  }
  
  private void a(FdLeakDumpResult paramFdLeakDumpResult)
  {
    if (paramFdLeakDumpResult.getErrorCode() == 11)
    {
      this.d += 1;
      return;
    }
    this.d = 0;
  }
  
  private boolean c()
  {
    FdLeakDumpHelper.c();
    FdLeakDumpResult localFdLeakDumpResult = FdLeakDumpHelper.a(1, b());
    a(localFdLeakDumpResult);
    if (!localFdLeakDumpResult.isSuccess()) {
      return false;
    }
    FdClusterItem localFdClusterItem = FdCluster.a((Map)localFdLeakDumpResult.getData());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("top fd: ");
    localStringBuilder.append(localFdClusterItem);
    LogUtils.a("FdLeakTrigger", localStringBuilder.toString());
    if (localFdClusterItem == null) {
      return false;
    }
    this.b.a(localFdClusterItem.a());
    if (!PluginController.a(151, FdLeakConfigHelper.g().d))
    {
      LogUtils.a("FdLeakTrigger", "do fd analyze, but not sampled.");
      return false;
    }
    int i = FdProcFdDumper.d();
    if (FdLeakConfigHelper.b())
    {
      a(localFdClusterItem.a(), i, localFdLeakDumpResult);
      return true;
    }
    a(localFdClusterItem.a(), i);
    return false;
  }
  
  public boolean a()
  {
    IFdLeakListener localIFdLeakListener = b();
    if (localIFdLeakListener != null) {
      localIFdLeakListener.dI_();
    }
    if (this.d >= 3)
    {
      LogUtils.b("FdLeakTrigger", "fd leak detected, but fd dump empty to many times.");
      return false;
    }
    if (!PluginController.b.b(151))
    {
      LogUtils.b("FdLeakTrigger", "fd leak detected, but don't collect.");
      return false;
    }
    if (!PluginController.a(151, FdLeakConfigHelper.g().c))
    {
      LogUtils.a("FdLeakTrigger", "onFdLeakDetected, but not sampled.");
      return false;
    }
    return c();
  }
  
  public IFdLeakListener b()
  {
    if (this.c == null)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = ListenerManager.i.a().iterator();
      while (localIterator.hasNext()) {
        localArrayList.add((IFdLeakListener)localIterator.next());
      }
      if (FdLeakConfigHelper.d()) {
        localArrayList.add(new FdLeakAttaReporter());
      }
      this.c = new FdLeakListener(localArrayList);
    }
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.fd.FdLeakTrigger
 * JD-Core Version:    0.7.0.1
 */