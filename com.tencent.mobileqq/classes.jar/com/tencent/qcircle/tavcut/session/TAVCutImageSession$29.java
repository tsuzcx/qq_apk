package com.tencent.qcircle.tavcut.session;

import android.util.SparseArray;
import com.tencent.qcircle.weseevideo.editor.sticker.PicStickerController;
import com.tencent.qcircle.weseevideo.editor.sticker.StickerController;

class TAVCutImageSession$29
  implements Runnable
{
  TAVCutImageSession$29(TAVCutImageSession paramTAVCutImageSession, int paramInt) {}
  
  public void run()
  {
    StickerController localStickerController = (StickerController)this.this$0.stickerControllers.get(this.val$index);
    if ((localStickerController instanceof PicStickerController)) {
      ((PicStickerController)localStickerController).setStickersVisible();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.session.TAVCutImageSession.29
 * JD-Core Version:    0.7.0.1
 */