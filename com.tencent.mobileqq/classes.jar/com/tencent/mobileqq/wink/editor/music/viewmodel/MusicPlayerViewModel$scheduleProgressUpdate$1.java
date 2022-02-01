package com.tencent.mobileqq.wink.editor.music.viewmodel;

import android.media.MediaPlayer;
import androidx.lifecycle.MutableLiveData;
import java.util.TimerTask;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/wink/editor/music/viewmodel/MusicPlayerViewModel$scheduleProgressUpdate$1", "Ljava/util/TimerTask;", "run", "", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class MusicPlayerViewModel$scheduleProgressUpdate$1
  extends TimerTask
{
  public void run()
  {
    try
    {
      MediaPlayer localMediaPlayer = MusicPlayerViewModel.a(this.this$0);
      if ((localMediaPlayer != null) && (localMediaPlayer.isPlaying()))
      {
        int i = localMediaPlayer.getCurrentPosition();
        this.this$0.b().postValue(Integer.valueOf(i));
        int j = MusicPlayerViewModel.b(this.this$0).c();
        if (1 > j) {
          return;
        }
        if (i >= j)
        {
          localMediaPlayer = MusicPlayerViewModel.a(this.this$0);
          if (localMediaPlayer != null) {
            localMediaPlayer.seekTo(MusicPlayerViewModel.b(this.this$0).b());
          }
        }
      }
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.viewmodel.MusicPlayerViewModel.scheduleProgressUpdate.1
 * JD-Core Version:    0.7.0.1
 */