package com.tencent.mobileqq.msgbackup.data;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class MsgBackupSessionInfo
{
  public String a;
  public int b;
  public String c;
  public long d;
  public boolean e;
  public boolean f;
  public boolean g;
  public AtomicBoolean h = new AtomicBoolean();
  public boolean i;
  public ConcurrentHashMap<Long, MsgBackupSessionTask> j = new ConcurrentHashMap();
  public ConcurrentHashMap<Long, MsgBackupSessionTask> k = new ConcurrentHashMap();
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append("_");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.data.MsgBackupSessionInfo
 * JD-Core Version:    0.7.0.1
 */