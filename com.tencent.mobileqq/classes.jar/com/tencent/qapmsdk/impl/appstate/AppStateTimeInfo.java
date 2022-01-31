package com.tencent.qapmsdk.impl.appstate;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.tencent.qapmsdk.base.config.DefaultPluginConfig;
import com.tencent.qapmsdk.base.config.PluginCombination;
import com.tencent.qapmsdk.base.meta.BaseInfo;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.util.AsyncSPEditor;
import com.tencent.qapmsdk.impl.instrumentation.QAPMTraceUnit;
import com.tencent.qapmsdk.impl.instrumentation.TraceType.CONTEXT;
import com.tencent.qapmsdk.impl.util.TraceUtil;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;

public class AppStateTimeInfo
{
  private static final String TAG = "QAPM_Impl_AppStateTimeInfo";
  public static boolean hasStartEnd = false;
  private static volatile AppStateTimeInfo instance;
  public static volatile long lastBackgroundTime = 0L;
  private long activityCreateBeginTime;
  private long activityCreateEndTime;
  private String activityName;
  private long activityReStartBeginTime;
  private long activityReStartEndTime;
  private long activityResumeBeginTime;
  private long activityResumeEndTime;
  private long activityStartBeginTime;
  private long activityStartEndTime;
  private long appAttachBaseContextBeginTime;
  private long appAttachBaseContextEndTime;
  private long appBeginTime;
  private long appCreateBeginTime;
  private long appCreateEndTime;
  private AsyncSPEditor editor = null;
  private MethodEventListener eventListener = new MethodEventListener();
  public boolean hasSnooze = false;
  private long hybridOnResumeEndTime;
  
  private long activityCreateDurationTime()
  {
    if ((this.activityCreateBeginTime != 0L) && (this.activityCreateEndTime != 0L))
    {
      if ((this.appCreateEndTime == 0L) && (this.activityCreateBeginTime != 0L)) {
        return this.activityCreateEndTime - this.activityCreateBeginTime;
      }
      return this.activityCreateEndTime - this.appCreateEndTime;
    }
    return this.activityReStartEndTime - this.activityReStartBeginTime;
  }
  
  private long activityPageStartLoadingTime()
  {
    if (this.activityCreateBeginTime == 0L) {
      return this.activityReStartBeginTime;
    }
    if (this.appCreateEndTime == 0L) {
      return this.activityCreateBeginTime;
    }
    return this.appCreateEndTime;
  }
  
  private long activityResumeDurationTime()
  {
    if (this.activityCreateBeginTime == 0L) {
      return this.activityResumeEndTime - this.activityReStartEndTime;
    }
    if (this.hybridOnResumeEndTime <= 0L) {
      return this.activityResumeEndTime - this.activityCreateEndTime;
    }
    return this.hybridOnResumeEndTime - this.activityCreateEndTime;
  }
  
  private long appApplicationInitDurationTime()
  {
    if (TraceUtil.appState.get() == AppState.HOTSTART.getValue()) {
      return -1L;
    }
    return this.appAttachBaseContextEndTime - this.appAttachBaseContextBeginTime;
  }
  
  private long appLaunchBeginTime()
  {
    if (TraceUtil.appState.get() == AppState.HOTSTART.getValue())
    {
      if (this.activityCreateBeginTime == 0L) {
        return this.activityReStartBeginTime;
      }
      return this.activityCreateBeginTime;
    }
    if ((TraceUtil.appState.get() == AppState.FIRSTSTART.getValue()) || (TraceUtil.appState.get() == AppState.COLDSTART.getValue())) {
      return this.appAttachBaseContextBeginTime;
    }
    return -1L;
  }
  
  private long appLaunchDurationTime()
  {
    if (TraceUtil.appState.get() == AppState.HOTSTART.getValue()) {
      return activityCreateDurationTime() + activityResumeDurationTime();
    }
    if ((TraceUtil.appState.get() == AppState.FIRSTSTART.getValue()) || (TraceUtil.appState.get() == AppState.COLDSTART.getValue())) {
      return appApplicationInitDurationTime() + mainActivityInitDurationTime() + activityCreateDurationTime() + activityResumeDurationTime();
    }
    return -1L;
  }
  
  private String appLaunchStageName()
  {
    if (TraceUtil.appState.get() == AppState.HOTSTART.getValue()) {
      return "WARM_LAUNCH";
    }
    if (TraceUtil.appState.get() == AppState.COLDSTART.getValue()) {
      return "COLD_LAUNCH";
    }
    if (TraceUtil.appState.get() == AppState.FIRSTSTART.getValue()) {
      return "FIRST_TIME_LAUNCH";
    }
    return "";
  }
  
