package com.tencent.mtt.abtestsdk.listener;

import com.tencent.mtt.abtestsdk.entity.ConfigValue;

public abstract interface GetConfigListener
{
  public abstract void getConfigFailed(int paramInt, String paramString);
  
  public abstract void getConfigSucceed(ConfigValue paramConfigValue);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.abtestsdk.listener.GetConfigListener
 * JD-Core Version:    0.7.0.1
 */