import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import java.lang.ref.WeakReference;

class qiy
  implements MediaPlayer.OnCompletionListener
{
  qiy(qiw paramqiw) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    qiw.a(this.a).a = false;
    paramMediaPlayer = (qiz)qiw.a(this.a).get();
    if (paramMediaPlayer != null)
    {
      paramMediaPlayer.b(qiw.a(this.a));
      this.a.a(false, "ugc voice play");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qiy
 * JD-Core Version:    0.7.0.1
 */