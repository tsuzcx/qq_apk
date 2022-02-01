package com.tencent.qcircle.tavcut.session;

import com.tencent.qcircle.tavcut.aekit.PreSegModel;
import com.tencent.qcircle.weseevideo.model.MediaModel;
import com.tencent.qcircle.weseevideo.model.effect.MediaEffectModel;
import com.tencent.qcircle.weseevideo.model.resource.MediaClipModel;
import com.tencent.qcircle.weseevideo.model.resource.MediaResourceModel;
import com.tencent.qcircle.weseevideo.model.resource.VideoResourceModel;
import java.util.List;

class TAVCutImageSession$37
  implements Runnable
{
  TAVCutImageSession$37(TAVCutImageSession paramTAVCutImageSession, int paramInt, String paramString) {}
  
  public void run()
  {
    PreSegModel localPreSegModel = new PreSegModel();
    localPreSegModel.setIndex(this.val$index);
    localPreSegModel.setSegMaterial(this.val$preSegMaterial);
    localPreSegModel.setOriginPic(((MediaClipModel)((MediaModel)this.this$0.getMediaModels().get(this.val$index)).getMediaResourceModel().getVideos().get(0)).getResource().getPath());
    ((MediaModel)this.this$0.mediaModels.get(this.val$index)).getMediaEffectModel().setPreSegModel(localPreSegModel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.session.TAVCutImageSession.37
 * JD-Core Version:    0.7.0.1
 */