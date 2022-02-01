package com.tencent.mobileqq.data.nativemonitor;

import com.tencent.mobileqq.jsonconverter.Alias;

public class NativeMonitorConfig
{
  @Alias(a="androidVersionBlackList")
  private String androidVersionBlackList = null;
  @Alias(a="countLimted")
  private long countLimted = 1000L;
  @Alias(a="memoryLimited")
  private long memoryLimited = 5242880L;
  @Alias(a="nativeMonitorOpened")
  private int nativeMonitorOpened = 0;
  @Alias(a="processBlackList")
  private String processBlackList = null;
  @Alias(a="soHook")
  public int soHook = 0;
  @Alias(a="soWhiteList")
  private String soWhiteList = null;
  @Alias(a="switchFlag")
  private long switchFlag = 0L;
  @Alias(a="timeLimited")
  private long timeLimited = 1000000L;
  @Alias(a="tmChance")
  private long tmChance = 0L;
  
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
    localStringBuilder.append("nativeMonitorOpened:");
    localStringBuilder.append(this.nativeMonitorOpened);
    localStringBuilder.append("|switchFlag:");
    localStringBuilder.append(this.switchFlag);
    localStringBuilder.append("|soWhiteList:");
    localStringBuilder.append(this.soWhiteList);
    localStringBuilder.append("|androidVersionBlackList:");
    localStringBuilder.append(this.androidVersionBlackList);
    localStringBuilder.append("|timeLimited:");
    localStringBuilder.append(this.timeLimited);
    localStringBuilder.append("|countLimited:");
    localStringBuilder.append(this.countLimted);
    localStringBuilder.append("|memoryLimited:");
    localStringBuilder.append(this.memoryLimited);
    localStringBuilder.append("|processBlackList:");
    localStringBuilder.append(this.processBlackList);
    localStringBuilder.append("|tmChance:");
    localStringBuilder.append(this.tmChance);
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