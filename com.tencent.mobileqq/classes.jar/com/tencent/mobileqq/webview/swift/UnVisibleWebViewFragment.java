package com.tencent.mobileqq.webview.swift;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import bdll;
import bebl;
import becl;
import bioc;
import biqx;
import birj;
import biry;
import birz;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.webview.sonic.SonicClientImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebSettings;
import noe;

public class UnVisibleWebViewFragment
  extends WebViewFragment
{
  private becl a;
  
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
    CookieManager.getInstance().setCookie(".docs.qq.com", "preloading_id=" + bebl.a(paramString));
    CookieSyncManager.createInstance(BaseApplicationImpl.getApplication());
    CookieSyncManager.getInstance().sync();
  }
  
  public becl a(ViewGroup paramViewGroup)
  {
    boolean bool2 = false;
    if ((this.mUIStyle.b & 0x40) != 0L) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.a = new becl(this.mApp, super.getActivity(), this, this.intent, bool1);
      this.a.a(this.sonicClient);
      TouchWebView localTouchWebView = this.a.a();
      if (this.sonicClient != null) {
        this.sonicClient.bindWebView(localTouchWebView);
      }
      this.mPluginEngine.a(localTouchWebView);
      localTouchWebView.setPluginEngine(this.mPluginEngine);
      if ((localTouchWebView instanceof SwiftReuseTouchWebView))
      {
        biqx localbiqx = this.mStatistics;
        bool1 = bool2;
        if (1 == ((SwiftReuseTouchWebView)localTouchWebView).b) {
          bool1 = true;
        }
        localbiqx.u = bool1;
      }
      if (localTouchWebView.getX5WebViewExtension() != null) {
        this.mX5CoreActive = true;
      }
      localTouchWebView.getView().setOnTouchListener(this);
      if (this.mNightMode) {
        localTouchWebView.setMask(true);
      }
      if (paramViewGroup != null) {
        paramViewGroup.addView(localTouchWebView);
      }
      return this.a;
    }
  }
  
  void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "onDestroy");
    }
    biqx localbiqx = this.mStatistics;
    this.isDestroyed = true;
    localbiqx.l = true;
    if (this.a != null)
    {
      this.a.a();
      this.a = null;
      this.webView = null;
    }
    this.mApp = null;
  }
  
  protected void initWebView()
  {
    int i = -1;
    long l1;
    long l2;
    if (this.webView == null)
    {
      this.webView = a(null).a();
      this.webView.getView().setOnTouchListener(this);
      this.webView.setOnLongClickListener(new bioc(this));
      l1 = System.currentTimeMillis();
      if ((this.mUIStyle.a & 0x10000) == 0L) {
        break label429;
      }
      i = 2;
      if (AppSetting.f) {
        i = 2;
      }
      this.webView.getSettings().setCacheMode(i);
      if (QLog.isColorLevel()) {
        QLog.i("WebLog_WebViewFragment", 2, "setCacheMode=" + i);
      }
      this.webView.getSettings().setAllowFileAccessFromFileURLs(false);
      this.webView.getSettings().setAllowUniversalAccessFromFileURLs(false);
      l2 = System.currentTimeMillis();
      this.mStatistics.n = (l2 - l1);
      this.mStatistics.R = l2;
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewFragment", 2, "init browser, cost = " + this.mStatistics.n);
      }
      l2 = System.currentTimeMillis();
      IX5WebViewExtension localIX5WebViewExtension = this.webView.getX5WebViewExtension();
      if (localIX5WebViewExtension == null) {
        break label485;
      }
      i = 1;
      label225:
      if (i == 0) {
        break label514;
      }
      Bundle localBundle = birz.a();
      if (localBundle != null) {
        localIX5WebViewExtension.invokeMiscMethod("setDomainsAndArgumentForImageRequest", localBundle);
      }
      if (!this.mStatistics.w) {
        break label490;
      }
      l1 = 2L;
      if (!(this.webView instanceof SwiftReuseTouchWebView)) {
        break label538;
      }
      if (1 != ((SwiftReuseTouchWebView)this.webView).b) {
        break label509;
      }
      i = 1;
    }
    for (;;)
    {
      label292:
      if (QLog.isColorLevel()) {
        QLog.i("WebLog_WebViewFragment", 2, String.format("reportInitPerformance, initType: %d, webViewType: %d, TbsAccelerator.sCostTime: %d", new Object[] { Long.valueOf(l1), Integer.valueOf(i), Long.valueOf(biry.a) }));
      }
      System.currentTimeMillis();
      this.webView.reportInitPerformance(l1, i, this.mStatistics.jdField_c_of_type_Long, biry.a);
      System.currentTimeMillis();
      this.mStatistics.e = 2;
      label514:
      for (this.mStatistics.g = String.valueOf(QbSdk.getTbsVersion(BaseApplicationImpl.getApplication()));; this.mStatistics.g = String.valueOf(Build.VERSION.SDK_INT))
      {
        l1 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.i("WebLog_WebViewFragment", 2, "setDomainsAndArgumentForImageRequest, cost=" + (l1 - l2));
        }
        return;
        label429:
        switch (this.intent.getIntExtra("reqType", -1))
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
          label485:
          i = 0;
          break label225;
          label490:
          if (biqx.s) {}
          for (i = 1;; i = 0)
          {
            l1 = i;
            break;
          }
          label509:
          i = 0;
          break label292;
          this.mStatistics.e = 1;
        }
      }
      label538:
      i = 0;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater.setVisibility(8);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    a();
  }
  
  public void startLoadUrl()
  {
    noe.a("Web_readyToLoadUrl");
    if (this.webView == null) {
      return;
    }
    initFinish();
    if ((this.mStatistics.i) && (this.mStatistics.k > 0L))
    {
      bdll.b(null, "P_CliOper", "BizTechReport", "", "web", "plugin_start_time", 0, 1, (int)((System.nanoTime() - this.mStatistics.k) / 1000000L), "", "", "", "" + this.mStatistics.jdField_c_of_type_Int);
      this.mStatistics.k = 0L;
    }
    this.mStatistics.q = System.currentTimeMillis();
    long l = this.mStatistics.q;
    l = this.mStatistics.b;
    a(this.mUrl);
    if (!TextUtils.isEmpty(this.mUrl))
    {
      QLog.i("WebLog_WebViewFragment", 1, "tendocpreload , UnVisibleWebViewFragment  preload =" + this.webView);
      this.webView.loadUrl(this.mUrl);
    }
    noe.b("Web_readyToLoadUrl");
    this.mStatistics.a(this.webView, this.mUrl, 0, 0, 0, 0, 0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.UnVisibleWebViewFragment
 * JD-Core Version:    0.7.0.1
 */