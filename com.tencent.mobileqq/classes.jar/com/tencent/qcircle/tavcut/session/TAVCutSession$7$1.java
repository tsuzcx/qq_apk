package com.tencent.qcircle.tavcut.session;

import android.util.SparseArray;
import com.tencent.qcircle.weseevideo.editor.sticker.StickerController;

class TAVCutSession$7$1
  implements Runnable
{
  TAVCutSession$7$1(TAVCutSession.7 param7, int paramInt) {}
  
  public void run()
  {
    ((StickerController)this.this$1.this$0.stickerControllers.get(this.val$key)).updateTextSticker(this.this$1.val$textEditorData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.session.TAVCutSession.7.1
 * JD-Core Version:    0.7.0.1
 */