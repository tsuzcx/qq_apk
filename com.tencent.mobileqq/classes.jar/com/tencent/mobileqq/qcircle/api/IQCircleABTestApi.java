package com.tencent.mobileqq.qcircle.api;

import java.util.Map;

public abstract interface IQCircleABTestApi
{
  public abstract Map<String, String> getParams();
  
  public abstract boolean isContrast();
  
  public abstract boolean isExpHit(String paramString);
  
  public abstract boolean isExpOnline();
  
  public abstract boolean isExperiment();
  
  public abstract IQCircleABTestApi loadExperiment(String paramString);
  
  public abstract void registerExpConfigInfo(String paramString);
  
  public abstract void reportEvent(int paramInt, String paramString);
  
  public abstract void reportExpExposure();
  
  public abstract void reportExposure(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.IQCircleABTestApi
 * JD-Core Version:    0.7.0.1
 */