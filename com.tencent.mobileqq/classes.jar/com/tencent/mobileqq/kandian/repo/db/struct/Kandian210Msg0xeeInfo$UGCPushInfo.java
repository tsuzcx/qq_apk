package com.tencent.mobileqq.kandian.repo.db.struct;

import java.io.Serializable;

public class Kandian210Msg0xeeInfo$UGCPushInfo
  implements Serializable
{
  public long feedsId;
  public String ugcReason;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(", feedsId=");
    localStringBuilder.append(this.feedsId);
    localStringBuilder.append(", ugcReason=");
    localStringBuilder.append(this.ugcReason);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.db.struct.Kandian210Msg0xeeInfo.UGCPushInfo
 * JD-Core Version:    0.7.0.1
 */