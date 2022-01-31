package com.tencent.mobileqq.data;

import awge;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.IGNORE, columnNames="mr_time,mr_seq,selfUin,friendUin")
public class TransFileInfo
  extends awge
{
  public String fileName;
  public String friendUin;
  public long mr_seq;
  public long mr_time;
  public String selfUin;
  public int status;
  public long transferedSize;
  public byte[] uuid;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.TransFileInfo
 * JD-Core Version:    0.7.0.1
 */