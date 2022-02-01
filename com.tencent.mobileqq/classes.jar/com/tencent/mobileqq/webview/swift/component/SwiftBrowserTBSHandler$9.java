package com.tencent.mobileqq.webview.swift.component;

import android.text.TextUtils;
import com.tencent.mobileqq.webview.swift.utils.SwiftOfflineDataUtils;
import com.tencent.mobileqq.webview.swift.utils.SwiftOfflineDataUtils.OfflineData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebView;

final class SwiftBrowserTBSHandler$9
  implements Runnable
{
  SwiftBrowserTBSHandler$9(String paramString, WebView paramWebView) {}
  
  public void run()
  {
    if (QbSdk.getTbsVersion(BaseApplication.getContext()) >= 43810)
    {
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (SwiftOfflineDataUtils.a(this.a))
      {
        SwiftOfflineDataUtils.OfflineData localOfflineData = SwiftOfflineDataUtils.b(this.a);
        localObject1 = localObject2;
        if (localOfflineData != null) {
          localObject1 = localOfflineData.b;
        }
      }
      if (!TextUtils.isEmpty(this.a)) {
        SwiftBrowserTBSHandler.a(this.b, this.a, (String)localObject1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserTBSHandler.9
 * JD-Core Version:    0.7.0.1
 */