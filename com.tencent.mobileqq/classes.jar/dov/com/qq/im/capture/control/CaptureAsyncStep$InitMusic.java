package dov.com.qq.im.capture.control;

import blmf;
import blpo;
import com.tencent.mobileqq.app.automator.AsyncStep;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;

public class CaptureAsyncStep$InitMusic
  extends AsyncStep
{
  public int a()
  {
    blpo localblpo = (blpo)blmf.a().c(8);
    if (localblpo != null) {
      localblpo.e();
    }
    ((QIMMusicConfigManager)blmf.a(2)).i();
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.capture.control.CaptureAsyncStep.InitMusic
 * JD-Core Version:    0.7.0.1
 */