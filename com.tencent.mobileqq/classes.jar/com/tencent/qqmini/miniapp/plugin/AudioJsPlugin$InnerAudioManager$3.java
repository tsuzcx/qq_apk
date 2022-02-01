package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.miniapp.widget.media.MiniAppAudioPlayer;

class AudioJsPlugin$InnerAudioManager$3
  implements Runnable
{
  AudioJsPlugin$InnerAudioManager$3(AudioJsPlugin.InnerAudioManager paramInnerAudioManager, int paramInt) {}
  
  public void run()
  {
    if (AudioJsPlugin.InnerAudioManager.access$3300(this.this$1) != null) {
      AudioJsPlugin.InnerAudioManager.access$3300(this.this$1).seekTo(this.val$mSec);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.AudioJsPlugin.InnerAudioManager.3
 * JD-Core Version:    0.7.0.1
 */