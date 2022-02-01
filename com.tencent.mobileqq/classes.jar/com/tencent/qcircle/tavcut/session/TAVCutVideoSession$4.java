package com.tencent.qcircle.tavcut.session;

import java.util.Map;

class TAVCutVideoSession$4
  implements Runnable
{
  TAVCutVideoSession$4(TAVCutVideoSession paramTAVCutVideoSession, float paramFloat1, String paramString1, float paramFloat2, Map paramMap, String paramString2) {}
  
  public void run()
  {
    TAVCutVideoSession localTAVCutVideoSession = this.this$0;
    localTAVCutVideoSession.resetAEKitModel(localTAVCutVideoSession.getMediaModel(), TAVCutVideoSession.access$300(this.this$0), this.val$effectStrength, this.val$lutPath, this.val$glowStrength, this.val$adjustParams, this.val$materialPath);
    this.this$0.refresh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.session.TAVCutVideoSession.4
 * JD-Core Version:    0.7.0.1
 */