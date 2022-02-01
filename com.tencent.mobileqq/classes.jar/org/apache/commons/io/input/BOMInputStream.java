package org.apache.commons.io.input;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.io.ByteOrderMark;

public class BOMInputStream
  extends ProxyInputStream
{
  private static final Comparator<ByteOrderMark> ByteOrderMarkLengthComparator = new BOMInputStream.1();
  private final List<ByteOrderMark> boms;
  private ByteOrderMark byteOrderMark;
  private int fbIndex;
  private int fbLength;
  private int[] firstBytes;
  private final boolean include;
  private int markFbIndex;
  private boolean markedAtStart;
  
  public BOMInputStream(InputStream paramInputStream)
  {
    this(paramInputStream, false, new ByteOrderMark[] { ByteOrderMark.UTF_8 });
  }
  
  public BOMInputStream(InputStream paramInputStream, boolean paramBoolean)
  {
    this(paramInputStream, paramBoolean, new ByteOrderMark[] { ByteOrderMark.UTF_8 });
  }
  
  public BOMInputStream(InputStream paramInputStream, boolean paramBoolean, ByteOrderMark... paramVarArgs)
  {
    super(paramInputStream);
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
      throw new IllegalArgumentException("No BOMs specified");
    }
    this.include = paramBoolean;
    paramInputStream = Arrays.asList(paramVarArgs);
    Collections.sort(paramInputStream, ByteOrderMarkLengthComparator);
    this.boms = paramInputStream;
  }
  
  public BOMInputStream(InputStream paramInputStream, ByteOrderMark... paramVarArgs)
  {
    this(paramInputStream, false, paramVarArgs);
  }
  
  private ByteOrderMark find()
  {
    Iterator localIterator = this.boms.iterator();
    while (localIterator.hasNext())
    {
      ByteOrderMark localByteOrderMark = (ByteOrderMark)localIterator.next();
      if (matches(localByteOrderMark)) {
        return localByteOrderMark;
      }
    }
    return null;
  }
  
  private boolean matches(ByteOrderMark paramByteOrderMark)
  {
    int i = 0;
    while (i < paramByteOrderMark.length())
    {
      if (paramByteOrderMark.get(i) != this.firstBytes[i]) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private int readFirstBytes()
  {
    getBOM();
    if (this.fbIndex < this.fbLength)
    {
      int[] arrayOfInt = this.firstBytes;
      int i = this.fbIndex;
      this.fbIndex = (i + 1);
      return arrayOfInt[i];
    }
    return -1;
  }
  
  public ByteOrderMark getBOM()
  {
    int i;
    if (this.firstBytes == null)
    {
      this.fbLength = 0;
      this.firstBytes = new int[((ByteOrderMark)this.boms.get(0)).length()];
      i = 0;
      if (i < this.firstBytes.length)
      {
        this.firstBytes[i] = this.in.read();
        this.fbLength += 1;
        if (this.firstBytes[i] >= 0) {
          break label130;
        }
      }
      this.byteOrderMark = find();
      if ((this.byteOrderMark != null) && (!this.include))
      {
        if (this.byteOrderMark.length() >= this.firstBytes.length) {
          break label137;
        }
        this.fbIndex = this.byteOrderMark.length();
      }
    }
    for (;;)
    {
      return this.byteOrderMark;
      label130:
      i += 1;
      break;
      label137:
      this.fbLength = 0;
    }
  }
  
  public String getBOMCharsetName()
  {
    getBOM();
    if (this.byteOrderMark == null) {
      return null;
    }
    return this.byteOrderMark.getCharsetName();
  }
  
  public boolean hasBOM()
  {
    return getBOM() != null;
  }
  
  public boolean hasBOM(ByteOrderMark paramByteOrderMark)
  {
    if (!this.boms.contains(paramByteOrderMark)) {
      throw new IllegalArgumentException("Stream not configure to detect " + paramByteOrderMark);
    }
    getBOM();
    return (this.byteOrderMark != null) && (this.byteOrderMark.equals(paramByteOrderMark));
  }
  
  /* Error */
  public void mark(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: getfield 105	org/apache/commons/io/input/BOMInputStream:fbIndex	I
    //   7: putfield 155	org/apache/commons/io/input/BOMInputStream:markFbIndex	I
    //   10: aload_0
    //   11: getfield 99	org/apache/commons/io/input/BOMInputStream:firstBytes	[I
    //   14: ifnonnull +21 -> 35
    //   17: iconst_1
    //   18: istore_2
    //   19: aload_0
    //   20: iload_2
    //   21: putfield 157	org/apache/commons/io/input/BOMInputStream:markedAtStart	Z
    //   24: aload_0
    //   25: getfield 114	org/apache/commons/io/input/BOMInputStream:in	Ljava/io/InputStream;
    //   28: iload_1
    //   29: invokevirtual 159	java/io/InputStream:mark	(I)V
    //   32: aload_0
    //   33: monitorexit
    //   34: return
    //   35: iconst_0
    //   36: istore_2
    //   37: goto -18 -> 19
    //   40: astore_3
    //   41: aload_0
    //   42: monitorexit
    //   43: aload_3
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	BOMInputStream
    //   0	45	1	paramInt	int
    //   18	19	2	bool	boolean
    //   40	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	40	finally
    //   19	32	40	finally
  }
  
  public int read()
  {
    int i = readFirstBytes();
    if (i >= 0) {
      return i;
    }
    return this.in.read();
  }
  
  public int read(byte[] paramArrayOfByte)
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int k = 0;
    int i = 0;
    int j = paramInt2;
    paramInt2 = k;
    while ((j > 0) && (i >= 0))
    {
      k = readFirstBytes();
      i = k;
      if (k >= 0)
      {
        paramArrayOfByte[paramInt1] = ((byte)(k & 0xFF));
        j -= 1;
        paramInt2 += 1;
        paramInt1 += 1;
        i = k;
      }
    }
    paramInt1 = this.in.read(paramArrayOfByte, paramInt1, j);
    if (paramInt1 < 0)
    {
      if (paramInt2 > 0) {
        return paramInt2;
      }
      return -1;
    }
    return paramInt2 + paramInt1;
  }
  
  public void reset()
  {
    try
    {
      this.fbIndex = this.markFbIndex;
      if (this.markedAtStart) {
        this.firstBytes = null;
      }
      this.in.reset();
      return;
    }
    finally {}
  }
  
  public long skip(long paramLong)
  {
    int i = 0;
    while ((paramLong > i) && (readFirstBytes() >= 0)) {
      i += 1;
    }
    paramLong = this.in.skip(paramLong - i);
    return i + paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     org.apache.commons.io.input.BOMInputStream
 * JD-Core Version:    0.7.0.1
 */