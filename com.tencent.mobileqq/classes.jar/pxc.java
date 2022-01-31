import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import java.lang.ref.WeakReference;

class pxc
  implements MediaPlayer.OnPreparedListener
{
  pxc(pxb parampxb) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    try
    {
      paramMediaPlayer.start();
      pxb.a(this.a).a = true;
      paramMediaPlayer = (pxe)pxb.a(this.a).get();
      if (paramMediaPlayer != null)
      {
        paramMediaPlayer.a(pxb.a(this.a));
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
 * Qualified Name:     pxc
 * JD-Core Version:    0.7.0.1
 */