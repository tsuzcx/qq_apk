package org.apache.http.io;

import org.apache.http.util.CharArrayBuffer;

@Deprecated
public abstract interface SessionInputBuffer
{
  public abstract HttpTransportMetrics getMetrics();
  
  public abstract boolean isDataAvailable(int paramInt);
  
  public abstract int read();
  
  public abstract int read(byte[] paramArrayOfByte);
  
  public abstract int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public abstract int readLine(CharArrayBuffer paramCharArrayBuffer);
  
  public abstract String readLine();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.http.io.SessionInputBuffer
 * JD-Core Version:    0.7.0.1
 */