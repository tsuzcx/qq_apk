package com.tencent.mobileqq.tritonaudio.inneraudio;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.webkit.URLUtil;
import com.tencent.mobileqq.triton.utils.LogDelegate;
import com.tencent.mobileqq.triton.utils.LogDelegate.DefaultImpls;
import com.tencent.mobileqq.triton.utils.LogDelegate.Level;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/media/MediaPlayer;", "kotlin.jvm.PlatformType", "onPrepared"}, k=3, mv={1, 1, 16})
final class InnerAudioPlayer$mOnPreparedListener$1
  implements MediaPlayer.OnPreparedListener
{
  InnerAudioPlayer$mOnPreparedListener$1(InnerAudioPlayer paramInnerAudioPlayer) {}
  
  public final void onPrepared(MediaPlayer paramMediaPlayer)
  {
    try
    {
      paramMediaPlayer = InnerAudioPlayer.access$getLogger$p(this.this$0);
      if (paramMediaPlayer != null) {
        LogDelegate.DefaultImpls.printLog$default(paramMediaPlayer, LogDelegate.Level.INFO, InnerAudioPlayer.access$getTAG$cp(), "onPrepared audioId=" + this.this$0.getAudioId() + " path=" + this.this$0.getAudioPath(), null, 8, null);
      }
      InnerAudioPlayer.access$setMIsPrepared$p(this.this$0, true);
      if (!URLUtil.isNetworkUrl(this.this$0.getAudioPath())) {
        InnerAudioPlayer.access$setMBufferedTime$p(this.this$0, this.this$0.getDuration());
      }
      InnerAudioPlayer.access$execOperateTasks(this.this$0);
      if (this.this$0.getAutoPlay())
      {
        paramMediaPlayer = InnerAudioPlayer.access$getLogger$p(this.this$0);
        if (paramMediaPlayer != null) {
          LogDelegate.DefaultImpls.printLog$default(paramMediaPlayer, LogDelegate.Level.INFO, InnerAudioPlayer.access$getTAG$cp(), "onPrepared:autoplay after prepared. audioId=" + this.this$0.getAudioId() + " path=" + this.this$0.getAudioPath(), null, 8, null);
        }
        this.this$0.play();
      }
      return;
    }
    catch (Throwable paramMediaPlayer)
    {
      LogDelegate localLogDelegate;
      do
      {
        localLogDelegate = InnerAudioPlayer.access$getLogger$p(this.this$0);
      } while (localLogDelegate == null);
      localLogDelegate.printLog(LogDelegate.Level.ERROR, InnerAudioPlayer.access$getTAG$cp(), "onPrepared error. audioId=" + this.this$0.getAudioId() + " path=" + this.this$0.getAudioPath(), paramMediaPlayer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tritonaudio.inneraudio.InnerAudioPlayer.mOnPreparedListener.1
 * JD-Core Version:    0.7.0.1
 */