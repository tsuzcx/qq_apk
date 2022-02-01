package com.tencent.qapmsdk.impl.instrumentation.a;

import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.impl.instrumentation.b.d;
import com.tencent.qapmsdk.impl.instrumentation.b.f;
import com.tencent.qapmsdk.impl.instrumentation.g;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.entity.HttpEntityWrapper;
import org.apache.http.message.AbstractHttpMessage;

public class c
  implements d, HttpEntity
{
  private final HttpEntity a;
  private final g b;
  private final long c;
  private com.tencent.qapmsdk.impl.instrumentation.b.a d;
  private HttpResponse e;
  
  public c(HttpResponse paramHttpResponse, g paramg, long paramLong)
  {
    this.e = paramHttpResponse;
    this.a = paramHttpResponse.getEntity();
    this.b = paramg;
    this.c = paramLong;
  }
  
  /* Error */
  private void a(g paramg)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 47	com/tencent/qapmsdk/impl/instrumentation/g:j	()Lcom/tencent/qapmsdk/impl/a/a/a;
    //   4: astore_3
    //   5: aload_3
    //   6: ifnonnull +24 -> 30
    //   9: getstatic 53	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   12: iconst_2
    //   13: anewarray 55	java/lang/String
    //   16: dup
    //   17: iconst_0
    //   18: ldc 57
    //   20: aastore
    //   21: dup
    //   22: iconst_1
    //   23: ldc 59
    //   25: aastore
    //   26: invokevirtual 62	com/tencent/qapmsdk/common/logger/Logger:d	([Ljava/lang/String;)V
    //   29: return
    //   30: aload_1
    //   31: invokevirtual 66	com/tencent/qapmsdk/impl/instrumentation/g:h	()Z
    //   34: ifeq +144 -> 178
    //   37: new 68	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   44: astore_2
    //   45: aload_0
    //   46: invokevirtual 73	com/tencent/qapmsdk/impl/instrumentation/a/c:getContent	()Ljava/io/InputStream;
    //   49: astore 4
    //   51: aload 4
    //   53: instanceof 75
    //   56: ifeq +16 -> 72
    //   59: aload_2
    //   60: aload 4
    //   62: checkcast 75	com/tencent/qapmsdk/impl/instrumentation/b/a
    //   65: invokevirtual 78	com/tencent/qapmsdk/impl/instrumentation/b/a:b	()Ljava/lang/String;
    //   68: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload_0
    //   73: getfield 25	com/tencent/qapmsdk/impl/instrumentation/a/c:e	Lorg/apache/http/HttpResponse;
    //   76: invokestatic 87	com/tencent/qapmsdk/impl/instrumentation/b:a	(Lorg/apache/http/HttpResponse;)Ljava/util/Map;
    //   79: ldc 89
    //   81: aload_1
    //   82: invokevirtual 93	com/tencent/qapmsdk/impl/instrumentation/g:i	()J
    //   85: invokestatic 99	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   88: invokeinterface 105 3 0
    //   93: pop
    //   94: ldc 107
    //   96: astore_2
    //   97: aload_1
    //   98: invokevirtual 110	com/tencent/qapmsdk/impl/instrumentation/g:k	()Ljava/lang/String;
    //   101: ifnull +8 -> 109
    //   104: aload_1
    //   105: invokevirtual 110	com/tencent/qapmsdk/impl/instrumentation/g:k	()Ljava/lang/String;
    //   108: astore_2
    //   109: getstatic 53	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   112: iconst_3
    //   113: anewarray 55	java/lang/String
    //   116: dup
    //   117: iconst_0
    //   118: ldc 57
    //   120: aastore
    //   121: dup
    //   122: iconst_1
    //   123: ldc 112
    //   125: aastore
    //   126: dup
    //   127: iconst_2
    //   128: aload_2
    //   129: aastore
    //   130: invokevirtual 62	com/tencent/qapmsdk/common/logger/Logger:d	([Ljava/lang/String;)V
    //   133: aload_3
    //   134: aload_2
    //   135: invokestatic 117	com/tencent/qapmsdk/impl/d/a:a	(Lcom/tencent/qapmsdk/impl/a/a/a;Ljava/lang/String;)V
    //   138: return
    //   139: astore_1
    //   140: getstatic 53	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   143: ldc 57
    //   145: ldc 119
    //   147: aload_1
    //   148: invokevirtual 123	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   151: return
    //   152: astore_2
    //   153: getstatic 53	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   156: iconst_2
    //   157: anewarray 55	java/lang/String
    //   160: dup
    //   161: iconst_0
    //   162: ldc 57
    //   164: aastore
    //   165: dup
    //   166: iconst_1
    //   167: aload_2
    //   168: invokevirtual 126	java/lang/Exception:toString	()Ljava/lang/String;
    //   171: aastore
    //   172: invokevirtual 128	com/tencent/qapmsdk/common/logger/Logger:e	([Ljava/lang/String;)V
    //   175: goto -103 -> 72
    //   178: aload_3
    //   179: invokestatic 131	com/tencent/qapmsdk/impl/d/a:a	(Lcom/tencent/qapmsdk/impl/a/a/a;)V
    //   182: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	this	c
    //   0	183	1	paramg	g
    //   44	91	2	localObject	Object
    //   152	16	2	localException	java.lang.Exception
    //   4	175	3	locala	com.tencent.qapmsdk.impl.a.a.a
    //   49	12	4	localInputStream	InputStream
    // Exception table:
    //   from	to	target	type
    //   0	5	139	java/lang/Exception
    //   9	29	139	java/lang/Exception
    //   30	45	139	java/lang/Exception
    //   72	94	139	java/lang/Exception
    //   97	109	139	java/lang/Exception
    //   109	138	139	java/lang/Exception
    //   153	175	139	java/lang/Exception
    //   178	182	139	java/lang/Exception
    //   45	72	152	java/lang/Exception
  }
  
  public void a(com.tencent.qapmsdk.impl.instrumentation.b.c paramc)
  {
    ((f)paramc.getSource()).b(this);
    com.tencent.qapmsdk.impl.instrumentation.b.a(this.b, paramc.b());
    if (!this.b.f()) {
      this.b.d(paramc.a());
    }
  }
  
  public void b(com.tencent.qapmsdk.impl.instrumentation.b.c paramc)
  {
    ((f)paramc.getSource()).b(this);
    Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMHttpResponseEntityImpl", "streamComplete" });
    if (!this.b.f())
    {
      Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMHttpResponseEntityImpl", "transaction not complete" });
      if (this.c < 0L) {
        break label92;
      }
      this.b.d(this.c);
    }
    for (;;)
    {
      a(this.b);
      return;
      label92:
      this.b.d(paramc.a());
    }
  }
  
  public void consumeContent()
  {
    com.tencent.qapmsdk.impl.a.a.a locala;
    try
    {
      this.a.consumeContent();
      return;
    }
    catch (IOException localIOException)
    {
      com.tencent.qapmsdk.impl.instrumentation.b.a(this.b, localIOException);
      if (!this.b.f())
      {
        locala = this.b.j();
        if (!this.b.h()) {
          break label75;
        }
        String str = "";
        if (this.b.k() != null) {
          str = this.b.k();
        }
        com.tencent.qapmsdk.impl.d.a.a(locala, str);
      }
    }
    for (;;)
    {
      throw localIOException;
      label75:
      com.tencent.qapmsdk.impl.d.a.a(locala);
    }
  }
  
  public InputStream getContent()
  {
    boolean bool2 = true;
    if (this.d != null) {
      return this.d;
    }
    label168:
    for (;;)
    {
      try
      {
        if ((this.a instanceof AbstractHttpMessage))
        {
          Header localHeader = ((AbstractHttpMessage)this.a).getLastHeader("Transfer-Encoding");
          if ((localHeader != null) && ("chunked".equalsIgnoreCase(localHeader.getValue())))
          {
            bool1 = false;
            break label168;
            this.d = new com.tencent.qapmsdk.impl.instrumentation.b.a(this.a.getContent(), bool1);
            this.d.a(this);
            return this.d;
          }
        }
        else
        {
          bool1 = bool2;
          if (!(this.a instanceof HttpEntityWrapper)) {
            continue;
          }
          boolean bool3 = this.a.isChunked();
          bool1 = bool2;
          if (!bool3) {
            continue;
          }
          bool1 = false;
          continue;
        }
        boolean bool1 = true;
      }
      catch (IOException localIOException)
      {
        com.tencent.qapmsdk.impl.instrumentation.b.a(this.b, localIOException);
        if (!this.b.f()) {
          com.tencent.qapmsdk.impl.d.a.a(this.b.j(), localIOException);
        }
        throw localIOException;
      }
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
      paramOutputStream = new com.tencent.qapmsdk.impl.instrumentation.b.b(paramOutputStream);
      for (;;)
      {
        try
        {
          this.a.writeTo(paramOutputStream);
          if (!this.b.f())
          {
            if (this.c >= 0L)
            {
              this.b.d(this.c);
              a(this.b);
            }
          }
          else {
            return;
          }
        }
        catch (IOException localIOException)
        {
          com.tencent.qapmsdk.impl.instrumentation.b.a(this.b, localIOException);
          if (!this.b.f())
          {
            this.b.d(paramOutputStream.a());
            com.tencent.qapmsdk.impl.d.a.a(this.b.j(), localIOException);
          }
          localIOException.printStackTrace();
          throw localIOException;
        }
        this.b.d(paramOutputStream.a());
      }
    }
    this.a.writeTo(paramOutputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.a.c
 * JD-Core Version:    0.7.0.1
 */