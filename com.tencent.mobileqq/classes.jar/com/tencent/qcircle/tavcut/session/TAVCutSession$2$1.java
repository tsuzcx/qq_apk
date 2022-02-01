package com.tencent.qcircle.tavcut.session;

import com.tencent.qcircle.tavcut.session.callback.StickerOperationCallback;
import com.tencent.qcircle.tavcut.util.StickerUtil;
import com.tencent.qcircle.weseevideo.editor.sticker.dispatcher.IStickerEventListener;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerOperationMode;
import org.jetbrains.annotations.NotNull;

class TAVCutSession$2$1
  implements IStickerEventListener
{
  TAVCutSession$2$1(TAVCutSession.2 param2) {}
  
  public void onStickerDataChanged(@NotNull TAVSticker paramTAVSticker, @NotNull TAVStickerOperationMode paramTAVStickerOperationMode, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if ((paramTAVStickerOperationMode == TAVStickerOperationMode.OP_DRAG) && (this.this$1.this$0.stickerOperationCallback != null)) {
      this.this$1.this$0.stickerOperationCallback.onStickerMoving(paramTAVSticker.getStickerId());
    }
  }
  
  public void onStickerStatusChanged(@NotNull TAVSticker paramTAVSticker, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean1) {
      TAVCutSession.access$000(this.this$1.this$0, paramTAVSticker);
    }
    if (this.this$1.this$0.stickerOperationCallback != null)
    {
      if (paramBoolean1)
      {
        this.this$1.this$0.stickerOperationCallback.onStickerTouchStart(StickerUtil.stickerModel2EditorData(paramTAVSticker));
        return;
      }
      this.this$1.this$0.stickerOperationCallback.onStickerTouchEnd(StickerUtil.stickerModel2EditorData(paramTAVSticker));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.session.TAVCutSession.2.1
 * JD-Core Version:    0.7.0.1
 */