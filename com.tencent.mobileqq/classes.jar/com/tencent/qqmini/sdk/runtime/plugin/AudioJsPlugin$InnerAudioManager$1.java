package com.tencent.qqmini.sdk.runtime.plugin;

import bhkl;
import bhko;

class AudioJsPlugin$InnerAudioManager$1
  implements bhko
{
  AudioJsPlugin$InnerAudioManager$1(AudioJsPlugin.InnerAudioManager paramInnerAudioManager, boolean paramBoolean1, boolean paramBoolean2, double paramDouble) {}
  
  public void onPrepared()
  {
    bhkl localbhkl;
    if ((this.val$autoPlay) && (AudioJsPlugin.InnerAudioManager.access$2100(this.this$1) != null))
    {
      AudioJsPlugin.InnerAudioManager.access$2100(this.this$1).b(this.val$loop);
      AudioJsPlugin.InnerAudioManager.access$2100(this.this$1).a((float)this.val$volume);
      localbhkl = AudioJsPlugin.InnerAudioManager.access$2100(this.this$1);
      if (AudioJsPlugin.access$2200()) {
        break label78;
      }
    }
    label78:
    for (boolean bool = true;; bool = false)
    {
      localbhkl.a(bool);
      AudioJsPlugin.InnerAudioManager.access$2100(this.this$1).d();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.AudioJsPlugin.InnerAudioManager.1
 * JD-Core Version:    0.7.0.1
 */