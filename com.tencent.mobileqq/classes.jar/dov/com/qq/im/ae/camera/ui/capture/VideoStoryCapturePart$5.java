package dov.com.qq.im.ae.camera.ui.capture;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.qq.im.ae.util.AEQLog;

class VideoStoryCapturePart$5
  implements Observer<Boolean>
{
  VideoStoryCapturePart$5(VideoStoryCapturePart paramVideoStoryCapturePart) {}
  
  public void a(@Nullable Boolean paramBoolean)
  {
    if (paramBoolean == null) {}
    while ((VideoStoryCapturePart.a(this.a) == null) || (VideoStoryCapturePart.a(this.a) != AECaptureMode.GIF)) {
      return;
    }
    AEQLog.a("VideoStoryCapturePart", "【抠背开关】->observe:" + paramBoolean);
    VideoStoryCapturePart.a(this.a).switchSegment(paramBoolean.booleanValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.capture.VideoStoryCapturePart.5
 * JD-Core Version:    0.7.0.1
 */