package com.tencent.qcircle.tavcut.session;

import com.tencent.tav.coremedia.CMTime;
import java.util.HashMap;

class TAVCutVideoSession$6
  implements Runnable
{
  TAVCutVideoSession$6(TAVCutVideoSession paramTAVCutVideoSession, String paramString, float paramFloat1, HashMap paramHashMap, int paramInt, float paramFloat2) {}
  
  public void run()
  {
    TAVCutVideoSession localTAVCutVideoSession = this.this$0;
    localTAVCutVideoSession.resetAEKitModelForAI(localTAVCutVideoSession.getMediaModel(), TAVCutVideoSession.access$300(this.this$0), this.val$lutPath, this.val$lutStrength, this.val$adjustParams, this.val$smoothLevel, this.val$glowAlpha, this.this$0.getDuration().getTimeUs() / 1000L);
    this.this$0.refresh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.session.TAVCutVideoSession.6
 * JD-Core Version:    0.7.0.1
 */