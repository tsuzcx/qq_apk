package com.tencent.mobileqq.microapp.appbrand.page;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.webkit.JavascriptInterface;
import com.tencent.mobileqq.microapp.apkg.j;
import com.tencent.mobileqq.microapp.apkg.l;
import com.tencent.mobileqq.microapp.appbrand.a;
import com.tencent.mobileqq.microapp.webview.BaseAppBrandWebview;
import com.tencent.mobileqq.microapp.widget.g;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;

public class PageWebview
  extends BaseAppBrandWebview
{
  private static final String PREF_HTML_URL = "https://servicewechat.com/";
  private static final String TAG;
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
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(PageWebview.class.getSimpleName());
    localStringBuilder.append("111");
    TAG = localStringBuilder.toString();
  }
  
  public PageWebview(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public PageWebview(Context paramContext, a parama, com.tencent.mobileqq.microapp.a.c paramc, String paramString1, String paramString2, PageWebview.PageWebViewListener paramPageWebViewListener, WebViewEventListener paramWebViewEventListener)
  {
    super(paramContext, paramc);
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
    if (this.apkgInfo$5475ea27.h())
    {
      evaluteJs(this.apkgInfo$5475ea27.g(), null);
      com.tencent.mobileqq.microapp.appbrand.b.c.a(this.apkgInfo$5475ea27.d, true);
      return;
    }
    com.tencent.mobileqq.microapp.appbrand.b.c.a(this.apkgInfo$5475ea27.d, false);
  }
  
  private void onWebViewReady$164d4c8c(com.tencent.mobileqq.microapp.a.c paramc)
  {
    if (StringUtil.a(this.wxssJsStr))
    {
      String str = paramc.g(this.mRouteUrl);
      if (!TextUtils.isEmpty(str)) {
        evaluteJs(str);
      }
    }
    paramc = paramc.b(this.mRouteUrl);
    if (!TextUtils.isEmpty(paramc)) {
      evaluteJs(paramc);
    }
    paramc = this.listener;
    if (paramc != null) {
      paramc.onWebViewReady(this.openType, this.mRouteUrl);
    }
  }
  
  public void clearUp()
  {
    removeJavascriptInterface("WeixinJSCore");
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      if (this.apkgInfo$5475ea27.b.b(this.mRouteUrl).a.b)
      {
        int i = (int)paramMotionEvent.getX();
        int j = (int)paramMotionEvent.getY();
        int k = paramMotionEvent.getAction();
        if (k != 0)
        {
          if (k != 1) {
            if (k != 2)
            {
              if (k != 3) {
                break label153;
              }
            }
            else
            {
              k = i - this.mLastX;
              int m = j - this.mLastY;
              if ((Math.abs(m) <= 0) || (Math.abs(k) <= 0)) {
                break label153;
              }
              if (Math.abs(m) > Math.abs(k))
              {
                this.swipeRefreshLayout.setEnabled(true);
                break label153;
              }
              this.swipeRefreshLayout.setEnabled(false);
              break label153;
            }
          }
          this.swipeRefreshLayout.setEnabled(true);
        }
        else
        {
          this.swipeRefreshLayout.setEnabled(true);
        }
        label153:
        this.mLastX = i;
        this.mLastY = j;
      }
    }
    catch (Exception localException)
    {
      label163:
      break label163;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
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
    WebViewEventListener localWebViewEventListener = this.eventListener;
    if (localWebViewEventListener != null) {
      return localWebViewEventListener.onWebViewNativeRequest(paramString1, paramString2, this, paramInt);
    }
    return "";
  }
  
  public void loadHtml()
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "---start loadHtml---");
    }
    loadUrl("https://servicewechat.com/page-frame.html");
  }
  
  public void loadPageWebviewJs$164d4c8c(com.tencent.mobileqq.microapp.a.c paramc)
  {
    if (StringUtil.a(this.mRouteUrl)) {
      return;
    }
    if (!this.hasFLoad)
    {
      if (!this.hasLoadHtmlFinish) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "----loadPageWebviewJs----");
      }
      onWebViewReady$164d4c8c(paramc);
      this.hasFLoad = true;
    }
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    PageWebview.OnWebviewScrollListener localOnWebviewScrollListener = this.onWebviewScrollListener;
    if (localOnWebviewScrollListener != null) {
      localOnWebviewScrollListener.onVerticalScroll(paramInt2);
    }
    this.scrollY = paramInt2;
  }
  
  @JavascriptInterface
  public void publishHandler(String paramString1, String paramString2, String paramString3)
  {
    WebViewEventListener localWebViewEventListener = this.eventListener;
    if (localWebViewEventListener != null) {
      localWebViewEventListener.onWebViewEvent(paramString1, paramString2, paramString3, this.apkgInfo$5475ea27.d, this.pageWebviewId);
    }
  }
  
  public void setOnWebviewScrollListener(PageWebview.OnWebviewScrollListener paramOnWebviewScrollListener)
  {
    this.onWebviewScrollListener = paramOnWebviewScrollListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.page.PageWebview
 * JD-Core Version:    0.7.0.1
 */