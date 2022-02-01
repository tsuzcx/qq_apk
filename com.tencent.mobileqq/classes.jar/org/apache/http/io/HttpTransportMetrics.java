package org.apache.http.io;

@Deprecated
public abstract interface HttpTransportMetrics
{
  public abstract long getBytesTransferred();
  
  public abstract void reset();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.http.io.HttpTransportMetrics
 * JD-Core Version:    0.7.0.1
 */