package dov.com.qq.im.capture.control;

import bhfm;
import bhiu;
import com.tencent.mobileqq.app.automator.AsyncStep;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;

public class CaptureAsyncStep$InitMusic
  extends AsyncStep
{
  public int a()
  {
    bhiu localbhiu = (bhiu)bhfm.a().c(8);
    if (localbhiu != null) {
      localbhiu.e();
    }
    ((QIMMusicConfigManager)bhfm.a(2)).g();
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.control.CaptureAsyncStep.InitMusic
 * JD-Core Version:    0.7.0.1
 */