package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

import com.tencent.qqmini.proxyimpl.tavkitplugin.ObjCreateTavEvent;
import com.tencent.qqmini.proxyimpl.tavkitplugin.SendMsgTavEvent;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.model.TAVAudioConfiguration;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration;
import com.tencent.tavkit.composition.resource.TAVResource;
import org.json.JSONObject;

class TavClipProxy
  extends BaseTavApiProxy
{
  private void a(SendMsgTavEvent paramSendMsgTavEvent, TAVClip paramTAVClip)
  {
    if (!"getResource".equals(paramSendMsgTavEvent.b()))
    {
      b(paramSendMsgTavEvent, paramTAVClip);
      return;
    }
    b(paramTAVClip.getResource());
  }
  
  private void b(SendMsgTavEvent paramSendMsgTavEvent, TAVClip paramTAVClip)
  {
    if (!"getVideoConfiguration".equals(paramSendMsgTavEvent.b()))
    {
      c(paramSendMsgTavEvent, paramTAVClip);
      return;
    }
    b(paramTAVClip.getVideoConfiguration());
  }
  
  private void c(SendMsgTavEvent paramSendMsgTavEvent, TAVClip paramTAVClip)
  {
    if (!"getAudioConfiguration".equals(paramSendMsgTavEvent.b()))
    {
      d(paramSendMsgTavEvent, paramTAVClip);
      return;
    }
    b(paramTAVClip.getAudioConfiguration());
  }
  
  private void d(SendMsgTavEvent paramSendMsgTavEvent, TAVClip paramTAVClip)
  {
    if (!"getStartTime".equals(paramSendMsgTavEvent.b()))
    {
      e(paramSendMsgTavEvent, paramTAVClip);
      return;
    }
    c(ObjConvector.a(paramTAVClip.getStartTime()));
  }
  
  private void e(SendMsgTavEvent paramSendMsgTavEvent, TAVClip paramTAVClip)
  {
    if (!"setVideoConfiguration".equals(paramSendMsgTavEvent.b()))
    {
      f(paramSendMsgTavEvent, paramTAVClip);
      return;
    }
    paramSendMsgTavEvent = paramSendMsgTavEvent.a("videoConfiguration");
    if ((paramSendMsgTavEvent instanceof TAVVideoConfiguration))
    {
      paramTAVClip.setVideoConfiguration((TAVVideoConfiguration)paramSendMsgTavEvent);
      a();
      return;
    }
    b();
  }
  
  private void f(SendMsgTavEvent paramSendMsgTavEvent, TAVClip paramTAVClip)
  {
    if (!"setAudioConfiguration".equals(paramSendMsgTavEvent.b()))
    {
      g(paramSendMsgTavEvent, paramTAVClip);
      return;
    }
    paramSendMsgTavEvent = paramSendMsgTavEvent.a("audioConfiguration");
    if ((paramSendMsgTavEvent instanceof TAVAudioConfiguration))
    {
      paramTAVClip.setAudioConfiguration((TAVAudioConfiguration)paramSendMsgTavEvent);
      a();
      return;
    }
    b();
  }
  
  private void g(SendMsgTavEvent paramSendMsgTavEvent, TAVClip paramTAVClip)
  {
    if (!"setStartTime".equals(paramSendMsgTavEvent.b()))
    {
      h(paramSendMsgTavEvent, paramTAVClip);
      return;
    }
    paramTAVClip.setStartTime(ObjConvector.a(paramSendMsgTavEvent.a().getJSONObject("startTime")));
    a();
  }
  
  private void h(SendMsgTavEvent paramSendMsgTavEvent, TAVClip paramTAVClip)
  {
    if (!"setLayerIndex".equals(paramSendMsgTavEvent.b()))
    {
      c();
      return;
    }
    paramTAVClip.putExtraTrackInfo("layerIndex", Integer.valueOf(paramSendMsgTavEvent.a().getInt("layerIndex")));
    a();
  }
  
  void a(ObjCreateTavEvent paramObjCreateTavEvent)
  {
    super.a(paramObjCreateTavEvent);
    paramObjCreateTavEvent = paramObjCreateTavEvent.a("resource");
    if (!(paramObjCreateTavEvent instanceof TAVResource))
    {
      a("error params resource");
      return;
    }
    a(new TAVClip((TAVResource)paramObjCreateTavEvent));
  }
  
  void a(SendMsgTavEvent paramSendMsgTavEvent)
  {
    super.a(paramSendMsgTavEvent);
    Object localObject = paramSendMsgTavEvent.a();
    if (!(localObject instanceof TAVClip))
    {
      b();
      return;
    }
    a(paramSendMsgTavEvent, (TAVClip)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.TavClipProxy
 * JD-Core Version:    0.7.0.1
 */