package com.tencent.mobileqq.webview.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class WebViewTitlerBar$2
  implements View.OnClickListener
{
  WebViewTitlerBar$2(WebViewTitlerBar paramWebViewTitlerBar) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_ComTencentBizPubaccountCustomWebView != null) {
      this.a.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.callJs(this.a.jdField_a_of_type_JavaLangString, new String[] { "" });
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.ui.WebViewTitlerBar.2
 * JD-Core Version:    0.7.0.1
 */