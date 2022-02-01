package dov.com.qq.im.ae.camera.ui.capture;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.qq.im.ae.mode.AECaptureModeChangingEvent;
import dov.com.qq.im.ae.util.AEQLog;

class VideoStoryCapturePart$6
  implements Observer<AECaptureModeChangingEvent>
{
  VideoStoryCapturePart$6(VideoStoryCapturePart paramVideoStoryCapturePart) {}
  
  public void a(@Nullable AECaptureModeChangingEvent paramAECaptureModeChangingEvent)
  {
    if (paramAECaptureModeChangingEvent == null)
    {
      AEQLog.d("VideoStoryCapturePart", "modeChangingEvent is null, return");
      return;
    }
    paramAECaptureModeChangingEvent = paramAECaptureModeChangingEvent.b;
    VideoStoryCapturePart.a(this.a, paramAECaptureModeChangingEvent);
    Boolean localBoolean = (Boolean)VideoStoryCapturePart.a(this.a).b().getValue();
    boolean bool;
    if (paramAECaptureModeChangingEvent == AECaptureMode.GIF)
    {
      VideoStoryCapturePart.a(this.a);
      VideoStoryCapturePart.a(this.a).setVisibility(0);
      AECameraGLSurfaceView localAECameraGLSurfaceView = VideoStoryCapturePart.a(this.a);
      if ((localBoolean != null) && (localBoolean.booleanValue()))
      {
        bool = true;
        localAECameraGLSurfaceView.switchSegment(bool);
      }
    }
    for (;;)
    {
      VideoStoryCapturePart.a(this.a, paramAECaptureModeChangingEvent);
      return;
      bool = false;
      break;
      if (VideoStoryCapturePart.a(this.a)) {
        VideoStoryCapturePart.a(this.a).setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.capture.VideoStoryCapturePart.6
 * JD-Core Version:    0.7.0.1
 */