package com.tencent.mobileqq.webview.ui;

import android.text.TextUtils;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import org.json.JSONObject;

public class WebViewTopTabHelper
{
  private final SwiftBrowserUIStyleHandler a;
  public String a;
  
  public WebViewTopTabHelper(SwiftBrowserUIStyleHandler paramSwiftBrowserUIStyleHandler)
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler = paramSwiftBrowserUIStyleHandler;
  }
  
  public void a(int paramInt)
  {
    TouchWebView localTouchWebView = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a();
    if ((localTouchWebView != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      try
      {
        localJSONObject1.put("code", 0);
        localJSONObject1.put("message", "ok");
        localJSONObject2.put("subIndex", paramInt);
        localJSONObject1.put("data", localJSONObject2);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      localTouchWebView.callJs(WebViewPlugin.toJsScript(this.jdField_a_of_type_JavaLangString, localJSONObject1, null));
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (!TextUtils.isEmpty(paramString)) {
        this.jdField_a_of_type_JavaLangString = paramString;
      }
    }
    else {
      this.jdField_a_of_type_JavaLangString = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.ui.WebViewTopTabHelper
 * JD-Core Version:    0.7.0.1
 */