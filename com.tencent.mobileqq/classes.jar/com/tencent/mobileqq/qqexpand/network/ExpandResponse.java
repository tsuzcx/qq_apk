package com.tencent.mobileqq.qqexpand.network;

import androidx.annotation.Nullable;

public class ExpandResponse
{
  protected int a;
  protected String b;
  public byte[] c;
  
  public ExpandResponse(int paramInt, String paramString)
  {
    this.a = paramInt;
    this.b = paramString;
  }
  
  public void a(byte[] paramArrayOfByte) {}
  
  @Nullable
  public byte[] a()
  {
    return null;
  }
  
  public int b()
  {
    return this.a;
  }
  
  public String c()
  {
    return this.b;
  }
  
  public String d()
  {
    StringBuffer localStringBuffer = new StringBuffer("ErrorInfo");
    localStringBuffer.append(" errorCode:");
    localStringBuffer.append(b());
    localStringBuffer.append(" errorMsg:");
    localStringBuffer.append(c());
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.network.ExpandResponse
 * JD-Core Version:    0.7.0.1
 */