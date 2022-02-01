package org.apache.http;

import java.io.InputStream;
import java.io.OutputStream;

@Deprecated
public abstract interface HttpEntity
{
  public abstract void consumeContent();
  
  public abstract InputStream getContent();
  
  public abstract Header getContentEncoding();
  
  public abstract long getContentLength();
  
  public abstract Header getContentType();
  
  public abstract boolean isChunked();
  
  public abstract boolean isRepeatable();
  
  public abstract boolean isStreaming();
  
  public abstract void writeTo(OutputStream paramOutputStream);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.http.HttpEntity
 * JD-Core Version:    0.7.0.1
 */