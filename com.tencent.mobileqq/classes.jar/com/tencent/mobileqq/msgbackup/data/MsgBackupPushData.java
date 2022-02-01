package com.tencent.mobileqq.msgbackup.data;

public class MsgBackupPushData
{
  private String a;
  private int b;
  
  private MsgBackupPushData(String paramString, int paramInt)
  {
    this.a = paramString;
    this.b = paramInt;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("--MsgBackupPushData--");
    localStringBuilder.append(",sig:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(",bizType:");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.data.MsgBackupPushData
 * JD-Core Version:    0.7.0.1
 */