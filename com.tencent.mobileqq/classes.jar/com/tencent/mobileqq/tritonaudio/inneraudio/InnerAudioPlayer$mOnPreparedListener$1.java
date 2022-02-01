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
      if (paramMediaPlayer != null)
      {
        localObject1 = LogDelegate.Level.INFO;
        localObject2 = InnerAudioPlayer.access$getTAG$cp();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("onPrepared audioId=");
        ((StringBuilder)localObject3).append(this.this$0.getAudioId());
        ((StringBuilder)localObject3).append(" path=");
        ((StringBuilder)localObject3).append(this.this$0.getAudioPath());
        LogDelegate.DefaultImpls.printLog$default(paramMediaPlayer, (LogDelegate.Level)localObject1, (String)localObject2, ((StringBuilder)localObject3).toString(), null, 8, null);
      }
      InnerAudioPlayer.access$setMIsPrepared$p(this.this$0, true);
      if (!URLUtil.isNetworkUrl(this.this$0.getAudioPath())) {
        InnerAudioPlayer.access$setMBufferedTime$p(this.this$0, this.this$0.getDuration());
      }
      InnerAudioPlayer.access$execOperateTasks(this.this$0);
      if (this.this$0.getAutoPlay())
      {
        paramMediaPlayer = InnerAudioPlayer.access$getLogger$p(this.this$0);
        if (paramMediaPlayer != null)
        {
          localObject1 = LogDelegate.Level.INFO;
          localObject2 = InnerAudioPlayer.access$getTAG$cp();
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("onPrepared:autoplay after prepared. audioId=");
          ((StringBuilder)localObject3).append(this.this$0.getAudioId());
          ((StringBuilder)localObject3).append(" path=");
          ((StringBuilder)localObject3).append(this.this$0.getAudioPath());
          LogDelegate.DefaultImpls.printLog$default(paramMediaPlayer, (LogDelegate.Level)localObject1, (String)localObject2, ((StringBuilder)localObject3).toString(), null, 8, null);
        }
        this.this$0.play();
        return;
      }
    }
    catch (Throwable paramMediaPlayer)
    {
      Object localObject2;
      Object localObject3;
      Object localObject1 = InnerAudioPlayer.access$getLogger$p(this.this$0);
      if (localObject1 != null)
      {
        localObject2 = LogDelegate.Level.ERROR;
        localObject3 = InnerAudioPlayer.access$getTAG$cp();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onPrepared error. audioId=");
        localStringBuilder.append(this.this$0.getAudioId());
        localStringBuilder.append(" path=");
        localStringBuilder.append(this.this$0.getAudioPath());
        ((LogDelegate)localObject1).printLog((LogDelegate.Level)localObject2, (String)localObject3, localStringBuilder.toString(), paramMediaPlayer);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tritonaudio.inneraudio.InnerAudioPlayer.mOnPreparedListener.1
 * JD-Core Version:    0.7.0.1
 */