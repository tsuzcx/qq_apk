package com.tencent.mobileqq.msgbackup.data;

public class MsgBackupConfirmQrRsp$Builder
{
  private String a;
  private String b;
  private MsgBackupUserData c;
  private int d;
  
  public Builder a(int paramInt)
  {
    this.d = paramInt;
    return this;
  }
  
  public Builder a(MsgBackupUserData paramMsgBackupUserData)
  {
    this.c = paramMsgBackupUserData;
    return this;
  }
  
  public Builder a(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public MsgBackupConfirmQrRsp a()
  {
    return new MsgBackupConfirmQrRsp(this.a, this.b, this.c, this.d);
  }
  
  public Builder b(String paramString)
  {
    this.b = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.data.MsgBackupConfirmQrRsp.Builder
 * JD-Core Version:    0.7.0.1
 */