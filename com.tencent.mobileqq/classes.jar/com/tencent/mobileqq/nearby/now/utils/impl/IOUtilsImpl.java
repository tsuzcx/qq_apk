package com.tencent.mobileqq.nearby.now.utils.impl;

import com.tencent.mobileqq.nearby.now.utils.IIOUtils;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

public class IOUtilsImpl
  implements IIOUtils
{
  private static final int MAX_BUFFER_BYTES = 1024;
  
  public ReadableByteChannel getChannel(InputStream paramInputStream)
  {
    if (paramInputStream != null) {
      return Channels.newChannel(paramInputStream);
    }
    return null;
  }
  
  public WritableByteChannel getChannel(OutputStream paramOutputStream)
  {
    if (paramOutputStream != null) {
      return Channels.newChannel(paramOutputStream);
    }
    return null;
  }
  
  /* Error */
  public byte[] getFileMD5(java.io.File paramFile)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 36	java/io/File:isFile	()Z
    //   4: istore_3
    //   5: aconst_null
    //   6: astore 5
    //   8: iload_3
    //   9: ifne +5 -> 14
    //   12: aconst_null
    //   13: areturn
    //   14: sipush 1024
    //   17: newarray byte
    //   19: astore 7
    //   21: ldc 38
    //   23: invokestatic 44	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   26: astore 6
    //   28: new 46	java/io/FileInputStream
    //   31: dup
    //   32: aload_1
    //   33: invokespecial 49	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   36: astore 4
    //   38: aload 4
    //   40: astore_1
    //   41: aload 4
    //   43: aload 7
    //   45: iconst_0
    //   46: sipush 1024
    //   49: invokevirtual 53	java/io/FileInputStream:read	([BII)I
    //   52: istore_2
    //   53: iload_2
    //   54: iconst_m1
    //   55: if_icmpeq +18 -> 73
    //   58: aload 4
    //   60: astore_1
    //   61: aload 6
    //   63: aload 7
    //   65: iconst_0
    //   66: iload_2
    //   67: invokevirtual 57	java/security/MessageDigest:update	([BII)V
    //   70: goto -32 -> 38
    //   73: aload 4
    //   75: invokevirtual 60	java/io/FileInputStream:close	()V
    //   78: aload 6
    //   80: invokevirtual 64	java/security/MessageDigest:digest	()[B
    //   83: areturn
    //   84: astore 5
    //   86: goto +16 -> 102
    //   89: astore_1
    //   90: aload 5
    //   92: astore 4
    //   94: goto +36 -> 130
    //   97: astore 5
    //   99: aconst_null
    //   100: astore 4
    //   102: aload 4
    //   104: astore_1
    //   105: aload 5
    //   107: invokevirtual 67	java/lang/Exception:printStackTrace	()V
    //   110: aload 4
    //   112: ifnull +8 -> 120
    //   115: aload 4
    //   117: invokevirtual 60	java/io/FileInputStream:close	()V
    //   120: aconst_null
    //   121: areturn
    //   122: astore 5
    //   124: aload_1
    //   125: astore 4
    //   127: aload 5
    //   129: astore_1
    //   130: aload 4
    //   132: ifnull +8 -> 140
    //   135: aload 4
    //   137: invokevirtual 60	java/io/FileInputStream:close	()V
    //   140: goto +5 -> 145
    //   143: aload_1
    //   144: athrow
    //   145: goto -2 -> 143
    //   148: astore_1
    //   149: goto -71 -> 78
    //   152: astore_1
    //   153: aconst_null
    //   154: areturn
    //   155: astore 4
    //   157: goto -17 -> 140
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	this	IOUtilsImpl
    //   0	160	1	paramFile	java.io.File
    //   52	15	2	i	int
    //   4	5	3	bool	boolean
    //   36	100	4	localObject1	Object
    //   155	1	4	localIOException	java.io.IOException
    //   6	1	5	localObject2	Object
    //   84	7	5	localException1	java.lang.Exception
    //   97	9	5	localException2	java.lang.Exception
    //   122	6	5	localObject3	Object
    //   26	53	6	localMessageDigest	java.security.MessageDigest
    //   19	45	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   41	53	84	java/lang/Exception
    //   61	70	84	java/lang/Exception
    //   21	38	89	finally
    //   21	38	97	java/lang/Exception
    //   41	53	122	finally
    //   61	70	122	finally
    //   105	110	122	finally
    //   73	78	148	java/io/IOException
    //   115	120	152	java/io/IOException
    //   135	140	155	java/io/IOException
  }
  
  public int indexOf(byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte2 != null))
    {
      int j = paramArrayOfByte1.length;
      int k = paramArrayOfByte2.length;
      if ((paramInt < j) && (j - paramInt >= k))
      {
        while (paramInt <= j - k)
        {
          int i = 0;
          while ((i < k) && (paramArrayOfByte1[(paramInt + i)] == paramArrayOfByte2[i])) {
            i += 1;
          }
          if (i == k) {
            return paramInt;
          }
          paramInt += 1;
        }
        return -1;
      }
      return -1;
    }
    paramArrayOfByte1 = new NullPointerException("source or target array is null!");
    for (;;)
    {
      throw paramArrayOfByte1;
    }
  }
  
  public byte[] numberToBytes(long paramLong, int paramInt, boolean paramBoolean)
  {
    byte[] arrayOfByte = new byte[paramInt];
    int i;
    if (paramBoolean) {
      i = paramInt - 1;
    } else {
      i = 0;
    }
    int j = -1;
    if (paramBoolean) {
      paramInt = -1;
    }
    if (!paramBoolean) {
      j = 1;
    }
    while (i != paramInt)
    {
      arrayOfByte[i] = ((byte)(int)(0xFF & paramLong));
      paramLong >>>= 8;
      i += j;
    }
    return arrayOfByte;
  }
  
  public byte[] readBytes(InputStream paramInputStream, int paramInt)
  {
    if (paramInt <= 0) {
      return null;
    }
    int i = 0;
    byte[] arrayOfByte = new byte[paramInt];
    while (i < paramInt) {
      try
      {
        int j = paramInputStream.read(arrayOfByte, i, paramInt - i);
        if (j > 0) {
          i += j;
        }
      }
      finally {}
    }
    return arrayOfByte;
  }
  
  public float readFloat(InputStream paramInputStream)
  {
    return readFloat(paramInputStream, true);
  }
  
  public float readFloat(InputStream paramInputStream, boolean paramBoolean)
  {
    return Float.intBitsToFloat((int)readInt(paramInputStream, paramBoolean));
  }
  
  public long readInt(InputStream paramInputStream)
  {
    return readNumber(paramInputStream, 4, true);
  }
  
  public long readInt(InputStream paramInputStream, boolean paramBoolean)
  {
    return readNumber(paramInputStream, 4, paramBoolean);
  }
  
  public long readNumber(InputStream paramInputStream, int paramInt, boolean paramBoolean)
  {
    if ((paramInt > 0) && (paramInt <= 8))
    {
      byte[] arrayOfByte = new byte[paramInt];
      if (paramInputStream.markSupported()) {
        paramInputStream.mark(paramInt);
      }
      int j = 0;
      int i = paramInputStream.read(arrayOfByte, 0, paramInt);
      if (i <= 0) {
        return -1L;
      }
      if (paramBoolean) {
        paramInt = j;
      } else {
        paramInt = i - 1;
      }
      j = -1;
      if (!paramBoolean) {
        i = -1;
      }
      if (paramBoolean) {
        j = 1;
      }
      long l = 0L;
      while (paramInt != i)
      {
        l = l << 8 | arrayOfByte[paramInt] & 0xFF;
        paramInt += j;
      }
      return l;
    }
    paramInputStream = new IllegalArgumentException("length must between 1 and 8.");
    for (;;)
    {
      throw paramInputStream;
    }
  }
  
  public String readString(InputStream paramInputStream, int paramInt)
  {
    int i = Math.min(paramInt, 1024);
    byte[] arrayOfByte = new byte[i];
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(1024);
    for (;;)
    {
      if (paramInt > 0) {}
      try
      {
        int j = paramInputStream.read(arrayOfByte, 0, i);
        if (j != -1)
        {
          localByteArrayOutputStream.write(arrayOfByte, 0, j);
          paramInt -= j;
        }
        else
        {
          paramInputStream = localByteArrayOutputStream.toString();
          localByteArrayOutputStream.close();
          return paramInputStream;
        }
      }
      finally
      {
        localByteArrayOutputStream.close();
      }
    }
    for (;;)
    {
      throw paramInputStream;
    }
  }
  
  public String readString(InputStream paramInputStream, int paramInt, String paramString)
  {
    int i = Math.min(paramInt, 1024);
    byte[] arrayOfByte = new byte[i];
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(1024);
    while (paramInt > 0)
    {
      int j = paramInputStream.read(arrayOfByte, 0, i);
      if (j == -1) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, j);
      paramInt -= j;
    }
    paramInputStream = localByteArrayOutputStream.toString(paramString);
    localByteArrayOutputStream.close();
    return paramInputStream;
  }
  
  public void skip(InputStream paramInputStream, int paramInt)
  {
    if ((paramInputStream != null) && (paramInt > 0))
    {
      byte[] arrayOfByte = new byte[512];
      int i;
      do
      {
        i = paramInputStream.read(arrayOfByte, 0, Math.min(arrayOfByte.length, paramInt));
        if (i < 0) {
          return;
        }
        i = paramInt - i;
        paramInt = i;
      } while (i > 0);
    }
  }
  
  public void writeFloat(OutputStream paramOutputStream, float paramFloat)
  {
    writeFloat(paramOutputStream, paramFloat, true);
  }
  
  public void writeFloat(OutputStream paramOutputStream, float paramFloat, boolean paramBoolean)
  {
    writeInt(paramOutputStream, Float.floatToIntBits(paramFloat), paramBoolean);
  }
  
  public void writeInt(OutputStream paramOutputStream, long paramLong)
  {
    paramOutputStream.write(new byte[] { (byte)(int)(paramLong >> 24 & 0xFF), (byte)(int)(paramLong >> 16 & 0xFF), (byte)(int)(paramLong >> 8 & 0xFF), (byte)(int)(paramLong & 0xFF) });
    paramOutputStream.flush();
  }
  
  public void writeInt(OutputStream paramOutputStream, long paramLong, boolean paramBoolean)
  {
    writeNumber(paramOutputStream, paramLong, 4, paramBoolean);
  }
  
  public void writeNumber(OutputStream paramOutputStream, long paramLong, int paramInt, boolean paramBoolean)
  {
    if ((paramInt > 0) && (paramInt <= 8))
    {
      paramOutputStream.write(numberToBytes(paramLong, paramInt, paramBoolean));
      paramOutputStream.flush();
      return;
    }
    throw new IllegalArgumentException("length must between 1 and 8.");
  }
  
  public void writeShort(OutputStream paramOutputStream, int paramInt)
  {
    paramOutputStream.write(new byte[] { (byte)(paramInt >> 8 & 0xFF), (byte)(paramInt & 0xFF) });
    paramOutputStream.flush();
  }
  
  public void writeShort(OutputStream paramOutputStream, int paramInt, boolean paramBoolean)
  {
    writeNumber(paramOutputStream, paramInt, 2, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.utils.impl.IOUtilsImpl
 * JD-Core Version:    0.7.0.1
 */