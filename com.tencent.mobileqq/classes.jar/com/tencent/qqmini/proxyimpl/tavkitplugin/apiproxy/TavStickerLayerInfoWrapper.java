package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

import android.graphics.RectF;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerLayerInfo;
import com.tencent.tavsticker.model.TAVStickerLayerInfo.TAVStickerTimeEffect;
import java.util.Iterator;
import java.util.List;
import org.libpag.PAGFile;
import org.libpag.PAGLayer;

public class TavStickerLayerInfoWrapper
  extends TAVStickerLayerInfo
{
  private final TAVSticker a;
  
  TavStickerLayerInfoWrapper(TAVStickerLayerInfo paramTAVStickerLayerInfo, TAVSticker paramTAVSticker)
  {
    super(paramTAVStickerLayerInfo.getLayerIndex(), paramTAVStickerLayerInfo.getLayerType(), paramTAVStickerLayerInfo.getTimeRange(), paramTAVStickerLayerInfo.getTimeEffects(), paramTAVStickerLayerInfo.getImageEffects(), paramTAVStickerLayerInfo.getUserDataList());
    this.a = paramTAVSticker;
  }
  
  CGSize a()
  {
    RectF localRectF = this.a.getPagFile().getLayerAt(getLayerIndex()).getBounds();
    return new CGSize(localRectF.width(), localRectF.height());
  }
  
  CMTime a()
  {
    Object localObject = CMTime.CMTimeZero;
    Iterator localIterator = getTimeEffects().iterator();
    if (localIterator.hasNext())
    {
      CMTime localCMTime = ((TAVStickerLayerInfo.TAVStickerTimeEffect)localIterator.next()).getTimeRange().getEnd();
      if (!((CMTime)localObject).smallThan(localCMTime)) {
        break label54;
      }
      localObject = localCMTime;
    }
    label54:
    for (;;)
    {
      break;
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.TavStickerLayerInfoWrapper
 * JD-Core Version:    0.7.0.1
 */