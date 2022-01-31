package com.tencent.mobileqq.troop.data;

import awge;
import awhs;
import java.io.Serializable;

public class TroopAioKeywordTipInfo
  extends awge
  implements Serializable
{
  public String icon;
  @awhs
  public int ruleId;
  public String summary;
  public String title;
  public String url;
  public int version;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ruleId=").append(this.ruleId).append("title=").append(this.title).append("summary").append(this.summary).append("icon").append(this.icon).append("url").append(this.url).append("version").append(this.version);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAioKeywordTipInfo
 * JD-Core Version:    0.7.0.1
 */