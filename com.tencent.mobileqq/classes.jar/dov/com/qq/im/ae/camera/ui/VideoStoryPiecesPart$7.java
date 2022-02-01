package dov.com.qq.im.ae.camera.ui;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import dov.com.qq.im.ae.camera.core.AECameraGLSurfaceView;
import dov.com.qq.im.ae.data.AEGifMaterialManager;
import dov.com.qq.im.ae.data.AEMaterialWrapper;
import dov.com.qq.im.ae.download.AEResUtil;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.qq.im.ae.util.AEQLog;

class VideoStoryPiecesPart$7
  implements Observer<AEMaterialWrapper>
{
  VideoStoryPiecesPart$7(VideoStoryPiecesPart paramVideoStoryPiecesPart) {}
  
  public void a(@Nullable AEMaterialWrapper paramAEMaterialWrapper)
  {
    if (VideoStoryPiecesPart.a(this.a) == AECaptureMode.GIF) {
      if (paramAEMaterialWrapper == null) {
        break label61;
      }
    }
    label61:
    for (paramAEMaterialWrapper = AEGifMaterialManager.a().a(paramAEMaterialWrapper.a);; paramAEMaterialWrapper = AEResUtil.f())
    {
      AEGifMaterialManager.a().a(paramAEMaterialWrapper);
      VideoStoryPiecesPart.a(this.a).setMaterial(paramAEMaterialWrapper);
      AEQLog.a("VideoStoryPiecesPart", "[GifAuthor]---checkShowGifAuthor when material change");
      VideoStoryPiecesPart.c(this.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.VideoStoryPiecesPart.7
 * JD-Core Version:    0.7.0.1
 */