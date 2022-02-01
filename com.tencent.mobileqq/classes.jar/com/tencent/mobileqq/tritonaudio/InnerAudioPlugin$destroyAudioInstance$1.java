package com.tencent.mobileqq.tritonaudio;

import com.tencent.mobileqq.tritonaudio.inneraudio.AudioPlayerManager;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class InnerAudioPlugin$destroyAudioInstance$1
  implements Runnable
{
  InnerAudioPlugin$destroyAudioInstance$1(InnerAudioPlugin paramInnerAudioPlugin, int paramInt) {}
  
  public final void run()
  {
    AudioPlayerManager localAudioPlayerManager = InnerAudioPlugin.access$getAudioPlayerManager$p(this.this$0);
    if (localAudioPlayerManager != null) {
      localAudioPlayerManager.destroyAudioContext(this.$audioId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tritonaudio.InnerAudioPlugin.destroyAudioInstance.1
 * JD-Core Version:    0.7.0.1
 */