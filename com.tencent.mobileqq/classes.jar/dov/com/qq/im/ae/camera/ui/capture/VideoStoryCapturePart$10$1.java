package dov.com.qq.im.ae.camera.ui.capture;

import bkvx;
import bkvz;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import mqq.os.MqqHandler;

public class VideoStoryCapturePart$10$1
  implements Runnable
{
  public VideoStoryCapturePart$10$1(bkvz parambkvz) {}
  
  public void run()
  {
    bkvx.a(this.a.a).setOnFrameDraw(null);
    ThreadManager.getUIHandler().postDelayed(new VideoStoryCapturePart.10.1.1(this), 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.capture.VideoStoryCapturePart.10.1
 * JD-Core Version:    0.7.0.1
 */