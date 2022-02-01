package com.tencent.qidian;

import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.webview.swift.proxy.WebKernelCallBackProxy;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;

class QidianWebViewFragment$1
  extends WebKernelCallBackProxy
{
  QidianWebViewFragment$1(QidianWebViewFragment paramQidianWebViewFragment, WebViewKernelCallBack paramWebViewKernelCallBack)
  {
    super(paramWebViewKernelCallBack);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if ((paramString.startsWith("mqqwpa://")) && (paramString.contains("request=videochat"))) {
      try
      {
        JumpAction localJumpAction = JumpParser.a(null, this.a.getActivity(), paramString);
        if (localJumpAction != null)
        {
          boolean bool = localJumpAction.a();
          return bool;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("shouldOverrideUrlLoading ");
          localStringBuilder.append(localException.getMessage());
          QLog.d("QidianWebViewFragment", 2, localStringBuilder.toString());
        }
      }
    }
    return super.shouldOverrideUrlLoading(paramWebView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qidian.QidianWebViewFragment.1
 * JD-Core Version:    0.7.0.1
 */