package com.tencent.tavcut.session;

import android.util.SparseArray;
import com.tencent.weseevideo.editor.sticker.StickerController;

class TAVCutImageSession$22
  implements Runnable
{
  TAVCutImageSession$22(TAVCutImageSession paramTAVCutImageSession, int paramInt) {}
  
  public void run()
  {
    ((StickerController)this.this$0.stickerControllers.get(this.val$index)).resignCurrentSticker();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutImageSession.22
 * JD-Core Version:    0.7.0.1
 */