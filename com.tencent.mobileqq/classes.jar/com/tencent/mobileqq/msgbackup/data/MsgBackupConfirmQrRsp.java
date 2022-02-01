package com.tencent.mobileqq.msgbackup.data;

public class MsgBackupConfirmQrRsp
{
  private String a;
  private String b;
  private MsgBackupUserData c;
  private int d;
  
  public MsgBackupConfirmQrRsp(String paramString1, String paramString2, MsgBackupUserData paramMsgBackupUserData, int paramInt)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramMsgBackupUserData;
    this.d = paramInt;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public MsgBackupUserData c()
  {
    return this.c;
  }
  
  public int d()
  {
    return this.d;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("--MsgBackupConfirmQrRsp--");
    localStringBuilder.append(",token:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(",encryptKey:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",userData:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",bizType:");
    localStringBuilder.append(this.d);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.data.MsgBackupConfirmQrRsp
 * JD-Core Version:    0.7.0.1
 */