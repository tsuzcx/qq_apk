package com.tencent.qphone.base.util.log;

public abstract interface ILogWriter
{
  public abstract void close();
  
  public abstract void flush();
  
  public abstract void write(int paramInt);
  
  public abstract void write(String paramString);
  
  public abstract void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public abstract void write(char[] paramArrayOfChar, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qphone.base.util.log.ILogWriter
 * JD-Core Version:    0.7.0.1
 */