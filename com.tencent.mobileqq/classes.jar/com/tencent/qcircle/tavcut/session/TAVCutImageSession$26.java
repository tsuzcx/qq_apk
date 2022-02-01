package com.tencent.qcircle.tavcut.session;

import android.os.Handler;
import android.util.SparseArray;
import com.tencent.qcircle.tavcut.util.DurationUtil;
import com.tencent.qcircle.tavcut.view.ext.OnRenderFinishListener;
import com.tencent.qcircle.weseevideo.composition.image.AssetImageGenerator.ImageGeneratorThread;

class TAVCutImageSession$26
  implements Runnable
{
  TAVCutImageSession$26(TAVCutImageSession paramTAVCutImageSession, int paramInt, OnRenderFinishListener paramOnRenderFinishListener) {}
  
  public void run()
  {
    if (TAVCutImageSession.access$400(this.this$0).get(this.val$index) == null)
    {
      OnRenderFinishListener localOnRenderFinishListener = this.val$onRenderFinishListener;
      if (localOnRenderFinishListener != null) {
        localOnRenderFinishListener.onRenderFinish();
      }
      return;
    }
    if ((this.this$0.renderChainManagers.get(this.val$index) == null) || (TAVCutImageSession.access$900(this.this$0).get(this.val$index) == null))
    {
      DurationUtil.start("initRenderEnvironment");
      TAVCutImageSession.access$1000(this.this$0, this.val$index);
      DurationUtil.end("initRenderEnvironment");
    }
    TAVCutImageSession.access$1200(this.this$0).getHandler().post(new TAVCutImageSession.26.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.session.TAVCutImageSession.26
 * JD-Core Version:    0.7.0.1
 */