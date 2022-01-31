package dov.com.qq.im;

import bjav;
import bjcb;
import bkrg;
import bkrh;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager;

class QIMEffectCameraCaptureUnit$8
  implements Runnable
{
  QIMEffectCameraCaptureUnit$8(QIMEffectCameraCaptureUnit paramQIMEffectCameraCaptureUnit) {}
  
  public void run()
  {
    Object localObject = ((bjcb)bjav.a(5)).a;
    VideoFilterViewPager localVideoFilterViewPager = this.this$0.a;
    if ((localVideoFilterViewPager != null) && (localObject != null))
    {
      localObject = ((bkrg)localObject).a(0);
      if (localObject != null)
      {
        localVideoFilterViewPager.a(((bkrh)localObject).c);
        localVideoFilterViewPager.b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.QIMEffectCameraCaptureUnit.8
 * JD-Core Version:    0.7.0.1
 */