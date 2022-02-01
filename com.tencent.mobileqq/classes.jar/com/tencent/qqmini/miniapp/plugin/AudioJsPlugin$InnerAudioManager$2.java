package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.miniapp.widget.media.MiniAppAudioPlayer;

class AudioJsPlugin$InnerAudioManager$2
  implements Runnable
{
  AudioJsPlugin$InnerAudioManager$2(AudioJsPlugin.InnerAudioManager paramInnerAudioManager) {}
  
  public void run()
  {
    if ((AudioJsPlugin.InnerAudioManager.access$3300(this.this$1) != null) && (AudioJsPlugin.InnerAudioManager.access$3300(this.this$1).isPlaying())) {
      AudioJsPlugin.InnerAudioManager.access$3300(this.this$1).pause();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.AudioJsPlugin.InnerAudioManager.2
 * JD-Core Version:    0.7.0.1
 */