package org.apache.http.io;

import org.apache.http.util.CharArrayBuffer;

@Deprecated
public abstract interface SessionOutputBuffer
{
  public abstract void flush();
  
  public abstract HttpTransportMetrics getMetrics();
  
  public abstract void write(int paramInt);
  
  public abstract void write(byte[] paramArrayOfByte);
  
  public abstract void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public abstract void writeLine(String paramString);
  
  public abstract void writeLine(CharArrayBuffer paramCharArrayBuffer);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.http.io.SessionOutputBuffer
 * JD-Core Version:    0.7.0.1
 */