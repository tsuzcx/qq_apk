package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

import com.tencent.qqmini.proxyimpl.tavkitplugin.ObjCreateTavEvent;
import com.tencent.qqmini.proxyimpl.tavkitplugin.SendMsgTavEvent;
import com.tencent.tavkit.utils.ListUtils;
import com.tencent.tavsticker.model.TAVSticker;
import org.json.JSONObject;

class PagMixerEffectProxy
  extends BaseTavApiProxy
{
  private void a(PagMixerEffect paramPagMixerEffect, SendMsgTavEvent paramSendMsgTavEvent)
  {
    if (!"setPAGFiles".equals(paramSendMsgTavEvent.b()))
    {
      b(paramPagMixerEffect, paramSendMsgTavEvent);
      return;
    }
    paramPagMixerEffect.a(ObjConvector.a(paramSendMsgTavEvent.a().getJSONArray("pagFiles"), TAVSticker.class));
    a();
  }
  
  private void b(PagMixerEffect paramPagMixerEffect, SendMsgTavEvent paramSendMsgTavEvent)
  {
    if (!"getPAGFiles".equals(paramSendMsgTavEvent.b()))
    {
      c();
      return;
    }
    c(ObjConvector.c(paramPagMixerEffect.a()));
  }
  
  void a(ObjCreateTavEvent paramObjCreateTavEvent)
  {
    super.a(paramObjCreateTavEvent);
    PagMixerEffect localPagMixerEffect = new PagMixerEffect();
    if ("pagFile".equals(paramObjCreateTavEvent.b()))
    {
      paramObjCreateTavEvent = paramObjCreateTavEvent.a("pagFile");
      if (!(paramObjCreateTavEvent instanceof TAVSticker))
      {
        b("pagFile");
        return;
      }
      localPagMixerEffect.a(ListUtils.listWithObjects(new TAVSticker[] { (TAVSticker)paramObjCreateTavEvent }));
    }
    a(localPagMixerEffect);
  }
  
  void a(SendMsgTavEvent paramSendMsgTavEvent)
  {
    super.a(paramSendMsgTavEvent);
    Object localObject = paramSendMsgTavEvent.a();
    if (!(localObject instanceof PagMixerEffect)) {
      return;
    }
    a((PagMixerEffect)localObject, paramSendMsgTavEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.PagMixerEffectProxy
 * JD-Core Version:    0.7.0.1
 */