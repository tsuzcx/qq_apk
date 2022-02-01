package com.tencent.mobileqq.intervideo.now.dynamic;

import android.os.Bundle;
import com.tencent.intervideo.nowproxy.WebCallHandler;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedWebView;

class DynamicNowManager$CustomizedWebViewImpl
  implements CustomizedWebView
{
  public void onJumpWeb(String paramString, Bundle paramBundle, WebCallHandler paramWebCallHandler)
  {
    PluginManagerInterfaceImpl.a().b(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.DynamicNowManager.CustomizedWebViewImpl
 * JD-Core Version:    0.7.0.1
 */