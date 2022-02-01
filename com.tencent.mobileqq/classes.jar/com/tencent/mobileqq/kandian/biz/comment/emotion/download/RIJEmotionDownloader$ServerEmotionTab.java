package com.tencent.mobileqq.kandian.biz.comment.emotion.download;

import java.io.Serializable;
import java.util.List;

class RIJEmotionDownloader$ServerEmotionTab
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public String iconUrl;
  public String id;
  public String name;
  public List<RIJEmotionDownloader.ServerEmotion> serverEmotions;
  public int size;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ServerEmotionTab{id='");
    localStringBuilder.append(this.id);
    localStringBuilder.append('\'');
    localStringBuilder.append(", name='");
    localStringBuilder.append(this.name);
    localStringBuilder.append('\'');
    localStringBuilder.append(", iconUrl='");
    localStringBuilder.append(this.iconUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", serverEmotions=");
    localStringBuilder.append(this.serverEmotions);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.emotion.download.RIJEmotionDownloader.ServerEmotionTab
 * JD-Core Version:    0.7.0.1
 */