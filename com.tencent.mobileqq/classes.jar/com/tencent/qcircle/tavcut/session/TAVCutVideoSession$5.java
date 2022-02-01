package com.tencent.qcircle.tavcut.session;

import com.tencent.qcircle.weseevideo.model.MediaModel;
import com.tencent.qcircle.weseevideo.model.resource.MediaClipModel;
import com.tencent.qcircle.weseevideo.model.resource.MediaResourceModel;
import com.tencent.qcircle.weseevideo.model.resource.VideoResourceModel;
import java.util.HashMap;
import java.util.List;

class TAVCutVideoSession$5
  implements Runnable
{
  TAVCutVideoSession$5(TAVCutVideoSession paramTAVCutVideoSession, String paramString, float paramFloat1, HashMap paramHashMap, int paramInt, float paramFloat2) {}
  
  public void run()
  {
    TAVCutVideoSession localTAVCutVideoSession = this.this$0;
    localTAVCutVideoSession.resetAEKitModelForAI(localTAVCutVideoSession.getMediaModel(), TAVCutVideoSession.access$300(this.this$0), this.val$lutPath, this.val$lutStrength, this.val$adjustParams, this.val$smoothLevel, this.val$glowAlpha, ((MediaClipModel)this.this$0.getMediaModel().getMediaResourceModel().getVideos().get(0)).getResource().getSelectTimeDuration());
    this.this$0.refresh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.session.TAVCutVideoSession.5
 * JD-Core Version:    0.7.0.1
 */