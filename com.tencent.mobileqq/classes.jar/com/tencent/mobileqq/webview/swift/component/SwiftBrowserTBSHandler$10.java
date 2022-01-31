package com.tencent.mobileqq.webview.swift.component;

import android.text.TextUtils;
import bcfs;
import bcgl;
import bcgm;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.smtt.sdk.QbSdk;

public class SwiftBrowserTBSHandler$10
  implements Runnable
{
  public SwiftBrowserTBSHandler$10(bcfs parambcfs, String paramString) {}
  
  public void run()
  {
    if (QbSdk.getTbsVersion(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity) >= 43810)
    {
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (bcgl.a(this.a))
      {
        bcgm localbcgm = bcgl.a(this.a);
        localObject1 = localObject2;
        if (localbcgm != null) {
          localObject1 = localbcgm.b;
        }
      }
      if (!TextUtils.isEmpty(this.a)) {
        bcfs.a(this.this$0.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.a, this.a, (String)localObject1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserTBSHandler.10
 * JD-Core Version:    0.7.0.1
 */