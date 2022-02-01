package com.tencent.qapmsdk.impl.instrumentation;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qapmsdk.common.logger.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ProtocolException;
import java.net.URL;
import java.security.Permission;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;

public class e
  extends HttpsURLConnection
{
  com.tencent.qapmsdk.impl.instrumentation.b.a a;
  private HttpsURLConnection b;
  private h c;
  
  public e(@NonNull HttpsURLConnection paramHttpsURLConnection)
  {
    super(paramHttpsURLConnection.getURL());
    this.b = paramHttpsURLConnection;
    b();
    try
    {
      if (com.tencent.qapmsdk.impl.g.b.c())
      {
        this.c.b(0);
        return;
      }
    }
    catch (Exception paramHttpsURLConnection)
    {
      Logger.INSTANCE.exception("QAPM_Impl_QAPMHttpsURLConnectionExtension", "QAPMHttpsURLConnectionExtension has an error : ", paramHttpsURLConnection);
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
        Logger.INSTANCE.exception("QAPM_Impl_QAPMHttpsURLConnectionExtension", "QAPMHttpsURLConnectionExtension addTransactionAndErrorData() has an error : ", localException1);
      }
      locala = paramh.j();
      if (locala == null) {
        return;
      }
      if (locala.h() >= 400L)
      {
        localObject = new StringBuilder();
        try
        {
          InputStream localInputStream = getErrorStream();
          if ((localInputStream instanceof com.tencent.qapmsdk.impl.instrumentation.b.a)) {
            ((StringBuilder)localObject).append(((com.tencent.qapmsdk.impl.instrumentation.b.a)localInputStream).b());
          }
        }
        catch (Exception localException3)
        {
          Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMHttpsURLConnectionExtension", localException3.toString() });
        }
        if ((this.b.getHeaderFields() != null) && (this.b.getHeaderFields().size() > 0)) {
          localTreeMap = new TreeMap();
        }
      }
    }
    catch (Exception paramh)
    {
      com.tencent.qapmsdk.impl.a.a.a locala;
      Object localObject;
      TreeMap localTreeMap;
      Iterator localIterator;
      label181:
      label239:
      Logger.INSTANCE.exception("QAPM_Impl_QAPMHttpsURLConnectionExtension", "QAPMHttpsURLConnectionExtension addTransactionAndErrorData has an error : ", paramh);
      return;
    }
    try
    {
      localObject = this.b.getHeaderFields();
      localIterator = ((Map)localObject).keySet().iterator();
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (TextUtils.isEmpty(str)) {
          break label181;
        }
        localTreeMap.put(str, ((List)((Map)localObject).get(str)).get(0));
        break label181;
      }
    }
    catch (Exception localException2)
    {
      break label239;
    }
    localObject = "";
    if (paramh.k() != null) {
      localObject = paramh.k();
    }
    com.tencent.qapmsdk.impl.d.a.a(locala, localTreeMap, (String)localObject);
    return;
    ((StringBuilder)localObject).append("no response");
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
        Logger.INSTANCE.exception("QAPM_Impl_QAPMHttpsURLConnectionExtension", "QAPMTransactionStateUtil. getContentType occur an error", localException1);
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
          Logger.INSTANCE.exception("QAPM_Impl_QAPMHttpsURLConnectionExtension", "QAPMTransactionStateUtil.processUrlParams occur an error", localException2);
        }
      }
      i.a(localh, paramException);
      if (!localh.f())
      {
        paramException = "";
        if (localh.k() != null) {
          paramException = localh.k();
        }
        i.c(localh, this.b);
        com.tencent.qapmsdk.impl.a.a.a locala = localh.j();
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
      Logger.INSTANCE.exception("QAPM_Impl_QAPMHttpsURLConnectionExtension", "QAPMHttpsURLConnectionExtension error() has an error : ", paramException);
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
  
  public String getCipherSuite()
  {
    return this.b.getCipherSuite();
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
      return this.a;
    }
    catch (Exception localException)
    {
      Logger.INSTANCE.e(new String[] { "QAPM_Impl_QAPMHttpsURLConnectionExtension", localException.toString() });
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
  
  public HostnameVerifier getHostnameVerifier()
  {
    return this.b.getHostnameVerifier();
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
      locala.a(new e.1(this, localh));
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
  
  public Certificate[] getLocalCertificates()
  {
    return this.b.getLocalCertificates();
  }
  
  public Principal getLocalPrincipal()
  {
    return this.b.getLocalPrincipal();
  }
  
  public OutputStream getOutputStream()
  {
    h localh = b();
    try
    {
      com.tencent.qapmsdk.impl.instrumentation.b.b localb = new com.tencent.qapmsdk.impl.instrumentation.b.b(this.b.getOutputStream());
      localb.a(new e.2(this, localh));
      return localb;
    }
    catch (IOException localIOException)
    {
      a(localIOException);
      throw localIOException;
    }
  }
  
  public Principal getPeerPrincipal()
  {
    return this.b.getPeerPrincipal();
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
  
  public SSLSocketFactory getSSLSocketFactory()
  {
    return this.b.getSSLSocketFactory();
  }
  
  public Certificate[] getServerCertificates()
  {
    try
    {
      Certificate[] arrayOfCertificate = this.b.getServerCertificates();
      return arrayOfCertificate;
    }
    catch (SSLPeerUnverifiedException localSSLPeerUnverifiedException)
    {
      a(localSSLPeerUnverifiedException);
      throw localSSLPeerUnverifiedException;
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
  
  public void setHostnameVerifier(HostnameVerifier paramHostnameVerifier)
  {
    this.b.setHostnameVerifier(paramHostnameVerifier);
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
  
  public void setSSLSocketFactory(SSLSocketFactory paramSSLSocketFactory)
  {
    this.b.setSSLSocketFactory(paramSSLSocketFactory);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.e
 * JD-Core Version:    0.7.0.1
 */