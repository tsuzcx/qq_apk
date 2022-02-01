package dov.com.qq.im.ae.biz.qcircle;

import android.view.MotionEvent;
import dov.com.qq.im.ae.AEPituCameraUnit;
import dov.com.qq.im.ae.view.AETouchNotifyRelativeLayout.IAETouchNotify;

class AECircleMultiUnit$2
  implements AETouchNotifyRelativeLayout.IAETouchNotify
{
  AECircleMultiUnit$2(AECircleMultiUnit paramAECircleMultiUnit) {}
  
  public void a(MotionEvent paramMotionEvent)
  {
    if ((AECircleMultiUnit.a(this.a) instanceof AEPituCameraUnit)) {
      ((AEPituCameraUnit)AECircleMultiUnit.a(this.a)).a(paramMotionEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.biz.qcircle.AECircleMultiUnit.2
 * JD-Core Version:    0.7.0.1
 */