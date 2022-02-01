package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavsticker.core.TAVStickerRenderContext;
import com.tencent.tavsticker.model.TAVSticker;
import java.util.Iterator;
import java.util.List;

class PagOverlayEffect$MyFilter
  extends BaseFilter
{
  PagOverlayEffect$MyFilter(List<TAVSticker> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TAVSticker localTAVSticker = (TAVSticker)paramList.next();
      this.a.loadSticker(localTAVSticker);
    }
  }
  
  CIImage a(CIImage paramCIImage1, CIImage paramCIImage2)
  {
    paramCIImage2.imageByCompositingOverImage(paramCIImage1);
    return paramCIImage1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.PagOverlayEffect.MyFilter
 * JD-Core Version:    0.7.0.1
 */