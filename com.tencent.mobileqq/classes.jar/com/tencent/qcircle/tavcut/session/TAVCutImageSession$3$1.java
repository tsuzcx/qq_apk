package com.tencent.qcircle.tavcut.session;

import android.util.SparseArray;
import com.tencent.qcircle.tavcut.view.TAVCutImageView;
import com.tencent.qcircle.weseevideo.editor.sticker.StickerController;
import com.tencent.qcircle.weseevideo.model.MediaModel;
import com.tencent.qcircle.weseevideo.model.effect.MediaEffectModel;
import java.util.List;

class TAVCutImageSession$3$1
  implements Runnable
{
  TAVCutImageSession$3$1(TAVCutImageSession.3 param3) {}
  
  public void run()
  {
    ((StickerController)this.this$1.this$0.stickerControllers.get(this.this$1.val$index)).setStickerContainer(this.this$1.val$tavCutImageView.getStickerContainer());
    ((StickerController)this.this$1.this$0.stickerControllers.get(this.this$1.val$index)).restoreSticker(((MediaModel)this.this$1.this$0.mediaModels.get(this.this$1.val$index)).getMediaEffectModel().getStickerModelList());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.session.TAVCutImageSession.3.1
 * JD-Core Version:    0.7.0.1
 */