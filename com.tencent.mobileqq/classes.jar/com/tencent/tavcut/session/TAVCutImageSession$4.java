package com.tencent.tavcut.session;

import android.util.SparseArray;
import com.tencent.tavcut.view.TAVCutImageView;
import com.tencent.weseevideo.editor.sticker.StickerController;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.effect.MediaEffectModel;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

class TAVCutImageSession$4
  implements Runnable
{
  TAVCutImageSession$4(TAVCutImageSession paramTAVCutImageSession, int paramInt, StickerController paramStickerController) {}
  
  public void run()
  {
    ((StickerController)this.this$0.stickerControllers.get(this.val$index)).resignCurrentSticker();
    TAVCutImageView localTAVCutImageView = (TAVCutImageView)((WeakReference)TAVCutImageSession.access$200(this.this$0).get(this.val$index)).get();
    if (localTAVCutImageView != null) {
      ((StickerController)this.this$0.stickerControllers.get(this.val$index)).setStickerContainer(localTAVCutImageView);
    }
    this.val$stickerController.restoreSticker(new ArrayList(((MediaModel)this.this$0.mediaModels.get(this.val$index)).getMediaEffectModel().getStickerModelList()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutImageSession.4
 * JD-Core Version:    0.7.0.1
 */