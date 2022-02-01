package com.tencent.tkd.comment.util.io;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ByteArrayPool
  implements Pool<byte[]>
{
  private static Comparator BUF_COMPARATOR = new ByteArrayPool.1();
  private int bufferCount = 4;
  private final List<byte[]> bufferPool = new ArrayList(this.bufferCount);
  private int leftSize;
  private int maxTotalBufferSize;
  
  public ByteArrayPool(int paramInt)
  {
    this.maxTotalBufferSize = paramInt;
  }
  
  public byte[] get(int paramInt)
  {
    List localList = this.bufferPool;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < this.bufferPool.size())
        {
          byte[] arrayOfByte = (byte[])this.bufferPool.get(i);
          if (arrayOfByte.length >= paramInt)
          {
            this.leftSize -= arrayOfByte.length;
            this.bufferPool.remove(i);
            return arrayOfByte;
          }
        }
        else
        {
          return new byte[Math.max(paramInt, 0)];
        }
      }
      finally {}
      i += 1;
    }
  }
  
  public void release(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    synchronized (this.bufferPool)
    {
      int j = Collections.binarySearch(this.bufferPool, paramArrayOfByte, BUF_COMPARATOR);
      int i = j;
      if (j < 0) {
        i = -j - 1;
      }
      this.bufferPool.add(i, paramArrayOfByte);
      this.leftSize += paramArrayOfByte.length;
      trim(TrimLevel.NORMAL);
      return;
    }
  }
  
  public void trim(TrimLevel paramTrimLevel)
  {
    for (;;)
    {
      synchronized (this.bufferPool)
      {
        switch (ByteArrayPool.2.$SwitchMap$com$tencent$tkd$comment$util$io$TrimLevel[paramTrimLevel.ordinal()])
        {
        case 1: 
          return;
          if (this.leftSize > this.maxTotalBufferSize) {
            if ((this.bufferPool.size() > 0) && (this.leftSize > this.maxTotalBufferSize))
            {
              paramTrimLevel = (byte[])this.bufferPool.get(0);
              this.bufferPool.remove(0);
              this.leftSize -= paramTrimLevel.length;
            }
          }
          break;
        case 2: 
          this.bufferPool.clear();
          this.leftSize = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.comment.util.io.ByteArrayPool
 * JD-Core Version:    0.7.0.1
 */