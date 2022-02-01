package com.tencent.mobileqq.kandian.repo.db.struct;

import java.io.Serializable;

public class Kandian210Msg0xeeInfo$SocialPushInfo
  implements Serializable
{
  public String biuComment;
  public String biuReason;
  public long feedsId;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(", feedsId=");
    localStringBuilder.append(this.feedsId);
    localStringBuilder.append(", biuReason='");
    localStringBuilder.append(this.biuReason);
    localStringBuilder.append('\'');
    localStringBuilder.append(", biuComment='");
    localStringBuilder.append(this.biuComment);
    localStringBuilder.append('\'');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.db.struct.Kandian210Msg0xeeInfo.SocialPushInfo
 * JD-Core Version:    0.7.0.1
 */