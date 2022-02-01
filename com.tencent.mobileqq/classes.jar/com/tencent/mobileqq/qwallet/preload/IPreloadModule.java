package com.tencent.mobileqq.qwallet.preload;

import java.util.List;

public abstract interface IPreloadModule
{
  public abstract String getBaseUrl();
  
  public abstract String getName();
  
  public abstract List<IPreloadResource> getResApiList();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.IPreloadModule
 * JD-Core Version:    0.7.0.1
 */