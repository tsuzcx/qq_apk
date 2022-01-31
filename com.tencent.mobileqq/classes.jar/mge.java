import com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeControl;
import java.util.TimerTask;

public class mge
  extends TimerTask
{
  public mge(VideoVolumeControl paramVideoVolumeControl) {}
  
  public void run()
  {
    VideoVolumeControl.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mge
 * JD-Core Version:    0.7.0.1
 */