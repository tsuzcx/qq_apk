package com.tencent.mobileqq.data;

public class TroopMessageNavigateInfo
  extends BaseMessageNavigateInfo
{
  public String troopCode;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TroopMessageNavigateInfo{troopCode='");
    localStringBuilder.append(this.troopCode);
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.type);
    localStringBuilder.append(", shmsgseq=");
    localStringBuilder.append(this.shmsgseq);
    localStringBuilder.append(", msgseq=");
    localStringBuilder.append(this.msgseq);
    localStringBuilder.append(", status=");
    localStringBuilder.append(this.status);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.TroopMessageNavigateInfo
 * JD-Core Version:    0.7.0.1
 */