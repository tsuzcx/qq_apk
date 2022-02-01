package com.tencent.mobileqq.kandian.biz.comment.emotion.download;

import java.io.Serializable;

class RIJEmotionDownloader$ServerEmotion
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public String emotionUrl;
  public String id;
  public String name;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ServerEmotion{id='");
    localStringBuilder.append(this.id);
    localStringBuilder.append('\'');
    localStringBuilder.append(", name='");
    localStringBuilder.append(this.name);
    localStringBuilder.append('\'');
    localStringBuilder.append(", emotionUrl='");
    localStringBuilder.append(this.emotionUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.emotion.download.RIJEmotionDownloader.ServerEmotion
 * JD-Core Version:    0.7.0.1
 */