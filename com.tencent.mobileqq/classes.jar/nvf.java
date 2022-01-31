import android.util.Log;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaPlayer;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class nvf
  implements Runnable
{
  public nvf(MediaPlayer paramMediaPlayer) {}
  
  public void run()
  {
    try
    {
      this.a.a();
      if (this.a.h == 4) {
        this.a.a.sendEmptyMessage(1);
      }
      return;
    }
    catch (IOException localIOException)
    {
      Log.e("Story-MediaPlayer", "prepareAsync() failed: cannot decode stream(s)", localIOException);
      this.a.a.sendMessage(this.a.a.obtainMessage(100, 1, -1004));
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      Log.e("Story-MediaPlayer", "prepareAsync() failed: something is in a wrong state", localIllegalStateException);
      this.a.a.sendMessage(this.a.a.obtainMessage(100, 1, 0));
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      Log.e("Story-MediaPlayer", "prepareAsync() failed: surface might be gone", localIllegalArgumentException);
      this.a.a.sendMessage(this.a.a.obtainMessage(100, 1, 0));
      return;
    }
    finally
    {
      MediaPlayer.a(this.a).countDown();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nvf
 * JD-Core Version:    0.7.0.1
 */