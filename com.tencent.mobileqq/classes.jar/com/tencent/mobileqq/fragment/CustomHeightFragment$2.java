package com.tencent.mobileqq.fragment;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.ui.RefreshView;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebBrowserViewContainer;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.proxy.WebKernelCallBackProxy;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;

class CustomHeightFragment$2
  extends WebKernelCallBackProxy
{
  CustomHeightFragment$2(CustomHeightFragment paramCustomHeightFragment, WebViewKernelCallBack paramWebViewKernelCallBack)
  {
    super(paramWebViewKernelCallBack);
  }
  
  public void onFinalState(Bundle paramBundle)
  {
    super.onFinalState(paramBundle);
    this.a.getSwiftTitleUI().b(false);
    this.a.getUIStyleHandler().a.setVisibility(8);
  }
  
  public void onInitUIContent(Bundle paramBundle)
  {
    this.a.getUIStyle().c = 0L;
    super.onInitUIContent(paramBundle);
    this.a.getActivity().getWindow().setBackgroundDrawableResource(2131167333);
    paramBundle = this.a.getActivity().findViewById(2131363807);
    if (paramBundle != null) {
      paramBundle.setBackgroundResource(2131167333);
    }
    if ((this.a.getUIStyleHandler().jdField_c_of_type_AndroidViewViewGroup instanceof RefreshView)) {
      ((RefreshView)this.a.getUIStyleHandler().jdField_c_of_type_AndroidViewViewGroup).a(false);
    }
    if (this.a.getUIStyleHandler().jdField_c_of_type_AndroidViewView != null) {
      this.a.getUIStyleHandler().jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
    this.a.contentView.setBackgroundColor(0);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    if (QLog.isColorLevel()) {
      QLog.d("CustomHeightFragment", 2, "ConfessBrowserFragment onReceivedError = ");
    }
    if (this.a.getActivity() != null) {
      this.a.getActivity().finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.CustomHeightFragment.2
 * JD-Core Version:    0.7.0.1
 */