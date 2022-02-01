package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

import com.tencent.qqmini.proxyimpl.tavkitplugin.ObjCreateTavEvent;
import com.tencent.qqmini.proxyimpl.tavkitplugin.SendMsgTavEvent;
import com.tencent.tavkit.composition.audio.TAVAudioProcessorNode;
import com.tencent.tavkit.composition.model.TAVAudioConfiguration;
import java.util.List;
import org.json.JSONObject;

class TavAudioConfigurationProxy
  extends BaseTavApiProxy
{
  private void a(SendMsgTavEvent paramSendMsgTavEvent, TAVAudioConfiguration paramTAVAudioConfiguration)
  {
    if (!"getVolume".equals(paramSendMsgTavEvent.b()))
    {
      b(paramSendMsgTavEvent, paramTAVAudioConfiguration);
      return;
    }
    c(Float.valueOf(paramTAVAudioConfiguration.getVolume()));
  }
  
  private void b(SendMsgTavEvent paramSendMsgTavEvent, TAVAudioConfiguration paramTAVAudioConfiguration)
  {
    if (!"getEffect".equals(paramSendMsgTavEvent.b()))
    {
      c(paramSendMsgTavEvent, paramTAVAudioConfiguration);
      return;
    }
    b((TAVAudioProcessorNode)paramTAVAudioConfiguration.getNodes().get(0));
  }
  
  private void c(SendMsgTavEvent paramSendMsgTavEvent, TAVAudioConfiguration paramTAVAudioConfiguration)
  {
    if (!"setVolume".equals(paramSendMsgTavEvent.b()))
    {
      d(paramSendMsgTavEvent, paramTAVAudioConfiguration);
      return;
    }
    paramTAVAudioConfiguration.setVolume((float)paramSendMsgTavEvent.a().getDouble("volume"));
    a();
  }
  
  private void d(SendMsgTavEvent paramSendMsgTavEvent, TAVAudioConfiguration paramTAVAudioConfiguration)
  {
    if (!"setEffect".equals(paramSendMsgTavEvent.b()))
    {
      c();
      return;
    }
    paramSendMsgTavEvent = paramSendMsgTavEvent.a("effect");
    if ((paramSendMsgTavEvent instanceof TAVAudioProcessorNode))
    {
      paramTAVAudioConfiguration.addAudioProcessorNode((TAVAudioProcessorNode)paramSendMsgTavEvent);
      a();
      return;
    }
    b();
  }
  
  void a(ObjCreateTavEvent paramObjCreateTavEvent)
  {
    super.a(paramObjCreateTavEvent);
    a(new TAVAudioConfiguration());
  }
  
  void a(SendMsgTavEvent paramSendMsgTavEvent)
  {
    super.a(paramSendMsgTavEvent);
    Object localObject = paramSendMsgTavEvent.a();
    if (!(localObject instanceof TAVAudioConfiguration))
    {
      b();
      return;
    }
    a(paramSendMsgTavEvent, (TAVAudioConfiguration)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.TavAudioConfigurationProxy
 * JD-Core Version:    0.7.0.1
 */