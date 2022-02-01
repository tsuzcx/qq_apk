package dov.com.qq.im.ae;

import com.tencent.ttpic.openapi.filter.CosFunHelper.CountDownListener;
import com.tencent.ttpic.openapi.model.VideoMaterial;

class AEPituCameraUnit$11
  implements CosFunHelper.CountDownListener
{
  AEPituCameraUnit$11(AEPituCameraUnit paramAEPituCameraUnit) {}
  
  public void onCountDownEnd()
  {
    this.a.T();
  }
  
  public void onCountDownStart(VideoMaterial paramVideoMaterial)
  {
    AEPituCameraUnit.a(this.a, paramVideoMaterial.getTipsDrawable());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.11
 * JD-Core Version:    0.7.0.1
 */