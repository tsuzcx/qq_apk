package com.tencent.mobileqq.jsp;

import com.tencent.mobileqq.webview.swift.component.SwiftBrowserTBSHandler;
import com.tencent.mobileqq.webview.swift.utils.SwiftOfflineDataUtils;
import com.tencent.mobileqq.webview.swift.utils.SwiftOfflineDataUtils.OfflineData;
import com.tencent.smtt.sdk.WebView;

class X5ApiPlugin$1
  implements Runnable
{
  X5ApiPlugin$1(X5ApiPlugin paramX5ApiPlugin, X5ApiPlugin.PreloadTask paramPreloadTask, WebView paramWebView) {}
  
  public void run()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (SwiftOfflineDataUtils.a(this.jdField_a_of_type_ComTencentMobileqqJspX5ApiPlugin$PreloadTask.a))
    {
      SwiftOfflineDataUtils.OfflineData localOfflineData = SwiftOfflineDataUtils.a(this.jdField_a_of_type_ComTencentMobileqqJspX5ApiPlugin$PreloadTask.a);
      localObject1 = localObject2;
      if (localOfflineData != null) {
        localObject1 = localOfflineData.b;
      }
    }
    SwiftBrowserTBSHandler.a(this.jdField_a_of_type_ComTencentSmttSdkWebView, this.jdField_a_of_type_ComTencentMobileqqJspX5ApiPlugin$PreloadTask.a, (String)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.X5ApiPlugin.1
 * JD-Core Version:    0.7.0.1
 */