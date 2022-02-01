package com.tencent.qapmsdk.qqbattery.monitor;

import android.app.Application;
import android.location.Criteria;
import android.location.LocationManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qapmsdk.base.meta.BaseInfo;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.thread.ThreadTool;
import com.tencent.qapmsdk.qqbattery.BatteryUsageItem;
import com.tencent.qapmsdk.qqbattery.HighFrequencyDetector;
import com.tencent.qapmsdk.qqbattery.IBatteryListener;
import com.tencent.qapmsdk.qqbattery.QQBatteryMonitor;
import com.tencent.qapmsdk.qqbattery.config.GpsMeta;
import java.lang.reflect.Member;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GpsMonitor
  extends BatteryUsageItem
  implements HookMethodCallback
{
  public static final String BG_5_SDK_COUNT = "bg5SdkCount";
  public static final String BG_5_SDK_DETAIL = "bg5SdkDetail";
  public static final String BG_5_SYS_COUNT = "bg5SysCount";
  public static final String BG_5_SYS_DETAIL = "bg5SysDetail";
  public static final String FG_30_SDK_COUNT = "fg30SdkCount";
  public static final String FG_30_SDK_DETAIL = "fg30SdkDetail";
  public static final String FG_30_SYS_COUNT = "fg30SysCount";
  public static final String FG_30_SYS_DETAIL = "fg30SysDetail";
  private static final String KEY_STACK = "key_stack";
  private static final String KEY_TYPE = "key_type";
  private static final String REQUEST_METHOD_0 = "requestLocationUpdates";
  private static final String REQUEST_METHOD_1 = "requestSingleUpdate";
  public static final String REQUEST_SOSO = "requestSoso";
  private static final String TAG = "QAPM_battery_GPS";
  private Map<String, HashSet<Long>> bg5MinSdkMap = new HashMap();
  private Map<String, HashSet<Long>> bg5MinSysMap = new HashMap();
  private String blackClassName = null;
  private HighFrequencyDetector detector1;
  private HighFrequencyDetector detector2;
  private Map<String, HashSet<Long>> fg30MinSdkMap = new HashMap();
  private Map<String, HashSet<Long>> fg30MinSysMap = new HashMap();
  private LocationManager locationMgr = (LocationManager)BaseInfo.app.getSystemService("location");
  private long longTime = 18000000L;
  private int maxCallTimeInLongTime = 10;
  private int maxCallTimeInShortTime = 3;
  private long shortTime = 900000L;
  
  public GpsMonitor(GpsMeta paramGpsMeta)
  {
    this.maxCallTimeInShortTime = paramGpsMeta.maxCallTimeInShortTime;
    this.shortTime = paramGpsMeta.shortTime;
    this.maxCallTimeInLongTime = paramGpsMeta.maxCallTimeInLongTime;
    this.longTime = paramGpsMeta.longTime;
    this.detector1 = new HighFrequencyDetector(this.maxCallTimeInShortTime, this.shortTime);
    this.detector2 = new HighFrequencyDetector(this.maxCallTimeInLongTime, this.longTime);
  }
  
  private int getGpsState()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void afterHookedMethod(MethodHookParam paramMethodHookParam) {}
  
  public void beforeHookedMethod(MethodHookParam paramMethodHookParam)
  {
    onGpsScan(paramMethodHookParam.method.getName(), paramMethodHookParam.args);
  }
  
  public void onAppBackground()
  {
    super.onAppBackground();
    synchronized (this.fg30MinSdkMap)
    {
      this.bg5MinSdkMap.clear();
      this.bg5MinSysMap.clear();
      return;
    }
  }
  
  public void onGpsScan(String paramString, Object[] paramArrayOfObject)
  {
    if (!this.isRunning) {
      return;
    }
    String str2 = getAppStack().toString();
    if (Logger.debug)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGPSScan: ");
      ((StringBuilder)localObject).append(str2);
      printLog(((StringBuilder)localObject).toString());
    }
    Object localObject = QQBatteryMonitor.batteryReportListener;
    if ((localObject != null) && (this.blackClassName == null)) {
      this.blackClassName = ((IBatteryListener)localObject).getBlackClassName();
    }
    int i;
    if ((!"requestLocationUpdates".equals(paramString)) && (!"requestSingleUpdate".equals(paramString))) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      if ((!TextUtils.isEmpty(this.blackClassName)) && (str2.contains(this.blackClassName))) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        return;
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("location|");
    ((StringBuilder)localObject).append(getGpsState());
    ((StringBuilder)localObject).append("|");
    String str3 = ((StringBuilder)localObject).toString();
    if ("requestLocationUpdates".equals(paramString))
    {
      if (paramArrayOfObject.length == 5)
      {
        if ((paramArrayOfObject[2] instanceof Criteria)) {
          writeCommonLog(new String[] { str3, "0", "|", "0", "|", "{", paramArrayOfObject[0].toString(), "#", paramArrayOfObject[1].toString(), "#", "[", this.locationMgr.getBestProvider((Criteria)paramArrayOfObject[2], true), ",", String.valueOf(((Criteria)paramArrayOfObject[2]).getAccuracy()), ",", String.valueOf(((Criteria)paramArrayOfObject[2]).getPowerRequirement()), "]", "}", "|", str2 });
        } else if ((paramArrayOfObject[0] instanceof String)) {
          writeCommonLog(new String[] { str3, "0", "|", "1", "|", "{", paramArrayOfObject[0].toString(), "#", paramArrayOfObject[1].toString(), "#", paramArrayOfObject[2].toString(), "}", "|", str2 });
        } else {
          writeCommonLog(new String[] { str3, "0", "|", "-1", "|", "{}", "|", str2 });
        }
      }
      else if (paramArrayOfObject.length == 6) {
        if ((paramArrayOfObject[2] instanceof Criteria)) {
          writeCommonLog(new String[] { str3, "0", "|", "2", "|", "{", paramArrayOfObject[0].toString(), "#", paramArrayOfObject[1].toString(), "#", "[", this.locationMgr.getBestProvider((Criteria)paramArrayOfObject[2], true), ",", String.valueOf(((Criteria)paramArrayOfObject[2]).getAccuracy()), ",", String.valueOf(((Criteria)paramArrayOfObject[2]).getPowerRequirement()), "]", "}", "|", str2 });
        } else if ((paramArrayOfObject[0] instanceof String)) {
          writeCommonLog(new String[] { str3, "0", "|", "3", "|", "{", paramArrayOfObject[0].toString(), "#", paramArrayOfObject[1].toString(), "#", paramArrayOfObject[2].toString(), "}", "|", str2 });
        } else {
          writeCommonLog(new String[] { str3, "0", "|", "-1", "|", "{}", "|", str2 });
        }
      }
      paramString = new Bundle();
      paramString.putInt("key_action", 2);
      paramString.putString("key_stack", str2);
      onOtherProcReport(paramString);
    }
    else if ("requestSingleUpdate".equals(paramString))
    {
      if ((paramArrayOfObject[0] instanceof String)) {
        writeCommonLog(new String[] { str3, "1", "|", "0", "|", "{", paramArrayOfObject[0].toString(), "}", "|", str2 });
      } else if ((paramArrayOfObject[0] instanceof Criteria)) {
        writeCommonLog(new String[] { str3, "1", "|", "1", "|", "{", "[", this.locationMgr.getBestProvider((Criteria)paramArrayOfObject[0], true), ",", String.valueOf(((Criteria)paramArrayOfObject[0]).getAccuracy()), ",", String.valueOf(((Criteria)paramArrayOfObject[0]).getPowerRequirement()), "]", "}", "|", str2 });
      } else {
        writeCommonLog(new String[] { str3, "1", "|", "-1", "|", "{}", "|", str2 });
      }
      paramString = new Bundle();
      paramString.putInt("key_action", 2);
      paramString.putString("key_stack", str2);
      onOtherProcReport(paramString);
    }
    else if ("requestSoso".equals(paramString))
    {
      if (paramArrayOfObject[2] == null) {
        paramString = "none";
      } else {
        paramString = paramArrayOfObject[2].toString();
      }
      String str4 = paramArrayOfObject[0].toString();
      String str5 = paramArrayOfObject[1].toString();
      if (paramArrayOfObject[3] == null) {
        localObject = "-1";
      } else {
        localObject = paramArrayOfObject[3].toString();
      }
      String str1;
      if (paramArrayOfObject[4] == null) {
        str1 = "-1";
      } else {
        str1 = paramArrayOfObject[4].toString();
      }
      writeCommonLog(new String[] { str3, "2", "|", "0", "|", "{", str4, "#", str5, "#", paramString, "#", localObject, "#", str1, "#", paramArrayOfObject[5].toString(), "}", "|", str2 });
      paramArrayOfObject = new Bundle();
      paramArrayOfObject.putInt("key_action", 1);
      paramArrayOfObject.putString("key_type", paramString);
      onOtherProcReport(paramArrayOfObject);
    }
    paramString = this.detector1.onAction(str2);
    if ((paramString != null) && (paramString.size() > 0))
    {
      paramArrayOfObject = new StringBuilder();
      paramArrayOfObject.append("GPS request update is too frequently(");
      paramArrayOfObject.append(this.maxCallTimeInShortTime);
      paramArrayOfObject.append(" in ");
      paramArrayOfObject.append(this.shortTime / 60L / 1000L);
      paramArrayOfObject.append(" seconds");
      onUsageAlarm(6, 0, 0, paramArrayOfObject.toString(), HighFrequencyDetector.getDescription(paramString));
      this.detector1.trimCache();
    }
    paramString = this.detector2.onAction(str2);
    if ((paramString != null) && (paramString.size() > 0))
    {
      paramArrayOfObject = new StringBuilder();
      paramArrayOfObject.append("Wifi scan is too frequently(");
      paramArrayOfObject.append(this.maxCallTimeInLongTime);
      paramArrayOfObject.append(" in ");
      paramArrayOfObject.append(this.longTime / 60L / 1000L);
      paramArrayOfObject.append(" seconds");
      onUsageAlarm(6, 0, 0, paramArrayOfObject.toString(), HighFrequencyDetector.getDescription(paramString));
      this.detector2.trimCache();
    }
  }
  
  public void onOtherProcReport(Bundle paramBundle)
  {
    int i = paramBundle.getInt("key_action");
    Object localObject2;
    Map localMap;
    if ((i == 1) || (i == 2))
    {
      localObject1 = Logger.INSTANCE;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append(", type=");
      ((Logger)localObject1).d(new String[] { "QAPM_battery_GPS", "GPS.onOtherProcReport:action=", ((StringBuilder)localObject2).toString(), paramBundle.getString("key_type"), ", stack=", paramBundle.getString("key_stack") });
      if (this.isRunning)
      {
        localMap = this.fg30MinSdkMap;
        if (i != 1) {
          break label301;
        }
      }
    }
    label301:
    for (Object localObject1 = "key_type";; localObject1 = "key_stack")
    {
      try
      {
        String str = paramBundle.getString((String)localObject1);
        if (this.isBeforeRun30Min)
        {
          if (i == 1) {
            paramBundle = this.fg30MinSdkMap;
          } else {
            paramBundle = this.fg30MinSysMap;
          }
          localObject2 = (HashSet)paramBundle.get(str);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = new HashSet();
            paramBundle.put(str, localObject1);
          }
          ((HashSet)localObject1).add(Long.valueOf(System.currentTimeMillis()));
        }
        if ((this.isAppBackground) && (this.isInFirstBg5min))
        {
          if (i == 1) {
            paramBundle = this.bg5MinSdkMap;
          } else {
            paramBundle = this.bg5MinSysMap;
          }
          localObject2 = (HashSet)paramBundle.get(str);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = new HashSet();
            paramBundle.put(str, localObject1);
          }
          ((HashSet)localObject1).add(Long.valueOf(System.currentTimeMillis()));
        }
        return;
      }
      finally {}
      return;
    }
  }
  
  public void onProcessBG5Min()
  {
    super.onProcessBG5Min();
    if (this.isRunning) {
      synchronized (this.fg30MinSdkMap)
      {
        Iterator localIterator1 = this.bg5MinSdkMap.values().iterator();
        int i = 0;
        while (localIterator1.hasNext()) {
          i += ((HashSet)localIterator1.next()).size();
        }
        localIterator1 = this.bg5MinSysMap.values().iterator();
        int j = 0;
        while (localIterator1.hasNext()) {
          j += ((HashSet)localIterator1.next()).size();
        }
        writeReportLog(new String[] { "bg5SdkCount", "|", String.valueOf(i) });
        writeReportLog(new String[] { "bg5SysCount", "|", String.valueOf(j) });
        localIterator1 = this.bg5MinSdkMap.keySet().iterator();
        String str;
        Object localObject2;
        Object localObject3;
        while (localIterator1.hasNext())
        {
          str = (String)localIterator1.next();
          localObject2 = (HashSet)this.bg5MinSdkMap.get(str);
          localObject3 = ThreadTool.getReuseStringBuilder();
          Iterator localIterator2 = ((HashSet)localObject2).iterator();
          i = 0;
          while (localIterator2.hasNext())
          {
            ((StringBuilder)localObject3).append((Long)localIterator2.next());
            j = i + 1;
            i = j;
            if (j < ((HashSet)localObject2).size())
            {
              ((StringBuilder)localObject3).append("#");
              i = j;
            }
          }
          writeReportLog(new String[] { "bg5SdkDetail", "|", str, "|", ((StringBuilder)localObject3).toString() });
        }
        localIterator1 = this.bg5MinSysMap.keySet().iterator();
        while (localIterator1.hasNext())
        {
          str = (String)localIterator1.next();
          localObject3 = (HashSet)this.bg5MinSysMap.get(str);
          localObject2 = ThreadTool.getReuseStringBuilder();
          localObject3 = ((HashSet)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            ((StringBuilder)localObject2).append((Long)((Iterator)localObject3).next());
            ((StringBuilder)localObject2).append("|");
          }
          writeReportLog(new String[] { "bg5SysDetail", "|", str, "|", ((StringBuilder)localObject2).toString() });
        }
        this.bg5MinSdkMap.clear();
        this.bg5MinSysMap.clear();
        return;
      }
    }
  }
  
  public void onProcessRun30Min()
  {
    super.onProcessRun30Min();
    if (this.isRunning) {
      synchronized (this.fg30MinSdkMap)
      {
        Iterator localIterator1 = this.fg30MinSdkMap.values().iterator();
        int i = 0;
        while (localIterator1.hasNext()) {
          i += ((HashSet)localIterator1.next()).size();
        }
        localIterator1 = this.fg30MinSysMap.values().iterator();
        int j = 0;
        while (localIterator1.hasNext()) {
          j += ((HashSet)localIterator1.next()).size();
        }
        writeReportLog(new String[] { "fg30SdkCount", "|", String.valueOf(i) });
        writeReportLog(new String[] { "fg30SysCount", "|", String.valueOf(j) });
        localIterator1 = this.fg30MinSdkMap.keySet().iterator();
        String str;
        Object localObject2;
        Object localObject3;
        while (localIterator1.hasNext())
        {
          str = (String)localIterator1.next();
          localObject2 = (HashSet)this.fg30MinSdkMap.get(str);
          localObject3 = ThreadTool.getReuseStringBuilder();
          Iterator localIterator2 = ((HashSet)localObject2).iterator();
          i = 0;
          while (localIterator2.hasNext())
          {
            ((StringBuilder)localObject3).append((Long)localIterator2.next());
            j = i + 1;
            i = j;
            if (j < ((HashSet)localObject2).size())
            {
              ((StringBuilder)localObject3).append("#");
              i = j;
            }
          }
          writeReportLog(new String[] { "fg30SdkDetail", "|", str, "|", ((StringBuilder)localObject3).toString() });
        }
        localIterator1 = this.fg30MinSysMap.keySet().iterator();
        while (localIterator1.hasNext())
        {
          str = (String)localIterator1.next();
          localObject3 = (HashSet)this.fg30MinSysMap.get(str);
          localObject2 = ThreadTool.getReuseStringBuilder();
          localObject3 = ((HashSet)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            ((StringBuilder)localObject2).append((Long)((Iterator)localObject3).next());
            ((StringBuilder)localObject2).append("|");
          }
          writeReportLog(new String[] { "fg30SysDetail", "|", str, "|", ((StringBuilder)localObject2).toString() });
        }
        this.fg30MinSdkMap.clear();
        this.fg30MinSysMap.clear();
        return;
      }
    }
  }
  
  public void onProcessStart() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.qqbattery.monitor.GpsMonitor
 * JD-Core Version:    0.7.0.1
 */