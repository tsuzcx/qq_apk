package dov.com.qq.im.capture.control;

import avzi;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;

public class CaptureAsyncStep$StoryCameraReq
  extends AsyncStep
{
  public int a()
  {
    avzi localavzi = (avzi)QQStoryContext.a().getBusinessHandler(3);
    localavzi.a("MqStoryCamera");
    localavzi.a("MqEmoCamera");
    localavzi.b();
    localavzi.a();
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.control.CaptureAsyncStep.StoryCameraReq
 * JD-Core Version:    0.7.0.1
 */