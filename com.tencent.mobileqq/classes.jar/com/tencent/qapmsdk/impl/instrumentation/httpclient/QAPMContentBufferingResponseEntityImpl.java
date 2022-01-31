package com.tencent.qapmsdk.impl.instrumentation.httpclient;

import com.tencent.qapmsdk.impl.instrumentation.io.QAPMCountingInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;

public class QAPMContentBufferingResponseEntityImpl
  implements HttpEntity
{
  private QAPMCountingInputStream contentStream;
  final HttpEntity httpEntity;
  
  public QAPMContentBufferingResponseEntityImpl(HttpEntity paramHttpEntity)
  {
    if (paramHttpEntity == null) {
      throw new IllegalArgumentException("Missing wrapped entity");
    }
    this.httpEntity = paramHttpEntity;
  }
  
  public void consumeContent()
  {
    this.httpEntity.consumeContent();
  }
  
  public InputStream getContent()
  {
    if (this.contentStream != null) {
      return this.contentStream;
    }
    this.contentStream = new QAPMCountingInputStream(this.httpEntity.getContent(), true);
    return this.contentStream;
  }
  
  public Header getContentEncoding()
  {
    return this.httpEntity.getContentEncoding();
  }
  
  public long getContentLength()
  {
    return this.httpEntity.getContentLength();
  }
  
  public Header getContentType()
  {
    return this.httpEntity.getContentType();
  }
  
  public boolean isChunked()
  {
    return this.httpEntity.isChunked();
  }
  
  public boolean isRepeatable()
  {
    return this.httpEntity.isRepeatable();
  }
  
  public boolean isStreaming()
  {
    return this.httpEntity.isStreaming();
  }
  
  public void writeTo(OutputStream paramOutputStream)
  {
    this.httpEntity.writeTo(paramOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.httpclient.QAPMContentBufferingResponseEntityImpl
 * JD-Core Version:    0.7.0.1
 */