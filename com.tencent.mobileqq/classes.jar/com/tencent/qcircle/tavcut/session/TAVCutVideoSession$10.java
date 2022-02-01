package com.tencent.qcircle.tavcut.session;

import com.tencent.qcircle.weseevideo.editor.sticker.StickerController;
import com.tencent.qcircle.weseevideo.model.MediaModel;
import com.tencent.qcircle.weseevideo.model.effect.MediaEffectModel;
import java.util.List;

class TAVCutVideoSession$10
  implements Runnable
{
  TAVCutVideoSession$10(TAVCutVideoSession paramTAVCutVideoSession, List paramList) {}
  
  public void run()
  {
    this.this$0.getStickerController().restoreSticker(this.val$stickerModels);
    this.this$0.getMediaModel().getMediaEffectModel().setStickerModelList(this.val$stickerModels);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.session.TAVCutVideoSession.10
 * JD-Core Version:    0.7.0.1
 */