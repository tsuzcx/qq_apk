package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import com.tencent.qqmini.proxyimpl.tavkitplugin.ObjCreateTavEvent;
import com.tencent.qqmini.proxyimpl.tavkitplugin.SendMsgTavEvent;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppFileManager;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tavkit.ciimage.TAVGLUtils;
import com.tencent.tavkit.composition.TAVComposition;
import java.io.File;
import org.json.JSONObject;

class TavImageGeneratorProxy
  extends BaseTavApiProxy
{
  private void a(Bitmap paramBitmap, SendMsgTavEvent paramSendMsgTavEvent)
  {
    try
    {
      b(paramBitmap, paramSendMsgTavEvent);
      return;
    }
    catch (Exception paramBitmap)
    {
      Logger.e(this.a, "tryOnCoverGenerated: ", paramBitmap);
      b();
    }
  }
  
  private void a(TavImageGenerator paramTavImageGenerator, SendMsgTavEvent paramSendMsgTavEvent)
  {
    if (!"generateImage".equals(paramSendMsgTavEvent.b()))
    {
      c();
      return;
    }
    paramTavImageGenerator.a(ObjConvector.b(paramSendMsgTavEvent.c().getJSONObject("time")), new TavImageGeneratorProxy.1(this, paramSendMsgTavEvent));
  }
  
  private void b(@Nullable Bitmap paramBitmap, SendMsgTavEvent paramSendMsgTavEvent)
  {
    if (paramBitmap == null)
    {
      a("generate cover filed");
      return;
    }
    String str = paramSendMsgTavEvent.c().getString("type");
    if ("object".equals(str))
    {
      b(paramBitmap);
      return;
    }
    if ("filePath".equals(str)) {
      c(paramBitmap, paramSendMsgTavEvent);
    }
  }
  
  private void c(Bitmap paramBitmap, SendMsgTavEvent paramSendMsgTavEvent)
  {
    paramSendMsgTavEvent = this.d.getTmpPath(".png");
    TAVGLUtils.saveBitmapToFile(paramBitmap, new File(paramSendMsgTavEvent));
    paramBitmap.recycle();
    c(this.d.getWxFilePath(paramSendMsgTavEvent));
  }
  
  void a(ObjCreateTavEvent paramObjCreateTavEvent)
  {
    super.a(paramObjCreateTavEvent);
    Object localObject = paramObjCreateTavEvent.b("composition");
    if (!(localObject instanceof TAVComposition))
    {
      a("no params: composition");
      return;
    }
    CGSize localCGSize = null;
    if (paramObjCreateTavEvent.c().has("maxSize")) {
      localCGSize = ObjConvector.d(paramObjCreateTavEvent.c().getJSONObject("maxSize"));
    }
    a(new TavImageGenerator((TAVComposition)localObject, localCGSize));
  }
  
  void a(SendMsgTavEvent paramSendMsgTavEvent)
  {
    super.a(paramSendMsgTavEvent);
    Object localObject = paramSendMsgTavEvent.d();
    if (!(localObject instanceof TavImageGenerator))
    {
      b();
      return;
    }
    a((TavImageGenerator)localObject, paramSendMsgTavEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.TavImageGeneratorProxy
 * JD-Core Version:    0.7.0.1
 */