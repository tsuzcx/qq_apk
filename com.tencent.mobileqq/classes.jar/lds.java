import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.av.VideoController;

public abstract class lds
  implements MediaPlayer.OnCompletionListener
{
  public long a;
  
  public lds(VideoController paramVideoController) {}
  
  public String toString()
  {
    return "Custom." + this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lds
 * JD-Core Version:    0.7.0.1
 */