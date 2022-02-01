package org.apache.http.conn.scheme;

import java.net.InetAddress;
import java.net.Socket;
import org.apache.http.params.HttpParams;

@Deprecated
public abstract interface SocketFactory
{
  public abstract Socket connectSocket(Socket paramSocket, String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2, HttpParams paramHttpParams);
  
  public abstract Socket createSocket();
  
  public abstract boolean isSecure(Socket paramSocket);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.http.conn.scheme.SocketFactory
 * JD-Core Version:    0.7.0.1
 */