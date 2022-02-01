package com.tencent.qcircle.tavcut.session;

import android.support.annotation.RequiresApi;
import android.util.SparseArray;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.qcircle.tavcut.util.DurationUtil;
import com.tencent.qcircle.weseevideo.composition.effectnode.WSSegmentManager;
import com.tencent.qcircle.weseevideo.composition.image.AssetImageGenerator.ImageGeneratorThread;
import com.tencent.qcircle.weseevideo.composition.image.WSImageRender;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.ttpic.baseutils.gles.EglCore;

class TAVCutImageSession$30
  implements Runnable
{
  TAVCutImageSession$30(TAVCutImageSession paramTAVCutImageSession) {}
  
  @RequiresApi(api=19)
  public void run()
  {
    DurationUtil.start("TAVCutImageSession release");
    int i = 0;
    while (i < TAVCutImageSession.access$900(this.this$0).size())
    {
      int j = TAVCutImageSession.access$900(this.this$0).keyAt(i);
      ((WSImageRender)TAVCutImageSession.access$900(this.this$0).get(j)).release();
      i += 1;
    }
    if (TAVCutImageSession.access$000(this.this$0) != null)
    {
      TAVCutImageSession.access$000(this.this$0).release();
      TAVCutImageSession.access$002(this.this$0, null);
    }
    if (TAVCutImageSession.access$700(this.this$0) != null)
    {
      TAVCutImageSession.access$700(this.this$0).setExternalRenderCallback(null);
      TAVCutImageSession.access$700(this.this$0).destroy();
      TAVCutImageSession.access$702(this.this$0, null);
    }
    if (TAVCutImageSession.access$1600(this.this$0) != null)
    {
      TAVCutImageSession.access$1600(this.this$0).release();
      TAVCutImageSession.access$1602(this.this$0, null);
      TAVCutImageSession.access$102(this.this$0, null);
    }
    TAVCutImageSession.access$900(this.this$0).clear();
    this.this$0.tavCompositions.clear();
    TAVCutImageSession.access$400(this.this$0).clear();
    TAVCutImageSession.access$1700(this.this$0).clear();
    this.this$0.mediaBuilderOutputs.clear();
    TAVCutImageSession.access$1200(this.this$0).quit();
    TAVCutImageSession.access$1400(this.this$0).clear();
    TAVCutImageSession.access$1800(this.this$0).clear();
    WSSegmentManager localWSSegmentManager = WSSegmentManager.INSTANCE;
    WSSegmentManager.release();
    DurationUtil.end("TAVCutImageSession release");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.session.TAVCutImageSession.30
 * JD-Core Version:    0.7.0.1
 */