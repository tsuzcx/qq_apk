package com.tencent.qqmini.sdk.monitor.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ByteArrayPool
{
  protected static final Comparator<byte[]> BUF_COMPARATOR = new ByteArrayPool.1();
  private static ByteArrayPool genericInstance = new ByteArrayPool(102400);
  private static ByteArrayPool maxBufPoolInstance;
  private List<byte[]> mBuffersByLastUse = new LinkedList();
  private List<byte[]> mBuffersBySize = new ArrayList(64);
  private int mCurrentSize = 0;
  private final int mSizeLimit;
  
  public ByteArrayPool(int paramInt)
  {
    this.mSizeLimit = paramInt;
  }
  
  public static ByteArrayPool getGenericInstance()
  {
    return genericInstance;
  }
  
  public static ByteArrayPool getMaxBufInstance()
  {
    if (maxBufPoolInstance == null) {
      try
      {
        if (maxBufPoolInstance == null) {
          maxBufPoolInstance = new ByteArrayPool(1024000);
        }
      }
      finally {}
    }
    return maxBufPoolInstance;
  }
  
  private void trim()
  {
    try
    {
      while (this.mCurrentSize > this.mSizeLimit)
      {
        byte[] arrayOfByte = (byte[])this.mBuffersByLastUse.remove(0);
        this.mBuffersBySize.remove(arrayOfByte);
        this.mCurrentSize -= arrayOfByte.length;
      }
      return;
    }
    finally
    {
      localObject = finally;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public byte[] getBuf(int paramInt)
  {
    int i = 0;
    try
    {
      while (i < this.mBuffersBySize.size())
      {
        arrayOfByte = (byte[])this.mBuffersBySize.get(i);
        if (arrayOfByte.length >= paramInt)
        {
          this.mCurrentSize -= arrayOfByte.length;
          this.mBuffersBySize.remove(i);
          this.mBuffersByLastUse.remove(arrayOfByte);
          return arrayOfByte;
        }
        i += 1;
      }
      byte[] arrayOfByte = new byte[paramInt];
      return arrayOfByte;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void returnBuf(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      try
      {
        if (paramArrayOfByte.length <= this.mSizeLimit)
        {
          this.mBuffersByLastUse.add(paramArrayOfByte);
          int j = Collections.binarySearch(this.mBuffersBySize, paramArrayOfByte, BUF_COMPARATOR);
          int i = j;
          if (j < 0) {
            i = -j - 1;
          }
          this.mBuffersBySize.add(i, paramArrayOfByte);
          this.mCurrentSize += paramArrayOfByte.length;
          trim();
          return;
        }
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.monitor.common.ByteArrayPool
 * JD-Core Version:    0.7.0.1
 */