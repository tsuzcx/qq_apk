import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import java.lang.ref.WeakReference;

class qix
  implements MediaPlayer.OnPreparedListener
{
  qix(qiw paramqiw) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    try
    {
      paramMediaPlayer.start();
      qiw.a(this.a).a = true;
      paramMediaPlayer = (qiz)qiw.a(this.a).get();
      if (paramMediaPlayer != null)
      {
        paramMediaPlayer.a(qiw.a(this.a));
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
 * Qualified Name:     qix
 * JD-Core Version:    0.7.0.1
 */