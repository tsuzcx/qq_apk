package com.tencent.mobileqq.webview.swift;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserLongClickHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserSetting;
import com.tencent.qphone.base.util.QLog;

class UnVisibleWebViewFragment$WebViewLongClickedListener
  implements View.OnLongClickListener
{
  UnVisibleWebViewFragment$WebViewLongClickedListener(UnVisibleWebViewFragment paramUnVisibleWebViewFragment) {}
  
  public boolean onLongClick(View paramView)
  {
    if (!this.a.mSetting.a("web_view_long_click", true))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("WebLog_WebViewFragment", 1, "disable long click on current url!");
      }
      return true;
    }
    if (!this.a.mSetting.a("image_long_click", false))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("WebLog_WebViewFragment", 1, "disable image long click on current url!");
      }
      return false;
    }
    SwiftBrowserLongClickHandler localSwiftBrowserLongClickHandler = (SwiftBrowserLongClickHandler)this.a.mComponentsProvider.a(8);
    if ((localSwiftBrowserLongClickHandler != null) && (localSwiftBrowserLongClickHandler.a(paramView))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.UnVisibleWebViewFragment.WebViewLongClickedListener
 * JD-Core Version:    0.7.0.1
 */