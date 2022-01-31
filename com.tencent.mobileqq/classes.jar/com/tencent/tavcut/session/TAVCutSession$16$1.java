package com.tencent.tavcut.session;

import android.util.SparseArray;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.weseevideo.editor.sticker.StickerController;

class TAVCutSession$16$1
  implements Runnable
{
  TAVCutSession$16$1(TAVCutSession.16 param16, int paramInt) {}
  
  public void run()
  {
    TAVSticker localTAVSticker = ((StickerController)this.this$1.this$0.stickerControllers.get(this.val$key)).updateTextSticker(this.this$1.val$textEditorData);
    if (localTAVSticker != null) {
      TAVCutSession.access$100(this.this$1.this$0, localTAVSticker);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutSession.16.1
 * JD-Core Version:    0.7.0.1
 */