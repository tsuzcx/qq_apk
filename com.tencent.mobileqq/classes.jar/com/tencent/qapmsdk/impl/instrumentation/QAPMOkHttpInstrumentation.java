package com.tencent.qapmsdk.impl.instrumentation;

import com.tencent.qapmsdk.common.logger.Logger;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class QAPMOkHttpInstrumentation
{
  private static final String TAG = "QAPM_Impl_QAPMOkHttpInstrumentation";
  
  @QAPMWrapReturn
  public static HttpURLConnection open(HttpURLConnection paramHttpURLConnection)
  {
    Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMOkHttpInstrumentation", "OkHttpInstrumentation - wrapping return of call to open" });
    HttpURLConnection localHttpURLConnection = processControllerDispatch(paramHttpURLConnection);
    if ((localHttpURLConnection instanceof HttpsURLConnection)) {
      return new e((HttpsURLConnection)localHttpURLConnection);
    }
    paramHttpURLConnection = localHttpURLConnection;
    if (localHttpURLConnection != null) {
      paramHttpURLConnection = new d(localHttpURLConnection);
    }
    return paramHttpURLConnection;
  }
  
  @QAPMWrapReturn
  public static HttpURLConnection openWithProxy(HttpURLConnection paramHttpURLConnection)
  {
    Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMOkHttpInstrumentation", "OkHttpInstrumentation -wrapping return of call to openWithProxy" });
    HttpURLConnection localHttpURLConnection = processControllerDispatch(paramHttpURLConnection);
    if ((localHttpURLConnection instanceof HttpsURLConnection)) {
      return new e((HttpsURLConnection)localHttpURLConnection);
    }
    paramHttpURLConnection = localHttpURLConnection;
    if (localHttpURLConnection != null) {
      paramHttpURLConnection = new d(localHttpURLConnection);
    }
    return paramHttpURLConnection;
  }
  
  private static HttpURLConnection processControllerDispatch(HttpURLConnection paramHttpURLConnection)
  {
    if (paramHttpURLConnection == null) {
      return paramHttpURLConnection;
    }
    paramHttpURLConnection.getURL().getHost();
    return paramHttpURLConnection;
  }
  
  @QAPMWrapReturn
  public static HttpURLConnection urlFactoryOpen(HttpURLConnection paramHttpURLConnection)
  {
    Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMOkHttpInstrumentation", "OkHttpInstrumentation - wrapping return of call to OkUrlFactory.open..." });
    HttpURLConnection localHttpURLConnection = processControllerDispatch(paramHttpURLConnection);
    if ((localHttpURLConnection instanceof HttpsURLConnection)) {
      return new e((HttpsURLConnection)localHttpURLConnection);
    }
    paramHttpURLConnection = localHttpURLConnection;
    if (localHttpURLConnection != null) {
      paramHttpURLConnection = new d(localHttpURLConnection);
    }
    return paramHttpURLConnection;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.QAPMOkHttpInstrumentation
 * JD-Core Version:    0.7.0.1
 */