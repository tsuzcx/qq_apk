package dov.com.qq.im.capture.control;

import abac;
import boqe;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;

public class CaptureAsyncStep$StoryCameraReq
  extends AsyncStep
{
  public int a()
  {
    boqe localboqe = (boqe)QQStoryContext.a().getBusinessHandler(3);
    localboqe.a("MqStoryCamera");
    localboqe.a("MqEmoCamera");
    localboqe.b();
    localboqe.a();
    abac.a().a();
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.capture.control.CaptureAsyncStep.StoryCameraReq
 * JD-Core Version:    0.7.0.1
 */