import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.camera.CameraUtils;
import com.tencent.qphone.base.util.QLog;

public class jgx
  implements Runnable
{
  public jgx(CameraUtils paramCameraUtils) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraUtils", 2, "NoPreviewRunnable.run");
    }
    this.a.a.a().a(new Object[] { Integer.valueOf(38), Integer.valueOf(2) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jgx
 * JD-Core Version:    0.7.0.1
 */