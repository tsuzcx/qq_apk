package com.tencent.mobileqq.mini.report;

import amxv;
import android.os.Debug;
import android.os.Debug.MemoryInfo;
import android.os.SystemClock;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.statistics.AverageStatistics;
import com.tencent.mobileqq.mini.statistics.MaxStatistics;
import com.tencent.mobileqq.mini.statistics.VarianceStatistics;
import com.tencent.mobileqq.minigame.report.MiniGameBeaconReport;
import cooperation.qzone.QUA;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

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
  private MiniAppConfig miniAppConfig;
  private String tritonVersion;
  
  private void doReport(float paramFloat)
  {
    float f1 = 0.0F;
    float f3;
    float f4;
    float f5;
    float f2;
    if (this.miniAppConfig != null)
    {
      long l = SystemClock.uptimeMillis() - this.mStartTimeMillis;
      if (l < 10000L)
      {
        reset();
        return;
      }
      f3 = (float)(amxv.a("-1") - this.mStartCpuTime) / ((float)l / 1000.0F);
      f4 = this.mAverageMemory.calculate();
      f5 = this.mMaxMemory.calculate() - this.mStartMemory;
      if (!this.miniAppConfig.isReportTypeMiniGame()) {
        break label225;
      }
      f2 = this.mAverageFps.calculate();
      f1 = this.mFpsVariance.calculate();
      MiniReportManager.reportEventType(this.miniAppConfig, 629, toString(f3), "1");
      MiniReportManager.reportEventType(this.miniAppConfig, 631, toString(f4), "1");
      MiniReportManager.reportEventType(this.miniAppConfig, 643, toString(f5), "1");
      MiniReportManager.reportEventType(this.miniAppConfig, 630, toString(f2), "1");
      MiniReportManager.reportEventType(this.miniAppConfig, 642, toString(f1), "1");
      MiniProgramLpReportDC04902.reportGameEnd(f2, f1, paramFloat, this.jsVersion, this.tritonVersion);
    }
    for (paramFloat = f2;; paramFloat = 0.0F)
    {
      MiniProgramLpReportDC05115.reportCPUMemoryFPS(this.miniAppConfig, f3, f4, f5, paramFloat, f1);
      reportFileApiTimeCost();
      reset();
      return;
      label225:
      MiniReportManager.reportEventType(this.miniAppConfig, 629, toString(f3), "0");
      MiniReportManager.reportEventType(this.miniAppConfig, 631, toString(f4), "0");
      MiniReportManager.reportEventType(this.miniAppConfig, 643, toString(f5), "0");
    }
  }
  
  private void doReportFileApiTimeCost(boolean paramBoolean)
  {
    String str = this.miniAppConfig.config.appId;
    ConcurrentHashMap localConcurrentHashMap;
    label36:
    Object localObject;
    HashMap localHashMap;
    int i;
    label117:
    int j;
    int k;
    Double localDouble;
    if (paramBoolean)
    {
      localConcurrentHashMap = this.fileApiSuccessTimeCostMap;
      Iterator localIterator = localConcurrentHashMap.keySet().iterator();
      if (!localIterator.hasNext()) {
        return;
      }
      localObject = (String)localIterator.next();
      localHashMap = new HashMap();
      localHashMap.put("appId", str);
      localHashMap.put("qua", QUA.getQUA3());
      localHashMap.put("apiName", localObject);
      localHashMap.put("isSdk", String.valueOf(0));
      if (!paramBoolean) {
        break label233;
      }
      i = 1;
      localHashMap.put("isSuccess", String.valueOf(i));
      j = getFileApiCount((String)localObject, true);
      k = getFileApiCount((String)localObject, false);
      localDouble = (Double)localConcurrentHashMap.get(localObject);
      if (localDouble != null) {
        break label239;
      }
      d = 0.0D;
      localHashMap.put("workingTime", String.valueOf(d));
      localObject = (Double)this.fileApiWaitingTimeMap.get(localObject);
      if (localObject != null) {
        break label269;
      }
    }
    label269:
    for (double d = 0.0D;; d = ((Double)localObject).doubleValue() / (j + k))
    {
      localHashMap.put("waitingTime", String.valueOf(d));
      MiniGameBeaconReport.report("mini_game_file_api_time_cost", localHashMap);
      break label36;
      localConcurrentHashMap = this.fileApiFailTimeCostMap;
      break;
      label233:
      i = 0;
      break label117;
      label239:
      d = localDouble.doubleValue();
      if (paramBoolean) {}
      for (i = j;; i = k)
      {
        d /= i;
        break;
      }
    }
  }
  
  private int getFileApiCount(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (ConcurrentHashMap localConcurrentHashMap = this.fileApiSuccessCountMap;; localConcurrentHashMap = this.fileApiFailCountMap)
    {
      paramString = (Integer)localConcurrentHashMap.get(paramString);
      if (paramString != null) {
        break;
      }
      return 0;
    }
    return paramString.intValue();
  }
  
  public static MiniGamePerformanceStatics getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new MiniGamePerformanceStatics();
      }
      return instance;
    }
    finally {}
  }
  
  private float getProcessPssMemory()
  {
    Debug.getMemoryInfo(this.mMemoryInfo);
    return this.mMemoryInfo.getTotalPss() / 1024.0F;
  }
  
  private void reportFileApiTimeCost()
  {
    if ((this.miniAppConfig == null) || (this.miniAppConfig.config == null)) {
      return;
    }
    doReportFileApiTimeCost(true);
    doReportFileApiTimeCost(false);
  }
  
  private void reset()
  {
    this.mAverageMemory.reset();
    this.mAverageFps.reset();
    this.mFpsVariance.reset();
    this.mStartCpuTime = amxv.a("-1");
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
    Double localDouble = (Double)this.fileApiWaitingTimeMap.get(paramString);
    if (localDouble == null)
    {
      this.fileApiWaitingTimeMap.put(paramString, Double.valueOf(paramLong * 1.0D));
      return;
    }
    this.fileApiWaitingTimeMap.put(paramString, Double.valueOf(localDouble.doubleValue() + paramLong));
  }
  
  private void updateWorkingTime(String paramString, boolean paramBoolean, long paramLong)
  {
    Object localObject;
    if (paramBoolean)
    {
      localObject = this.fileApiSuccessCountMap;
      if (!paramBoolean) {
        break label84;
      }
    }
    label84:
    for (ConcurrentHashMap localConcurrentHashMap = this.fileApiSuccessTimeCostMap;; localConcurrentHashMap = this.fileApiFailTimeCostMap)
    {
      ((Map)localObject).put(paramString, Integer.valueOf(getFileApiCount(paramString, paramBoolean) + 1));
      localObject = (Double)localConcurrentHashMap.get(paramString);
      if (localObject != null) {
        break label93;
      }
      localConcurrentHashMap.put(paramString, Double.valueOf(paramLong * 1.0D));
      return;
      localObject = this.fileApiFailCountMap;
      break;
    }
    label93:
    localConcurrentHashMap.put(paramString, Double.valueOf(((Double)localObject).doubleValue() + paramLong));
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
  
  public void setGameConfig(MiniAppConfig paramMiniAppConfig)
  {
    this.miniAppConfig = paramMiniAppConfig;
  }
  
  public void setVersion(String paramString1, String paramString2)
  {
    this.jsVersion = paramString1;
    this.tritonVersion = paramString2;
  }
  
  public void startReport()
  {
    reset();
    MqqHandler localMqqHandler = ThreadManager.getSubThreadHandler();
    localMqqHandler.removeCallbacks(this.mStaticsRunnable);
    localMqqHandler.postDelayed(this.mStaticsRunnable, 10000L);
  }
  
  public void stopReport(float paramFloat)
  {
    ThreadManager.getSubThreadHandler().removeCallbacks(this.mStaticsRunnable);
    doReport(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniGamePerformanceStatics
 * JD-Core Version:    0.7.0.1
 */