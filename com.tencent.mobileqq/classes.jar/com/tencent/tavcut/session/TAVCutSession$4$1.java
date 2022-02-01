package com.tencent.tavcut.session;

import com.tencent.tavcut.session.callback.StickerOperationCallback;
import com.tencent.tavcut.util.StickerUtil;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.weseevideo.editor.sticker.StickerController;
import com.tencent.weseevideo.editor.sticker.utils.StickerConverter;
import com.tencent.weseevideo.model.effect.SubtitleModel;

class TAVCutSession$4$1
  implements Runnable
{
  TAVCutSession$4$1(TAVCutSession.4 param4) {}
  
  public void run()
  {
    TAVSticker localTAVSticker = this.this$1.val$stickerController.getCurrentSticker();
    if (localTAVSticker != null) {
      TAVCutSession.access$000(this.this$1.this$0, localTAVSticker);
    }
    this.this$1.val$stickerController.resignCurrentSticker();
    if ((this.this$1.val$stickerModel instanceof SubtitleModel)) {}
    for (localTAVSticker = StickerConverter.subtitleModel2TavSticker((SubtitleModel)this.this$1.val$stickerModel);; localTAVSticker = StickerUtil.stickerModel2TavSticker(this.this$1.val$stickerModel))
    {
      if (localTAVSticker != null) {
        this.this$1.val$stickerController.addSticker(localTAVSticker);
      }
      if (this.this$1.this$0.stickerOperationCallback != null) {
        this.this$1.this$0.stickerOperationCallback.onAddStickerDone(localTAVSticker.getStickerId());
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutSession.4.1
 * JD-Core Version:    0.7.0.1
 */