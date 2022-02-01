package org.apache.commons.io.filefilter;

import java.io.Serializable;
import java.nio.charset.Charset;

public class MagicNumberFileFilter
  extends AbstractFileFilter
  implements Serializable
{
  private static final long serialVersionUID = -547733176983104172L;
  private final long byteOffset;
  private final byte[] magicNumbers;
  
  public MagicNumberFileFilter(String paramString)
  {
    this(paramString, 0L);
  }
  
  public MagicNumberFileFilter(String paramString, long paramLong)
  {
    if (paramString != null)
    {
      if (!paramString.isEmpty())
      {
        if (paramLong >= 0L)
        {
          this.magicNumbers = paramString.getBytes(Charset.defaultCharset());
          this.byteOffset = paramLong;
          return;
        }
        throw new IllegalArgumentException("The offset cannot be negative");
      }
      throw new IllegalArgumentException("The magic number must contain at least one byte");
    }
    throw new IllegalArgumentException("The magic number cannot be null");
  }
  
  public MagicNumberFileFilter(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, 0L);
  }
  
  public MagicNumberFileFilter(byte[] paramArrayOfByte, long paramLong)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length != 0)
      {
        if (paramLong >= 0L)
        {
          this.magicNumbers = new byte[paramArrayOfByte.length];
          System.arraycopy(paramArrayOfByte, 0, this.magicNumbers, 0, paramArrayOfByte.length);
          this.byteOffset = paramLong;
          return;
        }
        throw new IllegalArgumentException("The offset cannot be negative");
      }
      throw new IllegalArgumentException("The magic number must contain at least one byte");
    }
    throw new IllegalArgumentException("The magic number cannot be null");
  }
  
  /* Error */
  public boolean accept(java.io.File paramFile)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +143 -> 144
    //   4: aload_1
    //   5: invokevirtual 73	java/io/File:isFile	()Z
    //   8: ifeq +136 -> 144
    //   11: aload_1
    //   12: invokevirtual 76	java/io/File:canRead	()Z
    //   15: ifeq +129 -> 144
    //   18: new 78	java/io/RandomAccessFile
    //   21: dup
    //   22: aload_1
    //   23: ldc 80
    //   25: invokespecial 83	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   28: astore 6
    //   30: aconst_null
    //   31: astore 5
    //   33: aload 5
    //   35: astore_1
    //   36: aload_0
    //   37: getfield 40	org/apache/commons/io/filefilter/MagicNumberFileFilter:magicNumbers	[B
    //   40: arraylength
    //   41: newarray byte
    //   43: astore 7
    //   45: aload 5
    //   47: astore_1
    //   48: aload 6
    //   50: aload_0
    //   51: getfield 42	org/apache/commons/io/filefilter/MagicNumberFileFilter:byteOffset	J
    //   54: invokevirtual 87	java/io/RandomAccessFile:seek	(J)V
    //   57: aload 5
    //   59: astore_1
    //   60: aload 6
    //   62: aload 7
    //   64: invokevirtual 91	java/io/RandomAccessFile:read	([B)I
    //   67: istore_2
    //   68: aload 5
    //   70: astore_1
    //   71: aload_0
    //   72: getfield 40	org/apache/commons/io/filefilter/MagicNumberFileFilter:magicNumbers	[B
    //   75: arraylength
    //   76: istore_3
    //   77: iload_2
    //   78: iload_3
    //   79: if_icmpeq +10 -> 89
    //   82: aload 6
    //   84: invokevirtual 94	java/io/RandomAccessFile:close	()V
    //   87: iconst_0
    //   88: ireturn
    //   89: aload 5
    //   91: astore_1
    //   92: aload_0
    //   93: getfield 40	org/apache/commons/io/filefilter/MagicNumberFileFilter:magicNumbers	[B
    //   96: aload 7
    //   98: invokestatic 100	java/util/Arrays:equals	([B[B)Z
    //   101: istore 4
    //   103: aload 6
    //   105: invokevirtual 94	java/io/RandomAccessFile:close	()V
    //   108: iload 4
    //   110: ireturn
    //   111: astore 5
    //   113: goto +11 -> 124
    //   116: astore 5
    //   118: aload 5
    //   120: astore_1
    //   121: aload 5
    //   123: athrow
    //   124: aload_1
    //   125: ifnull +11 -> 136
    //   128: aload 6
    //   130: invokevirtual 94	java/io/RandomAccessFile:close	()V
    //   133: goto +8 -> 141
    //   136: aload 6
    //   138: invokevirtual 94	java/io/RandomAccessFile:close	()V
    //   141: aload 5
    //   143: athrow
    //   144: iconst_0
    //   145: ireturn
    //   146: astore_1
    //   147: iconst_0
    //   148: ireturn
    //   149: astore_1
    //   150: goto -9 -> 141
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	this	MagicNumberFileFilter
    //   0	153	1	paramFile	java.io.File
    //   67	13	2	i	int
    //   76	4	3	j	int
    //   101	8	4	bool	boolean
    //   31	59	5	localObject1	java.lang.Object
    //   111	1	5	localObject2	java.lang.Object
    //   116	26	5	localThrowable	java.lang.Throwable
    //   28	109	6	localRandomAccessFile	java.io.RandomAccessFile
    //   43	54	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   36	45	111	finally
    //   48	57	111	finally
    //   60	68	111	finally
    //   71	77	111	finally
    //   92	103	111	finally
    //   121	124	111	finally
    //   36	45	116	java/lang/Throwable
    //   48	57	116	java/lang/Throwable
    //   60	68	116	java/lang/Throwable
    //   71	77	116	java/lang/Throwable
    //   92	103	116	java/lang/Throwable
    //   18	30	146	java/io/IOException
    //   82	87	146	java/io/IOException
    //   103	108	146	java/io/IOException
    //   128	133	146	java/io/IOException
    //   136	141	146	java/io/IOException
    //   141	144	146	java/io/IOException
    //   128	133	149	java/lang/Throwable
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(super.toString());
    localStringBuilder.append("(");
    localStringBuilder.append(new String(this.magicNumbers, Charset.defaultCharset()));
    localStringBuilder.append(",");
    localStringBuilder.append(this.byteOffset);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.apache.commons.io.filefilter.MagicNumberFileFilter
 * JD-Core Version:    0.7.0.1
 */