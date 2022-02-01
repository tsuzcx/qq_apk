package com.tencent.mobileqq.msgbackup.data;

public class MsgBackupQryStateRsp
{
  private int a;
  private String b;
  private String c;
  private MsgBackupUserData d;
  private int e;
  
  public MsgBackupQryStateRsp(int paramInt1, String paramString1, String paramString2, MsgBackupUserData paramMsgBackupUserData, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramMsgBackupUserData;
    this.e = paramInt2;
  }
  
  public int a()
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
  
  public MsgBackupUserData d()
  {
    return this.d;
  }
  
  public int e()
  {
    return this.e;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("--MsgBackupQryStateRsp--");
    localStringBuilder.append(",state:");
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
 * Qualified Name:     com.tencent.mobileqq.msgbackup.data.MsgBackupQryStateRsp
 * JD-Core Version:    0.7.0.1
 */