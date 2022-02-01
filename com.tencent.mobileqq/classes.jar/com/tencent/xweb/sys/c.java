package com.tencent.xweb.sys;

import android.os.Build.VERSION;
import org.xwalk.core.Log;

public class c
{
  public static android.webkit.WebResourceResponse a(com.tencent.xweb.WebResourceResponse paramWebResourceResponse)
  {
    if (paramWebResourceResponse == null) {
      return null;
    }
    if ((paramWebResourceResponse.a()) && (Build.VERSION.SDK_INT >= 21)) {
      try
      {
        android.webkit.WebResourceResponse localWebResourceResponse1 = new android.webkit.WebResourceResponse(paramWebResourceResponse.b(), paramWebResourceResponse.c(), paramWebResourceResponse.d(), paramWebResourceResponse.e(), paramWebResourceResponse.f(), paramWebResourceResponse.g());
        return localWebResourceResponse1;
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("create webkit WebResourceResponse error :");
        localStringBuilder.append(localException.getMessage());
        Log.e("SysWebDataTrans", localStringBuilder.toString());
      }
    }
    android.webkit.WebResourceResponse localWebResourceResponse2 = new android.webkit.WebResourceResponse(paramWebResourceResponse.b(), paramWebResourceResponse.c(), paramWebResourceResponse.g());
    if (Build.VERSION.SDK_INT >= 21)
    {
      if ((paramWebResourceResponse.d() > 100) && (paramWebResourceResponse.e() != null) && (!paramWebResourceResponse.e().isEmpty())) {
        localWebResourceResponse2.setStatusCodeAndReasonPhrase(paramWebResourceResponse.d(), paramWebResourceResponse.e());
      }
      localWebResourceResponse2.setResponseHeaders(paramWebResourceResponse.f());
    }
    return localWebResourceResponse2;
  }
  
  public static com.tencent.xweb.WebResourceResponse a(android.webkit.WebResourceResponse paramWebResourceResponse)
  {
    if (paramWebResourceResponse == null) {
      return null;
    }
    if (Build.VERSION.SDK_INT >= 21) {
      return new com.tencent.xweb.WebResourceResponse(paramWebResourceResponse.getMimeType(), paramWebResourceResponse.getEncoding(), paramWebResourceResponse.getStatusCode(), paramWebResourceResponse.getReasonPhrase(), paramWebResourceResponse.getResponseHeaders(), paramWebResourceResponse.getData());
    }
    return new com.tencent.xweb.WebResourceResponse(paramWebResourceResponse.getMimeType(), paramWebResourceResponse.getEncoding(), paramWebResourceResponse.getData());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.sys.c
 * JD-Core Version:    0.7.0.1
 */