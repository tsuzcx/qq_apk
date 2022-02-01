package com.tencent.mobileqq.msgbackup.data;

public class MsgBackupSessionTask
{
  public String a;
  public int b;
  public boolean c;
  public long d;
  public String e;
  public String f;
  public short g;
  public boolean h = true;
  public long i;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MsgBackupSessionTask[msg = ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", cmd = ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", isFileTask = ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", sessionId = ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", path = ");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", url = ");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", retryTimes = ");
    localStringBuilder.append(this.g);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.data.MsgBackupSessionTask
 * JD-Core Version:    0.7.0.1
 */