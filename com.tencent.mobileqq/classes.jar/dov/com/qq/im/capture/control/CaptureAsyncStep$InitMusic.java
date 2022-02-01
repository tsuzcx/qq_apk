package dov.com.qq.im.capture.control;

import bogd;
import boje;
import com.tencent.mobileqq.app.automator.AsyncStep;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;

public class CaptureAsyncStep$InitMusic
  extends AsyncStep
{
  public int a()
  {
    boje localboje = (boje)bogd.a().c(8);
    if (localboje != null) {
      localboje.c();
    }
    ((QIMMusicConfigManager)bogd.a(2)).forceInit();
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.capture.control.CaptureAsyncStep.InitMusic
 * JD-Core Version:    0.7.0.1
 */