package com.tencent.mobileqq.webview.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class WebViewTitlerBar$1
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    if (this.a.j != null) {
      this.a.j.callJs(this.a.i, new String[] { "" });
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.ui.WebViewTitlerBar.1
 * JD-Core Version:    0.7.0.1
 */