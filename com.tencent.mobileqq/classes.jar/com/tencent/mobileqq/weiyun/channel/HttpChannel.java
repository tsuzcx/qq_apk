package com.tencent.mobileqq.weiyun.channel;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.weiyun.utils.NetworkUtils;
import mqq.app.MobileQQ;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.json.JSONObject;

public class HttpChannel
{
  private static HttpPost a(String paramString)
  {
    paramString = new HttpPost(paramString);
    paramString.addHeader("Accept", "*/*");
    paramString.addHeader("User-Agent", "QdiskAndroid1.1.0");
    paramString.addHeader("Accept-Language", "zh-CN");
    paramString.addHeader("Referer", "http://udisk.qq.com/android");
    paramString.addHeader("Charset", "UTF-8");
    paramString.addHeader("Pragma", "no-cache");
    paramString.addHeader("Content-type", "application/json");
    return paramString;
  }
  
  public static DefaultHttpClient a()
  {
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    localBasicHttpParams.setParameter("http.connection.timeout", Integer.valueOf(30000));
    localBasicHttpParams.setParameter("http.socket.timeout", Integer.valueOf(45000));
    SchemeRegistry localSchemeRegistry = new SchemeRegistry();
    localSchemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
    localSchemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
    return new DefaultHttpClient(new ThreadSafeClientConnManager(localBasicHttpParams, localSchemeRegistry), localBasicHttpParams);
  }
  
  public static void a(String paramString, JSONObject paramJSONObject)
  {
    ThreadManager.post(new HttpChannel.1(paramString, paramJSONObject), 5, null, true);
  }
  
  private static void a(HttpClient paramHttpClient)
  {
    if (paramHttpClient != null) {
      paramHttpClient.getConnectionManager().shutdown();
    }
  }
  
  public static void a(HttpClient paramHttpClient, int paramInt)
  {
    if (!NetworkUtils.isWifiAvailable(MobileQQ.sMobileQQ))
    {
      localHttpParams = paramHttpClient.getParams();
      paramInt *= 5000;
      localHttpParams.setParameter("http.connection.timeout", Integer.valueOf(45000 + paramInt));
      paramHttpClient.getParams().setParameter("http.socket.timeout", Integer.valueOf(paramInt + 60000));
      return;
    }
    HttpParams localHttpParams = paramHttpClient.getParams();
    paramInt *= 5000;
    localHttpParams.setParameter("http.connection.timeout", Integer.valueOf(paramInt + 30000));
    paramHttpClient.getParams().setParameter("http.socket.timeout", Integer.valueOf(paramInt + 45000));
  }
  
  /* Error */
  public static int b(String paramString, JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: invokestatic 154	com/tencent/mobileqq/weiyun/channel/HttpChannel:a	()Lorg/apache/http/impl/client/DefaultHttpClient;
    //   3: astore_3
    //   4: aload_3
    //   5: iconst_1
    //   6: invokestatic 156	com/tencent/mobileqq/weiyun/channel/HttpChannel:a	(Lorg/apache/http/client/HttpClient;I)V
    //   9: aload_0
    //   10: invokestatic 158	com/tencent/mobileqq/weiyun/channel/HttpChannel:a	(Ljava/lang/String;)Lorg/apache/http/client/methods/HttpPost;
    //   13: astore_0
    //   14: new 160	org/apache/http/entity/StringEntity
    //   17: dup
    //   18: aload_1
    //   19: invokevirtual 166	org/json/JSONObject:toString	()Ljava/lang/String;
    //   22: invokespecial 167	org/apache/http/entity/StringEntity:<init>	(Ljava/lang/String;)V
    //   25: astore_1
    //   26: aload_1
    //   27: ldc 40
    //   29: invokevirtual 170	org/apache/http/entity/StringEntity:setContentEncoding	(Ljava/lang/String;)V
    //   32: aload_1
    //   33: ldc 48
    //   35: invokevirtual 173	org/apache/http/entity/StringEntity:setContentType	(Ljava/lang/String;)V
    //   38: aload_0
    //   39: aload_1
    //   40: invokevirtual 177	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   43: aload_3
    //   44: aload_0
    //   45: invokeinterface 181 2 0
    //   50: invokeinterface 187 1 0
    //   55: invokeinterface 193 1 0
    //   60: istore_2
    //   61: aload_3
    //   62: invokestatic 195	com/tencent/mobileqq/weiyun/channel/HttpChannel:a	(Lorg/apache/http/client/HttpClient;)V
    //   65: iload_2
    //   66: ireturn
    //   67: astore_0
    //   68: aload_3
    //   69: invokestatic 195	com/tencent/mobileqq/weiyun/channel/HttpChannel:a	(Lorg/apache/http/client/HttpClient;)V
    //   72: aload_0
    //   73: athrow
    //   74: aload_3
    //   75: invokestatic 195	com/tencent/mobileqq/weiyun/channel/HttpChannel:a	(Lorg/apache/http/client/HttpClient;)V
    //   78: iconst_m1
    //   79: ireturn
    //   80: astore_0
    //   81: goto -7 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	paramString	String
    //   0	84	1	paramJSONObject	JSONObject
    //   60	6	2	i	int
    //   3	72	3	localDefaultHttpClient	DefaultHttpClient
    // Exception table:
    //   from	to	target	type
    //   14	61	67	finally
    //   14	61	80	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.channel.HttpChannel
 * JD-Core Version:    0.7.0.1
 */