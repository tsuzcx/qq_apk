package com.tencent.qcircle.tavcut.session.callback;

import com.tencent.qcircle.tavcut.bean.TextEditorData;

public abstract interface StickerOperationCallback
{
  public abstract void onAddStickerDone(String paramString);
  
  public abstract void onDeleteButtonClick(String paramString);
  
  public abstract void onStickerClick(TextEditorData paramTextEditorData);
  
  public abstract void onStickerMoving(String paramString);
  
  public abstract void onStickerOutsideClick();
  
  public abstract void onStickerSelect(TextEditorData paramTextEditorData);
  
  public abstract void onStickerTouchEnd(TextEditorData paramTextEditorData);
  
  public abstract void onStickerTouchStart(TextEditorData paramTextEditorData);
  
  public abstract void onTextEditButtonClick(TextEditorData paramTextEditorData);
  
  public abstract void onUpdateTextStickerDone(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.session.callback.StickerOperationCallback
 * JD-Core Version:    0.7.0.1
 */