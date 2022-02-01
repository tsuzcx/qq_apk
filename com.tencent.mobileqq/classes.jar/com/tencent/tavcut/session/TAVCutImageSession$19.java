package com.tencent.tavcut.session;

import android.util.SparseArray;
import com.tencent.tavcut.bean.CropConfig;
import com.tencent.weseevideo.composition.VideoRenderChainManager;
import com.tencent.weseevideo.model.MediaModel;
import java.util.List;

class TAVCutImageSession$19
  implements Runnable
{
  TAVCutImageSession$19(TAVCutImageSession paramTAVCutImageSession, int paramInt, CropConfig paramCropConfig) {}
  
  public void run()
  {
    this.this$0.setCrop((MediaModel)this.this$0.mediaModels.get(this.val$index), (VideoRenderChainManager)this.this$0.renderChainManagers.get(this.val$index), this.val$cropConfig);
    this.this$0.render(this.val$index);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutImageSession.19
 * JD-Core Version:    0.7.0.1
 */