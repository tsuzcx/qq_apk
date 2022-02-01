package com.tencent.weseevideo.editor.sticker;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.PointF;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavsticker.core.ITAVRenderContextDataSource;
import com.tencent.tavsticker.core.TAVStickerContext;
import com.tencent.tavsticker.core.TAVStickerRenderContext;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerMode;
import com.tencent.tavsticker.utils.TAVStickerUtil;
import com.tencent.weseevideo.composition.effectnode.WsStickerUtil;
import com.tencent.weseevideo.editor.sticker.model.TAVStickerExKt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class WsStickerContext
  extends TAVStickerContext
  implements IBlurStickerRenderContext
{
  protected List<TAVSticker> blurStickers = Collections.synchronizedList(new ArrayList());
  
  public WsStickerContext(Context paramContext)
  {
    super(paramContext);
  }
  
  private boolean isBlurSticker(TAVSticker paramTAVSticker)
  {
    return (paramTAVSticker != null) && (paramTAVSticker.getExtraBundle() != null) && (TAVStickerExKt.getExtraStickerType(paramTAVSticker) != null) && (TAVStickerExKt.getExtraStickerType(paramTAVSticker).equals("blur"));
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
  
  public boolean isTouchOnTavSticker(TAVSticker paramTAVSticker, float paramFloat1, float paramFloat2)
  {
    if (paramTAVSticker == null) {
      return false;
    }
    if (!TAVStickerUtil.isValidCGSize(this.renderSize)) {
      return false;
    }
    if ("blur".equals(TAVStickerExKt.getExtraStickerType(paramTAVSticker))) {}
    for (Matrix localMatrix = WsStickerUtil.getRatioChangeMatrix(paramTAVSticker, (int)this.renderSize.width, (int)this.renderSize.height);; localMatrix = TAVStickerUtil.getMatrix(paramTAVSticker, (int)this.renderSize.width, (int)this.renderSize.height))
    {
      paramTAVSticker = TAVStickerUtil.computeRectanglePoints(localMatrix, paramTAVSticker.getWidth(), paramTAVSticker.getHeight());
      if (!TAVStickerUtil.inQuadrangle(paramTAVSticker[0], paramTAVSticker[1], paramTAVSticker[2], paramTAVSticker[3], new PointF(paramFloat1, paramFloat2))) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public void loadSticker(TAVSticker paramTAVSticker, boolean paramBoolean)
  {
    if ((isBlurSticker(paramTAVSticker)) && (!this.blurStickers.contains(paramTAVSticker))) {
      this.blurStickers.add(paramTAVSticker);
    }
    super.loadSticker(paramTAVSticker, paramBoolean);
  }
  
  public boolean removeSticker(TAVSticker paramTAVSticker)
  {
    if (this.blurStickers.contains(paramTAVSticker)) {
      this.blurStickers.remove(paramTAVSticker);
    }
    return super.removeSticker(paramTAVSticker);
  }
  
  public boolean shouldRenderBlurSticker()
  {
    if ((this.blurStickers == null) || (this.blurStickers.size() == 0)) {
      return false;
    }
    Iterator localIterator = this.blurStickers.iterator();
    while (localIterator.hasNext()) {
      if (((TAVSticker)localIterator.next()).getMode() == TAVStickerMode.INACTIVE) {
        return true;
      }
    }
    return false;
  }
  
  public boolean shouldRenderSticker(TAVSticker paramTAVSticker, long paramLong)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramTAVSticker == null) {
      bool1 = false;
    }
    do
    {
      return bool1;
      if (this.renderContextDataSource != null) {
        return this.renderContextDataSource.shouldRenderSticker(paramTAVSticker, paramLong);
      }
      CMTimeRange localCMTimeRange = paramTAVSticker.getTimeRange();
      if (localCMTimeRange == null) {}
      for (bool1 = true; (isBlurSticker(paramTAVSticker)) && (paramTAVSticker.getMode() == TAVStickerMode.INACTIVE); bool1 = localCMTimeRange.containsTime(new CMTime(paramLong, 1000))) {
        return false;
      }
      if (!bool1) {
        break;
      }
      bool1 = bool2;
    } while (TAVStickerMode.INACTIVE == paramTAVSticker.getMode());
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.weseevideo.editor.sticker.WsStickerContext
 * JD-Core Version:    0.7.0.1
 */