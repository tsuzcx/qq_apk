import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import java.lang.ref.WeakReference;

class seo
  implements MediaPlayer.OnPreparedListener
{
  seo(sen paramsen) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    try
    {
      paramMediaPlayer.start();
      sen.a(this.a).isPlaying = true;
      paramMediaPlayer = (seq)sen.a(this.a).get();
      if (paramMediaPlayer != null)
      {
        paramMediaPlayer.a(sen.a(this.a));
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
 * Qualified Name:     seo
 * JD-Core Version:    0.7.0.1
 */