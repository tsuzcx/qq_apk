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
  public boolean a;
  public boolean b = false;
  boolean c = false;
  public boolean d = false;
  protected boolean e = false;
  protected boolean f = false;
  
  public NearbyHybridFragment$NearbyWebViewBuilder(NearbyHybridFragment paramNearbyHybridFragment, Context paramContext, Activity paramActivity, AppInterface paramAppInterface)
  {
    super(paramContext, paramActivity, paramAppInterface);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      if (this.mWebview == null) {
        return;
      }
      long l;
      if (this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity != null) {
        l = System.currentTimeMillis();
      } else {
        l = 0L;
      }
      this.jdField_a_of_type_Boolean = true;
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
      if ((this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.mInitWebViewTime == 0L))
      {
        this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.mInitWebViewTime = (System.currentTimeMillis() - l);
        if (QLog.isDevelopLevel()) {
          NearbyUtils.a("WebSpeedTrace", "mInitWebViewTime", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.mInitWebViewTime) });
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
      localStringBuilder.append(System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.jdField_c_of_type_Long);
      localStringBuilder.append(", url=");
      localStringBuilder.append(paramString);
      QLog.w("nearby.NearbyHybridFragment.webloading", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.jdField_e_of_type_Long = System.currentTimeMillis();
    this.mWebview.loadUrl(this.mUrl);
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.jdField_c_of_type_AndroidViewView.getVisibility() != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.w("nearby.NearbyHybridFragment.webloading", 2, "send MSG_SHOW_LOADING before loadUrl");
      }
      this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
      paramString = this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment;
      paramString.l = false;
      paramString.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, 500L);
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
    if (QLog.isColorLevel())
    {
      paramWebView = new StringBuilder();
      paramWebView.append("onPageFinished:");
      paramWebView.append(paramString);
      QLog.w("nearby.NearbyHybridFragment.webloading", 2, paramWebView.toString());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.jdField_a_of_type_ComTencentMobileqqFragmentTitlebarStatus != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.jdField_a_of_type_ComTencentMobileqqFragmentTitlebarStatus.a(true);
      this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.jdField_a_of_type_ComTencentMobileqqFragmentTitlebarStatus.a();
    }
    this.d = true;
    paramWebView = this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.jdField_c_of_type_AndroidViewView;
    if (!NearbyHybridFragment.k)
    {
      this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.jdField_a_of_type_AndroidOsHandler.postDelayed(NearbyHybridFragment.jdField_a_of_type_JavaLangRunnable, 500L);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramWebView = new StringBuilder();
      paramWebView.append("already called pre load now plugin!, isCalledNowPreLoad=");
      paramWebView.append(NearbyHybridFragment.k);
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
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.jdField_a_of_type_ComTencentMobileqqFragmentTitlebarStatus != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.jdField_a_of_type_ComTencentMobileqqFragmentTitlebarStatus.a(true);
      this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.jdField_a_of_type_ComTencentMobileqqFragmentTitlebarStatus.a();
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
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.d != null) {
      this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.d.setVisibility(0);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.jdField_c_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.jdField_e_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.jdField_e_of_type_AndroidViewView.setVisibility(8);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.NearbyHybridFragment.NearbyWebViewBuilder
 * JD-Core Version:    0.7.0.1
 */