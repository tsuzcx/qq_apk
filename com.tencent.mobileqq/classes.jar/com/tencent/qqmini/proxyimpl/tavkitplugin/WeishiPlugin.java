package com.tencent.qqmini.proxyimpl.tavkitplugin;

import android.util.Log;
import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.BaseTavApiProxy;
import com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.TavProxyManager;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tavcut.TAVCut;
import org.json.JSONObject;

@JsPlugin(secondary=true)
public class WeishiPlugin
  extends BaseJsPlugin
{
  public static MiniAppFileManager a;
  private IMiniAppContext jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext;
  private RequestEvent jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent;
  private boolean jdField_a_of_type_Boolean;
  private MiniAppFileManager b;
  
  static {}
  
  private void a()
  {
    Logger.d("WS_WeishiPlugin", "initSo() called");
    TAVCut.initTAVCut(this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext.getContext(), ((IAEResUtil)QRoute.api(IAEResUtil.class)).getUnzipAEResPath(AEResInfo.AE_RES_BASE_PACKAGE), ((IAEResUtil)QRoute.api(IAEResUtil.class)).getUnzipAEResPath(AEResInfo.LIGHT_RES_BASE_PACKAGE), new WeishiPlugin.MyCallback(this, null));
  }
  
  private void a(RequestEvent paramRequestEvent)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent = paramRequestEvent;
    a();
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
    ((BaseTavApiProxy)localObject).a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext);
    ((BaseTavApiProxy)localObject).a(this.b);
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
    TavObjPool.a().a(paramJSONObject);
    paramRequestEvent.ok();
  }
  
  private void b(RequestEvent paramRequestEvent)
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
  
  @JsEvent({"tav_createObject", "tav_sendMsgToObject", "tav_releaseObject"})
  public void dispatchEvent(RequestEvent paramRequestEvent)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("dispatchEvent() called with: req = [");
    localStringBuilder.append(paramRequestEvent.jsonParams);
    localStringBuilder.append("]");
    Logger.d("WS_WeishiPlugin", localStringBuilder.toString());
    if (!this.jdField_a_of_type_Boolean)
    {
      a(paramRequestEvent);
      return;
    }
    try
    {
      b(paramRequestEvent);
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
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext = paramIMiniAppContext;
    ((IAEResUtil)QRoute.api(IAEResUtil.class)).peakRequestAEBaseRes();
    paramIMiniAppContext = MiniAppFileManager.getMiniAppFileManager(paramIMiniAppContext.getMiniAppInfo().apkgInfo);
    this.b = paramIMiniAppContext;
    jdField_a_of_type_ComTencentQqminiSdkCoreManagerMiniAppFileManager = paramIMiniAppContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.WeishiPlugin
 * JD-Core Version:    0.7.0.1
 */