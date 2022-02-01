package com.tencent.mobileqq.kandian.repo.aladdin.beans;

import com.tencent.aladdin.config.parse.AladdinConfigBean;
import java.util.HashMap;
import java.util.Map;

public class SneakyParams
  implements AladdinConfigBean
{
  private String actionName = "";
  private String activityClassName = "";
  private String backupActivityUri = "";
  private int baseDelayMs = 10000;
  private int debounceIntervalMinutes = 60;
  private boolean enable = false;
  private int maximumWakeUpTimes = 3;
  private Map<String, OccasionRule> occasionTypeRulesMap = new HashMap();
  private String packageName = "";
  private Map<String, String> params = new HashMap();
  private int randomDelayUpperBoundMs = 10000;
  private String receiverClassName = "";
  private String serviceClassName = "";
  private String targetProcessName = "";
  private int wakeOccasion = 2;
  private String wakeType = "";
  
  public String getActionName()
  {
    return this.actionName;
  }
  
  public String getActivityClassName()
  {
    return this.activityClassName;
  }
  
  public String getBackupActivityUri()
  {
    return this.backupActivityUri;
  }
  
  public int getBaseDelayMs(int paramInt)
  {
    OccasionRule localOccasionRule = (OccasionRule)this.occasionTypeRulesMap.get(String.valueOf(paramInt));
    if (localOccasionRule != null) {
      return localOccasionRule.getBaseDelayMs();
    }
    return this.baseDelayMs;
  }
  
  public int getDebounceIntervalMinutes(int paramInt)
  {
    OccasionRule localOccasionRule = (OccasionRule)this.occasionTypeRulesMap.get(String.valueOf(paramInt));
    if (localOccasionRule != null) {
      return localOccasionRule.getDebounceIntervalMinutes();
    }
    return this.debounceIntervalMinutes;
  }
  
  public int getMaximumWakeUpTimes(int paramInt)
  {
    OccasionRule localOccasionRule = (OccasionRule)this.occasionTypeRulesMap.get(String.valueOf(paramInt));
    if (localOccasionRule != null) {
      return localOccasionRule.getMaximumWakeUpTimes();
    }
    return this.maximumWakeUpTimes;
  }
  
  public String getPackageName()
  {
    return this.packageName;
  }
  
  public Map<String, String> getParams()
  {
    return this.params;
  }
  
  public int getRandomDelayUpperBoundMs(int paramInt)
  {
    OccasionRule localOccasionRule = (OccasionRule)this.occasionTypeRulesMap.get(String.valueOf(paramInt));
    if (localOccasionRule != null) {
      return localOccasionRule.getRandomDelayUpperBound();
    }
    return this.randomDelayUpperBoundMs;
  }
  
  public String getReceiverClassName()
  {
    return this.receiverClassName;
  }
  
  public String getServiceClassName()
  {
    return this.serviceClassName;
  }
  
  public String getTargetProcessName()
  {
    return this.targetProcessName;
  }
  
  public int getWakeOccasion()
  {
    return this.wakeOccasion;
  }
  
  public String getWakeType()
  {
    return this.wakeType;
  }
  
  public boolean isEnable()
  {
    return this.enable;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SneakyParams{enable=");
    localStringBuilder.append(this.enable);
    localStringBuilder.append(", wakeType='");
    localStringBuilder.append(this.wakeType);
    localStringBuilder.append('\'');
    localStringBuilder.append(", serviceClassName='");
    localStringBuilder.append(this.serviceClassName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", activityClassName='");
    localStringBuilder.append(this.activityClassName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", receiverClassName='");
    localStringBuilder.append(this.receiverClassName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", targetProcessName='");
    localStringBuilder.append(this.targetProcessName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", actionName='");
    localStringBuilder.append(this.actionName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", packageName='");
    localStringBuilder.append(this.packageName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", backupActivityUri='");
    localStringBuilder.append(this.backupActivityUri);
    localStringBuilder.append('\'');
    localStringBuilder.append(", wakeOccasion=");
    localStringBuilder.append(this.wakeOccasion);
    localStringBuilder.append(", baseDelayMs=");
    localStringBuilder.append(this.baseDelayMs);
    localStringBuilder.append(", debounceIntervalMinutes=");
    localStringBuilder.append(this.debounceIntervalMinutes);
    localStringBuilder.append(", maximumWakeUpTimes=");
    localStringBuilder.append(this.maximumWakeUpTimes);
    localStringBuilder.append(", randomDelayUpperBoundMs=");
    localStringBuilder.append(this.randomDelayUpperBoundMs);
    localStringBuilder.append(", params=");
    localStringBuilder.append(this.params);
    localStringBuilder.append(", occasionTypeRulesMap=");
    localStringBuilder.append(this.occasionTypeRulesMap);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.beans.SneakyParams
 * JD-Core Version:    0.7.0.1
 */