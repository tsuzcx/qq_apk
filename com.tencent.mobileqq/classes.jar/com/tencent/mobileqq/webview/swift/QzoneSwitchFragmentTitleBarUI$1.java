package com.tencent.mobileqq.webview.swift;

import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.ui.WebViewTopTabView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QzoneSwitchFragmentTitleBarUI$1
  implements RadioGroup.OnCheckedChangeListener
{
  QzoneSwitchFragmentTitleBarUI$1(QzoneSwitchFragmentTitleBarUI paramQzoneSwitchFragmentTitleBarUI) {}
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    int i = this.a.a(paramRadioGroup);
    if (((QQBrowserActivity)this.a.a.i).oldTabSelectIndex != i)
    {
      WebViewFragment localWebViewFragment = QQBrowserActivity.switchFragment(i, (QQBrowserActivity)this.a.a.i);
      ((QQBrowserActivity)this.a.a.i).oldTabSelectIndex = i;
      if ((localWebViewFragment.getSwiftTitleUI() != null) && (localWebViewFragment.getSwiftTitleUI().N != null)) {
        localWebViewFragment.getSwiftTitleUI().N.setSelectedTab(i);
      }
    }
    EventCollector.getInstance().onCheckedChanged(paramRadioGroup, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.QzoneSwitchFragmentTitleBarUI.1
 * JD-Core Version:    0.7.0.1
 */