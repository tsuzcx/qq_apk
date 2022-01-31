package dov.com.qq.im.capture.control;

import bkvi;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;

public class CaptureAsyncStep$StoryCameraReq
  extends AsyncStep
{
  public int a()
  {
    bkvi localbkvi = (bkvi)QQStoryContext.a().getBusinessHandler(3);
    localbkvi.a("MqStoryCamera");
    localbkvi.a("MqEmoCamera");
    localbkvi.b();
    localbkvi.a();
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.capture.control.CaptureAsyncStep.StoryCameraReq
 * JD-Core Version:    0.7.0.1
 */