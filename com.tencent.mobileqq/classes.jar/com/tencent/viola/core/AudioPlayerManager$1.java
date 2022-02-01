package com.tencent.viola.core;

import android.media.MediaPlayer;
import android.os.Handler;
import android.util.SparseArray;
import com.tencent.viola.utils.ViolaLogUtils;

class AudioPlayerManager$1
  implements Runnable
{
  AudioPlayerManager$1(AudioPlayerManager paramAudioPlayerManager) {}
  
  public void run()
  {
    Object localObject = (AudioPlayerManager.AudioManagerListener)AudioPlayerManager.access$100(this.this$0).get(AudioPlayerManager.access$000(this.this$0));
    int i = ((Integer)AudioPlayerManager.access$200(this.this$0).get(AudioPlayerManager.access$000(this.this$0), Integer.valueOf(1000))).intValue();
    if ((localObject != null) && (AudioPlayerManager.access$300(this.this$0).isPlaying()))
    {
      ((AudioPlayerManager.AudioManagerListener)localObject).playTimeChange(AudioPlayerManager.access$300(this.this$0).getCurrentPosition(), AudioPlayerManager.access$300(this.this$0).getDuration());
      AudioPlayerManager.access$400(this.this$0).postDelayed(this, i);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("timerChange,data:");
    ((StringBuilder)localObject).append(AudioPlayerManager.access$500(this.this$0));
    ((StringBuilder)localObject).append(",currentDuration:");
    ((StringBuilder)localObject).append(AudioPlayerManager.access$300(this.this$0).getCurrentPosition());
    ((StringBuilder)localObject).append(",totalDuration:");
    ((StringBuilder)localObject).append(AudioPlayerManager.access$300(this.this$0).getDuration());
    ((StringBuilder)localObject).append(",isPlaying:");
    ((StringBuilder)localObject).append(AudioPlayerManager.access$300(this.this$0).isPlaying());
    ViolaLogUtils.d("AudioPlayerManager", ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.core.AudioPlayerManager.1
 * JD-Core Version:    0.7.0.1
 */