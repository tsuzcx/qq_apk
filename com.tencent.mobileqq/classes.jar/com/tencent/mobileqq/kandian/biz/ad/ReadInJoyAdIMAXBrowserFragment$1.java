package com.tencent.mobileqq.kandian.biz.ad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.proxy.WebKernelCallBackProxy;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebTitleBarInterface;
import com.tencent.mobileqq.widget.WebViewProgressBarController;
import mqq.app.AppRuntime;

class ReadInJoyAdIMAXBrowserFragment$1
  extends WebKernelCallBackProxy
{
  ReadInJoyAdIMAXBrowserFragment$1(ReadInJoyAdIMAXBrowserFragment paramReadInJoyAdIMAXBrowserFragment, WebViewKernelCallBack paramWebViewKernelCallBack)
  {
    super(paramWebViewKernelCallBack);
  }
  
  public void onDataInit(Bundle paramBundle)
  {
    if (this.a.getUIStyleHandler() != null)
    {
      this.a.getUIStyleHandler().jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.D = true;
      this.a.getUIStyleHandler().jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.f = true;
      this.a.getUIStyle().n = true;
    }
    VideoFeedsHelper.b(this.a.getHostActivity());
    super.onDataInit(paramBundle);
  }
  
  public void onFinalState(Bundle paramBundle)
  {
    super.onFinalState(paramBundle);
    if (this.a.getActivity().getRequestedOrientation() != 1) {
      this.a.getActivity().setRequestedOrientation(1);
    }
    this.a.getWebView().setVerticalScrollBarEnabled(false);
    this.a.getWebView().setHorizontalScrollBarEnabled(false);
    if ((this.a.getUIStyleHandler() != null) && (this.a.getUIStyleHandler().jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController != null)) {
      this.a.getUIStyleHandler().jdField_a_of_type_ComTencentMobileqqWidgetWebViewProgressBarController.a(false);
    }
    if ((this.a.getUIStyleHandler() != null) && (this.a.getUIStyleHandler().d != null))
    {
      paramBundle = this.a.getUIStyleHandler().d.findViewById(2131365199);
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
    }
    if (this.a.getWebTitleBarInterface().a() != null) {
      this.a.getWebTitleBarInterface().a().setVisibility(8);
    }
    VideoFeedsHelper.b(this.a.getHostActivity());
    paramBundle = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramBundle instanceof ToolAppRuntime)) {
      ReadInJoyAdIMAXBrowserFragment.a(this.a, paramBundle.getAppRuntime("modular_web"));
    }
    ReadInJoyAdIMAXBrowserFragment.a(this.a);
    paramBundle = this.a;
    ReadInJoyAdIMAXBrowserFragment.a(paramBundle, (AdvertisementInfo)paramBundle.getIntent().getParcelableExtra("ad"));
    ReadInJoyAdIMAXBrowserFragment.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ad.ReadInJoyAdIMAXBrowserFragment.1
 * JD-Core Version:    0.7.0.1
 */