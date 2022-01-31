package dov.com.qq.im.capture.control;

import bijd;
import bjal;
import bjav;
import bjcb;
import bktc;
import com.tencent.mobileqq.app.automator.AsyncStep;
import dov.com.qq.im.QIMEffectCameraCaptureUnit;

public class CaptureAsyncStep$InitCombo
  extends AsyncStep
{
  public int a()
  {
    bktc.a(bjal.a());
    bjcb localbjcb = (bjcb)bjav.a(5);
    localbjcb.i();
    localbjcb.a(false);
    if ((this.a[0] != null) && ((this.a[0] instanceof QIMEffectCameraCaptureUnit))) {
      ((QIMEffectCameraCaptureUnit)this.a[0]).l(false);
    }
    for (;;)
    {
      return 7;
      if ((this.a[0] != null) && ((this.a[0] instanceof bijd))) {
        ((bijd)this.a[0]).l(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.control.CaptureAsyncStep.InitCombo
 * JD-Core Version:    0.7.0.1
 */