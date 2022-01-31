import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.av.VideoController;

public abstract class lfv
  implements MediaPlayer.OnCompletionListener
{
  public long a;
  
  public lfv(VideoController paramVideoController) {}
  
  public String toString()
  {
    return "Custom." + this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lfv
 * JD-Core Version:    0.7.0.1
 */