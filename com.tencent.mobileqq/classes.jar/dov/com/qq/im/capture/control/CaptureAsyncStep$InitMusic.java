package dov.com.qq.im.capture.control;

import bjae;
import bjdm;
import com.tencent.mobileqq.app.automator.AsyncStep;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;

public class CaptureAsyncStep$InitMusic
  extends AsyncStep
{
  public int a()
  {
    bjdm localbjdm = (bjdm)bjae.a().c(8);
    if (localbjdm != null) {
      localbjdm.e();
    }
    ((QIMMusicConfigManager)bjae.a(2)).i();
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.control.CaptureAsyncStep.InitMusic
 * JD-Core Version:    0.7.0.1
 */