import com.tencent.av.AVLog;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.camera.QavCameraUsage;

public class jhc
  implements Runnable
{
  public jhc(VideoAppInterface paramVideoAppInterface) {}
  
  public void run()
  {
    AVLog.d(VideoAppInterface.c(), "CameraUsageRunnable: ");
    QavCameraUsage.a(this.a.getApplication(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jhc
 * JD-Core Version:    0.7.0.1
 */