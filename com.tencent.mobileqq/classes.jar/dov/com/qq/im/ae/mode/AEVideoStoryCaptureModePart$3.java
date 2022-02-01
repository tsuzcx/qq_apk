package dov.com.qq.im.ae.mode;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.view.View;

class AEVideoStoryCaptureModePart$3
  implements Observer<Boolean>
{
  AEVideoStoryCaptureModePart$3(AEVideoStoryCaptureModePart paramAEVideoStoryCaptureModePart) {}
  
  public void a(@Nullable Boolean paramBoolean)
  {
    if (paramBoolean == null) {}
    while (!AEVideoStoryCaptureModePart.b(this.a)) {
      return;
    }
    View localView = AEVideoStoryCaptureModePart.a(this.a);
    if (paramBoolean.booleanValue()) {}
    for (int i = 0;; i = 4)
    {
      localView.setVisibility(i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.mode.AEVideoStoryCaptureModePart.3
 * JD-Core Version:    0.7.0.1
 */