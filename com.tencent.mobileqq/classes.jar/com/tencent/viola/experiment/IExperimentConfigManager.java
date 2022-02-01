package com.tencent.viola.experiment;

public abstract interface IExperimentConfigManager
{
  public abstract int getRuntimeMode();
  
  public abstract boolean isBindDataOpmOpen();
  
  public abstract boolean isLayoutOpmOpen();
  
  public abstract boolean triggerV8GcWhenDestroy();
  
  public abstract boolean useV8Engine();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.experiment.IExperimentConfigManager
 * JD-Core Version:    0.7.0.1
 */