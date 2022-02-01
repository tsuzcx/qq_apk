package com.tencent.mobileqq.flashshow.api.hybird;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.WebBrowserViewContainer;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;

public class FSPublishHybirdFragment
  extends WebViewFragment
{
  private void a()
  {
    if (getWebView() != null)
    {
      getUIStyleHandler().E = getResources().getColor(2131167446);
      getUIStyleHandler().D.setBackgroundColor(getUIStyleHandler().E);
      if (getWebView().getX5WebViewExtension() != null) {
        try
        {
          getWebView().getView().setBackgroundColor(getResources().getColor(2131167446));
          getWebView().setBackgroundColor(getResources().getColor(2131167446));
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      } else {
        getWebView().setBackgroundColor(getResources().getColor(2131167446));
      }
      if (this.contentView != null) {
        this.contentView.setBackgroundColor(getResources().getColor(2131167446));
      }
    }
  }
  
  public void doOnBackEvent()
  {
    super.doOnBackEvent();
  }
  
  public WebViewKernelCallBack getWebViewKernelCallBack()
  {
    return new FSPublishHybirdFragment.1(this, this.webViewSurface);
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    a();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.api.hybird.FSPublishHybirdFragment
 * JD-Core Version:    0.7.0.1
 */