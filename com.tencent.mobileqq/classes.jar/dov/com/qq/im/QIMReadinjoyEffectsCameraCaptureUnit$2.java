package dov.com.qq.im;

import bdiv;
import bkjq;
import bmcv;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class QIMReadinjoyEffectsCameraCaptureUnit$2
  implements Runnable
{
  public QIMReadinjoyEffectsCameraCaptureUnit$2(bkjq parambkjq) {}
  
  public void run()
  {
    if (!bdiv.u(this.this$0.a.a(), this.this$0.a.a().getCurrentAccountUin()))
    {
      ThreadManager.getUIHandler().post(new QIMReadinjoyEffectsCameraCaptureUnit.2.1(this));
      bdiv.B(this.this$0.a.a(), this.this$0.a.a().getCurrentAccountUin());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.QIMReadinjoyEffectsCameraCaptureUnit.2
 * JD-Core Version:    0.7.0.1
 */