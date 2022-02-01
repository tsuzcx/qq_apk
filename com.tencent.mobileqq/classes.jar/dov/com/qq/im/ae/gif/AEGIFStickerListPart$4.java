package dov.com.qq.im.ae.gif;

import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleSlidingIndicator;
import dov.com.qq.im.ae.AEPituCameraUnit;
import dov.com.qq.im.ae.mode.AEVideoStoryCaptureModeViewModel;

class AEGIFStickerListPart$4
  implements Observer<Boolean>
{
  AEGIFStickerListPart$4(AEGIFStickerListPart paramAEGIFStickerListPart) {}
  
  public void a(@Nullable Boolean paramBoolean)
  {
    if (paramBoolean == null) {
      return;
    }
    Intent localIntent = AEGIFStickerListPart.a(this.a).a().getIntent();
    if (localIntent != null) {
      localIntent.getIntExtra("AECAMERA_MODE", 200);
    }
    if (paramBoolean.booleanValue())
    {
      if (AEGIFStickerListPart.a(this.a).a())
      {
        AEGIFStickerListPart.a(this.a).setVisibility(0);
        AEGIFStickerListPart.a(this.a).setVisibility(0);
        return;
      }
      AEGIFStickerListPart.a(this.a).setVisibility(8);
      AEGIFStickerListPart.a(this.a).setVisibility(8);
      return;
    }
    AEGIFStickerListPart.a(this.a).setVisibility(4);
    AEGIFStickerListPart.a(this.a).setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.AEGIFStickerListPart.4
 * JD-Core Version:    0.7.0.1
 */