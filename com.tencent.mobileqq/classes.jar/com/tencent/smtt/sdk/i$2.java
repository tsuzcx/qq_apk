package com.tencent.smtt.sdk;

import android.net.Uri;
import android.webkit.WebResourceRequest;

class i$2
  extends android.webkit.ServiceWorkerClient
{
  i$2(i parami, com.tencent.smtt.export.external.interfaces.ServiceWorkerClient paramServiceWorkerClient) {}
  
  public android.webkit.WebResourceResponse shouldInterceptRequest(WebResourceRequest paramWebResourceRequest)
  {
    paramWebResourceRequest = new SystemWebViewClient.e(paramWebResourceRequest.getUrl().toString(), paramWebResourceRequest.isForMainFrame(), paramWebResourceRequest.isRedirect(), paramWebResourceRequest.hasGesture(), paramWebResourceRequest.getMethod(), paramWebResourceRequest.getRequestHeaders());
    paramWebResourceRequest = this.a.shouldInterceptRequest(paramWebResourceRequest);
    if (paramWebResourceRequest == null) {
      paramWebResourceRequest = null;
    }
    android.webkit.WebResourceResponse localWebResourceResponse;
    int i;
    String str;
    do
    {
      do
      {
        return paramWebResourceRequest;
        localWebResourceResponse = new android.webkit.WebResourceResponse(paramWebResourceRequest.getMimeType(), paramWebResourceRequest.getEncoding(), paramWebResourceRequest.getData());
        localWebResourceResponse.setResponseHeaders(paramWebResourceRequest.getResponseHeaders());
        i = paramWebResourceRequest.getStatusCode();
        str = paramWebResourceRequest.getReasonPhrase();
        if (i != localWebResourceResponse.getStatusCode()) {
          break;
        }
        paramWebResourceRequest = localWebResourceResponse;
      } while (str == null);
      paramWebResourceRequest = localWebResourceResponse;
    } while (str.equals(localWebResourceResponse.getReasonPhrase()));
    localWebResourceResponse.setStatusCodeAndReasonPhrase(i, str);
    return localWebResourceResponse;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.i.2
 * JD-Core Version:    0.7.0.1
 */