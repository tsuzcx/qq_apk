package com.tencent.qcircle.weseevideo.editor.sticker;

import com.tencent.qcircle.weseevideo.composition.effectnode.VideoEffectType;
import com.tencent.tavsticker.model.TAVSticker;
import java.util.Iterator;
import java.util.List;

class StickerController$3
  implements Runnable
{
  StickerController$3(StickerController paramStickerController) {}
  
  public void run()
  {
    Object localObject = StickerController.access$600(this.this$0, VideoEffectType.TYPE_SUBTITLE.value);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        TAVSticker localTAVSticker = (TAVSticker)((Iterator)localObject).next();
        StickerController localStickerController = this.this$0;
        StickerController.access$200(localStickerController, localStickerController.getStickerContext(), localTAVSticker);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.editor.sticker.StickerController.3
 * JD-Core Version:    0.7.0.1
 */