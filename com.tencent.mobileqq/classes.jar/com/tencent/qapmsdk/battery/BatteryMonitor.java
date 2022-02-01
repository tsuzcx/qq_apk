package com.tencent.qapmsdk.battery;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qapmsdk.base.config.DefaultPluginConfig;
import com.tencent.qapmsdk.base.config.PluginCombination;
import com.tencent.qapmsdk.base.meta.BaseInfo;
import com.tencent.qapmsdk.base.meta.UserMeta;
import com.tencent.qapmsdk.base.monitorplugin.QAPMMonitorPlugin;
import com.tencent.qapmsdk.base.reporter.ReporterMachine;
import com.tencent.qapmsdk.base.reporter.uploaddata.data.ResultObject;
import com.tencent.qapmsdk.battery.config.BatteryConfig;
import com.tencent.qapmsdk.battery.config.CmdMeta;
import com.tencent.qapmsdk.battery.config.CpuMeta;
import com.tencent.qapmsdk.battery.config.GpsMeta;
import com.tencent.qapmsdk.battery.config.LogMeta;
import com.tencent.qapmsdk.battery.config.TrafficMeta;
import com.tencent.qapmsdk.battery.config.WakeLockMeta;
import com.tencent.qapmsdk.battery.config.WifiMeta;
import com.tencent.qapmsdk.battery.listener.BatteryStats;
import com.tencent.qapmsdk.battery.monitor.CmdMonitor;
import com.tencent.qapmsdk.battery.monitor.CpuMonitor;
import com.tencent.qapmsdk.battery.monitor.GpsMonitor;
import com.tencent.qapmsdk.battery.monitor.HookMethodCallback;
import com.tencent.qapmsdk.battery.monitor.LogMonitor;
import com.tencent.qapmsdk.battery.monitor.TrafficMonitor;
import com.tencent.qapmsdk.battery.monitor.WakeLockMonitor;
import com.tencent.qapmsdk.battery.monitor.WifiMonitor;
import com.tencent.qapmsdk.common.activty.LifecycleCallback;
import com.tencent.qapmsdk.common.json.JsonDispose;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.thread.ThreadManager;
import com.tencent.qapmsdk.common.util.AppInfo;
import com.tencent.qapmsdk.common.util.AsyncSPEditor;
import com.tencent.qapmsdk.common.util.FileUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class BatteryMonitor
  extends QAPMMonitorPlugin
  implements Handler.Callback, BatteryStats
{
  private static final int GRAY_ENLARGE_RATIO = 50;
  private static final String KEY_LAST_REPORT_TIMESTAMP = "battery_report_timestamp";
  private static final int MAX_NOT_RELEASE_COUNT = 10;
  private static final int MSG_BG_5_MIN = 5;
  private static final int MSG_INIT = 0;
  private static final int MSG_REPORT_CLEAN_LOG = 2;
  private static final int MSG_RUN_30_MIN = 4;
  private static final int MSG_STOP_MONITOR = 3;
  private static final int PUB_ENLARGE_RATIO = 300;
  private static final long REPORT_INTERVAL;
  private static final int STATUS_NOT_MONITOR = 0;
  private static final int STATUS_RUNNING = 1;
  private static final int STATUS_UN_INIT = -1;
  private static final String TAG = "QAPM_battery_BatteryMonitor";
  public static IBatteryListener batteryReportListener;
  @Nullable
  private static volatile BatteryMonitor instance;
  public static boolean sDebug;
  private BatteryForeCallbackImpl batteryForeCallback = new BatteryForeCallbackImpl();
  private List<BatteryUsageItem> batteryUsageList;
  BatteryMonitor.IBatteryStatsCallback callback;
  private CmdMonitor cmdMonitor;
  private BatteryConfig globalConfig;
  private GpsMonitor gpsMonitor;
  private boolean hasAppBg5Min = false;
  private boolean hasCleanLog = false;
  private boolean isBackground = false;
  private LogMonitor logMonitor;
  int notRelaseCount = 0;
  private int status = -1;
  @NonNull
  private Handler subHandler = new Handler(ThreadManager.getBatteryThreadLooper(), this);
  private WakeLockMonitor wakeLockMonitor;
  private WifiMonitor wifiMonitor;
  
  static
  {
    if (Logger.debug) {}
    for (long l = 14400000L;; l = 86400000L)
    {
      REPORT_INTERVAL = l;
      batteryReportListener = null;
      sDebug = false;
      instance = null;
      return;
    }
  }
  
  private BatteryMonitor()
  {
    LifecycleCallback.INSTANCE.register(this.batteryForeCallback);
  }
  
  private void addData(String paramString, int[] paramArrayOfInt, String[] paramArrayOfString, JSONArray paramJSONArray)
  {
    int j = (int)(Long.valueOf(paramArrayOfString[0]).longValue() / 1000L);
    Object localObject = null;
    int i = -1;
    switch (paramString.hashCode())
    {
    default: 
      switch (i)
      {
      default: 
        paramString = localObject;
      }
      break;
    }
    for (;;)
    {
      if (paramString != null) {
        paramJSONArray.put(paramString);
      }
      return;
      if (!paramString.equals("fg30Cpu")) {
        break;
      }
      i = 0;
      break;
      if (!paramString.equals("bg5Cpu")) {
        break;
      }
      i = 1;
      break;
      if (!paramString.equals("fg30Trf")) {
        break;
      }
      i = 2;
      break;
      if (!paramString.equals("bg5Trf")) {
        break;
      }
      i = 3;
      break;
      if (!paramString.equals("fg30CmdCount")) {
        break;
      }
      i = 4;
      break;
      if (!paramString.equals("bg5CmdCount")) {
        break;
      }
      i = 5;
      break;
      if (!paramString.equals("fg30LogCount")) {
        break;
      }
      i = 6;
      break;
      if (!paramString.equals("bg5LogCount")) {
        break;
      }
      i = 7;
      break;
      if (!paramString.equals("bg5SdkCount")) {
        break;
      }
      i = 8;
      break;
      if (!paramString.equals("bg5SysCount")) {
        break;
      }
      i = 9;
      break;
      if (!paramString.equals("fg30SdkCount")) {
        break;
      }
      i = 10;
      break;
      if (!paramString.equals("fg30SysCount")) {
        break;
      }
      i = 11;
      break;
      if (!paramString.equals("fg30WFSCount")) {
        break;
      }
      i = 12;
      break;
      if (!paramString.equals("bg5WFSCount")) {
        break;
      }
      i = 13;
      break;
      if (!paramString.equals("fg30CmdAlarm")) {
        break;
      }
      i = 14;
      break;
      if (!paramString.equals("bg5CmdAlarm")) {
        break;
      }
      i = 15;
      break;
      if (!paramString.equals("fg30LogAlarm")) {
        break;
      }
      i = 16;
      break;
      if (!paramString.equals("bg5LogAlarm")) {
        break;
      }
      i = 17;
      break;
      if (!paramString.equals("fg30WlCount")) {
        break;
      }
      i = 18;
      break;
      if (!paramString.equals("bg5WlCount")) {
        break;
      }
      i = 19;
      break;
      if (!paramString.equals("fg30WFLCount")) {
        break;
      }
      i = 20;
      break;
      if (!paramString.equals("bg5WFLCount")) {
        break;
      }
      i = 21;
      break;
      if (!paramString.equals("bg5WlUse")) {
        break;
      }
      i = 22;
      break;
      if (!paramString.equals("fg30WlUse")) {
        break;
      }
      i = 23;
      break;
      if (!paramString.equals("fg30WFLDetail")) {
        break;
      }
      i = 24;
      break;
      if (!paramString.equals("bg5WFLDetail")) {
        break;
      }
      i = 25;
      break;
      if (!paramString.equals("wlNotRelease")) {
        break;
      }
      i = 26;
      break;
      if (!paramString.equals("wlTimeout")) {
        break;
      }
      i = 27;
      break;
      if (!paramString.equals("wflNotRelease")) {
        break;
      }
      i = 28;
      break;
      if (!paramString.equals("bg5SdkDetail")) {
        break;
      }
      i = 29;
      break;
      if (!paramString.equals("bg5SysDetail")) {
        break;
      }
      i = 30;
      break;
      if (!paramString.equals("fg30SdkDetail")) {
        break;
      }
      i = 31;
      break;
      if (!paramString.equals("fg30SysDetail")) {
        break;
      }
      i = 32;
      break;
      if (!paramString.equals("fg30WFSDetail")) {
        break;
      }
      i = 33;
      break;
      if (!paramString.equals("bg5WFSDetail")) {
        break;
      }
      i = 34;
      break;
      paramArrayOfInt[0] += 1;
      paramString = handlerCpuData(j, paramArrayOfString);
      continue;
      paramArrayOfInt[1] += 1;
      paramString = handlerCpuData(j, paramArrayOfString);
      continue;
      paramString = handlerTrafficData(j, paramArrayOfString);
      continue;
      paramString = handlerLogOrCmdData(j, paramArrayOfString);
      continue;
      paramString = handlerLogOrCmdDataAlarm(paramString, paramArrayOfString);
      continue;
      paramString = handleWakeLockWifiLock(paramArrayOfString, j);
      continue;
      paramString = handleWakeLockAndWifi(paramArrayOfString, j);
      continue;
      paramString = localObject;
      if (this.notRelaseCount <= 10)
      {
        this.notRelaseCount += 1;
        paramString = handleWakeLock(paramArrayOfString, j);
        continue;
        paramString = handleGpsOrWifiScan(paramArrayOfString);
      }
    }
  }
  
  private String combineString(String[] paramArrayOfString, int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return paramArrayOfString[paramInt1];
    }
    StringBuilder localStringBuilder = new StringBuilder((paramInt2 - paramInt1) * 10);
    while (paramInt1 < paramInt2 + 1)
    {
      localStringBuilder.append(paramArrayOfString[paramInt1]);
      if (paramInt1 != paramInt2) {
        localStringBuilder.append("|");
      }
      paramInt1 += 1;
    }
    return localStringBuilder.toString();
  }
  
  private void doQuickFileReport(long paramLong1, long paramLong2)
  {
    File localFile = BatteryLog.getCommonLogFileForReport(paramLong1, paramLong2, 10, 3000L);
    if (localFile != null)
    {
      Logger.INSTANCE.i(new String[] { "QAPM_battery_BatteryMonitor", "report battery log: ", localFile.getName() });
      doReport(true, localFile.getAbsolutePath(), null);
      return;
    }
    Logger.INSTANCE.i(new String[] { "QAPM_battery_BatteryMonitor", "no battery log to report" });
  }
  
  private void doQuickJsonReport(long paramLong1, long paramLong2)
  {
    Object localObject = BatteryLog.getReportLogFile(paramLong1, paramLong2, 200L);
    if ((localObject == null) || (((List)localObject).size() == 0)) {
      Logger.INSTANCE.e(new String[] { "QAPM_battery_BatteryMonitor", "battery report, but reportLogFile is null" });
    }
    JSONObject localJSONObject;
    do
    {
      return;
      localJSONObject = new JSONObject();
      localObject = handlerAllData(localJSONObject, (List)localObject);
    } while ((localObject[0] <= 0) && (localObject[1] <= 0));
    doReport(false, null, localJSONObject);
  }
  
  private void doReport(boolean paramBoolean, String paramString, JSONObject paramJSONObject)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (paramBoolean) {
        localJSONObject.put("fileObj", paramString);
      }
      for (;;)
      {
        localJSONObject.put("plugin", PluginCombination.batteryPlugin.plugin);
        paramString = new ResultObject(0, "Battery target", true, 1L, 1L, JsonDispose.copyJson(BaseInfo.pubJson, localJSONObject), true, true, BaseInfo.userMeta.uin);
        ReporterMachine.INSTANCE.addResultObj(paramString);
        return;
        localJSONObject.put("batterydata", paramJSONObject);
      }
      return;
    }
    catch (Exception paramString)
    {
      Logger.INSTANCE.exception("QAPM_battery_BatteryMonitor", paramString);
    }
  }
  
  public static BatteryMonitor getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new BatteryMonitor();
      }
      return instance;
    }
    finally {}
  }
  
  private JSONObject handleGpsOrWifiScan(String[] paramArrayOfString)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("tag", paramArrayOfString[2]);
    JSONArray localJSONArray = new JSONArray();
    localJSONObject.put("timeList", localJSONArray);
    paramArrayOfString = paramArrayOfString[3].split("#");
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      localJSONArray.put(Long.valueOf(paramArrayOfString[i]).longValue() / 1000L);
      i += 1;
    }
    return localJSONObject;
  }
  
  private JSONObject handleWakeLock(String[] paramArrayOfString, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("tag", paramArrayOfString[3]);
    localJSONObject.put("stack", paramArrayOfString[2]);
    localJSONObject.put("flag", paramArrayOfString[4]);
    localJSONObject.put("time", paramInt);
    localJSONObject.put("duration", Long.valueOf(paramArrayOfString[5]).longValue() / 1000L);
    return localJSONObject;
  }
  
  private JSONObject handleWakeLockAndWifi(String[] paramArrayOfString, int paramInt)
  {
    JSONObject localJSONObject1 = new JSONObject();
    localJSONObject1.put("time", paramInt);
    localJSONObject1.put("tag", paramArrayOfString[2]);
    localJSONObject1.put("useBattery", paramArrayOfString[3].equals("1"));
    localJSONObject1.put("stack", paramArrayOfString[4]);
    JSONArray localJSONArray = new JSONArray();
    localJSONObject1.put("detail", localJSONArray);
    paramArrayOfString = paramArrayOfString[5].split("#");
    int i = paramArrayOfString.length;
    paramInt = 0;
    while (paramInt < i)
    {
      String[] arrayOfString = paramArrayOfString[paramInt].split(",");
      if ((arrayOfString != null) && (arrayOfString.length > 1))
      {
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("time", Long.valueOf(arrayOfString[0]).longValue() / 1000L);
        localJSONObject2.put("duration", Long.valueOf(arrayOfString[1]).longValue() / 1000L);
        localJSONArray.put(localJSONObject2);
      }
      paramInt += 1;
    }
    return localJSONObject1;
  }
  
  private JSONObject handleWakeLockWifiLock(String[] paramArrayOfString, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("count", paramArrayOfString[2]);
    localJSONObject.put("time", paramInt);
    localJSONObject.put("useTime", Long.valueOf(paramArrayOfString[3]).longValue() / 1000L);
    localJSONObject.put("useBatteryTime", Long.valueOf(paramArrayOfString[4]).longValue() / 1000L);
    return localJSONObject;
  }
  
  private int[] handlerAllData(JSONObject paramJSONObject, List<File> paramList)
  {
    arrayOfInt = new int[3];
    int[] tmp7_5 = arrayOfInt;
    tmp7_5[0] = 0;
    int[] tmp11_7 = tmp7_5;
    tmp11_7[1] = 0;
    int[] tmp15_11 = tmp11_7;
    tmp15_11[2] = 500;
    tmp15_11;
    try
    {
      paramJSONObject.put("device", Build.MODEL);
      paramJSONObject.put("sdk", Build.VERSION.SDK_INT);
      paramJSONObject.put("uin", BaseInfo.userMeta.uin);
      if (Logger.debug) {}
      for (int i = 3;; i = 2)
      {
        paramList = paramList.iterator();
        int j;
        do
        {
          do
          {
            if (!paramList.hasNext()) {
              break;
            }
            FileUtil.readStreamByLine((File)paramList.next(), new BatteryMonitor.1(this, arrayOfInt, i, paramJSONObject));
          } while (arrayOfInt[0] < i);
          j = arrayOfInt[1];
        } while (j < i);
        return arrayOfInt;
      }
      return arrayOfInt;
    }
    catch (Throwable paramJSONObject)
    {
      Logger.INSTANCE.exception("QAPM_battery_BatteryMonitor", paramJSONObject);
    }
  }
  
  private JSONObject handlerCpuData(long paramLong, String[] paramArrayOfString)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("main", paramArrayOfString[2]);
    localJSONObject.put("device", paramArrayOfString[3]);
    localJSONObject.put("time", paramLong);
    if (paramArrayOfString.length >= 5) {
      localJSONObject.put("other", paramArrayOfString[3]);
    }
    return localJSONObject;
  }
  
  private JSONObject handlerLogOrCmdData(long paramLong, String[] paramArrayOfString)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("time", paramLong);
    localJSONObject.put("count", paramArrayOfString[2]);
    return localJSONObject;
  }
  
  private JSONObject handlerLogOrCmdDataAlarm(String paramString, String[] paramArrayOfString)
  {
    JSONObject localJSONObject1 = new JSONObject();
    Object localObject = combineString(paramArrayOfString, 2, paramArrayOfString.length - 2);
    if ((paramString.equals("fg30LogAlarm")) || (paramString.equals("bg5LogAlarm"))) {
      localJSONObject1.put("log", localObject);
    }
    for (;;)
    {
      paramString = new JSONArray();
      localJSONObject1.put("detail", paramString);
      paramArrayOfString = paramArrayOfString[(paramArrayOfString.length - 1)].split("#");
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        localObject = paramArrayOfString[i].split(",");
        if (localObject.length > 1)
        {
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("time", Long.valueOf(localObject[0]).longValue() / 1000L);
          localJSONObject2.put("count", localObject[1]);
          paramString.put(localJSONObject2);
        }
        i += 1;
      }
      localJSONObject1.put("cmd", localObject);
    }
    return localJSONObject1;
  }
  
  private JSONObject handlerTrafficData(long paramLong, String[] paramArrayOfString)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("time", paramLong);
    localJSONObject.put("qqRecv", paramArrayOfString[2]);
    localJSONObject.put("qqSend", paramArrayOfString[3]);
    localJSONObject.put("devRecv", paramArrayOfString[4]);
    localJSONObject.put("devSend", paramArrayOfString[5]);
    return localJSONObject;
  }
  
  private void initConfig()
  {
    if (this.globalConfig != null) {
      return;
    }
    this.globalConfig = new BatteryConfig(true, 3600L);
    this.globalConfig.cpuConfig = new CpuMeta();
    this.globalConfig.trafficConfig = new TrafficMeta();
    this.globalConfig.logConfig = new LogMeta();
    this.globalConfig.cmdConfig = new CmdMeta();
    this.globalConfig.wakeLockConfig = new WakeLockMeta();
    this.globalConfig.gpsConfig = new GpsMeta();
    this.globalConfig.wifiConfig = new WifiMeta();
  }
  
  public static void setBatteryListener(IBatteryListener paramIBatteryListener)
  {
    batteryReportListener = paramIBatteryListener;
  }
  
  private void startMonitorInner()
  {
    this.batteryUsageList = new ArrayList(10);
    this.logMonitor = new LogMonitor(this.globalConfig.logConfig);
    this.cmdMonitor = new CmdMonitor(this.globalConfig.cmdConfig);
    if (sDebug)
    {
      this.globalConfig.cpuConfig.firstBgInterval = 10000L;
      this.globalConfig.cpuConfig.firstFgInterval = 10000L;
      this.globalConfig.cpuConfig.secondFgInterval = 10000L;
      this.globalConfig.cpuConfig.thirdFgInterval = 10000L;
    }
    this.batteryUsageList.add(new CpuMonitor(this.globalConfig.cpuConfig));
    this.batteryUsageList.add(new TrafficMonitor(this.globalConfig.trafficConfig));
    this.batteryUsageList.add(this.cmdMonitor);
    this.batteryUsageList.add(this.logMonitor);
    this.gpsMonitor = new GpsMonitor(this.globalConfig.gpsConfig);
    this.batteryUsageList.add(this.gpsMonitor);
    this.wakeLockMonitor = new WakeLockMonitor(this.globalConfig.wakeLockConfig);
    this.batteryUsageList.add(this.wakeLockMonitor);
    this.wifiMonitor = new WifiMonitor(this.globalConfig.wifiConfig);
    this.batteryUsageList.add(this.wifiMonitor);
    BatteryLog.init(AppInfo.obtainProcessName(BaseInfo.app), BatteryConstants.BATTERY_START_TIME);
    Object localObject = this.batteryUsageList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((BatteryUsageItem)((Iterator)localObject).next()).onProcessStart();
    }
    this.status = 1;
    long l = this.globalConfig.monitorEndTime;
    this.subHandler.sendEmptyMessageDelayed(3, (l + 60L) * 1000L);
    localObject = this.subHandler;
    if (sDebug) {}
    for (l = 20000L;; l = 1800000L)
    {
      ((Handler)localObject).sendEmptyMessageDelayed(4, l);
      return;
    }
  }
  
  public HookMethodCallback getGpsHook()
  {
    return this.gpsMonitor;
  }
  
  public HookMethodCallback getWakeLockHook()
  {
    return this.wakeLockMonitor;
  }
  
  public HookMethodCallback getWifiHook()
  {
    return this.wifiMonitor;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 1: 
    default: 
    case 0: 
      do
      {
        return true;
      } while (this.status != -1);
      BatteryConstants.BATTERY_START_TIME = System.currentTimeMillis();
      try
      {
        initConfig();
        startMonitorInner();
        return true;
      }
      catch (Exception paramMessage)
      {
        this.status = 0;
        return true;
      }
    case 2: 
      initConfig();
      if (this.globalConfig.reportfile) {
        if (BaseInfo.sharePreference == null) {
          break label455;
        }
      }
      break;
    }
    label445:
    label452:
    label455:
    for (long l1 = BaseInfo.sharePreference.getLong("battery_report_timestamp", 0L);; l1 = 0L)
    {
      long l2;
      if ((Math.abs(System.currentTimeMillis() - l1) > REPORT_INTERVAL) || (sDebug))
      {
        l2 = System.currentTimeMillis();
        if ((sDebug) || (BatteryConstants.BATTERY_START_TIME == 0L)) {
          break label452;
        }
        l2 = BatteryConstants.BATTERY_START_TIME - 60000L;
      }
      for (;;)
      {
        for (;;)
        {
          doQuickJsonReport(l1, l2);
          int i;
          if (Logger.debug)
          {
            i = 50;
            float f = (float)(1.0D / i);
            if ((Math.random() < f) || (sDebug)) {
              doQuickFileReport(l1, l2);
            }
            BaseInfo.editor.putLong("battery_report_timestamp", l2).commit();
          }
          for (;;)
          {
            BatteryLog.cleanStorage(BatteryConstants.BATTERY_START_TIME - 172800000L);
            this.hasCleanLog = true;
            return true;
            i = 300;
            break;
            Logger.INSTANCE.i(new String[] { "QAPM_battery_BatteryMonitor", "battery want report, but interval is short" });
            continue;
            Logger.INSTANCE.i(new String[] { "QAPM_battery_BatteryMonitor", "battery report switch is off" });
          }
          if (this.batteryUsageList != null)
          {
            paramMessage = this.batteryUsageList.iterator();
            while (paramMessage.hasNext()) {
              ((BatteryUsageItem)paramMessage.next()).stop();
            }
          }
          this.status = 0;
          return true;
          if (this.batteryUsageList == null) {
            break;
          }
          try
          {
            paramMessage = this.batteryUsageList.iterator();
            while (paramMessage.hasNext()) {
              ((BatteryUsageItem)paramMessage.next()).onProcessRun30Min();
            }
            if (this.batteryUsageList == null) {
              break label445;
            }
          }
          catch (Exception paramMessage)
          {
            Logger.INSTANCE.exception("QAPM_battery_BatteryMonitor", paramMessage);
            return true;
          }
        }
        try
        {
          paramMessage = this.batteryUsageList.iterator();
          while (paramMessage.hasNext()) {
            ((BatteryUsageItem)paramMessage.next()).onProcessBG5Min();
          }
          this.hasAppBg5Min = true;
        }
        catch (Exception paramMessage)
        {
          Logger.INSTANCE.exception("QAPM_battery_BatteryMonitor", paramMessage);
        }
        return true;
      }
    }
  }
  
  public boolean isHasAppBg5Min()
  {
    return this.hasAppBg5Min;
  }
  
  public void onAppBackground()
  {
    if ((this.isBackground) || (this.status != 1)) {
      return;
    }
    this.isBackground = true;
    Object localObject = this.batteryUsageList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((BatteryUsageItem)((Iterator)localObject).next()).onAppBackground();
    }
    if (!this.hasAppBg5Min)
    {
      localObject = this.subHandler;
      if (!sDebug) {
        break label110;
      }
    }
    label110:
    for (long l = 20000L;; l = 300000L)
    {
      ((Handler)localObject).sendEmptyMessageDelayed(5, l);
      if ((this.hasCleanLog) && (!sDebug)) {
        break;
      }
      this.subHandler.sendEmptyMessageDelayed(2, 200L);
      return;
    }
  }
  
  public void onAppForeground()
  {
    this.isBackground = false;
    if (this.status != 1) {
      return;
    }
    Iterator localIterator = this.batteryUsageList.iterator();
    while (localIterator.hasNext()) {
      ((BatteryUsageItem)localIterator.next()).onAppForeground();
    }
    this.subHandler.removeMessages(5);
  }
  
  public void onCmdRequest(String paramString)
  {
    if ((this.status != 1) || (this.cmdMonitor == null)) {
      return;
    }
    this.cmdMonitor.onCmdRequest(paramString);
  }
  
  public void onGpsScan(String paramString, Object[] paramArrayOfObject)
  {
    if (this.gpsMonitor != null) {
      this.gpsMonitor.onGpsScan(paramString, paramArrayOfObject);
    }
  }
  
  public void onPrintLog(String paramString) {}
  
  public void onWriteLog(String paramString1, String paramString2)
  {
    if ((this.status != 1) || (this.logMonitor == null)) {
      return;
    }
    this.logMonitor.onWriteLog(paramString1, paramString2);
  }
  
  public void setCallback(BatteryMonitor.IBatteryStatsCallback paramIBatteryStatsCallback)
  {
    this.callback = paramIBatteryStatsCallback;
  }
  
  public void setCmdWhite(@NonNull List<String> paramList, int paramInt)
  {
    if (this.cmdMonitor != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if (!TextUtils.isEmpty(str)) {
          this.cmdMonitor.getCmdWhiteMap().put(str, Integer.valueOf(paramInt));
        }
      }
    }
  }
  
  public void setLogWhite(@NonNull List<String> paramList, int paramInt)
  {
    if (this.logMonitor != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if (!TextUtils.isEmpty(str)) {
          this.logMonitor.getLogWhiteMap().put(str, Integer.valueOf(paramInt));
        }
      }
    }
  }
  
  public void setupConfig(BatteryConfig paramBatteryConfig)
  {
    this.globalConfig = paramBatteryConfig;
  }
  
  public void start()
  {
    if (!canEventReport(PluginCombination.batteryPlugin.plugin)) {
      Logger.INSTANCE.i(new String[] { "QAPM_battery_BatteryMonitor", "BatteryMonitor loose" });
    }
    while (this.subHandler == null) {
      return;
    }
    this.subHandler.sendEmptyMessage(0);
  }
  
  public void stop()
  {
    if ((this.status != 0) && (this.subHandler != null)) {
      this.subHandler.sendEmptyMessage(3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.battery.BatteryMonitor
 * JD-Core Version:    0.7.0.1
 */