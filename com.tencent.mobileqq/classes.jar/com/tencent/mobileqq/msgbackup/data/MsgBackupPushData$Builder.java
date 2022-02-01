package com.tencent.mobileqq.msgbackup.data;

public class MsgBackupPushData$Builder
{
  private String a;
  private int b;
  
  public Builder a(int paramInt)
  {
    this.b = paramInt;
    return this;
  }
  
  public Builder a(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public MsgBackupPushData a()
  {
    return new MsgBackupPushData(this.a, this.b, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.data.MsgBackupPushData.Builder
 * JD-Core Version:    0.7.0.1
 */