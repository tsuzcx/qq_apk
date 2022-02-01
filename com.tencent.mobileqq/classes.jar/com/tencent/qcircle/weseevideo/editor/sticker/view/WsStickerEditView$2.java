package com.tencent.qcircle.weseevideo.editor.sticker.view;

import android.view.MotionEvent;
import com.tencent.qcircle.weseevideo.editor.sticker.dispatcher.StickerEventDispatcher;
import com.tencent.tavsticker.core.ITAVStickerEventListener;
import com.tencent.tavsticker.log.TLog;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerOperationMode;

class WsStickerEditView$2
  implements ITAVStickerEventListener
{
  WsStickerEditView$2(WsStickerEditView paramWsStickerEditView) {}
  
  public void onDataChanged(TAVSticker paramTAVSticker, TAVStickerOperationMode paramTAVStickerOperationMode, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    TLog.d(WsStickerEditView.access$100(this.this$0), "onDataChanged -> $tavSticker, centerX : $centerX, centerY : $centerX, scale : $scale, rotate : $rotate");
    WsStickerEditView.access$202(this.this$0, paramTAVStickerOperationMode);
    StickerEventDispatcher.getInstance().onStickerDataChanged(paramTAVSticker, paramTAVStickerOperationMode, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public void onStickerClick(TAVSticker paramTAVSticker, MotionEvent paramMotionEvent)
  {
    TLog.d(WsStickerEditView.access$100(this.this$0), "onStickerClick -> $tavSticker");
    if (this.this$0.stickerEditButtonClickListener != null) {
      if (this.this$0.isStickerSelected) {
        this.this$0.stickerEditButtonClickListener.onStickerClick(this.this$0.getSticker());
      } else {
        this.this$0.stickerEditButtonClickListener.onStickerSelected(this.this$0.getSticker());
      }
    }
    this.this$0.isStickerSelected = true;
  }
  
  public void onTouchBegin(TAVSticker paramTAVSticker, MotionEvent paramMotionEvent)
  {
    TLog.d(WsStickerEditView.access$100(this.this$0), "onTouchBegin -> $tavSticker");
    StickerEventDispatcher.getInstance().onStickerStatusChanged(paramTAVSticker, Boolean.valueOf(true), Boolean.valueOf(this.this$0.isStickerSelected));
  }
  
  public void onTouchEnd(TAVSticker paramTAVSticker, MotionEvent paramMotionEvent)
  {
    TLog.d(WsStickerEditView.access$100(this.this$0), "onTouchEnd -> $tavSticker");
    WsStickerEditView.access$202(this.this$0, TAVStickerOperationMode.OP_NONE);
    StickerEventDispatcher.getInstance().onStickerStatusChanged(paramTAVSticker, Boolean.valueOf(false), Boolean.valueOf(this.this$0.isStickerSelected));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.editor.sticker.view.WsStickerEditView.2
 * JD-Core Version:    0.7.0.1
 */