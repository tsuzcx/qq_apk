package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;

public class TroopMessageNavigateInfo
  extends Entity
{
  public static int STATUS_ADD = 1;
  public static int STATUS_DELETE = 3;
  public static int STATUS_MODIFY = 2;
  public static int STATUS_NORMAL;
  public long msgseq;
  public int receivedFlowserCount;
  public int status = STATUS_NORMAL;
  public String summary;
  public String troopCode;
  public int type;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.TroopMessageNavigateInfo
 * JD-Core Version:    0.7.0.1
 */