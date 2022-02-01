package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;

public class TroopMessageNavigateInfo
  extends Entity
{
  public static int STATUS_ADD = 1;
  public static int STATUS_DELETE = 3;
  public static int STATUS_MODIFY = 2;
  public static int STATUS_NORMAL;
  public Object extObj;
  public long msgseq;
  public int receivedFlowserCount;
  public long shmsgseq;
  public int status = STATUS_NORMAL;
  public String summary;
  public String troopCode;
  public int type;
  
  public String toString()
  {
    return "TroopMessageNavigateInfo{troopCode='" + this.troopCode + ", type=" + this.type + ", shmsgseq=" + this.shmsgseq + ", msgseq=" + this.msgseq + ", status=" + this.status + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.TroopMessageNavigateInfo
 * JD-Core Version:    0.7.0.1
 */