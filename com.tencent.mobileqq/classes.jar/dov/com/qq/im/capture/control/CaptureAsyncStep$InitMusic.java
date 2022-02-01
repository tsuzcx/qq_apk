package dov.com.qq.im.capture.control;

import bojv;
import bone;
import com.tencent.mobileqq.app.automator.AsyncStep;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;

public class CaptureAsyncStep$InitMusic
  extends AsyncStep
{
  public int a()
  {
    bone localbone = (bone)bojv.a().c(8);
    if (localbone != null) {
      localbone.e();
    }
    ((QIMMusicConfigManager)bojv.a(2)).j();
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.capture.control.CaptureAsyncStep.InitMusic
 * JD-Core Version:    0.7.0.1
 */