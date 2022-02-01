package com.tencent.tavcut.session;

import android.util.SparseArray;
import com.tencent.weseevideo.composition.VideoRenderChainManager;
import com.tencent.weseevideo.model.MediaModel;
import java.util.List;

class TAVCutImageSession$7
  implements Runnable
{
  TAVCutImageSession$7(TAVCutImageSession paramTAVCutImageSession, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    TAVCutImageSession localTAVCutImageSession = this.this$0;
    localTAVCutImageSession.toggleAEKit((MediaModel)localTAVCutImageSession.mediaModels.get(this.val$index), (VideoRenderChainManager)this.this$0.renderChainManagers.get(this.val$index), this.val$on);
    this.this$0.render(this.val$index);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutImageSession.7
 * JD-Core Version:    0.7.0.1
 */