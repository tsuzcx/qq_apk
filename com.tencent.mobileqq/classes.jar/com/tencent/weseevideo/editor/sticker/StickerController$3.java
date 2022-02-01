package com.tencent.weseevideo.editor.sticker;

import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.weseevideo.composition.effectnode.VideoEffectType;
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
        StickerController.access$200(this.this$0, this.this$0.getStickerContext(), localTAVSticker);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.weseevideo.editor.sticker.StickerController.3
 * JD-Core Version:    0.7.0.1
 */