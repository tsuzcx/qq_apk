package com.tencent.tavcut.session;

import android.util.SparseArray;
import com.tencent.weseevideo.editor.sticker.StickerController;
import com.tencent.weseevideo.model.effect.StickerModel;

class TAVCutImageSession$14
  implements Runnable
{
  TAVCutImageSession$14(TAVCutImageSession paramTAVCutImageSession, int paramInt, StickerModel paramStickerModel) {}
  
  public void run()
  {
    this.this$0.addSticker((StickerController)this.this$0.stickerControllers.get(this.val$index), this.val$stickerModel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutImageSession.14
 * JD-Core Version:    0.7.0.1
 */