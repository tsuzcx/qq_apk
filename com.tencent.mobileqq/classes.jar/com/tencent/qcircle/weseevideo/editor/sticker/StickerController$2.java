package com.tencent.qcircle.weseevideo.editor.sticker;

import android.view.MotionEvent;
import com.tencent.qcircle.tavcut.session.callback.StickerOperationCallback;
import com.tencent.qcircle.tavcut.session.callback.StickerStateCallback;
import com.tencent.tavsticker.core.TAVStickerContext;
import com.tencent.tavsticker.core.TAVStickerContext.OnTouchStickerOutsideListener;

class StickerController$2
  implements TAVStickerContext.OnTouchStickerOutsideListener
{
  StickerController$2(StickerController paramStickerController, TAVStickerContext paramTAVStickerContext) {}
  
  public void onTouchStickerOutside(MotionEvent paramMotionEvent)
  {
    paramMotionEvent = this.val$stickerContext.getCurrentSticker();
    this.val$stickerContext.resignCurrentSticker();
    if ((paramMotionEvent != null) && (StickerController.access$500(this.this$0) != null)) {
      StickerController.access$500(this.this$0).onStickerResign(paramMotionEvent);
    }
    if (StickerController.access$300(this.this$0) != null) {
      StickerController.access$300(this.this$0).onStickerOutsideClick();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.editor.sticker.StickerController.2
 * JD-Core Version:    0.7.0.1
 */