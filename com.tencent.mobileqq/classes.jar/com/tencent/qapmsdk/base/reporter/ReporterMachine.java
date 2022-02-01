package com.tencent.qapmsdk.base.reporter;

import android.os.Handler;
import com.tencent.qapmsdk.base.config.PluginCombination;
import com.tencent.qapmsdk.base.config.PluginCombination.Companion;
import com.tencent.qapmsdk.base.config.SDKConfig;
import com.tencent.qapmsdk.base.config.SDKConfig.Companion;
import com.tencent.qapmsdk.base.dbpersist.DBDataStatus;
import com.tencent.qapmsdk.base.dbpersist.DBHandler;
import com.tencent.qapmsdk.base.dbpersist.DBHelper;
import com.tencent.qapmsdk.base.meta.BaseInfo;
import com.tencent.qapmsdk.base.monitorplugin.PluginController;
import com.tencent.qapmsdk.base.reporter.ab.AbProviderSingleton;
import com.tencent.qapmsdk.base.reporter.proxy.QAPMUploadProxy;
import com.tencent.qapmsdk.base.reporter.uploaddata.data.ResultObject;
import com.tencent.qapmsdk.base.reporter.uploaddata.runnable.CollectRecordDataRunnable;
import com.tencent.qapmsdk.base.reporter.uploaddata.runnable.StoreRecordDataRunnable;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.network.NetworkWatcher;
import com.tencent.qapmsdk.common.reporter.BaseJsonObject;
import com.tencent.qapmsdk.common.reporter.IReporter;
import com.tencent.qapmsdk.common.reporter.IReporter.ReportResultCallback;
import com.tencent.qapmsdk.common.thread.ThreadManager;
import com.tencent.qapmsdk.common.thread.ThreadManager.Companion;
import com.tencent.qapmsdk.common.util.AsyncSPEditor;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/reporter/ReporterMachine;", "", "()V", "TAG", "", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "isStarted", "", "uploadProxy", "Lcom/tencent/qapmsdk/common/reporter/IReporter;", "getUploadProxy", "()Lcom/tencent/qapmsdk/common/reporter/IReporter;", "setUploadProxy", "(Lcom/tencent/qapmsdk/common/reporter/IReporter;)V", "addResultObj", "", "resultObject", "Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;", "callback", "Lcom/tencent/qapmsdk/common/reporter/IReporter$ReportResultCallback;", "checkCollect", "reportOnce", "start", "updateToSendAway", "tableName", "dbId", "", "qapmbase_release"}, k=1, mv={1, 1, 15})
public final class ReporterMachine
{
  public static final ReporterMachine INSTANCE = new ReporterMachine();
  private static final String TAG = "QAPM_base_ReporterMachine";
  @NotNull
  private static final Handler handler = new Handler(ThreadManager.Companion.getReporterThreadLooper());
  private static boolean isStarted;
  @NotNull
  private static IReporter uploadProxy = (IReporter)new QAPMUploadProxy();
  
  @JvmOverloads
  public final void addResultObj(@NotNull ResultObject paramResultObject)
  {
    addResultObj$default(this, paramResultObject, null, false, 6, null);
  }
  
  @JvmOverloads
  public final void addResultObj(@NotNull ResultObject paramResultObject, @Nullable IReporter.ReportResultCallback paramReportResultCallback)
  {
    addResultObj$default(this, paramResultObject, paramReportResultCallback, false, 4, null);
  }
  
  @JvmOverloads
  public final void addResultObj(@NotNull ResultObject paramResultObject, @Nullable IReporter.ReportResultCallback paramReportResultCallback, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramResultObject, "resultObject");
    try
    {
      i = paramResultObject.getParams().getInt("plugin");
      if ((paramBoolean) && ((!PluginController.INSTANCE.whetherPluginSampling(i)) || (!PluginController.INSTANCE.canCollect(i)))) {
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      int i;
      for (;;)
      {
        Logger.INSTANCE.e(new String[] { "QAPM_base_ReporterMachine", localThrowable + ": resultObject lose plugin" });
        i = 0;
      }
      PluginController.INSTANCE.addPluginReportNum(i);
      if ((paramResultObject.isRealTime()) && (NetworkWatcher.INSTANCE.isWifiAvailable())) {
        try
        {
          reportOnce(paramResultObject, paramReportResultCallback);
          return;
        }
        catch (Exception paramResultObject)
        {
          Logger.INSTANCE.exception("QAPM_base_ReporterMachine", (Throwable)paramResultObject);
          return;
        }
      }
      handler.post((Runnable)new StoreRecordDataRunnable(paramResultObject));
    }
  }
  
