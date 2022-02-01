package dov.com.qq.im.ae.gif;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleSlidingIndicator;
import dov.com.qq.im.ae.font.AEFontManager;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.qq.im.ae.mode.AECaptureModeChangingEvent;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import dov.com.qq.im.ae.report.AEBaseReportParam;

class AEGIFStickerListPart$2
  implements Observer<AECaptureModeChangingEvent>
{
  AEGIFStickerListPart$2(AEGIFStickerListPart paramAEGIFStickerListPart) {}
  
  public void a(@Nullable AECaptureModeChangingEvent paramAECaptureModeChangingEvent)
  {
    if (paramAECaptureModeChangingEvent == null) {}
    AECaptureMode localAECaptureMode;
    do
    {
      do
      {
        return;
        localAECaptureMode = paramAECaptureModeChangingEvent.b;
        if (localAECaptureMode == AECaptureMode.NORMAL)
        {
          AEGIFStickerListPart.a(this.a).setVisibility(8);
          AEGIFStickerListPart.a(this.a).setVisibility(8);
          return;
        }
        if (localAECaptureMode != AECaptureMode.GIF) {
          break;
        }
        AEGIFStickerListPart.a(this.a);
        AEFontManager.a().a();
        AEBaseDataReporter.a().ae();
      } while ((paramAECaptureModeChangingEvent.a == null) || (TextUtils.isEmpty(AEGIFStickerListPart.a(this.a))));
      AEBaseReportParam.a().o(AEGIFStickerListPart.a(this.a));
      AEBaseDataReporter.a().ah();
      return;
    } while (localAECaptureMode != AECaptureMode.PLAY);
    AEGIFStickerListPart.a(this.a).setVisibility(8);
    AEGIFStickerListPart.a(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.AEGIFStickerListPart.2
 * JD-Core Version:    0.7.0.1
 */