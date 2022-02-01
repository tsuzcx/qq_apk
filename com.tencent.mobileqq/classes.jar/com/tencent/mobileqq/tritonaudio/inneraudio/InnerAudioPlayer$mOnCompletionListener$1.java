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
    if (paramMediaPlayer != null)
    {
      LogDelegate.Level localLevel = LogDelegate.Level.INFO;
      String str = InnerAudioPlayer.access$getTAG$cp();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCompletion audioId=");
      localStringBuilder.append(this.this$0.getAudioId());
      localStringBuilder.append(" path=");
      localStringBuilder.append(this.this$0.getAudioPath());
      localStringBuilder.append(", duration=");
      localStringBuilder.append(this.this$0.getDuration());
      LogDelegate.DefaultImpls.printLog$default(paramMediaPlayer, localLevel, str, localStringBuilder.toString(), null, 8, null);
    }
    paramMediaPlayer = this.this$0;
    paramMediaPlayer = new InnerAudioPlayer.ResetTask(paramMediaPlayer, paramMediaPlayer.getAudioId(), this.this$0.getAudioPath());
    if (this.this$0.getDuration() < 500) {
      TritonAudioThreadPool.getAudioThreadPool().schedule((Runnable)paramMediaPlayer, this.this$0.getDuration() * 2, TimeUnit.MILLISECONDS);
    } else {
      paramMediaPlayer.run();
    }
    paramMediaPlayer = this.this$0.getStateChangeListener();
    if (paramMediaPlayer != null) {
      paramMediaPlayer.onEnded();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tritonaudio.inneraudio.InnerAudioPlayer.mOnCompletionListener.1
 * JD-Core Version:    0.7.0.1
 */