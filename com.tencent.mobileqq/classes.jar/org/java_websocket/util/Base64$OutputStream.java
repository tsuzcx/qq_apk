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
    boolean bool1;
    if ((paramInt & 0x8) != 0)
    {
      bool1 = true;
      this.breakLines = bool1;
      if ((paramInt & 0x1) == 0) {
        break label106;
      }
      bool1 = bool2;
      label34:
      this.encode = bool1;
      if (!this.encode) {
        break label112;
      }
    }
    label106:
    label112:
    for (int i = 3;; i = 4)
    {
      this.bufferLength = i;
      this.buffer = new byte[this.bufferLength];
      this.position = 0;
      this.lineLength = 0;
      this.suspendEncoding = false;
      this.b4 = new byte[4];
      this.options = paramInt;
      this.decodabet = Base64.access$000(paramInt);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label34;
    }
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
      }
    }
    else {
      return;
    }
    throw new IOException("Base64 input not properly padded.");
  }
  
  public void write(int paramInt)
  {
    if (this.suspendEncoding) {
      this.out.write(paramInt);
    }
    do
    {
      do
      {
        do
        {
          return;
          if (!this.encode) {
            break;
          }
          arrayOfByte = this.buffer;
          i = this.position;
          this.position = (i + 1);
          arrayOfByte[i] = ((byte)paramInt);
        } while (this.position < this.bufferLength);
        this.out.write(Base64.access$100(this.b4, this.buffer, this.bufferLength, this.options));
        this.lineLength += 4;
        if ((this.breakLines) && (this.lineLength >= 76))
        {
          this.out.write(10);
          this.lineLength = 0;
        }
        this.position = 0;
        return;
        if (this.decodabet[(paramInt & 0x7F)] <= -5) {
          break;
        }
        byte[] arrayOfByte = this.buffer;
        int i = this.position;
        this.position = (i + 1);
        arrayOfByte[i] = ((byte)paramInt);
      } while (this.position < this.bufferLength);
      paramInt = Base64.access$200(this.buffer, 0, this.b4, 0, this.options);
      this.out.write(this.b4, 0, paramInt);
      this.position = 0;
      return;
    } while (this.decodabet[(paramInt & 0x7F)] == -5);
    throw new IOException("Invalid character in Base64 data.");
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.suspendEncoding) {
      this.out.write(paramArrayOfByte, paramInt1, paramInt2);
    }
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramInt2)
      {
        write(paramArrayOfByte[(paramInt1 + i)]);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     org.java_websocket.util.Base64.OutputStream
 * JD-Core Version:    0.7.0.1
 */