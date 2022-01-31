package dov.com.qq.im;

import dov.com.qq.im.setting.ICameraEntrance;
import dov.com.qq.im.setting.IQIMCameraContainer;

public class QIMEffectCameraCaptureUnitBuilder
{
  public static QIMEffectCameraCaptureUnit a(int paramInt, IQIMCameraContainer paramIQIMCameraContainer, ICameraEntrance paramICameraEntrance)
  {
    switch (paramInt)
    {
    case 10001: 
    case 10003: 
    case 10005: 
    case 10006: 
    case 10008: 
    default: 
      return new QIMQuickShootEffectCameraCaptureUnit(paramIQIMCameraContainer, paramICameraEntrance);
    case 10000: 
      return new QIMAIOEffectCameraCaptureUnit(paramIQIMCameraContainer, paramICameraEntrance);
    case 10002: 
      return new QIMStoryEffectCameraCaptureUnit(paramIQIMCameraContainer, paramICameraEntrance);
    case 10004: 
      return new QIMQuickShootEffectCameraCaptureUnit(paramIQIMCameraContainer, paramICameraEntrance);
    case 10009: 
      return new QIMProfileCoverEffectCameraCaptureUnit(paramIQIMCameraContainer, paramICameraEntrance);
    }
    return new QIMWebEffectCameraCaptureUnit(paramIQIMCameraContainer, paramICameraEntrance);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.QIMEffectCameraCaptureUnitBuilder
 * JD-Core Version:    0.7.0.1
 */