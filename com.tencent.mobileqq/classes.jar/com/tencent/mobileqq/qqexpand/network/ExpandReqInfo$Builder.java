package com.tencent.mobileqq.qqexpand.network;

public class ExpandReqInfo$Builder
{
  private String a;
  private byte[] b;
  private int c = 0;
  private int d = 0;
  private int e = 30;
  private boolean f = false;
  private boolean g = false;
  
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
  
  public Builder a(boolean paramBoolean)
  {
    this.f = paramBoolean;
    return this;
  }
  
  public Builder a(byte[] paramArrayOfByte)
  {
    this.b = paramArrayOfByte;
    return this;
  }
  
  public ExpandReqInfo a()
  {
    return new ExpandReqInfo(this);
  }
  
  public Builder b(boolean paramBoolean)
  {
    this.g = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.network.ExpandReqInfo.Builder
 * JD-Core Version:    0.7.0.1
 */