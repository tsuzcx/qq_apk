package dov.com.qq.im.capture.control;

import com.tencent.mobileqq.app.automator.AsyncStep;
import common.config.service.QzoneConfig;

public class CaptureAsyncStep$LoadQzoneConfig
  extends AsyncStep
{
  public int a()
  {
    QzoneConfig.getInstance().loadAllConfigs();
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.control.CaptureAsyncStep.LoadQzoneConfig
 * JD-Core Version:    0.7.0.1
 */