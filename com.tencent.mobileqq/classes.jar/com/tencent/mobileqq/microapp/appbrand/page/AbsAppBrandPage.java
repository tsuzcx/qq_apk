package com.tencent.mobileqq.microapp.appbrand.page;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.microapp.a.c;
import com.tencent.mobileqq.microapp.apkg.MiniAppConfig;
import com.tencent.mobileqq.microapp.appbrand.a;
import com.tencent.mobileqq.microapp.sdk.LaunchParam;
import com.tencent.mobileqq.microapp.widget.TabBarView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class AbsAppBrandPage
{
  public static final String TAG = "AbsAppBrandPage";
  protected c apkgInfo$5475ea27;
  protected AppBrandPageContainer appBrandPageContainer;
  private boolean isShow;
  
  public AbsAppBrandPage(Context paramContext, AppBrandPageContainer paramAppBrandPageContainer)
  {
    this.appBrandPageContainer = paramAppBrandPageContainer;
    this.apkgInfo$5475ea27 = paramAppBrandPageContainer.appBrandRuntime.c;
  }
  
  private void dispatch(String paramString1, String paramString2)
  {
    Object localObject1 = new HashMap();
    Object localObject2 = c.l(paramString2);
    Object localObject3 = c.m(paramString2);
    ((HashMap)localObject1).put("path", localObject2);
    ((HashMap)localObject1).put("query", localObject3);
    if (paramString1 != null) {
      ((HashMap)localObject1).put("openType", paramString1);
    }
    if ("appLaunch".equals(paramString1))
    {
      ((HashMap)localObject1).put("scene", Integer.valueOf(this.apkgInfo$5475ea27.f.launchParam.scene));
      if (TextUtils.isEmpty(this.apkgInfo$5475ea27.f.launchParam.navigateExtData)) {
        try
        {
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("appId", this.apkgInfo$5475ea27.d);
          ((JSONObject)localObject2).put("extraData", this.apkgInfo$5475ea27.f.launchParam.navigateExtData);
          ((HashMap)localObject1).put("referrerInfo", ((JSONObject)localObject2).toString());
        }
        catch (JSONException localJSONException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("AbsAppBrandPage", 4, "dispatch referrerInfo parse error", localJSONException);
          }
        }
      }
    }
    c.a((Map)localObject1);
    localObject1 = new JSONObject((Map)localObject1);
    PageWebview localPageWebview = getWebView(paramString2);
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("dispatch openType=");
      ((StringBuilder)localObject3).append(paramString1);
      ((StringBuilder)localObject3).append(",url=");
      ((StringBuilder)localObject3).append(paramString2);
      ((StringBuilder)localObject3).append(",webView=");
      if (localPageWebview != null) {
        paramString1 = Integer.valueOf(localPageWebview.pageWebviewId);
      } else {
        paramString1 = "empty";
      }
      ((StringBuilder)localObject3).append(paramString1);
      ((StringBuilder)localObject3).append(",jsonParams=");
      ((StringBuilder)localObject3).append(((JSONObject)localObject1).toString());
      QLog.d("AbsAppBrandPage", 2, ((StringBuilder)localObject3).toString());
    }
    if (localPageWebview != null)
    {
      paramString1 = this.appBrandPageContainer.appBrandRuntime.i;
      paramString2 = new StringBuilder();
      paramString2.append("WeixinJSBridge.subscribeHandler(\"onAppRoute\", ");
      paramString2.append(localObject1);
      paramString2.append(", ");
      paramString2.append(localPageWebview.pageWebviewId);
      paramString2.append(");");
      paramString1.evaluteJs(paramString2.toString());
      paramString1 = this.appBrandPageContainer.appBrandRuntime.i;
      paramString2 = new StringBuilder();
      paramString2.append("WeixinJSBridge.subscribeHandler(\"onAppRouteDone\", ");
      paramString2.append(localObject1);
      paramString2.append(", ");
      paramString2.append(localPageWebview.pageWebviewId);
      paramString2.append(");");
      paramString1.evaluteJs(paramString2.toString());
    }
  }
  
  public void cleanup()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsAppBrandPage", 4, "cleanup");
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
  
  public abstract TabBarView getTabBar();
  
  public abstract String getUrl();
  
  public abstract PageWebview getWebView(int paramInt);
  
  public abstract PageWebview getWebView(String paramString);
  
  public final void hide()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("hide isShow=");
      localStringBuilder.append(this.isShow);
      QLog.d("AbsAppBrandPage", 4, localStringBuilder.toString());
    }
  }
  
  public void hideToastView() {}
  
  public abstract boolean isHomePage();
  
  public abstract boolean isTabPage();
  
  public abstract void loadUrl(String paramString1, String paramString2);
  
  public abstract void notifyChangePullDownRefreshStyle();
  
  public void onAppRoute(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onAppRoute openType=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",url=");
      localStringBuilder.append(paramString2);
      QLog.d("AbsAppBrandPage", 4, localStringBuilder.toString());
    }
    dispatch(paramString1, paramString2);
  }
  
  public void onCreate() {}
  
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
  
  public void showToastView(String paramString1, String paramString2, CharSequence paramCharSequence, int paramInt, boolean paramBoolean) {}
  
  public abstract void stopPullDownRefresh();
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[currUrl=");
    localStringBuilder.append(getUrl());
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.page.AbsAppBrandPage
 * JD-Core Version:    0.7.0.1
 */