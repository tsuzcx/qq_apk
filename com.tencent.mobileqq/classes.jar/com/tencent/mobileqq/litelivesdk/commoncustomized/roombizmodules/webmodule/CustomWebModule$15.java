package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule;

import com.tencent.mobileqq.litelivesdk.utils.log.LogFactory;
import com.tencent.mobileqq.litelivesdk.utils.log.LogInterface;
import com.tencent.smtt.sdk.ValueCallback;

class CustomWebModule$15
  implements ValueCallback<String>
{
  CustomWebModule$15(CustomWebModule paramCustomWebModule) {}
  
  public void a(String paramString)
  {
    LogFactory.a().c("IliveCustomWebModule", "onReceiveValue value = " + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.CustomWebModule.15
 * JD-Core Version:    0.7.0.1
 */