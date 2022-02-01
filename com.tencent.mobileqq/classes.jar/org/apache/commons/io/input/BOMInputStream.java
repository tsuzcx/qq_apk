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
    if ((paramVarArgs != null) && (paramVarArgs.length != 0))
    {
      this.include = paramBoolean;
      paramInputStream = Arrays.asList(paramVarArgs);
      Collections.sort(paramInputStream, ByteOrderMarkLengthComparator);
      this.boms = paramInputStream;
      return;
    }
    throw new IllegalArgumentException("No BOMs specified");
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
    int i = this.fbIndex;
    if (i < this.fbLength)
    {
      int[] arrayOfInt = this.firstBytes;
      this.fbIndex = (i + 1);
      return arrayOfInt[i];
    }
    return -1;
  }
  
  public ByteOrderMark getBOM()
  {
    if (this.firstBytes == null)
    {
      this.fbLength = 0;
      this.firstBytes = new int[((ByteOrderMark)this.boms.get(0)).length()];
      int i = 0;
      for (;;)
      {
        localObject = this.firstBytes;
        if (i >= localObject.length) {
          break;
        }
        localObject[i] = this.in.read();
        this.fbLength += 1;
        if (this.firstBytes[i] < 0) {
          break;
        }
        i += 1;
      }
      this.byteOrderMark = find();
      Object localObject = this.byteOrderMark;
      if ((localObject != null) && (!this.include)) {
        if (((ByteOrderMark)localObject).length() < this.firstBytes.length) {
          this.fbIndex = this.byteOrderMark.length();
        } else {
          this.fbLength = 0;
        }
      }
    }
    return this.byteOrderMark;
  }
  
  public String getBOMCharsetName()
  {
    getBOM();
    ByteOrderMark localByteOrderMark = this.byteOrderMark;
    if (localByteOrderMark == null) {
      return null;
    }
    return localByteOrderMark.getCharsetName();
  }
  
  public boolean hasBOM()
  {
    return getBOM() != null;
  }
  
  public boolean hasBOM(ByteOrderMark paramByteOrderMark)
  {
    if (this.boms.contains(paramByteOrderMark))
    {
      getBOM();
      localObject = this.byteOrderMark;
      return (localObject != null) && (((ByteOrderMark)localObject).equals(paramByteOrderMark));
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Stream not configure to detect ");
    ((StringBuilder)localObject).append(paramByteOrderMark);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public void mark(int paramInt)
  {
    for (;;)
    {
      try
      {
        this.markFbIndex = this.fbIndex;
        if (this.firstBytes == null)
        {
          bool = true;
          this.markedAtStart = bool;
          this.in.mark(paramInt);
          return;
        }
      }
      finally {}
      boolean bool = false;
    }
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
    int i = 0;
    int k = 0;
    int j = paramInt2;
    paramInt2 = paramInt1;
    paramInt1 = k;
    while ((j > 0) && (i >= 0))
    {
      k = readFirstBytes();
      i = k;
      if (k >= 0)
      {
        paramArrayOfByte[paramInt2] = ((byte)(k & 0xFF));
        j -= 1;
        paramInt1 += 1;
        paramInt2 += 1;
        i = k;
      }
    }
    paramInt2 = this.in.read(paramArrayOfByte, paramInt2, j);
    if (paramInt2 < 0)
    {
      if (paramInt1 > 0) {
        return paramInt1;
      }
      return -1;
    }
    return paramInt1 + paramInt2;
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
    long l;
    for (;;)
    {
      l = i;
      if ((paramLong <= l) || (readFirstBytes() < 0)) {
        break;
      }
      i += 1;
    }
    return this.in.skip(paramLong - l) + l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.apache.commons.io.input.BOMInputStream
 * JD-Core Version:    0.7.0.1
 */