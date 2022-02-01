package com.tencent.qcircle.tavcut.session;

import android.util.SparseArray;
import com.tencent.qcircle.tavcut.util.DurationUtil;
import com.tencent.qcircle.weseevideo.editor.sticker.StickerController;

class TAVCutImageSession$4
  implements Runnable
{
  TAVCutImageSession$4(TAVCutImageSession paramTAVCutImageSession, int paramInt) {}
  
  public void run()
  {
    DurationUtil.start("releaseTAVCutImageView");
    TAVCutImageSession.access$400(this.this$0).remove(this.val$index);
    if (this.this$0.stickerControllers.get(this.val$index) != null)
    {
      ((StickerController)this.this$0.stickerControllers.get(this.val$index)).destroy();
      this.this$0.stickerControllers.remove(this.val$index);
    }
    TAVCutImageSession.access$500(this.this$0, this.val$index, false);
    DurationUtil.end("releaseTAVCutImageView");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.session.TAVCutImageSession.4
 * JD-Core Version:    0.7.0.1
 */