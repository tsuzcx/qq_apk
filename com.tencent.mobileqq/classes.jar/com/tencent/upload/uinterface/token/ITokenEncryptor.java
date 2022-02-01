package com.tencent.upload.uinterface.token;

public abstract interface ITokenEncryptor
{
  public abstract byte[] getTokenData(byte[] paramArrayOfByte);
  
  public abstract int getTokenEncTye();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.upload.uinterface.token.ITokenEncryptor
 * JD-Core Version:    0.7.0.1
 */