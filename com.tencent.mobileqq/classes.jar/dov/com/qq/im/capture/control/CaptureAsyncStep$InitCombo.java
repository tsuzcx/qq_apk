package dov.com.qq.im.capture.control;

import com.tencent.mobileqq.app.automator.AsyncStep;
import dov.com.qq.im.capture.CaptureContext;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.data.CaptureComboManager;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools.OnResourceDownloadListener;
import dov.com.tencent.mobileqq.activity.richmedia.view.LbsFilterStatusManager;

public class CaptureAsyncStep$InitCombo
  extends AsyncStep
{
  public int a()
  {
    LbsFilterStatusManager.a(CaptureContext.a());
    CaptureComboManager localCaptureComboManager = (CaptureComboManager)QIMManager.a(5);
    localCaptureComboManager.forceInit();
    localCaptureComboManager.a(false);
    if ((this.a[0] != null) && ((this.a[0] instanceof VideoFilterTools.OnResourceDownloadListener))) {
      ((VideoFilterTools.OnResourceDownloadListener)this.a[0]).g(false);
    }
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.control.CaptureAsyncStep.InitCombo
 * JD-Core Version:    0.7.0.1
 */