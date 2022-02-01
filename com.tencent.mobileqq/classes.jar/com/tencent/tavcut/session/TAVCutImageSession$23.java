package com.tencent.tavcut.session;

import android.util.SparseArray;
import com.tencent.tavcut.bean.CropConfig;
import com.tencent.weseevideo.composition.VideoRenderChainManager;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.effect.GestureModel;
import com.tencent.weseevideo.model.effect.MediaEffectModel;
import java.util.List;

class TAVCutImageSession$23
  implements Runnable
{
  TAVCutImageSession$23(TAVCutImageSession paramTAVCutImageSession, int paramInt, CropConfig paramCropConfig) {}
  
  public void run()
  {
    TAVCutImageSession localTAVCutImageSession = this.this$0;
    localTAVCutImageSession.setCrop((MediaModel)localTAVCutImageSession.mediaModels.get(this.val$index), (VideoRenderChainManager)this.this$0.renderChainManagers.get(this.val$index), this.val$cropConfig);
    ((MediaModel)this.this$0.mediaModels.get(this.val$index)).getMediaEffectModel().getGestureModel().reset();
    TAVCutImageSession.access$500(this.this$0, this.val$index, true);
    this.this$0.render(this.val$index);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutImageSession.23
 * JD-Core Version:    0.7.0.1
 */