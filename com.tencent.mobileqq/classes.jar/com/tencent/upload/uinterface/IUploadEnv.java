package com.tencent.upload.uinterface;

import com.tencent.upload.common.UploadConfiguration.NetworkStateObserver;

public abstract interface IUploadEnv
{
  public abstract String getApnName();
  
  public abstract String getBSSID();
  
  public abstract int getBatchControlCount();
  
  public abstract int getCurrentNetworkCategory();
  
  public abstract int getFileConcurrentCount();
  
  public abstract int getMobileOperatorCategory();
  
  public abstract String getProviderName();
  
  public abstract int getSocketCount();
  
  public abstract boolean isAvailable();
  
  public abstract boolean isMobile();
  
  public abstract boolean isWap();
  
  public abstract boolean isWifi();
  
  public abstract void registerNetworkStateObserver(UploadConfiguration.NetworkStateObserver paramNetworkStateObserver);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.uinterface.IUploadEnv
 * JD-Core Version:    0.7.0.1
 */