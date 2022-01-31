import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import java.lang.ref.WeakReference;

class qja
  implements MediaPlayer.OnPreparedListener
{
  qja(qiz paramqiz) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    try
    {
      paramMediaPlayer.start();
      qiz.a(this.a).a = true;
      paramMediaPlayer = (qjc)qiz.a(this.a).get();
      if (paramMediaPlayer != null)
      {
        paramMediaPlayer.a(qiz.a(this.a));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qja
 * JD-Core Version:    0.7.0.1
 */