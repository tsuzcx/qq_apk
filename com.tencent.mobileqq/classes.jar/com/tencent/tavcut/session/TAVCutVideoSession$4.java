package com.tencent.tavcut.session;

import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.resource.MediaClipModel;
import com.tencent.weseevideo.model.resource.MediaResourceModel;
import com.tencent.weseevideo.model.resource.VideoResourceModel;
import java.util.HashMap;
import java.util.List;

class TAVCutVideoSession$4
  implements Runnable
{
  TAVCutVideoSession$4(TAVCutVideoSession paramTAVCutVideoSession, String paramString, float paramFloat1, HashMap paramHashMap, int paramInt, float paramFloat2) {}
  
  public void run()
  {
    this.this$0.resetAEKitModelForAI(this.this$0.getMediaModel(), TAVCutVideoSession.access$200(this.this$0), this.val$lutPath, this.val$lutStrength, this.val$adjustParams, this.val$smoothLevel, this.val$glowAlpha, ((MediaClipModel)this.this$0.getMediaModel().getMediaResourceModel().getVideos().get(0)).getResource().getSelectTimeDuration());
    this.this$0.refresh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutVideoSession.4
 * JD-Core Version:    0.7.0.1
 */