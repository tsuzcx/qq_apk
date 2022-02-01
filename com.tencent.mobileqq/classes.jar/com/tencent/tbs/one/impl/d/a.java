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
    catch (IOException localIOException)
    {
      localStringBuilder = new StringBuilder("Failed to open connection, url: ");
      localStringBuilder.append(paramString);
      a(203, localStringBuilder.toString(), localIOException);
      return null;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      StringBuilder localStringBuilder = new StringBuilder("Failed to parse url ");
      localStringBuilder.append(paramString);
      a(202, localStringBuilder.toString(), localMalformedURLException);
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
    //   55: checkcast 144	java/lang/String
    //   58: aload 7
    //   60: invokeinterface 265 1 0
    //   65: checkcast 144	java/lang/String
    //   68: invokevirtual 89	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   71: goto -46 -> 25
    //   74: aconst_null
    //   75: astore 11
    //   77: aconst_null
    //   78: astore 12
    //   80: aconst_null
    //   81: astore 13
    //   83: aconst_null
    //   84: astore 10
    //   86: aload 11
    //   88: astore 6
    //   90: aload 12
    //   92: astore 7
    //   94: aload 13
    //   96: astore 8
    //   98: aload_1
    //   99: aload_3
    //   100: invokevirtual 268	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   103: aload 10
    //   105: astore 9
    //   107: aload 11
    //   109: astore 6
    //   111: aload 12
    //   113: astore 7
    //   115: aload 13
    //   117: astore 8
    //   119: aload_3
    //   120: ldc_w 270
    //   123: invokevirtual 274	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   126: ifeq +176 -> 302
    //   129: aload 10
    //   131: astore 9
    //   133: aload 5
    //   135: ifnull +167 -> 302
    //   138: aload 11
    //   140: astore 6
    //   142: aload 12
    //   144: astore 7
    //   146: aload 13
    //   148: astore 8
    //   150: aload_1
    //   151: invokevirtual 278	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   154: astore 9
    //   156: aload 9
    //   158: astore_1
    //   159: aload 4
    //   161: ifnull +110 -> 271
    //   164: aload 9
    //   166: astore 6
    //   168: aload 9
    //   170: astore 7
    //   172: aload 9
    //   174: astore 8
    //   176: aload 4
    //   178: ldc_w 280
    //   181: invokeinterface 284 2 0
    //   186: checkcast 144	java/lang/String
    //   189: astore 4
    //   191: aload 9
    //   193: astore_1
    //   194: aload 9
    //   196: astore 6
    //   198: aload 9
    //   200: astore 7
    //   202: aload 9
    //   204: astore 8
    //   206: aload 4
    //   208: invokestatic 290	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   211: ifne +60 -> 271
    //   214: aload 9
    //   216: astore_1
    //   217: aload 9
    //   219: astore 6
    //   221: aload 9
    //   223: astore 7
    //   225: aload 9
    //   227: astore 8
    //   229: aload 4
    //   231: ldc 142
    //   233: invokevirtual 274	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   236: ifeq +35 -> 271
    //   239: aload 9
    //   241: astore 6
    //   243: aload 9
    //   245: astore 7
    //   247: aload 9
    //   249: astore 8
    //   251: new 292	java/util/zip/GZIPOutputStream
    //   254: dup
    //   255: new 294	java/io/BufferedOutputStream
    //   258: dup
    //   259: aload 9
    //   261: ldc_w 295
    //   264: invokespecial 298	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   267: invokespecial 301	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   270: astore_1
    //   271: aload_1
    //   272: astore 6
    //   274: aload_1
    //   275: astore 7
    //   277: aload_1
    //   278: astore 8
    //   280: aload_1
    //   281: aload 5
    //   283: invokevirtual 307	java/io/OutputStream:write	([B)V
    //   286: aload_1
    //   287: astore 6
    //   289: aload_1
    //   290: astore 7
    //   292: aload_1
    //   293: astore 8
    //   295: aload_1
    //   296: invokevirtual 310	java/io/OutputStream:flush	()V
    //   299: aload_1
    //   300: astore 9
    //   302: aload 9
    //   304: invokestatic 184	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   307: iconst_1
    //   308: ireturn
    //   309: astore_1
    //   310: goto +140 -> 450
    //   313: astore_1
    //   314: aload 7
    //   316: astore 6
    //   318: aload_0
    //   319: aload_2
    //   320: invokespecial 227	com/tencent/tbs/one/impl/d/a:b	(Ljava/lang/String;)Z
    //   323: ifne +44 -> 367
    //   326: aload 7
    //   328: astore 6
    //   330: new 91	java/lang/StringBuilder
    //   333: dup
    //   334: ldc_w 312
    //   337: invokespecial 94	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   340: astore_3
    //   341: aload 7
    //   343: astore 6
    //   345: aload_3
    //   346: aload_2
    //   347: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: pop
    //   351: aload 7
    //   353: astore 6
    //   355: aload_0
    //   356: sipush 205
    //   359: aload_3
    //   360: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   363: aload_1
    //   364: invokevirtual 105	com/tencent/tbs/one/impl/d/a:a	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   367: aload 7
    //   369: invokestatic 184	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   372: iconst_0
    //   373: ireturn
    //   374: astore_1
    //   375: aload 8
    //   377: astore 6
    //   379: new 91	java/lang/StringBuilder
    //   382: dup
    //   383: ldc_w 314
    //   386: invokespecial 94	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   389: astore 4
    //   391: aload 8
    //   393: astore 6
    //   395: aload 4
    //   397: aload_3
    //   398: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: pop
    //   402: aload 8
    //   404: astore 6
    //   406: aload 4
    //   408: ldc_w 316
    //   411: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: pop
    //   415: aload 8
    //   417: astore 6
    //   419: aload 4
    //   421: aload_2
    //   422: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: pop
    //   426: aload 8
    //   428: astore 6
    //   430: aload_0
    //   431: sipush 204
    //   434: aload 4
    //   436: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   439: aload_1
    //   440: invokevirtual 105	com/tencent/tbs/one/impl/d/a:a	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   443: aload 8
    //   445: invokestatic 184	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   448: iconst_0
    //   449: ireturn
    //   450: aload 6
    //   452: invokestatic 184	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   455: goto +5 -> 460
    //   458: aload_1
    //   459: athrow
    //   460: goto -2 -> 458
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	463	0	this	a
    //   0	463	1	paramHttpURLConnection	HttpURLConnection
    //   0	463	2	paramString1	String
    //   0	463	3	paramString2	String
    //   0	463	4	paramMap	Map<String, String>
    //   0	463	5	paramArrayOfByte	byte[]
    //   23	428	6	localObject1	java.lang.Object
    //   45	323	7	localObject2	java.lang.Object
    //   96	348	8	localObject3	java.lang.Object
    //   105	198	9	localObject4	java.lang.Object
    //   84	46	10	localObject5	java.lang.Object
    //   75	64	11	localObject6	java.lang.Object
    //   78	65	12	localObject7	java.lang.Object
    //   81	66	13	localObject8	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   98	103	309	finally
    //   119	129	309	finally
    //   150	156	309	finally
    //   176	191	309	finally
    //   206	214	309	finally
    //   229	239	309	finally
    //   251	271	309	finally
    //   280	286	309	finally
    //   295	299	309	finally
    //   318	326	309	finally
    //   330	341	309	finally
    //   345	351	309	finally
    //   355	367	309	finally
    //   379	391	309	finally
    //   395	402	309	finally
    //   406	415	309	finally
    //   419	426	309	finally
    //   430	443	309	finally
    //   98	103	313	java/lang/Exception
    //   119	129	313	java/lang/Exception
    //   150	156	313	java/lang/Exception
    //   176	191	313	java/lang/Exception
    //   206	214	313	java/lang/Exception
    //   229	239	313	java/lang/Exception
    //   251	271	313	java/lang/Exception
    //   280	286	313	java/lang/Exception
    //   295	299	313	java/lang/Exception
    //   98	103	374	java/net/ProtocolException
    //   119	129	374	java/net/ProtocolException
    //   150	156	374	java/net/ProtocolException
    //   176	191	374	java/net/ProtocolException
    //   206	214	374	java/net/ProtocolException
    //   229	239	374	java/net/ProtocolException
    //   251	271	374	java/net/ProtocolException
    //   280	286	374	java/net/ProtocolException
    //   295	299	374	java/net/ProtocolException
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
  
  protected final void a()
  {
    m.d(new a.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tbs.one.impl.d.a
 * JD-Core Version:    0.7.0.1
 */