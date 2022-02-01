package com.tencent.weseevideo.editor.sticker;

import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.video.RenderInfo;

class BlurStickerEditView$2
  implements Runnable
{
  BlurStickerEditView$2(BlurStickerEditView paramBlurStickerEditView, CIImage paramCIImage, RenderInfo paramRenderInfo) {}
  
  public void run()
  {
    this.this$0.onSourceImageUpdated(this.val$sourceImage, this.val$renderInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.weseevideo.editor.sticker.BlurStickerEditView.2
 * JD-Core Version:    0.7.0.1
 */