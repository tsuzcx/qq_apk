package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

import com.tencent.qqmini.proxyimpl.tavkitplugin.ObjCreateTavEvent;
import com.tencent.qqmini.proxyimpl.tavkitplugin.SendMsgTavEvent;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

class TavMixerEffectProxy
  extends BaseTavApiProxy
{
  @NotNull
  private List<BaseEffectNode> a(SendMsgTavEvent paramSendMsgTavEvent, String paramString)
  {
    return ObjConvector.a(paramSendMsgTavEvent.a().getJSONArray(paramString), BaseEffectNode.class);
  }
  
  private void a(TavMixerEffect paramTavMixerEffect, SendMsgTavEvent paramSendMsgTavEvent)
  {
    if (!"setTemplatePagEffect".equals(paramSendMsgTavEvent.b()))
    {
      b(paramTavMixerEffect, paramSendMsgTavEvent);
      return;
    }
    paramSendMsgTavEvent = paramSendMsgTavEvent.a("templatePagEffect");
    if ((paramSendMsgTavEvent instanceof PagMixerEffect))
    {
      paramTavMixerEffect.a((PagMixerEffect)paramSendMsgTavEvent);
      a();
      return;
    }
    b();
  }
  
  private void a(List<BaseEffectNode> paramList)
  {
    c(ObjConvector.a(paramList, new TavMixerEffectProxy.1(this)));
  }
  
  private void b(TavMixerEffect paramTavMixerEffect, SendMsgTavEvent paramSendMsgTavEvent)
  {
    if (!"getTemplatePagEffect".equals(paramSendMsgTavEvent.b()))
    {
      c(paramTavMixerEffect, paramSendMsgTavEvent);
      return;
    }
    paramTavMixerEffect = paramTavMixerEffect.a();
    if (paramTavMixerEffect != null) {
      b(paramTavMixerEffect);
    }
  }
  
  private void c(TavMixerEffect paramTavMixerEffect, SendMsgTavEvent paramSendMsgTavEvent)
  {
    if (!"setPAGEffects".equals(paramSendMsgTavEvent.b()))
    {
      d(paramTavMixerEffect, paramSendMsgTavEvent);
      return;
    }
    paramTavMixerEffect.a(a(paramSendMsgTavEvent, "pagEffects"));
    a();
  }
  
  private void d(TavMixerEffect paramTavMixerEffect, SendMsgTavEvent paramSendMsgTavEvent)
  {
    if (!"getPAGEffects".equals(paramSendMsgTavEvent.b()))
    {
      e(paramTavMixerEffect, paramSendMsgTavEvent);
      return;
    }
    a(paramTavMixerEffect.a());
  }
  
  private void e(TavMixerEffect paramTavMixerEffect, SendMsgTavEvent paramSendMsgTavEvent)
  {
    if (!"setImageEffects".equals(paramSendMsgTavEvent.b()))
    {
      f(paramTavMixerEffect, paramSendMsgTavEvent);
      return;
    }
    paramTavMixerEffect.b(a(paramSendMsgTavEvent, "imageEffects"));
    a();
  }
  
  private void f(TavMixerEffect paramTavMixerEffect, SendMsgTavEvent paramSendMsgTavEvent)
  {
    if (!"getImageEffects".equals(paramSendMsgTavEvent.b()))
    {
      c();
      return;
    }
    a(paramTavMixerEffect.b());
  }
  
  void a(ObjCreateTavEvent paramObjCreateTavEvent)
  {
    super.a(paramObjCreateTavEvent);
    a(new TavMixerEffect());
  }
  
  void a(SendMsgTavEvent paramSendMsgTavEvent)
  {
    super.a(paramSendMsgTavEvent);
    Object localObject = paramSendMsgTavEvent.a();
    if (!(localObject instanceof TavMixerEffect))
    {
      b();
      return;
    }
    a((TavMixerEffect)localObject, paramSendMsgTavEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.TavMixerEffectProxy
 * JD-Core Version:    0.7.0.1
 */