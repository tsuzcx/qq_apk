package com.tencent.mobileqq.kandian.repo.feeds.entity;

import java.io.Serializable;

public class DailyFloatingWindowData
  implements Serializable
{
  public boolean remove = false;
  public String rowkey = "";
  public String topicID = "";
  public int type = 0;
  public String url = "";
  
  public void clear()
  {
    this.type = 0;
    this.url = "";
    this.topicID = "";
    this.rowkey = "";
    this.remove = false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DailyFloatingWindowData{type=");
    localStringBuilder.append(this.type);
    localStringBuilder.append(", url='");
    localStringBuilder.append(this.url);
    localStringBuilder.append('\'');
    localStringBuilder.append(", topicID='");
    localStringBuilder.append(this.topicID);
    localStringBuilder.append('\'');
    localStringBuilder.append(", rowkey='");
    localStringBuilder.append(this.rowkey);
    localStringBuilder.append('\'');
    localStringBuilder.append(", remove=");
    localStringBuilder.append(this.remove);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.DailyFloatingWindowData
 * JD-Core Version:    0.7.0.1
 */