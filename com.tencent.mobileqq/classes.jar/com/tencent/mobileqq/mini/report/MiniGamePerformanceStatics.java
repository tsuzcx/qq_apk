package com.tencent.mobileqq.mini.report;

import alzh;
import android.os.Debug;
import android.os.Debug.MemoryInfo;
import android.os.SystemClock;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.statistics.AverageStatistics;
import com.tencent.mobileqq.mini.statistics.MaxStatistics;
import com.tencent.mobileqq.mini.statistics.VarianceStatistics;
import java.util.Locale;
import mqq.os.MqqHandler;

public class MiniGamePerformanceStatics
{
  private static final long STATICS_INTERVAL_MS = 10000L;
  private static volatile MiniGamePerformanceStatics instance;
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
      f3 = (float)(alzh.a("-1") - this.mStartCpuTime) / ((float)l / 1000.0F);
      f4 = this.mAverageMemory.calculate();
      f5 = this.mMaxMemory.calculate() - this.mStartMemory;
      if (!this.miniAppConfig.isReportTypeMiniGame()) {
        break label213;
      }
      f2 = this.mAverageFps.calculate();
      f1 = this.mFpsVariance.calculate();
      MiniReportManager.reportEventType(this.miniAppConfig, 629, toString(f3), "1");
      MiniReportManager.reportEventType(this.miniAppConfig, 631, toString(f4), "1");
      MiniReportManager.reportEventType(this.miniAppConfig, 643, toString(f5), "1");
      MiniReportManager.reportEventType(this.miniAppConfig, 630, toString(f2), "1");
      MiniReportManager.reportEventType(this.miniAppConfig, 642, toString(f1), "1");
      MiniProgramLpReportDC04902.reportGameEnd(f2, f1, paramFloat);
    }
    for (paramFloat = f2;; paramFloat = 0.0F)
    {
      MiniProgramLpReportDC05115.reportCPUMemoryFPS(this.miniAppConfig, f3, f4, f5, paramFloat, f1);
      reset();
      return;
      label213:
      MiniReportManager.reportEventType(this.miniAppConfig, 629, toString(f3), "0");
      MiniReportManager.reportEventType(this.miniAppConfig, 631, toString(f4), "0");
      MiniReportManager.reportEventType(this.miniAppConfig, 643, toString(f5), "0");
    }
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
  
  private void reset()
  {
    this.mAverageMemory.reset();
    this.mAverageFps.reset();
    this.mFpsVariance.reset();
    this.mStartCpuTime = alzh.a("-1");
    this.mStartTimeMillis = SystemClock.uptimeMillis();
  }
  
  private static String toString(float paramFloat)
  {
    return String.format(Locale.US, "%.1f", new Object[] { Float.valueOf(paramFloat) });
  }
  
  public void onGetFps(float paramFloat)
  {
    this.mFpsVariance.addSample(paramFloat);
    this.mAverageFps.addSample(paramFloat);
  }
  
  public void recordInitialMemory()
  {
    this.mStartMemory = getProcessPssMemory();
  }
  
  public void setGameConfig(MiniAppConfig paramMiniAppConfig)
  {
    this.miniAppConfig = paramMiniAppConfig;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniGamePerformanceStatics
 * JD-Core Version:    0.7.0.1
 */