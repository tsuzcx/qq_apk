package dov.com.qq.im.ae;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import dov.com.qq.im.ae.util.AEQLog;

class AEPituCameraUnit$20
  implements Observer<Boolean>
{
  AEPituCameraUnit$20(AEPituCameraUnit paramAEPituCameraUnit) {}
  
  public void a(@Nullable Boolean paramBoolean)
  {
    AEQLog.b(this.a.b, "getCapturingLiveData--isCapturing=" + paramBoolean);
    dov.com.qq.im.ae.data.AEMaterialManager.a = paramBoolean.booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.20
 * JD-Core Version:    0.7.0.1
 */