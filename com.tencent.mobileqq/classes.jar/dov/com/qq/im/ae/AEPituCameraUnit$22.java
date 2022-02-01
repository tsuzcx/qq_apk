package dov.com.qq.im.ae;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import dov.com.qq.im.ae.util.AEQLog;

class AEPituCameraUnit$22
  implements Observer<Boolean>
{
  AEPituCameraUnit$22(AEPituCameraUnit paramAEPituCameraUnit) {}
  
  public void a(@Nullable Boolean paramBoolean)
  {
    AEQLog.b(this.a.b, "getTplPanelVisibleLiveData--isShow=" + paramBoolean);
    AEPituCameraUnit.c(this.a, Boolean.TRUE.equals(paramBoolean));
    AEPituCameraUnit.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.22
 * JD-Core Version:    0.7.0.1
 */