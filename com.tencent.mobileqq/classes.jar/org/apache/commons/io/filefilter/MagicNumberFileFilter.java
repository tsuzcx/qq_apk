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
    if (paramString == null) {
      throw new IllegalArgumentException("The magic number cannot be null");
    }
    if (paramString.isEmpty()) {
      throw new IllegalArgumentException("The magic number must contain at least one byte");
    }
    if (paramLong < 0L) {
      throw new IllegalArgumentException("The offset cannot be negative");
    }
    this.magicNumbers = paramString.getBytes(Charset.defaultCharset());
    this.byteOffset = paramLong;
  }
  
  public MagicNumberFileFilter(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, 0L);
  }
  
  public MagicNumberFileFilter(byte[] paramArrayOfByte, long paramLong)
  {
    if (paramArrayOfByte == null) {
      throw new IllegalArgumentException("The magic number cannot be null");
    }
    if (paramArrayOfByte.length == 0) {
      throw new IllegalArgumentException("The magic number must contain at least one byte");
    }
    if (paramLong < 0L) {
      throw new IllegalArgumentException("The offset cannot be negative");
    }
    this.magicNumbers = new byte[paramArrayOfByte.length];
    System.arraycopy(paramArrayOfByte, 0, this.magicNumbers, 0, paramArrayOfByte.length);
    this.byteOffset = paramLong;
  }
  
  /* Error */
  public boolean accept(java.io.File paramFile)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +81 -> 82
    //   4: aload_1
    //   5: invokevirtual 73	java/io/File:isFile	()Z
    //   8: ifeq +74 -> 82
    //   11: aload_1
    //   12: invokevirtual 76	java/io/File:canRead	()Z
    //   15: ifeq +67 -> 82
    //   18: new 78	java/io/RandomAccessFile
    //   21: dup
    //   22: aload_1
    //   23: ldc 80
    //   25: invokespecial 83	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   28: astore 6
    //   30: aconst_null
    //   31: astore 5
    //   33: aload_0
    //   34: getfield 50	org/apache/commons/io/filefilter/MagicNumberFileFilter:magicNumbers	[B
    //   37: arraylength
    //   38: newarray byte
    //   40: astore_1
    //   41: aload 6
    //   43: aload_0
    //   44: getfield 52	org/apache/commons/io/filefilter/MagicNumberFileFilter:byteOffset	J
    //   47: invokevirtual 87	java/io/RandomAccessFile:seek	(J)V
    //   50: aload 6
    //   52: aload_1
    //   53: invokevirtual 91	java/io/RandomAccessFile:read	([B)I
    //   56: istore_3
    //   57: aload_0
    //   58: getfield 50	org/apache/commons/io/filefilter/MagicNumberFileFilter:magicNumbers	[B
    //   61: arraylength
    //   62: istore_2
    //   63: iload_3
    //   64: iload_2
    //   65: if_icmpeq +35 -> 100
    //   68: aload 6
    //   70: ifnull +12 -> 82
    //   73: iconst_0
    //   74: ifeq +19 -> 93
    //   77: aload 6
    //   79: invokevirtual 94	java/io/RandomAccessFile:close	()V
    //   82: iconst_0
    //   83: ireturn
    //   84: astore_1
    //   85: new 96	java/lang/NullPointerException
    //   88: dup
    //   89: invokespecial 97	java/lang/NullPointerException:<init>	()V
    //   92: athrow
    //   93: aload 6
    //   95: invokevirtual 94	java/io/RandomAccessFile:close	()V
    //   98: iconst_0
    //   99: ireturn
    //   100: aload_0
    //   101: getfield 50	org/apache/commons/io/filefilter/MagicNumberFileFilter:magicNumbers	[B
    //   104: aload_1
    //   105: invokestatic 103	java/util/Arrays:equals	([B[B)Z
    //   108: istore 4
    //   110: aload 6
    //   112: ifnull +12 -> 124
    //   115: iconst_0
    //   116: ifeq +20 -> 136
    //   119: aload 6
    //   121: invokevirtual 94	java/io/RandomAccessFile:close	()V
    //   124: iload 4
    //   126: ireturn
    //   127: astore_1
    //   128: new 96	java/lang/NullPointerException
    //   131: dup
    //   132: invokespecial 97	java/lang/NullPointerException:<init>	()V
    //   135: athrow
    //   136: aload 6
    //   138: invokevirtual 94	java/io/RandomAccessFile:close	()V
    //   141: goto -17 -> 124
    //   144: astore 5
    //   146: aload 5
    //   148: athrow
    //   149: astore_1
    //   150: aload 6
    //   152: ifnull +13 -> 165
    //   155: aload 5
    //   157: ifnull +22 -> 179
    //   160: aload 6
    //   162: invokevirtual 94	java/io/RandomAccessFile:close	()V
    //   165: aload_1
    //   166: athrow
    //   167: astore 6
    //   169: aload 5
    //   171: aload 6
    //   173: invokevirtual 107	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   176: goto -11 -> 165
    //   179: aload 6
    //   181: invokevirtual 94	java/io/RandomAccessFile:close	()V
    //   184: goto -19 -> 165
    //   187: astore_1
    //   188: goto -38 -> 150
    //   191: astore_1
    //   192: iconst_0
    //   193: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	194	0	this	MagicNumberFileFilter
    //   0	194	1	paramFile	java.io.File
    //   62	4	2	i	int
    //   56	10	3	j	int
    //   108	17	4	bool	boolean
    //   31	1	5	localObject	java.lang.Object
    //   144	26	5	localThrowable1	java.lang.Throwable
    //   28	133	6	localRandomAccessFile	java.io.RandomAccessFile
    //   167	13	6	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   77	82	84	java/lang/Throwable
    //   119	124	127	java/lang/Throwable
    //   33	63	144	java/lang/Throwable
    //   100	110	144	java/lang/Throwable
    //   146	149	149	finally
    //   160	165	167	java/lang/Throwable
    //   33	63	187	finally
    //   100	110	187	finally
    //   18	30	191	java/io/IOException
    //   77	82	191	java/io/IOException
    //   85	93	191	java/io/IOException
    //   93	98	191	java/io/IOException
    //   119	124	191	java/io/IOException
    //   128	136	191	java/io/IOException
    //   136	141	191	java/io/IOException
    //   160	165	191	java/io/IOException
    //   165	167	191	java/io/IOException
    //   169	176	191	java/io/IOException
    //   179	184	191	java/io/IOException
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     org.apache.commons.io.filefilter.MagicNumberFileFilter
 * JD-Core Version:    0.7.0.1
 */