package dov.com.qq.im.ae.camera.ui.bottom;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import dov.com.qq.im.ae.mode.AEVideoStoryCaptureModeViewModel;

class AEBottomListPart$3
  implements Observer<Boolean>
{
  AEBottomListPart$3(AEBottomListPart paramAEBottomListPart) {}
  
  public void a(@Nullable Boolean paramBoolean)
  {
    if (paramBoolean == null) {}
    do
    {
      return;
      if (AEBottomListPart.a(this.a).a())
      {
        this.a.a.setVisibility(8);
        return;
      }
      if (AEBottomListPart.a(this.a).b())
      {
        if (!AEBottomListPart.a(this.a))
        {
          AEBottomListScrollView localAEBottomListScrollView = this.a.a;
          if (paramBoolean.booleanValue()) {}
          for (int i = 0;; i = 4)
          {
            localAEBottomListScrollView.setVisibility(i);
            return;
          }
        }
        this.a.a.setVisibility(8);
        return;
      }
    } while (!AEBottomListPart.a(this.a).c());
    this.a.a.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.bottom.AEBottomListPart.3
 * JD-Core Version:    0.7.0.1
 */