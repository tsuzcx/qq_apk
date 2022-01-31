package dov.com.qq.im.capture.control;

import bkpl;
import blqh;
import blqr;
import blrx;
import bniy;
import com.tencent.mobileqq.app.automator.AsyncStep;
import dov.com.qq.im.QIMEffectCameraCaptureUnit;

public class CaptureAsyncStep$InitCombo
  extends AsyncStep
{
  public int a()
  {
    bniy.a(blqh.a());
    blrx localblrx = (blrx)blqr.a(5);
    localblrx.i();
    localblrx.a(false);
    if ((this.a[0] != null) && ((this.a[0] instanceof QIMEffectCameraCaptureUnit))) {
      ((QIMEffectCameraCaptureUnit)this.a[0]).l(false);
    }
    for (;;)
    {
      return 7;
      if ((this.a[0] != null) && ((this.a[0] instanceof bkpl))) {
        ((bkpl)this.a[0]).l(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.capture.control.CaptureAsyncStep.InitCombo
 * JD-Core Version:    0.7.0.1
 */