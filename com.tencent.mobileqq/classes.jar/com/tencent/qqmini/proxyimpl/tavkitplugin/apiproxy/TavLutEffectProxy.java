package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

import com.tencent.qqmini.proxyimpl.tavkitplugin.ObjCreateTavEvent;
import com.tencent.qqmini.proxyimpl.tavkitplugin.SendMsgTavEvent;
import org.json.JSONObject;

class TavLutEffectProxy
  extends BaseTavApiProxy
{
  private void a(TavLutEffect paramTavLutEffect, SendMsgTavEvent paramSendMsgTavEvent)
  {
    if (!"getTimeRange".equals(paramSendMsgTavEvent.b()))
    {
      b(paramTavLutEffect, paramSendMsgTavEvent);
      return;
    }
    c(ObjConvector.a(paramTavLutEffect.c()));
  }
  
  private void b(TavLutEffect paramTavLutEffect, SendMsgTavEvent paramSendMsgTavEvent)
  {
    if (!"setTimeRange".equals(paramSendMsgTavEvent.b()))
    {
      c(paramTavLutEffect, paramSendMsgTavEvent);
      return;
    }
    paramTavLutEffect.a(ObjConvector.c(paramSendMsgTavEvent.c().getJSONObject("timeRange")));
    a();
  }
  
  private void c(TavLutEffect paramTavLutEffect, SendMsgTavEvent paramSendMsgTavEvent)
  {
    if (!"getLutPath".equals(paramSendMsgTavEvent.b()))
    {
      d(paramTavLutEffect, paramSendMsgTavEvent);
      return;
    }
    c(paramTavLutEffect.b());
  }
  
  private void d(TavLutEffect paramTavLutEffect, SendMsgTavEvent paramSendMsgTavEvent)
  {
    if (!"setLutPath".equals(paramSendMsgTavEvent.b()))
    {
      e(paramTavLutEffect, paramSendMsgTavEvent);
      return;
    }
    paramTavLutEffect.a(paramSendMsgTavEvent.c().getString("lutPath"));
    a();
  }
  
  private void e(TavLutEffect paramTavLutEffect, SendMsgTavEvent paramSendMsgTavEvent)
  {
    if (!"getIntensity".equals(paramSendMsgTavEvent.b()))
    {
      f(paramTavLutEffect, paramSendMsgTavEvent);
      return;
    }
    c(Float.valueOf(paramTavLutEffect.d()));
    a();
  }
  
  private void f(TavLutEffect paramTavLutEffect, SendMsgTavEvent paramSendMsgTavEvent)
  {
    if (!"setIntensity".equals(paramSendMsgTavEvent.b()))
    {
      c();
      return;
    }
    paramTavLutEffect.a((float)paramSendMsgTavEvent.c().getDouble("intensity"));
    a();
  }
  
  void a(ObjCreateTavEvent paramObjCreateTavEvent)
  {
    super.a(paramObjCreateTavEvent);
    a(new TavLutEffect());
  }
  
  void a(SendMsgTavEvent paramSendMsgTavEvent)
  {
    super.a(paramSendMsgTavEvent);
    Object localObject = paramSendMsgTavEvent.d();
    if (!(localObject instanceof TavLutEffect))
    {
      b("tavobject");
      return;
    }
    a((TavLutEffect)localObject, paramSendMsgTavEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.TavLutEffectProxy
 * JD-Core Version:    0.7.0.1
 */