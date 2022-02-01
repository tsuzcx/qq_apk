package com.tencent.mobileqq.msgbackup.data;

import java.util.List;

public class MsgBackupUserData$Builder
{
  private String a;
  private List<Integer> b;
  private String c;
  private String d;
  private int e;
  
  public Builder a(int paramInt)
  {
    this.e = paramInt;
    return this;
  }
  
  public Builder a(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public Builder a(List<Integer> paramList)
  {
    this.b = paramList;
    return this;
  }
  
  public MsgBackupUserData a()
  {
    return new MsgBackupUserData(this.a, this.b, this.c, this.d, this.e, null);
  }
  
  public Builder b(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public Builder c(String paramString)
  {
    this.d = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.data.MsgBackupUserData.Builder
 * JD-Core Version:    0.7.0.1
 */