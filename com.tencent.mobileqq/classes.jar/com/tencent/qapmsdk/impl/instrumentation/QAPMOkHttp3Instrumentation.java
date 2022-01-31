package com.tencent.qapmsdk.impl.instrumentation;

import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.impl.httpOprate.QAPMHTTPInterceptor;
import com.tencent.qapmsdk.impl.httpOprate.QAPMHttpCall;
import com.tencent.qapmsdk.impl.util.TraceUtil;
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
    return new OkHttpClient.Builder().addInterceptor(new QAPMHTTPInterceptor());
  }
  
  public static OkHttpClient init()
  {
    return new OkHttpClient.Builder().addInterceptor(new QAPMHTTPInterceptor()).build();
  }
  
  @QAPMReplaceCallSite
  public static Call newCall(OkHttpClient paramOkHttpClient, Request paramRequest)
  {
    return new QAPMHttpCall(paramOkHttpClient, paramRequest);
  }
  
  @QAPMReplaceCallSite
  public static HttpURLConnection open(OkUrlFactory paramOkUrlFactory, URL paramURL)
  {
    try
    {
      paramURL.getHost();
      paramURL = paramOkUrlFactory.open(paramURL);
      if (paramURL == null)
      {
        paramOkUrlFactory = null;
        return paramOkUrlFactory;
      }
    }
    catch (Exception localException)
    {
      do
      {
        do
        {
          for (;;)
          {
            Logger.INSTANCE.exception("QAPM_Impl_QAPMOkHttp3Instrumentation", "QAPMOkHttp3Instrumentation open has an error :", localException);
          }
          paramOkUrlFactory = paramURL;
        } while (!TraceUtil.getCanMonitorHttp());
        Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMOkHttp3Instrumentation", "okhttp3  open gather  begin !!" });
        if ((paramURL instanceof HttpsURLConnection)) {
          return new QAPMHttpsURLConnectionExtension((HttpsURLConnection)paramURL);
        }
        paramOkUrlFactory = paramURL;
      } while (!(paramURL instanceof HttpURLConnection));
    }
    return new QAPMHttpURLConnectionExtension(paramURL);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.QAPMOkHttp3Instrumentation
 * JD-Core Version:    0.7.0.1
 */