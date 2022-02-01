package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.fragment;

import com.tencent.ilive.litepages.room.webmodule.jsmodule.JsBizAdapter.ValueCallback;
import com.tencent.smtt.sdk.ValueCallback;

class LiteLiveWebViewFragment$3$1
  implements ValueCallback<String>
{
  LiteLiveWebViewFragment$3$1(LiteLiveWebViewFragment.3 param3, JsBizAdapter.ValueCallback paramValueCallback) {}
  
  public void a(String paramString)
  {
    JsBizAdapter.ValueCallback localValueCallback = this.jdField_a_of_type_ComTencentIliveLitepagesRoomWebmoduleJsmoduleJsBizAdapter$ValueCallback;
    if (localValueCallback != null) {
      localValueCallback.onReceiveValue(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.fragment.LiteLiveWebViewFragment.3.1
 * JD-Core Version:    0.7.0.1
 */