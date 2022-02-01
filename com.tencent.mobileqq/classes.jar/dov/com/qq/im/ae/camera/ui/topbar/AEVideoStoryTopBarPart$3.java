package dov.com.qq.im.ae.camera.ui.topbar;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import dov.com.qq.im.ae.view.AECompoundButton;

class AEVideoStoryTopBarPart$3
  implements Observer<AEVideoStoryTopBarViewModel.CountDownSetting>
{
  AEVideoStoryTopBarPart$3(AEVideoStoryTopBarPart paramAEVideoStoryTopBarPart) {}
  
  public void a(@Nullable AEVideoStoryTopBarViewModel.CountDownSetting paramCountDownSetting)
  {
    if (paramCountDownSetting == null) {
      return;
    }
    AEVideoStoryTopBarPart.e(this.a).setSelected(paramCountDownSetting.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarPart.3
 * JD-Core Version:    0.7.0.1
 */