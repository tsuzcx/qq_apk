import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.core.VcControllerImpl;

public class jfu
  implements Runnable
{
  public jfu(VideoController paramVideoController) {}
  
  public void run()
  {
    if ((this.a.a().a) && (this.a.a().i) && (this.a.a().d == 2))
    {
      this.a.a().f = false;
      this.a.a.pauseVideo(this.a.a().c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jfu
 * JD-Core Version:    0.7.0.1
 */