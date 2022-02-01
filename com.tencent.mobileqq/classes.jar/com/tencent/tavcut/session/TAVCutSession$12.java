package com.tencent.tavcut.session;

import android.util.SparseArray;
import com.tencent.weseevideo.composition.VideoRenderChainManager;
import com.tencent.weseevideo.editor.sticker.StickerController;
import com.tencent.weseevideo.editor.sticker.dispatcher.StickerEventDispatcher;

class TAVCutSession$12
  implements Runnable
{
  TAVCutSession$12(TAVCutSession paramTAVCutSession) {}
  
  public void run()
  {
    int j = 0;
    StickerEventDispatcher.getInstance().removeStickerEventListener(this.this$0.stickerEventListener);
    this.this$0.stickerOperationCallback = null;
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutSession.12
 * JD-Core Version:    0.7.0.1
 */