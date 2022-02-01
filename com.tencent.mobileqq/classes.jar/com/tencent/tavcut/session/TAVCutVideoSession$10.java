package com.tencent.tavcut.session;

import android.util.SparseArray;
import com.tencent.weseevideo.editor.sticker.StickerController;
import com.tencent.weseevideo.editor.sticker.utils.StickerConverter;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.effect.MediaEffectModel;
import java.util.List;

class TAVCutVideoSession$10
  implements Runnable
{
  TAVCutVideoSession$10(TAVCutVideoSession paramTAVCutVideoSession, List paramList) {}
  
  public void run()
  {
    this.this$0.getStickerController().restoreSticker(this.val$stickerModels);
    this.this$0.getMediaModel().getMediaEffectModel().setStickerModelList(this.val$stickerModels);
    MediaModel localMediaModel = this.this$0.getMediaModel();
    if ((localMediaModel.getMediaEffectModel().getSubtitleModel() != null) && (this.this$0.stickerControllers.size() > 0))
    {
      StickerController localStickerController = (StickerController)this.this$0.stickerControllers.get(0);
      if (localStickerController != null) {
        localStickerController.addSticker(StickerConverter.subtitleModel2TavSticker(localMediaModel.getMediaEffectModel().getSubtitleModel()));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutVideoSession.10
 * JD-Core Version:    0.7.0.1
 */