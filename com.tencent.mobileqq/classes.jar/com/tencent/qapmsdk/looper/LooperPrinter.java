package com.tencent.qapmsdk.looper;

import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Printer;
import com.tencent.qapmsdk.base.config.DefaultPluginConfig;
import com.tencent.qapmsdk.base.config.PluginCombination;
import com.tencent.qapmsdk.base.listener.IMonitorListener;
import com.tencent.qapmsdk.base.listener.ListenerManager;
import com.tencent.qapmsdk.base.meta.BaseInfo;
import com.tencent.qapmsdk.base.meta.LooperMeta;
import com.tencent.qapmsdk.base.meta.UserMeta;
import com.tencent.qapmsdk.base.monitorplugin.PluginController;
import com.tencent.qapmsdk.base.reporter.ReporterMachine;
import com.tencent.qapmsdk.base.reporter.uploaddata.data.ResultObject;
import com.tencent.qapmsdk.common.activty.ActivityInfo;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.util.FileUtil;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

class LooperPrinter
  implements Printer
{
  private static final String START_PREFIX = ">>";
  private static final String STOP_PREFIX = "<<";
  private static final String TAG = "QAPM_looper_LooperPrinter";
  static int looperThreshold = 200;
  @NonNull
  private static String workDir = FileUtil.getRootPath() + "/Log/";
  private String lastLog;
  private String looperName;
  private ArrayList<Printer> originalPrinters = new ArrayList();
  private long startTime;
  
  LooperPrinter(String paramString)
  {
    this.looperName = paramString;
  }
  
  private void gotoReport(@NonNull MonitorInfo paramMonitorInfo, long paramLong)
  {
    if (!PluginController.INSTANCE.canCollect(PluginCombination.loopStackPlugin.plugin)) {}
    while (TextUtils.isEmpty(paramMonitorInfo.stack)) {
      return;
    }
    try
    {
      localJSONObject = new JSONObject();
      localJSONObject.put("stage", ActivityInfo.getCurrentActivityName());
      localJSONObject.put("event_time", paramMonitorInfo.cacheRealStackTime);
      localJSONObject.put("cost_time", paramLong);
      localJSONObject.put("stack", paramMonitorInfo.stack);
      localJSONObject.put("plugin", PluginCombination.loopStackPlugin.plugin);
    }
    catch (Exception paramMonitorInfo)
    {
      Object localObject;
      Method localMethod;
      label202:
      Logger.INSTANCE.w(new String[] { "QAPM_looper_LooperPrinter", "looper data may be error, " + paramMonitorInfo.getMessage() });
      return;
    }
    try
    {
      localObject = Class.forName("com.tencent.qapmsdk.athena.BreadCrumb");
      paramMonitorInfo = ((Class)localObject).getDeclaredMethod("isEnable", new Class[0]);
      localMethod = ((Class)localObject).getDeclaredMethod("generateEvent", new Class[] { Integer.TYPE });
      localObject = ((Class)localObject).getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
      if ((localObject != null) && (((Boolean)paramMonitorInfo.invoke(localObject, new Object[0])).booleanValue())) {
        localJSONObject.put("bread_crumb_id", localMethod.invoke(localObject, new Object[] { Integer.valueOf(1) }));
      }
    }
    catch (ClassNotFoundException paramMonitorInfo)
    {
      localJSONObject.put("bread_crumb_id", "");
      break label202;
    }
    catch (NoSuchMethodException paramMonitorInfo)
    {
      localJSONObject.put("bread_crumb_id", "");
      break label202;
    }
    catch (Exception paramMonitorInfo)
    {
      localJSONObject.put("bread_crumb_id", "");
      break label202;
    }
    if (ListenerManager.monitorListener != null) {
      ListenerManager.monitorListener.onMetaGet(new LooperMeta(localJSONObject));
    }
    paramMonitorInfo = new ResultObject(0, "Looper single", true, 1L, 1L, localJSONObject, true, true, BaseInfo.userMeta.uin);
    ReporterMachine.INSTANCE.addResultObj(paramMonitorInfo);
  }
  
  private void notifyOriginalPrinters(String paramString)
  {
    Iterator localIterator = this.originalPrinters.iterator();
    while (localIterator.hasNext()) {
      ((Printer)localIterator.next()).println(paramString);
    }
  }
  
  public void println(@NonNull String paramString)
  {
    MonitorInfo localMonitorInfo = (MonitorInfo)LooperMonitor.monitorMap.get(this.looperName);
    if (paramString.startsWith(">>"))
    {
      this.startTime = SystemClock.uptimeMillis();
      this.lastLog = paramString;
      if ((localMonitorInfo != null) && (localMonitorInfo.stackGetterInited == true))
      {
        localMonitorInfo.lastStackRequestTime = SystemClock.uptimeMillis();
        localMonitorInfo.stack = null;
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
          Logger.INSTANCE.i(new String[] { "QAPM_looper_LooperPrinter", this.looperName, ", cost=", String.valueOf(l), ", ", this.lastLog });
          gotoReport(localMonitorInfo, l);
        }
        else if ((localMonitorInfo != null) && (localMonitorInfo.stackGetterInited == true))
        {
          localMonitorInfo.lastStackRequestTime = 0L;
          localMonitorInfo.stack = null;
        }
      }
    }
  }
  
  void setOriginalPrinter(Printer paramPrinter)
  {
    this.originalPrinters.add(paramPrinter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.looper.LooperPrinter
 * JD-Core Version:    0.7.0.1
 */