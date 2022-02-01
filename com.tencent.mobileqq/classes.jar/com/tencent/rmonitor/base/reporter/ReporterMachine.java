package com.tencent.rmonitor.base.reporter;

import android.os.Handler;
import com.tencent.rmonitor.base.config.PluginCombination;
import com.tencent.rmonitor.base.config.PluginCombination.Companion;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.base.plugin.monitor.PluginController;
import com.tencent.rmonitor.base.reporter.ab.AbProviderSingleton;
import com.tencent.rmonitor.base.reporter.batch.ReportCacheImpl;
import com.tencent.rmonitor.base.reporter.data.ReportData;
import com.tencent.rmonitor.base.reporter.upload.QAPMUploadProxy;
import com.tencent.rmonitor.base.reporter.uvreport.UVEventReport;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.common.network.NetworkWatcher;
import com.tencent.rmonitor.common.thread.ThreadManager;
import com.tencent.rmonitor.common.thread.ThreadManager.Companion;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/base/reporter/ReporterMachine;", "Lcom/tencent/rmonitor/base/reporter/IReporter;", "()V", "TAG", "", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "setHandler", "(Landroid/os/Handler;)V", "isStarted", "", "reportCache", "Lcom/tencent/rmonitor/base/reporter/IReportCache;", "getReportCache", "()Lcom/tencent/rmonitor/base/reporter/IReportCache;", "setReportCache", "(Lcom/tencent/rmonitor/base/reporter/IReportCache;)V", "uploadProxy", "getUploadProxy", "()Lcom/tencent/rmonitor/base/reporter/IReporter;", "setUploadProxy", "(Lcom/tencent/rmonitor/base/reporter/IReporter;)V", "uvEventReport", "Lcom/tencent/rmonitor/base/reporter/uvreport/UVEventReport;", "getUvEventReport", "()Lcom/tencent/rmonitor/base/reporter/uvreport/UVEventReport;", "setUvEventReport", "(Lcom/tencent/rmonitor/base/reporter/uvreport/UVEventReport;)V", "isStart", "report", "", "reportData", "Lcom/tencent/rmonitor/base/reporter/data/ReportData;", "callback", "Lcom/tencent/rmonitor/base/reporter/IReporter$ReportCallback;", "checkCollect", "reportNow", "start", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class ReporterMachine
  implements IReporter
{
  public static final ReporterMachine a = new ReporterMachine();
  private static boolean b;
  @NotNull
  private static Handler c = new Handler(ThreadManager.a.c());
  @NotNull
  private static UVEventReport d = new UVEventReport(ThreadManager.a.c());
  @NotNull
  private static IReporter e = (IReporter)new QAPMUploadProxy(c);
  @NotNull
  private static IReportCache f = (IReportCache)new ReportCacheImpl(c);
  
  @NotNull
  public final IReportCache a()
  {
    return f;
  }
  
  @JvmOverloads
  public final void a(@NotNull ReportData paramReportData)
  {
    a(this, paramReportData, null, false, 6, null);
  }
  
  @JvmOverloads
  public final void a(@NotNull ReportData paramReportData, @Nullable IReporter.ReportCallback paramReportCallback, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramReportData, "reportData");
    int i = paramReportData.getPlugin();
    if ((paramBoolean) && (!PluginController.b.b(i)))
    {
      if (paramReportCallback != null) {
        paramReportCallback.a(800, "", 0);
      }
      return;
    }
    PluginController.b.a(i);
    if ((paramReportData.isRealTime()) && (NetworkWatcher.a.b())) {
      try
      {
        a(paramReportData, paramReportCallback);
        return;
      }
      catch (Exception paramReportData)
      {
        Logger.b.a("RMonitor_base_ReporterMachine", (Throwable)paramReportData);
        return;
      }
    }
    f.a(paramReportData);
    if (paramReportCallback != null) {
      paramReportCallback.a();
    }
  }
  
  public boolean a(@NotNull ReportData paramReportData, @Nullable IReporter.ReportCallback paramReportCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramReportData, "reportData");
    int i = paramReportData.getPlugin();
    if ((PluginCombination.a.a(i)) && (PluginController.b.f()))
    {
      Logger.b.i(new String[] { "RMonitor_base_ReporterMachine", "reportNow, austerity plugin reach max report num." });
      if (paramReportCallback != null) {
        paramReportCallback.a(800, "", 0);
      }
      return false;
    }
    if ((PluginCombination.a.b(i)) && (PluginController.b.e()))
    {
      Logger.b.i(new String[] { "RMonitor_base_ReporterMachine", "reportNow, loose plugin reach max report num." });
      if (paramReportCallback != null) {
        paramReportCallback.a(800, "", 0);
      }
      return false;
    }
    Object localObject1 = BaseInfo.pubJson.keys();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "BaseInfo.pubJson.keys()");
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      paramReportData.getParams().put((String)localObject2, BaseInfo.pubJson.get((String)localObject2));
    }
    AbProviderSingleton.a.a(paramReportData.getParams());
    localObject1 = Logger.b;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("reportNow, dbId: ");
    ((StringBuilder)localObject2).append(paramReportData.getDbId());
    ((StringBuilder)localObject2).append(", reportData: ");
    ((StringBuilder)localObject2).append(paramReportData);
    ((Logger)localObject1).d(new String[] { "RMonitor_base_ReporterMachine", ((StringBuilder)localObject2).toString() });
    e.a(paramReportData, (IReporter.ReportCallback)new ReporterMachine.reportNow.1(paramReportCallback));
    PluginController.b.c(i);
    return true;
  }
  
  public final void b()
  {
    try
    {
      if (!a.c())
      {
        f.a((IReporter)a);
        d.a();
        b = true;
      }
      Unit localUnit = Unit.INSTANCE;
      return;
    }
    finally {}
  }
  
  @JvmOverloads
  public final void b(@NotNull ReportData paramReportData, @Nullable IReporter.ReportCallback paramReportCallback)
  {
    a(this, paramReportData, paramReportCallback, false, 4, null);
  }
  
  public final boolean c()
  {
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.reporter.ReporterMachine
 * JD-Core Version:    0.7.0.1
 */