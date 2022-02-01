package com.tencent.smtt.export.external.interfaces;

public abstract class ServiceWorkerWebSettings
{
  public abstract boolean getAllowContentAccess();
  
  public abstract boolean getAllowFileAccess();
  
  public abstract boolean getBlockNetworkLoads();
  
  public abstract int getCacheMode();
  
  public abstract void setAllowContentAccess(boolean paramBoolean);
  
  public abstract void setAllowFileAccess(boolean paramBoolean);
  
  public abstract void setBlockNetworkLoads(boolean paramBoolean);
  
  public abstract void setCacheMode(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.export.external.interfaces.ServiceWorkerWebSettings
 * JD-Core Version:    0.7.0.1
 */