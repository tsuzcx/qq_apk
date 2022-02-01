package dov.com.qq.im.ae.camera.ui.capture;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.activity.richmedia.Size;
import dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio;
import dov.com.qq.im.ae.util.AEPreviewSizeUtil;
import dov.com.qq.im.ae.util.AEQLog;

class VideoStoryCapturePart$7
  implements Observer<AEVideoStoryTopBarViewModel.Ratio>
{
  VideoStoryCapturePart$7(VideoStoryCapturePart paramVideoStoryCapturePart) {}
  
  public void a(@Nullable AEVideoStoryTopBarViewModel.Ratio paramRatio)
  {
    AEQLog.b("VideoStoryCapturePart", "mCurrentRatio---onChanged: ratio=" + paramRatio);
    if (paramRatio == null) {}
    while (VideoStoryCapturePart.a(this.a) == paramRatio) {
      return;
    }
    VideoStoryCapturePart.a(this.a, paramRatio);
    int i = 0;
    if (paramRatio == AEVideoStoryTopBarViewModel.Ratio.R_4_3) {
      i = VideoStoryCapturePart.a(this.a);
    }
    for (;;)
    {
      Size localSize = AEPreviewSizeUtil.a();
      paramRatio = AEPreviewSizeUtil.a(VideoStoryCapturePart.a(this.a), localSize, VideoStoryCapturePart.b(this.a), paramRatio);
      VideoStoryCapturePart.a(this.a, i, paramRatio);
      VideoStoryCapturePart.a(this.a, localSize, paramRatio);
      return;
      if (paramRatio == AEVideoStoryTopBarViewModel.Ratio.R_1_1) {
        i = VideoStoryCapturePart.a;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.capture.VideoStoryCapturePart.7
 * JD-Core Version:    0.7.0.1
 */