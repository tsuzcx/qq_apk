package com.tencent.mobileqq.search.activity;

import android.os.Bundle;
import com.tencent.mobileqq.webview.swift.proxy.WebKernelCallBackProxy;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;

class MixSearchWebFragment$1
  extends WebKernelCallBackProxy
{
  MixSearchWebFragment$1(MixSearchWebFragment paramMixSearchWebFragment, WebViewKernelCallBack paramWebViewKernelCallBack)
  {
    super(paramWebViewKernelCallBack);
  }
  
  public void onFinalState(Bundle paramBundle)
  {
    super.onFinalState(paramBundle);
    MixSearchWebFragment.a(this.a, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.activity.MixSearchWebFragment.1
 * JD-Core Version:    0.7.0.1
 */