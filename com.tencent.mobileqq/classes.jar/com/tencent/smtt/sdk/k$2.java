package com.tencent.smtt.sdk;

import android.net.Uri;
import android.webkit.WebResourceRequest;

class k$2
  extends android.webkit.ServiceWorkerClient
{
  k$2(k paramk, com.tencent.smtt.export.external.interfaces.ServiceWorkerClient paramServiceWorkerClient) {}
  
  public android.webkit.WebResourceResponse shouldInterceptRequest(WebResourceRequest paramWebResourceRequest)
  {
    paramWebResourceRequest = new SystemWebViewClient.e(paramWebResourceRequest.getUrl().toString(), paramWebResourceRequest.isForMainFrame(), paramWebResourceRequest.isRedirect(), paramWebResourceRequest.hasGesture(), paramWebResourceRequest.getMethod(), paramWebResourceRequest.getRequestHeaders());
    Object localObject = this.a.shouldInterceptRequest(paramWebResourceRequest);
    if (localObject == null) {
      return null;
    }
    paramWebResourceRequest = new android.webkit.WebResourceResponse(((com.tencent.smtt.export.external.interfaces.WebResourceResponse)localObject).getMimeType(), ((com.tencent.smtt.export.external.interfaces.WebResourceResponse)localObject).getEncoding(), ((com.tencent.smtt.export.external.interfaces.WebResourceResponse)localObject).getData());
    paramWebResourceRequest.setResponseHeaders(((com.tencent.smtt.export.external.interfaces.WebResourceResponse)localObject).getResponseHeaders());
    int i = ((com.tencent.smtt.export.external.interfaces.WebResourceResponse)localObject).getStatusCode();
    localObject = ((com.tencent.smtt.export.external.interfaces.WebResourceResponse)localObject).getReasonPhrase();
    if ((i != paramWebResourceRequest.getStatusCode()) || ((localObject != null) && (!((String)localObject).equals(paramWebResourceRequest.getReasonPhrase())))) {
      paramWebResourceRequest.setStatusCodeAndReasonPhrase(i, (String)localObject);
    }
    return paramWebResourceRequest;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.sdk.k.2
 * JD-Core Version:    0.7.0.1
 */