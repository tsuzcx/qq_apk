package com.tencent.mobileqq.webview.swift.component;

import android.text.TextUtils;
import bihz;
import biio;
import biip;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.smtt.sdk.QbSdk;

public class SwiftBrowserTBSHandler$9
  implements Runnable
{
  public SwiftBrowserTBSHandler$9(bihz parambihz, String paramString) {}
  
  public void run()
  {
    if (QbSdk.getTbsVersion(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity) >= 43810)
    {
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (biio.a(this.a))
      {
        biip localbiip = biio.a(this.a);
        localObject1 = localObject2;
        if (localbiip != null) {
          localObject1 = localbiip.b;
        }
      }
      if (!TextUtils.isEmpty(this.a)) {
        bihz.a(this.this$0.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.webView, this.a, (String)localObject1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserTBSHandler.9
 * JD-Core Version:    0.7.0.1
 */