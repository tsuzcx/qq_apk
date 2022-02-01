package com.tencent.qapmsdk.impl.instrumentation;

import com.tencent.qapmsdk.common.logger.Logger;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class QAPMOkHttpInstrumentation
{
  private static final String TAG = "QAPM_Impl_QAPMOkHttpInstrumentation";
  
  public static HttpURLConnection open(HttpURLConnection paramHttpURLConnection)
  {
    Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMOkHttpInstrumentation", "OkHttpInstrumentation - wrapping return of call to open" });
    HttpURLConnection localHttpURLConnection = processControllerDispatch(paramHttpURLConnection);
    if ((localHttpURLConnection instanceof HttpsURLConnection)) {
      paramHttpURLConnection = new d((HttpsURLConnection)localHttpURLConnection);
    }
    do
    {
      return paramHttpURLConnection;
      paramHttpURLConnection = localHttpURLConnection;
    } while (localHttpURLConnection == null);
    return new c(localHttpURLConnection);
  }
  
  public static HttpURLConnection openWithProxy(HttpURLConnection paramHttpURLConnection)
  {
    Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMOkHttpInstrumentation", "OkHttpInstrumentation -wrapping return of call to openWithProxy" });
    HttpURLConnection localHttpURLConnection = processControllerDispatch(paramHttpURLConnection);
    if ((localHttpURLConnection instanceof HttpsURLConnection)) {
      paramHttpURLConnection = new d((HttpsURLConnection)localHttpURLConnection);
    }
    do
    {
      return paramHttpURLConnection;
      paramHttpURLConnection = localHttpURLConnection;
    } while (localHttpURLConnection == null);
    return new c(localHttpURLConnection);
  }
  
  private static HttpURLConnection processControllerDispatch(HttpURLConnection paramHttpURLConnection)
  {
    if (paramHttpURLConnection == null) {
      return paramHttpURLConnection;
    }
    paramHttpURLConnection.getURL().getHost();
    return paramHttpURLConnection;
  }
  
  public static HttpURLConnection urlFactoryOpen(HttpURLConnection paramHttpURLConnection)
  {
    Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMOkHttpInstrumentation", "OkHttpInstrumentation - wrapping return of call to OkUrlFactory.open..." });
    HttpURLConnection localHttpURLConnection = processControllerDispatch(paramHttpURLConnection);
    if ((localHttpURLConnection instanceof HttpsURLConnection)) {
      paramHttpURLConnection = new d((HttpsURLConnection)localHttpURLConnection);
    }
    do
    {
      return paramHttpURLConnection;
      paramHttpURLConnection = localHttpURLConnection;
    } while (localHttpURLConnection == null);
    return new c(localHttpURLConnection);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.QAPMOkHttpInstrumentation
 * JD-Core Version:    0.7.0.1
 */