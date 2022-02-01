package com.tencent.mobileqq.fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import com.tencent.biz.ui.RefreshView;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebBrowserViewContainer;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webviewplugin.WebViewJumpPlugin;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;

public class CustomHeightFragment
  extends WebViewFragment
{
  public SwiftBrowserComponentsProvider createComponentsProvider()
  {
    return new SwiftBrowserComponentsProvider(this, 127, new CustomHeightFragment.1(this));
  }
  
  public int doCreateLoopStep_Final(Bundle paramBundle)
  {
    int i = super.doCreateLoopStep_Final(paramBundle);
    this.mSwiftTitleUI.b(false);
    this.mUIStyleHandler.a.setVisibility(8);
    return i;
  }
  
  public int doCreateLoopStep_InitUIContent(Bundle paramBundle)
  {
    this.mUIStyle.c = 0L;
    int i = super.doCreateLoopStep_InitUIContent(paramBundle);
    super.getActivity().getWindow().setBackgroundDrawableResource(2131167305);
    paramBundle = super.getActivity().findViewById(2131363879);
    if (paramBundle != null) {
      paramBundle.setBackgroundResource(2131167305);
    }
    if ((this.mUIStyleHandler.jdField_c_of_type_AndroidViewViewGroup instanceof RefreshView)) {
      ((RefreshView)this.mUIStyleHandler.jdField_c_of_type_AndroidViewViewGroup).a(false);
    }
    if (this.mUIStyleHandler.jdField_c_of_type_AndroidViewView != null) {
      this.mUIStyleHandler.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
    this.contentView.setBackgroundColor(0);
    return i;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CustomHeightFragment", 2, "ConfessBrowserFragment doOnCreate = ");
    }
    boolean bool = super.doOnCreate(paramBundle);
    this.mPluginEngine.a(new String[] { WebViewJumpPlugin.a, "QQApi", "ui", "share", "PublicAccountJs" });
    return bool;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    if (QLog.isColorLevel()) {
      QLog.d("CustomHeightFragment", 2, "ConfessBrowserFragment onReceivedError = ");
    }
    if (getActivity() != null) {
      getActivity().finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.CustomHeightFragment
 * JD-Core Version:    0.7.0.1
 */