package com.tencent.mobileqq.qfix.a;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.zip.GZIPInputStream;

public class a
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  
  public static int a(File paramFile1, File paramFile2, File paramFile3, int paramInt)
  {
    if ((paramFile1 != null) && (paramFile1.length() > 0L))
    {
      if (paramFile2 == null) {
        return 4;
      }
      if ((paramFile3 != null) && (paramFile3.length() > 0L))
      {
        BufferedInputStream localBufferedInputStream = new BufferedInputStream(new FileInputStream(paramFile1));
        byte[] arrayOfByte = new byte[(int)paramFile3.length()];
        paramFile3 = new FileInputStream(paramFile3);
        try
        {
          b.a(paramFile3, arrayOfByte, 0, arrayOfByte.length);
          paramFile3.close();
          paramFile1 = a(localBufferedInputStream, (int)paramFile1.length(), arrayOfByte, paramInt);
          paramFile2 = new FileOutputStream(paramFile2);
          try
          {
            paramFile2.write(paramFile1);
            return 1;
          }
          finally
          {
            paramFile2.close();
          }
          return 2;
        }
        finally
        {
          paramFile3.close();
        }
      }
    }
    return 3;
  }
  
  public static int a(InputStream paramInputStream1, InputStream paramInputStream2, File paramFile)
  {
    if (paramInputStream1 == null) {
      return 3;
    }
    if (paramFile == null) {
      return 4;
    }
    if (paramInputStream2 == null) {
      return 2;
    }
    paramInputStream1 = b.a(paramInputStream1);
    paramInputStream2 = b.a(paramInputStream2);
    paramInputStream1 = a(paramInputStream1, paramInputStream1.length, paramInputStream2, paramInputStream2.length, 0);
    paramInputStream2 = new FileOutputStream(paramFile);
    try
    {
      paramInputStream2.write(paramInputStream1);
      return 1;
    }
    finally
    {
      paramInputStream2.close();
    }
  }
  
  public static int a(RandomAccessFile paramRandomAccessFile, int paramInt1, byte[] paramArrayOfByte, int paramInt2, File paramFile, int paramInt3)
  {
    Object localObject1;
    int j;
    Object localObject2;
    int[] arrayOfInt;
    int i;
    label241:
    label250:
    byte[] arrayOfByte1;
    label257:
    byte[] arrayOfByte2;
    if ((paramRandomAccessFile != null) && (paramInt1 > 0))
    {
      if (paramFile == null) {
        return 4;
      }
      if ((paramArrayOfByte != null) && (paramInt2 > 0))
      {
        localObject1 = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte, 0, paramInt2));
        ((DataInputStream)localObject1).skip(8L);
        long l1 = ((DataInputStream)localObject1).readLong();
        long l2 = ((DataInputStream)localObject1).readLong();
        j = (int)((DataInputStream)localObject1).readLong();
        ((DataInputStream)localObject1).close();
        localObject1 = new ByteArrayInputStream(paramArrayOfByte, 0, paramInt2);
        ((InputStream)localObject1).skip(32L);
        localObject1 = new DataInputStream(new GZIPInputStream((InputStream)localObject1));
        localObject2 = new ByteArrayInputStream(paramArrayOfByte, 0, paramInt2);
        ((InputStream)localObject2).skip(l1 + 32L);
        localObject2 = new GZIPInputStream((InputStream)localObject2);
        paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte, 0, paramInt2);
        paramArrayOfByte.skip(l2 + l1 + 32L);
        paramArrayOfByte = new GZIPInputStream(paramArrayOfByte);
        paramFile = new FileOutputStream(paramFile);
        for (;;)
        {
          try
          {
            arrayOfInt = new int[3];
            paramInt3 = 0;
            paramInt2 = 0;
            break;
          }
          finally {}
          if (i > 2) {
            break label547;
          }
          arrayOfInt[i] = ((DataInputStream)localObject1).readInt();
          i += 1;
          continue;
          do
          {
            paramFile.close();
            paramRandomAccessFile.close();
            paramFile.close();
            return 2;
            arrayOfByte1 = new byte[arrayOfInt[0]];
          } while (!b.a((InputStream)localObject2, arrayOfByte1, 0, arrayOfInt[0]));
          arrayOfByte2 = new byte[arrayOfInt[0]];
          i = arrayOfInt[0];
        }
      }
    }
    for (;;)
    {
      try
      {
        if (paramRandomAccessFile.read(arrayOfByte2, 0, i) < arrayOfInt[0])
        {
          paramFile.close();
          paramRandomAccessFile.close();
          break label250;
        }
        i = 0;
        if (i < arrayOfInt[0])
        {
          int k = paramInt2 + i;
          if ((k < 0) || (k >= paramInt1)) {
            break label562;
          }
          arrayOfByte1[i] = ((byte)(arrayOfByte1[i] + arrayOfByte2[i]));
          break label562;
        }
        paramFile.write(arrayOfByte1);
        paramInt3 += arrayOfInt[0];
        i = arrayOfInt[0];
        if (arrayOfInt[1] + paramInt3 > j) {
          continue;
        }
        arrayOfByte1 = new byte[arrayOfInt[1]];
        if (!b.a(paramArrayOfByte, arrayOfByte1, 0, arrayOfInt[1]))
        {
          paramFile.close();
          paramRandomAccessFile.close();
          paramFile.close();
          return 2;
        }
        paramFile.write(arrayOfByte1);
        paramFile.flush();
        paramInt3 += arrayOfInt[1];
        paramInt2 = paramInt2 + i + arrayOfInt[2];
        paramRandomAccessFile.seek(paramInt2);
      }
      finally
      {
        break label519;
      }
      ((DataInputStream)localObject1).close();
      ((InputStream)localObject2).close();
      paramArrayOfByte.close();
      paramRandomAccessFile.close();
      paramFile.close();
      return 1;
      label519:
      paramRandomAccessFile.close();
      paramFile.close();
      throw paramArrayOfByte;
      return 2;
      return 3;
      if (paramInt3 < j)
      {
        i = 0;
        break;
        label547:
        if (arrayOfInt[0] + paramInt3 <= j) {
          break label257;
        }
        break label241;
        label562:
        i += 1;
      }
    }
  }
  
  public static int a(RandomAccessFile paramRandomAccessFile, File paramFile1, File paramFile2, int paramInt)
  {
    if ((paramRandomAccessFile != null) && (paramRandomAccessFile.length() > 0L))
    {
      if (paramFile1 == null) {
        return 4;
      }
      if ((paramFile2 != null) && (paramFile2.length() > 0L))
      {
        byte[] arrayOfByte = new byte[(int)paramFile2.length()];
        paramFile2 = new FileInputStream(paramFile2);
        try
        {
          b.a(paramFile2, arrayOfByte, 0, arrayOfByte.length);
          return a(paramRandomAccessFile, (int)paramRandomAccessFile.length(), arrayOfByte, arrayOfByte.length, paramFile1, paramInt);
        }
        finally
        {
          paramFile2.close();
        }
      }
      return 2;
    }
    return 3;
  }
  
  public static byte[] a(InputStream paramInputStream, int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    byte[] arrayOfByte = new byte[paramInt1];
    b.a(paramInputStream, arrayOfByte, 0, paramInt1);
    paramInputStream.close();
    return a(arrayOfByte, paramInt1, paramArrayOfByte, paramArrayOfByte.length, paramInt2);
  }
  
  public static byte[] a(InputStream paramInputStream1, InputStream paramInputStream2)
  {
    if (paramInputStream1 == null) {
      return null;
    }
    if (paramInputStream2 == null) {
      return null;
    }
    paramInputStream1 = b.a(paramInputStream1);
    paramInputStream2 = b.a(paramInputStream2);
    return a(paramInputStream1, paramInputStream1.length, paramInputStream2, paramInputStream2.length, 0);
  }
  
  public static byte[] a(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3)
  {
    Object localObject1 = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte2, 0, paramInt2));
    ((DataInputStream)localObject1).skip(8L);
    long l1 = ((DataInputStream)localObject1).readLong();
    long l2 = ((DataInputStream)localObject1).readLong();
    int j = (int)((DataInputStream)localObject1).readLong();
    ((DataInputStream)localObject1).close();
    localObject1 = new ByteArrayInputStream(paramArrayOfByte2, 0, paramInt2);
    ((InputStream)localObject1).skip(32L);
    localObject1 = new DataInputStream(new GZIPInputStream((InputStream)localObject1));
    Object localObject2 = new ByteArrayInputStream(paramArrayOfByte2, 0, paramInt2);
    ((InputStream)localObject2).skip(l1 + 32L);
    localObject2 = new GZIPInputStream((InputStream)localObject2);
    paramArrayOfByte2 = new ByteArrayInputStream(paramArrayOfByte2, 0, paramInt2);
    paramArrayOfByte2.skip(l2 + l1 + 32L);
    paramArrayOfByte2 = new GZIPInputStream(paramArrayOfByte2);
    byte[] arrayOfByte = new byte[j];
    int[] arrayOfInt = new int[3];
    paramInt3 = 0;
    paramInt2 = 0;
    while (paramInt3 < j)
    {
      int i = 0;
      while (i <= 2)
      {
        arrayOfInt[i] = ((DataInputStream)localObject1).readInt();
        i += 1;
      }
      if (arrayOfInt[0] + paramInt3 <= j)
      {
        if (b.a((InputStream)localObject2, arrayOfByte, paramInt3, arrayOfInt[0]))
        {
          i = 0;
          while (i < arrayOfInt[0])
          {
            int k = paramInt2 + i;
            if ((k >= 0) && (k < paramInt1))
            {
              int m = paramInt3 + i;
              arrayOfByte[m] = ((byte)(arrayOfByte[m] + paramArrayOfByte1[k]));
            }
            i += 1;
          }
          paramInt3 += arrayOfInt[0];
          i = arrayOfInt[0];
          if (arrayOfInt[1] + paramInt3 <= j)
          {
            if (b.a(paramArrayOfByte2, arrayOfByte, paramInt3, arrayOfInt[1]))
            {
              paramInt3 += arrayOfInt[1];
              paramInt2 = paramInt2 + i + arrayOfInt[2];
            }
            else
            {
              throw new IOException("Corrupt by wrong patch file.");
            }
          }
          else {
            throw new IOException("Corrupt by wrong patch file.");
          }
        }
        else
        {
          throw new IOException("Corrupt by wrong patch file.");
        }
      }
      else {
        throw new IOException("Corrupt by wrong patch file.");
      }
    }
    ((DataInputStream)localObject1).close();
    ((InputStream)localObject2).close();
    paramArrayOfByte2.close();
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qfix.a.a
 * JD-Core Version:    0.7.0.1
 */