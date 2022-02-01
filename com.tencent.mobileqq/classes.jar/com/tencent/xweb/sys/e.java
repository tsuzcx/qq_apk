package com.tencent.xweb.sys;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebView.FindListener;
import android.webkit.WebView.HitTestResult;
import android.webkit.WebViewClient;
import com.tencent.xweb.JsRuntime;
import com.tencent.xweb.WebView.a;
import com.tencent.xweb.WebView.b;
import com.tencent.xweb.aa;
import com.tencent.xweb.extension.video.b;
import com.tencent.xweb.extension.video.f;
import com.tencent.xweb.internal.IWebView;
import com.tencent.xweb.internal.IWebView.a;
import com.tencent.xweb.internal.IWebViewDatabase;
import com.tencent.xweb.r;
import com.tencent.xweb.s;
import com.tencent.xweb.u;
import com.tencent.xweb.w;
import com.tencent.xweb.x;
import com.tencent.xweb.y;
import com.tencent.xweb.z;
import java.util.Map;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public class e
  implements IWebView
{
  com.tencent.xweb.WebView a;
  e.a b;
  y c;
  u d;
  d e;
  g f;
  long g = 0L;
  e.b h;
  final String i = "xwalkTempCallBack";
  private b j;
  private boolean k = false;
  private WebChromeClient l = new e.2(this);
  private WebViewClient m = new e.3(this);
  
  public e(com.tencent.xweb.WebView paramWebView)
  {
    this.a = paramWebView;
    this.b = new e.a(this, paramWebView.getContext());
    this.b.setBackgroundColor(0);
    getSettings();
    this.e = new d(this.b);
    this.b.setWebChromeClient(this.l);
    this.b.setWebViewClient(this.m);
    this.e.a(this.m);
    this.e.a(this.l);
    if (Build.VERSION.SDK_INT < 19)
    {
      this.h = new e.b();
      this.b.addJavascriptInterface(this.h, "xwalkTempCallBack");
    }
    if ((paramWebView.getContext() instanceof Activity))
    {
      a((Activity)paramWebView.getContext());
      return;
    }
    a(null);
  }
  
  private void a(Activity paramActivity)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initFullscreenVideo:");
    localStringBuilder.append(getFullscreenVideoKind());
    localStringBuilder.append(",activity:");
    localStringBuilder.append(paramActivity);
    Log.i("SysWebView", localStringBuilder.toString());
    if (getFullscreenVideoKind() == WebView.a.a) {
      return;
    }
    this.j = f.a(paramActivity, this.a, this.b, com.tencent.xweb.extension.video.e.b());
    if (getFullscreenVideoKind() == WebView.a.c) {
      this.j.a(this.b);
    }
  }
  
  @SuppressLint({"JavascriptInterface"})
  public void addJavascriptInterface(Object paramObject, String paramString)
  {
    this.b.addJavascriptInterface(paramObject, paramString);
  }
  
  public boolean canGoBack()
  {
    return this.b.canGoBack();
  }
  
  public boolean canGoForward()
  {
    return this.b.canGoForward();
  }
  
  public Bitmap captureBitmap()
  {
    int n = this.b.getHeight();
    Bitmap localBitmap = Bitmap.createBitmap(this.b.getWidth(), n, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    this.b.draw(localCanvas);
    return localBitmap;
  }
  
  public void captureBitmap(IWebView.a parama)
  {
    new Thread(new e.4(this, parama)).start();
  }
  
  public void clearHistory()
  {
    this.b.clearHistory();
  }
  
  public void clearMatches()
  {
    this.b.clearMatches();
  }
  
  public void clearSslPreferences()
  {
    this.b.clearSslPreferences();
  }
  
  public void clearView()
  {
    this.b.clearView();
  }
  
  public WebBackForwardList copyBackForwardList()
  {
    return this.b.copyBackForwardList();
  }
  
  public void destroy()
  {
    this.b.destroy();
  }
  
  public void disableVideoJsCallback(boolean paramBoolean)
  {
    b localb = this.j;
    if (localb != null) {
      localb.a(paramBoolean);
    }
  }
  
  public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    if (paramString == null) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 19)
    {
      this.b.evaluateJavascript(paramString, paramValueCallback);
      return;
    }
    if (paramValueCallback == null)
    {
      this.b.loadUrl(paramString);
      return;
    }
    String str = paramString;
    if (paramString.trim().startsWith("javascript:")) {
      str = paramString.replaceFirst("javascript:", "");
    }
    if (this.h == null)
    {
      this.h = new e.b();
      this.b.addJavascriptInterface(this.h, "xwalkTempCallBack");
    }
    paramString = this.h.a(paramValueCallback);
    paramValueCallback = new StringBuilder();
    paramValueCallback.append("javascript:xwalkTempCallBack.notifyJava(");
    paramValueCallback.append(paramString);
    paramValueCallback.append(", ");
    paramValueCallback.append(str);
    paramValueCallback.append(")");
    paramString = paramValueCallback.toString();
    this.b.loadUrl(paramString);
  }
  
  public void findAllAsync(String paramString)
  {
    this.b.findAllAsync(paramString);
  }
  
  public void findNext(boolean paramBoolean)
  {
    this.b.findNext(paramBoolean);
  }
  
  public String getAbstractInfo()
  {
    return getVersionInfo();
  }
  
  public int getContentHeight()
  {
    return this.b.getContentHeight();
  }
  
  public u getCurWebChromeClient()
  {
    return this.d;
  }
  
  public y getCurWebviewClient()
  {
    return this.c;
  }
  
  public com.tencent.xweb.internal.e getDefalutOpProvider()
  {
    return this.e;
  }
  
  public WebView.a getFullscreenVideoKind()
  {
    return com.tencent.xweb.a.d(com.tencent.xweb.WebView.getCurStrModule());
  }
  
  public WebView.b getHitTestResult()
  {
    WebView.HitTestResult localHitTestResult = this.b.getHitTestResult();
    WebView.b localb = new WebView.b();
    localb.a(localHitTestResult.getType());
    localb.a(localHitTestResult.getExtra());
    return localb;
  }
  
  public String[] getHttpAuthUsernamePassword(String paramString1, String paramString2)
  {
    return z.a().a(paramString1, paramString2);
  }
  
  public boolean getImageBitmapToFile(String paramString1, String paramString2, String paramString3, com.tencent.xweb.g paramg)
  {
    return false;
  }
  
  public float getScale()
  {
    return this.b.getScale();
  }
  
  public int getScrollHeight()
  {
    return this.b.a();
  }
  
  public w getSettings()
  {
    Object localObject = this.f;
    if (localObject != null) {
      return localObject;
    }
    localObject = this.b;
    if (localObject == null) {
      return null;
    }
    this.f = new g((android.webkit.WebView)localObject);
    return this.f;
  }
  
  public String getTitle()
  {
    return this.b.getTitle();
  }
  
  public ViewGroup getTopView()
  {
    return this.b;
  }
  
  public String getUrl()
  {
    return this.b.getUrl();
  }
  
  public String getVersionInfo()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("webviewtype = WV_KIND_SYS, version = ");
    localStringBuilder.append(XWalkEnvironment.getChromiunVersion());
    localStringBuilder.append(", V8 type=");
    localStringBuilder.append(JsRuntime.b());
    return localStringBuilder.toString();
  }
  
  public View getView()
  {
    return this.b;
  }
  
  public int getVisibleTitleHeight()
  {
    Object localObject = com.tencent.xweb.util.g.a(this.b, "getVisibleTitleHeight");
    if (localObject == null) {
      return 0;
    }
    return ((Integer)localObject).intValue();
  }
  
  public int getWebScrollX()
  {
    return getWebViewUI().getScrollX();
  }
  
  public int getWebScrollY()
  {
    return this.b.getScrollY();
  }
  
  public View getWebViewUI()
  {
    return this.b;
  }
  
  public Object getX5WebViewExtension()
  {
    return null;
  }
  
  public void goBack()
  {
    this.b.goBack();
  }
  
  public void goForward()
  {
    this.b.goForward();
  }
  
  public boolean hasEnteredFullscreen()
  {
    return this.k;
  }
  
  public Bundle invokeMiscMethod(String paramString, Bundle paramBundle)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      if (paramString.equals("supportTranslateWebSite"))
      {
        paramString = new Bundle();
        paramString.putBoolean("result", false);
        Log.i("SysWebView", "sys web is not supportTranslateWebSite");
        return paramString;
      }
      return null;
    }
    Log.d("SysWebView", " method string is null or empty");
    return null;
  }
  
  public boolean isOverScrollStart()
  {
    return getWebViewUI().getScrollY() == 0;
  }
  
  public boolean isSupportExtendPluginForAppbrand()
  {
    return false;
  }
  
  public void leaveFullscreen()
  {
    WebChromeClient localWebChromeClient = this.l;
    if (localWebChromeClient != null) {
      localWebChromeClient.onHideCustomView();
    }
  }
  
  public void loadData(String paramString1, String paramString2, String paramString3)
  {
    this.b.loadData(paramString1, paramString2, paramString3);
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.b.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
  }
  
  public void loadUrl(String paramString)
  {
    this.b.loadUrl(paramString);
  }
  
  public void loadUrl(String paramString, Map<String, String> paramMap)
  {
    this.b.loadUrl(paramString, paramMap);
  }
  
  public void onHide()
  {
    this.b.onPause();
  }
  
  public void onPause()
  {
    this.b.onPause();
  }
  
  public void onResume()
  {
    this.b.onResume();
  }
  
  public void onShow()
  {
    this.b.onPause();
  }
  
  public boolean overlayHorizontalScrollbar()
  {
    return this.b.overlayHorizontalScrollbar();
  }
  
  public void reload()
  {
    this.b.reload();
  }
  
  public void removeJavascriptInterface(String paramString)
  {
    this.b.removeJavascriptInterface(paramString);
  }
  
  public boolean savePage(String paramString1, String paramString2, int paramInt)
  {
    return false;
  }
  
  public void setBottomHeight(int paramInt)
  {
    Log.e("SysWebView", "setBottomHeight not implement");
  }
  
  public void setDownloadListener(DownloadListener paramDownloadListener)
  {
    this.b.setDownloadListener(paramDownloadListener);
  }
  
  public void setFindListener(WebView.FindListener paramFindListener)
  {
    this.b.setFindListener(paramFindListener);
  }
  
  public void setHorizontalScrollBarEnabled(boolean paramBoolean)
  {
    this.b.setHorizontalScrollBarEnabled(paramBoolean);
  }
  
  public void setHttpAuthUsernamePassword(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    z.a().a(paramString1, paramString2, paramString3, paramString4);
  }
  
  public void setJSExceptionListener(aa paramaa) {}
  
  public void setVerticalScrollBarEnabled(boolean paramBoolean)
  {
    this.b.setVerticalScrollBarEnabled(paramBoolean);
  }
  
  public r setVideoJsCallback(s params)
  {
    if (this.j.b(params)) {
      return new e.1(this);
    }
    Log.i("SysWebView", "setVideoJsCallback not support");
    return null;
  }
  
  public void setWebChromeClient(u paramu)
  {
    this.d = paramu;
  }
  
  public void setWebViewCallbackClient(x paramx)
  {
    e.a locala = this.b;
    if (locala != null) {
      locala.a = paramx;
    }
  }
  
  public void setWebViewClient(y paramy)
  {
    this.c = paramy;
  }
  
  public void setWebViewClientExtension(com.tencent.xweb.x5.export.external.extension.proxy.a parama) {}
  
  public void smoothScroll(int paramInt1, int paramInt2, long paramLong) {}
  
  public void stopLoading()
  {
    this.b.stopLoading();
  }
  
  public void super_computeScroll() {}
  
  public boolean super_dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean super_onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void super_onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void super_onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public boolean super_onTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean super_overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    return false;
  }
  
  public boolean supportFeature(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt == 2006)
    {
      bool1 = bool2;
      if (Build.VERSION.SDK_INT >= 23) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean zoomIn()
  {
    return this.b.zoomIn();
  }
  
  public boolean zoomOut()
  {
    return this.b.zoomOut();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.sys.e
 * JD-Core Version:    0.7.0.1
 */