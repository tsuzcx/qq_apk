package com.tencent.ttpic.filter;

import android.graphics.PointF;
import java.util.List;

public class BeautyBodyLongLeg
{
  private int currentFrame;
  private boolean hasSeenValidPoints;
  private boolean legLineStable;
  private float lineMax;
  private float lineMin;
  private BeautyBodyLongLeg.LongLegParameters longLegParameters;
  private long previousLostWaistTime;
  private long previousTimeForChangeToStable;
  private long previousTimeForChangeToUnstable;
  private float previousValidWaistLine;
  private float[] previousWaistLines;
  private float rangeMax;
  private long timesForChangeToStable;
  private long timesForChangeToUnstable;
  private long usePreviousIfWithin = 2000L;
  private final int waistLineFrames = 8;
  
  public BeautyBodyLongLeg()
  {
    int i = 0;
    this.legLineStable = false;
    this.lineMax = 1.0F;
    this.lineMin = 1.0F;
    this.rangeMax = 0.1F;
    this.timesForChangeToStable = 3000L;
    this.timesForChangeToUnstable = 3000L;
    this.previousTimeForChangeToStable = System.currentTimeMillis();
    this.previousTimeForChangeToUnstable = System.currentTimeMillis();
    this.previousLostWaistTime = System.currentTimeMillis();
    this.hasSeenValidPoints = false;
    this.longLegParameters = new BeautyBodyLongLeg.LongLegParameters(this);
    this.previousWaistLines = new float[8];
    while (i < 8)
    {
      this.previousWaistLines[i] = 1.0F;
      i += 1;
    }
  }
  
  private int getCurrentFrame()
  {
    if (this.currentFrame >= 8) {
      this.currentFrame = 0;
    }
    return this.currentFrame;
  }
  
  private float getCurrentSmoothedWaistLine()
  {
    float f = 0.0F;
    int i = 0;
    while (i < 8)
    {
      f += this.previousWaistLines[i];
      i += 1;
    }
    return f / 8.0F;
  }
  
  private float legLineToset(float paramFloat)
  {
    if (!this.hasSeenValidPoints) {
      return 1.0F;
    }
    long l = System.currentTimeMillis();
    if (this.legLineStable)
    {
      f1 = (this.lineMin + this.lineMax) / 2.0F;
      if (Math.abs(f1 - paramFloat) < this.rangeMax)
      {
        this.previousTimeForChangeToUnstable = l;
      }
      else if (l - this.previousTimeForChangeToUnstable >= this.timesForChangeToUnstable)
      {
        int i = 0;
        this.legLineStable = false;
        this.previousTimeForChangeToStable = l;
        this.lineMax = paramFloat;
        this.lineMin = paramFloat;
        while (i < 8)
        {
          this.previousWaistLines[i] = f1;
          i += 1;
        }
      }
      return f1;
    }
    float f1 = this.lineMin;
    if (f1 >= paramFloat) {
      f1 = paramFloat;
    }
    this.lineMin = f1;
    f1 = this.lineMax;
    if (f1 <= paramFloat) {
      f1 = paramFloat;
    }
    this.lineMax = f1;
    f1 = this.lineMax;
    float f2 = this.lineMin;
    float f3 = this.rangeMax;
    if (f1 - f2 > f3)
    {
      this.lineMax = paramFloat;
      this.lineMin = paramFloat;
      this.previousTimeForChangeToStable = l;
      return paramFloat;
    }
    if (l - this.previousTimeForChangeToStable >= this.timesForChangeToStable)
    {
      this.legLineStable = true;
      this.lineMin = (paramFloat - f3 / 2.0F);
      this.lineMax = (f3 / 2.0F + paramFloat);
      this.previousTimeForChangeToUnstable = l;
    }
    return paramFloat;
  }
  
  public BeautyBodyLongLeg.LongLegParameters getLongLegParameters()
  {
    return this.longLegParameters;
  }
  
  public void setLongLegParameters(BeautyBodyLongLeg.LongLegParameters paramLongLegParameters)
  {
    this.longLegParameters = paramLongLegParameters;
  }
  
  public void setStrength(float paramFloat) {}
  
  public void setWaistLine(float paramFloat)
  {
    setWaistLine(paramFloat, true);
  }
  
  public void setWaistLine(float paramFloat, boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    if (paramFloat < 0.0F)
    {
      if ((!this.legLineStable) && (l - this.previousLostWaistTime < this.usePreviousIfWithin))
      {
        f = this.previousValidWaistLine;
        this.previousTimeForChangeToStable = System.currentTimeMillis();
      }
      else
      {
        f = 1.0F;
      }
    }
    else
    {
      this.previousValidWaistLine = paramFloat;
      this.previousLostWaistTime = l;
      f = paramFloat;
      if (!this.hasSeenValidPoints)
      {
        this.hasSeenValidPoints = true;
        this.previousTimeForChangeToStable = System.currentTimeMillis();
        f = paramFloat;
      }
    }
    this.previousWaistLines[getCurrentFrame()] = f;
    this.currentFrame += 1;
    if (paramBoolean) {
      f = legLineToset(getCurrentSmoothedWaistLine());
    }
    paramFloat = f;
    if (f > 1.0F) {
      paramFloat = 1.0F;
    }
    float f = paramFloat;
    if (paramFloat < 0.0F) {
      f = 0.0F;
    }
    this.longLegParameters.setY0(f);
  }
  
  public void setWaistLine(List<PointF> paramList, int paramInt)
  {
    float f;
    if ((paramList != null) && (!paramList.isEmpty())) {
      f = (((PointF)paramList.get(15)).y + ((PointF)paramList.get(43)).y) / 2.0F / paramInt;
    } else {
      f = -1.0F;
    }
    setWaistLine(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.filter.BeautyBodyLongLeg
 * JD-Core Version:    0.7.0.1
 */