package com.tencent.mobileqq.tritonaudio;

import com.tencent.mobileqq.triton.script.Argument;
import com.tencent.mobileqq.tritonaudio.inneraudio.AudioPlayerManager;
import com.tencent.mobileqq.tritonaudio.inneraudio.IAudioStateChangeListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class InnerAudioPlugin$createAudioInstance$1
  implements Runnable
{
  InnerAudioPlugin$createAudioInstance$1(InnerAudioPlugin paramInnerAudioPlugin, int paramInt, Argument paramArgument) {}
  
  public final void run()
  {
    IAudioStateChangeListener localIAudioStateChangeListener = (IAudioStateChangeListener)new InnerAudioPlugin.GameAudioStateChangeListener(this.$audioId, this.$arguments);
    AudioPlayerManager localAudioPlayerManager = InnerAudioPlugin.access$getAudioPlayerManager$p(this.this$0);
    if (localAudioPlayerManager != null) {
      localAudioPlayerManager.createAudioContext(this.$audioId, localIAudioStateChangeListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tritonaudio.InnerAudioPlugin.createAudioInstance.1
 * JD-Core Version:    0.7.0.1
 */