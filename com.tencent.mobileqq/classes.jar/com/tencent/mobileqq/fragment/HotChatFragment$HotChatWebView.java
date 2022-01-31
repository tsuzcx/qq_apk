package com.tencent.mobileqq.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.ui.TouchWebView.OnScrollChangedListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.webview.AbsWebView;
import com.tencent.mobileqq.webviewplugin.WebViewJumpPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;

public final class HotChatFragment$HotChatWebView
  extends AbsWebView
  implements TouchWebView.OnScrollChangedListener
{
  public int a;
  public boolean a;
  public boolean b;
  boolean c = false;
  
  public HotChatFragment$HotChatWebView(HotChatFragment paramHotChatFragment, Context paramContext, Activity paramActivity, AppInterface paramAppInterface)
  {
    super(paramContext, paramActivity, paramAppInterface);
    super.y();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity != null) {}
    for (long l = System.currentTimeMillis();; l = 0L)
    {
      this.jdField_a_of_type_Boolean = true;
      AuthorizeConfig.a();
      this.h = SharedPreUtils.d(this.e, this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin());
      this.jdField_a_of_type_ComTencentBizUiTouchWebView = new HotChatFragment.HotChatWebView.HotChatTouchWebView(this, this.e);
      b(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      this.c = "1103".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId"));
      if (this.c) {
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.setMask(true);
      }
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.setOnScrollChangedListener(this);
      a(System.currentTimeMillis());
      if (QLog.isDevelopLevel()) {
        NearbyUtils.a("WebSpeedTrace", "mTimeBeforeLoadUrl", new Object[] { Long.valueOf(this.jdField_b_of_type_Long) });
      }
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl(this.h);
      if (QLog.isColorLevel()) {
        NearbyUtils.a("AbsWebView", new Object[] { "HotChatWebView.init", this.h });
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.k != 0L)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.k = (System.currentTimeMillis() - l);
      if (!QLog.isDevelopLevel()) {
        break;
      }
      NearbyUtils.a("WebSpeedTrace", "mInitWebViewTime", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.k) });
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
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment.jdField_a_of_type_ComTencentMobileqqFragmentTitlebarStatus != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment.jdField_a_of_type_ComTencentMobileqqFragmentTitlebarStatus.b(true).a(true);
      this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment.jdField_a_of_type_ComTencentMobileqqFragmentTitlebarStatus.a();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment.b != null) && (this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment.b.getVisibility() != 8)) {
      this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment.b.setVisibility(8);
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    if (paramArrayList != null) {
      paramArrayList.add(new WebViewJumpPlugin());
    }
  }
  
  public void b()
  {
    super.u();
  }
  
  public void b(WebView paramWebView, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment.jdField_a_of_type_ComTencentMobileqqFragmentTitlebarStatus != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment.jdField_a_of_type_ComTencentMobileqqFragmentTitlebarStatus.b(false).a(true);
      this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment.jdField_a_of_type_ComTencentMobileqqFragmentTitlebarStatus.a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.HotChatFragment.HotChatWebView
 * JD-Core Version:    0.7.0.1
 */