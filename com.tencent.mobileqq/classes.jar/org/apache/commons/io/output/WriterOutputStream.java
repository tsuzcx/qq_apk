package org.apache.commons.io.output;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;

public class WriterOutputStream
  extends OutputStream
{
  private static final int DEFAULT_BUFFER_SIZE = 1024;
  private final CharsetDecoder decoder;
  private final ByteBuffer decoderIn = ByteBuffer.allocate(128);
  private final CharBuffer decoderOut;
  private final boolean writeImmediately;
  private final Writer writer;
  
  @Deprecated
  public WriterOutputStream(Writer paramWriter)
  {
    this(paramWriter, Charset.defaultCharset(), 1024, false);
  }
  
  public WriterOutputStream(Writer paramWriter, String paramString)
  {
    this(paramWriter, paramString, 1024, false);
  }
  
  public WriterOutputStream(Writer paramWriter, String paramString, int paramInt, boolean paramBoolean)
  {
    this(paramWriter, Charset.forName(paramString), paramInt, paramBoolean);
  }
  
  public WriterOutputStream(Writer paramWriter, Charset paramCharset)
  {
    this(paramWriter, paramCharset, 1024, false);
  }
  
  public WriterOutputStream(Writer paramWriter, Charset paramCharset, int paramInt, boolean paramBoolean)
  {
    this(paramWriter, paramCharset.newDecoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE).replaceWith("?"), paramInt, paramBoolean);
  }
  
  public WriterOutputStream(Writer paramWriter, CharsetDecoder paramCharsetDecoder)
  {
    this(paramWriter, paramCharsetDecoder, 1024, false);
  }
  
  public WriterOutputStream(Writer paramWriter, CharsetDecoder paramCharsetDecoder, int paramInt, boolean paramBoolean)
  {
    checkIbmJdkWithBrokenUTF16(paramCharsetDecoder.charset());
    this.writer = paramWriter;
    this.decoder = paramCharsetDecoder;
    this.writeImmediately = paramBoolean;
    this.decoderOut = CharBuffer.allocate(paramInt);
  }
  
  private static void checkIbmJdkWithBrokenUTF16(Charset paramCharset)
  {
    if (!"UTF-16".equals(paramCharset.name())) {
      return;
    }
    byte[] arrayOfByte = "vés".getBytes(paramCharset);
    paramCharset = paramCharset.newDecoder();
    ByteBuffer localByteBuffer = ByteBuffer.allocate(16);
    CharBuffer localCharBuffer = CharBuffer.allocate(3);
    int j = arrayOfByte.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label113;
      }
      localByteBuffer.put(arrayOfByte[i]);
      localByteBuffer.flip();
      boolean bool;
      if (i == j - 1) {
        bool = true;
      } else {
        bool = false;
      }
      try
      {
        paramCharset.decode(localByteBuffer, localCharBuffer, bool);
        localByteBuffer.compact();
        i += 1;
      }
      catch (IllegalArgumentException paramCharset)
      {
        label103:
        break label103;
      }
    }
    throw new UnsupportedOperationException("UTF-16 requested when runninng on an IBM JDK with broken UTF-16 support. Please find a JDK that supports UTF-16 if you intend to use UF-16 with WriterOutputStream");
    label113:
    localCharBuffer.rewind();
    if ("vés".equals(localCharBuffer.toString())) {
      return;
    }
    paramCharset = new UnsupportedOperationException("UTF-16 requested when runninng on an IBM JDK with broken UTF-16 support. Please find a JDK that supports UTF-16 if you intend to use UF-16 with WriterOutputStream");
    for (;;)
    {
      throw paramCharset;
    }
  }
  
  private void flushOutput()
  {
    if (this.decoderOut.position() > 0)
    {
      this.writer.write(this.decoderOut.array(), 0, this.decoderOut.position());
      this.decoderOut.rewind();
    }
  }
  
  private void processInput(boolean paramBoolean)
  {
    this.decoderIn.flip();
    for (;;)
    {
      localObject = this.decoder.decode(this.decoderIn, this.decoderOut, paramBoolean);
      if (!((CoderResult)localObject).isOverflow()) {
        break;
      }
      flushOutput();
    }
    if (((CoderResult)localObject).isUnderflow())
    {
      this.decoderIn.compact();
      return;
    }
    Object localObject = new IOException("Unexpected coder result");
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  public void close()
  {
    processInput(true);
    flushOutput();
    this.writer.close();
  }
  
  public void flush()
  {
    flushOutput();
    this.writer.flush();
  }
  
  public void write(int paramInt)
  {
    write(new byte[] { (byte)paramInt }, 0, 1);
  }
  
  public void write(byte[] paramArrayOfByte)
  {
    write(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    while (paramInt2 > 0)
    {
      int i = Math.min(paramInt2, this.decoderIn.remaining());
      this.decoderIn.put(paramArrayOfByte, paramInt1, i);
      processInput(false);
      paramInt2 -= i;
      paramInt1 += i;
    }
    if (this.writeImmediately) {
      flushOutput();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.apache.commons.io.output.WriterOutputStream
 * JD-Core Version:    0.7.0.1
 */