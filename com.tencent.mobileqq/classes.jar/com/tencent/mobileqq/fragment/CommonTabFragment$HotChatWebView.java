package com.tencent.mobileqq.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.ui.TouchWebView.OnScrollChangedListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.home.NearbyTabInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.webview.AbsWebView;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webviewplugin.WebViewJumpPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

final class CommonTabFragment$HotChatWebView
  extends AbsWebView
  implements TouchWebView.OnScrollChangedListener
{
  public int a;
  public boolean a;
  public boolean b = false;
  boolean c = false;
  
  public CommonTabFragment$HotChatWebView(CommonTabFragment paramCommonTabFragment, Context paramContext, Activity paramActivity, AppInterface paramAppInterface)
  {
    super(paramContext, paramActivity, paramAppInterface);
    this.jdField_a_of_type_Boolean = false;
    super.preInitPluginEngine();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentCommonTabFragment.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity != null) {}
    for (long l = System.currentTimeMillis();; l = 0L)
    {
      this.jdField_a_of_type_Boolean = true;
      AuthorizeConfig.a();
      if (this.jdField_a_of_type_ComTencentMobileqqFragmentCommonTabFragment.jdField_a_of_type_ComTencentMobileqqNearbyHomeNearbyTabInfo != null) {
        this.mUrl = this.jdField_a_of_type_ComTencentMobileqqFragmentCommonTabFragment.jdField_a_of_type_ComTencentMobileqqNearbyHomeNearbyTabInfo.tabUrl;
      }
      if (!TextUtils.isEmpty(this.mUrl)) {
        if (!this.mUrl.contains("?")) {
          break label379;
        }
      }
      label379:
      for (this.mUrl += "&";; this.mUrl += "?")
      {
        this.mUrl += this.jdField_a_of_type_ComTencentMobileqqFragmentCommonTabFragment.jdField_a_of_type_JavaLangString;
        this.mWebview = new TouchWebView(this.mContext);
        buildBaseWebView(this.mInterface);
        this.c = "1103".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId"));
        if (this.c) {
          this.mWebview.setMask(true);
        }
        this.mWebview.setBackgroundColor(-1);
        this.mWebview.setOnScrollChangedListener(this);
        setmTimeBeforeLoadUrl(System.currentTimeMillis());
        if (QLog.isDevelopLevel()) {
          NearbyUtils.a("WebSpeedTrace", "mTimeBeforeLoadUrl", new Object[] { Long.valueOf(this.mTimeBeforeLoadUrl) });
        }
        this.jdField_a_of_type_ComTencentMobileqqFragmentCommonTabFragment.g = false;
        HashMap localHashMap = new HashMap();
        localHashMap.put("accept-diff", "true");
        this.mWebview.loadUrl(this.mUrl, localHashMap);
        if (QLog.isColorLevel()) {
          NearbyUtils.a("AbsWebView", new Object[] { "HotChatWebView.init", this.mUrl });
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqFragmentCommonTabFragment.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqFragmentCommonTabFragment.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.l != 0L)) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqFragmentCommonTabFragment.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.l = (System.currentTimeMillis() - l);
        if (!QLog.isDevelopLevel()) {
          break;
        }
        NearbyUtils.a("WebSpeedTrace", "mInitWebViewTime", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFragmentCommonTabFragment.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.l) });
        return;
      }
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
    this.jdField_a_of_type_ComTencentMobileqqFragmentCommonTabFragment.a(paramWebView, paramString);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    this.b = true;
    if (this.jdField_a_of_type_ComTencentMobileqqFragmentCommonTabFragment.jdField_a_of_type_ComTencentMobileqqFragmentTitlebarStatus != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFragmentCommonTabFragment.jdField_a_of_type_ComTencentMobileqqFragmentTitlebarStatus.b(true).a(true);
      this.jdField_a_of_type_ComTencentMobileqqFragmentCommonTabFragment.jdField_a_of_type_ComTencentMobileqqFragmentTitlebarStatus.a();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqFragmentCommonTabFragment.b != null) && (this.jdField_a_of_type_ComTencentMobileqqFragmentCommonTabFragment.b.getVisibility() != 8)) {
      this.jdField_a_of_type_ComTencentMobileqqFragmentCommonTabFragment.b.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentMobileqqFragmentCommonTabFragment.a(paramWebView, paramString, paramBitmap);
  }
  
  public void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    if (this.mWebview != null) {
      this.jdField_a_of_type_Int = this.mWebview.getWebScrollY();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.CommonTabFragment.HotChatWebView
 * JD-Core Version:    0.7.0.1
 */