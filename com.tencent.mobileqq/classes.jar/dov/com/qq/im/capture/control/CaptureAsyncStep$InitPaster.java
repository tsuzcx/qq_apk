package dov.com.qq.im.capture.control;

import com.tencent.mobileqq.app.automator.AsyncStep;
import dov.com.qq.im.capture.CaptureContext;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.paster.PasterDataManager;
import dov.com.tencent.mobileqq.activity.richmedia.view.LbsFilterStatusManager;

public class CaptureAsyncStep$InitPaster
  extends AsyncStep
{
  public int a()
  {
    LbsFilterStatusManager.a(CaptureContext.a());
    PasterDataManager localPasterDataManager = (PasterDataManager)QIMManager.a().c(4);
    localPasterDataManager.forceInit();
    localPasterDataManager.a();
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.control.CaptureAsyncStep.InitPaster
 * JD-Core Version:    0.7.0.1
 */