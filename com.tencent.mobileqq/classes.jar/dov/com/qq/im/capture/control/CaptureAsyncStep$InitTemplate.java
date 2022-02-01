package dov.com.qq.im.capture.control;

import com.tencent.mobileqq.app.automator.AsyncStep;
import dov.com.qq.im.capture.QIMManager;
import dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager;

public class CaptureAsyncStep$InitTemplate
  extends AsyncStep
{
  public int a()
  {
    ((QIMPtvTemplateManager)QIMManager.a(3)).forceInit();
    QIMPtvTemplateManager.a = ((Integer)this.a[1]).intValue();
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.control.CaptureAsyncStep.InitTemplate
 * JD-Core Version:    0.7.0.1
 */