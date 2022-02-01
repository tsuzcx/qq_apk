package com.tencent.mobileqq.webview.swift.component;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SwiftBrowserTBSHandler$6
  implements View.OnClickListener
{
  SwiftBrowserTBSHandler$6(SwiftBrowserTBSHandler paramSwiftBrowserTBSHandler) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a != null) {
      this.a.a.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserTBSHandler.6
 * JD-Core Version:    0.7.0.1
 */