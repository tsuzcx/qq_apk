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
      if (SwiftOfflineDataUtils.a(this.jdField_a_of_type_JavaLangString))
      {
        SwiftOfflineDataUtils.OfflineData localOfflineData = SwiftOfflineDataUtils.a(this.jdField_a_of_type_JavaLangString);
        localObject1 = localObject2;
        if (localOfflineData != null) {
          localObject1 = localOfflineData.b;
        }
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        SwiftBrowserTBSHandler.a(this.jdField_a_of_type_ComTencentSmttSdkWebView, this.jdField_a_of_type_JavaLangString, (String)localObject1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserTBSHandler.9
 * JD-Core Version:    0.7.0.1
 */