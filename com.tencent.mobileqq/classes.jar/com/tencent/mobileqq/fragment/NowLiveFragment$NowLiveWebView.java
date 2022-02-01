package com.tencent.mobileqq.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.ui.TouchWebView.OnScrollChangedListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.webview.AbsWebView;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webviewplugin.WebViewJumpPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;

final class NowLiveFragment$NowLiveWebView
  extends AbsWebView
  implements TouchWebView.OnScrollChangedListener
{
  public int a;
  public boolean b = false;
  public boolean c = false;
  boolean d = false;
  
  public NowLiveFragment$NowLiveWebView(NowLiveFragment paramNowLiveFragment, Context paramContext, Activity paramActivity, AppInterface paramAppInterface)
  {
    super(paramContext, paramActivity, paramAppInterface);
    super.preInitPluginEngine();
  }
  
  public void a()
  {
    if (this.b) {
      return;
    }
    long l;
    if (this.e.b != null) {
      l = System.currentTimeMillis();
    } else {
      l = 0L;
    }
    this.b = true;
    AuthorizeConfig.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(NearbyActivity.nearByTabUrl);
    localStringBuilder.append(this.e.g);
    localStringBuilder.append("&_t=");
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append(((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getUrlJsonToStr(((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getLiveTabWebViewUrlByJson()));
    this.mUrl = localStringBuilder.toString();
    this.mWebview = new TouchWebView(this.mContext);
    this.mWebview.getSettings().setMediaPlaybackRequiresUserGesture(false);
    buildBaseWebView(this.mInterface);
    this.d = "1103".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId"));
    if (this.d) {
      this.mWebview.setMask(true);
    }
    this.mWebview.setBackgroundColor(-1);
    this.mWebview.setOnScrollChangedListener(this);
    setTimeBeforeLoadUrl(System.currentTimeMillis());
    if (QLog.isDevelopLevel()) {
      NearbyUtils.a("WebSpeedTrace", "AbsWebView mTimeBeforeLoadUrl", new Object[] { Long.valueOf(getTimeBeforeLoadUrl()) });
    }
    this.mWebview.loadUrl(this.mUrl);
    if (QLog.isColorLevel()) {
      NearbyUtils.a("AbsWebView", new Object[] { "NowLiveWebView.init", this.mUrl });
    }
    if ((this.e.b != null) && (this.e.b.mNowInitWebViewTime == 0L))
    {
      this.e.b.mNowInitWebViewTime = (System.currentTimeMillis() - l);
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("WebSpeedTrace", "AbsWebView mInitWebViewTime", new Object[] { Long.valueOf(this.e.b.mNowInitWebViewTime) });
      }
    }
    if (!NowLiveFragment.i()) {
      this.e.l.postDelayed(NowLiveFragment.j(), 5000L);
    }
  }
  
  public void a(Intent paramIntent)
  {
    super.doOnCreate(paramIntent);
  }
  
  public void b()
  {
    super.doOnResume();
  }
  
  public void bindJavaScript(ArrayList<WebViewPlugin> paramArrayList)
  {
    if (paramArrayList != null) {
      paramArrayList.add(new WebViewJumpPlugin());
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
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    if (this.e.aj != null)
    {
      this.e.aj.b(false).c(true);
      this.e.aj.a();
    }
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    this.c = true;
    if (this.e.aj != null)
    {
      this.e.aj.b(true).c(true);
      this.e.aj.a();
    }
    if ((this.e.a != null) && (this.e.a.getVisibility() != 8)) {
      this.e.a.setVisibility(8);
    }
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    if (this.mWebview != null) {
      this.a = this.mWebview.getWebScrollY();
    }
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    boolean bool = super.shouldOverrideUrlLoading(paramWebView, paramString);
    if ((paramString.startsWith("tmast://")) || (paramString.startsWith("tnow://")))
    {
      paramWebView = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
      paramWebView.addFlags(268435456);
      this.e.startActivity(paramWebView);
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.NowLiveFragment.NowLiveWebView
 * JD-Core Version:    0.7.0.1
 */