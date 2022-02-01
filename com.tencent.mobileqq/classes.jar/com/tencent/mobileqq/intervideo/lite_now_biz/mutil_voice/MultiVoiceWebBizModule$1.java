package com.tencent.mobileqq.intervideo.lite_now_biz.mutil_voice;

import androidx.lifecycle.Observer;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.intervideo.lite_now_biz.event.AudioChangeEvent;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;

class MultiVoiceWebBizModule$1
  implements Observer<AudioChangeEvent>
{
  MultiVoiceWebBizModule$1(MultiVoiceWebBizModule paramMultiVoiceWebBizModule) {}
  
  public void a(AudioChangeEvent paramAudioChangeEvent)
  {
    paramAudioChangeEvent = WebViewPlugin.toJsScript("HY_audioEventChange", paramAudioChangeEvent.a(), null);
    MultiVoiceWebBizModule.a(this.a).callJs(paramAudioChangeEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.mutil_voice.MultiVoiceWebBizModule.1
 * JD-Core Version:    0.7.0.1
 */