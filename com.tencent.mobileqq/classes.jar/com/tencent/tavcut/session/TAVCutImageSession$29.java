package com.tencent.tavcut.session;

import android.util.SparseArray;
import com.tencent.weseevideo.editor.sticker.PicStickerController;
import com.tencent.weseevideo.editor.sticker.StickerController;

class TAVCutImageSession$29
  implements Runnable
{
  TAVCutImageSession$29(TAVCutImageSession paramTAVCutImageSession, int paramInt) {}
  
  public void run()
  {
    StickerController localStickerController = (StickerController)this.this$0.stickerControllers.get(this.a);
    if ((localStickerController instanceof PicStickerController)) {
      ((PicStickerController)localStickerController).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutImageSession.29
 * JD-Core Version:    0.7.0.1
 */