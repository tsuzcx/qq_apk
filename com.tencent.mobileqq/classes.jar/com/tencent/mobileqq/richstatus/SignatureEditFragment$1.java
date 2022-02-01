package com.tencent.mobileqq.richstatus;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserSetting;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.proxy.WebKernelCallBackProxy;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebTitleBarInterface;
import com.tencent.mobileqq.widget.WebViewProgressBarController;
import mqq.app.AppRuntime;

class SignatureEditFragment$1
  extends WebKernelCallBackProxy
{
  SignatureEditFragment$1(SignatureEditFragment paramSignatureEditFragment, WebViewKernelCallBack paramWebViewKernelCallBack)
  {
    super(paramWebViewKernelCallBack);
  }
  
  public void onFinalState(Bundle paramBundle)
  {
    super.onFinalState(paramBundle);
    this.a.getSwiftTitleUI().o.setVisibility(8);
    if (this.a.getWebTitleBarInterface().l() != null) {
      this.a.getWebTitleBarInterface().l().setVisibility(8);
    }
    paramBundle = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
    Object localObject = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a.getAppRuntime().getCurrentAccountUin());
    localStringBuilder.append("_sign_edit_red_dot_key");
    SignatureEditFragment.a((SignatureEditFragment)localObject, paramBundle.getInt(localStringBuilder.toString(), 0));
    if (SignatureEditFragment.a(this.a) > 0) {
      SignatureEditFragment.b(this.a).setVisibility(4);
    }
    this.a.getUIStyleHandler().w.a(false);
    ((SwiftBrowserSetting)this.a.mComponentsProvider.a(-1)).a("web_view_long_click", false);
    this.a.d();
    paramBundle = paramBundle.edit();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.a.getAppRuntime().getCurrentAccountUin());
    ((StringBuilder)localObject).append("_has_history_sig_del_key");
    paramBundle.putBoolean(((StringBuilder)localObject).toString(), false).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignatureEditFragment.1
 * JD-Core Version:    0.7.0.1
 */