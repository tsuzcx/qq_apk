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
    Map localMap = c.m(paramString2);
    ((HashMap)localObject1).put("path", localObject2);
    ((HashMap)localObject1).put("query", localMap);
    if (paramString1 != null) {
      ((HashMap)localObject1).put("openType", paramString1);
    }
    if ("appLaunch".equals(paramString1))
    {
      ((HashMap)localObject1).put("scene", Integer.valueOf(this.apkgInfo$5475ea27.f.launchParam.scene));
      if (!TextUtils.isEmpty(this.apkgInfo$5475ea27.f.launchParam.navigateExtData)) {}
    }
    try
    {
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("appId", this.apkgInfo$5475ea27.d);
      ((JSONObject)localObject2).put("extraData", this.apkgInfo$5475ea27.f.launchParam.navigateExtData);
      ((HashMap)localObject1).put("referrerInfo", ((JSONObject)localObject2).toString());
      c.a((Map)localObject1);
      localObject1 = new JSONObject((Map)localObject1);
      localObject2 = getWebView(paramString2);
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder().append("dispatch openType=").append(paramString1).append(",url=").append(paramString2).append(",webView=");
        if (localObject2 != null)
        {
          paramString1 = Integer.valueOf(((PageWebview)localObject2).pageWebviewId);
          QLog.d("AbsAppBrandPage", 2, paramString1 + ",jsonParams=" + ((JSONObject)localObject1).toString());
        }
      }
      else
      {
        if (localObject2 != null)
        {
          this.appBrandPageContainer.appBrandRuntime.i.evaluteJs("WeixinJSBridge.subscribeHandler(\"onAppRoute\", " + localObject1 + ", " + ((PageWebview)localObject2).pageWebviewId + ");");
          this.appBrandPageContainer.appBrandRuntime.i.evaluteJs("WeixinJSBridge.subscribeHandler(\"onAppRouteDone\", " + localObject1 + ", " + ((PageWebview)localObject2).pageWebviewId + ");");
        }
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.e("AbsAppBrandPage", 4, "dispatch referrerInfo parse error", localJSONException);
          continue;
          paramString1 = "empty";
        }
      }
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
    if (QLog.isColorLevel()) {
      QLog.d("AbsAppBrandPage", 4, "hide isShow=" + this.isShow);
    }
  }
  
  public void hideToastView() {}
  
  public abstract boolean isHomePage();
  
  public abstract boolean isTabPage();
  
  public abstract void loadUrl(String paramString1, String paramString2);
  
  public abstract void notifyChangePullDownRefreshStyle();
  
  public void onAppRoute(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsAppBrandPage", 4, "onAppRoute openType=" + paramString1 + ",url=" + paramString2);
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
    return "[currUrl=" + getUrl() + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.page.AbsAppBrandPage
 * JD-Core Version:    0.7.0.1
 */