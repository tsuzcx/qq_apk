package com.tencent.tavsticker.model;

import com.tencent.tav.coremedia.CMTimeRange;
import java.util.Comparator;

class TAVSticker$2
  implements Comparator<TAVStickerLayerInfo>
{
  TAVSticker$2(TAVSticker paramTAVSticker) {}
  
  public int compare(TAVStickerLayerInfo paramTAVStickerLayerInfo1, TAVStickerLayerInfo paramTAVStickerLayerInfo2)
  {
    if ((paramTAVStickerLayerInfo1 != null) && (paramTAVStickerLayerInfo1.getTimeRange() != null) && (paramTAVStickerLayerInfo2 != null) && (paramTAVStickerLayerInfo2.getTimeRange() != null)) {
      return (int)(paramTAVStickerLayerInfo1.getTimeRange().getStartUs() - paramTAVStickerLayerInfo2.getTimeRange().getStartUs());
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavsticker.model.TAVSticker.2
 * JD-Core Version:    0.7.0.1
 */