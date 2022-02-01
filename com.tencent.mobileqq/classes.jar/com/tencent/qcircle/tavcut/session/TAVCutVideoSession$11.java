package com.tencent.qcircle.tavcut.session;

import android.util.SparseArray;
import com.tencent.qcircle.weseevideo.editor.sticker.StickerController;
import com.tencent.qcircle.weseevideo.editor.sticker.utils.StickerConverter;
import com.tencent.qcircle.weseevideo.model.MediaModel;
import com.tencent.qcircle.weseevideo.model.effect.MediaEffectModel;
import java.util.List;

class TAVCutVideoSession$11
  implements Runnable
{
  TAVCutVideoSession$11(TAVCutVideoSession paramTAVCutVideoSession, List paramList) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.session.TAVCutVideoSession.11
 * JD-Core Version:    0.7.0.1
 */