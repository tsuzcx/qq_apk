package com.tencent.weseevideo.editor.sticker;

import com.tencent.tavsticker.core.TAVStickerContext;

class StickerController$7
  implements Runnable
{
  StickerController$7(StickerController paramStickerController, TAVStickerContext paramTAVStickerContext, Runnable paramRunnable) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_ComTencentTavstickerCoreTAVStickerContext;
    if (localObject != null) {
      ((TAVStickerContext)localObject).removeAllStickers();
    }
    localObject = this.jdField_a_of_type_JavaLangRunnable;
    if (localObject != null) {
      ((Runnable)localObject).run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.editor.sticker.StickerController.7
 * JD-Core Version:    0.7.0.1
 */