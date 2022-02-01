package com.tencent.qidian;

import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;

public class QidianWebViewFragment
  extends WebViewFragment
{
  public WebViewKernelCallBack getWebViewKernelCallBack()
  {
    return new QidianWebViewFragment.1(this, this.webViewSurface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qidian.QidianWebViewFragment
 * JD-Core Version:    0.7.0.1
 */