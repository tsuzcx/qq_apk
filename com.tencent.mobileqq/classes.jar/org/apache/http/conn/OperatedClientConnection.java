package org.apache.http.conn;

import java.net.Socket;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpHost;
import org.apache.http.HttpInetConnection;
import org.apache.http.params.HttpParams;

@Deprecated
public abstract interface OperatedClientConnection
  extends HttpClientConnection, HttpInetConnection
{
  public abstract Socket getSocket();
  
  public abstract HttpHost getTargetHost();
  
  public abstract boolean isSecure();
  
  public abstract void openCompleted(boolean paramBoolean, HttpParams paramHttpParams);
  
  public abstract void opening(Socket paramSocket, HttpHost paramHttpHost);
  
  public abstract void update(Socket paramSocket, HttpHost paramHttpHost, boolean paramBoolean, HttpParams paramHttpParams);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.http.conn.OperatedClientConnection
 * JD-Core Version:    0.7.0.1
 */