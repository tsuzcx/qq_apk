package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.widget.media.MiniAppAudioPlayer;

class AudioJsPlugin$InnerAudioManager$2
  implements Runnable
{
  AudioJsPlugin$InnerAudioManager$2(AudioJsPlugin.InnerAudioManager paramInnerAudioManager) {}
  
  public void run()
  {
    if ((AudioJsPlugin.InnerAudioManager.access$1600(this.this$1) != null) && (AudioJsPlugin.InnerAudioManager.access$1600(this.this$1).isPlaying())) {
      AudioJsPlugin.InnerAudioManager.access$1600(this.this$1).pause();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.AudioJsPlugin.InnerAudioManager.2
 * JD-Core Version:    0.7.0.1
 */