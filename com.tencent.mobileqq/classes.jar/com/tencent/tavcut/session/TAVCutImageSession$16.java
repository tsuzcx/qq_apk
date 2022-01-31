package com.tencent.tavcut.session;

import android.util.SparseArray;
import com.tencent.tavcut.util.DurationUtil;
import com.tencent.weseevideo.composition.image.WSImageRender;

class TAVCutImageSession$16
  implements Runnable
{
  TAVCutImageSession$16(TAVCutImageSession paramTAVCutImageSession, int paramInt) {}
  
  public void run()
  {
    if (TAVCutImageSession.access$200(this.this$0).get(this.val$index) == null) {
      return;
    }
    if ((this.this$0.renderChainManagers.get(this.val$index) == null) || (TAVCutImageSession.access$300(this.this$0).get(this.val$index) == null))
    {
      DurationUtil.start("initRenderEnvironment");
      TAVCutImageSession.access$400(this.this$0, this.val$index);
      DurationUtil.end("initRenderEnvironment");
    }
    ((WSImageRender)TAVCutImageSession.access$300(this.this$0).get(this.val$index)).render(new TAVCutImageSession.16.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutImageSession.16
 * JD-Core Version:    0.7.0.1
 */