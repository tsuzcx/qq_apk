package dov.com.qq.im.ae.camera.ui.topbar;

import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.support.annotation.Nullable;
import dov.com.qq.im.ae.AEPituCameraUnit;
import dov.com.qq.im.ae.camera.ui.VideoStoryPiecesPart;
import dov.com.qq.im.ae.util.AEThemeUtil;
import dov.com.qq.im.ae.view.AECircleCaptureStyle;

class AEVideoStoryTopBarPart$5
  implements Observer<AEVideoStoryTopBarViewModel.Ratio>
{
  AEVideoStoryTopBarPart$5(AEVideoStoryTopBarPart paramAEVideoStoryTopBarPart) {}
  
  public void a(@Nullable AEVideoStoryTopBarViewModel.Ratio paramRatio)
  {
    if (paramRatio == null) {
      return;
    }
    AEThemeUtil.a();
    Object localObject = VideoStoryPiecesPart.a(paramRatio);
    AEVideoStoryTopBarPart.a(this.a, (AECircleCaptureStyle)localObject);
    localObject = new Intent();
    ((Intent)localObject).setAction("ae_editor_bottom_tab_change_style");
    if (paramRatio == AEVideoStoryTopBarViewModel.Ratio.FULL) {}
    for (boolean bool = true;; bool = false)
    {
      ((Intent)localObject).putExtra("is_full_screen_capture", bool);
      AEVideoStoryTopBarPart.a(this.a).a().sendBroadcast((Intent)localObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarPart.5
 * JD-Core Version:    0.7.0.1
 */