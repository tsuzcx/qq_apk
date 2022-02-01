package com.tencent.rtmp.sharp.jni;

public class RingBuffer
{
  private final int DEFAULT_SIZE = 1000;
  public int c_totalSize = 1000;
  public boolean m_isEmpty = true;
  public byte[] m_pBuf;
  public int m_read = 0;
  public int m_write = 0;
  
  public RingBuffer()
  {
    this.m_pBuf = null;
    this.c_totalSize = 1000;
    this.m_isEmpty = true;
    this.m_read = 0;
    this.m_write = 0;
    this.m_pBuf = new byte[this.c_totalSize];
  }
  
  public RingBuffer(int paramInt)
  {
    this.c_totalSize = paramInt;
    this.m_isEmpty = true;
    this.m_read = 0;
    this.m_write = 0;
    this.m_pBuf = new byte[this.c_totalSize];
  }
  
  public void Clear()
  {
    this.m_write = 0;
    this.m_read = this.m_write;
    this.m_isEmpty = true;
  }
  
  public boolean Pop(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte = this.m_pBuf;
    boolean bool = false;
    if (arrayOfByte == null) {
      return false;
    }
    if (RemainRead() >= paramInt)
    {
      if (paramInt <= 0) {
        return false;
      }
      int i = this.c_totalSize;
      int j = this.m_read;
      if (i - j >= paramInt)
      {
        System.arraycopy(this.m_pBuf, j, paramArrayOfByte, 0, paramInt);
      }
      else
      {
        System.arraycopy(this.m_pBuf, j, paramArrayOfByte, 0, i - j);
        arrayOfByte = this.m_pBuf;
        i = this.c_totalSize;
        j = this.m_read;
        System.arraycopy(arrayOfByte, 0, paramArrayOfByte, i - j, paramInt - (i - j));
      }
      this.m_read = ((this.m_read + paramInt) % this.c_totalSize);
      if (this.m_read == this.m_write) {
        bool = true;
      }
      this.m_isEmpty = bool;
      return true;
    }
    return false;
  }
  
  public void Push(byte[] paramArrayOfByte, int paramInt)
  {
    if (this.m_pBuf == null) {
      return;
    }
    if (RemainWrite() < paramInt) {
      return;
    }
    int i = this.c_totalSize;
    int j = this.m_write;
    if (i - j >= paramInt)
    {
      System.arraycopy(paramArrayOfByte, 0, this.m_pBuf, j, paramInt);
    }
    else
    {
      System.arraycopy(paramArrayOfByte, 0, this.m_pBuf, j, i - j);
      i = this.c_totalSize;
      j = this.m_write;
      System.arraycopy(paramArrayOfByte, i - j, this.m_pBuf, 0, paramInt - (i - j));
    }
    this.m_write = ((this.m_write + paramInt) % this.c_totalSize);
    this.m_isEmpty = false;
  }
  
  public int RemainRead()
  {
    int i = this.m_write;
    int j = this.m_read;
    if (i < j) {
      return this.c_totalSize - j + i;
    }
    if (i > j) {
      return i - j;
    }
    if (this.m_isEmpty) {
      return 0;
    }
    return this.c_totalSize;
  }
  
  public int RemainWrite()
  {
    return this.c_totalSize - RemainRead();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.RingBuffer
 * JD-Core Version:    0.7.0.1
 */