package dov.com.qq.im;

import android.os.Handler;
import android.os.Message;
import avtc;
import axlc;
import com.tencent.qphone.base.util.QLog;

class QIMEffectCameraCaptureUnit$3
  implements Runnable
{
  QIMEffectCameraCaptureUnit$3(QIMEffectCameraCaptureUnit paramQIMEffectCameraCaptureUnit, boolean paramBoolean) {}
  
  public void run()
  {
    Handler localHandler;
    if ((axlc.d()) && (axlc.a(this.this$0.a())))
    {
      i = 1;
      localHandler = this.this$0.a;
      if (i == 0) {
        break label92;
      }
    }
    label92:
    for (int i = 1;; i = 0)
    {
      localHandler.obtainMessage(1001, i, 0).sendToTarget();
      if (this.a)
      {
        boolean bool = avtc.b();
        if (QLog.isColorLevel()) {
          QLog.d("QIMEffectCameraCaptureUnit", 2, new Object[] { "onNotifyFilterReady soLoaded: ", Boolean.valueOf(bool) });
        }
      }
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.QIMEffectCameraCaptureUnit.3
 * JD-Core Version:    0.7.0.1
 */