package com.tencent.mobileqq.transfile;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.animation.AnimationUtils;
import com.tencent.image.DownloadParams;
import com.tencent.image.ProtocolDownloader.Adapter;
import com.tencent.image.URLDrawableHandler;
import com.tencent.image.Utils;
import com.tencent.mobileqq.startup.step.InitUrlDrawable;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.cookie.CookieSpec;
import org.apache.http.cookie.CookieSpecRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class LastModifySupportDownloader
  extends ProtocolDownloader.Adapter
{
  private static final int BUFFER_SIZE = 4096;
  private static final String PREF_NAME = "http_lastmodify";
  private static final String TAG = "LastModifySupportDownloader";
  private DefaultHttpClient sHttpClient;
  
  public LastModifySupportDownloader()
  {
    SchemeRegistry localSchemeRegistry = new SchemeRegistry();
    localSchemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
    try
    {
      Object localObject = SSLSocketFactory.getSocketFactory();
      ((SSLSocketFactory)localObject).setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
      localSchemeRegistry.register(new Scheme("https", (SocketFactory)localObject, 443));
      label60:
      localObject = new BasicHttpParams();
      ConnManagerParams.setTimeout((HttpParams)localObject, 3000L);
      HttpConnectionParams.setConnectionTimeout((HttpParams)localObject, 30000);
      HttpConnectionParams.setSoTimeout((HttpParams)localObject, 30000);
      this.sHttpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(new BasicHttpParams(), localSchemeRegistry), null);
      return;
    }
    catch (Exception localException)
    {
      break label60;
    }
  }
  
  public static String getCacheFilePath(String paramString)
  {
    paramString = Utils.Crc64String(paramString);
    paramString = InitUrlDrawable.b.getCleanFile(paramString);
    if (paramString.exists()) {
      return paramString.getAbsolutePath();
    }
    return null;
  }
  
  private String getLastModified(String paramString)
  {
    return CommonDataAdapter.a().b().getSharedPreferences("http_lastmodify", 0).getString(paramString, "");
  }
  
  private void saveLastModified(String paramString1, String paramString2)
  {
    SharedPreferences.Editor localEditor = CommonDataAdapter.a().b().getSharedPreferences("http_lastmodify", 0).edit();
    localEditor.putString(paramString1, paramString2);
    localEditor.commit();
  }
  
  public File downloadImage(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    localObject1 = paramDownloadParams.urlStr;
    String str = Utils.Crc64String((String)localObject1);
    Object localObject3 = InitUrlDrawable.b.getCleanFile(str);
    int i;
    if ((localObject3 != null) && (((File)localObject3).exists())) {
      i = 1;
    } else {
      i = 0;
    }
    str = ((String)localObject1).replace("gamead", "http");
    localObject1 = new HttpGet(str);
    Object localObject2;
    if (paramDownloadParams.cookies != null)
    {
      localObject2 = this.sHttpClient.getCookieSpecs().getCookieSpec("best-match").formatCookies(paramDownloadParams.cookies.getCookies()).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((HttpGet)localObject1).addHeader((Header)((Iterator)localObject2).next());
      }
    }
    if ((paramDownloadParams.headers != null) && (paramDownloadParams.headers.length > 0))
    {
      localObject2 = paramDownloadParams.headers;
      int k = localObject2.length;
      j = 0;
      while (j < k)
      {
        ((HttpGet)localObject1).addHeader(localObject2[j]);
        j += 1;
      }
    }
    if (i != 0) {
      ((HttpGet)localObject1).addHeader("If-Modified-Since", getLastModified(Utils.Crc64String(str)));
    }
    try
    {
      localObject2 = this.sHttpClient.execute((HttpUriRequest)localObject1);
      j = ((HttpResponse)localObject2).getStatusLine().getStatusCode();
      if (!QLog.isColorLevel()) {
        break label572;
      }
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("-->status code: ");
      ((StringBuilder)localObject4).append(j);
      QLog.d("LastModifySupportDownloader", 2, ((StringBuilder)localObject4).toString());
    }
    finally
    {
      for (;;)
      {
        Object localObject4;
        ((HttpGet)localObject1).abort();
        for (;;)
        {
          throw paramOutputStream;
        }
        if (j != 200) {
          if (j == 304) {}
        }
      }
    }
    paramOutputStream = new StringBuilder();
    paramOutputStream.append(paramDownloadParams.url);
    paramOutputStream.append(" response error! response code: ");
    paramOutputStream.append(j);
    paramOutputStream.append(" . reason: ");
    paramOutputStream.append(((HttpResponse)localObject2).getStatusLine().getReasonPhrase());
    throw new IOException(paramOutputStream.toString());
    localObject4 = ((HttpResponse)localObject2).getEntity();
    if (j == 200)
    {
      if (i != 0) {
        ((File)localObject3).delete();
      }
      localObject3 = new BufferedInputStream(((HttpEntity)localObject4).getContent(), 4096);
      try
      {
        paramDownloadParams = new byte[4096];
        long l = 0L;
        i = ((InputStream)localObject3).read(paramDownloadParams);
        if (i != -1)
        {
          paramOutputStream.write(paramDownloadParams, 0, i);
          l += i;
          if (AnimationUtils.currentAnimationTimeMillis() - 0L <= 100L) {
            break label591;
          }
          paramURLDrawableHandler.publishProgress((int)((float)l / (float)((HttpEntity)localObject4).getContentLength() * 9500.0F));
          break label591;
        }
        if (((HttpResponse)localObject2).containsHeader("Last-Modified"))
        {
          paramOutputStream = ((HttpResponse)localObject2).getFirstHeader("Last-Modified").getValue();
          saveLastModified(Utils.Crc64String(str), paramOutputStream);
        }
      }
      finally
      {
        ((InputStream)localObject3).close();
      }
    }
    else if ((j != 304) && (paramURLDrawableHandler != null))
    {
      paramURLDrawableHandler.publishProgress(10000);
    }
    ((HttpGet)localObject1).abort();
    return null;
  }
  
  /* Error */
  public File loadImageFile(DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 165	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   4: invokestatic 97	com/tencent/image/Utils:Crc64String	(Ljava/lang/String;)Ljava/lang/String;
    //   7: astore_3
    //   8: getstatic 103	com/tencent/mobileqq/startup/step/InitUrlDrawable:b	Lcom/tencent/mobileqq/transfile/DiskCache;
    //   11: aload_3
    //   12: invokevirtual 368	com/tencent/mobileqq/transfile/DiskCache:edit	(Ljava/lang/String;)Lcom/tencent/mobileqq/transfile/DiskCache$Editor;
    //   15: astore 6
    //   17: aconst_null
    //   18: astore 5
    //   20: aconst_null
    //   21: astore_3
    //   22: new 370	java/io/FileOutputStream
    //   25: dup
    //   26: aload 6
    //   28: getfield 376	com/tencent/mobileqq/transfile/DiskCache$Editor:dirtyFile	Ljava/io/File;
    //   31: iconst_0
    //   32: invokespecial 379	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   35: astore 4
    //   37: aload_0
    //   38: aload 4
    //   40: aload_1
    //   41: aload_2
    //   42: invokevirtual 381	com/tencent/mobileqq/transfile/LastModifySupportDownloader:downloadImage	(Ljava/io/OutputStream;Lcom/tencent/image/DownloadParams;Lcom/tencent/image/URLDrawableHandler;)Ljava/io/File;
    //   45: pop
    //   46: aload 6
    //   48: invokevirtual 384	com/tencent/mobileqq/transfile/DiskCache$Editor:commit	()Ljava/io/File;
    //   51: astore_1
    //   52: aload 4
    //   54: invokevirtual 385	java/io/OutputStream:close	()V
    //   57: aload_1
    //   58: areturn
    //   59: astore_1
    //   60: aload 4
    //   62: astore_3
    //   63: goto +55 -> 118
    //   66: astore_2
    //   67: aload 4
    //   69: astore_1
    //   70: goto +11 -> 81
    //   73: astore_1
    //   74: goto +44 -> 118
    //   77: astore_2
    //   78: aload 5
    //   80: astore_1
    //   81: aload 6
    //   83: ifnull +11 -> 94
    //   86: aload_1
    //   87: astore_3
    //   88: aload 6
    //   90: iconst_0
    //   91: invokevirtual 388	com/tencent/mobileqq/transfile/DiskCache$Editor:abort	(Z)V
    //   94: aload_1
    //   95: astore_3
    //   96: invokestatic 258	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   99: ifeq +15 -> 114
    //   102: aload_1
    //   103: astore_3
    //   104: ldc 14
    //   106: iconst_2
    //   107: ldc_w 390
    //   110: aload_2
    //   111: invokestatic 393	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   114: aload_1
    //   115: astore_3
    //   116: aload_2
    //   117: athrow
    //   118: aload_3
    //   119: ifnull +7 -> 126
    //   122: aload_3
    //   123: invokevirtual 385	java/io/OutputStream:close	()V
    //   126: aload_1
    //   127: athrow
    //   128: astore_2
    //   129: aload_1
    //   130: areturn
    //   131: astore_2
    //   132: goto -6 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	this	LastModifySupportDownloader
    //   0	135	1	paramDownloadParams	DownloadParams
    //   0	135	2	paramURLDrawableHandler	URLDrawableHandler
    //   7	116	3	localObject1	Object
    //   35	33	4	localFileOutputStream	java.io.FileOutputStream
    //   18	61	5	localObject2	Object
    //   15	74	6	localEditor	DiskCache.Editor
    // Exception table:
    //   from	to	target	type
    //   37	52	59	finally
    //   37	52	66	java/lang/Exception
    //   22	37	73	finally
    //   88	94	73	finally
    //   96	102	73	finally
    //   104	114	73	finally
    //   116	118	73	finally
    //   22	37	77	java/lang/Exception
    //   52	57	128	java/io/IOException
    //   122	126	131	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.LastModifySupportDownloader
 * JD-Core Version:    0.7.0.1
 */