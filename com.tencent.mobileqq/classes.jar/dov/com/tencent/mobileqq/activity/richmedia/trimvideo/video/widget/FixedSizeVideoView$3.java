package dov.com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

class FixedSizeVideoView$3
  implements MediaPlayer.OnCompletionListener
{
  FixedSizeVideoView$3(FixedSizeVideoView paramFixedSizeVideoView) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (this.a.a != null)
    {
      this.a.removeCallbacks(FixedSizeVideoView.a(this.a));
      this.a.a.a(paramMediaPlayer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView.3
 * JD-Core Version:    0.7.0.1
 */