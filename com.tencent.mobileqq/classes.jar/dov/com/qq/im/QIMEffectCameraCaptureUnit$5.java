package dov.com.qq.im;

import android.widget.TextView;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;

class QIMEffectCameraCaptureUnit$5
  implements Runnable
{
  QIMEffectCameraCaptureUnit$5(QIMEffectCameraCaptureUnit paramQIMEffectCameraCaptureUnit, boolean paramBoolean) {}
  
  public void run()
  {
    if ((this.a) && (!this.this$0.a.i()))
    {
      QIMEffectCameraCaptureUnit.a(this.this$0).setVisibility(0);
      return;
    }
    QIMEffectCameraCaptureUnit.a(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.QIMEffectCameraCaptureUnit.5
 * JD-Core Version:    0.7.0.1
 */