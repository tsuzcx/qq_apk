package com.tencent.qcircle.tavcut.session;

class TAVCutVideoSession$7
  implements Runnable
{
  TAVCutVideoSession$7(TAVCutVideoSession paramTAVCutVideoSession, float paramFloat) {}
  
  public void run()
  {
    TAVCutVideoSession localTAVCutVideoSession = this.this$0;
    localTAVCutVideoSession.setEffectStrength(localTAVCutVideoSession.getMediaModel(), TAVCutVideoSession.access$300(this.this$0), this.val$effectStrength);
    this.this$0.refresh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.session.TAVCutVideoSession.7
 * JD-Core Version:    0.7.0.1
 */