package com.tencent.qcircle.tavcut.session;

import android.util.SparseArray;
import com.tencent.qcircle.tavcut.aekit.PreSegModel;
import com.tencent.qcircle.weseevideo.composition.VideoRenderChainManager;
import com.tencent.qcircle.weseevideo.model.MediaModel;
import com.tencent.qcircle.weseevideo.model.effect.MediaEffectModel;
import com.tencent.qcircle.weseevideo.model.resource.MediaClipModel;
import com.tencent.qcircle.weseevideo.model.resource.MediaResourceModel;
import com.tencent.qcircle.weseevideo.model.resource.VideoResourceModel;
import java.util.List;

class TAVCutImageSession$36
  implements Runnable
{
  TAVCutImageSession$36(TAVCutImageSession paramTAVCutImageSession, int paramInt, String paramString) {}
  
  public void run()
  {
    Object localObject = new PreSegModel();
    ((PreSegModel)localObject).setIndex(this.val$index);
    ((PreSegModel)localObject).setSegMaterial(this.val$preSegMaterial);
    ((PreSegModel)localObject).setOriginPic(((MediaClipModel)((MediaModel)this.this$0.getMediaModels().get(this.val$index)).getMediaResourceModel().getVideos().get(0)).getResource().getPath());
    ((MediaModel)this.this$0.mediaModels.get(this.val$index)).getMediaEffectModel().setPreSegModel((PreSegModel)localObject);
    localObject = this.this$0;
    ((TAVCutImageSession)localObject).updateRenderChain((VideoRenderChainManager)((TAVCutImageSession)localObject).renderChainManagers.get(this.val$index), ((MediaModel)this.this$0.mediaModels.get(this.val$index)).getMediaEffectModel(), false);
    this.this$0.render(this.val$index);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.session.TAVCutImageSession.36
 * JD-Core Version:    0.7.0.1
 */