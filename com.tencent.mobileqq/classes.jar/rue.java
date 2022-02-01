import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import java.lang.ref.WeakReference;

class rue
  implements MediaPlayer.OnCompletionListener
{
  rue(ruc paramruc) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    ruc.a(this.a).a = false;
    paramMediaPlayer = (ruf)ruc.a(this.a).get();
    if (paramMediaPlayer != null)
    {
      paramMediaPlayer.b(ruc.a(this.a));
      this.a.a(false, "ugc voice play");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rue
 * JD-Core Version:    0.7.0.1
 */