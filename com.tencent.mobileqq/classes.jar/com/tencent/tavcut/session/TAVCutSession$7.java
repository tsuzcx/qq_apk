package com.tencent.tavcut.session;

import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.effect.MediaEffectModel;
import com.tencent.weseevideo.model.effect.StickerModel;
import java.util.Iterator;
import java.util.List;

class TAVCutSession$7
  implements Runnable
{
  TAVCutSession$7(TAVCutSession paramTAVCutSession, TAVSticker paramTAVSticker) {}
  
  public void run()
  {
    Iterator localIterator = this.this$0.mediaModels.iterator();
    label34:
    label111:
    label114:
    for (;;)
    {
      MediaModel localMediaModel;
      int i;
      if (localIterator.hasNext())
      {
        localMediaModel = (MediaModel)localIterator.next();
        i = 0;
        if (i >= localMediaModel.getMediaEffectModel().getStickerModelList().size()) {
          break label111;
        }
        if (!((StickerModel)localMediaModel.getMediaEffectModel().getStickerModelList().get(i)).getUniqueId().equals(this.val$tavSticker.getStickerId())) {}
      }
      for (;;)
      {
        if (i < 0) {
          break label114;
        }
        localMediaModel.getMediaEffectModel().getStickerModelList().remove(i);
        break;
        i += 1;
        break label34;
        return;
        i = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutSession.7
 * JD-Core Version:    0.7.0.1
 */