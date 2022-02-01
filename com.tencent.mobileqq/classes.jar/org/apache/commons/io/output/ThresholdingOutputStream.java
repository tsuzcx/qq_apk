package org.apache.commons.io.output;

import java.io.IOException;
import java.io.OutputStream;

public abstract class ThresholdingOutputStream
  extends OutputStream
{
  private final int threshold;
  private boolean thresholdExceeded;
  private long written;
  
  public ThresholdingOutputStream(int paramInt)
  {
    this.threshold = paramInt;
  }
  
  protected void checkThreshold(int paramInt)
  {
    if ((!this.thresholdExceeded) && (this.written + paramInt > this.threshold))
    {
      this.thresholdExceeded = true;
      thresholdReached();
    }
  }
  
  public void close()
  {
    try
    {
      flush();
      label4:
      getStream().close();
      return;
    }
    catch (IOException localIOException)
    {
      break label4;
    }
  }
  
  public void flush()
  {
    getStream().flush();
  }
  
  public long getByteCount()
  {
    return this.written;
  }
  
  protected abstract OutputStream getStream();
  
  public int getThreshold()
  {
    return this.threshold;
  }
  
  public boolean isThresholdExceeded()
  {
    return this.written > this.threshold;
  }
  
  protected void resetByteCount()
  {
    this.thresholdExceeded = false;
    this.written = 0L;
  }
  
  protected void setByteCount(long paramLong)
  {
    this.written = paramLong;
  }
  
  protected abstract void thresholdReached();
  
  public void write(int paramInt)
  {
    checkThreshold(1);
    getStream().write(paramInt);
    this.written += 1L;
  }
  
  public void write(byte[] paramArrayOfByte)
  {
    checkThreshold(paramArrayOfByte.length);
    getStream().write(paramArrayOfByte);
    this.written += paramArrayOfByte.length;
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    checkThreshold(paramInt2);
    getStream().write(paramArrayOfByte, paramInt1, paramInt2);
    this.written += paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.apache.commons.io.output.ThresholdingOutputStream
 * JD-Core Version:    0.7.0.1
 */