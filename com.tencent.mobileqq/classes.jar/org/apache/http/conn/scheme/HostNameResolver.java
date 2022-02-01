package org.apache.http.conn.scheme;

import java.net.InetAddress;

@Deprecated
public abstract interface HostNameResolver
{
  public abstract InetAddress resolve(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.http.conn.scheme.HostNameResolver
 * JD-Core Version:    0.7.0.1
 */