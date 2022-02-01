package com.tencent.mobileqq.vashealth.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={"all"})
public abstract interface ISportManager
  extends IRuntimeService
{
  public abstract void doOnLogin();
  
  public abstract void doOnTimer1();
  
  public abstract void doOnTimer2();
  
  public abstract void refreshCurrentStep(String paramString);
  
  public abstract void setStepCounterEnable(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.api.ISportManager
 * JD-Core Version:    0.7.0.1
 */