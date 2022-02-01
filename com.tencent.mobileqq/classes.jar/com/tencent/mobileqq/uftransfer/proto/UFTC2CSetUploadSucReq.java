package com.tencent.mobileqq.uftransfer.proto;

public class UFTC2CSetUploadSucReq
  extends UFTC2CUploadBaseInfo
{
  private byte[] a;
  private String b;
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.a = paramArrayOfByte;
  }
  
  public byte[] a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.proto.UFTC2CSetUploadSucReq
 * JD-Core Version:    0.7.0.1
 */