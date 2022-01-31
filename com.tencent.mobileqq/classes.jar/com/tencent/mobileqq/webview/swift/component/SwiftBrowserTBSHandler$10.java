package com.tencent.mobileqq.webview.swift.component;

import android.text.TextUtils;
import bcfe;
import bcfx;
import bcfy;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.smtt.sdk.QbSdk;

public class SwiftBrowserTBSHandler$10
  implements Runnable
{
  public SwiftBrowserTBSHandler$10(bcfe parambcfe, String paramString) {}
  
  public void run()
  {
    if (QbSdk.getTbsVersion(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity) >= 43810)
    {
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (bcfx.a(this.a))
      {
        bcfy localbcfy = bcfx.a(this.a);
        localObject1 = localObject2;
        if (localbcfy != null) {
          localObject1 = localbcfy.b;
        }
      }
      if (!TextUtils.isEmpty(this.a)) {
        bcfe.a(this.this$0.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.a, this.a, (String)localObject1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserTBSHandler.10
 * JD-Core Version:    0.7.0.1
 */