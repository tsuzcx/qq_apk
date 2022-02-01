package com.tencent.ttpic.trigger;

import com.tencent.ttpic.openapi.PTDetectInfo;

public abstract interface AETriggerI
{
  public abstract void clear();
  
  public abstract void reset();
  
  public abstract void updateTriggerStatus(PTDetectInfo paramPTDetectInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.trigger.AETriggerI
 * JD-Core Version:    0.7.0.1
 */