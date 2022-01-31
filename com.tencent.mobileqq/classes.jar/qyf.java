import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import java.lang.ref.WeakReference;

class qyf
  implements MediaPlayer.OnCompletionListener
{
  qyf(qyd paramqyd) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    qyd.a(this.a).a = false;
    paramMediaPlayer = (qyg)qyd.a(this.a).get();
    if (paramMediaPlayer != null)
    {
      paramMediaPlayer.b(qyd.a(this.a));
      this.a.a(false, "ugc voice play");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qyf
 * JD-Core Version:    0.7.0.1
 */