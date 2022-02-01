package dov.com.qq.im.capture.control;

import bmql;
import bmtm;
import com.tencent.mobileqq.app.automator.AsyncStep;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;

public class CaptureAsyncStep$InitMusic
  extends AsyncStep
{
  public int a()
  {
    bmtm localbmtm = (bmtm)bmql.a().c(8);
    if (localbmtm != null) {
      localbmtm.c();
    }
    ((QIMMusicConfigManager)bmql.a(2)).forceInit();
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.capture.control.CaptureAsyncStep.InitMusic
 * JD-Core Version:    0.7.0.1
 */