package com.tencent.qapmsdk.impl.instrumentation;

import android.support.annotation.NonNull;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.impl.instrumentation.b.a;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.security.Permission;
import java.util.List;
import java.util.Map;

public class d
  extends HttpURLConnection
{
  a a;
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
  
  /* Error */
  private void a(h paramh)
  {
    // Byte code:
    //   0: invokestatic 30	com/tencent/qapmsdk/impl/g/b:c	()Z
    //   3: istore_2
    //   4: iload_2
    //   5: ifne +4 -> 9
    //   8: return
    //   9: aload_1
    //   10: aload_0
    //   11: getfield 22	com/tencent/qapmsdk/impl/instrumentation/d:b	Ljava/net/HttpURLConnection;
    //   14: invokevirtual 63	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   17: invokestatic 68	com/tencent/qapmsdk/impl/g/a:a	(Ljava/lang/String;)Ljava/lang/String;
    //   20: invokevirtual 72	com/tencent/qapmsdk/impl/instrumentation/h:g	(Ljava/lang/String;)V
    //   23: aload_1
    //   24: invokevirtual 76	com/tencent/qapmsdk/impl/instrumentation/h:j	()Lcom/tencent/qapmsdk/impl/a/a/a;
    //   27: astore 4
    //   29: aload 4
    //   31: ifnull -23 -> 8
    //   34: aload_1
    //   35: invokevirtual 79	com/tencent/qapmsdk/impl/instrumentation/h:h	()Z
    //   38: ifeq +254 -> 292
    //   41: new 81	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   48: astore_3
    //   49: aload_0
    //   50: invokevirtual 87	com/tencent/qapmsdk/impl/instrumentation/d:getErrorStream	()Ljava/io/InputStream;
    //   53: astore 5
    //   55: aload 5
    //   57: instanceof 89
    //   60: ifeq +16 -> 76
    //   63: aload_3
    //   64: aload 5
    //   66: checkcast 89	com/tencent/qapmsdk/impl/instrumentation/b/a
    //   69: invokevirtual 91	com/tencent/qapmsdk/impl/instrumentation/b/a:b	()Ljava/lang/String;
    //   72: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: new 97	java/util/TreeMap
    //   79: dup
    //   80: invokespecial 98	java/util/TreeMap:<init>	()V
    //   83: astore 5
    //   85: aload_0
    //   86: getfield 22	com/tencent/qapmsdk/impl/instrumentation/d:b	Ljava/net/HttpURLConnection;
    //   89: invokevirtual 102	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   92: ifnull +98 -> 190
    //   95: aload_0
    //   96: getfield 22	com/tencent/qapmsdk/impl/instrumentation/d:b	Ljava/net/HttpURLConnection;
    //   99: invokevirtual 102	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   102: invokeinterface 108 1 0
    //   107: ifle +83 -> 190
    //   110: aload_0
    //   111: getfield 22	com/tencent/qapmsdk/impl/instrumentation/d:b	Ljava/net/HttpURLConnection;
    //   114: invokevirtual 102	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   117: astore_3
    //   118: aload_3
    //   119: invokeinterface 112 1 0
    //   124: invokeinterface 118 1 0
    //   129: astore 6
    //   131: aload 6
    //   133: invokeinterface 123 1 0
    //   138: ifeq +52 -> 190
    //   141: aload 6
    //   143: invokeinterface 127 1 0
    //   148: checkcast 129	java/lang/String
    //   151: astore 7
    //   153: aload 7
    //   155: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   158: ifne -27 -> 131
    //   161: aload 5
    //   163: aload 7
    //   165: aload_3
    //   166: aload 7
    //   168: invokeinterface 139 2 0
    //   173: checkcast 141	java/util/List
    //   176: iconst_0
    //   177: invokeinterface 144 2 0
    //   182: invokevirtual 148	java/util/TreeMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   185: pop
    //   186: goto -55 -> 131
    //   189: astore_3
    //   190: ldc 150
    //   192: astore_3
    //   193: aload_1
    //   194: invokevirtual 153	com/tencent/qapmsdk/impl/instrumentation/h:k	()Ljava/lang/String;
    //   197: ifnull +8 -> 205
    //   200: aload_1
    //   201: invokevirtual 153	com/tencent/qapmsdk/impl/instrumentation/h:k	()Ljava/lang/String;
    //   204: astore_3
    //   205: getstatic 159	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   208: iconst_3
    //   209: anewarray 129	java/lang/String
    //   212: dup
    //   213: iconst_0
    //   214: ldc 161
    //   216: aastore
    //   217: dup
    //   218: iconst_1
    //   219: ldc 163
    //   221: aastore
    //   222: dup
    //   223: iconst_2
    //   224: aload_3
    //   225: aastore
    //   226: invokevirtual 167	com/tencent/qapmsdk/common/logger/Logger:d	([Ljava/lang/String;)V
    //   229: aload 4
    //   231: aload 5
    //   233: aload_3
    //   234: invokestatic 172	com/tencent/qapmsdk/impl/d/a:a	(Lcom/tencent/qapmsdk/impl/a/a/a;Ljava/util/TreeMap;Ljava/lang/String;)V
    //   237: return
    //   238: astore_1
    //   239: getstatic 159	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   242: ldc 161
    //   244: ldc 174
    //   246: aload_1
    //   247: invokevirtual 178	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   250: return
    //   251: astore_3
    //   252: getstatic 159	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   255: ldc 161
    //   257: ldc 180
    //   259: aload_3
    //   260: invokevirtual 178	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   263: goto -240 -> 23
    //   266: astore_3
    //   267: getstatic 159	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   270: iconst_2
    //   271: anewarray 129	java/lang/String
    //   274: dup
    //   275: iconst_0
    //   276: ldc 161
    //   278: aastore
    //   279: dup
    //   280: iconst_1
    //   281: aload_3
    //   282: invokevirtual 183	java/lang/Exception:toString	()Ljava/lang/String;
    //   285: aastore
    //   286: invokevirtual 186	com/tencent/qapmsdk/common/logger/Logger:e	([Ljava/lang/String;)V
    //   289: goto -213 -> 76
    //   292: aload 4
    //   294: invokestatic 189	com/tencent/qapmsdk/impl/d/a:a	(Lcom/tencent/qapmsdk/impl/a/a/a;)V
    //   297: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	298	0	this	d
    //   0	298	1	paramh	h
    //   3	2	2	bool	boolean
    //   48	118	3	localObject1	Object
    //   189	1	3	localException1	Exception
    //   192	42	3	str1	String
    //   251	9	3	localException2	Exception
    //   266	16	3	localException3	Exception
    //   27	266	4	locala	com.tencent.qapmsdk.impl.a.a.a
    //   53	179	5	localObject2	Object
    //   129	13	6	localIterator	java.util.Iterator
    //   151	16	7	str2	String
    // Exception table:
    //   from	to	target	type
    //   85	131	189	java/lang/Exception
    //   131	186	189	java/lang/Exception
    //   0	4	238	java/lang/Exception
    //   23	29	238	java/lang/Exception
    //   34	49	238	java/lang/Exception
    //   76	85	238	java/lang/Exception
    //   193	205	238	java/lang/Exception
    //   205	237	238	java/lang/Exception
    //   252	263	238	java/lang/Exception
    //   267	289	238	java/lang/Exception
    //   292	297	238	java/lang/Exception
    //   9	23	251	java/lang/Exception
    //   49	76	266	java/lang/Exception
  }
  
  /* Error */
  private void a(Exception paramException)
  {
    // Byte code:
    //   0: invokestatic 30	com/tencent/qapmsdk/impl/g/b:c	()Z
    //   3: ifne +4 -> 7
    //   6: return
    //   7: aload_0
    //   8: invokespecial 25	com/tencent/qapmsdk/impl/instrumentation/d:b	()Lcom/tencent/qapmsdk/impl/instrumentation/h;
    //   11: astore_2
    //   12: aload_2
    //   13: aload_0
    //   14: getfield 22	com/tencent/qapmsdk/impl/instrumentation/d:b	Ljava/net/HttpURLConnection;
    //   17: invokevirtual 63	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   20: invokestatic 68	com/tencent/qapmsdk/impl/g/a:a	(Ljava/lang/String;)Ljava/lang/String;
    //   23: invokevirtual 72	com/tencent/qapmsdk/impl/instrumentation/h:g	(Ljava/lang/String;)V
    //   26: aload_2
    //   27: ifnull +18 -> 45
    //   30: aload_2
    //   31: getfield 192	com/tencent/qapmsdk/impl/instrumentation/h:a	Z
    //   34: ifne +11 -> 45
    //   37: aload_2
    //   38: aload_0
    //   39: getfield 22	com/tencent/qapmsdk/impl/instrumentation/d:b	Ljava/net/HttpURLConnection;
    //   42: invokestatic 194	com/tencent/qapmsdk/impl/instrumentation/i:b	(Lcom/tencent/qapmsdk/impl/instrumentation/h;Ljava/net/HttpURLConnection;)V
    //   45: aload_2
    //   46: aload_1
    //   47: invokestatic 197	com/tencent/qapmsdk/impl/instrumentation/i:a	(Lcom/tencent/qapmsdk/impl/instrumentation/h;Ljava/lang/Exception;)V
    //   50: aload_2
    //   51: invokevirtual 44	com/tencent/qapmsdk/impl/instrumentation/h:f	()Z
    //   54: ifne +137 -> 191
    //   57: ldc 150
    //   59: astore_1
    //   60: aload_2
    //   61: invokevirtual 153	com/tencent/qapmsdk/impl/instrumentation/h:k	()Ljava/lang/String;
    //   64: ifnull +8 -> 72
    //   67: aload_2
    //   68: invokevirtual 153	com/tencent/qapmsdk/impl/instrumentation/h:k	()Ljava/lang/String;
    //   71: astore_1
    //   72: getstatic 159	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   75: iconst_3
    //   76: anewarray 129	java/lang/String
    //   79: dup
    //   80: iconst_0
    //   81: ldc 161
    //   83: aastore
    //   84: dup
    //   85: iconst_1
    //   86: ldc 163
    //   88: aastore
    //   89: dup
    //   90: iconst_2
    //   91: aload_1
    //   92: aastore
    //   93: invokevirtual 167	com/tencent/qapmsdk/common/logger/Logger:d	([Ljava/lang/String;)V
    //   96: aload_2
    //   97: invokevirtual 76	com/tencent/qapmsdk/impl/instrumentation/h:j	()Lcom/tencent/qapmsdk/impl/a/a/a;
    //   100: astore_3
    //   101: getstatic 159	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   104: iconst_3
    //   105: anewarray 129	java/lang/String
    //   108: dup
    //   109: iconst_0
    //   110: ldc 161
    //   112: aastore
    //   113: dup
    //   114: iconst_1
    //   115: ldc 199
    //   117: aastore
    //   118: dup
    //   119: iconst_2
    //   120: aload_2
    //   121: invokevirtual 79	com/tencent/qapmsdk/impl/instrumentation/h:h	()Z
    //   124: invokestatic 203	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   127: aastore
    //   128: invokevirtual 167	com/tencent/qapmsdk/common/logger/Logger:d	([Ljava/lang/String;)V
    //   131: aload_2
    //   132: invokevirtual 79	com/tencent/qapmsdk/impl/instrumentation/h:h	()Z
    //   135: ifeq +52 -> 187
    //   138: aload_3
    //   139: aload_1
    //   140: invokestatic 206	com/tencent/qapmsdk/impl/d/a:a	(Lcom/tencent/qapmsdk/impl/a/a/a;Ljava/lang/String;)V
    //   143: return
    //   144: astore_1
    //   145: getstatic 159	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   148: ldc 161
    //   150: ldc 208
    //   152: aload_1
    //   153: invokevirtual 178	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   156: return
    //   157: astore_3
    //   158: getstatic 159	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   161: ldc 161
    //   163: ldc 180
    //   165: aload_3
    //   166: invokevirtual 178	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   169: goto -143 -> 26
    //   172: astore_3
    //   173: getstatic 159	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   176: ldc 161
    //   178: ldc 210
    //   180: aload_3
    //   181: invokevirtual 178	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   184: goto -139 -> 45
    //   187: aload_3
    //   188: invokestatic 189	com/tencent/qapmsdk/impl/d/a:a	(Lcom/tencent/qapmsdk/impl/a/a/a;)V
    //   191: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	192	0	this	d
    //   0	192	1	paramException	Exception
    //   11	121	2	localh	h
    //   100	39	3	locala	com.tencent.qapmsdk.impl.a.a.a
    //   157	9	3	localException1	Exception
    //   172	16	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	6	144	java/lang/Exception
    //   7	12	144	java/lang/Exception
    //   45	57	144	java/lang/Exception
    //   60	72	144	java/lang/Exception
    //   72	143	144	java/lang/Exception
    //   158	169	144	java/lang/Exception
    //   173	184	144	java/lang/Exception
    //   187	191	144	java/lang/Exception
    //   12	26	157	java/lang/Exception
    //   30	45	172	java/lang/Exception
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
      a locala = new a(this.b.getInputStream());
      i.c(localh, this.b);
      if (locala != null) {
        locala.a(new d.1(this, localh));
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
  
  public OutputStream getOutputStream()
  {
    try
    {
      com.tencent.qapmsdk.impl.instrumentation.b.b localb = new com.tencent.qapmsdk.impl.instrumentation.b.b(this.b.getOutputStream());
      if (localb != null) {
        localb.a(new d.3(this));
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.d
 * JD-Core Version:    0.7.0.1
 */