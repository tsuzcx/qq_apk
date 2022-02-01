package com.tencent.mobileqq.microapp.appbrand.page;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.microapp.a.c;
import com.tencent.mobileqq.microapp.apkg.k;
import com.tencent.mobileqq.microapp.appbrand.a;
import com.tencent.mobileqq.microapp.appbrand.b.h;
import com.tencent.mobileqq.microapp.widget.TabBarView;
import com.tencent.mobileqq.microapp.widget.g;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class AppBrandPage
  extends AbsAppBrandPage
  implements PageWebview.PageWebViewListener
{
  public static final String TAG = "AppBrandPage";
  private FrameLayout centerLayout;
  public FrameLayout fullScreenLayout;
  boolean isInitReady;
  private String mUrl;
  private LinearLayout rootView;
  private TabBarView tabView;
  private g toastView;
  private Map webViewMap;
  
  public AppBrandPage(Context paramContext, AppBrandPageContainer paramAppBrandPageContainer)
  {
    super(paramContext, paramAppBrandPageContainer);
    paramAppBrandPageContainer.fullScreenLayout = this.fullScreenLayout;
    this.webViewMap = new HashMap();
  }
  
  public void cleanup()
  {
    Iterator localIterator = this.webViewMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      ((WebviewContainer)((Map.Entry)localIterator.next()).getValue()).destroy();
      localIterator.remove();
    }
    this.rootView = null;
    this.mUrl = null;
    this.isInitReady = false;
    super.cleanup();
  }
  
  public View createContentView()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandPage", 4, "createContentView apkgInfo=" + this.apkgInfo$5475ea27);
    }
    if ((this.rootView == null) && (this.apkgInfo$5475ea27.b.h != null))
    {
      this.tabView.a(this.apkgInfo$5475ea27.b.h);
      this.tabView.a(this.appBrandPageContainer);
      "top".equals(this.apkgInfo$5475ea27.b.h.e);
    }
    return this.rootView;
  }
  
  public FrameLayout getCenterLayout()
  {
    return this.centerLayout;
  }
  
  public PageWebview getCurrentPageWebview()
  {
    if (!TextUtils.isEmpty(this.mUrl)) {
      return getWebView(this.mUrl);
    }
    return null;
  }
  
  public WebviewContainer getCurrentWebviewContainer()
  {
    return (WebviewContainer)this.webViewMap.get(this.mUrl);
  }
  
  public TabBarView getTabBar()
  {
    return this.tabView;
  }
  
  public String getUrl()
  {
    return this.mUrl;
  }
  
  public PageWebview getWebView(int paramInt)
  {
    Iterator localIterator = this.webViewMap.values().iterator();
    while (localIterator.hasNext())
    {
      PageWebview localPageWebview = ((WebviewContainer)localIterator.next()).getPageWebview();
      if ((localPageWebview != null) && (localPageWebview.pageWebviewId == paramInt)) {
        return localPageWebview;
      }
    }
    return null;
  }
  
  public PageWebview getWebView(String paramString)
  {
    paramString = (WebviewContainer)this.webViewMap.get(paramString);
    if (paramString != null) {
      return paramString.getPageWebview();
    }
    return null;
  }
  
  public void hideToastView()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandPage", 2, "hideToastView toastView=" + this.toastView);
    }
    if (this.toastView != null)
    {
      this.toastView.a();
      this.toastView = null;
    }
  }
  
  public boolean isHomePage()
  {
    return this.apkgInfo$5475ea27.i(this.mUrl);
  }
  
  public boolean isTabPage()
  {
    return this.apkgInfo$5475ea27.h(this.mUrl);
  }
  
  public void loadUrl(String paramString1, String paramString2)
  {
    if (paramString1.equals(this.mUrl)) {
      onAppRoute(paramString2, paramString1);
    }
    do
    {
      return;
      this.mUrl = paramString1;
      Object localObject;
      if (!this.webViewMap.containsKey(paramString1))
      {
        this.appBrandPageContainer.appBrandRuntime.i.loadAppServiceJs(paramString1);
        localObject = h.a().b(this.apkgInfo$5475ea27.d);
        ((PageWebview)localObject).apkgInfo$5475ea27 = this.apkgInfo$5475ea27;
        ((PageWebview)localObject).appBrandRuntime = this.appBrandPageContainer.appBrandRuntime;
        ((PageWebview)localObject).eventListener = this.appBrandPageContainer.appBrandRuntime.h;
        ((PageWebview)localObject).openType = paramString2;
        ((PageWebview)localObject).mRouteUrl = paramString1;
        ((PageWebview)localObject).listener = this;
        ((PageWebview)localObject).loadPageWebviewJs$164d4c8c(this.apkgInfo$5475ea27);
        if (QLog.isColorLevel()) {
          QLog.d("AppBrandPage", 4, "loadUrl put webViewContainer url=" + paramString1);
        }
      }
      for (;;)
      {
        int i = this.appBrandPageContainer.getPageCount();
        if (QLog.isColorLevel()) {
          QLog.d("AppBrandPage", 4, "loadUrl url=" + paramString1 + ",pageCnt=" + i);
        }
        if (!isTabPage()) {
          break;
        }
        this.tabView.setVisibility(0);
        this.tabView.a(paramString1);
        return;
        localObject = this.webViewMap.entrySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
          WebviewContainer localWebviewContainer = (WebviewContainer)localEntry.getValue();
          if (((String)localEntry.getKey()).equals(paramString1))
          {
            localWebviewContainer.setVisibility(0);
            onAppRoute(paramString2, paramString1);
          }
          else
          {
            localWebviewContainer.setVisibility(8);
          }
        }
      }
    } while (this.tabView == null);
    this.tabView.setVisibility(8);
  }
  
  public void notifyChangePullDownRefreshStyle()
  {
    Iterator localIterator = this.webViewMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((WebviewContainer)((Map.Entry)localIterator.next()).getValue()).notifyChangePullDownRefreshStyle();
    }
  }
  
  public void onAppRoute(String paramString1, String paramString2)
  {
    super.onAppRoute(paramString1, paramString2);
    reportPageVisit(paramString2);
  }
  
  public void onPageBackground()
  {
    super.onPageBackground();
    if (getCurrentWebviewContainer() != null) {
      getCurrentWebviewContainer().onVideoPlayerPause();
    }
  }
  
  public void onPageForeground()
  {
    super.onPageForeground();
    if (getCurrentWebviewContainer() != null) {
      getCurrentWebviewContainer().onVideoPlayerResume();
    }
  }
  
  public void onSwipeFinish()
  {
    this.appBrandPageContainer.navigateBack(1, true);
  }
  
  public void onWebViewReady(String paramString1, String paramString2)
  {
    onAppRoute(paramString1, paramString2);
  }
  
  public void reportPageVisit(String paramString)
  {
    JSONObject localJSONObject;
    if (this.appBrandPageContainer.appBrandRuntime.l != -1L) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("page", c.n(paramString));
      label37:
      VACDReportUtil.a(this.appBrandPageContainer.appBrandRuntime.l, null, "PageVisit", localJSONObject.toString(), 0, null);
      return;
    }
    catch (Throwable paramString)
    {
      break label37;
    }
  }
  
  public void showToastView(String paramString1, String paramString2, CharSequence paramCharSequence, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandPage", 2, "showToastView toastView=" + this.toastView);
    }
    this.toastView.a(paramString1, paramString2, paramCharSequence, paramInt, paramBoolean);
  }
  
  public void stopPullDownRefresh()
  {
    Iterator localIterator = this.webViewMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((WebviewContainer)((Map.Entry)localIterator.next()).getValue()).stopPullDownRefresh();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.page.AppBrandPage
 * JD-Core Version:    0.7.0.1
 */