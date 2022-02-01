package dov.com.qq.im.ae.camera.ui.topbar;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.ae.view.AECompoundButton;

class AEVideoStoryTopBarPart$4
  implements Observer<Boolean>
{
  AEVideoStoryTopBarPart$4(AEVideoStoryTopBarPart paramAEVideoStoryTopBarPart) {}
  
  public void a(@Nullable Boolean paramBoolean)
  {
    AEQLog.a("AEVideoStoryTopBarPart", "【抠背开关】-> observe ->更新按钮状态:" + paramBoolean);
    if (paramBoolean == null) {
      return;
    }
    AEVideoStoryTopBarPart.f(this.a).setSelected(paramBoolean.booleanValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarPart.4
 * JD-Core Version:    0.7.0.1
 */