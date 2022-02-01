package com.tencent.tavcut.session;

import com.tencent.weseevideo.model.MediaModel;
import com.tencent.weseevideo.model.effect.MediaEffectModel;
import com.tencent.weseevideo.model.effect.StickerModel;
import java.util.Iterator;
import java.util.List;

class TAVCutSession$9
  implements Runnable
{
  TAVCutSession$9(TAVCutSession paramTAVCutSession, String paramString) {}
  
  public void run()
  {
    Iterator localIterator1 = this.this$0.mediaModels.iterator();
    label122:
    for (;;)
    {
      MediaModel localMediaModel;
      List localList;
      StickerModel localStickerModel;
      if (localIterator1.hasNext())
      {
        localMediaModel = (MediaModel)localIterator1.next();
        localList = localMediaModel.getMediaEffectModel().getStickerModelList();
        Iterator localIterator2 = localList.iterator();
        do
        {
          if (!localIterator2.hasNext()) {
            break;
          }
          localStickerModel = (StickerModel)localIterator2.next();
        } while (!localStickerModel.getUniqueId().equals(this.val$uniqueId));
      }
      for (int i = localList.indexOf(localStickerModel);; i = -1)
      {
        if (i < 0) {
          break label122;
        }
        localMediaModel.getMediaEffectModel().getStickerModelList().remove(i);
        break;
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutSession.9
 * JD-Core Version:    0.7.0.1
 */