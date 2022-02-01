package com.tencent.mobileqq.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class CommonTabFragment$2
  implements View.OnClickListener
{
  CommonTabFragment$2(CommonTabFragment paramCommonTabFragment) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.a == null) || (this.a.a.mWebview == null)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      WebViewPluginEngine localWebViewPluginEngine = this.a.a.mWebview.getPluginEngine();
      if (localWebViewPluginEngine != null) {
        localWebViewPluginEngine.a(this.a.a.mWebview.getUrl(), 8589934606L, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.CommonTabFragment.2
 * JD-Core Version:    0.7.0.1
 */