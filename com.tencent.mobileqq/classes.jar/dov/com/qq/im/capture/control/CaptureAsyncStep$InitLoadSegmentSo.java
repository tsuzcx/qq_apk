package dov.com.qq.im.capture.control;

import com.tencent.mobileqq.app.automator.AsyncStep;
import dov.com.qq.im.ae.util.AEQLog;

public class CaptureAsyncStep$InitLoadSegmentSo
  extends AsyncStep
{
  public int a()
  {
    try
    {
      AEQLog.d("QQInitHandler", "[InitLoadSegmentSo] isOK:" + false);
      return 7;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        AEQLog.d("QQInitHandler", "[InitLoadSegmentSo] failed");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.control.CaptureAsyncStep.InitLoadSegmentSo
 * JD-Core Version:    0.7.0.1
 */