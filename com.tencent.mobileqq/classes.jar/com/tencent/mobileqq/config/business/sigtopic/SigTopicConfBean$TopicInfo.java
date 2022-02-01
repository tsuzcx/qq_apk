package com.tencent.mobileqq.config.business.sigtopic;

import org.jetbrains.annotations.NotNull;

public class SigTopicConfBean$TopicInfo
{
  public int a;
  public String b;
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("{");
    localStringBuilder.append("topicId: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(",topicName: ");
    localStringBuilder.append(this.b);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.sigtopic.SigTopicConfBean.TopicInfo
 * JD-Core Version:    0.7.0.1
 */