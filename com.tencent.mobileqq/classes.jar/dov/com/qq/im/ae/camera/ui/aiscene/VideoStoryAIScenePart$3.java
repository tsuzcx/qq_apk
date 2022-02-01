package dov.com.qq.im.ae.camera.ui.aiscene;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.qq.im.ae.mode.AECaptureModeChangingEvent;

class VideoStoryAIScenePart$3
  implements Observer<AECaptureModeChangingEvent>
{
  VideoStoryAIScenePart$3(VideoStoryAIScenePart paramVideoStoryAIScenePart) {}
  
  public void a(@Nullable AECaptureModeChangingEvent paramAECaptureModeChangingEvent)
  {
    if (paramAECaptureModeChangingEvent == null) {}
    while (paramAECaptureModeChangingEvent.b != AECaptureMode.PLAY) {
      return;
    }
    VideoStoryAIScenePart.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.aiscene.VideoStoryAIScenePart.3
 * JD-Core Version:    0.7.0.1
 */