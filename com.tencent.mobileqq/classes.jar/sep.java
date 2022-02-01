import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import java.lang.ref.WeakReference;

class sep
  implements MediaPlayer.OnCompletionListener
{
  sep(sen paramsen) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    sen.a(this.a).isPlaying = false;
    paramMediaPlayer = (seq)sen.a(this.a).get();
    if (paramMediaPlayer != null)
    {
      paramMediaPlayer.b(sen.a(this.a));
      this.a.a(false, "ugc voice play");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sep
 * JD-Core Version:    0.7.0.1
 */