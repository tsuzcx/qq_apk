package com.tencent.qapmsdk.impl.instrumentation.a;

import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;

public class a
  implements HttpEntity
{
  final HttpEntity a;
  private com.tencent.qapmsdk.impl.instrumentation.b.a b;
  
  public a(HttpEntity paramHttpEntity)
  {
    if (paramHttpEntity != null)
    {
      this.a = paramHttpEntity;
      return;
    }
    throw new IllegalArgumentException("Missing wrapped entity");
  }
  
  public void consumeContent()
  {
    this.a.consumeContent();
  }
  
  public InputStream getContent()
  {
    com.tencent.qapmsdk.impl.instrumentation.b.a locala = this.b;
    if (locala != null) {
      return locala;
    }
    this.b = new com.tencent.qapmsdk.impl.instrumentation.b.a(this.a.getContent(), true);
    return this.b;
  }
  
  public Header getContentEncoding()
  {
    return this.a.getContentEncoding();
  }
  
  public long getContentLength()
  {
    return this.a.getContentLength();
  }
  
  public Header getContentType()
  {
    return this.a.getContentType();
  }
  
  public boolean isChunked()
  {
    return this.a.isChunked();
  }
  
  public boolean isRepeatable()
  {
    return this.a.isRepeatable();
  }
  
  public boolean isStreaming()
  {
    return this.a.isStreaming();
  }
  
  public void writeTo(OutputStream paramOutputStream)
  {
    this.a.writeTo(paramOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.a.a
 * JD-Core Version:    0.7.0.1
 */