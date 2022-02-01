package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.qqmini.proxyimpl.tavkitplugin.ObjCreateTavEvent;
import com.tencent.qqmini.proxyimpl.tavkitplugin.SendMsgTavEvent;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tavkit.composition.resource.TAVAssetTrackResource;
import com.tencent.tavkit.composition.resource.TAVEmptyResource;
import com.tencent.tavkit.composition.resource.TAVImageTrackResource;
import com.tencent.tavkit.composition.resource.TAVResource;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

class TavResourceProxy
  extends BaseTavApiProxy
{
  @Nullable
  private CMTime a(JSONObject paramJSONObject)
  {
    if (!paramJSONObject.has("duration"))
    {
      b("duration");
      return null;
    }
    return ObjConvector.a(paramJSONObject.getJSONObject("duration"));
  }
  
  private void a(ObjCreateTavEvent paramObjCreateTavEvent, JSONObject paramJSONObject)
  {
    if (!"emptyVideo".equals(paramObjCreateTavEvent.b()))
    {
      b(paramObjCreateTavEvent, paramJSONObject);
      return;
    }
    a(new TAVEmptyResource(a(paramJSONObject), false));
  }
  
  private void a(SendMsgTavEvent paramSendMsgTavEvent, TAVResource paramTAVResource)
  {
    if (!"getFilePath".equals(paramSendMsgTavEvent.b()))
    {
      b(paramSendMsgTavEvent, paramTAVResource);
      return;
    }
    if ((paramTAVResource instanceof TAVAssetTrackResource))
    {
      c(((TAVAssetTrackResource)paramTAVResource).getAsset().getSourcePath());
      return;
    }
    if ((paramTAVResource instanceof TAVImageTrackResource))
    {
      c(((TAVImageTrackResource)paramTAVResource).getPath());
      return;
    }
    a("no filePath");
  }
  
  private void b(ObjCreateTavEvent paramObjCreateTavEvent, JSONObject paramJSONObject)
  {
    if (!"video".equals(paramObjCreateTavEvent.b()))
    {
      c(paramObjCreateTavEvent, paramJSONObject);
      return;
    }
    try
    {
      paramObjCreateTavEvent = new TAVAssetTrackResource(this.jdField_a_of_type_ComTencentQqminiSdkCoreManagerMiniAppFileManager.getAbsolutePath(paramJSONObject.getString("filePath")));
      a(paramObjCreateTavEvent);
      return;
    }
    catch (Exception paramObjCreateTavEvent)
    {
      Logger.e(this.jdField_a_of_type_JavaLangString, "matchNewVideo: ", paramObjCreateTavEvent);
      a(String.valueOf(paramObjCreateTavEvent));
    }
  }
  
  private void b(SendMsgTavEvent paramSendMsgTavEvent, TAVResource paramTAVResource)
  {
    if (!"getDuration".equals(paramSendMsgTavEvent.b()))
    {
      c(paramSendMsgTavEvent, paramTAVResource);
      return;
    }
    c(ObjConvector.a(paramTAVResource.getDuration()));
  }
  
  private void c(ObjCreateTavEvent paramObjCreateTavEvent, JSONObject paramJSONObject)
  {
    if (!"image".equals(paramObjCreateTavEvent.b()))
    {
      c();
      return;
    }
    a(new TAVImageTrackResource(this.jdField_a_of_type_ComTencentQqminiSdkCoreManagerMiniAppFileManager.getAbsolutePath(paramJSONObject.getString("filePath")), a(paramJSONObject)));
  }
  
  private void c(SendMsgTavEvent paramSendMsgTavEvent, TAVResource paramTAVResource)
  {
    if (!"getSourceTimeRange".equals(paramSendMsgTavEvent.b()))
    {
      d(paramSendMsgTavEvent, paramTAVResource);
      return;
    }
    c(ObjConvector.a(paramTAVResource.getSourceTimeRange()));
  }
  
  private void c(String paramString)
  {
    c(this.jdField_a_of_type_ComTencentQqminiSdkCoreManagerMiniAppFileManager.getWxFilePath(paramString));
  }
  
  private void d(SendMsgTavEvent paramSendMsgTavEvent, TAVResource paramTAVResource)
  {
    if (!"getScaledDuration".equals(paramSendMsgTavEvent.b()))
    {
      e(paramSendMsgTavEvent, paramTAVResource);
      return;
    }
    c(ObjConvector.a(paramTAVResource.getScaledDuration()));
  }
  
  private void e(SendMsgTavEvent paramSendMsgTavEvent, TAVResource paramTAVResource)
  {
    if (!"getSize".equals(paramSendMsgTavEvent.b()))
    {
      f(paramSendMsgTavEvent, paramTAVResource);
      return;
    }
    if ((paramTAVResource instanceof TAVAssetTrackResource))
    {
      c(ObjConvector.a(((TAVAssetTrackResource)paramTAVResource).getAsset().getNaturalSize()));
      return;
    }
    if ((paramTAVResource instanceof TAVImageTrackResource))
    {
      paramSendMsgTavEvent = ((TAVImageTrackResource)paramTAVResource).getPath();
      paramTAVResource = new BitmapFactory.Options();
      paramTAVResource.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramSendMsgTavEvent, paramTAVResource);
      c(ObjConvector.a(new CGSize(paramTAVResource.outWidth, paramTAVResource.outHeight)));
      return;
    }
    b("filePath");
  }
  
  private void f(SendMsgTavEvent paramSendMsgTavEvent, TAVResource paramTAVResource)
  {
    if (!"setSourceTimeRange".equals(paramSendMsgTavEvent.b()))
    {
      g(paramSendMsgTavEvent, paramTAVResource);
      return;
    }
    paramTAVResource.setSourceTimeRange(ObjConvector.a(paramSendMsgTavEvent.a().getJSONObject("sourceTimeRange")));
    a();
  }
  
  private void g(SendMsgTavEvent paramSendMsgTavEvent, TAVResource paramTAVResource)
  {
    if (!"setScaledDuration".equals(paramSendMsgTavEvent.b()))
    {
      c();
      return;
    }
    paramTAVResource.setScaledDuration(ObjConvector.a(paramSendMsgTavEvent.a().getJSONObject("scaledDuration")));
    a();
  }
  
  void a(ObjCreateTavEvent paramObjCreateTavEvent)
  {
    super.a(paramObjCreateTavEvent);
    a(paramObjCreateTavEvent, paramObjCreateTavEvent.a());
  }
  
  void a(SendMsgTavEvent paramSendMsgTavEvent)
  {
    super.a(paramSendMsgTavEvent);
    Object localObject = paramSendMsgTavEvent.a();
    if (!(localObject instanceof TAVResource))
    {
      b();
      return;
    }
    a(paramSendMsgTavEvent, (TAVResource)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.TavResourceProxy
 * JD-Core Version:    0.7.0.1
 */