package com.tencent.open.appstore.js;

import com.tencent.open.base.LogUtility;
import com.tencent.smtt.sdk.ValueCallback;

class DINewForCommonWebView$2$1
  implements ValueCallback<String>
{
  DINewForCommonWebView$2$1(DINewForCommonWebView.2 param2) {}
  
  public void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[jsCallBack]:");
    localStringBuilder.append(paramString);
    LogUtility.b("DINewForCommonWebView", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appstore.js.DINewForCommonWebView.2.1
 * JD-Core Version:    0.7.0.1
 */