package com.tencent.mobileqq.fragment;

import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.AbsWebView;

class NearbyBaseFragment$1
  implements Runnable
{
  NearbyBaseFragment$1(NearbyBaseFragment paramNearbyBaseFragment, AbsWebView paramAbsWebView) {}
  
  public void run()
  {
    this.a.mWebview.flingScroll(0, -this.this$0.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.NearbyBaseFragment.1
 * JD-Core Version:    0.7.0.1
 */