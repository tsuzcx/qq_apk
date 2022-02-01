package com.tencent.qqlive.module.videoreport.report.element;

import android.os.SystemClock;
import java.util.concurrent.TimeUnit;

public class EleExposeInfo
{
  private static final long ELEMENT_EXPOSE_EXPIRE_TIME = TimeUnit.MILLISECONDS.convert(30L, TimeUnit.MINUTES);
  long mExposeTime;
  boolean mHasReport;
  
  private void updateExposureTime()
  {
    this.mExposeTime = SystemClock.elapsedRealtime();
  }
  
  public boolean hasReport()
  {
    return this.mHasReport;
  }
  
  public void onExpose()
  {
    updateExposureTime();
  }
  
  public void onReport()
  {
    this.mHasReport = true;
  }
  
  public boolean reportOverTime()
  {
    return SystemClock.elapsedRealtime() - this.mExposeTime > ELEMENT_EXPOSE_EXPIRE_TIME;
  }
  
  public void resetReport()
  {
    this.mHasReport = false;
  }
  
  public String toString()
  {
    return "EleExposeInfo{mExposeTime=" + this.mExposeTime + "reportOverTime=" + reportOverTime() + "mHasReport=" + this.mHasReport + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.element.EleExposeInfo
 * JD-Core Version:    0.7.0.1
 */