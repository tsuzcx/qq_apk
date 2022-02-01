package com.tencent.mobileqq.kandian.repo.feeds.entity;

import com.tencent.qphone.base.util.QLog;

public class NewPolymericInfo$PackTopicExtraInfo
  implements Cloneable
{
  public int a;
  public String a;
  public int b;
  public String b;
  public int c;
  
  protected Object clone()
  {
    try
    {
      PackTopicExtraInfo localPackTopicExtraInfo = (PackTopicExtraInfo)super.clone();
      return localPackTopicExtraInfo;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PackTopicExtraInfo item clone failed. exception = ");
      localStringBuilder.append(localCloneNotSupportedException);
      QLog.e("NewPolymericInfo", 2, localStringBuilder.toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo.PackTopicExtraInfo
 * JD-Core Version:    0.7.0.1
 */