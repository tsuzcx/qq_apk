package com.tencent.mobileqq.webview.swift.component;

import com.tencent.biz.webviewplugin.Share;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.teamwork.SharePolicyInfo;
import com.tencent.mobileqq.teamwork.TeamWorkHandlerUtils;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

class SwiftBrowserShareMenuHandler$4$1
  implements Runnable
{
  SwiftBrowserShareMenuHandler$4$1(SwiftBrowserShareMenuHandler.4 param4) {}
  
  public void run()
  {
    int i = this.a.a.jdField_a_of_type_ComTencentBizWebviewpluginShare.a().a;
    String str1 = this.a.a.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getAppRuntime().getCurrentAccountUin();
    String str2 = this.a.a.jdField_a_of_type_ComTencentBizWebviewpluginShare.a().i;
    String str3 = this.a.a.jdField_a_of_type_ComTencentBizWebviewpluginShare.a().h;
    if (this.a.a.jdField_a_of_type_ComTencentBizWebviewpluginShare.a().b == 3) {
      bool = true;
    } else {
      bool = false;
    }
    boolean bool = TeamWorkHandlerUtils.a(str1, str2, str3, bool, false, 2, null, null, null);
    ThreadManager.getUIHandler().postDelayed(new SwiftBrowserShareMenuHandler.4.1.1(this, i, bool), 3000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler.4.1
 * JD-Core Version:    0.7.0.1
 */