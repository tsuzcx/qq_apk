package com.tencent.mobileqq.intervideo.lite_now_biz.now_od;

import androidx.lifecycle.Observer;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.intervideo.lite_now_biz.event.AudioChangeEvent;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;

class ODWebBizModule$1
  implements Observer<AudioChangeEvent>
{
  ODWebBizModule$1(ODWebBizModule paramODWebBizModule) {}
  
  public void a(AudioChangeEvent paramAudioChangeEvent)
  {
    paramAudioChangeEvent = WebViewPlugin.toJsScript("HY_audioEventChange", paramAudioChangeEvent.a(), null);
    ODWebBizModule.a(this.a).callJs(paramAudioChangeEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.now_od.ODWebBizModule.1
 * JD-Core Version:    0.7.0.1
 */