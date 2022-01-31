import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;

public class jex
  implements MediaPlayer.OnCompletionListener
{
  public jex(VideoController paramVideoController) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    AVLog.d(VideoController.a, "onCompletion onClose");
    if (paramMediaPlayer != null) {
      paramMediaPlayer.release();
    }
    if (!this.a.a().h())
    {
      AVLog.d(VideoController.a, "onCompletion onClose is not Closing2");
      return;
    }
    this.a.a(this.a.a().c, 0);
    this.a.b(217);
    this.a.c(this.a.a().c, this.a.a().z);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jex
 * JD-Core Version:    0.7.0.1
 */