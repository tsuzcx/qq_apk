package com.tencent.qapmsdk.impl.instrumentation.okhttp2;

import android.text.TextUtils;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.OkUrlFactory;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.Response.Builder;
import com.squareup.okhttp.ResponseBody;
import com.squareup.okhttp.internal.Version;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.impl.instrumentation.QAPMReplaceCallSite;
import com.tencent.qapmsdk.impl.instrumentation.d;
import com.tencent.qapmsdk.impl.instrumentation.e;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class QAPMOkHttp2Instrumentation
{
  private static final String TAG = "QAPM_Impl_QAPMOkHttp2Instrumentation";
  
  @QAPMReplaceCallSite
  public static Response.Builder body(Response.Builder paramBuilder, ResponseBody paramResponseBody)
  {
    if (isSpecificOkhttp()) {
      return paramBuilder.body(paramResponseBody);
    }
    return new g(paramBuilder).body(paramResponseBody);
  }
  
  @QAPMReplaceCallSite
  public static Request build(Request.Builder paramBuilder)
  {
    return new f(paramBuilder).build();
  }
  
  public static boolean isSpecificOkhttp()
  {
    boolean bool2 = true;
    try
    {
      Object localObject = Version.userAgent();
      boolean bool1 = bool2;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("/");
        if (localObject == null) {
          return true;
        }
        bool1 = bool2;
        if (!localObject[1].startsWith("2.4.")) {
          bool1 = false;
        }
      }
      return bool1;
    }
    catch (Throwable localThrowable) {}
    return true;
  }
  
  @QAPMReplaceCallSite
  public static Response.Builder newBuilder(Response.Builder paramBuilder)
  {
    if (isSpecificOkhttp()) {
      return paramBuilder;
    }
    return new g(paramBuilder);
  }
  
  @QAPMReplaceCallSite
  public static Call newCall(OkHttpClient paramOkHttpClient, Request paramRequest)
  {
    Logger.INSTANCE.d(new String[] { "QAPM_Impl_QAPMOkHttp2Instrumentation", "OkHttpInstrumentation2 - wrapping newCall" });
    if (isSpecificOkhttp()) {
      return paramOkHttpClient.newCall(paramRequest);
    }
    return new a(paramOkHttpClient, paramRequest);
  }
  
  @QAPMReplaceCallSite
  public static HttpURLConnection open(OkUrlFactory paramOkUrlFactory, URL paramURL)
  {
    paramURL = paramOkUrlFactory.open(paramURL);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.okhttp2.QAPMOkHttp2Instrumentation
 * JD-Core Version:    0.7.0.1
 */