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
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.webview.AbsWebView;
import com.tencent.mobileqq.webviewplugin.WebViewJumpPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;

public final class NowLiveFragment$NowLiveWebView
  extends AbsWebView
  implements TouchWebView.OnScrollChangedListener
{
  public int a;
  public boolean a;
  public boolean b;
  boolean c = false;
  
  public NowLiveFragment$NowLiveWebView(NowLiveFragment paramNowLiveFragment, Context paramContext, Activity paramActivity, AppInterface paramAppInterface)
  {
    super(paramContext, paramActivity, paramAppInterface);
    super.y();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity != null) {}
    for (long l = System.currentTimeMillis();; l = 0L)
    {
      this.jdField_a_of_type_Boolean = true;
      AuthorizeConfig.a();
      this.h = (NearbyActivity.jdField_a_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment.jdField_a_of_type_JavaLangString + "&_t=" + System.currentTimeMillis());
      this.jdField_a_of_type_ComTencentBizUiTouchWebView = new TouchWebView(this.e);
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.getSettings().setMediaPlaybackRequiresUserGesture(false);
      b(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      this.c = "1103".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId"));
      if (this.c) {
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.setMask(true);
      }
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.setOnScrollChangedListener(this);
      a(System.currentTimeMillis());
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("WebSpeedTrace", "AbsWebView mTimeBeforeLoadUrl", new Object[] { Long.valueOf(this.jdField_b_of_type_Long) });
      }
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl(this.h);
      if (QLog.isColorLevel()) {
        NearbyUtils.a("AbsWebView", new Object[] { "NowLiveWebView.init", this.h });
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.f == 0L))
      {
        this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.f = (System.currentTimeMillis() - l);
        if (QLog.isDevelopLevel()) {
          NearbyUtils.a("WebSpeedTrace", "AbsWebView mInitWebViewTime", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.f) });
        }
      }
      if (NowLiveFragment.b()) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment.jdField_a_of_type_AndroidOsHandler.postDelayed(NowLiveFragment.a(), 5000L);
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null) {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getWebScrollY();
    }
  }
  
  public void a(Intent paramIntent)
  {
    super.b(paramIntent);
  }
  
  public void a(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    this.jdField_b_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment.jdField_a_of_type_ComTencentMobileqqFragmentTitlebarStatus != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment.jdField_a_of_type_ComTencentMobileqqFragmentTitlebarStatus.b(true).a(true);
      this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment.jdField_a_of_type_ComTencentMobileqqFragmentTitlebarStatus.a();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment.b != null) && (this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment.b.getVisibility() != 8)) {
      this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment.b.setVisibility(8);
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    if (paramArrayList != null) {
      paramArrayList.add(new WebViewJumpPlugin());
    }
  }
  
  public boolean a(WebView paramWebView, String paramString)
  {
    boolean bool = super.a(paramWebView, paramString);
    if ((paramString.startsWith("tmast://")) || (paramString.startsWith("tnow://")))
    {
      paramWebView = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
      paramWebView.addFlags(268435456);
      this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment.startActivity(paramWebView);
    }
    return bool;
  }
  
  public void b()
  {
    super.u();
  }
  
  public void b(WebView paramWebView, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment.jdField_a_of_type_ComTencentMobileqqFragmentTitlebarStatus != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment.jdField_a_of_type_ComTencentMobileqqFragmentTitlebarStatus.b(false).a(true);
      this.jdField_a_of_type_ComTencentMobileqqFragmentNowLiveFragment.jdField_a_of_type_ComTencentMobileqqFragmentTitlebarStatus.a();
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.NowLiveFragment.NowLiveWebView
 * JD-Core Version:    0.7.0.1
 */