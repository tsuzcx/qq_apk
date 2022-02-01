package dov.com.qq.im;

import bplq;
import bpmw;
import braa;
import brab;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager;

class QIMEffectCameraCaptureUnit$8
  implements Runnable
{
  QIMEffectCameraCaptureUnit$8(QIMEffectCameraCaptureUnit paramQIMEffectCameraCaptureUnit) {}
  
  public void run()
  {
    Object localObject = ((bpmw)bplq.a(5)).a;
    VideoFilterViewPager localVideoFilterViewPager = this.this$0.a;
    if ((localVideoFilterViewPager != null) && (localObject != null))
    {
      localObject = ((braa)localObject).a(0);
      if (localObject != null)
      {
        localVideoFilterViewPager.a(((brab)localObject).c);
        localVideoFilterViewPager.b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.QIMEffectCameraCaptureUnit.8
 * JD-Core Version:    0.7.0.1
 */