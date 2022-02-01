package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.miniapp.widget.media.MiniAppAudioPlayer;
import com.tencent.qqmini.miniapp.widget.media.MiniAppAudioPlayer.OnPreparedListener;

class AudioJsPlugin$InnerAudioManager$1
  implements MiniAppAudioPlayer.OnPreparedListener
{
  AudioJsPlugin$InnerAudioManager$1(AudioJsPlugin.InnerAudioManager paramInnerAudioManager, boolean paramBoolean1, boolean paramBoolean2, double paramDouble, MiniAppAudioPlayer.OnPreparedListener paramOnPreparedListener) {}
  
  public void onPrepared()
  {
    if ((this.val$autoPlay) && (AudioJsPlugin.InnerAudioManager.access$3300(this.this$1) != null))
    {
      AudioJsPlugin.InnerAudioManager.access$3300(this.this$1).setLooping(this.val$loop);
      AudioJsPlugin.InnerAudioManager.access$3300(this.this$1).setVolume((float)this.val$volume);
      AudioJsPlugin.InnerAudioManager.access$3300(this.this$1).setAudioFocus(AudioJsPlugin.access$3400() ^ true);
      AudioJsPlugin.InnerAudioManager.access$3300(this.this$1).start();
    }
    MiniAppAudioPlayer.OnPreparedListener localOnPreparedListener = this.val$outerPreparedListener;
    if (localOnPreparedListener != null) {
      localOnPreparedListener.onPrepared();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.AudioJsPlugin.InnerAudioManager.1
 * JD-Core Version:    0.7.0.1
 */