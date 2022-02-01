package com.tencent.mobileqq.webview.swift.component;

import abgu;
import beae;
import bebl;
import biqq;
import biqt;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import mqq.os.MqqHandler;

public class SwiftBrowserShareMenuHandler$4$1
  implements Runnable
{
  public SwiftBrowserShareMenuHandler$4$1(biqt parambiqt) {}
  
  public void run()
  {
    int i = this.a.a.jdField_a_of_type_Abgu.a().a;
    String str1 = this.a.a.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.mApp.getCurrentAccountUin();
    String str2 = this.a.a.jdField_a_of_type_Abgu.a().i;
    String str3 = this.a.a.jdField_a_of_type_Abgu.a().h;
    if (this.a.a.jdField_a_of_type_Abgu.a().b == 3) {}
    for (boolean bool = true;; bool = false)
    {
      bool = bebl.a(str1, str2, str3, bool, false, 2, null, null, null);
      ThreadManager.getUIHandler().postDelayed(new SwiftBrowserShareMenuHandler.4.1.1(this, i, bool), 3000L);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler.4.1
 * JD-Core Version:    0.7.0.1
 */