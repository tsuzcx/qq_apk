package com.tencent.weseevideo.editor.sticker.dispatcher;

import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerOperationMode;

public abstract interface IStickerEventListener
{
  public abstract void onStickerDataChanged(TAVSticker paramTAVSticker, TAVStickerOperationMode paramTAVStickerOperationMode, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  
  public abstract void onStickerStatusChanged(TAVSticker paramTAVSticker, boolean paramBoolean1, boolean paramBoolean2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.weseevideo.editor.sticker.dispatcher.IStickerEventListener
 * JD-Core Version:    0.7.0.1
 */