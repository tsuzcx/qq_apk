package com.tencent.qidian;

import bacn;
import bade;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;

public class QidianWebViewFragment
  extends WebViewFragment
{
  public boolean b(WebView paramWebView, String paramString)
  {
    if ((paramString.startsWith("mqqwpa://")) && (paramString.contains("request=videochat"))) {
      try
      {
        bacn localbacn = bade.a(null, getActivity(), paramString);
        if (localbacn != null)
        {
          boolean bool = localbacn.c();
          return bool;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QidianWebViewFragment", 2, "shouldOverrideUrlLoading " + localException.getMessage());
        }
      }
    }
    return super.b(paramWebView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.qidian.QidianWebViewFragment
 * JD-Core Version:    0.7.0.1
 */