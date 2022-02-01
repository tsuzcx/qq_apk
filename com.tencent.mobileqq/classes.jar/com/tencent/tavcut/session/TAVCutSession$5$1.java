package com.tencent.tavcut.session;

import android.util.SparseArray;
import com.tencent.tavcut.session.callback.StickerOperationCallback;
import com.tencent.tavcut.util.StickerUtil;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.weseevideo.editor.sticker.StickerController;
import com.tencent.weseevideo.editor.sticker.utils.StickerConverter;
import com.tencent.weseevideo.model.effect.StickerModel;
import com.tencent.weseevideo.model.effect.SubtitleModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class TAVCutSession$5$1
  implements Runnable
{
  TAVCutSession$5$1(TAVCutSession.5 param5) {}
  
  public void run()
  {
    Object localObject = this.a.val$stickerController.getCurrentSticker();
    if (localObject != null) {
      TAVCutSession.access$000(this.a.this$0, (TAVSticker)localObject);
    }
    if (this.a.this$0.bulkStickers.get(this.a.val$index) == null) {
      this.a.this$0.bulkStickers.put(this.a.val$index, new ArrayList());
    }
    this.a.val$stickerController.resignCurrentSticker();
    Iterator localIterator = this.a.val$stickerModels.iterator();
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
        this.a.val$stickerController.addSticker((TAVSticker)localObject, this.a.val$needSelect);
        if (this.a.this$0.bulkStickers.get(this.a.val$index) != null) {
          ((ArrayList)this.a.this$0.bulkStickers.get(this.a.val$index)).add(localObject);
        }
      }
      if (this.a.this$0.stickerOperationCallback != null) {
        this.a.this$0.stickerOperationCallback.onAddStickerDone(((TAVSticker)localObject).getStickerId());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutSession.5.1
 * JD-Core Version:    0.7.0.1
 */