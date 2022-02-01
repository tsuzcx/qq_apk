package com.tencent.mobileqq.mini.servlet;

public class GetShareInfoRequest
  extends ProtoBufRequest
{
  private final byte[] byteData;
  
  public GetShareInfoRequest(byte[] paramArrayOfByte)
  {
    this.byteData = paramArrayOfByte;
  }
  
  public byte[] getBusiBuf()
  {
    return this.byteData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.servlet.GetShareInfoRequest
 * JD-Core Version:    0.7.0.1
 */