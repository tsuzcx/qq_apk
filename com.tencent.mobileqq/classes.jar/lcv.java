import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.av.VideoController;

public abstract class lcv
  implements MediaPlayer.OnCompletionListener
{
  public long a;
  
  public lcv(VideoController paramVideoController) {}
  
  public String toString()
  {
    return "Custom." + this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lcv
 * JD-Core Version:    0.7.0.1
 */