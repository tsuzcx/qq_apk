package com.tencent.weseevideo.editor.sticker.view;

import android.view.MotionEvent;
import com.tencent.tavsticker.core.ITAVStickerEventListener;
import com.tencent.tavsticker.log.TLog;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerOperationMode;
import com.tencent.weseevideo.editor.sticker.dispatcher.StickerEventDispatcher;

class WsStickerEditView$1
  implements ITAVStickerEventListener
{
  WsStickerEditView$1(WsStickerEditView paramWsStickerEditView) {}
  
  public void onDataChanged(TAVSticker paramTAVSticker, TAVStickerOperationMode paramTAVStickerOperationMode, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    TLog.d(WsStickerEditView.access$100(this.this$0), "onDataChanged -> $tavSticker, centerX : $centerX, centerY : $centerX, scale : $scale, rotate : $rotate");
    WsStickerEditView.access$302(this.this$0, paramTAVStickerOperationMode);
    StickerEventDispatcher.getInstance().onStickerDataChanged(paramTAVSticker, paramTAVStickerOperationMode, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public void onStickerClick(TAVSticker paramTAVSticker, MotionEvent paramMotionEvent)
  {
    TLog.d(WsStickerEditView.access$100(this.this$0), "onStickerClick -> $tavSticker");
    if ((this.this$0.isStickerSelected) && (WsStickerEditView.access$200(this.this$0) != null)) {
      WsStickerEditView.access$200(this.this$0).onStickerClick(this.this$0.getSticker());
    }
    this.this$0.isStickerSelected = true;
  }
  
  public void onTouchBegin(TAVSticker paramTAVSticker, MotionEvent paramMotionEvent)
  {
    TLog.d(WsStickerEditView.access$100(this.this$0), "onTouchBegin -> $tavSticker");
    WsStickerEditView.access$402(this.this$0, true);
    StickerEventDispatcher.getInstance().onStickerStatusChanged(paramTAVSticker, Boolean.valueOf(true), Boolean.valueOf(this.this$0.isStickerSelected));
  }
  
  public void onTouchEnd(TAVSticker paramTAVSticker, MotionEvent paramMotionEvent)
  {
    TLog.d(WsStickerEditView.access$100(this.this$0), "onTouchEnd -> $tavSticker");
    WsStickerEditView.access$402(this.this$0, false);
    WsStickerEditView.access$302(this.this$0, TAVStickerOperationMode.OP_NONE);
    StickerEventDispatcher.getInstance().onStickerStatusChanged(paramTAVSticker, Boolean.valueOf(false), Boolean.valueOf(this.this$0.isStickerSelected));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.weseevideo.editor.sticker.view.WsStickerEditView.1
 * JD-Core Version:    0.7.0.1
 */