package com.tencent.qqmusic.mediaplayer.seektable;

import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import java.io.Closeable;
import java.nio.charset.Charset;

public class ParsableInputStreamWrapper
  implements Parsable, Closeable
{
  private final IDataSource dataSource;
  private final byte[] intBuffer;
  private final byte[] longBuffer;
  private long position;
  
  public ParsableInputStreamWrapper(IDataSource paramIDataSource)
  {
    this.dataSource = paramIDataSource;
    this.intBuffer = new byte[4];
    this.longBuffer = new byte[8];
    this.position = 0L;
  }
  
  public long available()
  {
    return this.dataSource.getSize() - this.position;
  }
  
  public void close()
  {
    this.dataSource.close();
  }
  
  public void readBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    long l = this.position;
    this.position = (l + this.dataSource.readAt(l, paramArrayOfByte, paramInt1, paramInt2));
  }
  
  public int readInt()
  {
    Object localObject = this.dataSource;
    long l = this.position;
    byte[] arrayOfByte = this.intBuffer;
    int i = ((IDataSource)localObject).readAt(l, arrayOfByte, 0, arrayOfByte.length);
    this.position += i;
    localObject = this.intBuffer;
    if (i != localObject.length) {
      return -1;
    }
    return (localObject[0] & 0xFF) << 24 | (localObject[1] & 0xFF) << 16 | (localObject[2] & 0xFF) << 8 | localObject[3] & 0xFF;
  }
  
  public int[] readIntArray(int paramInt)
  {
    int[] arrayOfInt = new int[paramInt];
    paramInt = 0;
    while (paramInt < arrayOfInt.length)
    {
      arrayOfInt[paramInt] = readInt();
      paramInt += 1;
    }
    return arrayOfInt;
  }
  
  public void readIntArrayInterleaved(int paramInt, int[]... paramVarArgs)
  {
    int i = 0;
    while (i < paramInt)
    {
      int k = paramVarArgs.length;
      int j = 0;
      while (j < k)
      {
        paramVarArgs[j][i] = readInt();
        j += 1;
      }
      i += 1;
    }
  }
  
  public long readLong()
  {
    Object localObject = this.dataSource;
    long l1 = this.position;
    byte[] arrayOfByte = this.longBuffer;
    int i = ((IDataSource)localObject).readAt(l1, arrayOfByte, 0, arrayOfByte.length);
    this.position += i;
    localObject = this.longBuffer;
    if (i != localObject.length) {
      return -1L;
    }
    l1 = localObject[0];
    long l2 = localObject[1];
    long l3 = localObject[2];
    long l4 = localObject[3];
    long l5 = localObject[4];
    long l6 = localObject[5];
    long l7 = localObject[6];
    return localObject[7] & 0xFF | (l1 & 0xFF) << 56 | (l2 & 0xFF) << 48 | (l3 & 0xFF) << 40 | (l4 & 0xFF) << 32 | (l5 & 0xFF) << 24 | (l6 & 0xFF) << 16 | (l7 & 0xFF) << 8;
  }
  
  public long[] readLongArray(int paramInt)
  {
    long[] arrayOfLong = new long[paramInt];
    paramInt = 0;
    while (paramInt < arrayOfLong.length)
    {
      arrayOfLong[paramInt] = readLong();
      paramInt += 1;
    }
    return arrayOfLong;
  }
  
  public void readLongArrayInterleaved(int paramInt, long[]... paramVarArgs)
  {
    int i = 0;
    while (i < paramInt)
    {
      int k = paramVarArgs.length;
      int j = 0;
      while (j < k)
      {
        paramVarArgs[j][i] = readLong();
        j += 1;
      }
      i += 1;
    }
  }
  
  public String readString(int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    readBytes(arrayOfByte, 0, arrayOfByte.length);
    return new String(arrayOfByte, Charset.defaultCharset());
  }
  
  public long skip(long paramLong)
  {
    long l = available();
    if (l > paramLong)
    {
      this.position += paramLong;
      return paramLong;
    }
    this.position += l;
    return l;
  }
  
  public long tell()
  {
    return this.position;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.seektable.ParsableInputStreamWrapper
 * JD-Core Version:    0.7.0.1
 */