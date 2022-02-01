import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import java.lang.ref.WeakReference;

class rkz
  implements MediaPlayer.OnPreparedListener
{
  rkz(rky paramrky) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    try
    {
      paramMediaPlayer.start();
      rky.a(this.a).a = true;
      paramMediaPlayer = (rlb)rky.a(this.a).get();
      if (paramMediaPlayer != null)
      {
        paramMediaPlayer.a(rky.a(this.a));
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
 * Qualified Name:     rkz
 * JD-Core Version:    0.7.0.1
 */