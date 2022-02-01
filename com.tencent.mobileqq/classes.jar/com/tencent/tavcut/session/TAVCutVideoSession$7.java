package com.tencent.tavcut.session;

class TAVCutVideoSession$7
  implements Runnable
{
  TAVCutVideoSession$7(TAVCutVideoSession paramTAVCutVideoSession, String paramString) {}
  
  public void run()
  {
    TAVCutVideoSession localTAVCutVideoSession = this.this$0;
    localTAVCutVideoSession.setMaterial(localTAVCutVideoSession.getMediaModel(), TAVCutVideoSession.access$200(this.this$0), this.val$materialPath);
    this.this$0.refresh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutVideoSession.7
 * JD-Core Version:    0.7.0.1
 */