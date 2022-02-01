package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import com.tencent.qqmini.proxyimpl.tavkitplugin.ObjCreateTavEvent;
import com.tencent.qqmini.proxyimpl.tavkitplugin.SendMsgTavEvent;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
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
      Logger.e(this.jdField_a_of_type_JavaLangString, "tryOnCoverGenerated: ", paramBitmap);
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
    paramTavImageGenerator.a(ObjConvector.a(paramSendMsgTavEvent.a().getJSONObject("time")), new TavImageGeneratorProxy.1(this, paramSendMsgTavEvent));
  }
  
  private void b(@Nullable Bitmap paramBitmap, SendMsgTavEvent paramSendMsgTavEvent)
  {
    if (paramBitmap == null) {
      a("generate cover filed");
    }
    String str;
    do
    {
      return;
      str = paramSendMsgTavEvent.a().getString("type");
      if ("object".equals(str))
      {
        b(paramBitmap);
        return;
      }
    } while (!"filePath".equals(str));
    c(paramBitmap, paramSendMsgTavEvent);
  }
  
  private void c(Bitmap paramBitmap, SendMsgTavEvent paramSendMsgTavEvent)
  {
    paramSendMsgTavEvent = this.jdField_a_of_type_ComTencentQqminiSdkCoreManagerMiniAppFileManager.getTmpPath(".png");
    TAVGLUtils.saveBitmapToFile(paramBitmap, new File(paramSendMsgTavEvent));
    c(this.jdField_a_of_type_ComTencentQqminiSdkCoreManagerMiniAppFileManager.getWxFilePath(paramSendMsgTavEvent));
  }
  
  void a(ObjCreateTavEvent paramObjCreateTavEvent)
  {
    super.a(paramObjCreateTavEvent);
    Object localObject = paramObjCreateTavEvent.a("composition");
    if (!(localObject instanceof TAVComposition))
    {
      a("no params: composition");
      return;
    }
    CGSize localCGSize = null;
    if (paramObjCreateTavEvent.a().has("maxSize")) {
      localCGSize = ObjConvector.a(paramObjCreateTavEvent.a().getJSONObject("maxSize"));
    }
    a(new TavImageGenerator((TAVComposition)localObject, localCGSize));
  }
  
  void a(SendMsgTavEvent paramSendMsgTavEvent)
  {
    super.a(paramSendMsgTavEvent);
    Object localObject = paramSendMsgTavEvent.a();
    if (!(localObject instanceof TavImageGenerator))
    {
      b();
      return;
    }
    a((TavImageGenerator)localObject, paramSendMsgTavEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.TavImageGeneratorProxy
 * JD-Core Version:    0.7.0.1
 */