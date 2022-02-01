package com.tencent.turingfd.sdk.ams.ga;

public abstract interface ITuringDeviceInfoProvider
{
  public abstract String getAndroidId();
  
  public abstract String getBrand();
  
  public abstract String getImei();
  
  public abstract String getImsi();
  
  public abstract String getKernelVersion();
  
  public abstract String getModel();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.ams.ga.ITuringDeviceInfoProvider
 * JD-Core Version:    0.7.0.1
 */