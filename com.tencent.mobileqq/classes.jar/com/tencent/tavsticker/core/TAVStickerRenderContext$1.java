package com.tencent.tavsticker.core;

import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerProvider;
import java.util.Comparator;

class TAVStickerRenderContext$1
  implements Comparator<TAVStickerProvider>
{
  TAVStickerRenderContext$1(TAVStickerRenderContext paramTAVStickerRenderContext) {}
  
  public int compare(TAVStickerProvider paramTAVStickerProvider1, TAVStickerProvider paramTAVStickerProvider2)
  {
    if ((paramTAVStickerProvider1 != null) && (paramTAVStickerProvider1.getSticker() != null) && (paramTAVStickerProvider2 != null) && (paramTAVStickerProvider2.getSticker() != null)) {
      return paramTAVStickerProvider1.getSticker().getLayerIndex() - paramTAVStickerProvider2.getSticker().getLayerIndex();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavsticker.core.TAVStickerRenderContext.1
 * JD-Core Version:    0.7.0.1
 */