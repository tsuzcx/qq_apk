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
import com.tencent.qapmsdk.base.meta.BaseInfo;
import com.tencent.qapmsdk.base.meta.LooperMeta;
import com.tencent.qapmsdk.base.meta.UserMeta;
import com.tencent.qapmsdk.base.monitorplugin.PluginController;
import com.tencent.qapmsdk.base.reporter.ReporterMachine;
import com.tencent.qapmsdk.base.reporter.uploaddata.data.ResultObject;
import com.tencent.qapmsdk.common.activty.ActivityInfo;
import com.tencent.qapmsdk.common.logger.Logger;
import java.lang.reflect.Field;
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
  private Object dropFrameInstance = null;
  private Field dropFrameSceneField = null;
  private String lastLog;
  private String looperName;
  private ArrayList<Printer> originalPrinters = new ArrayList();
  private long startTime;
  
  LooperPrinter(String paramString)
  {
    this.looperName = paramString;
  }
  
  private String getDropFrameScene()
  {
    Object localObject1 = "";
    try
    {
      if ((this.dropFrameInstance == null) && (this.dropFrameSceneField == null))
      {
        Object localObject3 = Class.forName("com.tencent.qapmsdk.dropframe.DropFrameMonitor");
        localObject2 = ((Class)localObject3).getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        localObject3 = ((Class)localObject3).getDeclaredField("currentScene");
        ((Field)localObject3).setAccessible(true);
        this.dropFrameInstance = localObject2;
        this.dropFrameSceneField = ((Field)localObject3);
      }
      localObject2 = String.valueOf(this.dropFrameSceneField.get(this.dropFrameInstance));
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2;
        Logger.INSTANCE.w(new String[] { "QAPM_looper_LooperPrinter", "get dropFrame scene may be error" });
      }
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = ActivityInfo.getCurrentActivityName();
    }
    return localObject2;
  }
  
  private void notifyOriginalPrinters(String paramString)
  {
    Iterator localIterator = this.originalPrinters.iterator();
    while (localIterator.hasNext()) {
      ((Printer)localIterator.next()).println(paramString);
    }
  }
  
  public void gotoReport(@NonNull MonitorInfo paramMonitorInfo, long paramLong)
  {
    String str1 = paramMonitorInfo.stack;
    if ((!PluginController.INSTANCE.canCollect(PluginCombination.loopStackPlugin.plugin)) || (TextUtils.isEmpty(str1))) {
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      String str2 = getDropFrameScene();
      localJSONObject.put("event_time", paramMonitorInfo.cacheRealStackTime);
      localJSONObject.put("cost_time", paramLong);
      localJSONObject.put("stack", str1);
      localJSONObject.put("plugin", PluginCombination.loopStackPlugin.plugin);
      localJSONObject.put("stage", str2);
      localJSONObject.put("bread_crumb_id", AthenaReflect.getBreadCrumbId(1, new AthenaInfo(str2, (int)paramLong, 0L, "")));
      if (LooperMonitor.looperListener != null) {
        LooperMonitor.looperListener.onMetaGet(new LooperMeta(localJSONObject));
      }
      paramMonitorInfo = new ResultObject(0, "Looper single", true, 1L, 1L, localJSONObject, true, true, BaseInfo.userMeta.uin);
      ReporterMachine.INSTANCE.addResultObj(paramMonitorInfo);
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
        localMonitorInfo.stack = null;
        localMonitorInfo.lastGetStackTimeStamp = 0L;
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
          if (localMonitorInfo.lastGetStackTimeStamp == 0L) {
            continue;
          }
          localMonitorInfo.lastGetStackTimeStamp = 0L;
          gotoReport(localMonitorInfo, l);
          continue;
        }
        if ((localMonitorInfo != null) && (localMonitorInfo.stackGetterInited))
        {
          localMonitorInfo.lastStackRequestTime = 0L;
          localMonitorInfo.stack = null;
          localMonitorInfo.lastGetStackTimeStamp = 0L;
        }
      }
    }
  }
  
  void setOriginalPrinter(Printer paramPrinter)
  {
    this.originalPrinters.add(paramPrinter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.looper.LooperPrinter
 * JD-Core Version:    0.7.0.1
 */