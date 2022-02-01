package com.tencent.mtt.abtestsdk.entity;

import java.util.HashMap;
import java.util.Map;

public class ConfigEntity
{
  public static final String KEY_CONFIG_LAST_UPDATE_TIME = "config_last_update_time";
  public static final String KEY_CONFIG_LAST_UPDATE_VERSION = "config_last_update_version";
  private Map<String, ConfigValue> configData = new HashMap();
  private String configVersion = "";
  private long lastFetchDataTime = 0L;
  
  public Map<String, ConfigValue> getConfigData()
  {
    return this.configData;
  }
  
  public String getConfigVersion()
  {
    return this.configVersion;
  }
  
  public long getLastFetchDataTime()
  {
    return this.lastFetchDataTime;
  }
  
  public void setConfigData(Map<String, ConfigValue> paramMap)
  {
    this.configData = paramMap;
  }
  
  public void setConfigVersion(String paramString)
  {
    this.configVersion = paramString;
  }
  
  public void setLastFetchDataTime(long paramLong)
  {
    this.lastFetchDataTime = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.abtestsdk.entity.ConfigEntity
 * JD-Core Version:    0.7.0.1
 */