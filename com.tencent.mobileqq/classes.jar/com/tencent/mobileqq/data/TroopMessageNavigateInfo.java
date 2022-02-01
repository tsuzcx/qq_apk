package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;

public class TroopMessageNavigateInfo
  extends Entity
{
  public static int STATUS_ADD = 1;
  public static int STATUS_DELETE = 3;
  public static int STATUS_MODIFY = 2;
  public static int STATUS_NORMAL;
  public Object extObj = null;
  public long msgseq;
  public int receivedFlowserCount;
  public long shmsgseq;
  public int status = STATUS_NORMAL;
  public String summary;
  public String troopCode;
  public int type;
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.TroopMessageNavigateInfo
 * JD-Core Version:    0.7.0.1
 */