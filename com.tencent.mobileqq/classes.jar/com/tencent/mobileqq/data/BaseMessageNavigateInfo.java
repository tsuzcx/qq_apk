package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;

public class BaseMessageNavigateInfo
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
  public int type;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.BaseMessageNavigateInfo
 * JD-Core Version:    0.7.0.1
 */