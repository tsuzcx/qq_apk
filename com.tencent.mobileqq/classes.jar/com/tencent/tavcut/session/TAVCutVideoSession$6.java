package com.tencent.tavcut.session;

class TAVCutVideoSession$6
  implements Runnable
{
  TAVCutVideoSession$6(TAVCutVideoSession paramTAVCutVideoSession, float paramFloat) {}
  
  public void run()
  {
    TAVCutVideoSession localTAVCutVideoSession = this.this$0;
    localTAVCutVideoSession.setEffectStrength(localTAVCutVideoSession.getMediaModel(), TAVCutVideoSession.access$200(this.this$0), this.val$effectStrength);
    this.this$0.refresh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutVideoSession.6
 * JD-Core Version:    0.7.0.1
 */