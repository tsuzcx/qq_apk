package org.apache.http.impl.io;

import java.net.Socket;
import org.apache.http.params.HttpParams;

@Deprecated
public class SocketInputBuffer
  extends AbstractSessionInputBuffer
{
  public SocketInputBuffer(Socket paramSocket, int paramInt, HttpParams paramHttpParams)
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean isDataAvailable(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean isStale()
  {
    throw new RuntimeException("Stub!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.http.impl.io.SocketInputBuffer
 * JD-Core Version:    0.7.0.1
 */