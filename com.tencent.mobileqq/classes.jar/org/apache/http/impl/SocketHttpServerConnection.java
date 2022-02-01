package org.apache.http.impl;

import java.net.InetAddress;
import java.net.Socket;
import org.apache.http.HttpInetConnection;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.params.HttpParams;

@Deprecated
public class SocketHttpServerConnection
  extends AbstractHttpServerConnection
  implements HttpInetConnection
{
  public SocketHttpServerConnection()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected void assertNotOpen()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected void assertOpen()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected void bind(Socket paramSocket, HttpParams paramHttpParams)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void close()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected SessionInputBuffer createHttpDataReceiver(Socket paramSocket, int paramInt, HttpParams paramHttpParams)
  {
    throw new RuntimeException("Stub!");
  }
  
  protected SessionOutputBuffer createHttpDataTransmitter(Socket paramSocket, int paramInt, HttpParams paramHttpParams)
  {
    throw new RuntimeException("Stub!");
  }
  
  public InetAddress getLocalAddress()
  {
    throw new RuntimeException("Stub!");
  }
  
  public int getLocalPort()
  {
    throw new RuntimeException("Stub!");
  }
  
  public InetAddress getRemoteAddress()
  {
    throw new RuntimeException("Stub!");
  }
  
  public int getRemotePort()
  {
    throw new RuntimeException("Stub!");
  }
  
  protected Socket getSocket()
  {
    throw new RuntimeException("Stub!");
  }
  
  public int getSocketTimeout()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean isOpen()
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setSocketTimeout(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void shutdown()
  {
    throw new RuntimeException("Stub!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.http.impl.SocketHttpServerConnection
 * JD-Core Version:    0.7.0.1
 */