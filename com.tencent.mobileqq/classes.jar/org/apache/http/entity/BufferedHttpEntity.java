package org.apache.http.entity;

import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.HttpEntity;

@Deprecated
public class BufferedHttpEntity
  extends HttpEntityWrapper
{
  public BufferedHttpEntity(HttpEntity paramHttpEntity)
  {
    super((HttpEntity)null);
    throw new RuntimeException("Stub!");
  }
  
  public InputStream getContent()
  {
    throw new RuntimeException("Stub!");
  }
  
  public long getContentLength()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean isChunked()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean isRepeatable()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean isStreaming()
  {
    throw new RuntimeException("Stub!");
  }
  
  public void writeTo(OutputStream paramOutputStream)
  {
    throw new RuntimeException("Stub!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.apache.http.entity.BufferedHttpEntity
 * JD-Core Version:    0.7.0.1
 */