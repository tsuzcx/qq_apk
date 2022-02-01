package com.tencent.mobileqq.kandian.repo.db.struct;

import java.io.Serializable;

public class Kandian210Msg0xeeInfo$StatisticsInfo
  implements Serializable
{
  public long algorithmID;
  public long folderStatus;
  public long strategyID;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(", algorithmID=");
    localStringBuilder.append(this.algorithmID);
    localStringBuilder.append(", strategyID=");
    localStringBuilder.append(this.strategyID);
    localStringBuilder.append(", folderStatus=");
    localStringBuilder.append(this.folderStatus);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.db.struct.Kandian210Msg0xeeInfo.StatisticsInfo
 * JD-Core Version:    0.7.0.1
 */