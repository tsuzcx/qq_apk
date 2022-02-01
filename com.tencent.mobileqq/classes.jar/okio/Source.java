package okio;

import java.io.Closeable;

public abstract interface Source
  extends Closeable
{
  public abstract void close();
  
  public abstract long read(Buffer paramBuffer, long paramLong);
  
  public abstract Timeout timeout();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okio.Source
 * JD-Core Version:    0.7.0.1
 */