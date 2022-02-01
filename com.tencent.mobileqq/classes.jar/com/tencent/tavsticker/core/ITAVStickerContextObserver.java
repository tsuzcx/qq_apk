package com.tencent.tavsticker.core;

public abstract interface ITAVStickerContextObserver
{
  public abstract void onCurrentStickerStateChanged(TAVStickerContext paramTAVStickerContext, boolean paramBoolean);
  
  public abstract void onStickerActive(TAVStickerContext paramTAVStickerContext, TAVStickerEditView paramTAVStickerEditView);
  
  public abstract void onStickerAdd(TAVStickerContext paramTAVStickerContext, TAVStickerEditView paramTAVStickerEditView);
  
  public abstract void onStickerListChanged(TAVStickerContext paramTAVStickerContext);
  
  public abstract void onStickerRemove(TAVStickerContext paramTAVStickerContext, TAVStickerEditView paramTAVStickerEditView);
  
  public abstract void onStickerResign(TAVStickerContext paramTAVStickerContext, TAVStickerEditView paramTAVStickerEditView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavsticker.core.ITAVStickerContextObserver
 * JD-Core Version:    0.7.0.1
 */