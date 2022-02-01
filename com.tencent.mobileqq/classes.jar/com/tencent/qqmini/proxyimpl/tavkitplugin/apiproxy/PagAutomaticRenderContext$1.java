package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

import com.tencent.tavsticker.model.TAVStickerLayerInfo;
import java.util.Comparator;

class PagAutomaticRenderContext$1
  implements Comparator<TAVStickerLayerInfo>
{
  PagAutomaticRenderContext$1(PagAutomaticRenderContext paramPagAutomaticRenderContext) {}
  
  public int a(TAVStickerLayerInfo paramTAVStickerLayerInfo1, TAVStickerLayerInfo paramTAVStickerLayerInfo2)
  {
    return paramTAVStickerLayerInfo1.getLayerIndex() - paramTAVStickerLayerInfo2.getLayerIndex();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.PagAutomaticRenderContext.1
 * JD-Core Version:    0.7.0.1
 */