package com.tencent.qqmusic.mediaplayer.util;

import java.io.PrintStream;
import java.nio.ByteOrder;

public class BytesTransUtil
{
  private static BytesTransUtil instance;
  private String TAG = "BytesTransUtil";
  
  public static BytesTransUtil getInstance()
  {
    if (instance == null) {
      instance = new BytesTransUtil();
    }
    return instance;
  }
  
  public int[] Bytes2Ints(byte[] paramArrayOfByte)
  {
    int[] arrayOfInt = new int[paramArrayOfByte.length / 4];
    int i = 0;
    while (i < arrayOfInt.length)
    {
      Object localObject = new byte[4];
      int j = 0;
      while (j < 4)
      {
        localObject[j] = paramArrayOfByte[(i * 4 + j)];
        j += 1;
      }
      arrayOfInt[i] = getInt((byte[])localObject);
      localObject = System.out;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("2out->");
      localStringBuilder.append(arrayOfInt[i]);
      ((PrintStream)localObject).println(localStringBuilder.toString());
      i += 1;
    }
    return arrayOfInt;
  }
  
  public long[] Bytes2Longs(byte[] paramArrayOfByte)
  {
    long[] arrayOfLong = new long[paramArrayOfByte.length / 8];
    int i = 0;
    while (i < arrayOfLong.length)
    {
      byte[] arrayOfByte = new byte[8];
      int j = 0;
      while (j < 8)
      {
        arrayOfByte[j] = paramArrayOfByte[(i * 8 + j)];
        j += 1;
      }
      arrayOfLong[i] = getLong(arrayOfByte);
      i += 1;
    }
    return arrayOfLong;
  }
  
  public short[] Bytes2Shorts(short[] paramArrayOfShort, byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[2];
    int i = 0;
    while (i < paramArrayOfShort.length)
    {
      System.arraycopy(paramArrayOfByte, i * 2, arrayOfByte, 0, 2);
      paramArrayOfShort[i] = getShort(arrayOfByte);
      i += 1;
    }
    return paramArrayOfShort;
  }
  
