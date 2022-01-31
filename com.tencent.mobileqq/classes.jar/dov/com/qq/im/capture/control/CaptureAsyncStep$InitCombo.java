package dov.com.qq.im.capture.control;

import bhcw;
import bhfc;
import bhfm;
import bhgs;
import bjbz;
import com.tencent.mobileqq.app.automator.AsyncStep;
import dov.com.qq.im.QIMEffectCameraCaptureUnit;

public class CaptureAsyncStep$InitCombo
  extends AsyncStep
{
  public int a()
  {
    bjbz.a(bhfc.a());
    bhgs localbhgs = (bhgs)bhfm.a(5);
    localbhgs.g();
    localbhgs.a(false);
    if ((this.a[0] != null) && ((this.a[0] instanceof QIMEffectCameraCaptureUnit))) {
      ((QIMEffectCameraCaptureUnit)this.a[0]).b(false);
    }
    for (;;)
    {
      return 7;
      if ((this.a[0] != null) && ((this.a[0] instanceof bhcw))) {
        ((bhcw)this.a[0]).b(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.control.CaptureAsyncStep.InitCombo
 * JD-Core Version:    0.7.0.1
 */