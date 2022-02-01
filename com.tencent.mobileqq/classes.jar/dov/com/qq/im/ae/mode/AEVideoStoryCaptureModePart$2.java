package dov.com.qq.im.ae.mode;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.widget.ImageView;
import dov.com.qq.im.ae.part.VideoStoryCapturePartManager;

class AEVideoStoryCaptureModePart$2
  implements Observer<AECaptureModeChangingEvent>
{
  AEVideoStoryCaptureModePart$2(AEVideoStoryCaptureModePart paramAEVideoStoryCaptureModePart) {}
  
  public void a(@Nullable AECaptureModeChangingEvent paramAECaptureModeChangingEvent)
  {
    boolean bool = false;
    if (paramAECaptureModeChangingEvent == null) {
      return;
    }
    paramAECaptureModeChangingEvent = paramAECaptureModeChangingEvent.b;
    AEVideoStoryCaptureModePart.a(this.a, paramAECaptureModeChangingEvent);
    if (paramAECaptureModeChangingEvent != AECaptureMode.NORMAL) {
      AEVideoStoryCaptureModePart.a(this.a).a(196616, new Object[0]);
    }
    int i;
    if (AEVideoStoryCaptureModePart.a(this.a) != null)
    {
      i = 0;
      if (i < AEVideoStoryCaptureModePart.a(this.a).length) {
        if (paramAECaptureModeChangingEvent != AEVideoStoryCaptureModePart.a(this.a)[i]) {}
      }
    }
    for (;;)
    {
      if (i != -1) {
        AEVideoStoryCaptureModePart.a(this.a).setCurrentItem(i, true);
      }
      AEVideoStoryCaptureModePart localAEVideoStoryCaptureModePart = this.a;
      if (paramAECaptureModeChangingEvent == AECaptureMode.GIF) {
        bool = true;
      }
      AEVideoStoryCaptureModePart.a(localAEVideoStoryCaptureModePart, bool);
      AEVideoStoryCaptureModePart.a(this.a).notifyDataSetChanged();
      paramAECaptureModeChangingEvent = AEVideoStoryCaptureModePart.a(this.a);
      if (AEVideoStoryCaptureModePart.a(this.a)) {}
      for (i = 2130837611;; i = 2130837612)
      {
        paramAECaptureModeChangingEvent.setImageResource(i);
        return;
        i += 1;
        break;
      }
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.mode.AEVideoStoryCaptureModePart.2
 * JD-Core Version:    0.7.0.1
 */