package com.tencent.weseevideo.editor.sticker.view;

import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerLayerItem;
import java.util.List;

public abstract interface WsStickerEditView$OnStickerEditButtonClickListener
{
  public abstract void onAdjustTimeClick(TAVSticker paramTAVSticker);
  
  public abstract void onDeleteClick(TAVSticker paramTAVSticker);
  
  public abstract void onEditClick(TAVSticker paramTAVSticker, List<TAVStickerLayerItem> paramList);
  
  public abstract void onStickerClick(TAVSticker paramTAVSticker);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.weseevideo.editor.sticker.view.WsStickerEditView.OnStickerEditButtonClickListener
 * JD-Core Version:    0.7.0.1
 */