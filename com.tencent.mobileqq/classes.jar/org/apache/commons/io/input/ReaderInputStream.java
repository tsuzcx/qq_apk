package org.apache.commons.io.input;

import java.io.InputStream;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;

public class ReaderInputStream
  extends InputStream
{
  private static final int DEFAULT_BUFFER_SIZE = 1024;
  private final CharsetEncoder encoder;
  private final CharBuffer encoderIn;
  private final ByteBuffer encoderOut;
  private boolean endOfInput;
  private CoderResult lastCoderResult;
  private final Reader reader;
  
  @Deprecated
  public ReaderInputStream(Reader paramReader)
  {
    this(paramReader, Charset.defaultCharset());
  }
  
  public ReaderInputStream(Reader paramReader, String paramString)
  {
    this(paramReader, paramString, 1024);
  }
  
  public ReaderInputStream(Reader paramReader, String paramString, int paramInt)
  {
    this(paramReader, Charset.forName(paramString), paramInt);
  }
  
  public ReaderInputStream(Reader paramReader, Charset paramCharset)
  {
    this(paramReader, paramCharset, 1024);
  }
  
  public ReaderInputStream(Reader paramReader, Charset paramCharset, int paramInt)
  {
    this(paramReader, paramCharset.newEncoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE), paramInt);
  }
  
  public ReaderInputStream(Reader paramReader, CharsetEncoder paramCharsetEncoder)
  {
    this(paramReader, paramCharsetEncoder, 1024);
  }
  
  public ReaderInputStream(Reader paramReader, CharsetEncoder paramCharsetEncoder, int paramInt)
  {
    this.reader = paramReader;
    this.encoder = paramCharsetEncoder;
    this.encoderIn = CharBuffer.allocate(paramInt);
    this.encoderIn.flip();
    this.encoderOut = ByteBuffer.allocate(128);
    this.encoderOut.flip();
  }
  
  private void fillBuffer()
  {
    if (!this.endOfInput)
    {
      CoderResult localCoderResult = this.lastCoderResult;
      if ((localCoderResult == null) || (localCoderResult.isUnderflow()))
      {
        this.encoderIn.compact();
        int i = this.encoderIn.position();
        int j = this.reader.read(this.encoderIn.array(), i, this.encoderIn.remaining());
        if (j == -1) {
          this.endOfInput = true;
        } else {
          this.encoderIn.position(i + j);
        }
        this.encoderIn.flip();
      }
    }
    this.encoderOut.compact();
    this.lastCoderResult = this.encoder.encode(this.encoderIn, this.encoderOut, this.endOfInput);
    this.encoderOut.flip();
  }
  
  public void close()
  {
    this.reader.close();
  }
  
  public int read()
  {
    do
    {
      if (this.encoderOut.hasRemaining()) {
        return this.encoderOut.get() & 0xFF;
      }
      fillBuffer();
    } while ((!this.endOfInput) || (this.encoderOut.hasRemaining()));
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
      if ((paramInt2 >= 0) && (paramInt1 >= 0) && (paramInt1 + paramInt2 <= paramArrayOfByte.length))
      {
        int i = 0;
        int j = paramInt2;
        if (paramInt2 == 0) {
          return 0;
        }
        do
        {
          for (;;)
          {
            if (j <= 0) {
              break label111;
            }
            if (!this.encoderOut.hasRemaining()) {
              break;
            }
            paramInt2 = Math.min(this.encoderOut.remaining(), j);
            this.encoderOut.get(paramArrayOfByte, paramInt1, paramInt2);
            paramInt1 += paramInt2;
            j -= paramInt2;
            i += paramInt2;
          }
          fillBuffer();
        } while ((!this.endOfInput) || (this.encoderOut.hasRemaining()));
        label111:
        paramInt1 = i;
        if (i == 0)
        {
          paramInt1 = i;
          if (this.endOfInput) {
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
    paramArrayOfByte = new NullPointerException("Byte array must not be null");
    for (;;)
    {
      throw paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.apache.commons.io.input.ReaderInputStream
 * JD-Core Version:    0.7.0.1
 */