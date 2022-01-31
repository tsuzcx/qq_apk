package dov.com.qq.im;

import bhfm;
import bhgs;
import bhzc;
import bjac;
import bjad;
import bjae;
import bjin;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager;

class QIMEffectCameraCaptureUnit$7
  implements Runnable
{
  QIMEffectCameraCaptureUnit$7(QIMEffectCameraCaptureUnit paramQIMEffectCameraCaptureUnit) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMEffectCameraCaptureUnit", 2, "onResourceDownload update filterpager begin");
    }
    VideoFilterViewPager localVideoFilterViewPager = this.this$0.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterViewPager;
    if (localVideoFilterViewPager == null) {
      if (QLog.isColorLevel()) {
        QLog.d("QIMEffectCameraCaptureUnit", 2, "onResourceDownload filterPager null ");
      }
    }
    do
    {
      return;
      localVideoFilterViewPager.setCaptureScene(0);
      Object localObject = ((bhgs)bhfm.a(5)).a;
      bjin localbjin = (bjin)bhfm.a(3);
      if (localObject != null)
      {
        localObject = ((bjad)localObject).a(0);
        if (localObject != null)
        {
          localVideoFilterViewPager.a(((bjae)localObject).c);
          localVideoFilterViewPager.b();
        }
      }
      bjac.a().a(null);
      bjac.a().a(null, this.this$0.jdField_a_of_type_Bhzc.a(), 0);
      bhfv.c = 0;
    } while (!QLog.isColorLevel());
    QLog.d("QIMEffectCameraCaptureUnit", 2, "onResourceDownload update filterpager end");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.QIMEffectCameraCaptureUnit.7
 * JD-Core Version:    0.7.0.1
 */