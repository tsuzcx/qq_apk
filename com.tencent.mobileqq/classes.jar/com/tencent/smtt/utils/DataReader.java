package com.tencent.smtt.utils;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class DataReader
  implements Closeable
{
  private final byte[] mByteBuffer = new byte[8];
  private final File mFile;
  private boolean mIsLittleEndian;
  private final RandomAccessFile mRaf;
  
  public DataReader(File paramFile)
    throws FileNotFoundException
  {
    this.mFile = paramFile;
    this.mRaf = new RandomAccessFile(this.mFile, "r");
  }
  
  public DataReader(String paramString)
    throws FileNotFoundException
  {
    this(new File(paramString));
  }
  
  public void close()
  {
    try
    {
      this.mRaf.close();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
  
  public FileChannel getChannel()
  {
    return this.mRaf.getChannel();
  }
  
  public File getFile()
  {
    return this.mFile;
  }
  
  public long length()
    throws IOException
  {
    return this.mRaf.length();
  }
  
  public long position()
    throws IOException
  {
    return this.mRaf.getFilePointer();
  }
  
  public int previewInt()
    throws IOException
  {
    long l = this.mRaf.getFilePointer();
    int i = readInt();
    this.mRaf.seek(l);
    return i;
  }
  
  public final int readBytes(byte[] paramArrayOfByte)
    throws IOException
  {
    return this.mRaf.read(paramArrayOfByte);
  }
  
  public final int readBytes(char[] paramArrayOfChar)
    throws IOException
  {
    byte[] arrayOfByte = new byte[paramArrayOfChar.length];
    int j = this.mRaf.read(arrayOfByte);
    int i = 0;
    while (i < paramArrayOfChar.length)
    {
      paramArrayOfChar[i] = ((char)arrayOfByte[i]);
      i += 1;
    }
    return j;
  }
  
  public final int readInt()
    throws IOException
  {
    int j = this.mRaf.readInt();
    int i = j;
    if (this.mIsLittleEndian) {
      i = (j & 0xFF000000) >>> 24 | (j & 0xFF) << 24 | (0xFF00 & j) << 8 | (0xFF0000 & j) >>> 8;
    }
    return i;
  }
  
  public final void readIntArray(int[] paramArrayOfInt)
    throws IOException
  {
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      paramArrayOfInt[i] = readInt();
      i += 1;
    }
  }
  
  public final long readLong()
    throws IOException
  {
    if (this.mIsLittleEndian)
    {
      this.mRaf.readFully(this.mByteBuffer, 0, 8);
      return this.mByteBuffer[7] << 56 | (this.mByteBuffer[6] & 0xFF) << 48 | (this.mByteBuffer[5] & 0xFF) << 40 | (this.mByteBuffer[4] & 0xFF) << 32 | (this.mByteBuffer[3] & 0xFF) << 24 | (this.mByteBuffer[2] & 0xFF) << 16 | (this.mByteBuffer[1] & 0xFF) << 8 | this.mByteBuffer[0] & 0xFF;
    }
    return this.mRaf.readLong();
  }
  
  public final int readRaw(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    return this.mRaf.read(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public final short readShort()
    throws IOException
  {
    int j = this.mRaf.readShort();
    int i = j;
    if (this.mIsLittleEndian) {
      i = (short)((j & 0xFF00) >>> 8 | (j & 0xFF) << 8);
    }
    return i;
  }
  
  public void seek(long paramLong)
    throws IOException
  {
    this.mRaf.seek(paramLong);
  }
  
  public void setIsLittleEndian(boolean paramBoolean)
  {
    this.mIsLittleEndian = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.utils.DataReader
 * JD-Core Version:    0.7.0.1
 */