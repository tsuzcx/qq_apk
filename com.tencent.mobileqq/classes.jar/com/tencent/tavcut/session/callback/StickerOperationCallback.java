package com.tencent.tavcut.session.callback;

import com.tencent.tavcut.bean.TextEditorData;

public abstract interface StickerOperationCallback
{
  public abstract void onDeleteButtonClick(String paramString);
  
  public abstract void onStickerClick(TextEditorData paramTextEditorData);
  
  public abstract void onStickerMoving(String paramString);
  
  public abstract void onStickerTouchEnd(String paramString);
  
  public abstract void onStickerTouchStart(String paramString);
  
  public abstract void onTextEditButtonClick(TextEditorData paramTextEditorData);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavcut.session.callback.StickerOperationCallback
 * JD-Core Version:    0.7.0.1
 */