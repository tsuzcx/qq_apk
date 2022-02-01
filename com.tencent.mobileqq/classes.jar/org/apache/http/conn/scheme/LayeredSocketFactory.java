package org.apache.http.conn.scheme;

import java.net.Socket;

@Deprecated
public abstract interface LayeredSocketFactory
  extends SocketFactory
{
  public abstract Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.http.conn.scheme.LayeredSocketFactory
 * JD-Core Version:    0.7.0.1
 */