package com.tencent.tavsticker.core;

import android.view.MotionEvent;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerOperationMode;

public abstract interface ITAVStickerEventListener
{
  public abstract void onDataChanged(TAVSticker paramTAVSticker, TAVStickerOperationMode paramTAVStickerOperationMode, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  
  public abstract void onStickerClick(TAVSticker paramTAVSticker, MotionEvent paramMotionEvent);
  
  public abstract void onTouchBegin(TAVSticker paramTAVSticker, MotionEvent paramMotionEvent);
  
  public abstract void onTouchEnd(TAVSticker paramTAVSticker, MotionEvent paramMotionEvent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavsticker.core.ITAVStickerEventListener
 * JD-Core Version:    0.7.0.1
 */