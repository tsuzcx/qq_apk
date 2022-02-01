package com.tencent.mobileqq.qqlive.api.config;

import com.tencent.mobileqq.qqlive.api.IQQLiveModule;
import com.tencent.mobileqq.qqlive.callback.config.ConfigPreparedListener;
import com.tencent.mobileqq.qqlive.data.config.ConfigData;

public abstract interface IQQLiveConfigModule
  extends IQQLiveModule
{
  public abstract void asyncGetConfigData(ConfigPreparedListener paramConfigPreparedListener);
  
  public abstract ConfigData getConfigData();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.config.IQQLiveConfigModule
 * JD-Core Version:    0.7.0.1
 */