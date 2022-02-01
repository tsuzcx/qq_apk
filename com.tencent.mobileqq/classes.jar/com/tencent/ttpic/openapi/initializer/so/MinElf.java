package com.tencent.ttpic.openapi.initializer.so;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;

public final class MinElf
{
  public static final int DT_NEEDED = 1;
  public static final int DT_NULL = 0;
  public static final int DT_STRTAB = 5;
  public static final int ELF_MAGIC = 1179403647;
  public static final int PN_XNUM = 65535;
  public static final int PT_DYNAMIC = 2;
  public static final int PT_LOAD = 1;
  
  public static String[] extract_DT_NEEDED(File paramFile)
  {
    paramFile = new FileInputStream(paramFile);
    try
    {
      String[] arrayOfString = extract_DT_NEEDED(paramFile.getChannel());
      return arrayOfString;
    }
    finally
    {
      paramFile.close();
    }
  }
  
  public static String[] extract_DT_NEEDED(FileChannel paramFileChannel)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(8);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    if (getu32(paramFileChannel, localByteBuffer, 0L) != 1179403647L) {
      throw new MinElf.ElfError("file is not ELF");
    }
    int j;
    long l1;
    label92:
    long l2;
    label108:
    int k;
    label122:
    long l4;
    label150:
    label168:
    long l6;
    if (getu8(paramFileChannel, localByteBuffer, 4L) == 1)
    {
      j = 1;
      if (getu8(paramFileChannel, localByteBuffer, 5L) == 2) {
        localByteBuffer.order(ByteOrder.BIG_ENDIAN);
      }
      if (j == 0) {
        break label255;
      }
      l1 = getu32(paramFileChannel, localByteBuffer, 28L);
      if (j == 0) {
        break label269;
      }
      l2 = getu16(paramFileChannel, localByteBuffer, 44L);
      if (j == 0) {
        break label284;
      }
      k = getu16(paramFileChannel, localByteBuffer, 42L);
      l4 = l2;
      if (l2 == 65535L)
      {
        if (j == 0) {
          break label297;
        }
        l2 = getu32(paramFileChannel, localByteBuffer, 32L);
        if (j == 0) {
          break label311;
        }
        l4 = getu32(paramFileChannel, localByteBuffer, l2 + 28L);
      }
      l6 = 0L;
      l3 = 0L;
      l5 = l1;
    }
    for (;;)
    {
      l2 = l6;
      if (l3 < l4)
      {
        if (j == 0) {
          break label328;
        }
        l2 = getu32(paramFileChannel, localByteBuffer, 0L + l5);
        label206:
        if (l2 != 2L) {
          break label360;
        }
        if (j == 0) {
          break label343;
        }
      }
      label269:
      label284:
      label297:
      label311:
      label328:
      label343:
      for (l2 = getu32(paramFileChannel, localByteBuffer, 4L + l5);; l2 = get64(paramFileChannel, localByteBuffer, 8L + l5))
      {
        if (l2 != 0L) {
          break label376;
        }
        throw new MinElf.ElfError("ELF file does not contain dynamic linking information");
        j = 0;
        break;
        label255:
        l1 = get64(paramFileChannel, localByteBuffer, 32L);
        break label92;
        l2 = getu16(paramFileChannel, localByteBuffer, 56L);
        break label108;
        k = getu16(paramFileChannel, localByteBuffer, 54L);
        break label122;
        l2 = get64(paramFileChannel, localByteBuffer, 40L);
        break label150;
        l4 = getu32(paramFileChannel, localByteBuffer, l2 + 44L);
        break label168;
        l2 = getu32(paramFileChannel, localByteBuffer, 0L + l5);
        break label206;
      }
      label360:
      l5 += k;
      l3 = 1L + l3;
    }
    label376:
    int i = 0;
    long l3 = 0L;
    long l5 = l2;
    if (j != 0) {
      l6 = getu32(paramFileChannel, localByteBuffer, 0L + l5);
    }
    while (l6 == 1L) {
      if (i == 2147483647)
      {
        throw new MinElf.ElfError("malformed DT_NEEDED section");
        l6 = get64(paramFileChannel, localByteBuffer, 0L + l5);
      }
      else
      {
        i += 1;
      }
    }
    label681:
    label942:
    for (;;)
    {
      long l7;
      if (j != 0) {
        l7 = 8L;
      }
      label559:
      label698:
      for (;;)
      {
        label584:
        label715:
        label849:
        if (l6 == 0L) {
          label602:
          label732:
          label866:
          label870:
          if (l3 == 0L)
          {
            throw new MinElf.ElfError("Dynamic section string-table not found");
            if (l6 != 5L) {
              break label942;
            }
            if (j != 0) {}
            for (l3 = getu32(paramFileChannel, localByteBuffer, 4L + l5);; l3 = get64(paramFileChannel, localByteBuffer, 8L + l5)) {
              break;
            }
            l7 = 16L;
          }
          else
          {
            int m = 0;
            if (m < l4) {
              if (j != 0)
              {
                l5 = getu32(paramFileChannel, localByteBuffer, 0L + l1);
                if (l5 != 1L) {
                  break label732;
                }
                if (j == 0) {
                  break label681;
                }
                l5 = getu32(paramFileChannel, localByteBuffer, 8L + l1);
                if (j == 0) {
                  break label698;
                }
                l6 = getu32(paramFileChannel, localByteBuffer, 20L + l1);
                if ((l5 > l3) || (l3 >= l6 + l5)) {
                  break label732;
                }
                if (j == 0) {
                  break label715;
                }
                l1 = getu32(paramFileChannel, localByteBuffer, 4L + l1);
              }
            }
            label639:
            for (l1 += l3 - l5;; l1 = 0L)
            {
              if (l1 == 0L)
              {
                throw new MinElf.ElfError("did not find file offset of DT_STRTAB table");
                l5 = getu32(paramFileChannel, localByteBuffer, 0L + l1);
                break label559;
                l5 = get64(paramFileChannel, localByteBuffer, 16L + l1);
                break label584;
                l6 = get64(paramFileChannel, localByteBuffer, 40L + l1);
                break label602;
                l1 = get64(paramFileChannel, localByteBuffer, 8L + l1);
                break label639;
                l5 = k;
                m += 1;
                l1 = l5 + l1;
                break;
              }
              String[] arrayOfString = new String[i];
              for (i = 0;; i = k)
              {
                if (j != 0)
                {
                  l3 = getu32(paramFileChannel, localByteBuffer, 0L + l2);
                  k = i;
                  if (l3 != 1L) {
                    break label870;
                  }
                  if (j == 0) {
                    break label849;
                  }
                }
                for (l4 = getu32(paramFileChannel, localByteBuffer, 4L + l2);; l4 = get64(paramFileChannel, localByteBuffer, 8L + l2))
                {
                  arrayOfString[i] = getSz(paramFileChannel, localByteBuffer, l4 + l1);
                  if (i != 2147483647) {
                    break label866;
                  }
                  throw new MinElf.ElfError("malformed DT_NEEDED section");
                  l3 = get64(paramFileChannel, localByteBuffer, 0L + l2);
                  break;
                }
                k = i + 1;
                if (j != 0) {
                  l4 = 8L;
                }
                while (l3 == 0L) {
                  if (k != arrayOfString.length)
                  {
                    throw new MinElf.ElfError("malformed DT_NEEDED section");
                    l4 = 16L;
                  }
                  else
                  {
                    return arrayOfString;
                  }
                }
                l2 = l4 + l2;
              }
            }
          }
        }
      }
      l5 = l7 + l5;
      break;
    }
  }
  
  private static long get64(FileChannel paramFileChannel, ByteBuffer paramByteBuffer, long paramLong)
  {
    read(paramFileChannel, paramByteBuffer, 8, paramLong);
    return paramByteBuffer.getLong();
  }
  
  private static String getSz(FileChannel paramFileChannel, ByteBuffer paramByteBuffer, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      int i = getu8(paramFileChannel, paramByteBuffer, paramLong);
      if (i == 0) {
        break;
      }
      localStringBuilder.append((char)i);
      paramLong = 1L + paramLong;
    }
    return localStringBuilder.toString();
  }
  
  private static int getu16(FileChannel paramFileChannel, ByteBuffer paramByteBuffer, long paramLong)
  {
    read(paramFileChannel, paramByteBuffer, 2, paramLong);
    return paramByteBuffer.getShort() & 0xFFFF;
  }
  
  private static long getu32(FileChannel paramFileChannel, ByteBuffer paramByteBuffer, long paramLong)
  {
    read(paramFileChannel, paramByteBuffer, 4, paramLong);
    return paramByteBuffer.getInt() & 0xFFFFFFFF;
  }
  
  private static short getu8(FileChannel paramFileChannel, ByteBuffer paramByteBuffer, long paramLong)
  {
    read(paramFileChannel, paramByteBuffer, 1, paramLong);
    return (short)(paramByteBuffer.get() & 0xFF);
  }
  
  private static void read(FileChannel paramFileChannel, ByteBuffer paramByteBuffer, int paramInt, long paramLong)
  {
    paramByteBuffer.position(0);
    paramByteBuffer.limit(paramInt);
    for (;;)
    {
      if (paramByteBuffer.remaining() > 0)
      {
        paramInt = paramFileChannel.read(paramByteBuffer, paramLong);
        if (paramInt != -1) {}
      }
      else
      {
        if (paramByteBuffer.remaining() <= 0) {
          break;
        }
        throw new MinElf.ElfError("ELF file truncated");
      }
      paramLong += paramInt;
    }
    paramByteBuffer.position(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.initializer.so.MinElf
 * JD-Core Version:    0.7.0.1
 */