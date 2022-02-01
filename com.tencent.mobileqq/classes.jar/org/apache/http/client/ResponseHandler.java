package org.apache.http.client;

import org.apache.http.HttpResponse;

@Deprecated
public abstract interface ResponseHandler<T>
{
  public abstract T handleResponse(HttpResponse paramHttpResponse);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.http.client.ResponseHandler
 * JD-Core Version:    0.7.0.1
 */