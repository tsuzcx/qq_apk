package com.tencent.open.base.http;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.mobileqq.transfile.TlsSniSocketFactory;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;

public class HttpImageDownloadAsyncTask
  extends HttpAsyncTask<Void, Void, Bitmap>
{
  protected String a = null;
  protected HttpImageDownloadAsyncTask.TaskCompleteCallback b = null;
  protected Bundle c = null;
  ThreadSafeClientConnManager d = null;
  
  public HttpImageDownloadAsyncTask(String paramString1, String paramString2, Bundle paramBundle, String paramString3, HttpImageDownloadAsyncTask.TaskCompleteCallback paramTaskCompleteCallback)
  {
    super(paramString2, paramString3);
    this.a = paramString1;
    this.b = paramTaskCompleteCallback;
    this.c = paramBundle;
    paramString1 = new SchemeRegistry();
    paramString1.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
    try
    {
      int i = Build.VERSION.SDK_INT;
      if ((i < 23) && (!HttpDownloadUtil.shutdownSniSupport()))
      {
        paramString1.register(new Scheme("https", new TlsSniSocketFactory(HttpImageDownloadAsyncTask.class.getSimpleName()), 443));
      }
      else
      {
        paramString2 = SSLSocketFactory.getSocketFactory();
        paramString2.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
        paramString1.register(new Scheme("https", paramString2, 443));
      }
    }
    catch (Exception paramString2)
    {
      QLog.e("HttpImageDownloadAsyncTask", 1, "createHttpClient():Can't support https on this devices.", paramString2);
    }
    this.d = new ThreadSafeClientConnManager(new BasicHttpParams(), paramString1);
  }
  
  /* Error */
  protected Bitmap a(Void... paramVarArgs)
  {
    // Byte code:
    //   0: ldc 90
    //   2: iconst_1
    //   3: ldc 114
    //   5: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8: aload_0
    //   9: getfield 28	com/tencent/open/base/http/HttpImageDownloadAsyncTask:d	Lorg/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager;
    //   12: astore_1
    //   13: aconst_null
    //   14: astore 7
    //   16: aconst_null
    //   17: astore 4
    //   19: aconst_null
    //   20: astore 9
    //   22: aconst_null
    //   23: astore 5
    //   25: aconst_null
    //   26: astore 8
    //   28: aconst_null
    //   29: astore 6
    //   31: new 119	org/apache/http/impl/client/DefaultHttpClient
    //   34: dup
    //   35: aload_1
    //   36: aconst_null
    //   37: invokespecial 122	org/apache/http/impl/client/DefaultHttpClient:<init>	(Lorg/apache/http/conn/ClientConnectionManager;Lorg/apache/http/params/HttpParams;)V
    //   40: astore 10
    //   42: aload 9
    //   44: astore_1
    //   45: new 124	org/apache/http/client/methods/HttpGet
    //   48: dup
    //   49: aload_0
    //   50: getfield 126	com/tencent/open/base/http/HttpImageDownloadAsyncTask:e	Ljava/lang/String;
    //   53: invokespecial 127	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   56: astore 11
    //   58: aload 9
    //   60: astore_1
    //   61: aload_0
    //   62: getfield 26	com/tencent/open/base/http/HttpImageDownloadAsyncTask:c	Landroid/os/Bundle;
    //   65: ifnull +91 -> 156
    //   68: aload 9
    //   70: astore_1
    //   71: aload_0
    //   72: getfield 26	com/tencent/open/base/http/HttpImageDownloadAsyncTask:c	Landroid/os/Bundle;
    //   75: invokevirtual 133	android/os/Bundle:keySet	()Ljava/util/Set;
    //   78: invokeinterface 139 1 0
    //   83: astore 12
    //   85: aload 9
    //   87: astore_1
    //   88: aload 12
    //   90: invokeinterface 144 1 0
    //   95: ifeq +61 -> 156
    //   98: aload 9
    //   100: astore_1
    //   101: aload 12
    //   103: invokeinterface 148 1 0
    //   108: checkcast 150	java/lang/String
    //   111: astore 13
    //   113: aload 9
    //   115: astore_1
    //   116: aload_0
    //   117: getfield 26	com/tencent/open/base/http/HttpImageDownloadAsyncTask:c	Landroid/os/Bundle;
    //   120: aload 13
    //   122: invokevirtual 154	android/os/Bundle:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   125: astore 14
    //   127: aload 9
    //   129: astore_1
    //   130: aload 14
    //   132: instanceof 150
    //   135: ifeq -50 -> 85
    //   138: aload 9
    //   140: astore_1
    //   141: aload 11
    //   143: aload 13
    //   145: aload 14
    //   147: checkcast 150	java/lang/String
    //   150: invokevirtual 157	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   153: goto -68 -> 85
    //   156: aload 9
    //   158: astore_1
    //   159: aload 10
    //   161: aload 11
    //   163: invokeinterface 163 2 0
    //   168: invokeinterface 169 1 0
    //   173: astore 10
    //   175: aload 10
    //   177: ifnull +127 -> 304
    //   180: aload 9
    //   182: astore_1
    //   183: aload 10
    //   185: invokeinterface 175 1 0
    //   190: astore 4
    //   192: aload 6
    //   194: astore_1
    //   195: aload 7
    //   197: astore 5
    //   199: aload_0
    //   200: aload 4
    //   202: invokevirtual 178	com/tencent/open/base/http/HttpImageDownloadAsyncTask:a	(Ljava/io/InputStream;)[B
    //   205: astore 8
    //   207: aload 6
    //   209: astore_1
    //   210: aload 7
    //   212: astore 5
    //   214: aload 8
    //   216: arraylength
    //   217: istore_2
    //   218: iconst_0
    //   219: istore_3
    //   220: aload 6
    //   222: astore_1
    //   223: aload 7
    //   225: astore 5
    //   227: aload 8
    //   229: iconst_0
    //   230: iload_2
    //   231: invokestatic 184	com/tencent/image/SafeBitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   234: astore 6
    //   236: aload 6
    //   238: ifnonnull +5 -> 243
    //   241: iconst_1
    //   242: istore_3
    //   243: aload 6
    //   245: astore_1
    //   246: aload 6
    //   248: astore 5
    //   250: ldc 90
    //   252: iconst_1
    //   253: iconst_2
    //   254: anewarray 186	java/lang/Object
    //   257: dup
    //   258: iconst_0
    //   259: ldc 188
    //   261: aastore
    //   262: dup
    //   263: iconst_1
    //   264: iload_3
    //   265: invokestatic 194	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   268: aastore
    //   269: invokestatic 197	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   272: goto +41 -> 313
    //   275: astore 5
    //   277: aload 4
    //   279: astore_1
    //   280: aload 5
    //   282: astore 4
    //   284: goto +125 -> 409
    //   287: astore 6
    //   289: aload 4
    //   291: astore 5
    //   293: aload_1
    //   294: astore 4
    //   296: goto +40 -> 336
    //   299: astore 6
    //   301: goto +79 -> 380
    //   304: aconst_null
    //   305: astore_1
    //   306: aload 4
    //   308: astore 6
    //   310: aload_1
    //   311: astore 4
    //   313: aload 4
    //   315: ifnull +8 -> 323
    //   318: aload 4
    //   320: invokevirtual 202	java/io/InputStream:close	()V
    //   323: aload 6
    //   325: areturn
    //   326: astore 4
    //   328: goto +81 -> 409
    //   331: astore 6
    //   333: aconst_null
    //   334: astore 4
    //   336: aload 5
    //   338: astore_1
    //   339: ldc 90
    //   341: iconst_1
    //   342: ldc 204
    //   344: aload 6
    //   346: invokestatic 98	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   349: aload 4
    //   351: astore_1
    //   352: aload 5
    //   354: ifnull +53 -> 407
    //   357: aload 5
    //   359: astore_1
    //   360: aload 4
    //   362: astore 5
    //   364: aload_1
    //   365: invokevirtual 202	java/io/InputStream:close	()V
    //   368: aload 5
    //   370: areturn
    //   371: astore 6
    //   373: aconst_null
    //   374: astore 5
    //   376: aload 8
    //   378: astore 4
    //   380: aload 4
    //   382: astore_1
    //   383: ldc 90
    //   385: iconst_1
    //   386: ldc 206
    //   388: aload 6
    //   390: invokestatic 98	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   393: aload 5
    //   395: astore_1
    //   396: aload 4
    //   398: ifnull +9 -> 407
    //   401: aload 4
    //   403: astore_1
    //   404: goto -40 -> 364
    //   407: aload_1
    //   408: areturn
    //   409: aload_1
    //   410: ifnull +7 -> 417
    //   413: aload_1
    //   414: invokevirtual 202	java/io/InputStream:close	()V
    //   417: goto +6 -> 423
    //   420: aload 4
    //   422: athrow
    //   423: goto -3 -> 420
    //   426: astore_1
    //   427: goto -104 -> 323
    //   430: astore_1
    //   431: aload 5
    //   433: areturn
    //   434: astore_1
    //   435: goto -18 -> 417
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	438	0	this	HttpImageDownloadAsyncTask
    //   0	438	1	paramVarArgs	Void[]
    //   217	14	2	i	int
    //   219	46	3	bool	boolean
    //   17	302	4	localObject1	java.lang.Object
    //   326	1	4	localObject2	java.lang.Object
    //   334	87	4	localObject3	java.lang.Object
    //   23	226	5	localObject4	java.lang.Object
    //   275	6	5	localObject5	java.lang.Object
    //   291	141	5	localObject6	java.lang.Object
    //   29	218	6	localBitmap	Bitmap
    //   287	1	6	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   299	1	6	localException1	Exception
    //   308	16	6	localObject7	java.lang.Object
    //   331	14	6	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   371	18	6	localException2	Exception
    //   14	210	7	localObject8	java.lang.Object
    //   26	351	8	arrayOfByte	byte[]
    //   20	161	9	localObject9	java.lang.Object
    //   40	144	10	localObject10	java.lang.Object
    //   56	106	11	localHttpGet	org.apache.http.client.methods.HttpGet
    //   83	19	12	localIterator	java.util.Iterator
    //   111	33	13	str	String
    //   125	21	14	localObject11	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   199	207	275	finally
    //   214	218	275	finally
    //   227	236	275	finally
    //   250	272	275	finally
    //   199	207	287	java/lang/OutOfMemoryError
    //   214	218	287	java/lang/OutOfMemoryError
    //   227	236	287	java/lang/OutOfMemoryError
    //   250	272	287	java/lang/OutOfMemoryError
    //   199	207	299	java/lang/Exception
    //   214	218	299	java/lang/Exception
    //   227	236	299	java/lang/Exception
    //   250	272	299	java/lang/Exception
    //   45	58	326	finally
    //   61	68	326	finally
    //   71	85	326	finally
    //   88	98	326	finally
    //   101	113	326	finally
    //   116	127	326	finally
    //   130	138	326	finally
    //   141	153	326	finally
    //   159	175	326	finally
    //   183	192	326	finally
    //   339	349	326	finally
    //   383	393	326	finally
    //   45	58	331	java/lang/OutOfMemoryError
    //   61	68	331	java/lang/OutOfMemoryError
    //   71	85	331	java/lang/OutOfMemoryError
    //   88	98	331	java/lang/OutOfMemoryError
    //   101	113	331	java/lang/OutOfMemoryError
    //   116	127	331	java/lang/OutOfMemoryError
    //   130	138	331	java/lang/OutOfMemoryError
    //   141	153	331	java/lang/OutOfMemoryError
    //   159	175	331	java/lang/OutOfMemoryError
    //   183	192	331	java/lang/OutOfMemoryError
    //   45	58	371	java/lang/Exception
    //   61	68	371	java/lang/Exception
    //   71	85	371	java/lang/Exception
    //   88	98	371	java/lang/Exception
    //   101	113	371	java/lang/Exception
    //   116	127	371	java/lang/Exception
    //   130	138	371	java/lang/Exception
    //   141	153	371	java/lang/Exception
    //   159	175	371	java/lang/Exception
    //   183	192	371	java/lang/Exception
    //   318	323	426	java/io/IOException
    //   364	368	430	java/io/IOException
    //   413	417	434	java/io/IOException
  }
  
  protected void a(Bitmap paramBitmap)
  {
    HttpImageDownloadAsyncTask.TaskCompleteCallback localTaskCompleteCallback = this.b;
    if (localTaskCompleteCallback != null) {
      localTaskCompleteCallback.a(this.a, paramBitmap);
    }
  }
  
  protected byte[] a(InputStream paramInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte[1024];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte, 0, 1024);
      if (i == -1) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
      localByteArrayOutputStream.flush();
    }
    return localByteArrayOutputStream.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.base.http.HttpImageDownloadAsyncTask
 * JD-Core Version:    0.7.0.1
 */