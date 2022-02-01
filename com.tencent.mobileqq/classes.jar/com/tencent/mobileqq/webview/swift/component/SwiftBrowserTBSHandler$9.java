package com.tencent.mobileqq.webview.swift.component;

import android.text.TextUtils;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.utils.SwiftOfflineDataUtils;
import com.tencent.mobileqq.webview.swift.utils.SwiftOfflineDataUtils.OfflineData;
import com.tencent.smtt.sdk.QbSdk;

class SwiftBrowserTBSHandler$9
  implements Runnable
{
  SwiftBrowserTBSHandler$9(SwiftBrowserTBSHandler paramSwiftBrowserTBSHandler, String paramString) {}
  
  public void run()
  {
    if (QbSdk.getTbsVersion(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity) >= 43810)
    {
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (SwiftOfflineDataUtils.a(this.a))
      {
        SwiftOfflineDataUtils.OfflineData localOfflineData = SwiftOfflineDataUtils.a(this.a);
        localObject1 = localObject2;
        if (localOfflineData != null) {
          localObject1 = localOfflineData.b;
        }
      }
      if (!TextUtils.isEmpty(this.a)) {
        SwiftBrowserTBSHandler.a(this.this$0.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.webView, this.a, (String)localObject1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserTBSHandler.9
 * JD-Core Version:    0.7.0.1
 */