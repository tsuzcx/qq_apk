package com.tencent.qphone.base.util.log.processor;

public class ProcessByteData
{
  public byte[] bytes;
  public int capacity;
  public int length;
  public int offset;
  
  public ProcessByteData()
  {
    this.bytes = new byte[2048];
    this.capacity = 2048;
    this.offset = 0;
    this.length = 0;
  }
  
  public ProcessByteData(int paramInt)
  {
    this.bytes = new byte[paramInt];
    this.capacity = paramInt;
    this.offset = 0;
    this.length = 0;
  }
  
  public ProcessByteData(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.bytes = paramArrayOfByte;
    int i;
    if (paramArrayOfByte == null) {
      i = 0;
    } else {
      i = paramArrayOfByte.length;
    }
    this.capacity = i;
    this.offset = paramInt1;
    this.length = paramInt2;
  }
  
  public void append(byte[] paramArrayOfByte, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      this.bytes[(this.length + i)] = paramArrayOfByte[i];
      i += 1;
    }
    this.length += paramInt;
  }
  
  public void append(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < paramInt2)
    {
      byte[] arrayOfByte = this.bytes;
      int j = this.offset;
      this.offset = (j + 1);
      arrayOfByte[j] = paramArrayOfByte[(paramInt1 + i)];
      i += 1;
    }
    this.length += paramInt2;
  }
  
  public void clear()
  {
    this.offset = 0;
    this.length = 0;
  }
  
  public void setData(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.bytes = paramArrayOfByte;
    this.capacity = paramArrayOfByte.length;
    this.offset = paramInt1;
    this.length = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qphone.base.util.log.processor.ProcessByteData
 * JD-Core Version:    0.7.0.1
 */