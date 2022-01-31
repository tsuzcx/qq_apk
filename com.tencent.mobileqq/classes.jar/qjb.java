import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import java.lang.ref.WeakReference;

class qjb
  implements MediaPlayer.OnCompletionListener
{
  qjb(qiz paramqiz) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    qiz.a(this.a).a = false;
    paramMediaPlayer = (qjc)qiz.a(this.a).get();
    if (paramMediaPlayer != null)
    {
      paramMediaPlayer.b(qiz.a(this.a));
      this.a.a(false, "ugc voice play");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qjb
 * JD-Core Version:    0.7.0.1
 */