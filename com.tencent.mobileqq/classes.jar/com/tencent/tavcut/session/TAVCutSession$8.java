package com.tencent.tavcut.session;

import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.effect.MediaEffectModel;
import com.tencent.weseevideo.model.effect.StickerModel;
import java.util.Iterator;
import java.util.List;

class TAVCutSession$8
  implements Runnable
{
  TAVCutSession$8(TAVCutSession paramTAVCutSession, TAVSticker paramTAVSticker) {}
  
  public void run()
  {
    Iterator localIterator1 = this.this$0.mediaModels.iterator();
    while (localIterator1.hasNext())
    {
      MediaModel localMediaModel = (MediaModel)localIterator1.next();
      int j = -1;
      List localList = localMediaModel.getMediaEffectModel().getStickerModelList();
      Iterator localIterator2 = localList.iterator();
      StickerModel localStickerModel;
      do
      {
        i = j;
        if (!localIterator2.hasNext()) {
          break;
        }
        localStickerModel = (StickerModel)localIterator2.next();
      } while (!localStickerModel.getUniqueId().equals(this.val$tavSticker.getStickerId()));
      int i = localList.indexOf(localStickerModel);
      if (i >= 0) {
        localMediaModel.getMediaEffectModel().getStickerModelList().remove(i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutSession.8
 * JD-Core Version:    0.7.0.1
 */