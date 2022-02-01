package com.tencent.open.appcommon.now.download.js;

import bhwp;
import bhxs;
import bhzm;
import com.tencent.smtt.sdk.WebView;

public class DownloadCallbackWebImpl$1
  implements Runnable
{
  public DownloadCallbackWebImpl$1(bhxs parambhxs, WebView paramWebView, String paramString) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentSmttSdkWebView != null) && (this.jdField_a_of_type_JavaLangString != null) && (bhwp.a().a())) {}
    try
    {
      this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl(this.jdField_a_of_type_JavaLangString);
      return;
    }
    catch (Exception localException)
    {
      bhzm.a("DownloadCallbackWebImpl", "doJsCallBack >>> ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.appcommon.now.download.js.DownloadCallbackWebImpl.1
 * JD-Core Version:    0.7.0.1
 */