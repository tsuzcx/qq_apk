package com.tencent.mobileqq.qqexpand.audio.impl;

import com.tencent.mobileqq.qqexpand.audio.IAudioPlayerStatusListener;

class PlayerStatusManager$2
  implements Runnable
{
  PlayerStatusManager$2(PlayerStatusManager paramPlayerStatusManager, String paramString) {}
  
  public void run()
  {
    if (PlayerStatusManager.a(this.this$0) != null) {
      PlayerStatusManager.a(this.this$0).onAudioFinishPlay(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.audio.impl.PlayerStatusManager.2
 * JD-Core Version:    0.7.0.1
 */