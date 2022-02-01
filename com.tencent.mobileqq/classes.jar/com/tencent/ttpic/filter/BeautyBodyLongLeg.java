package com.tencent.ttpic.filter;

import android.graphics.PointF;
import java.util.List;

public class BeautyBodyLongLeg
{
  private int currentFrame;
  private boolean hasSeenValidPoints = false;
  private boolean legLineStable = false;
  private float lineMax = 1.0F;
  private float lineMin = 1.0F;
  private BeautyBodyLongLeg.LongLegParameters longLegParameters = new BeautyBodyLongLeg.LongLegParameters(this);
  private long previousLostWaistTime = System.currentTimeMillis();
  private long previousTimeForChangeToStable = System.currentTimeMillis();
  private long previousTimeForChangeToUnstable = System.currentTimeMillis();
  private float previousValidWaistLine;
  private float[] previousWaistLines = new float[8];
  private float rangeMax = 0.1F;
  private long timesForChangeToStable = 3000L;
  private long timesForChangeToUnstable = 3000L;
  private long usePreviousIfWithin = 2000L;
  private final int waistLineFrames = 8;
  
  public BeautyBodyLongLeg()
  {
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
    int i = 0;
    float f;
    if (!this.hasSeenValidPoints) {
      f = 1.0F;
    }
    long l;
    label193:
    label198:
    do
    {
      return f;
      l = System.currentTimeMillis();
      if (this.legLineStable)
      {
        f = (this.lineMin + this.lineMax) / 2.0F;
        if (Math.abs(f - paramFloat) < this.rangeMax) {
          this.previousTimeForChangeToUnstable = l;
        }
        for (;;)
        {
          return f;
          if (l - this.previousTimeForChangeToUnstable >= this.timesForChangeToUnstable)
          {
            this.legLineStable = false;
            this.previousTimeForChangeToStable = l;
            this.lineMax = paramFloat;
            this.lineMin = paramFloat;
            while (i < 8)
            {
              this.previousWaistLines[i] = f;
              i += 1;
            }
          }
        }
      }
      if (this.lineMin < paramFloat)
      {
        f = this.lineMin;
        this.lineMin = f;
        if (this.lineMax <= paramFloat) {
          break label193;
        }
      }
      for (f = this.lineMax;; f = paramFloat)
      {
        this.lineMax = f;
        if (this.lineMax - this.lineMin <= this.rangeMax) {
          break label198;
        }
        this.lineMax = paramFloat;
        this.lineMin = paramFloat;
        this.previousTimeForChangeToStable = l;
        return paramFloat;
        f = paramFloat;
        break;
      }
      f = paramFloat;
    } while (l - this.previousTimeForChangeToStable < this.timesForChangeToStable);
    this.legLineStable = true;
    this.lineMin = (paramFloat - this.rangeMax / 2.0F);
    this.lineMax = (this.rangeMax / 2.0F + paramFloat);
    this.previousTimeForChangeToUnstable = l;
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
    float f2 = 1.0F;
    long l = System.currentTimeMillis();
    float f1;
    if (paramFloat < 0.0F)
    {
      if ((this.legLineStable) || (l - this.previousLostWaistTime >= this.usePreviousIfWithin)) {
        break label154;
      }
      f1 = this.previousValidWaistLine;
      this.previousTimeForChangeToStable = System.currentTimeMillis();
    }
    for (;;)
    {
      this.previousWaistLines[getCurrentFrame()] = f1;
      this.currentFrame += 1;
      if (paramBoolean)
      {
        paramFloat = legLineToset(getCurrentSmoothedWaistLine());
        label81:
        if (paramFloat <= 1.0F) {
          break label151;
        }
        paramFloat = f2;
      }
      label151:
      for (;;)
      {
        f1 = paramFloat;
        if (paramFloat < 0.0F) {
          f1 = 0.0F;
        }
        this.longLegParameters.setY0(f1);
        return;
        this.previousValidWaistLine = paramFloat;
        this.previousLostWaistTime = l;
        f1 = paramFloat;
        if (this.hasSeenValidPoints) {
          break;
        }
        this.hasSeenValidPoints = true;
        this.previousTimeForChangeToStable = System.currentTimeMillis();
        f1 = paramFloat;
        break;
        paramFloat = f1;
        break label81;
      }
      label154:
      f1 = 1.0F;
    }
  }
  
  public void setWaistLine(List<PointF> paramList, int paramInt)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    for (float f = -1.0F;; f = (((PointF)paramList.get(43)).y + f) / 2.0F / paramInt)
    {
      setWaistLine(f);
      return;
      f = ((PointF)paramList.get(15)).y;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.filter.BeautyBodyLongLeg
 * JD-Core Version:    0.7.0.1
 */