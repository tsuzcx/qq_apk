package com.tencent.tavcut.session;

import android.util.SparseArray;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.weseevideo.composition.VideoRenderChainManager.ShouldRenderStickerAdapter;
import java.util.ArrayList;
import java.util.Iterator;

class TAVCutImageSession$21$1
  implements VideoRenderChainManager.ShouldRenderStickerAdapter
{
  TAVCutImageSession$21$1(TAVCutImageSession.21 param21) {}
  
  public boolean shouldRenderSticker(TAVSticker paramTAVSticker, long paramLong)
  {
    Object localObject = (ArrayList)this.this$1.this$0.bulkStickers.get(this.this$1.val$index);
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((TAVSticker)((Iterator)localObject).next()).getStickerId().equals(paramTAVSticker.getStickerId())) {
          return true;
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.session.TAVCutImageSession.21.1
 * JD-Core Version:    0.7.0.1
 */