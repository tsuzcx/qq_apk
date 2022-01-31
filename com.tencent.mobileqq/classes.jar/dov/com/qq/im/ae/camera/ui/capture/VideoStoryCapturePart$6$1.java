package dov.com.qq.im.ae.camera.ui.capture;

import bimj;
import bimo;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import mqq.os.MqqHandler;

public class VideoStoryCapturePart$6$1
  implements Runnable
{
  public VideoStoryCapturePart$6$1(bimo parambimo) {}
  
  public void run()
  {
    bimj.a(this.a.a).setOnFrameDraw(null);
    ThreadManager.getUIHandler().postDelayed(new VideoStoryCapturePart.6.1.1(this), 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.capture.VideoStoryCapturePart.6.1
 * JD-Core Version:    0.7.0.1
 */