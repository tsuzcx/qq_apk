package com.tencent.ttpic.openapi.cache;

import com.tencent.ttpic.cache.LoadETCItemManager;
import com.tencent.ttpic.cache.LoadItemManager;
import com.tencent.ttpic.cache.LoadItemManager.LOAD_TYPE;
import com.tencent.ttpic.cache.LoadStickerItemManager;
import com.tencent.ttpic.openapi.extrastickerutil.ExtraStickerParserAgent;
import com.tencent.ttpic.openapi.model.StickerItem;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.VideoMaterialUtil;
import com.tencent.ttpic.util.VideoFilterFactory.STICKER_TYPE;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class VideoMemoryManager$2
  implements Runnable
{
  VideoMemoryManager$2(VideoMemoryManager paramVideoMemoryManager, VideoMaterial paramVideoMaterial) {}
  
  public void run()
  {
    Iterator localIterator = this.val$material.getItemList().iterator();
    while (localIterator.hasNext())
    {
      StickerItem localStickerItem = (StickerItem)localIterator.next();
      if ((!VideoMaterialUtil.isEmptyItem(localStickerItem)) && (!VideoMemoryManager.access$800(this.this$0).containsKey(localStickerItem.id))) {
        if (ExtraStickerParserAgent.getInstance().isInExtraParser(localStickerItem.stickerType))
        {
          if (VideoMemoryManager.access$800(this.this$0) != null) {
            VideoMemoryManager.access$800(this.this$0).put(localStickerItem.id, new LoadExtraStickerParserManager(this.val$material.getDataPath(), localStickerItem));
          }
        }
        else if (localStickerItem.stickerType == VideoFilterFactory.STICKER_TYPE.ETC.type)
        {
          if (VideoMemoryManager.access$800(this.this$0) != null) {
            VideoMemoryManager.access$800(this.this$0).put(localStickerItem.id, new LoadETCItemManager(VideoMemoryManager.access$900(this.this$0), this.val$material.getDataPath(), localStickerItem));
          }
        }
        else if (localStickerItem.stickerType == VideoFilterFactory.STICKER_TYPE.PAG_STICKER.type)
        {
          if (VideoMemoryManager.access$800(this.this$0) != null) {
            VideoMemoryManager.access$800(this.this$0).put(localStickerItem.id, new LoadPagItemManager(this.val$material.getDataPath(), localStickerItem));
          }
        }
        else if (VideoMemoryManager.access$800(this.this$0) != null) {
          VideoMemoryManager.access$800(this.this$0).put(localStickerItem.id, new LoadStickerItemManager(VideoMemoryManager.access$1000(this.this$0), this.val$material.getDataPath(), localStickerItem, LoadItemManager.LOAD_TYPE.LOAD_ALL, 1));
        }
      }
    }
    localIterator = VideoMemoryManager.access$800(this.this$0).values().iterator();
    while (localIterator.hasNext()) {
      ((LoadItemManager)localIterator.next()).prepareImages();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.cache.VideoMemoryManager.2
 * JD-Core Version:    0.7.0.1
 */