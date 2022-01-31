import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import java.lang.ref.WeakReference;

class pxd
  implements MediaPlayer.OnCompletionListener
{
  pxd(pxb parampxb) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    pxb.a(this.a).a = false;
    paramMediaPlayer = (pxe)pxb.a(this.a).get();
    if (paramMediaPlayer != null)
    {
      paramMediaPlayer.b(pxb.a(this.a));
      this.a.a(false, "ugc voice play");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pxd
 * JD-Core Version:    0.7.0.1
 */