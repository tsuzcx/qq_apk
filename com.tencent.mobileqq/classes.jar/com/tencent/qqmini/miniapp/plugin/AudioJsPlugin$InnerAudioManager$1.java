package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.miniapp.widget.media.MiniAppAudioPlayer;
import com.tencent.qqmini.miniapp.widget.media.MiniAppAudioPlayer.OnPreparedListener;

class AudioJsPlugin$InnerAudioManager$1
  implements MiniAppAudioPlayer.OnPreparedListener
{
  AudioJsPlugin$InnerAudioManager$1(AudioJsPlugin.InnerAudioManager paramInnerAudioManager, boolean paramBoolean1, boolean paramBoolean2, double paramDouble, MiniAppAudioPlayer.OnPreparedListener paramOnPreparedListener) {}
  
  public void onPrepared()
  {
    MiniAppAudioPlayer localMiniAppAudioPlayer;
    if ((this.val$autoPlay) && (AudioJsPlugin.InnerAudioManager.access$3400(this.this$1) != null))
    {
      AudioJsPlugin.InnerAudioManager.access$3400(this.this$1).setLooping(this.val$loop);
      AudioJsPlugin.InnerAudioManager.access$3400(this.this$1).setVolume((float)this.val$volume);
      localMiniAppAudioPlayer = AudioJsPlugin.InnerAudioManager.access$3400(this.this$1);
      if (AudioJsPlugin.access$3500()) {
        break label94;
      }
    }
    label94:
    for (boolean bool = true;; bool = false)
    {
      localMiniAppAudioPlayer.setAudioFocus(bool);
      AudioJsPlugin.InnerAudioManager.access$3400(this.this$1).start();
      if (this.val$outerPreparedListener != null) {
        this.val$outerPreparedListener.onPrepared();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.AudioJsPlugin.InnerAudioManager.1
 * JD-Core Version:    0.7.0.1
 */