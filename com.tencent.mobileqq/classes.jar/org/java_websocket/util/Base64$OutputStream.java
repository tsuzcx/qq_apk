package org.java_websocket.util;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Base64$OutputStream
  extends FilterOutputStream
{
  private byte[] b4;
  private boolean breakLines;
  private byte[] buffer;
  private int bufferLength;
  private byte[] decodabet;
  private boolean encode;
  private int lineLength;
  private int options;
  private int position;
  private boolean suspendEncoding;
  
  public Base64$OutputStream(OutputStream paramOutputStream)
  {
    this(paramOutputStream, 1);
  }
  
  public Base64$OutputStream(OutputStream paramOutputStream, int paramInt)
  {
    super(paramOutputStream);
    boolean bool2 = true;
    boolean bool1;
    if ((paramInt & 0x8) != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.breakLines = bool1;
    if ((paramInt & 0x1) != 0) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    this.encode = bool1;
    int i;
    if (this.encode) {
      i = 3;
    } else {
      i = 4;
    }
    this.bufferLength = i;
    this.buffer = new byte[this.bufferLength];
    this.position = 0;
    this.lineLength = 0;
    this.suspendEncoding = false;
    this.b4 = new byte[4];
    this.options = paramInt;
    this.decodabet = Base64.access$000(paramInt);
  }
  
  public void close()
  {
    flushBase64();
    super.close();
    this.buffer = null;
    this.out = null;
  }
  
  public void flushBase64()
  {
    if (this.position > 0)
    {
      if (this.encode)
      {
        this.out.write(Base64.access$100(this.b4, this.buffer, this.position, this.options));
        this.position = 0;
        return;
      }
      throw new IOException("Base64 input not properly padded.");
    }
  }
  
  public void write(int paramInt)
  {
    if (this.suspendEncoding)
    {
      this.out.write(paramInt);
      return;
    }
    byte[] arrayOfByte;
    int i;
    if (this.encode)
    {
      arrayOfByte = this.buffer;
      i = this.position;
      this.position = (i + 1);
      arrayOfByte[i] = ((byte)paramInt);
      if (this.position >= this.bufferLength)
      {
        this.out.write(Base64.access$100(this.b4, this.buffer, this.bufferLength, this.options));
        this.lineLength += 4;
        if ((this.breakLines) && (this.lineLength >= 76))
        {
          this.out.write(10);
          this.lineLength = 0;
        }
        this.position = 0;
      }
    }
    else
    {
      arrayOfByte = this.decodabet;
      i = paramInt & 0x7F;
      if (arrayOfByte[i] > -5)
      {
        arrayOfByte = this.buffer;
        i = this.position;
        this.position = (i + 1);
        arrayOfByte[i] = ((byte)paramInt);
        if (this.position >= this.bufferLength)
        {
          paramInt = Base64.access$200(arrayOfByte, 0, this.b4, 0, this.options);
          this.out.write(this.b4, 0, paramInt);
          this.position = 0;
        }
      }
      else
      {
        if (arrayOfByte[i] != -5) {
          break label222;
        }
      }
    }
    return;
    label222:
    throw new IOException("Invalid character in Base64 data.");
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.suspendEncoding)
    {
      this.out.write(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    int i = 0;
    while (i < paramInt2)
    {
      write(paramArrayOfByte[(paramInt1 + i)]);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     org.java_websocket.util.Base64.OutputStream
 * JD-Core Version:    0.7.0.1
 */