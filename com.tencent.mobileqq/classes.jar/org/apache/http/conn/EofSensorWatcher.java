package org.apache.http.conn;

import java.io.InputStream;

@Deprecated
public abstract interface EofSensorWatcher
{
  public abstract boolean eofDetected(InputStream paramInputStream);
  
  public abstract boolean streamAbort(InputStream paramInputStream);
  
  public abstract boolean streamClosed(InputStream paramInputStream);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.http.conn.EofSensorWatcher
 * JD-Core Version:    0.7.0.1
 */