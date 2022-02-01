package com.tencent.mobileqq.kandian.repo.feeds.entity;

import com.tencent.qphone.base.util.QLog;

public class NewPolymericInfo$PackQuestionAnswerExtraInfo
  implements Cloneable
{
  public String a;
  public String b;
  
  protected Object clone()
  {
    try
    {
      PackQuestionAnswerExtraInfo localPackQuestionAnswerExtraInfo = (PackQuestionAnswerExtraInfo)super.clone();
      return localPackQuestionAnswerExtraInfo;
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
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo.PackQuestionAnswerExtraInfo
 * JD-Core Version:    0.7.0.1
 */