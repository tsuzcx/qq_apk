package com.tencent.qapmsdk.qqbattery;

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
import com.tencent.qapmsdk.base.listener.IBaseListener;
import com.tencent.qapmsdk.base.meta.BaseInfo;
import com.tencent.qapmsdk.base.meta.UserMeta;
import com.tencent.qapmsdk.base.monitorplugin.PluginController;
import com.tencent.qapmsdk.base.monitorplugin.QAPMMonitorPlugin;
import com.tencent.qapmsdk.base.reporter.ReporterMachine;
import com.tencent.qapmsdk.base.reporter.uploaddata.data.ResultObject;
import com.tencent.qapmsdk.common.activty.LifecycleCallback;
import com.tencent.qapmsdk.common.json.JsonDispose;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.thread.ThreadManager;
import com.tencent.qapmsdk.common.util.AppInfo;
import com.tencent.qapmsdk.common.util.AsyncSPEditor;
import com.tencent.qapmsdk.common.util.FileUtil;
import com.tencent.qapmsdk.qqbattery.config.BatteryConfig;
import com.tencent.qapmsdk.qqbattery.config.CmdMeta;
import com.tencent.qapmsdk.qqbattery.config.CpuMeta;
import com.tencent.qapmsdk.qqbattery.config.GpsMeta;
import com.tencent.qapmsdk.qqbattery.config.LogMeta;
import com.tencent.qapmsdk.qqbattery.config.TrafficMeta;
import com.tencent.qapmsdk.qqbattery.config.WakeLockMeta;
import com.tencent.qapmsdk.qqbattery.config.WifiMeta;
import com.tencent.qapmsdk.qqbattery.listener.BatteryStats;
import com.tencent.qapmsdk.qqbattery.monitor.CmdMonitor;
import com.tencent.qapmsdk.qqbattery.monitor.CpuMonitor;
import com.tencent.qapmsdk.qqbattery.monitor.GpsMonitor;
import com.tencent.qapmsdk.qqbattery.monitor.HookMethodCallback;
import com.tencent.qapmsdk.qqbattery.monitor.LogMonitor;
import com.tencent.qapmsdk.qqbattery.monitor.TrafficMonitor;
import com.tencent.qapmsdk.qqbattery.monitor.WakeLockMonitor;
import com.tencent.qapmsdk.qqbattery.monitor.WifiMonitor;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class QQBatteryMonitor
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
  public static IBatteryListener batteryReportListener = null;
  public static boolean debug = false;
  @Nullable
  private static volatile QQBatteryMonitor instance = null;
  private BatteryForeCallbackImpl batteryForeCallback = new BatteryForeCallbackImpl();
  private List<BatteryUsageItem> batteryUsageList;
  QQBatteryMonitor.IBatteryStatsCallback callback;
  private CmdMonitor cmdMonitor;
  private BatteryConfig globalConfig;
  private GpsMonitor gpsMonitor;
  private boolean hasAppBg5Min = false;
  private boolean hasCleanLog = false;
  private boolean isBackground = false;
  private LogMonitor logMonitor;
  private int notRealseCount = 0;
  private int status = -1;
  private Handler subHandler = new Handler(ThreadManager.getBatteryThreadLooper(), this);
  private WakeLockMonitor wakeLockMonitor;
  private WifiMonitor wifiMonitor;
  
  static
  {
    long l;
    if (Logger.debug) {
      l = 14400000L;
    } else {
      l = 86400000L;
    }
    REPORT_INTERVAL = l;
  }
  
  private QQBatteryMonitor()
  {
    LifecycleCallback.INSTANCE.register(this.batteryForeCallback);
  }
  
  private void addData(String paramString, int[] paramArrayOfInt, String[] paramArrayOfString, JSONArray paramJSONArray)
  {
    int j = (int)(Long.valueOf(paramArrayOfString[0]).longValue() / 1000L);
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 1972926683: 
      if (paramString.equals("bg5LogCount")) {
        i = 7;
      }
      break;
    case 1970971165: 
      if (paramString.equals("bg5LogAlarm")) {
        i = 17;
      }
      break;
    case 1916349170: 
      if (paramString.equals("bg5SysCount")) {
        i = 9;
      }
      break;
    case 1816281026: 
      if (paramString.equals("bg5WlUse")) {
        i = 22;
      }
      break;
    case 1714831230: 
      if (paramString.equals("bg5WFLDetail")) {
        i = 25;
      }
      break;
    case 1672620170: 
      if (paramString.equals("bg5WlCount")) {
        i = 19;
      }
      break;
    case 1606608037: 
      if (paramString.equals("bg5CmdCount")) {
        i = 5;
      }
      break;
    case 1604652519: 
      if (paramString.equals("bg5CmdAlarm")) {
        i = 15;
      }
      break;
    case 1458842236: 
      if (paramString.equals("fg30WlCount")) {
        i = 18;
      }
      break;
    case 1363475611: 
      if (paramString.equals("bg5WFSCount")) {
        i = 13;
      }
      break;
    case 1163071554: 
      if (paramString.equals("bg5WFLCount")) {
        i = 21;
      }
      break;
    case 779747601: 
      if (paramString.equals("wflNotRelease")) {
        i = 28;
      }
      break;
    case 229607845: 
      if (paramString.equals("bg5SdkCount")) {
        i = 8;
      }
      break;
    case 55258039: 
      if (paramString.equals("fg30WFSDetail")) {
        i = 33;
      }
      break;
    case 14469184: 
      if (paramString.equals("fg30SysDetail")) {
        i = 32;
      }
      break;
    case -359221975: 
      if (paramString.equals("fg30LogCount")) {
        i = 6;
      }
      break;
    case -361177493: 
      if (paramString.equals("fg30LogAlarm")) {
        i = 16;
      }
      break;
    case -415799488: 
      if (paramString.equals("fg30SysCount")) {
        i = 11;
      }
      break;
    case -662577595: 
      if (paramString.equals("bg5WFSDetail")) {
        i = 34;
      }
      break;
    case -703366450: 
      if (paramString.equals("bg5SysDetail")) {
        i = 30;
      }
      break;
    case -725540621: 
      if (paramString.equals("fg30CmdCount")) {
        i = 4;
      }
      break;
    case -727496139: 
      if (paramString.equals("fg30CmdAlarm")) {
        i = 14;
      }
      break;
    case -734904339: 
      if (paramString.equals("fg30SdkDetail")) {
        i = 31;
      }
      break;
    case -743019316: 
      if (paramString.equals("wlTimeout")) {
        i = 27;
      }
      break;
    case -765594007: 
      if (paramString.equals("wlNotRelease")) {
        i = 26;
      }
      break;
    case -966488598: 
      if (paramString.equals("fg30Trf")) {
        i = 2;
      }
      break;
    case -966504982: 
      if (paramString.equals("fg30Cpu")) {
        i = 0;
      }
      break;
    case -968673047: 
      if (paramString.equals("fg30WFSCount")) {
        i = 12;
      }
      break;
    case -1080027596: 
      if (paramString.equals("fg30WlUse")) {
        i = 23;
      }
      break;
    case -1169077104: 
      if (paramString.equals("fg30WFLCount")) {
        i = 20;
      }
      break;
    case -1392524552: 
      if (paramString.equals("bg5Trf")) {
        i = 3;
      }
      break;
    case -1392540936: 
      if (paramString.equals("bg5Cpu")) {
        i = 1;
      }
      break;
    case -1452739973: 
      if (paramString.equals("bg5SdkDetail")) {
        i = 29;
      }
      break;
    case -1862300432: 
      if (paramString.equals("fg30WFLDetail")) {
        i = 24;
      }
      break;
    case -2102540813: 
      if (paramString.equals("fg30SdkCount")) {
        i = 10;
      }
      break;
    }
    int i = -1;
    switch (i)
    {
    default: 
      break;
    case 29: 
    case 30: 
    case 31: 
    case 32: 
    case 33: 
    case 34: 
      paramString = handleGpsOrWifiScan(paramArrayOfString);
      break;
    case 26: 
    case 27: 
    case 28: 
      i = this.notRealseCount;
      if (i <= 10)
      {
        this.notRealseCount = (i + 1);
        paramString = handleWakeLock(paramArrayOfString, j);
      }
      break;
    case 22: 
    case 23: 
    case 24: 
    case 25: 
      paramString = handleWakeLockAndWifi(paramArrayOfString, j);
      break;
    case 18: 
    case 19: 
    case 20: 
    case 21: 
      paramString = handleWakeLockWifiLock(paramArrayOfString, j);
      break;
    case 14: 
    case 15: 
    case 16: 
    case 17: 
      paramString = handlerLogOrCmdDataAlarm(paramString, paramArrayOfString);
      break;
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
      paramString = handlerLogOrCmdData(j, paramArrayOfString);
      break;
    case 2: 
    case 3: 
      paramString = handlerTrafficData(j, paramArrayOfString);
      break;
    case 1: 
      paramArrayOfInt[1] += 1;
      paramString = handlerCpuData(j, paramArrayOfString);
      break;
    case 0: 
      paramArrayOfInt[0] += 1;
      paramString = handlerCpuData(j, paramArrayOfString);
      break;
    }
    paramString = null;
    if (paramString != null) {
      paramJSONArray.put(paramString);
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
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      JSONObject localJSONObject = new JSONObject();
      localObject = handlerAllData(localJSONObject, (List)localObject);
      if ((localObject[0] > 0) || (localObject[1] > 0)) {
        doReport(false, null, localJSONObject);
      }
      return;
    }
    Logger.INSTANCE.e(new String[] { "QAPM_battery_BatteryMonitor", "battery report, but reportLogFile is null" });
  }
  
  private void doReport(boolean paramBoolean, String paramString, JSONObject paramJSONObject)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (paramBoolean) {
        localJSONObject.put("fileObj", paramString);
      } else {
        localJSONObject.put("batterydata", paramJSONObject);
      }
      localJSONObject.put("plugin", PluginCombination.qqBatteryPlugin.plugin);
      paramString = new ResultObject(0, "Battery target", true, 1L, 1L, JsonDispose.copyJson(BaseInfo.pubJson, localJSONObject), true, true, BaseInfo.userMeta.uin);
      ReporterMachine.INSTANCE.addResultObj(paramString);
      return;
    }
    catch (Exception paramString)
    {
      Logger.INSTANCE.exception("QAPM_battery_BatteryMonitor", paramString);
    }
  }
  
  public static QQBatteryMonitor getInstance()
  {
    if (instance == null) {
      try
      {
        if (instance == null) {
          instance = new QQBatteryMonitor();
        }
      }
      finally {}
    }
    return instance;
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
    int i = 3;
    int[] arrayOfInt = new int[3];
    int[] tmp9_7 = arrayOfInt;
    tmp9_7[0] = 0;
    int[] tmp13_9 = tmp9_7;
    tmp13_9[1] = 0;
    int[] tmp17_13 = tmp13_9;
    tmp17_13[2] = 500;
    tmp17_13;
    for (;;)
    {
      try
      {
        paramJSONObject.put("device", Build.MODEL);
        paramJSONObject.put("sdk", Build.VERSION.SDK_INT);
        paramJSONObject.put("uin", BaseInfo.userMeta.uin);
        if (!Logger.debug) {
          break label145;
        }
        paramList = paramList.iterator();
        if (paramList.hasNext())
        {
          FileUtil.readStreamByLine((File)paramList.next(), new QQBatteryMonitor.1(this, arrayOfInt, i, paramJSONObject));
          if (arrayOfInt[0] < i) {
            continue;
          }
          int j = arrayOfInt[1];
          if (j < i) {
            continue;
          }
          return arrayOfInt;
        }
      }
      catch (Throwable paramJSONObject)
      {
        Logger.INSTANCE.exception("QAPM_battery_BatteryMonitor", paramJSONObject);
      }
      return arrayOfInt;
      label145:
      i = 2;
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
    if ((!paramString.equals("fg30LogAlarm")) && (!paramString.equals("bg5LogAlarm"))) {
      localJSONObject1.put("cmd", localObject);
    } else {
      localJSONObject1.put("log", localObject);
    }
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
    if (debug)
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
    if (debug) {
      l = 20000L;
    } else {
      l = 1800000L;
    }
    ((Handler)localObject).sendEmptyMessageDelayed(4, l);
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
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5) {
              return true;
            }
            paramMessage = this.batteryUsageList;
            if (paramMessage != null) {
              try
              {
                paramMessage = paramMessage.iterator();
                while (paramMessage.hasNext()) {
                  ((BatteryUsageItem)paramMessage.next()).onProcessBG5Min();
                }
                this.hasAppBg5Min = true;
              }
              catch (Exception paramMessage)
              {
                Logger.INSTANCE.exception("QAPM_battery_BatteryMonitor", paramMessage);
              }
            }
            return true;
          }
          paramMessage = this.batteryUsageList;
          if (paramMessage != null) {
            try
            {
              paramMessage = paramMessage.iterator();
              while (paramMessage.hasNext()) {
                ((BatteryUsageItem)paramMessage.next()).onProcessRun30Min();
              }
              paramMessage = this.batteryUsageList;
            }
            catch (Exception paramMessage)
            {
              Logger.INSTANCE.exception("QAPM_battery_BatteryMonitor", paramMessage);
              return true;
            }
          }
        }
        else
        {
          if (paramMessage != null)
          {
            paramMessage = paramMessage.iterator();
            while (paramMessage.hasNext()) {
              ((BatteryUsageItem)paramMessage.next()).stop();
            }
          }
          this.status = 0;
          return true;
        }
      }
      else
      {
        initConfig();
        if (this.globalConfig.reportfile)
        {
          long l1;
          if (BaseInfo.sharePreference != null) {
            l1 = BaseInfo.sharePreference.getLong("battery_report_timestamp", 0L);
          } else {
            l1 = 0L;
          }
          if ((Math.abs(System.currentTimeMillis() - l1) <= REPORT_INTERVAL) && (!debug))
          {
            Logger.INSTANCE.i(new String[] { "QAPM_battery_BatteryMonitor", "battery want report, but interval is short" });
          }
          else
          {
            long l3 = System.currentTimeMillis();
            long l2 = l3;
            if (!debug)
            {
              l2 = l3;
              if (BatteryConstants.BATTERY_START_TIME != 0L) {
                l2 = BatteryConstants.BATTERY_START_TIME - 60000L;
              }
            }
            doQuickJsonReport(l1, l2);
            if (Logger.debug) {
              i = 50;
            } else {
              i = 300;
            }
            double d = i;
            Double.isNaN(d);
            float f = (float)(1.0D / d);
            if ((Math.random() < f) || (debug)) {
              doQuickFileReport(l1, l2);
            }
            BaseInfo.editor.putLong("battery_report_timestamp", l2).commit();
          }
        }
        else
        {
          Logger.INSTANCE.i(new String[] { "QAPM_battery_BatteryMonitor", "battery report switch is off" });
        }
        BatteryLog.cleanStorage(BatteryConstants.BATTERY_START_TIME - 172800000L);
        this.hasCleanLog = true;
        return true;
      }
    }
    else if (this.status == -1) {
      BatteryConstants.BATTERY_START_TIME = System.currentTimeMillis();
    }
    try
    {
      initConfig();
      startMonitorInner();
      return true;
    }
    catch (Exception paramMessage)
    {
      label461:
      break label461;
    }
    this.status = 0;
    return true;
  }
  
  public boolean isHasAppBg5Min()
  {
    return this.hasAppBg5Min;
  }
  
  public void onAppBackground()
  {
    if (!this.isBackground)
    {
      if (this.status != 1) {
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
        long l;
        if (debug) {
          l = 20000L;
        } else {
          l = 300000L;
        }
        ((Handler)localObject).sendEmptyMessageDelayed(5, l);
      }
      if ((!this.hasCleanLog) || (debug)) {
        this.subHandler.sendEmptyMessageDelayed(2, 200L);
      }
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
    if (this.status == 1)
    {
      CmdMonitor localCmdMonitor = this.cmdMonitor;
      if (localCmdMonitor == null) {
        return;
      }
      localCmdMonitor.onCmdRequest(paramString);
    }
  }
  
  public void onGpsScan(String paramString, Object[] paramArrayOfObject)
  {
    GpsMonitor localGpsMonitor = this.gpsMonitor;
    if (localGpsMonitor != null) {
      localGpsMonitor.onGpsScan(paramString, paramArrayOfObject);
    }
  }
  
  public void onPrintLog(String paramString) {}
  
  public void onWriteLog(String paramString1, String paramString2)
  {
    if (this.status == 1)
    {
      LogMonitor localLogMonitor = this.logMonitor;
      if (localLogMonitor == null) {
        return;
      }
      localLogMonitor.onWriteLog(paramString1, paramString2);
    }
  }
  
  public void setCallback(QQBatteryMonitor.IBatteryStatsCallback paramIBatteryStatsCallback)
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
  
  public void setListener(@NonNull IBaseListener paramIBaseListener) {}
  
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
    if (!PluginController.INSTANCE.whetherPluginSampling(PluginCombination.qqBatteryPlugin.plugin))
    {
      Logger.INSTANCE.i(new String[] { "QAPM_battery_BatteryMonitor", "BatteryMonitor loose" });
      return;
    }
    Handler localHandler = this.subHandler;
    if (localHandler != null) {
      localHandler.sendEmptyMessage(0);
    }
  }
  
  public void stop()
  {
    if (this.status != 0)
    {
      Handler localHandler = this.subHandler;
      if (localHandler != null) {
        localHandler.sendEmptyMessage(3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.qqbattery.QQBatteryMonitor
 * JD-Core Version:    0.7.0.1
 */