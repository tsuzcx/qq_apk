package dov.com.qq.im;

import bplq;
import bpmw;
import bqai;
import bqzz;
import braa;
import brab;
import brhn;
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
      Object localObject = ((bpmw)bplq.a(5)).a;
      brhn localbrhn = (brhn)bplq.a(3);
      if (localObject != null)
      {
        localObject = ((braa)localObject).a(0);
        if (localObject != null)
        {
          localVideoFilterViewPager.a(((brab)localObject).c);
          localVideoFilterViewPager.b();
        }
      }
      bqzz.a().a(null);
      bqzz.a().a(null, this.this$0.jdField_a_of_type_Bqai.a(), 0);
      bplz.c = 0;
    } while (!QLog.isColorLevel());
    QLog.d("QIMEffectCameraCaptureUnit", 2, "onResourceDownload update filterpager end");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.QIMEffectCameraCaptureUnit.7
 * JD-Core Version:    0.7.0.1
 */