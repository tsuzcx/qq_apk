package com.tencent.mobileqq.fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import auvu;
import bieo;
import bigl;
import bikp;
import com.tencent.biz.ui.RefreshView;
import com.tencent.mobileqq.webview.swift.WebBrowserViewContainer;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;

public class CustomHeightFragment
  extends WebViewFragment
{
  public bigl createComponentsProvider()
  {
    return new bigl(this, 127, new auvu(this));
  }
  
  public int doCreateLoopStep_Final(Bundle paramBundle)
  {
    int i = super.doCreateLoopStep_Final(paramBundle);
    this.mSwiftTitleUI.setTitleBarVisibility(false);
    this.mUIStyleHandler.mLoadingProgressBar.setVisibility(8);
    return i;
  }
  
  public int doCreateLoopStep_InitUIContent(Bundle paramBundle)
  {
    this.mUIStyle.mFloatBarRulesFromUrl = 0L;
    int i = super.doCreateLoopStep_InitUIContent(paramBundle);
    super.getActivity().getWindow().setBackgroundDrawableResource(2131167296);
    paramBundle = super.getActivity().findViewById(2131363780);
    if (paramBundle != null) {
      paramBundle.setBackgroundResource(2131167296);
    }
    if ((this.mUIStyleHandler.webviewWrapper instanceof RefreshView)) {
      ((RefreshView)this.mUIStyleHandler.webviewWrapper).a(false);
    }
    if (this.mUIStyleHandler.mBrowserTips != null) {
      this.mUIStyleHandler.mBrowserTips.setVisibility(8);
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
    this.mPluginEngine.a(new String[] { bikp.a, "QQApi", "ui", "share", "PublicAccountJs" });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.CustomHeightFragment
 * JD-Core Version:    0.7.0.1
 */