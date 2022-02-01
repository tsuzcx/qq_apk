package com.tencent.mobileqq.kandian.biz.comment.emotion.download;

import java.io.Serializable;
import java.util.List;

class RIJEmotionDownloader$ServerEmotionHolder
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public List<RIJEmotionDownloader.ServerEmotionTab> serverEmotionTabs;
  public long updateTime;
  
  public boolean isValid()
  {
    List localList = this.serverEmotionTabs;
    return (localList != null) && (!localList.isEmpty()) && (!RIJEmotionDownloader.a(this.updateTime));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ServerEmotionHolder{updateTime=");
    localStringBuilder.append(this.updateTime);
    localStringBuilder.append(", serverEmotionTabs=");
    localStringBuilder.append(this.serverEmotionTabs);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.emotion.download.RIJEmotionDownloader.ServerEmotionHolder
 * JD-Core Version:    0.7.0.1
 */