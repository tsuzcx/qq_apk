package com.tencent.qcircle.tavcut.session;

import android.util.SparseArray;
import com.tencent.qcircle.tavcut.view.TAVCutImageView;
import com.tencent.qcircle.weseevideo.editor.sticker.StickerController;
import java.lang.ref.WeakReference;

class TAVCutImageSession$3
  implements Runnable
{
  TAVCutImageSession$3(TAVCutImageSession paramTAVCutImageSession, int paramInt, TAVCutImageView paramTAVCutImageView) {}
  
  public void run()
  {
    TAVCutImageSession.access$400(this.this$0).put(this.val$index, new WeakReference(this.val$tavCutImageView));
    if ((StickerController)this.this$0.stickerControllers.get(this.val$index) == null)
    {
      StickerController localStickerController = this.this$0.createStickerController();
      this.this$0.stickerControllers.put(this.val$index, localStickerController);
      localStickerController.createStickerContext(true);
      this.this$0.runOnMainThread(new TAVCutImageSession.3.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.session.TAVCutImageSession.3
 * JD-Core Version:    0.7.0.1
 */