package com.tencent.mobileqq.webview.swift;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SwiftIphoneTitleBarUI$3
  implements View.OnClickListener
{
  SwiftIphoneTitleBarUI$3(SwiftIphoneTitleBarUI paramSwiftIphoneTitleBarUI) {}
  
  public void onClick(View paramView)
  {
    this.a.a(false, 0, 0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI.3
 * JD-Core Version:    0.7.0.1
 */