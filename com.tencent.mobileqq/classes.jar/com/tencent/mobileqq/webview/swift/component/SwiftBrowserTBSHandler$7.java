package com.tencent.mobileqq.webview.swift.component;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

class SwiftBrowserTBSHandler$7
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    if (this.a.f != null) {
      this.a.f.dismiss();
    }
    this.a.d.sendMessage(this.a.d.obtainMessage(102));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserTBSHandler.7
 * JD-Core Version:    0.7.0.1
 */