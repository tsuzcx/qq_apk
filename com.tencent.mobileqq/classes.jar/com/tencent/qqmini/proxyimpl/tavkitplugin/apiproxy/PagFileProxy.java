package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

import android.graphics.PointF;
import android.text.TextUtils;
import com.tencent.qqmini.proxyimpl.tavkitplugin.ObjCreateTavEvent;
import com.tencent.qqmini.proxyimpl.tavkitplugin.SendMsgTavEvent;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppFileManager;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tavsticker.exception.StickerInitializationException;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerLayerInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
import org.libpag.PAGFile;

class PagFileProxy
  extends BaseTavApiProxy
{
  private void a(TAVSticker paramTAVSticker, SendMsgTavEvent paramSendMsgTavEvent)
  {
    if (!"getSourceDuration".equals(paramSendMsgTavEvent.b()))
    {
      b(paramTAVSticker, paramSendMsgTavEvent);
      return;
    }
    c(ObjConvector.a(CMTime.fromUs(paramTAVSticker.durationTime())));
  }
  
  private void b(TAVSticker paramTAVSticker, SendMsgTavEvent paramSendMsgTavEvent)
  {
    if (!"getScaleRect".equals(paramSendMsgTavEvent.b()))
    {
      c(paramTAVSticker, paramSendMsgTavEvent);
      return;
    }
    float f1 = paramTAVSticker.getCenterX();
    float f2 = paramTAVSticker.getCenterY();
    float f3 = paramTAVSticker.getScale();
    c(ObjConvector.a(new CGRect(f1, f2, f3, f3)));
  }
  
  private void c(TAVSticker paramTAVSticker, SendMsgTavEvent paramSendMsgTavEvent)
  {
    if (!"setScaleRect".equals(paramSendMsgTavEvent.b()))
    {
      d(paramTAVSticker, paramSendMsgTavEvent);
      return;
    }
    paramSendMsgTavEvent = ObjConvector.f(paramSendMsgTavEvent.c().getJSONObject("scaleRect"));
    paramTAVSticker.setCenterX(paramSendMsgTavEvent.origin.x);
    paramTAVSticker.setCenterY(paramSendMsgTavEvent.origin.y);
    paramTAVSticker.setScale(paramSendMsgTavEvent.size.width);
    a();
  }
  
  private void d(TAVSticker paramTAVSticker, SendMsgTavEvent paramSendMsgTavEvent)
  {
    if (!"getRotation".equals(paramSendMsgTavEvent.b()))
    {
      e(paramTAVSticker, paramSendMsgTavEvent);
      return;
    }
    c(Integer.valueOf((int)paramTAVSticker.getRotate()));
  }
  
  private void e(TAVSticker paramTAVSticker, SendMsgTavEvent paramSendMsgTavEvent)
  {
    if (!"setRotation".equals(paramSendMsgTavEvent.b()))
    {
      f(paramTAVSticker, paramSendMsgTavEvent);
      return;
    }
    paramTAVSticker.setRotate(paramSendMsgTavEvent.c().getInt("rotation"));
    a();
  }
  
  private void f(TAVSticker paramTAVSticker, SendMsgTavEvent paramSendMsgTavEvent)
  {
    if (!"getTimeRange".equals(paramSendMsgTavEvent.b()))
    {
      g(paramTAVSticker, paramSendMsgTavEvent);
      return;
    }
    CMTimeRange localCMTimeRange = paramTAVSticker.getTimeRange();
    paramSendMsgTavEvent = localCMTimeRange;
    if (localCMTimeRange == null)
    {
      paramSendMsgTavEvent = localCMTimeRange;
      if (paramTAVSticker.getPagFile() != null) {
        paramSendMsgTavEvent = CMTimeRange.fromUs(0L, paramTAVSticker.getPagFile().duration());
      }
    }
    c(ObjConvector.a(paramSendMsgTavEvent));
  }
  
  private void g(TAVSticker paramTAVSticker, SendMsgTavEvent paramSendMsgTavEvent)
  {
    if (!"setTimeRange".equals(paramSendMsgTavEvent.b()))
    {
      h(paramTAVSticker, paramSendMsgTavEvent);
      return;
    }
    paramTAVSticker.setTimeRange(ObjConvector.c(paramSendMsgTavEvent.c().getJSONObject("timeRange")));
    a();
  }
  
  private void h(TAVSticker paramTAVSticker, SendMsgTavEvent paramSendMsgTavEvent)
  {
    if (!"getRenderSize".equals(paramSendMsgTavEvent.b()))
    {
      i(paramTAVSticker, paramSendMsgTavEvent);
      return;
    }
    c(ObjConvector.a(new CGSize(paramTAVSticker.getWidth(), paramTAVSticker.getHeight())));
  }
  
  private void i(TAVSticker paramTAVSticker, SendMsgTavEvent paramSendMsgTavEvent)
  {
    if (!"getTextList".equals(paramSendMsgTavEvent.b()))
    {
      j(paramTAVSticker, paramSendMsgTavEvent);
      return;
    }
    c(ObjConvector.a(paramTAVSticker.getStickerTextItems(), new PagFileProxy.1(this)));
  }
  
  private void j(TAVSticker paramTAVSticker, SendMsgTavEvent paramSendMsgTavEvent)
  {
    if (!"setTextList".equals(paramSendMsgTavEvent.b()))
    {
      k(paramTAVSticker, paramSendMsgTavEvent);
      return;
    }
    paramSendMsgTavEvent = ObjConvector.a(paramSendMsgTavEvent.c().getJSONArray("textList"), new PagFileProxy.2(this, paramTAVSticker));
    paramTAVSticker.getStickerTextItems().clear();
    paramTAVSticker.getStickerTextItems().addAll(paramSendMsgTavEvent);
    a();
  }
  
  private void k(TAVSticker paramTAVSticker, SendMsgTavEvent paramSendMsgTavEvent)
  {
    if (!"getImageList".equals(paramSendMsgTavEvent.b()))
    {
      l(paramTAVSticker, paramSendMsgTavEvent);
      return;
    }
    c(ObjConvector.a(paramTAVSticker.getStickerImageItems(), new PagFileProxy.3(this)));
  }
  
  private void l(TAVSticker paramTAVSticker, SendMsgTavEvent paramSendMsgTavEvent)
  {
    if (!"getAudioList".equals(paramSendMsgTavEvent.b()))
    {
      m(paramTAVSticker, paramSendMsgTavEvent);
      return;
    }
    paramSendMsgTavEvent = new ArrayList();
    paramSendMsgTavEvent.add(PagAudioItem.a(paramTAVSticker, this.d));
    c(ObjConvector.a(paramSendMsgTavEvent, new PagFileProxy.4(this)));
  }
  
  private void m(TAVSticker paramTAVSticker, SendMsgTavEvent paramSendMsgTavEvent)
  {
    if (!"setImageList".equals(paramSendMsgTavEvent.b()))
    {
      n(paramTAVSticker, paramSendMsgTavEvent);
      return;
    }
    paramSendMsgTavEvent = ObjConvector.a(paramSendMsgTavEvent.c().getJSONArray("imageList"), new PagFileProxy.5(this, paramTAVSticker));
    paramTAVSticker.getStickerImageItems().clear();
    paramTAVSticker.getStickerImageItems().addAll(paramSendMsgTavEvent);
    a();
  }
  
  private void n(TAVSticker paramTAVSticker, SendMsgTavEvent paramSendMsgTavEvent)
  {
    if (!"getInfoList".equals(paramSendMsgTavEvent.b()))
    {
      c();
      return;
    }
    Object localObject = paramTAVSticker.getStickerLayerInfos();
    paramSendMsgTavEvent = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramSendMsgTavEvent.add(new TavStickerLayerInfoWrapper((TAVStickerLayerInfo)((Iterator)localObject).next(), paramTAVSticker));
    }
    c(ObjConvector.a(paramSendMsgTavEvent, new PagFileProxy.6(this)));
  }
  
  void a(ObjCreateTavEvent paramObjCreateTavEvent)
  {
    super.a(paramObjCreateTavEvent);
    paramObjCreateTavEvent = paramObjCreateTavEvent.c().getString("filePath");
    if (TextUtils.isEmpty(paramObjCreateTavEvent))
    {
      a("error params filePath");
      return;
    }
    paramObjCreateTavEvent = this.d.getAbsolutePath(paramObjCreateTavEvent);
    Object localObject = new TAVSticker();
    try
    {
      ((TAVSticker)localObject).setFilePath(paramObjCreateTavEvent).setCenterX(0.5F).setCenterY(0.5F).setScale(1.0F).init();
      a(localObject);
      return;
    }
    catch (StickerInitializationException paramObjCreateTavEvent)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("StickerInitializationException:");
      ((StringBuilder)localObject).append(paramObjCreateTavEvent);
      a(((StringBuilder)localObject).toString());
    }
  }
  
  void a(SendMsgTavEvent paramSendMsgTavEvent)
  {
    super.a(paramSendMsgTavEvent);
    Object localObject = paramSendMsgTavEvent.d();
    if (!(localObject instanceof TAVSticker)) {
      return;
    }
    a((TAVSticker)localObject, paramSendMsgTavEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.PagFileProxy
 * JD-Core Version:    0.7.0.1
 */