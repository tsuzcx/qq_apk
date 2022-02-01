package com.tencent.qapmsdk.impl.instrumentation.a;

import com.tencent.qapmsdk.impl.instrumentation.b.d;
import com.tencent.qapmsdk.impl.instrumentation.b.f;
import com.tencent.qapmsdk.impl.instrumentation.h;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;

public class b
  implements d, HttpEntity
{
  private final HttpEntity a;
  private final h b;
  
  public b(HttpEntity paramHttpEntity, h paramh)
  {
    this.a = paramHttpEntity;
    this.b = paramh;
  }
  
  public void a(com.tencent.qapmsdk.impl.instrumentation.b.c paramc)
  {
    ((f)paramc.getSource()).b(this);
    com.tencent.qapmsdk.impl.instrumentation.c.a(this.b, paramc.b());
    if (!this.b.f())
    {
      this.b.b(paramc.a());
      com.tencent.qapmsdk.impl.d.a.a(this.b.j(), paramc.b());
    }
  }
  
  public void b(com.tencent.qapmsdk.impl.instrumentation.b.c paramc)
  {
    ((f)paramc.getSource()).b(this);
    this.b.b(paramc.a());
  }
  
  public void consumeContent()
  {
    try
    {
      this.a.consumeContent();
      return;
    }
    catch (IOException localIOException)
    {
      com.tencent.qapmsdk.impl.instrumentation.c.a(this.b, localIOException);
      if (!this.b.f()) {
        com.tencent.qapmsdk.impl.d.a.a(this.b.j(), localIOException);
      }
      throw localIOException;
    }
  }
  
  public InputStream getContent()
  {
    try
    {
      if (!this.b.e())
      {
        localObject = new com.tencent.qapmsdk.impl.instrumentation.b.a(this.a.getContent());
        ((com.tencent.qapmsdk.impl.instrumentation.b.a)localObject).a(this);
        return localObject;
      }
      Object localObject = this.a.getContent();
      return localObject;
    }
    catch (IOException localIOException)
    {
      com.tencent.qapmsdk.impl.instrumentation.c.a(this.b, localIOException);
      if (!this.b.f()) {
        com.tencent.qapmsdk.impl.d.a.a(this.b.j(), localIOException);
      }
      throw localIOException;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      com.tencent.qapmsdk.impl.instrumentation.c.a(this.b, localIllegalStateException);
      if (!this.b.f()) {
        com.tencent.qapmsdk.impl.d.a.a(this.b.j(), localIllegalStateException);
      }
      throw localIllegalStateException;
    }
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
    try
    {
      if (!this.b.e())
      {
        paramOutputStream = new com.tencent.qapmsdk.impl.instrumentation.b.b(paramOutputStream);
        this.a.writeTo(paramOutputStream);
        this.b.b(paramOutputStream.a());
        return;
      }
      this.a.writeTo(paramOutputStream);
      return;
    }
    catch (IOException paramOutputStream)
    {
      com.tencent.qapmsdk.impl.instrumentation.c.a(this.b, paramOutputStream);
      if (!this.b.f()) {
        com.tencent.qapmsdk.impl.d.a.a(this.b.j(), paramOutputStream);
      }
      throw paramOutputStream;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.a.b
 * JD-Core Version:    0.7.0.1
 */