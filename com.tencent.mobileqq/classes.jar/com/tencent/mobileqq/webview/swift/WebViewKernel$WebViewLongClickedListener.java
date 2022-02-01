package com.tencent.mobileqq.webview.swift;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webprocess.temp.api.IWebviewApi;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider.SwiftBrowserComponent;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserSetting;
import com.tencent.qphone.base.util.QLog;

class WebViewKernel$WebViewLongClickedListener
  implements View.OnLongClickListener
{
  private WebViewKernel$WebViewLongClickedListener(WebViewKernel paramWebViewKernel) {}
  
  public boolean onLongClick(View paramView)
  {
    if (!WebViewKernel.a(this.a).a("web_view_long_click", true))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("WebViewKernel", 1, "disable long click on current url!");
      }
      return true;
    }
    if (!WebViewKernel.a(this.a).a("image_long_click", false))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("WebViewKernel", 1, "disable image long click on current url!");
      }
      return false;
    }
    SwiftBrowserComponentsProvider.SwiftBrowserComponent localSwiftBrowserComponent = (SwiftBrowserComponentsProvider.SwiftBrowserComponent)WebViewKernel.a(this.a).getComponentProvider().a(8);
    return ((IWebviewApi)QRoute.api(IWebviewApi.class)).shouldOverrideLongClick(paramView, localSwiftBrowserComponent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.WebViewKernel.WebViewLongClickedListener
 * JD-Core Version:    0.7.0.1
 */