package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

import com.tencent.qqmini.proxyimpl.tavkitplugin.ObjCreateTavEvent;
import com.tencent.qqmini.proxyimpl.tavkitplugin.SendMsgTavEvent;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration.TAVVideoConfigurationContentMode;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import java.util.List;
import org.json.JSONObject;

class TavVideoConfigurationProxy
  extends BaseTavApiProxy
{
  private void a(SendMsgTavEvent paramSendMsgTavEvent, TAVVideoConfiguration paramTAVVideoConfiguration)
  {
    if (!"getContentMode".equals(paramSendMsgTavEvent.b()))
    {
      b(paramSendMsgTavEvent, paramTAVVideoConfiguration);
      return;
    }
    c(paramTAVVideoConfiguration.getContentMode().name());
  }
  
  private void b(SendMsgTavEvent paramSendMsgTavEvent, TAVVideoConfiguration paramTAVVideoConfiguration)
  {
    if (!"getFrame".equals(paramSendMsgTavEvent.b()))
    {
      c(paramSendMsgTavEvent, paramTAVVideoConfiguration);
      return;
    }
    c(ObjConvector.a(paramTAVVideoConfiguration.getFrame()));
  }
  
  private void c(SendMsgTavEvent paramSendMsgTavEvent, TAVVideoConfiguration paramTAVVideoConfiguration)
  {
    if (!"getMatrix".equals(paramSendMsgTavEvent.b()))
    {
      d(paramSendMsgTavEvent, paramTAVVideoConfiguration);
      return;
    }
    c(ObjConvector.a(paramTAVVideoConfiguration.getTransform()));
  }
  
  private void d(SendMsgTavEvent paramSendMsgTavEvent, TAVVideoConfiguration paramTAVVideoConfiguration)
  {
    if (!"getEffect".equals(paramSendMsgTavEvent.b()))
    {
      e(paramSendMsgTavEvent, paramTAVVideoConfiguration);
      return;
    }
    if (paramTAVVideoConfiguration.getEffects().isEmpty())
    {
      c("no effect");
      return;
    }
    b((TAVVideoEffect)paramTAVVideoConfiguration.getEffects().get(0));
  }
  
  private void e(SendMsgTavEvent paramSendMsgTavEvent, TAVVideoConfiguration paramTAVVideoConfiguration)
  {
    if (!"setContentMode".equals(paramSendMsgTavEvent.b()))
    {
      f(paramSendMsgTavEvent, paramTAVVideoConfiguration);
      return;
    }
    paramTAVVideoConfiguration.setContentMode(TAVVideoConfiguration.TAVVideoConfigurationContentMode.valueOf(paramSendMsgTavEvent.a().getString("contentMode")));
    a();
  }
  
  private void f(SendMsgTavEvent paramSendMsgTavEvent, TAVVideoConfiguration paramTAVVideoConfiguration)
  {
    if (!"setFrame".equals(paramSendMsgTavEvent.b()))
    {
      g(paramSendMsgTavEvent, paramTAVVideoConfiguration);
      return;
    }
    paramTAVVideoConfiguration.setFrame(ObjConvector.a(paramSendMsgTavEvent.a().getJSONObject("frame")));
    a();
  }
  
  private void g(SendMsgTavEvent paramSendMsgTavEvent, TAVVideoConfiguration paramTAVVideoConfiguration)
  {
    if (!"setMatrix".equals(paramSendMsgTavEvent.b()))
    {
      h(paramSendMsgTavEvent, paramTAVVideoConfiguration);
      return;
    }
    paramTAVVideoConfiguration.setTransform(ObjConvector.a(paramSendMsgTavEvent.a().getJSONArray("matrix")));
    a();
  }
  
  private void h(SendMsgTavEvent paramSendMsgTavEvent, TAVVideoConfiguration paramTAVVideoConfiguration)
  {
    if (!"setEffect".equals(paramSendMsgTavEvent.b()))
    {
      c();
      return;
    }
    paramSendMsgTavEvent = paramSendMsgTavEvent.a("effect");
    if ((paramSendMsgTavEvent instanceof TAVVideoEffect))
    {
      paramTAVVideoConfiguration.addEffect((TAVVideoEffect)paramSendMsgTavEvent);
      a();
      return;
    }
    b();
  }
  
  void a(ObjCreateTavEvent paramObjCreateTavEvent)
  {
    super.a(paramObjCreateTavEvent);
    a(new TAVVideoConfiguration());
  }
  
  void a(SendMsgTavEvent paramSendMsgTavEvent)
  {
    super.a(paramSendMsgTavEvent);
    Object localObject = paramSendMsgTavEvent.a();
    if (!(localObject instanceof TAVVideoConfiguration))
    {
      b();
      return;
    }
    a(paramSendMsgTavEvent, (TAVVideoConfiguration)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.TavVideoConfigurationProxy
 * JD-Core Version:    0.7.0.1
 */