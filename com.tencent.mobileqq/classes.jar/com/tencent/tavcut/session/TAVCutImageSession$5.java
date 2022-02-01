package com.tencent.tavcut.session;

import android.util.SparseArray;
import com.tencent.weseevideo.editor.sticker.StickerController;

class TAVCutImageSession$5
  implements Runnable
{
  TAVCutImageSession$5(TAVCutImageSession paramTAVCutImageSession, int paramInt) {}
  
  public void run()
  {
    if (this.this$0.stickerControllers.get(this.val$index) != null)
    {
      ((StickerController)this.this$0.stickerControllers.get(this.val$index)).destroy();
      this.this$0.stickerControllers.remove(this.val$index);
    }
    TAVCutImageSession.access$500(this.this$0, this.val$index, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutImageSession.5
 * JD-Core Version:    0.7.0.1
 */