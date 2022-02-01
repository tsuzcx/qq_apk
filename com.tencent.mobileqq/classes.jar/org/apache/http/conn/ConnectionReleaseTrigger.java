package org.apache.http.conn;

@Deprecated
public abstract interface ConnectionReleaseTrigger
{
  public abstract void abortConnection();
  
  public abstract void releaseConnection();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.http.conn.ConnectionReleaseTrigger
 * JD-Core Version:    0.7.0.1
 */