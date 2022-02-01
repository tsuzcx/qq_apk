package dov.com.qq.im.ae.camera.ui;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.CountDownSetting;
import dov.com.qq.im.capture.view.CountDownView;
import dov.com.tencent.mobileqq.richmedia.capture.view.AbsAECaptureButton;

class VideoStoryPiecesPart$9
  implements Observer<AEVideoStoryTopBarViewModel.CountDownSetting>
{
  VideoStoryPiecesPart$9(VideoStoryPiecesPart paramVideoStoryPiecesPart) {}
  
  public void a(@Nullable AEVideoStoryTopBarViewModel.CountDownSetting paramCountDownSetting)
  {
    if (paramCountDownSetting == null) {
      return;
    }
    boolean bool = paramCountDownSetting.a();
    if (bool) {
      VideoStoryPiecesPart.e(this.a);
    }
    for (;;)
    {
      VideoStoryPiecesPart.a(this.a).a(bool, new VideoStoryPiecesPart.9.1(this, paramCountDownSetting));
      return;
      if (VideoStoryPiecesPart.a(this.a) != null) {
        VideoStoryPiecesPart.a(this.a).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.VideoStoryPiecesPart.9
 * JD-Core Version:    0.7.0.1
 */