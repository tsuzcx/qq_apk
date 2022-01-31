package com.tencent.tavcut.aifilter;

import com.tencent.aekit.api.standard.filter.AEAdjust;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.tavcut.util.Logger;

public class TavAIFilter
{
  AEAdjust mAEAdjust = new AEAdjust();
  
  public void release() {}
  
  public Frame render(Frame paramFrame)
  {
    Logger.i("TAVAIFilter", "rendering");
    return this.mAEAdjust.render(paramFrame);
  }
  
  public void setParams(float[] paramArrayOfFloat)
  {
    this.mAEAdjust.apply();
    this.mAEAdjust.setBrightness(paramArrayOfFloat[0]);
    this.mAEAdjust.setColorTemperature(paramArrayOfFloat[1]);
    this.mAEAdjust.setHighlights(paramArrayOfFloat[2]);
    this.mAEAdjust.setShadows(paramArrayOfFloat[3]);
    this.mAEAdjust.setContrast(paramArrayOfFloat[4]);
    this.mAEAdjust.setSaturation(paramArrayOfFloat[5]);
    this.mAEAdjust.setSharp(paramArrayOfFloat[6]);
    this.mAEAdjust.setFadeLevel(paramArrayOfFloat[7]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavcut.aifilter.TavAIFilter
 * JD-Core Version:    0.7.0.1
 */