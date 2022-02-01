package org.light.device;

import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;

final class LightDeviceUtils$2
  implements View.OnSystemUiVisibilityChangeListener
{
  LightDeviceUtils$2(View paramView) {}
  
  public void onSystemUiVisibilityChange(int paramInt)
  {
    if ((paramInt & 0x4) == 0) {
      this.val$decorView.setSystemUiVisibility(5894);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.light.device.LightDeviceUtils.2
 * JD-Core Version:    0.7.0.1
 */