package com.tencent.mobileqq.mini.appbrand.page;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.ui.CapsuleButton;
import com.tencent.mobileqq.mini.appbrand.ui.SwipeBackLayout;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandUtil;
import com.tencent.mobileqq.mini.ui.NavigationBar;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.mini.widget.TabBarView;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public abstract class AbsAppBrandPage
  extends SwipeBackLayout
{
  public static final String TAG = "AbsAppBrandPage";
  protected ApkgInfo apkgInfo;
  protected AppBrandPageContainer appBrandPageContainer;
  protected AppBrandRuntime appBrandRuntime;
  private boolean isShow;
  private View keyBoardConfirmView;
  protected View mContentView;
  
  public AbsAppBrandPage(Context paramContext, AppBrandRuntime paramAppBrandRuntime)
  {
    super(paramContext);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    if (paramAppBrandRuntime != null)
    {
      this.appBrandRuntime = paramAppBrandRuntime;
      this.apkgInfo = paramAppBrandRuntime.apkgInfo;
    }
    this.mContentView = createContentView();
    if (this.mContentView != null) {
      addView(this.mContentView, new ViewGroup.LayoutParams(-1, -1));
    }
  }
  
  private void dispatch(String paramString1, String paramString2)
  {
    MiniAppInfo localMiniAppInfo = null;
    if ((getNavBar() != null) && (getNavBar().getCapsuleButton() != null)) {
      getNavBar().getCapsuleButton().updateRedDotVisible();
    }
    PageWebview localPageWebview = getWebView(paramString2);
    if (localPageWebview != null) {
      localPageWebview.setTitle();
    }
    Object localObject1;
    if ((this.apkgInfo != null) && (this.apkgInfo.appConfig != null)) {
      if (this.apkgInfo.appConfig.launchParam != null)
      {
        localObject1 = this.apkgInfo.appConfig.launchParam;
        localObject2 = localObject1;
        if (this.apkgInfo.appConfig.config != null) {
          localMiniAppInfo = this.apkgInfo.appConfig.config;
        }
      }
    }
    for (Object localObject2 = localObject1;; localObject2 = null)
    {
      localObject1 = AppBrandUtil.getPageLoadInfo(paramString2, paramString1, localObject2, localMiniAppInfo);
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder().append("dispatch openType=").append(paramString1).append(",url=").append(paramString2).append(",webView=");
        if (localPageWebview == null) {
          break label271;
        }
      }
      label271:
      for (paramString1 = Integer.valueOf(localPageWebview.pageWebviewId);; paramString1 = "empty")
      {
        QLog.d("AbsAppBrandPage", 2, paramString1 + ",jsonParams=" + ((JSONObject)localObject1).toString());
        if ((localPageWebview != null) && (this.appBrandPageContainer != null))
        {
          this.appBrandPageContainer.appBrandRuntime.serviceRuntime.evaluateSubcribeJS("onAppRoute", ((JSONObject)localObject1).toString(), localPageWebview.pageWebviewId);
          this.appBrandPageContainer.appBrandRuntime.serviceRuntime.evaluateSubcribeJS("onAppRouteDone", ((JSONObject)localObject1).toString(), localPageWebview.pageWebviewId);
        }
        return;
      }
      localObject1 = null;
      break;
    }
  }
  
  private void initKeyBoardConfirmView()
  {
    this.keyBoardConfirmView = LayoutInflater.from(getContext().getApplicationContext()).inflate(2131559395, null);
    this.keyBoardConfirmView.setVisibility(8);
    ((TextView)this.keyBoardConfirmView.findViewById(2131371073)).setOnClickListener(new AbsAppBrandPage.1(this));
    addView(this.keyBoardConfirmView);
  }
  
  public void cleanup()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsAppBrandPage", 4, "cleanup");
    }
    if (this.appBrandPageContainer != null) {
      this.appBrandPageContainer.removeView(this);
    }
  }
  
  public abstract View createContentView();
  
  public boolean forceRemoveNoMatchOnPath()
  {
    return false;
  }
  
  public abstract FrameLayout getCenterLayout();
  
  public PageWebview getCurrentPageWebview()
  {
    return null;
  }
  
  public abstract WebviewContainer getCurrentWebviewContainer();
  
  public NavigationBar getNavBar()
  {
    return null;
  }
  
  public int getNavBarHeight()
  {
    return 0;
  }
  
  public abstract TabBarView getTabBar();
  
  public int getTabBarHeight()
  {
    return 0;
  }
  
  public abstract String getUrl();
  
  public abstract PageWebview getWebView(int paramInt);
  
  public abstract PageWebview getWebView(String paramString);
  
  public abstract WebviewContainer getWebviewContainerByUrl(String paramString);
  
  public boolean hasToastView()
  {
    return false;
  }
  
  public final void hide()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsAppBrandPage", 4, "hide isShow=" + this.isShow);
    }
    if (this.isShow) {
      setVisibility(4);
    }
  }
  
  public void hideKeyBoardConfirmView()
  {
    if ((this.keyBoardConfirmView != null) && (this.keyBoardConfirmView.getVisibility() == 0)) {
      this.keyBoardConfirmView.setVisibility(8);
    }
  }
  
  public void hideToastView() {}
  
  public abstract boolean isHomePage();
  
  public abstract boolean isTabPage();
  
  public abstract void loadUrl(int paramInt, String paramString1, String paramString2);
  
  public abstract void loadUrl(String paramString1, String paramString2);
  
  public abstract void notifyChangePullDownRefreshStyle();
  
  public void onAddColorNote()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsAppBrandPage", 4, "onAddColorNote");
    }
  }
  
  public void onAppRoute(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsAppBrandPage", 4, "onAppRoute openType=" + paramString1 + ",url=" + paramString2);
    }
    dispatch(paramString1, paramString2);
  }
  
  public void onCreate(AppBrandRuntime paramAppBrandRuntime, AppBrandPageContainer paramAppBrandPageContainer)
  {
    setAppBrandRuntime(paramAppBrandRuntime);
    this.appBrandPageContainer = paramAppBrandPageContainer;
    paramAppBrandPageContainer.addView(this);
    initKeyBoardConfirmView();
  }
  
  public void onPageBackground()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsAppBrandPage", 4, "onPageBackground");
    }
    this.isShow = false;
  }
  
  public void onPageForeground()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsAppBrandPage", 4, "onPageForeground");
    }
    this.isShow = true;
  }
  
  public void setAppBrandRuntime(AppBrandRuntime paramAppBrandRuntime)
  {
    if (this.mContentView != null) {}
    do
    {
      return;
      this.appBrandRuntime = paramAppBrandRuntime;
      this.apkgInfo = paramAppBrandRuntime.apkgInfo;
      this.mContentView = createContentView();
    } while (this.mContentView == null);
    addView(this.mContentView, new ViewGroup.LayoutParams(-1, -1));
  }
  
  public abstract void setDisablePullDownRefresh(boolean paramBoolean);
  
  public void showKeyBoardConfirmView(int paramInt)
  {
    if (this.keyBoardConfirmView != null)
    {
      if (this.keyBoardConfirmView.getVisibility() == 8) {
        this.keyBoardConfirmView.setVisibility(0);
      }
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, DisplayUtil.dip2px(getContext(), 50.0F));
      localLayoutParams.leftMargin = 0;
      localLayoutParams.topMargin = paramInt;
      this.keyBoardConfirmView.setLayoutParams(localLayoutParams);
    }
  }
  
  public void showToastView(int paramInt1, String paramString1, String paramString2, CharSequence paramCharSequence, int paramInt2, boolean paramBoolean) {}
  
  public abstract void stopPullDownRefresh();
  
  public String toString()
  {
    return "[currUrl=" + getUrl() + "]";
  }
  
  public void updateStyle(String paramString) {}
  
  public void updateToastMsg(String paramString) {}
  
  public abstract void updateViewStyle(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage
 * JD-Core Version:    0.7.0.1
 */