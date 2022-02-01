package com.tencent.mobileqq.qqgift.webview;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.qqgift.api.IQQGiftDataStore;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.WebBrowserViewContainer;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewKernel;
import com.tencent.mobileqq.webview.swift.WebViewUIUtils;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebTitleBarInterface;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;

public class QQGiftHalfTranslucentBrowserActivity$QQGiftRechargeBrowserFragment
  extends WebViewFragment
{
  @TargetApi(11)
  public void a(Bundle paramBundle, WebViewKernelCallBack paramWebViewKernelCallBack)
  {
    getUIStyle().e = 0L;
    getUIStyleHandler().C = true;
    getUIStyle().y = true;
    paramWebViewKernelCallBack.onInitUIContent(paramBundle);
    super.getActivity().getWindow().setBackgroundDrawableResource(2131168376);
    if ((getUIStyleHandler().u instanceof RefreshView)) {
      ((RefreshView)getUIStyleHandler().u).a(false);
    }
    if (getUIStyleHandler().D != null) {
      getUIStyleHandler().D.setVisibility(8);
    }
    if (this.webView.getX5WebViewExtension() != null) {
      try
      {
        this.webView.getView().setBackgroundColor(0);
        this.webView.setBackgroundColor(0);
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
      }
    } else {
      this.webView.setBackgroundColor(0);
    }
    this.contentView.setBackgroundColor(0);
  }
  
  public void b(Bundle paramBundle, WebViewKernelCallBack paramWebViewKernelCallBack)
  {
    paramWebViewKernelCallBack.onFinalState(paramBundle);
    if (getActivity() != null)
    {
      if (getActivity().getIntent() == null) {
        return;
      }
      if (this.intent.getIntExtra("key_dialog_type", -1) != -1)
      {
        getActivity().getWindow().setFlags(1024, 1024);
        getUIStyleHandler().v.setVisibility(8);
        getUIStyle().a = true;
        WebViewUIUtils.b(super.getActivity());
        getWebTitleBarInterface().f(false);
      }
    }
  }
  
  public WebViewKernelCallBack getWebViewKernelCallBack()
  {
    return new QQGiftHalfTranslucentBrowserActivity.QQGiftRechargeBrowserFragment.1(this, this.webViewSurface);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater.setBackgroundColor(0);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ((IQQGiftDataStore)QRoute.api(IQQGiftDataStore.class)).clear();
    if (this.webViewKernel != null) {
      this.webViewKernel.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.webview.QQGiftHalfTranslucentBrowserActivity.QQGiftRechargeBrowserFragment
 * JD-Core Version:    0.7.0.1
 */