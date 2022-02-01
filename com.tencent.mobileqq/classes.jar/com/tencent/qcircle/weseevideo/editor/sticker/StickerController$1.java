package com.tencent.qcircle.weseevideo.editor.sticker;

import com.tencent.qcircle.weseevideo.editor.sticker.model.TAVStickerExKt;
import com.tencent.qcircle.weseevideo.editor.sticker.view.WsStickerEditView;
import com.tencent.tavsticker.core.ITAVStickerContextDataSource;
import com.tencent.tavsticker.core.TAVStickerContext;
import com.tencent.tavsticker.core.TAVStickerEditView;
import com.tencent.tavsticker.model.TAVSticker;

class StickerController$1
  implements ITAVStickerContextDataSource
{
  StickerController$1(StickerController paramStickerController) {}
  
  public TAVStickerEditView loadSticker(TAVStickerContext paramTAVStickerContext, TAVSticker paramTAVSticker)
  {
    WsStickerEditView localWsStickerEditView = StickerViewFactory.createStickerEditView(StickerController.access$000(this.this$0), paramTAVSticker, StickerController.access$100(this.this$0));
    paramTAVSticker = TAVStickerExKt.getExtraStickerType(paramTAVSticker);
    localWsStickerEditView.setDrawMovieLimitRect(false);
    if ("sticker_lyric".equals(paramTAVSticker)) {
      localWsStickerEditView.setDrawingOperationMask(21);
    } else {
      localWsStickerEditView.setDrawingOperationMask(63);
    }
    localWsStickerEditView.setOnStickerEditButtonClickListener(new StickerController.1.1(this, paramTAVStickerContext, paramTAVSticker));
    return localWsStickerEditView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.editor.sticker.StickerController.1
 * JD-Core Version:    0.7.0.1
 */