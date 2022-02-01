package com.tencent.qqlive.module.videoreport.apm;

import com.tencent.qqlive.module.videoreport.Configuration;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.report.FinalDataTarget;
import com.tencent.qqlive.module.videoreport.reportdata.FinalData;
import com.tencent.qqlive.module.videoreport.task.ThreadUtils;
import com.tencent.qqlive.module.videoreport.utils.ReusablePool;
import java.util.Random;

public class DTApmManager
{
  private static final int MAX_EFFECTIVE_DETECT_TIME = 10;
  private static final int MAX_TOTAL_DETECT_TIME = 100;
  private static final String TAG = "DTApmManager";
  private long mElementDetectMaxTime = 0L;
  private int mElementEffectiveDetectCount = 0;
  private long mElementEffectiveTime = 0L;
  private int mElementIneffectiveDetectCount = 0;
  private long mElementIneffectiveTime = 0L;
  private int mElementTotalDetectCount = 0;
  private long mElementTotalDetectTime = 0L;
  private boolean mIsElementDetectEnable = false;
  
  public static DTApmManager getInstance()
  {
    return DTApmManager.InstanceHolder.INSTANCE;
  }
  
  private void handleOnElementDetect(boolean paramBoolean, long paramLong)
  {
    try
    {
      this.mElementTotalDetectCount += 1;
      this.mElementTotalDetectTime += paramLong;
      if (paramLong > this.mElementDetectMaxTime) {
        this.mElementDetectMaxTime = paramLong;
      }
      if (paramBoolean)
      {
        this.mElementEffectiveTime += paramLong;
        this.mElementEffectiveDetectCount += 1;
      }
      else
      {
        this.mElementIneffectiveTime += paramLong;
        this.mElementIneffectiveDetectCount += 1;
      }
      if ((this.mElementEffectiveDetectCount >= 10) || (this.mElementTotalDetectCount >= 100)) {
        triggleElementDetectReport();
      }
      return;
    }
    finally {}
  }
  
  private boolean isDetectEnable()
  {
    boolean bool2 = VideoReportInner.getInstance().getConfiguration().isElementDetectEnable();
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    if (new Random().nextInt(10000) <= 10) {
      bool1 = true;
    }
    return bool1;
  }
  
  private void reset()
  {
    this.mElementTotalDetectCount = 0;
    this.mElementEffectiveDetectCount = 0;
    this.mElementIneffectiveDetectCount = 0;
    this.mElementTotalDetectTime = 0L;
    this.mElementIneffectiveTime = 0L;
    this.mElementEffectiveTime = 0L;
    this.mElementDetectMaxTime = 0L;
  }
  
  private void triggleElementDetectReport()
  {
    FinalData localFinalData = (FinalData)ReusablePool.obtain(6);
    localFinalData.setEventKey("dt_monitor_viewdetect");
    int i = this.mElementTotalDetectCount;
    float f4 = 0.0F;
    float f1;
    if (i > 0) {
      f1 = this.mElementEffectiveDetectCount / i;
    } else {
      f1 = 0.0F;
    }
    i = this.mElementTotalDetectCount;
    float f2;
    if (i > 0) {
      f2 = (float)this.mElementTotalDetectTime / i;
    } else {
      f2 = 0.0F;
    }
    i = this.mElementEffectiveDetectCount;
    float f3;
    if (i > 0) {
      f3 = (float)this.mElementEffectiveTime / i;
    } else {
      f3 = 0.0F;
    }
    i = this.mElementIneffectiveDetectCount;
    if (i > 0) {
      f4 = (float)this.mElementIneffectiveTime / i;
    }
    localFinalData.put("dt_effective_rate", Integer.valueOf((int)(100.0F * f1)));
    localFinalData.put("dt_time_average", Integer.valueOf((int)f2));
    localFinalData.put("dt_time_max", Long.valueOf(this.mElementDetectMaxTime));
    localFinalData.put("dt_effective_average", Integer.valueOf((int)f3));
    localFinalData.put("dt_ineffective_average", Integer.valueOf((int)f4));
    if (VideoReportInner.getInstance().isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("effective_rate=");
      localStringBuilder.append(f1);
      localStringBuilder.append("&time_average=");
      localStringBuilder.append(f2);
      localStringBuilder.append("&time_max=");
      localStringBuilder.append(this.mElementDetectMaxTime);
      localStringBuilder.append("&effective_averate=");
      localStringBuilder.append(f3);
      localStringBuilder.append("&ineffective_averate=");
      localStringBuilder.append(f4);
      Log.i("DTApmManager", localStringBuilder.toString());
    }
    reset();
    FinalDataTarget.handle(null, localFinalData);
  }
  
  public void onElementDetect(boolean paramBoolean, long paramLong)
  {
    if (!this.mIsElementDetectEnable) {
      return;
    }
    ThreadUtils.execTask(new DTApmManager.1(this, paramBoolean, paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.apm.DTApmManager
 * JD-Core Version:    0.7.0.1
 */