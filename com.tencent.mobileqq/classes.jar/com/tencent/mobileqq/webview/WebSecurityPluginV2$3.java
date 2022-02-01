package com.tencent.mobileqq.webview;

import com.tencent.biz.SoftKeyboardObserver.OnSoftKeyboardToggledListener;
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
  WebSecurityPluginV2$3(WebSecurityPluginV2 paramWebSecurityPluginV2) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    Object localObject = this.a.mRuntime.e();
    if (paramBoolean)
    {
      if ((this.a.mRuntime.c() != null) && (!this.a.mRuntime.c().isLogin()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("WebSecurityPluginV2", 2, new Object[] { "not login and url in whiteList, mShouldShowInputWarning=", Boolean.valueOf(this.a.c) });
        }
        this.a.c = false;
      }
      if (this.a.c) {
        if ((localObject != null) && (((WebUiUtils.WebViewProviderInterface)localObject).getWebTitleBarInterface() != null))
        {
          ((WebUiUtils.WebViewProviderInterface)localObject).getWebTitleBarInterface().a(true, 1, 2131888416);
        }
        else
        {
          localObject = QQToast.makeText(BaseApplicationImpl.getContext(), 1, 2131888416, 1);
          ((QQToast)localObject).show(((QQToast)localObject).getTitleBarHeight());
        }
      }
      WebSecurityPluginV2.a(this.a);
      return;
    }
    if ((localObject != null) && (((WebUiUtils.WebViewProviderInterface)localObject).getWebTitleBarInterface() != null)) {
      ((WebUiUtils.WebViewProviderInterface)localObject).getWebTitleBarInterface().a(false, 0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.WebSecurityPluginV2.3
 * JD-Core Version:    0.7.0.1
 */