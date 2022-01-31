package com.tencent.ttpic.openapi.util;

import com.tencent.ttpic.openapi.model.StickerItem;
import java.util.Comparator;

final class VideoTemplateParser$7
  implements Comparator<StickerItem>
{
  public int compare(StickerItem paramStickerItem1, StickerItem paramStickerItem2)
  {
    return paramStickerItem1.zIndex - paramStickerItem2.zIndex;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.util.VideoTemplateParser.7
 * JD-Core Version:    0.7.0.1
 */