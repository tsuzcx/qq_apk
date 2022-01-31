package com.tencent.mobileqq.minigame.jsapi.webaudio;

import com.tencent.mobileqq.mini.webview.JsRuntime;

class WebAudioManager$1
  implements Runnable
{
  WebAudioManager$1(WebAudioManager paramWebAudioManager, int paramInt1, int paramInt2, JsRuntime paramJsRuntime, int paramInt3) {}
  
  public void run()
  {
    AudioNativeManager.play(this.val$sourceId, this.val$offset);
    WebAudioManager.access$000(this.this$0, this.val$jsRuntime, this.val$sourceId, this.val$audioId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.webaudio.WebAudioManager.1
 * JD-Core Version:    0.7.0.1
 */