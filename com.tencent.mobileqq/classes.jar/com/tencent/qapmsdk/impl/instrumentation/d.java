package com.tencent.qapmsdk.impl.instrumentation;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qapmsdk.common.logger.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.security.Permission;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class d
  extends HttpURLConnection
{
  com.tencent.qapmsdk.impl.instrumentation.b.a a;
  private HttpURLConnection b;
  private h c;
  
  public d(@NonNull HttpURLConnection paramHttpURLConnection)
  {
    super(paramHttpURLConnection.getURL());
    this.b = paramHttpURLConnection;
    b();
    if (com.tencent.qapmsdk.impl.g.b.c())
    {
      b();
      this.c.b(0);
    }
  }
  
  private void a()
  {
    if (!b().f()) {
      i.c(b(), this.b);
    }
  }
  
  private void a(h paramh)
  {
    try
    {
      boolean bool = com.tencent.qapmsdk.impl.g.b.c();
      if (!bool) {
        return;
      }
      try
      {
        paramh.g(com.tencent.qapmsdk.impl.g.a.a(this.b.getContentType()));
      }
      catch (Exception localException1)
      {
        Logger.INSTANCE.exception("QAPM_Impl_QAPMHttpURLConnectionExtension", "QAPMTransactionStateUtil. getcontenttype occur an error", localException1);
      }
      locala = paramh.j();
      if (locala == null) {
        return;
      }
      if (paramh.h())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        try
        {
          localObject2 = getErrorStream();
          if ((localObject2 instanceof com.tencent.qapmsdk.impl.instrumentation.b.a)) {
            localStringBuilder.append(((com.tencent.qapmsdk.impl.instrumentation.b.a)localObject2).b());
          }
        }
        catch (Exception localException2)
        {
          Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMHttpURLConnectionExtension", localException2.toString() });
        }
        localObject2 = new TreeMap();
      }
    }
    catch (Exception paramh)
    {
      com.tencent.qapmsdk.impl.a.a.a locala;
      Object localObject2;
      Object localObject1;
      label231:
      Logger.INSTANCE.exception("QAPM_Impl_QAPMHttpURLConnectionExtension", "QAPMHttpURLConnectionExtension addTransactionAndErrorData has an error : ", paramh);
      return;
    }
    try
    {
      if ((this.b.getHeaderFields() != null) && (this.b.getHeaderFields().size() > 0))
      {
        localObject1 = this.b.getHeaderFields();
        Iterator localIterator = ((Map)localObject1).keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (!TextUtils.isEmpty(str)) {
            ((TreeMap)localObject2).put(str, ((List)((Map)localObject1).get(str)).get(0));
          }
        }
      }
    }
    catch (Exception localException3)
    {
      break label231;
    }
    localObject1 = "";
    if (paramh.k() != null) {
      localObject1 = paramh.k();
    }
    Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMHttpURLConnectionExtension", "error message:", localObject1 });
    com.tencent.qapmsdk.impl.d.a.a(locala, (TreeMap)localObject2, (String)localObject1);
    return;
    com.tencent.qapmsdk.impl.d.a.a(locala);
  }
  
  private void a(Exception paramException)
  {
    try
    {
      if (!com.tencent.qapmsdk.impl.g.b.c()) {
        return;
      }
      h localh = b();
      try
      {
        localh.g(com.tencent.qapmsdk.impl.g.a.a(this.b.getContentType()));
      }
      catch (Exception localException1)
      {
        Logger.INSTANCE.exception("QAPM_Impl_QAPMHttpURLConnectionExtension", "QAPMTransactionStateUtil. getcontenttype occur an error", localException1);
      }
      if (localh != null) {
        try
        {
          if (!localh.a) {
            i.b(localh, this.b);
          }
        }
        catch (Exception localException2)
        {
          Logger.INSTANCE.exception("QAPM_Impl_QAPMHttpURLConnectionExtension", "QAPMTransactionStateUtil.processUrlParams occur an error", localException2);
        }
      }
      i.a(localh, paramException);
      if (!localh.f())
      {
        paramException = "";
        if (localh.k() != null) {
          paramException = localh.k();
        }
        Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMHttpURLConnectionExtension", "error message:", paramException });
        com.tencent.qapmsdk.impl.a.a.a locala = localh.j();
        Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMHttpURLConnectionExtension", "isError:", String.valueOf(localh.h()) });
        if (localh.h())
        {
          com.tencent.qapmsdk.impl.d.a.a(locala, paramException);
          return;
        }
        com.tencent.qapmsdk.impl.d.a.a(locala);
        return;
      }
    }
    catch (Exception paramException)
    {
      Logger.INSTANCE.exception("QAPM_Impl_QAPMHttpURLConnectionExtension", "QAPMHttpURLConnectionExtension error had an error :", paramException);
    }
  }
  
  private h b()
  {
    if (this.c == null)
    {
      this.c = new h();
      i.a(this.c, this.b);
    }
    return this.c;
  }
  
  public void addRequestProperty(String paramString1, String paramString2)
  {
    this.b.addRequestProperty(paramString1, paramString2);
  }
  
  public void connect()
  {
    b();
    try
    {
      this.b.connect();
      return;
    }
    catch (IOException localIOException)
    {
      a(localIOException);
      throw localIOException;
    }
  }
  
  public void disconnect()
  {
    h localh = this.c;
    if ((localh != null) && (!localh.f())) {
      a(this.c);
    }
    this.b.disconnect();
  }
  
  public boolean getAllowUserInteraction()
  {
    return this.b.getAllowUserInteraction();
  }
  
  public int getConnectTimeout()
  {
    return this.b.getConnectTimeout();
  }
  
  public Object getContent()
  {
    b();
    try
    {
      Object localObject = this.b.getContent();
      int i = this.b.getContentLength();
      if (i >= 0)
      {
        h localh = b();
        if (!localh.f())
        {
          localh.d(i);
          a(localh);
        }
      }
      return localObject;
    }
    catch (IOException localIOException)
    {
      a(localIOException);
      throw localIOException;
    }
  }
  
  public Object getContent(Class[] paramArrayOfClass)
  {
    b();
    try
    {
      paramArrayOfClass = this.b.getContent(paramArrayOfClass);
      a();
      return paramArrayOfClass;
    }
    catch (IOException paramArrayOfClass)
    {
      a(paramArrayOfClass);
      throw paramArrayOfClass;
    }
  }
  
  public String getContentEncoding()
  {
    b();
    String str = this.b.getContentEncoding();
    a();
    return str;
  }
  
  public int getContentLength()
  {
    b();
    int i = this.b.getContentLength();
    a();
    return i;
  }
  
  public String getContentType()
  {
    b();
    String str = this.b.getContentType();
    a();
    return str;
  }
  
  public long getDate()
  {
    b();
    long l = this.b.getDate();
    a();
    return l;
  }
  
  public boolean getDefaultUseCaches()
  {
    return this.b.getDefaultUseCaches();
  }
  
  public boolean getDoInput()
  {
    return this.b.getDoInput();
  }
  
  public boolean getDoOutput()
  {
    return this.b.getDoOutput();
  }
  
  public InputStream getErrorStream()
  {
    b();
    com.tencent.qapmsdk.impl.instrumentation.b.a locala = this.a;
    if (locala != null) {
      return locala;
    }
    try
    {
      this.a = new com.tencent.qapmsdk.impl.instrumentation.b.a(this.b.getErrorStream(), true);
      this.a.a(new d.2(this));
      return this.a;
    }
    catch (Exception localException)
    {
      Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMHttpURLConnectionExtension", "errorStream :", localException.toString() });
    }
    return this.b.getErrorStream();
  }
  
  public long getExpiration()
  {
    b();
    long l = this.b.getExpiration();
    a();
    return l;
  }
  
  public String getHeaderField(int paramInt)
  {
    b();
    String str = this.b.getHeaderField(paramInt);
    a();
    return str;
  }
  
  public String getHeaderField(String paramString)
  {
    b();
    paramString = this.b.getHeaderField(paramString);
    a();
    return paramString;
  }
  
  public long getHeaderFieldDate(String paramString, long paramLong)
  {
    b();
    paramLong = this.b.getHeaderFieldDate(paramString, paramLong);
    a();
    return paramLong;
  }
  
  public int getHeaderFieldInt(String paramString, int paramInt)
  {
    b();
    paramInt = this.b.getHeaderFieldInt(paramString, paramInt);
    a();
    return paramInt;
  }
  
  public String getHeaderFieldKey(int paramInt)
  {
    b();
    String str = this.b.getHeaderFieldKey(paramInt);
    a();
    return str;
  }
  
  public Map<String, List<String>> getHeaderFields()
  {
    b();
    Map localMap = this.b.getHeaderFields();
    a();
    return localMap;
  }
  
  public long getIfModifiedSince()
  {
    b();
    long l = this.b.getIfModifiedSince();
    a();
    return l;
  }
  
  public InputStream getInputStream()
  {
    h localh = b();
    try
    {
      com.tencent.qapmsdk.impl.instrumentation.b.a locala = new com.tencent.qapmsdk.impl.instrumentation.b.a(this.b.getInputStream());
      i.c(localh, this.b);
      locala.a(new d.1(this, localh));
      return locala;
    }
    catch (IOException localIOException)
    {
      a(localIOException);
      throw localIOException;
    }
  }
  
  public boolean getInstanceFollowRedirects()
  {
    return this.b.getInstanceFollowRedirects();
  }
  
  public long getLastModified()
  {
    b();
    long l = this.b.getLastModified();
    a();
    return l;
  }
  
  public OutputStream getOutputStream()
  {
    try
    {
      com.tencent.qapmsdk.impl.instrumentation.b.b localb = new com.tencent.qapmsdk.impl.instrumentation.b.b(this.b.getOutputStream());
      localb.a(new d.3(this));
      return localb;
    }
    catch (IOException localIOException)
    {
      a(localIOException);
      throw localIOException;
    }
  }
  
  public Permission getPermission()
  {
    return this.b.getPermission();
  }
  
  public int getReadTimeout()
  {
    return this.b.getReadTimeout();
  }
  
  public String getRequestMethod()
  {
    h localh = b();
    String str = this.b.getRequestMethod();
    i.a(localh, str);
    this.c.a(com.tencent.qapmsdk.impl.b.b.a);
    return str;
  }
  
  public Map<String, List<String>> getRequestProperties()
  {
    return this.b.getRequestProperties();
  }
  
  public String getRequestProperty(String paramString)
  {
    return this.b.getRequestProperty(paramString);
  }
  
  public int getResponseCode()
  {
    b();
    try
    {
      int i = this.b.getResponseCode();
      a();
      return i;
    }
    catch (IOException localIOException)
    {
      a(localIOException);
      throw localIOException;
    }
  }
  
  public String getResponseMessage()
  {
    b();
    try
    {
      String str = this.b.getResponseMessage();
      a();
      return str;
    }
    catch (IOException localIOException)
    {
      a(localIOException);
      throw localIOException;
    }
  }
  
  public URL getURL()
  {
    return this.b.getURL();
  }
  
  public boolean getUseCaches()
  {
    return this.b.getUseCaches();
  }
  
  public void setAllowUserInteraction(boolean paramBoolean)
  {
    this.b.setAllowUserInteraction(paramBoolean);
  }
  
  public void setChunkedStreamingMode(int paramInt)
  {
    this.b.setChunkedStreamingMode(paramInt);
  }
  
  public void setConnectTimeout(int paramInt)
  {
    this.b.setConnectTimeout(paramInt);
  }
  
  public void setDefaultUseCaches(boolean paramBoolean)
  {
    this.b.setDefaultUseCaches(paramBoolean);
  }
  
  public void setDoInput(boolean paramBoolean)
  {
    this.b.setDoInput(paramBoolean);
  }
  
  public void setDoOutput(boolean paramBoolean)
  {
    this.b.setDoOutput(paramBoolean);
  }
  
  public void setFixedLengthStreamingMode(int paramInt)
  {
    this.b.setFixedLengthStreamingMode(paramInt);
  }
  
  public void setIfModifiedSince(long paramLong)
  {
    this.b.setIfModifiedSince(paramLong);
  }
  
  public void setInstanceFollowRedirects(boolean paramBoolean)
  {
    this.b.setInstanceFollowRedirects(paramBoolean);
  }
  
  public void setReadTimeout(int paramInt)
  {
    this.b.setReadTimeout(paramInt);
  }
  
  public void setRequestMethod(String paramString)
  {
    b();
    try
    {
      this.b.setRequestMethod(paramString);
      this.c.e(paramString);
      this.c.a(com.tencent.qapmsdk.impl.b.b.a);
      i.a(b(), paramString);
      return;
    }
    catch (ProtocolException paramString)
    {
      a(paramString);
      throw paramString;
    }
  }
  
  public void setRequestProperty(String paramString1, String paramString2)
  {
    this.b.setRequestProperty(paramString1, paramString2);
  }
  
  public void setUseCaches(boolean paramBoolean)
  {
    this.b.setUseCaches(paramBoolean);
  }
  
  public String toString()
  {
    return this.b.toString();
  }
  
  public boolean usingProxy()
  {
    return this.b.usingProxy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.d
 * JD-Core Version:    0.7.0.1
 */