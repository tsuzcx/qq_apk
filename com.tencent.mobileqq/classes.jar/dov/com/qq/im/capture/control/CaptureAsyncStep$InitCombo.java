package dov.com.qq.im.capture.control;

import bofh;
import bplg;
import bplq;
import bpmw;
import brbw;
import com.tencent.mobileqq.app.automator.AsyncStep;
import dov.com.qq.im.QIMEffectCameraCaptureUnit;

public class CaptureAsyncStep$InitCombo
  extends AsyncStep
{
  public int a()
  {
    brbw.a(bplg.a());
    bpmw localbpmw = (bpmw)bplq.a(5);
    localbpmw.e();
    localbpmw.a(false);
    if ((this.a[0] != null) && ((this.a[0] instanceof QIMEffectCameraCaptureUnit))) {
      ((QIMEffectCameraCaptureUnit)this.a[0]).l(false);
    }
    for (;;)
    {
      return 7;
      if ((this.a[0] != null) && ((this.a[0] instanceof bofh))) {
        ((bofh)this.a[0]).l(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.capture.control.CaptureAsyncStep.InitCombo
 * JD-Core Version:    0.7.0.1
 */