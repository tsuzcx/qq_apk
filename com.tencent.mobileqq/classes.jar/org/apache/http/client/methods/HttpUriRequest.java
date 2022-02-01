package org.apache.http.client.methods;

import java.net.URI;
import org.apache.http.HttpRequest;

@Deprecated
public abstract interface HttpUriRequest
  extends HttpRequest
{
  public abstract void abort();
  
  public abstract String getMethod();
  
  public abstract URI getURI();
  
  public abstract boolean isAborted();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.http.client.methods.HttpUriRequest
 * JD-Core Version:    0.7.0.1
 */