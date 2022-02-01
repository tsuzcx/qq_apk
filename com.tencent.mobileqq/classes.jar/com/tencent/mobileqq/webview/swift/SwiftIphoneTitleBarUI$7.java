package com.tencent.mobileqq.webview.swift;

import android.content.Intent;
import android.text.TextUtils;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.ui.WebViewTopTabHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SwiftIphoneTitleBarUI$7
  implements RadioGroup.OnCheckedChangeListener
{
  SwiftIphoneTitleBarUI$7(SwiftIphoneTitleBarUI paramSwiftIphoneTitleBarUI) {}
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabHelper != null) && (!TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabHelper.a))) {
      this.a.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabHelper.a(paramInt);
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramRadioGroup, paramInt);
      return;
      TouchWebView localTouchWebView = this.a.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a();
      if (localTouchWebView != null)
      {
        String str2 = localTouchWebView.getUrl();
        String str1 = str2;
        if (TextUtils.isEmpty(str2))
        {
          str1 = str2;
          if (this.a.jdField_a_of_type_AndroidContentIntent != null) {
            str1 = this.a.jdField_a_of_type_AndroidContentIntent.getStringExtra("url");
          }
        }
        if (!TextUtils.isEmpty(str1)) {
          localTouchWebView.loadUrl(str1.replaceAll("(?<=[?&])subIndex=[^&]*", "subIndex=" + paramInt));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI.7
 * JD-Core Version:    0.7.0.1
 */