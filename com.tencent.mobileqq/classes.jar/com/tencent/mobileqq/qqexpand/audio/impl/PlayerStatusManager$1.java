package com.tencent.mobileqq.qqexpand.audio.impl;

import com.tencent.mobileqq.qqexpand.audio.IAudioPlayerStatusListener;

class PlayerStatusManager$1
  implements Runnable
{
  PlayerStatusManager$1(PlayerStatusManager paramPlayerStatusManager, String paramString) {}
  
  public void run()
  {
    if (PlayerStatusManager.a(this.this$0) != null) {
      PlayerStatusManager.a(this.this$0).onAudioStartPlay(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.audio.impl.PlayerStatusManager.1
 * JD-Core Version:    0.7.0.1
 */