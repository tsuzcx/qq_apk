package com.tencent.tavsticker.core;

import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerLayerItem;
import java.util.List;

public abstract interface ITAVTouchStickerLayerListener
{
  public abstract void onTouchSticker(TAVSticker paramTAVSticker, List<TAVStickerLayerItem> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavsticker.core.ITAVTouchStickerLayerListener
 * JD-Core Version:    0.7.0.1
 */