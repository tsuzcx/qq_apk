package com.tencent.tavcut.session;

import android.util.SparseArray;
import com.tencent.tavcut.util.DurationUtil;
import com.tencent.weseevideo.composition.VideoRenderChainManager;
import com.tencent.weseevideo.composition.image.WSImageRender;
import com.tencent.weseevideo.editor.sticker.StickerController;

class TAVCutImageSession$5
  implements Runnable
{
  TAVCutImageSession$5(TAVCutImageSession paramTAVCutImageSession, int paramInt) {}
  
  public void run()
  {
    DurationUtil.start("releaseTAVCutImageView");
    TAVCutImageSession.access$200(this.this$0).remove(this.val$index);
    if (this.this$0.renderChainManagers.get(this.val$index) != null)
    {
      ((VideoRenderChainManager)this.this$0.renderChainManagers.get(this.val$index)).release();
      this.this$0.renderChainManagers.remove(this.val$index);
    }
    if (this.this$0.stickerControllers.get(this.val$index) != null)
    {
      ((StickerController)this.this$0.stickerControllers.get(this.val$index)).destroy();
      this.this$0.stickerControllers.remove(this.val$index);
    }
    if (TAVCutImageSession.access$300(this.this$0).get(this.val$index) != null) {
      ((WSImageRender)TAVCutImageSession.access$300(this.this$0).get(this.val$index)).release();
    }
    this.this$0.tavCompositions.remove(this.val$index);
    DurationUtil.end("releaseTAVCutImageView");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutImageSession.5
 * JD-Core Version:    0.7.0.1
 */