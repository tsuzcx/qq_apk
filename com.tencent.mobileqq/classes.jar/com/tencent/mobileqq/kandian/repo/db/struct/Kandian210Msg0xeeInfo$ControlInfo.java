package com.tencent.mobileqq.kandian.repo.db.struct;

import java.io.Serializable;

public class Kandian210Msg0xeeInfo$ControlInfo
  implements Serializable
{
  public int commentLength;
  public int fontSize;
  public int showLine;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(", commentLength=");
    localStringBuilder.append(this.commentLength);
    localStringBuilder.append(", showLine=");
    localStringBuilder.append(this.showLine);
    localStringBuilder.append(", fontSize=");
    localStringBuilder.append(this.fontSize);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.db.struct.Kandian210Msg0xeeInfo.ControlInfo
 * JD-Core Version:    0.7.0.1
 */