package dov.com.qq.im.capture.control;

import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.qqperf.opt.clearmemory.MemoryClearManager;
import dov.com.qq.im.QIMCaptureVarManager;
import dov.com.qq.im.capture.QIMManager;

public class CaptureAsyncStep$OnShowOther
  extends AsyncStep
{
  public int a()
  {
    QIMCaptureVarManager localQIMCaptureVarManager = (QIMCaptureVarManager)QIMManager.a(13);
    localQIMCaptureVarManager.d(0);
    localQIMCaptureVarManager.a(2);
    MemoryClearManager.a().h = 1;
    MemoryClearManager.a().j = 1;
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.control.CaptureAsyncStep.OnShowOther
 * JD-Core Version:    0.7.0.1
 */