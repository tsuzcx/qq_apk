package com.tencent.mobileqq.webview.build;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class WebViewBaseBuilder$1
  implements View.OnClickListener
{
  WebViewBaseBuilder$1(WebViewBaseBuilder paramWebViewBaseBuilder) {}
  
  public void onClick(View paramView)
  {
    this.a.mInActivity.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.build.WebViewBaseBuilder.1
 * JD-Core Version:    0.7.0.1
 */