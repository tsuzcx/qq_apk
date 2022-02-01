package org.apache.http.conn;

import java.net.InetAddress;
import java.net.Socket;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.params.HttpParams;

@Deprecated
public final class MultihomePlainSocketFactory
  implements SocketFactory
{
  MultihomePlainSocketFactory()
  {
    throw new RuntimeException("Stub!");
  }
  
  public static MultihomePlainSocketFactory getSocketFactory()
  {
    throw new RuntimeException("Stub!");
  }
  
  public Socket connectSocket(Socket paramSocket, String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2, HttpParams paramHttpParams)
  {
    throw new RuntimeException("Stub!");
  }
  
  public Socket createSocket()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean equals(Object paramObject)
  {
    throw new RuntimeException("Stub!");
  }
  
  public int hashCode()
  {
    throw new RuntimeException("Stub!");
  }
  
  public final boolean isSecure(Socket paramSocket)
  {
    throw new RuntimeException("Stub!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.http.conn.MultihomePlainSocketFactory
 * JD-Core Version:    0.7.0.1
 */