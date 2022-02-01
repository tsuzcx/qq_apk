package com.tencent.tavcut.session;

import com.tencent.weseevideo.editor.sticker.StickerController;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.effect.MediaEffectModel;
import java.util.List;

class TAVCutVideoSession$9
  implements Runnable
{
  TAVCutVideoSession$9(TAVCutVideoSession paramTAVCutVideoSession, List paramList) {}
  
  public void run()
  {
    this.this$0.getStickerController().restoreSticker(this.val$stickerModels);
    this.this$0.getMediaModel().getMediaEffectModel().setStickerModelList(this.val$stickerModels);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutVideoSession.9
 * JD-Core Version:    0.7.0.1
 */