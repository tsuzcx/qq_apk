package com.tencent.mobileqq.fragment;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.newnearby.impl.NearbyReportHelperImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.webview.AbsWebView;
import com.tencent.mobileqq.webview.swift.CommonJsPluginFactory;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webviewplugin.WebViewJumpPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;

public final class NearbyHybridFragment$NearbyWebViewBuilder
  extends AbsWebView
{
  public boolean a = false;
  public boolean b = false;
  boolean c = false;
  public boolean d = false;
  protected boolean e = false;
  protected boolean f = false;
  
  public NearbyHybridFragment$NearbyWebViewBuilder(NearbyHybridFragment paramNearbyHybridFragment, Context paramContext, Activity paramActivity, AppInterface paramAppInterface)
  {
    super(paramContext, paramActivity, paramAppInterface);
  }
  
  public void a()
  {
    if (!this.a)
    {
      if (this.mWebview == null) {
        return;
      }
      long l;
      if (this.g.a != null) {
        l = System.currentTimeMillis();
      } else {
        l = 0L;
      }
      this.a = true;
      AuthorizeConfig.a();
      super.buildBaseWebView(this.mInterface);
      onWebViewReady();
      if (Build.VERSION.SDK_INT >= 21) {
        this.mWebview.getSettings().setMixedContentMode(0);
      }
      this.c = "1103".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId"));
      if (this.c) {
        this.mWebview.setMask(true);
      }
      setTimeBeforeLoadUrl(System.currentTimeMillis());
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("WebSpeedTrace", "mTimeBeforeLoadUrl", new Object[] { Long.valueOf(getTimeBeforeLoadUrl()) });
      }
      if ((this.g.a != null) && (this.g.a.mInitWebViewTime == 0L))
      {
        this.g.a.mInitWebViewTime = (System.currentTimeMillis() - l);
        if (QLog.isDevelopLevel()) {
          NearbyUtils.a("WebSpeedTrace", "mInitWebViewTime", new Object[] { Long.valueOf(this.g.a.mInitWebViewTime) });
        }
      }
    }
  }
  
  public void a(TouchWebView paramTouchWebView)
  {
    this.mWebview = paramTouchWebView;
  }
  
  public void a(String paramString)
  {
    this.mUrl = paramString;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start load url, from attach cost=");
      localStringBuilder.append(System.currentTimeMillis() - this.g.O);
      localStringBuilder.append(", url=");
      localStringBuilder.append(paramString);
      QLog.w("nearby.NearbyHybridFragment.webloading", 2, localStringBuilder.toString());
    }
    this.g.S = System.currentTimeMillis();
    this.mWebview.loadUrl(this.mUrl);
    if (this.g.E.getVisibility() != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.w("nearby.NearbyHybridFragment.webloading", 2, "send MSG_SHOW_LOADING before loadUrl");
      }
      this.g.l.removeMessages(3);
      paramString = this.g;
      paramString.R = false;
      paramString.l.sendEmptyMessageDelayed(3, 500L);
    }
  }
  
  public void b()
  {
    super.doOnResume();
  }
  
  public void bindJavaScript(ArrayList<WebViewPlugin> paramArrayList)
  {
    if (paramArrayList != null)
    {
      paramArrayList.add(new WebViewJumpPlugin());
      paramArrayList.add((WebViewPlugin)((IQzoneWebViewPluginHelper)QRoute.api(IQzoneWebViewPluginHelper.class)).getQzoneWebViewOfflinePlugin());
      paramArrayList.add((WebViewPlugin)((IQzoneWebViewPluginHelper)QRoute.api(IQzoneWebViewPluginHelper.class)).getQzoneWebViewPlugin());
    }
  }
  
  public void c()
  {
    super.doOnPause();
  }
  
  public void d()
  {
    super.doOnDestroy();
  }
  
  protected CommonJsPluginFactory myCommonJsPlugins()
  {
    return new CommonJsPluginFactory();
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    if (this.f) {
      return;
    }
    this.f = true;
    QLog.i("NearbyActivity", 1, "Load H5 Success");
    if ((this.g.ag instanceof NearbyActivity)) {
      NearbyReportHelperImpl.reportBeginLoadWebview((NearbyActivity)this.g.ag);
    }
    if (QLog.isColorLevel())
    {
      paramWebView = new StringBuilder();
      paramWebView.append("onPageFinished:");
      paramWebView.append(paramString);
      QLog.w("nearby.NearbyHybridFragment.webloading", 2, paramWebView.toString());
    }
    if (this.g.aj != null)
    {
      this.g.aj.c(true);
      this.g.aj.a();
    }
    this.d = true;
    paramWebView = this.g.E;
    if (!NearbyHybridFragment.M)
    {
      this.g.l.postDelayed(NearbyHybridFragment.N, 500L);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramWebView = new StringBuilder();
      paramWebView.append("already called pre load now plugin!, isCalledNowPreLoad=");
      paramWebView.append(NearbyHybridFragment.M);
      QLog.w("AbsWebView", 2, paramWebView.toString());
    }
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    if (this.e) {
      return;
    }
    this.e = true;
    if (QLog.isColorLevel())
    {
      paramWebView = new StringBuilder();
      paramWebView.append("onPageStarted:");
      paramWebView.append(paramString);
      QLog.w("nearby.NearbyHybridFragment.webloading", 2, paramWebView.toString());
    }
    this.b = true;
    if (this.g.aj != null)
    {
      this.g.aj.c(true);
      this.g.aj.a();
    }
    this.d = false;
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      paramWebView = new StringBuilder();
      paramWebView.append("onReceivedError: errorCode=");
      paramWebView.append(paramInt);
      paramWebView.append(", description=");
      paramWebView.append(paramString1);
      paramWebView.append(", failingUrl=");
      paramWebView.append(paramString2);
      QLog.w("nearby.NearbyHybridFragment.webloading", 2, paramWebView.toString());
    }
    if (this.g.F != null) {
      this.g.F.setVisibility(0);
    }
    if (this.g.E != null) {
      this.g.E.setVisibility(8);
    }
    if (this.g.H != null) {
      this.g.H.setVisibility(8);
    }
  }
  
  public void showCustomView(View paramView, int paramInt, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    if (QLog.isColorLevel())
    {
      paramCustomViewCallback = new StringBuilder();
      paramCustomViewCallback.append("showCustomView: view=");
      paramCustomViewCallback.append(paramView);
      paramCustomViewCallback.append(", orientation=");
      paramCustomViewCallback.append(paramInt);
      QLog.w("nearby.NearbyHybridFragment.webloading", 2, paramCustomViewCallback.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.NearbyHybridFragment.NearbyWebViewBuilder
 * JD-Core Version:    0.7.0.1
 */