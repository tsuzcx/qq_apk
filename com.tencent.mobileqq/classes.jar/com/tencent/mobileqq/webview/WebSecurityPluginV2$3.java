package com.tencent.mobileqq.webview;

import com.tencent.biz.SoftKeyboardObserver.OnSoftKeyboardToggledListener;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebTitleBarInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebViewProviderInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

class WebSecurityPluginV2$3
  implements SoftKeyboardObserver.OnSoftKeyboardToggledListener
{
  WebSecurityPluginV2$3(WebSecurityPluginV2 paramWebSecurityPluginV2, CustomWebView paramCustomWebView) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWebviewWebSecurityPluginV2.mRuntime.a();
    if (paramBoolean)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWebviewWebSecurityPluginV2.mRuntime.a() != null) && (!this.jdField_a_of_type_ComTencentMobileqqWebviewWebSecurityPluginV2.mRuntime.a().isLogin()) && (WebSecurityPluginV2.a(this.jdField_a_of_type_ComTencentMobileqqWebviewWebSecurityPluginV2, this.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.getUrl())))
      {
        if (QLog.isColorLevel()) {
          QLog.d("WebSecurityPluginV2", 2, new Object[] { "not login and url in whiteList, mShouldShowInputWarning=", Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqWebviewWebSecurityPluginV2.a) });
        }
        this.jdField_a_of_type_ComTencentMobileqqWebviewWebSecurityPluginV2.a = false;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewWebSecurityPluginV2.a) {
        if ((localObject != null) && (((WebUiUtils.WebViewProviderInterface)localObject).getWebTitleBarInterface() != null))
        {
          ((WebUiUtils.WebViewProviderInterface)localObject).getWebTitleBarInterface().a(true, 1, 2131691458);
        }
        else
        {
          localObject = QQToast.a(BaseApplicationImpl.getContext(), 1, 2131691458, 1);
          ((QQToast)localObject).b(((QQToast)localObject).b());
        }
      }
      WebSecurityPluginV2.a(this.jdField_a_of_type_ComTencentMobileqqWebviewWebSecurityPluginV2);
      return;
    }
    if ((localObject != null) && (((WebUiUtils.WebViewProviderInterface)localObject).getWebTitleBarInterface() != null)) {
      ((WebUiUtils.WebViewProviderInterface)localObject).getWebTitleBarInterface().a(false, 0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.WebSecurityPluginV2.3
 * JD-Core Version:    0.7.0.1
 */