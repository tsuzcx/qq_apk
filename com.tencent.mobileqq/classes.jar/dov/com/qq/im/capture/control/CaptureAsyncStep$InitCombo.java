package dov.com.qq.im.capture.control;

import bkle;
import bllv;
import blmf;
import blnl;
import bnem;
import com.tencent.mobileqq.app.automator.AsyncStep;
import dov.com.qq.im.QIMEffectCameraCaptureUnit;

public class CaptureAsyncStep$InitCombo
  extends AsyncStep
{
  public int a()
  {
    bnem.a(bllv.a());
    blnl localblnl = (blnl)blmf.a(5);
    localblnl.i();
    localblnl.a(false);
    if ((this.a[0] != null) && ((this.a[0] instanceof QIMEffectCameraCaptureUnit))) {
      ((QIMEffectCameraCaptureUnit)this.a[0]).l(false);
    }
    for (;;)
    {
      return 7;
      if ((this.a[0] != null) && ((this.a[0] instanceof bkle))) {
        ((bkle)this.a[0]).l(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.capture.control.CaptureAsyncStep.InitCombo
 * JD-Core Version:    0.7.0.1
 */