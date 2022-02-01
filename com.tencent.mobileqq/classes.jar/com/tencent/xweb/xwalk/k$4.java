package com.tencent.xweb.xwalk;

import android.net.Uri;
import android.net.http.SslError;
import android.webkit.ValueCallback;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.u;
import com.tencent.xweb.y;
import java.util.Map;
import org.xwalk.core.ClientCertRequest;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkHttpAuthHandler;
import org.xwalk.core.XWalkUIClient.LoadStatus;
import org.xwalk.core.XWalkView;
import org.xwalk.core.XWalkWebResourceRequest;
import org.xwalk.core.XWalkWebResourceResponse;

class k$4
  extends o
{
  int a = 0;
  
  k$4(k paramk, XWalkView paramXWalkView)
  {
    super(paramXWalkView);
  }
  
  private String a(int paramInt, String paramString1, String paramString2)
  {
    paramString1 = new StringBuilder(2000);
    paramString1.append("<html>\n");
    paramString1.append("<head>\n");
    paramString1.append("<script type=\"text/javascript\">\n");
    paramString1.append("function jumurl(){\n");
    paramString1.append("　　window.location.href = '");
    paramString1.append(paramString2);
    paramString1.append("';\n");
    paramString1.append("}\n");
    paramString1.append("</script>\n");
    paramString1.append("<title>无法打开页面</title>\n");
    paramString1.append("<script >\n");
    paramString1.append("var html = document.documentElement,");
    paramString1.append("resizeEvt = 'orientationchange' in window ? 'orientationchange' : 'resize';");
    paramString1.append("function setHtmlFontSize() {");
    paramString1.append("var cliWidth = html.clientWidth;");
    paramString1.append("html.style.fontSize = 100 * (cliWidth / 720) + 'px';}");
    paramString1.append("window.addEventListener(resizeEvt, setHtmlFontSize, false);");
    paramString1.append("</script>\n");
    paramString1.append("<style>.exp{ text-align:center; margin-top:15rem; height=\"10rem\" width=\"10rem\"}</style>\n");
    paramString1.append("<style>.fcolorfortitle{ color: rgba(0, 0, 0, 0.3); font-size:44px;}</style>\n");
    paramString1.append("<style>.fcolorforsubtitle{ color: rgba(0, 0, 0, 0.3); font-size:34px;}</style>\n");
    paramString1.append("</head>\n");
    paramString1.append("<body bgcolor=\"#F2F2F2\" onclick=\"jumurl()\"'\">\n");
    paramString1.append("<br></br>");
    paramString1.append("<p></p>");
    paramString1.append("<div class=\"exp\" ><img src=\"html/img/webview_404_refresh_icon.svg\" text-align:center /><div>");
    paramString1.append("<br></br>");
    paramString1.append("<font size=\"44px\" class=\"fcolorfortitle\">无法打开页面</font>");
    paramString1.append("<br></br>");
    paramString1.append("<font size=\"44px\" class=\"fcolorforsubtitle\">轻触屏幕重新加载</font>");
    paramString1.append("</body>\n");
    paramString1.append("</html>");
    return paramString1.toString();
  }
  
  public void doUpdateVisitedHistory(XWalkView paramXWalkView, String paramString, boolean paramBoolean)
  {
    if ((paramString != null) && (paramString.startsWith("data:text/html;charset=utf-8"))) {
      return;
    }
    this.b.e.a(this.b.a, paramString, paramBoolean);
  }
  
  public void onDocumentLoadedInFrame(XWalkView paramXWalkView, long paramLong)
  {
    super.onDocumentLoadedInFrame(paramXWalkView, paramLong);
  }
  
  public void onLoadFinished(XWalkView paramXWalkView, String paramString)
  {
    super.onLoadFinished(paramXWalkView, paramString);
  }
  
  public void onLoadStarted(XWalkView paramXWalkView, String paramString)
  {
    this.b.e.e(this.b.a, paramString);
  }
  
  public void onProgressChanged(XWalkView paramXWalkView, int paramInt)
  {
    if ((Math.abs(paramInt - this.a) > 5) || (paramInt == 100))
    {
      this.a = paramInt;
      paramXWalkView = new StringBuilder();
      paramXWalkView.append("onProgressChanged, progress = ");
      paramXWalkView.append(paramInt);
      Log.i("XWWebView", paramXWalkView.toString());
    }
    this.b.f.b(this.b.a, paramInt);
  }
  
  public void onReceivedClientCertRequest(XWalkView paramXWalkView, ClientCertRequest paramClientCertRequest)
  {
    super.onReceivedClientCertRequest(paramXWalkView, paramClientCertRequest);
  }
  
  public void onReceivedHttpAuthRequest(XWalkView paramXWalkView, XWalkHttpAuthHandler paramXWalkHttpAuthHandler, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReceivedHttpAuthRequest host:");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", realm:");
    localStringBuilder.append(paramString2);
    Log.i("XWWebView", localStringBuilder.toString());
    if (this.b.e != null)
    {
      this.b.e.a(this.b.a, new g.j(paramXWalkHttpAuthHandler), paramString1, paramString2);
      return;
    }
    super.onReceivedHttpAuthRequest(paramXWalkView, paramXWalkHttpAuthHandler, paramString1, paramString2);
  }
  
  public void onReceivedHttpError(XWalkView paramXWalkView, XWalkWebResourceRequest paramXWalkWebResourceRequest, XWalkWebResourceResponse paramXWalkWebResourceResponse)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReceivedHttpError code:");
    localStringBuilder.append(paramXWalkWebResourceResponse.getStatusCode());
    Log.i("XWWebView", localStringBuilder.toString());
    this.b.e.a(this.b.a, new g.i(paramXWalkWebResourceRequest), g.a(paramXWalkWebResourceResponse));
    if (paramXWalkWebResourceRequest.isForMainFrame())
    {
      if (paramXWalkWebResourceRequest.getUrl() != null) {
        paramXWalkWebResourceRequest = paramXWalkWebResourceRequest.getUrl().toString();
      } else {
        paramXWalkWebResourceRequest = "";
      }
      if (this.b.m != null) {
        this.b.m.onPageLoadStopped(paramXWalkView, paramXWalkWebResourceRequest, XWalkUIClient.LoadStatus.FAILED);
      }
    }
  }
  
  public void onReceivedLoadError(XWalkView paramXWalkView, int paramInt, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReceivedError ");
    localStringBuilder.append(paramString2);
    Log.i("XWWebView", localStringBuilder.toString());
    super.onReceivedLoadError(paramXWalkView, paramInt, paramString1, paramString2);
    paramXWalkView = this.b;
    paramXWalkView.k = true;
    paramXWalkView.e.a(this.b.a, paramInt, paramString1, paramString2);
    com.tencent.xweb.internal.h.a().c();
    com.tencent.xweb.util.h.a(paramString2, paramInt, System.currentTimeMillis() - this.b.i, k.c(this.b));
    if (this.b.e.b(this.b.a, paramInt, paramString1, paramString2)) {
      return;
    }
    paramXWalkView = a(paramInt, paramString1, paramString2);
    this.b.c.loadDataWithBaseURL("file:///android_asset/", paramXWalkView, "text/html", "utf-8", null);
  }
  
  public void onReceivedResponseHeaders(XWalkView paramXWalkView, XWalkWebResourceRequest paramXWalkWebResourceRequest, XWalkWebResourceResponse paramXWalkWebResourceResponse)
  {
    Object localObject;
    if (paramXWalkWebResourceResponse.getStatusCode() == 302)
    {
      String str = (String)paramXWalkWebResourceResponse.getResponseHeaders().get("location");
      if (str != null)
      {
        localObject = str;
        if (!str.isEmpty()) {}
      }
      else
      {
        localObject = (String)paramXWalkWebResourceResponse.getResponseHeaders().get("Location");
      }
      if ((localObject != null) && (((String)localObject).trim().startsWith("weixin://")))
      {
        this.b.e.a(this.b.a, (String)localObject, null);
        this.b.c.postDelayed(new k.4.1(this, (String)localObject), 300L);
      }
    }
    else if ((paramXWalkWebResourceResponse.getStatusCode() >= 400) && (!this.b.supportFeature(3)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onReceivedHttpError code:");
      ((StringBuilder)localObject).append(paramXWalkWebResourceResponse.getStatusCode());
      Log.i("XWWebView", ((StringBuilder)localObject).toString());
      this.b.e.a(this.b.a, new g.i(paramXWalkWebResourceRequest), g.a(paramXWalkWebResourceResponse));
      if (paramXWalkWebResourceRequest.getUrl() != null) {
        localObject = paramXWalkWebResourceRequest.getUrl().toString();
      } else {
        localObject = "";
      }
      this.b.e.a(this.b.a, paramXWalkWebResourceResponse.getStatusCode(), "", (String)localObject);
    }
    super.onReceivedResponseHeaders(paramXWalkView, paramXWalkWebResourceRequest, paramXWalkWebResourceResponse);
  }
  
  public void onReceivedSslError(XWalkView paramXWalkView, ValueCallback<Boolean> paramValueCallback, SslError paramSslError)
  {
    paramXWalkView = new StringBuilder();
    paramXWalkView.append("onReceivedSslError ");
    paramXWalkView.append(paramSslError.getPrimaryError());
    Log.i("XWWebView", paramXWalkView.toString());
    this.b.e.a(this.b.a, new g.h(paramValueCallback), paramSslError);
  }
  
  public XWalkWebResourceResponse shouldInterceptLoadRequest(XWalkView paramXWalkView, XWalkWebResourceRequest paramXWalkWebResourceRequest)
  {
    g.i locali = new g.i(paramXWalkWebResourceRequest);
    paramXWalkView = locali.e();
    if (paramXWalkView != null) {
      localObject = this.b.e.a(this.b.a, locali, paramXWalkView);
    } else {
      localObject = null;
    }
    paramXWalkView = (XWalkView)localObject;
    if (localObject == null) {
      paramXWalkView = this.b.e.b(this.b.a, locali);
    }
    Object localObject = paramXWalkView;
    if (paramXWalkView == null) {
      localObject = this.b.e.a(this.b.a, paramXWalkWebResourceRequest.getUrl().toString());
    }
    if (localObject != null) {
      return createXWalkWebResourceResponse(((WebResourceResponse)localObject).b(), ((WebResourceResponse)localObject).c(), ((WebResourceResponse)localObject).g(), ((WebResourceResponse)localObject).d(), ((WebResourceResponse)localObject).e(), ((WebResourceResponse)localObject).f());
    }
    return null;
  }
  
  public boolean shouldOverrideUrlLoading(XWalkView paramXWalkView, String paramString)
  {
    if (d.b(paramString)) {
      return true;
    }
    boolean bool = this.b.e.b(this.b.a, paramString);
    paramXWalkView = new StringBuilder();
    paramXWalkView.append("shouldOverrideUrlLoading ret =  ");
    paramXWalkView.append(bool);
    paramXWalkView.append(" url = ");
    paramXWalkView.append(paramString);
    Log.i("XWWebView", paramXWalkView.toString());
    return bool;
  }
  
  public boolean shouldOverrideUrlLoading(XWalkView paramXWalkView, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (d.b(paramString)) {
      return true;
    }
    paramXWalkView = new g.i(paramString, "GET", paramBoolean1, paramBoolean2, paramBoolean3);
    return this.b.e.a(this.b.a, paramXWalkView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.k.4
 * JD-Core Version:    0.7.0.1
 */