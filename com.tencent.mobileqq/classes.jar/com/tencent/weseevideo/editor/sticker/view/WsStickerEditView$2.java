package com.tencent.weseevideo.editor.sticker.view;

import android.view.MotionEvent;
import com.tencent.tavsticker.core.ITAVStickerEventListener;
import com.tencent.tavsticker.log.TLog;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerOperationMode;
import com.tencent.weseevideo.editor.sticker.dispatcher.StickerEventDispatcher;

class WsStickerEditView$2
  implements ITAVStickerEventListener
{
  WsStickerEditView$2(WsStickerEditView paramWsStickerEditView) {}
  
  public void onDataChanged(TAVSticker paramTAVSticker, TAVStickerOperationMode paramTAVStickerOperationMode, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    TLog.d(WsStickerEditView.access$100(this.a), "onDataChanged -> $tavSticker, centerX : $centerX, centerY : $centerX, scale : $scale, rotate : $rotate");
    WsStickerEditView.access$202(this.a, paramTAVStickerOperationMode);
    StickerEventDispatcher.getInstance().onStickerDataChanged(paramTAVSticker, paramTAVStickerOperationMode, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public void onStickerClick(TAVSticker paramTAVSticker, MotionEvent paramMotionEvent)
  {
    TLog.d(WsStickerEditView.access$100(this.a), "onStickerClick -> $tavSticker");
    if (this.a.stickerEditButtonClickListener != null) {
      if (this.a.isStickerSelected) {
        this.a.stickerEditButtonClickListener.onStickerClick(this.a.getSticker());
      } else {
        this.a.stickerEditButtonClickListener.onStickerSelected(this.a.getSticker());
      }
    }
    this.a.isStickerSelected = true;
  }
  
  public void onTouchBegin(TAVSticker paramTAVSticker, MotionEvent paramMotionEvent)
  {
    TLog.d(WsStickerEditView.access$100(this.a), "onTouchBegin -> $tavSticker");
    StickerEventDispatcher.getInstance().onStickerStatusChanged(paramTAVSticker, Boolean.valueOf(true), Boolean.valueOf(this.a.isStickerSelected));
  }
  
  public void onTouchEnd(TAVSticker paramTAVSticker, MotionEvent paramMotionEvent)
  {
    TLog.d(WsStickerEditView.access$100(this.a), "onTouchEnd -> $tavSticker");
    WsStickerEditView.access$202(this.a, TAVStickerOperationMode.OP_NONE);
    StickerEventDispatcher.getInstance().onStickerStatusChanged(paramTAVSticker, Boolean.valueOf(false), Boolean.valueOf(this.a.isStickerSelected));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.editor.sticker.view.WsStickerEditView.2
 * JD-Core Version:    0.7.0.1
 */