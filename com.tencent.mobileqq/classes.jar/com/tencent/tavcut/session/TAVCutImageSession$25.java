package com.tencent.tavcut.session;

import android.util.SparseArray;
import com.tencent.weseevideo.editor.sticker.StickerController;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.effect.MediaEffectModel;
import java.util.List;

class TAVCutImageSession$25
  implements Runnable
{
  TAVCutImageSession$25(TAVCutImageSession paramTAVCutImageSession, int paramInt) {}
  
  public void run()
  {
    ((MediaModel)this.this$0.mediaModels.get(this.a)).getMediaEffectModel().getStickerModelList().clear();
    ((StickerController)this.this$0.stickerControllers.get(this.a)).removeAllStickers(new TAVCutImageSession.25.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutImageSession.25
 * JD-Core Version:    0.7.0.1
 */