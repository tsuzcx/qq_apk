package com.tencent.qphone.base.util.log.wrapper;

import com.tencent.qphone.base.util.log.ILogWriter;

public class EmptyWriterWrapper
  implements ILogWriter
{
  public void close() {}
  
  public void flush() {}
  
  public void write(int paramInt) {}
  
  public void write(String paramString) {}
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2) {}
  
  public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qphone.base.util.log.wrapper.EmptyWriterWrapper
 * JD-Core Version:    0.7.0.1
 */