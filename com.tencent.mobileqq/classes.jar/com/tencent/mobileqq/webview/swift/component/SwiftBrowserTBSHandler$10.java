package com.tencent.mobileqq.webview.swift.component;

import android.text.TextUtils;
import beet;
import befm;
import befn;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.smtt.sdk.QbSdk;

public class SwiftBrowserTBSHandler$10
  implements Runnable
{
  public SwiftBrowserTBSHandler$10(beet parambeet, String paramString) {}
  
  public void run()
  {
    if (QbSdk.getTbsVersion(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity) >= 43810)
    {
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (befm.a(this.a))
      {
        befn localbefn = befm.a(this.a);
        localObject1 = localObject2;
        if (localbefn != null) {
          localObject1 = localbefn.b;
        }
      }
      if (!TextUtils.isEmpty(this.a)) {
        beet.a(this.this$0.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.a, this.a, (String)localObject1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserTBSHandler.10
 * JD-Core Version:    0.7.0.1
 */