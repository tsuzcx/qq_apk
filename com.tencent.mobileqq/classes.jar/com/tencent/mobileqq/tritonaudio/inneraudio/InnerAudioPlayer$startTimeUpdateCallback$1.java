package com.tencent.mobileqq.tritonaudio.inneraudio;

import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/tritonaudio/inneraudio/InnerAudioPlayer$startTimeUpdateCallback$1", "Ljava/util/TimerTask;", "run", "", "TritonAudio_release"}, k=1, mv={1, 1, 16})
public final class InnerAudioPlayer$startTimeUpdateCallback$1
  extends TimerTask
{
  public void run()
  {
    if ((this.this$0.getStateChangeListener() != null) && (!this.this$0.isPaused()))
    {
      IAudioStateChangeListener localIAudioStateChangeListener = this.this$0.getStateChangeListener();
      if (localIAudioStateChangeListener == null) {
        Intrinsics.throwNpe();
      }
      localIAudioStateChangeListener.onTimeUpdate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tritonaudio.inneraudio.InnerAudioPlayer.startTimeUpdateCallback.1
 * JD-Core Version:    0.7.0.1
 */