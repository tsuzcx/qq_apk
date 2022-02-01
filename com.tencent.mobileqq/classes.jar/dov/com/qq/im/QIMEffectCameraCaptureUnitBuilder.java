package dov.com.qq.im;

import com.tencent.mobileqq.activity.faceunlock.QFaceUnlockCameraCaptureUnit;
import dov.com.qq.im.ae.AECMShowCameraUnit;
import dov.com.qq.im.ae.AEPituCameraUnit;
import dov.com.qq.im.ae.biz.qcircle.AECircleMultiUnit;
import dov.com.qq.im.setting.ICameraEntrance;
import dov.com.qq.im.setting.IQIMCameraContainer;
import dov.com.qq.im.setting.IQIMCameraLifeCallback;

public class QIMEffectCameraCaptureUnitBuilder
{
  public static IQIMCameraLifeCallback a(int paramInt, IQIMCameraContainer paramIQIMCameraContainer, ICameraEntrance paramICameraEntrance)
  {
    switch (paramInt)
    {
    default: 
      return new AEPituCameraUnit(paramIQIMCameraContainer, paramICameraEntrance);
    case 10026: 
      return new AECircleMultiUnit(paramIQIMCameraContainer, paramICameraEntrance);
    case 10000: 
    case 10013: 
    case 10017: 
    case 10023: 
    case 10024: 
      return new AEPituCameraUnit(paramIQIMCameraContainer, paramICameraEntrance);
    case -1000: 
      return new AEPituCameraUnit();
    case 10007: 
      return new QIMWebEffectCameraCaptureUnit(paramIQIMCameraContainer, paramICameraEntrance);
    case 10012: 
      return new QIMTribeEffectsCameraCaptureUnit(paramIQIMCameraContainer, paramICameraEntrance);
    case 10025: 
      return new QFaceUnlockCameraCaptureUnit(paramIQIMCameraContainer, paramICameraEntrance);
    case 10027: 
      return new AECMShowCameraUnit(paramIQIMCameraContainer, paramICameraEntrance);
    }
    return new AEPituQzoneCameraUnit(paramIQIMCameraContainer, paramICameraEntrance);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.QIMEffectCameraCaptureUnitBuilder
 * JD-Core Version:    0.7.0.1
 */