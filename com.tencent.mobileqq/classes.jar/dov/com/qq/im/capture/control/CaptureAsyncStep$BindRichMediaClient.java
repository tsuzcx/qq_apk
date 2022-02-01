package dov.com.qq.im.capture.control;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.richmedia.RichmediaClient;

public class CaptureAsyncStep$BindRichMediaClient
  extends AsyncStep
{
  public int a()
  {
    RichmediaClient.a().a(BaseApplicationImpl.sApplication);
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.control.CaptureAsyncStep.BindRichMediaClient
 * JD-Core Version:    0.7.0.1
 */