package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule;

import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.ValueCallback;

class CustomWebModule$14
  implements ValueCallback<String>
{
  CustomWebModule$14(CustomWebModule paramCustomWebModule) {}
  
  public void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AppJavascriptInterface onVideoPlay ValueCallback value = ");
    localStringBuilder.append(paramString);
    QLog.d("IliveCustomWebModule", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.CustomWebModule.14
 * JD-Core Version:    0.7.0.1
 */