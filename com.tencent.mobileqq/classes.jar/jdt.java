import android.content.Context;
import android.media.AudioManager;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;

public class jdt
  implements Runnable
{
  public jdt(VideoController paramVideoController) {}
  
  public void run()
  {
    if (this.a.a().N) {
      ((AudioManager)this.a.a.getSystemService("audio")).setSpeakerphoneOn(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jdt
 * JD-Core Version:    0.7.0.1
 */