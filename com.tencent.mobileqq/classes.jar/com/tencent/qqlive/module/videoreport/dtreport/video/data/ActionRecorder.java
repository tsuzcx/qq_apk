package com.tencent.qqlive.module.videoreport.dtreport.video.data;

import android.text.TextUtils;
import com.tencent.qqlive.module.videoreport.Log;

public class ActionRecorder
{
  private static final int MAX_RECORD_LENGTH = 3400;
  private static final float MAX_SPEED_RATIO = 3.0F;
  private static final int MIN_SEEK_RANGE = 500;
  private static final float MIN_SPEED_RATIO = 0.5F;
  private static final float NORMAL_SPEED_RATIO = 1.0F;
  private static final float SPEED_RATIO_PARTICLE = 0.25F;
  private static final String TAG = "ActionRecorder";
  private float lastSpeedRatio = 1.0F;
  private long lastSpeedRatioPosition = 0L;
  private String seekRecord = "";
  private String speedRatioRecord = "";
  
  private void appendSeekRecord(long paramLong1, long paramLong2)
  {
    boolean bool = TextUtils.isEmpty(this.seekRecord);
    Object localObject = "";
    if (!bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append("|");
      localObject = ((StringBuilder)localObject).toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(paramLong1);
    localStringBuilder.append("-");
    localStringBuilder.append(paramLong2);
    localObject = localStringBuilder.toString();
    if (((String)localObject).length() + this.seekRecord.length() > 3400) {
      return;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.seekRecord);
    localStringBuilder.append((String)localObject);
    this.seekRecord = localStringBuilder.toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("seekRecord: ");
    ((StringBuilder)localObject).append(this.seekRecord);
    Log.d("ActionRecorder", ((StringBuilder)localObject).toString());
  }
  
  private void appendSpeedRatioRecord(float paramFloat, long paramLong1, long paramLong2)
  {
    boolean bool = TextUtils.isEmpty(this.speedRatioRecord);
    Object localObject = "";
    if (!bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append("|");
      localObject = ((StringBuilder)localObject).toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(paramFloat);
    localStringBuilder.append("-");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append("-");
    localStringBuilder.append(paramLong2);
    localObject = localStringBuilder.toString();
    if (((String)localObject).length() + this.speedRatioRecord.length() > 3400) {
      return;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.speedRatioRecord);
    localStringBuilder.append((String)localObject);
    this.speedRatioRecord = localStringBuilder.toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("speedRatioRecord: ");
    ((StringBuilder)localObject).append(this.speedRatioRecord);
    Log.d("ActionRecorder", ((StringBuilder)localObject).toString());
  }
  
  private float correctSpeedRatio(float paramFloat)
  {
    float f = Math.max(Math.min(Math.round(paramFloat / 0.25F) * 0.25F, 3.0F), 0.5F);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("correctSpeedRatio origin: ");
    localStringBuilder.append(paramFloat);
    localStringBuilder.append(", corrected: ");
    localStringBuilder.append(f);
    Log.d("ActionRecorder", localStringBuilder.toString());
    return f;
  }
  
  private void resetSeekRecord()
  {
    this.seekRecord = "";
  }
  
  private void resetSpeedRatioRecord()
  {
    this.speedRatioRecord = "";
  }
  
  public void end(long paramLong)
  {
    try
    {
      if (this.lastSpeedRatio != 1.0F)
      {
        appendSpeedRatioRecord(this.lastSpeedRatio, this.lastSpeedRatioPosition, paramLong);
        this.lastSpeedRatioPosition = paramLong;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String getSeekRecord()
  {
    return this.seekRecord;
  }
  
  public String getSpeedRatioRecord()
  {
    return this.speedRatioRecord;
  }
  
  public void seekTo(long paramLong1, long paramLong2)
  {
    try
    {
      long l = Math.abs(paramLong2 - paramLong1);
      if (l < 500L) {
        return;
      }
      appendSeekRecord(paramLong1, paramLong2);
      return;
    }
    finally {}
  }
  
  public void speedRatioPlay(float paramFloat, long paramLong)
  {
    try
    {
      paramFloat = correctSpeedRatio(paramFloat);
      float f = this.lastSpeedRatio;
      if (paramFloat == f) {
        return;
      }
      if (this.lastSpeedRatio != 1.0F) {
        appendSpeedRatioRecord(this.lastSpeedRatio, this.lastSpeedRatioPosition, paramLong);
      }
      this.lastSpeedRatio = paramFloat;
      this.lastSpeedRatioPosition = paramLong;
      return;
    }
    finally {}
  }
  
  public void start()
  {
    try
    {
      resetSeekRecord();
      resetSpeedRatioRecord();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.video.data.ActionRecorder
 * JD-Core Version:    0.7.0.1
 */