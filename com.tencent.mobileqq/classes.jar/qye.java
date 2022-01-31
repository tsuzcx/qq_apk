import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import java.lang.ref.WeakReference;

class qye
  implements MediaPlayer.OnPreparedListener
{
  qye(qyd paramqyd) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    try
    {
      paramMediaPlayer.start();
      qyd.a(this.a).a = true;
      paramMediaPlayer = (qyg)qyd.a(this.a).get();
      if (paramMediaPlayer != null)
      {
        paramMediaPlayer.a(qyd.a(this.a));
        this.a.a(true, "ugc voice play");
      }
      return;
    }
    catch (Exception paramMediaPlayer)
    {
      for (;;)
      {
        paramMediaPlayer.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qye
 * JD-Core Version:    0.7.0.1
 */