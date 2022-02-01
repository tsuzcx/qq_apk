import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import java.lang.ref.WeakReference;

class rla
  implements MediaPlayer.OnCompletionListener
{
  rla(rky paramrky) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    rky.a(this.a).a = false;
    paramMediaPlayer = (rlb)rky.a(this.a).get();
    if (paramMediaPlayer != null)
    {
      paramMediaPlayer.b(rky.a(this.a));
      this.a.a(false, "ugc voice play");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rla
 * JD-Core Version:    0.7.0.1
 */