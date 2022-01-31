import com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeControl;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;

public class mhr
  implements Runnable
{
  public mhr(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter) {}
  
  public void run()
  {
    VideoVolumeControl.a().c(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mhr
 * JD-Core Version:    0.7.0.1
 */