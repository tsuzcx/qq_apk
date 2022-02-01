package com.tencent.qcircle.tavcut.session;

class TAVCutVideoSession$3
  implements Runnable
{
  TAVCutVideoSession$3(TAVCutVideoSession paramTAVCutVideoSession, boolean paramBoolean) {}
  
  public void run()
  {
    TAVCutVideoSession localTAVCutVideoSession = this.this$0;
    localTAVCutVideoSession.toggleAEKit(localTAVCutVideoSession.getMediaModel(), TAVCutVideoSession.access$300(this.this$0), this.val$on);
    this.this$0.refresh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.session.TAVCutVideoSession.3
 * JD-Core Version:    0.7.0.1
 */