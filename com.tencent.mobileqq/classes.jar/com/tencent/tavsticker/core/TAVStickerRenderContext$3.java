package com.tencent.tavsticker.core;

import com.tencent.tavsticker.model.TAVSticker;
import java.util.Comparator;

class TAVStickerRenderContext$3
  implements Comparator<TAVSticker>
{
  TAVStickerRenderContext$3(TAVStickerRenderContext paramTAVStickerRenderContext) {}
  
  public int a(TAVSticker paramTAVSticker1, TAVSticker paramTAVSticker2)
  {
    if ((paramTAVSticker1 != null) && (paramTAVSticker2 != null)) {
      return paramTAVSticker1.getLayerIndex() - paramTAVSticker2.getLayerIndex();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavsticker.core.TAVStickerRenderContext.3
 * JD-Core Version:    0.7.0.1
 */