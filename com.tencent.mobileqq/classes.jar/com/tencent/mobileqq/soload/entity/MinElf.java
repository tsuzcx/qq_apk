package com.tencent.mobileqq.soload.entity;

import com.tencent.mobileqq.soload.util.SoLoadUtils;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;

public class MinElf
{
  public static String[] a(File paramFile)
  {
    paramFile = new FileInputStream(paramFile);
    try
    {
      String[] arrayOfString = a(paramFile.getChannel());
      return arrayOfString;
    }
    finally
    {
      paramFile.close();
    }
  }
  
  public static String[] a(FileChannel paramFileChannel)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(8);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    if (SoLoadUtils.b(paramFileChannel, localByteBuffer, 0L) == 1179403647L)
    {
      if (SoLoadUtils.a(paramFileChannel, localByteBuffer, 5L) == 2) {
        localByteBuffer.order(ByteOrder.BIG_ENDIAN);
      }
      int j = SoLoadUtils.a(paramFileChannel, localByteBuffer, 4L);
      int i = 1;
      if (j != 1) {
        i = 0;
      }
      long l2;
      if (i != 0) {
        l2 = SoLoadUtils.b(paramFileChannel, localByteBuffer, 28L);
      } else {
        l2 = SoLoadUtils.a(paramFileChannel, localByteBuffer, 32L);
      }
      if (i != 0) {
        l1 = SoLoadUtils.a(paramFileChannel, localByteBuffer, 44L);
      } else {
        l1 = SoLoadUtils.a(paramFileChannel, localByteBuffer, 56L);
      }
      if (i != 0) {
        l3 = 42L;
      } else {
        l3 = 54L;
      }
      int n = SoLoadUtils.a(paramFileChannel, localByteBuffer, l3);
      long l3 = l1;
      if (l1 == 65535L)
      {
        if (i != 0) {
          l1 = SoLoadUtils.b(paramFileChannel, localByteBuffer, 32L);
        } else {
          l1 = SoLoadUtils.a(paramFileChannel, localByteBuffer, 40L);
        }
        if (i != 0) {
          l1 += 28L;
        } else {
          l1 += 44L;
        }
        l3 = SoLoadUtils.b(paramFileChannel, localByteBuffer, l1);
      }
      long l4 = l2;
      for (long l1 = 0L; l1 < l3; l1 += 1L)
      {
        if (SoLoadUtils.b(paramFileChannel, localByteBuffer, l4) == 2L)
        {
          if (i != 0)
          {
            l1 = SoLoadUtils.b(paramFileChannel, localByteBuffer, l4 + 4L);
            break label324;
          }
          l1 = SoLoadUtils.a(paramFileChannel, localByteBuffer, l4 + 8L);
          break label324;
        }
        l4 += n;
      }
      l1 = 0L;
      label324:
      if (l1 != 0L)
      {
        long l5 = l1;
        l4 = 0L;
        int k;
        for (int m = 0;; m = k)
        {
          long l6;
          if (i != 0) {
            l6 = SoLoadUtils.b(paramFileChannel, localByteBuffer, l5 + 0L);
          } else {
            l6 = SoLoadUtils.a(paramFileChannel, localByteBuffer, l5 + 0L);
          }
          j = i;
          if (l6 == 1L)
          {
            if (m != 2147483647) {
              k = m + 1;
            } else {
              throw new MinElf.ElfError("malformed DT_NEEDED section");
            }
          }
          else
          {
            k = m;
            if (l6 == 5L)
            {
              if (j != 0) {
                l4 = SoLoadUtils.b(paramFileChannel, localByteBuffer, l5 + 4L);
              } else {
                l4 = SoLoadUtils.a(paramFileChannel, localByteBuffer, l5 + 8L);
              }
              k = m;
            }
          }
          long l7;
          if (j != 0) {
            l7 = 8L;
          } else {
            l7 = 16L;
          }
          l5 += l7;
          if (l6 == 0L)
          {
            if (l4 != 0L)
            {
              i = 0;
              while (i < l3)
              {
                if (SoLoadUtils.b(paramFileChannel, localByteBuffer, l2) == 1L)
                {
                  if (j != 0) {
                    l5 = SoLoadUtils.b(paramFileChannel, localByteBuffer, l2 + 8L);
                  } else {
                    l5 = SoLoadUtils.a(paramFileChannel, localByteBuffer, l2 + 16L);
                  }
                  if (j != 0) {
                    l6 = SoLoadUtils.b(paramFileChannel, localByteBuffer, l2 + 20L);
                  } else {
                    l6 = SoLoadUtils.a(paramFileChannel, localByteBuffer, l2 + 40L);
                  }
                  if ((l5 <= l4) && (l4 < l6 + l5))
                  {
                    if (j != 0) {
                      l2 = SoLoadUtils.b(paramFileChannel, localByteBuffer, l2 + 4L);
                    } else {
                      l2 = SoLoadUtils.a(paramFileChannel, localByteBuffer, l2 + 8L);
                    }
                    l2 += l4 - l5;
                    break label672;
                  }
                }
                l2 += n;
                i += 1;
              }
              l2 = 0L;
              if (l2 != 0L)
              {
                String[] arrayOfString = new String[k];
                i = 0;
                for (;;)
                {
                  if (j != 0) {
                    l3 = SoLoadUtils.b(paramFileChannel, localByteBuffer, l1);
                  } else {
                    l3 = SoLoadUtils.a(paramFileChannel, localByteBuffer, l1);
                  }
                  if (l3 == 1L)
                  {
                    if (j != 0) {
                      l4 = SoLoadUtils.b(paramFileChannel, localByteBuffer, l1 + 4L);
                    } else {
                      l4 = SoLoadUtils.a(paramFileChannel, localByteBuffer, l1 + 8L);
                    }
                    arrayOfString[i] = SoLoadUtils.a(paramFileChannel, localByteBuffer, l4 + l2);
                    i += 1;
                  }
                  if (j != 0) {
                    l4 = 8L;
                  } else {
                    l4 = 16L;
                  }
                  l1 += l4;
                  if (l3 == 0L)
                  {
                    if (i == arrayOfString.length) {
                      return arrayOfString;
                    }
                    throw new MinElf.ElfError("malformed DT_NEEDED section");
                  }
                }
              }
              throw new MinElf.ElfError("did not find file offset of DT_STRTAB table");
            }
            throw new MinElf.ElfError("Dynamic section string-table not found");
          }
          i = j;
        }
      }
      label672:
      throw new MinElf.ElfError("ELF file does not contain dynamic linking information");
    }
    paramFileChannel = new MinElf.ElfError("file is not ELF");
    for (;;)
    {
      throw paramFileChannel;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.soload.entity.MinElf
 * JD-Core Version:    0.7.0.1
 */