  @NotNull
  public final Handler getHandler()
  {
    return handler;
  }
  
  @NotNull
  public final IReporter getUploadProxy()
  {
    return uploadProxy;
  }
  
  public final void reportOnce(@NotNull ResultObject paramResultObject, @Nullable IReporter.ReportResultCallback paramReportResultCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramResultObject, "resultObject");
    int i = paramResultObject.getParams().getInt("plugin");
    if (((PluginCombination.Companion.isAusterityPlugin(i)) && (PluginController.INSTANCE.getAusterityReportNum() > SDKConfig.Companion.getMAX_AUSTERITY_REPORT_NUM())) || ((PluginCombination.Companion.isLoosePlugin(i)) && (PluginController.INSTANCE.getLooseReportNum() > SDKConfig.Companion.getMAX_LOOSE_REPORT_NUM()))) {}
    do
    {
      do
      {
        return;
        Iterator localIterator = BaseInfo.pubJson.keys();
        Intrinsics.checkExpressionValueIsNotNull(localIterator, "BaseInfo.pubJson.keys()");
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          paramResultObject.getParams().put(str, BaseInfo.pubJson.get(str));
        }
        AbProviderSingleton.INSTANCE.addAbToParams(paramResultObject.getParams());
        uploadProxy.report((BaseJsonObject)paramResultObject, (IReporter.ReportResultCallback)new ReporterMachine.reportOnce.1(paramReportResultCallback));
        if (PluginCombination.Companion.isLoosePlugin(i))
        {
          paramResultObject = PluginController.INSTANCE;
          paramResultObject.setLooseReportNum(paramResultObject.getLooseReportNum() + 1);
          if (paramResultObject.getLooseReportNum() % 5 == 0) {
            BaseInfo.editor.putInt("count_today_loose_reported", PluginController.INSTANCE.getLooseReportNum()).apply();
          }
        }
      } while (!PluginCombination.Companion.isAusterityPlugin(i));
      paramResultObject = PluginController.INSTANCE;
      paramResultObject.setAusterityReportNum(paramResultObject.getAusterityReportNum() + 1);
    } while (paramResultObject.getAusterityReportNum() % 10 != 0);
    BaseInfo.editor.putInt("count_today_austerity_reported", PluginController.INSTANCE.getAusterityReportNum()).apply();
  }
  
  public final void setUploadProxy(@NotNull IReporter paramIReporter)
  {
    Intrinsics.checkParameterIsNotNull(paramIReporter, "<set-?>");
    uploadProxy = paramIReporter;
  }
  
  public final void start()
  {
    try
    {
      if (!isStarted)
      {
        localObject1 = new CollectRecordDataRunnable(handler, INSTANCE);
        handler.postDelayed((Runnable)localObject1, 300000L);
        handler.postDelayed((Runnable)ReporterMachine.start.1.1.INSTANCE, 60000L);
        isStarted = true;
      }
      Object localObject1 = Unit.INSTANCE;
      return;
    }
    finally {}
  }
  
  public final void updateToSendAway(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "tableName");
    if (paramInt > 0)
    {
      Object localObject = BaseInfo.dbHelper;
      if (localObject != null)
      {
        localObject = ((DBHelper)localObject).getDbHandler();
        if (localObject != null) {
          ((DBHandler)localObject).updateStatus(paramString, paramInt, DBDataStatus.SENT.getValue());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.base.reporter.ReporterMachine
 * JD-Core Version:    0.7.0.1
 */