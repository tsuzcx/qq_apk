package com.tencent.mobileqq.data.nativemonitor;

import atgw;

public class NativeMonitorConfig
{
  @atgw(a="androidVersionBlackList")
  private String androidVersionBlackList;
  @atgw(a="countLimted")
  private long countLimted = 1000L;
  @atgw(a="memoryLimited")
  private long memoryLimited = 5242880L;
  @atgw(a="nativeMonitorOpened")
  private int nativeMonitorOpened;
  @atgw(a="processBlackList")
  private String processBlackList;
  @atgw(a="soHook")
  public int soHook;
  @atgw(a="soWhiteList")
  private String soWhiteList;
  @atgw(a="switchFlag")
  private long switchFlag;
  @atgw(a="timeLimited")
  private long timeLimited = 1000000L;
  @atgw(a="tmChance")
  private long tmChance;
  
  public String getAndroidVersionBlackList()
  {
    return this.androidVersionBlackList;
  }
  
  public long getCountLimted()
  {
    return this.countLimted;
  }
  
  public long getMemoryLimited()
  {
    return this.memoryLimited;
  }
  
  public int getNativeMonitorOpened()
  {
    return this.nativeMonitorOpened;
  }
  
  public String getProcessBlackList()
  {
    return this.processBlackList;
  }
  
  public String getSoWhiteList()
  {
    return this.soWhiteList;
  }
  
  public long getSwitchFlag()
  {
    return this.switchFlag;
  }
  
  public long getTimeLimited()
  {
    return this.timeLimited;
  }
  
  public long getTmChance()
  {
    return this.tmChance;
  }
  
  public void setCountLimitedDefault()
  {
    this.countLimted = 1000L;
  }
  
  public void setMemoryLimitedDefault()
  {
    this.memoryLimited = 5242880L;
  }
  
  public void setTimeLimitedDefault()
  {
    this.timeLimited = 1000000L;
  }
  
  public void setTmChance(long paramLong)
  {
    this.tmChance = paramLong;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("nativeMonitorOpened:").append(this.nativeMonitorOpened);
    localStringBuilder.append("|switchFlag:").append(this.switchFlag);
    localStringBuilder.append("|soWhiteList:").append(this.soWhiteList);
    localStringBuilder.append("|androidVersionBlackList:").append(this.androidVersionBlackList);
    localStringBuilder.append("|timeLimited:").append(this.timeLimited);
    localStringBuilder.append("|countLimited:").append(this.countLimted);
    localStringBuilder.append("|memoryLimited:").append(this.memoryLimited);
    localStringBuilder.append("|processBlackList:").append(this.processBlackList);
    localStringBuilder.append("|tmChance:").append(this.tmChance);
    return localStringBuilder.toString();
  }
  
  public void update(NativeMonitorConfig paramNativeMonitorConfig)
  {
    this.nativeMonitorOpened = paramNativeMonitorConfig.getNativeMonitorOpened();
    this.switchFlag = paramNativeMonitorConfig.getSwitchFlag();
    this.soWhiteList = paramNativeMonitorConfig.getSoWhiteList();
    this.timeLimited = paramNativeMonitorConfig.getTimeLimited();
    this.countLimted = paramNativeMonitorConfig.getCountLimted();
    this.memoryLimited = paramNativeMonitorConfig.getMemoryLimited();
    this.androidVersionBlackList = paramNativeMonitorConfig.getAndroidVersionBlackList();
    this.processBlackList = paramNativeMonitorConfig.getProcessBlackList();
    this.tmChance = paramNativeMonitorConfig.getTmChance();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.nativemonitor.NativeMonitorConfig
 * JD-Core Version:    0.7.0.1
 */