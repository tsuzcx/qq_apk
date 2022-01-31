package com.tencent.mobileqq.webview.swift.component;

import axdv;
import axfb;
import bbbt;
import bbbw;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import mqq.os.MqqHandler;
import xdt;

public class SwiftBrowserShareMenuHandler$5$1
  implements Runnable
{
  public SwiftBrowserShareMenuHandler$5$1(bbbw parambbbw) {}
  
  public void run()
  {
    int i = this.a.a.jdField_a_of_type_Xdt.a().a;
    String str1 = this.a.a.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.a.getCurrentAccountUin();
    String str2 = this.a.a.jdField_a_of_type_Xdt.a().i;
    String str3 = this.a.a.jdField_a_of_type_Xdt.a().h;
    if (this.a.a.jdField_a_of_type_Xdt.a().b == 3) {}
    for (boolean bool = true;; bool = false)
    {
      bool = axfb.a(str1, str2, str3, bool, false, 2, null, null, null);
      ThreadManager.getUIHandler().postDelayed(new SwiftBrowserShareMenuHandler.5.1.1(this, i, bool), 3000L);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler.5.1
 * JD-Core Version:    0.7.0.1
 */