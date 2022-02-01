package com.tencent.tbs.one.impl.d;

import android.content.Context;
import com.tencent.tbs.one.impl.a.m;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public final class a
  extends com.tencent.tbs.one.impl.a.a<Integer>
{
  String b;
  String c;
  Map<String, String> d;
  byte[] e;
  public a.a f;
  public boolean g;
  private Context h;
  private int i;
  private int j;
  
  public a(Context paramContext, String paramString)
  {
    this(paramContext, paramString, "GET");
  }
  
  private a(Context paramContext, String paramString1, String paramString2)
  {
    this(paramContext, paramString1, paramString2, (byte)0);
  }
  
  private a(Context paramContext, String paramString1, String paramString2, byte paramByte)
  {
    this(paramContext, paramString1, paramString2, null, null);
  }
  
  public a(Context paramContext, String paramString1, String paramString2, Map<String, String> paramMap, byte[] paramArrayOfByte)
  {
    this.h = paramContext;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramMap;
    this.e = paramArrayOfByte;
  }
  
  private HttpURLConnection a(String paramString)
  {
    a(5);
    try
    {
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(paramString).openConnection();
      localHttpURLConnection.setDoInput(true);
      localHttpURLConnection.setUseCaches(false);
      localHttpURLConnection.setConnectTimeout(20000);
      localHttpURLConnection.setRequestProperty("Connection", "close");
      return localHttpURLConnection;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      a(202, "Failed to parse url " + paramString, localMalformedURLException);
      return null;
    }
    catch (IOException localIOException)
    {
      a(203, "Failed to open connection, url: " + paramString, localIOException);
    }
    return null;
  }
  
  /* Error */
  private boolean a(HttpURLConnection paramHttpURLConnection, String paramString1, String paramString2, Map<String, String> paramMap, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: bipush 10
    //   3: invokevirtual 60	com/tencent/tbs/one/impl/d/a:a	(I)V
    //   6: aload 4
    //   8: ifnull +66 -> 74
    //   11: aload 4
    //   13: invokeinterface 242 1 0
    //   18: invokeinterface 248 1 0
    //   23: astore 6
    //   25: aload 6
    //   27: invokeinterface 253 1 0
    //   32: ifeq +42 -> 74
    //   35: aload 6
    //   37: invokeinterface 257 1 0
    //   42: checkcast 259	java/util/Map$Entry
    //   45: astore 7
    //   47: aload_1
    //   48: aload 7
    //   50: invokeinterface 262 1 0
    //   55: checkcast 188	java/lang/String
    //   58: aload 7
    //   60: invokeinterface 265 1 0
    //   65: checkcast 188	java/lang/String
    //   68: invokevirtual 89	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   71: goto -46 -> 25
    //   74: aconst_null
    //   75: astore 7
    //   77: aload_1
    //   78: aload_3
    //   79: invokevirtual 268	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   82: aload 7
    //   84: astore 6
    //   86: aload_3
    //   87: ldc_w 270
    //   90: invokevirtual 274	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   93: ifeq +103 -> 196
    //   96: aload 7
    //   98: astore 6
    //   100: aload 5
    //   102: ifnull +94 -> 196
    //   105: aload_1
    //   106: invokevirtual 278	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   109: astore_1
    //   110: aload 4
    //   112: ifnull +230 -> 342
    //   115: aload_1
    //   116: astore 6
    //   118: aload 4
    //   120: ldc_w 280
    //   123: invokeinterface 284 2 0
    //   128: checkcast 188	java/lang/String
    //   131: astore 4
    //   133: aload_1
    //   134: astore 6
    //   136: aload 4
    //   138: invokestatic 290	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   141: ifne +201 -> 342
    //   144: aload_1
    //   145: astore 6
    //   147: aload 4
    //   149: ldc 186
    //   151: invokevirtual 274	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   154: ifeq +188 -> 342
    //   157: aload_1
    //   158: astore 6
    //   160: new 292	java/util/zip/GZIPOutputStream
    //   163: dup
    //   164: new 294	java/io/BufferedOutputStream
    //   167: dup
    //   168: aload_1
    //   169: ldc_w 295
    //   172: invokespecial 298	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   175: invokespecial 301	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   178: astore 4
    //   180: aload 4
    //   182: astore_1
    //   183: aload_1
    //   184: aload 5
    //   186: invokevirtual 307	java/io/OutputStream:write	([B)V
    //   189: aload_1
    //   190: invokevirtual 310	java/io/OutputStream:flush	()V
    //   193: aload_1
    //   194: astore 6
    //   196: aload 6
    //   198: invokestatic 208	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   201: iconst_1
    //   202: ireturn
    //   203: astore 4
    //   205: aconst_null
    //   206: astore_1
    //   207: aload_1
    //   208: astore 6
    //   210: aload_0
    //   211: sipush 204
    //   214: new 91	java/lang/StringBuilder
    //   217: dup
    //   218: ldc_w 312
    //   221: invokespecial 94	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   224: aload_3
    //   225: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: ldc_w 314
    //   231: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: aload_2
    //   235: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: aload 4
    //   243: invokevirtual 105	com/tencent/tbs/one/impl/d/a:a	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   246: aload_1
    //   247: invokestatic 208	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   250: iconst_0
    //   251: ireturn
    //   252: astore_3
    //   253: aconst_null
    //   254: astore_1
    //   255: aload_1
    //   256: astore 6
    //   258: aload_0
    //   259: aload_2
    //   260: invokespecial 156	com/tencent/tbs/one/impl/d/a:b	(Ljava/lang/String;)Z
    //   263: ifne +31 -> 294
    //   266: aload_1
    //   267: astore 6
    //   269: aload_0
    //   270: sipush 205
    //   273: new 91	java/lang/StringBuilder
    //   276: dup
    //   277: ldc_w 316
    //   280: invokespecial 94	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   283: aload_2
    //   284: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: aload_3
    //   291: invokevirtual 105	com/tencent/tbs/one/impl/d/a:a	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   294: aload_1
    //   295: invokestatic 208	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   298: iconst_0
    //   299: ireturn
    //   300: astore_1
    //   301: aconst_null
    //   302: astore 6
    //   304: aload 6
    //   306: invokestatic 208	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   309: aload_1
    //   310: athrow
    //   311: astore_1
    //   312: goto -8 -> 304
    //   315: astore_2
    //   316: aload_1
    //   317: astore 6
    //   319: aload_2
    //   320: astore_1
    //   321: goto -17 -> 304
    //   324: astore_3
    //   325: goto -70 -> 255
    //   328: astore_3
    //   329: goto -74 -> 255
    //   332: astore 4
    //   334: goto -127 -> 207
    //   337: astore 4
    //   339: goto -132 -> 207
    //   342: goto -159 -> 183
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	345	0	this	a
    //   0	345	1	paramHttpURLConnection	HttpURLConnection
    //   0	345	2	paramString1	String
    //   0	345	3	paramString2	String
    //   0	345	4	paramMap	Map<String, String>
    //   0	345	5	paramArrayOfByte	byte[]
    //   23	295	6	localObject	java.lang.Object
    //   45	52	7	localEntry	java.util.Map.Entry
    // Exception table:
    //   from	to	target	type
    //   77	82	203	java/net/ProtocolException
    //   86	96	203	java/net/ProtocolException
    //   105	110	203	java/net/ProtocolException
    //   77	82	252	java/lang/Exception
    //   86	96	252	java/lang/Exception
    //   105	110	252	java/lang/Exception
    //   77	82	300	finally
    //   86	96	300	finally
    //   105	110	300	finally
    //   118	133	311	finally
    //   136	144	311	finally
    //   147	157	311	finally
    //   160	180	311	finally
    //   210	246	311	finally
    //   258	266	311	finally
    //   269	294	311	finally
    //   183	193	315	finally
    //   118	133	324	java/lang/Exception
    //   136	144	324	java/lang/Exception
    //   147	157	324	java/lang/Exception
    //   160	180	324	java/lang/Exception
    //   183	193	328	java/lang/Exception
    //   118	133	332	java/net/ProtocolException
    //   136	144	332	java/net/ProtocolException
    //   147	157	332	java/net/ProtocolException
    //   160	180	332	java/net/ProtocolException
    //   183	193	337	java/net/ProtocolException
  }
  
  private boolean b(String paramString)
  {
    int k = this.i + 1;
    this.i = k;
    if (k > 3) {
      return false;
    }
    m.d(new a.3(this, paramString));
    return true;
  }
  
  private boolean c()
  {
    if (this.a)
    {
      a(104, "Aborted", null);
      return false;
    }
    return true;
  }
  
  public final void a()
  {
    m.d(new a.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.impl.d.a
 * JD-Core Version:    0.7.0.1
 */