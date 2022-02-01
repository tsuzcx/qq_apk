package com.tencent.qcircle.tavcut.session;

import android.util.SparseArray;
import com.tencent.qcircle.tavcut.util.StickerUtil;
import com.tencent.qcircle.weseevideo.editor.sticker.StickerController;
import com.tencent.qcircle.weseevideo.editor.sticker.utils.StickerConverter;
import com.tencent.qcircle.weseevideo.model.effect.StickerModel;
import com.tencent.qcircle.weseevideo.model.effect.SubtitleModel;
import com.tencent.tavsticker.model.TAVSticker;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class TAVCutSession$5$1
  implements Runnable
{
  TAVCutSession$5$1(TAVCutSession.5 param5) {}
  
  public void run()
  {
    Object localObject = this.this$1.val$stickerController.getCurrentSticker();
    if (localObject != null) {
      TAVCutSession.access$000(this.this$1.this$0, (TAVSticker)localObject);
    }
    if (this.this$1.this$0.bulkStickers.get(this.this$1.val$index) == null) {
      this.this$1.this$0.bulkStickers.put(this.this$1.val$index, new ArrayList());
    }
    this.this$1.val$stickerController.resignCurrentSticker();
    Iterator localIterator = this.this$1.val$stickerModels.iterator();
    while (localIterator.hasNext())
    {
      localObject = (StickerModel)localIterator.next();
      if ((localObject instanceof SubtitleModel)) {
        localObject = StickerConverter.subtitleModel2TavSticker((SubtitleModel)localObject);
      } else {
        localObject = StickerUtil.stickerModel2TavSticker((StickerModel)localObject);
      }
      if (localObject != null)
      {
        this.this$1.val$stickerController.addSticker((TAVSticker)localObject, this.this$1.val$needSelect);
        if (this.this$1.this$0.bulkStickers.get(this.this$1.val$index) != null) {
          ((ArrayList)this.this$1.this$0.bulkStickers.get(this.this$1.val$index)).add(localObject);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.session.TAVCutSession.5.1
 * JD-Core Version:    0.7.0.1
 */