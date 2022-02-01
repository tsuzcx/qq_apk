package com.tencent.qqmini.proxyimpl.tavkitplugin;

import android.util.Log;
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
import dov.com.qq.im.ae.download.AEResInfo;
import dov.com.qq.im.ae.download.AEResUtil;
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
    TAVCut.initTAVCut(this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext.getContext(), AEResUtil.b(AEResInfo.b), AEResUtil.b(AEResInfo.b), new WeishiPlugin.MyCallback(this, null));
  }
  
  private void a(RequestEvent paramRequestEvent)
  {
    if (!AEResUtil.b(AEResInfo.b))
    {
      paramRequestEvent.fail("tavkit so do not ready, please retry.");
      return;
    }
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreModelRequestEvent = paramRequestEvent;
    a();
  }
  
  private void a(RequestEvent paramRequestEvent, BaseTavEvent paramBaseTavEvent)
  {
    BaseTavApiProxy localBaseTavApiProxy = TavProxyManager.a(paramBaseTavEvent.a());
    if (localBaseTavApiProxy == null)
    {
      paramRequestEvent.fail("getProxy(classKey) is Null, classKey = " + paramBaseTavEvent);
      return;
    }
    localBaseTavApiProxy.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext);
    localBaseTavApiProxy.a(this.b);
    try
    {
      localBaseTavApiProxy.a(paramRequestEvent, paramBaseTavEvent);
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
    Log.v("WS_WeishiPlugin", "releaseObj() called with: req = [" + paramRequestEvent + "], dataObj = [" + paramJSONObject + "]");
    if (!paramJSONObject.has("param"))
    {
      paramRequestEvent.fail("no param");
      return;
    }
    paramJSONObject = paramJSONObject.getJSONObject("param");
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
    if ("tav_createObject".equals(paramRequestEvent.event)) {}
    for (localObject = new ObjCreateTavEvent((JSONObject)localObject);; localObject = new SendMsgTavEvent((JSONObject)localObject))
    {
      a(paramRequestEvent, (BaseTavEvent)localObject);
      return;
      if (!"tav_sendMsgToObject".equals(paramRequestEvent.event)) {
        break;
      }
    }
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
    Logger.d("WS_WeishiPlugin", "dispatchEvent() called with: req = [" + paramRequestEvent.jsonParams + "]");
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
    paramIMiniAppContext = MiniAppFileManager.getMiniAppFileManager(paramIMiniAppContext.getMiniAppInfo().apkgInfo);
    this.b = paramIMiniAppContext;
    jdField_a_of_type_ComTencentQqminiSdkCoreManagerMiniAppFileManager = paramIMiniAppContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.WeishiPlugin
 * JD-Core Version:    0.7.0.1
 */