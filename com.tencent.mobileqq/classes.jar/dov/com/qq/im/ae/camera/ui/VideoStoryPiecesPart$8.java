package dov.com.qq.im.ae.camera.ui;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.biz.qqstory.view.widget.bubble.BubbleTextView;
import com.tencent.biz.videostory.capture.widgets.SquareRoundImageView;
import dov.com.qq.im.ae.AEPituCameraUnit;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ae.camera.ui.panel.BeautyAndFilterPanelViewStubHolder;
import dov.com.qq.im.ae.entry.AECameraEntry;
import dov.com.qq.im.ae.gif.AEVideoStoryGIFTplViewModel;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.qq.im.ae.mode.AECaptureModeChangingEvent;
import dov.com.qq.im.ae.util.AECameraPrefsUtil;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.ae.view.AECircleCaptureStyle;
import dov.com.qq.im.capture.view.CountDownView;
import dov.com.tencent.mobileqq.richmedia.capture.view.AbsAECaptureButton;

class VideoStoryPiecesPart$8
  implements Observer<AECaptureModeChangingEvent>
{
  VideoStoryPiecesPart$8(VideoStoryPiecesPart paramVideoStoryPiecesPart) {}
  
  public void a(@Nullable AECaptureModeChangingEvent paramAECaptureModeChangingEvent)
  {
    if (paramAECaptureModeChangingEvent == null) {}
    label375:
    do
    {
      return;
      paramAECaptureModeChangingEvent = paramAECaptureModeChangingEvent.b;
      VideoStoryPiecesPart.a(this.a, paramAECaptureModeChangingEvent);
      AEQLog.a("VideoStoryPiecesPart", "[GifAuthor]---checkShowGifAuthor when capture mode change");
      VideoStoryPiecesPart.c(this.a);
      if ((paramAECaptureModeChangingEvent == AECaptureMode.GIF) && (VideoStoryPiecesPart.a(this.a) != null) && (VideoStoryPiecesPart.a(this.a).getVisibility() == 0))
      {
        AECameraPrefsUtil.a().a("sp_key_ae_comics_gif_tips", true, 0);
        AEQLog.b("VideoStoryPiecesPart", "[ComicsTips]--set flag: comics gif tips has shown");
      }
      VideoStoryPiecesPart.d(this.a);
      VideoStoryPiecesPart.a(this.a).e();
      if (paramAECaptureModeChangingEvent == AECaptureMode.NORMAL) {
        VideoStoryPiecesPart.a(this.a).f(true);
      }
      for (;;)
      {
        if (VideoStoryPiecesPart.a(this.a) != null) {
          VideoStoryPiecesPart.a(this.a).a(paramAECaptureModeChangingEvent);
        }
        if (paramAECaptureModeChangingEvent != AECaptureMode.NORMAL) {
          break label375;
        }
        VideoStoryPiecesPart.a(this.a).setVisibility(0);
        this.a.b();
        VideoStoryPiecesPart.a(this.a).setMaxDuration(this.a.a(paramAECaptureModeChangingEvent));
        VideoStoryPiecesPart.a(this.a).a(false);
        if (VideoStoryPiecesPart.c(this.a)) {
          VideoStoryPiecesPart.a(this.a).a(true, AECircleCaptureStyle.a);
        }
        VideoStoryPiecesPart.a(this.a).b(false);
        if (VideoStoryPiecesPart.c(this.a))
        {
          int i = this.a.a();
          if (i > 0)
          {
            paramAECaptureModeChangingEvent = (ViewGroup.MarginLayoutParams)VideoStoryPiecesPart.c(this.a).getLayoutParams();
            if (paramAECaptureModeChangingEvent != null)
            {
              paramAECaptureModeChangingEvent.bottomMargin = i;
              VideoStoryPiecesPart.c(this.a).setLayoutParams(paramAECaptureModeChangingEvent);
            }
          }
        }
        if (VideoStoryPiecesPart.d(this.a)) {
          VideoStoryPiecesPart.a(this.a).setVisibility(0);
        }
        VideoStoryPiecesPart.a(this.a, true);
        if (!AECameraEntry.a(VideoStoryPiecesPart.a(this.a).a())) {
          VideoStoryPiecesPart.a(this.a).a().a();
        }
        if (VideoStoryPiecesPart.a(this.a) == null) {
          break;
        }
        VideoStoryPiecesPart.a(this.a).a();
        return;
        VideoStoryPiecesPart.a(this.a).f(false);
      }
      if (paramAECaptureModeChangingEvent == AECaptureMode.GIF)
      {
        VideoStoryPiecesPart.a(this.a).setVisibility(0);
        VideoStoryPiecesPart.a(this.a).setFunctionFlag(4);
        VideoStoryPiecesPart.a(this.a).setMaxDuration(this.a.a(paramAECaptureModeChangingEvent));
        VideoStoryPiecesPart.a(this.a).a(true);
        VideoStoryPiecesPart.a(this.a).b(true);
        if (VideoStoryPiecesPart.d(this.a)) {
          VideoStoryPiecesPart.a(this.a).setVisibility(0);
        }
        VideoStoryPiecesPart.a(this.a, true);
        VideoStoryPiecesPart.a(this.a).a();
        return;
      }
    } while (paramAECaptureModeChangingEvent != AECaptureMode.PLAY);
    VideoStoryPiecesPart.a(this.a).setVisibility(8);
    VideoStoryPiecesPart.a(this.a).setVisibility(8);
    VideoStoryPiecesPart.a(this.a, false);
    VideoStoryPiecesPart.a(this.a).setMaterial(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.VideoStoryPiecesPart.8
 * JD-Core Version:    0.7.0.1
 */