package com.tencent.mobileqq.qcircle.api.coldboot;

public abstract interface IPreloadTask
{
  public abstract String getAttachInfo();
  
  public abstract byte[] getPreloadRspData();
  
  public abstract boolean hasPreloadData();
  
  public abstract void preloadFeed();
  
  public abstract void removePreloadData();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.coldboot.IPreloadTask
 * JD-Core Version:    0.7.0.1
 */