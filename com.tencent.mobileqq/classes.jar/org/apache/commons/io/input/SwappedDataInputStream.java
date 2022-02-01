package org.apache.commons.io.input;

import java.io.DataInput;
import java.io.EOFException;
import java.io.InputStream;
import org.apache.commons.io.EndianUtils;

public class SwappedDataInputStream
  extends ProxyInputStream
  implements DataInput
{
  public SwappedDataInputStream(InputStream paramInputStream)
  {
    super(paramInputStream);
  }
  
  public boolean readBoolean()
  {
    return readByte() != 0;
  }
  
  public byte readByte()
  {
    return (byte)this.in.read();
  }
  
  public char readChar()
  {
    return (char)readShort();
  }
  
  public double readDouble()
  {
    return EndianUtils.readSwappedDouble(this.in);
  }
  
  public float readFloat()
  {
    return EndianUtils.readSwappedFloat(this.in);
  }
  
  public void readFully(byte[] paramArrayOfByte)
  {
    readFully(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void readFully(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    while (i > 0)
    {
      int j = read(paramArrayOfByte, paramInt1 + paramInt2 - i, i);
      if (-1 == j) {
        throw new EOFException();
      }
      i -= j;
    }
  }
  
  public int readInt()
  {
    return EndianUtils.readSwappedInteger(this.in);
  }
  
  public String readLine()
  {
    throw new UnsupportedOperationException("Operation not supported: readLine()");
  }
  
  public long readLong()
  {
    return EndianUtils.readSwappedLong(this.in);
  }
  
  public short readShort()
  {
    return EndianUtils.readSwappedShort(this.in);
  }
  
  public String readUTF()
  {
    throw new UnsupportedOperationException("Operation not supported: readUTF()");
  }
  
  public int readUnsignedByte()
  {
    return this.in.read();
  }
  
  public int readUnsignedShort()
  {
    return EndianUtils.readSwappedUnsignedShort(this.in);
  }
  
  public int skipBytes(int paramInt)
  {
    return (int)this.in.skip(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     org.apache.commons.io.input.SwappedDataInputStream
 * JD-Core Version:    0.7.0.1
 */