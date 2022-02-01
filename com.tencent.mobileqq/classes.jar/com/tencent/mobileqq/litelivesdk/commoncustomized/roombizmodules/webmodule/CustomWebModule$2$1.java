package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule;

import com.tencent.ilive.litepages.room.webmodule.jsmodule.JsBizAdapter.ValueCallback;
import com.tencent.smtt.sdk.ValueCallback;

class CustomWebModule$2$1
  implements ValueCallback<String>
{
  CustomWebModule$2$1(CustomWebModule.2 param2, JsBizAdapter.ValueCallback paramValueCallback) {}
  
  public void a(String paramString)
  {
    JsBizAdapter.ValueCallback localValueCallback = this.a;
    if (localValueCallback != null) {
      localValueCallback.onReceiveValue(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.CustomWebModule.2.1
 * JD-Core Version:    0.7.0.1
 */