package com.tencent.mobileqq.webview.swift.component;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;
import com.tencent.mobileqq.troop.troopapps.api.TroopAppObserver;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebTitleBarInterface;
import com.tencent.mobileqq.widget.QQToast;

class SwiftBrowserShareMenuHandler$2
  implements ITroopMemberApiClientApi.Callback
{
  SwiftBrowserShareMenuHandler$2(SwiftBrowserShareMenuHandler paramSwiftBrowserShareMenuHandler) {}
  
  public void callback(Bundle paramBundle)
  {
    if (paramBundle.getInt("type") == TroopAppObserver.b)
    {
      boolean bool = paramBundle.getBoolean("isSuccess");
      if ((this.a.jdField_a_of_type_AndroidAppActivity.isFinishing()) && (this.a.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.isDestroyed())) {
        return;
      }
      if (Boolean.valueOf(bool).booleanValue())
      {
        QQToast.a(BaseApplicationImpl.getApplication(), 2, 2131719766, 0).b(this.a.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getWebTitleBarInterface().a());
        return;
      }
      QQToast.a(BaseApplicationImpl.getApplication(), 1, 2131719763, 0).b(this.a.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewFragment.getWebTitleBarInterface().a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler.2
 * JD-Core Version:    0.7.0.1
 */