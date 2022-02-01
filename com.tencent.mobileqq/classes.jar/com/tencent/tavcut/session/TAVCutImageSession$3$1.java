package com.tencent.tavcut.session;

import android.util.SparseArray;
import com.tencent.tavcut.view.TAVCutImageView;
import com.tencent.weseevideo.editor.sticker.StickerController;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.effect.MediaEffectModel;
import java.util.List;

class TAVCutImageSession$3$1
  implements Runnable
{
  TAVCutImageSession$3$1(TAVCutImageSession.3 param3) {}
  
  public void run()
  {
    ((StickerController)this.a.this$0.stickerControllers.get(this.a.val$index)).setStickerContainer(this.a.val$tavCutImageView.getStickerContainer());
    ((StickerController)this.a.this$0.stickerControllers.get(this.a.val$index)).restoreSticker(((MediaModel)this.a.this$0.mediaModels.get(this.a.val$index)).getMediaEffectModel().getStickerModelList());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutImageSession.3.1
 * JD-Core Version:    0.7.0.1
 */