package com.tencent.qcircle.tavcut.session;

class TAVCutVideoSession$8
  implements Runnable
{
  TAVCutVideoSession$8(TAVCutVideoSession paramTAVCutVideoSession, String paramString) {}
  
  public void run()
  {
    TAVCutVideoSession localTAVCutVideoSession = this.this$0;
    localTAVCutVideoSession.setMaterial(localTAVCutVideoSession.getMediaModel(), TAVCutVideoSession.access$300(this.this$0), this.val$materialPath);
    this.this$0.refresh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.session.TAVCutVideoSession.8
 * JD-Core Version:    0.7.0.1
 */