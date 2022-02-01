package org.apache.commons.io.output;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.SequenceInputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.io.input.ClosedInputStream;

public class ByteArrayOutputStream
  extends OutputStream
{
  static final int DEFAULT_SIZE = 1024;
  private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
  private final List<byte[]> buffers = new ArrayList();
  private int count;
  private byte[] currentBuffer;
  private int currentBufferIndex;
  private int filledBufferSum;
  private boolean reuseBuffers = true;
  
  public ByteArrayOutputStream()
  {
    this(1024);
  }
  
  public ByteArrayOutputStream(int paramInt)
  {
    if (paramInt >= 0) {
      try
      {
        needNewBuffer(paramInt);
        return;
      }
      finally {}
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Negative initial size: ");
    localStringBuilder.append(paramInt);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  private void needNewBuffer(int paramInt)
  {
    if (this.currentBufferIndex < this.buffers.size() - 1)
    {
      this.filledBufferSum += this.currentBuffer.length;
      this.currentBufferIndex += 1;
      this.currentBuffer = ((byte[])this.buffers.get(this.currentBufferIndex));
      return;
    }
    byte[] arrayOfByte = this.currentBuffer;
    if (arrayOfByte == null)
    {
      this.filledBufferSum = 0;
    }
    else
    {
      paramInt = Math.max(arrayOfByte.length << 1, paramInt - this.filledBufferSum);
      this.filledBufferSum += this.currentBuffer.length;
    }
    this.currentBufferIndex += 1;
    this.currentBuffer = new byte[paramInt];
    this.buffers.add(this.currentBuffer);
  }
  
  public static InputStream toBufferedInputStream(InputStream paramInputStream)
  {
    return toBufferedInputStream(paramInputStream, 1024);
  }
  
  public static InputStream toBufferedInputStream(InputStream paramInputStream, int paramInt)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(paramInt);
    localByteArrayOutputStream.write(paramInputStream);
    return localByteArrayOutputStream.toInputStream();
  }
  
  public void close() {}
  
  public void reset()
  {
    try
    {
      this.count = 0;
      this.filledBufferSum = 0;
      this.currentBufferIndex = 0;
      if (this.reuseBuffers)
      {
        this.currentBuffer = ((byte[])this.buffers.get(this.currentBufferIndex));
      }
      else
      {
        this.currentBuffer = null;
        int i = ((byte[])this.buffers.get(0)).length;
        this.buffers.clear();
        needNewBuffer(i);
        this.reuseBuffers = true;
      }
      return;
    }
    finally {}
  }
  
  public int size()
  {
    try
    {
      int i = this.count;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public byte[] toByteArray()
  {
    try
    {
      int i = this.count;
      if (i == 0)
      {
        arrayOfByte1 = EMPTY_BYTE_ARRAY;
        return arrayOfByte1;
      }
      byte[] arrayOfByte1 = new byte[i];
      Iterator localIterator = this.buffers.iterator();
      int j = 0;
      int k;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        byte[] arrayOfByte2 = (byte[])localIterator.next();
        k = Math.min(arrayOfByte2.length, i);
        System.arraycopy(arrayOfByte2, 0, arrayOfByte1, j, k);
        j += k;
        k = i - k;
        i = k;
      } while (k != 0);
      return arrayOfByte1;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public InputStream toInputStream()
  {
    try
    {
      int i = this.count;
      if (i == 0)
      {
        localObject1 = new ClosedInputStream();
        return localObject1;
      }
      Object localObject1 = new ArrayList(this.buffers.size());
      Iterator localIterator = this.buffers.iterator();
      int j;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        byte[] arrayOfByte = (byte[])localIterator.next();
        j = Math.min(arrayOfByte.length, i);
        ((List)localObject1).add(new ByteArrayInputStream(arrayOfByte, 0, j));
        j = i - j;
        i = j;
      } while (j != 0);
      this.reuseBuffers = false;
      localObject1 = new SequenceInputStream(Collections.enumeration((Collection)localObject1));
      return localObject1;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  @Deprecated
  public String toString()
  {
    return new String(toByteArray(), Charset.defaultCharset());
  }
  
  public String toString(String paramString)
  {
    return new String(toByteArray(), paramString);
  }
  
  public String toString(Charset paramCharset)
  {
    return new String(toByteArray(), paramCharset);
  }
  
  public int write(InputStream paramInputStream)
  {
    try
    {
      int i = this.count - this.filledBufferSum;
      int j = paramInputStream.read(this.currentBuffer, i, this.currentBuffer.length - i);
      int k = 0;
      while (j != -1)
      {
        k += j;
        int m = i + j;
        this.count += j;
        i = m;
        if (m == this.currentBuffer.length)
        {
          needNewBuffer(this.currentBuffer.length);
          i = 0;
        }
        j = paramInputStream.read(this.currentBuffer, i, this.currentBuffer.length - i);
      }
      return k;
    }
    finally {}
    for (;;)
    {
      throw paramInputStream;
    }
  }
  
  public void write(int paramInt)
  {
    try
    {
      int j = this.count - this.filledBufferSum;
      int i = j;
      if (j == this.currentBuffer.length)
      {
        needNewBuffer(this.count + 1);
        i = 0;
      }
      this.currentBuffer[i] = ((byte)paramInt);
      this.count += 1;
      return;
    }
    finally {}
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 0) && (paramInt1 <= paramArrayOfByte.length) && (paramInt2 >= 0))
    {
      int j = paramInt1 + paramInt2;
      if ((j <= paramArrayOfByte.length) && (j >= 0))
      {
        if (paramInt2 == 0) {
          return;
        }
        try
        {
          int k = this.count + paramInt2;
          paramInt1 = this.count - this.filledBufferSum;
          while (paramInt2 > 0)
          {
            int i = Math.min(paramInt2, this.currentBuffer.length - paramInt1);
            System.arraycopy(paramArrayOfByte, j - paramInt2, this.currentBuffer, paramInt1, i);
            i = paramInt2 - i;
            paramInt2 = i;
            if (i > 0)
            {
              needNewBuffer(k);
              paramInt1 = 0;
              paramInt2 = i;
            }
          }
          this.count = k;
          return;
        }
        finally {}
      }
    }
    paramArrayOfByte = new IndexOutOfBoundsException();
    for (;;)
    {
      throw paramArrayOfByte;
    }
  }
  
  public void writeTo(OutputStream paramOutputStream)
  {
    try
    {
      int i = this.count;
      Iterator localIterator = this.buffers.iterator();
      int j;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        byte[] arrayOfByte = (byte[])localIterator.next();
        j = Math.min(arrayOfByte.length, i);
        paramOutputStream.write(arrayOfByte, 0, j);
        j = i - j;
        i = j;
      } while (j != 0);
      return;
    }
    finally {}
    for (;;)
    {
      throw paramOutputStream;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.apache.commons.io.output.ByteArrayOutputStream
 * JD-Core Version:    0.7.0.1
 */