package dov.com.qq.im;

import bdne;
import bknx;
import bmhh;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class QIMReadinjoyEffectsCameraCaptureUnit$2
  implements Runnable
{
  public QIMReadinjoyEffectsCameraCaptureUnit$2(bknx parambknx) {}
  
  public void run()
  {
    if (!bdne.u(this.this$0.a.a(), this.this$0.a.a().getCurrentAccountUin()))
    {
      ThreadManager.getUIHandler().post(new QIMReadinjoyEffectsCameraCaptureUnit.2.1(this));
      bdne.B(this.this$0.a.a(), this.this$0.a.a().getCurrentAccountUin());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.QIMReadinjoyEffectsCameraCaptureUnit.2
 * JD-Core Version:    0.7.0.1
 */