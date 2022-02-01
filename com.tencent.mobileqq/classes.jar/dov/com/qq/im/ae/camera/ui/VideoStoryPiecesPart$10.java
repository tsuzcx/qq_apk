package dov.com.qq.im.ae.camera.ui;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import dov.com.qq.im.ae.camera.ui.panel.AEWaterMarkPanel;
import dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio;
import dov.com.qq.im.ae.view.AECircleCaptureStyle;

class VideoStoryPiecesPart$10
  implements Observer<AEVideoStoryTopBarViewModel.Ratio>
{
  VideoStoryPiecesPart$10(VideoStoryPiecesPart paramVideoStoryPiecesPart) {}
  
  public void a(@Nullable AEVideoStoryTopBarViewModel.Ratio paramRatio)
  {
    if (paramRatio == null) {
      return;
    }
    AECircleCaptureStyle localAECircleCaptureStyle = VideoStoryPiecesPart.a(paramRatio);
    if (VideoStoryPiecesPart.a(this.a) != null) {
      VideoStoryPiecesPart.a(this.a).setCaptureRadio(paramRatio);
    }
    VideoStoryPiecesPart.a(this.a, localAECircleCaptureStyle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.VideoStoryPiecesPart.10
 * JD-Core Version:    0.7.0.1
 */