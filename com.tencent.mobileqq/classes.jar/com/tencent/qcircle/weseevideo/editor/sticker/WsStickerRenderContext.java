package com.tencent.qcircle.weseevideo.editor.sticker;

import com.tencent.qcircle.weseevideo.editor.sticker.model.TAVStickerExKt;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavsticker.core.ITAVRenderContextDataSource;
import com.tencent.tavsticker.core.TAVStickerRenderContext;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class WsStickerRenderContext
  extends TAVStickerRenderContext
  implements IBlurStickerRenderContext
{
  protected List<TAVSticker> blurStickers = Collections.synchronizedList(new ArrayList());
  
  private boolean isBlurSticker(TAVSticker paramTAVSticker)
  {
    return (paramTAVSticker != null) && (paramTAVSticker.getExtraBundle() != null) && (TAVStickerExKt.getExtraStickerType(paramTAVSticker) != null) && (TAVStickerExKt.getExtraStickerType(paramTAVSticker).equals("blur"));
  }
  
  public void checkStickerList()
  {
    super.checkStickerList();
  }
  
  public TAVStickerRenderContext copy()
  {
    WsStickerRenderContext localWsStickerRenderContext = new WsStickerRenderContext();
    localWsStickerRenderContext.checkStickerList();
    if (this.stickers != null) {
      localWsStickerRenderContext.setStickerList(this.stickers);
    }
    localWsStickerRenderContext.setRenderSize(this.renderSize);
    localWsStickerRenderContext.setLayerIndex(this.stickerLayerIndex);
    localWsStickerRenderContext.setRenderContextSource(this.renderContextDataSource);
    localWsStickerRenderContext.setStickerRenderQuality(this.quality);
    localWsStickerRenderContext.blurStickers = this.blurStickers;
    checkChildContexts();
    this.childContexts.add(localWsStickerRenderContext);
    return localWsStickerRenderContext;
  }
  
  public List<TAVSticker> getBlurStickers()
  {
    return this.blurStickers;
  }
  
  public void loadSticker(TAVSticker paramTAVSticker, boolean paramBoolean)
  {
    if ((isBlurSticker(paramTAVSticker)) && (!this.blurStickers.contains(paramTAVSticker))) {
      this.blurStickers.add(paramTAVSticker);
    }
    super.loadSticker(paramTAVSticker, paramBoolean);
  }
  
  public void removeAllStickers()
  {
    this.blurStickers.clear();
    super.removeAllStickers();
  }
  
  public boolean removeSticker(TAVSticker paramTAVSticker)
  {
    if (this.blurStickers.contains(paramTAVSticker)) {
      this.blurStickers.remove(paramTAVSticker);
    }
    return super.removeSticker(paramTAVSticker);
  }
  
  public void setLayerIndex(int paramInt)
  {
    this.stickerLayerIndex = paramInt;
  }
  
  public void setRenderContextSource(ITAVRenderContextDataSource paramITAVRenderContextDataSource)
  {
    this.renderContextDataSource = paramITAVRenderContextDataSource;
  }
  
  public void setStickerList(List<TAVSticker> paramList)
  {
    this.stickers = paramList;
  }
  
  public boolean shouldRenderBlurSticker()
  {
    Object localObject = this.blurStickers;
    if (localObject != null)
    {
      if (((List)localObject).size() == 0) {
        return false;
      }
      localObject = this.blurStickers.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((TAVSticker)((Iterator)localObject).next()).getMode() == TAVStickerMode.INACTIVE) {
          return true;
        }
      }
    }
    return false;
  }
  
  protected boolean shouldRenderSticker(TAVSticker paramTAVSticker, long paramLong)
  {
    if (paramTAVSticker == null) {
      return false;
    }
    if (this.renderContextDataSource != null) {
      return this.renderContextDataSource.shouldRenderSticker(paramTAVSticker, paramLong);
    }
    CMTimeRange localCMTimeRange = paramTAVSticker.getTimeRange();
    boolean bool;
    if (localCMTimeRange == null) {
      bool = true;
    } else {
      bool = localCMTimeRange.containsTime(new CMTime(paramLong, 1000));
    }
    if ((isBlurSticker(paramTAVSticker)) && (paramTAVSticker.getMode() == TAVStickerMode.INACTIVE)) {
      return false;
    }
    return (bool) && (TAVStickerMode.INACTIVE == paramTAVSticker.getMode());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.editor.sticker.WsStickerRenderContext
 * JD-Core Version:    0.7.0.1
 */