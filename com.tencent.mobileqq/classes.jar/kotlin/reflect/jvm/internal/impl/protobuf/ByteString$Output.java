package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.OutputStream;
import java.util.ArrayList;

public final class ByteString$Output
  extends OutputStream
{
  private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
  private byte[] buffer;
  private int bufferPos;
  private final ArrayList<ByteString> flushedBuffers;
  private int flushedBuffersTotalBytes;
  private final int initialCapacity;
  
  ByteString$Output(int paramInt)
  {
    if (paramInt >= 0)
    {
      this.initialCapacity = paramInt;
      this.flushedBuffers = new ArrayList();
      this.buffer = new byte[paramInt];
      return;
    }
    throw new IllegalArgumentException("Buffer size < 0");
  }
  
  private byte[] copyArray(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, Math.min(paramArrayOfByte.length, paramInt));
    return arrayOfByte;
  }
  
  private void flushFullBuffer(int paramInt)
  {
    this.flushedBuffers.add(new LiteralByteString(this.buffer));
    this.flushedBuffersTotalBytes += this.buffer.length;
    this.buffer = new byte[Math.max(this.initialCapacity, Math.max(paramInt, this.flushedBuffersTotalBytes >>> 1))];
    this.bufferPos = 0;
  }
  
  private void flushLastBuffer()
  {
    int i = this.bufferPos;
    byte[] arrayOfByte = this.buffer;
    if (i < arrayOfByte.length)
    {
      if (i > 0)
      {
        arrayOfByte = copyArray(arrayOfByte, i);
        this.flushedBuffers.add(new LiteralByteString(arrayOfByte));
      }
    }
    else
    {
      this.flushedBuffers.add(new LiteralByteString(arrayOfByte));
      this.buffer = EMPTY_BYTE_ARRAY;
    }
    this.flushedBuffersTotalBytes += this.bufferPos;
    this.bufferPos = 0;
  }
  
  public int size()
  {
    try
    {
      int i = this.flushedBuffersTotalBytes;
      int j = this.bufferPos;
      return i + j;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public ByteString toByteString()
  {
    try
    {
      flushLastBuffer();
      ByteString localByteString = ByteString.copyFrom(this.flushedBuffers);
      return localByteString;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String toString()
  {
    return String.format("<ByteString.Output@%s size=%d>", new Object[] { Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()) });
  }
  
  public void write(int paramInt)
  {
    try
    {
      if (this.bufferPos == this.buffer.length) {
        flushFullBuffer(1);
      }
      byte[] arrayOfByte = this.buffer;
      int i = this.bufferPos;
      this.bufferPos = (i + 1);
      arrayOfByte[i] = ((byte)paramInt);
      return;
    }
    finally {}
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      if (paramInt2 <= this.buffer.length - this.bufferPos)
      {
        System.arraycopy(paramArrayOfByte, paramInt1, this.buffer, this.bufferPos, paramInt2);
        this.bufferPos += paramInt2;
      }
      else
      {
        int i = this.buffer.length - this.bufferPos;
        System.arraycopy(paramArrayOfByte, paramInt1, this.buffer, this.bufferPos, i);
        paramInt2 -= i;
        flushFullBuffer(paramInt2);
        System.arraycopy(paramArrayOfByte, paramInt1 + i, this.buffer, 0, paramInt2);
        this.bufferPos = paramInt2;
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.protobuf.ByteString.Output
 * JD-Core Version:    0.7.0.1
 */