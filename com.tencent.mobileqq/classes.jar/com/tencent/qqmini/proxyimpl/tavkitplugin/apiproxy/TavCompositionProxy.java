package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

import android.util.Log;
import com.tencent.qqmini.proxyimpl.tavkitplugin.ObjCreateTavEvent;
import com.tencent.qqmini.proxyimpl.tavkitplugin.SendMsgTavEvent;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.tav.core.composition.VideoComposition.RenderLayoutMode;
import com.tencent.tavkit.composition.TAVClip;
import com.tencent.tavkit.composition.TAVComposition;
import com.tencent.tavkit.composition.model.TAVAudio;
import com.tencent.tavkit.composition.model.TAVTransitionableAudio;
import com.tencent.tavkit.composition.model.TAVTransitionableVideo;
import com.tencent.tavkit.composition.model.TAVVideo;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

class TavCompositionProxy
  extends BaseTavApiProxy
{
  private List<? extends TAVClip> a(List<? extends TAVAudio> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add((TAVClip)paramList.next());
    }
    return localArrayList;
  }
  
  private void a(SendMsgTavEvent paramSendMsgTavEvent, TAVComposition paramTAVComposition)
  {
    if (!"getRenderSize".equals(paramSendMsgTavEvent.b()))
    {
      b(paramSendMsgTavEvent, paramTAVComposition);
      return;
    }
    c(ObjConvector.a(paramTAVComposition.getRenderSize()));
  }
  
  private void a(List<? extends TAVClip> paramList)
  {
    c(ObjConvector.b(paramList));
  }
  
  private List<? extends TAVClip> b(List<? extends TAVVideo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add((TAVClip)paramList.next());
    }
    return localArrayList;
  }
  
  private void b(SendMsgTavEvent paramSendMsgTavEvent, TAVComposition paramTAVComposition)
  {
    if (!"getVideoChannels".equals(paramSendMsgTavEvent.b()))
    {
      c(paramSendMsgTavEvent, paramTAVComposition);
      return;
    }
    b(d(paramTAVComposition.getVideoChannels()));
  }
  
  private void b(List<List<? extends TAVClip>> paramList)
  {
    c(ObjConvector.a(paramList));
  }
  
  private List<List<? extends TAVClip>> c(List<List<? extends TAVTransitionableAudio>> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(a((List)paramList.next()));
    }
    return localArrayList;
  }
  
  private void c(SendMsgTavEvent paramSendMsgTavEvent, TAVComposition paramTAVComposition)
  {
    if (!"getAudioChannels".equals(paramSendMsgTavEvent.b()))
    {
      d(paramSendMsgTavEvent, paramTAVComposition);
      return;
    }
    b(c(paramTAVComposition.getAudioChannels()));
  }
  
  private List<List<? extends TAVClip>> d(List<List<? extends TAVTransitionableVideo>> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(b((List)paramList.next()));
    }
    return localArrayList;
  }
  
  private void d(SendMsgTavEvent paramSendMsgTavEvent, TAVComposition paramTAVComposition)
  {
    if (!"getVideos".equals(paramSendMsgTavEvent.b()))
    {
      e(paramSendMsgTavEvent, paramTAVComposition);
      return;
    }
    a(b(paramTAVComposition.getOverlays()));
  }
  
  private void e(SendMsgTavEvent paramSendMsgTavEvent, TAVComposition paramTAVComposition)
  {
    if (!"getAudios".equals(paramSendMsgTavEvent.b()))
    {
      f(paramSendMsgTavEvent, paramTAVComposition);
      return;
    }
    a(a(paramTAVComposition.getAudios()));
  }
  
  private void f(SendMsgTavEvent paramSendMsgTavEvent, TAVComposition paramTAVComposition)
  {
    if (!"getMixerEffect".equals(paramSendMsgTavEvent.b()))
    {
      g(paramSendMsgTavEvent, paramTAVComposition);
      return;
    }
    b(paramTAVComposition.getVideoMixEffect());
  }
  
  private void g(SendMsgTavEvent paramSendMsgTavEvent, TAVComposition paramTAVComposition)
  {
    if (!"getEffect".equals(paramSendMsgTavEvent.b()))
    {
      h(paramSendMsgTavEvent, paramTAVComposition);
      return;
    }
    b(paramTAVComposition.getGlobalVideoEffect());
  }
  
  private void h(SendMsgTavEvent paramSendMsgTavEvent, TAVComposition paramTAVComposition)
  {
    if (!"setRenderSize".equals(paramSendMsgTavEvent.b()))
    {
      i(paramSendMsgTavEvent, paramTAVComposition);
      return;
    }
    paramTAVComposition.setRenderSize(ObjConvector.a(paramSendMsgTavEvent.a().getJSONObject("renderSize")));
    a();
  }
  
  private void i(SendMsgTavEvent paramSendMsgTavEvent, TAVComposition paramTAVComposition)
  {
    if (!"setVideoChannels".equals(paramSendMsgTavEvent.b()))
    {
      j(paramSendMsgTavEvent, paramTAVComposition);
      return;
    }
    paramTAVComposition.setVideoChannels(new ArrayList(ObjConvector.a(paramSendMsgTavEvent.a().getJSONArray("videoChannels"))));
    a();
  }
  
  private void j(SendMsgTavEvent paramSendMsgTavEvent, TAVComposition paramTAVComposition)
  {
    if (!"setAudioChannels".equals(paramSendMsgTavEvent.b()))
    {
      k(paramSendMsgTavEvent, paramTAVComposition);
      return;
    }
    paramTAVComposition.setAudioChannels(new ArrayList(ObjConvector.a(paramSendMsgTavEvent.a().getJSONArray("audioChannels"))));
    a();
  }
  
  private void k(SendMsgTavEvent paramSendMsgTavEvent, TAVComposition paramTAVComposition)
  {
    if (!"setVideos".equals(paramSendMsgTavEvent.b()))
    {
      l(paramSendMsgTavEvent, paramTAVComposition);
      return;
    }
    paramTAVComposition.setOverlays(ObjConvector.b(paramSendMsgTavEvent.a().getJSONArray("videos")));
    a();
  }
  
  private void l(SendMsgTavEvent paramSendMsgTavEvent, TAVComposition paramTAVComposition)
  {
    if (!"setAudios".equals(paramSendMsgTavEvent.b()))
    {
      m(paramSendMsgTavEvent, paramTAVComposition);
      return;
    }
    paramTAVComposition.setAudios(ObjConvector.b(paramSendMsgTavEvent.a().getJSONArray("audios")));
    a();
  }
  
  private void m(SendMsgTavEvent paramSendMsgTavEvent, TAVComposition paramTAVComposition)
  {
    if (!"setEffect".equals(paramSendMsgTavEvent.b()))
    {
      n(paramSendMsgTavEvent, paramTAVComposition);
      return;
    }
    paramSendMsgTavEvent = paramSendMsgTavEvent.a("effect");
    if ((paramSendMsgTavEvent instanceof TAVVideoEffect))
    {
      paramTAVComposition.setGlobalVideoEffect((TAVVideoEffect)paramSendMsgTavEvent);
      a();
      return;
    }
    b();
  }
  
  private void n(SendMsgTavEvent paramSendMsgTavEvent, TAVComposition paramTAVComposition)
  {
    if (!"setMixerEffect".equals(paramSendMsgTavEvent.b()))
    {
      c();
      return;
    }
    paramSendMsgTavEvent = paramSendMsgTavEvent.a("mixerEffect");
    if ((paramSendMsgTavEvent instanceof TAVVideoMixEffect))
    {
      paramTAVComposition.setVideoMixEffect((TAVVideoMixEffect)paramSendMsgTavEvent);
      a();
      return;
    }
    b();
  }
  
  void a(ObjCreateTavEvent paramObjCreateTavEvent)
  {
    super.a(paramObjCreateTavEvent);
    paramObjCreateTavEvent = new TAVComposition();
    paramObjCreateTavEvent.setRenderLayoutMode(VideoComposition.RenderLayoutMode.aspectFit);
    a(paramObjCreateTavEvent);
  }
  
  void a(SendMsgTavEvent paramSendMsgTavEvent)
  {
    super.a(paramSendMsgTavEvent);
    Object localObject = paramSendMsgTavEvent.a();
    if (!(localObject instanceof TAVComposition))
    {
      Log.e(this.jdField_a_of_type_JavaLangString, "sendMsgInvoke: " + "object error");
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent.fail("object error");
      return;
    }
    a(paramSendMsgTavEvent, (TAVComposition)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.TavCompositionProxy
 * JD-Core Version:    0.7.0.1
 */