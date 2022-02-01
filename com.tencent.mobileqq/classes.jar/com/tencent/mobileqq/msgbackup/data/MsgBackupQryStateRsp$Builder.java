package com.tencent.mobileqq.msgbackup.data;

public class MsgBackupQryStateRsp$Builder
{
  private int a;
  private String b;
  private String c;
  private MsgBackupUserData d;
  private int e;
  
  public Builder a(int paramInt)
  {
    this.a = paramInt;
    return this;
  }
  
  public Builder a(MsgBackupUserData paramMsgBackupUserData)
  {
    this.d = paramMsgBackupUserData;
    return this;
  }
  
  public Builder a(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public MsgBackupQryStateRsp a()
  {
    return new MsgBackupQryStateRsp(this.a, this.b, this.c, this.d, this.e);
  }
  
  public Builder b(int paramInt)
  {
    this.e = paramInt;
    return this;
  }
  
  public Builder b(String paramString)
  {
    this.c = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.data.MsgBackupQryStateRsp.Builder
 * JD-Core Version:    0.7.0.1
 */