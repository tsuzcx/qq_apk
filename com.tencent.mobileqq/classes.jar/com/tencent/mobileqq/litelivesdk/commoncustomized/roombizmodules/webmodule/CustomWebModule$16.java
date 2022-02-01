package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule;

import com.tencent.mobileqq.litelivesdk.utils.log.LogFactory;
import com.tencent.mobileqq.litelivesdk.utils.log.LogInterface;
import com.tencent.smtt.sdk.ValueCallback;

class CustomWebModule$16
  implements ValueCallback<String>
{
  CustomWebModule$16(CustomWebModule paramCustomWebModule) {}
  
  public void a(String paramString)
  {
    LogInterface localLogInterface = LogFactory.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReceiveValue value = ");
    localStringBuilder.append(paramString);
    localLogInterface.c("IliveCustomWebModule", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.CustomWebModule.16
 * JD-Core Version:    0.7.0.1
 */