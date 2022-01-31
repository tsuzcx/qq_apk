package com.tencent.mobileqq.microapp.appbrand.page;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.webkit.JavascriptInterface;
import bdje;
import com.tencent.mobileqq.microapp.apkg.f;
import com.tencent.mobileqq.microapp.apkg.r;
import com.tencent.mobileqq.microapp.apkg.t;
import com.tencent.mobileqq.microapp.appbrand.a;
import com.tencent.mobileqq.microapp.webview.BaseAppBrandWebview;
import com.tencent.qphone.base.util.QLog;

public class PageWebview
  extends BaseAppBrandWebview
{
  private static final String PREF_HTML_URL = "http://servicewechat.com/";
  private static final String TAG = PageWebview.class.getSimpleName() + "111";
  a appBrandRuntime;
  private byte[] contentBytes;
  WebViewEventListener eventListener;
  private boolean hasFLoad = false;
  private boolean hasLoadHtmlFinish;
  public boolean isShowShare = false;
  PageWebview.PageWebViewListener listener;
  Context mContext;
  private int mLastX;
  private int mLastY;
  String mRouteUrl;
  private String mWAWebviewStr;
  private String mWxssJs;
  public PageWebview.OnWebviewScrollListener onWebviewScrollListener;
  String openType;
  public int scrollY;
  public SwipeRefreshLayout swipeRefreshLayout;
  private String wxssJsStr;
  
  public PageWebview(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public PageWebview(Context paramContext, a parama, f paramf, String paramString1, String paramString2, PageWebview.PageWebViewListener paramPageWebViewListener, WebViewEventListener paramWebViewEventListener)
  {
    super(paramContext, paramf);
    this.appBrandRuntime = parama;
    this.mContext = paramContext;
    this.mRouteUrl = paramString1;
    this.openType = paramString2;
    this.listener = paramPageWebViewListener;
    this.eventListener = paramWebViewEventListener;
    init();
  }
  
  private void initEnableDebug()
  {
    if (this.apkgInfo.i())
    {
      evaluteJs(this.apkgInfo.h(), null);
      com.tencent.mobileqq.microapp.appbrand.utils.c.a(this.apkgInfo.d, true);
      return;
    }
    com.tencent.mobileqq.microapp.appbrand.utils.c.a(this.apkgInfo.d, false);
  }
  
  private void onWebViewReady(f paramf)
  {
    if (bdje.a(this.wxssJsStr))
    {
      String str = paramf.g(this.mRouteUrl);
      if (!TextUtils.isEmpty(str)) {
        evaluteJs(str);
      }
    }
    paramf = paramf.b(this.mRouteUrl);
    if (!TextUtils.isEmpty(paramf)) {
      evaluteJs(paramf);
    }
    if (this.listener != null) {
      this.listener.onWebViewReady(this.openType, this.mRouteUrl);
    }
  }
  
  public void clearUp()
  {
    removeJavascriptInterface("WeixinJSCore");
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    for (;;)
    {
      try
      {
        if (this.apkgInfo.b.d(this.mRouteUrl).a.d)
        {
          i = (int)paramMotionEvent.getX();
          j = (int)paramMotionEvent.getY();
          switch (paramMotionEvent.getAction())
          {
          case 0: 
            this.mLastX = i;
            this.mLastY = j;
          }
        }
      }
      catch (Exception localException)
      {
        int i;
        int j;
        int k;
        int m;
        continue;
      }
      return super.dispatchTouchEvent(paramMotionEvent);
      this.swipeRefreshLayout.setEnabled(true);
      continue;
      k = i - this.mLastX;
      m = j - this.mLastY;
      if ((Math.abs(m) > 0) && (Math.abs(k) > 0)) {
        if (Math.abs(m) > Math.abs(k))
        {
          this.swipeRefreshLayout.setEnabled(true);
        }
        else
        {
          this.swipeRefreshLayout.setEnabled(false);
          continue;
          this.swipeRefreshLayout.setEnabled(true);
        }
      }
    }
  }
  
  public void init()
  {
    addJavascriptInterface(this, "WeixinJSCore");
    setWebChromeClient(new PageWebview.1(this));
    setWebViewClient(new PageWebview.2(this));
  }
  
  @JavascriptInterface
  public String invokeHandler(String paramString1, String paramString2, int paramInt)
  {
    if (this.eventListener != null) {
      return this.eventListener.onWebViewNativeRequest(paramString1, paramString2, this, paramInt);
    }
    return "";
  }
  
  public void loadHtml()
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "---start loadHtml---");
    }
    loadUrl("http://servicewechat.com/page-frame.html");
  }
  
  public void loadPageWebviewJs(f paramf)
  {
    if (bdje.a(this.mRouteUrl)) {}
    while ((this.hasFLoad) || (!this.hasLoadHtmlFinish)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "----loadPageWebviewJs----");
    }
    onWebViewReady(paramf);
    this.hasFLoad = true;
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.onWebviewScrollListener != null) {
      this.onWebviewScrollListener.onVerticalScroll(paramInt2);
    }
    this.scrollY = paramInt2;
  }
  
  @JavascriptInterface
  public void publishHandler(String paramString1, String paramString2, String paramString3)
  {
    if (this.eventListener != null) {
      this.eventListener.onWebViewEvent(paramString1, paramString2, paramString3, this.apkgInfo.d, this.pageWebviewId);
    }
  }
  
  public void setOnWebviewScrollListener(PageWebview.OnWebviewScrollListener paramOnWebviewScrollListener)
  {
    this.onWebviewScrollListener = paramOnWebviewScrollListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.page.PageWebview
 * JD-Core Version:    0.7.0.1
 */