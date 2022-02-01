package com.tencent.mobileqq.qqexpand.bean.profile;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import java.io.Serializable;

public class ExpandForbiddenInfo
  implements Serializable
{
  private String forbiddenDialogText;
  private long forbiddenDuration;
  private long forbiddenEndTime;
  private int forbiddenReason;
  private int forbiddenType;
  private boolean isForbidden;
  
  public ExpandForbiddenInfo(boolean paramBoolean, long paramLong1, long paramLong2, int paramInt1, int paramInt2, String paramString)
  {
    this.isForbidden = paramBoolean;
    this.forbiddenEndTime = paramLong1;
    this.forbiddenDuration = paramLong2;
    this.forbiddenType = paramInt1;
    this.forbiddenReason = paramInt2;
    this.forbiddenDialogText = paramString;
  }
  
  public long getForbiddenDuration()
  {
    return this.forbiddenDuration;
  }
  
  public long getForbiddenEndTime()
  {
    return this.forbiddenEndTime;
  }
  
  public int getForbiddenReason()
  {
    return this.forbiddenReason;
  }
  
  public String getForbiddenTips()
  {
    return this.forbiddenDialogText;
  }
  
  public int getForbiddenType()
  {
    return this.forbiddenType;
  }
  
  public long getRemainingForbiddenTime()
  {
    long l2 = this.forbiddenEndTime - NetConnInfoCenter.getServerTime();
    long l1 = l2;
    if (l2 < 0L) {
      l1 = 0L;
    }
    return l1;
  }
  
  public boolean isForbidden()
  {
    return this.isForbidden;
  }
  
  public void setForbidden(boolean paramBoolean)
  {
    this.isForbidden = paramBoolean;
  }
  
  public void setForbiddenDuration(long paramLong)
  {
    this.forbiddenDuration = paramLong;
  }
  
  public void setForbiddenEndTime(long paramLong)
  {
    this.forbiddenEndTime = paramLong;
  }
  
  public void setForbiddenReason(int paramInt)
  {
    this.forbiddenReason = paramInt;
  }
  
  public void setForbiddenTips(String paramString)
  {
    this.forbiddenDialogText = paramString;
  }
  
  public void setForbiddenType(int paramInt)
  {
    this.forbiddenType = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ExpandForbiddenInfo{isForbidden=");
    localStringBuilder.append(this.isForbidden);
    localStringBuilder.append(", forbiddenEndTime=");
    localStringBuilder.append(this.forbiddenEndTime);
    localStringBuilder.append(", forbiddenDuration=");
    localStringBuilder.append(this.forbiddenDuration);
    localStringBuilder.append(", forbiddenType=");
    localStringBuilder.append(this.forbiddenType);
    localStringBuilder.append(", forbiddenReason='");
    localStringBuilder.append(this.forbiddenReason);
    localStringBuilder.append(", forbiddenTips='");
    localStringBuilder.append(this.forbiddenDialogText);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.bean.profile.ExpandForbiddenInfo
 * JD-Core Version:    0.7.0.1
 */