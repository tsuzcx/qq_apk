package com.tencent.qphone.base.util.log;

import java.io.Writer;

public abstract class QWriter
  extends Writer
{
  protected QWriter(Object paramObject)
  {
    super(paramObject);
  }
  
  public abstract void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qphone.base.util.log.QWriter
 * JD-Core Version:    0.7.0.1
 */