package com.tencent.qapmsdk.looper;

import android.os.Debug;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Printer;
import com.tencent.qapmsdk.base.breadcrumbreflect.AthenaInfo;
import com.tencent.qapmsdk.base.breadcrumbreflect.AthenaReflect;
import com.tencent.qapmsdk.base.config.DefaultPluginConfig;
import com.tencent.qapmsdk.base.config.PluginCombination;
import com.tencent.qapmsdk.base.listener.ILooperListener;
import com.tencent.qapmsdk.base.listener.ListenerManager;
import com.tencent.qapmsdk.base.meta.BaseInfo;
import com.tencent.qapmsdk.base.meta.LooperMeta;
import com.tencent.qapmsdk.base.meta.UserMeta;
import com.tencent.qapmsdk.base.monitorplugin.PluginController;
import com.tencent.qapmsdk.base.reporter.ReporterMachine;
import com.tencent.qapmsdk.base.reporter.uploaddata.data.ResultObject;
import com.tencent.qapmsdk.common.logger.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

class LooperPrinter
  implements Printer
{
  private static final long MAX_LOOPER_TIME = 3000L;
  private static final String START_PREFIX = ">>";
  private static final String STOP_PREFIX = "<<";
  private static final String TAG = "QAPM_looper_LooperPrinter";
  static int looperThreshold = 200;
  private String lastLog;
  private String looperName;
  IMonitorCallback monitorCallback;
  private ArrayList<Printer> originalPrinters = new ArrayList();
  private long startTime;
  
  LooperPrinter(String paramString)
  {
    this.looperName = paramString;
    this.monitorCallback = new LooperPrinter.1(this);
  }
  
  private void notifyOriginalPrinters(String paramString)
  {
    Iterator localIterator = this.originalPrinters.iterator();
    while (localIterator.hasNext()) {
      ((Printer)localIterator.next()).println(paramString);
    }
  }
  
  void gotoReport(@NonNull MonitorInfo paramMonitorInfo, long paramLong)
  {
    Object localObject = paramMonitorInfo.stack;
    if ((!PluginController.INSTANCE.canCollect(PluginCombination.loopStackPlugin.plugin)) || (TextUtils.isEmpty((CharSequence)localObject))) {
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("event_time", paramMonitorInfo.cacheRealStackTime);
      localJSONObject.put("cost_time", paramLong);
      localJSONObject.put("stack", localObject);
      localJSONObject.put("plugin", PluginCombination.loopStackPlugin.plugin);
      localJSONObject.put("stage", paramMonitorInfo.scene);
      localJSONObject.put("bread_crumb_id", AthenaReflect.getBreadCrumbId(1, new AthenaInfo(paramMonitorInfo.scene, (int)paramLong)));
      if (ListenerManager.looperListener != null) {
        ListenerManager.looperListener.onBeforeReport(new LooperMeta(localJSONObject));
      }
      localObject = new ResultObject(0, "Looper single", true, 1L, 1L, localJSONObject, true, true, BaseInfo.userMeta.uin);
      ReporterMachine.INSTANCE.addResultObj((ResultObject)localObject, null, paramMonitorInfo.needCheck);
      return;
    }
    catch (Exception paramMonitorInfo)
    {
      Logger.INSTANCE.w(new String[] { "QAPM_looper_LooperPrinter", "looper data may be error, " + paramMonitorInfo.getMessage() });
    }
  }
  
  public void println(@NonNull String paramString)
  {
    MonitorInfo localMonitorInfo = (MonitorInfo)LooperMonitor.monitorMap.get(this.looperName);
    if (paramString.startsWith(">>"))
    {
      this.startTime = SystemClock.uptimeMillis();
      this.lastLog = paramString;
      if ((localMonitorInfo != null) && (localMonitorInfo.stackGetterInited))
      {
        localMonitorInfo.lastStackRequestTime = SystemClock.uptimeMillis();
        localMonitorInfo.lastForceTime = localMonitorInfo.lastStackRequestTime;
        localMonitorInfo.stack = null;
        localMonitorInfo.scene = null;
      }
    }
    for (;;)
    {
      notifyOriginalPrinters(paramString);
      return;
      if ((this.startTime != 0L) && (paramString.startsWith("<<")))
      {
        long l = SystemClock.uptimeMillis() - this.startTime;
        this.startTime = 0L;
        if (l > looperThreshold)
        {
          if (Debug.isDebuggerConnected()) {
            break;
          }
          Logger.INSTANCE.i(new String[] { "QAPM_looper_LooperPrinter", this.looperName, ", cost=", String.valueOf(l), ", ", this.lastLog });
          gotoReport(localMonitorInfo, l);
          continue;
        }
        if ((localMonitorInfo != null) && (localMonitorInfo.stackGetterInited))
        {
          localMonitorInfo.lastStackRequestTime = 0L;
          localMonitorInfo.lastForceTime = 0L;
          localMonitorInfo.stack = null;
          localMonitorInfo.scene = null;
        }
      }
    }
  }
  
  void setOriginalPrinter(Printer paramPrinter)
  {
    this.originalPrinters.add(paramPrinter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.looper.LooperPrinter
 * JD-Core Version:    0.7.0.1
 */