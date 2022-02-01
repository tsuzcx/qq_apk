package com.tencent.qcircle.weseevideo.editor.sticker;

import com.tencent.tavsticker.core.TAVStickerContext;

class StickerController$7
  implements Runnable
{
  StickerController$7(StickerController paramStickerController, TAVStickerContext paramTAVStickerContext, Runnable paramRunnable) {}
  
  public void run()
  {
    Object localObject = this.val$finalContext;
    if (localObject != null) {
      ((TAVStickerContext)localObject).removeAllStickers();
    }
    localObject = this.val$after;
    if (localObject != null) {
      ((Runnable)localObject).run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.editor.sticker.StickerController.7
 * JD-Core Version:    0.7.0.1
 */