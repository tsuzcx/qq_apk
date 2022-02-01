package com.tencent.mobileqq.webview.swift.utils;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.ValueCallback;

final class WebViewJumpUtils$1
  implements ValueCallback<String>
{
  WebViewJumpUtils$1(WebViewProvider paramWebViewProvider) {}
  
  public void a(String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("evaluateJavascript: ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("SwiftWebViewUtils", 2, ((StringBuilder)localObject).toString());
    }
    Bundle localBundle = new Bundle();
    if (!TextUtils.isEmpty(paramString)) {
      localObject = paramString.trim();
    } else {
      localObject = "";
    }
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      paramString = (String)localObject;
      if (((String)localObject).startsWith("\"")) {
        paramString = ((String)localObject).replaceFirst("\"", "");
      }
      localObject = paramString;
      if (paramString.endsWith("\"")) {
        localObject = paramString.substring(0, paramString.length() - 1);
      }
      localBundle.putString("banner_wording", String.format(HardCodeUtil.a(2131714496), new Object[] { localObject }));
    }
    WebViewJumpUtils.a(localBundle, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.utils.WebViewJumpUtils.1
 * JD-Core Version:    0.7.0.1
 */