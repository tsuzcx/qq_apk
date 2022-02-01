package com.tencent.qqmini.proxyimpl.tavkitplugin;

import android.util.Log;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qcircle.tavcut.TAVCut;
import com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.BaseTavApiProxy;
import com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.TavProxyManager;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppFileManager;
import com.tencent.tav.decoder.logger.Logger;
import org.json.JSONObject;

@JsPlugin(secondary=true)
public class WeishiPlugin
  extends BaseJsPlugin
{
  public static IMiniAppFileManager a;
  private IMiniAppContext b;
  private boolean c;
  private RequestEvent d;
  private IMiniAppFileManager e;
  
  static {}
  
  private String a()
  {
    return null;
  }
  
  private void a(RequestEvent paramRequestEvent)
  {
    String str = a();
    if (str == null)
    {
      paramRequestEvent.ok();
      return;
    }
    paramRequestEvent.fail(str);
  }
  
  private void a(RequestEvent paramRequestEvent, BaseTavEvent paramBaseTavEvent)
  {
    Object localObject = TavProxyManager.a(paramBaseTavEvent.a());
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getProxy(classKey) is Null, classKey = ");
      ((StringBuilder)localObject).append(paramBaseTavEvent);
      paramRequestEvent.fail(((StringBuilder)localObject).toString());
      return;
    }
    ((BaseTavApiProxy)localObject).a(this.b);
    ((BaseTavApiProxy)localObject).a(this.e);
    try
    {
      ((BaseTavApiProxy)localObject).a(paramRequestEvent, paramBaseTavEvent);
      return;
    }
    catch (Exception paramBaseTavEvent)
    {
      Log.e("WS_WeishiPlugin", "dispatchProxy: ", paramBaseTavEvent);
      paramRequestEvent.fail();
    }
  }
  
  private void a(RequestEvent paramRequestEvent, JSONObject paramJSONObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("releaseObj() called with: req = [");
    localStringBuilder.append(paramRequestEvent);
    localStringBuilder.append("], dataObj = [");
    localStringBuilder.append(paramJSONObject);
    localStringBuilder.append("]");
    Log.v("WS_WeishiPlugin", localStringBuilder.toString());
    if (!paramJSONObject.has("tavobject"))
    {
      paramRequestEvent.fail("no tavobject");
      return;
    }
    paramJSONObject = paramJSONObject.getJSONObject("tavobject");
    if (!paramJSONObject.has("identifier"))
    {
      paramRequestEvent.fail("no identifier");
      return;
    }
    paramJSONObject = paramJSONObject.getString("identifier");
    TavObjPool.a().b(paramJSONObject);
    paramRequestEvent.ok();
  }
  
  private void b()
  {
    Logger.d("WS_WeishiPlugin", "initSo() called");
    TAVCut.initTAVCut(this.b.getContext(), ((IAEResUtil)QRoute.api(IAEResUtil.class)).getUnzipAEResPath(AEResInfo.AE_RES_BASE_PACKAGE), ((IAEResUtil)QRoute.api(IAEResUtil.class)).getUnzipAEResPath(AEResInfo.LIGHT_RES_BASE_PACKAGE), new WeishiPlugin.MyCallback(this, null));
  }
  
  private void b(RequestEvent paramRequestEvent)
  {
    this.d = paramRequestEvent;
    b();
  }
  
  private void c(RequestEvent paramRequestEvent)
  {
    Object localObject = new JSONObject(paramRequestEvent.jsonParams).getJSONObject("data");
    if ("tav_createObject".equals(paramRequestEvent.event))
    {
      localObject = new ObjCreateTavEvent((JSONObject)localObject);
    }
    else
    {
      if (!"tav_sendMsgToObject".equals(paramRequestEvent.event)) {
        break label69;
      }
      localObject = new SendMsgTavEvent((JSONObject)localObject);
    }
    a(paramRequestEvent, (BaseTavEvent)localObject);
    return;
    label69:
    if ("tav_releaseObject".equals(paramRequestEvent.event))
    {
      a(paramRequestEvent, (JSONObject)localObject);
      return;
    }
    paramRequestEvent.fail("没有覆盖的事件");
  }
  
  @JsEvent({"tav_createObject", "tav_sendMsgToObject", "tav_releaseObject", "tav_checkInit"})
  public void dispatchEvent(RequestEvent paramRequestEvent)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("dispatchEvent() called with: req = [");
    localStringBuilder.append(paramRequestEvent.jsonParams);
    localStringBuilder.append("]");
    Logger.d("WS_WeishiPlugin", localStringBuilder.toString());
    if ("tav_checkInit".equals(paramRequestEvent.event))
    {
      a(paramRequestEvent);
      return;
    }
    if (!this.c)
    {
      b(paramRequestEvent);
      return;
    }
    try
    {
      c(paramRequestEvent);
      return;
    }
    catch (Exception paramRequestEvent)
    {
      Log.e("WS_WeishiPlugin", "sendMsgToObject: ", paramRequestEvent);
    }
  }
  
  public void onCreate(IMiniAppContext paramIMiniAppContext)
  {
    super.onCreate(paramIMiniAppContext);
    this.b = paramIMiniAppContext;
    ((IAEResUtil)QRoute.api(IAEResUtil.class)).peakRequestAEBaseRes();
    paramIMiniAppContext = (IMiniAppFileManager)paramIMiniAppContext.getManager(IMiniAppFileManager.class);
    this.e = paramIMiniAppContext;
    a = paramIMiniAppContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.WeishiPlugin
 * JD-Core Version:    0.7.0.1
 */