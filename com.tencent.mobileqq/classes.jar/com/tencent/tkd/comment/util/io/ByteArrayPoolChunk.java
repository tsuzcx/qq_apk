package com.tencent.tkd.comment.util.io;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class ByteArrayPoolChunk
  implements Pool<byte[]>
{
  private final HashMap<Integer, ByteArrayPool> chunkMap = new HashMap(7);
  
  private int enlarge(int paramInt)
  {
    return MemoryUtil.roundUpToPowerOfTwo(paramInt);
  }
  
  public static ByteArrayPoolChunk getInstance()
  {
    return ByteArrayPoolChunk.ClassHolder.access$000();
  }
  
  private int getSizeLimitByBucket(int paramInt)
  {
    return 65536;
  }
  
  private int hash(int paramInt)
  {
    return 0;
  }
  
  private ByteArrayPool obtainPool(int paramInt)
  {
    synchronized (this.chunkMap)
    {
      paramInt = hash(paramInt);
      ByteArrayPool localByteArrayPool2 = (ByteArrayPool)this.chunkMap.get(Integer.valueOf(paramInt));
      ByteArrayPool localByteArrayPool1 = localByteArrayPool2;
      if (localByteArrayPool2 == null)
      {
        localByteArrayPool1 = new ByteArrayPool(getSizeLimitByBucket(paramInt));
        this.chunkMap.put(Integer.valueOf(paramInt), localByteArrayPool1);
      }
      return localByteArrayPool1;
    }
  }
  
  public byte[] get(int paramInt)
  {
    paramInt = enlarge(paramInt);
    return obtainPool(paramInt).get(paramInt);
  }
  
  public void release(byte[] paramArrayOfByte)
  {
    obtainPool(paramArrayOfByte.length).release(paramArrayOfByte);
  }
  
  public void trim(TrimLevel paramTrimLevel)
  {
    try
    {
      synchronized (this.chunkMap)
      {
        Iterator localIterator = this.chunkMap.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          if ((localEntry != null) && (localEntry.getValue() != null)) {
            ((ByteArrayPool)localEntry.getValue()).trim(paramTrimLevel);
          }
        }
      }
    }
    catch (Throwable paramTrimLevel)
    {
      paramTrimLevel.printStackTrace();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tkd.comment.util.io.ByteArrayPoolChunk
 * JD-Core Version:    0.7.0.1
 */