import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import java.lang.ref.WeakReference;

class rrz
  implements MediaPlayer.OnPreparedListener
{
  rrz(rry paramrry) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    try
    {
      paramMediaPlayer.start();
      rry.a(this.a).a = true;
      paramMediaPlayer = (rsb)rry.a(this.a).get();
      if (paramMediaPlayer != null)
      {
        paramMediaPlayer.a(rry.a(this.a));
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
 * Qualified Name:     rrz
 * JD-Core Version:    0.7.0.1
 */