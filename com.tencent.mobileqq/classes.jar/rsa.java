import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import java.lang.ref.WeakReference;

class rsa
  implements MediaPlayer.OnCompletionListener
{
  rsa(rry paramrry) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    rry.a(this.a).a = false;
    paramMediaPlayer = (rsb)rry.a(this.a).get();
    if (paramMediaPlayer != null)
    {
      paramMediaPlayer.b(rry.a(this.a));
      this.a.a(false, "ugc voice play");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rsa
 * JD-Core Version:    0.7.0.1
 */