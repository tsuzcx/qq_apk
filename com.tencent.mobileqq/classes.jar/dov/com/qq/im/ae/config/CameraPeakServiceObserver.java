package dov.com.qq.im.ae.config;

import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetFontDataRsp;
import com.tencent.mobileqq.app.BusinessObserver;
import dov.com.qq.im.ae.gif.RecognizedEmotionBean;

public abstract class CameraPeakServiceObserver
  implements BusinessObserver
{
  public static final int STATE_SENSITIVE_FACE_FAILED = -2;
  public static final int STATE_SENSITIVE_FACE_ILLEGAL = -1;
  public static final int STATE_SENSITIVE_FACE_LEGAL = 0;
  
  protected void onGetFontData(boolean paramBoolean, GetFontDataRsp paramGetFontDataRsp) {}
  
  public final void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      onUpdateRecommendText(paramBoolean, (RecognizedEmotionBean)paramObject);
      return;
    case 2: 
      onUpdateTextValid(paramBoolean, ((Boolean)paramObject).booleanValue());
      return;
    case 3: 
      onUpdateOnlineUserNum(paramBoolean, ((Integer)paramObject).intValue());
      return;
    case 4: 
      onGetFontData(paramBoolean, (GetFontDataRsp)paramObject);
      return;
    }
    onUpdateFaceDetect(paramBoolean, ((Integer)paramObject).intValue());
  }
  
  public void onUpdateFaceDetect(boolean paramBoolean, int paramInt) {}
  
  public void onUpdateOnlineUserNum(boolean paramBoolean, int paramInt) {}
  
  public void onUpdateRecommendText(boolean paramBoolean, RecognizedEmotionBean paramRecognizedEmotionBean) {}
  
  public void onUpdateTextValid(boolean paramBoolean1, boolean paramBoolean2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.config.CameraPeakServiceObserver
 * JD-Core Version:    0.7.0.1
 */