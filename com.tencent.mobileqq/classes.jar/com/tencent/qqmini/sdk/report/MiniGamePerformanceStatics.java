package com.tencent.qqmini.sdk.report;

import android.os.Debug;
import android.os.Debug.MemoryInfo;
import android.os.Handler;
import android.os.SystemClock;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy.BeaconReportCategory;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.monitor.common.ProcessStats;
import com.tencent.qqmini.sdk.statistics.AverageStatistics;
import com.tencent.qqmini.sdk.statistics.MaxStatistics;
import com.tencent.qqmini.sdk.statistics.VarianceStatistics;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MiniGamePerformanceStatics
{
  private static final String EVENT_FILE_API_TIME_COST = "mini_game_file_api_time_cost";
  private static final String KEY_API_NAME = "apiName";
  private static final String KEY_APP_ID = "appId";
  private static final String KEY_IS_SDK = "isSdk";
  private static final String KEY_IS_SUCCESS = "isSuccess";
  private static final String KEY_QUA = "qua";
  private static final String KEY_WAITING_TIME = "waitingTime";
  private static final String KEY_WORKING_TIME = "workingTime";
  private static final long STATICS_INTERVAL_MS = 10000L;
  private static volatile MiniGamePerformanceStatics instance;
  private ConcurrentHashMap<String, Integer> fileApiFailCountMap = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Double> fileApiFailTimeCostMap = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Integer> fileApiSuccessCountMap = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Double> fileApiSuccessTimeCostMap = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Double> fileApiWaitingTimeMap = new ConcurrentHashMap();
  private String jsVersion;
  private final AverageStatistics mAverageFps = new AverageStatistics();
  private final AverageStatistics mAverageMemory = new AverageStatistics();
  private final VarianceStatistics mFpsVariance = new VarianceStatistics(200);
  private final MaxStatistics mMaxMemory = new MaxStatistics();
  private final Debug.MemoryInfo mMemoryInfo = new Debug.MemoryInfo();
  private long mStartCpuTime;
  private float mStartMemory;
  private long mStartTimeMillis;
  private final Runnable mStaticsRunnable = new MiniGamePerformanceStatics.1(this);
  private MiniAppInfo miniAppInfo;
  private String tritonVersion;
  
  private void doReport()
  {
    if (this.miniAppInfo != null)
    {
      long l = SystemClock.uptimeMillis() - this.mStartTimeMillis;
      if (l < 10000L)
      {
        reset();
        return;
      }
      Object localObject = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
      float f3 = (float)(ProcessStats.collectCpuUsage("-1") - this.mStartCpuTime) / ((float)l / 1000.0F);
      float f4 = this.mAverageMemory.calculate();
      float f5 = this.mMaxMemory.calculate() - this.mStartMemory;
      float f1;
      float f2;
      if (this.miniAppInfo.isReportTypeMiniGame())
      {
        f1 = this.mAverageFps.calculate();
        f2 = this.mFpsVariance.calculate();
        MiniReportManager.reportEventType(this.miniAppInfo, 629, toString(f3), "1");
        MiniReportManager.reportEventType(this.miniAppInfo, 631, toString(f4), "1");
        MiniReportManager.reportEventType(this.miniAppInfo, 643, toString(f5), "1");
        MiniReportManager.reportEventType(this.miniAppInfo, 630, toString(f1), "1");
        MiniReportManager.reportEventType(this.miniAppInfo, 642, toString(f2), "1");
        MiniProgramLpReportDC04902.reportGameEnd(f1, f2, this.jsVersion, this.tritonVersion);
        if (((MiniAppProxy)localObject).isDebugVersion())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("cpu:");
          ((StringBuilder)localObject).append(f3);
          ((StringBuilder)localObject).append(" avgMemory:");
          ((StringBuilder)localObject).append(f4);
          ((StringBuilder)localObject).append(" memoryGrowth:");
          ((StringBuilder)localObject).append(f5);
          ((StringBuilder)localObject).append(" avgFps:");
          ((StringBuilder)localObject).append(f1);
          ((StringBuilder)localObject).append(" fpsVariance:");
          ((StringBuilder)localObject).append(f2);
          ((StringBuilder)localObject).append(" dalivkPss:");
          ((StringBuilder)localObject).append(this.mMemoryInfo.dalvikPss);
          ((StringBuilder)localObject).append(" nativePss:");
          ((StringBuilder)localObject).append(this.mMemoryInfo.nativePss);
          ((StringBuilder)localObject).append(" otherPss:");
          ((StringBuilder)localObject).append(this.mMemoryInfo.otherPss);
          ((StringBuilder)localObject).append(" totalPss:");
          ((StringBuilder)localObject).append(this.mMemoryInfo.getTotalPss());
          QMLog.i("MiniGamePerformance", ((StringBuilder)localObject).toString());
        }
      }
      else
      {
        MiniReportManager.reportEventType(this.miniAppInfo, 629, toString(f3), MiniReportManager.getAppType(this.miniAppInfo));
        MiniReportManager.reportEventType(this.miniAppInfo, 631, toString(f4), MiniReportManager.getAppType(this.miniAppInfo));
        MiniReportManager.reportEventType(this.miniAppInfo, 643, toString(f5), MiniReportManager.getAppType(this.miniAppInfo));
        if (((MiniAppProxy)localObject).isDebugVersion())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("cpu:");
          ((StringBuilder)localObject).append(f3);
          ((StringBuilder)localObject).append(" avgMemory:");
          ((StringBuilder)localObject).append(f4);
          ((StringBuilder)localObject).append(" memoryGrowth:");
          ((StringBuilder)localObject).append(f5);
          ((StringBuilder)localObject).append(" dalivkPss:");
          ((StringBuilder)localObject).append(this.mMemoryInfo.dalvikPss);
          ((StringBuilder)localObject).append(" nativePss:");
          ((StringBuilder)localObject).append(this.mMemoryInfo.nativePss);
          ((StringBuilder)localObject).append(" otherPss:");
          ((StringBuilder)localObject).append(this.mMemoryInfo.otherPss);
          ((StringBuilder)localObject).append(" totalPss:");
          ((StringBuilder)localObject).append(this.mMemoryInfo.getTotalPss());
          QMLog.i("MiniGamePerformance", ((StringBuilder)localObject).toString());
        }
        f1 = 0.0F;
        f2 = 0.0F;
      }
      MiniProgramLpReportDC05115.reportCPUMemoryFPS(this.miniAppInfo, f3, f4, f5, f1, f2);
      reportFileApiTimeCost();
    }
    reset();
  }
  
  private void doReportFileApiTimeCost(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private int getFileApiCount(String paramString, boolean paramBoolean)
  {
    ConcurrentHashMap localConcurrentHashMap;
    if (paramBoolean) {
      localConcurrentHashMap = this.fileApiSuccessCountMap;
    } else {
      localConcurrentHashMap = this.fileApiFailCountMap;
    }
    paramString = (Integer)localConcurrentHashMap.get(paramString);
    if (paramString == null) {
      return 0;
    }
    return paramString.intValue();
  }
  
  public static MiniGamePerformanceStatics getInstance()
  {
    if (instance == null) {
      try
      {
        if (instance == null) {
          instance = new MiniGamePerformanceStatics();
        }
      }
      finally {}
    }
    return instance;
  }
  
  private float getProcessPssMemory()
  {
    Debug.getMemoryInfo(this.mMemoryInfo);
    return this.mMemoryInfo.getTotalPss() / 1024.0F;
  }
  
  private void report(String paramString, Map<String, String> paramMap)
  {
    ChannelProxy localChannelProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
    if (localChannelProxy != null) {
      localChannelProxy.reportBeacon(ChannelProxy.BeaconReportCategory.MINI_GAME, paramString, paramMap);
    }
  }
  
  private void reportFileApiTimeCost()
  {
    doReportFileApiTimeCost(true);
    doReportFileApiTimeCost(false);
  }
  
  private void reset()
  {
    this.mAverageMemory.reset();
    this.mAverageFps.reset();
    this.mFpsVariance.reset();
    this.mStartCpuTime = ProcessStats.collectCpuUsage("-1");
    this.mStartTimeMillis = SystemClock.uptimeMillis();
    this.fileApiSuccessCountMap.clear();
    this.fileApiFailCountMap.clear();
    this.fileApiWaitingTimeMap.clear();
    this.fileApiSuccessTimeCostMap.clear();
    this.fileApiFailTimeCostMap.clear();
  }
  
  private static String toString(float paramFloat)
  {
    return String.format(Locale.US, "%.1f", new Object[] { Float.valueOf(paramFloat) });
  }
  
  private void updateWaitingTime(String paramString, long paramLong)
  {
    Object localObject = (Double)this.fileApiWaitingTimeMap.get(paramString);
    if (localObject == null)
    {
      localObject = this.fileApiWaitingTimeMap;
      d1 = paramLong;
      Double.isNaN(d1);
      ((ConcurrentHashMap)localObject).put(paramString, Double.valueOf(d1 * 1.0D));
      return;
    }
    ConcurrentHashMap localConcurrentHashMap = this.fileApiWaitingTimeMap;
    double d1 = ((Double)localObject).doubleValue();
    double d2 = paramLong;
    Double.isNaN(d2);
    localConcurrentHashMap.put(paramString, Double.valueOf(d1 + d2));
  }
  
  private void updateWorkingTime(String paramString, boolean paramBoolean, long paramLong)
  {
    if (paramBoolean) {
      localObject = this.fileApiSuccessCountMap;
    } else {
      localObject = this.fileApiFailCountMap;
    }
    ConcurrentHashMap localConcurrentHashMap;
    if (paramBoolean) {
      localConcurrentHashMap = this.fileApiSuccessTimeCostMap;
    } else {
      localConcurrentHashMap = this.fileApiFailTimeCostMap;
    }
    ((Map)localObject).put(paramString, Integer.valueOf(getFileApiCount(paramString, paramBoolean) + 1));
    Object localObject = (Double)localConcurrentHashMap.get(paramString);
    if (localObject == null)
    {
      d1 = paramLong;
      Double.isNaN(d1);
      localConcurrentHashMap.put(paramString, Double.valueOf(d1 * 1.0D));
      return;
    }
    double d1 = ((Double)localObject).doubleValue();
    double d2 = paramLong;
    Double.isNaN(d2);
    localConcurrentHashMap.put(paramString, Double.valueOf(d1 + d2));
  }
  
  public void onGetFps(float paramFloat)
  {
    this.mFpsVariance.addSample(paramFloat);
    this.mAverageFps.addSample(paramFloat);
  }
  
  public void recordFileApiTimeCost(String paramString, boolean paramBoolean, long paramLong1, long paramLong2)
  {
    try
    {
      updateWaitingTime(paramString, paramLong1);
      updateWorkingTime(paramString, paramBoolean, paramLong2);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void recordInitialMemory()
  {
    this.mStartMemory = getProcessPssMemory();
  }
  
  public void setMiniAppInfo(MiniAppInfo paramMiniAppInfo)
  {
    this.miniAppInfo = paramMiniAppInfo;
  }
  
  public void setVersion(String paramString1, String paramString2)
  {
    this.jsVersion = paramString1;
    this.tritonVersion = paramString2;
  }
  
  public void startReport()
  {
    reset();
    Handler localHandler = ThreadManager.getSubThreadHandler();
    localHandler.removeCallbacks(this.mStaticsRunnable);
    localHandler.postDelayed(this.mStaticsRunnable, 10000L);
  }
  
  public void stopReport()
  {
    ThreadManager.getSubThreadHandler().removeCallbacks(this.mStaticsRunnable);
    doReport();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.MiniGamePerformanceStatics
 * JD-Core Version:    0.7.0.1
 */