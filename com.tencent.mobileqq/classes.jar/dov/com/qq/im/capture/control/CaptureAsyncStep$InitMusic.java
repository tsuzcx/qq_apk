package dov.com.qq.im.capture.control;

import bplq;
import bpoz;
import com.tencent.mobileqq.app.automator.AsyncStep;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;

public class CaptureAsyncStep$InitMusic
  extends AsyncStep
{
  public int a()
  {
    bpoz localbpoz = (bpoz)bplq.a().c(8);
    if (localbpoz != null) {
      localbpoz.e();
    }
    ((QIMMusicConfigManager)bplq.a(2)).e();
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.capture.control.CaptureAsyncStep.InitMusic
 * JD-Core Version:    0.7.0.1
 */