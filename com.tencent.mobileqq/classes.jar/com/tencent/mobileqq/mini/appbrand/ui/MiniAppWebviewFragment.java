package com.tencent.mobileqq.mini.appbrand.ui;

import android.content.Intent;
import android.text.TextUtils;
import bdll;
import bhnh;
import biqx;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import noe;

public class MiniAppWebviewFragment
  extends WebViewFragment
{
  public static final String KEY_HEADER = "key_header";
  public static final String KEY_URL_BLACK_LIST = "key_url_black_list";
  private final String TAG = "MiniAppWebviewFragment";
  
  private boolean isBlackPrefixUrl(String paramString, ArrayList<String> paramArrayList)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramArrayList == null) || (paramArrayList.size() == 0)) {
      return false;
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      if (paramString.toLowerCase().startsWith(str.toLowerCase())) {
        return true;
      }
    }
    return false;
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if ((this.isDestroyed) || (this.webView == null)) {
      return true;
    }
    if (isBlackPrefixUrl(paramString, getIntent().getStringArrayListExtra("key_url_black_list")))
    {
      this.webView.loadUrl("file:///android_asset/error.html");
      QLog.d("MiniAppWebviewFragment", 1, new Object[] { "url:", this.mUrl, "in black" });
      return true;
    }
    return super.shouldOverrideUrlLoading(this.webView, paramString);
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
      bdll.b(null, "P_CliOper", "BizTechReport", "", "web", "plugin_start_time", 0, 1, (int)((System.nanoTime() - this.mStatistics.k) / 1000000L), "", "", "", "" + this.mStatistics.c);
      this.mStatistics.k = 0L;
    }
    this.mStatistics.q = System.currentTimeMillis();
    long l = this.mStatistics.q;
    l = this.mStatistics.b;
    Object localObject = getIntent().getStringArrayListExtra("key_url_black_list");
    if ((bhnh.a().a(this.mUrl)) || (isBlackPrefixUrl(this.mUrl, (ArrayList)localObject)))
    {
      this.webView.loadUrl("file:///android_asset/error.html");
      QLog.d("MiniAppWebviewFragment", 1, new Object[] { "url:", this.mUrl, "in black" });
    }
    for (;;)
    {
      noe.b("Web_readyToLoadUrl");
      this.mStatistics.a(this.webView, this.mUrl, 0, 0, 0, 0, 0, null);
      return;
      if (getIntent().hasExtra("key_header")) {}
      for (localObject = (HashMap)getIntent().getSerializableExtra("key_header");; localObject = null)
      {
        if (TextUtils.isEmpty(this.mUrl)) {
          break label298;
        }
        if ((localObject == null) || (((HashMap)localObject).size() <= 0)) {
          break label300;
        }
        this.webView.loadUrl(this.mUrl, (Map)localObject);
        break;
      }
      label298:
      continue;
      label300:
      this.webView.loadUrl(this.mUrl);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.MiniAppWebviewFragment
 * JD-Core Version:    0.7.0.1
 */