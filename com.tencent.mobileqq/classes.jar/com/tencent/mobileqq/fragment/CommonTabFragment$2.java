package com.tencent.mobileqq.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;

class CommonTabFragment$2
  implements View.OnClickListener
{
  CommonTabFragment$2(CommonTabFragment paramCommonTabFragment) {}
  
  public void onClick(View paramView)
  {
    if (this.a.b != null)
    {
      if (this.a.b.mWebview == null) {
        return;
      }
      paramView = this.a.b.mWebview.getPluginEngine();
      if (paramView != null) {
        paramView.a(this.a.b.mWebview.getUrl(), 8589934606L, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.CommonTabFragment.2
 * JD-Core Version:    0.7.0.1
 */