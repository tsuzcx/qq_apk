package com.tencent.qcircle.tavcut.session;

import com.tencent.qcircle.weseevideo.model.effect.StickerModel;

class TAVCutVideoSession$9
  implements Runnable
{
  TAVCutVideoSession$9(TAVCutVideoSession paramTAVCutVideoSession, StickerModel paramStickerModel) {}
  
  public void run()
  {
    TAVCutVideoSession localTAVCutVideoSession = this.this$0;
    localTAVCutVideoSession.addSticker(localTAVCutVideoSession.getStickerController(), this.val$stickerModel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.session.TAVCutVideoSession.9
 * JD-Core Version:    0.7.0.1
 */