package com.tencent.mobileqq.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import ashu;
import auwz;
import bdne;
import beej;
import belw;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.ui.TouchWebView.OnScrollChangedListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import myl;

public final class HotChatFragment$HotChatWebView
  extends beej
  implements TouchWebView.OnScrollChangedListener
{
  public int a;
  public boolean a;
  public boolean b;
  boolean c = false;
  
  public HotChatFragment$HotChatWebView(HotChatFragment paramHotChatFragment, Context paramContext, Activity paramActivity, AppInterface paramAppInterface)
  {
    super(paramContext, paramActivity, paramAppInterface);
    super.preInitPluginEngine();
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
      myl.a();
      this.mUrl = bdne.e(this.mContext, this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin());
      this.mWebview = new HotChatFragment.HotChatWebView.HotChatTouchWebView(this, this.mContext);
      buildBaseWebView(this.mInterface);
      this.c = "1103".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId"));
      if (this.c) {
        this.mWebview.setMask(true);
      }
      this.mWebview.setBackgroundColor(-1);
      this.mWebview.setOnScrollChangedListener(this);
      setmTimeBeforeLoadUrl(System.currentTimeMillis());
      if (QLog.isDevelopLevel()) {
        auwz.a("WebSpeedTrace", "mTimeBeforeLoadUrl", new Object[] { Long.valueOf(this.mTimeBeforeLoadUrl) });
      }
      this.mWebview.loadUrl(this.mUrl);
      if (QLog.isColorLevel()) {
        auwz.a("AbsWebView", new Object[] { "HotChatWebView.init", this.mUrl });
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.k != 0L)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.k = (System.currentTimeMillis() - l);
      if (!QLog.isDevelopLevel()) {
        break;
      }
      auwz.a("WebSpeedTrace", "mInitWebViewTime", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.k) });
      return;
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
      paramArrayList.add(new belw());
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
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment.jdField_a_of_type_Ashu != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment.jdField_a_of_type_Ashu.b(false).a(true);
      this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment.jdField_a_of_type_Ashu.a();
    }
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    this.b = true;
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment.jdField_a_of_type_Ashu != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment.jdField_a_of_type_Ashu.b(true).a(true);
      this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment.jdField_a_of_type_Ashu.a();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment.b != null) && (this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment.b.getVisibility() != 8)) {
      this.jdField_a_of_type_ComTencentMobileqqFragmentHotChatFragment.b.setVisibility(8);
    }
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    if (this.mWebview != null) {
      this.jdField_a_of_type_Int = this.mWebview.getWebScrollY();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.HotChatFragment.HotChatWebView
 * JD-Core Version:    0.7.0.1
 */