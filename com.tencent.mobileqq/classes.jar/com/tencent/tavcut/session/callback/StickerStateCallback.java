package com.tencent.tavcut.session.callback;

import com.tencent.tavsticker.core.TAVStickerContext;
import com.tencent.tavsticker.core.TAVStickerEditView;
import com.tencent.tavsticker.model.TAVSticker;

public abstract interface StickerStateCallback
{
  public abstract void onStatusChanged(boolean paramBoolean);
  
  public abstract void onStickerActive();
  
  public abstract void onStickerAdd(TAVStickerContext paramTAVStickerContext, TAVStickerEditView paramTAVStickerEditView);
  
  public abstract void onStickerResign(TAVSticker paramTAVSticker);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavcut.session.callback.StickerStateCallback
 * JD-Core Version:    0.7.0.1
 */