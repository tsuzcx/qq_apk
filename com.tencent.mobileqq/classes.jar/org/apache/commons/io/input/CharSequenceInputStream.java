package org.apache.commons.io.input;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;

public class CharSequenceInputStream
  extends InputStream
{
  private static final int BUFFER_SIZE = 2048;
  private static final int NO_MARK = -1;
  private final ByteBuffer bbuf;
  private final CharBuffer cbuf;
  private final CharsetEncoder encoder;
  private int mark_bbuf;
  private int mark_cbuf;
  
  public CharSequenceInputStream(CharSequence paramCharSequence, String paramString)
  {
    this(paramCharSequence, paramString, 2048);
  }
  
  public CharSequenceInputStream(CharSequence paramCharSequence, String paramString, int paramInt)
  {
    this(paramCharSequence, Charset.forName(paramString), paramInt);
  }
  
  public CharSequenceInputStream(CharSequence paramCharSequence, Charset paramCharset)
  {
    this(paramCharSequence, paramCharset, 2048);
  }
  
  public CharSequenceInputStream(CharSequence paramCharSequence, Charset paramCharset, int paramInt)
  {
    this.encoder = paramCharset.newEncoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE);
    float f = this.encoder.maxBytesPerChar();
    if (paramInt >= f)
    {
      this.bbuf = ByteBuffer.allocate(paramInt);
      this.bbuf.flip();
      this.cbuf = CharBuffer.wrap(paramCharSequence);
      this.mark_cbuf = -1;
      this.mark_bbuf = -1;
      return;
    }
    paramCharSequence = new StringBuilder();
    paramCharSequence.append("Buffer size ");
    paramCharSequence.append(paramInt);
    paramCharSequence.append(" is less than maxBytesPerChar ");
    paramCharSequence.append(f);
    throw new IllegalArgumentException(paramCharSequence.toString());
  }
  
  private void fillBuffer()
  {
    this.bbuf.compact();
    CoderResult localCoderResult = this.encoder.encode(this.cbuf, this.bbuf, true);
    if (localCoderResult.isError()) {
      localCoderResult.throwException();
    }
    this.bbuf.flip();
  }
  
  public int available()
  {
    return this.bbuf.remaining() + this.cbuf.remaining();
  }
  
  public void close() {}
  
  public void mark(int paramInt)
  {
    try
    {
      this.mark_cbuf = this.cbuf.position();
      this.mark_bbuf = this.bbuf.position();
      this.cbuf.mark();
      this.bbuf.mark();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean markSupported()
  {
    return true;
  }
  
  public int read()
  {
    do
    {
      if (this.bbuf.hasRemaining()) {
        return this.bbuf.get() & 0xFF;
      }
      fillBuffer();
    } while ((this.bbuf.hasRemaining()) || (this.cbuf.hasRemaining()));
    return -1;
  }
  
  public int read(byte[] paramArrayOfByte)
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte != null)
    {
      if ((paramInt2 >= 0) && (paramInt1 + paramInt2 <= paramArrayOfByte.length))
      {
        int m = 0;
        if (paramInt2 == 0) {
          return 0;
        }
        int i = m;
        int j = paramInt1;
        int k = paramInt2;
        if (!this.bbuf.hasRemaining())
        {
          i = m;
          j = paramInt1;
          k = paramInt2;
          if (!this.cbuf.hasRemaining()) {
            return -1;
          }
        }
        do
        {
          for (;;)
          {
            if (k <= 0) {
              break label152;
            }
            if (!this.bbuf.hasRemaining()) {
              break;
            }
            paramInt1 = Math.min(this.bbuf.remaining(), k);
            this.bbuf.get(paramArrayOfByte, j, paramInt1);
            j += paramInt1;
            k -= paramInt1;
            i += paramInt1;
          }
          fillBuffer();
        } while ((this.bbuf.hasRemaining()) || (this.cbuf.hasRemaining()));
        label152:
        paramInt1 = i;
        if (i == 0)
        {
          paramInt1 = i;
          if (!this.cbuf.hasRemaining()) {
            paramInt1 = -1;
          }
        }
        return paramInt1;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Array Size=");
      localStringBuilder.append(paramArrayOfByte.length);
      localStringBuilder.append(", offset=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", length=");
      localStringBuilder.append(paramInt2);
      throw new IndexOutOfBoundsException(localStringBuilder.toString());
    }
    paramArrayOfByte = new NullPointerException("Byte array is null");
    for (;;)
    {
      throw paramArrayOfByte;
    }
  }
  
  public void reset()
  {
    try
    {
      if (this.mark_cbuf != -1)
      {
        if (this.cbuf.position() != 0)
        {
          this.encoder.reset();
          this.cbuf.rewind();
          this.bbuf.rewind();
          this.bbuf.limit(0);
          while (this.cbuf.position() < this.mark_cbuf)
          {
            this.bbuf.rewind();
            this.bbuf.limit(0);
            fillBuffer();
          }
        }
        if (this.cbuf.position() == this.mark_cbuf)
        {
          this.bbuf.position(this.mark_bbuf);
          this.mark_cbuf = -1;
          this.mark_bbuf = -1;
        }
        else
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Unexpected CharBuffer postion: actual=");
          localStringBuilder.append(this.cbuf.position());
          localStringBuilder.append(" expected=");
          localStringBuilder.append(this.mark_cbuf);
          throw new IllegalStateException(localStringBuilder.toString());
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public long skip(long paramLong)
  {
    long l2 = 0L;
    long l1 = paramLong;
    for (paramLong = l2; (l1 > 0L) && (available() > 0); paramLong += 1L)
    {
      read();
      l1 -= 1L;
    }
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.apache.commons.io.input.CharSequenceInputStream
 * JD-Core Version:    0.7.0.1
 */