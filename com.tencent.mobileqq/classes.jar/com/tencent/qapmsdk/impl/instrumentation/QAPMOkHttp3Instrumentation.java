package com.tencent.qapmsdk.impl.instrumentation;

import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.impl.c.c;
import com.tencent.qapmsdk.impl.g.b;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.OkUrlFactory;
import okhttp3.Request;

public class QAPMOkHttp3Instrumentation
{
  private static final String TAG = "QAPM_Impl_QAPMOkHttp3Instrumentation";
  
  public static OkHttpClient.Builder builderInit()
  {
    return new OkHttpClient.Builder().addInterceptor(new com.tencent.qapmsdk.impl.c.d());
  }
  
  public static OkHttpClient init()
  {
    return new OkHttpClient.Builder().addInterceptor(new com.tencent.qapmsdk.impl.c.d()).build();
  }
  
  @QAPMReplaceCallSite
  public static Call newCall(OkHttpClient paramOkHttpClient, Request paramRequest)
  {
    return new c(paramOkHttpClient, paramRequest);
  }
  
  @QAPMReplaceCallSite
  public static HttpURLConnection open(OkUrlFactory paramOkUrlFactory, URL paramURL)
  {
    try
    {
      paramURL.getHost();
    }
    catch (Exception localException)
    {
      Logger.INSTANCE.exception("QAPM_Impl_QAPMOkHttp3Instrumentation", "QAPMOkHttp3Instrumentation open has an error :", localException);
    }
    paramURL = paramOkUrlFactory.open(paramURL);
    if (paramURL == null) {
      return null;
    }
    if (!b.c()) {
      return paramURL;
    }
    Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMOkHttp3Instrumentation", "okhttp3  open gather  begin !!" });
    if ((paramURL instanceof HttpsURLConnection)) {
      return new e((HttpsURLConnection)paramURL);
    }
    paramOkUrlFactory = paramURL;
    if ((paramURL instanceof HttpURLConnection)) {
      paramOkUrlFactory = new d(paramURL);
    }
    return paramOkUrlFactory;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.QAPMOkHttp3Instrumentation
 * JD-Core Version:    0.7.0.1
 */