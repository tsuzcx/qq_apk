package com.tencent.qcircle.tavcut.session;

import android.util.SparseArray;
import com.tencent.qcircle.weseevideo.composition.VideoRenderChainManager;
import com.tencent.qcircle.weseevideo.composition.effectnode.WSOverLayBlurManager;
import com.tencent.qcircle.weseevideo.editor.sticker.StickerController;
import com.tencent.qcircle.weseevideo.editor.sticker.dispatcher.StickerEventDispatcher;

class TAVCutSession$13
  implements Runnable
{
  TAVCutSession$13(TAVCutSession paramTAVCutSession) {}
  
  public void run()
  {
    StickerEventDispatcher.getInstance().removeStickerEventListener(this.this$0.stickerEventListener);
    this.this$0.stickerOperationCallback = null;
    int j = 0;
    int i = 0;
    while (i < this.this$0.renderChainManagers.size())
    {
      int k = this.this$0.renderChainManagers.keyAt(i);
      ((VideoRenderChainManager)this.this$0.renderChainManagers.get(k)).release();
      i += 1;
    }
    this.this$0.renderChainManagers.clear();
    i = j;
    while (i < this.this$0.stickerControllers.size())
    {
      j = this.this$0.stickerControllers.keyAt(i);
      ((StickerController)this.this$0.stickerControllers.get(j)).destroy();
      i += 1;
    }
    this.this$0.stickerControllers.clear();
    WSOverLayBlurManager.release();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.session.TAVCutSession.13
 * JD-Core Version:    0.7.0.1
 */