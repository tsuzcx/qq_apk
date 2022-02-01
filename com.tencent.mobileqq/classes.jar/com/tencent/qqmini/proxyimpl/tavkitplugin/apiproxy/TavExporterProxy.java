package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

import com.tencent.qqmini.proxyimpl.tavkitplugin.ObjCreateTavEvent;
import com.tencent.qqmini.proxyimpl.tavkitplugin.SendMsgTavEvent;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppFileManager;
import com.tencent.tavkit.composition.TAVComposition;
import org.json.JSONObject;

class TavExporterProxy
  extends BaseTavApiProxy
{
  private void a(SendMsgTavEvent paramSendMsgTavEvent, TavExporter paramTavExporter)
  {
    if (!"setVideoSize".equals(paramSendMsgTavEvent.b()))
    {
      b(paramSendMsgTavEvent, paramTavExporter);
      return;
    }
    paramTavExporter.a(ObjConvector.d(paramSendMsgTavEvent.c().getJSONObject("videoSize")));
    a();
  }
  
  private void b(SendMsgTavEvent paramSendMsgTavEvent, TavExporter paramTavExporter)
  {
    if (!"setVideoProfileLevel".equals(paramSendMsgTavEvent.b()))
    {
      c(paramSendMsgTavEvent, paramTavExporter);
      return;
    }
    a();
  }
  
  private void c(SendMsgTavEvent paramSendMsgTavEvent, TavExporter paramTavExporter)
  {
    if (!"setVideoBitRate".equals(paramSendMsgTavEvent.b()))
    {
      d(paramSendMsgTavEvent, paramTavExporter);
      return;
    }
    paramTavExporter.a(paramSendMsgTavEvent.c().getInt("videoBitRate"));
    a();
  }
  
  private void d(SendMsgTavEvent paramSendMsgTavEvent, TavExporter paramTavExporter)
  {
    if (!"setAudioBitRate".equals(paramSendMsgTavEvent.b()))
    {
      e(paramSendMsgTavEvent, paramTavExporter);
      return;
    }
    a();
  }
  
  private void e(SendMsgTavEvent paramSendMsgTavEvent, TavExporter paramTavExporter)
  {
    if (!"setAudioSampleRate".equals(paramSendMsgTavEvent.b()))
    {
      f(paramSendMsgTavEvent, paramTavExporter);
      return;
    }
    a();
  }
  
  private void f(SendMsgTavEvent paramSendMsgTavEvent, TavExporter paramTavExporter)
  {
    if (!"startExport".equals(paramSendMsgTavEvent.b()))
    {
      g(paramSendMsgTavEvent, paramTavExporter);
      return;
    }
    paramSendMsgTavEvent = this.d.getTmpPath(".mp4");
    paramTavExporter.a(new TavExporterProxy.MyExportListener(this, paramTavExporter));
    paramTavExporter.a(paramSendMsgTavEvent);
    a();
  }
  
  private void g(SendMsgTavEvent paramSendMsgTavEvent, TavExporter paramTavExporter)
  {
    if (!"cancelExport".equals(paramSendMsgTavEvent.b()))
    {
      c();
      return;
    }
    paramTavExporter.a();
    a();
  }
  
  void a(ObjCreateTavEvent paramObjCreateTavEvent)
  {
    super.a(paramObjCreateTavEvent);
    paramObjCreateTavEvent = paramObjCreateTavEvent.b("composition");
    if (!(paramObjCreateTavEvent instanceof TAVComposition))
    {
      b();
      return;
    }
    a(new TavExporter((TAVComposition)paramObjCreateTavEvent));
  }
  
  void a(SendMsgTavEvent paramSendMsgTavEvent)
  {
    super.a(paramSendMsgTavEvent);
    Object localObject = paramSendMsgTavEvent.d();
    if (!(localObject instanceof TavExporter))
    {
      localObject = this.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("get exporter obj filed, eventBean = ");
      localStringBuilder.append(paramSendMsgTavEvent);
      ((RequestEvent)localObject).fail(localStringBuilder.toString());
      return;
    }
    a(paramSendMsgTavEvent, (TavExporter)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.TavExporterProxy
 * JD-Core Version:    0.7.0.1
 */