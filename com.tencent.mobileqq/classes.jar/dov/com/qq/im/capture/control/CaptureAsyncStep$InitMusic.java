package dov.com.qq.im.capture.control;

import bjav;
import bjed;
import com.tencent.mobileqq.app.automator.AsyncStep;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;

public class CaptureAsyncStep$InitMusic
  extends AsyncStep
{
  public int a()
  {
    bjed localbjed = (bjed)bjav.a().c(8);
    if (localbjed != null) {
      localbjed.e();
    }
    ((QIMMusicConfigManager)bjav.a(2)).i();
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.control.CaptureAsyncStep.InitMusic
 * JD-Core Version:    0.7.0.1
 */