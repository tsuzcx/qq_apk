package com.tencent.ttpic.openapi.util;

import com.tencent.ttpic.openapi.model.StickerItem;
import java.util.Comparator;

final class VideoTemplateParser$9
  implements Comparator<StickerItem>
{
  public int compare(StickerItem paramStickerItem1, StickerItem paramStickerItem2)
  {
    return paramStickerItem1.zIndex - paramStickerItem2.zIndex;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.util.VideoTemplateParser.9
 * JD-Core Version:    0.7.0.1
 */