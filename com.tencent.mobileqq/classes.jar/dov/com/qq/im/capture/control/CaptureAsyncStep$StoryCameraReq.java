package dov.com.qq.im.capture.control;

import blul;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;

public class CaptureAsyncStep$StoryCameraReq
  extends AsyncStep
{
  public int a()
  {
    blul localblul = (blul)QQStoryContext.a().getBusinessHandler(3);
    localblul.a("MqStoryCamera");
    localblul.a("MqEmoCamera");
    localblul.b();
    localblul.a();
    VSConfigManager.getInstance().getStoryConfigOnline();
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.capture.control.CaptureAsyncStep.StoryCameraReq
 * JD-Core Version:    0.7.0.1
 */