package com.tencent.mobileqq.troop.jsp;

import com.tencent.smtt.sdk.WebView;

class TroopNoticeJsHandler$4
  implements Runnable
{
  TroopNoticeJsHandler$4(TroopNoticeJsHandler paramTroopNoticeJsHandler, WebView paramWebView, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentSmttSdkWebView != null) {
      this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl("javascript: " + this.jdField_a_of_type_JavaLangString + "(" + this.b + ")");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler.4
 * JD-Core Version:    0.7.0.1
 */