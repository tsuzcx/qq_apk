package dov.com.qq.im.capture.control;

import bmbx;
import com.tencent.aekit.api.standard.ai.AIManager;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.ttpicmodule.module_human_segment.PTHumanSegmenter;

public class CaptureAsyncStep$InitLoadSegmentSo
  extends AsyncStep
{
  public int a()
  {
    try
    {
      boolean bool = AIManager.installDetector(PTHumanSegmenter.class, FeatureManager.getSoDir(), FeatureManager.getResourceDir());
      bmbx.d("QQInitHandler", "[InitLoadSegmentSo] isOK:" + bool);
      return 7;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        bmbx.d("QQInitHandler", "[InitLoadSegmentSo] failed");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.capture.control.CaptureAsyncStep.InitLoadSegmentSo
 * JD-Core Version:    0.7.0.1
 */