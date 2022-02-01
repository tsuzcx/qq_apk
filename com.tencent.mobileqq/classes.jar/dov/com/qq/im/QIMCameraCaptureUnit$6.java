package dov.com.qq.im;

import bmul;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

public class QIMCameraCaptureUnit$6
  implements Runnable
{
  public QIMCameraCaptureUnit$6(bmul parambmul) {}
  
  public void run()
  {
    QQToast.a(BaseApplicationImpl.getContext(), this.this$0.a, 0).a();
    if (this.this$0.g) {
      this.this$0.B();
    }
    this.this$0.t();
    this.this$0.D();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.QIMCameraCaptureUnit.6
 * JD-Core Version:    0.7.0.1
 */