package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavsticker.core.TAVStickerRenderContext;
import com.tencent.tavsticker.model.TAVSticker;

class PagFilterEffect$MyFilter
  extends BaseFilter
{
  PagFilterEffect$MyFilter(TAVSticker paramTAVSticker)
  {
    this.a.loadSticker(paramTAVSticker);
  }
  
  CIImage a(CIImage paramCIImage1, CIImage paramCIImage2)
  {
    return paramCIImage2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.PagFilterEffect.MyFilter
 * JD-Core Version:    0.7.0.1
 */