  public byte[] Ints2Bytes(int[] paramArrayOfInt)
  {
    byte[] arrayOfByte1 = new byte[paramArrayOfInt.length * 4];
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      byte[] arrayOfByte2 = getBytes(paramArrayOfInt[i]);
      PrintStream localPrintStream = System.out;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("1out->");
      localStringBuilder.append(paramArrayOfInt[i]);
      localPrintStream.println(localStringBuilder.toString());
      int j = 0;
      while (j < 4)
      {
        arrayOfByte1[(i * 4 + j)] = arrayOfByte2[j];
        j += 1;
      }
      i += 1;
    }
    return arrayOfByte1;
  }
  
  public byte[] Longs2Bytes(long[] paramArrayOfLong)
  {
    byte[] arrayOfByte1 = new byte[paramArrayOfLong.length * 8];
    int i = 0;
    while (i < paramArrayOfLong.length)
    {
      byte[] arrayOfByte2 = getBytes(paramArrayOfLong[i]);
      int j = 0;
      while (j < 8)
      {
        arrayOfByte1[(i * 8 + j)] = arrayOfByte2[j];
        j += 1;
      }
      i += 1;
    }
    return arrayOfByte1;
  }
  
  public void Shorts2Bytes(short[] paramArrayOfShort, byte[] paramArrayOfByte)
  {
    int i = 0;
    while (i < paramArrayOfShort.length)
    {
      System.arraycopy(getBytes(paramArrayOfShort[i]), 0, paramArrayOfByte, i * 2, 2);
      i += 1;
    }
  }
  
  public byte[] Shorts2Bytes(short[] paramArrayOfShort)
  {
    byte[] arrayOfByte = new byte[paramArrayOfShort.length * 2];
    Shorts2Bytes(paramArrayOfShort, arrayOfByte);
    return arrayOfByte;
  }
  
  public byte[] getBytes(int paramInt)
  {
    return getBytes(paramInt, testCPU());
  }
  
  public byte[] getBytes(int paramInt, boolean paramBoolean)
  {
    byte[] arrayOfByte = new byte[4];
    if (paramBoolean)
    {
      i = arrayOfByte.length - 1;
      while (i >= 0)
      {
        arrayOfByte[i] = ((byte)(paramInt & 0xFF));
        paramInt >>= 8;
        i -= 1;
      }
    }
    System.out.println("1");
    int i = 0;
    while (i < arrayOfByte.length)
    {
      arrayOfByte[i] = ((byte)(paramInt & 0xFF));
      paramInt >>= 8;
      i += 1;
    }
    return arrayOfByte;
  }
  
  public byte[] getBytes(long paramLong)
  {
    return getBytes(paramLong, testCPU());
  }
  
  public byte[] getBytes(long paramLong, boolean paramBoolean)
  {
    byte[] arrayOfByte = new byte[8];
    if (paramBoolean)
    {
      i = arrayOfByte.length - 1;
      while (i >= 0)
      {
        arrayOfByte[i] = ((byte)(int)(paramLong & 0xFF));
        paramLong >>= 8;
        i -= 1;
      }
    }
    int i = 0;
    while (i < arrayOfByte.length)
    {
      arrayOfByte[i] = ((byte)(int)(paramLong & 0xFF));
      paramLong >>= 8;
      i += 1;
    }
    return arrayOfByte;
  }
  
  public byte[] getBytes(short paramShort)
  {
    return getBytes(paramShort, testCPU());
  }
  
  public byte[] getBytes(short paramShort, boolean paramBoolean)
  {
    byte[] arrayOfByte = new byte[2];
    if (paramBoolean)
    {
      i = arrayOfByte.length - 1;
      while (i >= 0)
      {
        arrayOfByte[i] = ((byte)(paramShort & 0xFF));
        paramShort = (short)(paramShort >> 8);
        i -= 1;
      }
    }
    int i = 0;
    while (i < arrayOfByte.length)
    {
      arrayOfByte[i] = ((byte)(paramShort & 0xFF));
      paramShort = (short)(paramShort >> 8);
      i += 1;
    }
    return arrayOfByte;
  }
  
  public int getInt(byte[] paramArrayOfByte)
  {
    return getInt(paramArrayOfByte, testCPU());
  }
  
  public int getInt(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length <= 4)
      {
        int i = 0;
        int j = 0;
        if (paramBoolean)
        {
          i = 0;
          for (;;)
          {
            k = i;
            if (j >= paramArrayOfByte.length) {
              break;
            }
            i = i << 8 | paramArrayOfByte[j] & 0xFF;
            j += 1;
          }
        }
        j = paramArrayOfByte.length - 1;
        while (j >= 0)
        {
          i = i << 8 | paramArrayOfByte[j] & 0xFF;
          j -= 1;
        }
        int k = i;
        return k;
      }
      throw new IllegalArgumentException("byte array size > 4 !");
    }
    paramArrayOfByte = new IllegalArgumentException("byte array is null!");
    for (;;)
    {
      throw paramArrayOfByte;
    }
  }
  
  public long getLong(byte[] paramArrayOfByte)
  {
    return getLong(paramArrayOfByte, testCPU());
  }
  
  public long getLong(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length <= 8)
      {
        long l1 = 0L;
        long l2;
        if (paramBoolean)
        {
          i = 0;
          for (;;)
          {
            l2 = l1;
            if (i >= paramArrayOfByte.length) {
              break;
            }
            l1 = l1 << 8 | paramArrayOfByte[i] & 0xFF;
            i += 1;
          }
        }
        int i = paramArrayOfByte.length - 1;
        for (;;)
        {
          l2 = l1;
          if (i < 0) {
            break;
          }
          l1 = l1 << 8 | paramArrayOfByte[i] & 0xFF;
          i -= 1;
        }
        return l2;
      }
      throw new IllegalArgumentException("byte array size > 8 !");
    }
    paramArrayOfByte = new IllegalArgumentException("byte array is null!");
    for (;;)
    {
      throw paramArrayOfByte;
    }
  }
  
  public short getShort(byte[] paramArrayOfByte)
  {
    return getShort(paramArrayOfByte, testCPU());
  }
  
  public short getShort(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length <= 2)
      {
        short s1 = 0;
        int i = 0;
        if (paramBoolean)
        {
          s1 = 0;
          for (;;)
          {
            s2 = s1;
            if (i >= paramArrayOfByte.length) {
              break;
            }
            s1 = (short)((short)(s1 << 8) | paramArrayOfByte[i] & 0xFF);
            i += 1;
          }
        }
        i = paramArrayOfByte.length - 1;
        while (i >= 0)
        {
          s1 = (short)((short)(s1 << 8) | paramArrayOfByte[i] & 0xFF);
          i -= 1;
        }
        short s2 = s1;
        return s2;
      }
      throw new IllegalArgumentException("byte array size > 2 !");
    }
    paramArrayOfByte = new IllegalArgumentException("byte array is null!");
    for (;;)
    {
      throw paramArrayOfByte;
    }
  }
  
  public boolean testCPU()
  {
    return ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.util.BytesTransUtil
 * JD-Core Version:    0.7.0.1
 */