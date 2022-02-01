package com.tencent.qapmsdk.impl.instrumentation.a;

import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.impl.instrumentation.b.b;
import com.tencent.qapmsdk.impl.instrumentation.b.f;
import com.tencent.qapmsdk.impl.instrumentation.h;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.entity.HttpEntityWrapper;

public class d
  extends HttpEntityWrapper
  implements com.tencent.qapmsdk.impl.instrumentation.b.d
{
  private final HttpEntity a;
  private final h b;
  private final long c;
  private com.tencent.qapmsdk.impl.instrumentation.b.a d;
  private HttpResponse e;
  
  public d(HttpResponse paramHttpResponse, h paramh, long paramLong)
  {
    super(paramHttpResponse.getEntity());
    this.e = paramHttpResponse;
    this.a = paramHttpResponse.getEntity();
    this.b = paramh;
    this.c = paramLong;
  }
  
  private void a(h paramh)
  {
    try
    {
      com.tencent.qapmsdk.impl.a.a.a locala = paramh.j();
      if (locala == null)
      {
        Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMHttpResponseEntityWrapperImpl", "HttpResponseEntityWrapperImpl transactionData is null!" });
        return;
      }
      if (paramh.h())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        try
        {
          InputStream localInputStream = getContent();
          if ((localInputStream instanceof com.tencent.qapmsdk.impl.instrumentation.b.a)) {
            localStringBuilder.append(((com.tencent.qapmsdk.impl.instrumentation.b.a)localInputStream).b());
          }
        }
        catch (Exception localException)
        {
          Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMHttpResponseEntityWrapperImpl", localException.toString() });
        }
        com.tencent.qapmsdk.impl.instrumentation.c.a(this.e).put("Content-Length", Long.valueOf(paramh.i()));
        String str = "";
        if (paramh.k() != null) {
          str = paramh.k();
        }
        Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMHttpResponseEntityWrapperImpl", "error message:", str });
        com.tencent.qapmsdk.impl.d.a.a(locala, str);
        return;
      }
      com.tencent.qapmsdk.impl.d.a.a(locala);
      return;
    }
    catch (Exception paramh)
    {
      Logger.INSTANCE.exception("QAPM_Impl_QAPMHttpResponseEntityWrapperImpl", "addTransactionAndErrorData", paramh);
    }
  }
  
  public void a(com.tencent.qapmsdk.impl.instrumentation.b.c paramc)
  {
    ((f)paramc.getSource()).b(this);
    com.tencent.qapmsdk.impl.instrumentation.c.a(this.b, paramc.b());
    if (!this.b.f()) {
      this.b.d(paramc.a());
    }
  }
  
  public void b(com.tencent.qapmsdk.impl.instrumentation.b.c paramc)
  {
    ((f)paramc.getSource()).b(this);
    Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMHttpResponseEntityWrapperImpl", "streamComplete" });
    if (!this.b.f())
    {
      Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMHttpResponseEntityWrapperImpl", "transaction not complete" });
      long l = this.c;
      if (l >= 0L) {
        this.b.d(l);
      } else {
        this.b.d(paramc.a());
      }
      a(this.b);
    }
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
      if (!this.b.f())
      {
        com.tencent.qapmsdk.impl.a.a.a locala = this.b.j();
        if (this.b.h())
        {
          String str;
          if (this.b.k() != null) {
            str = this.b.k();
          } else {
            str = "";
          }
          com.tencent.qapmsdk.impl.d.a.a(locala, str);
        }
        else
        {
          com.tencent.qapmsdk.impl.d.a.a(locala);
        }
      }
      throw localIOException;
    }
  }
  
  public InputStream getContent()
  {
    com.tencent.qapmsdk.impl.instrumentation.b.a locala = this.d;
    if (locala != null) {
      return locala;
    }
    try
    {
      boolean bool2 = this.a instanceof HttpEntityWrapper;
      boolean bool1 = true;
      if (bool2) {
        bool1 = true ^ ((HttpEntityWrapper)this.a).isChunked();
      }
      this.d = new com.tencent.qapmsdk.impl.instrumentation.b.a(this.a.getContent(), bool1);
      this.d.a(this);
      locala = this.d;
      return locala;
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
    if (!this.b.f())
    {
      paramOutputStream = new b(paramOutputStream);
      try
      {
        this.a.writeTo(paramOutputStream);
        if (this.b.f()) {
          return;
        }
        long l = this.c;
        if (l >= 0L) {
          this.b.d(l);
        } else {
          this.b.d(paramOutputStream.a());
        }
        a(this.b);
        return;
      }
      catch (IOException localIOException)
      {
        com.tencent.qapmsdk.impl.instrumentation.c.a(this.b, localIOException);
        if (!this.b.f())
        {
          this.b.d(paramOutputStream.a());
          com.tencent.qapmsdk.impl.d.a.a(this.b.j(), localIOException);
        }
        localIOException.printStackTrace();
        throw localIOException;
      }
    }
    else
    {
      this.a.writeTo(paramOutputStream);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.a.d
 * JD-Core Version:    0.7.0.1
 */