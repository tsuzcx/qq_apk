package com.tencent.mobileqq.webview.swift.component;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.service.troop.TroopNotificationConstants;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.widget.QQToast;

class SwiftBrowserShareMenuHandler$2
  implements TroopMemberApiClient.Callback
{
  SwiftBrowserShareMenuHandler$2(SwiftBrowserShareMenuHandler paramSwiftBrowserShareMenuHandler) {}
  
  public void callback(Bundle paramBundle)
  {
    boolean bool;
    if (paramBundle.getInt("type") == TroopNotificationConstants.av)
    {
      bool = paramBundle.getBoolean("isSuccess");
      if ((!this.a.jdField_a_of_type_AndroidAppActivity.isFinishing()) || (!this.a.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.isDestroyed)) {}
    }
    else
    {
      return;
    }
    if (Boolean.valueOf(bool).booleanValue())
    {
      QQToast.a(BaseApplicationImpl.getApplication(), 2, 2131720034, 0).b(this.a.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getTitleBarHeight());
      return;
    }
    QQToast.a(BaseApplicationImpl.getApplication(), 1, 2131720031, 0).b(this.a.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler.2
 * JD-Core Version:    0.7.0.1
 */