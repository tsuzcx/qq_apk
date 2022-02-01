package dov.com.qq.im.capture.control;

import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import dov.com.qq.im.ae.config.CameraDataServiceHandler;

public class CaptureAsyncStep$StoryCameraReq
  extends AsyncStep
{
  public int a()
  {
    CameraDataServiceHandler localCameraDataServiceHandler = (CameraDataServiceHandler)QQStoryContext.a().getBusinessHandler(PeakAppInterface.d);
    localCameraDataServiceHandler.a("MqStoryCamera");
    localCameraDataServiceHandler.a("MqEmoCamera");
    localCameraDataServiceHandler.a("MqCircleWatermark");
    localCameraDataServiceHandler.b();
    localCameraDataServiceHandler.a();
    VSConfigManager.a().a();
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.control.CaptureAsyncStep.StoryCameraReq
 * JD-Core Version:    0.7.0.1
 */