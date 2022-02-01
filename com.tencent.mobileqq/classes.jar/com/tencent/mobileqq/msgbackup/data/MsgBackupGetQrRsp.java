package com.tencent.mobileqq.msgbackup.data;

public class MsgBackupGetQrRsp
{
  private String a;
  private String b;
  private String c;
  private MsgBackupUserData d;
  private int e;
  
  public MsgBackupGetQrRsp(String paramString1, String paramString2, String paramString3, MsgBackupUserData paramMsgBackupUserData, int paramInt)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramMsgBackupUserData;
    this.e = paramInt;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public int d()
  {
    return this.e;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("--MsgBackupGetQrRsp--");
    localStringBuilder.append(",qr_sig:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(",token:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",encryptKey:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",userData:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(",bizType:");
    localStringBuilder.append(this.e);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.data.MsgBackupGetQrRsp
 * JD-Core Version:    0.7.0.1
 */