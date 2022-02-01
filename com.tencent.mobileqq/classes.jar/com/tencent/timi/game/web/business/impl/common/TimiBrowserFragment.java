package com.tencent.timi.game.web.business.impl.common;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebTitleBarInterface;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;

public class TimiBrowserFragment
  extends WebViewFragment
{
  private boolean a;
  
  private void a()
  {
    getWebTitleBarInterface().f(false);
    Object localObject = getActivity();
    if (localObject != null) {
      ((Activity)localObject).getWindow().setBackgroundDrawableResource(2131168376);
    }
    getUIStyleHandler().v.setVisibility(8);
    getUIStyleHandler().D.setVisibility(8);
    localObject = getUIStyleHandler().u;
    if ((localObject instanceof RefreshView)) {
      ((RefreshView)localObject).a(false);
    }
    if (this.webView.getX5WebViewExtension() != null) {
      try
      {
        this.webView.getView().setBackgroundColor(0);
        this.webView.setBackgroundColor(0);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
    }
    this.webView.setBackgroundColor(0);
  }
  
  private void b()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity instanceof TimiBrowserActivity)) {
      ((TimiBrowserActivity)localFragmentActivity).g();
    }
  }
  
  private void c()
  {
    if (!this.a)
    {
      FragmentActivity localFragmentActivity = getActivity();
      if ((localFragmentActivity instanceof TimiBrowserActivity))
      {
        ((TimiBrowserActivity)localFragmentActivity).d();
        this.a = true;
      }
    }
  }
  
  public WebViewKernelCallBack getWebViewKernelCallBack()
  {
    return new TimiBrowserFragment.1(this, this.webViewSurface);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater.setBackgroundColor(0);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.web.business.impl.common.TimiBrowserFragment
 * JD-Core Version:    0.7.0.1
 */