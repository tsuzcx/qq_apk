package com.tencent.mobileqq.webview.swift.component;

import aasr;
import beau;
import becb;
import biho;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment;
import com.tencent.mobileqq.webview.swift.WebViewFragment;

public class SwiftBrowserShareMenuHandler$1
  implements Runnable
{
  public SwiftBrowserShareMenuHandler$1(biho parambiho, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void run()
  {
    int j = 1;
    int k = this.this$0.jdField_a_of_type_Aasr.a().a;
    String str1;
    boolean bool;
    if (this.this$0.jdField_a_of_type_Aasr.a().a == 0)
    {
      str1 = this.this$0.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.mApp.getCurrentAccountUin();
      String str2 = this.this$0.jdField_a_of_type_Aasr.a().i;
      String str3 = this.this$0.jdField_a_of_type_Aasr.a().h;
      if (this.this$0.jdField_a_of_type_Aasr.a().b == 3)
      {
        bool = true;
        if (becb.a(str1, str2, str3, bool, false, 1, null, null, null)) {
          break label241;
        }
      }
    }
    label241:
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        str1 = becb.a(this.this$0.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.mApp.getCurrentAccountUin(), this.this$0.jdField_a_of_type_Aasr.a());
        this.this$0.jdField_a_of_type_Aasr.a().l = str1;
        if (str1 != null) {
          i = j;
        }
      }
      for (;;)
      {
        biho.a(this.this$0, this.a, this.b, this.c, this.d);
        if ((i != 0) && ((this.this$0.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment instanceof TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment))) {
          ((TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment)this.this$0.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment).c(k);
        }
        return;
        bool = false;
        break;
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler.1
 * JD-Core Version:    0.7.0.1
 */