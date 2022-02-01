package dov.com.qq.im;

import bojo;
import com.tencent.qphone.base.util.QLog;

class QIMEffectCameraCaptureUnit$4
  implements Runnable
{
  QIMEffectCameraCaptureUnit$4(QIMEffectCameraCaptureUnit paramQIMEffectCameraCaptureUnit) {}
  
  public void run()
  {
    long l1 = System.currentTimeMillis();
    this.this$0.a.a();
    long l2 = System.currentTimeMillis();
    this.this$0.n();
    long l3 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("QIMEffectCameraCaptureUnit", 2, new Object[] { "onFirstFrameShownInternal initUI:", Long.valueOf(l2 - l1), "  openSpecificTab:", Long.valueOf(l3 - l2) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.QIMEffectCameraCaptureUnit.4
 * JD-Core Version:    0.7.0.1
 */