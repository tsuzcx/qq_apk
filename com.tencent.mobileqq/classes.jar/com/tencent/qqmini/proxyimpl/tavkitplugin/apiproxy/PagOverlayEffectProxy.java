package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

import com.tencent.qqmini.proxyimpl.tavkitplugin.ObjCreateTavEvent;
import com.tencent.qqmini.proxyimpl.tavkitplugin.SendMsgTavEvent;
import com.tencent.tavsticker.model.TAVSticker;
import org.json.JSONObject;

class PagOverlayEffectProxy
  extends BaseTavApiProxy
{
  private void a(PagOverlayEffect paramPagOverlayEffect, SendMsgTavEvent paramSendMsgTavEvent)
  {
    if (!"setPAGFiles".equals(paramSendMsgTavEvent.b()))
    {
      b(paramPagOverlayEffect, paramSendMsgTavEvent);
      return;
    }
    paramPagOverlayEffect.a(ObjConvector.a(paramSendMsgTavEvent.a().getJSONArray("pagFiles"), TAVSticker.class));
    a();
  }
  
  private void b(PagOverlayEffect paramPagOverlayEffect, SendMsgTavEvent paramSendMsgTavEvent)
  {
    if (!"getPAGFiles".equals(paramSendMsgTavEvent.b()))
    {
      c();
      return;
    }
    c(ObjConvector.c(paramPagOverlayEffect.a()));
  }
  
  void a(ObjCreateTavEvent paramObjCreateTavEvent)
  {
    super.a(paramObjCreateTavEvent);
    a(new PagOverlayEffect());
  }
  
  void a(SendMsgTavEvent paramSendMsgTavEvent)
  {
    super.a(paramSendMsgTavEvent);
    Object localObject = paramSendMsgTavEvent.a();
    if (!(localObject instanceof PagOverlayEffect)) {
      return;
    }
    a((PagOverlayEffect)localObject, paramSendMsgTavEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.PagOverlayEffectProxy
 * JD-Core Version:    0.7.0.1
 */