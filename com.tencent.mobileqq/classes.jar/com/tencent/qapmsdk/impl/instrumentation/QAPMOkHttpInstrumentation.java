package com.tencent.qapmsdk.impl.instrumentation;

import com.tencent.qapmsdk.common.logger.Logger;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class QAPMOkHttpInstrumentation
{
  private static final String TAG = "QAPM_Impl_QAPMOkHttpInstrumentation";
  
  @QAPMWrapReturn(className="com/squareup/okhttp/OkHttpClient", methodDesc="(Ljava/net/URL;)Ljava/net/HttpURLConnection;", methodName="open")
  public static HttpURLConnection open(HttpURLConnection paramHttpURLConnection)
  {
    Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMOkHttpInstrumentation", "OkHttpInstrumentation - wrapping return of call to open" });
    HttpURLConnection localHttpURLConnection = processControllerDispatch(paramHttpURLConnection);
    if ((localHttpURLConnection instanceof HttpsURLConnection)) {
      paramHttpURLConnection = new QAPMHttpsURLConnectionExtension((HttpsURLConnection)localHttpURLConnection);
    }
    do
    {
      return paramHttpURLConnection;
      paramHttpURLConnection = localHttpURLConnection;
    } while (localHttpURLConnection == null);
    return new QAPMHttpURLConnectionExtension(localHttpURLConnection);
  }
  
  @QAPMWrapReturn(className="com/squareup/okhttp/OkHttpClient", methodDesc="(Ljava/net/URL;Ljava/net/Proxy)Ljava/net/HttpURLConnection;", methodName="open")
  public static HttpURLConnection openWithProxy(HttpURLConnection paramHttpURLConnection)
  {
    Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMOkHttpInstrumentation", "OkHttpInstrumentation -wrapping return of call to openWithProxy" });
    HttpURLConnection localHttpURLConnection = processControllerDispatch(paramHttpURLConnection);
    if ((localHttpURLConnection instanceof HttpsURLConnection)) {
      paramHttpURLConnection = new QAPMHttpsURLConnectionExtension((HttpsURLConnection)localHttpURLConnection);
    }
    do
    {
      return paramHttpURLConnection;
      paramHttpURLConnection = localHttpURLConnection;
    } while (localHttpURLConnection == null);
    return new QAPMHttpURLConnectionExtension(localHttpURLConnection);
  }
  
  private static HttpURLConnection processControllerDispatch(HttpURLConnection paramHttpURLConnection)
  {
    if (paramHttpURLConnection == null) {
      return paramHttpURLConnection;
    }
    paramHttpURLConnection.getURL().getHost();
    return paramHttpURLConnection;
  }
  
  @QAPMWrapReturn(className="com/squareup/okhttp/OkUrlFactory", methodDesc="(Ljava/net/URL;)Ljava/net/HttpURLConnection;", methodName="open")
  public static HttpURLConnection urlFactoryOpen(HttpURLConnection paramHttpURLConnection)
  {
    Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMOkHttpInstrumentation", "OkHttpInstrumentation - wrapping return of call to OkUrlFactory.open..." });
    HttpURLConnection localHttpURLConnection = processControllerDispatch(paramHttpURLConnection);
    if ((localHttpURLConnection instanceof HttpsURLConnection)) {
      paramHttpURLConnection = new QAPMHttpsURLConnectionExtension((HttpsURLConnection)localHttpURLConnection);
    }
    do
    {
      return paramHttpURLConnection;
      paramHttpURLConnection = localHttpURLConnection;
    } while (localHttpURLConnection == null);
    return new QAPMHttpURLConnectionExtension(localHttpURLConnection);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.QAPMOkHttpInstrumentation
 * JD-Core Version:    0.7.0.1
 */