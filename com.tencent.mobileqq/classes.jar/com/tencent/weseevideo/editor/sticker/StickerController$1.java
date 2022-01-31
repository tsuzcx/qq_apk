package com.tencent.weseevideo.editor.sticker;

import com.tencent.tavsticker.core.ITAVStickerContextDataSource;
import com.tencent.tavsticker.core.TAVStickerContext;
import com.tencent.tavsticker.core.TAVStickerEditView;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.weseevideo.editor.sticker.view.WsStickerEditView;

class StickerController$1
  implements ITAVStickerContextDataSource
{
  StickerController$1(StickerController paramStickerController) {}
  
  public TAVStickerEditView loadSticker(TAVStickerContext paramTAVStickerContext, TAVSticker paramTAVSticker)
  {
    paramTAVSticker = new WsStickerEditView(StickerController.access$000(this.this$0), paramTAVSticker, StickerController.access$100(this.this$0));
    paramTAVSticker.setDrawMovieLimitRect(false);
    paramTAVSticker.setDrawingOperationMask(63);
    paramTAVSticker.setOnStickerEditButtonClickListener(new StickerController.1.1(this, paramTAVStickerContext));
    return paramTAVSticker;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.weseevideo.editor.sticker.StickerController.1
 * JD-Core Version:    0.7.0.1
 */