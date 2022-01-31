package dov.com.qq.im;

import blqr;
import blrx;
import bmhh;
import bnhb;
import bnhc;
import bnhd;
import bnpl;
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
      Object localObject = ((blrx)blqr.a(5)).a;
      bnpl localbnpl = (bnpl)blqr.a(3);
      if (localObject != null)
      {
        localObject = ((bnhc)localObject).a(0);
        if (localObject != null)
        {
          localVideoFilterViewPager.a(((bnhd)localObject).c);
          localVideoFilterViewPager.b();
        }
      }
      bnhb.a().a(null);
      bnhb.a().a(null, this.this$0.jdField_a_of_type_Bmhh.a(), 0);
      blra.c = 0;
    } while (!QLog.isColorLevel());
    QLog.d("QIMEffectCameraCaptureUnit", 2, "onResourceDownload update filterpager end");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.QIMEffectCameraCaptureUnit.7
 * JD-Core Version:    0.7.0.1
 */