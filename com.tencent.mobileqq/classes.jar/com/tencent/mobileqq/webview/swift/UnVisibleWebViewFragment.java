package com.tencent.mobileqq.webview.swift;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import azmj;
import badd;
import baed;
import bebw;
import beep;
import befb;
import befq;
import befr;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.webview.sonic.SonicClientImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebSettings;
import ndq;

public class UnVisibleWebViewFragment
  extends WebViewFragment
{
  private baed a;
  
  public static WebViewFragment a(Intent paramIntent)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("intent", paramIntent);
    paramIntent = new UnVisibleWebViewFragment();
    paramIntent.setArguments(localBundle);
    return paramIntent;
  }
  
  private void a(String paramString)
  {
    CookieManager.getInstance().setCookie(".docs.qq.com", "preloading_id=" + badd.a(paramString));
    CookieSyncManager.createInstance(BaseApplicationImpl.getApplication());
    CookieSyncManager.getInstance().sync();
  }
  
  public baed a(ViewGroup paramViewGroup)
  {
    boolean bool2 = false;
    if ((this.jdField_a_of_type_Befb.b & 0x40) != 0L) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.jdField_a_of_type_Baed = new baed(this.jdField_a_of_type_ComTencentCommonAppAppInterface, super.getActivity(), this, this.jdField_a_of_type_AndroidContentIntent, bool1);
      this.jdField_a_of_type_Baed.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl);
      TouchWebView localTouchWebView = this.jdField_a_of_type_Baed.a();
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl != null) {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl.bindWebView(localTouchWebView);
      }
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine.a(localTouchWebView);
      localTouchWebView.setPluginEngine(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine);
      if ((localTouchWebView instanceof SwiftReuseTouchWebView))
      {
        beep localbeep = this.jdField_a_of_type_Beep;
        bool1 = bool2;
        if (1 == ((SwiftReuseTouchWebView)localTouchWebView).a) {
          bool1 = true;
        }
        localbeep.u = bool1;
      }
      if (localTouchWebView.getX5WebViewExtension() != null) {
        this.r = true;
      }
      localTouchWebView.getView().setOnTouchListener(this);
      if (this.h) {
        localTouchWebView.setMask(true);
      }
      if (paramViewGroup != null) {
        paramViewGroup.addView(localTouchWebView);
      }
      return this.jdField_a_of_type_Baed;
    }
  }
  
  protected void e()
  {
    int i = -1;
    long l1;
    long l2;
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null)
    {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView = a(null).a();
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.getView().setOnTouchListener(this);
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.setOnLongClickListener(new bebw(this));
      l1 = System.currentTimeMillis();
      if ((this.jdField_a_of_type_Befb.a & 0x10000) == 0L) {
        break label428;
      }
      i = 2;
      if (AppSetting.f) {
        i = 2;
      }
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.getSettings().setCacheMode(i);
      if (QLog.isColorLevel()) {
        QLog.i("WebLog_WebViewFragment", 2, "setCacheMode=" + i);
      }
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.getSettings().setAllowFileAccessFromFileURLs(false);
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.getSettings().setAllowUniversalAccessFromFileURLs(false);
      l2 = System.currentTimeMillis();
      this.jdField_a_of_type_Beep.n = (l2 - l1);
      this.jdField_a_of_type_Beep.R = l2;
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewFragment", 2, "init browser, cost = " + this.jdField_a_of_type_Beep.n);
      }
      l2 = System.currentTimeMillis();
      IX5WebViewExtension localIX5WebViewExtension = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getX5WebViewExtension();
      if (localIX5WebViewExtension == null) {
        break label481;
      }
      i = 1;
      label224:
      if (i == 0) {
        break label510;
      }
      Bundle localBundle = befr.a();
      if (localBundle != null) {
        localIX5WebViewExtension.invokeMiscMethod("setDomainsAndArgumentForImageRequest", localBundle);
      }
      if (!this.jdField_a_of_type_Beep.w) {
        break label486;
      }
      l1 = 2L;
      if (!(this.jdField_a_of_type_ComTencentBizUiTouchWebView instanceof SwiftReuseTouchWebView)) {
        break label534;
      }
      if (1 != ((SwiftReuseTouchWebView)this.jdField_a_of_type_ComTencentBizUiTouchWebView).a) {
        break label505;
      }
      i = 1;
    }
    for (;;)
    {
      label291:
      if (QLog.isColorLevel()) {
        QLog.i("WebLog_WebViewFragment", 2, String.format("reportInitPerformance, initType: %d, webViewType: %d, TbsAccelerator.sCostTime: %d", new Object[] { Long.valueOf(l1), Integer.valueOf(i), Long.valueOf(befq.a) }));
      }
      System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.reportInitPerformance(l1, i, this.jdField_a_of_type_Beep.jdField_c_of_type_Long, befq.a);
      System.currentTimeMillis();
      this.jdField_a_of_type_Beep.e = 2;
      for (this.jdField_a_of_type_Beep.g = String.valueOf(QbSdk.getTbsVersion(BaseApplicationImpl.getApplication()));; this.jdField_a_of_type_Beep.g = String.valueOf(Build.VERSION.SDK_INT))
      {
        l1 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.i("WebLog_WebViewFragment", 2, "setDomainsAndArgumentForImageRequest, cost=" + (l1 - l2));
        }
        return;
        label428:
        switch (this.jdField_a_of_type_AndroidContentIntent.getIntExtra("reqType", -1))
        {
        case 2: 
        case 3: 
        default: 
          break;
        case 1: 
          i = 2;
          break;
        case 4: 
          i = 0;
          break;
          label481:
          i = 0;
          break label224;
          label486:
          if (beep.s) {}
          for (i = 1;; i = 0)
          {
            l1 = i;
            break;
          }
          label505:
          i = 0;
          break label291;
          label510:
          this.jdField_a_of_type_Beep.e = 1;
        }
      }
      label534:
      i = 0;
    }
  }
  
  public void g()
  {
    ndq.a("Web_readyToLoadUrl");
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null) {
      return;
    }
    a();
    if ((this.jdField_a_of_type_Beep.i) && (this.jdField_a_of_type_Beep.k > 0L))
    {
      azmj.b(null, "P_CliOper", "BizTechReport", "", "web", "plugin_start_time", 0, 1, (int)((System.nanoTime() - this.jdField_a_of_type_Beep.k) / 1000000L), "", "", "", "" + this.jdField_a_of_type_Beep.jdField_c_of_type_Int);
      this.jdField_a_of_type_Beep.k = 0L;
    }
    this.jdField_a_of_type_Beep.q = System.currentTimeMillis();
    long l = this.jdField_a_of_type_Beep.q;
    l = this.jdField_a_of_type_Beep.b;
    a(this.g);
    if (!TextUtils.isEmpty(this.g))
    {
      QLog.i("WebLog_WebViewFragment", 1, "tendocpreload , UnVisibleWebViewFragment  preload =" + this.jdField_a_of_type_ComTencentBizUiTouchWebView);
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl(this.g);
    }
    ndq.b("Web_readyToLoadUrl");
    this.jdField_a_of_type_Beep.a(this.jdField_a_of_type_ComTencentBizUiTouchWebView, this.g, 0, 0, 0, 0, 0, null);
  }
  
  void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "onDestroy");
    }
    beep localbeep = this.jdField_a_of_type_Beep;
    this.i = true;
    localbeep.l = true;
    if (this.jdField_a_of_type_Baed != null)
    {
      this.jdField_a_of_type_Baed.a();
      this.jdField_a_of_type_Baed = null;
      this.jdField_a_of_type_ComTencentBizUiTouchWebView = null;
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater.setVisibility(8);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.UnVisibleWebViewFragment
 * JD-Core Version:    0.7.0.1
 */