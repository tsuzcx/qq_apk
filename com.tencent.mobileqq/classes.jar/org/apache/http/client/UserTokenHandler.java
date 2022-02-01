package org.apache.http.client;

import org.apache.http.protocol.HttpContext;

@Deprecated
public abstract interface UserTokenHandler
{
  public abstract Object getUserToken(HttpContext paramHttpContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.http.client.UserTokenHandler
 * JD-Core Version:    0.7.0.1
 */