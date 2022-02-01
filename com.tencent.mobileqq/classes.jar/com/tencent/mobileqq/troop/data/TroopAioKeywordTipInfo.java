package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import java.io.Serializable;

public class TroopAioKeywordTipInfo
  extends Entity
  implements Serializable
{
  public String icon;
  @unique
  public int ruleId;
  public String summary;
  public String title;
  public String url;
  public int version;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ruleId=");
    localStringBuilder.append(this.ruleId);
    localStringBuilder.append("title=");
    localStringBuilder.append(this.title);
    localStringBuilder.append("summary");
    localStringBuilder.append(this.summary);
    localStringBuilder.append("icon");
    localStringBuilder.append(this.icon);
    localStringBuilder.append("url");
    localStringBuilder.append(this.url);
    localStringBuilder.append("version");
    localStringBuilder.append(this.version);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAioKeywordTipInfo
 * JD-Core Version:    0.7.0.1
 */