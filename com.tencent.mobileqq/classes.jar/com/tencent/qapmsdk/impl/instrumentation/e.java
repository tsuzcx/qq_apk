package com.tencent.qapmsdk.impl.instrumentation;

import android.support.annotation.NonNull;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.impl.instrumentation.b.a;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ProtocolException;
import java.net.URL;
import java.security.Permission;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;

public class e
  extends HttpsURLConnection
{
  a a;
  private HttpsURLConnection b;
  private h c;
  
  public e(@NonNull HttpsURLConnection paramHttpsURLConnection)
  {
    super(paramHttpsURLConnection.getURL());
    this.b = paramHttpsURLConnection;
    b();
    try
    {
      if (com.tencent.qapmsdk.impl.g.b.c()) {
        this.c.b(0);
      }
      return;
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
  
  /* Error */
  private void a(h paramh)
  {
    // Byte code:
    //   0: invokestatic 32	com/tencent/qapmsdk/impl/g/b:c	()Z
    //   3: istore_2
    //   4: iload_2
    //   5: ifne +4 -> 9
    //   8: return
    //   9: aload_1
    //   10: aload_0
    //   11: getfield 24	com/tencent/qapmsdk/impl/instrumentation/e:b	Ljavax/net/ssl/HttpsURLConnection;
    //   14: invokevirtual 77	javax/net/ssl/HttpsURLConnection:getContentType	()Ljava/lang/String;
    //   17: invokestatic 82	com/tencent/qapmsdk/impl/g/a:a	(Ljava/lang/String;)Ljava/lang/String;
    //   20: invokevirtual 86	com/tencent/qapmsdk/impl/instrumentation/h:g	(Ljava/lang/String;)V
    //   23: aload_1
    //   24: invokevirtual 90	com/tencent/qapmsdk/impl/instrumentation/h:j	()Lcom/tencent/qapmsdk/impl/a/a/a;
    //   27: astore 4
    //   29: aload 4
    //   31: ifnull -23 -> 8
    //   34: aload 4
    //   36: invokevirtual 96	com/tencent/qapmsdk/impl/a/a/a:h	()I
    //   39: i2l
    //   40: ldc2_w 97
    //   43: lcmp
    //   44: iflt +240 -> 284
    //   47: new 100	java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   54: astore_3
    //   55: aload_0
    //   56: invokevirtual 106	com/tencent/qapmsdk/impl/instrumentation/e:getErrorStream	()Ljava/io/InputStream;
    //   59: astore 5
    //   61: aload 5
    //   63: instanceof 108
    //   66: ifeq +16 -> 82
    //   69: aload_3
    //   70: aload 5
    //   72: checkcast 108	com/tencent/qapmsdk/impl/instrumentation/b/a
    //   75: invokevirtual 110	com/tencent/qapmsdk/impl/instrumentation/b/a:b	()Ljava/lang/String;
    //   78: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload_0
    //   83: getfield 24	com/tencent/qapmsdk/impl/instrumentation/e:b	Ljavax/net/ssl/HttpsURLConnection;
    //   86: invokevirtual 118	javax/net/ssl/HttpsURLConnection:getHeaderFields	()Ljava/util/Map;
    //   89: ifnull +187 -> 276
    //   92: aload_0
    //   93: getfield 24	com/tencent/qapmsdk/impl/instrumentation/e:b	Ljavax/net/ssl/HttpsURLConnection;
    //   96: invokevirtual 118	javax/net/ssl/HttpsURLConnection:getHeaderFields	()Ljava/util/Map;
    //   99: invokeinterface 123 1 0
    //   104: ifle +172 -> 276
    //   107: new 125	java/util/TreeMap
    //   110: dup
    //   111: invokespecial 126	java/util/TreeMap:<init>	()V
    //   114: astore 5
    //   116: aload_0
    //   117: getfield 24	com/tencent/qapmsdk/impl/instrumentation/e:b	Ljavax/net/ssl/HttpsURLConnection;
    //   120: invokevirtual 118	javax/net/ssl/HttpsURLConnection:getHeaderFields	()Ljava/util/Map;
    //   123: astore_3
    //   124: aload_3
    //   125: invokeinterface 130 1 0
    //   130: invokeinterface 136 1 0
    //   135: astore 6
    //   137: aload 6
    //   139: invokeinterface 141 1 0
    //   144: ifeq +52 -> 196
    //   147: aload 6
    //   149: invokeinterface 145 1 0
    //   154: checkcast 147	java/lang/String
    //   157: astore 7
    //   159: aload 7
    //   161: invokestatic 153	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   164: ifne -27 -> 137
    //   167: aload 5
    //   169: aload 7
    //   171: aload_3
    //   172: aload 7
    //   174: invokeinterface 157 2 0
    //   179: checkcast 159	java/util/List
    //   182: iconst_0
    //   183: invokeinterface 162 2 0
    //   188: invokevirtual 166	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   191: pop
    //   192: goto -55 -> 137
    //   195: astore_3
    //   196: ldc 168
    //   198: astore_3
    //   199: aload_1
    //   200: invokevirtual 171	com/tencent/qapmsdk/impl/instrumentation/h:k	()Ljava/lang/String;
    //   203: ifnull +8 -> 211
    //   206: aload_1
    //   207: invokevirtual 171	com/tencent/qapmsdk/impl/instrumentation/h:k	()Ljava/lang/String;
    //   210: astore_3
    //   211: aload 4
    //   213: aload 5
    //   215: aload_3
    //   216: invokestatic 176	com/tencent/qapmsdk/impl/d/a:a	(Lcom/tencent/qapmsdk/impl/a/a/a;Ljava/util/TreeMap;Ljava/lang/String;)V
    //   219: return
    //   220: astore_1
    //   221: getstatic 45	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   224: ldc 47
    //   226: ldc 178
    //   228: aload_1
    //   229: invokevirtual 53	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   232: return
    //   233: astore_3
    //   234: getstatic 45	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   237: ldc 47
    //   239: ldc 180
    //   241: aload_3
    //   242: invokevirtual 53	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   245: goto -222 -> 23
    //   248: astore 5
    //   250: getstatic 45	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   253: iconst_2
    //   254: anewarray 147	java/lang/String
    //   257: dup
    //   258: iconst_0
    //   259: ldc 47
    //   261: aastore
    //   262: dup
    //   263: iconst_1
    //   264: aload 5
    //   266: invokevirtual 183	java/lang/Exception:toString	()Ljava/lang/String;
    //   269: aastore
    //   270: invokevirtual 187	com/tencent/qapmsdk/common/logger/Logger:e	([Ljava/lang/String;)V
    //   273: goto -191 -> 82
    //   276: aload_3
    //   277: ldc 189
    //   279: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: pop
    //   283: return
    //   284: aload 4
    //   286: invokestatic 192	com/tencent/qapmsdk/impl/d/a:a	(Lcom/tencent/qapmsdk/impl/a/a/a;)V
    //   289: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	290	0	this	e
    //   0	290	1	paramh	h
    //   3	2	2	bool	boolean
    //   54	118	3	localObject1	Object
    //   195	1	3	localException1	Exception
    //   198	18	3	str1	String
    //   233	44	3	localException2	Exception
    //   27	258	4	locala	com.tencent.qapmsdk.impl.a.a.a
    //   59	155	5	localObject2	Object
    //   248	17	5	localException3	Exception
    //   135	13	6	localIterator	java.util.Iterator
    //   157	16	7	str2	String
    // Exception table:
    //   from	to	target	type
    //   116	137	195	java/lang/Exception
    //   137	192	195	java/lang/Exception
    //   0	4	220	java/lang/Exception
    //   23	29	220	java/lang/Exception
    //   34	55	220	java/lang/Exception
    //   82	116	220	java/lang/Exception
    //   199	211	220	java/lang/Exception
    //   211	219	220	java/lang/Exception
    //   234	245	220	java/lang/Exception
    //   250	273	220	java/lang/Exception
    //   276	283	220	java/lang/Exception
    //   284	289	220	java/lang/Exception
    //   9	23	233	java/lang/Exception
    //   55	82	248	java/lang/Exception
  }
  
  /* Error */
  private void a(Exception paramException)
  {
    // Byte code:
    //   0: invokestatic 32	com/tencent/qapmsdk/impl/g/b:c	()Z
    //   3: ifne +4 -> 7
    //   6: return
    //   7: aload_0
    //   8: invokespecial 27	com/tencent/qapmsdk/impl/instrumentation/e:b	()Lcom/tencent/qapmsdk/impl/instrumentation/h;
    //   11: astore_2
    //   12: aload_2
    //   13: aload_0
    //   14: getfield 24	com/tencent/qapmsdk/impl/instrumentation/e:b	Ljavax/net/ssl/HttpsURLConnection;
    //   17: invokevirtual 77	javax/net/ssl/HttpsURLConnection:getContentType	()Ljava/lang/String;
    //   20: invokestatic 82	com/tencent/qapmsdk/impl/g/a:a	(Ljava/lang/String;)Ljava/lang/String;
    //   23: invokevirtual 86	com/tencent/qapmsdk/impl/instrumentation/h:g	(Ljava/lang/String;)V
    //   26: aload_2
    //   27: ifnull +18 -> 45
    //   30: aload_2
    //   31: getfield 195	com/tencent/qapmsdk/impl/instrumentation/h:a	Z
    //   34: ifne +11 -> 45
    //   37: aload_2
    //   38: aload_0
    //   39: getfield 24	com/tencent/qapmsdk/impl/instrumentation/e:b	Ljavax/net/ssl/HttpsURLConnection;
    //   42: invokestatic 197	com/tencent/qapmsdk/impl/instrumentation/i:b	(Lcom/tencent/qapmsdk/impl/instrumentation/h;Ljava/net/HttpURLConnection;)V
    //   45: aload_2
    //   46: aload_1
    //   47: invokestatic 200	com/tencent/qapmsdk/impl/instrumentation/i:a	(Lcom/tencent/qapmsdk/impl/instrumentation/h;Ljava/lang/Exception;)V
    //   50: aload_2
    //   51: invokevirtual 60	com/tencent/qapmsdk/impl/instrumentation/h:f	()Z
    //   54: ifne +91 -> 145
    //   57: ldc 168
    //   59: astore_1
    //   60: aload_2
    //   61: invokevirtual 171	com/tencent/qapmsdk/impl/instrumentation/h:k	()Ljava/lang/String;
    //   64: ifnull +8 -> 72
    //   67: aload_2
    //   68: invokevirtual 171	com/tencent/qapmsdk/impl/instrumentation/h:k	()Ljava/lang/String;
    //   71: astore_1
    //   72: aload_2
    //   73: aload_0
    //   74: getfield 24	com/tencent/qapmsdk/impl/instrumentation/e:b	Ljavax/net/ssl/HttpsURLConnection;
    //   77: invokestatic 65	com/tencent/qapmsdk/impl/instrumentation/i:c	(Lcom/tencent/qapmsdk/impl/instrumentation/h;Ljava/net/HttpURLConnection;)V
    //   80: aload_2
    //   81: invokevirtual 90	com/tencent/qapmsdk/impl/instrumentation/h:j	()Lcom/tencent/qapmsdk/impl/a/a/a;
    //   84: astore_3
    //   85: aload_2
    //   86: invokevirtual 202	com/tencent/qapmsdk/impl/instrumentation/h:h	()Z
    //   89: ifeq +52 -> 141
    //   92: aload_3
    //   93: aload_1
    //   94: invokestatic 205	com/tencent/qapmsdk/impl/d/a:a	(Lcom/tencent/qapmsdk/impl/a/a/a;Ljava/lang/String;)V
    //   97: return
    //   98: astore_1
    //   99: getstatic 45	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   102: ldc 47
    //   104: ldc 207
    //   106: aload_1
    //   107: invokevirtual 53	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   110: return
    //   111: astore_3
    //   112: getstatic 45	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   115: ldc 47
    //   117: ldc 209
    //   119: aload_3
    //   120: invokevirtual 53	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   123: goto -97 -> 26
    //   126: astore_3
    //   127: getstatic 45	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   130: ldc 47
    //   132: ldc 211
    //   134: aload_3
    //   135: invokevirtual 53	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   138: goto -93 -> 45
    //   141: aload_3
    //   142: invokestatic 192	com/tencent/qapmsdk/impl/d/a:a	(Lcom/tencent/qapmsdk/impl/a/a/a;)V
    //   145: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	e
    //   0	146	1	paramException	Exception
    //   11	75	2	localh	h
    //   84	9	3	locala	com.tencent.qapmsdk.impl.a.a.a
    //   111	9	3	localException1	Exception
    //   126	16	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	6	98	java/lang/Exception
    //   7	12	98	java/lang/Exception
    //   45	57	98	java/lang/Exception
    //   60	72	98	java/lang/Exception
    //   72	97	98	java/lang/Exception
    //   112	123	98	java/lang/Exception
    //   127	138	98	java/lang/Exception
    //   141	145	98	java/lang/Exception
    //   12	26	111	java/lang/Exception
    //   30	45	126	java/lang/Exception
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
    if ((this.c != null) && (!this.c.f())) {
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
    if (this.a != null) {
      return this.a;
    }
    try
    {
      this.a = new a(this.b.getErrorStream(), true);
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
      a locala = new a(this.b.getInputStream());
      i.c(localh, this.b);
      if (locala != null) {
        locala.a(new e.1(this, localh));
      }
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
      if (localb != null) {
        localb.a(new e.2(this, localh));
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.e
 * JD-Core Version:    0.7.0.1
 */