  private void appStartEnd()
  {
    com.tencent.qapmsdk.impl.instrumentation.QAPMAppInstrumentation.isAppInBackground = false;
    TraceUtil.appState.set(AppState.INIT.getValue());
    instance.reSet();
  }
  
  private void beforeReport()
  {
    if ((TraceUtil.appState.get() != AppState.COMMONRESTART.getValue()) && (TraceUtil.appState.get() != AppState.INIT.getValue()) && (TraceUtil.appState.get() != AppState.f.getValue()))
    {
      if (appLaunchDurationTime() != -1L)
      {
        long l = appLaunchBeginTime();
        MonitorAdapter localMonitorAdapter = MonitorAdapter.newOne("QAPM_APPLAUNCH", appLaunchStageName(), PluginCombination.resourcePlugin.threshold, TraceType.CONTEXT.APP);
        localMonitorAdapter.sectionHarve.setEntryTimestamp(l);
        localMonitorAdapter.sectionHarve.setExitTimestamp(this.activityResumeEndTime);
        if ((TraceUtil.appState.get() == AppState.FIRSTSTART.getValue()) || (TraceUtil.appState.get() == AppState.COLDSTART.getValue()))
        {
          localMonitorAdapter.addMonitorUnit(new QAPMTraceUnit("QAPM_APPLAUNCH", "LAUNCH_APPLICATION_INIT", this.appAttachBaseContextBeginTime, this.appAttachBaseContextEndTime, TraceType.CONTEXT.APP.getValue()));
          localMonitorAdapter.deleteMonitorUnit(false);
          localMonitorAdapter.addMonitorUnit(new QAPMTraceUnit("QAPM_APPLAUNCH", "LAUNCH_MAIN_ACTIVITY_INIT", this.appAttachBaseContextEndTime, this.appCreateEndTime, TraceType.CONTEXT.APP.getValue()));
          localMonitorAdapter.deleteMonitorUnit(false);
        }
        localMonitorAdapter.addMonitorUnit(new QAPMTraceUnit("QAPM_APPLAUNCH", "LAUNCH_ACTIVITY_LOAD", activityPageStartLoadingTime(), this.activityResumeEndTime, TraceType.CONTEXT.APP.getValue()));
        localMonitorAdapter.deleteMonitorUnit(false);
        localMonitorAdapter.sectionHarve.readyToReport(localMonitorAdapter.getQapmMonitorThreadLocal());
      }
      if (this.editor != null)
      {
        this.editor.putInt("appVersion", TraceUtil.versionCode);
        this.editor.putInt("betaOn", 1);
        this.editor.commit();
      }
    }
  }
  
  private void doHostStart()
  {
    if (QAPMMonitorThreadLocal.getInstance().getFinishedMethodThreadLocal().get() != null) {
      ((Vector)QAPMMonitorThreadLocal.getInstance().getFinishedMethodThreadLocal().get()).clear();
    }
    TraceUtil.appState.set(AppState.HOTSTART.getValue());
    this.appBeginTime = System.currentTimeMillis();
  }
  
  private Context getContext()
  {
    return TraceUtil.getContext();
  }
  
