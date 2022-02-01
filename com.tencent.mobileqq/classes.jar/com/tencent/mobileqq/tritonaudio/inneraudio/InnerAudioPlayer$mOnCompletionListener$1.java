package com.tencent.mobileqq.tritonaudio.inneraudio;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mobileqq.triton.utils.LogDelegate.DefaultImpls;
import com.tencent.mobileqq.triton.utils.LogDelegate.Level;
import com.tencent.mobileqq.tritonaudio.TritonAudioThreadPool;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/media/MediaPlayer;", "kotlin.jvm.PlatformType", "onCompletion"}, k=3, mv={1, 1, 16})
final class InnerAudioPlayer$mOnCompletionListener$1
  implements MediaPlayer.OnCompletionListener
{
  InnerAudioPlayer$mOnCompletionListener$1(InnerAudioPlayer paramInnerAudioPlayer) {}
  
  public final void onCompletion(MediaPlayer paramMediaPlayer)
  {
    paramMediaPlayer = InnerAudioPlayer.access$getLogger$p(this.this$0);
    if (paramMediaPlayer != null) {
      LogDelegate.DefaultImpls.printLog$default(paramMediaPlayer, LogDelegate.Level.INFO, InnerAudioPlayer.access$getTAG$cp(), "onCompletion audioId=" + this.this$0.getAudioId() + " path=" + this.this$0.getAudioPath() + ", duration=" + this.this$0.getDuration(), null, 8, null);
    }
    paramMediaPlayer = new InnerAudioPlayer.ResetTask(this.this$0, this.this$0.getAudioId(), this.this$0.getAudioPath());
    if (this.this$0.getDuration() < 500) {
      TritonAudioThreadPool.getAudioThreadPool().schedule((Runnable)paramMediaPlayer, this.this$0.getDuration() * 2, TimeUnit.MILLISECONDS);
    }
    for (;;)
    {
      paramMediaPlayer = this.this$0.getStateChangeListener();
      if (paramMediaPlayer != null) {
        paramMediaPlayer.onEnded();
      }
      return;
      paramMediaPlayer.run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tritonaudio.inneraudio.InnerAudioPlayer.mOnCompletionListener.1
 * JD-Core Version:    0.7.0.1
 */