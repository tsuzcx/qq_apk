package com.tencent.tavcut.session;

class TAVCutVideoSession$2
  implements Runnable
{
  TAVCutVideoSession$2(TAVCutVideoSession paramTAVCutVideoSession, boolean paramBoolean) {}
  
  public void run()
  {
    TAVCutVideoSession localTAVCutVideoSession = this.this$0;
    localTAVCutVideoSession.toggleAEKit(localTAVCutVideoSession.getMediaModel(), TAVCutVideoSession.access$200(this.this$0), this.val$on);
    this.this$0.refresh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutVideoSession.2
 * JD-Core Version:    0.7.0.1
 */