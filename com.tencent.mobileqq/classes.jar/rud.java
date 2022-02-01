import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import java.lang.ref.WeakReference;

class rud
  implements MediaPlayer.OnPreparedListener
{
  rud(ruc paramruc) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    try
    {
      paramMediaPlayer.start();
      ruc.a(this.a).a = true;
      paramMediaPlayer = (ruf)ruc.a(this.a).get();
      if (paramMediaPlayer != null)
      {
        paramMediaPlayer.a(ruc.a(this.a));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rud
 * JD-Core Version:    0.7.0.1
 */