package com.tencent.oskplayer.datasource;

import java.io.IOException;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;

public class DataSourceReader
  extends Reader
{
  private final ByteBuffer bytes = ByteBuffer.allocate(8192);
  private CharsetDecoder decoder;
  private boolean endOfInput = false;
  private DataSource in;
  
  public DataSourceReader(DataSource paramDataSource)
  {
    this(paramDataSource, Charset.defaultCharset());
  }
  
  public DataSourceReader(DataSource paramDataSource, String paramString)
  {
    super(paramDataSource);
    if (paramString != null)
    {
      this.in = paramDataSource;
      try
      {
        this.decoder = Charset.forName(paramString).newDecoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE);
        this.bytes.limit(0);
        return;
      }
      catch (IllegalArgumentException paramDataSource)
      {
        throw ((UnsupportedEncodingException)new UnsupportedEncodingException(paramString).initCause(paramDataSource));
      }
    }
    throw new NullPointerException();
  }
  
  public DataSourceReader(DataSource paramDataSource, Charset paramCharset)
  {
    super(paramDataSource);
    this.in = paramDataSource;
    this.decoder = paramCharset.newDecoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE);
    this.bytes.limit(0);
  }
  
  public DataSourceReader(DataSource paramDataSource, CharsetDecoder paramCharsetDecoder)
  {
    super(paramDataSource);
    paramCharsetDecoder.averageCharsPerByte();
    this.in = paramDataSource;
    this.decoder = paramCharsetDecoder;
    this.bytes.limit(0);
  }
  
  public static void checkOffsetAndCount(int paramInt1, int paramInt2, int paramInt3)
  {
    if (((paramInt2 | paramInt3) >= 0) && (paramInt2 <= paramInt1) && (paramInt1 - paramInt2 >= paramInt3)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("arrayLength=");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(",offset=");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(",count=");
    localStringBuilder.append(paramInt3);
    throw new ArrayIndexOutOfBoundsException(localStringBuilder.toString());
  }
  
  private boolean isOpen()
  {
    return this.in != null;
  }
  
  public void close()
  {
    synchronized (this.lock)
    {
      if (this.decoder != null) {
        this.decoder.reset();
      }
      this.decoder = null;
      if (this.in != null)
      {
        this.in.close();
        this.in = null;
      }
      return;
    }
  }
  
  public int read()
  {
    synchronized (this.lock)
    {
      if (isOpen())
      {
        char[] arrayOfChar = new char[1];
        int j = read(arrayOfChar, 0, 1);
        int i = -1;
        if (j != -1) {
          i = arrayOfChar[0];
        }
        return i;
      }
      throw new IOException("DataSourceReader is closed");
    }
  }
  
  public int read(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    Object localObject1;
    label305:
    label435:
    label440:
    label450:
    synchronized (this.lock)
    {
      CharBuffer localCharBuffer;
      int i;
      if (isOpen())
      {
        checkOffsetAndCount(paramArrayOfChar.length, paramInt1, paramInt2);
        if (paramInt2 == 0) {
          return 0;
        }
        localCharBuffer = CharBuffer.wrap(paramArrayOfChar, paramInt1, paramInt2);
        localObject1 = CoderResult.UNDERFLOW;
        if (this.bytes.hasRemaining()) {
          break label435;
        }
        break label450;
        boolean bool = localCharBuffer.hasRemaining();
        i = -1;
        paramArrayOfChar = (char[])localObject1;
        if ((bool) && (paramInt2 == 0)) {}
      }
      try
      {
        if (this.in.available() == 0L)
        {
          paramInt2 = localCharBuffer.position();
          if (paramInt2 > paramInt1) {
            paramArrayOfChar = (char[])localObject1;
          }
        }
      }
      catch (Exception paramArrayOfChar)
      {
        label111:
        int j;
        int k;
        int m;
        CoderResult localCoderResult;
        break label111;
      }
      if (this.endOfInput)
      {
        paramArrayOfChar = (char[])localObject1;
      }
      else
      {
        paramInt2 = this.bytes.capacity();
        j = this.bytes.limit();
        k = this.bytes.arrayOffset();
        m = this.bytes.limit();
        paramInt2 = this.in.read(this.bytes.array(), k + m, paramInt2 - j);
        if (paramInt2 != -1) {
          break label440;
        }
        this.endOfInput = true;
        paramArrayOfChar = (char[])localObject1;
        break label305;
        this.bytes.limit(this.bytes.limit() + paramInt2);
        localCoderResult = this.decoder.decode(this.bytes, localCharBuffer, false);
        paramArrayOfChar = localCoderResult;
        if (localCoderResult.isUnderflow())
        {
          localObject1 = localCoderResult;
          if (this.bytes.limit() != this.bytes.capacity()) {
            break label450;
          }
          this.bytes.compact();
          this.bytes.limit(this.bytes.position());
          this.bytes.position(0);
          localObject1 = localCoderResult;
          break label450;
        }
      }
      localObject1 = paramArrayOfChar;
      if (paramArrayOfChar == CoderResult.UNDERFLOW)
      {
        localObject1 = paramArrayOfChar;
        if (this.endOfInput)
        {
          localObject1 = this.decoder.decode(this.bytes, localCharBuffer, true);
          this.decoder.flush(localCharBuffer);
          this.decoder.reset();
        }
      }
      if ((((CoderResult)localObject1).isMalformed()) || (((CoderResult)localObject1).isUnmappable())) {
        ((CoderResult)localObject1).throwException();
      }
      if (localCharBuffer.position() - paramInt1 == 0) {
        paramInt1 = i;
      } else {
        paramInt1 = localCharBuffer.position() - paramInt1;
      }
      return paramInt1;
      throw new IOException("DataSourceReader is closed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.oskplayer.datasource.DataSourceReader
 * JD-Core Version:    0.7.0.1
 */