package com.tencent.tavcut.session;

import com.tencent.tav.coremedia.CMTime;
import java.util.HashMap;

class TAVCutVideoSession$5
  implements Runnable
{
  TAVCutVideoSession$5(TAVCutVideoSession paramTAVCutVideoSession, String paramString, float paramFloat1, HashMap paramHashMap, int paramInt, float paramFloat2) {}
  
  public void run()
  {
    this.this$0.resetAEKitModelForAI(this.this$0.getMediaModel(), TAVCutVideoSession.access$200(this.this$0), this.val$lutPath, this.val$lutStrength, this.val$adjustParams, this.val$smoothLevel, this.val$glowAlpha, this.this$0.getDuration().getTimeUs() / 1000L);
    this.this$0.refresh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutVideoSession.5
 * JD-Core Version:    0.7.0.1
 */