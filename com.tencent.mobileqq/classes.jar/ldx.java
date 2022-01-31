import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.av.VideoController;

public abstract class ldx
  implements MediaPlayer.OnCompletionListener
{
  public long a;
  
  public ldx(VideoController paramVideoController) {}
  
  public String toString()
  {
    return "Custom." + this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     ldx
 * JD-Core Version:    0.7.0.1
 */