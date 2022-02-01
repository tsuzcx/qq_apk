package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

import com.tencent.qqmini.proxyimpl.tavkitplugin.ObjCreateTavEvent;
import com.tencent.qqmini.proxyimpl.tavkitplugin.SendMsgTavEvent;
import com.tencent.tavkit.composition.TAVComposition;
import org.json.JSONObject;

class TavPlayerProxy
  extends BaseTavApiProxy
{
  private void a(SendMsgTavEvent paramSendMsgTavEvent, TavPlayer paramTavPlayer)
  {
    if (!"setComposition".equals(paramSendMsgTavEvent.b()))
    {
      b(paramSendMsgTavEvent, paramTavPlayer);
      return;
    }
    paramSendMsgTavEvent = paramSendMsgTavEvent.b("composition");
    if ((paramSendMsgTavEvent instanceof TAVComposition)) {
      paramTavPlayer.a((TAVComposition)paramSendMsgTavEvent, false);
    }
    a();
  }
  
  private void b(SendMsgTavEvent paramSendMsgTavEvent)
  {
    if (!"asyncSeek".equals(paramSendMsgTavEvent.b()))
    {
      c();
      return;
    }
    c();
  }
  
  private void b(SendMsgTavEvent paramSendMsgTavEvent, TavPlayer paramTavPlayer)
  {
    if (!"attachVideoView".equals(paramSendMsgTavEvent.b()))
    {
      c(paramSendMsgTavEvent, paramTavPlayer);
      return;
    }
    paramSendMsgTavEvent = paramSendMsgTavEvent.b("videoView");
    if (!(paramSendMsgTavEvent instanceof TavVideoView))
    {
      b("videoView");
      return;
    }
    if (((TavVideoView)paramSendMsgTavEvent).a(paramTavPlayer))
    {
      a();
      return;
    }
    a("view has be attach to another player, sorry");
  }
  
  private void c(SendMsgTavEvent paramSendMsgTavEvent, TavPlayer paramTavPlayer)
  {
    if (!"play".equals(paramSendMsgTavEvent.b()))
    {
      d(paramSendMsgTavEvent, paramTavPlayer);
      return;
    }
    paramTavPlayer.d();
    a();
  }
  
  private void d(SendMsgTavEvent paramSendMsgTavEvent, TavPlayer paramTavPlayer)
  {
    if (!"pause".equals(paramSendMsgTavEvent.b()))
    {
      e(paramSendMsgTavEvent, paramTavPlayer);
      return;
    }
    paramTavPlayer.c();
    a();
  }
  
  private void e(SendMsgTavEvent paramSendMsgTavEvent, TavPlayer paramTavPlayer)
  {
    if (!"seek".equals(paramSendMsgTavEvent.b()))
    {
      b(paramSendMsgTavEvent);
      return;
    }
    paramTavPlayer.a(ObjConvector.b(paramSendMsgTavEvent.c().getJSONObject("time")));
    a();
  }
  
  void a(ObjCreateTavEvent paramObjCreateTavEvent)
  {
    super.a(paramObjCreateTavEvent);
    TavPlayer localTavPlayer = new TavPlayer();
    if ("composition".equals(paramObjCreateTavEvent.b()))
    {
      paramObjCreateTavEvent = paramObjCreateTavEvent.b("composition");
      if ((paramObjCreateTavEvent instanceof TAVComposition)) {
        localTavPlayer.a((TAVComposition)paramObjCreateTavEvent, false);
      }
    }
    localTavPlayer.a(new TavPlayerProxy.MyPlayerListener(this, localTavPlayer));
    a(localTavPlayer);
  }
  
  void a(SendMsgTavEvent paramSendMsgTavEvent)
  {
    super.a(paramSendMsgTavEvent);
    Object localObject = paramSendMsgTavEvent.d();
    if (!(localObject instanceof TavPlayer))
    {
      b();
      return;
    }
    a(paramSendMsgTavEvent, (TavPlayer)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.TavPlayerProxy
 * JD-Core Version:    0.7.0.1
 */