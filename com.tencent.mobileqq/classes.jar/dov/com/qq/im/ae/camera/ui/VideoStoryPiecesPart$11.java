package dov.com.qq.im.ae.camera.ui;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.videostory.capture.widgets.SquareRoundImageView;
import com.tencent.image.URLImageView;
import dov.com.qq.im.ae.data.AEMaterialManager;
import dov.com.qq.im.ae.mode.AEVideoStoryCaptureModeViewModel;
import dov.com.qq.im.ae.part.VideoStoryCapturePartManager;
import dov.com.qq.im.ae.util.AEQLog;

class VideoStoryPiecesPart$11
  implements Observer<Boolean>
{
  VideoStoryPiecesPart$11(VideoStoryPiecesPart paramVideoStoryPiecesPart) {}
  
  public void a(@Nullable Boolean paramBoolean)
  {
    if (paramBoolean == null) {
      return;
    }
    if (paramBoolean.booleanValue()) {
      if (VideoStoryPiecesPart.a(this.a).a())
      {
        VideoStoryPiecesPart.d(this.a).setVisibility(0);
        VideoStoryPiecesPart.a(this.a).setVisibility(8);
        this.a.a(false);
        VideoStoryPiecesPart.a(this.a, false);
      }
    }
    for (;;)
    {
      AEQLog.a("VideoStoryPiecesPart", "[GifAuthor]---checkShowGifAuthor when other buttons visibility change");
      VideoStoryPiecesPart.c(this.a);
      VideoStoryPiecesPart.d(this.a);
      return;
      if (VideoStoryPiecesPart.a(this.a).b())
      {
        VideoStoryPiecesPart.d(this.a).setVisibility(0);
        this.a.a(true);
        VideoStoryPiecesPart.a(this.a, true);
        if (VideoStoryPiecesPart.d(this.a)) {
          VideoStoryPiecesPart.a(this.a).setVisibility(0);
        }
        if ((AEMaterialManager.a()) && (VideoStoryPiecesPart.a(this.a) != null)) {
          VideoStoryPiecesPart.a(this.a).setVisibility(0);
        }
        VideoStoryPiecesPart.a(this.a).a(786435, new Object[0]);
      }
      else if (VideoStoryPiecesPart.a(this.a).c())
      {
        VideoStoryPiecesPart.d(this.a).setVisibility(0);
        VideoStoryPiecesPart.a(this.a).setVisibility(8);
        VideoStoryPiecesPart.a(this.a, false);
        this.a.a(false);
        continue;
        VideoStoryPiecesPart.a(this.a).setVisibility(8);
        VideoStoryPiecesPart.a(this.a, false);
        if (VideoStoryPiecesPart.a(this.a) != null) {
          VideoStoryPiecesPart.a(this.a).setVisibility(8);
        }
        VideoStoryPiecesPart.b(this.a).a(786434, new Object[0]);
        if (VideoStoryPiecesPart.a(this.a) != null) {
          VideoStoryPiecesPart.a(this.a).setVisibility(8);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.VideoStoryPiecesPart.11
 * JD-Core Version:    0.7.0.1
 */