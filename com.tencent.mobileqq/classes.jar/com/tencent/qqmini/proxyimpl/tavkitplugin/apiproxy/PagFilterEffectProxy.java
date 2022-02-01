package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

import com.tencent.qqmini.proxyimpl.tavkitplugin.ObjCreateTavEvent;
import com.tencent.tavsticker.model.TAVSticker;

class PagFilterEffectProxy
  extends BaseTavApiProxy
{
  void a(ObjCreateTavEvent paramObjCreateTavEvent)
  {
    super.a(paramObjCreateTavEvent);
    paramObjCreateTavEvent = paramObjCreateTavEvent.a("pagFile");
    if (!(paramObjCreateTavEvent instanceof TAVSticker))
    {
      a("error params pagFile");
      return;
    }
    a(new PagFilterEffect((TAVSticker)paramObjCreateTavEvent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.PagFilterEffectProxy
 * JD-Core Version:    0.7.0.1
 */