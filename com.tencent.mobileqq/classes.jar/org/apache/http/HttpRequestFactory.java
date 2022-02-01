package org.apache.http;

@Deprecated
public abstract interface HttpRequestFactory
{
  public abstract HttpRequest newHttpRequest(String paramString1, String paramString2);
  
  public abstract HttpRequest newHttpRequest(RequestLine paramRequestLine);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.http.HttpRequestFactory
 * JD-Core Version:    0.7.0.1
 */