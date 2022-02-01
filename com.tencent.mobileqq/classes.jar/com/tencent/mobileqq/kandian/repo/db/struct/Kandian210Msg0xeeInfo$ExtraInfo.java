package com.tencent.mobileqq.kandian.repo.db.struct;

import java.io.Serializable;

public class Kandian210Msg0xeeInfo$ExtraInfo
  implements Serializable
{
  public String extCookie;
  public String extInfo;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(", extInfo='");
    localStringBuilder.append(this.extInfo);
    localStringBuilder.append('\'');
    localStringBuilder.append(", extCookie='");
    localStringBuilder.append(this.extCookie);
    localStringBuilder.append('\'');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.db.struct.Kandian210Msg0xeeInfo.ExtraInfo
 * JD-Core Version:    0.7.0.1
 */