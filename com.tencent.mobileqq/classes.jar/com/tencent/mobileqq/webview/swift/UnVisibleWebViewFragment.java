package com.tencent.mobileqq.webview.swift;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import awqx;
import axfb;
import axgc;
import bazn;
import bbca;
import bbcm;
import bbdb;
import bbdc;
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
import mpw;

public class UnVisibleWebViewFragment
  extends WebViewFragment
{
  private axgc a;
  
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
    CookieManager.getInstance().setCookie(".docs.qq.com", "preloading_id=" + axfb.a(paramString));
    CookieSyncManager.createInstance(BaseApplicationImpl.getApplication());
    CookieSyncManager.getInstance().sync();
  }
  
  public axgc a(ViewGroup paramViewGroup)
  {
    boolean bool2 = false;
    if ((this.jdField_a_of_type_Bbcm.b & 0x40) != 0L) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.jdField_a_of_type_Axgc = new axgc(this.jdField_a_of_type_ComTencentCommonAppAppInterface, super.getActivity(), this, this.jdField_a_of_type_AndroidContentIntent, bool1);
      this.jdField_a_of_type_Axgc.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl);
      TouchWebView localTouchWebView = this.jdField_a_of_type_Axgc.a();
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl != null) {
        this.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl.bindWebView(localTouchWebView);
      }
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine.a(localTouchWebView);
      localTouchWebView.setPluginEngine(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine);
      if ((localTouchWebView instanceof SwiftReuseTouchWebView))
      {
        bbca localbbca = this.jdField_a_of_type_Bbca;
        bool1 = bool2;
        if (1 == ((SwiftReuseTouchWebView)localTouchWebView).a) {
          bool1 = true;
        }
        localbbca.u = bool1;
      }
      if (localTouchWebView.getX5WebViewExtension() != null) {
        this.r = true;
      }
      localTouchWebView.getView().setOnTouchListener(this);
      if (this.jdField_h_of_type_Boolean) {
        localTouchWebView.setMask(true);
      }
      if (paramViewGroup != null) {
        paramViewGroup.addView(localTouchWebView);
      }
      return this.jdField_a_of_type_Axgc;
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
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.setOnLongClickListener(new bazn(this));
      l1 = System.currentTimeMillis();
      if ((this.jdField_a_of_type_Bbcm.a & 0x10000) == 0L) {
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
      this.jdField_a_of_type_Bbca.n = (l2 - l1);
      this.jdField_a_of_type_Bbca.R = l2;
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewFragment", 2, "init browser, cost = " + this.jdField_a_of_type_Bbca.n);
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
      Bundle localBundle = bbdc.a();
      if (localBundle != null) {
        localIX5WebViewExtension.invokeMiscMethod("setDomainsAndArgumentForImageRequest", localBundle);
      }
      if (!this.jdField_a_of_type_Bbca.w) {
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
        QLog.i("WebLog_WebViewFragment", 2, String.format("reportInitPerformance, initType: %d, webViewType: %d, TbsAccelerator.sCostTime: %d", new Object[] { Long.valueOf(l1), Integer.valueOf(i), Long.valueOf(bbdb.a) }));
      }
      System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.reportInitPerformance(l1, i, this.jdField_a_of_type_Bbca.jdField_c_of_type_Long, bbdb.a);
      System.currentTimeMillis();
      this.jdField_a_of_type_Bbca.e = 2;
      for (this.jdField_a_of_type_Bbca.g = String.valueOf(QbSdk.getTbsVersion(BaseApplicationImpl.getApplication()));; this.jdField_a_of_type_Bbca.g = String.valueOf(Build.VERSION.SDK_INT))
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
          if (bbca.s) {}
          for (i = 1;; i = 0)
          {
            l1 = i;
            break;
          }
          label505:
          i = 0;
          break label291;
          label510:
          this.jdField_a_of_type_Bbca.e = 1;
        }
      }
      label534:
      i = 0;
    }
  }
  
  public void g()
  {
    mpw.a("Web_readyToLoadUrl");
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView == null) {
      return;
    }
    a();
    if ((this.jdField_a_of_type_Bbca.i) && (this.jdField_a_of_type_Bbca.k > 0L))
    {
      awqx.b(null, "P_CliOper", "BizTechReport", "", "web", "plugin_start_time", 0, 1, (int)((System.nanoTime() - this.jdField_a_of_type_Bbca.k) / 1000000L), "", "", "", "" + this.jdField_a_of_type_Bbca.jdField_c_of_type_Int);
      this.jdField_a_of_type_Bbca.k = 0L;
    }
    this.jdField_a_of_type_Bbca.q = System.currentTimeMillis();
    long l = this.jdField_a_of_type_Bbca.q;
    l = this.jdField_a_of_type_Bbca.b;
    a(this.jdField_h_of_type_JavaLangString);
    if (!TextUtils.isEmpty(this.jdField_h_of_type_JavaLangString))
    {
      QLog.i("WebLog_WebViewFragment", 1, "tendocpreload , UnVisibleWebViewFragment  preload =" + this.jdField_a_of_type_ComTencentBizUiTouchWebView);
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl(this.jdField_h_of_type_JavaLangString);
    }
    mpw.b("Web_readyToLoadUrl");
    this.jdField_a_of_type_Bbca.a(this.jdField_a_of_type_ComTencentBizUiTouchWebView, this.jdField_h_of_type_JavaLangString, 0, 0, 0, 0, 0, null);
  }
  
  void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "onDestroy");
    }
    bbca localbbca = this.jdField_a_of_type_Bbca;
    this.i = true;
    localbbca.l = true;
    if (this.jdField_a_of_type_Axgc != null)
    {
      this.jdField_a_of_type_Axgc.a();
      this.jdField_a_of_type_Axgc = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.UnVisibleWebViewFragment
 * JD-Core Version:    0.7.0.1
 */