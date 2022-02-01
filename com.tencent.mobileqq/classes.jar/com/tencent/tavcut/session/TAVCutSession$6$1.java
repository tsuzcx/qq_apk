package com.tencent.tavcut.session;

import android.util.SparseArray;
import com.tencent.weseevideo.editor.sticker.StickerController;

class TAVCutSession$6$1
  implements Runnable
{
  TAVCutSession$6$1(TAVCutSession.6 param6, int paramInt) {}
  
  public void run()
  {
    ((StickerController)this.this$1.this$0.stickerControllers.get(this.val$key)).updateTextSticker(this.this$1.val$textEditorData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutSession.6.1
 * JD-Core Version:    0.7.0.1
 */