  public static AppStateTimeInfo getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new AppStateTimeInfo();
      }
      return instance;
    }
    finally {}
  }
  
  private void initConfig()
  {
    try
    {
      Context localContext = TraceUtil.getContext();
      BaseInfo.sharePreference = localContext.getSharedPreferences("QAPM_SP", 0);
      this.editor = new AsyncSPEditor(BaseInfo.sharePreference.edit());
      int i = localContext.getPackageManager().getPackageInfo(localContext.getPackageName(), 0).versionCode;
      TraceUtil.versionCode = i;
      int j = BaseInfo.sharePreference.getInt("appVersion", -1);
      if (j == -1) {}
      for (TraceUtil.canInstrumentMonitor = true; (j != -1) && (j == i); TraceUtil.canInstrumentMonitor = true)
      {
        TraceUtil.appState.set(AppState.COLDSTART.getValue());
        return;
        TraceUtil.setFirstVisit(BaseInfo.sharePreference.getInt("betaOn", 0));
      }
      TraceUtil.appState.set(AppState.FIRSTSTART.getValue());
    }
    catch (Exception localException)
    {
      Logger.INSTANCE.exception("QAPM_Impl_AppStateTimeInfo", "initInAttachBaseContextEnv:", localException);
      return;
    }
  }
  
  private boolean isHotStart()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.appAttachBaseContextBeginTime == 0L)
    {
      bool1 = bool2;
      if (lastBackgroundTime != 0L)
      {
        bool1 = bool2;
        if (System.currentTimeMillis() - lastBackgroundTime >= 180L * 1000L) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private long mainActivityInitDurationTime()
  {
    if (TraceUtil.appState.get() == AppState.HOTSTART.getValue()) {
      return -1L;
    }
    return this.appCreateEndTime - this.appAttachBaseContextEndTime;
  }
  
  private void reSet()
  {
    this.appAttachBaseContextBeginTime = 0L;
    this.appAttachBaseContextEndTime = 0L;
    this.appCreateEndTime = 0L;
    this.activityCreateBeginTime = 0L;
    this.activityCreateEndTime = 0L;
    this.activityReStartBeginTime = 0L;
    this.activityReStartEndTime = 0L;
    this.activityStartBeginTime = 0L;
    this.activityStartEndTime = 0L;
    this.activityResumeBeginTime = 0L;
    this.hybridOnResumeEndTime = 0L;
  }
  
  public void activityCreateBeginIns(String paramString)
  {
    if ((!hasStartEnd) && (TraceUtil.canInstrumentMonitor))
    {
      this.activityName = paramString;
      if (TraceUtil.appState.get() == AppState.f.getValue())
      {
        if (!isHotStart()) {
          break label51;
        }
        doHostStart();
      }
    }
    for (;;)
    {
      this.activityCreateBeginTime = System.currentTimeMillis();
      return;
      label51:
      TraceUtil.appState.set(AppState.COMMONRESTART.getValue());
    }
  }
  
  public void activityCreateEndIns()
  {
    if ((!hasStartEnd) && (TraceUtil.canInstrumentMonitor)) {
      this.activityCreateEndTime = System.currentTimeMillis();
    }
  }
  
  public void activityRestartBeginIns(String paramString)
  {
    hasStartEnd = false;
    this.activityName = paramString;
    TraceUtil.canInstrumentMonitor = true;
    if ((TraceUtil.canInstrumentMonitor) && (this.activityReStartBeginTime == 0L))
    {
      if (!isHotStart()) {
        break label47;
      }
      doHostStart();
    }
    for (;;)
    {
      this.activityReStartBeginTime = System.currentTimeMillis();
      return;
      label47:
      TraceUtil.appState.set(AppState.COMMONRESTART.getValue());
    }
  }
  
  public void activityRestartEndIns()
  {
    if ((TraceUtil.canInstrumentMonitor) && (this.activityReStartEndTime == 0L)) {
      this.activityReStartEndTime = System.currentTimeMillis();
    }
  }
  
  public void activityResumeBeginIns(String paramString)
  {
    if ((!hasStartEnd) && (TraceUtil.canInstrumentMonitor))
    {
      this.activityName = paramString;
      this.activityResumeBeginTime = System.currentTimeMillis();
    }
  }
  
  public void activityResumeEndIns()
  {
    if ((TraceUtil.canInstrumentMonitor) && (!hasStartEnd)) {}
    try
    {
      this.activityResumeEndTime = System.currentTimeMillis();
      hasStartEnd = true;
      beforeReport();
      return;
    }
    catch (Exception localException)
    {
      Logger.INSTANCE.exception("QAPM_Impl_AppStateTimeInfo", "error:", localException);
      return;
    }
    finally
    {
      appStartEnd();
    }
  }
  
  public void activityStartBeginIns(String paramString)
  {
    if ((!hasStartEnd) && (TraceUtil.canInstrumentMonitor)) {
      this.activityStartBeginTime = System.currentTimeMillis();
    }
  }
  
  public void activityStartEndIns()
  {
    if ((!hasStartEnd) && (TraceUtil.canInstrumentMonitor) && (this.activityStartEndTime == 0L)) {
      this.activityStartEndTime = System.currentTimeMillis();
    }
  }
  
  public void applicationCreateBeginIns()
  {
    if (TraceUtil.canInstrumentMonitor) {
      this.appCreateBeginTime = System.currentTimeMillis();
    }
  }
  
  public void applicationCreateEndIns()
  {
    if (TraceUtil.canInstrumentMonitor) {
      this.appCreateEndTime = System.currentTimeMillis();
    }
  }
  
  public void attachBaseContextBeginIns(Context paramContext)
  {
    hasStartEnd = false;
    TraceUtil.saveContext(paramContext);
    initConfig();
    if (TraceUtil.canInstrumentMonitor)
    {
      this.appBeginTime = System.currentTimeMillis();
      this.appAttachBaseContextBeginTime = this.appBeginTime;
    }
  }
  
  public void attachBaseContextEndIns()
  {
    if (TraceUtil.canInstrumentMonitor) {
      this.appAttachBaseContextEndTime = System.currentTimeMillis();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.appstate.AppStateTimeInfo
 * JD-Core Version:    0.7.0.1
 */