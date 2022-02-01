package dov.com.qq.im.ae.camera.ui.aiscene;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio;

class VideoStoryAIScenePart$4
  implements Observer<AEVideoStoryTopBarViewModel.Ratio>
{
  VideoStoryAIScenePart$4(VideoStoryAIScenePart paramVideoStoryAIScenePart) {}
  
  public void a(@Nullable AEVideoStoryTopBarViewModel.Ratio paramRatio)
  {
    if (paramRatio == null) {
      return;
    }
    VideoStoryAIScenePart.a(this.a, paramRatio);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.aiscene.VideoStoryAIScenePart.4
 * JD-Core Version:    0.7.0.1
 */