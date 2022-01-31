package com.tencent.mobileqq.fragment;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.ui.TouchWebView.OnScrollChangedListener;
import com.tencent.biz.webviewplugin.QzoneWebViewOfflinePlugin;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper.CommonJsPluginFactory;
import com.tencent.mobileqq.webview.AbsWebView;
import com.tencent.mobileqq.webviewplugin.WebViewJumpPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;
import com.tencent.smtt.sdk.WebView;
import cooperation.qzone.webviewplugin.QZoneWebViewPlugin;
import java.util.ArrayList;

public final class NearbyHybridFragment$NearbyWebViewBuilder
  extends AbsWebView
  implements TouchWebView.OnScrollChangedListener
{
  public int a;
  public boolean a;
  public boolean b;
  boolean c = false;
  public boolean d;
  protected boolean e;
  protected boolean f;
  
  public NearbyHybridFragment$NearbyWebViewBuilder(NearbyHybridFragment paramNearbyHybridFragment, Context paramContext, Activity paramActivity, AppInterface paramAppInterface)
  {
    super(paramContext, paramActivity, paramAppInterface);
  }
  
  protected WebAccelerateHelper.CommonJsPluginFactory a()
  {
    return new WebAccelerateHelper.CommonJsPluginFactory();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity != null) {}
    for (long l = System.currentTimeMillis();; l = 0L)
    {
      this.jdField_a_of_type_Boolean = true;
      AuthorizeConfig.a();
      super.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      e();
      this.c = "1103".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId"));
      if (this.c) {
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.setMask(true);
      }
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.setOnScrollChangedListener(this);
      a(System.currentTimeMillis());
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("WebSpeedTrace", "mTimeBeforeLoadUrl", new Object[] { Long.valueOf(this.jdField_b_of_type_Long) });
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.k != 0L)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.k = (System.currentTimeMillis() - l);
      if (!QLog.isDevelopLevel()) {
        break;
      }
      NearbyUtils.a("WebSpeedTrace", "mInitWebViewTime", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.k) });
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null) {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getWebScrollY();
    }
  }
  
  public void a(View paramView, int paramInt, IX5WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.w("NearbyHybridFragment.webloading", 2, "showCustomView: view=" + paramView + ", orientation=" + paramInt);
    }
  }
  
  public void a(TouchWebView paramTouchWebView)
  {
    this.jdField_a_of_type_ComTencentBizUiTouchWebView = paramTouchWebView;
  }
  
  public void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.w("NearbyHybridFragment.webloading", 2, "onReceivedError: errorCode=" + paramInt + ", description=" + paramString1 + ", failingUrl=" + paramString2);
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
  
  public void a(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    if (this.e) {
      return;
    }
    this.e = true;
    if (QLog.isColorLevel()) {
      QLog.w("NearbyHybridFragment.webloading", 2, "onPageStarted:" + paramString);
    }
    this.jdField_b_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.jdField_a_of_type_ComTencentMobileqqFragmentTitlebarStatus != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.jdField_a_of_type_ComTencentMobileqqFragmentTitlebarStatus.b(true).a(true);
      this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.jdField_a_of_type_ComTencentMobileqqFragmentTitlebarStatus.a();
    }
    this.d = false;
  }
  
  public void a(String paramString)
  {
    this.h = paramString;
    if (QLog.isColorLevel()) {
      QLog.w("NearbyHybridFragment.webloading", 2, "start load url, from attach cost=" + (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.jdField_c_of_type_Long) + ", url=" + paramString);
    }
    this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.jdField_e_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl(this.h);
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.jdField_c_of_type_AndroidViewView.getVisibility() != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.w("NearbyHybridFragment.webloading", 2, "send MSG_SHOW_LOADING before loadUrl");
      }
      this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
      this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.m = false;
      this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, 500L);
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    if (paramArrayList != null)
    {
      paramArrayList.add(new WebViewJumpPlugin());
      paramArrayList.add(new QzoneWebViewOfflinePlugin());
      paramArrayList.add(new QZoneWebViewPlugin());
    }
  }
  
  public void b()
  {
    super.u();
  }
  
  public void b(WebView paramWebView, String paramString)
  {
    if (this.f) {}
    do
    {
      return;
      this.f = true;
      if (QLog.isColorLevel()) {
        QLog.w("NearbyHybridFragment.webloading", 2, "onPageFinished:" + paramString);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.jdField_a_of_type_ComTencentMobileqqFragmentTitlebarStatus != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.jdField_a_of_type_ComTencentMobileqqFragmentTitlebarStatus.b(false).a(true);
        this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.jdField_a_of_type_ComTencentMobileqqFragmentTitlebarStatus.a();
      }
      this.d = true;
      if ((this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.jdField_c_of_type_AndroidViewView == null) || (!NearbyHybridFragment.l))
      {
        this.jdField_a_of_type_ComTencentMobileqqFragmentNearbyHybridFragment.jdField_a_of_type_AndroidOsHandler.postDelayed(NearbyHybridFragment.jdField_a_of_type_JavaLangRunnable, 500L);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.w("AbsWebView", 2, "already called pre load now plugin!, isCalledNowPreLoad=" + NearbyHybridFragment.l);
  }
  
  public void c()
  {
    super.v();
  }
  
  public void d()
  {
    super.w();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.NearbyHybridFragment.NearbyWebViewBuilder
 * JD-Core Version:    0.7.0.1
 */