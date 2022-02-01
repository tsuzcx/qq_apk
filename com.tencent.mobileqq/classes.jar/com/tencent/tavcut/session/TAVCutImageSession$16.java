package com.tencent.tavcut.session;

import android.util.SparseArray;
import com.tencent.weseevideo.composition.VideoRenderChainManager;
import com.tencent.weseevideo.model.MediaModel;
import java.util.List;

class TAVCutImageSession$16
  implements Runnable
{
  TAVCutImageSession$16(TAVCutImageSession paramTAVCutImageSession, int paramInt, String paramString) {}
  
  public void run()
  {
    this.this$0.setMaterial((MediaModel)this.this$0.mediaModels.get(this.val$index), (VideoRenderChainManager)this.this$0.renderChainManagers.get(this.val$index), this.val$materialPath);
    this.this$0.render(this.val$index);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutImageSession.16
 * JD-Core Version:    0.7.0.1
 */