package dov.com.qq.im;

import blmf;
import blnl;
import bmcv;
import bncp;
import bncq;
import bncr;
import bnkz;
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
      Object localObject = ((blnl)blmf.a(5)).a;
      bnkz localbnkz = (bnkz)blmf.a(3);
      if (localObject != null)
      {
        localObject = ((bncq)localObject).a(0);
        if (localObject != null)
        {
          localVideoFilterViewPager.a(((bncr)localObject).c);
          localVideoFilterViewPager.b();
        }
      }
      bncp.a().a(null);
      bncp.a().a(null, this.this$0.jdField_a_of_type_Bmcv.a(), 0);
      blmo.c = 0;
    } while (!QLog.isColorLevel());
    QLog.d("QIMEffectCameraCaptureUnit", 2, "onResourceDownload update filterpager end");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.QIMEffectCameraCaptureUnit.7
 * JD-Core Version:    0.7.0.1
 */