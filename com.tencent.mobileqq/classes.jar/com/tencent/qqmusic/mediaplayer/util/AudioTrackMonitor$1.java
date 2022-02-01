package com.tencent.qqmusic.mediaplayer.util;

import android.media.AudioTrack;
import java.lang.ref.WeakReference;

class AudioTrackMonitor$1
  extends Thread
{
  AudioTrackMonitor$1(AudioTrackMonitor paramAudioTrackMonitor, String paramString)
  {
    super(paramString);
  }
  
  public void run()
  {
    super.run();
    while (!AudioTrackMonitor.access$000(this.this$0))
    {
      try
      {
        Thread.currentThread();
        Thread.sleep(AudioTrackMonitor.access$100(this.this$0));
      }
      catch (Throwable localThrowable1)
      {
        Logger.e("AudioTrackMonitor", localThrowable1);
      }
      try
      {
        if ((AudioTrackMonitor.access$200(this.this$0) == null) || (AudioTrackMonitor.access$200(this.this$0).get() == null)) {
          break;
        }
        AudioTrack localAudioTrack = (AudioTrack)AudioTrackMonitor.access$200(this.this$0).get();
        if (localAudioTrack != null)
        {
          long l1 = localAudioTrack.getPlaybackHeadPosition();
          long l2 = AudioTrackMonitor.access$300(this.this$0);
          AudioTrackMonitor.access$302(this.this$0, l1);
          long l3 = System.nanoTime();
          long l4 = AudioTrackMonitor.access$400(this.this$0);
          AudioTrackMonitor.access$402(this.this$0, System.nanoTime());
          StringBuilder localStringBuilder = AudioTrackMonitor.access$500(this.this$0);
          localStringBuilder.append("play-speedTime-");
          localStringBuilder.append(l3 - l4);
          localStringBuilder.append(",play-speedPosition-");
          localStringBuilder.append(l1 - l2);
          localStringBuilder = AudioTrackMonitor.access$500(this.this$0);
          localStringBuilder.append(",playstate-");
          localStringBuilder.append(localAudioTrack.getPlayState());
          Logger.e("AudioTrackMonitor", AudioTrackMonitor.access$500(this.this$0).toString());
          AudioTrackMonitor.access$500(this.this$0).delete(0, AudioTrackMonitor.access$500(this.this$0).length());
        }
      }
      catch (Throwable localThrowable2)
      {
        Logger.e("AudioTrackMonitor", localThrowable2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.util.AudioTrackMonitor.1
 * JD-Core Version:    0.7.0.1
 */